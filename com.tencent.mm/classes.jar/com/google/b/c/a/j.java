package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class j
{
  private static int a(float[] paramArrayOfFloat, int[] paramArrayOfInt, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(57322);
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
    AppMethodBeat.o(57322);
    return i;
  }
  
  public static String a(String paramString, l paraml, com.google.b.b paramb1, com.google.b.b paramb2)
  {
    int j = 0;
    AppMethodBeat.i(57320);
    a locala = new a();
    c localc = new c();
    m localm = new m();
    n localn = new n();
    f localf = new f();
    b localb = new b();
    h localh = new h(paramString);
    localh.bjn = paraml;
    localh.bjo = paramb1;
    localh.bjp = paramb2;
    int i;
    if ((paramString.startsWith("[)>\03605\035")) && (paramString.endsWith("\036\004")))
    {
      localh.g('ì');
      localh.bjt = 2;
      localh.pos += 7;
      i = j;
    }
    while (localh.sG())
    {
      new g[] { locala, localc, localm, localn, localf, localb }[i].a(localh);
      if (localh.bjr >= 0)
      {
        i = localh.bjr;
        localh.bjr = -1;
        continue;
        i = j;
        if (paramString.startsWith("[)>\03606\035"))
        {
          i = j;
          if (paramString.endsWith("\036\004"))
          {
            localh.g('í');
            localh.bjt = 2;
            localh.pos += 7;
            i = j;
          }
        }
      }
    }
    int k = localh.bjq.length();
    localh.sJ();
    j = localh.bjs.bjB;
    if ((k < j) && (i != 0) && (i != 5)) {
      localh.g('þ');
    }
    paramString = localh.bjq;
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
    paramString = localh.bjq.toString();
    AppMethodBeat.o(57320);
    return paramString;
  }
  
  static int b(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57321);
    if (paramInt1 >= paramCharSequence.length())
    {
      AppMethodBeat.o(57321);
      return paramInt2;
    }
    float[] arrayOfFloat;
    if (paramInt2 == 0)
    {
      arrayOfFloat = new float[6];
      float[] tmp34_32 = arrayOfFloat;
      tmp34_32[0] = 0.0F;
      float[] tmp38_34 = tmp34_32;
      tmp38_34[1] = 1.0F;
      float[] tmp42_38 = tmp38_34;
      tmp42_38[2] = 1.0F;
      float[] tmp46_42 = tmp42_38;
      tmp46_42[3] = 1.0F;
      float[] tmp50_46 = tmp46_42;
      tmp50_46[4] = 1.0F;
      float[] tmp54_50 = tmp50_46;
      tmp54_50[5] = 1.25F;
      tmp54_50;
      paramInt2 = 0;
    }
    int[] arrayOfInt;
    char c;
    int i;
    label270:
    label302:
    label317:
    label349:
    label364:
    label382:
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
                paramInt2 = r(paramCharSequence);
                if (arrayOfInt[0] == paramInt1)
                {
                  AppMethodBeat.o(57321);
                  return 0;
                  arrayOfFloat = new float[6];
                  tmp124_122 = arrayOfFloat;
                  tmp124_122[0] = 1.0F;
                  tmp128_124 = tmp124_122;
                  tmp128_124[1] = 2.0F;
                  tmp132_128 = tmp128_124;
                  tmp132_128[2] = 2.0F;
                  tmp136_132 = tmp132_128;
                  tmp136_132[3] = 2.0F;
                  tmp140_136 = tmp136_132;
                  tmp140_136[4] = 2.0F;
                  tmp144_140 = tmp140_136;
                  tmp144_140[5] = 2.25F;
                  tmp144_140;
                  arrayOfFloat[paramInt2] = 0.0F;
                  break;
                }
                if ((paramInt2 == 1) && (paramCharSequence[5] > 0))
                {
                  AppMethodBeat.o(57321);
                  return 5;
                }
                if ((paramInt2 == 1) && (paramCharSequence[4] > 0))
                {
                  AppMethodBeat.o(57321);
                  return 4;
                }
                if ((paramInt2 == 1) && (paramCharSequence[2] > 0))
                {
                  AppMethodBeat.o(57321);
                  return 2;
                }
                if ((paramInt2 == 1) && (paramCharSequence[3] > 0))
                {
                  AppMethodBeat.o(57321);
                  return 3;
                }
                AppMethodBeat.o(57321);
                return 1;
              }
              c = paramCharSequence.charAt(paramInt1 + paramInt2);
              i = paramInt2 + 1;
              if (isDigit(c))
              {
                arrayOfFloat[0] += 0.5F;
                if ((c != ' ') && ((c < '0') || (c > '9')) && ((c < 'A') || (c > 'Z'))) {
                  break label581;
                }
                paramInt2 = 1;
                if (paramInt2 == 0) {
                  break label586;
                }
                arrayOfFloat[1] += 0.6666667F;
                if ((c != ' ') && ((c < '0') || (c > '9')) && ((c < 'a') || (c > 'z'))) {
                  break label621;
                }
                paramInt2 = 1;
                if (paramInt2 == 0) {
                  break label626;
                }
                arrayOfFloat[2] += 0.6666667F;
                if (!i(c)) {
                  break label661;
                }
                arrayOfFloat[3] += 0.6666667F;
                if ((c < ' ') || (c > '^')) {
                  break label696;
                }
                paramInt2 = 1;
                if (paramInt2 == 0) {
                  break label701;
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
                paramInt2 = r(arrayOfByte);
                if ((arrayOfInt[0] >= arrayOfInt[5]) || (arrayOfInt[0] >= arrayOfInt[1]) || (arrayOfInt[0] >= arrayOfInt[2]) || (arrayOfInt[0] >= arrayOfInt[3]) || (arrayOfInt[0] >= arrayOfInt[4])) {
                  break label736;
                }
                AppMethodBeat.o(57321);
                return 0;
                if (h(c))
                {
                  arrayOfFloat[0] = ((float)Math.ceil(arrayOfFloat[0]));
                  arrayOfFloat[0] += 2.0F;
                  break label270;
                }
                arrayOfFloat[0] = ((float)Math.ceil(arrayOfFloat[0]));
                arrayOfFloat[0] += 1.0F;
                break label270;
                paramInt2 = 0;
                break label302;
                if (h(c))
                {
                  arrayOfFloat[1] += 2.666667F;
                  break label317;
                }
                arrayOfFloat[1] += 1.333333F;
                break label317;
                paramInt2 = 0;
                break label349;
                if (h(c))
                {
                  arrayOfFloat[2] += 2.666667F;
                  break label364;
                }
                arrayOfFloat[2] += 1.333333F;
                break label364;
                if (h(c))
                {
                  arrayOfFloat[3] += 4.333334F;
                  break label382;
                }
                arrayOfFloat[3] += 3.333333F;
                break label382;
                paramInt2 = 0;
                break label396;
                if (h(c)) {
                  arrayOfFloat[4] += 4.25F;
                } else {
                  arrayOfFloat[4] += 3.25F;
                }
              }
              if ((arrayOfInt[5] < arrayOfInt[0]) || (arrayOfByte[1] + arrayOfByte[2] + arrayOfByte[3] + arrayOfByte[4] == 0))
              {
                AppMethodBeat.o(57321);
                return 5;
              }
              if ((paramInt2 == 1) && (arrayOfByte[4] > 0))
              {
                AppMethodBeat.o(57321);
                return 4;
              }
              if ((paramInt2 == 1) && (arrayOfByte[2] > 0))
              {
                AppMethodBeat.o(57321);
                return 2;
              }
              if ((paramInt2 == 1) && (arrayOfByte[3] > 0))
              {
                AppMethodBeat.o(57321);
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
        AppMethodBeat.o(57321);
        return 1;
      }
      paramInt2 = i;
    } while (arrayOfInt[1] != arrayOfInt[3]);
    label396:
    label581:
    label586:
    label621:
    label626:
    paramInt1 = paramInt1 + i + 1;
    label661:
    label696:
    label701:
    label736:
    while (paramInt1 < paramCharSequence.length())
    {
      c = paramCharSequence.charAt(paramInt1);
      if (j(c))
      {
        AppMethodBeat.o(57321);
        return 3;
      }
      if (!i(c)) {
        break;
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(57321);
    return 1;
  }
  
  static boolean h(char paramChar)
  {
    return (paramChar >= '') && (paramChar <= 'ÿ');
  }
  
  private static boolean i(char paramChar)
  {
    AppMethodBeat.i(57323);
    if ((j(paramChar)) || (paramChar == ' ') || ((paramChar >= '0') && (paramChar <= '9')) || ((paramChar >= 'A') && (paramChar <= 'Z')))
    {
      AppMethodBeat.o(57323);
      return true;
    }
    AppMethodBeat.o(57323);
    return false;
  }
  
  static boolean isDigit(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  private static boolean j(char paramChar)
  {
    return (paramChar == '\r') || (paramChar == '*') || (paramChar == '>');
  }
  
  static void k(char paramChar)
  {
    AppMethodBeat.i(57324);
    Object localObject = Integer.toHexString(paramChar);
    localObject = "0000".substring(0, 4 - ((String)localObject).length()) + (String)localObject;
    localObject = new IllegalArgumentException("Illegal character: " + paramChar + " (0x" + (String)localObject + ')');
    AppMethodBeat.o(57324);
    throw ((Throwable)localObject);
  }
  
  private static int r(byte[] paramArrayOfByte)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.b.c.a.j
 * JD-Core Version:    0.7.0.1
 */