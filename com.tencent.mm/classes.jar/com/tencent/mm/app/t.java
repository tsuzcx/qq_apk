package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.splash.b;
import com.tencent.mm.splash.c;
import com.tencent.mm.splash.f;
import com.tencent.mm.splash.i;
import com.tencent.mm.splash.n;
import com.tencent.mm.splash.o;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.tinker.loader.app.ApplicationLike;
import java.util.ArrayList;

public final class t
{
  public static h bxn;
  
  public static void a(h paramh, String paramString)
  {
    bxn = paramh;
    i.a(new c()
    {
      public final void a(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        y.printErrStackTrace("WxSplash.WeChatSplash", paramAnonymousThrowable, paramAnonymousString, new Object[0]);
        String str = paramAnonymousString;
        if (paramAnonymousString == null) {
          str = "";
        }
        paramAnonymousThrowable = str + "  " + Log.getStackTraceString(paramAnonymousThrowable);
        i.cte().umH.add(paramAnonymousThrowable);
      }
      
      public final void c(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        y.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void l(Activity paramAnonymousActivity)
      {
        if ((t.bxn != null) && (t.bxn.Ex()))
        {
          paramAnonymousActivity = paramAnonymousActivity.getSharedPreferences("system_config_prefs", 4);
          if (paramAnonymousActivity.getBoolean("first_launch_weixin", true))
          {
            paramAnonymousActivity.edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
          }
        }
      }
    });
    i.a(new b()
    {
      public final boolean aG(Context paramAnonymousContext)
      {
        return com.tencent.mm.g.a.aQ(paramAnonymousContext);
      }
      
      public final boolean aH(Context paramAnonymousContext)
      {
        return com.tencent.mm.g.a.aH(paramAnonymousContext);
      }
      
      public final void aI(Context paramAnonymousContext)
      {
        com.tencent.mm.g.a.aI(paramAnonymousContext);
      }
    });
    i.a(new f()
    {
      public final void cr(String paramAnonymousString)
      {
        com.tencent.mm.blink.a.cr(paramAnonymousString);
      }
      
      public final void tg() {}
      
      public final void th()
      {
        com.tencent.mm.blink.a.fP(1);
      }
    });
    if (paramString == null)
    {
      y.i("WxSplash.WeChatSplash", "splash callback class is null, return.");
      return;
    }
    com.tencent.mm.blink.a.o(paramh.dMU.getApplicationStartMillisTime(), paramh.dMU.getApplicationStartElapsedTime());
    i.aay(ae.cqP());
    i.W(WeChatSplashActivity.class);
    i.X(WeChatSplashFallbackActivity.class);
    n.a(paramh.bT, paramh.dIA, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.t
 * JD-Core Version:    0.7.0.1
 */