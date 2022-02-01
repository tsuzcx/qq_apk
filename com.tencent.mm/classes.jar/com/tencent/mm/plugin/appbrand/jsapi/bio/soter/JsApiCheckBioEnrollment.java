package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.je.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckBioEnrollment
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 344;
  public static final String NAME = "checkIsSoterEnrolledInDevice";
  private GetIsEnrolledTask kFL = null;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106580);
    ae.i("MicroMsg.JsApiCheckBioEnrollment", "hy: subapp start do check is enrolled");
    this.kFL = new GetIsEnrolledTask(paramc, paramInt, a.Qa(paramJSONObject.optString("checkAuthMode")), this);
    this.kFL.biw();
    AppBrandMainProcessService.a(this.kFL);
    AppMethodBeat.o(106580);
  }
  
  static class GetIsEnrolledTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsEnrolledTask> CREATOR;
    private int cgA;
    private c jQp;
    private JsApiCheckBioEnrollment kFM;
    private int kFN;
    private int kFO;
    
    static
    {
      AppMethodBeat.i(106579);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106579);
    }
    
    protected GetIsEnrolledTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106577);
      this.jQp = null;
      this.cgA = -1;
      this.kFN = -1;
      this.kFO = -1;
      e(paramParcel);
      AppMethodBeat.o(106577);
    }
    
    public GetIsEnrolledTask(c paramc, int paramInt1, int paramInt2, JsApiCheckBioEnrollment paramJsApiCheckBioEnrollment)
    {
      this.jQp = null;
      this.cgA = -1;
      this.kFN = -1;
      this.kFO = -1;
      this.jQp = paramc;
      this.cgA = paramInt1;
      this.kFM = paramJsApiCheckBioEnrollment;
      this.kFN = paramInt2;
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(106575);
      je localje = new je();
      localje.dwX.dwZ = this.kFN;
      com.tencent.mm.sdk.b.a.IvT.l(localje);
      this.kFO = localje.dwY.dxa;
      ae.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", new Object[] { Integer.valueOf(this.kFO) });
      biG();
      AppMethodBeat.o(106575);
    }
    
    public final void aOY()
    {
      boolean bool = false;
      AppMethodBeat.i(106574);
      super.aOY();
      ae.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", new Object[] { Integer.valueOf(this.kFO) });
      HashMap localHashMap = new HashMap(2);
      if (this.kFO == 1) {
        bool = true;
      }
      localHashMap.put("isEnrolled", Boolean.valueOf(bool));
      if (this.kFO == 0) {
        this.jQp.h(this.cgA, this.kFM.n("ok", localHashMap));
      }
      for (;;)
      {
        bix();
        AppMethodBeat.o(106574);
        return;
        if (this.kFO == -1) {
          this.jQp.h(this.cgA, this.kFM.n("fail not support", localHashMap));
        } else if (this.kFO == 1) {
          this.jQp.h(this.cgA, this.kFM.n("ok", localHashMap));
        } else {
          this.jQp.h(this.cgA, this.kFM.n("fail unknown error", localHashMap));
        }
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(106578);
      super.e(paramParcel);
      this.kFO = paramParcel.readInt();
      this.kFN = paramParcel.readInt();
      AppMethodBeat.o(106578);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106576);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.kFO);
      paramParcel.writeInt(this.kFN);
      AppMethodBeat.o(106576);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckBioEnrollment
 * JD-Core Version:    0.7.0.1
 */