package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class ac
{
  public static boolean iOA;
  public static boolean iOB;
  public static boolean iOC;
  public static boolean iOD;
  public static boolean iOE;
  public static int iOF;
  public static int iOG;
  public static boolean iOH;
  public static String iOI;
  public static String iOJ;
  public static boolean iOK;
  public static boolean iOL;
  public static int iOM;
  public static int iON;
  public static int iOO;
  public static String iOP;
  public static String iOQ;
  public static String iOR;
  public static String iOS;
  public static boolean iOT;
  public static boolean iOU;
  public static boolean iOV;
  public static boolean iOW;
  public static String iOX;
  public static String iOY;
  public static String iOZ;
  public static boolean iOb;
  public static boolean iOc;
  public static boolean iOd;
  public static boolean iOe;
  public static boolean iOf;
  public static boolean iOg;
  public static boolean iOh;
  public static boolean iOi;
  public static boolean iOj;
  public static boolean iOk;
  public static boolean iOl;
  public static boolean iOm;
  public static String iOn;
  public static boolean iOo;
  public static boolean iOp;
  public static boolean iOq;
  public static boolean iOr;
  public static int iOs;
  public static boolean iOt;
  public static boolean iOu;
  public static boolean iOv;
  public static String iOw;
  public static String iOx;
  public static boolean iOy;
  public static boolean iOz;
  public static float iPA;
  public static boolean iPB;
  public static int iPC;
  public static int iPD;
  public static boolean iPE;
  public static String iPF;
  public static String iPG;
  public static boolean iPH;
  public static boolean iPI;
  public static String iPJ;
  public static String iPK;
  public static boolean iPL;
  public static boolean iPM;
  public static boolean iPN;
  public static boolean iPO;
  public static boolean iPP;
  public static boolean iPQ;
  public static boolean iPR;
  public static boolean iPS;
  public static boolean iPT;
  public static boolean iPU;
  public static boolean iPV;
  public static boolean iPW;
  private static HashMap<Integer, ConcurrentLinkedQueue<Integer>> iPX;
  public static boolean iPY;
  public static boolean iPZ;
  public static String iPa;
  public static String iPb;
  public static boolean iPc;
  public static boolean iPd;
  public static boolean iPe;
  public static int iPf;
  public static boolean iPg;
  public static boolean iPh;
  public static boolean iPi;
  public static boolean iPj;
  public static boolean iPk;
  public static String iPl;
  public static int iPm;
  public static boolean iPn;
  public static boolean iPo;
  public static boolean iPp;
  public static boolean iPq;
  public static String iPr;
  public static int iPs;
  public static boolean iPt;
  public static boolean iPu;
  public static int iPw;
  public static boolean iPx;
  public static String iPy;
  public static float iPz;
  public static boolean iQa;
  public static double lat;
  public static double lng;
  
  static
  {
    AppMethodBeat.i(132987);
    iOb = false;
    iOc = false;
    iOd = false;
    iOe = false;
    iOf = false;
    iOg = false;
    iOh = false;
    iOi = false;
    iOj = false;
    iOk = false;
    iOl = false;
    iOm = false;
    iOn = "";
    iOo = false;
    iOp = false;
    iOq = false;
    iOr = false;
    iOs = 0;
    iOt = false;
    iOu = false;
    iOv = false;
    iOw = "";
    iOx = "";
    iOy = false;
    iOz = false;
    iOA = false;
    iOB = false;
    iOC = false;
    iOD = false;
    iOE = false;
    iOF = 0;
    iOG = 0;
    iOH = false;
    iOI = null;
    iOJ = null;
    iOK = false;
    iOL = false;
    iOM = 0;
    iON = 0;
    iOO = 0;
    iOP = "";
    iOQ = "";
    iOR = null;
    iOS = null;
    iOT = false;
    iOU = false;
    iOV = false;
    iOW = false;
    lat = 0.0D;
    lng = 0.0D;
    iOX = "";
    iOY = "";
    iOZ = "";
    iPa = "";
    iPb = "";
    iPc = false;
    iPd = false;
    iPe = false;
    iPf = 0;
    iPg = false;
    iPh = false;
    iPi = false;
    iPj = false;
    iPk = false;
    iPl = "";
    iPm = 0;
    iPn = false;
    iPo = true;
    iPp = false;
    iPq = false;
    iPr = "";
    iPs = 0;
    iPt = false;
    iPu = false;
    iPw = -1;
    iPx = false;
    iPy = "";
    iPz = 0.4F;
    iPA = 0.7F;
    iPB = false;
    iPC = 0;
    iPD = 0;
    iPE = false;
    iPF = "";
    iPG = "";
    iPH = false;
    iPI = false;
    iPJ = "";
    iPK = "";
    iPL = false;
    iPM = false;
    iPN = false;
    iPO = false;
    iPP = false;
    iPQ = false;
    iPR = false;
    iPS = false;
    iPT = false;
    iPU = false;
    iPV = false;
    iPW = false;
    iPX = new HashMap();
    iPY = false;
    iPZ = false;
    iQa = false;
    AppMethodBeat.o(132987);
  }
  
  public static void dv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132986);
    synchronized (iPX)
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue2 = (ConcurrentLinkedQueue)iPX.get(Integer.valueOf(paramInt1));
      ConcurrentLinkedQueue localConcurrentLinkedQueue1 = localConcurrentLinkedQueue2;
      if (localConcurrentLinkedQueue2 == null)
      {
        localConcurrentLinkedQueue1 = new ConcurrentLinkedQueue();
        iPX.put(Integer.valueOf(paramInt1), localConcurrentLinkedQueue1);
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