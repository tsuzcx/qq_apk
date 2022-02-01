package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.iw;
import com.tencent.mm.g.a.iw.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckIsSupportFaceDetect
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 214;
  public static final String NAME = "checkIsSupportFacialRecognition";
  private GetIsSupportFaceTask khy = null;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106565);
    ac.i("MicroMsg.JsApiCheckIsSupportFaceDetect", "hy: subapp start do check is support face detect");
    this.khy = new GetIsSupportFaceTask(paramc, paramInt, this);
    this.khy.bej();
    AppBrandMainProcessService.a(this.khy);
    AppMethodBeat.o(106565);
  }
  
  static class GetIsSupportFaceTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportFaceTask> CREATOR;
    private int bWl;
    private boolean dyk;
    private int errCode;
    private String errMsg;
    private c kay;
    private int khA;
    private JsApiCheckIsSupportFaceDetect khz;
    
    static
    {
      AppMethodBeat.i(106564);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106564);
    }
    
    protected GetIsSupportFaceTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106562);
      this.kay = null;
      this.bWl = -1;
      this.dyk = false;
      this.errCode = -1;
      this.errMsg = "not returned";
      this.khA = -1;
      e(paramParcel);
      AppMethodBeat.o(106562);
    }
    
    public GetIsSupportFaceTask(c paramc, int paramInt, JsApiCheckIsSupportFaceDetect paramJsApiCheckIsSupportFaceDetect)
    {
      this.kay = null;
      this.bWl = -1;
      this.dyk = false;
      this.errCode = -1;
      this.errMsg = "not returned";
      this.khA = -1;
      this.kay = paramc;
      this.bWl = paramInt;
      this.khz = paramJsApiCheckIsSupportFaceDetect;
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(106560);
      iw localiw = new iw();
      com.tencent.mm.sdk.b.a.GpY.l(localiw);
      this.dyk = localiw.dkj.dkk;
      this.errCode = localiw.dkj.dkl;
      this.errMsg = localiw.dkj.dkm;
      this.khA = localiw.dkj.dkn;
      ac.i("MicroMsg.GetIsSupportFaceTask", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", new Object[] { Boolean.valueOf(this.dyk), Integer.valueOf(this.errCode), this.errMsg, Integer.valueOf(this.khA) });
      bet();
      AppMethodBeat.o(106560);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(106559);
      super.aLr();
      ac.d("MicroMsg.GetIsSupportFaceTask", "hy: callback. isSupport: %b, errCode: %d, errMsg: %s, libVersion: %d", new Object[] { Boolean.valueOf(this.dyk), Integer.valueOf(this.errCode), this.errMsg, Integer.valueOf(this.khA) });
      HashMap localHashMap = new HashMap(3);
      localHashMap.put("errCode", Integer.valueOf(this.errCode));
      localHashMap.put("libVersionCode", Integer.valueOf(this.khA));
      if (this.errCode == 0) {
        this.kay.h(this.bWl, this.khz.k("ok", localHashMap));
      }
      for (;;)
      {
        bek();
        AppMethodBeat.o(106559);
        return;
        this.kay.h(this.bWl, this.khz.k("fail " + this.errMsg, localHashMap));
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
        this.dyk = bool;
        this.errCode = paramParcel.readInt();
        this.errMsg = paramParcel.readString();
        this.khA = paramParcel.readInt();
        AppMethodBeat.o(106563);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106561);
      super.writeToParcel(paramParcel, paramInt);
      if (this.dyk) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.errCode);
        paramParcel.writeString(this.errMsg);
        paramParcel.writeInt(this.khA);
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