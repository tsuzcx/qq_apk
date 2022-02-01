package com.tencent.mm.plugin.finder.live.ui.at;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.mvvmlist.a.c;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.a.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtSomeoneDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;", "()V", "dbProvider", "Lcom/tencent/mm/kernel/mvvm/MainDBProvider;", "getDbProvider", "()Lcom/tencent/mm/kernel/mvvm/MainDBProvider;", "dbProvider$delegate", "Lkotlin/Lazy;", "memberList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getMemberList", "()Ljava/util/ArrayList;", "setMemberList", "(Ljava/util/ArrayList;)V", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "getPriority", "", "onCreate", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.mvvmlist.a.a<com.tencent.mm.plugin.finder.ui.at.g>
{
  public static final b.a DHH;
  private final j DHI;
  private ArrayList<String> lKN;
  
  static
  {
    AppMethodBeat.i(352281);
    DHH = new b.a((byte)0);
    AppMethodBeat.o(352281);
  }
  
  public b()
  {
    AppMethodBeat.i(352272);
    this.DHI = kotlin.k.cm((kotlin.g.a.a)b.DHJ);
    AppMethodBeat.o(352272);
  }
  
  public final kotlinx.coroutines.b.g<com.tencent.mm.plugin.mvvmlist.a.d<com.tencent.mm.plugin.finder.ui.at.g>> a(LifecycleScope paramLifecycleScope, c<com.tencent.mm.plugin.finder.ui.at.g> paramc)
  {
    AppMethodBeat.i(352314);
    s.u(paramLifecycleScope, "scope");
    s.u(paramc, "request");
    paramLifecycleScope = new com.tencent.mm.plugin.mvvmlist.a.d(paramc);
    q localq = new q();
    Object localObject = this.lKN;
    int j;
    int i;
    if ((localObject != null) && (paramc.offset < ((ArrayList)localObject).size()))
    {
      j = paramc.offset;
      if (((ArrayList)localObject).size() > paramc.offset + paramc.pageSize)
      {
        paramLifecycleScope.ABD = true;
        i = paramc.offset + paramc.pageSize;
        paramc = new ArrayList();
        if (j >= i) {}
      }
    }
    for (;;)
    {
      int k = j + 1;
      paramc.add(((ArrayList)localObject).get(j));
      if (k >= i)
      {
        localObject = com.tencent.mm.plugin.ac.b.MnM;
        paramc = ((Iterable)((com.tencent.mm.plugin.ac.a.a)com.tencent.mm.plugin.ac.b.a.q(com.tencent.mm.plugin.ac.a.a.class)).jh((List)paramc)).iterator();
        for (;;)
        {
          if (paramc.hasNext())
          {
            localObject = (au)paramc.next();
            if ((int)((com.tencent.mm.contact.d)localObject).maN != 0)
            {
              paramLifecycleScope.pUj.add(new com.tencent.mm.plugin.finder.ui.at.g(0, (au)localObject, 3));
              continue;
              i = ((ArrayList)localObject).size();
              break;
            }
          }
        }
        localq.offer(paramLifecycleScope);
        paramLifecycleScope = kotlinx.coroutines.b.k.a((f)localq);
        AppMethodBeat.o(352314);
        return paramLifecycleScope;
      }
      j = k;
    }
  }
  
  public final int getPriority()
  {
    return -1;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(352294);
    this.lKN = new ArrayList();
    Object localObject = ((n)h.ax(n.class)).bzA().jaH();
    if (localObject != null)
    {
      au localau = new au();
      while (((Cursor)localObject).moveToNext())
      {
        localau.convertFrom((Cursor)localObject);
        ArrayList localArrayList = this.lKN;
        if (localArrayList != null) {
          localArrayList.add(localau.field_username);
        }
      }
      ((Cursor)localObject).close();
    }
    localObject = this.lKN;
    s.checkNotNull(localObject);
    ((ArrayList)localObject).remove(z.bAM());
    AppMethodBeat.o(352294);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/kernel/mvvm/MainDBProvider;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.kernel.mvvm.b>
  {
    public static final b DHJ;
    
    static
    {
      AppMethodBeat.i(352355);
      DHJ = new b();
      AppMethodBeat.o(352355);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.ui.at.b
 * JD-Core Version:    0.7.0.1
 */