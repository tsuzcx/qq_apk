package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.floatball.b;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.ball.c.i;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.a.d;
import org.json.JSONObject;

public final class ab
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 99;
  private static final String NAME = "openDocument";
  private static long kQh = -1L;
  private i kQi;
  private i kQj;
  private b ksU;
  private String mAppID;
  
  public ab()
  {
    AppMethodBeat.i(174793);
    this.kQi = new i()
    {
      public final void bq(List<BallInfo> paramAnonymousList)
      {
        AppMethodBeat.i(174791);
        paramAnonymousList = paramAnonymousList.iterator();
        while (paramAnonymousList.hasNext())
        {
          BallInfo localBallInfo = (BallInfo)paramAnonymousList.next();
          if ((localBallInfo != null) && (localBallInfo.type == 4) && (localBallInfo.ioY != null) && (bu.nullAsNil(localBallInfo.ioY.getString("appId")).equals(ab.d(ab.this))))
          {
            localBallInfo.ioY.putString("processName", ak.getProcessName());
            if (ab.a(ab.this) != null) {
              ab.a(ab.this).a(localBallInfo);
            }
          }
        }
        AppMethodBeat.o(174791);
      }
    };
    this.kQj = new i()
    {
      public final void bq(List<BallInfo> paramAnonymousList)
      {
        AppMethodBeat.i(174792);
        paramAnonymousList = paramAnonymousList.iterator();
        while (paramAnonymousList.hasNext())
        {
          BallInfo localBallInfo = (BallInfo)paramAnonymousList.next();
          if ((localBallInfo != null) && (localBallInfo.type == 4) && (localBallInfo.ioY != null) && (bu.nullAsNil(localBallInfo.ioY.getString("processName")).equals(ak.getProcessName())))
          {
            localBallInfo.ioY.putString("processName", "");
            if (ab.a(ab.this) != null) {
              ab.a(ab.this).a(localBallInfo);
            }
          }
        }
        AppMethodBeat.o(174792);
      }
    };
    AppMethodBeat.o(174793);
  }
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46349);
    long l = bu.fpO();
    if (l - kQh < 1000L)
    {
      paramc.h(paramInt, e("fail:document viewer already starting", null));
      AppMethodBeat.o(46349);
      return;
    }
    kQh = l;
    final Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(46349);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("showMenu");
    String str = paramJSONObject.optString("filePath");
    if (bu.isNullOrNil(str))
    {
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46349);
      return;
    }
    k localk = paramc.Fl().MP(str);
    if (localk == null)
    {
      paramc.h(paramInt, e("fail:file doesn't exist", null));
      AppMethodBeat.o(46349);
      return;
    }
    this.mAppID = paramc.getAppId();
    OpenFileRequest localOpenFileRequest = new OpenFileRequest();
    localOpenFileRequest.filePath = w.B(localk.fTh());
    localOpenFileRequest.fXl = d.getExtension(str);
    localOpenFileRequest.appId = this.mAppID;
    localOpenFileRequest.showMenu = bool;
    paramJSONObject = paramJSONObject.optString("fileType");
    if (!bu.isNullOrNil(paramJSONObject)) {
      localOpenFileRequest.fXl = paramJSONObject;
    }
    com.tencent.mm.plugin.appbrand.ipc.a.b(localContext, localOpenFileRequest, new AppBrandProxyUIProcessTask.b() {});
    h.a(paramc.getAppId(), new h.c()
    {
      public final void a(h.d paramAnonymousd)
      {
        AppMethodBeat.i(174789);
        if (ab.a(ab.this) != null) {
          ab.a(ab.this).b(ab.b(ab.this));
        }
        AppMethodBeat.o(174789);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(174788);
        if (ab.a(ab.this) != null)
        {
          ab.a(ab.this).onDestroy();
          ab.a(ab.this, null);
        }
        h.b(paramc.getAppId(), this);
        AppMethodBeat.o(174788);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(174790);
        if (ab.a(ab.this) != null) {
          ab.a(ab.this).b(ab.c(ab.this));
        }
        AppMethodBeat.o(174790);
      }
    });
    AppMethodBeat.o(46349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ab
 * JD-Core Version:    0.7.0.1
 */