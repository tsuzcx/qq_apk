package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.core.a;
import java.util.HashMap;
import java.util.Map;

class JsApiLuggageCheckIsSupportSoterAuthentication$GetIsSupportSoterTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetIsSupportSoterTask> CREATOR;
  private int bxX;
  private c hAC;
  private JsApiLuggageCheckIsSupportSoterAuthentication hFn;
  private String hFo;
  
  static
  {
    AppMethodBeat.i(73790);
    CREATOR = new JsApiLuggageCheckIsSupportSoterAuthentication.GetIsSupportSoterTask.1();
    AppMethodBeat.o(73790);
  }
  
  protected JsApiLuggageCheckIsSupportSoterAuthentication$GetIsSupportSoterTask(Parcel paramParcel)
  {
    AppMethodBeat.i(73788);
    this.hAC = null;
    this.bxX = -1;
    this.hFo = "";
    f(paramParcel);
    AppMethodBeat.o(73788);
  }
  
  public JsApiLuggageCheckIsSupportSoterAuthentication$GetIsSupportSoterTask(c paramc, int paramInt, JsApiLuggageCheckIsSupportSoterAuthentication paramJsApiLuggageCheckIsSupportSoterAuthentication)
  {
    this.hAC = null;
    this.bxX = -1;
    this.hFo = "";
    this.hAC = paramc;
    this.bxX = paramInt;
    this.hFn = paramJsApiLuggageCheckIsSupportSoterAuthentication;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(73786);
    this.hFo = a.dVi();
    ab.i("MicroMsg.GetIsSupportSoterTask", "hy: verifyRemoteStr: %s", new Object[] { this.hFo });
    aBp();
    AppMethodBeat.o(73786);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(73785);
    super.atb();
    ab.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. verifyRemoteStr: %s", new Object[] { this.hFo });
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("verifyRemote", this.hFo);
    localHashMap.put("nativeSupport", Boolean.valueOf(a.dVc()));
    ab.i("MicroMsg.GetIsSupportSoterTask", "hy: nativeSupport:" + a.dVc());
    this.hAC.h(this.bxX, this.hFn.j("ok", localHashMap));
    h.ai(this);
    AppMethodBeat.o(73785);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(73789);
    super.f(paramParcel);
    this.hFo = paramParcel.readString();
    AppMethodBeat.o(73789);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(73787);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.hFo);
    AppMethodBeat.o(73787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckIsSupportSoterAuthentication.GetIsSupportSoterTask
 * JD-Core Version:    0.7.0.1
 */