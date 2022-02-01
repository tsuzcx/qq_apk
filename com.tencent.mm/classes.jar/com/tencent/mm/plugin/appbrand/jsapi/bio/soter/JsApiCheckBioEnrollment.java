package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ln;
import com.tencent.mm.autogen.a.ln.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckBioEnrollment
  extends c
{
  public static final int CTRL_INDEX = 344;
  public static final String NAME = "checkIsSoterEnrolledInDevice";
  private GetIsEnrolledTask rJB = null;
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106580);
    Log.i("MicroMsg.JsApiCheckBioEnrollment", "hy: subapp start do check is enrolled");
    this.rJB = new GetIsEnrolledTask(paramf, paramInt, a.aam(paramJSONObject.optString("checkAuthMode")), this);
    this.rJB.bQt();
    AppMethodBeat.o(106580);
  }
  
  static class GetIsEnrolledTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsEnrolledTask> CREATOR;
    private int eit;
    private f qNp;
    private JsApiCheckBioEnrollment rJC;
    private int rJD;
    private int rJE;
    
    static
    {
      AppMethodBeat.i(106579);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106579);
    }
    
    protected GetIsEnrolledTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106577);
      this.qNp = null;
      this.eit = -1;
      this.rJD = -1;
      this.rJE = -1;
      h(paramParcel);
      AppMethodBeat.o(106577);
    }
    
    public GetIsEnrolledTask(f paramf, int paramInt1, int paramInt2, JsApiCheckBioEnrollment paramJsApiCheckBioEnrollment)
    {
      this.qNp = null;
      this.eit = -1;
      this.rJD = -1;
      this.rJE = -1;
      this.qNp = paramf;
      this.eit = paramInt1;
      this.rJC = paramJsApiCheckBioEnrollment;
      this.rJD = paramInt2;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(106575);
      ln localln = new ln();
      localln.hNp.hNr = this.rJD;
      localln.publish();
      this.rJE = localln.hNq.hNs;
      Log.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", new Object[] { Integer.valueOf(this.rJE) });
      cpA();
      AppMethodBeat.o(106575);
    }
    
    public final void bQr()
    {
      boolean bool = false;
      AppMethodBeat.i(106574);
      super.bQr();
      Log.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", new Object[] { Integer.valueOf(this.rJE) });
      HashMap localHashMap = new HashMap(2);
      if (this.rJE == 1) {
        bool = true;
      }
      localHashMap.put("isEnrolled", Boolean.valueOf(bool));
      if (this.rJE == 0) {
        this.qNp.callback(this.eit, this.rJC.m("ok", localHashMap));
      }
      for (;;)
      {
        cpx();
        AppMethodBeat.o(106574);
        return;
        if (this.rJE == -1) {
          this.qNp.callback(this.eit, this.rJC.m("fail not support", localHashMap));
        } else if (this.rJE == 1) {
          this.qNp.callback(this.eit, this.rJC.m("ok", localHashMap));
        } else {
          this.qNp.callback(this.eit, this.rJC.m("fail unknown error", localHashMap));
        }
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(106578);
      super.h(paramParcel);
      this.rJE = paramParcel.readInt();
      this.rJD = paramParcel.readInt();
      AppMethodBeat.o(106578);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106576);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.rJE);
      paramParcel.writeInt(this.rJD);
      AppMethodBeat.o(106576);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckBioEnrollment
 * JD-Core Version:    0.7.0.1
 */