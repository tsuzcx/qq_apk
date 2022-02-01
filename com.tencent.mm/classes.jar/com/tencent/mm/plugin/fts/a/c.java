package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class c
{
  public static final int[] swA;
  public static final int[] swB;
  public static final int[] swC;
  public static final int[] swD;
  public static final int[] swE;
  public static final int[] swF;
  public static final String swG;
  public static final int[] swl;
  public static final int[] swm;
  public static final int[] swn;
  public static final int[] swo;
  public static final int[] swp;
  public static final int[] swq;
  public static final int[] swr;
  public static final int[] sws;
  public static final int[] swt;
  public static final int[] swu;
  public static final int[] swv;
  public static final int[] sww;
  public static final int[] swx;
  public static final int[] swy;
  public static final Map<Integer, Integer> swz;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(131619);
    swl = new int[] { 65536 };
    swm = new int[] { 196608 };
    swn = new int[] { 262144 };
    swo = new int[] { 327680 };
    swp = new int[] { 393216 };
    swq = new int[] { 458752 };
    swr = new int[] { 131073, 131074 };
    sws = new int[] { 131072, 131075, 131076, 131081 };
    swt = new int[] { 131072, 131075, 131076, 131081 };
    swu = new int[] { 131072 };
    swv = new int[] { 131073, 131074 };
    sww = new int[] { 131077, 131078 };
    swx = new int[] { 131079, 131080 };
    swy = new int[] { 5, 6, 7, 1, 2, 3 };
    swA = new int[] { 2, 3, 6, 7 };
    swB = new int[] { 29, 30, 31, 34, 35, 36, 33, 32, 37 };
    Object localObject = new int[3];
    Object tmp317_316 = localObject;
    tmp317_316[0] = 8;
    Object tmp322_317 = tmp317_316;
    tmp322_317[1] = 9;
    Object tmp327_322 = tmp322_317;
    tmp327_322[2] = 10;
    tmp327_322;
    swC = (int[])localObject;
    swD = (int[])localObject;
    localObject = new HashMap();
    int i = 0;
    while (i < 9)
    {
      ((HashMap)localObject).put(Integer.valueOf(new int[] { 131072, 131073, 131074, 131075, 131076, 131077, 131078, 131079, 131080 }[i]), Integer.valueOf(i));
      i += 1;
    }
    swz = Collections.unmodifiableMap((Map)localObject);
    swE = new int[43];
    i = 0;
    while (i < 43)
    {
      swE[new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 17, 18, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 0 }[i]] = i;
      i += 1;
    }
    swF = new int[27];
    i = j;
    while (i < 27)
    {
      swF[new int[] { 1, 2, 3, 4, 5, 6, 8, 19, 20, 21, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 7, 0 }[i]] = i;
      i += 1;
    }
    swG = b.aph() + "fts/";
    AppMethodBeat.o(131619);
  }
  
  public static final class a
  {
    public static final Pattern swH;
    public static final Pattern swI;
    public static final Pattern swJ;
    public static final Pattern swK;
    public static final Pattern swL;
    public static final Pattern swM;
    public static final Pattern swN;
    public static final Pattern swO;
    public static final Pattern swP;
    
    static
    {
      AppMethodBeat.i(131618);
      swH = Pattern.compile(";");
      swI = Pattern.compile(" ");
      swJ = Pattern.compile("​");
      swK = Pattern.compile("‌");
      Pattern localPattern = Pattern.compile("‍");
      swL = localPattern;
      swM = localPattern;
      swN = Pattern.compile("\\s+");
      swO = Pattern.compile(",");
      swP = Pattern.compile("[A-Za-z]+");
      AppMethodBeat.o(131618);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.c
 * JD-Core Version:    0.7.0.1
 */