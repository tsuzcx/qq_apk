package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.viewmodel.e;
import com.tencent.mm.plugin.finder.viewmodel.notifytab.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderMsgNotifyTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "onBtnBack", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "unsetRedDot", "Companion", "plugin-finder_release"})
public final class af
  extends FinderTabUIC
{
  public static final a Bmx;
  
  static
  {
    AppMethodBeat.i(272423);
    Bmx = new a((byte)0);
    AppMethodBeat.o(272423);
  }
  
  public af(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(272422);
    AppMethodBeat.o(272422);
  }
  
  public final IFinderTabProvider dmS()
  {
    AppMethodBeat.i(272419);
    IFinderTabProvider localIFinderTabProvider = (IFinderTabProvider)new c();
    AppMethodBeat.o(272419);
    return localIFinderTabProvider;
  }
  
  public final void ekP()
  {
    AppMethodBeat.i(272421);
    Log.i("Finder.FinderMsgNotifyUIC", "unsetRedDot");
    Object localObject = ag.BmD;
    int k = ag.ekR().length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      localObject = Sc(i);
      if ((localObject instanceof com.tencent.mm.plugin.finder.viewmodel.notifytab.a)) {
        ((com.tencent.mm.plugin.finder.view.tabcomp.a)localObject).aGC("");
      }
      j += 1;
      i += 1;
    }
    super.ekP();
    AppMethodBeat.o(272421);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(272420);
    super.onCreate(paramBundle);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    paramBundle = g.Xox;
    aA(((e)g.bD(PluginFinder.class).i(e.class)).eke(), false);
    AppMethodBeat.o(272420);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderMsgNotifyTabUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.af
 * JD-Core Version:    0.7.0.1
 */