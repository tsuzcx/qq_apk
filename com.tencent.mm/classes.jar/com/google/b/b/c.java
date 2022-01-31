package com.google.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  private static final Map<Integer, c> biM;
  private static final Map<String, c> biN;
  public final int[] biO;
  private final String[] biP;
  
  static
  {
    AppMethodBeat.i(57145);
    bil = new c("Cp437", 0, new int[] { 0, 2 }, new String[0]);
    bim = new c("ISO8859_1", 1, new int[] { 1, 3 }, new String[] { "ISO-8859-1" });
    bin = new c("ISO8859_2", 2, 4, new String[] { "ISO-8859-2" });
    bio = new c("ISO8859_3", 3, 5, new String[] { "ISO-8859-3" });
    bip = new c("ISO8859_4", 4, 6, new String[] { "ISO-8859-4" });
    biq = new c("ISO8859_5", 5, 7, new String[] { "ISO-8859-5" });
    bir = new c("ISO8859_6", 6, 8, new String[] { "ISO-8859-6" });
    bis = new c("ISO8859_7", 7, 9, new String[] { "ISO-8859-7" });
    bit = new c("ISO8859_8", 8, 10, new String[] { "ISO-8859-8" });
    biu = new c("ISO8859_9", 9, 11, new String[] { "ISO-8859-9" });
    biv = new c("ISO8859_10", 10, 12, new String[] { "ISO-8859-10" });
    biw = new c("ISO8859_11", 11, 13, new String[] { "ISO-8859-11" });
    bix = new c("ISO8859_13", 12, 15, new String[] { "ISO-8859-13" });
    biy = new c("ISO8859_14", 13, 16, new String[] { "ISO-8859-14" });
    biz = new c("ISO8859_15", 14, 17, new String[] { "ISO-8859-15" });
    biA = new c("ISO8859_16", 15, 18, new String[] { "ISO-8859-16" });
    biB = new c("SJIS", 16, 20, new String[] { "Shift_JIS" });
    biC = new c("Cp1250", 17, 21, new String[] { "windows-1250" });
    biD = new c("Cp1251", 18, 22, new String[] { "windows-1251" });
    biE = new c("Cp1252", 19, 23, new String[] { "windows-1252" });
    biF = new c("Cp1256", 20, 24, new String[] { "windows-1256" });
    biG = new c("UnicodeBigUnmarked", 21, 25, new String[] { "UTF-16BE", "UnicodeBig" });
    biH = new c("UTF8", 22, 26, new String[] { "UTF-8" });
    biI = new c("ASCII", 23, new int[] { 27, 170 }, new String[] { "US-ASCII" });
    biJ = new c("Big5");
    biK = new c("GB18030", 25, 29, new String[] { "GB2312", "EUC_CN", "GBK" });
    biL = new c("EUC_KR", 26, 30, new String[] { "EUC-KR" });
    biQ = new c[] { bil, bim, bin, bio, bip, biq, bir, bis, bit, biu, biv, biw, bix, biy, biz, biA, biB, biC, biD, biE, biF, biG, biH, biI, biJ, biK, biL };
    biM = new HashMap();
    biN = new HashMap();
    c[] arrayOfc = values();
    int k = arrayOfc.length;
    int i = 0;
    while (i < k)
    {
      c localc = arrayOfc[i];
      Object localObject1 = localc.biO;
      int m = localObject1.length;
      int j = 0;
      while (j < m)
      {
        int n = localObject1[j];
        biM.put(Integer.valueOf(n), localc);
        j += 1;
      }
      biN.put(localc.name(), localc);
      localObject1 = localc.biP;
      m = localObject1.length;
      j = 0;
      while (j < m)
      {
        Object localObject2 = localObject1[j];
        biN.put(localObject2, localc);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(57145);
  }
  
  private c(int paramInt)
  {
    this(new int[] { 28 }, new String[0]);
    AppMethodBeat.i(57142);
    AppMethodBeat.o(57142);
  }
  
  private c(int paramInt, String... paramVarArgs)
  {
    AppMethodBeat.i(57143);
    this.biO = new int[] { paramInt };
    this.biP = paramVarArgs;
    AppMethodBeat.o(57143);
  }
  
  private c(int[] paramArrayOfInt, String... paramVarArgs)
  {
    this.biO = paramArrayOfInt;
    this.biP = paramVarArgs;
  }
  
  public static c bh(String paramString)
  {
    AppMethodBeat.i(57144);
    paramString = (c)biN.get(paramString);
    AppMethodBeat.o(57144);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.b.b.c
 * JD-Core Version:    0.7.0.1
 */