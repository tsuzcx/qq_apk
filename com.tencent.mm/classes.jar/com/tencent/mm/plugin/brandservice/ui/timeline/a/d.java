package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.a.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.plugin.brandservice.a.a.a;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.plugin.webview.preload.TmplParams.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.e.j;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d
{
  private static AtomicBoolean gnl = new AtomicBoolean(false);
  private static d.d iic = d.d.iih;
  private static Boolean iid = null;
  private static Integer iie = null;
  
  public static boolean a(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    d.d locald1 = iic;
    switch (paramInt)
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 6: 
    default: 
      paramInt = -1;
    }
    TmplParams localTmplParams;
    for (;;)
    {
      localTmplParams = oB(paramInt);
      if (localTmplParams != null) {
        break;
      }
      y.e("MicroMsg.PreloadLogic", "tmplParams is null");
      return false;
      paramInt = 0;
      continue;
      paramInt = 2;
      continue;
      paramInt = 1;
      continue;
      paramInt = 3;
    }
    paramIntent.putExtra(e.j.uHX, localTmplParams);
    com.tencent.mm.plugin.webview.preload.a.aa(localTmplParams.rjC, 104, 1);
    Object localObject = new a.a();
    ((a.a)localObject).url = paramString;
    ((a.a)localObject).ibT = localTmplParams.version;
    localObject = ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.brandservice.a.a.class)).a((a.a)localObject);
    if ((localObject != null) && (!bk.bl(((com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a)localObject).field_forceUrl)))
    {
      paramString = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a)localObject).field_forceUrl;
      y.i("MicroMsg.PreloadLogic", "appMsgContext forceUrl:%s", new Object[] { paramString });
      paramIntent = new Intent();
      paramIntent.putExtra("rawUrl", paramString);
      com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
      com.tencent.mm.plugin.webview.preload.a.aa(localTmplParams.rjC, 107, 1);
    }
    for (;;)
    {
      return true;
      if ((localObject != null) && (!bk.bl(((com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a)localObject).field_content)) && (c.ays()))
      {
        y.i("MicroMsg.PreloadLogic", "appMsgContext url:%s size:%d cacheTime:%d", new Object[] { ((com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a)localObject).field_url, Integer.valueOf(((com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a)localObject).field_content.length()), Long.valueOf(((com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a)localObject).field_invalidTime) });
        y.v("MicroMsg.PreloadLogic", "debug appMsgContext:%s", new Object[] { ((com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a)localObject).field_content });
        String str = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a)localObject).field_content;
        d.d locald2 = iic;
        Bundle localBundle = new Bundle();
        localBundle.putInt("tmplType", 0);
        localBundle.putString("data", str);
        localBundle.putLong("startLoadPage", System.currentTimeMillis());
        f.a(locald2.processName, localBundle, d.c.class, null);
        paramIntent.putExtra(e.j.uHW, ((com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a)localObject).field_content);
      }
      paramIntent.putExtra(e.j.uHY, c.ayr());
      paramIntent.putExtra(e.j.uHZ, System.currentTimeMillis());
      paramIntent.putExtra(e.j.uIb, paramString);
      com.tencent.mm.plugin.webview.preload.a.aa(localTmplParams.rjC, 106, 1);
      switch (1.iif[locald1.ordinal()])
      {
      default: 
        break;
      case 1: 
        com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.preload.TmplWebViewMMUI", paramIntent);
        break;
      case 2: 
        com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.preload.TmplWebViewToolUI", paramIntent);
        break;
      case 3: 
        com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.preload.TmplWebViewTooLMpUI", paramIntent);
      }
    }
  }
  
  public static boolean ayw()
  {
    if ((com.tencent.mm.sdk.platformtools.d.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.d.DEBUG)) {
      return c.ayo();
    }
    if (iid != null) {
      return iid.booleanValue();
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100463");
    if ((localc.isValid()) && ("1".equals(localc.ctr().get("openMPPageFastLoad")))) {}
    for (boolean bool = true;; bool = false)
    {
      iid = Boolean.valueOf(bool);
      y.i("MicroMsg.PreloadLogic", "isPreloadOpen open %b", new Object[] { iid });
      return iid.booleanValue();
    }
  }
  
  private static TmplParams oB(int paramInt)
  {
    Object localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.a.c.d.oE(paramInt);
    if (localObject1 == null)
    {
      y.e("MicroMsg.PreloadLogic", "[createTmplParams]type:%d localTmplInfo is null", new Object[] { Integer.valueOf(paramInt) });
      com.tencent.mm.plugin.webview.preload.a.jdMethod_if(100);
      return null;
    }
    if (!e.bK(((com.tencent.mm.plugin.brandservice.ui.timeline.a.c.b)localObject1).field_filePath))
    {
      y.e("MicroMsg.PreloadLogic", "[createTmplParams]filePath:%s is null", new Object[] { ((com.tencent.mm.plugin.brandservice.ui.timeline.a.c.b)localObject1).field_filePath });
      com.tencent.mm.plugin.webview.preload.a.aa(((com.tencent.mm.plugin.brandservice.ui.timeline.a.c.b)localObject1).field_reportId, 100, 1);
      return null;
    }
    if (((com.tencent.mm.plugin.brandservice.ui.timeline.a.c.b)localObject1).field_versionLowerBound > ((com.tencent.mm.plugin.brandservice.ui.timeline.a.c.b)localObject1).field_version)
    {
      y.e("MicroMsg.PreloadLogic", "[createTmplParams]version:%d lowerBound:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.brandservice.ui.timeline.a.c.b)localObject1).field_version), Integer.valueOf(((com.tencent.mm.plugin.brandservice.ui.timeline.a.c.b)localObject1).field_versionLowerBound) });
      com.tencent.mm.plugin.webview.preload.a.aa(((com.tencent.mm.plugin.brandservice.ui.timeline.a.c.b)localObject1).field_reportId, 101, 1);
      return null;
    }
    if (!c.ayp())
    {
      localObject2 = com.tencent.mm.a.g.bQ(((com.tencent.mm.plugin.brandservice.ui.timeline.a.c.b)localObject1).field_filePath);
      if ((bk.bl((String)localObject2)) || (!((String)localObject2).equals(((com.tencent.mm.plugin.brandservice.ui.timeline.a.c.b)localObject1).field_md5)))
      {
        y.w("MicroMsg.PreloadLogic", "[createTmplParams]file md5 not equal, may be modify");
        com.tencent.mm.plugin.webview.preload.a.aa(((com.tencent.mm.plugin.brandservice.ui.timeline.a.c.b)localObject1).field_reportId, 102, 1);
        return null;
      }
    }
    Object localObject2 = new TmplParams.a();
    ((TmplParams.a)localObject2).rjD = paramInt;
    ((TmplParams.a)localObject2).rjE = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.c.b)localObject1).field_version;
    ((TmplParams.a)localObject2).rjH = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.c.b)localObject1).field_md5;
    ((TmplParams.a)localObject2).rjG = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.c.b)localObject1).field_filePath;
    ((TmplParams.a)localObject2).rjF = "https://mp.weixin.qq.com/s/index.html";
    ((TmplParams.a)localObject2).rjK = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.c.b)localObject1).field_reportId;
    ((TmplParams.a)localObject2).rjJ = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.c.b)localObject1).field_downloadTime;
    ((TmplParams.a)localObject2).rjI = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.c.b)localObject1).field_FullVersion;
    localObject1 = new TmplParams();
    ((TmplParams)localObject1).rjv = ((TmplParams.a)localObject2).rjD;
    ((TmplParams)localObject1).version = ((TmplParams.a)localObject2).rjE;
    ((TmplParams)localObject1).rfY = ((TmplParams.a)localObject2).rjF;
    ((TmplParams)localObject1).rjA = ((TmplParams.a)localObject2).rjG;
    ((TmplParams)localObject1).bIW = ((TmplParams.a)localObject2).rjH;
    ((TmplParams)localObject1).rjC = ((TmplParams.a)localObject2).rjK;
    ((TmplParams)localObject1).ouU = ((TmplParams.a)localObject2).rjJ;
    ((TmplParams)localObject1).rjB = ((TmplParams.a)localObject2).rjI;
    return localObject1;
  }
  
  public static void run()
  {
    Object localObject = c.ayn();
    iic = (d.d)localObject;
    if (localObject == d.d.iij)
    {
      if (iie == null)
      {
        localObject = com.tencent.mm.model.c.c.IX().fJ("100463");
        if (!((com.tencent.mm.storage.c)localObject).isValid())
        {
          y.i("MicroMsg.PreloadLogic", "webviewProcess item is null");
          iie = Integer.valueOf(0);
        }
        iie = Integer.valueOf(bk.getInt((String)((com.tencent.mm.storage.c)localObject).ctr().get("webviewProcess"), 0));
        y.i("MicroMsg.PreloadLogic", "webviewProcess %d", new Object[] { iie });
      }
      switch (iie.intValue())
      {
      default: 
        localObject = d.d.iii;
      }
    }
    for (;;)
    {
      iic = (d.d)localObject;
      y.i("MicroMsg.PreloadLogic", "[initDefaultProcess]DEFAULT_PROCESS:%s", new Object[] { iic });
      localObject = iic;
      if (ayw())
      {
        y.i("MicroMsg.PreloadLogic", "start");
        f.a("com.tencent.mm", null, d.a.class, null);
        if (c.ayr()) {
          f.a(((d.d)localObject).processName, new IPCInteger(0), d.b.class, null);
        }
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.brandservice.a.b.class)).axr();
      }
      return;
      localObject = d.d.iih;
      continue;
      localObject = d.d.iii;
      continue;
      localObject = d.d.iig;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.d
 * JD-Core Version:    0.7.0.1
 */