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
import com.tencent.mm.plugin.appbrand.jsapi.e.q;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.StopBackgroundMusicTask;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.a;
import com.tencent.mm.plugin.appbrand.s.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

abstract class f
  extends g
{
  private final AppBrandRuntime iGV;
  int iRC = 0;
  private final AppBrandMusicClientService.a iRD = new AppBrandMusicClientService.a()
  {
    public final void aQU()
    {
      AppMethodBeat.i(134742);
      f.this.qH(1);
      AppMethodBeat.o(134742);
    }
    
    public final void onStop()
    {
      AppMethodBeat.i(134743);
      f.this.qH(1);
      AppMethodBeat.o(134743);
    }
  };
  
  f(h paramh, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramh);
    this.iGV = paramAppBrandRuntime;
  }
  
  private int aQT()
  {
    this.iRC = 0;
    Object localObject1 = this.iGV.mAppId;
    Object localObject2 = (a)this.iGV.ar(a.class);
    int i;
    AppBrandMusicClientService.a locala;
    if ((localObject2 != null) && (((a)localObject2).iQI))
    {
      i = 1;
      if (i == 0) {
        break label406;
      }
      if (AppBrandMusicClientService.KF((String)localObject1))
      {
        dM(1);
        localObject2 = AppBrandMusicClientService.kQj;
        locala = this.iRD;
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (locala != null)) {
          break label354;
        }
      }
      label81:
      boolean bool = ((a)this.iGV.ar(a.class)).iQJ;
      ad.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, canKeepAliveLocation:%s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        localObject2 = (q)this.iGV.as(q.class);
        if (localObject2 != null)
        {
          if ((!((q)localObject2).jSy) || (!((q)localObject2).iXN)) {
            break label463;
          }
          i = 1;
          label156:
          ad.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, isBackgroundMode:%s, isListening:%s", new Object[] { Boolean.valueOf(((q)localObject2).jSy), Boolean.valueOf(((q)localObject2).iXN) });
          if (i != 0) {
            dM(32);
          }
        }
      }
      localObject2 = (k)this.iGV.as(k.class);
      if (localObject2 != null)
      {
        bool = ((k)localObject2).aSL();
        ad.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandLiveVOIPIfNeed, isVOIPing:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          dM(64);
        }
      }
      localObject2 = (j)this.iGV.as(j.class);
      if (localObject2 != null)
      {
        bool = ((j)localObject2).aSK();
        ad.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandAudioBackgroundPlayIfNeed, isNeedKeepAlive:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          dM(128);
        }
      }
      localObject1 = com.tencent.mm.plugin.appbrand.g.Dd((String)localObject1);
      switch (2.iRF[localObject1.ordinal()])
      {
      }
    }
    for (;;)
    {
      return this.iRC;
      i = 0;
      break;
      label354:
      if (!((AppBrandMusicClientService)localObject2).kQi.containsKey(localObject1))
      {
        ((AppBrandMusicClientService)localObject2).kQi.put(localObject1, locala);
        break label81;
      }
      ((AppBrandMusicClientService)localObject2).kQi.remove(localObject1);
      ((AppBrandMusicClientService)localObject2).kQi.put(localObject1, locala);
      break label81;
      label406:
      localObject2 = AppBrandMusicClientService.kQj;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label81;
      }
      if (!((String)localObject1).equalsIgnoreCase(((AppBrandMusicClientService)localObject2).kQk))
      {
        ad.e("MicroMsg.AppBrandMusicClientService", "appId is diff, can't stop music");
        break label81;
      }
      localObject2 = new AppBrandMusicClientService.StopBackgroundMusicTask();
      ((AppBrandMusicClientService.StopBackgroundMusicTask)localObject2).appId = ((String)localObject1);
      AppBrandMainProcessService.a((MainProcessTask)localObject2);
      break label81;
      label463:
      i = 0;
      break label156;
      dM(16);
      continue;
      dM(4);
      continue;
      try
      {
        if ((this.iGV.iDt != null) && ((!this.iGV.iDt.getWindowAndroid().aMC()) || (this.iGV.aLJ() != null))) {
          dM(8);
        }
      }
      catch (IllegalAccessError localIllegalAccessError) {}
    }
  }
  
  private void dM(int paramInt)
  {
    this.iRC |= paramInt;
  }
  
  abstract void aQQ();
  
  public void enter()
  {
    this.iRC = aQT();
    super.enter();
    qH(0);
  }
  
  public void exit()
  {
    super.exit();
    this.iRC = 0;
    AppBrandMusicClientService localAppBrandMusicClientService = AppBrandMusicClientService.kQj;
    String str = this.iGV.mAppId;
    if ((!TextUtils.isEmpty(str)) && (localAppBrandMusicClientService.kQi.containsKey(str))) {
      localAppBrandMusicClientService.kQi.remove(str);
    }
  }
  
  public boolean k(Message paramMessage)
  {
    if (d.a.qG(paramMessage.what) == d.a.iRr)
    {
      ad.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LOCATION_LISTENING");
      qH(32);
      return true;
    }
    if (d.a.qG(paramMessage.what) == d.a.iRs)
    {
      ad.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LIVE_VOIP");
      qH(64);
      return true;
    }
    if (d.a.qG(paramMessage.what) == d.a.iRt)
    {
      ad.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_AUDIO_BACKGROUND_PLAY");
      qH(128);
      return true;
    }
    return super.k(paramMessage);
  }
  
  final void qH(int paramInt)
  {
    this.iRC &= (paramInt ^ 0xFFFFFFFF);
    if (this.iRC == 0) {
      aQQ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.f
 * JD-Core Version:    0.7.0.1
 */