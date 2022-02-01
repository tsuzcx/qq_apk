package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.ens;
import com.tencent.mm.protocal.protobuf.ent;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class JsApiUploadWeRunData
  extends d
{
  public static final int CTRL_INDEX = 323;
  public static final String NAME = "uploadWeRunData";
  private UploadMiniAppStepTask lCp;
  
  public void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45717);
    Log.d("MicroMsg.JsApiUploadWeRunData", "JsApiUploadWeRunData!");
    if (paramJSONObject == null)
    {
      paramf.i(paramInt, h("fail:data is null", null));
      Log.e("MicroMsg.JsApiUploadWeRunData", "data is null");
      AppMethodBeat.o(45717);
      return;
    }
    a(this, paramf, paramInt, paramJSONObject.optInt("step"), false);
    AppMethodBeat.o(45717);
  }
  
  public final void a(p paramp, f paramf, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(45718);
    if (paramInt2 <= 0)
    {
      paramf.i(paramInt1, paramp.h("fail:step invalid", null));
      AppMethodBeat.o(45718);
      return;
    }
    this.lCp = new UploadMiniAppStepTask(paramp, paramf, paramInt1, paramInt2, paramBoolean);
    this.lCp.bDJ();
    AppBrandMainProcessService.a(this.lCp);
    AppMethodBeat.o(45718);
  }
  
  static class UploadMiniAppStepTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<UploadMiniAppStepTask> CREATOR;
    private String appId;
    private boolean dGX;
    private p lAw;
    private f lAx;
    private int lCq;
    private boolean lCr;
    private int lqe;
    
    static
    {
      AppMethodBeat.i(45716);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45716);
    }
    
    public UploadMiniAppStepTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45710);
      f(paramParcel);
      AppMethodBeat.o(45710);
    }
    
    public UploadMiniAppStepTask(p paramp, f paramf, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(45709);
      Log.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask");
      this.lAw = paramp;
      this.lAx = paramf;
      this.lqe = paramInt1;
      this.lCq = paramInt2;
      this.lCr = paramBoolean;
      this.appId = paramf.getAppId();
      AppMethodBeat.o(45709);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(45711);
      long l2 = cl.aWy();
      Log.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask currentTime %d", new Object[] { Long.valueOf(l2 / 1000L) });
      long l1 = l2;
      if (l2 == 0L) {
        l1 = System.currentTimeMillis();
      }
      d.a locala = new d.a();
      ens localens = new ens();
      locala.iLN = localens;
      locala.iLO = new ent();
      locala.uri = "/cgi-bin/mmoc-bin/hardware/uploadminiappstep";
      locala.funcId = 1949;
      locala.iLP = 0;
      locala.respCmdId = 0;
      localens.jfi = this.appId;
      localens.oUu = this.lCq;
      localens.NlA = this.lCr;
      localens.hil = ((int)(l1 / 1000L));
      aa.a(locala.aXF(), new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
        {
          AppMethodBeat.i(45707);
          if (paramAnonymousq.getType() != 1949)
          {
            AppMethodBeat.o(45707);
            return 0;
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            JsApiUploadWeRunData.UploadMiniAppStepTask.a(JsApiUploadWeRunData.UploadMiniAppStepTask.this, true);
            Log.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask ok.");
          }
          for (;;)
          {
            JsApiUploadWeRunData.UploadMiniAppStepTask.a(JsApiUploadWeRunData.UploadMiniAppStepTask.this);
            AppMethodBeat.o(45707);
            return 0;
            JsApiUploadWeRunData.UploadMiniAppStepTask.a(JsApiUploadWeRunData.UploadMiniAppStepTask.this, false);
            Log.i("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask fail: errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          }
        }
      }, true);
      AppMethodBeat.o(45711);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(45712);
      if (this.dGX) {
        this.lAx.i(this.lqe, this.lAw.h("ok", null));
      }
      for (;;)
      {
        bDK();
        AppMethodBeat.o(45712);
        return;
        this.lAx.i(this.lqe, this.lAw.h("fail", null));
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45713);
      this.lCq = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.lCr = bool1;
        if (paramParcel.readByte() == 0) {
          break label62;
        }
      }
      label62:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.dGX = bool1;
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
      paramParcel.writeInt(this.lCq);
      if (this.lCr)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.dGX) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadWeRunData
 * JD-Core Version:    0.7.0.1
 */