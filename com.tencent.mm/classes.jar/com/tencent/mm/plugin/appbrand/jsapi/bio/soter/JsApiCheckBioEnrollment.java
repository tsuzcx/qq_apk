package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.kj;
import com.tencent.mm.f.a.kj.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckBioEnrollment
  extends c
{
  public static final int CTRL_INDEX = 344;
  public static final String NAME = "checkIsSoterEnrolledInDevice";
  private GetIsEnrolledTask oGC = null;
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106580);
    Log.i("MicroMsg.JsApiCheckBioEnrollment", "hy: subapp start do check is enrolled");
    this.oGC = new GetIsEnrolledTask(parame, paramInt, a.ahp(paramJSONObject.optString("checkAuthMode")), this);
    this.oGC.bsM();
    AppMethodBeat.o(106580);
  }
  
  static class GetIsEnrolledTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsEnrolledTask> CREATOR;
    private int cqA;
    private e nNw;
    private JsApiCheckBioEnrollment oGD;
    private int oGE;
    private int oGF;
    
    static
    {
      AppMethodBeat.i(106579);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106579);
    }
    
    protected GetIsEnrolledTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106577);
      this.nNw = null;
      this.cqA = -1;
      this.oGE = -1;
      this.oGF = -1;
      f(paramParcel);
      AppMethodBeat.o(106577);
    }
    
    public GetIsEnrolledTask(e parame, int paramInt1, int paramInt2, JsApiCheckBioEnrollment paramJsApiCheckBioEnrollment)
    {
      this.nNw = null;
      this.cqA = -1;
      this.oGE = -1;
      this.oGF = -1;
      this.nNw = parame;
      this.cqA = paramInt1;
      this.oGD = paramJsApiCheckBioEnrollment;
      this.oGE = paramInt2;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(106575);
      kj localkj = new kj();
      localkj.fHP.fHR = this.oGE;
      EventCenter.instance.publish(localkj);
      this.oGF = localkj.fHQ.fHS;
      Log.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", new Object[] { Integer.valueOf(this.oGF) });
      bPt();
      AppMethodBeat.o(106575);
    }
    
    public final void bsK()
    {
      boolean bool = false;
      AppMethodBeat.i(106574);
      super.bsK();
      Log.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", new Object[] { Integer.valueOf(this.oGF) });
      HashMap localHashMap = new HashMap(2);
      if (this.oGF == 1) {
        bool = true;
      }
      localHashMap.put("isEnrolled", Boolean.valueOf(bool));
      if (this.oGF == 0) {
        this.nNw.j(this.cqA, this.oGD.m("ok", localHashMap));
      }
      for (;;)
      {
        bPk();
        AppMethodBeat.o(106574);
        return;
        if (this.oGF == -1) {
          this.nNw.j(this.cqA, this.oGD.m("fail not support", localHashMap));
        } else if (this.oGF == 1) {
          this.nNw.j(this.cqA, this.oGD.m("ok", localHashMap));
        } else {
          this.nNw.j(this.cqA, this.oGD.m("fail unknown error", localHashMap));
        }
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(106578);
      super.f(paramParcel);
      this.oGF = paramParcel.readInt();
      this.oGE = paramParcel.readInt();
      AppMethodBeat.o(106578);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106576);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.oGF);
      paramParcel.writeInt(this.oGE);
      AppMethodBeat.o(106576);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckBioEnrollment
 * JD-Core Version:    0.7.0.1
 */