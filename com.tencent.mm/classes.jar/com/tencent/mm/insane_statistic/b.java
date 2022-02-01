package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.b;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.tm;
import com.tencent.mm.g.d;
import com.tencent.mm.modelimage.h;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelimage.v.a;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.ftv;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;

public final class b
  implements v.a
{
  public final void a(long paramLong, cc paramcc, c paramc, int paramInt, boolean paramBoolean, d paramd, String paramString)
  {
    AppMethodBeat.i(231517);
    paramc = new a(paramLong, paramcc, paramc, paramBoolean, paramInt, paramString);
    paramc.mxT = 1;
    if ((paramc.mxR) || ((!paramc.mxV) && (paramc.mxT == 0)))
    {
      AppMethodBeat.o(231517);
      return;
    }
    paramc.mxU = paramd;
    paramc.mxR = true;
    paramcc = (ftv)c.b.b(paramc.rr.otB);
    if (paramcc.YFF != null)
    {
      paramcc = paramcc.YFF.abwM;
      if ((Util.isNullOrNil(paramcc)) || (!au.bwE(paramcc))) {
        break label280;
      }
      paramInt = 1;
      label120:
      paramcc = new StringBuilder("2,");
      if (paramInt == 0) {
        break label286;
      }
    }
    label280:
    label286:
    for (paramInt = 2;; paramInt = 1)
    {
      paramc.mxQ = (paramInt + ",,");
      if (paramc.mxP == null) {
        paramc.mxP = r.bKa().b(Long.valueOf(paramc.mxN));
      }
      paramcc = paramc.mxP;
      if (paramcc != null)
      {
        paramd = new tm();
        paramc.mxW.alive();
        paramc.mxX.alive();
        paramc.mxS = r.bKa().v(paramcc.oGr, "", "");
        paramd.hXd.hBk = System.nanoTime();
        paramd.hXd.filePath = paramc.mxS;
        paramd.publish();
      }
      AppMethodBeat.o(231517);
      return;
      paramcc = "";
      break;
      paramInt = 0;
      break label120;
    }
  }
  
  static final class a
  {
    cc hzO;
    long mxN;
    int mxO;
    h mxP;
    String mxQ;
    boolean mxR;
    String mxS;
    int mxT;
    d mxU;
    boolean mxV;
    IListener mxW;
    IListener mxX;
    final c rr;
    private String uuid;
    
    a(long paramLong, cc paramcc, c paramc, boolean paramBoolean, int paramInt, String paramString)
    {
      AppMethodBeat.i(231509);
      this.hzO = null;
      this.mxR = false;
      this.mxT = 0;
      this.mxV = false;
      this.mxW = new OnNetSceneUploadMsgImgEnd.ProcessOnNetSceneUploadMsgImgEnd.1(this, f.hfK);
      this.mxX = new OnNetSceneUploadMsgImgEnd.ProcessOnNetSceneUploadMsgImgEnd.2(this, f.hfK);
      this.mxN = paramLong;
      this.hzO = paramcc;
      this.rr = paramc;
      this.mxO = paramInt;
      this.mxV = paramBoolean;
      this.uuid = paramString;
      AppMethodBeat.o(231509);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.insane_statistic.b
 * JD-Core Version:    0.7.0.1
 */