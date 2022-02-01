package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.dhr;
import com.tencent.mm.protocal.protobuf.dhs;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public class JsApiUploadWeRunData
  extends a
{
  public static final int CTRL_INDEX = 323;
  public static final String NAME = "uploadWeRunData";
  private UploadMiniAppStepTask jzU;
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45717);
    ad.d("MicroMsg.JsApiUploadWeRunData", "JsApiUploadWeRunData!");
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null", null));
      ad.e("MicroMsg.JsApiUploadWeRunData", "data is null");
      AppMethodBeat.o(45717);
      return;
    }
    a(this, paramc, paramInt, paramJSONObject.optInt("step"), false);
    AppMethodBeat.o(45717);
  }
  
  public final void a(m paramm, c paramc, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(45718);
    if (paramInt2 <= 0)
    {
      paramc.h(paramInt1, paramm.e("fail:step invalid", null));
      AppMethodBeat.o(45718);
      return;
    }
    this.jzU = new UploadMiniAppStepTask(paramm, paramc, paramInt1, paramInt2, paramBoolean);
    this.jzU.aXm();
    AppBrandMainProcessService.a(this.jzU);
    AppMethodBeat.o(45718);
  }
  
  static class UploadMiniAppStepTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<UploadMiniAppStepTask> CREATOR;
    private String appId;
    private boolean dfO;
    private int joH;
    private m jwG;
    private c jyl;
    private int jzV;
    private boolean jzW;
    
    static
    {
      AppMethodBeat.i(45716);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45716);
    }
    
    public UploadMiniAppStepTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45710);
      e(paramParcel);
      AppMethodBeat.o(45710);
    }
    
    public UploadMiniAppStepTask(m paramm, c paramc, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(45709);
      ad.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask");
      this.jwG = paramm;
      this.jyl = paramc;
      this.joH = paramInt1;
      this.jzV = paramInt2;
      this.jzW = paramBoolean;
      this.appId = paramc.getAppId();
      AppMethodBeat.o(45709);
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(45712);
      if (this.dfO) {
        this.jyl.h(this.joH, this.jwG.e("ok", null));
      }
      for (;;)
      {
        aXn();
        AppMethodBeat.o(45712);
        return;
        this.jyl.h(this.joH, this.jwG.e("fail", null));
      }
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(45711);
      long l2 = ce.asQ();
      ad.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask currentTime %d", new Object[] { Long.valueOf(l2 / 1000L) });
      long l1 = l2;
      if (l2 == 0L) {
        l1 = System.currentTimeMillis();
      }
      b.a locala = new b.a();
      dhr localdhr = new dhr();
      locala.gUU = localdhr;
      locala.gUV = new dhs();
      locala.uri = "/cgi-bin/mmoc-bin/hardware/uploadminiappstep";
      locala.funcId = 1949;
      locala.reqCmdId = 0;
      locala.respCmdId = 0;
      localdhr.hnC = this.appId;
      localdhr.mBG = this.jzV;
      localdhr.ExQ = this.jzW;
      localdhr.fVD = ((int)(l1 / 1000L));
      x.a(locala.atI(), new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(45707);
          if (paramAnonymousn.getType() != 1949)
          {
            AppMethodBeat.o(45707);
            return 0;
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            JsApiUploadWeRunData.UploadMiniAppStepTask.a(JsApiUploadWeRunData.UploadMiniAppStepTask.this, true);
            ad.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask ok.");
          }
          for (;;)
          {
            JsApiUploadWeRunData.UploadMiniAppStepTask.a(JsApiUploadWeRunData.UploadMiniAppStepTask.this);
            AppMethodBeat.o(45707);
            return 0;
            JsApiUploadWeRunData.UploadMiniAppStepTask.a(JsApiUploadWeRunData.UploadMiniAppStepTask.this, false);
            ad.i("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask fail: errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          }
        }
      }, true);
      AppMethodBeat.o(45711);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45713);
      this.jzV = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.jzW = bool1;
        if (paramParcel.readByte() == 0) {
          break label62;
        }
      }
      label62:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.dfO = bool1;
        this.appId = paramParcel.readString();
        AppMethodBeat.o(45713);
        return;
        bool1 = false;
        break;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      AppMethodBeat.i(45714);
      paramParcel.writeInt(this.jzV);
      if (this.jzW)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.dfO) {
          break label64;
        }
      }
      label64:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        paramParcel.writeString(this.appId);
        AppMethodBeat.o(45714);
        return;
        b1 = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadWeRunData
 * JD-Core Version:    0.7.0.1
 */