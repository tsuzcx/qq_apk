package com.google.android.exoplayer2.source.dash.manifest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class j
{
  private final String[] boA;
  private final int[] boB;
  private final String[] boC;
  private final int boD;
  
  private j(String[] paramArrayOfString1, int[] paramArrayOfInt, String[] paramArrayOfString2, int paramInt)
  {
    this.boA = paramArrayOfString1;
    this.boB = paramArrayOfInt;
    this.boC = paramArrayOfString2;
    this.boD = paramInt;
  }
  
  private static int a(String paramString, String[] paramArrayOfString1, int[] paramArrayOfInt, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(10578);
    paramArrayOfString1[0] = "";
    int j = 0;
    int i = 0;
    while (i < paramString.length())
    {
      int k = paramString.indexOf("$", i);
      if (k == -1)
      {
        paramArrayOfString1[j] = (paramArrayOfString1[j] + paramString.substring(i));
        i = paramString.length();
      }
      else if (k != i)
      {
        paramArrayOfString1[j] = (paramArrayOfString1[j] + paramString.substring(i, k));
        i = k;
      }
      else if (paramString.startsWith("$$", i))
      {
        paramArrayOfString1[j] = (paramArrayOfString1[j] + "$");
        i += 2;
      }
      else
      {
        k = paramString.indexOf("$", i + 1);
        String str2 = paramString.substring(i + 1, k);
        if (str2.equals("RepresentationID"))
        {
          paramArrayOfInt[j] = 1;
          j += 1;
          paramArrayOfString1[j] = "";
          i = k + 1;
        }
        else
        {
          i = str2.indexOf("%0");
          Object localObject = "%01d";
          String str1 = str2;
          if (i != -1)
          {
            str1 = str2.substring(i);
            localObject = str1;
            if (!str1.endsWith("d")) {
              localObject = str1 + "d";
            }
            str1 = str2.substring(0, i);
          }
          switch (str1.hashCode())
          {
          default: 
            label352:
            i = -1;
          }
          for (;;)
          {
            switch (i)
            {
            default: 
              paramString = new IllegalArgumentException("Invalid template: ".concat(String.valueOf(paramString)));
              AppMethodBeat.o(10578);
              throw paramString;
              if (!str1.equals("Number")) {
                break label352;
              }
              i = 0;
              continue;
              if (!str1.equals("Bandwidth")) {
                break label352;
              }
              i = 1;
              continue;
              if (!str1.equals("Time")) {
                break label352;
              }
              i = 2;
            }
          }
          paramArrayOfInt[j] = 2;
          for (;;)
          {
            paramArrayOfString2[j] = localObject;
            break;
            paramArrayOfInt[j] = 3;
            continue;
            paramArrayOfInt[j] = 4;
          }
        }
      }
    }
    AppMethodBeat.o(10578);
    return j;
  }
  
  public static j ar(String paramString)
  {
    AppMethodBeat.i(10576);
    String[] arrayOfString1 = new String[5];
    int[] arrayOfInt = new int[4];
    String[] arrayOfString2 = new String[4];
    paramString = new j(arrayOfString1, arrayOfInt, arrayOfString2, a(paramString, arrayOfString1, arrayOfInt, arrayOfString2));
    AppMethodBeat.o(10576);
    return paramString;
  }
  
  public final String a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(10577);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < this.boD)
    {
      localStringBuilder.append(this.boA[i]);
      if (this.boB[i] == 1) {
        localStringBuilder.append(paramString);
      }
      for (;;)
      {
        i += 1;
        break;
        if (this.boB[i] == 2) {
          localStringBuilder.append(String.format(Locale.US, this.boC[i], new Object[] { Integer.valueOf(paramInt1) }));
        } else if (this.boB[i] == 3) {
          localStringBuilder.append(String.format(Locale.US, this.boC[i], new Object[] { Integer.valueOf(paramInt2) }));
        } else if (this.boB[i] == 4) {
          localStringBuilder.append(String.format(Locale.US, this.boC[i], new Object[] { Long.valueOf(paramLong) }));
        }
      }
    }
    localStringBuilder.append(this.boA[this.boD]);
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(10577);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.source.dash.manifest.j
 * JD-Core Version:    0.7.0.1
 */