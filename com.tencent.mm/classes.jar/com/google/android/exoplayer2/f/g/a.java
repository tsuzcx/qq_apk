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
  private static final Pattern dgP;
  private final m dgQ;
  private final StringBuilder dgR;
  
  static
  {
    AppMethodBeat.i(92883);
    dgP = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    AppMethodBeat.o(92883);
  }
  
  public a()
  {
    AppMethodBeat.i(92876);
    this.dgQ = new m();
    this.dgR = new StringBuilder();
    AppMethodBeat.o(92876);
  }
  
  private static void D(m paramm)
  {
    AppMethodBeat.i(92878);
    int i = 1;
    while ((paramm.UF() > 0) && (i != 0)) {
      if ((E(paramm)) || (F(paramm))) {
        i = 1;
      } else {
        i = 0;
      }
    }
    AppMethodBeat.o(92878);
  }
  
  private static boolean E(m paramm)
  {
    AppMethodBeat.i(92880);
    int i = paramm.position;
    switch ((char)paramm.data[i])
    {
    default: 
      AppMethodBeat.o(92880);
      return false;
    }
    paramm.iH(1);
    AppMethodBeat.o(92880);
    return true;
  }
  
  private static boolean F(m paramm)
  {
    AppMethodBeat.i(92881);
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
        paramm.iH(j - paramm.position);
        AppMethodBeat.o(92881);
        return true;
        AppMethodBeat.o(92881);
        return false;
      }
      i = k;
    }
  }
  
  private static String a(m paramm, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(92879);
    D(paramm);
    if (paramm.UF() == 0)
    {
      AppMethodBeat.o(92879);
      return null;
    }
    paramStringBuilder = b(paramm, paramStringBuilder);
    if (!"".equals(paramStringBuilder))
    {
      AppMethodBeat.o(92879);
      return paramStringBuilder;
    }
    paramm = (char)paramm.readUnsignedByte();
    AppMethodBeat.o(92879);
    return paramm;
  }
  
  private static String b(m paramm, StringBuilder paramStringBuilder)
  {
    int j = 0;
    AppMethodBeat.i(92882);
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
    paramm.iH(i - paramm.position);
    paramm = paramStringBuilder.toString();
    AppMethodBeat.o(92882);
    return paramm;
  }
  
  public final d C(m paramm)
  {
    AppMethodBeat.i(92877);
    this.dgR.setLength(0);
    int i = paramm.position;
    while (!TextUtils.isEmpty(paramm.readLine())) {}
    this.dgQ.n(paramm.data, paramm.position);
    this.dgQ.setPosition(i);
    Object localObject1 = this.dgQ;
    Object localObject2 = this.dgR;
    D((m)localObject1);
    if (((m)localObject1).UF() < 5) {
      paramm = null;
    }
    int k;
    while ((paramm == null) || (!"{".equals(a(this.dgQ, this.dgR))))
    {
      AppMethodBeat.o(92877);
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
        localObject1 = dgP.matcher(paramm.substring(i));
        if (((Matcher)localObject1).matches()) {
          ((d)localObject3).dgY = ((Matcher)localObject1).group(1);
        }
        localObject1 = paramm.substring(0, i);
      }
      paramm = ((String)localObject1).split("\\.");
      localObject1 = paramm[0];
      i = ((String)localObject1).indexOf('#');
      if (i == -1) {
        break label710;
      }
      ((d)localObject3).dgW = ((String)localObject1).substring(0, i);
      ((d)localObject3).cui = ((String)localObject1).substring(i + 1);
      if (paramm.length > 1) {
        ((d)localObject3).dgX = Arrays.asList((String[])Arrays.copyOfRange(paramm, 1, paramm.length));
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
      k = this.dgQ.position;
      localObject2 = a(this.dgQ, this.dgR);
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
        this.dgQ.setPosition(k);
        localm = this.dgQ;
        localObject4 = this.dgR;
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
        ((d)localObject3).dgs = e.cZ((String)localObject1);
        ((d)localObject3).dgt = true;
        j = i;
        paramm = (m)localObject2;
        break label438;
        ((d)localObject3).dgW = ((String)localObject1);
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
        ((d)localObject3).backgroundColor = e.cZ((String)localObject1);
        ((d)localObject3).dgu = true;
        j = i;
        paramm = (m)localObject2;
      }
      else if ("text-decoration".equals(str))
      {
        j = i;
        paramm = (m)localObject2;
        if ("underline".equals(localObject1))
        {
          ((d)localObject3).dgw = 1;
          j = i;
          paramm = (m)localObject2;
        }
      }
      else if ("font-family".equals(str))
      {
        ((d)localObject3).fontFamily = x.ds((String)localObject1);
        j = i;
        paramm = (m)localObject2;
      }
      else if ("font-weight".equals(str))
      {
        j = i;
        paramm = (m)localObject2;
        if ("bold".equals(localObject1))
        {
          ((d)localObject3).dgx = 1;
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
            ((d)localObject3).italic = 1;
            j = i;
            paramm = (m)localObject2;
          }
        }
      }
    }
    label963:
    if ("}".equals(paramm))
    {
      AppMethodBeat.o(92877);
      return localObject3;
    }
    AppMethodBeat.o(92877);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.a
 * JD-Core Version:    0.7.0.1
 */