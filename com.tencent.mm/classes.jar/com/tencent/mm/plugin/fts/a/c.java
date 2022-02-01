package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class c
{
  public static final int[] wUC;
  public static final int[] wUD;
  public static final int[] wUE;
  public static final int[] wUF;
  public static final int[] wUG;
  public static final int[] wUH;
  public static final int[] wUI;
  public static final int[] wUJ;
  public static final int[] wUK;
  public static final int[] wUL;
  public static final int[] wUM;
  public static final int[] wUN;
  public static final int[] wUO;
  public static final int[] wUP;
  public static final Map<Integer, Integer> wUQ;
  public static final int[] wUR;
  public static final int[] wUS;
  public static final int[] wUT;
  public static final int[] wUU;
  public static final int[] wUV;
  public static final int[] wUW;
  public static final String wUX;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(131619);
    wUC = new int[] { 65536 };
    wUD = new int[] { 196608 };
    wUE = new int[] { 262144 };
    wUF = new int[] { 327680 };
    wUG = new int[] { 393216 };
    wUH = new int[] { 458752 };
    wUI = new int[] { 131073, 131074 };
    wUJ = new int[] { 131072, 131075, 131076, 131081 };
    wUK = new int[] { 131072, 131075, 131076, 131081 };
    wUL = new int[] { 131072 };
    wUM = new int[] { 131073, 131074 };
    wUN = new int[] { 131077, 131078 };
    wUO = new int[] { 131079, 131080 };
    wUP = new int[] { 5, 6, 7, 1, 2, 3 };
    wUR = new int[] { 2, 3, 6, 7 };
    wUS = new int[] { 29, 30, 31, 34, 35, 36, 33, 32, 37 };
    Object localObject = new int[3];
    Object tmp317_316 = localObject;
    tmp317_316[0] = 8;
    Object tmp322_317 = tmp317_316;
    tmp322_317[1] = 9;
    Object tmp327_322 = tmp322_317;
    tmp327_322[2] = 10;
    tmp327_322;
    wUT = (int[])localObject;
    wUU = (int[])localObject;
    localObject = new HashMap();
    int i = 0;
    while (i < 9)
    {
      ((HashMap)localObject).put(Integer.valueOf(new int[] { 131072, 131073, 131074, 131075, 131076, 131077, 131078, 131079, 131080 }[i]), Integer.valueOf(i));
      i += 1;
    }
    wUQ = Collections.unmodifiableMap((Map)localObject);
    wUV = new int[43];
    i = 0;
    while (i < 43)
    {
      wUV[new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 17, 18, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 0 }[i]] = i;
      i += 1;
    }
    wUW = new int[27];
    i = j;
    while (i < 27)
    {
      wUW[new int[] { 1, 2, 3, 4, 5, 6, 8, 19, 20, 21, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 7, 0 }[i]] = i;
      i += 1;
    }
    wUX = b.aKJ() + "fts/";
    AppMethodBeat.o(131619);
  }
  
  public static final class a
  {
    public static final Pattern wUY;
    public static final Pattern wUZ;
    public static final Pattern wVa;
    public static final Pattern wVb;
    public static final Pattern wVc;
    public static final Pattern wVd;
    public static final Pattern wVe;
    public static final Pattern wVf;
    public static final Pattern wVg;
    
    static
    {
      AppMethodBeat.i(131618);
      wUY = Pattern.compile(";");
      wUZ = Pattern.compile(" ");
      wVa = Pattern.compile("​");
      wVb = Pattern.compile("‌");
      Pattern localPattern = Pattern.compile("‍");
      wVc = localPattern;
      wVd = localPattern;
      wVe = Pattern.compile("\\s+");
      wVf = Pattern.compile(",");
      wVg = Pattern.compile("[A-Za-z]+");
      AppMethodBeat.o(131618);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.c
 * JD-Core Version:    0.7.0.1
 */