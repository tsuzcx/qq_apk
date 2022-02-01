package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.floatball.b;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.ball.c.h;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import org.apache.commons.a.d;
import org.json.JSONObject;

public final class z
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 99;
  private static final String NAME = "openDocument";
  private static long kMM = -1L;
  private h kMN;
  private h kMO;
  private b kpE;
  private String mAppID;
  
  public z()
  {
    AppMethodBeat.i(174793);
    this.kMN = new z.3(this);
    this.kMO = new z.4(this);
    AppMethodBeat.o(174793);
  }
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46349);
    long l = bt.flT();
    if (l - kMM < 1000L)
    {
      paramc.h(paramInt, e("fail:document viewer already starting", null));
      AppMethodBeat.o(46349);
      return;
    }
    kMM = l;
    final Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(46349);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("showMenu");
    String str = paramJSONObject.optString("filePath");
    if (bt.isNullOrNil(str))
    {
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46349);
      return;
    }
    e locale = paramc.Fg().Mj(str);
    if (locale == null)
    {
      paramc.h(paramInt, e("fail:file doesn't exist", null));
      AppMethodBeat.o(46349);
      return;
    }
    this.mAppID = paramc.getAppId();
    OpenFileRequest localOpenFileRequest = new OpenFileRequest();
    localOpenFileRequest.filePath = q.B(locale.fOK());
    localOpenFileRequest.fVf = d.getExtension(str);
    localOpenFileRequest.appId = this.mAppID;
    localOpenFileRequest.kpF = bool;
    paramJSONObject = paramJSONObject.optString("fileType");
    if (!bt.isNullOrNil(paramJSONObject)) {
      localOpenFileRequest.fVf = paramJSONObject;
    }
    com.tencent.mm.plugin.appbrand.ipc.a.b(localContext, localOpenFileRequest, new AppBrandProxyUIProcessTask.b() {});
    g.a(paramc.getAppId(), new g.c()
    {
      public final void a(g.d paramAnonymousd)
      {
        AppMethodBeat.i(174789);
        if (z.a(z.this) != null) {
          z.a(z.this).b(z.b(z.this));
        }
        AppMethodBeat.o(174789);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(174788);
        if (z.a(z.this) != null)
        {
          z.a(z.this).onDestroy();
          z.a(z.this, null);
        }
        g.b(paramc.getAppId(), this);
        AppMethodBeat.o(174788);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(174790);
        if (z.a(z.this) != null) {
          z.a(z.this).b(z.c(z.this));
        }
        AppMethodBeat.o(174790);
      }
    });
    AppMethodBeat.o(46349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.z
 * JD-Core Version:    0.7.0.1
 */