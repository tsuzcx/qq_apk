package com.tencent.mm.cs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class h
{
  public static final Character agZc;
  public static final Character agZd;
  public static final Character agZe;
  public static final Character agZf;
  public static final Character agZg;
  public static final Character agZh;
  public static final Character agZi;
  public static final Character agZj;
  public static final Character agZk;
  
  static
  {
    AppMethodBeat.i(231677);
    agZc = Character.valueOf('&');
    agZd = Character.valueOf('\'');
    agZe = Character.valueOf('!');
    agZf = Character.valueOf('=');
    agZg = Character.valueOf('>');
    agZh = Character.valueOf('<');
    agZi = Character.valueOf('?');
    agZj = Character.valueOf('"');
    agZk = Character.valueOf('/');
    AppMethodBeat.o(231677);
  }
  
  private static String EQ(String paramString)
  {
    AppMethodBeat.i(231624);
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    paramString = new h.1(paramString).iterator();
    while (paramString.hasNext())
    {
      int j = ((Integer)paramString.next()).intValue();
      switch (j)
      {
      default: 
        if (((!Character.isISOControl(j)) || (j == 9) || (j == 10) || (j == 13)) && (((j >= 32) && (j <= 55295)) || ((j >= 57344) && (j <= 65533)) || ((j >= 65536) && (j <= 1114111)))) {
          break;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label252;
        }
        localStringBuilder.append("&#x");
        localStringBuilder.append(Integer.toHexString(j));
        localStringBuilder.append(';');
        break;
        localStringBuilder.append("&amp;");
        break;
        localStringBuilder.append("&lt;");
        break;
        localStringBuilder.append("&gt;");
        break;
        localStringBuilder.append("&quot;");
        break;
        localStringBuilder.append("&apos;");
        break;
      }
      label252:
      localStringBuilder.appendCodePoint(j);
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(231624);
    return paramString;
  }
  
  private static c a(Reader paramReader, i parami)
  {
    AppMethodBeat.i(231656);
    c localc = new c();
    paramReader = new j(paramReader);
    while (paramReader.jQr())
    {
      paramReader.bFe("<");
      if (paramReader.jQr()) {
        a(paramReader, localc, null, parami);
      }
    }
    AppMethodBeat.o(231656);
    return localc;
  }
  
  private static String a(Object paramObject, String paramString, i parami)
  {
    AppMethodBeat.i(231673);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    if ((paramObject instanceof c))
    {
      localObject2 = (c)paramObject;
      if (paramString != null)
      {
        localStringBuilder.append('<');
        localStringBuilder.append(paramString);
        localObject3 = ((c)localObject2).keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          paramObject = (String)((Iterator)localObject3).next();
          if (paramObject.startsWith("__attr__"))
          {
            localObject4 = paramObject.substring(8);
            localObject1 = ((c)localObject2).opt(paramObject);
            paramObject = localObject1;
            if (localObject1 == null) {
              paramObject = "";
            }
            localStringBuilder.append(" ").append((String)localObject4).append(agZf);
            localStringBuilder.append(" \"").append(EQ(paramObject.toString())).append("\"");
          }
        }
        localStringBuilder.append('>');
      }
      localObject1 = ((c)localObject2).keySet().iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          if (!((String)localObject3).startsWith("__attr__"))
          {
            paramObject = ((c)localObject2).opt((String)localObject3);
            if (paramObject == null) {
              paramObject = "";
            }
          }
        }
      }
    }
    label664:
    label670:
    label817:
    for (;;)
    {
      int j;
      int i;
      if (((String)localObject3).equals(parami.agZq))
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          j = paramObject.agYV.size();
          i = 0;
          while (i < j)
          {
            if (i > 0) {
              localStringBuilder.append('\n');
            }
            localStringBuilder.append(EQ(paramObject.opt(i).toString()));
            i += 1;
          }
          break;
          if (!paramObject.getClass().isArray()) {
            break label817;
          }
          paramObject = new a(paramObject);
          continue;
        }
        localStringBuilder.append(EQ(paramObject.toString()));
        break;
      }
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        j = paramObject.agYV.size();
        i = 0;
        label365:
        if (i < j)
        {
          localObject4 = paramObject.opt(i);
          if (!(localObject4 instanceof a)) {
            break label454;
          }
          localStringBuilder.append('<');
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append('>');
          localStringBuilder.append(a(localObject4, null, parami));
          localStringBuilder.append("</");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append('>');
        }
        for (;;)
        {
          i += 1;
          break label365;
          break;
          label454:
          localStringBuilder.append(a(localObject4, (String)localObject3, parami));
        }
      }
      if ("".equals(paramObject))
      {
        localStringBuilder.append('<');
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append("/>");
        break;
      }
      localStringBuilder.append(a(paramObject, (String)localObject3, parami));
      break;
      if (paramString != null)
      {
        localStringBuilder.append("</");
        localStringBuilder.append(paramString);
        localStringBuilder.append('>');
      }
      paramObject = localStringBuilder.toString();
      AppMethodBeat.o(231673);
      return paramObject;
      if ((paramObject != null) && (((paramObject instanceof a)) || (paramObject.getClass().isArray())))
      {
        if (paramObject.getClass().isArray())
        {
          paramObject = new a(paramObject);
          j = paramObject.agYV.size();
          i = 0;
          label614:
          if (i >= j) {
            break label670;
          }
          localObject2 = paramObject.opt(i);
          if (paramString != null) {
            break label664;
          }
        }
        for (localObject1 = "__array__";; localObject1 = paramString)
        {
          localStringBuilder.append(a(localObject2, (String)localObject1, parami));
          i += 1;
          break label614;
          paramObject = (a)paramObject;
          break;
        }
        paramObject = localStringBuilder.toString();
        AppMethodBeat.o(231673);
        return paramObject;
      }
      if (paramObject == null) {}
      for (paramObject = "null"; paramString == null; paramObject = EQ(paramObject.toString()))
      {
        paramObject = "\"" + paramObject + "\"";
        AppMethodBeat.o(231673);
        return paramObject;
      }
      if (paramObject.length() == 0)
      {
        paramObject = "<" + paramString + "/>";
        AppMethodBeat.o(231673);
        return paramObject;
      }
      paramObject = "<" + paramString + ">" + paramObject + "</" + paramString + ">";
      AppMethodBeat.o(231673);
      return paramObject;
    }
  }
  
  private static boolean a(j paramj, c paramc, String paramString, i parami)
  {
    AppMethodBeat.i(231635);
    Object localObject = paramj.jQz();
    if (localObject == agZe)
    {
      i = paramj.next();
      if (i == 45)
      {
        if (paramj.next() == '-')
        {
          paramj.bFe("-->");
          AppMethodBeat.o(231635);
          return false;
        }
        paramj.cLO();
      }
      int j;
      while (i != 91)
      {
        j = 1;
        paramc = paramj.jQy();
        if (paramc != null) {
          break;
        }
        paramj = paramj.bFc("Missing '>' after '<!'.");
        AppMethodBeat.o(231635);
        throw paramj;
      }
      if (("CDATA".equals(paramj.jQz())) && (paramj.next() == '['))
      {
        paramString = new StringBuilder();
        while (paramj.jQr())
        {
          paramString.append(paramj.next());
          i = paramString.length() - 3;
          if ((i >= 0) && (paramString.charAt(i) == ']') && (paramString.charAt(i + 1) == ']') && (paramString.charAt(i + 2) == '>'))
          {
            paramString.setLength(i);
            paramj = paramString.toString();
            if (paramj.length() > 0) {
              paramc.U(parami.agZq, paramj);
            }
            AppMethodBeat.o(231635);
            return false;
          }
        }
        paramj = paramj.bFc("Unclosed CDATA");
        AppMethodBeat.o(231635);
        throw paramj;
      }
      paramj = paramj.bFc("Expected 'CDATA['");
      AppMethodBeat.o(231635);
      throw paramj;
      if (paramc == agZh) {
        i = j + 1;
      }
      for (;;)
      {
        j = i;
        if (i > 0) {
          break;
        }
        AppMethodBeat.o(231635);
        return false;
        i = j;
        if (paramc == agZg) {
          i = j - 1;
        }
      }
    }
    if (localObject == agZi)
    {
      paramj.bFe("?>");
      AppMethodBeat.o(231635);
      return false;
    }
    if (localObject == agZk)
    {
      paramc = paramj.jQz();
      if (paramString == null)
      {
        paramj = paramj.bFc("Mismatched close tag ".concat(String.valueOf(paramc)));
        AppMethodBeat.o(231635);
        throw paramj;
      }
      if (!paramc.equals(paramString))
      {
        paramj = paramj.bFc("Mismatched " + paramString + " and " + paramc);
        AppMethodBeat.o(231635);
        throw paramj;
      }
      if (paramj.jQz() != agZg)
      {
        paramj = paramj.bFc("Misshaped close tag");
        AppMethodBeat.o(231635);
        throw paramj;
      }
      AppMethodBeat.o(231635);
      return true;
    }
    if ((localObject instanceof Character))
    {
      paramj = paramj.bFc("Misshaped tag");
      AppMethodBeat.o(231635);
      throw paramj;
    }
    String str1 = (String)localObject;
    c localc = new c();
    paramString = null;
    int i = 0;
    localObject = null;
    if (localObject == null) {
      localObject = paramj.jQz();
    }
    for (;;)
    {
      String str2;
      if ((localObject instanceof String))
      {
        str2 = (String)localObject;
        localObject = paramj.jQz();
        if (localObject == agZf)
        {
          localObject = paramj.jQz();
          if (!(localObject instanceof String))
          {
            paramj = paramj.bFc("Missing value");
            AppMethodBeat.o(231635);
            throw paramj;
          }
          if ((parami.agZr) && ("xsi:nil".equals(str2)) && (Boolean.parseBoolean((String)localObject))) {
            i = 1;
          }
          for (;;)
          {
            localObject = null;
            break;
            if ((parami.agZs == null) || (parami.agZs.isEmpty()) || (!"xsi:type".equals(str2))) {
              break label644;
            }
            paramString = (k)parami.agZs.get(localObject);
          }
          label644:
          if (i == 0)
          {
            str2 = "__attr__".concat(String.valueOf(str2));
            if (!parami.agZp) {
              break label688;
            }
          }
          label688:
          for (localObject = (String)localObject;; localObject = bFb((String)localObject))
          {
            localc.U(str2, localObject);
            break;
          }
        }
        localc.U("__attr__".concat(String.valueOf(str2)), "");
        break;
      }
      if (localObject == agZk)
      {
        if (paramj.jQz() != agZg)
        {
          paramj = paramj.bFc("Misshaped tag");
          AppMethodBeat.o(231635);
          throw paramj;
        }
        if (i != 0) {
          paramc.U(str1, c.bfF);
        }
        for (;;)
        {
          AppMethodBeat.o(231635);
          return false;
          if (localc.length() > 0) {
            paramc.U(str1, localc);
          } else {
            paramc.U(str1, "");
          }
        }
      }
      if (localObject == agZg)
      {
        do
        {
          do
          {
            localObject = paramj.jQw();
            if (localObject == null)
            {
              if (str1 != null)
              {
                paramj = paramj.bFc("Unclosed tag ".concat(String.valueOf(str1)));
                AppMethodBeat.o(231635);
                throw paramj;
              }
              AppMethodBeat.o(231635);
              return false;
            }
            if (!(localObject instanceof String)) {
              break;
            }
            localObject = (String)localObject;
          } while (((String)localObject).length() <= 0);
          if (paramString != null)
          {
            str2 = parami.agZq;
            if (paramString != null) {}
            for (localObject = paramString.jQA();; localObject = bFb((String)localObject))
            {
              localc.U(str2, localObject);
              break;
            }
          }
          str2 = parami.agZq;
          if (parami.agZp) {}
          for (;;)
          {
            localc.U(str2, localObject);
            break;
            localObject = bFb((String)localObject);
          }
        } while ((localObject != agZh) || (!a(paramj, localc, str1, parami)));
        if (localc.length() == 0) {
          paramc.U(str1, "");
        }
        for (;;)
        {
          AppMethodBeat.o(231635);
          return false;
          if ((localc.length() == 1) && (localc.opt(parami.agZq) != null)) {
            paramc.U(str1, localc.opt(parami.agZq));
          } else {
            paramc.U(str1, localc);
          }
        }
      }
      paramj = paramj.bFc("Misshaped tag");
      AppMethodBeat.o(231635);
      throw paramj;
    }
  }
  
  private static Number bFa(String paramString)
  {
    AppMethodBeat.i(231648);
    int j = paramString.charAt(0);
    if (((j >= 48) && (j <= 57)) || (j == 45))
    {
      int i;
      if ((paramString.indexOf('.') >= 0) || (paramString.indexOf('e') >= 0) || (paramString.indexOf('E') >= 0) || ("-0".equals(paramString))) {
        i = 1;
      }
      while (i != 0) {
        try
        {
          BigDecimal localBigDecimal = new BigDecimal(paramString);
          if ((j == 45) && (BigDecimal.ZERO.compareTo(localBigDecimal) == 0))
          {
            double d = -0.0D;
            AppMethodBeat.o(231648);
            return Double.valueOf(d);
            i = 0;
          }
          else
          {
            AppMethodBeat.o(231648);
            return localBigDecimal;
          }
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          try
          {
            Object localObject = Double.valueOf(paramString);
            if ((((Double)localObject).isNaN()) || (((Double)localObject).isInfinite()))
            {
              localObject = new NumberFormatException("val [" + paramString + "] is not a valid number.");
              AppMethodBeat.o(231648);
              throw ((Throwable)localObject);
            }
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            paramString = new NumberFormatException("val [" + paramString + "] is not a valid number.");
            AppMethodBeat.o(231648);
            throw paramString;
          }
          AppMethodBeat.o(231648);
          return localNumberFormatException2;
        }
      }
      if ((j == 48) && (paramString.length() > 1))
      {
        i = paramString.charAt(1);
        if ((i >= 48) && (i <= 57))
        {
          paramString = new NumberFormatException("val [" + paramString + "] is not a valid number.");
          AppMethodBeat.o(231648);
          throw paramString;
        }
      }
      else if ((j == 45) && (paramString.length() > 2))
      {
        i = paramString.charAt(1);
        j = paramString.charAt(2);
        if ((i == 48) && (j >= 48) && (j <= 57))
        {
          paramString = new NumberFormatException("val [" + paramString + "] is not a valid number.");
          AppMethodBeat.o(231648);
          throw paramString;
        }
      }
      paramString = new BigInteger(paramString);
      if (paramString.bitLength() <= 31)
      {
        i = paramString.intValue();
        AppMethodBeat.o(231648);
        return Integer.valueOf(i);
      }
      if (paramString.bitLength() <= 63)
      {
        long l = paramString.longValue();
        AppMethodBeat.o(231648);
        return Long.valueOf(l);
      }
      AppMethodBeat.o(231648);
      return paramString;
    }
    paramString = new NumberFormatException("val [" + paramString + "] is not a valid number.");
    AppMethodBeat.o(231648);
    throw paramString;
  }
  
  private static Object bFb(String paramString)
  {
    AppMethodBeat.i(231642);
    if ("".equals(paramString))
    {
      AppMethodBeat.o(231642);
      return paramString;
    }
    if ("true".equalsIgnoreCase(paramString))
    {
      paramString = Boolean.TRUE;
      AppMethodBeat.o(231642);
      return paramString;
    }
    if ("false".equalsIgnoreCase(paramString))
    {
      paramString = Boolean.FALSE;
      AppMethodBeat.o(231642);
      return paramString;
    }
    if ("null".equalsIgnoreCase(paramString))
    {
      paramString = c.bfF;
      AppMethodBeat.o(231642);
      return paramString;
    }
    int i = paramString.charAt(0);
    if (((i >= 48) && (i <= 57)) || (i == 45)) {
      try
      {
        Number localNumber = bFa(paramString);
        AppMethodBeat.o(231642);
        return localNumber;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(231642);
    return paramString;
  }
  
  public static c bFd(String paramString)
  {
    AppMethodBeat.i(231653);
    i locali = i.agZn;
    paramString = a(new StringReader(paramString), locali);
    AppMethodBeat.o(231653);
    return paramString;
  }
  
  public static String ca(Object paramObject)
  {
    AppMethodBeat.i(231659);
    paramObject = a(paramObject, null, i.agZn);
    AppMethodBeat.o(231659);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.cs.h
 * JD-Core Version:    0.7.0.1
 */