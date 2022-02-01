package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.a.io.b;
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
  private GetIsEnrolledTask jHe = null;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106580);
    ad.i("MicroMsg.JsApiCheckBioEnrollment", "hy: subapp start do check is enrolled");
    this.jHe = new GetIsEnrolledTask(paramc, paramInt, a.HR(paramJSONObject.optString("checkAuthMode")), this);
    this.jHe.aXm();
    AppBrandMainProcessService.a(this.jHe);
    AppMethodBeat.o(106580);
  }
  
  static class GetIsEnrolledTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsEnrolledTask> CREATOR;
    private int bZo;
    private c jAc;
    private JsApiCheckBioEnrollment jHf;
    private int jHg;
    private int jHh;
    
    static
    {
      AppMethodBeat.i(106579);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106579);
    }
    
    protected GetIsEnrolledTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106577);
      this.jAc = null;
      this.bZo = -1;
      this.jHg = -1;
      this.jHh = -1;
      e(paramParcel);
      AppMethodBeat.o(106577);
    }
    
    public GetIsEnrolledTask(c paramc, int paramInt1, int paramInt2, JsApiCheckBioEnrollment paramJsApiCheckBioEnrollment)
    {
      this.jAc = null;
      this.bZo = -1;
      this.jHg = -1;
      this.jHh = -1;
      this.jAc = paramc;
      this.bZo = paramInt1;
      this.jHf = paramJsApiCheckBioEnrollment;
      this.jHg = paramInt2;
    }
    
    public final void aEA()
    {
      boolean bool = false;
      AppMethodBeat.i(106574);
      super.aEA();
      ad.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", new Object[] { Integer.valueOf(this.jHh) });
      HashMap localHashMap = new HashMap(2);
      if (this.jHh == 1) {
        bool = true;
      }
      localHashMap.put("isEnrolled", Boolean.valueOf(bool));
      if (this.jHh == 0) {
        this.jAc.h(this.bZo, this.jHf.k("ok", localHashMap));
      }
      for (;;)
      {
        aXn();
        AppMethodBeat.o(106574);
        return;
        if (this.jHh == -1) {
          this.jAc.h(this.bZo, this.jHf.k("fail not support", localHashMap));
        } else if (this.jHh == 1) {
          this.jAc.h(this.bZo, this.jHf.k("ok", localHashMap));
        } else {
          this.jAc.h(this.bZo, this.jHf.k("fail unknown error", localHashMap));
        }
      }
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(106575);
      io localio = new io();
      localio.dmx.dmz = this.jHg;
      com.tencent.mm.sdk.b.a.ESL.l(localio);
      this.jHh = localio.dmy.dmA;
      ad.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", new Object[] { Integer.valueOf(this.jHh) });
      aXw();
      AppMethodBeat.o(106575);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(106578);
      super.e(paramParcel);
      this.jHh = paramParcel.readInt();
      this.jHg = paramParcel.readInt();
      AppMethodBeat.o(106578);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106576);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.jHh);
      paramParcel.writeInt(this.jHg);
      AppMethodBeat.o(106576);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckBioEnrollment
 * JD-Core Version:    0.7.0.1
 */