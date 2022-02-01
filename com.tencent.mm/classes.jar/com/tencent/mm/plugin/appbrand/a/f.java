package com.tencent.mm.plugin.appbrand.a;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.backgroundrunning.i;
import com.tencent.mm.plugin.appbrand.backgroundrunning.j;
import com.tencent.mm.plugin.appbrand.jsapi.j.t;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.StopBackgroundMusicTask;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.a;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

abstract class f
  extends g
{
  int nLJ = 0;
  private final AppBrandMusicClientService.a nLK = new AppBrandMusicClientService.a()
  {
    public final void bIo()
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
  private final AppBrandRuntime nxs;
  
  f(h paramh, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramh);
    this.nxs = paramAppBrandRuntime;
  }
  
  private int bIm()
  {
    this.nLJ = 0;
    Object localObject1 = this.nxs.mAppId;
    Object localObject2 = (a)this.nxs.au(a.class);
    int i;
    AppBrandMusicClientService.a locala;
    if ((localObject2 != null) && (((a)localObject2).nKN))
    {
      i = 1;
      if (i == 0) {
        break label462;
      }
      if (AppBrandMusicClientService.akw((String)localObject1))
      {
        dY(1);
        localObject2 = AppBrandMusicClientService.qdk;
        locala = this.nLK;
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (locala != null)) {
          break label410;
        }
      }
      label81:
      boolean bool = ((a)this.nxs.au(a.class)).nKO;
      Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, canKeepAliveLocation:%s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        localObject2 = (t)this.nxs.av(t.class);
        if (localObject2 != null)
        {
          if ((!((t)localObject2).oVh) || (!((t)localObject2).nSz)) {
            break label519;
          }
          i = 1;
          label156:
          Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, isBackgroundMode:%s, isListening:%s", new Object[] { Boolean.valueOf(((t)localObject2).oVh), Boolean.valueOf(((t)localObject2).nSz) });
          if (i != 0) {
            dY(32);
          }
        }
      }
      localObject2 = (j)this.nxs.av(j.class);
      if (localObject2 != null)
      {
        bool = ((j)localObject2).bKs();
        Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandLiveVOIPIfNeed, isVOIPing:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          dY(64);
        }
      }
      localObject2 = (i)this.nxs.av(i.class);
      if (localObject2 != null)
      {
        bool = ((i)localObject2).bKr();
        Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandAudioBackgroundPlayIfNeed, isNeedKeepAlive:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          dY(128);
        }
      }
      localObject2 = (j)this.nxs.av(j.class);
      if (localObject2 != null)
      {
        bool = ((j)localObject2).bKs();
        Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandLiveVOIPIfNeed, isVOIPing:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          dY(256);
        }
      }
      localObject1 = k.abM((String)localObject1);
      switch (2.nLM[localObject1.ordinal()])
      {
      }
    }
    for (;;)
    {
      return this.nLJ;
      i = 0;
      break;
      label410:
      if (!((AppBrandMusicClientService)localObject2).qdj.containsKey(localObject1))
      {
        ((AppBrandMusicClientService)localObject2).qdj.put(localObject1, locala);
        break label81;
      }
      ((AppBrandMusicClientService)localObject2).qdj.remove(localObject1);
      ((AppBrandMusicClientService)localObject2).qdj.put(localObject1, locala);
      break label81;
      label462:
      localObject2 = AppBrandMusicClientService.qdk;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label81;
      }
      if (!((String)localObject1).equalsIgnoreCase(((AppBrandMusicClientService)localObject2).qdl))
      {
        Log.e("MicroMsg.AppBrandMusicClientService", "appId is diff, can't stop music");
        break label81;
      }
      localObject2 = new AppBrandMusicClientService.StopBackgroundMusicTask();
      ((AppBrandMusicClientService.StopBackgroundMusicTask)localObject2).appId = ((String)localObject1);
      ((AppBrandMusicClientService.StopBackgroundMusicTask)localObject2).bsM();
      break label81;
      label519:
      i = 0;
      break label156;
      dY(16);
      continue;
      dY(4);
      continue;
      try
      {
        if ((this.nxs.ntu != null) && ((!this.nxs.ntu.getWindowAndroid().bCS()) || (this.nxs.bBW() != null))) {
          dY(8);
        }
      }
      catch (IllegalAccessError localIllegalAccessError) {}
    }
  }
  
  private void dY(int paramInt)
  {
    this.nLJ |= paramInt;
  }
  
  private void ze(int paramInt)
  {
    this.nLJ &= (paramInt ^ 0xFFFFFFFF);
    if (this.nLJ == 0)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "onKeepFlagsCleared, appId:%s", new Object[] { this.nxs.mAppId });
      bIj();
    }
  }
  
  abstract void bIj();
  
  final void bIn()
  {
    ze(16);
  }
  
  public void enter()
  {
    this.nLJ = bIm();
    super.enter();
    ze(0);
  }
  
  public void exit()
  {
    super.exit();
    this.nLJ = 0;
    AppBrandMusicClientService localAppBrandMusicClientService = AppBrandMusicClientService.qdk;
    String str = this.nxs.mAppId;
    if ((!TextUtils.isEmpty(str)) && (localAppBrandMusicClientService.qdj.containsKey(str))) {
      localAppBrandMusicClientService.qdj.remove(str);
    }
  }
  
  public boolean processMessage(Message paramMessage)
  {
    if (d.a.zd(paramMessage.what) == d.a.nLw)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LOCATION_LISTENING");
      ze(32);
      return true;
    }
    if (d.a.zd(paramMessage.what) == d.a.nLx)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LIVE_VOIP");
      ze(64);
      return true;
    }
    if (d.a.zd(paramMessage.what) == d.a.nLy)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_AUDIO_BACKGROUND_PLAY");
      ze(128);
      return true;
    }
    if (d.a.zd(paramMessage.what) == d.a.nLz)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LIVE_VOIP");
      ze(256);
      return true;
    }
    if (d.a.zd(paramMessage.what) == d.a.nLA)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_CONTAINER_FORCED_MOVE_TO_BACK, appId:%s", new Object[] { this.nxs.mAppId });
      ze(4);
      return true;
    }
    return super.processMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.f
 * JD-Core Version:    0.7.0.1
 */