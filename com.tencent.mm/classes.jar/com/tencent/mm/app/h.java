package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.tencent.mm.loader.a.a;
import com.tencent.mm.loader.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.al.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class h
{
  public static String a(Application paramApplication, final String paramString)
  {
    if (!"com.tencent.mm:cuploader".equals(paramString))
    {
      al.a(new al.d()
      {
        public final void a(al paramAnonymousal, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          Application localApplication = this.bws;
          Object localObject1 = paramString;
          try
          {
            StringBuilder localStringBuilder = new StringBuilder(2560);
            StringBuilderPrinter localStringBuilderPrinter = new StringBuilderPrinter(localStringBuilder);
            localStringBuilderPrinter.println("#client.version=" + a.CLIENT_VERSION);
            if (d.DEBUG) {
              localStringBuilderPrinter.println("#accinfo.revision=123321123");
            }
            for (;;)
            {
              Object localObject2 = c.dOS.L("last_login_uin", "0");
              if (localObject2 != null)
              {
                paramAnonymousal = (al)localObject2;
                if (!((String)localObject2).equals("0")) {}
              }
              else
              {
                paramAnonymousal = Integer.toString((Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL).hashCode());
              }
              localStringBuilderPrinter.println("#accinfo.uin=" + paramAnonymousal);
              localObject2 = new StringBuilder("#accinfo.runtime=").append(bk.UY() - b.bvZ).append("(");
              paramAnonymousal = (al)localObject1;
              if (localObject1 == null) {
                paramAnonymousal = "";
              }
              localStringBuilderPrinter.println(paramAnonymousal + ") by cup");
              if (d.DEBUG) {
                localStringBuilderPrinter.println("#accinfo.build=99/88/2077 66:55 PM:amm-dev");
              }
              try
              {
                for (;;)
                {
                  paramAnonymousal = Environment.getDataDirectory();
                  localObject1 = new StatFs(paramAnonymousal.getPath());
                  localObject2 = new StatFs(com.tencent.mm.loader.a.b.bkF);
                  paramAnonymousal = String.format("%dMB %dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)localApplication.getSystemService("activity")).getMemoryClass()), Integer.valueOf(((ActivityManager)localApplication.getSystemService("activity")).getLargeMemoryClass()), paramAnonymousal.getAbsolutePath(), Integer.valueOf(((StatFs)localObject1).getBlockSize()), Integer.valueOf(((StatFs)localObject1).getBlockCount()), Integer.valueOf(((StatFs)localObject1).getAvailableBlocks()), com.tencent.mm.loader.a.b.bkF, Integer.valueOf(((StatFs)localObject2).getBlockSize()), Integer.valueOf(((StatFs)localObject2).getBlockCount()), Integer.valueOf(((StatFs)localObject2).getAvailableBlocks()) });
                  s.b(paramAnonymousThrowable);
                  localStringBuilderPrinter.println("#accinfo.data=" + paramAnonymousal);
                  paramAnonymousal = new Date();
                  paramAnonymousThrowable = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
                  localStringBuilderPrinter.println("#accinfo.crashTime=" + paramAnonymousThrowable.format(paramAnonymousal));
                  localStringBuilderPrinter.println("#crashContent=");
                  paramAnonymousal = paramAnonymousString;
                  if (f.aC(ae.getContext()) == 1) {
                    paramAnonymousal = paramAnonymousString.substring(0, f.aD(ae.getContext()));
                  }
                  f.e(ae.getContext(), ae.getProcessName(), "first");
                  localStringBuilderPrinter.println(paramAnonymousal);
                  y.e("MicroMsg.FirstCrashCatcher", "cpu catch crash:" + paramAnonymousal);
                  paramAnonymousal = new Intent();
                  paramAnonymousal.setAction("INTENT_ACTION_UNCATCH");
                  paramAnonymousal.putExtra("INTENT_EXTRA_USER_NAME", c.dOS.L("login_user_name", "never_login_crash"));
                  paramAnonymousal.putExtra("INTENT_EXTRA_EXCEPTION_MSG", Base64.encodeToString(localStringBuilder.toString().getBytes(), 2));
                  paramAnonymousal.putExtra("INTENT_EXTRA_DATA_PATH", com.tencent.mm.loader.a.b.dOP + "crash/");
                  paramAnonymousal.putExtra("INTENT_EXTRA_SDCARD_PATH", com.tencent.mm.loader.a.b.dOR);
                  paramAnonymousal.putExtra("INTENT_EXTRA_UIN", c.dOS.L("last_login_uin", "0"));
                  paramAnonymousal.putExtra("INTENT_EXTRA_CLIENT_VERSION", a.CLIENT_VERSION);
                  paramAnonymousal.putExtra("INTENT_EXTRA_DEVICE_TYPE", a.dOM);
                  paramAnonymousal.putExtra("INTENT_EXTRA_TAG", "exception");
                  paramAnonymousString = localApplication.getSharedPreferences("system_config_prefs", 0);
                  paramAnonymousal.putExtra("INTENT_EXTRA_HOST", "http://" + paramAnonymousString.getString("support.weixin.qq.com", "support.weixin.qq.com"));
                  paramAnonymousal.setClassName(localApplication, localApplication.getPackageName() + ".crash.CrashUploaderService");
                  ae.getContext().startService(paramAnonymousal);
                  return;
                  localStringBuilderPrinter.println("#accinfo.revision=" + a.EO());
                  break;
                  localStringBuilderPrinter.println("#accinfo.build=" + a.TIME + ":" + a.HOSTNAME + ":0");
                }
              }
              catch (Exception paramAnonymousal)
              {
                for (;;)
                {
                  paramAnonymousal = "";
                }
              }
            }
            return;
          }
          catch (Exception paramAnonymousal) {}
        }
      });
      al.a(new al.a()
      {
        public final void sP()
        {
          String str = a.dON;
        }
      });
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.h
 * JD-Core Version:    0.7.0.1
 */