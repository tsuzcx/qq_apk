package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.dng;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public class JsApiUploadWeRunData
  extends a
{
  public static final int CTRL_INDEX = 323;
  public static final String NAME = "uploadWeRunData";
  private UploadMiniAppStepTask kaq;
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45717);
    ac.d("MicroMsg.JsApiUploadWeRunData", "JsApiUploadWeRunData!");
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null", null));
      ac.e("MicroMsg.JsApiUploadWeRunData", "data is null");
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
    this.kaq = new UploadMiniAppStepTask(paramm, paramc, paramInt1, paramInt2, paramBoolean);
    this.kaq.bej();
    AppBrandMainProcessService.a(this.kaq);
    AppMethodBeat.o(45718);
  }
  
  static class UploadMiniAppStepTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<UploadMiniAppStepTask> CREATOR;
    private String appId;
    private boolean ddj;
    private int jOT;
    private m jXc;
    private c jYG;
    private int kar;
    private boolean kas;
    
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
      ac.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask");
      this.jXc = paramm;
      this.jYG = paramc;
      this.jOT = paramInt1;
      this.kar = paramInt2;
      this.kas = paramBoolean;
      this.appId = paramc.getAppId();
      AppMethodBeat.o(45709);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(45711);
      long l2 = ce.azH();
      ac.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask currentTime %d", new Object[] { Long.valueOf(l2 / 1000L) });
      long l1 = l2;
      if (l2 == 0L) {
        l1 = System.currentTimeMillis();
      }
      b.a locala = new b.a();
      dng localdng = new dng();
      locala.hvt = localdng;
      locala.hvu = new dnh();
      locala.uri = "/cgi-bin/mmoc-bin/hardware/uploadminiappstep";
      locala.funcId = 1949;
      locala.reqCmdId = 0;
      locala.respCmdId = 0;
      localdng.hOf = this.appId;
      localdng.ndH = this.kar;
      localdng.FUS = this.kas;
      localdng.fZy = ((int)(l1 / 1000L));
      x.a(locala.aAz(), new x.a()
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
            ac.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask ok.");
          }
          for (;;)
          {
            JsApiUploadWeRunData.UploadMiniAppStepTask.a(JsApiUploadWeRunData.UploadMiniAppStepTask.this);
            AppMethodBeat.o(45707);
            return 0;
            JsApiUploadWeRunData.UploadMiniAppStepTask.a(JsApiUploadWeRunData.UploadMiniAppStepTask.this, false);
            ac.i("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask fail: errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          }
        }
      }, true);
      AppMethodBeat.o(45711);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(45712);
      if (this.ddj) {
        this.jYG.h(this.jOT, this.jXc.e("ok", null));
      }
      for (;;)
      {
        bek();
        AppMethodBeat.o(45712);
        return;
        this.jYG.h(this.jOT, this.jXc.e("fail", null));
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45713);
      this.kar = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.kas = bool1;
        if (paramParcel.readByte() == 0) {
          break label62;
        }
      }
      label62:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.ddj = bool1;
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
      paramParcel.writeInt(this.kar);
      if (this.kas)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.ddj) {
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