package com.tencent.mm.app;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.p;

@Deprecated
public final class a
{
  private static String cHA;
  private static boolean cHB;
  private static boolean cHC;
  private static int cHr;
  private static int cHs;
  private static p cHt;
  private static final a cHu;
  private static final b cHv;
  private static a cHw;
  private static b cHx;
  private static int cHy;
  private static int cHz;
  private static String csT;
  
  static
  {
    AppMethodBeat.i(19427);
    cHr = 0;
    cHs = 0;
    cHt = new p(Process.myPid());
    cHu = new a() {};
    cHv = new b() {};
    cHw = cHu;
    cHx = cHv;
    cHy = 4500;
    cHz = 500;
    cHA = "";
    cHB = true;
    cHC = false;
    csT = "";
    AppMethodBeat.o(19427);
  }
  
  public static void JV() {}
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.a
 * JD-Core Version:    0.7.0.1
 */