package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class ac
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 99;
  private static final String NAME = "openDocument";
  private static long oSq = -1L;
  private String mAppID;
  private com.tencent.mm.plugin.multitask.c.a oSr;
  private com.tencent.mm.plugin.multitask.c.a oSs;
  private com.tencent.mm.plugin.appbrand.q.a orm;
  
  public ac()
  {
    AppMethodBeat.i(174793);
    this.oSr = new com.tencent.mm.plugin.multitask.c.a()
    {
      public final void bA(List<MultiTaskInfo> paramAnonymousList)
      {
        AppMethodBeat.i(282186);
        paramAnonymousList = paramAnonymousList.iterator();
        for (;;)
        {
          if (paramAnonymousList.hasNext())
          {
            MultiTaskInfo localMultiTaskInfo = (MultiTaskInfo)paramAnonymousList.next();
            if ((localMultiTaskInfo == null) || (localMultiTaskInfo.field_type != 4) || (localMultiTaskInfo.field_data == null)) {
              continue;
            }
            apf localapf = new apf();
            try
            {
              localapf.parseFrom(localMultiTaskInfo.field_data);
              if ((Util.nullAsNil(localapf.appId).equals(ac.d(ac.this))) && (ac.a(ac.this) != null)) {
                ac.a(ac.this).akK(MMApplicationContext.getProcessName());
              }
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                Log.e("MicroMsg.AppBrand.JsApiOpenDocument", "handleMultiTaskInfoClicked", new Object[] { localThrowable });
              }
            }
          }
        }
        AppMethodBeat.o(282186);
      }
    };
    this.oSs = new com.tencent.mm.plugin.multitask.c.a()
    {
      public final void bA(List<MultiTaskInfo> paramAnonymousList)
      {
        AppMethodBeat.i(272024);
        paramAnonymousList = paramAnonymousList.iterator();
        for (;;)
        {
          if (paramAnonymousList.hasNext())
          {
            MultiTaskInfo localMultiTaskInfo = (MultiTaskInfo)paramAnonymousList.next();
            if ((localMultiTaskInfo == null) || (localMultiTaskInfo.field_type != 4) || (localMultiTaskInfo.field_data == null)) {
              continue;
            }
            apf localapf = new apf();
            try
            {
              localapf.parseFrom(localMultiTaskInfo.field_data);
              if ((Util.nullAsNil(localapf.processName).equals(MMApplicationContext.getProcessName())) && (ac.a(ac.this) != null)) {
                ac.a(ac.this).akK("");
              }
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                Log.e("MicroMsg.AppBrand.JsApiOpenDocument", "handleMultiTaskInfoClicked", new Object[] { localThrowable });
              }
            }
          }
        }
        AppMethodBeat.o(272024);
      }
    };
    AppMethodBeat.o(174793);
  }
  
  private static String a(e parame, q paramq, String paramString)
  {
    AppMethodBeat.i(277064);
    if (paramq == null)
    {
      AppMethodBeat.o(277064);
      return null;
    }
    if ((parame == null) || (parame.getFileSystem() == null))
    {
      AppMethodBeat.o(277064);
      return null;
    }
    String str = paramq.bOF();
    if (!Util.nullAsNil(str).endsWith(paramString))
    {
      Log.i("MicroMsg.AppBrand.JsApiOpenDocument", "create new temp file for suffix");
      paramString = String.format("%s.%s", new Object[] { paramq.getName(), paramString });
      parame = parame.getFileSystem().adN(paramString);
      if ((parame != null) && (parame.ifE())) {}
    }
    try
    {
      parame.ifM();
      label109:
      u.on(str, parame.bOF());
      if ((parame.ifE()) && (parame.length() == paramq.length()))
      {
        parame = parame.bOF();
        AppMethodBeat.o(277064);
        return parame;
      }
      parame = paramq.bOF();
      AppMethodBeat.o(277064);
      return parame;
    }
    catch (IOException paramString)
    {
      break label109;
    }
  }
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46349);
    long l = Util.nowMilliSecond();
    if (l - oSq < 1000L)
    {
      parame.j(paramInt, h("fail:document viewer already starting", null));
      AppMethodBeat.o(46349);
      return;
    }
    oSq = l;
    final Context localContext = parame.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      parame.j(paramInt, h("fail", null));
      AppMethodBeat.o(46349);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("showMenu");
    Object localObject = paramJSONObject.optString("filePath");
    if (Util.isNullOrNil((String)localObject))
    {
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(46349);
      return;
    }
    q localq = parame.getFileSystem().adL((String)localObject);
    if (localq == null)
    {
      parame.j(paramInt, h("fail:file doesn't exist", null));
      AppMethodBeat.o(46349);
      return;
    }
    this.mAppID = parame.getAppId();
    String str = org.apache.commons.a.c.bIf((String)localObject);
    localObject = new OpenFileRequest();
    ((OpenFileRequest)localObject).filePath = a(parame, localq, str);
    ((OpenFileRequest)localObject).jmx = str;
    ((OpenFileRequest)localObject).appId = this.mAppID;
    ((OpenFileRequest)localObject).orn = bool;
    paramJSONObject = paramJSONObject.optString("fileType");
    if (!Util.isNullOrNil(paramJSONObject)) {
      ((OpenFileRequest)localObject).jmx = paramJSONObject;
    }
    com.tencent.mm.plugin.appbrand.ipc.a.b(localContext, (AppBrandProxyUIProcessTask.ProcessRequest)localObject, new AppBrandProxyUIProcessTask.b() {});
    k.a(parame.getAppId(), new k.c()
    {
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(174789);
        if (ac.a(ac.this) != null)
        {
          ac.a(ac.this);
          com.tencent.mm.plugin.appbrand.q.a.a(ac.b(ac.this));
        }
        AppMethodBeat.o(174789);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(174788);
        if (ac.a(ac.this) != null)
        {
          ac.a(ac.this);
          ac.a(ac.this, null);
        }
        k.b(parame.getAppId(), this);
        AppMethodBeat.o(174788);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(174790);
        if (ac.a(ac.this) != null)
        {
          ac.a(ac.this);
          com.tencent.mm.plugin.appbrand.q.a.a(ac.c(ac.this));
        }
        AppMethodBeat.o(174790);
      }
    });
    AppMethodBeat.o(46349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ac
 * JD-Core Version:    0.7.0.1
 */