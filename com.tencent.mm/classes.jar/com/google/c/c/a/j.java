package com.google.c.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class j
{
  private static int a(float[] paramArrayOfFloat, int[] paramArrayOfInt, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12387);
    Arrays.fill(paramArrayOfByte, (byte)0);
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < 6)
    {
      paramArrayOfInt[paramInt] = ((int)Math.ceil(paramArrayOfFloat[paramInt]));
      int k = paramArrayOfInt[paramInt];
      j = i;
      if (i > k)
      {
        Arrays.fill(paramArrayOfByte, (byte)0);
        j = k;
      }
      if (j == k) {
        paramArrayOfByte[paramInt] = ((byte)(paramArrayOfByte[paramInt] + 1));
      }
      paramInt += 1;
      i = j;
    }
    AppMethodBeat.o(12387);
    return i;
  }
  
  public static String a(String paramString, l paraml, com.google.c.b paramb1, com.google.c.b paramb2)
  {
    int j = 0;
    AppMethodBeat.i(12385);
    a locala = new a();
    c localc = new c();
    m localm = new m();
    n localn = new n();
    f localf = new f();
    b localb = new b();
    h localh = new h(paramString);
    localh.bIP = paraml;
    localh.bIQ = paramb1;
    localh.bIR = paramb2;
    int i;
    if ((paramString.startsWith("[)>\03605\035")) && (paramString.endsWith("\036\004")))
    {
      localh.e('ì');
      localh.bIV = 2;
      localh.pos += 7;
      i = j;
    }
    while (localh.ya())
    {
      new g[] { locala, localc, localm, localn, localf, localb }[i].a(localh);
      if (localh.bIT >= 0)
      {
        i = localh.bIT;
        localh.bIT = -1;
        continue;
        i = j;
        if (paramString.startsWith("[)>\03606\035"))
        {
          i = j;
          if (paramString.endsWith("\036\004"))
          {
            localh.e('í');
            localh.bIV = 2;
            localh.pos += 7;
            i = j;
          }
        }
      }
    }
    int k = localh.bIS.length();
    localh.yd();
    j = localh.bIU.bJd;
    if ((k < j) && (i != 0) && (i != 5)) {
      localh.e('þ');
    }
    paramString = localh.bIS;
    if (paramString.length() < j) {
      paramString.append('');
    }
    if (paramString.length() < j)
    {
      i = (paramString.length() + 1) * 149 % 253 + 1 + 129;
      if (i <= 254) {}
      for (;;)
      {
        paramString.append((char)i);
        break;
        i -= 254;
      }
    }
    paramString = localh.bIS.toString();
    AppMethodBeat.o(12385);
    return paramString;
  }
  
  static int b(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12386);
    if (paramInt1 >= paramCharSequence.length())
    {
      AppMethodBeat.o(12386);
      return paramInt2;
    }
    float[] arrayOfFloat;
    if (paramInt2 == 0)
    {
      arrayOfFloat = new float[6];
      float[] tmp36_34 = arrayOfFloat;
      tmp36_34[0] = 0.0F;
      float[] tmp40_36 = tmp36_34;
      tmp40_36[1] = 1.0F;
      float[] tmp44_40 = tmp40_36;
      tmp44_40[2] = 1.0F;
      float[] tmp48_44 = tmp44_40;
      tmp48_44[3] = 1.0F;
      float[] tmp52_48 = tmp48_44;
      tmp52_48[4] = 1.0F;
      float[] tmp56_52 = tmp52_48;
      tmp56_52[5] = 1.25F;
      tmp56_52;
      paramInt2 = 0;
    }
    int[] arrayOfInt;
    char c;
    int i;
    label278:
    label310:
    label325:
    label357:
    label372:
    label630:
    label635:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              if (paramInt1 + paramInt2 == paramCharSequence.length())
              {
                paramCharSequence = new byte[6];
                arrayOfInt = new int[6];
                paramInt1 = a(arrayOfFloat, arrayOfInt, 2147483647, paramCharSequence);
                paramInt2 = w(paramCharSequence);
                if (arrayOfInt[0] == paramInt1)
                {
                  AppMethodBeat.o(12386);
                  return 0;
                  arrayOfFloat = new float[6];
                  tmp127_125 = arrayOfFloat;
                  tmp127_125[0] = 1.0F;
                  tmp131_127 = tmp127_125;
                  tmp131_127[1] = 2.0F;
                  tmp135_131 = tmp131_127;
                  tmp135_131[2] = 2.0F;
                  tmp139_135 = tmp135_131;
                  tmp139_135[3] = 2.0F;
                  tmp143_139 = tmp139_135;
                  tmp143_139[4] = 2.0F;
                  tmp147_143 = tmp143_139;
                  tmp147_143[5] = 2.25F;
                  tmp147_143;
                  arrayOfFloat[paramInt2] = 0.0F;
                  break;
                }
                if ((paramInt2 == 1) && (paramCharSequence[5] > 0))
                {
                  AppMethodBeat.o(12386);
                  return 5;
                }
                if ((paramInt2 == 1) && (paramCharSequence[4] > 0))
                {
                  AppMethodBeat.o(12386);
                  return 4;
                }
                if ((paramInt2 == 1) && (paramCharSequence[2] > 0))
                {
                  AppMethodBeat.o(12386);
                  return 2;
                }
                if ((paramInt2 == 1) && (paramCharSequence[3] > 0))
                {
                  AppMethodBeat.o(12386);
                  return 3;
                }
                AppMethodBeat.o(12386);
                return 1;
              }
              c = paramCharSequence.charAt(paramInt1 + paramInt2);
              i = paramInt2 + 1;
              if (isDigit(c))
              {
                arrayOfFloat[0] += 0.5F;
                if ((c != ' ') && ((c < '0') || (c > '9')) && ((c < 'A') || (c > 'Z'))) {
                  break label590;
                }
                paramInt2 = 1;
                if (paramInt2 == 0) {
                  break label595;
                }
                arrayOfFloat[1] += 0.6666667F;
                if ((c != ' ') && ((c < '0') || (c > '9')) && ((c < 'a') || (c > 'z'))) {
                  break label630;
                }
                paramInt2 = 1;
                if (paramInt2 == 0) {
                  break label635;
                }
                arrayOfFloat[2] += 0.6666667F;
                if (!g(c)) {
                  break label670;
                }
                arrayOfFloat[3] += 0.6666667F;
                if ((c < ' ') || (c > '^')) {
                  break label705;
                }
                paramInt2 = 1;
                if (paramInt2 == 0) {
                  break label710;
                }
                arrayOfFloat[4] += 0.75F;
              }
              byte[] arrayOfByte;
              for (;;)
              {
                arrayOfFloat[5] += 1.0F;
                paramInt2 = i;
                if (i < 4) {
                  break;
                }
                arrayOfInt = new int[6];
                arrayOfByte = new byte[6];
                a(arrayOfFloat, arrayOfInt, 2147483647, arrayOfByte);
                paramInt2 = w(arrayOfByte);
                if ((arrayOfInt[0] >= arrayOfInt[5]) || (arrayOfInt[0] >= arrayOfInt[1]) || (arrayOfInt[0] >= arrayOfInt[2]) || (arrayOfInt[0] >= arrayOfInt[3]) || (arrayOfInt[0] >= arrayOfInt[4])) {
                  break label745;
                }
                AppMethodBeat.o(12386);
                return 0;
                if (f(c))
                {
                  arrayOfFloat[0] = ((float)Math.ceil(arrayOfFloat[0]));
                  arrayOfFloat[0] += 2.0F;
                  break label278;
                }
                arrayOfFloat[0] = ((float)Math.ceil(arrayOfFloat[0]));
                arrayOfFloat[0] += 1.0F;
                break label278;
                paramInt2 = 0;
                break label310;
                if (f(c))
                {
                  arrayOfFloat[1] += 2.666667F;
                  break label325;
                }
                arrayOfFloat[1] += 1.333333F;
                break label325;
                paramInt2 = 0;
                break label357;
                if (f(c))
                {
                  arrayOfFloat[2] += 2.666667F;
                  break label372;
                }
                arrayOfFloat[2] += 1.333333F;
                break label372;
                if (f(c))
                {
                  arrayOfFloat[3] += 4.333334F;
                  break label390;
                }
                arrayOfFloat[3] += 3.333333F;
                break label390;
                paramInt2 = 0;
                break label404;
                if (f(c)) {
                  arrayOfFloat[4] += 4.25F;
                } else {
                  arrayOfFloat[4] += 3.25F;
                }
              }
              if ((arrayOfInt[5] < arrayOfInt[0]) || (arrayOfByte[1] + arrayOfByte[2] + arrayOfByte[3] + arrayOfByte[4] == 0))
              {
                AppMethodBeat.o(12386);
                return 5;
              }
              if ((paramInt2 == 1) && (arrayOfByte[4] > 0))
              {
                AppMethodBeat.o(12386);
                return 4;
              }
              if ((paramInt2 == 1) && (arrayOfByte[2] > 0))
              {
                AppMethodBeat.o(12386);
                return 2;
              }
              if ((paramInt2 == 1) && (arrayOfByte[3] > 0))
              {
                AppMethodBeat.o(12386);
                return 3;
              }
              paramInt2 = i;
            } while (arrayOfInt[1] + 1 >= arrayOfInt[0]);
            paramInt2 = i;
          } while (arrayOfInt[1] + 1 >= arrayOfInt[5]);
          paramInt2 = i;
        } while (arrayOfInt[1] + 1 >= arrayOfInt[4]);
        paramInt2 = i;
      } while (arrayOfInt[1] + 1 >= arrayOfInt[2]);
      if (arrayOfInt[1] < arrayOfInt[3])
      {
        AppMethodBeat.o(12386);
        return 1;
      }
      paramInt2 = i;
    } while (arrayOfInt[1] != arrayOfInt[3]);
    label390:
    label404:
    label590:
    label595:
    label745:
    paramInt1 = paramInt1 + i + 1;
    label670:
    label705:
    label710:
    while (paramInt1 < paramCharSequence.length())
    {
      c = paramCharSequence.charAt(paramInt1);
      if (h(c))
      {
        AppMethodBeat.o(12386);
        return 3;
      }
      if (!g(c)) {
        break;
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(12386);
    return 1;
  }
  
  static boolean f(char paramChar)
  {
    return (paramChar >= '') && (paramChar <= 'ÿ');
  }
  
  private static boolean g(char paramChar)
  {
    AppMethodBeat.i(12388);
    if ((h(paramChar)) || (paramChar == ' ') || ((paramChar >= '0') && (paramChar <= '9')) || ((paramChar >= 'A') && (paramChar <= 'Z')))
    {
      AppMethodBeat.o(12388);
      return true;
    }
    AppMethodBeat.o(12388);
    return false;
  }
  
  private static boolean h(char paramChar)
  {
    return (paramChar == '\r') || (paramChar == '*') || (paramChar == '>');
  }
  
  static void i(char paramChar)
  {
    AppMethodBeat.i(12389);
    Object localObject = Integer.toHexString(paramChar);
    localObject = "0000".substring(0, 4 - ((String)localObject).length()) + (String)localObject;
    localObject = new IllegalArgumentException("Illegal character: " + paramChar + " (0x" + (String)localObject + ')');
    AppMethodBeat.o(12389);
    throw ((Throwable)localObject);
  }
  
  static boolean isDigit(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  private static int w(byte[] paramArrayOfByte)
  {
    int j = 0;
    int k;
    for (int i = 0; j < 6; i = k + i)
    {
      k = paramArrayOfByte[j];
      j += 1;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.c.c.a.j
 * JD-Core Version:    0.7.0.1
 */