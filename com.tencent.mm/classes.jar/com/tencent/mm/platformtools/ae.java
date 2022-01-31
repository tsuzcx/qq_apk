package com.tencent.mm.platformtools;

import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class ae
{
  public static boolean eSA;
  public static boolean eSB;
  public static boolean eSC;
  public static boolean eSD;
  public static boolean eSE;
  public static boolean eSF;
  public static boolean eSG;
  public static int eSH;
  public static int eSI;
  public static boolean eSJ;
  public static String eSK;
  public static String eSL;
  public static boolean eSM;
  public static boolean eSN;
  public static int eSO;
  public static int eSP;
  public static int eSQ;
  public static String eSR;
  public static String eSS;
  public static String eST;
  public static String eSU;
  public static boolean eSV;
  public static boolean eSW;
  public static boolean eSX;
  public static boolean eSY;
  public static String eSZ;
  public static boolean eSd = false;
  public static boolean eSe = false;
  public static boolean eSf = false;
  public static boolean eSg = false;
  public static boolean eSh = false;
  public static boolean eSi = false;
  public static boolean eSj = false;
  public static boolean eSk = false;
  public static boolean eSl = false;
  public static boolean eSm = false;
  public static boolean eSn = false;
  public static boolean eSo = false;
  public static String eSp = "";
  public static boolean eSq = false;
  public static boolean eSr = false;
  public static boolean eSs = false;
  public static boolean eSt = false;
  public static int eSu = 0;
  public static boolean eSv = false;
  public static boolean eSw = false;
  public static boolean eSx = false;
  public static String eSy = "";
  public static String eSz = "";
  public static boolean eTA = false;
  public static String eTB = "";
  public static String eTC = "";
  public static boolean eTD = false;
  public static boolean eTE = false;
  public static String eTF = "";
  public static String eTG = "";
  public static boolean eTH = false;
  public static boolean eTI = false;
  public static boolean eTJ = false;
  public static boolean eTK = false;
  public static boolean eTL = false;
  public static boolean eTM = false;
  public static boolean eTN = false;
  public static boolean eTO = false;
  private static HashMap<Integer, ConcurrentLinkedQueue<Integer>> eTP = new HashMap();
  public static boolean eTQ = false;
  public static boolean eTR = false;
  public static boolean eTS = false;
  public static String eTa;
  public static String eTb;
  public static String eTc;
  public static String eTd;
  public static boolean eTe;
  public static boolean eTf;
  public static boolean eTg;
  public static int eTh;
  public static boolean eTi;
  public static boolean eTj;
  public static boolean eTk;
  public static boolean eTl;
  public static boolean eTm;
  public static boolean eTn;
  public static boolean eTo;
  public static boolean eTp;
  public static boolean eTq;
  public static String eTr;
  public static int eTs;
  public static boolean eTt;
  public static boolean eTu;
  public static int eTv;
  public static boolean eTw;
  public static String eTx;
  public static float eTy;
  public static float eTz;
  public static double lat;
  public static double lng;
  
  static
  {
    eSA = false;
    eSB = false;
    eSC = false;
    eSD = false;
    eSE = false;
    eSF = false;
    eSG = false;
    eSH = 0;
    eSI = 0;
    eSJ = false;
    eSK = null;
    eSL = null;
    eSM = false;
    eSN = false;
    eSO = 0;
    eSP = 0;
    eSQ = 0;
    eSR = "";
    eSS = "";
    eST = null;
    eSU = null;
    eSV = false;
    eSW = false;
    eSX = false;
    eSY = false;
    lat = 0.0D;
    lng = 0.0D;
    eSZ = "";
    eTa = "";
    eTb = "";
    eTc = "";
    eTd = "";
    eTe = false;
    eTf = false;
    eTg = false;
    eTh = 0;
    eTi = false;
    eTj = false;
    eTk = false;
    eTl = false;
    eTm = false;
    eTn = false;
    eTo = true;
    eTp = false;
    eTq = false;
    eTr = "";
    eTs = 0;
    eTt = false;
    eTu = false;
    eTv = -1;
    eTw = false;
    eTx = "";
    eTy = 0.4F;
    eTz = 0.7F;
  }
  
  public static void bB(int paramInt1, int paramInt2)
  {
    synchronized (eTP)
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue2 = (ConcurrentLinkedQueue)eTP.get(Integer.valueOf(paramInt1));
      ConcurrentLinkedQueue localConcurrentLinkedQueue1 = localConcurrentLinkedQueue2;
      if (localConcurrentLinkedQueue2 == null)
      {
        localConcurrentLinkedQueue1 = new ConcurrentLinkedQueue();
        eTP.put(Integer.valueOf(paramInt1), localConcurrentLinkedQueue1);
      }
      localConcurrentLinkedQueue1.add(Integer.valueOf(paramInt2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.ae
 * JD-Core Version:    0.7.0.1
 */