package com.tencent.mm.plugin.appbrand.jsapi.scanner;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class JsApiScanCode$GetA8KeyTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetA8KeyTask> CREATOR;
  public int actionCode;
  public int dov;
  public int dow;
  public String lke;
  public String lkf;
  public Runnable lkg;
  
  static
  {
    AppMethodBeat.i(174882);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(174882);
  }
  
  public final void aOX()
  {
    AppMethodBeat.i(174876);
    final l locall = new l(this.lke, 36, this.dov, this.dow, null, (int)System.currentTimeMillis(), new byte[0]);
    x.a(locall.rr, new x.a()
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
        JsApiScanCode.GetA8KeyTask.this.actionCode = locall.aKQ();
        switch (JsApiScanCode.GetA8KeyTask.this.actionCode)
        {
        }
        for (JsApiScanCode.GetA8KeyTask.this.lkf = "";; JsApiScanCode.GetA8KeyTask.this.lkf = locall.aKO())
        {
          JsApiScanCode.GetA8KeyTask.b(JsApiScanCode.GetA8KeyTask.this);
          AppMethodBeat.o(174874);
          return 0;
        }
      }
    }, true);
    AppMethodBeat.o(174876);
  }
  
  public final void aOY()
  {
    AppMethodBeat.i(174877);
    if (this.lkg != null) {
      this.lkg.run();
    }
    AppMethodBeat.o(174877);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(174879);
    this.lke = paramParcel.readString();
    this.actionCode = paramParcel.readInt();
    this.lkf = paramParcel.readString();
    this.dov = paramParcel.readInt();
    this.dow = paramParcel.readInt();
    AppMethodBeat.o(174879);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(174878);
    paramParcel.writeString(this.lke);
    paramParcel.writeInt(this.actionCode);
    paramParcel.writeString(this.lkf);
    paramParcel.writeInt(this.dov);
    paramParcel.writeInt(this.dow);
    AppMethodBeat.o(174878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanCode.GetA8KeyTask
 * JD-Core Version:    0.7.0.1
 */