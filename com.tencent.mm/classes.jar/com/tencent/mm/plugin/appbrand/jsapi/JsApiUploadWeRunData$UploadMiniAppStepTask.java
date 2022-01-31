package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.w;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.protocal.protobuf.com;
import com.tencent.mm.sdk.platformtools.ab;

class JsApiUploadWeRunData$UploadMiniAppStepTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<UploadMiniAppStepTask> CREATOR;
  private String appId;
  private boolean cqS;
  private int hAu;
  private boolean hAv;
  private int hry;
  private m hxs;
  private c hyO;
  
  static
  {
    AppMethodBeat.i(130630);
    CREATOR = new JsApiUploadWeRunData.UploadMiniAppStepTask.2();
    AppMethodBeat.o(130630);
  }
  
  public JsApiUploadWeRunData$UploadMiniAppStepTask(Parcel paramParcel)
  {
    AppMethodBeat.i(130624);
    f(paramParcel);
    AppMethodBeat.o(130624);
  }
  
  public JsApiUploadWeRunData$UploadMiniAppStepTask(m paramm, c paramc, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(130623);
    ab.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask");
    this.hxs = paramm;
    this.hyO = paramc;
    this.hry = paramInt1;
    this.hAu = paramInt2;
    this.hAv = paramBoolean;
    this.appId = paramc.getAppId();
    AppMethodBeat.o(130623);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130625);
    long l2 = cb.abp();
    ab.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask currentTime %d", new Object[] { Long.valueOf(l2 / 1000L) });
    long l1 = l2;
    if (l2 == 0L) {
      l1 = System.currentTimeMillis();
    }
    b.a locala = new b.a();
    col localcol = new col();
    locala.fsX = localcol;
    locala.fsY = new com();
    locala.uri = "/cgi-bin/mmoc-bin/hardware/uploadminiappstep";
    locala.funcId = 1949;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    localcol.fKw = this.appId;
    localcol.jKr = this.hAu;
    localcol.xXj = this.hAv;
    localcol.nrR = ((int)(l1 / 1000L));
    w.a(locala.ado(), new JsApiUploadWeRunData.UploadMiniAppStepTask.1(this), true);
    AppMethodBeat.o(130625);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(130626);
    if (this.cqS) {
      this.hyO.h(this.hry, this.hxs.j("ok", null));
    }
    for (;;)
    {
      aBk();
      AppMethodBeat.o(130626);
      return;
      this.hyO.h(this.hry, this.hxs.j("fail", null));
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(130627);
    this.hAu = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.hAv = bool1;
      if (paramParcel.readByte() == 0) {
        break label62;
      }
    }
    label62:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.cqS = bool1;
      this.appId = paramParcel.readString();
      AppMethodBeat.o(130627);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(130628);
    paramParcel.writeInt(this.hAu);
    if (this.hAv)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.cqS) {
        break label64;
      }
    }
    label64:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.appId);
      AppMethodBeat.o(130628);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadWeRunData.UploadMiniAppStepTask
 * JD-Core Version:    0.7.0.1
 */