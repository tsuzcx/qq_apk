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
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.x.a.a.a;
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
import java.util.ArrayList;
import java.util.List;

public final class c
{
  public static Pair<Integer, Integer> a(final Context paramContext, final String paramString, boolean paramBoolean1, final boolean paramBoolean2, final c.a parama)
  {
    AppMethodBeat.i(151469);
    a.a locala = com.tencent.mm.plugin.x.a.a.eVl();
    int j = locala.eVm();
    boolean bool = locala.eVn();
    final f.a locala1 = new f.a(paramContext);
    Object localObject1 = paramContext.getResources();
    Object localObject3;
    Object localObject2;
    int i;
    if (j == -1)
    {
      locala1.boz(((Resources)localObject1).getString(2131765866));
      localObject3 = ((Resources)localObject1).getString(2131765868);
      localObject2 = ((Resources)localObject1).getString(2131765865);
      locala1.aC((CharSequence)localObject3);
      if (bool)
      {
        localObject3 = (LinearLayout)LayoutInflater.from(paramContext).inflate(2131492977, null);
        TextView localTextView1 = (TextView)((LinearLayout)localObject3).findViewById(2131296711);
        TextView localTextView2 = (TextView)((LinearLayout)localObject3).findViewById(2131302970);
        localTextView1.setText((CharSequence)localObject2);
        localTextView2.setText(2131765863);
        locala1.hu((View)localObject3);
        locala1.apa(2131765862);
        locala1.boB(((Resources)localObject1).getString(2131755316));
        localTextView2.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(151459);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/base/model/ShortcutUtil$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            c.a(this.val$context, false, this.neO, paramString, paramBoolean2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/base/model/ShortcutUtil$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(151459);
          }
        });
        locala1.a(new f.b()
        {
          public final void D(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
          {
            AppMethodBeat.i(151460);
            if (paramAnonymousBoolean1)
            {
              this.pdm.gX(paramContext);
              if (paramBoolean2) {
                h.CyF.a(15783, new Object[] { Integer.valueOf(this.neO), Integer.valueOf(0), paramString });
              }
            }
            for (;;)
            {
              parama.d(paramAnonymousBoolean2, paramString, this.neO);
              AppMethodBeat.o(151460);
              return;
              c.a(locala1, this.neO, paramString, paramBoolean2);
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
      locala1.bow((String)localObject2);
      locala1.apa(2131765863);
      locala1.boB(((Resources)localObject1).getString(2131755316));
      locala1.a(new f.b()
      {
        public final void D(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(151461);
          if (paramAnonymousBoolean1) {
            c.a(this.val$context, false, this.neO, paramString, paramBoolean2);
          }
          for (;;)
          {
            parama.d(paramAnonymousBoolean2, paramString, this.neO);
            AppMethodBeat.o(151461);
            return;
            c.a(locala1, this.neO, paramString, paramBoolean2);
          }
        }
      });
      i = 4;
      continue;
      if (j == 1)
      {
        localObject2 = ((Resources)localObject1).getString(2131765867);
        parama = ((Resources)localObject1).getString(2131765864);
        locala1.boB(((Resources)localObject1).getString(2131755761));
        locala1.aC((CharSequence)localObject2);
        if (bool)
        {
          localObject1 = (LinearLayout)LayoutInflater.from(paramContext).inflate(2131492977, null);
          localObject2 = (TextView)((LinearLayout)localObject1).findViewById(2131296711);
          localObject3 = (TextView)((LinearLayout)localObject1).findViewById(2131302970);
          ((TextView)localObject2).setText(parama);
          ((TextView)localObject3).setText(2131765863);
          locala1.hu((View)localObject1);
          locala1.apa(2131765862);
          ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(151462);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/base/model/ShortcutUtil$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              c.a(this.val$context, false, this.neO, paramString, paramBoolean2);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/base/model/ShortcutUtil$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(151462);
            }
          });
          locala1.a(new f.c()new f.c
          {
            public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(151463);
              c.a(this.pdh, this.neO, paramString, paramBoolean2);
              AppMethodBeat.o(151463);
            }
          }, new f.c()
          {
            public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(151464);
              this.pdm.gX(paramContext);
              if (paramBoolean2) {
                h.CyF.a(15783, new Object[] { Integer.valueOf(this.neO), Integer.valueOf(0), paramString });
              }
              AppMethodBeat.o(151464);
            }
          });
          i = 1;
        }
        else
        {
          locala1.bow(parama);
          locala1.apa(2131765863);
          locala1.boB(((Resources)localObject1).getString(2131755761));
          locala1.a(new f.c()new f.c
          {
            public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(151455);
              c.a(this.pdh, this.neO, paramString, paramBoolean2);
              AppMethodBeat.o(151455);
            }
          }, new f.c()
          {
            public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(151456);
              c.a(this.val$context, false, this.neO, paramString, paramBoolean2);
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
      h.CyF.a(15788, new Object[] { Integer.valueOf(i), Integer.valueOf(0), paramString });
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
      com.tencent.mm.ui.widget.snackbar.b.r((Activity)paramContext, localResources.getString(2131765870));
      if (paramBoolean2)
      {
        h.CyF.a(15787, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(0), paramString });
        AppMethodBeat.o(151470);
      }
    }
    else if ((paramBoolean1) && ((paramInt2 == 2) || (paramInt2 == 4)))
    {
      localResources = paramContext.getResources();
      com.tencent.mm.ui.widget.snackbar.b.a((Activity)paramContext, localResources.getString(2131765870), localResources.getString(2131765863), new a.b()
      {
        public final void bDZ()
        {
          AppMethodBeat.i(151457);
          c.a(this.val$context, true, paramInt2, paramString, paramBoolean2);
          AppMethodBeat.o(151457);
        }
      });
      if (paramBoolean2) {
        h.CyF.a(15787, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(0), paramString });
      }
    }
    AppMethodBeat.o(151470);
  }
  
  public static void a(final Context paramContext, b paramb)
  {
    AppMethodBeat.i(223692);
    Log.i("MicroMsg.ShortcutUtil", "addShortCut()");
    final boolean bool = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("no_more_show_add_short_cut_dialog", false);
    final Pair localPair = a(paramContext, null, bool, false, new c.1(paramContext));
    paramb.cjO();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151458);
        try
        {
          this.pdj.cjP();
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
    AppMethodBeat.o(223692);
  }
  
  public static String aG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(151468);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(151468);
      return null;
    }
    Log.i("MicroMsg.ShortcutUtil", "process name: %s", new Object[] { Util.getProcessNameByPid(MMApplicationContext.getContext(), Process.myPid()) });
    if (paramBoolean) {}
    for (String str = q.getAndroidId();; str = q.dr(true))
    {
      paramString = b.eW(paramString, str);
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
  
  public static String ahb(String paramString)
  {
    AppMethodBeat.i(151465);
    paramString = eX(paramString, q.dr(true));
    AppMethodBeat.o(151465);
    return paramString;
  }
  
  public static void cjL()
  {
    AppMethodBeat.i(223693);
    if (d.oD(25))
    {
      com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class);
      b.a locala = b.a.sos;
      com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
      if (localb.a(locala, com.tencent.mm.util.c.hdh()) == 1)
      {
        Log.i("MicroMsg.ShortcutUtil", "need addShortCuts");
        cjM();
        AppMethodBeat.o(223693);
        return;
      }
      Log.i("MicroMsg.ShortcutUtil", "switch is close , remove all shortcut");
      cjN();
    }
    AppMethodBeat.o(223693);
  }
  
  private static void cjM()
  {
    AppMethodBeat.i(223694);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ShortcutInfo.Builder(MMApplicationContext.getContext(), "launch_type_scan_qrcode").setShortLabel(MMApplicationContext.getContext().getString(2131759428)).setLongLabel(MMApplicationContext.getContext().getString(2131759428)).setIcon(Icon.createWithResource(MMApplicationContext.getContext(), 2131234872)).setIntent(new Intent("com.tencent.mm.action.BIZSHORTCUT").addFlags(67108864).putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_scan_qrcode")).build());
    int i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(-1))).intValue();
    Log.i("MicroMsg.ShortcutUtil", "offline shorcut walletRegion : %s", new Object[] { Integer.valueOf(i) });
    if ((i == 0) || (i == 1) || (i == 8)) {
      localArrayList.add(new ShortcutInfo.Builder(MMApplicationContext.getContext(), "launch_type_offline_wallet").setShortLabel(MMApplicationContext.getContext().getString(2131765861)).setLongLabel(MMApplicationContext.getContext().getString(2131765861)).setIcon(Icon.createWithResource(MMApplicationContext.getContext(), 2131234871)).setIntent(new Intent("com.tencent.mm.action.BIZSHORTCUT").addFlags(67108864).putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_offline_wallet")).build());
    }
    localArrayList.add(new ShortcutInfo.Builder(MMApplicationContext.getContext(), "launch_type_my_qrcode").setShortLabel(MMApplicationContext.getContext().getString(2131765860)).setLongLabel(MMApplicationContext.getContext().getString(2131765860)).setIcon(Icon.createWithResource(MMApplicationContext.getContext(), 2131234870)).setIntent(new Intent("com.tencent.mm.action.BIZSHORTCUT").addFlags(67108864).putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_my_qrcode")).build());
    try
    {
      ShortcutManager localShortcutManager = (ShortcutManager)MMApplicationContext.getContext().getSystemService(ShortcutManager.class);
      localShortcutManager.removeDynamicShortcuts(Util.stringsToList(new String[] { "launch_type_scan_qrcode", "launch_type_offline_wallet", "launch_type_my_qrcode" }));
      localShortcutManager.addDynamicShortcuts(localArrayList);
      AppMethodBeat.o(223694);
      return;
    }
    catch (Exception localException)
    {
      Log.i("MicroMsg.ShortcutUtil", "remove error : %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(223694);
    }
  }
  
  private static void cjN()
  {
    AppMethodBeat.i(223695);
    try
    {
      ((ShortcutManager)MMApplicationContext.getContext().getSystemService(ShortcutManager.class)).removeDynamicShortcuts(Util.stringsToList(new String[] { "launch_type_scan_qrcode", "launch_type_offline_wallet", "launch_type_my_qrcode" }));
      AppMethodBeat.o(223695);
      return;
    }
    catch (Exception localException)
    {
      Log.i("MicroMsg.ShortcutUtil", "remove error : %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(223695);
    }
  }
  
  public static String eX(String paramString1, String paramString2)
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
        paramString1 = b.eW(new String(b.aha(str)), paramString2);
        AppMethodBeat.o(151466);
        return paramString1;
      }
    }
    AppMethodBeat.o(151466);
    return paramString1;
  }
  
  public static String eY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151467);
    paramString1 = com.tencent.mm.b.g.getMessageDigest((com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) + b.eW(paramString2, paramString1)).getBytes());
    AppMethodBeat.o(151467);
    return paramString1;
  }
  
  public static abstract interface b
  {
    public abstract void cjO();
    
    public abstract void cjP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.c
 * JD-Core Version:    0.7.0.1
 */