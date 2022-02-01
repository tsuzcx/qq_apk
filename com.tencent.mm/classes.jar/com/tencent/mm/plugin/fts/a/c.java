package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class c
{
  public static final int[] tDD;
  public static final int[] tDE;
  public static final int[] tDF;
  public static final int[] tDG;
  public static final int[] tDH;
  public static final int[] tDI;
  public static final int[] tDJ;
  public static final int[] tDK;
  public static final int[] tDL;
  public static final int[] tDM;
  public static final int[] tDN;
  public static final int[] tDO;
  public static final int[] tDP;
  public static final int[] tDQ;
  public static final Map<Integer, Integer> tDR;
  public static final int[] tDS;
  public static final int[] tDT;
  public static final int[] tDU;
  public static final int[] tDV;
  public static final int[] tDW;
  public static final int[] tDX;
  public static final String tDY;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(131619);
    tDD = new int[] { 65536 };
    tDE = new int[] { 196608 };
    tDF = new int[] { 262144 };
    tDG = new int[] { 327680 };
    tDH = new int[] { 393216 };
    tDI = new int[] { 458752 };
    tDJ = new int[] { 131073, 131074 };
    tDK = new int[] { 131072, 131075, 131076, 131081 };
    tDL = new int[] { 131072, 131075, 131076, 131081 };
    tDM = new int[] { 131072 };
    tDN = new int[] { 131073, 131074 };
    tDO = new int[] { 131077, 131078 };
    tDP = new int[] { 131079, 131080 };
    tDQ = new int[] { 5, 6, 7, 1, 2, 3 };
    tDS = new int[] { 2, 3, 6, 7 };
    tDT = new int[] { 29, 30, 31, 34, 35, 36, 33, 32, 37 };
    Object localObject = new int[3];
    Object tmp317_316 = localObject;
    tmp317_316[0] = 8;
    Object tmp322_317 = tmp317_316;
    tmp322_317[1] = 9;
    Object tmp327_322 = tmp322_317;
    tmp327_322[2] = 10;
    tmp327_322;
    tDU = (int[])localObject;
    tDV = (int[])localObject;
    localObject = new HashMap();
    int i = 0;
    while (i < 9)
    {
      ((HashMap)localObject).put(Integer.valueOf(new int[] { 131072, 131073, 131074, 131075, 131076, 131077, 131078, 131079, 131080 }[i]), Integer.valueOf(i));
      i += 1;
    }
    tDR = Collections.unmodifiableMap((Map)localObject);
    tDW = new int[43];
    i = 0;
    while (i < 43)
    {
      tDW[new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 17, 18, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 0 }[i]] = i;
      i += 1;
    }
    tDX = new int[27];
    i = j;
    while (i < 27)
    {
      tDX[new int[] { 1, 2, 3, 4, 5, 6, 8, 19, 20, 21, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 7, 0 }[i]] = i;
      i += 1;
    }
    tDY = b.asj() + "fts/";
    AppMethodBeat.o(131619);
  }
  
  public static final class a
  {
    public static final Pattern tDZ;
    public static final Pattern tEa;
    public static final Pattern tEb;
    public static final Pattern tEc;
    public static final Pattern tEd;
    public static final Pattern tEe;
    public static final Pattern tEf;
    public static final Pattern tEg;
    public static final Pattern tEh;
    
    static
    {
      AppMethodBeat.i(131618);
      tDZ = Pattern.compile(";");
      tEa = Pattern.compile(" ");
      tEb = Pattern.compile("​");
      tEc = Pattern.compile("‌");
      Pattern localPattern = Pattern.compile("‍");
      tEd = localPattern;
      tEe = localPattern;
      tEf = Pattern.compile("\\s+");
      tEg = Pattern.compile(",");
      tEh = Pattern.compile("[A-Za-z]+");
      AppMethodBeat.o(131618);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.c
 * JD-Core Version:    0.7.0.1
 */