package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jf;
import com.tencent.mm.g.a.jf.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckIsSupportFaceDetect
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 214;
  public static final String NAME = "checkIsSupportFacialRecognition";
  private GetIsSupportFaceTask kFE = null;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106565);
    ae.i("MicroMsg.JsApiCheckIsSupportFaceDetect", "hy: subapp start do check is support face detect");
    this.kFE = new GetIsSupportFaceTask(paramc, paramInt, this);
    this.kFE.biw();
    AppBrandMainProcessService.a(this.kFE);
    AppMethodBeat.o(106565);
  }
  
  static class GetIsSupportFaceTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportFaceTask> CREATOR;
    private int cgA;
    private boolean dLM;
    private int errCode;
    private String errMsg;
    private c jQp;
    private JsApiCheckIsSupportFaceDetect kFF;
    private int kFG;
    
    static
    {
      AppMethodBeat.i(106564);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106564);
    }
    
    protected GetIsSupportFaceTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106562);
      this.jQp = null;
      this.cgA = -1;
      this.dLM = false;
      this.errCode = -1;
      this.errMsg = "not returned";
      this.kFG = -1;
      e(paramParcel);
      AppMethodBeat.o(106562);
    }
    
    public GetIsSupportFaceTask(c paramc, int paramInt, JsApiCheckIsSupportFaceDetect paramJsApiCheckIsSupportFaceDetect)
    {
      this.jQp = null;
      this.cgA = -1;
      this.dLM = false;
      this.errCode = -1;
      this.errMsg = "not returned";
      this.kFG = -1;
      this.jQp = paramc;
      this.cgA = paramInt;
      this.kFF = paramJsApiCheckIsSupportFaceDetect;
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(106560);
      jf localjf = new jf();
      com.tencent.mm.sdk.b.a.IvT.l(localjf);
      this.dLM = localjf.dxb.dxc;
      this.errCode = localjf.dxb.dxd;
      this.errMsg = localjf.dxb.dxe;
      this.kFG = localjf.dxb.dxf;
      ae.i("MicroMsg.GetIsSupportFaceTask", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", new Object[] { Boolean.valueOf(this.dLM), Integer.valueOf(this.errCode), this.errMsg, Integer.valueOf(this.kFG) });
      biG();
      AppMethodBeat.o(106560);
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(106559);
      super.aOY();
      ae.d("MicroMsg.GetIsSupportFaceTask", "hy: callback. isSupport: %b, errCode: %d, errMsg: %s, libVersion: %d", new Object[] { Boolean.valueOf(this.dLM), Integer.valueOf(this.errCode), this.errMsg, Integer.valueOf(this.kFG) });
      HashMap localHashMap = new HashMap(3);
      localHashMap.put("errCode", Integer.valueOf(this.errCode));
      localHashMap.put("libVersionCode", Integer.valueOf(this.kFG));
      if (this.errCode == 0) {
        this.jQp.h(this.cgA, this.kFF.n("ok", localHashMap));
      }
      for (;;)
      {
        bix();
        AppMethodBeat.o(106559);
        return;
        this.jQp.h(this.cgA, this.kFF.n("fail " + this.errMsg, localHashMap));
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
        this.dLM = bool;
        this.errCode = paramParcel.readInt();
        this.errMsg = paramParcel.readString();
        this.kFG = paramParcel.readInt();
        AppMethodBeat.o(106563);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106561);
      super.writeToParcel(paramParcel, paramInt);
      if (this.dLM) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.errCode);
        paramParcel.writeString(this.errMsg);
        paramParcel.writeInt(this.kFG);
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