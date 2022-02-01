package com.tencent.mm.app;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.p;

@Deprecated
public final class a
{
  private static String eMg;
  private static int heE;
  private static int heF;
  private static p heG;
  private static final a heH;
  private static final b heI;
  private static a heJ;
  private static b heK;
  private static int heL;
  private static int heM;
  private static String heN;
  private static boolean heO;
  private static boolean heP;
  
  static
  {
    AppMethodBeat.i(19427);
    heE = 0;
    heF = 0;
    heG = new p(Process.myPid());
    heH = new a() {};
    heI = new b() {};
    heJ = heH;
    heK = heI;
    heL = 4500;
    heM = 500;
    heN = "";
    heO = true;
    heP = false;
    eMg = "";
    AppMethodBeat.o(19427);
  }
  
  public static void aBO() {}
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.app.a
 * JD-Core Version:    0.7.0.1
 */