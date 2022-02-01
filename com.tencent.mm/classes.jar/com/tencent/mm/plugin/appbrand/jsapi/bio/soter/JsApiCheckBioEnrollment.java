package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jd;
import com.tencent.mm.g.a.jd.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckBioEnrollment
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 344;
  public static final String NAME = "checkIsSoterEnrolledInDevice";
  private GetIsEnrolledTask kCw = null;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106580);
    ad.i("MicroMsg.JsApiCheckBioEnrollment", "hy: subapp start do check is enrolled");
    this.kCw = new GetIsEnrolledTask(paramc, paramInt, a.Ps(paramJSONObject.optString("checkAuthMode")), this);
    this.kCw.bhN();
    AppBrandMainProcessService.a(this.kCw);
    AppMethodBeat.o(106580);
  }
  
  static class GetIsEnrolledTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsEnrolledTask> CREATOR;
    private int cgA;
    private JsApiCheckBioEnrollment kCx;
    private int kCy;
    private int kCz;
    private c kuU;
    
    static
    {
      AppMethodBeat.i(106579);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106579);
    }
    
    protected GetIsEnrolledTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106577);
      this.kuU = null;
      this.cgA = -1;
      this.kCy = -1;
      this.kCz = -1;
      e(paramParcel);
      AppMethodBeat.o(106577);
    }
    
    public GetIsEnrolledTask(c paramc, int paramInt1, int paramInt2, JsApiCheckBioEnrollment paramJsApiCheckBioEnrollment)
    {
      this.kuU = null;
      this.cgA = -1;
      this.kCy = -1;
      this.kCz = -1;
      this.kuU = paramc;
      this.cgA = paramInt1;
      this.kCx = paramJsApiCheckBioEnrollment;
      this.kCy = paramInt2;
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(106575);
      jd localjd = new jd();
      localjd.dvS.dvU = this.kCy;
      com.tencent.mm.sdk.b.a.IbL.l(localjd);
      this.kCz = localjd.dvT.dvV;
      ad.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", new Object[] { Integer.valueOf(this.kCz) });
      bhX();
      AppMethodBeat.o(106575);
    }
    
    public final void aOB()
    {
      boolean bool = false;
      AppMethodBeat.i(106574);
      super.aOB();
      ad.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", new Object[] { Integer.valueOf(this.kCz) });
      HashMap localHashMap = new HashMap(2);
      if (this.kCz == 1) {
        bool = true;
      }
      localHashMap.put("isEnrolled", Boolean.valueOf(bool));
      if (this.kCz == 0) {
        this.kuU.h(this.cgA, this.kCx.m("ok", localHashMap));
      }
      for (;;)
      {
        bhO();
        AppMethodBeat.o(106574);
        return;
        if (this.kCz == -1) {
          this.kuU.h(this.cgA, this.kCx.m("fail not support", localHashMap));
        } else if (this.kCz == 1) {
          this.kuU.h(this.cgA, this.kCx.m("ok", localHashMap));
        } else {
          this.kuU.h(this.cgA, this.kCx.m("fail unknown error", localHashMap));
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
      this.kCz = paramParcel.readInt();
      this.kCy = paramParcel.readInt();
      AppMethodBeat.o(106578);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106576);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.kCz);
      paramParcel.writeInt(this.kCy);
      AppMethodBeat.o(106576);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckBioEnrollment
 * JD-Core Version:    0.7.0.1
 */