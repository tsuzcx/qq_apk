package com.tencent.mm.app;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.splash.b;
import com.tencent.mm.splash.c;
import com.tencent.mm.splash.f;
import com.tencent.mm.splash.i;
import com.tencent.mm.splash.n;
import com.tencent.mm.splash.o;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.tinker.entry.ApplicationLike;
import java.util.ArrayList;

public final class ap
{
  public static h hji;
  
  public static void a(h paramh, String paramString)
  {
    AppMethodBeat.i(160061);
    hji = paramh;
    aDp();
    if (paramString == null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("WxSplash.WeChatSplash", "splash callback class is null, return.");
      AppMethodBeat.o(160061);
      return;
    }
    com.tencent.mm.blink.a.R(paramh.mFT.getApplicationStartMillisTime(), paramh.mFT.getApplicationStartElapsedTime());
    i.buI(MMApplicationContext.getLaunchName());
    i.cg(WeChatSplashActivity.class);
    i.ch(WeChatSplashFallbackActivity.class);
    if (!com.tencent.mm.plugin.fcm.a.gm(paramh.bGP)) {
      i.buH("com.google.firebase.provider.FirebaseInitProvider");
    }
    n.a(paramh.bGP, paramh.mProcessName, paramString);
    AppMethodBeat.o(160061);
  }
  
  private static void aDp()
  {
    AppMethodBeat.i(160060);
    i.a(new c()
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
        i.iVT().acBG.add(paramAnonymousThrowable);
        AppMethodBeat.o(160029);
      }
      
      public final void g(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(160030);
        com.tencent.mm.sdk.platformtools.Log.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(160030);
      }
      
      public final void s(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(160028);
        if ((ap.hji != null) && (ap.hji.bbA()))
        {
          paramAnonymousActivity = paramAnonymousActivity.getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.aQe());
          if (paramAnonymousActivity.getBoolean("first_launch_weixin", true))
          {
            paramAnonymousActivity.edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
          }
        }
        AppMethodBeat.o(160028);
      }
    });
    i.a(new b()
    {
      public final boolean aDq()
      {
        return true;
      }
      
      public final boolean aDr()
      {
        return false;
      }
    });
    i.a(new f()
    {
      public final void aDs()
      {
        AppMethodBeat.i(160085);
        com.tencent.mm.blink.a.aDs();
        AppMethodBeat.o(160085);
      }
      
      public final void aDt()
      {
        AppMethodBeat.i(160087);
        com.tencent.mm.blink.a.qd(1);
        AppMethodBeat.o(160087);
      }
      
      public final void iy(String paramAnonymousString)
      {
        AppMethodBeat.i(160086);
        com.tencent.mm.blink.a.iy(paramAnonymousString);
        AppMethodBeat.o(160086);
      }
    });
    AppMethodBeat.o(160060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.ap
 * JD-Core Version:    0.7.0.1
 */