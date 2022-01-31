package com.tencent.mm.plugin.appbrand.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.StopBackgroundMusicTask;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.a;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

abstract class g
  extends h
{
  int fGk = 0;
  private final AppBrandMusicClientService.a fGl = new g.1(this);
  private final com.tencent.mm.plugin.appbrand.i fzT;
  
  g(i parami, com.tencent.mm.plugin.appbrand.i parami1)
  {
    super(parami);
    this.fzT = parami1;
  }
  
  private void cG(int paramInt)
  {
    this.fGk |= paramInt;
  }
  
  abstract void acB();
  
  public void enter()
  {
    this.fGk = 0;
    Object localObject1 = this.fzT.mAppId;
    Object localObject2 = this.fzT.c(a.class, true);
    int i;
    AppBrandMusicClientService.a locala;
    if ((localObject2 != null) && (((a)localObject2).fFH))
    {
      i = 1;
      if (i == 0) {
        break label187;
      }
      if (AppBrandMusicClientService.vc((String)localObject1))
      {
        cG(1);
        localObject2 = AppBrandMusicClientService.gNe;
        locala = this.fGl;
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (locala != null)) {
          break label139;
        }
      }
      label78:
      localObject1 = com.tencent.mm.plugin.appbrand.g.qB((String)localObject1);
      switch (g.2.fGn[localObject1.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.fGk = this.fGk;
      super.enter();
      kv(0);
      return;
      i = 0;
      break;
      label139:
      if (!((AppBrandMusicClientService)localObject2).gNd.containsKey(localObject1))
      {
        ((AppBrandMusicClientService)localObject2).gNd.put(localObject1, locala);
        break label78;
      }
      ((AppBrandMusicClientService)localObject2).gNd.remove(localObject1);
      ((AppBrandMusicClientService)localObject2).gNd.put(localObject1, locala);
      break label78;
      label187:
      localObject2 = AppBrandMusicClientService.gNe;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label78;
      }
      if (!((String)localObject1).equalsIgnoreCase(((AppBrandMusicClientService)localObject2).gNf))
      {
        y.e("MicroMsg.AppBrandMusicClientService", "appId is diff, can't stop music");
        break label78;
      }
      localObject2 = new AppBrandMusicClientService.StopBackgroundMusicTask();
      ((AppBrandMusicClientService.StopBackgroundMusicTask)localObject2).appId = ((String)localObject1);
      AppBrandMainProcessService.a((MainProcessTask)localObject2);
      break label78;
      cG(16);
      continue;
      cG(4);
      continue;
      if ((!this.fzT.fyl.ZZ().aoO()) || (this.fzT.Zx() != null)) {
        cG(8);
      }
    }
  }
  
  public void exit()
  {
    super.exit();
    this.fGk = 0;
    AppBrandMusicClientService localAppBrandMusicClientService = AppBrandMusicClientService.gNe;
    String str = this.fzT.mAppId;
    if ((!TextUtils.isEmpty(str)) && (localAppBrandMusicClientService.gNd.containsKey(str))) {
      localAppBrandMusicClientService.gNd.remove(str);
    }
  }
  
  final void kv(int paramInt)
  {
    this.fGk &= (paramInt ^ 0xFFFFFFFF);
    if (this.fGk == 0) {
      acB();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.g
 * JD-Core Version:    0.7.0.1
 */