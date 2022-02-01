package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.je.a;
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
  private GetIsSupportFaceTask kCp = null;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106565);
    ad.i("MicroMsg.JsApiCheckIsSupportFaceDetect", "hy: subapp start do check is support face detect");
    this.kCp = new GetIsSupportFaceTask(paramc, paramInt, this);
    this.kCp.bhN();
    AppBrandMainProcessService.a(this.kCp);
    AppMethodBeat.o(106565);
  }
  
  static class GetIsSupportFaceTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportFaceTask> CREATOR;
    private int cgA;
    private boolean dKx;
    private int errCode;
    private String errMsg;
    private JsApiCheckIsSupportFaceDetect kCq;
    private int kCr;
    private c kuU;
    
    static
    {
      AppMethodBeat.i(106564);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106564);
    }
    
    protected GetIsSupportFaceTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106562);
      this.kuU = null;
      this.cgA = -1;
      this.dKx = false;
      this.errCode = -1;
      this.errMsg = "not returned";
      this.kCr = -1;
      e(paramParcel);
      AppMethodBeat.o(106562);
    }
    
    public GetIsSupportFaceTask(c paramc, int paramInt, JsApiCheckIsSupportFaceDetect paramJsApiCheckIsSupportFaceDetect)
    {
      this.kuU = null;
      this.cgA = -1;
      this.dKx = false;
      this.errCode = -1;
      this.errMsg = "not returned";
      this.kCr = -1;
      this.kuU = paramc;
      this.cgA = paramInt;
      this.kCq = paramJsApiCheckIsSupportFaceDetect;
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(106560);
      je localje = new je();
      com.tencent.mm.sdk.b.a.IbL.l(localje);
      this.dKx = localje.dvW.dvX;
      this.errCode = localje.dvW.dvY;
      this.errMsg = localje.dvW.dvZ;
      this.kCr = localje.dvW.dwa;
      ad.i("MicroMsg.GetIsSupportFaceTask", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", new Object[] { Boolean.valueOf(this.dKx), Integer.valueOf(this.errCode), this.errMsg, Integer.valueOf(this.kCr) });
      bhX();
      AppMethodBeat.o(106560);
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(106559);
      super.aOB();
      ad.d("MicroMsg.GetIsSupportFaceTask", "hy: callback. isSupport: %b, errCode: %d, errMsg: %s, libVersion: %d", new Object[] { Boolean.valueOf(this.dKx), Integer.valueOf(this.errCode), this.errMsg, Integer.valueOf(this.kCr) });
      HashMap localHashMap = new HashMap(3);
      localHashMap.put("errCode", Integer.valueOf(this.errCode));
      localHashMap.put("libVersionCode", Integer.valueOf(this.kCr));
      if (this.errCode == 0) {
        this.kuU.h(this.cgA, this.kCq.m("ok", localHashMap));
      }
      for (;;)
      {
        bhO();
        AppMethodBeat.o(106559);
        return;
        this.kuU.h(this.cgA, this.kCq.m("fail " + this.errMsg, localHashMap));
      }
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
        this.dKx = bool;
        this.errCode = paramParcel.readInt();
        this.errMsg = paramParcel.readString();
        this.kCr = paramParcel.readInt();
        AppMethodBeat.o(106563);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106561);
      super.writeToParcel(paramParcel, paramInt);
      if (this.dKx) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.errCode);
        paramParcel.writeString(this.errMsg);
        paramParcel.writeInt(this.kCr);
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