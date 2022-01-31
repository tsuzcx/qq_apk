package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hu;
import com.tencent.mm.g.a.hu.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

class JsApiCheckIsSupportFaceDetect$GetIsSupportFaceTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetIsSupportFaceTask> CREATOR;
  private int bxX;
  private boolean cJE;
  private int errCode;
  private String errMsg;
  private c hAC;
  private JsApiCheckIsSupportFaceDetect hEY;
  private int hEZ;
  
  static
  {
    AppMethodBeat.i(3199);
    CREATOR = new JsApiCheckIsSupportFaceDetect.GetIsSupportFaceTask.1();
    AppMethodBeat.o(3199);
  }
  
  protected JsApiCheckIsSupportFaceDetect$GetIsSupportFaceTask(Parcel paramParcel)
  {
    AppMethodBeat.i(3197);
    this.hAC = null;
    this.bxX = -1;
    this.cJE = false;
    this.errCode = -1;
    this.errMsg = "not returned";
    this.hEZ = -1;
    f(paramParcel);
    AppMethodBeat.o(3197);
  }
  
  public JsApiCheckIsSupportFaceDetect$GetIsSupportFaceTask(c paramc, int paramInt, JsApiCheckIsSupportFaceDetect paramJsApiCheckIsSupportFaceDetect)
  {
    this.hAC = null;
    this.bxX = -1;
    this.cJE = false;
    this.errCode = -1;
    this.errMsg = "not returned";
    this.hEZ = -1;
    this.hAC = paramc;
    this.bxX = paramInt;
    this.hEY = paramJsApiCheckIsSupportFaceDetect;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(3195);
    hu localhu = new hu();
    a.ymk.l(localhu);
    this.cJE = localhu.cwY.cwZ;
    this.errCode = localhu.cwY.cxa;
    this.errMsg = localhu.cwY.cxb;
    this.hEZ = localhu.cwY.cxc;
    ab.i("MicroMsg.GetIsSupportFaceTask", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", new Object[] { Boolean.valueOf(this.cJE), Integer.valueOf(this.errCode), this.errMsg, Integer.valueOf(this.hEZ) });
    aBp();
    AppMethodBeat.o(3195);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(3194);
    super.atb();
    ab.d("MicroMsg.GetIsSupportFaceTask", "hy: callback. isSupport: %b, errCode: %d, errMsg: %s, libVersion: %d", new Object[] { Boolean.valueOf(this.cJE), Integer.valueOf(this.errCode), this.errMsg, Integer.valueOf(this.hEZ) });
    HashMap localHashMap = new HashMap(3);
    localHashMap.put("errCode", Integer.valueOf(this.errCode));
    localHashMap.put("libVersionCode", Integer.valueOf(this.hEZ));
    if (this.errCode == 0) {
      this.hAC.h(this.bxX, this.hEY.j("ok", localHashMap));
    }
    for (;;)
    {
      h.ai(this);
      AppMethodBeat.o(3194);
      return;
      this.hAC.h(this.bxX, this.hEY.j("fail " + this.errMsg, localHashMap));
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(3198);
    super.f(paramParcel);
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.cJE = bool;
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
      this.hEZ = paramParcel.readInt();
      AppMethodBeat.o(3198);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(3196);
    super.writeToParcel(paramParcel, paramInt);
    if (this.cJE) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      paramParcel.writeInt(this.hEZ);
      AppMethodBeat.o(3196);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect.GetIsSupportFaceTask
 * JD-Core Version:    0.7.0.1
 */