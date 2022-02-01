package com.google.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  private static final Map<Integer, c> ceE;
  private static final Map<String, c> ceF;
  public final int[] ceG;
  private final String[] ceH;
  
  static
  {
    AppMethodBeat.i(12210);
    ced = new c("Cp437", 0, new int[] { 0, 2 }, new String[0]);
    cee = new c("ISO8859_1", 1, new int[] { 1, 3 }, new String[] { "ISO-8859-1" });
    cef = new c("ISO8859_2", 2, 4, new String[] { "ISO-8859-2" });
    ceg = new c("ISO8859_3", 3, 5, new String[] { "ISO-8859-3" });
    ceh = new c("ISO8859_4", 4, 6, new String[] { "ISO-8859-4" });
    cei = new c("ISO8859_5", 5, 7, new String[] { "ISO-8859-5" });
    cej = new c("ISO8859_6", 6, 8, new String[] { "ISO-8859-6" });
    cek = new c("ISO8859_7", 7, 9, new String[] { "ISO-8859-7" });
    cel = new c("ISO8859_8", 8, 10, new String[] { "ISO-8859-8" });
    cem = new c("ISO8859_9", 9, 11, new String[] { "ISO-8859-9" });
    cen = new c("ISO8859_10", 10, 12, new String[] { "ISO-8859-10" });
    ceo = new c("ISO8859_11", 11, 13, new String[] { "ISO-8859-11" });
    cep = new c("ISO8859_13", 12, 15, new String[] { "ISO-8859-13" });
    ceq = new c("ISO8859_14", 13, 16, new String[] { "ISO-8859-14" });
    cer = new c("ISO8859_15", 14, 17, new String[] { "ISO-8859-15" });
    ces = new c("ISO8859_16", 15, 18, new String[] { "ISO-8859-16" });
    cet = new c("SJIS", 16, 20, new String[] { "Shift_JIS" });
    ceu = new c("Cp1250", 17, 21, new String[] { "windows-1250" });
    cev = new c("Cp1251", 18, 22, new String[] { "windows-1251" });
    cew = new c("Cp1252", 19, 23, new String[] { "windows-1252" });
    cex = new c("Cp1256", 20, 24, new String[] { "windows-1256" });
    cey = new c("UnicodeBigUnmarked", 21, 25, new String[] { "UTF-16BE", "UnicodeBig" });
    cez = new c("UTF8", 22, 26, new String[] { "UTF-8" });
    ceA = new c("ASCII", 23, new int[] { 27, 170 }, new String[] { "US-ASCII" });
    ceB = new c("Big5");
    ceC = new c("GB18030", 25, 29, new String[] { "GB2312", "EUC_CN", "GBK" });
    ceD = new c("EUC_KR", 26, 30, new String[] { "EUC-KR" });
    ceI = new c[] { ced, cee, cef, ceg, ceh, cei, cej, cek, cel, cem, cen, ceo, cep, ceq, cer, ces, cet, ceu, cev, cew, cex, cey, cez, ceA, ceB, ceC, ceD };
    ceE = new HashMap();
    ceF = new HashMap();
    c[] arrayOfc = values();
    int k = arrayOfc.length;
    int i = 0;
    while (i < k)
    {
      c localc = arrayOfc[i];
      Object localObject1 = localc.ceG;
      int m = localObject1.length;
      int j = 0;
      while (j < m)
      {
        int n = localObject1[j];
        ceE.put(Integer.valueOf(n), localc);
        j += 1;
      }
      ceF.put(localc.name(), localc);
      localObject1 = localc.ceH;
      m = localObject1.length;
      j = 0;
      while (j < m)
      {
        Object localObject2 = localObject1[j];
        ceF.put(localObject2, localc);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(12210);
  }
  
  private c()
  {
    this(new int[] { 28 }, new String[0]);
    AppMethodBeat.i(12207);
    AppMethodBeat.o(12207);
  }
  
  private c(int paramInt, String... paramVarArgs)
  {
    AppMethodBeat.i(12208);
    this.ceG = new int[] { paramInt };
    this.ceH = paramVarArgs;
    AppMethodBeat.o(12208);
  }
  
  private c(int[] paramArrayOfInt, String... paramVarArgs)
  {
    this.ceG = paramArrayOfInt;
    this.ceH = paramVarArgs;
  }
  
  public static c cL(String paramString)
  {
    AppMethodBeat.i(12209);
    paramString = (c)ceF.get(paramString);
    AppMethodBeat.o(12209);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.c.b.c
 * JD-Core Version:    0.7.0.1
 */