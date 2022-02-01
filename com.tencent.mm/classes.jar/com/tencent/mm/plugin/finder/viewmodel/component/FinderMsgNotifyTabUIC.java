package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.viewmodel.notifytab.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderMsgNotifyTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "onBtnBack", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "unsetRedDot", "Companion", "plugin-finder_release"})
public final class FinderMsgNotifyTabUIC
  extends FinderTabUIC
{
  public static final a wyK;
  
  static
  {
    AppMethodBeat.i(255844);
    wyK = new a((byte)0);
    AppMethodBeat.o(255844);
  }
  
  public FinderMsgNotifyTabUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255843);
    AppMethodBeat.o(255843);
  }
  
  public final IFinderTabProvider cXB()
  {
    AppMethodBeat.i(255840);
    IFinderTabProvider localIFinderTabProvider = (IFinderTabProvider)new c();
    AppMethodBeat.o(255840);
    return localIFinderTabProvider;
  }
  
  public final void dIp()
  {
    AppMethodBeat.i(255842);
    Log.i("Finder.FinderMsgNotifyUIC", "unsetRedDot");
    Object localObject = FinderNotifyUIC.wyQ;
    int k = FinderNotifyUIC.dIr().length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      localObject = MI(i);
      if ((localObject instanceof com.tencent.mm.plugin.finder.viewmodel.notifytab.a)) {
        ((com.tencent.mm.plugin.finder.view.tabcomp.a)localObject).by("", false);
      }
      j += 1;
      i += 1;
    }
    super.dIp();
    AppMethodBeat.o(255842);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255841);
    super.onCreate(paramBundle);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.hide();
      AppMethodBeat.o(255841);
      return;
    }
    AppMethodBeat.o(255841);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderMsgNotifyTabUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderMsgNotifyTabUIC
 * JD-Core Version:    0.7.0.1
 */