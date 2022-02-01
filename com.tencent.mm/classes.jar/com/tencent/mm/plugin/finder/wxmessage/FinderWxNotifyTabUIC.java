package com.tencent.mm.plugin.finder.wxmessage;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.e;
import com.tencent.mm.plugin.finder.view.tabcomp.f;
import com.tencent.mm.plugin.finder.view.tabcomp.l;
import com.tencent.mm.plugin.finder.view.tabcomp.n;
import com.tencent.mm.plugin.finder.view.tabcomp.o;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/wxmessage/FinderWxNotifyTabUIC;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderAlignTabUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "onBtnBack", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "unsetRedDot", "Companion", "FinderWxMessageFragment", "FinderWxNotifyTabProvider", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderWxNotifyTabUIC
  extends f
{
  public static final a Hbr;
  
  static
  {
    AppMethodBeat.i(332452);
    Hbr = new a((byte)0);
    AppMethodBeat.o(332452);
  }
  
  public FinderWxNotifyTabUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(332444);
    AppMethodBeat.o(332444);
  }
  
  public final IFinderTabProvider dTN()
  {
    AppMethodBeat.i(332456);
    IFinderTabProvider localIFinderTabProvider = (IFinderTabProvider)new b();
    AppMethodBeat.o(332456);
    return localIFinderTabProvider;
  }
  
  public final void foe()
  {
    AppMethodBeat.i(332467);
    Log.i("Finder.FinderMsgNotifyUIC", "unsetRedDot");
    Object localObject = a.Hbp;
    int k = a.fog().length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      localObject = Vu(i);
      if ((localObject instanceof com.tencent.mm.plugin.finder.viewmodel.notifytab.a)) {
        ((com.tencent.mm.plugin.finder.viewmodel.notifytab.a)localObject).aCK("");
      }
      j += 1;
      i += 1;
    }
    super.foe();
    AppMethodBeat.o(332467);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(332461);
    super.onCreate(paramBundle);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    paramBundle = k.aeZF;
    int i = ((com.tencent.mm.plugin.finder.viewmodel.m)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.m.class)).Va(1);
    ((FinderTabUIC)this).aV(i, false);
    AppMethodBeat.o(332461);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/wxmessage/FinderWxNotifyTabUIC$FinderWxMessageFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class FinderWxMessageFragment
    extends FinderHomeTabFragment
  {
    public static final a Hbs;
    
    static
    {
      AppMethodBeat.i(332432);
      Hbs = new a((byte)0);
      AppMethodBeat.o(332432);
    }
    
    public final Set<Class<? extends UIComponent>> importUIComponents()
    {
      AppMethodBeat.i(332436);
      Set localSet = ar.setOf(a.class);
      AppMethodBeat.o(332436);
      return localSet;
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(332441);
      super.onCreate(paramBundle);
      Log.i("FinderWxMessageFragment", s.X("index:", Integer.valueOf(this.hJx)));
      paramBundle = k.aeZF;
      ((a)k.y((Fragment)this).q(a.class)).index = this.hJx;
      AppMethodBeat.o(332441);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/wxmessage/FinderWxNotifyTabUIC$FinderWxMessageFragment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/wxmessage/FinderWxNotifyTabUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/wxmessage/FinderWxNotifyTabUIC$FinderWxNotifyTabProvider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderAlignTabProvider;", "()V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends e
  {
    public b()
    {
      AppMethodBeat.i(332429);
      FinderWxNotifyTabUIC.FinderWxMessageFragment localFinderWxMessageFragment = new FinderWxNotifyTabUIC.FinderWxMessageFragment();
      localFinderWxMessageFragment.hJx = 0;
      Object localObject = ah.aiuX;
      localObject = new FinderWxNotifyTabUIC.FinderWxMessageFragment();
      ((FinderHomeTabFragment)localObject).hJx = 1;
      ah localah = ah.aiuX;
      setFragments((List)p.al(new FinderWxNotifyTabUIC.FinderWxMessageFragment[] { localFinderWxMessageFragment, localObject }));
      setTabContainer((n)new com.tencent.mm.plugin.finder.viewmodel.notifytab.b());
      setTabs((List)p.al(new b[] { new b(e.h.finder_notify_tab_like), new b(e.h.finder_notify_tab_comment) }));
      setTabViewAction((com.tencent.mm.plugin.finder.view.tabcomp.m)new l());
      this.GJf = ((o)new com.tencent.mm.plugin.finder.view.tabcomp.a((byte)0));
      AppMethodBeat.o(332429);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.wxmessage.FinderWxNotifyTabUIC
 * JD-Core Version:    0.7.0.1
 */