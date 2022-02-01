package com.tencent.mm.plugin.appbrand.b;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ai;
import com.tencent.mm.plugin.appbrand.backgroundrunning.j;
import com.tencent.mm.plugin.appbrand.backgroundrunning.k;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d.q;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.StopBackgroundMusicTask;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.a;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;

abstract class f
  extends g
{
  private final AppBrandRuntime jgY;
  int jrN = 0;
  private final AppBrandMusicClientService.a jrO = new AppBrandMusicClientService.a()
  {
    public final void aXP()
    {
      AppMethodBeat.i(134742);
      f.this.ru(1);
      AppMethodBeat.o(134742);
    }
    
    public final void onStop()
    {
      AppMethodBeat.i(134743);
      f.this.ru(1);
      AppMethodBeat.o(134743);
    }
  };
  
  f(h paramh, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramh);
    this.jgY = paramAppBrandRuntime;
  }
  
  private int aXO()
  {
    this.jrN = 0;
    Object localObject1 = this.jgY.mAppId;
    Object localObject2 = (a)this.jgY.ar(a.class);
    int i;
    AppBrandMusicClientService.a locala;
    if ((localObject2 != null) && (((a)localObject2).jqS))
    {
      i = 1;
      if (i == 0) {
        break label462;
      }
      if (AppBrandMusicClientService.OM((String)localObject1))
      {
        dL(1);
        localObject2 = AppBrandMusicClientService.lrI;
        locala = this.jrO;
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (locala != null)) {
          break label410;
        }
      }
      label81:
      boolean bool = ((a)this.jgY.ar(a.class)).jqT;
      ac.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, canKeepAliveLocation:%s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        localObject2 = (q)this.jgY.as(q.class);
        if (localObject2 != null)
        {
          if ((!((q)localObject2).ktk) || (!((q)localObject2).jyd)) {
            break label519;
          }
          i = 1;
          label156:
          ac.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, isBackgroundMode:%s, isListening:%s", new Object[] { Boolean.valueOf(((q)localObject2).ktk), Boolean.valueOf(((q)localObject2).jyd) });
          if (i != 0) {
            dL(32);
          }
        }
      }
      localObject2 = (k)this.jgY.as(k.class);
      if (localObject2 != null)
      {
        bool = ((k)localObject2).aZI();
        ac.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandLiveVOIPIfNeed, isVOIPing:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          dL(64);
        }
      }
      localObject2 = (j)this.jgY.as(j.class);
      if (localObject2 != null)
      {
        bool = ((j)localObject2).aZH();
        ac.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandAudioBackgroundPlayIfNeed, isNeedKeepAlive:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          dL(128);
        }
      }
      localObject2 = (k)this.jgY.as(k.class);
      if (localObject2 != null)
      {
        bool = ((k)localObject2).aZI();
        ac.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandLiveVOIPIfNeed, isVOIPing:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          dL(256);
        }
      }
      localObject1 = com.tencent.mm.plugin.appbrand.g.Hg((String)localObject1);
      switch (2.jrQ[localObject1.ordinal()])
      {
      }
    }
    for (;;)
    {
      return this.jrN;
      i = 0;
      break;
      label410:
      if (!((AppBrandMusicClientService)localObject2).lrH.containsKey(localObject1))
      {
        ((AppBrandMusicClientService)localObject2).lrH.put(localObject1, locala);
        break label81;
      }
      ((AppBrandMusicClientService)localObject2).lrH.remove(localObject1);
      ((AppBrandMusicClientService)localObject2).lrH.put(localObject1, locala);
      break label81;
      label462:
      localObject2 = AppBrandMusicClientService.lrI;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label81;
      }
      if (!((String)localObject1).equalsIgnoreCase(((AppBrandMusicClientService)localObject2).lrJ))
      {
        ac.e("MicroMsg.AppBrandMusicClientService", "appId is diff, can't stop music");
        break label81;
      }
      localObject2 = new AppBrandMusicClientService.StopBackgroundMusicTask();
      ((AppBrandMusicClientService.StopBackgroundMusicTask)localObject2).appId = ((String)localObject1);
      AppBrandMainProcessService.a((MainProcessTask)localObject2);
      break label81;
      label519:
      i = 0;
      break label156;
      dL(16);
      continue;
      dL(4);
      continue;
      try
      {
        if ((this.jgY.jdt != null) && ((!this.jgY.jdt.getWindowAndroid().aTs()) || (this.jgY.aSz() != null))) {
          dL(8);
        }
      }
      catch (IllegalAccessError localIllegalAccessError) {}
    }
  }
  
  private void dL(int paramInt)
  {
    this.jrN |= paramInt;
  }
  
  abstract void aXL();
  
  public void enter()
  {
    this.jrN = aXO();
    super.enter();
    ru(0);
  }
  
  public void exit()
  {
    super.exit();
    this.jrN = 0;
    AppBrandMusicClientService localAppBrandMusicClientService = AppBrandMusicClientService.lrI;
    String str = this.jgY.mAppId;
    if ((!TextUtils.isEmpty(str)) && (localAppBrandMusicClientService.lrH.containsKey(str))) {
      localAppBrandMusicClientService.lrH.remove(str);
    }
  }
  
  public boolean k(Message paramMessage)
  {
    if (d.a.rt(paramMessage.what) == d.a.jrB)
    {
      ac.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LOCATION_LISTENING");
      ru(32);
      return true;
    }
    if (d.a.rt(paramMessage.what) == d.a.jrC)
    {
      ac.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LIVE_VOIP");
      ru(64);
      return true;
    }
    if (d.a.rt(paramMessage.what) == d.a.jrD)
    {
      ac.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_AUDIO_BACKGROUND_PLAY");
      ru(128);
      return true;
    }
    if (d.a.rt(paramMessage.what) == d.a.jrE)
    {
      ac.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LIVE_VOIP");
      ru(256);
      return true;
    }
    return super.k(paramMessage);
  }
  
  final void ru(int paramInt)
  {
    this.jrN &= (paramInt ^ 0xFFFFFFFF);
    if (this.jrN == 0) {
      aXL();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.f
 * JD-Core Version:    0.7.0.1
 */