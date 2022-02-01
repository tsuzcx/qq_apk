package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class ac
{
  public static boolean jNP;
  public static boolean jNQ;
  public static boolean jNR;
  public static boolean jNS;
  public static boolean jNT;
  public static boolean jNU;
  public static boolean jNV;
  public static boolean jNW;
  public static boolean jNX;
  public static boolean jNY;
  public static boolean jNZ;
  public static boolean jOA;
  public static int jOB;
  public static int jOC;
  public static int jOD;
  public static String jOE;
  public static String jOF;
  public static String jOG;
  public static String jOH;
  public static boolean jOI;
  public static boolean jOJ;
  public static boolean jOK;
  public static boolean jOL;
  public static String jOM;
  public static String jON;
  public static String jOO;
  public static String jOP;
  public static String jOQ;
  public static boolean jOR;
  public static boolean jOS;
  public static boolean jOT;
  public static int jOU;
  public static boolean jOV;
  public static boolean jOW;
  public static boolean jOX;
  public static boolean jOY;
  public static boolean jOZ;
  public static boolean jOa;
  public static String jOb;
  public static boolean jOc;
  public static boolean jOd;
  public static boolean jOe;
  public static boolean jOf;
  public static int jOg;
  public static boolean jOh;
  public static boolean jOi;
  public static boolean jOj;
  public static String jOk;
  public static String jOl;
  public static boolean jOm;
  public static boolean jOn;
  public static boolean jOo;
  public static boolean jOp;
  public static boolean jOq;
  public static boolean jOr;
  public static boolean jOs;
  public static boolean jOt;
  public static int jOu;
  public static int jOv;
  public static boolean jOw;
  public static String jOx;
  public static String jOy;
  public static boolean jOz;
  public static boolean jPA;
  public static boolean jPB;
  public static boolean jPC;
  public static boolean jPD;
  public static boolean jPE;
  public static boolean jPF;
  public static boolean jPG;
  public static boolean jPH;
  public static boolean jPI;
  public static boolean jPJ;
  public static int jPK;
  private static HashMap<Integer, ConcurrentLinkedQueue<Integer>> jPL;
  public static boolean jPM;
  public static boolean jPN;
  public static boolean jPO;
  public static String jPa;
  public static int jPb;
  public static boolean jPc;
  public static boolean jPd;
  public static boolean jPe;
  public static boolean jPf;
  public static String jPg;
  public static int jPh;
  public static boolean jPi;
  public static boolean jPj;
  public static int jPk;
  public static boolean jPl;
  public static String jPm;
  public static float jPn;
  public static float jPo;
  public static boolean jPp;
  public static int jPq;
  public static int jPr;
  public static boolean jPs;
  public static String jPt;
  public static String jPu;
  public static boolean jPv;
  public static boolean jPw;
  public static String jPx;
  public static String jPy;
  public static boolean jPz;
  public static double lat;
  public static double lng;
  
  static
  {
    AppMethodBeat.i(132987);
    jNP = false;
    jNQ = false;
    jNR = false;
    jNS = false;
    jNT = false;
    jNU = false;
    jNV = false;
    jNW = false;
    jNX = false;
    jNY = false;
    jNZ = false;
    jOa = false;
    jOb = "";
    jOc = false;
    jOd = false;
    jOe = false;
    jOf = false;
    jOg = 0;
    jOh = false;
    jOi = false;
    jOj = false;
    jOk = "";
    jOl = "";
    jOm = false;
    jOn = false;
    jOo = false;
    jOp = false;
    jOq = false;
    jOr = false;
    jOs = false;
    jOt = false;
    jOu = 0;
    jOv = 0;
    jOw = false;
    jOx = null;
    jOy = null;
    jOz = false;
    jOA = false;
    jOB = 0;
    jOC = 0;
    jOD = 0;
    jOE = "";
    jOF = "";
    jOG = null;
    jOH = null;
    jOI = false;
    jOJ = false;
    jOK = false;
    jOL = false;
    lat = 0.0D;
    lng = 0.0D;
    jOM = "";
    jON = "";
    jOO = "";
    jOP = "";
    jOQ = "";
    jOR = false;
    jOS = false;
    jOT = false;
    jOU = 0;
    jOV = false;
    jOW = false;
    jOX = false;
    jOY = false;
    jOZ = false;
    jPa = "";
    jPb = 0;
    jPc = false;
    jPd = true;
    jPe = false;
    jPf = false;
    jPg = "";
    jPh = 0;
    jPi = false;
    jPj = false;
    jPk = -1;
    jPl = false;
    jPm = "";
    jPn = 0.4F;
    jPo = 0.7F;
    jPp = false;
    jPq = 0;
    jPr = 0;
    jPs = false;
    jPt = "";
    jPu = "";
    jPv = false;
    jPw = false;
    jPx = "";
    jPy = "";
    jPz = false;
    jPA = false;
    jPB = false;
    jPC = false;
    jPD = false;
    jPE = false;
    jPF = false;
    jPG = false;
    jPH = false;
    jPI = false;
    jPJ = false;
    jPK = 0;
    jPL = new HashMap();
    jPM = false;
    jPN = false;
    jPO = false;
    AppMethodBeat.o(132987);
  }
  
  public static void dF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132986);
    synchronized (jPL)
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue2 = (ConcurrentLinkedQueue)jPL.get(Integer.valueOf(paramInt1));
      ConcurrentLinkedQueue localConcurrentLinkedQueue1 = localConcurrentLinkedQueue2;
      if (localConcurrentLinkedQueue2 == null)
      {
        localConcurrentLinkedQueue1 = new ConcurrentLinkedQueue();
        jPL.put(Integer.valueOf(paramInt1), localConcurrentLinkedQueue1);
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