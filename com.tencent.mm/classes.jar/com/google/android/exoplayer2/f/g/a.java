package com.google.android.exoplayer2.f.g;

import android.text.TextUtils;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class a
{
  private static final Pattern aWY;
  private final m aWZ;
  private final StringBuilder aXa;
  
  static
  {
    AppMethodBeat.i(95715);
    aWY = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    AppMethodBeat.o(95715);
  }
  
  public a()
  {
    AppMethodBeat.i(95708);
    this.aWZ = new m();
    this.aXa = new StringBuilder();
    AppMethodBeat.o(95708);
  }
  
  private static void D(m paramm)
  {
    AppMethodBeat.i(95710);
    int i = 1;
    while ((paramm.qM() > 0) && (i != 0)) {
      if ((E(paramm)) || (F(paramm))) {
        i = 1;
      } else {
        i = 0;
      }
    }
    AppMethodBeat.o(95710);
  }
  
  private static boolean E(m paramm)
  {
    AppMethodBeat.i(95712);
    int i = paramm.position;
    switch ((char)paramm.data[i])
    {
    default: 
      AppMethodBeat.o(95712);
      return false;
    }
    paramm.en(1);
    AppMethodBeat.o(95712);
    return true;
  }
  
  private static boolean F(m paramm)
  {
    AppMethodBeat.i(95713);
    int i = paramm.position;
    int j = paramm.limit;
    byte[] arrayOfByte = paramm.data;
    int k;
    if (i + 2 <= j)
    {
      k = i + 1;
      if (arrayOfByte[i] == 47)
      {
        i = k + 1;
        if (arrayOfByte[k] != 42) {}
      }
    }
    for (;;)
    {
      if (i + 1 < j)
      {
        k = i + 1;
        if (((char)arrayOfByte[i] == '*') && ((char)arrayOfByte[k] == '/'))
        {
          i = k + 1;
          j = i;
        }
      }
      else
      {
        paramm.en(j - paramm.position);
        AppMethodBeat.o(95713);
        return true;
        AppMethodBeat.o(95713);
        return false;
      }
      i = k;
    }
  }
  
  private static String a(m paramm, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(95711);
    D(paramm);
    if (paramm.qM() == 0)
    {
      AppMethodBeat.o(95711);
      return null;
    }
    paramStringBuilder = b(paramm, paramStringBuilder);
    if (!"".equals(paramStringBuilder))
    {
      AppMethodBeat.o(95711);
      return paramStringBuilder;
    }
    paramm = (char)paramm.readUnsignedByte();
    AppMethodBeat.o(95711);
    return paramm;
  }
  
  private static String b(m paramm, StringBuilder paramStringBuilder)
  {
    int j = 0;
    AppMethodBeat.i(95714);
    paramStringBuilder.setLength(0);
    int i = paramm.position;
    int k = paramm.limit;
    while ((i < k) && (j == 0))
    {
      char c = (char)paramm.data[i];
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
    paramm.en(i - paramm.position);
    paramm = paramStringBuilder.toString();
    AppMethodBeat.o(95714);
    return paramm;
  }
  
  public final d C(m paramm)
  {
    AppMethodBeat.i(95709);
    this.aXa.setLength(0);
    int i = paramm.position;
    while (!TextUtils.isEmpty(paramm.readLine())) {}
    this.aWZ.l(paramm.data, paramm.position);
    this.aWZ.setPosition(i);
    Object localObject1 = this.aWZ;
    Object localObject2 = this.aXa;
    D((m)localObject1);
    if (((m)localObject1).qM() < 5) {
      paramm = null;
    }
    int k;
    while ((paramm == null) || (!"{".equals(a(this.aWZ, this.aXa))))
    {
      AppMethodBeat.o(95709);
      return null;
      if (!"::cue".equals(((m)localObject1).readString(5)))
      {
        paramm = null;
      }
      else
      {
        i = ((m)localObject1).position;
        localObject3 = a((m)localObject1, (StringBuilder)localObject2);
        if (localObject3 == null)
        {
          paramm = null;
        }
        else if ("{".equals(localObject3))
        {
          ((m)localObject1).setPosition(i);
          paramm = "";
        }
        else
        {
          paramm = null;
          if ("(".equals(localObject3))
          {
            j = ((m)localObject1).position;
            k = ((m)localObject1).limit;
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
            paramm = ((m)localObject1).readString(j - 1 - ((m)localObject1).position).trim();
          }
          localObject1 = a((m)localObject1, (StringBuilder)localObject2);
          if ((!")".equals(localObject1)) || (localObject1 == null)) {
            paramm = null;
          }
        }
      }
    }
    Object localObject3 = new d();
    if (!"".equals(paramm))
    {
      i = paramm.indexOf('[');
      localObject1 = paramm;
      if (i != -1)
      {
        localObject1 = aWY.matcher(paramm.substring(i));
        if (((Matcher)localObject1).matches()) {
          ((d)localObject3).aXi = ((Matcher)localObject1).group(1);
        }
        localObject1 = paramm.substring(0, i);
      }
      paramm = ((String)localObject1).split("\\.");
      localObject1 = paramm[0];
      i = ((String)localObject1).indexOf('#');
      if (i == -1) {
        break label710;
      }
      ((d)localObject3).aXg = ((String)localObject1).substring(0, i);
      ((d)localObject3).aXf = ((String)localObject1).substring(i + 1);
      if (paramm.length > 1) {
        ((d)localObject3).aXh = Arrays.asList((String[])Arrays.copyOfRange(paramm, 1, paramm.length));
      }
    }
    paramm = null;
    int j = 0;
    for (;;)
    {
      label438:
      if (j != 0) {
        break label963;
      }
      k = this.aWZ.position;
      localObject2 = a(this.aWZ, this.aXa);
      label481:
      m localm;
      Object localObject4;
      String str;
      if ((localObject2 == null) || ("}".equals(localObject2)))
      {
        i = 1;
        j = i;
        paramm = (m)localObject2;
        if (i != 0) {
          continue;
        }
        this.aWZ.setPosition(k);
        localm = this.aWZ;
        localObject4 = this.aXa;
        D(localm);
        str = b(localm, (StringBuilder)localObject4);
        j = i;
        paramm = (m)localObject2;
        if ("".equals(str)) {
          continue;
        }
        j = i;
        paramm = (m)localObject2;
        if (!":".equals(a(localm, (StringBuilder)localObject4))) {
          continue;
        }
        D(localm);
        paramm = new StringBuilder();
        j = 0;
        label575:
        if (j != 0) {
          break label767;
        }
        k = localm.position;
        localObject1 = a(localm, (StringBuilder)localObject4);
        if (localObject1 != null) {
          break label725;
        }
      }
      label710:
      label725:
      label767:
      for (localObject1 = null;; localObject1 = paramm.toString())
      {
        j = i;
        paramm = (m)localObject2;
        if (localObject1 == null) {
          break label438;
        }
        j = i;
        paramm = (m)localObject2;
        if ("".equals(localObject1)) {
          break label438;
        }
        k = localm.position;
        localObject4 = a(localm, (StringBuilder)localObject4);
        if (!";".equals(localObject4))
        {
          j = i;
          paramm = (m)localObject2;
          if (!"}".equals(localObject4)) {
            break label438;
          }
          localm.setPosition(k);
        }
        if (!"color".equals(str)) {
          break label776;
        }
        ((d)localObject3).aWA = e.aF((String)localObject1);
        ((d)localObject3).aWB = true;
        j = i;
        paramm = (m)localObject2;
        break label438;
        ((d)localObject3).aXg = ((String)localObject1);
        break;
        i = 0;
        break label481;
        if (("}".equals(localObject1)) || (";".equals(localObject1)))
        {
          localm.setPosition(k);
          j = 1;
          break label575;
        }
        paramm.append((String)localObject1);
        break label575;
      }
      label776:
      if ("background-color".equals(str))
      {
        ((d)localObject3).backgroundColor = e.aF((String)localObject1);
        ((d)localObject3).aWC = true;
        j = i;
        paramm = (m)localObject2;
      }
      else if ("text-decoration".equals(str))
      {
        j = i;
        paramm = (m)localObject2;
        if ("underline".equals(localObject1))
        {
          ((d)localObject3).aWE = 1;
          j = i;
          paramm = (m)localObject2;
        }
      }
      else if ("font-family".equals(str))
      {
        ((d)localObject3).aWz = x.aQ((String)localObject1);
        j = i;
        paramm = (m)localObject2;
      }
      else if ("font-weight".equals(str))
      {
        j = i;
        paramm = (m)localObject2;
        if ("bold".equals(localObject1))
        {
          ((d)localObject3).aWF = 1;
          j = i;
          paramm = (m)localObject2;
        }
      }
      else
      {
        j = i;
        paramm = (m)localObject2;
        if ("font-style".equals(str))
        {
          j = i;
          paramm = (m)localObject2;
          if ("italic".equals(localObject1))
          {
            ((d)localObject3).aWG = 1;
            j = i;
            paramm = (m)localObject2;
          }
        }
      }
    }
    label963:
    if ("}".equals(paramm))
    {
      AppMethodBeat.o(95709);
      return localObject3;
    }
    AppMethodBeat.o(95709);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.a
 * JD-Core Version:    0.7.0.1
 */