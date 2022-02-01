package com.tencent.mm.app;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.p;

@Deprecated
public final class a
{
  private static String cQi;
  private static final a djA;
  private static final b djB;
  private static a djC;
  private static b djD;
  private static int djE;
  private static int djF;
  private static String djG;
  private static boolean djH;
  private static boolean djI;
  private static int djx;
  private static int djy;
  private static p djz;
  
  static
  {
    AppMethodBeat.i(19427);
    djx = 0;
    djy = 0;
    djz = new p(Process.myPid());
    djA = new a() {};
    djB = new b() {};
    djC = djA;
    djD = djB;
    djE = 4500;
    djF = 500;
    djG = "";
    djH = true;
    djI = false;
    cQi = "";
    AppMethodBeat.o(19427);
  }
  
  public static void VP() {}
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.a
 * JD-Core Version:    0.7.0.1
 */