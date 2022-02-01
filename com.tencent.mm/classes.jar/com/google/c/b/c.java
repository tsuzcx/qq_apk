package com.google.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  private static final Map<Integer, c> bIo;
  private static final Map<String, c> bIp;
  public final int[] bIq;
  private final String[] bIr;
  
  static
  {
    AppMethodBeat.i(12210);
    bHN = new c("Cp437", 0, new int[] { 0, 2 }, new String[0]);
    bHO = new c("ISO8859_1", 1, new int[] { 1, 3 }, new String[] { "ISO-8859-1" });
    bHP = new c("ISO8859_2", 2, 4, new String[] { "ISO-8859-2" });
    bHQ = new c("ISO8859_3", 3, 5, new String[] { "ISO-8859-3" });
    bHR = new c("ISO8859_4", 4, 6, new String[] { "ISO-8859-4" });
    bHS = new c("ISO8859_5", 5, 7, new String[] { "ISO-8859-5" });
    bHT = new c("ISO8859_6", 6, 8, new String[] { "ISO-8859-6" });
    bHU = new c("ISO8859_7", 7, 9, new String[] { "ISO-8859-7" });
    bHV = new c("ISO8859_8", 8, 10, new String[] { "ISO-8859-8" });
    bHW = new c("ISO8859_9", 9, 11, new String[] { "ISO-8859-9" });
    bHX = new c("ISO8859_10", 10, 12, new String[] { "ISO-8859-10" });
    bHY = new c("ISO8859_11", 11, 13, new String[] { "ISO-8859-11" });
    bHZ = new c("ISO8859_13", 12, 15, new String[] { "ISO-8859-13" });
    bIa = new c("ISO8859_14", 13, 16, new String[] { "ISO-8859-14" });
    bIb = new c("ISO8859_15", 14, 17, new String[] { "ISO-8859-15" });
    bIc = new c("ISO8859_16", 15, 18, new String[] { "ISO-8859-16" });
    bId = new c("SJIS", 16, 20, new String[] { "Shift_JIS" });
    bIe = new c("Cp1250", 17, 21, new String[] { "windows-1250" });
    bIf = new c("Cp1251", 18, 22, new String[] { "windows-1251" });
    bIg = new c("Cp1252", 19, 23, new String[] { "windows-1252" });
    bIh = new c("Cp1256", 20, 24, new String[] { "windows-1256" });
    bIi = new c("UnicodeBigUnmarked", 21, 25, new String[] { "UTF-16BE", "UnicodeBig" });
    bIj = new c("UTF8", 22, 26, new String[] { "UTF-8" });
    bIk = new c("ASCII", 23, new int[] { 27, 170 }, new String[] { "US-ASCII" });
    bIl = new c("Big5");
    bIm = new c("GB18030", 25, 29, new String[] { "GB2312", "EUC_CN", "GBK" });
    bIn = new c("EUC_KR", 26, 30, new String[] { "EUC-KR" });
    bIs = new c[] { bHN, bHO, bHP, bHQ, bHR, bHS, bHT, bHU, bHV, bHW, bHX, bHY, bHZ, bIa, bIb, bIc, bId, bIe, bIf, bIg, bIh, bIi, bIj, bIk, bIl, bIm, bIn };
    bIo = new HashMap();
    bIp = new HashMap();
    c[] arrayOfc = values();
    int k = arrayOfc.length;
    int i = 0;
    while (i < k)
    {
      c localc = arrayOfc[i];
      Object localObject1 = localc.bIq;
      int m = localObject1.length;
      int j = 0;
      while (j < m)
      {
        int n = localObject1[j];
        bIo.put(Integer.valueOf(n), localc);
        j += 1;
      }
      bIp.put(localc.name(), localc);
      localObject1 = localc.bIr;
      m = localObject1.length;
      j = 0;
      while (j < m)
      {
        Object localObject2 = localObject1[j];
        bIp.put(localObject2, localc);
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
    this.bIq = new int[] { paramInt };
    this.bIr = paramVarArgs;
    AppMethodBeat.o(12208);
  }
  
  private c(int[] paramArrayOfInt, String... paramVarArgs)
  {
    this.bIq = paramArrayOfInt;
    this.bIr = paramVarArgs;
  }
  
  public static c bl(String paramString)
  {
    AppMethodBeat.i(12209);
    paramString = (c)bIp.get(paramString);
    AppMethodBeat.o(12209);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.c.b.c
 * JD-Core Version:    0.7.0.1
 */