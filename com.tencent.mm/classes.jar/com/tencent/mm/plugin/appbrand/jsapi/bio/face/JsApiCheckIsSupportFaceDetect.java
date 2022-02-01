package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.a.ip.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckIsSupportFaceDetect
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 214;
  public static final String NAME = "checkIsSupportFacialRecognition";
  private GetIsSupportFaceTask jGZ = null;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106565);
    ad.i("MicroMsg.JsApiCheckIsSupportFaceDetect", "hy: subapp start do check is support face detect");
    this.jGZ = new GetIsSupportFaceTask(paramc, paramInt, this);
    this.jGZ.aXm();
    AppBrandMainProcessService.a(this.jGZ);
    AppMethodBeat.o(106565);
  }
  
  static class GetIsSupportFaceTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportFaceTask> CREATOR;
    private int bZo;
    private boolean dAy;
    private int errCode;
    private String errMsg;
    private c jAc;
    private JsApiCheckIsSupportFaceDetect jHa;
    private int jHb;
    
    static
    {
      AppMethodBeat.i(106564);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106564);
    }
    
    protected GetIsSupportFaceTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106562);
      this.jAc = null;
      this.bZo = -1;
      this.dAy = false;
      this.errCode = -1;
      this.errMsg = "not returned";
      this.jHb = -1;
      e(paramParcel);
      AppMethodBeat.o(106562);
    }
    
    public GetIsSupportFaceTask(c paramc, int paramInt, JsApiCheckIsSupportFaceDetect paramJsApiCheckIsSupportFaceDetect)
    {
      this.jAc = null;
      this.bZo = -1;
      this.dAy = false;
      this.errCode = -1;
      this.errMsg = "not returned";
      this.jHb = -1;
      this.jAc = paramc;
      this.bZo = paramInt;
      this.jHa = paramJsApiCheckIsSupportFaceDetect;
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(106559);
      super.aEA();
      ad.d("MicroMsg.GetIsSupportFaceTask", "hy: callback. isSupport: %b, errCode: %d, errMsg: %s, libVersion: %d", new Object[] { Boolean.valueOf(this.dAy), Integer.valueOf(this.errCode), this.errMsg, Integer.valueOf(this.jHb) });
      HashMap localHashMap = new HashMap(3);
      localHashMap.put("errCode", Integer.valueOf(this.errCode));
      localHashMap.put("libVersionCode", Integer.valueOf(this.jHb));
      if (this.errCode == 0) {
        this.jAc.h(this.bZo, this.jHa.k("ok", localHashMap));
      }
      for (;;)
      {
        aXn();
        AppMethodBeat.o(106559);
        return;
        this.jAc.h(this.bZo, this.jHa.k("fail " + this.errMsg, localHashMap));
      }
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(106560);
      ip localip = new ip();
      com.tencent.mm.sdk.b.a.ESL.l(localip);
      this.dAy = localip.dmB.dmC;
      this.errCode = localip.dmB.dmD;
      this.errMsg = localip.dmB.dmE;
      this.jHb = localip.dmB.dmF;
      ad.i("MicroMsg.GetIsSupportFaceTask", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", new Object[] { Boolean.valueOf(this.dAy), Integer.valueOf(this.errCode), this.errMsg, Integer.valueOf(this.jHb) });
      aXw();
      AppMethodBeat.o(106560);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(106563);
      super.e(paramParcel);
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.dAy = bool;
        this.errCode = paramParcel.readInt();
        this.errMsg = paramParcel.readString();
        this.jHb = paramParcel.readInt();
        AppMethodBeat.o(106563);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106561);
      super.writeToParcel(paramParcel, paramInt);
      if (this.dAy) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.errCode);
        paramParcel.writeString(this.errMsg);
        paramParcel.writeInt(this.jHb);
        AppMethodBeat.o(106561);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect
 * JD-Core Version:    0.7.0.1
 */