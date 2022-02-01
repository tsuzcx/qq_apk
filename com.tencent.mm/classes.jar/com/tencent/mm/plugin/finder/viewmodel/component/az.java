package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI5;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.view.teens.c;
import com.tencent.mm.plugin.findersdk.a.by;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTeensGuideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderTeensGuideUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "teensGuideDig", "Lcom/tencent/mm/plugin/finder/view/teens/ITeensGuideView;", "getTeensGuideDig", "()Lcom/tencent/mm/plugin/finder/view/teens/ITeensGuideView;", "setTeensGuideDig", "(Lcom/tencent/mm/plugin/finder/view/teens/ITeensGuideView;)V", "checkTeensGuideShowByConfig", "", "checkTeensGuideShowBySwitch", "checkTipsBySwitch", "tipsLocation", "", "flag", "getTodayStartTime", "", "getUiStyle", "isCanShowAtFirst", "", "isEnableSwitch", "value", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "isValidInt", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class az
  extends UIComponent
  implements by
{
  public static final a GVr;
  public c GVs;
  
  static
  {
    AppMethodBeat.i(338074);
    GVr = new a((byte)0);
    AppMethodBeat.o(338074);
  }
  
  public az(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338017);
    AppMethodBeat.o(338017);
  }
  
  public az(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(338023);
    AppMethodBeat.o(338023);
  }
  
  private void a(c paramc)
  {
    AppMethodBeat.i(338012);
    s.u(paramc, "<set-?>");
    this.GVs = paramc;
    AppMethodBeat.o(338012);
  }
  
  private static boolean aCR(String paramString)
  {
    AppMethodBeat.i(338044);
    s.u(paramString, "<this>");
    if (n.bJF(paramString) != null)
    {
      AppMethodBeat.o(338044);
      return true;
    }
    AppMethodBeat.o(338044);
    return false;
  }
  
  private c fpl()
  {
    AppMethodBeat.i(338007);
    c localc = this.GVs;
    if (localc != null)
    {
      AppMethodBeat.o(338007);
      return localc;
    }
    s.bIx("teensGuideDig");
    AppMethodBeat.o(338007);
    return null;
  }
  
  private final void fpn()
  {
    AppMethodBeat.i(338038);
    int j = h.baE().ban().getInt(at.a.adhG, 0);
    Object localObject = getActivity();
    if ((localObject instanceof OccupyFinderUI5))
    {
      iM(j, 2);
      AppMethodBeat.o(338038);
      return;
    }
    if ((localObject instanceof FinderHomeUI))
    {
      localObject = k.aeZF;
      localObject = k.d(getActivity()).q(FinderHomeUIC.class);
      s.s(localObject, "UICProvider.of(activity)…inderHomeUIC::class.java)");
      switch (((FinderHomeUIC)localObject).fnX())
      {
      case 2: 
      default: 
        iM(j, 4);
        AppMethodBeat.o(338038);
        return;
      case 3: 
      case 4: 
        iM(j, 1);
        AppMethodBeat.o(338038);
        return;
      }
      iM(j, 2);
      AppMethodBeat.o(338038);
      return;
    }
    if ((localObject instanceof FinderShareFeedRelUI))
    {
      if (((FinderShareFeedRelUI)getActivity()).getCommentScene() == 16)
      {
        iM(j, 1);
        AppMethodBeat.o(338038);
        return;
      }
      iM(j, 4);
      AppMethodBeat.o(338038);
      return;
    }
    localObject = com.tencent.mm.plugin.findersdk.e.a.HdV;
    if (com.tencent.mm.plugin.findersdk.e.a.ay((Activity)getActivity()))
    {
      localObject = getIntent().getStringExtra("key_context_id");
      if (localObject == null)
      {
        localObject = null;
        if ((localObject == null) || (!aCR((String)localObject))) {
          break label413;
        }
      }
    }
    label401:
    label413:
    for (int i = Integer.parseInt((String)localObject);; i = 0) {
      switch (i)
      {
      default: 
        iM(j, 4);
        AppMethodBeat.o(338038);
        return;
        localObject = n.a((CharSequence)localObject, new char[] { '-' }, 0, 6);
        if (localObject == null)
        {
          localObject = null;
          break;
        }
        localObject = (String)((List)localObject).get(0);
        break;
      case 12: 
      case 23: 
        iM(j, 1);
        AppMethodBeat.o(338038);
        return;
        localObject = com.tencent.mm.plugin.findersdk.e.b.HeH;
        if (!com.tencent.mm.plugin.findersdk.e.b.aD((Activity)getActivity()))
        {
          localObject = com.tencent.mm.plugin.findersdk.e.b.HeH;
          if (!com.tencent.mm.plugin.findersdk.e.b.aE((Activity)getActivity()))
          {
            localObject = com.tencent.mm.plugin.findersdk.e.b.HeH;
            if (!com.tencent.mm.plugin.findersdk.e.b.aF((Activity)getActivity())) {
              break label401;
            }
          }
        }
        iM(j, 1);
        AppMethodBeat.o(338038);
        return;
        iM(j, 4);
        AppMethodBeat.o(338038);
        return;
      }
    }
  }
  
  private static long fpo()
  {
    AppMethodBeat.i(338052);
    Calendar localCalendar = Calendar.getInstance();
    s.s(localCalendar, "getInstance()");
    localCalendar.setTimeInMillis(System.currentTimeMillis());
    localCalendar.set(11, 0);
    localCalendar.set(13, 0);
    localCalendar.set(12, 0);
    localCalendar.set(14, 0);
    long l = localCalendar.getTimeInMillis();
    AppMethodBeat.o(338052);
    return l;
  }
  
  private static boolean iL(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  private final void iM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(338065);
    if (iL(paramInt1, paramInt2))
    {
      h.baE().ban().set(at.a.adhI, Long.valueOf(System.currentTimeMillis()));
      fpl().fmH();
    }
    AppMethodBeat.o(338065);
  }
  
  public final void fpm()
  {
    AppMethodBeat.i(338104);
    boolean bool1 = ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
    boolean bool2 = ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEt();
    long l1 = h.baE().ban().a(at.a.adhI, 0L);
    long l2 = fpo();
    Log.i("Finder.FinderTeensGuideUIC", "isTeenMode=" + bool1 + " lastime=" + l1 + " todayStartTime=" + l2 + " isHideTeenMode=" + bool2);
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(338104);
      return;
    }
    if (l2 >= l1)
    {
      fpn();
      AppMethodBeat.o(338104);
      return;
    }
    h.baE().ban().set(at.a.adhI, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(338104);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(338094);
    super.onCreateAfter(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eXj().bmg()).intValue() == 1) {}
    for (int i = 1;; i = 0)
    {
      paramBundle = com.tencent.mm.plugin.findersdk.e.b.HeH;
      if (!com.tencent.mm.plugin.findersdk.e.b.aE((Activity)getActivity()))
      {
        paramBundle = com.tencent.mm.plugin.findersdk.e.b.HeH;
        if (!com.tencent.mm.plugin.findersdk.e.b.aD((Activity)getActivity()))
        {
          paramBundle = OccupyFinderUI5.Bth;
          if ((!OccupyFinderUI5.egg()) && ((!(getActivity() instanceof FinderHomeUI)) || (i == 0)))
          {
            paramBundle = com.tencent.mm.plugin.findersdk.e.a.HdV;
            if ((!com.tencent.mm.plugin.findersdk.e.a.ay((Activity)getActivity())) || (i == 0)) {
              break label126;
            }
          }
        }
      }
      i = j;
      if ((getActivity() instanceof OccupyFinderUI5)) {
        label126:
        i = 1;
      }
      if (i != 0) {
        fpm();
      }
      AppMethodBeat.o(338094);
      return;
    }
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(338084);
    super.onCreateBefore(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
    int i;
    switch (((Number)com.tencent.mm.plugin.finder.storage.d.eXi().bmg()).intValue())
    {
    default: 
      i = 0;
      paramBundle = h.baE().ban().b(at.a.adhE, getContext().getString(e.h.finder_teens_guide_dialog_tips));
      Log.i("Finder.FinderTeensGuideUIC", "uiStyle=" + i + " tips=" + paramBundle);
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      c localc = fpl();
      s.s(paramBundle, "tips");
      localc.aCL(paramBundle);
      AppMethodBeat.o(338084);
      return;
      i = h.baE().ban().getInt(at.a.adhH, 0);
      break;
      i = 0;
      break;
      i = 1;
      break;
      a((c)new com.tencent.mm.plugin.finder.view.teens.b((Activity)getActivity()));
      continue;
      a((c)new com.tencent.mm.plugin.finder.view.teens.a((Activity)getActivity()));
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338110);
    super.onDestroy();
    fpl().fmI();
    AppMethodBeat.o(338110);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTeensGuideUIC$Companion;", "", "()V", "TAG", "", "UI_STYLE_BOTTOM", "", "UI_STYLE_CENTER", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.az
 * JD-Core Version:    0.7.0.1
 */