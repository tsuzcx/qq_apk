package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class ab
{
  public static boolean hUQ;
  public static boolean hUR;
  public static boolean hUS;
  public static boolean hUT;
  public static boolean hUU;
  public static boolean hUV;
  public static boolean hUW;
  public static boolean hUX;
  public static boolean hUY;
  public static boolean hUZ;
  public static boolean hVA;
  public static int hVB;
  public static int hVC;
  public static int hVD;
  public static String hVE;
  public static String hVF;
  public static String hVG;
  public static String hVH;
  public static boolean hVI;
  public static boolean hVJ;
  public static boolean hVK;
  public static boolean hVL;
  public static String hVM;
  public static String hVN;
  public static String hVO;
  public static String hVP;
  public static String hVQ;
  public static boolean hVR;
  public static boolean hVS;
  public static boolean hVT;
  public static int hVU;
  public static boolean hVV;
  public static boolean hVW;
  public static boolean hVX;
  public static boolean hVY;
  public static boolean hVZ;
  public static boolean hVa;
  public static boolean hVb;
  public static String hVc;
  public static boolean hVd;
  public static boolean hVe;
  public static boolean hVf;
  public static boolean hVg;
  public static int hVh;
  public static boolean hVi;
  public static boolean hVj;
  public static boolean hVk;
  public static String hVl;
  public static String hVm;
  public static boolean hVn;
  public static boolean hVo;
  public static boolean hVp;
  public static boolean hVq;
  public static boolean hVr;
  public static boolean hVs;
  public static boolean hVt;
  public static int hVu;
  public static int hVv;
  public static boolean hVw;
  public static String hVx;
  public static String hVy;
  public static boolean hVz;
  public static boolean hWA;
  public static boolean hWB;
  public static boolean hWC;
  public static boolean hWD;
  public static boolean hWE;
  public static boolean hWF;
  public static boolean hWG;
  public static boolean hWH;
  public static boolean hWI;
  public static boolean hWJ;
  private static HashMap<Integer, ConcurrentLinkedQueue<Integer>> hWK;
  public static boolean hWL;
  public static boolean hWM;
  public static boolean hWN;
  public static String hWa;
  public static int hWb;
  public static boolean hWc;
  public static boolean hWd;
  public static boolean hWe;
  public static boolean hWf;
  public static String hWg;
  public static int hWh;
  public static boolean hWi;
  public static boolean hWj;
  public static int hWk;
  public static boolean hWl;
  public static String hWm;
  public static float hWn;
  public static float hWo;
  public static boolean hWp;
  public static int hWq;
  public static int hWr;
  public static boolean hWs;
  public static String hWt;
  public static String hWu;
  public static boolean hWv;
  public static boolean hWw;
  public static String hWx;
  public static String hWy;
  public static boolean hWz;
  public static double lat;
  public static double lng;
  
  static
  {
    AppMethodBeat.i(132987);
    hUQ = false;
    hUR = false;
    hUS = false;
    hUT = false;
    hUU = false;
    hUV = false;
    hUW = false;
    hUX = false;
    hUY = false;
    hUZ = false;
    hVa = false;
    hVb = false;
    hVc = "";
    hVd = false;
    hVe = false;
    hVf = false;
    hVg = false;
    hVh = 0;
    hVi = false;
    hVj = false;
    hVk = false;
    hVl = "";
    hVm = "";
    hVn = false;
    hVo = false;
    hVp = false;
    hVq = false;
    hVr = false;
    hVs = false;
    hVt = false;
    hVu = 0;
    hVv = 0;
    hVw = false;
    hVx = null;
    hVy = null;
    hVz = false;
    hVA = false;
    hVB = 0;
    hVC = 0;
    hVD = 0;
    hVE = "";
    hVF = "";
    hVG = null;
    hVH = null;
    hVI = false;
    hVJ = false;
    hVK = false;
    hVL = false;
    lat = 0.0D;
    lng = 0.0D;
    hVM = "";
    hVN = "";
    hVO = "";
    hVP = "";
    hVQ = "";
    hVR = false;
    hVS = false;
    hVT = false;
    hVU = 0;
    hVV = false;
    hVW = false;
    hVX = false;
    hVY = false;
    hVZ = false;
    hWa = "";
    hWb = 0;
    hWc = false;
    hWd = true;
    hWe = false;
    hWf = false;
    hWg = "";
    hWh = 0;
    hWi = false;
    hWj = false;
    hWk = -1;
    hWl = false;
    hWm = "";
    hWn = 0.4F;
    hWo = 0.7F;
    hWp = false;
    hWq = 0;
    hWr = 0;
    hWs = false;
    hWt = "";
    hWu = "";
    hWv = false;
    hWw = false;
    hWx = "";
    hWy = "";
    hWz = false;
    hWA = false;
    hWB = false;
    hWC = false;
    hWD = false;
    hWE = false;
    hWF = false;
    hWG = false;
    hWH = false;
    hWI = false;
    hWJ = false;
    hWK = new HashMap();
    hWL = false;
    hWM = false;
    hWN = false;
    AppMethodBeat.o(132987);
  }
  
  public static void dt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132986);
    synchronized (hWK)
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue2 = (ConcurrentLinkedQueue)hWK.get(Integer.valueOf(paramInt1));
      ConcurrentLinkedQueue localConcurrentLinkedQueue1 = localConcurrentLinkedQueue2;
      if (localConcurrentLinkedQueue2 == null)
      {
        localConcurrentLinkedQueue1 = new ConcurrentLinkedQueue();
        hWK.put(Integer.valueOf(paramInt1), localConcurrentLinkedQueue1);
      }
      localConcurrentLinkedQueue1.add(Integer.valueOf(paramInt2));
      AppMethodBeat.o(132986);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.ab
 * JD-Core Version:    0.7.0.1
 */