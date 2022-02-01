package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.splash.b;
import com.tencent.mm.splash.c;
import com.tencent.mm.splash.f;
import com.tencent.mm.splash.m;
import com.tencent.mm.splash.n;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.tinker.entry.ApplicationLike;
import java.util.ArrayList;

public final class aj
{
  public static com.tencent.mm.kernel.b.h dmN;
  
  private static void WT()
  {
    AppMethodBeat.i(160060);
    com.tencent.mm.splash.h.a(new c()
    {
      public final void a(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        AppMethodBeat.i(160029);
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("WxSplash.WeChatSplash", paramAnonymousThrowable, paramAnonymousString, new Object[0]);
        String str = paramAnonymousString;
        if (paramAnonymousString == null) {
          str = "";
        }
        paramAnonymousThrowable = str + "  " + android.util.Log.getStackTraceString(paramAnonymousThrowable);
        com.tencent.mm.splash.h.gyq().NMC.add(paramAnonymousThrowable);
        AppMethodBeat.o(160029);
      }
      
      public final void c(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(160030);
        com.tencent.mm.sdk.platformtools.Log.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(160030);
      }
      
      public final void r(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(160028);
        if ((aj.dmN != null) && (aj.dmN.aBb()))
        {
          paramAnonymousActivity = paramAnonymousActivity.getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.aps());
          if (paramAnonymousActivity.getBoolean("first_launch_weixin", true))
          {
            paramAnonymousActivity.edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
          }
        }
        AppMethodBeat.o(160028);
      }
    });
    com.tencent.mm.splash.h.a(new b()
    {
      public final boolean bR(Context paramAnonymousContext)
      {
        AppMethodBeat.i(160072);
        boolean bool = com.tencent.mm.f.a.cc(paramAnonymousContext);
        AppMethodBeat.o(160072);
        return bool;
      }
      
      public final boolean bS(Context paramAnonymousContext)
      {
        AppMethodBeat.i(160073);
        boolean bool = com.tencent.mm.f.a.bS(paramAnonymousContext);
        AppMethodBeat.o(160073);
        return bool;
      }
      
      public final void bT(Context paramAnonymousContext)
      {
        AppMethodBeat.i(160074);
        com.tencent.mm.f.a.bT(paramAnonymousContext);
        AppMethodBeat.o(160074);
      }
    });
    com.tencent.mm.splash.h.a(new f()
    {
      public final void WU()
      {
        AppMethodBeat.i(160085);
        com.tencent.mm.blink.a.WU();
        AppMethodBeat.o(160085);
      }
      
      public final void WV()
      {
        AppMethodBeat.i(160087);
        com.tencent.mm.blink.a.nO(1);
        AppMethodBeat.o(160087);
      }
      
      public final void gn(String paramAnonymousString)
      {
        AppMethodBeat.i(160086);
        com.tencent.mm.blink.a.gn(paramAnonymousString);
        AppMethodBeat.o(160086);
      }
    });
    AppMethodBeat.o(160060);
  }
  
  public static void a(com.tencent.mm.kernel.b.h paramh, String paramString)
  {
    AppMethodBeat.i(160061);
    dmN = paramh;
    WT();
    if (paramString == null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("WxSplash.WeChatSplash", "splash callback class is null, return.");
      AppMethodBeat.o(160061);
      return;
    }
    com.tencent.mm.blink.a.u(paramh.htz.getApplicationStartMillisTime(), paramh.htz.getApplicationStartElapsedTime());
    com.tencent.mm.splash.h.bil(MMApplicationContext.getLaunchName());
    com.tencent.mm.splash.h.bb(WeChatSplashActivity.class);
    com.tencent.mm.splash.h.bc(WeChatSplashFallbackActivity.class);
    if (!com.tencent.mm.plugin.fcm.a.fj(paramh.ca)) {
      com.tencent.mm.splash.h.bik("com.google.firebase.provider.FirebaseInitProvider");
    }
    m.a(paramh.ca, paramh.mProcessName, paramString);
    AppMethodBeat.o(160061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.aj
 * JD-Core Version:    0.7.0.1
 */