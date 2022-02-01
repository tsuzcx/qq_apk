package com.tencent.mm.plugin.appbrand.a;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.backgroundrunning.i;
import com.tencent.mm.plugin.appbrand.backgroundrunning.j;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.i.s;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.StopBackgroundMusicTask;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.a;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

abstract class f
  extends g
{
  private final AppBrandRuntime kEc;
  int kRB = 0;
  private final AppBrandMusicClientService.a kRC = new AppBrandMusicClientService.a()
  {
    public final void bxf()
    {
      AppMethodBeat.i(134742);
      f.a(f.this);
      AppMethodBeat.o(134742);
    }
    
    public final void onStop()
    {
      AppMethodBeat.i(134743);
      f.a(f.this);
      AppMethodBeat.o(134743);
    }
  };
  
  f(h paramh, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramh);
    this.kEc = paramAppBrandRuntime;
  }
  
  private int bxe()
  {
    this.kRB = 0;
    Object localObject1 = this.kEc.mAppId;
    Object localObject2 = (a)this.kEc.av(a.class);
    int i;
    AppBrandMusicClientService.a locala;
    if ((localObject2 != null) && (((a)localObject2).kQF))
    {
      i = 1;
      if (i == 0) {
        break label462;
      }
      if (AppBrandMusicClientService.acC((String)localObject1))
      {
        dK(1);
        localObject2 = AppBrandMusicClientService.ncV;
        locala = this.kRC;
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (locala != null)) {
          break label410;
        }
      }
      label81:
      boolean bool = ((a)this.kEc.av(a.class)).kQG;
      Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, canKeepAliveLocation:%s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        localObject2 = (s)this.kEc.aw(s.class);
        if (localObject2 != null)
        {
          if ((!((s)localObject2).lXu) || (!((s)localObject2).kYn)) {
            break label519;
          }
          i = 1;
          label156:
          Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, isBackgroundMode:%s, isListening:%s", new Object[] { Boolean.valueOf(((s)localObject2).lXu), Boolean.valueOf(((s)localObject2).kYn) });
          if (i != 0) {
            dK(32);
          }
        }
      }
      localObject2 = (j)this.kEc.aw(j.class);
      if (localObject2 != null)
      {
        bool = ((j)localObject2).bzd();
        Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandLiveVOIPIfNeed, isVOIPing:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          dK(64);
        }
      }
      localObject2 = (i)this.kEc.aw(i.class);
      if (localObject2 != null)
      {
        bool = ((i)localObject2).bzc();
        Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandAudioBackgroundPlayIfNeed, isNeedKeepAlive:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          dK(128);
        }
      }
      localObject2 = (j)this.kEc.aw(j.class);
      if (localObject2 != null)
      {
        bool = ((j)localObject2).bzd();
        Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandLiveVOIPIfNeed, isVOIPing:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          dK(256);
        }
      }
      localObject1 = com.tencent.mm.plugin.appbrand.h.Uc((String)localObject1);
      switch (2.kRE[localObject1.ordinal()])
      {
      }
    }
    for (;;)
    {
      return this.kRB;
      i = 0;
      break;
      label410:
      if (!((AppBrandMusicClientService)localObject2).ncU.containsKey(localObject1))
      {
        ((AppBrandMusicClientService)localObject2).ncU.put(localObject1, locala);
        break label81;
      }
      ((AppBrandMusicClientService)localObject2).ncU.remove(localObject1);
      ((AppBrandMusicClientService)localObject2).ncU.put(localObject1, locala);
      break label81;
      label462:
      localObject2 = AppBrandMusicClientService.ncV;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label81;
      }
      if (!((String)localObject1).equalsIgnoreCase(((AppBrandMusicClientService)localObject2).ncW))
      {
        Log.e("MicroMsg.AppBrandMusicClientService", "appId is diff, can't stop music");
        break label81;
      }
      localObject2 = new AppBrandMusicClientService.StopBackgroundMusicTask();
      ((AppBrandMusicClientService.StopBackgroundMusicTask)localObject2).appId = ((String)localObject1);
      AppBrandMainProcessService.a((MainProcessTask)localObject2);
      break label81;
      label519:
      i = 0;
      break label156;
      dK(16);
      continue;
      dK(4);
      continue;
      try
      {
        if ((this.kEc.kAl != null) && ((!this.kEc.kAl.getWindowAndroid().bsc()) || (this.kEc.brg() != null))) {
          dK(8);
        }
      }
      catch (IllegalAccessError localIllegalAccessError) {}
    }
  }
  
  private void dK(int paramInt)
  {
    this.kRB |= paramInt;
  }
  
  abstract void bxb();
  
  public void enter()
  {
    this.kRB = bxe();
    super.enter();
    vT(0);
  }
  
  public void exit()
  {
    super.exit();
    this.kRB = 0;
    AppBrandMusicClientService localAppBrandMusicClientService = AppBrandMusicClientService.ncV;
    String str = this.kEc.mAppId;
    if ((!TextUtils.isEmpty(str)) && (localAppBrandMusicClientService.ncU.containsKey(str))) {
      localAppBrandMusicClientService.ncU.remove(str);
    }
  }
  
  public boolean processMessage(Message paramMessage)
  {
    if (d.a.vS(paramMessage.what) == d.a.kRo)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LOCATION_LISTENING");
      vT(32);
      return true;
    }
    if (d.a.vS(paramMessage.what) == d.a.kRp)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LIVE_VOIP");
      vT(64);
      return true;
    }
    if (d.a.vS(paramMessage.what) == d.a.kRq)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_AUDIO_BACKGROUND_PLAY");
      vT(128);
      return true;
    }
    if (d.a.vS(paramMessage.what) == d.a.kRr)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LIVE_VOIP");
      vT(256);
      return true;
    }
    if (d.a.vS(paramMessage.what) == d.a.kRs)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_CONTAINER_FORCED_MOVE_TO_BACK, appId:%s", new Object[] { this.kEc.mAppId });
      vT(4);
      return true;
    }
    return super.processMessage(paramMessage);
  }
  
  final void vT(int paramInt)
  {
    this.kRB &= (paramInt ^ 0xFFFFFFFF);
    if (this.kRB == 0)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "onKeepFlagsCleared, appId:%s", new Object[] { this.kEc.mAppId });
      bxb();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.f
 * JD-Core Version:    0.7.0.1
 */