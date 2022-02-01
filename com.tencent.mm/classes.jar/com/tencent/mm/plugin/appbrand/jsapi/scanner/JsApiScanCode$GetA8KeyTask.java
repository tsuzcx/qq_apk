package com.tencent.mm.plugin.appbrand.jsapi.scanner;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class JsApiScanCode$GetA8KeyTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetA8KeyTask> CREATOR;
  public int actionCode;
  public int dnt;
  public int dnu;
  public String lgs;
  public String lgt;
  public Runnable lgu;
  
  static
  {
    AppMethodBeat.i(174882);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(174882);
  }
  
  public final void aOA()
  {
    AppMethodBeat.i(174876);
    final k localk = new k(this.lgs, 36, this.dnt, this.dnu, null, (int)System.currentTimeMillis(), new byte[0]);
    x.a(localk.rr, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(174874);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          JsApiScanCode.GetA8KeyTask.this.actionCode = -1;
          JsApiScanCode.GetA8KeyTask.a(JsApiScanCode.GetA8KeyTask.this);
          AppMethodBeat.o(174874);
          return 0;
        }
        JsApiScanCode.GetA8KeyTask.this.actionCode = localk.aKt();
        switch (JsApiScanCode.GetA8KeyTask.this.actionCode)
        {
        }
        for (JsApiScanCode.GetA8KeyTask.this.lgt = "";; JsApiScanCode.GetA8KeyTask.this.lgt = localk.aKr())
        {
          JsApiScanCode.GetA8KeyTask.b(JsApiScanCode.GetA8KeyTask.this);
          AppMethodBeat.o(174874);
          return 0;
        }
      }
    }, true);
    AppMethodBeat.o(174876);
  }
  
  public final void aOB()
  {
    AppMethodBeat.i(174877);
    if (this.lgu != null) {
      this.lgu.run();
    }
    AppMethodBeat.o(174877);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(174879);
    this.lgs = paramParcel.readString();
    this.actionCode = paramParcel.readInt();
    this.lgt = paramParcel.readString();
    this.dnt = paramParcel.readInt();
    this.dnu = paramParcel.readInt();
    AppMethodBeat.o(174879);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(174878);
    paramParcel.writeString(this.lgs);
    paramParcel.writeInt(this.actionCode);
    paramParcel.writeString(this.lgt);
    paramParcel.writeInt(this.dnt);
    paramParcel.writeInt(this.dnu);
    AppMethodBeat.o(174878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanCode.GetA8KeyTask
 * JD-Core Version:    0.7.0.1
 */