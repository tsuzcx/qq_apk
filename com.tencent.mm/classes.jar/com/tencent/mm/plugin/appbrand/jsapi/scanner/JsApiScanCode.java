package com.tencent.mm.plugin.appbrand.jsapi.scanner;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.luggage.h.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public final class JsApiScanCode
  extends a<c>
{
  public static final int CTRL_INDEX = 148;
  public static final String NAME = "scanCode";
  private static volatile boolean kiB = false;
  
  public static class GetA8KeyTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetA8KeyTask> CREATOR;
    public int actionCode;
    public int deB;
    public int deC;
    public String kiH;
    public String kiI;
    public Runnable kiJ;
    
    static
    {
      AppMethodBeat.i(174882);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(174882);
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(174877);
      if (this.kiJ != null) {
        this.kiJ.run();
      }
      AppMethodBeat.o(174877);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(174876);
      final k localk = new k(this.kiH, 36, this.deB, this.deC, null, (int)System.currentTimeMillis(), new byte[0]);
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
          JsApiScanCode.GetA8KeyTask.this.actionCode = localk.aAs();
          switch (JsApiScanCode.GetA8KeyTask.this.actionCode)
          {
          }
          for (JsApiScanCode.GetA8KeyTask.this.kiI = "";; JsApiScanCode.GetA8KeyTask.this.kiI = localk.aAq())
          {
            JsApiScanCode.GetA8KeyTask.b(JsApiScanCode.GetA8KeyTask.this);
            AppMethodBeat.o(174874);
            return 0;
          }
        }
      }, true);
      AppMethodBeat.o(174876);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(174879);
      this.kiH = paramParcel.readString();
      this.actionCode = paramParcel.readInt();
      this.kiI = paramParcel.readString();
      this.deB = paramParcel.readInt();
      this.deC = paramParcel.readInt();
      AppMethodBeat.o(174879);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(174878);
      paramParcel.writeString(this.kiH);
      paramParcel.writeInt(this.actionCode);
      paramParcel.writeString(this.kiI);
      paramParcel.writeInt(this.deB);
      paramParcel.writeInt(this.deC);
      AppMethodBeat.o(174878);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanCode
 * JD-Core Version:    0.7.0.1
 */