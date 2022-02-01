package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.g.a.iv.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckBioEnrollment
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 344;
  public static final String NAME = "checkIsSoterEnrolledInDevice";
  private GetIsEnrolledTask khD = null;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106580);
    ac.i("MicroMsg.JsApiCheckBioEnrollment", "hy: subapp start do check is enrolled");
    this.khD = new GetIsEnrolledTask(paramc, paramInt, a.LW(paramJSONObject.optString("checkAuthMode")), this);
    this.khD.bej();
    AppBrandMainProcessService.a(this.khD);
    AppMethodBeat.o(106580);
  }
  
  static class GetIsEnrolledTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsEnrolledTask> CREATOR;
    private int bWl;
    private c kay;
    private JsApiCheckBioEnrollment khE;
    private int khF;
    private int khG;
    
    static
    {
      AppMethodBeat.i(106579);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106579);
    }
    
    protected GetIsEnrolledTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106577);
      this.kay = null;
      this.bWl = -1;
      this.khF = -1;
      this.khG = -1;
      e(paramParcel);
      AppMethodBeat.o(106577);
    }
    
    public GetIsEnrolledTask(c paramc, int paramInt1, int paramInt2, JsApiCheckBioEnrollment paramJsApiCheckBioEnrollment)
    {
      this.kay = null;
      this.bWl = -1;
      this.khF = -1;
      this.khG = -1;
      this.kay = paramc;
      this.bWl = paramInt1;
      this.khE = paramJsApiCheckBioEnrollment;
      this.khF = paramInt2;
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(106575);
      iv localiv = new iv();
      localiv.dkf.dkh = this.khF;
      com.tencent.mm.sdk.b.a.GpY.l(localiv);
      this.khG = localiv.dkg.dki;
      ac.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", new Object[] { Integer.valueOf(this.khG) });
      bet();
      AppMethodBeat.o(106575);
    }
    
    public final void aLr()
    {
      boolean bool = false;
      AppMethodBeat.i(106574);
      super.aLr();
      ac.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", new Object[] { Integer.valueOf(this.khG) });
      HashMap localHashMap = new HashMap(2);
      if (this.khG == 1) {
        bool = true;
      }
      localHashMap.put("isEnrolled", Boolean.valueOf(bool));
      if (this.khG == 0) {
        this.kay.h(this.bWl, this.khE.k("ok", localHashMap));
      }
      for (;;)
      {
        bek();
        AppMethodBeat.o(106574);
        return;
        if (this.khG == -1) {
          this.kay.h(this.bWl, this.khE.k("fail not support", localHashMap));
        } else if (this.khG == 1) {
          this.kay.h(this.bWl, this.khE.k("ok", localHashMap));
        } else {
          this.kay.h(this.bWl, this.khE.k("fail unknown error", localHashMap));
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
      this.khG = paramParcel.readInt();
      this.khF = paramParcel.readInt();
      AppMethodBeat.o(106578);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106576);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.khG);
      paramParcel.writeInt(this.khF);
      AppMethodBeat.o(106576);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckBioEnrollment
 * JD-Core Version:    0.7.0.1
 */