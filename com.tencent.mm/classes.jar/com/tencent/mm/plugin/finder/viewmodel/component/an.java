package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.findersdk.e.a;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTeensGuideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "teensGuideDig", "Lcom/tencent/mm/plugin/finder/view/FinderTeensGuideDialog;", "getTeensGuideDig", "()Lcom/tencent/mm/plugin/finder/view/FinderTeensGuideDialog;", "setTeensGuideDig", "(Lcom/tencent/mm/plugin/finder/view/FinderTeensGuideDialog;)V", "checkTeensGuideShowByConfig", "", "checkTeensGuideShowBySwitch", "checkTipsBySwitch", "tipsLocation", "", "flag", "isEnableSwitch", "", "value", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "isValidInt", "", "Companion", "plugin-finder_release"})
public final class an
  extends UIComponent
{
  public static final a BoN;
  public com.tencent.mm.plugin.finder.view.n BoM;
  
  static
  {
    AppMethodBeat.i(277776);
    BoN = new a((byte)0);
    AppMethodBeat.o(277776);
  }
  
  public an(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(277774);
    AppMethodBeat.o(277774);
  }
  
  public an(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(277775);
    AppMethodBeat.o(277775);
  }
  
  private static boolean aGD(String paramString)
  {
    AppMethodBeat.i(277771);
    p.k(paramString, "$this$isValidInt");
    if (kotlin.n.n.bHC(paramString) != null)
    {
      AppMethodBeat.o(277771);
      return true;
    }
    AppMethodBeat.o(277771);
    return false;
  }
  
  private final void ely()
  {
    AppMethodBeat.i(277770);
    Object localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    int j = ((f)localObject).aHp().getInt(ar.a.VEl, 0);
    localObject = getActivity();
    if ((localObject instanceof FinderHomeUI))
    {
      localObject = g.Xox;
      localObject = g.b(getActivity()).i(FinderHomeUIC.class);
      p.j(localObject, "UICProvider.of(activity)…inderHomeUIC::class.java)");
      switch (((FinderHomeUIC)localObject).ekL())
      {
      case 2: 
      default: 
        hq(j, 4);
        AppMethodBeat.o(277770);
        return;
      case 3: 
      case 4: 
        hq(j, 1);
        AppMethodBeat.o(277770);
        return;
      }
      hq(j, 2);
      AppMethodBeat.o(277770);
      return;
    }
    if ((localObject instanceof FinderShareFeedRelUI))
    {
      localObject = getActivity();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI");
        AppMethodBeat.o(277770);
        throw ((Throwable)localObject);
      }
      if (((FinderShareFeedRelUI)localObject).getCommentScene() == 16)
      {
        hq(j, 1);
        AppMethodBeat.o(277770);
        return;
      }
      hq(j, 4);
      AppMethodBeat.o(277770);
      return;
    }
    localObject = a.Bxf;
    if (a.an((Activity)getActivity()))
    {
      localObject = getIntent().getStringExtra("key_context_id");
      if (localObject != null)
      {
        localObject = kotlin.n.n.a((CharSequence)localObject, new char[] { '-' });
        if (localObject != null)
        {
          localObject = (String)((List)localObject).get(0);
          if ((localObject == null) || (!aGD((String)localObject))) {
            break label336;
          }
        }
      }
    }
    label336:
    for (int i = Integer.parseInt((String)localObject);; i = 0)
    {
      if ((i == 23) || (i == 12))
      {
        hq(j, 1);
        AppMethodBeat.o(277770);
        return;
        localObject = null;
        break;
      }
      hq(j, 4);
      AppMethodBeat.o(277770);
      return;
      hq(j, 4);
      AppMethodBeat.o(277770);
      return;
    }
  }
  
  private static boolean hp(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  private final void hq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(277773);
    if (hp(paramInt1, paramInt2))
    {
      long l = System.currentTimeMillis();
      Object localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      ((f)localObject).aHp().set(ar.a.VEm, Long.valueOf(l));
      localObject = this.BoM;
      if (localObject == null) {
        p.bGy("teensGuideDig");
      }
      ((com.tencent.mm.plugin.finder.view.n)localObject).show();
    }
    AppMethodBeat.o(277773);
  }
  
  public final void elx()
  {
    AppMethodBeat.i(277769);
    Object localObject = h.ae(b.class);
    p.j(localObject, "MMKernel.service(ITeenModeService::class.java)");
    boolean bool1 = ((b)localObject).ZM();
    localObject = h.ae(b.class);
    p.j(localObject, "MMKernel.service(ITeenModeService::class.java)");
    boolean bool2 = ((b)localObject).gku();
    localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    long l1 = ((f)localObject).aHp().a(ar.a.VEk, 0L);
    localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    long l2 = ((f)localObject).aHp().a(ar.a.VEm, 0L);
    long l3 = System.currentTimeMillis() - l2;
    Log.i("Finder.FinderTeensGuideUIC", "isTeenMode=" + bool1 + " tipsDuration=" + l1 + " lastime=" + l2 + " timestamps=" + l3 + " isHideTeenMode=" + bool2);
    if ((l1 <= 0L) || (bool1) || (bool2))
    {
      AppMethodBeat.o(277769);
      return;
    }
    if (l3 >= 1000L * l1) {
      ely();
    }
    AppMethodBeat.o(277769);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(277768);
    super.onCreate(paramBundle);
    elx();
    AppMethodBeat.o(277768);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(277767);
    super.onCreateBefore(paramBundle);
    this.BoM = new com.tencent.mm.plugin.finder.view.n((Context)getActivity());
    paramBundle = h.aHG();
    p.j(paramBundle, "MMKernel.storage()");
    paramBundle = paramBundle.aHp().a(ar.a.VEj, getContext().getString(b.j.finder_teens_guide_dialog_tips));
    Object localObject = this.BoM;
    if (localObject == null) {
      p.bGy("teensGuideDig");
    }
    p.j(paramBundle, "tips");
    p.k(paramBundle, "msg");
    ((com.tencent.mm.plugin.finder.view.n)localObject).BaP.setText((CharSequence)paramBundle);
    paramBundle = this.BoM;
    if (paramBundle == null) {
      p.bGy("teensGuideDig");
    }
    localObject = getActivity();
    p.k(localObject, "activity");
    paramBundle.xGq = ((AppCompatActivity)localObject);
    AppMethodBeat.o(277767);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(277772);
    super.onDestroy();
    com.tencent.mm.plugin.finder.view.n localn = this.BoM;
    if (localn == null) {
      p.bGy("teensGuideDig");
    }
    localn.dismiss();
    AppMethodBeat.o(277772);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTeensGuideUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.an
 * JD-Core Version:    0.7.0.1
 */