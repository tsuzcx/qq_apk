package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Context;
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

class JsApiLuggageCheckBioEnrollment$GetIsEnrolledTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetIsEnrolledTask> CREATOR;
  private int bxX;
  private c hAC;
  private int hFe;
  private int hFf;
  private JsApiLuggageCheckBioEnrollment hFl;
  
  static
  {
    AppMethodBeat.i(73782);
    CREATOR = new JsApiLuggageCheckBioEnrollment.GetIsEnrolledTask.1();
    AppMethodBeat.o(73782);
  }
  
  protected JsApiLuggageCheckBioEnrollment$GetIsEnrolledTask(Parcel paramParcel)
  {
    AppMethodBeat.i(73780);
    this.hAC = null;
    this.bxX = -1;
    this.hFe = -1;
    this.hFf = -1;
    f(paramParcel);
    AppMethodBeat.o(73780);
  }
  
  public JsApiLuggageCheckBioEnrollment$GetIsEnrolledTask(c paramc, int paramInt1, int paramInt2, JsApiLuggageCheckBioEnrollment paramJsApiLuggageCheckBioEnrollment)
  {
    this.hAC = null;
    this.bxX = -1;
    this.hFe = -1;
    this.hFf = -1;
    this.hAC = paramc;
    this.bxX = paramInt1;
    this.hFl = paramJsApiLuggageCheckBioEnrollment;
    this.hFe = paramInt2;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(73778);
    Context localContext = JsApiLuggageCheckBioEnrollment.access$000();
    int i;
    if (this.hFe == 1) {
      if (a.ji(localContext)) {
        i = 1;
      }
    }
    for (;;)
    {
      this.hFf = i;
      ab.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", new Object[] { Integer.valueOf(this.hFf) });
      aBp();
      AppMethodBeat.o(73778);
      return;
      i = 0;
      continue;
      i = -1;
    }
  }
  
  public final void atb()
  {
    boolean bool = false;
    AppMethodBeat.i(73777);
    super.atb();
    ab.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", new Object[] { Integer.valueOf(this.hFf) });
    HashMap localHashMap = new HashMap(2);
    if (this.hFf == 1) {
      bool = true;
    }
    localHashMap.put("isEnrolled", Boolean.valueOf(bool));
    if (this.hFf == 0) {
      this.hAC.h(this.bxX, this.hFl.j("ok", localHashMap));
    }
    for (;;)
    {
      h.ai(this);
      AppMethodBeat.o(73777);
      return;
      if (this.hFf == -1) {
        this.hAC.h(this.bxX, this.hFl.j("fail not support", localHashMap));
      } else if (this.hFf == 1) {
        this.hAC.h(this.bxX, this.hFl.j("ok", localHashMap));
      } else {
        this.hAC.h(this.bxX, this.hFl.j("fail unknown error", localHashMap));
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(73781);
    super.f(paramParcel);
    this.hFf = paramParcel.readInt();
    this.hFe = paramParcel.readInt();
    AppMethodBeat.o(73781);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(73779);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.hFf);
    paramParcel.writeInt(this.hFe);
    AppMethodBeat.o(73779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckBioEnrollment.GetIsEnrolledTask
 * JD-Core Version:    0.7.0.1
 */