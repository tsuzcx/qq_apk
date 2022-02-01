package com.tencent.mm.plugin.finder.ui.at;

import android.content.Context;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.i;
import com.tencent.mm.plugin.finder.utils.at;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneDialog;", "Lcom/tencent/mm/plugin/finder/ui/at/BaseFinderAtSomeoneDialog;", "context", "Landroid/content/Context;", "forceDarkMode", "", "recentAtStorageKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "callback", "Lcom/tencent/mm/plugin/finder/ui/at/AtSomeoneCallback;", "(Landroid/content/Context;Ljava/lang/Boolean;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Lcom/tencent/mm/plugin/finder/ui/at/AtSomeoneCallback;)V", "dataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;", "getDataSource", "()Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "dataSource$delegate", "Lkotlin/Lazy;", "searchDataSource", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneSearchDataSource;", "getSearchDataSource", "()Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneSearchDataSource;", "searchDataSource$delegate", "buildItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "contactToDisplayName", "", "ct", "Lcom/tencent/mm/storage/Contact;", "getAtDataSource", "getAtSearchDataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseSearchDataSource;", "getEmptyViewHeight", "", "getLayoutId", "initContentView", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends b
{
  private final j DHL;
  private final j DHM;
  
  public d(Context paramContext, Boolean paramBoolean, at.a parama, a parama1)
  {
    super(paramContext, paramBoolean, parama1);
    AppMethodBeat.i(347895);
    this.DHL = k.cm((kotlin.g.a.a)new b(parama));
    this.DHM = k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(347895);
  }
  
  public final String ae(au paramau)
  {
    AppMethodBeat.i(347929);
    s.u(paramau, "ct");
    paramau = paramau.aSU();
    s.s(paramau, "ct.displayNick");
    AppMethodBeat.o(347929);
    return paramau;
  }
  
  public final com.tencent.mm.view.recyclerview.g euf()
  {
    AppMethodBeat.i(347944);
    com.tencent.mm.view.recyclerview.g localg = (com.tencent.mm.view.recyclerview.g)new a(this);
    AppMethodBeat.o(347944);
    return localg;
  }
  
  public final com.tencent.mm.plugin.mvvmlist.a.a<g> eug()
  {
    AppMethodBeat.i(347911);
    com.tencent.mm.plugin.mvvmlist.a.a locala = (com.tencent.mm.plugin.mvvmlist.a.a)this.DHL.getValue();
    AppMethodBeat.o(347911);
    return locala;
  }
  
  public final com.tencent.mm.plugin.mvvmlist.a.b<g, String> euh()
  {
    AppMethodBeat.i(347920);
    com.tencent.mm.plugin.mvvmlist.a.b localb = (com.tencent.mm.plugin.mvvmlist.a.b)this.DHM.getValue();
    AppMethodBeat.o(347920);
    return localb;
  }
  
  public final int fcr()
  {
    AppMethodBeat.i(347936);
    at localat = at.GiI;
    int i = (int)(at.getScreenHeight() * 0.25D - bf.getStatusBarHeight(getContext()));
    AppMethodBeat.o(347936);
    return i;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_at_someone_dialog;
  }
  
  public final void initContentView()
  {
    AppMethodBeat.i(347901);
    getDelegate().N(1);
    super.initContentView();
    Window localWindow = getWindow();
    if (localWindow != null) {
      localWindow.setWindowAnimations(e.i.RightToLeftAnimation);
    }
    AppMethodBeat.o(347901);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneDialog$buildItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    a(d paramd) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(347862);
      switch (paramInt)
      {
      case 3: 
      default: 
        localf = (com.tencent.mm.view.recyclerview.f)new f(this.FWq.DHP);
        AppMethodBeat.o(347862);
        return localf;
      case 2: 
        localf = (com.tencent.mm.view.recyclerview.f)new h(this.FWq.DHP);
        AppMethodBeat.o(347862);
        return localf;
      }
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new e(this.FWq.DHP);
      AppMethodBeat.o(347862);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.mvvmlist.a.a<g>>
  {
    b(at.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneSearchDataSource;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<FinderAtSomeoneSearchDataSource>
  {
    c(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.at.d
 * JD-Core Version:    0.7.0.1
 */