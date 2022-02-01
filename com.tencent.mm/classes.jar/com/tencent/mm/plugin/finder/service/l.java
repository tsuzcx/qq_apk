package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.findersdk.a.bt;
import com.tencent.mm.plugin.findersdk.a.bt.a;
import com.tencent.mm.plugin.findersdk.a.bt.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderSnsKeyWordsService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsKeyWordsService;", "()V", "snsKeyWordsStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSnsKeyWordsStorage;", "getSnsKeyWordsStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSnsKeyWordsStorage;", "snsKeyWordsStorage$delegate", "Lkotlin/Lazy;", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "getKeyWordsDataList", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsKeyWordsService$GetKeyWordsDataCallback;", "removeOnStorageChange", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements bt
{
  public static final a Fzz;
  private final j FzA;
  
  static
  {
    AppMethodBeat.i(330118);
    Fzz = new a((byte)0);
    AppMethodBeat.o(330118);
  }
  
  public l()
  {
    AppMethodBeat.i(330112);
    this.FzA = k.cm((a)b.FzB);
    AppMethodBeat.o(330112);
  }
  
  public final void a(bt.a parama)
  {
    AppMethodBeat.i(330126);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)((an)this.FzA.getValue()).eZt()).iterator();
    while (localIterator.hasNext())
    {
      am localam = (am)localIterator.next();
      bt.b localb = new bt.b(localam.field_localId);
      localb.Hcx = localam.field_jumpScene;
      localb.Hcy = localam.field_jumpDest;
      localb.Hcz = localam.field_startTime;
      localb.endTime = localam.field_endTime;
      localb.oQy = localam.field_keyWord;
      localb.BgC = localam.field_passByInfo;
      localArrayList.add(localb);
    }
    Log.i("FinderSnsKeyWordsService", "dataList " + localArrayList + ", size:" + localArrayList.size());
    parama.onDone((List)localArrayList);
    AppMethodBeat.o(330126);
  }
  
  public final void l(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(330143);
    if (paramIOnStorageChange != null) {
      ((PluginFinder)h.az(PluginFinder.class)).getSnsKeyWordsStorage().remove(paramIOnStorageChange);
    }
    AppMethodBeat.o(330143);
  }
  
  public final void m(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(330133);
    if (paramIOnStorageChange != null) {
      ((PluginFinder)h.az(PluginFinder.class)).getSnsKeyWordsStorage().add(paramIOnStorageChange);
    }
    AppMethodBeat.o(330133);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderSnsKeyWordsService$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSnsKeyWordsStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<an>
  {
    public static final b FzB;
    
    static
    {
      AppMethodBeat.i(330182);
      FzB = new b();
      AppMethodBeat.o(330182);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.l
 * JD-Core Version:    0.7.0.1
 */