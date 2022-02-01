package com.tencent.mm.plugin.finder.live.ui.at;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.abv;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.storage.au;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtSomeoneDialog;", "Lcom/tencent/mm/plugin/finder/ui/at/BaseFinderAtSomeoneDialog;", "context", "Landroid/content/Context;", "forceDarkMode", "", "callback", "Lcom/tencent/mm/plugin/finder/ui/at/AtSomeoneCallback;", "(Landroid/content/Context;Ljava/lang/Boolean;Lcom/tencent/mm/plugin/finder/ui/at/AtSomeoneCallback;)V", "dataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;", "getDataSource", "()Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "dataSource$delegate", "Lkotlin/Lazy;", "searchDataSource", "Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtSomeoneSearchDataSource;", "getSearchDataSource", "()Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtSomeoneSearchDataSource;", "searchDataSource$delegate", "buildItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "contactToDisplayName", "", "ct", "Lcom/tencent/mm/storage/Contact;", "getAtDataSource", "getAtSearchDataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseSearchDataSource;", "getLayoutId", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class c
  extends com.tencent.mm.plugin.finder.ui.at.b
{
  public static final c.a DHK;
  private final j DHL;
  private final j DHM;
  
  static
  {
    AppMethodBeat.i(352284);
    DHK = new c.a((byte)0);
    AppMethodBeat.o(352284);
  }
  
  public c(Context paramContext, Boolean paramBoolean, com.tencent.mm.plugin.finder.ui.at.a parama)
  {
    super(paramContext, paramBoolean, parama);
    AppMethodBeat.i(352274);
    this.DHL = k.cm((kotlin.g.a.a)c.DHO);
    this.DHM = k.cm((kotlin.g.a.a)new d(this));
    paramContext = new abv();
    paramContext.ifq.delay = 0L;
    paramContext.publish();
    AppMethodBeat.o(352274);
  }
  
  public final String ae(au paramau)
  {
    AppMethodBeat.i(352334);
    s.u(paramau, "ct");
    if (s.p(paramau.field_username, "notify@all"))
    {
      paramau = getContext().getResources().getString(p.h.Ciz);
      s.s(paramau, "{\n            context.re…og_at_all_item)\n        }");
      AppMethodBeat.o(352334);
      return paramau;
    }
    paramau = paramau.aSU();
    s.s(paramau, "{\n            ct.displayNick\n        }");
    AppMethodBeat.o(352334);
    return paramau;
  }
  
  public final com.tencent.mm.view.recyclerview.g euf()
  {
    AppMethodBeat.i(352296);
    com.tencent.mm.view.recyclerview.g localg = (com.tencent.mm.view.recyclerview.g)new b(this);
    AppMethodBeat.o(352296);
    return localg;
  }
  
  public com.tencent.mm.plugin.mvvmlist.a.a<com.tencent.mm.plugin.finder.ui.at.g> eug()
  {
    AppMethodBeat.i(352315);
    com.tencent.mm.plugin.mvvmlist.a.a locala = (com.tencent.mm.plugin.mvvmlist.a.a)this.DHL.getValue();
    AppMethodBeat.o(352315);
    return locala;
  }
  
  public com.tencent.mm.plugin.mvvmlist.a.b<com.tencent.mm.plugin.finder.ui.at.g, String> euh()
  {
    AppMethodBeat.i(352321);
    com.tencent.mm.plugin.mvvmlist.a.b localb = (com.tencent.mm.plugin.mvvmlist.a.b)this.DHM.getValue();
    AppMethodBeat.o(352321);
    return localb;
  }
  
  public final int getLayoutId()
  {
    return p.f.Cde;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtSomeoneDialog$buildItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.view.recyclerview.g
  {
    b(c paramc) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(352352);
      switch (paramInt)
      {
      case 3: 
      default: 
        localf = (com.tencent.mm.view.recyclerview.f)new e(this.DHN.DHP);
        AppMethodBeat.o(352352);
        return localf;
      case 2: 
        localf = (com.tencent.mm.view.recyclerview.f)new f(this.DHN.DHP);
        AppMethodBeat.o(352352);
        return localf;
      }
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new d(this.DHN.DHP);
      AppMethodBeat.o(352352);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.mvvmlist.a.a<com.tencent.mm.plugin.finder.ui.at.g>>
  {
    public static final c DHO;
    
    static
    {
      AppMethodBeat.i(352336);
      DHO = new c();
      AppMethodBeat.o(352336);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtSomeoneSearchDataSource;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<FinderLiveAtSomeoneSearchDataSource>
  {
    d(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.ui.at.c
 * JD-Core Version:    0.7.0.1
 */