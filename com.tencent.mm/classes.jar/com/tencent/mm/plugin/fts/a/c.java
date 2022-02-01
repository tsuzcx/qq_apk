package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class c
{
  public static final int[] rnA;
  public static final int[] rnB;
  public static final int[] rnC;
  public static final int[] rnD;
  public static final int[] rnE;
  public static final Map<Integer, Integer> rnF;
  public static final int[] rnG;
  public static final int[] rnH;
  public static final int[] rnI;
  public static final int[] rnJ;
  public static final int[] rnK;
  public static final int[] rnL;
  public static final String rnM;
  public static final int[] rnr;
  public static final int[] rns;
  public static final int[] rnt;
  public static final int[] rnu;
  public static final int[] rnv;
  public static final int[] rnw;
  public static final int[] rnx;
  public static final int[] rny;
  public static final int[] rnz;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(131619);
    rnr = new int[] { 65536 };
    rns = new int[] { 196608 };
    rnt = new int[] { 262144 };
    rnu = new int[] { 327680 };
    rnv = new int[] { 393216 };
    rnw = new int[] { 458752 };
    rnx = new int[] { 131073, 131074 };
    rny = new int[] { 131072, 131075, 131076, 131081 };
    rnz = new int[] { 131072, 131075, 131076, 131081 };
    rnA = new int[] { 131072 };
    rnB = new int[] { 131073, 131074 };
    rnC = new int[] { 131077, 131078 };
    rnD = new int[] { 131079, 131080 };
    rnE = new int[] { 5, 6, 7, 1, 2, 3 };
    rnG = new int[] { 2, 3, 6, 7 };
    rnH = new int[] { 29, 30, 31, 34, 35, 36, 33, 32, 37 };
    Object localObject = new int[3];
    Object tmp317_316 = localObject;
    tmp317_316[0] = 8;
    Object tmp322_317 = tmp317_316;
    tmp322_317[1] = 9;
    Object tmp327_322 = tmp322_317;
    tmp327_322[2] = 10;
    tmp327_322;
    rnI = (int[])localObject;
    rnJ = (int[])localObject;
    localObject = new HashMap();
    int i = 0;
    while (i < 9)
    {
      ((HashMap)localObject).put(Integer.valueOf(new int[] { 131072, 131073, 131074, 131075, 131076, 131077, 131078, 131079, 131080 }[i]), Integer.valueOf(i));
      i += 1;
    }
    rnF = Collections.unmodifiableMap((Map)localObject);
    rnK = new int[43];
    i = 0;
    while (i < 43)
    {
      rnK[new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 17, 18, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 0 }[i]] = i;
      i += 1;
    }
    rnL = new int[27];
    i = j;
    while (i < 27)
    {
      rnL[new int[] { 1, 2, 3, 4, 5, 6, 8, 19, 20, 21, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 7, 0 }[i]] = i;
      i += 1;
    }
    rnM = b.aih() + "fts/";
    AppMethodBeat.o(131619);
  }
  
  public static final class a
  {
    public static final Pattern rnN;
    public static final Pattern rnO;
    public static final Pattern rnP;
    public static final Pattern rnQ;
    public static final Pattern rnR;
    public static final Pattern rnS;
    public static final Pattern rnT;
    public static final Pattern rnU;
    public static final Pattern rnV;
    
    static
    {
      AppMethodBeat.i(131618);
      rnN = Pattern.compile(";");
      rnO = Pattern.compile(" ");
      rnP = Pattern.compile("​");
      rnQ = Pattern.compile("‌");
      Pattern localPattern = Pattern.compile("‍");
      rnR = localPattern;
      rnS = localPattern;
      rnT = Pattern.compile("\\s+");
      rnU = Pattern.compile(",");
      rnV = Pattern.compile("[A-Za-z]+");
      AppMethodBeat.o(131618);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.c
 * JD-Core Version:    0.7.0.1
 */