package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiLuggageCheckBioEnrollment
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 344;
  public static final String NAME = "checkIsSoterEnrolledInDevice";
  private static Context kFT = null;
  private GetIsEnrolledTask kFS;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(159041);
    kFT = paramc.getContext();
    ae.i("MicroMsg.JsApiLuggageCheckBioEnrollment", "hy: subapp start do check is enrolled");
    this.kFS = new GetIsEnrolledTask(paramc, paramInt, d.Qa(paramJSONObject.optString("checkAuthMode")), this);
    this.kFS.biw();
    AppBrandMainProcessService.a(this.kFS);
    AppMethodBeat.o(159041);
  }
  
  static class GetIsEnrolledTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsEnrolledTask> CREATOR;
    private int cgA;
    private c jQp;
    private int kFN;
    private int kFO;
    private JsApiLuggageCheckBioEnrollment kFU;
    
    static
    {
      AppMethodBeat.i(159040);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(159040);
    }
    
    protected GetIsEnrolledTask(Parcel paramParcel)
    {
      AppMethodBeat.i(159038);
      this.jQp = null;
      this.cgA = -1;
      this.kFN = -1;
      this.kFO = -1;
      e(paramParcel);
      AppMethodBeat.o(159038);
    }
    
    public GetIsEnrolledTask(c paramc, int paramInt1, int paramInt2, JsApiLuggageCheckBioEnrollment paramJsApiLuggageCheckBioEnrollment)
    {
      this.jQp = null;
      this.cgA = -1;
      this.kFN = -1;
      this.kFO = -1;
      this.jQp = paramc;
      this.cgA = paramInt1;
      this.kFU = paramJsApiLuggageCheckBioEnrollment;
      this.kFN = paramInt2;
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(159036);
      Context localContext = JsApiLuggageCheckBioEnrollment.kFT;
      int i;
      if (this.kFN == 1) {
        if (com.tencent.soter.core.a.li(localContext)) {
          i = 1;
        }
      }
      for (;;)
      {
        this.kFO = i;
        ae.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", new Object[] { Integer.valueOf(this.kFO) });
        biG();
        AppMethodBeat.o(159036);
        return;
        i = 0;
        continue;
        i = -1;
      }
    }
    
    public final void aOY()
    {
      boolean bool = false;
      AppMethodBeat.i(159035);
      super.aOY();
      ae.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", new Object[] { Integer.valueOf(this.kFO) });
      HashMap localHashMap = new HashMap(2);
      if (this.kFO == 1) {
        bool = true;
      }
      localHashMap.put("isEnrolled", Boolean.valueOf(bool));
      if (this.kFO == 0) {
        this.jQp.h(this.cgA, this.kFU.n("ok", localHashMap));
      }
      for (;;)
      {
        bix();
        AppMethodBeat.o(159035);
        return;
        if (this.kFO == -1) {
          this.jQp.h(this.cgA, this.kFU.n("fail not support", localHashMap));
        } else if (this.kFO == 1) {
          this.jQp.h(this.cgA, this.kFU.n("ok", localHashMap));
        } else {
          this.jQp.h(this.cgA, this.kFU.n("fail unknown error", localHashMap));
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
      this.kFO = paramParcel.readInt();
      this.kFN = paramParcel.readInt();
      AppMethodBeat.o(159039);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(159037);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.kFO);
      paramParcel.writeInt(this.kFN);
      AppMethodBeat.o(159037);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckBioEnrollment
 * JD-Core Version:    0.7.0.1
 */