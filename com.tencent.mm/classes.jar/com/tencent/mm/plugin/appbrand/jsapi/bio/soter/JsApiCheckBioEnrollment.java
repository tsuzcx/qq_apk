package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.g.a.jt.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckBioEnrollment
  extends d
{
  public static final int CTRL_INDEX = 344;
  public static final String NAME = "checkIsSoterEnrolledInDevice";
  private GetIsEnrolledTask lKm = null;
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106580);
    Log.i("MicroMsg.JsApiCheckBioEnrollment", "hy: subapp start do check is enrolled");
    this.lKm = new GetIsEnrolledTask(paramf, paramInt, a.ZB(paramJSONObject.optString("checkAuthMode")), this);
    this.lKm.bDJ();
    AppBrandMainProcessService.a(this.lKm);
    AppMethodBeat.o(106580);
  }
  
  static class GetIsEnrolledTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsEnrolledTask> CREATOR;
    private int csv;
    private f kSY;
    private JsApiCheckBioEnrollment lKn;
    private int lKo;
    private int lKp;
    
    static
    {
      AppMethodBeat.i(106579);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106579);
    }
    
    protected GetIsEnrolledTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106577);
      this.kSY = null;
      this.csv = -1;
      this.lKo = -1;
      this.lKp = -1;
      f(paramParcel);
      AppMethodBeat.o(106577);
    }
    
    public GetIsEnrolledTask(f paramf, int paramInt1, int paramInt2, JsApiCheckBioEnrollment paramJsApiCheckBioEnrollment)
    {
      this.kSY = null;
      this.csv = -1;
      this.lKo = -1;
      this.lKp = -1;
      this.kSY = paramf;
      this.csv = paramInt1;
      this.lKn = paramJsApiCheckBioEnrollment;
      this.lKo = paramInt2;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(106575);
      jt localjt = new jt();
      localjt.dOE.dOG = this.lKo;
      EventCenter.instance.publish(localjt);
      this.lKp = localjt.dOF.dOH;
      Log.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", new Object[] { Integer.valueOf(this.lKp) });
      bDU();
      AppMethodBeat.o(106575);
    }
    
    public final void bjk()
    {
      boolean bool = false;
      AppMethodBeat.i(106574);
      super.bjk();
      Log.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", new Object[] { Integer.valueOf(this.lKp) });
      HashMap localHashMap = new HashMap(2);
      if (this.lKp == 1) {
        bool = true;
      }
      localHashMap.put("isEnrolled", Boolean.valueOf(bool));
      if (this.lKp == 0) {
        this.kSY.i(this.csv, this.lKn.n("ok", localHashMap));
      }
      for (;;)
      {
        bDK();
        AppMethodBeat.o(106574);
        return;
        if (this.lKp == -1) {
          this.kSY.i(this.csv, this.lKn.n("fail not support", localHashMap));
        } else if (this.lKp == 1) {
          this.kSY.i(this.csv, this.lKn.n("ok", localHashMap));
        } else {
          this.kSY.i(this.csv, this.lKn.n("fail unknown error", localHashMap));
        }
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(106578);
      super.f(paramParcel);
      this.lKp = paramParcel.readInt();
      this.lKo = paramParcel.readInt();
      AppMethodBeat.o(106578);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106576);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.lKp);
      paramParcel.writeInt(this.lKo);
      AppMethodBeat.o(106576);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckBioEnrollment
 * JD-Core Version:    0.7.0.1
 */