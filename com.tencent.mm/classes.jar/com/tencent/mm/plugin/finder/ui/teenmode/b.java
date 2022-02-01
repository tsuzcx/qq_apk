package com.tencent.mm.plugin.finder.ui.teenmode;

import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.plugin.teenmode.a.a.a;
import com.tencent.mm.plugin.teenmode.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/teenmode/FinderLimitAuthorizationFiller;", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller;", "()V", "getBizTypeDesc", "", "context", "Landroid/content/Context;", "handleCurFewByGuard", "", "holder", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller$Holder;", "state", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller$State;", "handleCurFewByWard", "handleLockByGuard", "handleLockByWard", "onFill", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  public final void a(Context paramContext, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(347245);
    s.u(paramContext, "context");
    s.u(paramb, "state");
    if (parama == null)
    {
      AppMethodBeat.o(347245);
      return;
    }
    parama.SYp.setVisibility(8);
    Object localObject1 = (com.tencent.mm.message.a.c)parama.SYk.aK(com.tencent.mm.message.a.c.class);
    boolean bool = z.bAM().equals(parama.SYo);
    Object localObject2 = new StringBuilder("onFill, state:").append(paramb).append(", type:");
    if (localObject1 == null)
    {
      paramContext = null;
      Log.i("FinderLimitAuthorizationFiller", paramContext + ", isWard:" + bool);
      if (localObject1 != null) {
        switch (((com.tencent.mm.message.a.c)localObject1).nVI)
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(347245);
      return;
      paramContext = Integer.valueOf(((com.tencent.mm.message.a.c)localObject1).nVI);
      break;
      if (bool)
      {
        paramContext = com.tencent.mm.plugin.finder.viewmodel.teenmode.c.GWG;
        i = com.tencent.mm.plugin.finder.viewmodel.teenmode.c.fpA() / 60;
        paramContext = new StringBuilder();
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.teenmode.c.GWG;
        paramContext = com.tencent.mm.plugin.finder.viewmodel.teenmode.c.fpB() + ":00";
        localObject1 = new StringBuilder("0");
        localObject2 = com.tencent.mm.plugin.finder.viewmodel.teenmode.c.GWG;
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.teenmode.c.fpC() + ":00";
        localObject2 = parama.mll.getContext();
        switch (a.$EnumSwitchMapping$0[paramb.ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(347245);
          return;
          parama.pmf.setText((CharSequence)((Context)localObject2).getResources().getString(e.h.finder_teen_mode_guardian_curfew_req_ward_subtitle, new Object[] { paramContext, localObject1, Integer.valueOf(i) }));
          AppMethodBeat.o(347245);
          return;
          parama.pmf.setText((CharSequence)((Context)localObject2).getResources().getString(e.h.finder_teen_mode_guardian_req_overtime_subtitle));
          AppMethodBeat.o(347245);
          return;
          parama.pmf.setText((CharSequence)((Context)localObject2).getResources().getString(e.h.finder_teen_mode_guardian_curfew_req_agree_ward_subtitle, new Object[] { paramContext, localObject1, paramContext, Integer.valueOf(i) }));
          AppMethodBeat.o(347245);
          return;
          parama.pmf.setText((CharSequence)((Context)localObject2).getResources().getString(e.h.finder_teen_mode_guardian_curfew_req_agree_expired_ward_subtitle, new Object[] { Integer.valueOf(i) }));
        }
      }
      paramContext = com.tencent.mm.plugin.finder.viewmodel.teenmode.c.GWG;
      int i = com.tencent.mm.plugin.finder.viewmodel.teenmode.c.fpA() / 60;
      paramContext = new StringBuilder();
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.teenmode.c.GWG;
      paramContext = com.tencent.mm.plugin.finder.viewmodel.teenmode.c.fpB() + ":00";
      localObject1 = new StringBuilder("0");
      localObject2 = com.tencent.mm.plugin.finder.viewmodel.teenmode.c.GWG;
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.teenmode.c.fpC() + ":00";
      localObject2 = parama.mll.getContext();
      switch (a.$EnumSwitchMapping$0[paramb.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(347245);
        return;
        parama.mll.setText((CharSequence)((Context)localObject2).getResources().getString(e.h.finder_teen_mode_guardian_req_title));
        parama.pmf.setText((CharSequence)((Context)localObject2).getResources().getString(e.h.finder_teen_mode_guardian_curfew_req_subtitle, new Object[] { paramContext, localObject1, Integer.valueOf(i) }));
        AppMethodBeat.o(347245);
        return;
        parama.pmf.setText((CharSequence)((Context)localObject2).getResources().getString(e.h.finder_teen_mode_guardian_req_overtime_subtitle));
        AppMethodBeat.o(347245);
        return;
        parama.pmf.setText((CharSequence)((Context)localObject2).getResources().getString(e.h.finder_teen_mode_guardian_req_agree_subtitle, new Object[] { Integer.valueOf(i) }));
        AppMethodBeat.o(347245);
        return;
        parama.pmf.setText((CharSequence)((Context)localObject2).getResources().getString(e.h.finder_teen_mode_guardian_curfew_req_agree_expired_subtitle, new Object[] { paramContext, Integer.valueOf(i) }));
      }
      if (bool)
      {
        paramContext = com.tencent.mm.plugin.finder.viewmodel.teenmode.c.GWG;
        i = com.tencent.mm.plugin.finder.viewmodel.teenmode.c.fpA() / 60;
        paramContext = parama.mll.getContext();
        switch (a.$EnumSwitchMapping$0[paramb.ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(347245);
          return;
          parama.pmf.setText((CharSequence)paramContext.getResources().getString(e.h.finder_teen_mode_guardian_lock_req_ward_subtitle, new Object[] { Integer.valueOf(i), Integer.valueOf(i) }));
          AppMethodBeat.o(347245);
          return;
          parama.pmf.setText((CharSequence)paramContext.getResources().getString(e.h.finder_teen_mode_guardian_req_overtime_subtitle));
          AppMethodBeat.o(347245);
          return;
          parama.pmf.setText((CharSequence)paramContext.getResources().getString(e.h.finder_teen_mode_guardian_lock_req_agree_ward_subtitle, new Object[] { Integer.valueOf(i), Integer.valueOf(i) }));
          AppMethodBeat.o(347245);
          return;
          parama.pmf.setText((CharSequence)paramContext.getResources().getString(e.h.finder_teen_mode_guardian_lock_req_agree_expired_ward_subtitle, new Object[] { Integer.valueOf(i) }));
        }
      }
      paramContext = com.tencent.mm.plugin.finder.viewmodel.teenmode.c.GWG;
      i = com.tencent.mm.plugin.finder.viewmodel.teenmode.c.fpA() / 60;
      paramContext = parama.mll.getContext();
      switch (a.$EnumSwitchMapping$0[paramb.ordinal()])
      {
      default: 
        break;
      case 1: 
        parama.mll.setText((CharSequence)paramContext.getResources().getString(e.h.finder_teen_mode_guardian_req_title));
        parama.pmf.setText((CharSequence)paramContext.getResources().getString(e.h.finder_teen_mode_guardian_lock_req_subtitle, new Object[] { Integer.valueOf(i), Integer.valueOf(i) }));
        AppMethodBeat.o(347245);
        return;
      case 2: 
        parama.pmf.setText((CharSequence)paramContext.getResources().getString(e.h.finder_teen_mode_guardian_req_overtime_subtitle));
        AppMethodBeat.o(347245);
        return;
      case 3: 
        parama.pmf.setText((CharSequence)paramContext.getResources().getString(e.h.finder_teen_mode_guardian_req_agree_subtitle, new Object[] { Integer.valueOf(i) }));
        AppMethodBeat.o(347245);
        return;
      case 4: 
        parama.pmf.setText((CharSequence)paramContext.getResources().getString(e.h.finder_teen_mode_guardian_lock_req_agree_expired_subtitle, new Object[] { Integer.valueOf(i) }));
      }
    }
  }
  
  public final String gV(Context paramContext)
  {
    AppMethodBeat.i(347231);
    s.u(paramContext, "context");
    paramContext = paramContext.getString(e.h.finder_title);
    s.s(paramContext, "context.getString(R.string.finder_title)");
    AppMethodBeat.o(347231);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.teenmode.b
 * JD-Core Version:    0.7.0.1
 */