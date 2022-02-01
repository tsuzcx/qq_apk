package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo;
import com.tencent.mm.plugin.appbrand.ui.AppBrandCheckWxaShortLinkUI;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.pluginsdk.ui.span.x.b;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.protocal.protobuf.ewg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class f
  implements com.tencent.mm.pluginsdk.ui.span.d
{
  private static f hkz = null;
  private LruCache hkA;
  private a hkB;
  private URISpanHandlerSet hkC;
  public ArrayList<URISpanHandlerSet.BaseUriSpanHandler> hkD;
  private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> hkE;
  private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> hkF;
  private Context mContext;
  
  private f()
  {
    AppMethodBeat.i(19669);
    this.hkA = new LruCache(128);
    this.mContext = null;
    this.hkD = new ArrayList();
    this.hkE = new ArrayList();
    this.hkF = new ArrayList();
    long l = Util.nowMilliSecond();
    Log.d("MicroMsg.URISpanHandler", "init URISpanHandler");
    this.mContext = MMApplicationContext.getContext();
    this.hkC = new URISpanHandlerSet(this.mContext);
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
              localObject2 = (URISpanHandlerSet.BaseUriSpanHandler)URISpanHandlerSet.BaseUriSpanHandler.class.cast(((Constructor)localObject2).newInstance(new Object[] { this.hkC }));
              localObject1 = ((URISpanHandlerSet.a)localObject1).aDR();
              if (localObject1 != URISpanHandlerSet.PRIORITY.LOW) {
                continue;
              }
              this.hkF.add(localObject2);
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
              this.hkD.add(localObject2);
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
            this.hkE.add(localObject2);
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
  
  private void a(ewg paramewg, URISpanHandlerSet.TopicSpanHandler paramTopicSpanHandler, View paramView, u paramu, m paramm)
  {
    AppMethodBeat.i(239343);
    Log.d("MicroMsg.URISpanHandler", "handleSpanClick, response.JumpType: %s.", new Object[] { Integer.valueOf(paramewg.IHl) });
    int j = paramu.fromScene;
    int i = 73;
    if ((j == 1) || (j == 4) || (j == 6)) {
      i = 73;
    }
    String str;
    for (;;)
    {
      Log.i("MicroMsg.URISpanHandler", "scene1 = ".concat(String.valueOf(i)));
      str = com.tencent.mm.plugin.fts.a.d.We(i);
      if (paramewg.IHl != 1) {
        break;
      }
      i = paramu.type;
      if ((!contains(new int[] { 58 }, i)) || (!paramTopicSpanHandler.a(paramView, paramu, paramm))) {
        break label647;
      }
      Log.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { paramTopicSpanHandler.getClass().getName() });
      this.mContext = null;
      this.hkC.mContext = null;
      AppMethodBeat.o(239343);
      return;
      if (j == 2) {
        i = 79;
      } else if (j == 5) {
        i = 80;
      } else {
        Log.e("MicroMsg.URISpanHandler", "error scene fromScene = ".concat(String.valueOf(j)));
      }
    }
    if (paramewg.IHl == 2)
    {
      paramTopicSpanHandler = new Intent();
      paramTopicSpanHandler.putExtra("rawUrl", paramewg.IGI);
      com.tencent.mm.br.c.b(this.mContext, "webview", ".ui.tools.WebViewUI", paramTopicSpanHandler);
      this.mContext = null;
      this.hkC.mContext = null;
      URISpanHandlerSet.TopicSpanHandler.a(paramView, paramu, str);
      AppMethodBeat.o(239343);
      return;
    }
    x.b localb;
    if (paramewg.IHl == 3)
    {
      Log.i("MicroMsg.URISpanHandler", "[WxaShortLinkUriSpanHandler] handleSpanClick ");
      paramm = paramu.cpt;
      if ((paramm instanceof Bundle))
      {
        paramTopicSpanHandler = ((Bundle)paramm).getString("key_wxa_short_link_launch_scene", "");
        i = ((Bundle)paramm).getInt("key_wxa_short_link_launch_chat_type", -1);
        if (!paramTopicSpanHandler.isEmpty())
        {
          localb = x.b.valueOf(paramTopicSpanHandler);
          Log.i("MicroMsg.URISpanHandler", "[WxaShortLinkUriSpanHandler] sceneName=%s  scene=%d  preScene=%d", new Object[] { paramTopicSpanHandler, Integer.valueOf(localb.CKA), Integer.valueOf(localb.YpH) });
          if (paramewg.abyJ != null) {
            break label653;
          }
          paramTopicSpanHandler = "";
          if (paramewg.abyI != null) {
            break label661;
          }
          paramm = "";
          label408:
          j = paramewg.crz;
          int k = paramewg.aaJu;
          if (paramewg.vhX != null) {
            break label670;
          }
          paramewg = "";
          label430:
          paramTopicSpanHandler = new WxaShortLinkInfo(paramTopicSpanHandler, "", paramm, j, k, paramewg);
          paramm = new HashMap();
          paramm.put("chatType", String.valueOf(i));
          paramm.put("requestId", str);
          paramm.put("message", paramu.url);
          paramewg = "";
          if (paramu.fromScene != 1) {
            break label813;
          }
          if (au.bwE(paramu.chatroomName)) {
            break label706;
          }
          if (!au.bwO(paramu.chatroomName)) {
            break label678;
          }
          paramewg = paramu.username + "_2";
          label555:
          paramm.put("prescene_for_report", "1");
          label567:
          if (paramu.fromScene != 1) {
            break label934;
          }
          if (au.bwE(paramu.chatroomName)) {
            break label919;
          }
          paramm.put("scene_for_report", "2");
        }
      }
    }
    for (;;)
    {
      paramm.put("presceneNote_for_report", paramewg);
      AppBrandCheckWxaShortLinkUI.a(this.mContext, paramu.url, localb, paramTopicSpanHandler, paramm);
      URISpanHandlerSet.TopicSpanHandler.a(paramView, paramu, str);
      this.mContext = null;
      this.hkC.mContext = null;
      label647:
      AppMethodBeat.o(239343);
      return;
      label653:
      paramTopicSpanHandler = paramewg.abyJ;
      break;
      label661:
      paramm = paramewg.abyI;
      break label408;
      label670:
      paramewg = paramewg.vhX;
      break label430;
      label678:
      paramewg = paramu.username + "_1";
      break label555;
      label706:
      if (ab.II(paramu.chatroomName)) {}
      for (paramewg = paramu.chatroomName + "_" + paramu.username + "_4";; paramewg = paramu.chatroomName + "_" + paramu.username + "_3")
      {
        paramm.put("prescene_for_report", "2");
        break;
      }
      label813:
      if ((paramu.fromScene == 2) || (paramu.fromScene == 5))
      {
        paramm.put("prescene_for_report", "3");
        break label567;
      }
      if (paramu.fromScene == 3)
      {
        paramm.put("prescene_for_report", "5");
        break label567;
      }
      if ((paramu.fromScene == 4) || (paramu.fromScene == 6))
      {
        paramm.put("prescene_for_report", "4");
        break label567;
      }
      paramm.put("prescene_for_report", "0");
      break label567;
      label919:
      paramm.put("scene_for_report", "3");
      continue;
      label934:
      if ((paramu.fromScene == 2) || (paramu.fromScene == 5)) {
        paramm.put("scene_for_report", "1");
      } else if (paramu.fromScene == 3) {
        paramm.put("scene_for_report", "5");
      } else if ((paramu.fromScene == 4) || (paramu.fromScene == 6)) {
        paramm.put("scene_for_report", "4");
      } else {
        paramm.put("scene_for_report", "0");
      }
    }
  }
  
  public static f aDP()
  {
    AppMethodBeat.i(19668);
    if (hkz == null) {
      hkz = new f();
    }
    f localf = hkz;
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
  
  public final u C(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19670);
    Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url:%s, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size：%d", new Object[] { paramString, Integer.valueOf(this.hkD.size()), Integer.valueOf(this.hkE.size()), Integer.valueOf(this.hkF.size()) });
    if (paramContext == null)
    {
      Log.e("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl error, context is null!");
      this.hkC.mContext = null;
      AppMethodBeat.o(19670);
      return null;
    }
    this.mContext = paramContext;
    this.hkC.mContext = this.mContext;
    if (Util.isNullOrNil(paramString))
    {
      Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url is null");
      this.mContext = null;
      this.hkC.mContext = null;
      AppMethodBeat.o(19670);
      return null;
    }
    paramContext = this.hkD.iterator();
    u localu;
    while (paramContext.hasNext())
    {
      localu = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).iJ(paramString);
      if (localu != null)
      {
        Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localu.type) });
        this.mContext = null;
        this.hkC.mContext = null;
        AppMethodBeat.o(19670);
        return localu;
      }
    }
    paramContext = this.hkE.iterator();
    while (paramContext.hasNext())
    {
      localu = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).iJ(paramString);
      if (localu != null)
      {
        Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localu.type) });
        this.mContext = null;
        this.hkC.mContext = null;
        AppMethodBeat.o(19670);
        return localu;
      }
    }
    paramContext = this.hkF.iterator();
    while (paramContext.hasNext())
    {
      localu = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).iJ(paramString);
      if (localu != null)
      {
        Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localu.type) });
        this.mContext = null;
        this.hkC.mContext = null;
        AppMethodBeat.o(19670);
        return localu;
      }
    }
    this.mContext = null;
    this.hkC.mContext = null;
    Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, nothing match");
    AppMethodBeat.o(19670);
    return null;
  }
  
  public final boolean a(Context paramContext, final View paramView, final u paramu, final m paramm)
  {
    AppMethodBeat.i(239364);
    if (paramu == null)
    {
      Log.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo is null");
      AppMethodBeat.o(239364);
      return false;
    }
    int i = paramu.type;
    if (paramm == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo.getType:%d, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size:%d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(this.hkD.size()), Integer.valueOf(this.hkE.size()), Integer.valueOf(this.hkF.size()) });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.URISpanHandler", "handleSpanClick, context is null!");
      this.hkC.mContext = null;
      AppMethodBeat.o(239364);
      return false;
    }
    this.mContext = paramContext;
    this.hkC.mContext = this.mContext;
    paramContext = this.hkD.iterator();
    while (paramContext.hasNext())
    {
      localObject = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((contains(((URISpanHandlerSet.BaseUriSpanHandler)localObject).aDQ(), paramu.type)) && (((URISpanHandlerSet.BaseUriSpanHandler)localObject).a(paramView, paramu, paramm)))
      {
        Log.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localObject.getClass().getName() });
        this.mContext = null;
        this.hkC.mContext = null;
        AppMethodBeat.o(239364);
        return true;
      }
    }
    Object localObject = this.hkE.iterator();
    while (((Iterator)localObject).hasNext())
    {
      final URISpanHandlerSet.BaseUriSpanHandler localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)((Iterator)localObject).next();
      if (((localBaseUriSpanHandler instanceof URISpanHandlerSet.TopicSpanHandler)) && (contains(localBaseUriSpanHandler.aDQ(), paramu.type)))
      {
        paramContext = null;
        if ((this.hkA.get(paramu.url) instanceof ewg)) {
          paramContext = (ewg)this.hkA.get(paramu.url);
        }
        i = paramu.fromScene;
        if ((i == 1) || (i == 4) || (i == 6)) {
          i = 73;
        }
        for (;;)
        {
          Log.i("MicroMsg.URISpanHandler", "scene1 = ".concat(String.valueOf(i)));
          if (paramContext != null) {
            break label615;
          }
          if (this.hkB != null) {
            break label593;
          }
          this.hkB = new a(this.mContext, i, paramu.url, new a.a()
          {
            public final void a(Context paramAnonymousContext, ewg paramAnonymousewg)
            {
              AppMethodBeat.i(239401);
              Log.i("MicroMsg.URISpanHandler", "finishCheckTag");
              if (paramAnonymousewg == null)
              {
                Log.i("MicroMsg.URISpanHandler", "handleSpanClick, response is null");
                AppMethodBeat.o(239401);
                return;
              }
              f.a(f.this, paramAnonymousContext);
              f.a(f.this).mContext = paramAnonymousContext;
              f.b(f.this).put(paramu.url, paramAnonymousewg);
              f.a(f.this, paramAnonymousewg, (URISpanHandlerSet.TopicSpanHandler)localBaseUriSpanHandler, paramView, paramu, paramm);
              f.c(f.this);
              AppMethodBeat.o(239401);
            }
          });
          this.hkB.hks = true;
          paramContext = this.hkB;
          if (paramContext.hks)
          {
            paramContext.hku = new a.2(paramContext);
            MMHandlerThread.postToMainThreadDelayed(paramContext.hku, 1000L);
          }
          paramContext.hkt = new a.1(paramContext);
          MMHandlerThread.postToMainThreadDelayed(paramContext.hkt, 10000L);
          h.baD().mCm.a(4790, paramContext);
          paramContext = new com.tencent.mm.app.plugin.a.a(paramContext.mContext, paramContext.brD, paramContext.mScene);
          h.baD().mCm.a(paramContext, 0);
          break;
          if (i == 2)
          {
            i = 79;
          }
          else if (i == 5)
          {
            i = 80;
          }
          else
          {
            Log.e("MicroMsg.URISpanHandler", "error scene fromScene = ".concat(String.valueOf(i)));
            i = 73;
          }
        }
        label593:
        Log.i("MicroMsg.URISpanHandler", "checkMPURL:%s.", new Object[] { this.hkB });
        continue;
        label615:
        Log.i("MicroMsg.URISpanHandler", "checkMPURL has cache.");
        a(paramContext, (URISpanHandlerSet.TopicSpanHandler)localBaseUriSpanHandler, paramView, paramu, paramm);
      }
      else if ((contains(localBaseUriSpanHandler.aDQ(), paramu.type)) && (localBaseUriSpanHandler.a(paramView, paramu, paramm)))
      {
        Log.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.hkC.mContext = null;
        AppMethodBeat.o(239364);
        return true;
      }
    }
    paramContext = this.hkF.iterator();
    while (paramContext.hasNext())
    {
      localObject = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((contains(((URISpanHandlerSet.BaseUriSpanHandler)localObject).aDQ(), paramu.type)) && (((URISpanHandlerSet.BaseUriSpanHandler)localObject).a(paramView, paramu, paramm)))
      {
        Log.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localObject.getClass().getName() });
        this.mContext = null;
        this.hkC.mContext = null;
        AppMethodBeat.o(239364);
        return true;
      }
    }
    this.mContext = null;
    this.hkC.mContext = null;
    Log.d("MicroMsg.URISpanHandler", "handleSpanClick, nothing handle");
    AppMethodBeat.o(239364);
    return false;
  }
  
  public final boolean b(Context paramContext, String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(19672);
    if (paramv == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.URISpanHandler", "handleUriJump, url:%s, isAllowScanQrCode:%b, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size: %d, mLowPriorityHandlerList.size: %d", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(this.hkD.size()), Integer.valueOf(this.hkE.size()), Integer.valueOf(this.hkF.size()) });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.URISpanHandler", "handleUriJump, context is null!");
      this.hkC.mContext = null;
      AppMethodBeat.o(19672);
      return false;
    }
    this.mContext = paramContext;
    this.hkC.mContext = this.mContext;
    if (Util.isNullOrNil(paramString))
    {
      Log.d("MicroMsg.URISpanHandler", "handleUriJump, url is null");
      this.mContext = null;
      this.hkC.mContext = null;
      AppMethodBeat.o(19672);
      return false;
    }
    paramContext = this.hkD.iterator();
    URISpanHandlerSet.BaseUriSpanHandler localBaseUriSpanHandler;
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramv, paramBundle))
      {
        Log.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.hkC.mContext = null;
        AppMethodBeat.o(19672);
        return true;
      }
    }
    paramContext = this.hkE.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramv, paramBundle))
      {
        Log.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.hkC.mContext = null;
        AppMethodBeat.o(19672);
        return true;
      }
    }
    paramContext = this.hkF.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramv, paramBundle))
      {
        Log.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.hkC.mContext = null;
        AppMethodBeat.o(19672);
        return true;
      }
    }
    this.mContext = null;
    this.hkC.mContext = null;
    Log.d("MicroMsg.URISpanHandler", "handleUriJump, nothing handle");
    AppMethodBeat.o(19672);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.app.plugin.f
 * JD-Core Version:    0.7.0.1
 */