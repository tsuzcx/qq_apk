package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiLuggageCheckBioEnrollment
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 344;
  public static final String NAME = "checkIsSoterEnrolledInDevice";
  private static Context kCE = null;
  private GetIsEnrolledTask kCD;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(159041);
    kCE = paramc.getContext();
    ad.i("MicroMsg.JsApiLuggageCheckBioEnrollment", "hy: subapp start do check is enrolled");
    this.kCD = new GetIsEnrolledTask(paramc, paramInt, d.Ps(paramJSONObject.optString("checkAuthMode")), this);
    this.kCD.bhN();
    AppBrandMainProcessService.a(this.kCD);
    AppMethodBeat.o(159041);
  }
  
  static class GetIsEnrolledTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsEnrolledTask> CREATOR;
    private int cgA;
    private JsApiLuggageCheckBioEnrollment kCF;
    private int kCy;
    private int kCz;
    private c kuU;
    
    static
    {
      AppMethodBeat.i(159040);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(159040);
    }
    
    protected GetIsEnrolledTask(Parcel paramParcel)
    {
      AppMethodBeat.i(159038);
      this.kuU = null;
      this.cgA = -1;
      this.kCy = -1;
      this.kCz = -1;
      e(paramParcel);
      AppMethodBeat.o(159038);
    }
    
    public GetIsEnrolledTask(c paramc, int paramInt1, int paramInt2, JsApiLuggageCheckBioEnrollment paramJsApiLuggageCheckBioEnrollment)
    {
      this.kuU = null;
      this.cgA = -1;
      this.kCy = -1;
      this.kCz = -1;
      this.kuU = paramc;
      this.cgA = paramInt1;
      this.kCF = paramJsApiLuggageCheckBioEnrollment;
      this.kCy = paramInt2;
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(159036);
      Context localContext = JsApiLuggageCheckBioEnrollment.kCE;
      int i;
      if (this.kCy == 1) {
        if (com.tencent.soter.core.a.lc(localContext)) {
          i = 1;
        }
      }
      for (;;)
      {
        this.kCz = i;
        ad.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", new Object[] { Integer.valueOf(this.kCz) });
        bhX();
        AppMethodBeat.o(159036);
        return;
        i = 0;
        continue;
        i = -1;
      }
    }
    
    public final void aOB()
    {
      boolean bool = false;
      AppMethodBeat.i(159035);
      super.aOB();
      ad.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", new Object[] { Integer.valueOf(this.kCz) });
      HashMap localHashMap = new HashMap(2);
      if (this.kCz == 1) {
        bool = true;
      }
      localHashMap.put("isEnrolled", Boolean.valueOf(bool));
      if (this.kCz == 0) {
        this.kuU.h(this.cgA, this.kCF.m("ok", localHashMap));
      }
      for (;;)
      {
        bhO();
        AppMethodBeat.o(159035);
        return;
        if (this.kCz == -1) {
          this.kuU.h(this.cgA, this.kCF.m("fail not support", localHashMap));
        } else if (this.kCz == 1) {
          this.kuU.h(this.cgA, this.kCF.m("ok", localHashMap));
        } else {
          this.kuU.h(this.cgA, this.kCF.m("fail unknown error", localHashMap));
        }
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(159039);
      super.e(paramParcel);
      this.kCz = paramParcel.readInt();
      this.kCy = paramParcel.readInt();
      AppMethodBeat.o(159039);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(159037);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.kCz);
      paramParcel.writeInt(this.kCy);
      AppMethodBeat.o(159037);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckBioEnrollment
 * JD-Core Version:    0.7.0.1
 */