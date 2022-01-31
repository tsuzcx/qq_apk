package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ht;
import com.tencent.mm.g.a.ht.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

class JsApiCheckBioEnrollment$GetIsEnrolledTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetIsEnrolledTask> CREATOR;
  private int bxX;
  private c hAC;
  private JsApiCheckBioEnrollment hFd;
  private int hFe;
  private int hFf;
  
  static
  {
    AppMethodBeat.i(3214);
    CREATOR = new JsApiCheckBioEnrollment.GetIsEnrolledTask.1();
    AppMethodBeat.o(3214);
  }
  
  protected JsApiCheckBioEnrollment$GetIsEnrolledTask(Parcel paramParcel)
  {
    AppMethodBeat.i(3212);
    this.hAC = null;
    this.bxX = -1;
    this.hFe = -1;
    this.hFf = -1;
    f(paramParcel);
    AppMethodBeat.o(3212);
  }
  
  public JsApiCheckBioEnrollment$GetIsEnrolledTask(c paramc, int paramInt1, int paramInt2, JsApiCheckBioEnrollment paramJsApiCheckBioEnrollment)
  {
    this.hAC = null;
    this.bxX = -1;
    this.hFe = -1;
    this.hFf = -1;
    this.hAC = paramc;
    this.bxX = paramInt1;
    this.hFd = paramJsApiCheckBioEnrollment;
    this.hFe = paramInt2;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(3210);
    ht localht = new ht();
    localht.cwU.cwW = this.hFe;
    a.ymk.l(localht);
    this.hFf = localht.cwV.cwX;
    ab.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", new Object[] { Integer.valueOf(this.hFf) });
    aBp();
    AppMethodBeat.o(3210);
  }
  
  public final void atb()
  {
    boolean bool = false;
    AppMethodBeat.i(3209);
    super.atb();
    ab.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", new Object[] { Integer.valueOf(this.hFf) });
    HashMap localHashMap = new HashMap(2);
    if (this.hFf == 1) {
      bool = true;
    }
    localHashMap.put("isEnrolled", Boolean.valueOf(bool));
    if (this.hFf == 0) {
      this.hAC.h(this.bxX, this.hFd.j("ok", localHashMap));
    }
    for (;;)
    {
      h.ai(this);
      AppMethodBeat.o(3209);
      return;
      if (this.hFf == -1) {
        this.hAC.h(this.bxX, this.hFd.j("fail not support", localHashMap));
      } else if (this.hFf == 1) {
        this.hAC.h(this.bxX, this.hFd.j("ok", localHashMap));
      } else {
        this.hAC.h(this.bxX, this.hFd.j("fail unknown error", localHashMap));
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(3213);
    super.f(paramParcel);
    this.hFf = paramParcel.readInt();
    this.hFe = paramParcel.readInt();
    AppMethodBeat.o(3213);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(3211);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.hFf);
    paramParcel.writeInt(this.hFe);
    AppMethodBeat.o(3211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckBioEnrollment.GetIsEnrolledTask
 * JD-Core Version:    0.7.0.1
 */