package com.tencent.mm.plugin.base.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Process;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.am.a.a.a;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.util.i;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  public static Pair<Integer, Integer> a(final Context paramContext, final String paramString, boolean paramBoolean1, final boolean paramBoolean2, final a parama)
  {
    AppMethodBeat.i(151469);
    a.a locala = com.tencent.mm.plugin.am.a.a.fIm();
    int j = locala.fIn();
    boolean bool = locala.fIo();
    final f.a locala1 = new f.a(paramContext);
    Object localObject1 = paramContext.getResources();
    Object localObject3;
    Object localObject2;
    int i;
    if (j == -1)
    {
      locala1.bBo(((Resources)localObject1).getString(c.h.shortcut_permission_dialog_no_more_notify));
      localObject3 = ((Resources)localObject1).getString(c.h.shortcut_permission_dialog_title_not_know_permission_status);
      localObject2 = ((Resources)localObject1).getString(c.h.shortcut_permission_dialog_msg_unknown_permission_status);
      locala1.aR((CharSequence)localObject3);
      if (bool)
      {
        localObject3 = (LinearLayout)LayoutInflater.from(paramContext).inflate(c.f.add_shortcut_permission_dialog_content_layout, null);
        TextView localTextView1 = (TextView)((LinearLayout)localObject3).findViewById(c.e.alert_msg);
        TextView localTextView2 = (TextView)((LinearLayout)localObject3).findViewById(c.e.know_detail);
        localTextView1.setText((CharSequence)localObject2);
        localTextView2.setText(c.h.shortcut_permission_dialog_know_detail);
        locala1.iK((View)localObject3);
        locala1.ayp(c.h.shortcut_permission_dialog_go_setting);
        locala1.bBq(((Resources)localObject1).getString(c.h.app_back));
        localTextView2.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(151459);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/base/model/ShortcutUtil$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            c.a(this.val$context, false, this.qfv, paramString, paramBoolean2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/base/model/ShortcutUtil$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(151459);
          }
        });
        locala1.a(new f.b()
        {
          public final void H(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
          {
            AppMethodBeat.i(151460);
            if (paramAnonymousBoolean1)
            {
              this.sfo.hX(paramContext);
              if (paramBoolean2) {
                com.tencent.mm.plugin.report.service.h.IzE.a(15783, new Object[] { Integer.valueOf(this.qfv), Integer.valueOf(0), paramString });
              }
            }
            for (;;)
            {
              parama.d(paramAnonymousBoolean2, paramString, this.qfv);
              AppMethodBeat.o(151460);
              return;
              c.a(locala1, this.qfv, paramString, paramBoolean2);
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
      locala1.bBl((String)localObject2);
      locala1.ayp(c.h.shortcut_permission_dialog_know_detail);
      locala1.bBq(((Resources)localObject1).getString(c.h.app_back));
      locala1.a(new f.b()
      {
        public final void H(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(151461);
          if (paramAnonymousBoolean1) {
            c.a(this.val$context, false, this.qfv, paramString, paramBoolean2);
          }
          for (;;)
          {
            parama.d(paramAnonymousBoolean2, paramString, this.qfv);
            AppMethodBeat.o(151461);
            return;
            c.a(locala1, this.qfv, paramString, paramBoolean2);
          }
        }
      });
      i = 4;
      continue;
      if (j == 1)
      {
        localObject2 = ((Resources)localObject1).getString(c.h.shortcut_permission_dialog_title_know_permission_status);
        parama = ((Resources)localObject1).getString(c.h.shortcut_permission_dialog_msg_know_permission_status);
        locala1.bBq(((Resources)localObject1).getString(c.h.app_cancel));
        locala1.aR((CharSequence)localObject2);
        if (bool)
        {
          localObject1 = (LinearLayout)LayoutInflater.from(paramContext).inflate(c.f.add_shortcut_permission_dialog_content_layout, null);
          localObject2 = (TextView)((LinearLayout)localObject1).findViewById(c.e.alert_msg);
          localObject3 = (TextView)((LinearLayout)localObject1).findViewById(c.e.know_detail);
          ((TextView)localObject2).setText(parama);
          ((TextView)localObject3).setText(c.h.shortcut_permission_dialog_know_detail);
          locala1.iK((View)localObject1);
          locala1.ayp(c.h.shortcut_permission_dialog_go_setting);
          ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(151462);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/base/model/ShortcutUtil$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              c.a(this.val$context, false, this.qfv, paramString, paramBoolean2);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/base/model/ShortcutUtil$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(151462);
            }
          });
          locala1.a(new f.c()new f.c
          {
            public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(151463);
              c.a(this.sfj, this.qfv, paramString, paramBoolean2);
              AppMethodBeat.o(151463);
            }
          }, new f.c()
          {
            public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(151464);
              this.sfo.hX(paramContext);
              if (paramBoolean2) {
                com.tencent.mm.plugin.report.service.h.IzE.a(15783, new Object[] { Integer.valueOf(this.qfv), Integer.valueOf(0), paramString });
              }
              AppMethodBeat.o(151464);
            }
          });
          i = 1;
        }
        else
        {
          locala1.bBl(parama);
          locala1.ayp(c.h.shortcut_permission_dialog_know_detail);
          locala1.bBq(((Resources)localObject1).getString(c.h.app_cancel));
          locala1.a(new f.c()new f.c
          {
            public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(151455);
              c.a(this.sfj, this.qfv, paramString, paramBoolean2);
              AppMethodBeat.o(151455);
            }
          }, new f.c()
          {
            public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(151456);
              c.a(this.val$context, false, this.qfv, paramString, paramBoolean2);
              AppMethodBeat.o(151456);
            }
          });
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
      com.tencent.mm.plugin.report.service.h.IzE.a(15788, new Object[] { Integer.valueOf(i), Integer.valueOf(0), paramString });
    }
    Log.i("MicroMsg.ShortcutUtil", "permissionJumpStatus = ".concat(String.valueOf(i)));
    paramContext = new Pair(Integer.valueOf(j), Integer.valueOf(i));
    AppMethodBeat.o(151469);
    return paramContext;
  }
  
  public static void a(Context paramContext, int paramInt1, final int paramInt2, boolean paramBoolean1, final String paramString, final boolean paramBoolean2)
  {
    AppMethodBeat.i(151470);
    Resources localResources = paramContext.getResources();
    if (paramInt1 == 0)
    {
      com.tencent.mm.ui.widget.snackbar.b.r((Activity)paramContext, localResources.getString(c.h.shortcut_permission_toast_had_add_to_desktop));
      if (paramBoolean2)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(15787, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(0), paramString });
        AppMethodBeat.o(151470);
      }
    }
    else if ((paramBoolean1) && ((paramInt2 == 2) || (paramInt2 == 4)))
    {
      localResources = paramContext.getResources();
      com.tencent.mm.ui.widget.snackbar.b.a((Activity)paramContext, localResources.getString(c.h.shortcut_permission_toast_had_add_to_desktop), localResources.getString(c.h.shortcut_permission_dialog_know_detail), new a.b()
      {
        public final void bPM()
        {
          AppMethodBeat.i(151457);
          c.a(this.val$context, true, paramInt2, paramString, paramBoolean2);
          AppMethodBeat.o(151457);
        }
      });
      if (paramBoolean2) {
        com.tencent.mm.plugin.report.service.h.IzE.a(15787, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(0), paramString });
      }
    }
    AppMethodBeat.o(151470);
  }
  
  public static void a(final Context paramContext, b paramb)
  {
    AppMethodBeat.i(236230);
    Log.i("MicroMsg.ShortcutUtil", "addShortCut()");
    final boolean bool = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("no_more_show_add_short_cut_dialog", false);
    final Pair localPair = a(paramContext, null, bool, false, new c.1(paramContext));
    paramb.cxf();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151458);
        try
        {
          this.sfl.cxg();
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
    AppMethodBeat.o(236230);
  }
  
  public static String aI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(151468);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(151468);
      return null;
    }
    Log.i("MicroMsg.ShortcutUtil", "process name: %s", new Object[] { Util.getProcessNameByPid(MMApplicationContext.getContext(), Process.myPid()) });
    if (paramBoolean) {}
    for (String str = q.getAndroidId();; str = q.dR(true))
    {
      paramString = b.fk(paramString, str);
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
  
  public static String aoH(String paramString)
  {
    AppMethodBeat.i(151465);
    paramString = fl(paramString, q.dR(true));
    AppMethodBeat.o(151465);
    return paramString;
  }
  
  public static void cxc()
  {
    AppMethodBeat.i(236233);
    if (d.qV(25))
    {
      i locali = i.YyX;
      if (i.ier().get())
      {
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vZR, com.tencent.mm.util.b.a.YxH, 1) == 1)
        {
          Log.i("MicroMsg.ShortcutUtil", "need addShortCuts");
          cxd();
          AppMethodBeat.o(236233);
          return;
        }
        Log.i("MicroMsg.ShortcutUtil", "switch is close , remove all shortcut");
        cxe();
        AppMethodBeat.o(236233);
        return;
      }
      locali = i.YyX;
      i.a(new com.tencent.mm.util.h()
      {
        public final void NO()
        {
          AppMethodBeat.i(216761);
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vZR, com.tencent.mm.util.b.a.YxH, 1) == 1)
          {
            Log.i("MicroMsg.ShortcutUtil", "need addShortCuts");
            c.cxd();
            AppMethodBeat.o(216761);
            return;
          }
          Log.i("MicroMsg.ShortcutUtil", "switch is close , remove all shortcut");
          c.cxe();
          AppMethodBeat.o(216761);
        }
      });
    }
    AppMethodBeat.o(236233);
  }
  
  public static void cxd()
  {
    AppMethodBeat.i(236235);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ShortcutInfo.Builder(MMApplicationContext.getContext(), "launch_type_scan_qrcode").setShortLabel(MMApplicationContext.getContext().getString(c.h.find_friends_by_qrcode)).setLongLabel(MMApplicationContext.getContext().getString(c.h.find_friends_by_qrcode)).setIcon(Icon.createWithResource(MMApplicationContext.getContext(), c.d.shortcut_scan_qrcode)).setIntent(new Intent("com.tencent.mm.action.BIZSHORTCUT").addFlags(67108864).putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_scan_qrcode")).build());
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlG, Integer.valueOf(-1))).intValue();
    Log.i("MicroMsg.ShortcutUtil", "offline shorcut walletRegion : %s", new Object[] { Integer.valueOf(i) });
    if ((i == 0) || (i == 1) || (i == 8)) {
      localArrayList.add(new ShortcutInfo.Builder(MMApplicationContext.getContext(), "launch_type_offline_wallet").setShortLabel(MMApplicationContext.getContext().getString(c.h.shortcut_offline_wallet)).setLongLabel(MMApplicationContext.getContext().getString(c.h.shortcut_offline_wallet)).setIcon(Icon.createWithResource(MMApplicationContext.getContext(), c.d.shortcut_offline_wallet)).setIntent(new Intent("com.tencent.mm.action.BIZSHORTCUT").addFlags(67108864).putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_offline_wallet")).build());
    }
    localArrayList.add(new ShortcutInfo.Builder(MMApplicationContext.getContext(), "launch_type_my_qrcode").setShortLabel(MMApplicationContext.getContext().getString(c.h.shortcut_my_qrcode)).setLongLabel(MMApplicationContext.getContext().getString(c.h.shortcut_my_qrcode)).setIcon(Icon.createWithResource(MMApplicationContext.getContext(), c.d.shortcut_my_qrcode)).setIntent(new Intent("com.tencent.mm.action.BIZSHORTCUT").addFlags(67108864).putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_my_qrcode")).build());
    try
    {
      ShortcutManager localShortcutManager = (ShortcutManager)MMApplicationContext.getContext().getSystemService(ShortcutManager.class);
      localShortcutManager.removeDynamicShortcuts(Util.stringsToList(new String[] { "launch_type_scan_qrcode", "launch_type_offline_wallet", "launch_type_my_qrcode" }));
      localShortcutManager.addDynamicShortcuts(localArrayList);
      AppMethodBeat.o(236235);
      return;
    }
    catch (Exception localException)
    {
      Log.i("MicroMsg.ShortcutUtil", "remove error : %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(236235);
    }
  }
  
  public static void cxe()
  {
    AppMethodBeat.i(236237);
    try
    {
      ((ShortcutManager)MMApplicationContext.getContext().getSystemService(ShortcutManager.class)).removeDynamicShortcuts(Util.stringsToList(new String[] { "launch_type_scan_qrcode", "launch_type_offline_wallet", "launch_type_my_qrcode" }));
      AppMethodBeat.o(236237);
      return;
    }
    catch (Exception localException)
    {
      Log.i("MicroMsg.ShortcutUtil", "remove error : %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(236237);
    }
  }
  
  public static String fl(String paramString1, String paramString2)
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
        paramString1 = b.fk(new String(b.aoG(str)), paramString2);
        AppMethodBeat.o(151466);
        return paramString1;
      }
    }
    AppMethodBeat.o(151466);
    return paramString1;
  }
  
  public static String fm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151467);
    paramString1 = g.getMessageDigest((g.getMessageDigest(paramString1.getBytes()) + b.fk(paramString2, paramString1)).getBytes());
    AppMethodBeat.o(151467);
    return paramString1;
  }
  
  public static abstract interface a
  {
    public abstract void d(boolean paramBoolean, String paramString, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void cxf();
    
    public abstract void cxg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.c
 * JD-Core Version:    0.7.0.1
 */