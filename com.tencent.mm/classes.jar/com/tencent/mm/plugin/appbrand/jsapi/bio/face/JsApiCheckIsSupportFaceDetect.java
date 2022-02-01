package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.lo;
import com.tencent.mm.autogen.a.lo.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckIsSupportFaceDetect
  extends c
{
  public static final int CTRL_INDEX = 214;
  public static final String NAME = "checkIsSupportFacialRecognition";
  private GetIsSupportFaceTask rJu = null;
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106565);
    Log.i("MicroMsg.JsApiCheckIsSupportFaceDetect", "hy: subapp start do check is support face detect");
    this.rJu = new GetIsSupportFaceTask(paramf, paramInt, this);
    this.rJu.bQt();
    AppMethodBeat.o(106565);
  }
  
  static class GetIsSupportFaceTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportFaceTask> CREATOR;
    private int eit;
    private int errCode;
    private String errMsg;
    private boolean idL;
    private f qNp;
    private JsApiCheckIsSupportFaceDetect rJv;
    private int rJw;
    
    static
    {
      AppMethodBeat.i(106564);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106564);
    }
    
    protected GetIsSupportFaceTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106562);
      this.qNp = null;
      this.eit = -1;
      this.idL = false;
      this.errCode = -1;
      this.errMsg = "not returned";
      this.rJw = -1;
      h(paramParcel);
      AppMethodBeat.o(106562);
    }
    
    public GetIsSupportFaceTask(f paramf, int paramInt, JsApiCheckIsSupportFaceDetect paramJsApiCheckIsSupportFaceDetect)
    {
      this.qNp = null;
      this.eit = -1;
      this.idL = false;
      this.errCode = -1;
      this.errMsg = "not returned";
      this.rJw = -1;
      this.qNp = paramf;
      this.eit = paramInt;
      this.rJv = paramJsApiCheckIsSupportFaceDetect;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(106560);
      lo locallo = new lo();
      locallo.publish();
      this.idL = locallo.hNt.hNu;
      this.errCode = locallo.hNt.hNv;
      this.errMsg = locallo.hNt.hNw;
      this.rJw = locallo.hNt.hNx;
      Log.i("MicroMsg.GetIsSupportFaceTask", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", new Object[] { Boolean.valueOf(this.idL), Integer.valueOf(this.errCode), this.errMsg, Integer.valueOf(this.rJw) });
      cpA();
      AppMethodBeat.o(106560);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(106559);
      super.bQr();
      Log.d("MicroMsg.GetIsSupportFaceTask", "hy: callback. isSupport: %b, errCode: %d, errMsg: %s, libVersion: %d", new Object[] { Boolean.valueOf(this.idL), Integer.valueOf(this.errCode), this.errMsg, Integer.valueOf(this.rJw) });
      HashMap localHashMap = new HashMap(3);
      localHashMap.put("errCode", Integer.valueOf(this.errCode));
      localHashMap.put("libVersionCode", Integer.valueOf(this.rJw));
      if (this.errCode == 0) {
        this.qNp.callback(this.eit, this.rJv.m("ok", localHashMap));
      }
      for (;;)
      {
        cpx();
        AppMethodBeat.o(106559);
        return;
        this.qNp.callback(this.eit, this.rJv.m("fail " + this.errMsg, localHashMap));
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(106563);
      super.h(paramParcel);
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.idL = bool;
        this.errCode = paramParcel.readInt();
        this.errMsg = paramParcel.readString();
        this.rJw = paramParcel.readInt();
        AppMethodBeat.o(106563);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106561);
      super.writeToParcel(paramParcel, paramInt);
      if (this.idL) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.errCode);
        paramParcel.writeString(this.errMsg);
        paramParcel.writeInt(this.rJw);
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