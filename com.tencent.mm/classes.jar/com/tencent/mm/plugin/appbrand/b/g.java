package com.tencent.mm.plugin.appbrand.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.ad;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.StopBackgroundMusicTask;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

abstract class g
  extends h
{
  private final com.tencent.mm.plugin.appbrand.i gRG;
  int gYR = 0;
  private final AppBrandMusicClientService.a gYS = new g.1(this);
  
  g(i parami, com.tencent.mm.plugin.appbrand.i parami1)
  {
    super(parami);
    this.gRG = parami1;
  }
  
  private int aww()
  {
    this.gYR = 0;
    Object localObject1 = this.gRG.mAppId;
    Object localObject2 = this.gRG.U(a.class);
    int i;
    AppBrandMusicClientService.a locala;
    if ((localObject2 != null) && (((a)localObject2).gYd))
    {
      i = 1;
      if (i == 0) {
        break label174;
      }
      if (AppBrandMusicClientService.Dy((String)localObject1))
      {
        db(1);
        localObject2 = AppBrandMusicClientService.ioY;
        locala = this.gYS;
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (locala != null)) {
          break label126;
        }
      }
      label77:
      localObject1 = e.xX((String)localObject1);
      switch (g.2.gYU[localObject1.ordinal()])
      {
      }
    }
    for (;;)
    {
      return this.gYR;
      i = 0;
      break;
      label126:
      if (!((AppBrandMusicClientService)localObject2).ioX.containsKey(localObject1))
      {
        ((AppBrandMusicClientService)localObject2).ioX.put(localObject1, locala);
        break label77;
      }
      ((AppBrandMusicClientService)localObject2).ioX.remove(localObject1);
      ((AppBrandMusicClientService)localObject2).ioX.put(localObject1, locala);
      break label77;
      label174:
      localObject2 = AppBrandMusicClientService.ioY;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label77;
      }
      if (!((String)localObject1).equalsIgnoreCase(((AppBrandMusicClientService)localObject2).ioZ))
      {
        ab.e("MicroMsg.AppBrandMusicClientService", "appId is diff, can't stop music");
        break label77;
      }
      localObject2 = new AppBrandMusicClientService.StopBackgroundMusicTask();
      ((AppBrandMusicClientService.StopBackgroundMusicTask)localObject2).appId = ((String)localObject1);
      AppBrandMainProcessService.a((MainProcessTask)localObject2);
      break label77;
      db(16);
      continue;
      db(4);
      continue;
      try
      {
        if ((!this.gRG.gPw.atK().aLX()) || (this.gRG.ati() != null)) {
          db(8);
        }
      }
      catch (IllegalAccessError localIllegalAccessError) {}
    }
  }
  
  private void db(int paramInt)
  {
    this.gYR |= paramInt;
  }
  
  abstract void aws();
  
  public void enter()
  {
    this.gYR = aww();
    super.enter();
    np(0);
  }
  
  public void exit()
  {
    super.exit();
    this.gYR = 0;
    AppBrandMusicClientService localAppBrandMusicClientService = AppBrandMusicClientService.ioY;
    String str = this.gRG.mAppId;
    if ((!TextUtils.isEmpty(str)) && (localAppBrandMusicClientService.ioX.containsKey(str))) {
      localAppBrandMusicClientService.ioX.remove(str);
    }
  }
  
  final void np(int paramInt)
  {
    this.gYR &= (paramInt ^ 0xFFFFFFFF);
    if (this.gYR == 0) {
      aws();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.g
 * JD-Core Version:    0.7.0.1
 */