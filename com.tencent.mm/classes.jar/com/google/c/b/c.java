package com.google.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  private static final Map<Integer, c> bSC;
  private static final Map<String, c> bSD;
  public final int[] bSE;
  private final String[] bSF;
  
  static
  {
    AppMethodBeat.i(12210);
    bSb = new c("Cp437", 0, new int[] { 0, 2 }, new String[0]);
    bSc = new c("ISO8859_1", 1, new int[] { 1, 3 }, new String[] { "ISO-8859-1" });
    bSd = new c("ISO8859_2", 2, 4, new String[] { "ISO-8859-2" });
    bSe = new c("ISO8859_3", 3, 5, new String[] { "ISO-8859-3" });
    bSf = new c("ISO8859_4", 4, 6, new String[] { "ISO-8859-4" });
    bSg = new c("ISO8859_5", 5, 7, new String[] { "ISO-8859-5" });
    bSh = new c("ISO8859_6", 6, 8, new String[] { "ISO-8859-6" });
    bSi = new c("ISO8859_7", 7, 9, new String[] { "ISO-8859-7" });
    bSj = new c("ISO8859_8", 8, 10, new String[] { "ISO-8859-8" });
    bSk = new c("ISO8859_9", 9, 11, new String[] { "ISO-8859-9" });
    bSl = new c("ISO8859_10", 10, 12, new String[] { "ISO-8859-10" });
    bSm = new c("ISO8859_11", 11, 13, new String[] { "ISO-8859-11" });
    bSn = new c("ISO8859_13", 12, 15, new String[] { "ISO-8859-13" });
    bSo = new c("ISO8859_14", 13, 16, new String[] { "ISO-8859-14" });
    bSp = new c("ISO8859_15", 14, 17, new String[] { "ISO-8859-15" });
    bSq = new c("ISO8859_16", 15, 18, new String[] { "ISO-8859-16" });
    bSr = new c("SJIS", 16, 20, new String[] { "Shift_JIS" });
    bSs = new c("Cp1250", 17, 21, new String[] { "windows-1250" });
    bSt = new c("Cp1251", 18, 22, new String[] { "windows-1251" });
    bSu = new c("Cp1252", 19, 23, new String[] { "windows-1252" });
    bSv = new c("Cp1256", 20, 24, new String[] { "windows-1256" });
    bSw = new c("UnicodeBigUnmarked", 21, 25, new String[] { "UTF-16BE", "UnicodeBig" });
    bSx = new c("UTF8", 22, 26, new String[] { "UTF-8" });
    bSy = new c("ASCII", 23, new int[] { 27, 170 }, new String[] { "US-ASCII" });
    bSz = new c("Big5");
    bSA = new c("GB18030", 25, 29, new String[] { "GB2312", "EUC_CN", "GBK" });
    bSB = new c("EUC_KR", 26, 30, new String[] { "EUC-KR" });
    bSG = new c[] { bSb, bSc, bSd, bSe, bSf, bSg, bSh, bSi, bSj, bSk, bSl, bSm, bSn, bSo, bSp, bSq, bSr, bSs, bSt, bSu, bSv, bSw, bSx, bSy, bSz, bSA, bSB };
    bSC = new HashMap();
    bSD = new HashMap();
    c[] arrayOfc = values();
    int k = arrayOfc.length;
    int i = 0;
    while (i < k)
    {
      c localc = arrayOfc[i];
      Object localObject1 = localc.bSE;
      int m = localObject1.length;
      int j = 0;
      while (j < m)
      {
        int n = localObject1[j];
        bSC.put(Integer.valueOf(n), localc);
        j += 1;
      }
      bSD.put(localc.name(), localc);
      localObject1 = localc.bSF;
      m = localObject1.length;
      j = 0;
      while (j < m)
      {
        Object localObject2 = localObject1[j];
        bSD.put(localObject2, localc);
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
    this.bSE = new int[] { paramInt };
    this.bSF = paramVarArgs;
    AppMethodBeat.o(12208);
  }
  
  private c(int[] paramArrayOfInt, String... paramVarArgs)
  {
    this.bSE = paramArrayOfInt;
    this.bSF = paramVarArgs;
  }
  
  public static c ce(String paramString)
  {
    AppMethodBeat.i(12209);
    paramString = (c)bSD.get(paramString);
    AppMethodBeat.o(12209);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.c.b.c
 * JD-Core Version:    0.7.0.1
 */