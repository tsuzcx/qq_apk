package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.core.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiLuggageCheckBioEnrollment
  extends c
{
  public static final int CTRL_INDEX = 344;
  public static final String NAME = "checkIsSoterEnrolledInDevice";
  private static Context rJI = null;
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(159041);
    rJI = paramf.getContext();
    Log.i("MicroMsg.JsApiLuggageCheckBioEnrollment", "hy: subapp start do check is enrolled");
    paramJSONObject = paramJSONObject.optString("checkAuthMode");
    int i;
    if ("fingerPrint".equals(paramJSONObject)) {
      i = 1;
    }
    for (;;)
    {
      new GetIsEnrolledTask(paramf, paramInt, i, this);
      AppMethodBeat.o(159041);
      throw null;
      if ("facial".equals(paramJSONObject))
      {
        i = 8;
      }
      else if ("speech".equals(paramJSONObject))
      {
        i = 2;
      }
      else
      {
        Log.e("MicroMsg.AppBrandSoterTranslateUtil", "hy: invalid item");
        i = 0;
      }
    }
  }
  
  static class GetIsEnrolledTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsEnrolledTask> CREATOR;
    private int eit;
    private f qNp;
    private int rJD;
    private int rJE;
    private JsApiLuggageCheckBioEnrollment rJJ;
    
    static
    {
      AppMethodBeat.i(159040);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(159040);
    }
    
    protected GetIsEnrolledTask(Parcel paramParcel)
    {
      AppMethodBeat.i(159038);
      this.qNp = null;
      this.eit = -1;
      this.rJD = -1;
      this.rJE = -1;
      h(paramParcel);
      AppMethodBeat.o(159038);
    }
    
    public GetIsEnrolledTask(f paramf, int paramInt1, int paramInt2, JsApiLuggageCheckBioEnrollment paramJsApiLuggageCheckBioEnrollment)
    {
      this.qNp = null;
      this.eit = -1;
      this.rJD = -1;
      this.rJE = -1;
      this.qNp = paramf;
      this.eit = paramInt1;
      this.rJJ = paramJsApiLuggageCheckBioEnrollment;
      this.rJD = paramInt2;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(159036);
      Context localContext = JsApiLuggageCheckBioEnrollment.rJI;
      int i;
      if (this.rJD == 1) {
        if (a.oo(localContext)) {
          i = 1;
        }
      }
      for (;;)
      {
        this.rJE = i;
        Log.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", new Object[] { Integer.valueOf(this.rJE) });
        cpA();
        AppMethodBeat.o(159036);
        return;
        i = 0;
        continue;
        i = -1;
      }
    }
    
    public final void bQr()
    {
      boolean bool = false;
      AppMethodBeat.i(159035);
      super.bQr();
      Log.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", new Object[] { Integer.valueOf(this.rJE) });
      HashMap localHashMap = new HashMap(2);
      if (this.rJE == 1) {
        bool = true;
      }
      localHashMap.put("isEnrolled", Boolean.valueOf(bool));
      if (this.rJE == 0) {
        this.qNp.callback(this.eit, this.rJJ.m("ok", localHashMap));
      }
      for (;;)
      {
        cpx();
        AppMethodBeat.o(159035);
        return;
        if (this.rJE == -1) {
          this.qNp.callback(this.eit, this.rJJ.m("fail not support", localHashMap));
        } else if (this.rJE == 1) {
          this.qNp.callback(this.eit, this.rJJ.m("ok", localHashMap));
        } else {
          this.qNp.callback(this.eit, this.rJJ.m("fail unknown error", localHashMap));
        }
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(159039);
      super.h(paramParcel);
      this.rJE = paramParcel.readInt();
      this.rJD = paramParcel.readInt();
      AppMethodBeat.o(159039);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(159037);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.rJE);
      paramParcel.writeInt(this.rJD);
      AppMethodBeat.o(159037);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckBioEnrollment
 * JD-Core Version:    0.7.0.1
 */