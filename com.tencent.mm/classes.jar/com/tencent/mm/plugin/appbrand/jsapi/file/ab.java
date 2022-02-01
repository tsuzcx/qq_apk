package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import org.json.JSONObject;

public final class ab
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  private static final int CTRL_INDEX = 99;
  private static final String NAME = "openDocument";
  private static long lVm = -1L;
  private com.tencent.mm.plugin.multitask.c.a lVn;
  private com.tencent.mm.plugin.multitask.c.a lVo;
  private com.tencent.mm.plugin.appbrand.q.a lwE;
  private String mAppID;
  
  public ab()
  {
    AppMethodBeat.i(174793);
    this.lVn = new ab.3(this);
    this.lVo = new ab.4(this);
    AppMethodBeat.o(174793);
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46349);
    long l = Util.nowMilliSecond();
    if (l - lVm < 1000L)
    {
      paramf.i(paramInt, h("fail:document viewer already starting", null));
      AppMethodBeat.o(46349);
      return;
    }
    lVm = l;
    final Context localContext = paramf.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramf.i(paramInt, h("fail", null));
      AppMethodBeat.o(46349);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("showMenu");
    String str = paramJSONObject.optString("filePath");
    if (Util.isNullOrNil(str))
    {
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(46349);
      return;
    }
    o localo = paramf.getFileSystem().VY(str);
    if (localo == null)
    {
      paramf.i(paramInt, h("fail:file doesn't exist", null));
      AppMethodBeat.o(46349);
      return;
    }
    this.mAppID = paramf.getAppId();
    OpenFileRequest localOpenFileRequest = new OpenFileRequest();
    localOpenFileRequest.filePath = aa.z(localo.her());
    localOpenFileRequest.gCr = org.apache.commons.a.d.getExtension(str);
    localOpenFileRequest.appId = this.mAppID;
    localOpenFileRequest.lwF = bool;
    paramJSONObject = paramJSONObject.optString("fileType");
    if (!Util.isNullOrNil(paramJSONObject)) {
      localOpenFileRequest.gCr = paramJSONObject;
    }
    com.tencent.mm.plugin.appbrand.ipc.a.b(localContext, localOpenFileRequest, new AppBrandProxyUIProcessTask.b() {});
    h.a(paramf.getAppId(), new h.c()
    {
      public final void a(h.d paramAnonymousd)
      {
        AppMethodBeat.i(174789);
        if (ab.a(ab.this) != null)
        {
          ab.a(ab.this);
          com.tencent.mm.plugin.appbrand.q.a.a(ab.b(ab.this));
        }
        AppMethodBeat.o(174789);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(174788);
        if (ab.a(ab.this) != null)
        {
          ab.a(ab.this);
          ab.a(ab.this, null);
        }
        h.b(paramf.getAppId(), this);
        AppMethodBeat.o(174788);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(174790);
        if (ab.a(ab.this) != null)
        {
          ab.a(ab.this);
          com.tencent.mm.plugin.appbrand.q.a.a(ab.c(ab.this));
        }
        AppMethodBeat.o(174790);
      }
    });
    AppMethodBeat.o(46349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ab
 * JD-Core Version:    0.7.0.1
 */