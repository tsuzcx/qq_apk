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

public final class al
{
  public static h ffb;
  
  public static void a(h paramh, String paramString)
  {
    AppMethodBeat.i(160061);
    ffb = paramh;
    abw();
    if (paramString == null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("WxSplash.WeChatSplash", "splash callback class is null, return.");
      AppMethodBeat.o(160061);
      return;
    }
    com.tencent.mm.blink.a.u(paramh.kfv.getApplicationStartMillisTime(), paramh.kfv.getApplicationStartElapsedTime());
    i.buC(MMApplicationContext.getLaunchName());
    i.bw(WeChatSplashActivity.class);
    i.bx(WeChatSplashFallbackActivity.class);
    if (!com.tencent.mm.plugin.fcm.a.fo(paramh.Zw)) {
      i.buB("com.google.firebase.provider.FirebaseInitProvider");
    }
    n.a(paramh.Zw, paramh.mProcessName, paramString);
    AppMethodBeat.o(160061);
  }
  
  private static void abw()
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
        i.huq().Vam.add(paramAnonymousThrowable);
        AppMethodBeat.o(160029);
      }
      
      public final void g(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(160030);
        com.tencent.mm.sdk.platformtools.Log.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(160030);
      }
      
      public final void q(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(160028);
        if ((al.ffb != null) && (al.ffb.aIE()))
        {
          paramAnonymousActivity = paramAnonymousActivity.getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.avK());
          if (paramAnonymousActivity.getBoolean("first_launch_weixin", true))
          {
            paramAnonymousActivity.edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
          }
        }
        AppMethodBeat.o(160028);
      }
    });
    i.a(new b() {});
    i.a(new f()
    {
      public final void abx()
      {
        AppMethodBeat.i(160085);
        com.tencent.mm.blink.a.abx();
        AppMethodBeat.o(160085);
      }
      
      public final void aby()
      {
        AppMethodBeat.i(160087);
        com.tencent.mm.blink.a.qd(1);
        AppMethodBeat.o(160087);
      }
      
      public final void gX(String paramAnonymousString)
      {
        AppMethodBeat.i(160086);
        com.tencent.mm.blink.a.gX(paramAnonymousString);
        AppMethodBeat.o(160086);
      }
    });
    AppMethodBeat.o(160060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.al
 * JD-Core Version:    0.7.0.1
 */