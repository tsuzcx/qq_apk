package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.loader.a.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class c
{
  public static final int[] kuN;
  public static final int[] kuO;
  public static final int[] kuP;
  public static final int[] kuQ;
  public static final int[] kuR;
  public static final int[] kuS;
  public static final int[] kuT;
  public static final int[] kuU;
  public static final int[] kuV;
  public static final int[] kuW;
  public static final int[] kuX;
  public static final int[] kuY;
  public static final int[] kuZ;
  public static final int[] kva;
  public static final Map<Integer, Integer> kvb;
  public static final int[] kvc;
  public static final int[] kvd;
  public static final int[] kve;
  public static final int[] kvf;
  public static final int[] kvg;
  public static final int[] kvh;
  public static final String kvi = b.bkH + "fts/";
  
  static
  {
    int j = 0;
    kuN = new int[] { 65536 };
    kuO = new int[] { 196608 };
    kuP = new int[] { 262144 };
    kuQ = new int[] { 327680 };
    kuR = new int[] { 393216 };
    kuS = new int[] { 458752 };
    kuT = new int[] { 131073, 131074 };
    kuU = new int[] { 131072, 131075, 131076, 131081 };
    kuV = new int[] { 131072, 131075, 131076, 131081 };
    kuW = new int[] { 131072 };
    kuX = new int[] { 131073, 131074 };
    kuY = new int[] { 131077, 131078 };
    kuZ = new int[] { 131079, 131080 };
    kva = new int[] { 5, 6, 7, 1, 2, 3 };
    kvc = new int[] { 2, 3, 6, 7 };
    kvd = new int[] { 29, 30, 31, 34, 35, 36, 33, 32, 37 };
    Object localObject = new int[3];
    Object tmp312_311 = localObject;
    tmp312_311[0] = 8;
    Object tmp317_312 = tmp312_311;
    tmp317_312[1] = 9;
    Object tmp322_317 = tmp317_312;
    tmp322_317[2] = 10;
    tmp322_317;
    kve = (int[])localObject;
    kvf = (int[])localObject;
    localObject = new HashMap();
    int i = 0;
    while (i < 9)
    {
      ((HashMap)localObject).put(Integer.valueOf(new int[] { 131072, 131073, 131074, 131075, 131076, 131077, 131078, 131079, 131080 }[i]), Integer.valueOf(i));
      i += 1;
    }
    kvb = Collections.unmodifiableMap((Map)localObject);
    kvg = new int[43];
    i = 0;
    while (i < 43)
    {
      kvg[new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 17, 18, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 0 }[i]] = i;
      i += 1;
    }
    kvh = new int[27];
    i = j;
    while (i < 27)
    {
      kvh[new int[] { 1, 2, 3, 4, 5, 6, 8, 19, 20, 21, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 7, 0 }[i]] = i;
      i += 1;
    }
  }
  
  public static final class a
  {
    public static final Pattern kvj = Pattern.compile(";");
    public static final Pattern kvk = Pattern.compile(" ");
    public static final Pattern kvl = Pattern.compile("​");
    public static final Pattern kvm = Pattern.compile("‌");
    public static final Pattern kvn;
    public static final Pattern kvo;
    public static final Pattern kvp = Pattern.compile("\\s+");
    public static final Pattern kvq = Pattern.compile(",");
    public static final Pattern kvr = Pattern.compile("[A-Za-z]+");
    
    static
    {
      Pattern localPattern = Pattern.compile("‍");
      kvn = localPattern;
      kvo = localPattern;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.c
 * JD-Core Version:    0.7.0.1
 */