package com.google.c.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  private static final int[] bTj;
  private static final int[][] bTk;
  private static final int[] bTl;
  private static final int[] bTm;
  
  static
  {
    int i = 1;
    bTj = new int[] { 5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68 };
    int[] arrayOfInt1 = { 228, 48, 15, 111, 62 };
    int[] arrayOfInt2 = { 23, 68, 144, 134, 240, 92, 254 };
    int[] arrayOfInt3 = { 28, 24, 185, 166, 223, 248, 116, 255, 110, 61 };
    int[] arrayOfInt4 = { 175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120 };
    int[] arrayOfInt5 = { 41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242 };
    int[] arrayOfInt6 = { 156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185 };
    int[] arrayOfInt7 = { 15, 195, 244, 9, 233, 71, 168, 2, 188, 160, 153, 145, 253, 79, 108, 82, 27, 174, 186, 172 };
    int[] arrayOfInt8 = { 77, 193, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, 226, 5, 9, 5 };
    int[] arrayOfInt9 = { 175, 9, 223, 238, 12, 17, 220, 208, 100, 29, 175, 170, 230, 192, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, 207, 164, 13, 137, 245, 127, 67, 247, 28, 155, 43, 203, 107, 233, 53, 143, 46 };
    int[] arrayOfInt10 = { 242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, 189, 143, 108, 196, 37, 185, 112, 134, 230, 245, 63, 197, 190, 250, 106, 185, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204 };
    int[] arrayOfInt11 = { 220, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, 213, 136, 248, 180, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, 181, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186 };
    bTk = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, { 83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, 254, 225, 48, 90, 188 }, arrayOfInt7, { 52, 190, 88, 205, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, 193 }, { 211, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, 136, 120, 151, 233, 168, 93, 255 }, { 245, 127, 242, 218, 130, 250, 162, 181, 102, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, 225, 98, 81, 112 }, arrayOfInt8, { 245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, 188, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, 213, 92, 253, 225, 19 }, arrayOfInt9, arrayOfInt10, arrayOfInt11 };
    bTl = new int[256];
    bTm = new int['ÿ'];
    int j = 0;
    while (j < 255)
    {
      bTm[j] = i;
      bTl[i] = j;
      int k = i << 1;
      i = k;
      if (k >= 256) {
        i = k ^ 0x12D;
      }
      j += 1;
    }
  }
  
  private static String a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int k = 0;
    AppMethodBeat.i(12343);
    int i = 0;
    if (i < bTj.length) {
      if (bTj[i] != paramInt2) {}
    }
    for (;;)
    {
      if (i < 0)
      {
        paramCharSequence = new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(paramInt2)));
        AppMethodBeat.o(12343);
        throw paramCharSequence;
        i += 1;
        break;
      }
      int[] arrayOfInt = bTk[i];
      char[] arrayOfChar = new char[paramInt2];
      i = 0;
      while (i < paramInt2)
      {
        arrayOfChar[i] = '\000';
        i += 1;
      }
      i = 0;
      if (i < paramInt1 + 0)
      {
        int j = arrayOfChar[(paramInt2 - 1)];
        int m = paramCharSequence.charAt(i) ^ j;
        j = paramInt2 - 1;
        if (j > 0)
        {
          if ((m != 0) && (arrayOfInt[j] != 0)) {
            arrayOfChar[j] = ((char)(arrayOfChar[(j - 1)] ^ bTm[((bTl[m] + bTl[arrayOfInt[j]]) % 255)]));
          }
          for (;;)
          {
            j -= 1;
            break;
            arrayOfChar[j] = arrayOfChar[(j - 1)];
          }
        }
        if ((m != 0) && (arrayOfInt[0] != 0)) {
          arrayOfChar[0] = ((char)bTm[((bTl[m] + bTl[arrayOfInt[0]]) % 255)]);
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfChar[0] = '\000';
        }
      }
      paramCharSequence = new char[paramInt2];
      paramInt1 = k;
      while (paramInt1 < paramInt2)
      {
        paramCharSequence[paramInt1] = arrayOfChar[(paramInt2 - paramInt1 - 1)];
        paramInt1 += 1;
      }
      paramCharSequence = String.valueOf(paramCharSequence);
      AppMethodBeat.o(12343);
      return paramCharSequence;
      i = -1;
    }
  }
  
  public static String a(String paramString, k paramk)
  {
    AppMethodBeat.i(12341);
    if (paramString.length() != paramk.bTq)
    {
      paramString = new IllegalArgumentException("The number of codewords does not match the selected symbol");
      AppMethodBeat.o(12341);
      throw paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramk.bTq + paramk.bTr);
    localStringBuilder.append(paramString);
    int m = paramk.zu();
    if (m == 1) {
      localStringBuilder.append(c(paramString, paramk.bTr));
    }
    for (;;)
    {
      paramString = localStringBuilder.toString();
      AppMethodBeat.o(12341);
      return paramString;
      localStringBuilder.setLength(localStringBuilder.capacity());
      int[] arrayOfInt1 = new int[m];
      int[] arrayOfInt2 = new int[m];
      Object localObject = new int[m];
      int i = 0;
      while (i < m)
      {
        arrayOfInt1[i] = paramk.fW(i + 1);
        arrayOfInt2[i] = paramk.bTw;
        localObject[i] = 0;
        if (i > 0) {
          localObject[i] = (localObject[(i - 1)] + arrayOfInt1[i]);
        }
        i += 1;
      }
      i = 0;
      while (i < m)
      {
        localObject = new StringBuilder(arrayOfInt1[i]);
        int j = i;
        while (j < paramk.bTq)
        {
          ((StringBuilder)localObject).append(paramString.charAt(j));
          j += m;
        }
        localObject = c(((StringBuilder)localObject).toString(), arrayOfInt2[i]);
        int k = i;
        j = 0;
        while (k < arrayOfInt2[i] * m)
        {
          localStringBuilder.setCharAt(paramk.bTq + k, ((String)localObject).charAt(j));
          k += m;
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  private static String c(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(12342);
    paramCharSequence = a(paramCharSequence, paramCharSequence.length(), paramInt);
    AppMethodBeat.o(12342);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.c.c.a.i
 * JD-Core Version:    0.7.0.1
 */