package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class c
{
  public static final int[] tsM;
  public static final int[] tsN;
  public static final int[] tsO;
  public static final int[] tsP;
  public static final int[] tsQ;
  public static final int[] tsR;
  public static final int[] tsS;
  public static final int[] tsT;
  public static final int[] tsU;
  public static final int[] tsV;
  public static final int[] tsW;
  public static final int[] tsX;
  public static final int[] tsY;
  public static final int[] tsZ;
  public static final Map<Integer, Integer> tta;
  public static final int[] ttb;
  public static final int[] ttc;
  public static final int[] ttd;
  public static final int[] tte;
  public static final int[] ttf;
  public static final int[] ttg;
  public static final String tth;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(131619);
    tsM = new int[] { 65536 };
    tsN = new int[] { 196608 };
    tsO = new int[] { 262144 };
    tsP = new int[] { 327680 };
    tsQ = new int[] { 393216 };
    tsR = new int[] { 458752 };
    tsS = new int[] { 131073, 131074 };
    tsT = new int[] { 131072, 131075, 131076, 131081 };
    tsU = new int[] { 131072, 131075, 131076, 131081 };
    tsV = new int[] { 131072 };
    tsW = new int[] { 131073, 131074 };
    tsX = new int[] { 131077, 131078 };
    tsY = new int[] { 131079, 131080 };
    tsZ = new int[] { 5, 6, 7, 1, 2, 3 };
    ttb = new int[] { 2, 3, 6, 7 };
    ttc = new int[] { 29, 30, 31, 34, 35, 36, 33, 32, 37 };
    Object localObject = new int[3];
    Object tmp317_316 = localObject;
    tmp317_316[0] = 8;
    Object tmp322_317 = tmp317_316;
    tmp322_317[1] = 9;
    Object tmp327_322 = tmp322_317;
    tmp327_322[2] = 10;
    tmp327_322;
    ttd = (int[])localObject;
    tte = (int[])localObject;
    localObject = new HashMap();
    int i = 0;
    while (i < 9)
    {
      ((HashMap)localObject).put(Integer.valueOf(new int[] { 131072, 131073, 131074, 131075, 131076, 131077, 131078, 131079, 131080 }[i]), Integer.valueOf(i));
      i += 1;
    }
    tta = Collections.unmodifiableMap((Map)localObject);
    ttf = new int[43];
    i = 0;
    while (i < 43)
    {
      ttf[new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 17, 18, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 0 }[i]] = i;
      i += 1;
    }
    ttg = new int[27];
    i = j;
    while (i < 27)
    {
      ttg[new int[] { 1, 2, 3, 4, 5, 6, 8, 19, 20, 21, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 7, 0 }[i]] = i;
      i += 1;
    }
    tth = b.arU() + "fts/";
    AppMethodBeat.o(131619);
  }
  
  public static final class a
  {
    public static final Pattern tti;
    public static final Pattern ttj;
    public static final Pattern ttk;
    public static final Pattern ttl;
    public static final Pattern ttm;
    public static final Pattern ttn;
    public static final Pattern tto;
    public static final Pattern ttp;
    public static final Pattern ttq;
    
    static
    {
      AppMethodBeat.i(131618);
      tti = Pattern.compile(";");
      ttj = Pattern.compile(" ");
      ttk = Pattern.compile("​");
      ttl = Pattern.compile("‌");
      Pattern localPattern = Pattern.compile("‍");
      ttm = localPattern;
      ttn = localPattern;
      tto = Pattern.compile("\\s+");
      ttp = Pattern.compile(",");
      ttq = Pattern.compile("[A-Za-z]+");
      AppMethodBeat.o(131618);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.c
 * JD-Core Version:    0.7.0.1
 */