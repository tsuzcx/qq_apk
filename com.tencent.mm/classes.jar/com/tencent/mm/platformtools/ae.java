package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class ae
{
  public static boolean gjY;
  public static boolean gjZ;
  public static boolean gkA;
  public static boolean gkB;
  public static int gkC;
  public static int gkD;
  public static boolean gkE;
  public static String gkF;
  public static String gkG;
  public static boolean gkH;
  public static boolean gkI;
  public static int gkJ;
  public static int gkK;
  public static int gkL;
  public static String gkM;
  public static String gkN;
  public static String gkO;
  public static String gkP;
  public static boolean gkQ;
  public static boolean gkR;
  public static boolean gkS;
  public static boolean gkT;
  public static String gkU;
  public static String gkV;
  public static String gkW;
  public static String gkX;
  public static String gkY;
  public static boolean gkZ;
  public static boolean gka;
  public static boolean gkb;
  public static boolean gkc;
  public static boolean gkd;
  public static boolean gke;
  public static boolean gkf;
  public static boolean gkg;
  public static boolean gkh;
  public static boolean gki;
  public static boolean gkj;
  public static String gkk;
  public static boolean gkl;
  public static boolean gkm;
  public static boolean gkn;
  public static boolean gko;
  public static int gkp;
  public static boolean gkq;
  public static boolean gkr;
  public static boolean gks;
  public static String gkt;
  public static String gku;
  public static boolean gkv;
  public static boolean gkw;
  public static boolean gkx;
  public static boolean gky;
  public static boolean gkz;
  public static String glA;
  public static String glB;
  public static boolean glC;
  public static boolean glD;
  public static boolean glE;
  public static boolean glF;
  public static boolean glG;
  public static boolean glH;
  public static boolean glI;
  public static boolean glJ;
  public static boolean glK;
  public static boolean glL;
  public static boolean glM;
  private static HashMap<Integer, ConcurrentLinkedQueue<Integer>> glN;
  public static boolean glO;
  public static boolean glP;
  public static boolean glQ;
  public static boolean gla;
  public static boolean glb;
  public static int glc;
  public static boolean gld;
  public static boolean gle;
  public static boolean glf;
  public static boolean glg;
  public static boolean glh;
  public static boolean gli;
  public static boolean glj;
  public static boolean glk;
  public static boolean gll;
  public static String glm;
  public static int gln;
  public static boolean glo;
  public static boolean glp;
  public static int glq;
  public static boolean glr;
  public static String gls;
  public static float glt;
  public static float glu;
  public static boolean glv;
  public static String glw;
  public static String glx;
  public static boolean gly;
  public static boolean glz;
  public static double lat;
  public static double lng;
  
  static
  {
    AppMethodBeat.i(58737);
    gjY = false;
    gjZ = false;
    gka = false;
    gkb = false;
    gkc = false;
    gkd = false;
    gke = false;
    gkf = false;
    gkg = false;
    gkh = false;
    gki = false;
    gkj = false;
    gkk = "";
    gkl = false;
    gkm = false;
    gkn = false;
    gko = false;
    gkp = 0;
    gkq = false;
    gkr = false;
    gks = false;
    gkt = "";
    gku = "";
    gkv = false;
    gkw = false;
    gkx = false;
    gky = false;
    gkz = false;
    gkA = false;
    gkB = false;
    gkC = 0;
    gkD = 0;
    gkE = false;
    gkF = null;
    gkG = null;
    gkH = false;
    gkI = false;
    gkJ = 0;
    gkK = 0;
    gkL = 0;
    gkM = "";
    gkN = "";
    gkO = null;
    gkP = null;
    gkQ = false;
    gkR = false;
    gkS = false;
    gkT = false;
    lat = 0.0D;
    lng = 0.0D;
    gkU = "";
    gkV = "";
    gkW = "";
    gkX = "";
    gkY = "";
    gkZ = false;
    gla = false;
    glb = false;
    glc = 0;
    gld = false;
    gle = false;
    glf = false;
    glg = false;
    glh = false;
    gli = false;
    glj = true;
    glk = false;
    gll = false;
    glm = "";
    gln = 0;
    glo = false;
    glp = false;
    glq = -1;
    glr = false;
    gls = "";
    glt = 0.4F;
    glu = 0.7F;
    glv = false;
    glw = "";
    glx = "";
    gly = false;
    glz = false;
    glA = "";
    glB = "";
    glC = false;
    glD = false;
    glE = false;
    glF = false;
    glG = false;
    glH = false;
    glI = false;
    glJ = false;
    glK = false;
    glL = false;
    glM = false;
    glN = new HashMap();
    glO = false;
    glP = false;
    glQ = false;
    AppMethodBeat.o(58737);
  }
  
  public static void cM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(58736);
    synchronized (glN)
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue2 = (ConcurrentLinkedQueue)glN.get(Integer.valueOf(paramInt1));
      ConcurrentLinkedQueue localConcurrentLinkedQueue1 = localConcurrentLinkedQueue2;
      if (localConcurrentLinkedQueue2 == null)
      {
        localConcurrentLinkedQueue1 = new ConcurrentLinkedQueue();
        glN.put(Integer.valueOf(paramInt1), localConcurrentLinkedQueue1);
      }
      localConcurrentLinkedQueue1.add(Integer.valueOf(paramInt2));
      AppMethodBeat.o(58736);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.ae
 * JD-Core Version:    0.7.0.1
 */