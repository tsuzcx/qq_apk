package com.google.android.exoplayer2.i;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
{
  private static String a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93214);
    if (paramInt1 >= paramInt2)
    {
      paramStringBuilder = paramStringBuilder.toString();
      AppMethodBeat.o(93214);
      return paramStringBuilder;
    }
    int i = paramInt1;
    if (paramStringBuilder.charAt(paramInt1) == '/') {
      i = paramInt1 + 1;
    }
    paramInt1 = i;
    int k = i;
    int j = paramInt2;
    paramInt2 = k;
    while (paramInt1 <= j)
    {
      if (paramInt1 == j) {
        k = paramInt1;
      }
      for (;;)
      {
        if ((paramInt1 == paramInt2 + 1) && (paramStringBuilder.charAt(paramInt2) == '.'))
        {
          paramStringBuilder.delete(paramInt2, k);
          j -= k - paramInt2;
          paramInt1 = paramInt2;
          break;
          if (paramStringBuilder.charAt(paramInt1) == '/')
          {
            k = paramInt1 + 1;
          }
          else
          {
            paramInt1 += 1;
            break;
          }
        }
      }
      if ((paramInt1 == paramInt2 + 2) && (paramStringBuilder.charAt(paramInt2) == '.') && (paramStringBuilder.charAt(paramInt2 + 1) == '.'))
      {
        paramInt1 = paramStringBuilder.lastIndexOf("/", paramInt2 - 2) + 1;
        if (paramInt1 > i) {}
        for (paramInt2 = paramInt1;; paramInt2 = i)
        {
          paramStringBuilder.delete(paramInt2, k);
          k = j - (k - paramInt2);
          paramInt2 = paramInt1;
          j = paramInt1;
          paramInt1 = paramInt2;
          paramInt2 = j;
          j = k;
          break;
        }
      }
      paramInt2 = paramInt1 + 1;
      paramInt1 = paramInt2;
    }
    paramStringBuilder = paramStringBuilder.toString();
    AppMethodBeat.o(93214);
    return paramStringBuilder;
  }
  
  private static int[] bD(String paramString)
  {
    AppMethodBeat.i(93215);
    int[] arrayOfInt = new int[4];
    if (TextUtils.isEmpty(paramString))
    {
      arrayOfInt[0] = -1;
      AppMethodBeat.o(93215);
      return arrayOfInt;
    }
    int j = paramString.length();
    int i = paramString.indexOf('#');
    if (i == -1) {}
    for (;;)
    {
      int k = paramString.indexOf('?');
      if (k != -1)
      {
        i = k;
        if (k <= j) {}
      }
      else
      {
        i = j;
      }
      int m = paramString.indexOf('/');
      if (m != -1)
      {
        k = m;
        if (m <= i) {}
      }
      else
      {
        k = i;
      }
      int n = paramString.indexOf(':');
      m = n;
      if (n > k) {
        m = -1;
      }
      if ((m + 2 < i) && (paramString.charAt(m + 1) == '/') && (paramString.charAt(m + 2) == '/'))
      {
        k = 1;
        if (k == 0) {
          break label217;
        }
        n = paramString.indexOf('/', m + 3);
        if (n != -1)
        {
          k = n;
          if (n <= i) {
            break label183;
          }
        }
      }
      label183:
      label217:
      for (k = i;; k = m + 1)
      {
        arrayOfInt[0] = m;
        arrayOfInt[1] = k;
        arrayOfInt[2] = i;
        arrayOfInt[3] = j;
        AppMethodBeat.o(93215);
        return arrayOfInt;
        k = 0;
        break;
      }
      j = i;
    }
  }
  
  public static Uri m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(93212);
    paramString1 = Uri.parse(n(paramString1, paramString2));
    AppMethodBeat.o(93212);
    return paramString1;
  }
  
  private static String n(String paramString1, String paramString2)
  {
    AppMethodBeat.i(93213);
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString2 = bD(paramString1);
    if (paramString2[0] != -1)
    {
      localStringBuilder.append(paramString1);
      a(localStringBuilder, paramString2[1], paramString2[2]);
      paramString1 = localStringBuilder.toString();
      AppMethodBeat.o(93213);
      return paramString1;
    }
    int[] arrayOfInt = bD(str);
    if (paramString2[3] == 0)
    {
      paramString1 = paramString1;
      AppMethodBeat.o(93213);
      return paramString1;
    }
    if (paramString2[2] == 0)
    {
      paramString1 = paramString1;
      AppMethodBeat.o(93213);
      return paramString1;
    }
    if (paramString2[1] != 0)
    {
      i = arrayOfInt[0] + 1;
      localStringBuilder.append(str, 0, i).append(paramString1);
      paramString1 = a(localStringBuilder, paramString2[1] + i, i + paramString2[2]);
      AppMethodBeat.o(93213);
      return paramString1;
    }
    int j;
    if (paramString1.charAt(paramString2[1]) == '/')
    {
      localStringBuilder.append(str, 0, arrayOfInt[1]).append(paramString1);
      i = arrayOfInt[1];
      j = arrayOfInt[1];
      paramString1 = a(localStringBuilder, i, paramString2[2] + j);
      AppMethodBeat.o(93213);
      return paramString1;
    }
    if ((arrayOfInt[0] + 2 < arrayOfInt[1]) && (arrayOfInt[1] == arrayOfInt[2]))
    {
      localStringBuilder.append(str, 0, arrayOfInt[1]).append('/').append(paramString1);
      i = arrayOfInt[1];
      j = arrayOfInt[1];
      paramString1 = a(localStringBuilder, i, paramString2[2] + j + 1);
      AppMethodBeat.o(93213);
      return paramString1;
    }
    int i = str.lastIndexOf('/', arrayOfInt[2] - 1);
    if (i == -1) {
      i = arrayOfInt[1];
    }
    for (;;)
    {
      localStringBuilder.append(str, 0, i).append(paramString1);
      paramString1 = a(localStringBuilder, arrayOfInt[1], i + paramString2[2]);
      AppMethodBeat.o(93213);
      return paramString1;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.i.w
 * JD-Core Version:    0.7.0.1
 */