package com.tencent.mm.plugin.appbrand.a;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ai;
import com.tencent.mm.plugin.appbrand.backgroundrunning.j;
import com.tencent.mm.plugin.appbrand.backgroundrunning.k;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.g.q;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.StopBackgroundMusicTask;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.a;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

abstract class f
  extends g
{
  int jLH = 0;
  private final AppBrandMusicClientService.a jLI = new AppBrandMusicClientService.a()
  {
    public final void bbn()
    {
      AppMethodBeat.i(134742);
      f.this.rU(1);
      AppMethodBeat.o(134742);
    }
    
    public final void onStop()
    {
      AppMethodBeat.i(134743);
      f.this.rU(1);
      AppMethodBeat.o(134743);
    }
  };
  private final AppBrandRuntime jzY;
  
  f(h paramh, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramh);
    this.jzY = paramAppBrandRuntime;
  }
  
  private int bbm()
  {
    this.jLH = 0;
    Object localObject1 = this.jzY.mAppId;
    Object localObject2 = (a)this.jzY.ar(a.class);
    int i;
    AppBrandMusicClientService.a locala;
    if ((localObject2 != null) && (((a)localObject2).jKM))
    {
      i = 1;
      if (i == 0) {
        break label462;
      }
      if (AppBrandMusicClientService.Sp((String)localObject1))
      {
        dP(1);
        localObject2 = AppBrandMusicClientService.lQS;
        locala = this.jLI;
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (locala != null)) {
          break label410;
        }
      }
      label81:
      boolean bool = ((a)this.jzY.ar(a.class)).jKN;
      ad.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, canKeepAliveLocation:%s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        localObject2 = (q)this.jzY.as(q.class);
        if (localObject2 != null)
        {
          if ((!((q)localObject2).kOG) || (!((q)localObject2).jSa)) {
            break label519;
          }
          i = 1;
          label156:
          ad.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, isBackgroundMode:%s, isListening:%s", new Object[] { Boolean.valueOf(((q)localObject2).kOG), Boolean.valueOf(((q)localObject2).jSa) });
          if (i != 0) {
            dP(32);
          }
        }
      }
      localObject2 = (k)this.jzY.as(k.class);
      if (localObject2 != null)
      {
        bool = ((k)localObject2).bdh();
        ad.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandLiveVOIPIfNeed, isVOIPing:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          dP(64);
        }
      }
      localObject2 = (j)this.jzY.as(j.class);
      if (localObject2 != null)
      {
        bool = ((j)localObject2).bdg();
        ad.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandAudioBackgroundPlayIfNeed, isNeedKeepAlive:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          dP(128);
        }
      }
      localObject2 = (k)this.jzY.as(k.class);
      if (localObject2 != null)
      {
        bool = ((k)localObject2).bdh();
        ad.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandLiveVOIPIfNeed, isVOIPing:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          dP(256);
        }
      }
      localObject1 = com.tencent.mm.plugin.appbrand.g.Kv((String)localObject1);
      switch (2.jLK[localObject1.ordinal()])
      {
      }
    }
    for (;;)
    {
      return this.jLH;
      i = 0;
      break;
      label410:
      if (!((AppBrandMusicClientService)localObject2).lQR.containsKey(localObject1))
      {
        ((AppBrandMusicClientService)localObject2).lQR.put(localObject1, locala);
        break label81;
      }
      ((AppBrandMusicClientService)localObject2).lQR.remove(localObject1);
      ((AppBrandMusicClientService)localObject2).lQR.put(localObject1, locala);
      break label81;
      label462:
      localObject2 = AppBrandMusicClientService.lQS;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label81;
      }
      if (!((String)localObject1).equalsIgnoreCase(((AppBrandMusicClientService)localObject2).lQT))
      {
        ad.e("MicroMsg.AppBrandMusicClientService", "appId is diff, can't stop music");
        break label81;
      }
      localObject2 = new AppBrandMusicClientService.StopBackgroundMusicTask();
      ((AppBrandMusicClientService.StopBackgroundMusicTask)localObject2).appId = ((String)localObject1);
      AppBrandMainProcessService.a((MainProcessTask)localObject2);
      break label81;
      label519:
      i = 0;
      break label156;
      dP(16);
      continue;
      dP(4);
      continue;
      try
      {
        if ((this.jzY.jwC != null) && ((!this.jzY.jwC.getWindowAndroid().aWA()) || (this.jzY.aVM() != null))) {
          dP(8);
        }
      }
      catch (IllegalAccessError localIllegalAccessError) {}
    }
  }
  
  private void dP(int paramInt)
  {
    this.jLH |= paramInt;
  }
  
  abstract void bbj();
  
  public void enter()
  {
    this.jLH = bbm();
    super.enter();
    rU(0);
  }
  
  public void exit()
  {
    super.exit();
    this.jLH = 0;
    AppBrandMusicClientService localAppBrandMusicClientService = AppBrandMusicClientService.lQS;
    String str = this.jzY.mAppId;
    if ((!TextUtils.isEmpty(str)) && (localAppBrandMusicClientService.lQR.containsKey(str))) {
      localAppBrandMusicClientService.lQR.remove(str);
    }
  }
  
  public boolean k(Message paramMessage)
  {
    if (d.a.rT(paramMessage.what) == d.a.jLv)
    {
      ad.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LOCATION_LISTENING");
      rU(32);
      return true;
    }
    if (d.a.rT(paramMessage.what) == d.a.jLw)
    {
      ad.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LIVE_VOIP");
      rU(64);
      return true;
    }
    if (d.a.rT(paramMessage.what) == d.a.jLx)
    {
      ad.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_AUDIO_BACKGROUND_PLAY");
      rU(128);
      return true;
    }
    if (d.a.rT(paramMessage.what) == d.a.jLy)
    {
      ad.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LIVE_VOIP");
      rU(256);
      return true;
    }
    return super.k(paramMessage);
  }
  
  final void rU(int paramInt)
  {
    this.jLH &= (paramInt ^ 0xFFFFFFFF);
    if (this.jLH == 0) {
      bbj();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.f
 * JD-Core Version:    0.7.0.1
 */