package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.ftt;
import com.tencent.mm.protocal.protobuf.ftu;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class JsApiUploadWeRunData
  extends c
{
  public static final int CTRL_INDEX = 323;
  public static final String NAME = "uploadWeRunData";
  private UploadMiniAppStepTask rBo;
  
  public void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45717);
    Log.d("MicroMsg.JsApiUploadWeRunData", "JsApiUploadWeRunData!");
    if (paramJSONObject == null)
    {
      paramf.callback(paramInt, ZP("fail:data is null"));
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
      paramf.callback(paramInt1, paramp.ZP("fail:step invalid"));
      AppMethodBeat.o(45718);
      return;
    }
    this.rBo = new UploadMiniAppStepTask(paramp, paramf, paramInt1, paramInt2, paramBoolean);
    this.rBo.bQt();
    AppMethodBeat.o(45718);
  }
  
  static class UploadMiniAppStepTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<UploadMiniAppStepTask> CREATOR;
    private String appId;
    private boolean hEn;
    private int rBp;
    private boolean rBq;
    private int ror;
    private p rzh;
    private f rzi;
    
    static
    {
      AppMethodBeat.i(45716);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45716);
    }
    
    public UploadMiniAppStepTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45710);
      h(paramParcel);
      AppMethodBeat.o(45710);
    }
    
    public UploadMiniAppStepTask(p paramp, f paramf, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(45709);
      Log.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask");
      this.rzh = paramp;
      this.rzi = paramf;
      this.ror = paramInt1;
      this.rBp = paramInt2;
      this.rBq = paramBoolean;
      this.appId = paramf.getAppId();
      AppMethodBeat.o(45709);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(45711);
      long l2 = cn.bDu();
      Log.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask currentTime %d", new Object[] { Long.valueOf(l2 / 1000L) });
      long l1 = l2;
      if (l2 == 0L) {
        l1 = System.currentTimeMillis();
      }
      c.a locala = new c.a();
      ftt localftt = new ftt();
      locala.otE = localftt;
      locala.otF = new ftu();
      locala.uri = "/cgi-bin/mmoc-bin/hardware/uploadminiappstep";
      locala.funcId = 1949;
      locala.otG = 0;
      locala.respCmdId = 0;
      localftt.oOI = this.appId;
      localftt.vhI = this.rBp;
      localftt.abRS = this.rBq;
      localftt.muB = ((int)(l1 / 1000L));
      z.a(locala.bEF(), new z.a()
      {
        public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(45707);
          if (paramAnonymousp.getType() != 1949)
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
    
    public final void bQr()
    {
      AppMethodBeat.i(45712);
      if (this.hEn) {
        this.rzi.callback(this.ror, this.rzh.ZP("ok"));
      }
      for (;;)
      {
        cpx();
        AppMethodBeat.o(45712);
        return;
        this.rzi.callback(this.ror, this.rzh.ZP("fail"));
      }
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45713);
      this.rBp = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.rBq = bool1;
        if (paramParcel.readByte() == 0) {
          break label62;
        }
      }
      label62:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.hEn = bool1;
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
      paramParcel.writeInt(this.rBp);
      if (this.rBq)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.hEn) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadWeRunData
 * JD-Core Version:    0.7.0.1
 */