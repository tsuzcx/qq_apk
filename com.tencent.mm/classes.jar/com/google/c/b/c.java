package com.google.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  private static final Map<Integer, c> bKG;
  private static final Map<String, c> bKH;
  public final int[] bKI;
  private final String[] bKJ;
  
  static
  {
    AppMethodBeat.i(12210);
    bKf = new c("Cp437", 0, new int[] { 0, 2 }, new String[0]);
    bKg = new c("ISO8859_1", 1, new int[] { 1, 3 }, new String[] { "ISO-8859-1" });
    bKh = new c("ISO8859_2", 2, 4, new String[] { "ISO-8859-2" });
    bKi = new c("ISO8859_3", 3, 5, new String[] { "ISO-8859-3" });
    bKj = new c("ISO8859_4", 4, 6, new String[] { "ISO-8859-4" });
    bKk = new c("ISO8859_5", 5, 7, new String[] { "ISO-8859-5" });
    bKl = new c("ISO8859_6", 6, 8, new String[] { "ISO-8859-6" });
    bKm = new c("ISO8859_7", 7, 9, new String[] { "ISO-8859-7" });
    bKn = new c("ISO8859_8", 8, 10, new String[] { "ISO-8859-8" });
    bKo = new c("ISO8859_9", 9, 11, new String[] { "ISO-8859-9" });
    bKp = new c("ISO8859_10", 10, 12, new String[] { "ISO-8859-10" });
    bKq = new c("ISO8859_11", 11, 13, new String[] { "ISO-8859-11" });
    bKr = new c("ISO8859_13", 12, 15, new String[] { "ISO-8859-13" });
    bKs = new c("ISO8859_14", 13, 16, new String[] { "ISO-8859-14" });
    bKt = new c("ISO8859_15", 14, 17, new String[] { "ISO-8859-15" });
    bKu = new c("ISO8859_16", 15, 18, new String[] { "ISO-8859-16" });
    bKv = new c("SJIS", 16, 20, new String[] { "Shift_JIS" });
    bKw = new c("Cp1250", 17, 21, new String[] { "windows-1250" });
    bKx = new c("Cp1251", 18, 22, new String[] { "windows-1251" });
    bKy = new c("Cp1252", 19, 23, new String[] { "windows-1252" });
    bKz = new c("Cp1256", 20, 24, new String[] { "windows-1256" });
    bKA = new c("UnicodeBigUnmarked", 21, 25, new String[] { "UTF-16BE", "UnicodeBig" });
    bKB = new c("UTF8", 22, 26, new String[] { "UTF-8" });
    bKC = new c("ASCII", 23, new int[] { 27, 170 }, new String[] { "US-ASCII" });
    bKD = new c("Big5");
    bKE = new c("GB18030", 25, 29, new String[] { "GB2312", "EUC_CN", "GBK" });
    bKF = new c("EUC_KR", 26, 30, new String[] { "EUC-KR" });
    bKK = new c[] { bKf, bKg, bKh, bKi, bKj, bKk, bKl, bKm, bKn, bKo, bKp, bKq, bKr, bKs, bKt, bKu, bKv, bKw, bKx, bKy, bKz, bKA, bKB, bKC, bKD, bKE, bKF };
    bKG = new HashMap();
    bKH = new HashMap();
    c[] arrayOfc = values();
    int k = arrayOfc.length;
    int i = 0;
    while (i < k)
    {
      c localc = arrayOfc[i];
      Object localObject1 = localc.bKI;
      int m = localObject1.length;
      int j = 0;
      while (j < m)
      {
        int n = localObject1[j];
        bKG.put(Integer.valueOf(n), localc);
        j += 1;
      }
      bKH.put(localc.name(), localc);
      localObject1 = localc.bKJ;
      m = localObject1.length;
      j = 0;
      while (j < m)
      {
        Object localObject2 = localObject1[j];
        bKH.put(localObject2, localc);
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
    this.bKI = new int[] { paramInt };
    this.bKJ = paramVarArgs;
    AppMethodBeat.o(12208);
  }
  
  private c(int[] paramArrayOfInt, String... paramVarArgs)
  {
    this.bKI = paramArrayOfInt;
    this.bKJ = paramVarArgs;
  }
  
  public static c bu(String paramString)
  {
    AppMethodBeat.i(12209);
    paramString = (c)bKH.get(paramString);
    AppMethodBeat.o(12209);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.b.c
 * JD-Core Version:    0.7.0.1
 */