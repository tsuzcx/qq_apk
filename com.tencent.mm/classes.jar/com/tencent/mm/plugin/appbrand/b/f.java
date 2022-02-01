package com.tencent.mm.plugin.appbrand.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.backgroundrunning.i;
import com.tencent.mm.plugin.appbrand.backgroundrunning.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.l;
import com.tencent.mm.plugin.appbrand.jsapi.m.u;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.StopBackgroundMusicTask;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;

abstract class f
  extends g
  implements ComponentCallbacks2
{
  int qLx = 0;
  private final AppBrandMusicClientService.a qLy = new AppBrandMusicClientService.a()
  {
    public final void chO()
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
  private final AppBrandRuntime qwG;
  
  f(h paramh, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramh);
    this.qwG = paramAppBrandRuntime;
  }
  
  private int chL()
  {
    this.qLx = 0;
    Object localObject1 = this.qwG.mAppId;
    Object localObject2 = (a)this.qwG.aN(a.class);
    int i;
    AppBrandMusicClientService.a locala;
    label81:
    boolean bool;
    if ((localObject2 != null) && (((a)localObject2).qKt))
    {
      i = 1;
      if (i == 0) {
        break label562;
      }
      if (AppBrandMusicClientService.adC((String)localObject1))
      {
        hp(1);
        localObject2 = AppBrandMusicClientService.thY;
        locala = this.qLy;
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (locala != null)) {
          break label510;
        }
      }
      bool = ((a)this.qwG.aN(a.class)).qKu;
      Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, canKeepAliveLocation:%s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        localObject2 = (u)this.qwG.aO(u.class);
        if (localObject2 != null)
        {
          if ((!((u)localObject2).sax) || (!((u)localObject2).qSk)) {
            break label619;
          }
          i = 1;
          label156:
          Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, isBackgroundMode:%s, isListening:%s", new Object[] { Boolean.valueOf(((u)localObject2).sax), Boolean.valueOf(((u)localObject2).qSk) });
          if (i != 0) {
            hp(32);
          }
        }
      }
      localObject2 = (j)this.qwG.aO(j.class);
      if (localObject2 != null)
      {
        bool = ((j)localObject2).cjS();
        Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandLiveVOIPIfNeed, isVOIPing:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          hp(64);
        }
      }
      localObject2 = (i)this.qwG.aO(i.class);
      if (localObject2 != null)
      {
        bool = ((i)localObject2).cjR();
        Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandAudioBackgroundPlayIfNeed, isNeedKeepAlive:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          hp(128);
        }
      }
      localObject2 = (j)this.qwG.aO(j.class);
      if (localObject2 != null)
      {
        bool = ((j)localObject2).cjS();
        Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandLiveVOIPIfNeed, isVOIPing:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          hp(256);
        }
      }
      localObject2 = e.rKk.af(this.qwG);
      if (localObject2 != null) {
        break label624;
      }
      Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagBluetoothIfNeed, client is null");
      label384:
      if ((c.qKB) && (this.qwG.isInBackStack()))
      {
        localObject2 = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState((ActivityManager.RunningAppProcessInfo)localObject2);
        Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagForForegroundService processInfo.importance:%d", new Object[] { Integer.valueOf(((ActivityManager.RunningAppProcessInfo)localObject2).importance) });
        if (100 == ((ActivityManager.RunningAppProcessInfo)localObject2).importance)
        {
          hp(1024);
          MMApplicationContext.getContext().registerComponentCallbacks(this);
        }
      }
      localObject1 = k.Uo((String)localObject1);
      switch (2.qLA[localObject1.ordinal()])
      {
      }
    }
    label510:
    do
    {
      for (;;)
      {
        return this.qLx;
        i = 0;
        break;
        if (!((AppBrandMusicClientService)localObject2).thX.containsKey(localObject1))
        {
          ((AppBrandMusicClientService)localObject2).thX.put(localObject1, locala);
          break label81;
        }
        ((AppBrandMusicClientService)localObject2).thX.remove(localObject1);
        ((AppBrandMusicClientService)localObject2).thX.put(localObject1, locala);
        break label81;
        localObject2 = AppBrandMusicClientService.thY;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label81;
        }
        if (!((String)localObject1).equalsIgnoreCase(((AppBrandMusicClientService)localObject2).thZ))
        {
          Log.e("MicroMsg.AppBrandMusicClientService", "appId is diff, can't stop music");
          break label81;
        }
        localObject2 = new AppBrandMusicClientService.StopBackgroundMusicTask();
        ((AppBrandMusicClientService.StopBackgroundMusicTask)localObject2).appId = ((String)localObject1);
        ((AppBrandMusicClientService.StopBackgroundMusicTask)localObject2).bQt();
        break label81;
        i = 0;
        break label156;
        Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagBluetoothIfNeed, client: " + ((l)localObject2).com());
        bool = ((l)localObject2).cjR();
        Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagBluetoothIfNeed, isNeedKeepAlive: ".concat(String.valueOf(bool)));
        if (!bool) {
          break label384;
        }
        hp(512);
        break label384;
        hp(16);
        continue;
        hp(4);
        continue;
        try
        {
          if ((this.qwG.qsc != null) && ((!this.qwG.qsc.getWindowAndroid().ccf()) || (this.qwG.cbs() != null))) {
            hp(8);
          }
        }
        catch (IllegalAccessError localIllegalAccessError) {}
      }
    } while (!BuildInfo.DEBUG);
    label562:
    label619:
    label624:
    throw localIllegalAccessError;
  }
  
  private void chM()
  {
    if ((this.qLx & 0x400) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
        if (100 != localRunningAppProcessInfo.importance) {
          zr(1024);
        }
      }
      return;
    }
  }
  
  private void hp(int paramInt)
  {
    this.qLx |= paramInt;
  }
  
  private void zr(int paramInt)
  {
    this.qLx &= (paramInt ^ 0xFFFFFFFF);
    if (this.qLx == 0)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "onKeepFlagsCleared, appId:%s", new Object[] { this.qwG.mAppId });
      chI();
    }
  }
  
  abstract void chI();
  
  final void chN()
  {
    zr(16);
  }
  
  public void enter()
  {
    this.qLx = chL();
    super.enter();
    zr(0);
  }
  
  public void exit()
  {
    super.exit();
    this.qLx = 0;
    AppBrandMusicClientService localAppBrandMusicClientService = AppBrandMusicClientService.thY;
    String str = this.qwG.mAppId;
    if ((!TextUtils.isEmpty(str)) && (localAppBrandMusicClientService.thX.containsKey(str))) {
      localAppBrandMusicClientService.thX.remove(str);
    }
    try
    {
      MMApplicationContext.getContext().unregisterComponentCallbacks(this);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory()
  {
    Log.i("MicroMsg.MultipleConditionBackgroundState", "onLowMemory");
    chM();
  }
  
  public void onTrimMemory(int paramInt)
  {
    Log.i("MicroMsg.MultipleConditionBackgroundState", "onTrimMemory level:%d", new Object[] { Integer.valueOf(paramInt) });
    chM();
  }
  
  public boolean processMessage(Message paramMessage)
  {
    if (d.a.zq(paramMessage.what) == d.a.qLh)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LOCATION_LISTENING");
      zr(32);
      return true;
    }
    if (d.a.zq(paramMessage.what) == d.a.qLi)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LIVE_VOIP");
      zr(64);
      return true;
    }
    if (d.a.zq(paramMessage.what) == d.a.qLj)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_AUDIO_BACKGROUND_PLAY");
      zr(128);
      return true;
    }
    if (d.a.zq(paramMessage.what) == d.a.qLk)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LIVE_VOIP");
      zr(256);
      return true;
    }
    if (d.a.zq(paramMessage.what) == d.a.qLm)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_CONTAINER_FORCED_MOVE_TO_BACK, appId:%s", new Object[] { this.qwG.mAppId });
      zr(4);
      return true;
    }
    if (d.a.zq(paramMessage.what) == d.a.qLl)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_BLUETOOTH");
      zr(512);
      return true;
    }
    if (d.a.zq(paramMessage.what) == d.a.qLg)
    {
      Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_RESET_TO_TOP_OF_STACK");
      zr(16);
      return true;
    }
    return super.processMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.f
 * JD-Core Version:    0.7.0.1
 */