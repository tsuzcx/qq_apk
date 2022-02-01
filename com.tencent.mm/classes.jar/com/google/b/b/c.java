package com.google.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  private static final Map<Integer, c> cdb;
  private static final Map<String, c> cdc;
  public final int[] cdd;
  private final String[] cde;
  
  static
  {
    AppMethodBeat.i(12210);
    ccA = new c("Cp437", 0, new int[] { 0, 2 }, new String[0]);
    ccB = new c("ISO8859_1", 1, new int[] { 1, 3 }, new String[] { "ISO-8859-1" });
    ccC = new c("ISO8859_2", 2, 4, new String[] { "ISO-8859-2" });
    ccD = new c("ISO8859_3", 3, 5, new String[] { "ISO-8859-3" });
    ccE = new c("ISO8859_4", 4, 6, new String[] { "ISO-8859-4" });
    ccF = new c("ISO8859_5", 5, 7, new String[] { "ISO-8859-5" });
    ccG = new c("ISO8859_6", 6, 8, new String[] { "ISO-8859-6" });
    ccH = new c("ISO8859_7", 7, 9, new String[] { "ISO-8859-7" });
    ccI = new c("ISO8859_8", 8, 10, new String[] { "ISO-8859-8" });
    ccJ = new c("ISO8859_9", 9, 11, new String[] { "ISO-8859-9" });
    ccK = new c("ISO8859_10", 10, 12, new String[] { "ISO-8859-10" });
    ccL = new c("ISO8859_11", 11, 13, new String[] { "ISO-8859-11" });
    ccM = new c("ISO8859_13", 12, 15, new String[] { "ISO-8859-13" });
    ccN = new c("ISO8859_14", 13, 16, new String[] { "ISO-8859-14" });
    ccO = new c("ISO8859_15", 14, 17, new String[] { "ISO-8859-15" });
    ccP = new c("ISO8859_16", 15, 18, new String[] { "ISO-8859-16" });
    ccQ = new c("SJIS", 16, 20, new String[] { "Shift_JIS" });
    ccR = new c("Cp1250", 17, 21, new String[] { "windows-1250" });
    ccS = new c("Cp1251", 18, 22, new String[] { "windows-1251" });
    ccT = new c("Cp1252", 19, 23, new String[] { "windows-1252" });
    ccU = new c("Cp1256", 20, 24, new String[] { "windows-1256" });
    ccV = new c("UnicodeBigUnmarked", 21, 25, new String[] { "UTF-16BE", "UnicodeBig" });
    ccW = new c("UTF8", 22, 26, new String[] { "UTF-8" });
    ccX = new c("ASCII", 23, new int[] { 27, 170 }, new String[] { "US-ASCII" });
    ccY = new c("Big5");
    ccZ = new c("GB18030", 25, 29, new String[] { "GB2312", "EUC_CN", "GBK" });
    cda = new c("EUC_KR", 26, 30, new String[] { "EUC-KR" });
    cdf = new c[] { ccA, ccB, ccC, ccD, ccE, ccF, ccG, ccH, ccI, ccJ, ccK, ccL, ccM, ccN, ccO, ccP, ccQ, ccR, ccS, ccT, ccU, ccV, ccW, ccX, ccY, ccZ, cda };
    cdb = new HashMap();
    cdc = new HashMap();
    c[] arrayOfc = values();
    int k = arrayOfc.length;
    int i = 0;
    while (i < k)
    {
      c localc = arrayOfc[i];
      Object localObject1 = localc.cdd;
      int m = localObject1.length;
      int j = 0;
      while (j < m)
      {
        int n = localObject1[j];
        cdb.put(Integer.valueOf(n), localc);
        j += 1;
      }
      cdc.put(localc.name(), localc);
      localObject1 = localc.cde;
      m = localObject1.length;
      j = 0;
      while (j < m)
      {
        Object localObject2 = localObject1[j];
        cdc.put(localObject2, localc);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(12210);
  }
  
  private c(int paramInt)
  {
    this(new int[] { 28 }, new String[0]);
    AppMethodBeat.i(12207);
    AppMethodBeat.o(12207);
  }
  
  private c(int paramInt, String... paramVarArgs)
  {
    AppMethodBeat.i(12208);
    this.cdd = new int[] { paramInt };
    this.cde = paramVarArgs;
    AppMethodBeat.o(12208);
  }
  
  private c(int[] paramArrayOfInt, String... paramVarArgs)
  {
    this.cdd = paramArrayOfInt;
    this.cde = paramVarArgs;
  }
  
  public static c cr(String paramString)
  {
    AppMethodBeat.i(12209);
    paramString = (c)cdc.get(paramString);
    AppMethodBeat.o(12209);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.b.b.c
 * JD-Core Version:    0.7.0.1
 */