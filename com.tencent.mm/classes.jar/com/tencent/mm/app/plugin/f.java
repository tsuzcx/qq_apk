package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo;
import com.tencent.mm.plugin.appbrand.ui.AppBrandCheckWxaShortLinkUI;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.pluginsdk.ui.span.t.b;
import com.tencent.mm.protocal.protobuf.ecp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class f
  implements com.tencent.mm.pluginsdk.ui.span.d
{
  private static f fgp = null;
  private LruCache fgq;
  private a fgr;
  private URISpanHandlerSet fgs;
  private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> fgt;
  private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> fgu;
  private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> fgv;
  private Context mContext;
  
  private f()
  {
    AppMethodBeat.i(19669);
    this.fgq = new LruCache(128);
    this.mContext = null;
    this.fgt = new ArrayList();
    this.fgu = new ArrayList();
    this.fgv = new ArrayList();
    long l = Util.nowMilliSecond();
    Log.d("MicroMsg.URISpanHandler", "init URISpanHandler");
    this.mContext = MMApplicationContext.getContext();
    this.fgs = new URISpanHandlerSet(this.mContext);
    Class[] arrayOfClass = URISpanHandlerSet.class.getDeclaredClasses();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        if ((localClass != null) && (localClass.getSuperclass() != null) && (localClass.isAnnotationPresent(URISpanHandlerSet.a.class)) && (localClass.getSuperclass().getName().equals(URISpanHandlerSet.BaseUriSpanHandler.class.getName())))
        {
          for (;;)
          {
            try
            {
              localObject1 = (URISpanHandlerSet.a)localClass.getAnnotation(URISpanHandlerSet.a.class);
              localObject2 = localClass.getDeclaredConstructor(new Class[] { URISpanHandlerSet.class });
              if (localObject2 == null) {
                break label423;
              }
              localObject2 = (URISpanHandlerSet.BaseUriSpanHandler)URISpanHandlerSet.BaseUriSpanHandler.class.cast(((Constructor)localObject2).newInstance(new Object[] { this.fgs }));
              localObject1 = ((URISpanHandlerSet.a)localObject1).abS();
              if (localObject1 != URISpanHandlerSet.PRIORITY.LOW) {
                continue;
              }
              this.fgv.add(localObject2);
            }
            catch (Exception localException)
            {
              Object localObject1;
              Object localObject2;
              Log.printErrStackTrace("MicroMsg.URISpanHandler", localException, "", new Object[0]);
              Log.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", new Object[] { localClass.getName(), localException.getMessage(), localException.getClass().getName() });
              break label474;
              if (localException != URISpanHandlerSet.PRIORITY.HIGH) {
                continue;
              }
              this.fgt.add(localObject2);
              continue;
            }
            catch (Error localError)
            {
              Log.printErrStackTrace("MicroMsg.URISpanHandler", localError, "", new Object[0]);
              Log.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", new Object[] { localClass.getName(), localError.getMessage(), localError.getClass().getName() });
            }
            Log.d("MicroMsg.URISpanHandler", "successfully add: %s", new Object[] { localClass.getName() });
            break label474;
            if (localObject1 != URISpanHandlerSet.PRIORITY.NORMAL) {
              continue;
            }
            this.fgu.add(localObject2);
          }
          label423:
          Log.d("MicroMsg.URISpanHandler", "failed to add %s, constructor is null!!", new Object[] { localClass.getName() });
        }
      }
      else
      {
        Log.d("MicroMsg.URISpanHandler", "init URISpanHandler used :%d ms", new Object[] { Long.valueOf(Util.nowMilliSecond() - l) });
        AppMethodBeat.o(19669);
        return;
      }
      label474:
      i += 1;
    }
  }
  
  private void a(ecp paramecp, URISpanHandlerSet.TopicSpanHandler paramTopicSpanHandler, View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(279752);
    Log.d("MicroMsg.URISpanHandler", "handleSpanClick, response.JumpType: %s.", new Object[] { Integer.valueOf(paramecp.CNg) });
    int j = paramu.fromScene;
    int i = 73;
    if ((j == 1) || (j == 2)) {
      i = 73;
    }
    String str;
    for (;;)
    {
      str = com.tencent.mm.plugin.fts.a.d.Sx(i);
      if (paramecp.CNg != 1) {
        break;
      }
      i = paramu.type;
      if ((!contains(new int[] { 58 }, i)) || (!paramTopicSpanHandler.a(paramView, paramu, parami))) {
        break label611;
      }
      Log.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { paramTopicSpanHandler.getClass().getName() });
      this.mContext = null;
      this.fgs.mContext = null;
      AppMethodBeat.o(279752);
      return;
      if (j == 3) {
        i = 79;
      } else if ((j == 4) || (j == 5)) {
        i = 80;
      }
    }
    if (paramecp.CNg == 2)
    {
      paramTopicSpanHandler = new Intent();
      paramTopicSpanHandler.putExtra("rawUrl", paramecp.CMD);
      com.tencent.mm.by.c.b(this.mContext, "webview", ".ui.tools.WebViewUI", paramTopicSpanHandler);
      this.mContext = null;
      this.fgs.mContext = null;
      URISpanHandlerSet.TopicSpanHandler.a(paramView, paramu, str);
      AppMethodBeat.o(279752);
      return;
    }
    t.b localb;
    if (paramecp.CNg == 3)
    {
      Log.i("MicroMsg.URISpanHandler", "[WxaShortLinkUriSpanHandler] handleSpanClick ");
      parami = paramu.bnW;
      if ((parami instanceof Bundle))
      {
        paramTopicSpanHandler = ((Bundle)parami).getString("key_wxa_short_link_launch_scene", "");
        i = ((Bundle)parami).getInt("key_wxa_short_link_launch_chat_type", -1);
        if (!paramTopicSpanHandler.isEmpty())
        {
          localb = t.b.valueOf(paramTopicSpanHandler);
          Log.i("MicroMsg.URISpanHandler", "[WxaShortLinkUriSpanHandler] sceneName=%s  scene=%d  preScene=%d", new Object[] { paramTopicSpanHandler, Integer.valueOf(localb.Rtz), Integer.valueOf(localb.RtA) });
          if (paramecp.Uhg != null) {
            break label617;
          }
          paramTopicSpanHandler = "";
          if (paramecp.Uhf != null) {
            break label625;
          }
          parami = "";
          label372:
          j = paramecp.rWt;
          int k = paramecp.TuP;
          if (paramecp.rWI != null) {
            break label634;
          }
          paramecp = "";
          label394:
          paramTopicSpanHandler = new WxaShortLinkInfo(paramTopicSpanHandler, "", parami, j, k, paramecp);
          parami = new HashMap();
          parami.put("chatType", String.valueOf(i));
          parami.put("requestId", str);
          parami.put("message", paramu.url);
          paramecp = "";
          if (paramu.fromScene != 1) {
            break label777;
          }
          if (ab.Lj(paramu.chatroomName)) {
            break label670;
          }
          if (!as.bvK(paramu.chatroomName)) {
            break label642;
          }
          paramecp = paramu.username + "_2";
          label519:
          parami.put("prescene_for_report", "1");
          label531:
          if (paramu.fromScene != 1) {
            break label879;
          }
          if (ab.Lj(paramu.chatroomName)) {
            break label864;
          }
          parami.put("scene_for_report", "2");
        }
      }
    }
    for (;;)
    {
      parami.put("presceneNote_for_report", paramecp);
      AppBrandCheckWxaShortLinkUI.a(this.mContext, paramu.url, localb, paramTopicSpanHandler, parami);
      URISpanHandlerSet.TopicSpanHandler.a(paramView, paramu, str);
      this.mContext = null;
      this.fgs.mContext = null;
      label611:
      AppMethodBeat.o(279752);
      return;
      label617:
      paramTopicSpanHandler = paramecp.Uhg;
      break;
      label625:
      parami = paramecp.Uhf;
      break label372;
      label634:
      paramecp = paramecp.rWI;
      break label394;
      label642:
      paramecp = paramu.username + "_1";
      break label519;
      label670:
      if (ab.PT(paramu.chatroomName)) {}
      for (paramecp = paramu.chatroomName + "_" + paramu.username + "_4";; paramecp = paramu.chatroomName + "_" + paramu.username + "_3")
      {
        parami.put("prescene_for_report", "2");
        break;
      }
      label777:
      if (paramu.fromScene == 2)
      {
        parami.put("prescene_for_report", "3");
        break label531;
      }
      if (paramu.fromScene == 3)
      {
        parami.put("prescene_for_report", "5");
        break label531;
      }
      if (paramu.fromScene == 4)
      {
        parami.put("prescene_for_report", "4");
        break label531;
      }
      parami.put("prescene_for_report", "0");
      break label531;
      label864:
      parami.put("scene_for_report", "3");
      continue;
      label879:
      if (paramu.fromScene == 2) {
        parami.put("scene_for_report", "1");
      } else if (paramu.fromScene == 3) {
        parami.put("scene_for_report", "5");
      } else if (paramu.fromScene == 4) {
        parami.put("scene_for_report", "4");
      } else {
        parami.put("scene_for_report", "0");
      }
    }
  }
  
  public static f abQ()
  {
    AppMethodBeat.i(19668);
    if (fgp == null) {
      fgp = new f();
    }
    f localf = fgp;
    AppMethodBeat.o(19668);
    return localf;
  }
  
  private static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final boolean a(Context paramContext, final View paramView, final com.tencent.mm.pluginsdk.ui.applet.u paramu, final i parami)
  {
    AppMethodBeat.i(279749);
    if (paramu == null)
    {
      Log.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo is null");
      AppMethodBeat.o(279749);
      return false;
    }
    int i = paramu.type;
    if (parami == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo.getType:%d, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size:%d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(this.fgt.size()), Integer.valueOf(this.fgu.size()), Integer.valueOf(this.fgv.size()) });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.URISpanHandler", "handleSpanClick, context is null!");
      this.fgs.mContext = null;
      AppMethodBeat.o(279749);
      return false;
    }
    this.mContext = paramContext;
    this.fgs.mContext = this.mContext;
    paramContext = this.fgt.iterator();
    while (paramContext.hasNext())
    {
      localObject = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((contains(((URISpanHandlerSet.BaseUriSpanHandler)localObject).abR(), paramu.type)) && (((URISpanHandlerSet.BaseUriSpanHandler)localObject).a(paramView, paramu, parami)))
      {
        Log.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localObject.getClass().getName() });
        this.mContext = null;
        this.fgs.mContext = null;
        AppMethodBeat.o(279749);
        return true;
      }
    }
    Object localObject = this.fgu.iterator();
    while (((Iterator)localObject).hasNext())
    {
      final URISpanHandlerSet.BaseUriSpanHandler localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)((Iterator)localObject).next();
      if (((localBaseUriSpanHandler instanceof URISpanHandlerSet.TopicSpanHandler)) && (contains(localBaseUriSpanHandler.abR(), paramu.type)))
      {
        paramContext = null;
        if ((this.fgq.get(paramu.url) instanceof ecp)) {
          paramContext = (ecp)this.fgq.get(paramu.url);
        }
        if (paramContext == null)
        {
          if (this.fgr == null)
          {
            this.fgr = new a(this.mContext, paramu.fromScene, paramu.url, new a.a()
            {
              public final void a(Context paramAnonymousContext, ecp paramAnonymousecp)
              {
                AppMethodBeat.i(281639);
                Log.i("MicroMsg.URISpanHandler", "finishCheckTag");
                if (paramAnonymousecp == null)
                {
                  Log.i("MicroMsg.URISpanHandler", "handleSpanClick, response is null");
                  AppMethodBeat.o(281639);
                  return;
                }
                f.a(f.this, paramAnonymousContext);
                f.a(f.this).mContext = paramAnonymousContext;
                f.b(f.this).put(paramu.url, paramAnonymousecp);
                f.a(f.this, paramAnonymousecp, (URISpanHandlerSet.TopicSpanHandler)localBaseUriSpanHandler, paramView, paramu, parami);
                f.c(f.this);
                AppMethodBeat.o(281639);
              }
            });
            this.fgr.fgi = true;
            paramContext = this.fgr;
            if (paramContext.fgi)
            {
              paramContext.fgk = new a.2(paramContext);
              MMHandlerThread.postToMainThreadDelayed(paramContext.fgk, 1000L);
            }
            paramContext.fgj = new a.1(paramContext);
            MMHandlerThread.postToMainThreadDelayed(paramContext.fgj, 10000L);
            h.aHF().kcd.a(4790, paramContext);
            paramContext = new com.tencent.mm.app.plugin.c.a(paramContext.mContext, paramContext.Ln, paramContext.mScene);
            h.aHF().kcd.a(paramContext, 0);
          }
          else
          {
            Log.i("MicroMsg.URISpanHandler", "checkMPURL:%s.", new Object[] { this.fgr });
          }
        }
        else
        {
          Log.i("MicroMsg.URISpanHandler", "checkMPURL has cache.");
          a(paramContext, (URISpanHandlerSet.TopicSpanHandler)localBaseUriSpanHandler, paramView, paramu, parami);
        }
      }
      else if ((contains(localBaseUriSpanHandler.abR(), paramu.type)) && (localBaseUriSpanHandler.a(paramView, paramu, parami)))
      {
        Log.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.fgs.mContext = null;
        AppMethodBeat.o(279749);
        return true;
      }
    }
    paramContext = this.fgv.iterator();
    while (paramContext.hasNext())
    {
      localObject = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((contains(((URISpanHandlerSet.BaseUriSpanHandler)localObject).abR(), paramu.type)) && (((URISpanHandlerSet.BaseUriSpanHandler)localObject).a(paramView, paramu, parami)))
      {
        Log.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localObject.getClass().getName() });
        this.mContext = null;
        this.fgs.mContext = null;
        AppMethodBeat.o(279749);
        return true;
      }
    }
    this.mContext = null;
    this.fgs.mContext = null;
    Log.d("MicroMsg.URISpanHandler", "handleSpanClick, nothing handle");
    AppMethodBeat.o(279749);
    return false;
  }
  
  public final boolean b(Context paramContext, String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    AppMethodBeat.i(19672);
    if (paramu == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.URISpanHandler", "handleUriJump, url:%s, isAllowScanQrCode:%b, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size: %d, mLowPriorityHandlerList.size: %d", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(this.fgt.size()), Integer.valueOf(this.fgu.size()), Integer.valueOf(this.fgv.size()) });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.URISpanHandler", "handleUriJump, context is null!");
      this.fgs.mContext = null;
      AppMethodBeat.o(19672);
      return false;
    }
    this.mContext = paramContext;
    this.fgs.mContext = this.mContext;
    if (Util.isNullOrNil(paramString))
    {
      Log.d("MicroMsg.URISpanHandler", "handleUriJump, url is null");
      this.mContext = null;
      this.fgs.mContext = null;
      AppMethodBeat.o(19672);
      return false;
    }
    paramContext = this.fgt.iterator();
    URISpanHandlerSet.BaseUriSpanHandler localBaseUriSpanHandler;
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramu, paramBundle))
      {
        Log.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.fgs.mContext = null;
        AppMethodBeat.o(19672);
        return true;
      }
    }
    paramContext = this.fgu.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramu, paramBundle))
      {
        Log.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.fgs.mContext = null;
        AppMethodBeat.o(19672);
        return true;
      }
    }
    paramContext = this.fgv.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramu, paramBundle))
      {
        Log.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.fgs.mContext = null;
        AppMethodBeat.o(19672);
        return true;
      }
    }
    this.mContext = null;
    this.fgs.mContext = null;
    Log.d("MicroMsg.URISpanHandler", "handleUriJump, nothing handle");
    AppMethodBeat.o(19672);
    return false;
  }
  
  public final com.tencent.mm.pluginsdk.ui.applet.u y(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19670);
    Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url:%s, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size：%d", new Object[] { paramString, Integer.valueOf(this.fgt.size()), Integer.valueOf(this.fgu.size()), Integer.valueOf(this.fgv.size()) });
    if (paramContext == null)
    {
      Log.e("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl error, context is null!");
      this.fgs.mContext = null;
      AppMethodBeat.o(19670);
      return null;
    }
    this.mContext = paramContext;
    this.fgs.mContext = this.mContext;
    if (Util.isNullOrNil(paramString))
    {
      Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url is null");
      this.mContext = null;
      this.fgs.mContext = null;
      AppMethodBeat.o(19670);
      return null;
    }
    paramContext = this.fgt.iterator();
    com.tencent.mm.pluginsdk.ui.applet.u localu;
    while (paramContext.hasNext())
    {
      localu = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).hi(paramString);
      if (localu != null)
      {
        Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localu.type) });
        this.mContext = null;
        this.fgs.mContext = null;
        AppMethodBeat.o(19670);
        return localu;
      }
    }
    paramContext = this.fgu.iterator();
    while (paramContext.hasNext())
    {
      localu = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).hi(paramString);
      if (localu != null)
      {
        Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localu.type) });
        this.mContext = null;
        this.fgs.mContext = null;
        AppMethodBeat.o(19670);
        return localu;
      }
    }
    paramContext = this.fgv.iterator();
    while (paramContext.hasNext())
    {
      localu = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).hi(paramString);
      if (localu != null)
      {
        Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localu.type) });
        this.mContext = null;
        this.fgs.mContext = null;
        AppMethodBeat.o(19670);
        return localu;
      }
    }
    this.mContext = null;
    this.fgs.mContext = null;
    Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, nothing match");
    AppMethodBeat.o(19670);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.plugin.f
 * JD-Core Version:    0.7.0.1
 */