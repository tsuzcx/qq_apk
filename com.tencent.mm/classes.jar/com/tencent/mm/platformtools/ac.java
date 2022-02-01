package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class ac
{
  public static double lat;
  public static double lng;
  public static boolean mEX;
  public static boolean mEY;
  public static boolean mEZ;
  public static boolean mFA;
  public static boolean mFB;
  public static boolean mFC;
  public static int mFE;
  public static int mFF;
  public static boolean mFG;
  public static String mFH;
  public static String mFI;
  public static boolean mFJ;
  public static boolean mFK;
  public static int mFL;
  public static int mFM;
  public static int mFN;
  public static String mFO;
  public static String mFP;
  public static String mFQ;
  public static String mFR;
  public static boolean mFS;
  public static boolean mFT;
  public static boolean mFU;
  public static boolean mFV;
  public static String mFW;
  public static String mFX;
  public static String mFY;
  public static String mFZ;
  public static boolean mFa;
  public static boolean mFb;
  public static boolean mFc;
  public static boolean mFe;
  public static boolean mFf;
  public static boolean mFg;
  public static boolean mFh;
  public static boolean mFi;
  public static boolean mFj;
  public static String mFk;
  public static boolean mFl;
  public static boolean mFm;
  public static boolean mFn;
  public static boolean mFo;
  public static int mFp;
  public static boolean mFq;
  public static boolean mFr;
  public static boolean mFs;
  public static String mFt;
  public static String mFu;
  public static boolean mFv;
  public static boolean mFw;
  public static boolean mFx;
  public static boolean mFy;
  public static boolean mFz;
  public static int mGA;
  public static int mGB;
  public static boolean mGC;
  public static String mGD;
  public static String mGE;
  public static boolean mGF;
  public static boolean mGG;
  public static String mGH;
  public static String mGI;
  public static boolean mGJ;
  public static boolean mGK;
  public static boolean mGL;
  public static boolean mGM;
  public static boolean mGN;
  public static boolean mGO;
  public static boolean mGP;
  public static boolean mGQ;
  public static boolean mGR;
  public static boolean mGS;
  public static boolean mGT;
  public static int mGU;
  private static HashMap<Integer, ConcurrentLinkedQueue<Integer>> mGV;
  public static boolean mGW;
  public static boolean mGX;
  public static boolean mGY;
  public static String mGa;
  public static boolean mGb;
  public static boolean mGc;
  public static boolean mGd;
  public static int mGe;
  public static boolean mGf;
  public static boolean mGg;
  public static boolean mGh;
  public static boolean mGi;
  public static boolean mGj;
  public static String mGk;
  public static int mGl;
  public static boolean mGm;
  public static boolean mGn;
  public static boolean mGo;
  public static boolean mGp;
  public static String mGq;
  public static int mGr;
  public static boolean mGs;
  public static boolean mGt;
  public static int mGu;
  public static boolean mGv;
  public static String mGw;
  public static float mGx;
  public static float mGy;
  public static boolean mGz;
  
  static
  {
    AppMethodBeat.i(132987);
    mEX = false;
    mEY = false;
    mEZ = false;
    mFa = false;
    mFb = false;
    mFc = false;
    mFe = false;
    mFf = false;
    mFg = false;
    mFh = false;
    mFi = false;
    mFj = false;
    mFk = "";
    mFl = false;
    mFm = false;
    mFn = false;
    mFo = false;
    mFp = 0;
    mFq = false;
    mFr = false;
    mFs = false;
    mFt = "";
    mFu = "";
    mFv = false;
    mFw = false;
    mFx = false;
    mFy = false;
    mFz = false;
    mFA = false;
    mFB = false;
    mFC = false;
    mFE = 0;
    mFF = 0;
    mFG = false;
    mFH = null;
    mFI = null;
    mFJ = false;
    mFK = false;
    mFL = 0;
    mFM = 0;
    mFN = 0;
    mFO = "";
    mFP = "";
    mFQ = null;
    mFR = null;
    mFS = false;
    mFT = false;
    mFU = false;
    mFV = false;
    lat = 0.0D;
    lng = 0.0D;
    mFW = "";
    mFX = "";
    mFY = "";
    mFZ = "";
    mGa = "";
    mGb = false;
    mGc = false;
    mGd = false;
    mGe = 0;
    mGf = false;
    mGg = false;
    mGh = false;
    mGi = false;
    mGj = false;
    mGk = "";
    mGl = 0;
    mGm = false;
    mGn = true;
    mGo = false;
    mGp = false;
    mGq = "";
    mGr = 0;
    mGs = false;
    mGt = false;
    mGu = -1;
    mGv = false;
    mGw = "";
    mGx = 0.4F;
    mGy = 0.7F;
    mGz = false;
    mGA = 0;
    mGB = 0;
    mGC = false;
    mGD = "";
    mGE = "";
    mGF = false;
    mGG = false;
    mGH = "";
    mGI = "";
    mGJ = false;
    mGK = false;
    mGL = false;
    mGM = false;
    mGN = false;
    mGO = false;
    mGP = false;
    mGQ = false;
    mGR = false;
    mGS = false;
    mGT = false;
    mGU = 0;
    mGV = new HashMap();
    mGW = false;
    mGX = false;
    mGY = false;
    AppMethodBeat.o(132987);
  }
  
  public static void ed(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132986);
    synchronized (mGV)
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue2 = (ConcurrentLinkedQueue)mGV.get(Integer.valueOf(paramInt1));
      ConcurrentLinkedQueue localConcurrentLinkedQueue1 = localConcurrentLinkedQueue2;
      if (localConcurrentLinkedQueue2 == null)
      {
        localConcurrentLinkedQueue1 = new ConcurrentLinkedQueue();
        mGV.put(Integer.valueOf(paramInt1), localConcurrentLinkedQueue1);
      }
      localConcurrentLinkedQueue1.add(Integer.valueOf(paramInt2));
      AppMethodBeat.o(132986);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.ac
 * JD-Core Version:    0.7.0.1
 */