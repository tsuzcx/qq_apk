package com.google.c.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public final class a
{
  private static final TimeZone dHW;
  
  static
  {
    AppMethodBeat.i(208869);
    dHW = TimeZone.getTimeZone("UTC");
    AppMethodBeat.o(208869);
  }
  
  public static Date a(String paramString, ParsePosition paramParsePosition)
  {
    AppMethodBeat.i(208850);
    try
    {
      j = paramParsePosition.getIndex();
      i = j + 4;
      i2 = l(paramString, j, i);
      if (!a(paramString, i, '-')) {
        break label979;
      }
      i += 1;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      int i2;
      int i3;
      int i4;
      boolean bool;
      Object localObject1;
      int i5;
      if (paramString != null) {
        break label904;
      }
      paramString = null;
      String str1 = localIndexOutOfBoundsException.getMessage();
      if (str1 == null) {
        break label424;
      }
      Object localObject3 = str1;
      if (!str1.isEmpty()) {
        break label454;
      }
      localObject3 = "(" + localIndexOutOfBoundsException.getClass().getName() + ")";
      paramString = new ParseException("Failed to parse date [" + paramString + "]: " + (String)localObject3, paramParsePosition.getIndex());
      paramString.initCause(localIndexOutOfBoundsException);
      AppMethodBeat.o(208850);
      throw paramString;
      j *= 10;
      break label982;
      j *= 100;
      break label982;
      char c = paramString.charAt(k);
      if (c != 'Z') {
        break label649;
      }
      Object localObject2 = dHW;
      k += 1;
      String str2;
      do
      {
        do
        {
          localObject2 = new GregorianCalendar((TimeZone)localObject2);
          ((Calendar)localObject2).setLenient(false);
          ((Calendar)localObject2).set(1, i2);
          ((Calendar)localObject2).set(2, i3 - 1);
          ((Calendar)localObject2).set(5, i4);
          ((Calendar)localObject2).set(11, n);
          ((Calendar)localObject2).set(12, m);
          ((Calendar)localObject2).set(13, j);
          ((Calendar)localObject2).set(14, i);
          paramParsePosition.setIndex(k);
          localObject2 = ((Calendar)localObject2).getTime();
          AppMethodBeat.o(208850);
          return localObject2;
          if ((c != '+') && (c != '-')) {
            break;
          }
          localObject2 = paramString.substring(k);
          if (((String)localObject2).length() >= 5) {}
          for (;;)
          {
            i1 = ((String)localObject2).length() + k;
            if ((!"+0000".equals(localObject2)) && (!"+00:00".equals(localObject2))) {
              break label745;
            }
            localObject2 = dHW;
            k = i1;
            break;
            localObject2 = (String)localObject2 + "00";
          }
          str1 = "GMT".concat(String.valueOf(localObject2));
          localObject3 = TimeZone.getTimeZone(str1);
          str2 = ((TimeZone)localObject3).getID();
          localObject2 = localObject3;
          k = i1;
        } while (str2.equals(str1));
        localObject2 = localObject3;
        k = i1;
      } while (str2.replace(":", "").equals(str1));
      localObject2 = new IndexOutOfBoundsException("Mismatching time zone indicator: " + str1 + " given, resolves to " + ((TimeZone)localObject3).getID());
      AppMethodBeat.o(208850);
      throw ((Throwable)localObject2);
      localObject2 = new IndexOutOfBoundsException("Invalid time zone indicator '" + c + "'");
      AppMethodBeat.o(208850);
      throw ((Throwable)localObject2);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        continue;
        paramString = "\"" + paramString + '"';
        continue;
        int i1 = 0;
        int j = i;
        int i = i1;
        continue;
        i1 = 0;
        j = 0;
        int k = i;
        i = i1;
        continue;
        continue;
        i = 0;
        j = 0;
        int m = 0;
        int n = 0;
        continue;
        i = j;
        continue;
        continue;
        k = i;
        i = j;
        j = k;
        k = i1;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label394;
    }
    j = i + 2;
    i3 = l(paramString, i, j);
    if (a(paramString, j, '-'))
    {
      i = j + 1;
      k = i + 2;
      i4 = l(paramString, i, k);
      bool = a(paramString, k, 'T');
      if ((!bool) && (paramString.length() <= k))
      {
        localObject1 = new GregorianCalendar(i2, i3 - 1, i4);
        paramParsePosition.setIndex(k);
        localObject1 = ((Calendar)localObject1).getTime();
        AppMethodBeat.o(208850);
        return localObject1;
      }
      if (bool)
      {
        j = k + 1;
        i = j + 2;
        n = l(paramString, j, i);
        if (a(paramString, i, ':'))
        {
          i += 1;
          j = i + 2;
          m = l(paramString, i, j);
          i = j;
          if (a(paramString, j, ':')) {
            i = j + 1;
          }
          if (paramString.length() > i)
          {
            j = paramString.charAt(i);
            if ((j != 90) && (j != 43) && (j != 45))
            {
              k = i + 2;
              j = l(paramString, i, k);
              i = j;
              if (j > 59)
              {
                i = j;
                if (j < 63) {
                  i = 59;
                }
              }
              if (a(paramString, k, '.'))
              {
                k += 1;
                i1 = z(paramString, k + 1);
                i5 = Math.min(i1, k + 3);
                j = l(paramString, k, i5);
                switch (i5 - k)
                {
                case 2: 
                  if (paramString.length() <= k)
                  {
                    localObject1 = new IllegalArgumentException("No time zone indicator");
                    AppMethodBeat.o(208850);
                    throw ((Throwable)localObject1);
                  }
                  break;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static boolean a(String paramString, int paramInt, char paramChar)
  {
    AppMethodBeat.i(208852);
    if ((paramInt < paramString.length()) && (paramString.charAt(paramInt) == paramChar))
    {
      AppMethodBeat.o(208852);
      return true;
    }
    AppMethodBeat.o(208852);
    return false;
  }
  
  private static int l(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208858);
    if ((paramInt1 < 0) || (paramInt2 > paramString.length()) || (paramInt1 > paramInt2))
    {
      paramString = new NumberFormatException(paramString);
      AppMethodBeat.o(208858);
      throw paramString;
    }
    int i = 0;
    int j;
    if (paramInt1 < paramInt2)
    {
      j = paramInt1 + 1;
      i = Character.digit(paramString.charAt(paramInt1), 10);
      if (i < 0)
      {
        paramString = new NumberFormatException("Invalid number: " + paramString.substring(paramInt1, paramInt2));
        AppMethodBeat.o(208858);
        throw paramString;
      }
      i = -i;
    }
    for (;;)
    {
      if (j < paramInt2)
      {
        int k = Character.digit(paramString.charAt(j), 10);
        if (k < 0)
        {
          paramString = new NumberFormatException("Invalid number: " + paramString.substring(paramInt1, paramInt2));
          AppMethodBeat.o(208858);
          throw paramString;
        }
        i = i * 10 - k;
        j += 1;
      }
      else
      {
        paramInt1 = -i;
        AppMethodBeat.o(208858);
        return paramInt1;
        j = paramInt1;
      }
    }
  }
  
  private static int z(String paramString, int paramInt)
  {
    AppMethodBeat.i(208864);
    while (paramInt < paramString.length())
    {
      int i = paramString.charAt(paramInt);
      if ((i < 48) || (i > 57))
      {
        AppMethodBeat.o(208864);
        return paramInt;
      }
      paramInt += 1;
    }
    paramInt = paramString.length();
    AppMethodBeat.o(208864);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.c.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */