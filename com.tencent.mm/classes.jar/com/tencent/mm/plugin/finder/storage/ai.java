package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.f.i;
import com.tencent.f.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.i.a.ad.a;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.plugin.i.a.m.c;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.tav.decoder.logger.Logger;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderTeenModeConfig;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderTeenModeConfig;", "()V", "dialogRunnable", "Lcom/tencent/threadpool/runnable/FutureEx;", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "canGotoFinderPage", "", "context", "Landroid/content/Context;", "userName", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderTeenModeConfig$OnCanGotoFinderPageCallback;", "getFinderOption", "", "isTeenMode", "", "isTeenModeAndFocus", "isTeenModeAndViewAll", "Companion", "plugin-finder_release"})
public final class ai
  implements ad
{
  public static final a vFj;
  private d<?> dialogRunnable;
  private q loadingDialog;
  
  static
  {
    AppMethodBeat.i(251885);
    vFj = new a((byte)0);
    AppMethodBeat.o(251885);
  }
  
  private static boolean Vt()
  {
    AppMethodBeat.i(251880);
    a locala = g.af(b.class);
    p.g(locala, "MMKernel.service(ITeenModeService::class.java)");
    boolean bool = ((b)locala).Vt();
    AppMethodBeat.o(251880);
    return bool;
  }
  
  private static int dxW()
  {
    AppMethodBeat.i(251881);
    a locala = g.af(b.class);
    p.g(locala, "MMKernel.service(ITeenModeService::class.java)");
    int i = ((b)locala).dxW();
    AppMethodBeat.o(251881);
    return i;
  }
  
  public final void a(final Context paramContext, final String paramString, final ad.a parama)
  {
    AppMethodBeat.i(251884);
    if (paramContext == null)
    {
      Log.w("Finder.FinderTeenModeConfig", "canGotoFinderPage, callback is null.");
      parama.mM(true);
      AppMethodBeat.o(251884);
      return;
    }
    if (!Vt())
    {
      parama.mM(true);
      AppMethodBeat.o(251884);
      return;
    }
    switch (dxW())
    {
    default: 
      if (Util.isNullOrNil(paramString))
      {
        parama.mM(true);
        AppMethodBeat.o(251884);
        return;
      }
      break;
    case 1: 
      parama.mM(true);
      AppMethodBeat.o(251884);
      return;
    case 2: 
      parama.mM(false);
      AppMethodBeat.o(251884);
      return;
    }
    int i = ((m)g.af(m.class)).a(paramString, (m.c)new c(this, paramString, paramContext, parama));
    Logger.i("Finder.FinderTeenModeConfig", "canGotoFinderPage, userName:" + paramString + ", followState:" + i);
    if (i == 1)
    {
      if (this.dialogRunnable != null)
      {
        paramString = this.dialogRunnable;
        if (paramString == null) {
          p.hyc();
        }
        paramString.cancel(false);
        this.dialogRunnable = null;
      }
      this.dialogRunnable = com.tencent.f.h.RTc.n((Runnable)new b(this, paramContext), 1500L);
      AppMethodBeat.o(251884);
      return;
    }
    if (i == 2) {}
    for (boolean bool = true;; bool = false)
    {
      parama.mM(bool);
      AppMethodBeat.o(251884);
      return;
    }
  }
  
  public final boolean dxX()
  {
    AppMethodBeat.i(251882);
    if ((Vt()) && (dxW() == 0))
    {
      AppMethodBeat.o(251882);
      return true;
    }
    AppMethodBeat.o(251882);
    return false;
  }
  
  public final boolean dxY()
  {
    AppMethodBeat.i(251883);
    if ((Vt()) && (dxW() == 1))
    {
      AppMethodBeat.o(251883);
      return true;
    }
    AppMethodBeat.o(251883);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderTeenModeConfig$Companion;", "", "()V", "TAG", "", "checkTeenMode", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderTeenModeConfig$OnCanGotoFinderPageCallback;", "checkTeenModeInFocus", "plugin-finder_release"})
  public static final class a
  {
    public static void a(final Context paramContext, Intent paramIntent, ad.a parama)
    {
      Object localObject2 = null;
      AppMethodBeat.i(251877);
      p.h(paramContext, "context");
      final z.f localf1 = new z.f();
      final z.f localf2;
      if (paramIntent != null)
      {
        localObject1 = Integer.valueOf(paramIntent.getIntExtra("key_finder_teen_mode_scene", 0));
        localf1.SYG = localObject1;
        localf2 = new z.f();
        if (paramIntent == null) {
          break label134;
        }
      }
      final z.f localf3;
      label134:
      for (Object localObject1 = paramIntent.getStringExtra("key_finder_teen_mode_user_name");; localObject1 = null)
      {
        localf2.SYG = localObject1;
        localf3 = new z.f();
        localObject1 = localObject2;
        if (paramIntent != null) {
          localObject1 = paramIntent.getStringExtra("key_finder_teen_mode_user_id");
        }
        localf3.SYG = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localf3.SYG)) {
          break label139;
        }
        parama.mM(true);
        AppMethodBeat.o(251877);
        return;
        localObject1 = null;
        break;
      }
      label139:
      ((ad)g.af(ad.class)).a(paramContext, (String)localf3.SYG, (ad.a)new a(parama, paramContext, localf1, localf3, localf2));
      AppMethodBeat.o(251877);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onDone"})
    static final class a
      implements ad.a
    {
      a(ad.a parama, Context paramContext, z.f paramf1, z.f paramf2, z.f paramf3) {}
      
      public final void mM(boolean paramBoolean)
      {
        AppMethodBeat.i(251876);
        if (paramBoolean)
        {
          locala = this.vFk;
          if (locala != null)
          {
            locala.mM(paramBoolean);
            AppMethodBeat.o(251876);
            return;
          }
          AppMethodBeat.o(251876);
          return;
        }
        ((b)g.af(b.class)).hr(paramContext);
        com.tencent.mm.plugin.report.service.h.CyF.a(20912, new Object[] { Integer.valueOf(3), (Integer)localf1.SYG, (String)localf3.SYG, (String)localf2.SYG });
        ad.a locala = this.vFk;
        if (locala != null)
        {
          locala.mM(paramBoolean);
          AppMethodBeat.o(251876);
          return;
        }
        AppMethodBeat.o(251876);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(ai paramai, Context paramContext) {}
    
    public final void run()
    {
      AppMethodBeat.i(251878);
      ai.a(this.vFo, q.a(paramContext, (CharSequence)paramContext.getString(2131762447), true, 3, null));
      AppMethodBeat.o(251878);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "state", "", "onDone"})
  static final class c
    implements m.c
  {
    c(ai paramai, String paramString, Context paramContext, ad.a parama) {}
    
    public final void yL(int paramInt)
    {
      boolean bool = false;
      AppMethodBeat.i(251879);
      Logger.i("Finder.FinderTeenModeConfig", "canGotoFinderPage#onDone, userName:" + paramString + ", followState:" + paramInt);
      if (ai.a(this.vFo) != null)
      {
        localObject = ai.a(this.vFo);
        if (localObject == null) {
          p.hyc();
        }
        ((d)localObject).cancel(false);
        ai.b(this.vFo);
      }
      if (ai.c(this.vFo) != null)
      {
        localObject = ai.c(this.vFo);
        if (localObject == null) {
          p.hyc();
        }
        ((q)localObject).dismiss();
        ai.a(this.vFo, null);
      }
      if (paramInt == -1)
      {
        u.u(paramContext, paramContext.getString(2131766184), 2131690547);
        AppMethodBeat.o(251879);
        return;
      }
      Object localObject = parama;
      if (paramInt == 2) {
        bool = true;
      }
      ((ad.a)localObject).mM(bool);
      AppMethodBeat.o(251879);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ai
 * JD-Core Version:    0.7.0.1
 */