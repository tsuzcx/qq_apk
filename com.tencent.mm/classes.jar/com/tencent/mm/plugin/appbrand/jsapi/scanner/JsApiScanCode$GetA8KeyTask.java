package com.tencent.mm.plugin.appbrand.jsapi.scanner;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class JsApiScanCode$GetA8KeyTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetA8KeyTask> CREATOR;
  public int actionCode;
  public int dFL;
  public int dFM;
  public String mpM;
  public String mpN;
  public Runnable mpO;
  
  static
  {
    AppMethodBeat.i(174882);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(174882);
  }
  
  public final void bjj()
  {
    AppMethodBeat.i(174876);
    final l locall = new l(this.mpM, 36, this.dFL, this.dFM, (int)System.currentTimeMillis(), new byte[0]);
    aa.a(locall.rr, new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(174874);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          JsApiScanCode.GetA8KeyTask.this.actionCode = -1;
          JsApiScanCode.GetA8KeyTask.a(JsApiScanCode.GetA8KeyTask.this);
          AppMethodBeat.o(174874);
          return 0;
        }
        JsApiScanCode.GetA8KeyTask.this.actionCode = locall.beS();
        switch (JsApiScanCode.GetA8KeyTask.this.actionCode)
        {
        }
        for (JsApiScanCode.GetA8KeyTask.this.mpN = "";; JsApiScanCode.GetA8KeyTask.this.mpN = locall.beQ())
        {
          JsApiScanCode.GetA8KeyTask.b(JsApiScanCode.GetA8KeyTask.this);
          AppMethodBeat.o(174874);
          return 0;
        }
      }
    }, true);
    AppMethodBeat.o(174876);
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(174877);
    if (this.mpO != null) {
      this.mpO.run();
    }
    AppMethodBeat.o(174877);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(174879);
    this.mpM = paramParcel.readString();
    this.actionCode = paramParcel.readInt();
    this.mpN = paramParcel.readString();
    this.dFL = paramParcel.readInt();
    this.dFM = paramParcel.readInt();
    AppMethodBeat.o(174879);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(174878);
    paramParcel.writeString(this.mpM);
    paramParcel.writeInt(this.actionCode);
    paramParcel.writeString(this.mpN);
    paramParcel.writeInt(this.dFL);
    paramParcel.writeInt(this.dFM);
    AppMethodBeat.o(174878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanCode.GetA8KeyTask
 * JD-Core Version:    0.7.0.1
 */