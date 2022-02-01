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
  public static final Pattern btn;
  private static final Pattern bto;
  private final StringBuilder bsl;
  
  static
  {
    AppMethodBeat.i(92907);
    btn = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    bto = Pattern.compile("(\\S+?):(\\S+)");
    AppMethodBeat.o(92907);
  }
  
  public f()
  {
    AppMethodBeat.i(92899);
    this.bsl = new StringBuilder();
    AppMethodBeat.o(92899);
  }
  
  static void a(String paramString, e.a parama)
  {
    AppMethodBeat.i(92901);
    Matcher localMatcher = bto.matcher(paramString);
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
            parama.bpG = at(paramString.substring(i + 1));
            paramString = paramString.substring(0, i);
            if (!paramString.endsWith("%")) {
              break label136;
            }
            parama.bpF = h.av(paramString);
            parama.lineType = 0;
          }
          catch (NumberFormatException paramString)
          {
            new StringBuilder("Skipping bad cue setting: ").append(localMatcher.group());
          }
          break;
          label127:
          parama.bpG = -2147483648;
        }
        label136:
        int j = Integer.parseInt(paramString);
        i = j;
        if (j < 0) {
          i = j - 1;
        }
        parama.bpF = i;
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
      parama.bpE = paramString;
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
                      parama.bpI = at(paramString.substring(i + 1));
                      paramString = paramString.substring(0, i);
                    }
                    for (;;)
                    {
                      parama.bpH = h.av(paramString);
                      break;
                      parama.bpI = -2147483648;
                    }
                  }
                  if ("size".equals(str))
                  {
                    parama.width = h.av(paramString);
                    break;
                  }
                  new StringBuilder("Unknown cue setting ").append(str).append(":").append(paramString);
                  break;
                  AppMethodBeat.o(92901);
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
  
  private static void a(String paramString, a parama, SpannableStringBuilder paramSpannableStringBuilder, List<d> paramList, List<b> paramList1)
  {
    AppMethodBeat.i(92905);
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
        AppMethodBeat.o(92905);
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
      paramString = ((b)paramList1.get(i)).bts;
      if (paramString != null)
      {
        if (paramString.getStyle() != -1) {
          paramSpannableStringBuilder.setSpan(new StyleSpan(paramString.getStyle()), k, m, 33);
        }
        if (paramString.bsE == 1)
        {
          j = 1;
          label371:
          if (j != 0) {
            paramSpannableStringBuilder.setSpan(new StrikethroughSpan(), k, m, 33);
          }
          if (paramString.bsF != 1) {
            break label505;
          }
        }
        label505:
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            paramSpannableStringBuilder.setSpan(new UnderlineSpan(), k, m, 33);
          }
          if (!paramString.bsC) {
            break label532;
          }
          if (paramString.bsC) {
            break label511;
          }
          paramString = new IllegalStateException("Font color not defined");
          AppMethodBeat.o(92905);
          throw paramString;
          paramSpannableStringBuilder.setSpan(new StyleSpan(2), k, m, 33);
          break;
          paramSpannableStringBuilder.setSpan(new UnderlineSpan(), k, m, 33);
          break;
          j = 0;
          break label371;
        }
        label511:
        paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramString.bsB), k, m, 33);
        label532:
        if (paramString.bsD)
        {
          if (!paramString.bsD)
          {
            paramString = new IllegalStateException("Background color not defined.");
            AppMethodBeat.o(92905);
            throw paramString;
          }
          paramSpannableStringBuilder.setSpan(new BackgroundColorSpan(paramString.backgroundColor), k, m, 33);
        }
        if (paramString.jD != null) {
          paramSpannableStringBuilder.setSpan(new TypefaceSpan(paramString.jD), k, m, 33);
        }
        if (paramString.bsL != null) {
          paramSpannableStringBuilder.setSpan(new AlignmentSpan.Standard(paramString.bsL), k, m, 33);
        }
        switch (paramString.bsI)
        {
        }
      }
      for (;;)
      {
        i += 1;
        break;
        paramSpannableStringBuilder.setSpan(new AbsoluteSizeSpan((int)paramString.bsJ, true), k, m, 33);
        continue;
        paramSpannableStringBuilder.setSpan(new RelativeSizeSpan(paramString.bsJ), k, m, 33);
        continue;
        paramSpannableStringBuilder.setSpan(new RelativeSizeSpan(paramString.bsJ / 100.0F), k, m, 33);
      }
    }
    AppMethodBeat.o(92905);
  }
  
  static void a(String paramString1, String paramString2, e.a parama, List<d> paramList)
  {
    AppMethodBeat.i(92902);
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
              localObject = (a)localStack.pop();
              a(paramString1, (a)localObject, localSpannableStringBuilder, paramList, localArrayList);
            } while (!((a)localObject).name.equals(str));
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
          localStack.push(a.i((String)localObject, localSpannableStringBuilder.length()));
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
          a(paramString1, (a)localStack.pop(), localSpannableStringBuilder, paramList, localArrayList);
        }
        a(paramString1, a.uT(), localSpannableStringBuilder, paramList, localArrayList);
        parama.btm = localSpannableStringBuilder;
        AppMethodBeat.o(92902);
        return;
        label963:
        i = j;
      }
    }
  }
  
  private static void a(List<d> paramList, String paramString, a parama, List<b> paramList1)
  {
    AppMethodBeat.i(92906);
    int k = paramList.size();
    int j = 0;
    if (j < k)
    {
      d locald = (d)paramList.get(j);
      String str1 = parama.name;
      String[] arrayOfString = parama.btr;
      String str2 = parama.btq;
      int i;
      if ((locald.bth.isEmpty()) && (locald.bti.isEmpty()) && (locald.btj.isEmpty()) && (locald.btk.isEmpty())) {
        if (str1.isEmpty()) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i > 0) {
          paramList1.add(new b(i, locald));
        }
        j += 1;
        break;
        i = 0;
        continue;
        i = d.b(d.b(d.b(0, locald.bth, paramString, 1073741824), locald.bti, str1, 2), locald.btk, str2, 4);
        if ((i == -1) || (!Arrays.asList(arrayOfString).containsAll(locald.btj))) {
          i = 0;
        } else {
          i += locald.btj.size() * 4;
        }
      }
    }
    Collections.sort(paramList1);
    AppMethodBeat.o(92906);
  }
  
  private static boolean a(String paramString, Matcher paramMatcher, m paramm, e.a parama, StringBuilder paramStringBuilder, List<d> paramList)
  {
    AppMethodBeat.i(92903);
    try
    {
      parama.startTime = h.au(paramMatcher.group(1));
      parama.endTime = h.au(paramMatcher.group(2));
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
      AppMethodBeat.o(92903);
      return false;
    }
    AppMethodBeat.o(92903);
    return true;
  }
  
  private static int at(String paramString)
  {
    AppMethodBeat.i(92904);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(92904);
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
    AppMethodBeat.o(92904);
    return 0;
    AppMethodBeat.o(92904);
    return 1;
    AppMethodBeat.o(92904);
    return 2;
  }
  
  final boolean a(m paramm, e.a parama, List<d> paramList)
  {
    AppMethodBeat.i(92900);
    String str = paramm.readLine();
    if (str == null)
    {
      AppMethodBeat.o(92900);
      return false;
    }
    Object localObject = btn.matcher(str);
    boolean bool;
    if (((Matcher)localObject).matches())
    {
      bool = a(null, (Matcher)localObject, paramm, parama, this.bsl, paramList);
      AppMethodBeat.o(92900);
      return bool;
    }
    localObject = paramm.readLine();
    if (localObject == null)
    {
      AppMethodBeat.o(92900);
      return false;
    }
    localObject = btn.matcher((CharSequence)localObject);
    if (((Matcher)localObject).matches())
    {
      bool = a(str.trim(), (Matcher)localObject, paramm, parama, this.bsl, paramList);
      AppMethodBeat.o(92900);
      return bool;
    }
    AppMethodBeat.o(92900);
    return false;
  }
  
  static final class a
  {
    private static final String[] btp = new String[0];
    public final String btq;
    public final String[] btr;
    public final String name;
    public final int position;
    
    private a(String paramString1, int paramInt, String paramString2, String[] paramArrayOfString)
    {
      this.position = paramInt;
      this.name = paramString1;
      this.btq = paramString2;
      this.btr = paramArrayOfString;
    }
    
    public static a i(String paramString, int paramInt)
    {
      AppMethodBeat.i(92897);
      Object localObject = paramString.trim();
      if (((String)localObject).isEmpty())
      {
        AppMethodBeat.o(92897);
        return null;
      }
      int i = ((String)localObject).indexOf(" ");
      String str;
      if (i == -1)
      {
        paramString = "";
        localObject = ((String)localObject).split("\\.");
        str = localObject[0];
        if (localObject.length <= 1) {
          break label107;
        }
      }
      label107:
      for (localObject = (String[])Arrays.copyOfRange((Object[])localObject, 1, localObject.length);; localObject = btp)
      {
        paramString = new a(str, paramInt, paramString, (String[])localObject);
        AppMethodBeat.o(92897);
        return paramString;
        paramString = ((String)localObject).substring(i).trim();
        localObject = ((String)localObject).substring(0, i);
        break;
      }
    }
    
    public static a uT()
    {
      AppMethodBeat.i(92898);
      a locala = new a("", 0, "", new String[0]);
      AppMethodBeat.o(92898);
      return locala;
    }
  }
  
  static final class b
    implements Comparable<b>
  {
    public final d bts;
    public final int score;
    
    public b(int paramInt, d paramd)
    {
      this.score = paramInt;
      this.bts = paramd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.f
 * JD-Core Version:    0.7.0.1
 */