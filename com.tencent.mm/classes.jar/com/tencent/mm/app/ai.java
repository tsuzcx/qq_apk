package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fcm.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.splash.b;
import com.tencent.mm.splash.c;
import com.tencent.mm.splash.f;
import com.tencent.mm.splash.m;
import com.tencent.mm.splash.n;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.tinker.entry.ApplicationLike;
import java.util.ArrayList;

public final class ai
{
  public static com.tencent.mm.kernel.b.h cVo;
  
  private static void ML()
  {
    AppMethodBeat.i(160060);
    com.tencent.mm.splash.h.a(new c()
    {
      public final void a(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        AppMethodBeat.i(160029);
        ad.printErrStackTrace("WxSplash.WeChatSplash", paramAnonymousThrowable, paramAnonymousString, new Object[0]);
        String str = paramAnonymousString;
        if (paramAnonymousString == null) {
          str = "";
        }
        paramAnonymousThrowable = str + "  " + Log.getStackTraceString(paramAnonymousThrowable);
        com.tencent.mm.splash.h.fnx().Ilz.add(paramAnonymousThrowable);
        AppMethodBeat.o(160029);
      }
      
      public final void b(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(160030);
        ad.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(160030);
      }
      
      public final void r(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(160028);
        if ((ai.cVo != null) && (ai.cVo.akw()))
        {
          paramAnonymousActivity = paramAnonymousActivity.getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.abm());
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
      public final boolean bu(Context paramAnonymousContext)
      {
        AppMethodBeat.i(160072);
        boolean bool = com.tencent.mm.f.a.bF(paramAnonymousContext);
        AppMethodBeat.o(160072);
        return bool;
      }
      
      public final boolean bv(Context paramAnonymousContext)
      {
        AppMethodBeat.i(160073);
        boolean bool = com.tencent.mm.f.a.bv(paramAnonymousContext);
        AppMethodBeat.o(160073);
        return bool;
      }
      
      public final void bw(Context paramAnonymousContext)
      {
        AppMethodBeat.i(160074);
        com.tencent.mm.f.a.bw(paramAnonymousContext);
        AppMethodBeat.o(160074);
      }
    });
    com.tencent.mm.splash.h.a(new f()
    {
      public final void MM()
      {
        AppMethodBeat.i(160085);
        com.tencent.mm.blink.a.MM();
        AppMethodBeat.o(160085);
      }
      
      public final void MN()
      {
        AppMethodBeat.i(160087);
        com.tencent.mm.blink.a.kJ(1);
        AppMethodBeat.o(160087);
      }
      
      public final void fu(String paramAnonymousString)
      {
        AppMethodBeat.i(160086);
        com.tencent.mm.blink.a.fu(paramAnonymousString);
        AppMethodBeat.o(160086);
      }
    });
    AppMethodBeat.o(160060);
  }
  
  public static void a(com.tencent.mm.kernel.b.h paramh, String paramString)
  {
    AppMethodBeat.i(160061);
    cVo = paramh;
    ML();
    if (paramString == null)
    {
      ad.i("WxSplash.WeChatSplash", "splash callback class is null, return.");
      AppMethodBeat.o(160061);
      return;
    }
    com.tencent.mm.blink.a.t(paramh.gEe.getApplicationStartMillisTime(), paramh.gEe.getApplicationStartElapsedTime());
    com.tencent.mm.splash.h.aRU(aj.fkA());
    com.tencent.mm.splash.h.bb(WeChatSplashActivity.class);
    com.tencent.mm.splash.h.bc(WeChatSplashFallbackActivity.class);
    if (d.e(paramh)) {
      com.tencent.mm.splash.h.aRT("com.google.firebase.provider.FirebaseInitProvider");
    }
    m.a(paramh.ca, paramh.mProcessName, paramString);
    AppMethodBeat.o(160061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.ai
 * JD-Core Version:    0.7.0.1
 */