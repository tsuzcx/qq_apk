package com.tencent.mm.app;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.p;

@Deprecated
public final class a
{
  private static String cQP;
  private static int fbe;
  private static int fbf;
  private static p fbg;
  private static final a fbh;
  private static final b fbi;
  private static a fbj;
  private static b fbk;
  private static int fbl;
  private static int fbm;
  private static String fbn;
  private static boolean fbo;
  private static boolean fbp;
  
  static
  {
    AppMethodBeat.i(19427);
    fbe = 0;
    fbf = 0;
    fbg = new p(Process.myPid());
    fbh = new a() {};
    fbi = new b() {};
    fbj = fbh;
    fbk = fbi;
    fbl = 4500;
    fbm = 500;
    fbn = "";
    fbo = true;
    fbp = false;
    cQP = "";
    AppMethodBeat.o(19427);
  }
  
  public static void aak() {}
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.a
 * JD-Core Version:    0.7.0.1
 */