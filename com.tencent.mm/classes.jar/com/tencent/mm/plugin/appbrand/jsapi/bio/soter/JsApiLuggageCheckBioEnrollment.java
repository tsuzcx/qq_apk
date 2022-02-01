package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
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
  private static Context oGJ = null;
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(159041);
    oGJ = parame.getContext();
    Log.i("MicroMsg.JsApiLuggageCheckBioEnrollment", "hy: subapp start do check is enrolled");
    paramJSONObject = paramJSONObject.optString("checkAuthMode");
    int i;
    if ("fingerPrint".equals(paramJSONObject)) {
      i = 1;
    }
    for (;;)
    {
      new GetIsEnrolledTask(parame, paramInt, i, this);
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
    private int cqA;
    private e nNw;
    private int oGE;
    private int oGF;
    private JsApiLuggageCheckBioEnrollment oGK;
    
    static
    {
      AppMethodBeat.i(159040);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(159040);
    }
    
    protected GetIsEnrolledTask(Parcel paramParcel)
    {
      AppMethodBeat.i(159038);
      this.nNw = null;
      this.cqA = -1;
      this.oGE = -1;
      this.oGF = -1;
      f(paramParcel);
      AppMethodBeat.o(159038);
    }
    
    public GetIsEnrolledTask(e parame, int paramInt1, int paramInt2, JsApiLuggageCheckBioEnrollment paramJsApiLuggageCheckBioEnrollment)
    {
      this.nNw = null;
      this.cqA = -1;
      this.oGE = -1;
      this.oGF = -1;
      this.nNw = parame;
      this.cqA = paramInt1;
      this.oGK = paramJsApiLuggageCheckBioEnrollment;
      this.oGE = paramInt2;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(159036);
      Context localContext = JsApiLuggageCheckBioEnrollment.oGJ;
      int i;
      if (this.oGE == 1) {
        if (a.mb(localContext)) {
          i = 1;
        }
      }
      for (;;)
      {
        this.oGF = i;
        Log.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", new Object[] { Integer.valueOf(this.oGF) });
        bPt();
        AppMethodBeat.o(159036);
        return;
        i = 0;
        continue;
        i = -1;
      }
    }
    
    public final void bsK()
    {
      boolean bool = false;
      AppMethodBeat.i(159035);
      super.bsK();
      Log.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", new Object[] { Integer.valueOf(this.oGF) });
      HashMap localHashMap = new HashMap(2);
      if (this.oGF == 1) {
        bool = true;
      }
      localHashMap.put("isEnrolled", Boolean.valueOf(bool));
      if (this.oGF == 0) {
        this.nNw.j(this.cqA, this.oGK.m("ok", localHashMap));
      }
      for (;;)
      {
        bPk();
        AppMethodBeat.o(159035);
        return;
        if (this.oGF == -1) {
          this.nNw.j(this.cqA, this.oGK.m("fail not support", localHashMap));
        } else if (this.oGF == 1) {
          this.nNw.j(this.cqA, this.oGK.m("ok", localHashMap));
        } else {
          this.nNw.j(this.cqA, this.oGK.m("fail unknown error", localHashMap));
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
      this.oGF = paramParcel.readInt();
      this.oGE = paramParcel.readInt();
      AppMethodBeat.o(159039);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(159037);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.oGF);
      paramParcel.writeInt(this.oGE);
      AppMethodBeat.o(159037);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckBioEnrollment
 * JD-Core Version:    0.7.0.1
 */