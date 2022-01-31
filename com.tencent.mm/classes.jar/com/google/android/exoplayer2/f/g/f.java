package com.google.android.exoplayer2.f.g;

import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class f
{
  public static final Pattern aXl;
  private static final Pattern aXm;
  private final StringBuilder aWj;
  
  static
  {
    AppMethodBeat.i(95739);
    aXl = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    aXm = Pattern.compile("(\\S+?):(\\S+)");
    AppMethodBeat.o(95739);
  }
  
  public f()
  {
    AppMethodBeat.i(95731);
    this.aWj = new StringBuilder();
    AppMethodBeat.o(95731);
  }
  
  static void a(String paramString, e.a parama)
  {
    AppMethodBeat.i(95733);
    Matcher localMatcher = aXm.matcher(paramString);
    String str;
    int i;
    for (;;)
    {
      if (localMatcher.find())
      {
        str = localMatcher.group(1);
        paramString = localMatcher.group(2);
        for (;;)
        {
          try
          {
            if (!"line".equals(str)) {
              break label165;
            }
            i = paramString.indexOf(',');
            if (i == -1) {
              break label127;
            }
            parama.aTE = av(paramString.substring(i + 1));
            paramString = paramString.substring(0, i);
            if (!paramString.endsWith("%")) {
              break label136;
            }
            parama.aTD = h.ax(paramString);
            parama.lineType = 0;
          }
          catch (NumberFormatException paramString)
          {
            new StringBuilder("Skipping bad cue setting: ").append(localMatcher.group());
          }
          break;
          label127:
          parama.aTE = -2147483648;
        }
        label136:
        int j = Integer.parseInt(paramString);
        i = j;
        if (j < 0) {
          i = j - 1;
        }
        parama.aTD = i;
        parama.lineType = 1;
        continue;
        label165:
        if ("align".equals(str)) {
          switch (paramString.hashCode())
          {
          }
        }
      }
    }
    for (;;)
    {
      parama.aTC = paramString;
      break;
      if (paramString.equals("start"))
      {
        i = 0;
        break label468;
        if (paramString.equals("left"))
        {
          i = 1;
          break label468;
          if (paramString.equals("center"))
          {
            i = 2;
            break label468;
            if (paramString.equals("middle"))
            {
              i = 3;
              break label468;
              if (paramString.equals("end"))
              {
                i = 4;
                break label468;
                if (paramString.equals("right"))
                {
                  i = 5;
                  break label468;
                  paramString = Layout.Alignment.ALIGN_NORMAL;
                  continue;
                  paramString = Layout.Alignment.ALIGN_CENTER;
                  continue;
                  paramString = Layout.Alignment.ALIGN_OPPOSITE;
                  continue;
                  if ("position".equals(str))
                  {
                    i = paramString.indexOf(',');
                    if (i != -1)
                    {
                      parama.aTG = av(paramString.substring(i + 1));
                      paramString = paramString.substring(0, i);
                    }
                    for (;;)
                    {
                      parama.aTF = h.ax(paramString);
                      break;
                      parama.aTG = -2147483648;
                    }
                  }
                  if ("size".equals(str))
                  {
                    parama.width = h.ax(paramString);
                    break;
                  }
                  new StringBuilder("Unknown cue setting ").append(str).append(":").append(paramString);
                  break;
                  AppMethodBeat.o(95733);
                  return;
                }
              }
            }
          }
        }
      }
      i = -1;
      label468:
      switch (i)
      {
      }
      paramString = null;
    }
  }
  
  private static void a(String paramString, f.a parama, SpannableStringBuilder paramSpannableStringBuilder, List<d> paramList, List<f.b> paramList1)
  {
    AppMethodBeat.i(95737);
    int k = parama.position;
    int m = paramSpannableStringBuilder.length();
    String str = parama.name;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(95737);
        return;
        if (str.equals("b"))
        {
          i = 0;
          continue;
          if (str.equals("i"))
          {
            i = 1;
            continue;
            if (str.equals("u"))
            {
              i = 2;
              continue;
              if (str.equals("c"))
              {
                i = 3;
                continue;
                if (str.equals("lang"))
                {
                  i = 4;
                  continue;
                  if (str.equals("v"))
                  {
                    i = 5;
                    continue;
                    if (str.equals("")) {
                      i = 6;
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    paramSpannableStringBuilder.setSpan(new StyleSpan(1), k, m, 33);
    paramList1.clear();
    a(paramList, paramString, parama, paramList1);
    int n = paramList1.size();
    i = 0;
    if (i < n)
    {
      paramString = ((f.b)paramList1.get(i)).aXq;
      if (paramString != null)
      {
        if (paramString.getStyle() != -1) {
          paramSpannableStringBuilder.setSpan(new StyleSpan(paramString.getStyle()), k, m, 33);
        }
        if (paramString.aWD == 1)
        {
          j = 1;
          label371:
          if (j != 0) {
            paramSpannableStringBuilder.setSpan(new StrikethroughSpan(), k, m, 33);
          }
          if (paramString.aWE != 1) {
            break label505;
          }
        }
        label505:
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            paramSpannableStringBuilder.setSpan(new UnderlineSpan(), k, m, 33);
          }
          if (!paramString.aWB) {
            break label532;
          }
          if (paramString.aWB) {
            break label511;
          }
          paramString = new IllegalStateException("Font color not defined");
          AppMethodBeat.o(95737);
          throw paramString;
          paramSpannableStringBuilder.setSpan(new StyleSpan(2), k, m, 33);
          break;
          paramSpannableStringBuilder.setSpan(new UnderlineSpan(), k, m, 33);
          break;
          j = 0;
          break label371;
        }
        label511:
        paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramString.aWA), k, m, 33);
        label532:
        if (paramString.aWC)
        {
          if (!paramString.aWC)
          {
            paramString = new IllegalStateException("Background color not defined.");
            AppMethodBeat.o(95737);
            throw paramString;
          }
          paramSpannableStringBuilder.setSpan(new BackgroundColorSpan(paramString.backgroundColor), k, m, 33);
        }
        if (paramString.aWz != null) {
          paramSpannableStringBuilder.setSpan(new TypefaceSpan(paramString.aWz), k, m, 33);
        }
        if (paramString.aWJ != null) {
          paramSpannableStringBuilder.setSpan(new AlignmentSpan.Standard(paramString.aWJ), k, m, 33);
        }
        switch (paramString.aWH)
        {
        }
      }
      for (;;)
      {
        i += 1;
        break;
        paramSpannableStringBuilder.setSpan(new AbsoluteSizeSpan((int)paramString.fontSize, true), k, m, 33);
        continue;
        paramSpannableStringBuilder.setSpan(new RelativeSizeSpan(paramString.fontSize), k, m, 33);
        continue;
        paramSpannableStringBuilder.setSpan(new RelativeSizeSpan(paramString.fontSize / 100.0F), k, m, 33);
      }
    }
    AppMethodBeat.o(95737);
  }
  
  static void a(String paramString1, String paramString2, e.a parama, List<d> paramList)
  {
    AppMethodBeat.i(95734);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Stack localStack = new Stack();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      label133:
      int j;
      if (i < paramString2.length())
      {
        char c = paramString2.charAt(i);
        int k;
        label157:
        int m;
        label173:
        label181:
        label192:
        String str;
        switch (c)
        {
        default: 
          localSpannableStringBuilder.append(c);
          i += 1;
          break;
        case '<': 
          if (i + 1 >= paramString2.length())
          {
            i += 1;
            continue;
          }
          int n;
          int i1;
          Object localObject;
          if (paramString2.charAt(i + 1) == '/')
          {
            k = 1;
            j = paramString2.indexOf('>', i + 1);
            if (j != -1) {
              break label404;
            }
            j = paramString2.length();
            if (paramString2.charAt(j - 2) != '/') {
              break label413;
            }
            m = 1;
            if (k == 0) {
              break label419;
            }
            n = 2;
            if (m == 0) {
              break label425;
            }
            i1 = j - 2;
            localObject = paramString2.substring(n + i, i1);
            str = ((String)localObject).trim();
            if (!str.isEmpty()) {
              break label434;
            }
            str = null;
            if (str == null) {
              break label963;
            }
            i = -1;
            switch (str.hashCode())
            {
            default: 
              switch (i)
              {
              }
              break;
            }
          }
          for (i = 0;; i = 1)
          {
            if (i == 0) {
              break label963;
            }
            if (k == 0) {
              break label551;
            }
            do
            {
              if (localStack.isEmpty()) {
                break;
              }
              localObject = (f.a)localStack.pop();
              a(paramString1, (f.a)localObject, localSpannableStringBuilder, paramList, localArrayList);
            } while (!((f.a)localObject).name.equals(str));
            i = j;
            break;
            k = 0;
            break label133;
            j += 1;
            break label157;
            m = 0;
            break label173;
            n = 1;
            break label181;
            i1 = j - 1;
            break label192;
            str = str.split("[ \\.]")[0];
            break label223;
            if (!str.equals("b")) {
              break label296;
            }
            i = 0;
            break label296;
            if (!str.equals("c")) {
              break label296;
            }
            i = 1;
            break label296;
            if (!str.equals("i")) {
              break label296;
            }
            i = 2;
            break label296;
            if (!str.equals("lang")) {
              break label296;
            }
            i = 3;
            break label296;
            if (!str.equals("u")) {
              break label296;
            }
            i = 4;
            break label296;
            if (!str.equals("v")) {
              break label296;
            }
            i = 5;
            break label296;
          }
          if (m != 0) {
            break label963;
          }
          localStack.push(f.a.j((String)localObject, localSpannableStringBuilder.length()));
          i = j;
          break;
        case '&': 
          label223:
          m = paramString2.indexOf(';', i + 1);
          label296:
          label425:
          label434:
          k = paramString2.indexOf(' ', i + 1);
          label404:
          label413:
          label419:
          label551:
          if (m == -1)
          {
            j = k;
            label613:
            if (j == -1) {
              break label893;
            }
            str = paramString2.substring(i + 1, j);
            i = -1;
            switch (str.hashCode())
            {
            default: 
              switch (i)
              {
              default: 
                label680:
                new StringBuilder("ignoring unsupported entity: '&").append(str).append(";'");
              }
              break;
            }
          }
          for (;;)
          {
            if (j == k) {
              localSpannableStringBuilder.append(" ");
            }
            i = j + 1;
            break;
            j = m;
            if (k == -1) {
              break label613;
            }
            j = Math.min(m, k);
            break label613;
            if (!str.equals("lt")) {
              break label680;
            }
            i = 0;
            break label680;
            if (!str.equals("gt")) {
              break label680;
            }
            i = 1;
            break label680;
            if (!str.equals("nbsp")) {
              break label680;
            }
            i = 2;
            break label680;
            if (!str.equals("amp")) {
              break label680;
            }
            i = 3;
            break label680;
            localSpannableStringBuilder.append('<');
            continue;
            localSpannableStringBuilder.append('>');
            continue;
            localSpannableStringBuilder.append(' ');
            continue;
            localSpannableStringBuilder.append('&');
          }
          label893:
          localSpannableStringBuilder.append(c);
          i += 1;
          break;
        }
      }
      else
      {
        while (!localStack.isEmpty()) {
          a(paramString1, (f.a)localStack.pop(), localSpannableStringBuilder, paramList, localArrayList);
        }
        a(paramString1, f.a.qf(), localSpannableStringBuilder, paramList, localArrayList);
        parama.aXk = localSpannableStringBuilder;
        AppMethodBeat.o(95734);
        return;
        label963:
        i = j;
      }
    }
  }
  
  private static void a(List<d> paramList, String paramString, f.a parama, List<f.b> paramList1)
  {
    AppMethodBeat.i(95738);
    int k = paramList.size();
    int j = 0;
    if (j < k)
    {
      d locald = (d)paramList.get(j);
      String str1 = parama.name;
      String[] arrayOfString = parama.aXp;
      String str2 = parama.aXo;
      int i;
      if ((locald.aXf.isEmpty()) && (locald.aXg.isEmpty()) && (locald.aXh.isEmpty()) && (locald.aXi.isEmpty())) {
        if (str1.isEmpty()) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i > 0) {
          paramList1.add(new f.b(i, locald));
        }
        j += 1;
        break;
        i = 0;
        continue;
        i = d.a(d.a(d.a(0, locald.aXf, paramString, 1073741824), locald.aXg, str1, 2), locald.aXi, str2, 4);
        if ((i == -1) || (!Arrays.asList(arrayOfString).containsAll(locald.aXh))) {
          i = 0;
        } else {
          i += locald.aXh.size() * 4;
        }
      }
    }
    Collections.sort(paramList1);
    AppMethodBeat.o(95738);
  }
  
  private static boolean a(String paramString, Matcher paramMatcher, m paramm, e.a parama, StringBuilder paramStringBuilder, List<d> paramList)
  {
    AppMethodBeat.i(95735);
    try
    {
      parama.startTime = h.aw(paramMatcher.group(1));
      parama.endTime = h.aw(paramMatcher.group(2));
      a(paramMatcher.group(3), parama);
      paramStringBuilder.setLength(0);
      for (;;)
      {
        paramMatcher = paramm.readLine();
        if (TextUtils.isEmpty(paramMatcher)) {
          break;
        }
        if (paramStringBuilder.length() > 0) {
          paramStringBuilder.append("\n");
        }
        paramStringBuilder.append(paramMatcher.trim());
      }
      a(paramString, paramStringBuilder.toString(), parama, paramList);
    }
    catch (NumberFormatException paramString)
    {
      new StringBuilder("Skipping cue with bad header: ").append(paramMatcher.group());
      AppMethodBeat.o(95735);
      return false;
    }
    AppMethodBeat.o(95735);
    return true;
  }
  
  private static int av(String paramString)
  {
    AppMethodBeat.i(95736);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(95736);
        return -2147483648;
        if (paramString.equals("start"))
        {
          i = 0;
          continue;
          if (paramString.equals("center"))
          {
            i = 1;
            continue;
            if (paramString.equals("middle"))
            {
              i = 2;
              continue;
              if (paramString.equals("end")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    AppMethodBeat.o(95736);
    return 0;
    AppMethodBeat.o(95736);
    return 1;
    AppMethodBeat.o(95736);
    return 2;
  }
  
  final boolean a(m paramm, e.a parama, List<d> paramList)
  {
    AppMethodBeat.i(95732);
    String str = paramm.readLine();
    if (str == null)
    {
      AppMethodBeat.o(95732);
      return false;
    }
    Object localObject = aXl.matcher(str);
    boolean bool;
    if (((Matcher)localObject).matches())
    {
      bool = a(null, (Matcher)localObject, paramm, parama, this.aWj, paramList);
      AppMethodBeat.o(95732);
      return bool;
    }
    localObject = paramm.readLine();
    if (localObject == null)
    {
      AppMethodBeat.o(95732);
      return false;
    }
    localObject = aXl.matcher((CharSequence)localObject);
    if (((Matcher)localObject).matches())
    {
      bool = a(str.trim(), (Matcher)localObject, paramm, parama, this.aWj, paramList);
      AppMethodBeat.o(95732);
      return bool;
    }
    AppMethodBeat.o(95732);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.f
 * JD-Core Version:    0.7.0.1
 */