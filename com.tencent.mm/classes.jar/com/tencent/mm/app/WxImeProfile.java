package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.crash.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.nativecrash.NativeCrash;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/app/WxImeProfile;", "Lcom/tencent/mm/compatible/loader/Profile;", "()V", "PROCESS_NAME", "", "onConfigurationChanged", "", "config", "Landroid/content/res/Configuration;", "onCreate", "onTrimMemory", "level", "", "Companion", "app_release"})
public final class WxImeProfile
  extends c
{
  public static final WxImeProfile.a fge;
  private final String PROCESS_NAME;
  
  static
  {
    AppMethodBeat.i(292040);
    fge = new WxImeProfile.a((byte)0);
    AppMethodBeat.o(292040);
  }
  
  public WxImeProfile()
  {
    AppMethodBeat.i(292038);
    String str = MMApplicationContext.getProcessName();
    kotlin.g.b.p.j(str, "MMApplicationContext.getProcessName()");
    this.PROCESS_NAME = str;
    AppMethodBeat.o(292038);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(292036);
    Log.i("WxIme.WxImeProfile", "onConfigurationChanged");
    AppMethodBeat.o(292036);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(292035);
    Log.i("WxIme.WxImeProfile", "WxImeProfile onCreate.");
    long l = System.currentTimeMillis();
    Object localObject = com.tencent.mm.plugin.hld.model.p.DEH;
    localObject = MMApplicationContext.getContext();
    kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getPackageName();
    kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext().packageName");
    com.tencent.mm.plugin.hld.model.p.aLA((String)localObject);
    localObject = com.tencent.mm.plugin.hld.model.p.DEH;
    com.tencent.mm.plugin.hld.model.p.init();
    LocaleUtil.initLanguage(MMApplicationContext.getContext());
    t.f(false, this.PROCESS_NAME);
    com.tencent.mm.vfs.h.setContext((Context)this.app);
    Log.setConsoleLogOpen(true);
    d.cQP = Util.getProcessNameByPid((Context)this.app, Process.myPid());
    NativeCrash.class.getClassLoader();
    com.tencent.mm.compatible.util.j.KW("wechatcrash");
    a.ayx();
    WxImeProfile.class.getClassLoader();
    com.tencent.mm.compatible.util.j.KW("wechatcommon");
    com.tencent.mm.compatible.util.j.KW("wechatbase");
    com.tencent.mm.compatible.util.j.KW("wechatmm");
    a.b.a((j.a)new b((j.a)new b(this)));
    com.tencent.mm.kernel.h.a(new com.tencent.mm.kernel.b.h(MMApplicationContext.getProcessName(), this.app, null));
    Log.i("WxIme.WxImeProfile", "WxImeProfile onCreate finish in %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(292035);
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(292037);
    super.onTrimMemory(paramInt);
    Log.v("WxIme.WxImeProfile", "onTerminate(l : %d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(292037);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/app/WxImeProfile$onCreate$1", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "defaultAvatar", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "getDefaultAvatar", "()Landroid/graphics/Bitmap;", "getDefaultBitmap", "loadBitmap", "tag", "", "loadFromCache", "loadHdBitmap", "width", "", "height", "customFillet", "watch", "", "drawable", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable;", "app_release"})
  public static final class b
    implements j.a
  {
    private final Bitmap fgf;
    
    b()
    {
      AppMethodBeat.i(281901);
      Object localObject = WxImeProfile.a((WxImeProfile)localObject);
      kotlin.g.b.p.j(localObject, "app");
      this.fgf = BitmapFactory.decodeResource(((Application)localObject).getResources(), R.g.icon);
      AppMethodBeat.o(281901);
    }
    
    public final void a(com.tencent.mm.pluginsdk.ui.j paramj) {}
    
    public final Bitmap aaC()
    {
      AppMethodBeat.i(281899);
      Bitmap localBitmap = this.fgf;
      kotlin.g.b.p.j(localBitmap, "defaultAvatar");
      AppMethodBeat.o(281899);
      return localBitmap;
    }
    
    public final Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      return this.fgf;
    }
    
    public final Bitmap gJ(String paramString)
    {
      return this.fgf;
    }
    
    public final Bitmap gK(String paramString)
    {
      return this.fgf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.WxImeProfile
 * JD-Core Version:    0.7.0.1
 */