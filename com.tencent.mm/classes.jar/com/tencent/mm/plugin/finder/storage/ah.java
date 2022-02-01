package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.e.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.plugin.findersdk.a.ae.a;
import com.tencent.mm.plugin.findersdk.a.m;
import com.tencent.mm.plugin.findersdk.a.m.c;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.tav.decoder.logger.Logger;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderTeenModeConfig;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderTeenModeConfig;", "()V", "dialogRunnable", "Lcom/tencent/threadpool/runnable/FutureEx;", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "canGotoFinderPage", "", "context", "Landroid/content/Context;", "userName", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderTeenModeConfig$OnCanGotoFinderPageCallback;", "getFinderOption", "", "isTeenMode", "", "isTeenModeAndFocus", "isTeenModeAndViewAll", "isTeenModeAndViewNothing", "Companion", "plugin-finder_release"})
public final class ah
  implements ae
{
  public static final a AmB;
  private d<?> dialogRunnable;
  private s loadingDialog;
  
  static
  {
    AppMethodBeat.i(284239);
    AmB = new a((byte)0);
    AppMethodBeat.o(284239);
  }
  
  private static boolean ZM()
  {
    AppMethodBeat.i(284229);
    a locala = com.tencent.mm.kernel.h.ae(b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    boolean bool = ((b)locala).ZM();
    AppMethodBeat.o(284229);
    return bool;
  }
  
  private static int dYS()
  {
    AppMethodBeat.i(284231);
    a locala = com.tencent.mm.kernel.h.ae(b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    int i = ((b)locala).dYS();
    AppMethodBeat.o(284231);
    return i;
  }
  
  public final void a(final Context paramContext, final String paramString, final ae.a parama)
  {
    AppMethodBeat.i(284238);
    if (paramContext == null)
    {
      Log.w("Finder.FinderTeenModeConfig", "canGotoFinderPage, callback is null.");
      parama.oa(true);
      AppMethodBeat.o(284238);
      return;
    }
    if (!ZM())
    {
      parama.oa(true);
      AppMethodBeat.o(284238);
      return;
    }
    switch (dYS())
    {
    default: 
      if (Util.isNullOrNil(paramString))
      {
        parama.oa(true);
        AppMethodBeat.o(284238);
        return;
      }
      break;
    case 1: 
      parama.oa(true);
      AppMethodBeat.o(284238);
      return;
    case 2: 
      parama.oa(false);
      AppMethodBeat.o(284238);
      return;
    }
    int i = ((m)com.tencent.mm.kernel.h.ae(m.class)).a(paramString, (m.c)new c(this, paramString, paramContext, parama));
    Logger.i("Finder.FinderTeenModeConfig", "canGotoFinderPage, userName:" + paramString + ", followState:" + i);
    if (i == 1)
    {
      if (this.dialogRunnable != null)
      {
        paramString = this.dialogRunnable;
        if (paramString == null) {
          p.iCn();
        }
        paramString.cancel(false);
        this.dialogRunnable = null;
      }
      this.dialogRunnable = com.tencent.e.h.ZvG.n((Runnable)new b(this, paramContext), 1500L);
      AppMethodBeat.o(284238);
      return;
    }
    if (i == 2) {}
    for (boolean bool = true;; bool = false)
    {
      parama.oa(bool);
      AppMethodBeat.o(284238);
      return;
    }
  }
  
  public final boolean dYT()
  {
    AppMethodBeat.i(284233);
    if ((ZM()) && (dYS() == 0))
    {
      AppMethodBeat.o(284233);
      return true;
    }
    AppMethodBeat.o(284233);
    return false;
  }
  
  public final boolean dYU()
  {
    AppMethodBeat.i(284235);
    if ((ZM()) && (dYS() == 1))
    {
      AppMethodBeat.o(284235);
      return true;
    }
    AppMethodBeat.o(284235);
    return false;
  }
  
  public final boolean dYV()
  {
    AppMethodBeat.i(284237);
    if ((ZM()) && (dYS() == 2))
    {
      AppMethodBeat.o(284237);
      return true;
    }
    AppMethodBeat.o(284237);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderTeenModeConfig$Companion;", "", "()V", "TAG", "", "checkTeenMode", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderTeenModeConfig$OnCanGotoFinderPageCallback;", "checkTeenModeInFocus", "plugin-finder_release"})
  public static final class a
  {
    public static void a(Context paramContext, Intent paramIntent, ae.a parama)
    {
      AppMethodBeat.i(271575);
      p.k(paramContext, "context");
      if (paramIntent != null) {}
      for (paramIntent = Integer.valueOf(paramIntent.getIntExtra("key_finder_teen_mode_scene", 0));; paramIntent = null)
      {
        a locala = com.tencent.mm.kernel.h.ae(b.class);
        p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
        if (((b)locala).ZM())
        {
          locala = com.tencent.mm.kernel.h.ae(ae.class);
          p.j(locala, "MMKernel.service(IFinder…enModeConfig::class.java)");
          if (!((ae)locala).dYU()) {
            break;
          }
        }
        parama.oa(true);
        AppMethodBeat.o(271575);
        return;
      }
      ((b)com.tencent.mm.kernel.h.ae(b.class)).ir(paramContext);
      com.tencent.mm.plugin.report.service.h.IzE.a(20912, new Object[] { Integer.valueOf(3), paramIntent, "", "" });
      parama.oa(false);
      AppMethodBeat.o(271575);
    }
    
    public static void b(final Context paramContext, Intent paramIntent, ae.a parama)
    {
      Object localObject2 = null;
      AppMethodBeat.i(271576);
      p.k(paramContext, "context");
      final aa.f localf1 = new aa.f();
      final aa.f localf2;
      if (paramIntent != null)
      {
        localObject1 = Integer.valueOf(paramIntent.getIntExtra("key_finder_teen_mode_scene", 0));
        localf1.aaBC = localObject1;
        localf2 = new aa.f();
        if (paramIntent == null) {
          break label134;
        }
      }
      final aa.f localf3;
      label134:
      for (Object localObject1 = paramIntent.getStringExtra("key_finder_teen_mode_user_name");; localObject1 = null)
      {
        localf2.aaBC = localObject1;
        localf3 = new aa.f();
        localObject1 = localObject2;
        if (paramIntent != null) {
          localObject1 = paramIntent.getStringExtra("key_finder_teen_mode_user_id");
        }
        localf3.aaBC = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localf3.aaBC)) {
          break label139;
        }
        parama.oa(true);
        AppMethodBeat.o(271576);
        return;
        localObject1 = null;
        break;
      }
      label139:
      ((ae)com.tencent.mm.kernel.h.ae(ae.class)).a(paramContext, (String)localf3.aaBC, (ae.a)new a(parama, paramContext, localf1, localf3, localf2));
      AppMethodBeat.o(271576);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "onDone"})
    static final class a
      implements ae.a
    {
      a(ae.a parama, Context paramContext, aa.f paramf1, aa.f paramf2, aa.f paramf3) {}
      
      public final void oa(boolean paramBoolean)
      {
        AppMethodBeat.i(233736);
        if (paramBoolean)
        {
          locala = this.AmC;
          if (locala != null)
          {
            locala.oa(paramBoolean);
            AppMethodBeat.o(233736);
            return;
          }
          AppMethodBeat.o(233736);
          return;
        }
        ((b)com.tencent.mm.kernel.h.ae(b.class)).ir(paramContext);
        com.tencent.mm.plugin.report.service.h.IzE.a(20912, new Object[] { Integer.valueOf(3), (Integer)localf1.aaBC, (String)localf3.aaBC, (String)localf2.aaBC });
        ae.a locala = this.AmC;
        if (locala != null)
        {
          locala.oa(paramBoolean);
          AppMethodBeat.o(233736);
          return;
        }
        AppMethodBeat.o(233736);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(ah paramah, Context paramContext) {}
    
    public final void run()
    {
      AppMethodBeat.i(276866);
      ah.a(this.AmG, s.a(paramContext, (CharSequence)paramContext.getString(b.j.loading_tips_1), true, 3, null));
      AppMethodBeat.o(276866);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "state", "", "onDone"})
  static final class c
    implements m.c
  {
    c(ah paramah, String paramString, Context paramContext, ae.a parama) {}
    
    public final void Ql(int paramInt)
    {
      boolean bool = false;
      AppMethodBeat.i(288209);
      Logger.i("Finder.FinderTeenModeConfig", "canGotoFinderPage#onDone, userName:" + paramString + ", followState:" + paramInt);
      if (ah.a(this.AmG) != null)
      {
        localObject = ah.a(this.AmG);
        if (localObject == null) {
          p.iCn();
        }
        ((d)localObject).cancel(false);
        ah.b(this.AmG);
      }
      if (ah.c(this.AmG) != null)
      {
        localObject = ah.c(this.AmG);
        if (localObject == null) {
          p.iCn();
        }
        ((s)localObject).dismiss();
        ah.a(this.AmG, null);
      }
      if (paramInt == -1)
      {
        w.w(paramContext, paramContext.getString(b.j.sns_request_timeout), b.i.icons_filled_error);
        AppMethodBeat.o(288209);
        return;
      }
      Object localObject = parama;
      if (paramInt == 2) {
        bool = true;
      }
      ((ae.a)localObject).oa(bool);
      AppMethodBeat.o(288209);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ah
 * JD-Core Version:    0.7.0.1
 */