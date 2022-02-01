package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ju;
import com.tencent.mm.g.a.ju.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckIsSupportFaceDetect
  extends d
{
  public static final int CTRL_INDEX = 214;
  public static final String NAME = "checkIsSupportFacialRecognition";
  private GetIsSupportFaceTask lKf = null;
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106565);
    Log.i("MicroMsg.JsApiCheckIsSupportFaceDetect", "hy: subapp start do check is support face detect");
    this.lKf = new GetIsSupportFaceTask(paramf, paramInt, this);
    this.lKf.bDJ();
    AppBrandMainProcessService.a(this.lKf);
    AppMethodBeat.o(106565);
  }
  
  static class GetIsSupportFaceTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportFaceTask> CREATOR;
    private int csv;
    private boolean edB;
    private int errCode;
    private String errMsg;
    private f kSY;
    private JsApiCheckIsSupportFaceDetect lKg;
    private int lKh;
    
    static
    {
      AppMethodBeat.i(106564);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106564);
    }
    
    protected GetIsSupportFaceTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106562);
      this.kSY = null;
      this.csv = -1;
      this.edB = false;
      this.errCode = -1;
      this.errMsg = "not returned";
      this.lKh = -1;
      f(paramParcel);
      AppMethodBeat.o(106562);
    }
    
    public GetIsSupportFaceTask(f paramf, int paramInt, JsApiCheckIsSupportFaceDetect paramJsApiCheckIsSupportFaceDetect)
    {
      this.kSY = null;
      this.csv = -1;
      this.edB = false;
      this.errCode = -1;
      this.errMsg = "not returned";
      this.lKh = -1;
      this.kSY = paramf;
      this.csv = paramInt;
      this.lKg = paramJsApiCheckIsSupportFaceDetect;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(106560);
      ju localju = new ju();
      EventCenter.instance.publish(localju);
      this.edB = localju.dOI.dOJ;
      this.errCode = localju.dOI.dOK;
      this.errMsg = localju.dOI.dOL;
      this.lKh = localju.dOI.dOM;
      Log.i("MicroMsg.GetIsSupportFaceTask", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", new Object[] { Boolean.valueOf(this.edB), Integer.valueOf(this.errCode), this.errMsg, Integer.valueOf(this.lKh) });
      bDU();
      AppMethodBeat.o(106560);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(106559);
      super.bjk();
      Log.d("MicroMsg.GetIsSupportFaceTask", "hy: callback. isSupport: %b, errCode: %d, errMsg: %s, libVersion: %d", new Object[] { Boolean.valueOf(this.edB), Integer.valueOf(this.errCode), this.errMsg, Integer.valueOf(this.lKh) });
      HashMap localHashMap = new HashMap(3);
      localHashMap.put("errCode", Integer.valueOf(this.errCode));
      localHashMap.put("libVersionCode", Integer.valueOf(this.lKh));
      if (this.errCode == 0) {
        this.kSY.i(this.csv, this.lKg.n("ok", localHashMap));
      }
      for (;;)
      {
        bDK();
        AppMethodBeat.o(106559);
        return;
        this.kSY.i(this.csv, this.lKg.n("fail " + this.errMsg, localHashMap));
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(106563);
      super.f(paramParcel);
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.edB = bool;
        this.errCode = paramParcel.readInt();
        this.errMsg = paramParcel.readString();
        this.lKh = paramParcel.readInt();
        AppMethodBeat.o(106563);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106561);
      super.writeToParcel(paramParcel, paramInt);
      if (this.edB) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.errCode);
        paramParcel.writeString(this.errMsg);
        paramParcel.writeInt(this.lKh);
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