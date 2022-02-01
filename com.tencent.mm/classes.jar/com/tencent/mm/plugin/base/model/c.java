package com.tencent.mm.plugin.base.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Process;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.an.a.a;
import com.tencent.mm.plugin.an.a.a.a;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.b;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.util.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  public static Pair<Integer, Integer> a(final Context paramContext, final String paramString, boolean paramBoolean1, final boolean paramBoolean2, final a parama)
  {
    AppMethodBeat.i(151469);
    a.a locala = a.gYg();
    int j = locala.gYh();
    boolean bool = locala.gYi();
    final g.a locala1 = new g.a(paramContext);
    Object localObject1 = paramContext.getResources();
    Object localObject3;
    Object localObject2;
    int i;
    if (j == -1)
    {
      locala1.bDH(((Resources)localObject1).getString(c.h.shortcut_permission_dialog_no_more_notify));
      localObject3 = ((Resources)localObject1).getString(c.h.shortcut_permission_dialog_title_not_know_permission_status);
      localObject2 = ((Resources)localObject1).getString(c.h.shortcut_permission_dialog_msg_unknown_permission_status);
      locala1.bf((CharSequence)localObject3);
      if (bool)
      {
        localObject3 = (LinearLayout)LayoutInflater.from(paramContext).inflate(c.f.add_shortcut_permission_dialog_content_layout, null);
        TextView localTextView1 = (TextView)((LinearLayout)localObject3).findViewById(c.e.alert_msg);
        TextView localTextView2 = (TextView)((LinearLayout)localObject3).findViewById(c.e.know_detail);
        localTextView1.setText((CharSequence)localObject2);
        localTextView2.setText(c.h.shortcut_permission_dialog_know_detail);
        locala1.mg((View)localObject3);
        locala1.aEX(c.h.shortcut_permission_dialog_go_setting);
        locala1.bDJ(((Resources)localObject1).getString(c.h.app_back));
        localTextView2.setOnClickListener(new c.6(paramContext, paramString, paramBoolean2));
        locala1.a(new g.b()
        {
          public final void e(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
          {
            AppMethodBeat.i(268967);
            if (paramAnonymousBoolean1)
            {
              c.this.jJ(paramContext);
              if (paramBoolean2) {
                com.tencent.mm.plugin.report.service.h.OAn.b(15783, new Object[] { Integer.valueOf(this.tkb), Integer.valueOf(0), paramString });
              }
            }
            for (;;)
            {
              parama.c(paramAnonymousBoolean2, paramString, this.tkb);
              AppMethodBeat.o(268967);
              return;
              c.a(locala1, this.tkb, paramString, paramBoolean2);
            }
          }
        });
        i = 2;
      }
    }
    while ((j == 0) || (paramBoolean1))
    {
      paramContext = new Pair(Integer.valueOf(j), Integer.valueOf(i));
      AppMethodBeat.o(151469);
      return paramContext;
      locala1.bDE((String)localObject2);
      locala1.aEX(c.h.shortcut_permission_dialog_know_detail);
      locala1.bDJ(((Resources)localObject1).getString(c.h.app_back));
      locala1.a(new g.b()
      {
        public final void e(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(268955);
          if (paramAnonymousBoolean1) {
            c.a(c.this, false, this.tkb, paramString, paramBoolean2);
          }
          for (;;)
          {
            parama.c(paramAnonymousBoolean2, paramString, this.tkb);
            AppMethodBeat.o(268955);
            return;
            c.a(locala1, this.tkb, paramString, paramBoolean2);
          }
        }
      });
      i = 4;
      continue;
      if (j == 1)
      {
        localObject2 = ((Resources)localObject1).getString(c.h.shortcut_permission_dialog_title_know_permission_status);
        parama = ((Resources)localObject1).getString(c.h.shortcut_permission_dialog_msg_know_permission_status);
        locala1.bDJ(((Resources)localObject1).getString(c.h.app_cancel));
        locala1.bf((CharSequence)localObject2);
        if (bool)
        {
          localObject1 = (LinearLayout)LayoutInflater.from(paramContext).inflate(c.f.add_shortcut_permission_dialog_content_layout, null);
          localObject2 = (TextView)((LinearLayout)localObject1).findViewById(c.e.alert_msg);
          localObject3 = (TextView)((LinearLayout)localObject1).findViewById(c.e.know_detail);
          ((TextView)localObject2).setText(parama);
          ((TextView)localObject3).setText(c.h.shortcut_permission_dialog_know_detail);
          locala1.mg((View)localObject1);
          locala1.aEX(c.h.shortcut_permission_dialog_go_setting);
          ((TextView)localObject3).setOnClickListener(new c.9(paramContext, paramString, paramBoolean2));
          locala1.a(new g.c()new c.11
          {
            public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(151463);
              c.a(c.this, this.tkb, paramString, paramBoolean2);
              AppMethodBeat.o(151463);
            }
          }, new c.11(locala, paramContext, paramBoolean2, paramString));
          i = 1;
        }
        else
        {
          locala1.bDE(parama);
          locala1.aEX(c.h.shortcut_permission_dialog_know_detail);
          locala1.bDJ(((Resources)localObject1).getString(c.h.app_cancel));
          locala1.a(new g.c()new c.3
          {
            public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(151455);
              c.a(c.this, this.tkb, paramString, paramBoolean2);
              AppMethodBeat.o(151455);
            }
          }, new c.3(paramContext, paramString, paramBoolean2));
          i = 3;
        }
      }
      else
      {
        i = -1;
      }
    }
    locala1.show();
    if (paramBoolean2) {
      com.tencent.mm.plugin.report.service.h.OAn.b(15788, new Object[] { Integer.valueOf(i), Integer.valueOf(0), paramString });
    }
    Log.i("MicroMsg.ShortcutUtil", "permissionJumpStatus = ".concat(String.valueOf(i)));
    paramContext = new Pair(Integer.valueOf(j), Integer.valueOf(i));
    AppMethodBeat.o(151469);
    return paramContext;
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AppMethodBeat.i(151470);
    Resources localResources = paramContext.getResources();
    if (paramInt1 == 0)
    {
      com.tencent.mm.ui.widget.snackbar.b.u((Activity)paramContext, localResources.getString(c.h.shortcut_permission_toast_had_add_to_desktop));
      if (paramBoolean2)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(15787, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(0), paramString });
        AppMethodBeat.o(151470);
      }
    }
    else if ((paramBoolean1) && ((paramInt2 == 2) || (paramInt2 == 4)))
    {
      localResources = paramContext.getResources();
      com.tencent.mm.ui.widget.snackbar.b.a((Activity)paramContext, localResources.getString(c.h.shortcut_permission_toast_had_add_to_desktop), localResources.getString(c.h.shortcut_permission_dialog_know_detail), new c.4(paramContext, paramInt2, paramString, paramBoolean2));
      if (paramBoolean2) {
        com.tencent.mm.plugin.report.service.h.OAn.b(15787, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(0), paramString });
      }
    }
    AppMethodBeat.o(151470);
  }
  
  public static void a(final Context paramContext, b paramb)
  {
    AppMethodBeat.i(268973);
    Log.i("MicroMsg.ShortcutUtil", "addShortCut()");
    final boolean bool = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("no_more_show_add_short_cut_dialog", false);
    final Pair localPair = a(paramContext, null, bool, false, new a()
    {
      public final void c(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(151454);
        if (paramAnonymousBoolean) {
          c.this.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("no_more_show_add_short_cut_dialog", true).commit();
        }
        AppMethodBeat.o(151454);
      }
    });
    paramb.cZQ();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151458);
        try
        {
          c.this.cZR();
          c.a(paramContext, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue(), bool, null, false);
          AppMethodBeat.o(151458);
          return;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          Log.w("MicroMsg.ShortcutUtil", localIllegalStateException.toString());
          AppMethodBeat.o(151458);
        }
      }
    });
    AppMethodBeat.o(268973);
  }
  
  public static String aU(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(151468);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(151468);
      return null;
    }
    Log.i("MicroMsg.ShortcutUtil", "process name: %s", new Object[] { Util.getProcessNameByPid(MMApplicationContext.getContext(), Process.myPid()) });
    if (paramBoolean) {}
    for (String str = q.getAndroidId();; str = q.eD(true))
    {
      paramString = b.fB(paramString, str);
      if (!Util.isNullOrNil(paramString)) {
        break;
      }
      AppMethodBeat.o(151468);
      return null;
    }
    paramString = "shortcut_" + b.toHexString(paramString.getBytes());
    AppMethodBeat.o(151468);
    return paramString;
  }
  
  public static String aid(String paramString)
  {
    AppMethodBeat.i(151465);
    paramString = fC(paramString, q.eD(true));
    AppMethodBeat.o(151465);
    return paramString;
  }
  
  public static void cZN()
  {
    AppMethodBeat.i(268988);
    if (d.rb(25))
    {
      i locali = i.agtt;
      if (i.jJz().get())
      {
        Log.i("MicroMsg.ShortcutUtil", "need addShortCuts");
        cZO();
        AppMethodBeat.o(268988);
        return;
      }
      locali = i.agtt;
      i.a(c..ExternalSyntheticLambda0.INSTANCE);
    }
    AppMethodBeat.o(268988);
  }
  
  private static void cZO()
  {
    AppMethodBeat.i(268995);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ShortcutInfo.Builder(MMApplicationContext.getContext(), "launch_type_scan_qrcode").setShortLabel(MMApplicationContext.getContext().getString(c.h.find_friends_by_qrcode)).setLongLabel(MMApplicationContext.getContext().getString(c.h.find_friends_by_qrcode)).setIcon(Icon.createWithResource(MMApplicationContext.getContext(), c.d.shortcut_scan_qrcode)).setIntent(new Intent("com.tencent.mm.ui.ShortCutDispatchAction").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_scan_qrcode")).build());
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNa, Integer.valueOf(-1))).intValue();
    Log.i("MicroMsg.ShortcutUtil", "offline shorcut walletRegion : %s", new Object[] { Integer.valueOf(i) });
    if ((i == 0) || (i == 1) || (i == 8)) {
      localArrayList.add(new ShortcutInfo.Builder(MMApplicationContext.getContext(), "launch_type_offline_wallet").setShortLabel(MMApplicationContext.getContext().getString(c.h.shortcut_offline_wallet)).setLongLabel(MMApplicationContext.getContext().getString(c.h.shortcut_offline_wallet)).setIcon(Icon.createWithResource(MMApplicationContext.getContext(), c.d.shortcut_offline_wallet)).setIntent(new Intent("com.tencent.mm.ui.ShortCutDispatchAction").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_offline_wallet")).build());
    }
    localArrayList.add(new ShortcutInfo.Builder(MMApplicationContext.getContext(), "launch_type_my_qrcode").setShortLabel(MMApplicationContext.getContext().getString(c.h.shortcut_my_qrcode)).setLongLabel(MMApplicationContext.getContext().getString(c.h.shortcut_my_qrcode)).setIcon(Icon.createWithResource(MMApplicationContext.getContext(), c.d.shortcut_my_qrcode)).setIntent(new Intent("com.tencent.mm.ui.ShortCutDispatchAction").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_my_qrcode")).build());
    try
    {
      ShortcutManager localShortcutManager = (ShortcutManager)MMApplicationContext.getContext().getSystemService(ShortcutManager.class);
      Object localObject = localShortcutManager.getPinnedShortcuts();
      if ((localObject != null) && (((List)localObject).size() != 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ShortcutInfo localShortcutInfo = (ShortcutInfo)((Iterator)localObject).next();
          Log.i("MicroMsg.ShortcutUtil", "pinnedShortcut id :" + localShortcutInfo.getId());
          if (localShortcutInfo.getId().equals(MMApplicationContext.getContext().getString(c.h.find_friends_by_qrcode)))
          {
            localObject = fG(MMApplicationContext.getContext());
            b.d(MMApplicationContext.getContext(), (Intent)localObject, false);
          }
        }
      }
      localShortcutManager.removeDynamicShortcuts(Util.stringsToList(new String[] { "launch_type_scan_qrcode", "launch_type_offline_wallet", "launch_type_my_qrcode" }));
      localShortcutManager.addDynamicShortcuts(localArrayList);
      AppMethodBeat.o(268995);
      return;
    }
    catch (Exception localException)
    {
      Log.i("MicroMsg.ShortcutUtil", "remove error : %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(268995);
    }
  }
  
  public static String fC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151466);
    if ((paramString1 == null) || (paramString1.length() <= 0) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(151466);
      return null;
    }
    Log.i("MicroMsg.ShortcutUtil", "process name: %s", new Object[] { Util.getProcessNameByPid(MMApplicationContext.getContext(), Process.myPid()) });
    if ((paramString1.startsWith("shortcut_")) && (paramString1.length() > 9))
    {
      String str = paramString1.substring(9);
      if ((str != null) && (str.length() > 0))
      {
        paramString1 = b.fB(new String(b.aic(str)), paramString2);
        AppMethodBeat.o(151466);
        return paramString1;
      }
    }
    AppMethodBeat.o(151466);
    return paramString1;
  }
  
  public static String fD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151467);
    paramString1 = g.getMessageDigest((g.getMessageDigest(paramString1.getBytes()) + b.fB(paramString2, paramString1)).getBytes());
    AppMethodBeat.o(151467);
    return paramString1;
  }
  
  private static Intent fG(Context paramContext)
  {
    AppMethodBeat.i(269001);
    Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
    localIntent1.putExtra("android.intent.extra.shortcut.NAME", paramContext.getString(c.h.find_friends_by_qrcode));
    localIntent1.putExtra("duplicate", false);
    Intent localIntent2 = new Intent("com.tencent.mm.ui.ShortCutDispatchAction");
    localIntent2.putExtra("LauncherUI.From.Scaner.Shortcut", true);
    localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
    localIntent1.putExtra("shortcut_is_adaptive_icon", true);
    localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramContext, c.d.scan_shortcut_icon));
    localIntent1.putExtra("shortcut_icon_resource_id", c.d.scan_shortcut_icon);
    AppMethodBeat.o(269001);
    return localIntent1;
  }
  
  public static abstract interface a
  {
    public abstract void c(boolean paramBoolean, String paramString, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void cZQ();
    
    public abstract void cZR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.c
 * JD-Core Version:    0.7.0.1
 */