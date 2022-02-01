package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiLuggageCheckBioEnrollment
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 344;
  public static final String NAME = "checkIsSoterEnrolledInDevice";
  private static Context khL = null;
  private GetIsEnrolledTask khK;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(159041);
    khL = paramc.getContext();
    ac.i("MicroMsg.JsApiLuggageCheckBioEnrollment", "hy: subapp start do check is enrolled");
    this.khK = new GetIsEnrolledTask(paramc, paramInt, d.LW(paramJSONObject.optString("checkAuthMode")), this);
    this.khK.bej();
    AppBrandMainProcessService.a(this.khK);
    AppMethodBeat.o(159041);
  }
  
  static class GetIsEnrolledTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsEnrolledTask> CREATOR;
    private int bWl;
    private c kay;
    private int khF;
    private int khG;
    private JsApiLuggageCheckBioEnrollment khM;
    
    static
    {
      AppMethodBeat.i(159040);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(159040);
    }
    
    protected GetIsEnrolledTask(Parcel paramParcel)
    {
      AppMethodBeat.i(159038);
      this.kay = null;
      this.bWl = -1;
      this.khF = -1;
      this.khG = -1;
      e(paramParcel);
      AppMethodBeat.o(159038);
    }
    
    public GetIsEnrolledTask(c paramc, int paramInt1, int paramInt2, JsApiLuggageCheckBioEnrollment paramJsApiLuggageCheckBioEnrollment)
    {
      this.kay = null;
      this.bWl = -1;
      this.khF = -1;
      this.khG = -1;
      this.kay = paramc;
      this.bWl = paramInt1;
      this.khM = paramJsApiLuggageCheckBioEnrollment;
      this.khF = paramInt2;
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(159036);
      Context localContext = JsApiLuggageCheckBioEnrollment.khL;
      int i;
      if (this.khF == 1) {
        if (com.tencent.soter.core.a.kP(localContext)) {
          i = 1;
        }
      }
      for (;;)
      {
        this.khG = i;
        ac.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", new Object[] { Integer.valueOf(this.khG) });
        bet();
        AppMethodBeat.o(159036);
        return;
        i = 0;
        continue;
        i = -1;
      }
    }
    
    public final void aLr()
    {
      boolean bool = false;
      AppMethodBeat.i(159035);
      super.aLr();
      ac.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", new Object[] { Integer.valueOf(this.khG) });
      HashMap localHashMap = new HashMap(2);
      if (this.khG == 1) {
        bool = true;
      }
      localHashMap.put("isEnrolled", Boolean.valueOf(bool));
      if (this.khG == 0) {
        this.kay.h(this.bWl, this.khM.k("ok", localHashMap));
      }
      for (;;)
      {
        bek();
        AppMethodBeat.o(159035);
        return;
        if (this.khG == -1) {
          this.kay.h(this.bWl, this.khM.k("fail not support", localHashMap));
        } else if (this.khG == 1) {
          this.kay.h(this.bWl, this.khM.k("ok", localHashMap));
        } else {
          this.kay.h(this.bWl, this.khM.k("fail unknown error", localHashMap));
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
      this.khG = paramParcel.readInt();
      this.khF = paramParcel.readInt();
      AppMethodBeat.o(159039);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(159037);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.khG);
      paramParcel.writeInt(this.khF);
      AppMethodBeat.o(159037);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckBioEnrollment
 * JD-Core Version:    0.7.0.1
 */