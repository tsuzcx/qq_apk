package com.tencent.mm.plugin.base.model;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Process;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.y.a.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.snackbar.a.b;

public final class c
{
  public static String Wv(String paramString)
  {
    AppMethodBeat.i(151465);
    paramString = eD(paramString, q.cH(true));
    AppMethodBeat.o(151465);
    return paramString;
  }
  
  public static Pair<Integer, Integer> a(final Context paramContext, final String paramString, boolean paramBoolean1, final boolean paramBoolean2, final a parama)
  {
    AppMethodBeat.i(151469);
    a.a locala = com.tencent.mm.plugin.y.a.a.dPP();
    int j = locala.dPQ();
    boolean bool = locala.dPR();
    final f.a locala1 = new f.a(paramContext);
    Object localObject1 = paramContext.getResources();
    Object localObject3;
    Object localObject2;
    int i;
    if (j == -1)
    {
      locala1.aXR(((Resources)localObject1).getString(2131763675));
      localObject3 = ((Resources)localObject1).getString(2131763677);
      localObject2 = ((Resources)localObject1).getString(2131763674);
      locala1.av((CharSequence)localObject3);
      if (bool)
      {
        localObject3 = (LinearLayout)LayoutInflater.from(paramContext).inflate(2131492944, null);
        TextView localTextView1 = (TextView)((LinearLayout)localObject3).findViewById(2131296634);
        TextView localTextView2 = (TextView)((LinearLayout)localObject3).findViewById(2131301273);
        localTextView1.setText((CharSequence)localObject2);
        localTextView2.setText(2131763672);
        locala1.hb((View)localObject3);
        locala1.afp(2131763671);
        locala1.aXT(((Resources)localObject1).getString(2131755281));
        localTextView2.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(151459);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/base/model/ShortcutUtil$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            c.a(this.val$context, false, this.lSB, paramString, paramBoolean2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/base/model/ShortcutUtil$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(151459);
          }
        });
        locala1.a(new f.b()
        {
          public final void E(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
          {
            AppMethodBeat.i(151460);
            if (paramAnonymousBoolean1)
            {
              this.nMR.gg(paramContext);
              if (paramBoolean2) {
                com.tencent.mm.plugin.report.service.g.yhR.f(15783, new Object[] { Integer.valueOf(this.lSB), Integer.valueOf(0), paramString });
              }
            }
            for (;;)
            {
              parama.d(paramAnonymousBoolean2, paramString, this.lSB);
              AppMethodBeat.o(151460);
              return;
              c.a(locala1, this.lSB, paramString, paramBoolean2);
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
      locala1.aXO((String)localObject2);
      locala1.afp(2131763672);
      locala1.aXT(((Resources)localObject1).getString(2131755281));
      locala1.a(new f.b()
      {
        public final void E(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(151461);
          if (paramAnonymousBoolean1) {
            c.a(this.val$context, false, this.lSB, paramString, paramBoolean2);
          }
          for (;;)
          {
            parama.d(paramAnonymousBoolean2, paramString, this.lSB);
            AppMethodBeat.o(151461);
            return;
            c.a(locala1, this.lSB, paramString, paramBoolean2);
          }
        }
      });
      i = 4;
      continue;
      if (j == 1)
      {
        localObject2 = ((Resources)localObject1).getString(2131763676);
        parama = ((Resources)localObject1).getString(2131763673);
        locala1.aXT(((Resources)localObject1).getString(2131755691));
        locala1.av((CharSequence)localObject2);
        if (bool)
        {
          localObject1 = (LinearLayout)LayoutInflater.from(paramContext).inflate(2131492944, null);
          localObject2 = (TextView)((LinearLayout)localObject1).findViewById(2131296634);
          localObject3 = (TextView)((LinearLayout)localObject1).findViewById(2131301273);
          ((TextView)localObject2).setText(parama);
          ((TextView)localObject3).setText(2131763672);
          locala1.hb((View)localObject1);
          locala1.afp(2131763671);
          ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(151462);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/base/model/ShortcutUtil$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              c.a(this.val$context, false, this.lSB, paramString, paramBoolean2);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/base/model/ShortcutUtil$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(151462);
            }
          });
          locala1.a(new f.c()new f.c
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(151463);
              c.a(this.nMM, this.lSB, paramString, paramBoolean2);
              AppMethodBeat.o(151463);
            }
          }, new f.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(151464);
              this.nMR.gg(paramContext);
              if (paramBoolean2) {
                com.tencent.mm.plugin.report.service.g.yhR.f(15783, new Object[] { Integer.valueOf(this.lSB), Integer.valueOf(0), paramString });
              }
              AppMethodBeat.o(151464);
            }
          });
          i = 1;
        }
        else
        {
          locala1.aXO(parama);
          locala1.afp(2131763672);
          locala1.aXT(((Resources)localObject1).getString(2131755691));
          locala1.a(new f.c()new f.c
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(151455);
              c.a(this.nMM, this.lSB, paramString, paramBoolean2);
              AppMethodBeat.o(151455);
            }
          }, new f.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(151456);
              c.a(this.val$context, false, this.lSB, paramString, paramBoolean2);
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
      com.tencent.mm.plugin.report.service.g.yhR.f(15788, new Object[] { Integer.valueOf(i), Integer.valueOf(0), paramString });
    }
    ad.i("MicroMsg.ShortcutUtil", "permissionJumpStatus = ".concat(String.valueOf(i)));
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
      com.tencent.mm.ui.widget.snackbar.b.n((Activity)paramContext, localResources.getString(2131763679));
      if (paramBoolean2)
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(15787, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(0), paramString });
        AppMethodBeat.o(151470);
      }
    }
    else if ((paramBoolean1) && ((paramInt2 == 2) || (paramInt2 == 4)))
    {
      localResources = paramContext.getResources();
      com.tencent.mm.ui.widget.snackbar.b.a((Activity)paramContext, localResources.getString(2131763679), localResources.getString(2131763672), new a.b()
      {
        public final void bip()
        {
          AppMethodBeat.i(151457);
          c.a(this.val$context, true, paramInt2, paramString, paramBoolean2);
          AppMethodBeat.o(151457);
        }
      });
      if (paramBoolean2) {
        com.tencent.mm.plugin.report.service.g.yhR.f(15787, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(0), paramString });
      }
    }
    AppMethodBeat.o(151470);
  }
  
  public static void a(final Context paramContext, b paramb)
  {
    AppMethodBeat.i(195321);
    ad.i("MicroMsg.ShortcutUtil", "addShortCut()");
    final boolean bool = aj.getContext().getSharedPreferences(aj.fkC(), 0).getBoolean("no_more_show_add_short_cut_dialog", false);
    final Pair localPair = a(paramContext, null, bool, false, new a()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(151454);
        if (paramAnonymousBoolean) {
          this.val$context.getSharedPreferences(aj.fkC(), 0).edit().putBoolean("no_more_show_add_short_cut_dialog", true).commit();
        }
        AppMethodBeat.o(151454);
      }
    });
    paramb.bLX();
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151458);
        try
        {
          this.nMO.bLY();
          c.a(paramContext, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue(), bool, null, false);
          AppMethodBeat.o(151458);
          return;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          ad.w("MicroMsg.ShortcutUtil", localIllegalStateException.toString());
          AppMethodBeat.o(151458);
        }
      }
    });
    AppMethodBeat.o(195321);
  }
  
  public static String aC(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(151468);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(151468);
      return null;
    }
    ad.i("MicroMsg.ShortcutUtil", "process name: %s", new Object[] { bt.getProcessNameByPid(aj.getContext(), Process.myPid()) });
    if (paramBoolean) {}
    for (String str = q.getAndroidId();; str = q.cH(true))
    {
      paramString = b.eC(paramString, str);
      if (!bt.isNullOrNil(paramString)) {
        break;
      }
      AppMethodBeat.o(151468);
      return null;
    }
    paramString = "shortcut_" + b.Z(paramString.getBytes());
    AppMethodBeat.o(151468);
    return paramString;
  }
  
  public static String eD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151466);
    if ((paramString1 == null) || (paramString1.length() <= 0) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(151466);
      return null;
    }
    ad.i("MicroMsg.ShortcutUtil", "process name: %s", new Object[] { bt.getProcessNameByPid(aj.getContext(), Process.myPid()) });
    if ((paramString1.startsWith("shortcut_")) && (paramString1.length() > 9))
    {
      String str = paramString1.substring(9);
      if ((str != null) && (str.length() > 0))
      {
        paramString1 = b.eC(new String(b.Wu(str)), paramString2);
        AppMethodBeat.o(151466);
        return paramString1;
      }
    }
    AppMethodBeat.o(151466);
    return paramString1;
  }
  
  public static String eE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151467);
    paramString1 = com.tencent.mm.b.g.getMessageDigest((com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) + b.eC(paramString2, paramString1)).getBytes());
    AppMethodBeat.o(151467);
    return paramString1;
  }
  
  public static abstract interface a
  {
    public abstract void d(boolean paramBoolean, String paramString, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void bLX();
    
    public abstract void bLY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.c
 * JD-Core Version:    0.7.0.1
 */