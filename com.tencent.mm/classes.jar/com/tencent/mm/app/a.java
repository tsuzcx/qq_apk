package com.tencent.mm.app;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.p;

@Deprecated
public final class a
{
  private static int cKj;
  private static int cKk;
  private static p cKl;
  private static final a cKm;
  private static final b cKn;
  private static a cKo;
  private static b cKp;
  private static int cKq;
  private static int cKr;
  private static String cKs;
  private static boolean cKt;
  private static boolean cKu;
  private static String cvL;
  
  static
  {
    AppMethodBeat.i(19427);
    cKj = 0;
    cKk = 0;
    cKl = new p(Process.myPid());
    cKm = new a() {};
    cKn = new b() {};
    cKo = cKm;
    cKp = cKn;
    cKq = 4500;
    cKr = 500;
    cKs = "";
    cKt = true;
    cKu = false;
    cvL = "";
    AppMethodBeat.o(19427);
  }
  
  public static void Kl() {}
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.a
 * JD-Core Version:    0.7.0.1
 */