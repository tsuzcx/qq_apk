package com.tencent.mm.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.plugin.hld.model.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.nativecrash.NativeCrash;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/app/WxImeProfile;", "Lcom/tencent/mm/compatible/loader/Profile;", "()V", "PROCESS_NAME", "", "onConfigurationChanged", "", "config", "Landroid/content/res/Configuration;", "onCreate", "onTrimMemory", "level", "", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxImeProfile
  extends c
{
  public static final WxImeProfile.a hko;
  private final String PROCESS_NAME;
  
  static
  {
    AppMethodBeat.i(239285);
    hko = new WxImeProfile.a((byte)0);
    AppMethodBeat.o(239285);
  }
  
  public WxImeProfile()
  {
    AppMethodBeat.i(239280);
    String str = MMApplicationContext.getProcessName();
    s.s(str, "getProcessName()");
    this.PROCESS_NAME = str;
    AppMethodBeat.o(239280);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(239292);
    Log.i("WxIme.WxImeProfile", "onConfigurationChanged");
    AppMethodBeat.o(239292);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(239289);
    Log.i("WxIme.WxImeProfile", "WxImeProfile onCreate.");
    long l = System.currentTimeMillis();
    Object localObject = o.Jwm;
    localObject = MMApplicationContext.getContext().getPackageName();
    s.s(localObject, "getContext().packageName");
    o.aIs((String)localObject);
    localObject = o.Jwm;
    o.init();
    LocaleUtil.initLanguage(MMApplicationContext.getContext());
    w.f(false, this.PROCESS_NAME);
    com.tencent.mm.vfs.k.setContext((Context)this.app);
    Log.setConsoleLogOpen(true);
    e.eMg = Util.getProcessNameByPid((Context)this.app, Process.myPid());
    NativeCrash.class.getClassLoader();
    com.tencent.mm.compatible.util.k.DA("wechatcrash");
    com.tencent.mm.crash.b.aTa();
    WxImeProfile.class.getClassLoader();
    com.tencent.mm.compatible.util.k.DA("wechatcommon");
    com.tencent.mm.compatible.util.k.DA("wechatbase");
    com.tencent.mm.compatible.util.k.DA("wechatmm");
    a.b.a((j.a)new com.tencent.mm.pluginsdk.ui.b((j.a)new WxImeProfile.b(this)));
    com.tencent.mm.kernel.h.a(new com.tencent.mm.kernel.b.h(MMApplicationContext.getProcessName(), this.app, null));
    Log.i("WxIme.WxImeProfile", "WxImeProfile onCreate finish in %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(239289);
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(239295);
    super.onTrimMemory(paramInt);
    Log.v("WxIme.WxImeProfile", "onTerminate(l : %d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(239295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.WxImeProfile
 * JD-Core Version:    0.7.0.1
 */