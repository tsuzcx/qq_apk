package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.b;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.f;
import com.tencent.mm.plugin.appbrand.report.quality.n;
import com.tencent.mm.plugin.appbrand.report.y;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Locale;

public final class i
  extends com.tencent.mm.plugin.appbrand.launching.a
{
  private static long teM = 0L;
  
  public static String a(LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(321025);
    paramLaunchParcel = (String)com.tencent.luggage.sdk.h.d.b(String.format(Locale.ENGLISH, "tryGetAppId(%s, %s)", new Object[] { paramLaunchParcel.username, paramLaunchParcel.appId }), new kotlin.g.a.a() {});
    AppMethodBeat.o(321025);
    return paramLaunchParcel;
  }
  
  static void c(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(47463);
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramIntent.putExtra("extra_from_activity_status_bar_color", paramActivity.getWindow().getStatusBarColor());
        paramIntent.putExtra("extra_from_activity_navigation_bar_color", paramActivity.getWindow().getNavigationBarColor());
      }
      paramIntent.putExtra("extra_from_activity_window_attributes", paramActivity.getWindow().getAttributes());
      AppMethodBeat.o(47463);
      return;
    }
    catch (NullPointerException paramIntent)
    {
      AppMethodBeat.o(47463);
    }
  }
  
  public final boolean b(Context paramContext, LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(47462);
    Object localObject1 = a(paramLaunchParcel);
    String str = f.d(paramLaunchParcel, (String)localObject1);
    f.a(paramLaunchParcel, str, (String)localObject1);
    Object localObject2 = y.tOP;
    y.b(paramLaunchParcel, str);
    if (n.cJm())
    {
      localObject2 = n.tTb;
      n.fn((String)localObject1, str);
      com.tencent.mm.plugin.appbrand.keylogger.c.d(KSProcessWeAppLaunch.class, (String)localObject1);
      com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, (String)localObject1, String.format("Network:%s", new Object[] { NetStatusUtil.getNetTypeString(paramContext) }));
    }
    int i = paramLaunchParcel.euz;
    if ((!Util.isNullOrNil((String)localObject1)) && (i == 0) && (com.tencent.mm.plugin.appbrand.task.i.cJV().C((String)localObject1, i)))
    {
      localObject2 = com.tencent.mm.plugin.appbrand.config.h.ckG().Xo((String)localObject1);
      if ((localObject2 != null) && (((AppBrandInitConfigWC)localObject2).eul == i))
      {
        paramLaunchParcel.f((AppBrandInitConfigLU)localObject2);
        WeAppOpenUICallbackIPCProxy.c.a((AppBrandInitConfigWC)localObject2, paramLaunchParcel);
        ((AppBrandInitConfigWC)localObject2).qYh = paramLaunchParcel.qYh;
        ((AppBrandInitConfigWC)localObject2).qYg = paramLaunchParcel.qYg;
        ((AppBrandInitConfigWC)localObject2).launchMode = paramLaunchParcel.launchMode;
        if (paramLaunchParcel.tdW == null)
        {
          i = 0;
          ((AppBrandInitConfigWC)localObject2).opX = i;
          ((AppBrandInitConfigWC)localObject2).icX = paramLaunchParcel.icX;
          ((AppBrandInitConfigWC)localObject2).qYm = new QualitySession(str, (AppBrandInitConfigWC)localObject2, paramLaunchParcel.siB);
          ((AppBrandInitConfigWC)localObject2).fk(str);
          ((AppBrandInitConfigWC)localObject2).qYm.tSj = false;
          ((AppBrandInitConfigWC)localObject2).qAQ = paramLaunchParcel.qAQ;
          if (paramLaunchParcel.tec == null) {
            break label391;
          }
          ((AppBrandInitConfigWC)localObject2).qYt = ((WeAppOpenDeclarePromptBundle)paramLaunchParcel.tec);
          label266:
          ((AppBrandInitConfigLU)localObject2).epl = false;
          ((AppBrandInitConfigWC)localObject2).qAT = paramLaunchParcel.qAT;
          ((AppBrandInitConfigWC)localObject2).qAX = paramLaunchParcel.qAX;
          ((AppBrandInitConfigWC)localObject2).qYy = paramLaunchParcel.qYy;
          ((AppBrandInitConfigWC)localObject2).qBa = paramLaunchParcel.qBa;
          ((AppBrandInitConfigWC)localObject2).epk = b.iRp();
          ((AppBrandInitConfigWC)localObject2).epi = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
          if (paramLaunchParcel.tdW != null) {
            break label400;
          }
        }
        label391:
        label400:
        for (localObject1 = "";; localObject1 = paramLaunchParcel.tdW.eoY)
        {
          ((AppBrandInitConfigWC)localObject2).eoY = ((String)localObject1);
          k.b(paramContext, (AppBrandInitConfigWC)localObject2, paramLaunchParcel.siB);
          paramContext = y.tOP;
          y.i((AppBrandInitConfigWC)localObject2);
          AppMethodBeat.o(47462);
          return true;
          i = paramLaunchParcel.tdW.opX;
          break;
          ((AppBrandInitConfigWC)localObject2).qYt = null;
          break label266;
        }
      }
    }
    if (Math.abs(System.currentTimeMillis() - teM) < 200L)
    {
      Log.w("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start in 200 ms, just return");
      AppMethodBeat.o(47462);
      return false;
    }
    teM = Util.nowMilliSecond();
    Log.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "[applaunch] start entered %s %d", new Object[] { localObject1, Integer.valueOf(i) });
    boolean bool1;
    if ((paramLaunchParcel.eoV != null) && (4 == paramLaunchParcel.eoV.qYE))
    {
      i = 1;
      boolean bool2 = "wxfe02ecfe70800f46".equalsIgnoreCase((String)localObject1);
      localObject2 = "Token@" + i.class.hashCode() + "#" + System.nanoTime();
      if (bool2) {
        break label818;
      }
      bool1 = true;
      label549:
      if (i != 0) {
        bool1 = false;
      }
      new d(paramContext, (String)localObject2, bool1).a(paramLaunchParcel, str);
      Log.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start we app with username(%s) and appId(%s) and statObj(%s)", new Object[] { paramLaunchParcel.username, localObject1, paramLaunchParcel.siB });
      localObject1 = new Intent(paramContext, AppBrandLaunchProxyUI.class);
      if ((paramContext instanceof Activity)) {
        break label824;
      }
      ((Intent)localObject1).addFlags(268435456);
      label635:
      ((Intent)localObject1).putExtra("extra_from_mm", true);
      ((Intent)localObject1).putExtra("extra_entry_token", (String)localObject2);
      if ((bool2) && (paramLaunchParcel.tdW != null) && (paramLaunchParcel.tdW.eoW != null))
      {
        ((Intent)localObject1).putExtra("extra_launch_weishi_video", true);
        ((Intent)localObject1).putExtra("extra_launch_thumb_url", paramLaunchParcel.tdW.eoW.thumbUrl);
        ((Intent)localObject1).putExtra("extra_launch_thumb_path", paramLaunchParcel.tdW.eoW.qZi);
      }
      if ((!(paramContext instanceof Activity)) || (paramLaunchParcel.qAL < 0)) {
        break label836;
      }
      com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, com.tencent.mm.hellhoundlib.b.c.a(paramLaunchParcel.qAL, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject1).aYi(), "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    }
    for (;;)
    {
      if ((i != 0) && ((paramContext instanceof MMActivity))) {
        ((MMActivity)paramContext).hideAllManagedDialogs();
      }
      AppMethodBeat.o(47462);
      return true;
      i = 0;
      break;
      label818:
      bool1 = false;
      break label549;
      label824:
      c((Intent)localObject1, (Activity)paramContext);
      break label635;
      label836:
      if (paramLaunchParcel.sWl != null)
      {
        int j = ((Intent)localObject1).getFlags();
        try
        {
          ((Intent)localObject1).setFlags(0xEFFFFFFF & j);
          paramLaunchParcel = paramLaunchParcel.sWl;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(paramLaunchParcel, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramLaunchParcel.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramLaunchParcel, "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        catch (Exception paramLaunchParcel)
        {
          ((Intent)localObject1).setFlags(j);
          paramLaunchParcel = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramLaunchParcel.aYi(), "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramLaunchParcel.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      else
      {
        paramLaunchParcel = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramLaunchParcel.aYi(), "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramLaunchParcel.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.i
 * JD-Core Version:    0.7.0.1
 */