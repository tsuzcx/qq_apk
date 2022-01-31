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
import com.google.android.exoplayer2.i.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class f
{
  public static final Pattern aPR = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
  private static final Pattern aPS = Pattern.compile("(\\S+?):(\\S+)");
  private final StringBuilder aOP = new StringBuilder();
  
  static void a(String paramString, e.a parama)
  {
    Matcher localMatcher = aPS.matcher(paramString);
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
              break label160;
            }
            i = paramString.indexOf(',');
            if (i == -1) {
              break label122;
            }
            parama.aMk = aq(paramString.substring(i + 1));
            paramString = paramString.substring(0, i);
            if (!paramString.endsWith("%")) {
              break label131;
            }
            parama.aMj = h.as(paramString);
            parama.lineType = 0;
          }
          catch (NumberFormatException paramString)
          {
            new StringBuilder("Skipping bad cue setting: ").append(localMatcher.group());
          }
          break;
          label122:
          parama.aMk = -2147483648;
        }
        label131:
        int j = Integer.parseInt(paramString);
        i = j;
        if (j < 0) {
          i = j - 1;
        }
        parama.aMj = i;
        parama.lineType = 1;
        continue;
        label160:
        if ("align".equals(str)) {
          switch (paramString.hashCode())
          {
          }
        }
      }
    }
    for (;;)
    {
      parama.aMi = paramString;
      break;
      if (paramString.equals("start"))
      {
        i = 0;
        break label459;
        if (paramString.equals("left"))
        {
          i = 1;
          break label459;
          if (paramString.equals("center"))
          {
            i = 2;
            break label459;
            if (paramString.equals("middle"))
            {
              i = 3;
              break label459;
              if (paramString.equals("end"))
              {
                i = 4;
                break label459;
                if (paramString.equals("right"))
                {
                  i = 5;
                  break label459;
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
                      parama.aMm = aq(paramString.substring(i + 1));
                      paramString = paramString.substring(0, i);
                    }
                    for (;;)
                    {
                      parama.aMl = h.as(paramString);
                      break;
                      parama.aMm = -2147483648;
                    }
                  }
                  if ("size".equals(str))
                  {
                    parama.width = h.as(paramString);
                    break;
                  }
                  new StringBuilder("Unknown cue setting ").append(str).append(":").append(paramString);
                  break;
                  return;
                }
              }
            }
          }
        }
      }
      i = -1;
      label459:
      switch (i)
      {
      }
      paramString = null;
    }
  }
  
  private static void a(String paramString, f.a parama, SpannableStringBuilder paramSpannableStringBuilder, List<d> paramList, List<f.b> paramList1)
  {
    int k = parama.position;
    int m = paramSpannableStringBuilder.length();
    String str = parama.name;
    int i;
    switch (str.hashCode())
    {
    default: 
      i = -1;
      label91:
      switch (i)
      {
      }
      break;
    }
    int n;
    do
    {
      return;
      if (!str.equals("b")) {
        break;
      }
      i = 0;
      break label91;
      if (!str.equals("i")) {
        break;
      }
      i = 1;
      break label91;
      if (!str.equals("u")) {
        break;
      }
      i = 2;
      break label91;
      if (!str.equals("c")) {
        break;
      }
      i = 3;
      break label91;
      if (!str.equals("lang")) {
        break;
      }
      i = 4;
      break label91;
      if (!str.equals("v")) {
        break;
      }
      i = 5;
      break label91;
      if (!str.equals("")) {
        break;
      }
      i = 6;
      break label91;
      paramSpannableStringBuilder.setSpan(new StyleSpan(1), k, m, 33);
      paramList1.clear();
      a(paramList, paramString, parama, paramList1);
      n = paramList1.size();
      i = 0;
    } while (i >= n);
    paramString = ((f.b)paramList1.get(i)).aPW;
    if (paramString != null)
    {
      if (paramString.getStyle() != -1) {
        paramSpannableStringBuilder.setSpan(new StyleSpan(paramString.getStyle()), k, m, 33);
      }
      if (paramString.aPk == 1)
      {
        j = 1;
        label362:
        if (j != 0) {
          paramSpannableStringBuilder.setSpan(new StrikethroughSpan(), k, m, 33);
        }
        if (paramString.aPl != 1) {
          break label488;
        }
      }
      label488:
      for (int j = 1;; j = 0)
      {
        if (j != 0) {
          paramSpannableStringBuilder.setSpan(new UnderlineSpan(), k, m, 33);
        }
        if (!paramString.aPi) {
          break label515;
        }
        if (paramString.aPi) {
          break label494;
        }
        throw new IllegalStateException("Font color not defined");
        paramSpannableStringBuilder.setSpan(new StyleSpan(2), k, m, 33);
        break;
        paramSpannableStringBuilder.setSpan(new UnderlineSpan(), k, m, 33);
        break;
        j = 0;
        break label362;
      }
      label494:
      paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramString.aPh), k, m, 33);
      label515:
      if (paramString.aPj)
      {
        if (!paramString.aPj) {
          throw new IllegalStateException("Background color not defined.");
        }
        paramSpannableStringBuilder.setSpan(new BackgroundColorSpan(paramString.backgroundColor), k, m, 33);
      }
      if (paramString.aPg != null) {
        paramSpannableStringBuilder.setSpan(new TypefaceSpan(paramString.aPg), k, m, 33);
      }
      if (paramString.aPp != null) {
        paramSpannableStringBuilder.setSpan(new AlignmentSpan.Standard(paramString.aPp), k, m, 33);
      }
      switch (paramString.aPn)
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
  
  static void a(String paramString1, String paramString2, e.a parama, List<d> paramList)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Stack localStack = new Stack();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      label129:
      int j;
      if (i < paramString2.length())
      {
        char c = paramString2.charAt(i);
        int k;
        label153:
        int m;
        label169:
        label177:
        label188:
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
              break label400;
            }
            j = paramString2.length();
            if (paramString2.charAt(j - 2) != '/') {
              break label409;
            }
            m = 1;
            if (k == 0) {
              break label415;
            }
            n = 2;
            if (m == 0) {
              break label421;
            }
            i1 = j - 2;
            localObject = paramString2.substring(n + i, i1);
            str = ((String)localObject).trim();
            if (!str.isEmpty()) {
              break label430;
            }
            str = null;
            if (str == null) {
              break label953;
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
              break label953;
            }
            if (k == 0) {
              break label547;
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
            break label129;
            j += 1;
            break label153;
            m = 0;
            break label169;
            n = 1;
            break label177;
            i1 = j - 1;
            break label188;
            str = str.split("[ \\.]")[0];
            break label219;
            if (!str.equals("b")) {
              break label292;
            }
            i = 0;
            break label292;
            if (!str.equals("c")) {
              break label292;
            }
            i = 1;
            break label292;
            if (!str.equals("i")) {
              break label292;
            }
            i = 2;
            break label292;
            if (!str.equals("lang")) {
              break label292;
            }
            i = 3;
            break label292;
            if (!str.equals("u")) {
              break label292;
            }
            i = 4;
            break label292;
            if (!str.equals("v")) {
              break label292;
            }
            i = 5;
            break label292;
          }
          if (m != 0) {
            break label953;
          }
          localStack.push(f.a.k((String)localObject, localSpannableStringBuilder.length()));
          i = j;
          break;
        case '&': 
          label219:
          m = paramString2.indexOf(';', i + 1);
          label292:
          label421:
          label430:
          k = paramString2.indexOf(' ', i + 1);
          label400:
          label409:
          label415:
          label547:
          if (m == -1)
          {
            j = k;
            label609:
            if (j == -1) {
              break label889;
            }
            str = paramString2.substring(i + 1, j);
            i = -1;
            switch (str.hashCode())
            {
            default: 
              switch (i)
              {
              default: 
                label676:
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
              break label609;
            }
            j = Math.min(m, k);
            break label609;
            if (!str.equals("lt")) {
              break label676;
            }
            i = 0;
            break label676;
            if (!str.equals("gt")) {
              break label676;
            }
            i = 1;
            break label676;
            if (!str.equals("nbsp")) {
              break label676;
            }
            i = 2;
            break label676;
            if (!str.equals("amp")) {
              break label676;
            }
            i = 3;
            break label676;
            localSpannableStringBuilder.append('<');
            continue;
            localSpannableStringBuilder.append('>');
            continue;
            localSpannableStringBuilder.append(' ');
            continue;
            localSpannableStringBuilder.append('&');
          }
          label889:
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
        a(paramString1, f.a.nG(), localSpannableStringBuilder, paramList, localArrayList);
        parama.aPQ = localSpannableStringBuilder;
        return;
        label953:
        i = j;
      }
    }
  }
  
  private static void a(List<d> paramList, String paramString, f.a parama, List<f.b> paramList1)
  {
    int k = paramList.size();
    int j = 0;
    if (j < k)
    {
      d locald = (d)paramList.get(j);
      String str1 = parama.name;
      String[] arrayOfString = parama.aPV;
      String str2 = parama.aPU;
      int i;
      if ((locald.aPL.isEmpty()) && (locald.aPM.isEmpty()) && (locald.aPN.isEmpty()) && (locald.aPO.isEmpty())) {
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
        i = d.a(d.a(d.a(0, locald.aPL, paramString, 1073741824), locald.aPM, str1, 2), locald.aPO, str2, 4);
        if ((i == -1) || (!Arrays.asList(arrayOfString).containsAll(locald.aPN))) {
          i = 0;
        } else {
          i += locald.aPN.size() * 4;
        }
      }
    }
    Collections.sort(paramList1);
  }
  
  private static boolean a(String paramString, Matcher paramMatcher, j paramj, e.a parama, StringBuilder paramStringBuilder, List<d> paramList)
  {
    try
    {
      parama.startTime = h.ar(paramMatcher.group(1));
      parama.endTime = h.ar(paramMatcher.group(2));
      a(paramMatcher.group(3), parama);
      paramStringBuilder.setLength(0);
      for (;;)
      {
        paramMatcher = paramj.readLine();
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
      return false;
    }
    return true;
  }
  
  private static int aq(String paramString)
  {
    int j = 0;
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        j = -2147483648;
      case 0: 
        return j;
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
    return 1;
    return 2;
  }
  
  final boolean a(j paramj, e.a parama, List<d> paramList)
  {
    String str = paramj.readLine();
    if (str == null) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        localObject = aPR.matcher(str);
        if (((Matcher)localObject).matches()) {
          return a(null, (Matcher)localObject, paramj, parama, this.aOP, paramList);
        }
        localObject = paramj.readLine();
      } while (localObject == null);
      localObject = aPR.matcher((CharSequence)localObject);
    } while (!((Matcher)localObject).matches());
    return a(str.trim(), (Matcher)localObject, paramj, parama, this.aOP, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.f
 * JD-Core Version:    0.7.0.1
 */