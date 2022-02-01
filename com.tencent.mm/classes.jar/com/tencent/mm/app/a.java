package com.tencent.mm.app;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.p;

@Deprecated
public final class a
{
  private static String cDP;
  private static a cSA;
  private static b cSB;
  private static int cSC;
  private static int cSD;
  private static String cSE;
  private static boolean cSF;
  private static boolean cSG;
  private static int cSv;
  private static int cSw;
  private static p cSx;
  private static final a cSy;
  private static final b cSz;
  
  static
  {
    AppMethodBeat.i(19427);
    cSv = 0;
    cSw = 0;
    cSx = new p(Process.myPid());
    cSy = new a() {};
    cSz = new b() {};
    cSA = cSy;
    cSB = cSz;
    cSC = 4500;
    cSD = 500;
    cSE = "";
    cSF = true;
    cSG = false;
    cDP = "";
    AppMethodBeat.o(19427);
  }
  
  public static void Lu() {}
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.a
 * JD-Core Version:    0.7.0.1
 */