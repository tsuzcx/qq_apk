package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class ab
{
  public static boolean iuU;
  public static boolean iuV;
  public static boolean iuW;
  public static boolean iuX;
  public static boolean iuY;
  public static boolean iuZ;
  public static boolean ivA;
  public static String ivB;
  public static String ivC;
  public static boolean ivD;
  public static boolean ivE;
  public static int ivF;
  public static int ivG;
  public static int ivH;
  public static String ivI;
  public static String ivJ;
  public static String ivK;
  public static String ivL;
  public static boolean ivM;
  public static boolean ivN;
  public static boolean ivO;
  public static boolean ivP;
  public static String ivQ;
  public static String ivR;
  public static String ivS;
  public static String ivT;
  public static String ivU;
  public static boolean ivV;
  public static boolean ivW;
  public static boolean ivX;
  public static int ivY;
  public static boolean ivZ;
  public static boolean iva;
  public static boolean ivb;
  public static boolean ivc;
  public static boolean ivd;
  public static boolean ive;
  public static boolean ivf;
  public static String ivg;
  public static boolean ivh;
  public static boolean ivi;
  public static boolean ivj;
  public static boolean ivk;
  public static int ivl;
  public static boolean ivm;
  public static boolean ivn;
  public static boolean ivo;
  public static String ivp;
  public static String ivq;
  public static boolean ivr;
  public static boolean ivs;
  public static boolean ivt;
  public static boolean ivu;
  public static boolean ivv;
  public static boolean ivw;
  public static boolean ivx;
  public static int ivy;
  public static int ivz;
  public static boolean iwA;
  public static String iwB;
  public static String iwC;
  public static boolean iwD;
  public static boolean iwE;
  public static boolean iwF;
  public static boolean iwG;
  public static boolean iwH;
  public static boolean iwI;
  public static boolean iwJ;
  public static boolean iwK;
  public static boolean iwL;
  public static boolean iwM;
  public static boolean iwN;
  private static HashMap<Integer, ConcurrentLinkedQueue<Integer>> iwO;
  public static boolean iwP;
  public static boolean iwQ;
  public static boolean iwR;
  public static boolean iwa;
  public static boolean iwb;
  public static boolean iwc;
  public static boolean iwd;
  public static String iwe;
  public static int iwf;
  public static boolean iwg;
  public static boolean iwh;
  public static boolean iwi;
  public static boolean iwj;
  public static String iwk;
  public static int iwl;
  public static boolean iwm;
  public static boolean iwn;
  public static int iwo;
  public static boolean iwp;
  public static String iwq;
  public static float iwr;
  public static float iws;
  public static boolean iwt;
  public static int iwu;
  public static int iwv;
  public static boolean iww;
  public static String iwx;
  public static String iwy;
  public static boolean iwz;
  public static double lat;
  public static double lng;
  
  static
  {
    AppMethodBeat.i(132987);
    iuU = false;
    iuV = false;
    iuW = false;
    iuX = false;
    iuY = false;
    iuZ = false;
    iva = false;
    ivb = false;
    ivc = false;
    ivd = false;
    ive = false;
    ivf = false;
    ivg = "";
    ivh = false;
    ivi = false;
    ivj = false;
    ivk = false;
    ivl = 0;
    ivm = false;
    ivn = false;
    ivo = false;
    ivp = "";
    ivq = "";
    ivr = false;
    ivs = false;
    ivt = false;
    ivu = false;
    ivv = false;
    ivw = false;
    ivx = false;
    ivy = 0;
    ivz = 0;
    ivA = false;
    ivB = null;
    ivC = null;
    ivD = false;
    ivE = false;
    ivF = 0;
    ivG = 0;
    ivH = 0;
    ivI = "";
    ivJ = "";
    ivK = null;
    ivL = null;
    ivM = false;
    ivN = false;
    ivO = false;
    ivP = false;
    lat = 0.0D;
    lng = 0.0D;
    ivQ = "";
    ivR = "";
    ivS = "";
    ivT = "";
    ivU = "";
    ivV = false;
    ivW = false;
    ivX = false;
    ivY = 0;
    ivZ = false;
    iwa = false;
    iwb = false;
    iwc = false;
    iwd = false;
    iwe = "";
    iwf = 0;
    iwg = false;
    iwh = true;
    iwi = false;
    iwj = false;
    iwk = "";
    iwl = 0;
    iwm = false;
    iwn = false;
    iwo = -1;
    iwp = false;
    iwq = "";
    iwr = 0.4F;
    iws = 0.7F;
    iwt = false;
    iwu = 0;
    iwv = 0;
    iww = false;
    iwx = "";
    iwy = "";
    iwz = false;
    iwA = false;
    iwB = "";
    iwC = "";
    iwD = false;
    iwE = false;
    iwF = false;
    iwG = false;
    iwH = false;
    iwI = false;
    iwJ = false;
    iwK = false;
    iwL = false;
    iwM = false;
    iwN = false;
    iwO = new HashMap();
    iwP = false;
    iwQ = false;
    iwR = false;
    AppMethodBeat.o(132987);
  }
  
  public static void dt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132986);
    synchronized (iwO)
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue2 = (ConcurrentLinkedQueue)iwO.get(Integer.valueOf(paramInt1));
      ConcurrentLinkedQueue localConcurrentLinkedQueue1 = localConcurrentLinkedQueue2;
      if (localConcurrentLinkedQueue2 == null)
      {
        localConcurrentLinkedQueue1 = new ConcurrentLinkedQueue();
        iwO.put(Integer.valueOf(paramInt1), localConcurrentLinkedQueue1);
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