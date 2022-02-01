package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class c
{
  public static final int[] Hra;
  public static final int[] Hrb;
  public static final int[] Hrc;
  public static final int[] Hrd;
  public static final int[] Hre;
  public static final int[] Hrf;
  public static final int[] Hrg;
  public static final int[] Hrh;
  public static final int[] Hri;
  public static final int[] Hrj;
  public static final int[] Hrk;
  public static final int[] Hrl;
  public static final int[] Hrm;
  public static final int[] Hrn;
  public static final int[] Hro;
  public static final int[] Hrp;
  public static final Map<Integer, Integer> Hrq;
  public static final int[] Hrr;
  public static final int[] Hrs;
  public static final int[] Hrt;
  public static final int[] Hru;
  public static final int[] Hrv;
  public static final int[] Hrw;
  public static final String Hrx;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(131619);
    Hra = new int[] { 65536 };
    Hrb = new int[] { 196608 };
    Hrc = new int[] { 262144 };
    Hrd = new int[] { 327680 };
    Hre = new int[] { 393216 };
    Hrf = new int[] { 458752 };
    Hrg = new int[] { 524288 };
    Hrh = new int[] { 589824 };
    Hri = new int[] { 131073, 131074 };
    Hrj = new int[] { 131072, 131075, 131076, 131081 };
    Hrk = new int[] { 131072, 131075, 131076, 131081 };
    Hrl = new int[] { 131072 };
    Hrm = new int[] { 131073, 131074 };
    Hrn = new int[] { 131077, 131078 };
    Hro = new int[] { 131079, 131080 };
    Hrp = new int[] { 5, 6, 7, 1, 2, 3 };
    Hrr = new int[] { 2, 3, 6, 7 };
    Hrs = new int[] { 29, 30, 31, 34, 35, 36, 33, 32, 37 };
    Object localObject = new int[3];
    Object tmp339_338 = localObject;
    tmp339_338[0] = 8;
    Object tmp344_339 = tmp339_338;
    tmp344_339[1] = 9;
    Object tmp349_344 = tmp344_339;
    tmp349_344[2] = 10;
    tmp349_344;
    Hrt = (int[])localObject;
    Hru = (int[])localObject;
    localObject = new HashMap();
    int i = 0;
    while (i < 9)
    {
      ((HashMap)localObject).put(Integer.valueOf(new int[] { 131072, 131073, 131074, 131075, 131076, 131077, 131078, 131079, 131080 }[i]), Integer.valueOf(i));
      i += 1;
    }
    Hrq = Collections.unmodifiableMap((Map)localObject);
    Hrv = new int[43];
    i = 0;
    while (i < 43)
    {
      Hrv[new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 17, 18, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 0 }[i]] = i;
      i += 1;
    }
    Hrw = new int[27];
    i = j;
    while (i < 27)
    {
      Hrw[new int[] { 1, 2, 3, 4, 5, 6, 8, 19, 20, 21, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 7, 0 }[i]] = i;
      i += 1;
    }
    Hrx = b.bmz() + "fts/";
    AppMethodBeat.o(131619);
  }
  
  public static final class a
  {
    public static final Pattern HrA;
    public static final Pattern HrB;
    public static final Pattern HrC;
    public static final Pattern HrD;
    public static final Pattern HrE;
    public static final Pattern HrF;
    public static final Pattern HrG;
    public static final Pattern Hry;
    public static final Pattern Hrz;
    
    static
    {
      AppMethodBeat.i(131618);
      Hry = Pattern.compile(";");
      Hrz = Pattern.compile(" ");
      HrA = Pattern.compile("​");
      HrB = Pattern.compile("‌");
      Pattern localPattern = Pattern.compile("‍");
      HrC = localPattern;
      HrD = localPattern;
      HrE = Pattern.compile("\\s+");
      HrF = Pattern.compile(",");
      HrG = Pattern.compile("[A-Za-z]+");
      AppMethodBeat.o(131618);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.c
 * JD-Core Version:    0.7.0.1
 */