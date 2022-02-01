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
  private static Context jHm = null;
  private GetIsEnrolledTask jHl;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(159041);
    jHm = paramc.getContext();
    ad.i("MicroMsg.JsApiLuggageCheckBioEnrollment", "hy: subapp start do check is enrolled");
    this.jHl = new GetIsEnrolledTask(paramc, paramInt, d.HR(paramJSONObject.optString("checkAuthMode")), this);
    this.jHl.aXm();
    AppBrandMainProcessService.a(this.jHl);
    AppMethodBeat.o(159041);
  }
  
  static class GetIsEnrolledTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsEnrolledTask> CREATOR;
    private int bZo;
    private c jAc;
    private int jHg;
    private int jHh;
    private JsApiLuggageCheckBioEnrollment jHn;
    
    static
    {
      AppMethodBeat.i(159040);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(159040);
    }
    
    protected GetIsEnrolledTask(Parcel paramParcel)
    {
      AppMethodBeat.i(159038);
      this.jAc = null;
      this.bZo = -1;
      this.jHg = -1;
      this.jHh = -1;
      e(paramParcel);
      AppMethodBeat.o(159038);
    }
    
    public GetIsEnrolledTask(c paramc, int paramInt1, int paramInt2, JsApiLuggageCheckBioEnrollment paramJsApiLuggageCheckBioEnrollment)
    {
      this.jAc = null;
      this.bZo = -1;
      this.jHg = -1;
      this.jHh = -1;
      this.jAc = paramc;
      this.bZo = paramInt1;
      this.jHn = paramJsApiLuggageCheckBioEnrollment;
      this.jHg = paramInt2;
    }
    
    public final void aEA()
    {
      boolean bool = false;
      AppMethodBeat.i(159035);
      super.aEA();
      ad.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", new Object[] { Integer.valueOf(this.jHh) });
      HashMap localHashMap = new HashMap(2);
      if (this.jHh == 1) {
        bool = true;
      }
      localHashMap.put("isEnrolled", Boolean.valueOf(bool));
      if (this.jHh == 0) {
        this.jAc.h(this.bZo, this.jHn.k("ok", localHashMap));
      }
      for (;;)
      {
        aXn();
        AppMethodBeat.o(159035);
        return;
        if (this.jHh == -1) {
          this.jAc.h(this.bZo, this.jHn.k("fail not support", localHashMap));
        } else if (this.jHh == 1) {
          this.jAc.h(this.bZo, this.jHn.k("ok", localHashMap));
        } else {
          this.jAc.h(this.bZo, this.jHn.k("fail unknown error", localHashMap));
        }
      }
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(159036);
      Context localContext = JsApiLuggageCheckBioEnrollment.jHm;
      int i;
      if (this.jHg == 1) {
        if (com.tencent.soter.core.a.kD(localContext)) {
          i = 1;
        }
      }
      for (;;)
      {
        this.jHh = i;
        ad.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", new Object[] { Integer.valueOf(this.jHh) });
        aXw();
        AppMethodBeat.o(159036);
        return;
        i = 0;
        continue;
        i = -1;
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
      this.jHh = paramParcel.readInt();
      this.jHg = paramParcel.readInt();
      AppMethodBeat.o(159039);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(159037);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.jHh);
      paramParcel.writeInt(this.jHg);
      AppMethodBeat.o(159037);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckBioEnrollment
 * JD-Core Version:    0.7.0.1
 */