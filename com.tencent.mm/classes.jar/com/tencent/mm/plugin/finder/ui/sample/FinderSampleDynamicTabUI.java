package com.tencent.mm.plugin.finder.ui.sample;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.g;
import com.tencent.mm.plugin.finder.view.tabcomp.i;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleDynamicTabUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "selectTab", "Companion", "FinderDynamicSampleTabUIC", "FinderDynamicTabProvider", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSampleDynamicTabUI
  extends MMFinderUI
{
  public static final a FXX;
  
  static
  {
    AppMethodBeat.i(347157);
    FXX = new a((byte)0);
    AppMethodBeat.o(347157);
  }
  
  private static final void a(FinderSampleDynamicTabUI paramFinderSampleDynamicTabUI)
  {
    AppMethodBeat.i(347133);
    s.u(paramFinderSampleDynamicTabUI, "this$0");
    Object localObject1 = k.aeZF;
    localObject1 = k.d((AppCompatActivity)paramFinderSampleDynamicTabUI).q(b.class);
    s.s(localObject1, "UICProvider.of(this).get…SampleTabUIC::class.java)");
    localObject1 = (FinderTabUIC)localObject1;
    Object localObject2 = (g)new i("A1");
    Object localObject3 = new FinderSampleTabUI.FinderSampleTabFragment();
    ((FinderHomeTabFragment)localObject3).title = 201;
    ah localah = ah.aiuX;
    FinderTabUIC.a((FinderTabUIC)localObject1, 1, (g)localObject2, (FinderHomeTabFragment)localObject3);
    localObject1 = k.aeZF;
    paramFinderSampleDynamicTabUI = k.d((AppCompatActivity)paramFinderSampleDynamicTabUI).q(b.class);
    s.s(paramFinderSampleDynamicTabUI, "UICProvider.of(this).get…SampleTabUIC::class.java)");
    paramFinderSampleDynamicTabUI = (FinderTabUIC)paramFinderSampleDynamicTabUI;
    localObject1 = (g)new i("A2");
    localObject2 = new FinderSampleTabUI.FinderSampleTabFragment();
    ((FinderHomeTabFragment)localObject2).title = 202;
    localObject3 = ah.aiuX;
    FinderTabUIC.a(paramFinderSampleDynamicTabUI, 2, (g)localObject1, (FinderHomeTabFragment)localObject2);
    AppMethodBeat.o(347133);
  }
  
  private static final void b(FinderSampleDynamicTabUI paramFinderSampleDynamicTabUI)
  {
    AppMethodBeat.i(347144);
    s.u(paramFinderSampleDynamicTabUI, "this$0");
    Object localObject1 = k.aeZF;
    localObject1 = k.d((AppCompatActivity)paramFinderSampleDynamicTabUI).q(b.class);
    s.s(localObject1, "UICProvider.of(this).get…SampleTabUIC::class.java)");
    localObject1 = (FinderTabUIC)localObject1;
    Object localObject2 = (g)new i("B1");
    Object localObject3 = new FinderSampleTabUI.FinderSampleTabFragment();
    ((FinderHomeTabFragment)localObject3).title = 301;
    ah localah = ah.aiuX;
    FinderTabUIC.a((FinderTabUIC)localObject1, (g)localObject2, (FinderHomeTabFragment)localObject3);
    localObject1 = k.aeZF;
    localObject1 = k.d((AppCompatActivity)paramFinderSampleDynamicTabUI).q(b.class);
    s.s(localObject1, "UICProvider.of(this).get…SampleTabUIC::class.java)");
    localObject1 = (FinderTabUIC)localObject1;
    localObject2 = (g)new i("B2");
    localObject3 = new FinderSampleTabUI.FinderSampleTabFragment();
    ((FinderHomeTabFragment)localObject3).title = 302;
    localah = ah.aiuX;
    FinderTabUIC.a((FinderTabUIC)localObject1, (g)localObject2, (FinderHomeTabFragment)localObject3);
    localObject1 = k.aeZF;
    paramFinderSampleDynamicTabUI = k.d((AppCompatActivity)paramFinderSampleDynamicTabUI).q(b.class);
    s.s(paramFinderSampleDynamicTabUI, "UICProvider.of(this).get…SampleTabUIC::class.java)");
    paramFinderSampleDynamicTabUI = (FinderTabUIC)paramFinderSampleDynamicTabUI;
    localObject1 = (g)new i("B3");
    localObject2 = new FinderSampleTabUI.FinderSampleTabFragment();
    ((FinderHomeTabFragment)localObject2).title = 303;
    localObject3 = ah.aiuX;
    FinderTabUIC.a(paramFinderSampleDynamicTabUI, (g)localObject1, (FinderHomeTabFragment)localObject2);
    AppMethodBeat.o(347144);
  }
  
  private static final void c(FinderSampleDynamicTabUI paramFinderSampleDynamicTabUI)
  {
    AppMethodBeat.i(347149);
    s.u(paramFinderSampleDynamicTabUI, "this$0");
    k localk = k.aeZF;
    paramFinderSampleDynamicTabUI = k.d((AppCompatActivity)paramFinderSampleDynamicTabUI).q(b.class);
    s.s(paramFinderSampleDynamicTabUI, "UICProvider.of(this).get…SampleTabUIC::class.java)");
    FinderTabUIC.c((FinderTabUIC)paramFinderSampleDynamicTabUI, 3);
    AppMethodBeat.o(347149);
  }
  
  private static final void d(FinderSampleDynamicTabUI paramFinderSampleDynamicTabUI)
  {
    AppMethodBeat.i(347154);
    s.u(paramFinderSampleDynamicTabUI, "this$0");
    Object localObject = k.aeZF;
    localObject = k.d((AppCompatActivity)paramFinderSampleDynamicTabUI).q(b.class);
    s.s(localObject, "UICProvider.of(this).get…SampleTabUIC::class.java)");
    FinderTabUIC.c((FinderTabUIC)localObject, 0);
    localObject = k.aeZF;
    ((b)k.d((AppCompatActivity)paramFinderSampleDynamicTabUI).q(b.class)).fpj();
    localObject = k.aeZF;
    ((b)k.d((AppCompatActivity)paramFinderSampleDynamicTabUI).q(b.class)).fpj();
    AppMethodBeat.o(347154);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(347186);
    Set localSet = ar.setOf(b.class);
    AppMethodBeat.o(347186);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(347194);
    super.onCreate(paramBundle);
    paramBundle = k.aeZF;
    paramBundle = k.d((AppCompatActivity)this).q(b.class);
    s.s(paramBundle, "UICProvider.of(this).get…SampleTabUIC::class.java)");
    FinderTabUIC.a((FinderTabUIC)paramBundle, 1);
    getContentView().postDelayed(new FinderSampleDynamicTabUI..ExternalSyntheticLambda2(this), 4000L);
    getContentView().postDelayed(new FinderSampleDynamicTabUI..ExternalSyntheticLambda1(this), 10000L);
    getContentView().postDelayed(new FinderSampleDynamicTabUI..ExternalSyntheticLambda3(this), 15000L);
    getContentView().postDelayed(new FinderSampleDynamicTabUI..ExternalSyntheticLambda0(this), 20000L);
    AppMethodBeat.o(347194);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleDynamicTabUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleDynamicTabUI$FinderDynamicSampleTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends FinderTabUIC
  {
    public b(AppCompatActivity paramAppCompatActivity)
    {
      super();
      AppMethodBeat.i(347135);
      Log.i("Finder.FinderTabUIC", "FinderBizTabUIC init cons");
      AppMethodBeat.o(347135);
    }
    
    public final IFinderTabProvider dTN()
    {
      AppMethodBeat.i(347147);
      Log.i("Finder.FinderTabUIC", "FinderBizTabUIC generateProvider");
      IFinderTabProvider localIFinderTabProvider = (IFinderTabProvider)new FinderSampleDynamicTabUI.c();
      AppMethodBeat.o(347147);
      return localIFinderTabProvider;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleDynamicTabUI$FinderDynamicTabProvider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "()V", "isDynamic", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends FinderTabProvider
  {
    public final boolean isDynamic()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.sample.FinderSampleDynamicTabUI
 * JD-Core Version:    0.7.0.1
 */