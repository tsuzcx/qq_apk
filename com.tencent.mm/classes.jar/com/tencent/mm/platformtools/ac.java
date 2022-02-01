package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class ac
{
  public static boolean iQV;
  public static boolean iQW;
  public static boolean iQX;
  public static boolean iQY;
  public static boolean iQZ;
  public static int iRA;
  public static boolean iRB;
  public static String iRC;
  public static String iRD;
  public static boolean iRE;
  public static boolean iRF;
  public static int iRG;
  public static int iRH;
  public static int iRI;
  public static String iRJ;
  public static String iRK;
  public static String iRL;
  public static String iRM;
  public static boolean iRN;
  public static boolean iRO;
  public static boolean iRP;
  public static boolean iRQ;
  public static String iRR;
  public static String iRS;
  public static String iRT;
  public static String iRU;
  public static String iRV;
  public static boolean iRW;
  public static boolean iRX;
  public static boolean iRY;
  public static int iRZ;
  public static boolean iRa;
  public static boolean iRb;
  public static boolean iRc;
  public static boolean iRd;
  public static boolean iRe;
  public static boolean iRf;
  public static boolean iRg;
  public static String iRh;
  public static boolean iRi;
  public static boolean iRj;
  public static boolean iRk;
  public static boolean iRl;
  public static int iRm;
  public static boolean iRn;
  public static boolean iRo;
  public static boolean iRp;
  public static String iRq;
  public static String iRr;
  public static boolean iRs;
  public static boolean iRt;
  public static boolean iRu;
  public static boolean iRv;
  public static boolean iRw;
  public static boolean iRx;
  public static boolean iRy;
  public static int iRz;
  public static boolean iSA;
  public static boolean iSB;
  public static String iSC;
  public static String iSD;
  public static boolean iSE;
  public static boolean iSF;
  public static boolean iSG;
  public static boolean iSH;
  public static boolean iSI;
  public static boolean iSJ;
  public static boolean iSK;
  public static boolean iSL;
  public static boolean iSM;
  public static boolean iSN;
  public static boolean iSO;
  public static int iSP;
  private static HashMap<Integer, ConcurrentLinkedQueue<Integer>> iSQ;
  public static boolean iSR;
  public static boolean iSS;
  public static boolean iST;
  public static boolean iSa;
  public static boolean iSb;
  public static boolean iSc;
  public static boolean iSd;
  public static boolean iSe;
  public static String iSf;
  public static int iSg;
  public static boolean iSh;
  public static boolean iSi;
  public static boolean iSj;
  public static boolean iSk;
  public static String iSl;
  public static int iSm;
  public static boolean iSn;
  public static boolean iSo;
  public static int iSp;
  public static boolean iSq;
  public static String iSr;
  public static float iSs;
  public static float iSt;
  public static boolean iSu;
  public static int iSv;
  public static int iSw;
  public static boolean iSx;
  public static String iSy;
  public static String iSz;
  public static double lat;
  public static double lng;
  
  static
  {
    AppMethodBeat.i(132987);
    iQV = false;
    iQW = false;
    iQX = false;
    iQY = false;
    iQZ = false;
    iRa = false;
    iRb = false;
    iRc = false;
    iRd = false;
    iRe = false;
    iRf = false;
    iRg = false;
    iRh = "";
    iRi = false;
    iRj = false;
    iRk = false;
    iRl = false;
    iRm = 0;
    iRn = false;
    iRo = false;
    iRp = false;
    iRq = "";
    iRr = "";
    iRs = false;
    iRt = false;
    iRu = false;
    iRv = false;
    iRw = false;
    iRx = false;
    iRy = false;
    iRz = 0;
    iRA = 0;
    iRB = false;
    iRC = null;
    iRD = null;
    iRE = false;
    iRF = false;
    iRG = 0;
    iRH = 0;
    iRI = 0;
    iRJ = "";
    iRK = "";
    iRL = null;
    iRM = null;
    iRN = false;
    iRO = false;
    iRP = false;
    iRQ = false;
    lat = 0.0D;
    lng = 0.0D;
    iRR = "";
    iRS = "";
    iRT = "";
    iRU = "";
    iRV = "";
    iRW = false;
    iRX = false;
    iRY = false;
    iRZ = 0;
    iSa = false;
    iSb = false;
    iSc = false;
    iSd = false;
    iSe = false;
    iSf = "";
    iSg = 0;
    iSh = false;
    iSi = true;
    iSj = false;
    iSk = false;
    iSl = "";
    iSm = 0;
    iSn = false;
    iSo = false;
    iSp = -1;
    iSq = false;
    iSr = "";
    iSs = 0.4F;
    iSt = 0.7F;
    iSu = false;
    iSv = 0;
    iSw = 0;
    iSx = false;
    iSy = "";
    iSz = "";
    iSA = false;
    iSB = false;
    iSC = "";
    iSD = "";
    iSE = false;
    iSF = false;
    iSG = false;
    iSH = false;
    iSI = false;
    iSJ = false;
    iSK = false;
    iSL = false;
    iSM = false;
    iSN = false;
    iSO = false;
    iSP = 0;
    iSQ = new HashMap();
    iSR = false;
    iSS = false;
    iST = false;
    AppMethodBeat.o(132987);
  }
  
  public static void dv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132986);
    synchronized (iSQ)
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue2 = (ConcurrentLinkedQueue)iSQ.get(Integer.valueOf(paramInt1));
      ConcurrentLinkedQueue localConcurrentLinkedQueue1 = localConcurrentLinkedQueue2;
      if (localConcurrentLinkedQueue2 == null)
      {
        localConcurrentLinkedQueue1 = new ConcurrentLinkedQueue();
        iSQ.put(Integer.valueOf(paramInt1), localConcurrentLinkedQueue1);
      }
      localConcurrentLinkedQueue1.add(Integer.valueOf(paramInt2));
      AppMethodBeat.o(132986);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.ac
 * JD-Core Version:    0.7.0.1
 */