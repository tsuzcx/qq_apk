package com.tencent.mm.plugin.appbrand.jsapi.scanner;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.luggage.k.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.q;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public final class JsApiScanCode
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 148;
  public static final String NAME = "scanCode";
  private static volatile boolean pnL = false;
  
  public static class GetA8KeyTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetA8KeyTask> CREATOR;
    public int actionCode;
    public int fys;
    public int fyt;
    public String pnR;
    public String pnS;
    public Runnable pnT;
    
    static
    {
      AppMethodBeat.i(174882);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(174882);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(174876);
      final l locall = new l(this.pnR, this.fys, this.fyt, l.boo(), new byte[0]);
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
          JsApiScanCode.GetA8KeyTask.this.actionCode = locall.boh();
          switch (JsApiScanCode.GetA8KeyTask.this.actionCode)
          {
          }
          for (JsApiScanCode.GetA8KeyTask.this.pnS = "";; JsApiScanCode.GetA8KeyTask.this.pnS = locall.bof())
          {
            JsApiScanCode.GetA8KeyTask.b(JsApiScanCode.GetA8KeyTask.this);
            AppMethodBeat.o(174874);
            return 0;
          }
        }
      }, true);
      AppMethodBeat.o(174876);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(174877);
      if (this.pnT != null) {
        this.pnT.run();
      }
      AppMethodBeat.o(174877);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(174879);
      this.pnR = paramParcel.readString();
      this.actionCode = paramParcel.readInt();
      this.pnS = paramParcel.readString();
      this.fys = paramParcel.readInt();
      this.fyt = paramParcel.readInt();
      AppMethodBeat.o(174879);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(174878);
      paramParcel.writeString(this.pnR);
      paramParcel.writeInt(this.actionCode);
      paramParcel.writeString(this.pnS);
      paramParcel.writeInt(this.fys);
      paramParcel.writeInt(this.fyt);
      AppMethodBeat.o(174878);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanCode
 * JD-Core Version:    0.7.0.1
 */