package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.fcm.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.splash.b;
import com.tencent.mm.splash.c;
import com.tencent.mm.splash.f;
import com.tencent.mm.splash.m;
import com.tencent.mm.splash.n;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.tinker.entry.ApplicationLike;
import java.util.ArrayList;

public final class z
{
  public static com.tencent.mm.kernel.b.h bZn;
  
  private static void BJ()
  {
    AppMethodBeat.i(137946);
    com.tencent.mm.splash.h.a(new c()
    {
      public final void a(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        AppMethodBeat.i(137940);
        ab.printErrStackTrace("WxSplash.WeChatSplash", paramAnonymousThrowable, paramAnonymousString, new Object[0]);
        String str = paramAnonymousString;
        if (paramAnonymousString == null) {
          str = "";
        }
        paramAnonymousThrowable = str + "  " + Log.getStackTraceString(paramAnonymousThrowable);
        com.tencent.mm.splash.h.dvB().ywn.add(paramAnonymousThrowable);
        AppMethodBeat.o(137940);
      }
      
      public final void c(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(137941);
        ab.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(137941);
      }
      
      public final void m(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(137939);
        if ((z.bZn != null) && (z.bZn.SD()))
        {
          paramAnonymousActivity = paramAnonymousActivity.getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mp());
          if (paramAnonymousActivity.getBoolean("first_launch_weixin", true))
          {
            paramAnonymousActivity.edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
          }
        }
        AppMethodBeat.o(137939);
      }
    });
    com.tencent.mm.splash.h.a(new b()
    {
      public final boolean be(Context paramAnonymousContext)
      {
        AppMethodBeat.i(137954);
        boolean bool = com.tencent.mm.f.a.bp(paramAnonymousContext);
        AppMethodBeat.o(137954);
        return bool;
      }
      
      public final boolean bf(Context paramAnonymousContext)
      {
        AppMethodBeat.i(137955);
        boolean bool = com.tencent.mm.f.a.bf(paramAnonymousContext);
        AppMethodBeat.o(137955);
        return bool;
      }
      
      public final void bg(Context paramAnonymousContext)
      {
        AppMethodBeat.i(137956);
        com.tencent.mm.f.a.bg(paramAnonymousContext);
        AppMethodBeat.o(137956);
      }
    });
    com.tencent.mm.splash.h.a(new f()
    {
      public final void BK()
      {
        AppMethodBeat.i(137968);
        com.tencent.mm.blink.a.BK();
        AppMethodBeat.o(137968);
      }
      
      public final void BL()
      {
        AppMethodBeat.i(137970);
        com.tencent.mm.blink.a.id(1);
        AppMethodBeat.o(137970);
      }
      
      public final void dD(String paramAnonymousString)
      {
        AppMethodBeat.i(137969);
        com.tencent.mm.blink.a.dD(paramAnonymousString);
        AppMethodBeat.o(137969);
      }
    });
    AppMethodBeat.o(137946);
  }
  
  public static void a(com.tencent.mm.kernel.b.h paramh, String paramString)
  {
    AppMethodBeat.i(137947);
    bZn = paramh;
    BJ();
    if (paramString == null)
    {
      ab.i("WxSplash.WeChatSplash", "splash callback class is null, return.");
      AppMethodBeat.o(137947);
      return;
    }
    com.tencent.mm.blink.a.v(paramh.eKG.getApplicationStartMillisTime(), paramh.eKG.getApplicationStartElapsedTime());
    com.tencent.mm.splash.h.aqJ(ah.dsN());
    com.tencent.mm.splash.h.as(WeChatSplashActivity.class);
    com.tencent.mm.splash.h.at(WeChatSplashFallbackActivity.class);
    if (d.e(paramh)) {
      com.tencent.mm.splash.h.aqI("com.google.firebase.provider.FirebaseInitProvider");
    }
    m.a(paramh.bX, paramh.mProcessName, paramString);
    AppMethodBeat.o(137947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.z
 * JD-Core Version:    0.7.0.1
 */