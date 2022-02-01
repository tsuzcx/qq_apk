package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class c
{
  public static final int[] BGA;
  public static final int[] BGB;
  public static final int[] BGC;
  public static final int[] BGD;
  public static final int[] BGE;
  public static final int[] BGF;
  public static final int[] BGG;
  public static final int[] BGH;
  public static final int[] BGI;
  public static final int[] BGJ;
  public static final int[] BGK;
  public static final int[] BGL;
  public static final Map<Integer, Integer> BGM;
  public static final int[] BGN;
  public static final int[] BGO;
  public static final int[] BGP;
  public static final int[] BGQ;
  public static final int[] BGR;
  public static final int[] BGS;
  public static final String BGT;
  public static final int[] BGy;
  public static final int[] BGz;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(131619);
    BGy = new int[] { 65536 };
    BGz = new int[] { 196608 };
    BGA = new int[] { 262144 };
    BGB = new int[] { 327680 };
    BGC = new int[] { 393216 };
    BGD = new int[] { 458752 };
    BGE = new int[] { 131073, 131074 };
    BGF = new int[] { 131072, 131075, 131076, 131081 };
    BGG = new int[] { 131072, 131075, 131076, 131081 };
    BGH = new int[] { 131072 };
    BGI = new int[] { 131073, 131074 };
    BGJ = new int[] { 131077, 131078 };
    BGK = new int[] { 131079, 131080 };
    BGL = new int[] { 5, 6, 7, 1, 2, 3 };
    BGN = new int[] { 2, 3, 6, 7 };
    BGO = new int[] { 29, 30, 31, 34, 35, 36, 33, 32, 37 };
    Object localObject = new int[3];
    Object tmp317_316 = localObject;
    tmp317_316[0] = 8;
    Object tmp322_317 = tmp317_316;
    tmp322_317[1] = 9;
    Object tmp327_322 = tmp322_317;
    tmp327_322[2] = 10;
    tmp327_322;
    BGP = (int[])localObject;
    BGQ = (int[])localObject;
    localObject = new HashMap();
    int i = 0;
    while (i < 9)
    {
      ((HashMap)localObject).put(Integer.valueOf(new int[] { 131072, 131073, 131074, 131075, 131076, 131077, 131078, 131079, 131080 }[i]), Integer.valueOf(i));
      i += 1;
    }
    BGM = Collections.unmodifiableMap((Map)localObject);
    BGR = new int[43];
    i = 0;
    while (i < 43)
    {
      BGR[new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 17, 18, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 0 }[i]] = i;
      i += 1;
    }
    BGS = new int[27];
    i = j;
    while (i < 27)
    {
      BGS[new int[] { 1, 2, 3, 4, 5, 6, 8, 19, 20, 21, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 7, 0 }[i]] = i;
      i += 1;
    }
    BGT = b.aSL() + "fts/";
    AppMethodBeat.o(131619);
  }
  
  public static final class a
  {
    public static final Pattern BGU;
    public static final Pattern BGV;
    public static final Pattern BGW;
    public static final Pattern BGX;
    public static final Pattern BGY;
    public static final Pattern BGZ;
    public static final Pattern BHa;
    public static final Pattern BHb;
    public static final Pattern BHc;
    
    static
    {
      AppMethodBeat.i(131618);
      BGU = Pattern.compile(";");
      BGV = Pattern.compile(" ");
      BGW = Pattern.compile("​");
      BGX = Pattern.compile("‌");
      Pattern localPattern = Pattern.compile("‍");
      BGY = localPattern;
      BGZ = localPattern;
      BHa = Pattern.compile("\\s+");
      BHb = Pattern.compile(",");
      BHc = Pattern.compile("[A-Za-z]+");
      AppMethodBeat.o(131618);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.c
 * JD-Core Version:    0.7.0.1
 */