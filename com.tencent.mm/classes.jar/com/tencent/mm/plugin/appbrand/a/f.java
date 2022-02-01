package com.tencent.mm.plugin.appbrand.a;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ai;
import com.tencent.mm.plugin.appbrand.backgroundrunning.i;
import com.tencent.mm.plugin.appbrand.backgroundrunning.j;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.g.r;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.StopBackgroundMusicTask;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.a;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;

abstract class f
  extends g
{
  private final AppBrandRuntime jDb;
  int jOT = 0;
  private final AppBrandMusicClientService.a jOU = new AppBrandMusicClientService.a()
  {
    public final void bbP()
    {
      AppMethodBeat.i(134742);
      f.this.rX(1);
      AppMethodBeat.o(134742);
    }
    
    public final void onStop()
    {
      AppMethodBeat.i(134743);
      f.this.rX(1);
      AppMethodBeat.o(134743);
    }
  };
  
  f(h paramh, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramh);
    this.jDb = paramAppBrandRuntime;
  }
  
  private int bbO()
  {
    this.jOT = 0;
    Object localObject1 = this.jDb.mAppId;
    Object localObject2 = (a)this.jDb.ar(a.class);
    int i;
    AppBrandMusicClientService.a locala;
    if ((localObject2 != null) && (((a)localObject2).jNY))
    {
      i = 1;
      if (i == 0) {
        break label462;
      }
      if (AppBrandMusicClientService.SY((String)localObject1))
      {
        dP(1);
        localObject2 = AppBrandMusicClientService.lVt;
        locala = this.jOU;
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (locala != null)) {
          break label410;
        }
      }
      label81:
      boolean bool = ((a)this.jDb.ar(a.class)).jNZ;
      ae.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, canKeepAliveLocation:%s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        localObject2 = (r)this.jDb.as(r.class);
        if (localObject2 != null)
        {
          if ((!((r)localObject2).kSo) || (!((r)localObject2).jVr)) {
            break label519;
          }
          i = 1;
          label156:
          ae.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, isBackgroundMode:%s, isListening:%s", new Object[] { Boolean.valueOf(((r)localObject2).kSo), Boolean.valueOf(((r)localObject2).jVr) });
          if (i != 0) {
            dP(32);
          }
        }
      }
      localObject2 = (j)this.jDb.as(j.class);
      if (localObject2 != null)
      {
        bool = ((j)localObject2).bdM();
        ae.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandLiveVOIPIfNeed, isVOIPing:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          dP(64);
        }
      }
      localObject2 = (i)this.jDb.as(i.class);
      if (localObject2 != null)
      {
        bool = ((i)localObject2).bdL();
        ae.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandAudioBackgroundPlayIfNeed, isNeedKeepAlive:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          dP(128);
        }
      }
      localObject2 = (j)this.jDb.as(j.class);
      if (localObject2 != null)
      {
        bool = ((j)localObject2).bdM();
        ae.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandLiveVOIPIfNeed, isVOIPing:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          dP(256);
        }
      }
      localObject1 = com.tencent.mm.plugin.appbrand.h.KU((String)localObject1);
      switch (2.jOW[localObject1.ordinal()])
      {
      }
    }
    for (;;)
    {
      return this.jOT;
      i = 0;
      break;
      label410:
      if (!((AppBrandMusicClientService)localObject2).lVs.containsKey(localObject1))
      {
        ((AppBrandMusicClientService)localObject2).lVs.put(localObject1, locala);
        break label81;
      }
      ((AppBrandMusicClientService)localObject2).lVs.remove(localObject1);
      ((AppBrandMusicClientService)localObject2).lVs.put(localObject1, locala);
      break label81;
      label462:
      localObject2 = AppBrandMusicClientService.lVt;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label81;
      }
      if (!((String)localObject1).equalsIgnoreCase(((AppBrandMusicClientService)localObject2).lVu))
      {
        ae.e("MicroMsg.AppBrandMusicClientService", "appId is diff, can't stop music");
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
        if ((this.jDb.jzy != null) && ((!this.jDb.jzy.getWindowAndroid().aXc()) || (this.jDb.aWl() != null))) {
          dP(8);
        }
      }
      catch (IllegalAccessError localIllegalAccessError) {}
    }
  }
  
  private void dP(int paramInt)
  {
    this.jOT |= paramInt;
  }
  
  abstract void bbL();
  
  public void enter()
  {
    this.jOT = bbO();
    super.enter();
    rX(0);
  }
  
  public void exit()
  {
    super.exit();
    this.jOT = 0;
    AppBrandMusicClientService localAppBrandMusicClientService = AppBrandMusicClientService.lVt;
    String str = this.jDb.mAppId;
    if ((!TextUtils.isEmpty(str)) && (localAppBrandMusicClientService.lVs.containsKey(str))) {
      localAppBrandMusicClientService.lVs.remove(str);
    }
  }
  
  public boolean k(Message paramMessage)
  {
    if (d.a.rW(paramMessage.what) == d.a.jOH)
    {
      ae.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LOCATION_LISTENING");
      rX(32);
      return true;
    }
    if (d.a.rW(paramMessage.what) == d.a.jOI)
    {
      ae.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LIVE_VOIP");
      rX(64);
      return true;
    }
    if (d.a.rW(paramMessage.what) == d.a.jOJ)
    {
      ae.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_AUDIO_BACKGROUND_PLAY");
      rX(128);
      return true;
    }
    if (d.a.rW(paramMessage.what) == d.a.jOK)
    {
      ae.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LIVE_VOIP");
      rX(256);
      return true;
    }
    return super.k(paramMessage);
  }
  
  final void rX(int paramInt)
  {
    this.jOT &= (paramInt ^ 0xFFFFFFFF);
    if (this.jOT == 0) {
      bbL();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.f
 * JD-Core Version:    0.7.0.1
 */