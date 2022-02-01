package c.t.m.g;

import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class cl
{
  private static final int[] a = { 93629, 99879, 79843, 75029, 59699, 55667, 46867, 38039 };
  
  public static double a(double paramDouble, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 6) {
      return 40.0D;
    }
    if (paramInt1 == 5) {
      return 60.0D;
    }
    if (paramInt1 == 4) {
      return 70.0D;
    }
    if (paramInt1 == 3) {
      return 90.0D;
    }
    if (paramInt1 == 2) {
      return 110.0D;
    }
    if ((paramInt2 >= -72) && (paramInt1 == 0)) {
      return (int)(0.45D * paramDouble / 10.0D) * 10;
    }
    if (paramDouble <= 100.0D) {
      paramInt1 = (int)((paramDouble - 1.0D) / 10.0D + 1.0D) * 10;
    }
    for (;;)
    {
      return paramInt1;
      if ((paramDouble > 100.0D) && (paramDouble <= 800.0D)) {
        paramInt1 = (int)(0.85D * paramDouble / 10.0D) * 10;
      } else {
        paramInt1 = (int)(0.8D * paramDouble / 10.0D) * 10;
      }
    }
  }
  
  public static int a(String paramString)
  {
    new a();
    return a.a(paramString.toCharArray());
  }
  
  public static int a(String paramString1, String paramString2)
  {
    if (b.a(paramString1, paramString2)) {
      return 1;
    }
    return 0;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ a[(i & 0x7)] & 0xFF));
      i += 1;
    }
    return 0;
  }
  
  static final class a
  {
    private static char[] a = "FBTP2AHR3WKC6LEYON7D5GZXVISMJ4QU".toCharArray();
    private static int[] b = { 10997, 23684, 12917, 22136, 2009, 11942, 4068, 6127, 13933, 18756, 20277, 9652, 15925, 25061, 11178, 31378, 26914, 11204, 6235, 22223, 27062, 30059, 14207, 27229, 11368, 17539, 22247, 28496, 22602, 25579, 5579, 18581, 17129, 6151, 6089, 30944, 23413, 27995, 26923, 1510, 20770, 21848, 30825, 7117, 30925, 1397, 18670, 1248, 13795, 19586, 17183, 18824, 27263, 21049, 17818, 3191, 13010, 29975, 23483, 30503, 28616, 14954, 15717, 19075, 25832, 1194, 31743, 26596, 28029, 1036, 188, 26174, 3315, 5461, 16416, 1948, 24195, 748, 18112, 8905, 10259, 23604, 841, 21840, 5207, 22296, 29123, 4519, 22589, 28648, 3095, 23976, 18312, 15203, 9167, 21824, 7354, 7957, 2334, 17771, 30776, 25571, 8992, 29536, 23209, 22244, 23906, 25608, 7839, 27762, 3749, 14261, 13689, 6529, 15583, 28177, 11144, 22320, 25219, 9813, 14192, 1182, 6402, 12219, 22737, 6911, 19602, 32309, 18983, 26607, 23854, 22367, 18927, 16901, 20702, 19378, 32524, 27564, 31544, 20475, 31848, 6190, 15911, 2828, 10206, 18194, 18411, 11186, 2136, 27048, 29281, 23271, 16180, 1762, 10117, 7752, 12525, 20837, 28469, 16073, 8439, 25568, 2616, 1959, 17642, 6045, 15998, 29086, 4835, 10582, 14505, 3677, 20263, 8265, 9933, 18487, 7434, 11150, 28788, 18971, 5904, 27049, 12262, 9158, 12881, 20060, 20647, 32311, 28962, 6847, 30528, 29795, 10481, 7058, 5698, 25643, 24433, 8657, 21641, 19339, 760, 27017, 10430, 1556, 549, 25323, 19999, 32412, 1733, 4510, 30339, 10548, 22519, 30298, 23960, 22874, 10127, 14003, 8560, 18544, 20153, 30514, 1084, 24685, 15839, 7082, 31575, 7891, 9164, 25033, 12166, 9185, 4113, 2542, 21118, 16905, 5287, 570, 28070, 8612, 10967, 18410, 3615, 19685, 24407, 29412, 29186, 14347, 2486, 8079, 6888, 6619, 4857, 10984, 27056, 10318 };
    
    private static int a(char paramChar)
    {
      int i = 0;
      while (i < 32)
      {
        if (a[i] == paramChar) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    
    static int a(char[] paramArrayOfChar)
    {
      int n = 0;
      if (paramArrayOfChar.length != 35) {}
      do
      {
        return -1;
        i = 0;
        if (i >= 35) {
          break label85;
        }
        if ((i - 5) % 6 != 0) {
          break;
        }
      } while (paramArrayOfChar[i] != '-');
      int k;
      int j;
      label83:
      for (;;)
      {
        i += 1;
        break;
        k = paramArrayOfChar[i];
        j = 0;
        if (j < 32) {
          if (a[j] != k) {}
        }
        for (j = 1;; j = 0)
        {
          if (j != 0) {
            break label83;
          }
          return -1;
          j += 1;
          break;
        }
      }
      label85:
      int i = a(paramArrayOfChar[3]);
      switch (i + ((a(paramArrayOfChar[4]) ^ i + 21) << 5))
      {
      default: 
        i = -1;
      }
      for (;;)
      {
        return i;
        i = a(paramArrayOfChar[7]);
        j = a(paramArrayOfChar[13]);
        k = b[paramArrayOfChar[7]];
        int m = a(paramArrayOfChar[27]);
        int i1 = b[paramArrayOfChar[13]];
        int i2 = a(paramArrayOfChar[18]);
        int i3 = b[paramArrayOfChar[27]];
        int i4 = a(paramArrayOfChar[10]);
        int i5 = b[paramArrayOfChar[18]];
        i1 = ((a(paramArrayOfChar[15]) ^ b[paramArrayOfChar[10]] & 0x1F) << 25) + (i + ((j ^ k & 0x1F) << 5) + ((m ^ i1 & 0x1F) << 10) + ((i2 ^ i3 & 0x1F) << 15) + ((i4 ^ i5 & 0x1F) << 20));
        i = ((0xAAAAAAAA & i1) >> 1) + (0x55555555 & i1);
        i = (i & 0x33333333) + ((0xCCCCCCCC & i) >> 2);
        i = (i & 0xF0F0F0F) + ((0xF0F0F0F0 & i) >> 4);
        i = (i & 0xFF00FF) + ((0xFF00FF00 & i) >> 8);
        i = (i & 0xFFFF) + ((0xFFFF0000 & i) >> 16);
        if (i != a(paramArrayOfChar[9]))
        {
          i = -1;
        }
        else
        {
          j = i ^ 0x99A43CE;
          i = 0;
          while (i < 6)
          {
            j = b[(j & 0xFF ^ paramArrayOfChar[new int[] { 7, 13, 27, 18, 10, 15 }[i]])] ^ j >> 8 & 0xFF;
            i += 1;
          }
          if ((paramArrayOfChar[1] != a[(j & 0x1F)]) || (paramArrayOfChar[21] != a[(j >> 5 & 0x1F)]))
          {
            i = -1;
          }
          else
          {
            i = 0;
            k = 28;
            j = 0;
            while (k > 0)
            {
              i = paramArrayOfChar[j] << '\b' ^ i;
              m = 0;
              if (m < 8)
              {
                if ((0x8000 & i) != 0) {
                  i = i << 1 ^ 0x159E;
                }
                for (;;)
                {
                  m += 1;
                  break;
                  i <<= 1;
                }
              }
              k -= 1;
              i &= 0xFFFF;
              j += 1;
            }
            if ((paramArrayOfChar[28] != a[(i & 0x1F)]) || (paramArrayOfChar[30] != a[(i >> 5 & 0x1F)]) || (paramArrayOfChar[31] != a[(i >> 10 & 0x1F)]) || (paramArrayOfChar[32] != a[(i >> 15 & 0x1F)]))
            {
              i = -1;
            }
            else
            {
              j = 0;
              i = n;
              while (i <= 32)
              {
                j = b[(j & 0xFF ^ paramArrayOfChar[i])] ^ j >> 8 & 0xFF;
                i += 1;
              }
              if ((paramArrayOfChar[33] != a[(j & 0x1F)]) || (paramArrayOfChar[34] != a[(j >> 5 & 0x1F)])) {
                i = -1;
              } else {
                i = i1;
              }
            }
          }
        }
      }
    }
  }
  
  static final class b
  {
    private static int[] a = { 0, 49345, 49537, 320, 49921, 960, 640, 49729, 50689, 1728, 1920, 51009, 1280, 50625, 50305, 1088, 52225, 3264, 3456, 52545, 3840, 53185, 52865, 3648, 2560, 51905, 52097, 2880, 51457, 2496, 2176, 51265, 55297, 6336, 6528, 55617, 6912, 56257, 55937, 6720, 7680, 57025, 57217, 8000, 56577, 7616, 7296, 56385, 5120, 54465, 54657, 5440, 55041, 6080, 5760, 54849, 53761, 4800, 4992, 54081, 4352, 53697, 53377, 4160, 61441, 12480, 12672, 61761, 13056, 62401, 62081, 12864, 13824, 63169, 63361, 14144, 62721, 13760, 13440, 62529, 15360, 64705, 64897, 15680, 65281, 16320, 16000, 65089, 64001, 15040, 15232, 64321, 14592, 63937, 63617, 14400, 10240, 59585, 59777, 10560, 60161, 11200, 10880, 59969, 60929, 11968, 12160, 61249, 11520, 60865, 60545, 11328, 58369, 9408, 9600, 58689, 9984, 59329, 59009, 9792, 8704, 58049, 58241, 9024, 57601, 8640, 8320, 57409, 40961, 24768, 24960, 41281, 25344, 41921, 41601, 25152, 26112, 42689, 42881, 26432, 42241, 26048, 25728, 42049, 27648, 44225, 44417, 27968, 44801, 28608, 28288, 44609, 43521, 27328, 27520, 43841, 26880, 43457, 43137, 26688, 30720, 47297, 47489, 31040, 47873, 31680, 31360, 47681, 48641, 32448, 32640, 48961, 32000, 48577, 48257, 31808, 46081, 29888, 30080, 46401, 30464, 47041, 46721, 30272, 29184, 45761, 45953, 29504, 45313, 29120, 28800, 45121, 20480, 37057, 37249, 20800, 37633, 21440, 21120, 37441, 38401, 22208, 22400, 38721, 21760, 38337, 38017, 21568, 39937, 23744, 23936, 40257, 24320, 40897, 40577, 24128, 23040, 39617, 39809, 23360, 39169, 22976, 22656, 38977, 34817, 18624, 18816, 35137, 19200, 35777, 35457, 19008, 19968, 36545, 36737, 20288, 36097, 19904, 19584, 35905, 17408, 33985, 34177, 17728, 34561, 18368, 18048, 34369, 33281, 17088, 17280, 33601, 16640, 33217, 32897, 16448 };
    private static String b = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567";
    
    private static int a(char paramChar)
    {
      int j = 256;
      int i = j;
      if (paramChar >= 'A')
      {
        i = j;
        if (paramChar <= 'Z') {
          i = paramChar - 'A';
        }
      }
      j = i;
      if (paramChar >= 'a')
      {
        j = i;
        if (paramChar <= 'z') {
          j = paramChar - 'a' + 64;
        }
      }
      i = j;
      if (paramChar >= '0')
      {
        i = j;
        if (paramChar <= '9') {
          i = paramChar + '' - 48;
        }
      }
      return i;
    }
    
    public static boolean a(String paramString1, String paramString2)
    {
      int i;
      if ((paramString1.length() > 32) || (paramString1.length() < 6))
      {
        i = 0;
        if (i != 0) {
          break label51;
        }
      }
      label51:
      int j;
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
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        int k;
                        for (;;)
                        {
                          return false;
                          if (!Pattern.compile("[a-zA-Z0-9_]{6,32}").matcher(paramString1).matches())
                          {
                            i = 0;
                            break;
                          }
                          i = 1;
                          break;
                          if (paramString2.length() != 29) {
                            i = 0;
                          }
                          while (i != 0)
                          {
                            k = paramString1.length();
                            i = 0;
                            j = 0;
                            while (i < k)
                            {
                              j += a(paramString1.charAt(i));
                              i += 1;
                            }
                            if (!Pattern.compile("([A-Z2-7]{5}){1}(-[A-Z2-7]{5}){4}").matcher(paramString2).matches()) {
                              i = 0;
                            } else {
                              i = 1;
                            }
                          }
                        }
                        i = (k << 7) + k ^ j;
                        System.out.println(i);
                        j = (i * 9 + 10) / 3;
                      } while (paramString2.charAt(4) != b.charAt(j + 36 & 0x1F));
                      j = (i * 5 + 11) / 5;
                    } while (paramString2.charAt(7) != b.charAt(j & 0x1F));
                    j = (i + 10) / 3;
                  } while (paramString2.charAt(12) != b.charAt(j << 3 & 0x1F));
                  j = (i * 3 + 19) / 9;
                } while (paramString2.charAt(14) != b.charAt(j & 0x1F));
                j = (i * 3 + 39) / 8;
              } while (paramString2.charAt(19) != b.charAt(j & 0x1F));
              j = (i / 23 + 67) / 7;
            } while (paramString2.charAt(21) != b.charAt(j & 0x1F));
            i = (i + 23) / 6;
          } while (paramString2.charAt(26) != b.charAt((i + 3) * 7 & 0x1F));
          i = 0;
          j = 0;
          while (i < paramString1.length())
          {
            j = a[((j ^ a(paramString1.charAt(i))) & 0xFF)] ^ j >> 8 & 0xFF;
            i += 1;
          }
        } while ((paramString2.charAt(0) != b.charAt(j & 0x1F)) || (paramString2.charAt(1) != b.charAt(j >> 5 & 0x1F)));
        i = 0;
        j = 0;
        while (i < 27)
        {
          j = a[((j ^ a(paramString2.charAt(i))) & 0xFF)] ^ j >> 8 & 0xFF;
          i += 1;
        }
      } while ((paramString2.charAt(27) != b.charAt(j & 0x1F)) || (paramString2.charAt(28) != b.charAt(j >> 5 & 0x1F)));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.cl
 * JD-Core Version:    0.7.0.1
 */