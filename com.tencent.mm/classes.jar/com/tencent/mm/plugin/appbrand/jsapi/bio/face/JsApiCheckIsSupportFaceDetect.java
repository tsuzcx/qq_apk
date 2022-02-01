package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.kk;
import com.tencent.mm.f.a.kk.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckIsSupportFaceDetect
  extends c
{
  public static final int CTRL_INDEX = 214;
  public static final String NAME = "checkIsSupportFacialRecognition";
  private GetIsSupportFaceTask oGv = null;
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106565);
    Log.i("MicroMsg.JsApiCheckIsSupportFaceDetect", "hy: subapp start do check is support face detect");
    this.oGv = new GetIsSupportFaceTask(parame, paramInt, this);
    this.oGv.bsM();
    AppMethodBeat.o(106565);
  }
  
  static class GetIsSupportFaceTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportFaceTask> CREATOR;
    private int cqA;
    private int errCode;
    private String errMsg;
    private boolean fXK;
    private e nNw;
    private JsApiCheckIsSupportFaceDetect oGw;
    private int oGx;
    
    static
    {
      AppMethodBeat.i(106564);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106564);
    }
    
    protected GetIsSupportFaceTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106562);
      this.nNw = null;
      this.cqA = -1;
      this.fXK = false;
      this.errCode = -1;
      this.errMsg = "not returned";
      this.oGx = -1;
      f(paramParcel);
      AppMethodBeat.o(106562);
    }
    
    public GetIsSupportFaceTask(e parame, int paramInt, JsApiCheckIsSupportFaceDetect paramJsApiCheckIsSupportFaceDetect)
    {
      this.nNw = null;
      this.cqA = -1;
      this.fXK = false;
      this.errCode = -1;
      this.errMsg = "not returned";
      this.oGx = -1;
      this.nNw = parame;
      this.cqA = paramInt;
      this.oGw = paramJsApiCheckIsSupportFaceDetect;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(106560);
      kk localkk = new kk();
      EventCenter.instance.publish(localkk);
      this.fXK = localkk.fHT.fHU;
      this.errCode = localkk.fHT.fHV;
      this.errMsg = localkk.fHT.fHW;
      this.oGx = localkk.fHT.fHX;
      Log.i("MicroMsg.GetIsSupportFaceTask", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", new Object[] { Boolean.valueOf(this.fXK), Integer.valueOf(this.errCode), this.errMsg, Integer.valueOf(this.oGx) });
      bPt();
      AppMethodBeat.o(106560);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(106559);
      super.bsK();
      Log.d("MicroMsg.GetIsSupportFaceTask", "hy: callback. isSupport: %b, errCode: %d, errMsg: %s, libVersion: %d", new Object[] { Boolean.valueOf(this.fXK), Integer.valueOf(this.errCode), this.errMsg, Integer.valueOf(this.oGx) });
      HashMap localHashMap = new HashMap(3);
      localHashMap.put("errCode", Integer.valueOf(this.errCode));
      localHashMap.put("libVersionCode", Integer.valueOf(this.oGx));
      if (this.errCode == 0) {
        this.nNw.j(this.cqA, this.oGw.m("ok", localHashMap));
      }
      for (;;)
      {
        bPk();
        AppMethodBeat.o(106559);
        return;
        this.nNw.j(this.cqA, this.oGw.m("fail " + this.errMsg, localHashMap));
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
        this.fXK = bool;
        this.errCode = paramParcel.readInt();
        this.errMsg = paramParcel.readString();
        this.oGx = paramParcel.readInt();
        AppMethodBeat.o(106563);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106561);
      super.writeToParcel(paramParcel, paramInt);
      if (this.fXK) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.errCode);
        paramParcel.writeString(this.errMsg);
        paramParcel.writeInt(this.oGx);
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