package com.tencent.mm.plugin.finder.live.ui.at;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.at.g;
import com.tencent.mm.plugin.mvvmlist.a.b;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtGroupMemberDialog;", "Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtSomeoneDialog;", "groupId", "", "context", "Landroid/content/Context;", "forceDarkMode", "", "callback", "Lcom/tencent/mm/plugin/finder/ui/at/AtSomeoneCallback;", "(Ljava/lang/String;Landroid/content/Context;Ljava/lang/Boolean;Lcom/tencent/mm/plugin/finder/ui/at/AtSomeoneCallback;)V", "dataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;", "getDataSource", "()Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "dataSource$delegate", "Lkotlin/Lazy;", "searchDataSource", "Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtGroupSearchDataSource;", "getSearchDataSource", "()Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtGroupSearchDataSource;", "searchDataSource$delegate", "getAtDataSource", "getAtSearchDataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseSearchDataSource;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends c
{
  private final j DHL;
  private final j DHM;
  
  public i(String paramString, Context paramContext, Boolean paramBoolean, com.tencent.mm.plugin.finder.ui.at.a parama)
  {
    super(paramContext, paramBoolean, parama);
    AppMethodBeat.i(371280);
    this.DHL = k.cm((kotlin.g.a.a)new a(paramString));
    this.DHM = k.cm((kotlin.g.a.a)new b(paramString, this));
    AppMethodBeat.o(371280);
  }
  
  public final com.tencent.mm.plugin.mvvmlist.a.a<g> eug()
  {
    AppMethodBeat.i(371282);
    com.tencent.mm.plugin.mvvmlist.a.a locala = (com.tencent.mm.plugin.mvvmlist.a.a)this.DHL.getValue();
    AppMethodBeat.o(371282);
    return locala;
  }
  
  public final b<g, String> euh()
  {
    AppMethodBeat.i(371284);
    b localb = (b)this.DHM.getValue();
    AppMethodBeat.o(371284);
    return localb;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.mvvmlist.a.a<g>>
  {
    a(String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtGroupSearchDataSource;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<FinderLiveAtGroupSearchDataSource>
  {
    b(String paramString, i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.ui.at.i
 * JD-Core Version:    0.7.0.1
 */