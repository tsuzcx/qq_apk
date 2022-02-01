package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.core.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiLuggageCheckBioEnrollment
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  public static final int CTRL_INDEX = 344;
  public static final String NAME = "checkIsSoterEnrolledInDevice";
  private static Context lKu = null;
  private GetIsEnrolledTask lKt;
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(159041);
    lKu = paramf.getContext();
    Log.i("MicroMsg.JsApiLuggageCheckBioEnrollment", "hy: subapp start do check is enrolled");
    this.lKt = new GetIsEnrolledTask(paramf, paramInt, d.ZB(paramJSONObject.optString("checkAuthMode")), this);
    this.lKt.bDJ();
    AppBrandMainProcessService.a(this.lKt);
    AppMethodBeat.o(159041);
  }
  
  static class GetIsEnrolledTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsEnrolledTask> CREATOR;
    private int csv;
    private f kSY;
    private int lKo;
    private int lKp;
    private JsApiLuggageCheckBioEnrollment lKv;
    
    static
    {
      AppMethodBeat.i(159040);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(159040);
    }
    
    protected GetIsEnrolledTask(Parcel paramParcel)
    {
      AppMethodBeat.i(159038);
      this.kSY = null;
      this.csv = -1;
      this.lKo = -1;
      this.lKp = -1;
      f(paramParcel);
      AppMethodBeat.o(159038);
    }
    
    public GetIsEnrolledTask(f paramf, int paramInt1, int paramInt2, JsApiLuggageCheckBioEnrollment paramJsApiLuggageCheckBioEnrollment)
    {
      this.kSY = null;
      this.csv = -1;
      this.lKo = -1;
      this.lKp = -1;
      this.kSY = paramf;
      this.csv = paramInt1;
      this.lKv = paramJsApiLuggageCheckBioEnrollment;
      this.lKo = paramInt2;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(159036);
      Context localContext = JsApiLuggageCheckBioEnrollment.lKu;
      int i;
      if (this.lKo == 1) {
        if (a.ld(localContext)) {
          i = 1;
        }
      }
      for (;;)
      {
        this.lKp = i;
        Log.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", new Object[] { Integer.valueOf(this.lKp) });
        bDU();
        AppMethodBeat.o(159036);
        return;
        i = 0;
        continue;
        i = -1;
      }
    }
    
    public final void bjk()
    {
      boolean bool = false;
      AppMethodBeat.i(159035);
      super.bjk();
      Log.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", new Object[] { Integer.valueOf(this.lKp) });
      HashMap localHashMap = new HashMap(2);
      if (this.lKp == 1) {
        bool = true;
      }
      localHashMap.put("isEnrolled", Boolean.valueOf(bool));
      if (this.lKp == 0) {
        this.kSY.i(this.csv, this.lKv.n("ok", localHashMap));
      }
      for (;;)
      {
        bDK();
        AppMethodBeat.o(159035);
        return;
        if (this.lKp == -1) {
          this.kSY.i(this.csv, this.lKv.n("fail not support", localHashMap));
        } else if (this.lKp == 1) {
          this.kSY.i(this.csv, this.lKv.n("ok", localHashMap));
        } else {
          this.kSY.i(this.csv, this.lKv.n("fail unknown error", localHashMap));
        }
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(159039);
      super.f(paramParcel);
      this.lKp = paramParcel.readInt();
      this.lKo = paramParcel.readInt();
      AppMethodBeat.o(159039);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(159037);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.lKp);
      paramParcel.writeInt(this.lKo);
      AppMethodBeat.o(159037);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckBioEnrollment
 * JD-Core Version:    0.7.0.1
 */