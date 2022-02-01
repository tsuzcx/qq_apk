package com.tencent.mm.plugin.finder.ui.at;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ac.b;
import com.tencent.mm.plugin.ac.b.a;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.mvvmlist.a.c;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.a.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/at/FinderRecentAtDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;", "storageKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "getStorageKey", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "usernameList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getUsernameList", "()Ljava/util/ArrayList;", "setUsernameList", "(Ljava/util/ArrayList;)V", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "getPriority", "", "onCreate", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends com.tencent.mm.plugin.mvvmlist.a.a<g>
{
  public static final i.a FWD;
  private final at.a FWE;
  private ArrayList<String> pJO;
  
  static
  {
    AppMethodBeat.i(347931);
    FWD = new i.a((byte)0);
    AppMethodBeat.o(347931);
  }
  
  public i(at.a parama)
  {
    AppMethodBeat.i(347923);
    this.FWE = parama;
    AppMethodBeat.o(347923);
  }
  
  public final kotlinx.coroutines.b.g<com.tencent.mm.plugin.mvvmlist.a.d<g>> a(LifecycleScope paramLifecycleScope, c<g> paramc)
  {
    AppMethodBeat.i(347954);
    s.u(paramLifecycleScope, "scope");
    s.u(paramc, "request");
    paramLifecycleScope = new com.tencent.mm.plugin.mvvmlist.a.d(paramc);
    q localq = new q();
    Object localObject1 = this.pJO;
    int j;
    int i;
    if ((localObject1 != null) && (paramc.offset < ((ArrayList)localObject1).size()))
    {
      j = paramc.offset;
      if (((ArrayList)localObject1).size() > paramc.offset + paramc.pageSize)
      {
        i = paramc.offset + paramc.pageSize;
        localObject1 = new ArrayList();
        paramc = this.pJO;
        if (paramc == null) {
          break label273;
        }
        if (j >= i) {}
      }
    }
    for (;;)
    {
      int k = j + 1;
      ((ArrayList)localObject1).add(paramc.get(j));
      if (k >= i)
      {
        localObject1 = b.MnM;
        paramc = ((Iterable)((com.tencent.mm.plugin.ac.a.a)b.a.q(com.tencent.mm.plugin.ac.a.a.class)).jh((List)paramc)).iterator();
        for (;;)
        {
          if (paramc.hasNext())
          {
            Object localObject2 = (au)paramc.next();
            if ((int)((com.tencent.mm.contact.d)localObject2).maN != 0)
            {
              localObject1 = paramLifecycleScope.pUj;
              localObject2 = new g(-1, (au)localObject2, 0);
              Object localObject3 = MMApplicationContext.getContext().getString(e.h.finder_at_someone_recent_at);
              s.s(localObject3, "getContext().getString(R…der_at_someone_recent_at)");
              s.u(localObject3, "<set-?>");
              ((g)localObject2).FWw = ((String)localObject3);
              localObject3 = ah.aiuX;
              ((ArrayList)localObject1).add(localObject2);
              continue;
              i = ((ArrayList)localObject1).size();
              break;
            }
          }
        }
        label273:
        localq.offer(paramLifecycleScope);
        paramLifecycleScope = kotlinx.coroutines.b.k.a((f)localq);
        AppMethodBeat.o(347954);
        return paramLifecycleScope;
      }
      j = k;
    }
  }
  
  public final int getPriority()
  {
    return 0;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(347939);
    this.pJO = new ArrayList();
    Object localObject1 = k.FWG;
    localObject1 = this.FWE;
    s.u(localObject1, "key");
    Object localObject2 = k.aBf(k.h((at.a)localObject1));
    localObject1 = z.bAM();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      j localj = (j)((Iterator)localObject2).next();
      if (!s.p(localj.name, localObject1))
      {
        ArrayList localArrayList = this.pJO;
        if (localArrayList != null) {
          localArrayList.add(localj.name);
        }
      }
    }
    AppMethodBeat.o(347939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.at.i
 * JD-Core Version:    0.7.0.1
 */