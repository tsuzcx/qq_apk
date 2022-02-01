package com.tencent.mm.plugin.appbrand.jsapi.scanner;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.luggage.l.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.pluginsdk.e.e;
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
  private static volatile boolean ssy = false;
  
  public static class GetA8KeyTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetA8KeyTask> CREATOR;
    public int actionCode;
    public int hDb;
    public int hDc;
    public String ssE;
    public String ssF;
    public Runnable ssG;
    
    static
    {
      AppMethodBeat.i(174882);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(174882);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(174876);
      final n localn = new n(this.ssE, this.hDb, this.hDc, n.bMd(), new byte[0]);
      z.a(localn.rr, new z.a()
      {
        public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, p paramAnonymousp)
        {
          AppMethodBeat.i(174874);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            JsApiScanCode.GetA8KeyTask.this.actionCode = -1;
            JsApiScanCode.GetA8KeyTask.a(JsApiScanCode.GetA8KeyTask.this);
            AppMethodBeat.o(174874);
            return 0;
          }
          JsApiScanCode.GetA8KeyTask.this.actionCode = localn.bLV();
          switch (JsApiScanCode.GetA8KeyTask.this.actionCode)
          {
          }
          for (JsApiScanCode.GetA8KeyTask.this.ssF = "";; JsApiScanCode.GetA8KeyTask.this.ssF = localn.bLT())
          {
            JsApiScanCode.GetA8KeyTask.b(JsApiScanCode.GetA8KeyTask.this);
            AppMethodBeat.o(174874);
            return 0;
          }
        }
      }, true);
      AppMethodBeat.o(174876);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(174877);
      if (this.ssG != null) {
        this.ssG.run();
      }
      AppMethodBeat.o(174877);
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(174879);
      this.ssE = paramParcel.readString();
      this.actionCode = paramParcel.readInt();
      this.ssF = paramParcel.readString();
      this.hDb = paramParcel.readInt();
      this.hDc = paramParcel.readInt();
      AppMethodBeat.o(174879);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(174878);
      paramParcel.writeString(this.ssE);
      paramParcel.writeInt(this.actionCode);
      paramParcel.writeString(this.ssF);
      paramParcel.writeInt(this.hDb);
      paramParcel.writeInt(this.hDc);
      AppMethodBeat.o(174878);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanCode
 * JD-Core Version:    0.7.0.1
 */