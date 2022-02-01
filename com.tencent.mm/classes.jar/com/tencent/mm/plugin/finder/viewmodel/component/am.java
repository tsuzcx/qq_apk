package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.f;
import com.tencent.mm.plugin.finder.viewmodel.g;
import com.tencent.mm.plugin.finder.viewmodel.notifytab.a;
import com.tencent.mm.plugin.finder.viewmodel.notifytab.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderMsgNotifyTabUIC;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderAlignTabUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "onBtnBack", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "unsetRedDot", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am
  extends f
{
  public static final a GSr;
  
  static
  {
    AppMethodBeat.i(338187);
    GSr = new a((byte)0);
    AppMethodBeat.o(338187);
  }
  
  public am(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338176);
    AppMethodBeat.o(338176);
  }
  
  public final IFinderTabProvider dTN()
  {
    AppMethodBeat.i(338197);
    IFinderTabProvider localIFinderTabProvider = (IFinderTabProvider)new c();
    AppMethodBeat.o(338197);
    return localIFinderTabProvider;
  }
  
  public final void foe()
  {
    AppMethodBeat.i(338221);
    Log.i("Finder.FinderMsgNotifyUIC", "unsetRedDot");
    Object localObject = an.GSs;
    int k = an.fog().length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      localObject = Vu(i);
      if ((localObject instanceof a)) {
        ((a)localObject).aCK("");
      }
      j += 1;
      i += 1;
    }
    super.foe();
    AppMethodBeat.o(338221);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(338211);
    super.onCreate(paramBundle);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    paramBundle = k.aeZF;
    int i = ((g)k.cn(PluginFinder.class).q(g.class)).Va(1);
    ((FinderTabUIC)this).aV(i, false);
    AppMethodBeat.o(338211);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderMsgNotifyTabUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.am
 * JD-Core Version:    0.7.0.1
 */