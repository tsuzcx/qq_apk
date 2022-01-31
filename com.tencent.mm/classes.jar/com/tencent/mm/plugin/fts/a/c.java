package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  public static final int[] mQA;
  public static final int[] mQB;
  public static final int[] mQC;
  public static final int[] mQD;
  public static final int[] mQE;
  public static final int[] mQF;
  public static final int[] mQG;
  public static final int[] mQH;
  public static final int[] mQI;
  public static final int[] mQJ;
  public static final int[] mQK;
  public static final int[] mQL;
  public static final int[] mQM;
  public static final int[] mQN;
  public static final Map<Integer, Integer> mQO;
  public static final int[] mQP;
  public static final int[] mQQ;
  public static final int[] mQR;
  public static final int[] mQS;
  public static final int[] mQT;
  public static final int[] mQU;
  public static final String mQV;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(114187);
    mQA = new int[] { 65536 };
    mQB = new int[] { 196608 };
    mQC = new int[] { 262144 };
    mQD = new int[] { 327680 };
    mQE = new int[] { 393216 };
    mQF = new int[] { 458752 };
    mQG = new int[] { 131073, 131074 };
    mQH = new int[] { 131072, 131075, 131076, 131081 };
    mQI = new int[] { 131072, 131075, 131076, 131081 };
    mQJ = new int[] { 131072 };
    mQK = new int[] { 131073, 131074 };
    mQL = new int[] { 131077, 131078 };
    mQM = new int[] { 131079, 131080 };
    mQN = new int[] { 5, 6, 7, 1, 2, 3 };
    mQP = new int[] { 2, 3, 6, 7 };
    mQQ = new int[] { 29, 30, 31, 34, 35, 36, 33, 32, 37 };
    Object localObject = new int[3];
    Object tmp317_316 = localObject;
    tmp317_316[0] = 8;
    Object tmp322_317 = tmp317_316;
    tmp322_317[1] = 9;
    Object tmp327_322 = tmp322_317;
    tmp327_322[2] = 10;
    tmp327_322;
    mQR = (int[])localObject;
    mQS = (int[])localObject;
    localObject = new HashMap();
    int i = 0;
    while (i < 9)
    {
      ((HashMap)localObject).put(Integer.valueOf(new int[] { 131072, 131073, 131074, 131075, 131076, 131077, 131078, 131079, 131080 }[i]), Integer.valueOf(i));
      i += 1;
    }
    mQO = Collections.unmodifiableMap((Map)localObject);
    mQT = new int[43];
    i = 0;
    while (i < 43)
    {
      mQT[new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 17, 18, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 0 }[i]] = i;
      i += 1;
    }
    mQU = new int[27];
    i = j;
    while (i < 27)
    {
      mQU[new int[] { 1, 2, 3, 4, 5, 6, 8, 19, 20, 21, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 7, 0 }[i]] = i;
      i += 1;
    }
    mQV = b.eQz + "fts/";
    AppMethodBeat.o(114187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.c
 * JD-Core Version:    0.7.0.1
 */