package com.tencent.ilink.tdi;

import com.google.d.am.a;
import com.google.d.am.g;
import com.google.d.bg.e;
import com.google.d.bj.d;
import com.google.d.cw;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class a
{
  private static am.g descriptor;
  private static final bg.e edA;
  private static final am.a edB;
  private static final bg.e edC;
  private static final am.a edD;
  private static final bg.e edE;
  private static final am.a edF;
  private static final bg.e edG;
  private static final am.a edr;
  private static final bg.e eds;
  private static final am.a edt;
  private static final bg.e edu;
  private static final am.a edv;
  private static final bg.e edw;
  private static final am.a edx;
  private static final bg.e edy;
  private static final am.a edz;
  
  static
  {
    AppMethodBeat.i(214012);
    am.g localg = am.g.a(new String[] { "" }, new am.g[0]);
    descriptor = localg;
    edr = (am.a)localg.ahs().get(0);
    eds = new bg.e(edr, new String[] { "ColorImage", "DepthImage", "InfraredImage", "KeyPoints", "FaceRect" });
    edt = (am.a)descriptor.ahs().get(1);
    edu = new bg.e(edt, new String[] { "XCoordinates", "YCoordinates", "Image" });
    edv = (am.a)descriptor.ahs().get(2);
    edw = new bg.e(edv, new String[] { "Frames", "Action" });
    edx = (am.a)descriptor.ahs().get(3);
    edy = new bg.e(edx, new String[] { "Vs", "Encrypt" });
    edz = (am.a)descriptor.ahs().get(4);
    edA = new bg.e(edz, new String[] { "Deviceid", "Actions", "Tmstamp", "Randstr", "Checkstr" });
    edB = (am.a)descriptor.ahs().get(5);
    edC = new bg.e(edB, new String[] { "Encrypt" });
    edD = (am.a)descriptor.ahs().get(6);
    edE = new bg.e(edD, new String[] { "LeftEyeX", "LeftEyeY", "RightEyeX", "RightEyeY", "NoseX", "NoseY", "LeftMouthX", "LeftMouthY", "RightMouthX", "RightMouthY" });
    edF = (am.a)descriptor.ahs().get(7);
    edG = new bg.e(edF, new String[] { "FaceX", "FaceY", "FaceWidth", "FaceHeight" });
    AppMethodBeat.o(214012);
  }
  
  public static am.g getDescriptor()
  {
    return descriptor;
  }
  
  public static enum b
    implements cw
  {
    private static final bj.d<b> dLG;
    private static final b[] edW;
    final int value;
    
    static
    {
      AppMethodBeat.i(214029);
      edS = new b("kFaceRecognizeTypeRes_Non", 0, 0);
      edT = new b("kFaceRecognizeTypeRes_WxPay", 1, 1);
      edU = new b("kFaceRecognizeTypeRes_WxBase", 2, 2);
      edV = new b("kFaceRecognizeTypeRes_WxPayBaseAll", 3, 3);
      edX = new b[] { edS, edT, edU, edV };
      dLG = new bj.d() {};
      edW = values();
      AppMethodBeat.o(214029);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
    
    @Deprecated
    public static b md(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return edS;
      case 1: 
        return edT;
      case 2: 
        return edU;
      }
      return edV;
    }
    
    public final int getNumber()
    {
      return this.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.ilink.tdi.a
 * JD-Core Version:    0.7.0.1
 */