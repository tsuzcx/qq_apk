package com.google.android.exoplayer2.f.g;

import android.text.TextUtils;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class a
{
  private static final Pattern aPE = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
  private final j aPF = new j();
  private final StringBuilder aPG = new StringBuilder();
  
  private static String a(j paramj, StringBuilder paramStringBuilder)
  {
    h(paramj);
    if (paramj.oe() == 0) {
      paramStringBuilder = null;
    }
    String str;
    do
    {
      return paramStringBuilder;
      str = b(paramj, paramStringBuilder);
      paramStringBuilder = str;
    } while (!"".equals(str));
    return (char)paramj.readUnsignedByte();
  }
  
  private static String b(j paramj, StringBuilder paramStringBuilder)
  {
    int j = 0;
    paramStringBuilder.setLength(0);
    int i = paramj.position;
    int k = paramj.limit;
    while ((i < k) && (j == 0))
    {
      char c = (char)paramj.data[i];
      if (((c >= 'A') && (c <= 'Z')) || ((c >= 'a') && (c <= 'z')) || ((c >= '0') && (c <= '9')) || (c == '#') || (c == '-') || (c == '.') || (c == '_'))
      {
        i += 1;
        paramStringBuilder.append(c);
      }
      else
      {
        j = 1;
      }
    }
    paramj.dB(i - paramj.position);
    return paramStringBuilder.toString();
  }
  
  private static void h(j paramj)
  {
    int i = 1;
    label78:
    int j;
    byte[] arrayOfByte;
    int k;
    if ((paramj.oe() > 0) && (i != 0))
    {
      i = paramj.position;
      switch ((char)paramj.data[i])
      {
      default: 
        i = 0;
        if (i == 0)
        {
          i = paramj.position;
          j = paramj.limit;
          arrayOfByte = paramj.data;
          if (i + 2 > j) {
            break label202;
          }
          k = i + 1;
          if (arrayOfByte[i] != 47) {
            break label202;
          }
          i = k + 1;
          if (arrayOfByte[k] != 42) {
            break label202;
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (i + 1 < j)
      {
        k = i + 1;
        if (((char)arrayOfByte[i] != '*') || ((char)arrayOfByte[k] != '/')) {
          break label213;
        }
        i = k + 1;
        j = i;
        continue;
        paramj.dB(1);
        i = 1;
        break label78;
      }
      paramj.dB(j - paramj.position);
      label202:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label207;
        }
        i = 1;
        break;
      }
      label207:
      i = 0;
      break;
      return;
      label213:
      i = k;
    }
  }
  
  public final d g(j paramj)
  {
    this.aPG.setLength(0);
    int i = paramj.position;
    while (!TextUtils.isEmpty(paramj.readLine())) {}
    this.aPF.m(paramj.data, paramj.position);
    this.aPF.setPosition(i);
    Object localObject1 = this.aPF;
    Object localObject2 = this.aPG;
    h((j)localObject1);
    if (((j)localObject1).oe() < 5) {
      paramj = null;
    }
    label97:
    int j;
    int k;
    for (;;)
    {
      if ((paramj == null) || (!"{".equals(a(this.aPF, this.aPG))))
      {
        return null;
        if (!"::cue".equals(((j)localObject1).readString(5)))
        {
          paramj = null;
        }
        else
        {
          i = ((j)localObject1).position;
          paramj = a((j)localObject1, (StringBuilder)localObject2);
          if (paramj == null)
          {
            paramj = null;
          }
          else if ("{".equals(paramj))
          {
            ((j)localObject1).setPosition(i);
            paramj = "";
          }
          else
          {
            if (!"(".equals(paramj)) {
              break label956;
            }
            j = ((j)localObject1).position;
            k = ((j)localObject1).limit;
            i = 0;
            if ((j < k) && (i == 0))
            {
              if ((char)localObject1.data[j] == ')') {}
              for (i = 1;; i = 0)
              {
                j += 1;
                break;
              }
            }
          }
        }
      }
    }
    label422:
    label559:
    label694:
    label956:
    for (paramj = ((j)localObject1).readString(j - 1 - ((j)localObject1).position).trim();; paramj = null)
    {
      localObject1 = a((j)localObject1, (StringBuilder)localObject2);
      if ((")".equals(localObject1)) && (localObject1 != null)) {
        break;
      }
      paramj = null;
      break;
      d locald = new d();
      if (!"".equals(paramj))
      {
        i = paramj.indexOf('[');
        localObject1 = paramj;
        if (i != -1)
        {
          localObject1 = aPE.matcher(paramj.substring(i));
          if (((Matcher)localObject1).matches()) {
            locald.aPO = ((Matcher)localObject1).group(1);
          }
          localObject1 = paramj.substring(0, i);
        }
        paramj = ((String)localObject1).split("\\.");
        localObject1 = paramj[0];
        i = ((String)localObject1).indexOf('#');
        if (i == -1) {
          break label694;
        }
        locald.aPM = ((String)localObject1).substring(0, i);
        locald.aPL = ((String)localObject1).substring(i + 1);
        if (paramj.length > 1) {
          locald.aPN = Arrays.asList((String[])Arrays.copyOfRange(paramj, 1, paramj.length));
        }
      }
      j = 0;
      paramj = null;
      for (;;)
      {
        if (j != 0) {
          break label944;
        }
        k = this.aPF.position;
        localObject2 = a(this.aPF, this.aPG);
        label465:
        j localj;
        Object localObject3;
        String str;
        if ((localObject2 == null) || ("}".equals(localObject2)))
        {
          i = 1;
          j = i;
          paramj = (j)localObject2;
          if (i != 0) {
            continue;
          }
          this.aPF.setPosition(k);
          localj = this.aPF;
          localObject3 = this.aPG;
          h(localj);
          str = b(localj, (StringBuilder)localObject3);
          j = i;
          paramj = (j)localObject2;
          if ("".equals(str)) {
            continue;
          }
          j = i;
          paramj = (j)localObject2;
          if (!":".equals(a(localj, (StringBuilder)localObject3))) {
            continue;
          }
          h(localj);
          paramj = new StringBuilder();
          j = 0;
          if (j != 0) {
            break label751;
          }
          k = localj.position;
          localObject1 = a(localj, (StringBuilder)localObject3);
          if (localObject1 != null) {
            break label709;
          }
        }
        label709:
        label751:
        for (localObject1 = null;; localObject1 = paramj.toString())
        {
          j = i;
          paramj = (j)localObject2;
          if (localObject1 == null) {
            break label422;
          }
          j = i;
          paramj = (j)localObject2;
          if ("".equals(localObject1)) {
            break label422;
          }
          k = localj.position;
          localObject3 = a(localj, (StringBuilder)localObject3);
          if (!";".equals(localObject3))
          {
            j = i;
            paramj = (j)localObject2;
            if (!"}".equals(localObject3)) {
              break label422;
            }
            localj.setPosition(k);
          }
          if (!"color".equals(str)) {
            break label760;
          }
          locald.aPh = com.google.android.exoplayer2.i.d.au((String)localObject1);
          locald.aPi = true;
          j = i;
          paramj = (j)localObject2;
          break label422;
          locald.aPM = ((String)localObject1);
          break;
          i = 0;
          break label465;
          if (("}".equals(localObject1)) || (";".equals(localObject1)))
          {
            localj.setPosition(k);
            j = 1;
            break label559;
          }
          paramj.append((String)localObject1);
          break label559;
        }
        label760:
        if ("background-color".equals(str))
        {
          locald.backgroundColor = com.google.android.exoplayer2.i.d.au((String)localObject1);
          locald.aPj = true;
          j = i;
          paramj = (j)localObject2;
        }
        else if ("text-decoration".equals(str))
        {
          j = i;
          paramj = (j)localObject2;
          if ("underline".equals(localObject1))
          {
            locald.aPl = 1;
            j = i;
            paramj = (j)localObject2;
          }
        }
        else if ("font-family".equals(str))
        {
          locald.aPg = t.aE((String)localObject1);
          j = i;
          paramj = (j)localObject2;
        }
        else if ("font-weight".equals(str))
        {
          j = i;
          paramj = (j)localObject2;
          if ("bold".equals(localObject1))
          {
            locald.aPm = 1;
            j = i;
            paramj = (j)localObject2;
          }
        }
        else
        {
          j = i;
          paramj = (j)localObject2;
          if ("font-style".equals(str))
          {
            j = i;
            paramj = (j)localObject2;
            if ("italic".equals(localObject1))
            {
              locald.italic = 1;
              j = i;
              paramj = (j)localObject2;
            }
          }
        }
      }
      if (!"}".equals(paramj)) {
        break label97;
      }
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.a
 * JD-Core Version:    0.7.0.1
 */