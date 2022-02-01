package com.tencent.mm.app;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.p;

@Deprecated
public final class a
{
  private static String cEw;
  private static int cTf;
  private static int cTg;
  private static p cTh;
  private static final a cTi;
  private static final b cTj;
  private static a cTk;
  private static b cTl;
  private static int cTm;
  private static int cTn;
  private static String cTo;
  private static boolean cTp;
  private static boolean cTq;
  
  static
  {
    AppMethodBeat.i(19427);
    cTf = 0;
    cTg = 0;
    cTh = new p(Process.myPid());
    cTi = new a() {};
    cTj = new b() {};
    cTk = cTi;
    cTl = cTj;
    cTm = 4500;
    cTn = 500;
    cTo = "";
    cTp = true;
    cTq = false;
    cEw = "";
    AppMethodBeat.o(19427);
  }
  
  public static void LC() {}
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.a
 * JD-Core Version:    0.7.0.1
 */