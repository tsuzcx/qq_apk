package com.tencent.kinda.framework;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.e.i;
import com.tencent.kinda.framework.api.IPluginWxKindaApi;
import com.tencent.kinda.framework.app.SubCoreKinda;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.y;
import com.tencent.mm.pluginsdk.wallet.a;

public class PluginWxKindaApi
  extends f
  implements IPluginWxKindaApi, ApplicationLifeCycleBucket, c
{
  private static final String TAG = "MicroMsg.PluginWxKindaApi";
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(18262);
    if (paramg.aIE())
    {
      pin(new y(SubCoreKinda.class));
      com.tencent.mm.kernel.h.b(a.class, new WxCrossServices());
    }
    AppMethodBeat.o(18262);
  }
  
  public void dependency() {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(18263);
    AppMethodBeat.o(18263);
  }
  
  public void installed()
  {
    AppMethodBeat.i(18261);
    alias(PluginWxKindaApi.class);
    AppMethodBeat.o(18261);
  }
  
  public String name()
  {
    return "plugin-wxkindaapi";
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(264047);
    WxCrossServices.judgeReprot();
    com.tencent.e.h.ZvG.be(new PluginWxKindaApi.1(this));
    AppMethodBeat.o(264047);
  }
  
  public void onAccountRelease() {}
  
  public void onBaseContextAttached(Context paramContext) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onCreate() {}
  
  public void onLowMemory()
  {
    AppMethodBeat.i(264051);
    com.tencent.e.h.ZvG.be(new PluginWxKindaApi.2(this));
    AppMethodBeat.o(264051);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(264053);
    com.tencent.e.h.ZvG.be(new PluginWxKindaApi.4(this));
    AppMethodBeat.o(264053);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(264052);
    if (paramInt <= 20)
    {
      AppMethodBeat.o(264052);
      return;
    }
    com.tencent.e.h.ZvG.be(new PluginWxKindaApi.3(this, paramInt));
    AppMethodBeat.o(264052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.PluginWxKindaApi
 * JD-Core Version:    0.7.0.1
 */