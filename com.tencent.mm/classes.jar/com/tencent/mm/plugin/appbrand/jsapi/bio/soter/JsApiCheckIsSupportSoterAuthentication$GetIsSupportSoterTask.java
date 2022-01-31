package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.g.a.hv.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

class JsApiCheckIsSupportSoterAuthentication$GetIsSupportSoterTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetIsSupportSoterTask> CREATOR;
  private int bxX;
  private c hAC;
  private JsApiCheckIsSupportSoterAuthentication hFh;
  private int hFi;
  
  static
  {
    AppMethodBeat.i(3222);
    CREATOR = new JsApiCheckIsSupportSoterAuthentication.GetIsSupportSoterTask.1();
    AppMethodBeat.o(3222);
  }
  
  protected JsApiCheckIsSupportSoterAuthentication$GetIsSupportSoterTask(Parcel paramParcel)
  {
    AppMethodBeat.i(3220);
    this.hAC = null;
    this.bxX = -1;
    this.hFi = 0;
    f(paramParcel);
    AppMethodBeat.o(3220);
  }
  
  public JsApiCheckIsSupportSoterAuthentication$GetIsSupportSoterTask(c paramc, int paramInt, JsApiCheckIsSupportSoterAuthentication paramJsApiCheckIsSupportSoterAuthentication)
  {
    this.hAC = null;
    this.bxX = -1;
    this.hFi = 0;
    this.hAC = paramc;
    this.bxX = paramInt;
    this.hFh = paramJsApiCheckIsSupportSoterAuthentication;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(3218);
    hv localhv = new hv();
    com.tencent.mm.sdk.b.a.ymk.l(localhv);
    this.hFi = localhv.cxd.cxe;
    ab.i("MicroMsg.GetIsSupportSoterTask", "hy: supportMode: %d", new Object[] { Integer.valueOf(this.hFi) });
    aBp();
    AppMethodBeat.o(3218);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(3217);
    super.atb();
    ab.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. supportMode: %d", new Object[] { Integer.valueOf(this.hFi) });
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("supportMode", a.nS(this.hFi));
    this.hAC.h(this.bxX, this.hFh.j("ok", localHashMap));
    h.ai(this);
    AppMethodBeat.o(3217);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(3221);
    super.f(paramParcel);
    this.hFi = paramParcel.readInt();
    AppMethodBeat.o(3221);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(3219);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.hFi);
    AppMethodBeat.o(3219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication.GetIsSupportSoterTask
 * JD-Core Version:    0.7.0.1
 */