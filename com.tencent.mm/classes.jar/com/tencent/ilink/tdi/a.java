package com.tencent.ilink.tdi;

import com.google.b.aj.a;
import com.google.b.aj.g;
import com.google.b.bb.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class a
{
  private static aj.g bQR;
  private static final bb.e cmA;
  private static final aj.a cml;
  private static final bb.e cmm;
  private static final aj.a cmn;
  private static final bb.e cmo;
  private static final aj.a cmp;
  private static final bb.e cmq;
  private static final aj.a cmr;
  private static final bb.e cms;
  private static final aj.a cmt;
  private static final bb.e cmu;
  private static final aj.a cmv;
  private static final bb.e cmw;
  private static final aj.a cmx;
  private static final bb.e cmy;
  private static final aj.a cmz;
  
  static
  {
    AppMethodBeat.i(218332);
    aj.g localg = aj.g.a(new String[] { "" }, new aj.g[0]);
    bQR = localg;
    cml = (aj.a)localg.Hw().get(0);
    cmm = new bb.e(cml, new String[] { "ColorImage", "DepthImage", "InfraredImage", "KeyPoints", "FaceRect" });
    cmn = (aj.a)bQR.Hw().get(1);
    cmo = new bb.e(cmn, new String[] { "XCoordinates", "YCoordinates", "Image" });
    cmp = (aj.a)bQR.Hw().get(2);
    cmq = new bb.e(cmp, new String[] { "Frames", "Action" });
    cmr = (aj.a)bQR.Hw().get(3);
    cms = new bb.e(cmr, new String[] { "Vs", "Encrypt" });
    cmt = (aj.a)bQR.Hw().get(4);
    cmu = new bb.e(cmt, new String[] { "Deviceid", "Actions", "Tmstamp", "Randstr", "Checkstr" });
    cmv = (aj.a)bQR.Hw().get(5);
    cmw = new bb.e(cmv, new String[] { "Encrypt" });
    cmx = (aj.a)bQR.Hw().get(6);
    cmy = new bb.e(cmx, new String[] { "LeftEyeX", "LeftEyeY", "RightEyeX", "RightEyeY", "NoseX", "NoseY", "LeftMouthX", "LeftMouthY", "RightMouthX", "RightMouthY" });
    cmz = (aj.a)bQR.Hw().get(7);
    cmA = new bb.e(cmz, new String[] { "FaceX", "FaceY", "FaceWidth", "FaceHeight" });
    AppMethodBeat.o(218332);
  }
  
  public static aj.g Ls()
  {
    return bQR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ilink.tdi.a
 * JD-Core Version:    0.7.0.1
 */