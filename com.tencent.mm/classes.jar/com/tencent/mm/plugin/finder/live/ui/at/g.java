package com.tencent.mm.plugin.finder.live.ui.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.mvvmlist.a.a;
import com.tencent.mm.plugin.mvvmlist.a.c;
import com.tencent.mm.plugin.mvvmlist.a.d;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.b.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtGroupAllDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;", "groupId", "", "(Ljava/lang/String;)V", "getGroupId", "()Ljava/lang/String;", "memberList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMemberList", "()Ljava/util/ArrayList;", "setMemberList", "(Ljava/util/ArrayList;)V", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "getPriority", "", "onCreate", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a<com.tencent.mm.plugin.finder.ui.at.g>
{
  public static final a akfv;
  private final String groupId;
  private ArrayList<String> lKN;
  
  static
  {
    AppMethodBeat.i(371277);
    akfv = new a((byte)0);
    AppMethodBeat.o(371277);
  }
  
  public g(String paramString)
  {
    AppMethodBeat.i(371275);
    this.groupId = paramString;
    AppMethodBeat.o(371275);
  }
  
  public final kotlinx.coroutines.b.g<d<com.tencent.mm.plugin.finder.ui.at.g>> a(LifecycleScope paramLifecycleScope, c<com.tencent.mm.plugin.finder.ui.at.g> paramc)
  {
    AppMethodBeat.i(371281);
    s.u(paramLifecycleScope, "scope");
    s.u(paramc, "request");
    paramLifecycleScope = new d(paramc);
    q localq = new q();
    ArrayList localArrayList = this.lKN;
    int j;
    int i;
    if ((localArrayList != null) && (paramc.offset < localArrayList.size()))
    {
      j = paramc.offset;
      if (localArrayList.size() <= paramc.offset + paramc.pageSize) {
        break label200;
      }
      i = paramc.offset + paramc.pageSize;
      if (j >= i) {}
    }
    for (;;)
    {
      int k = j + 1;
      paramc = localArrayList.get(j);
      s.s(paramc, "memberList[index]");
      if (s.p((String)paramc, "notify@all"))
      {
        paramc = paramLifecycleScope.pUj;
        au localau = new au();
        localau.setUsername("notify@all");
        ah localah = ah.aiuX;
        paramc.add(new com.tencent.mm.plugin.finder.ui.at.g(-1, localau, 1));
      }
      if (k >= i)
      {
        localq.offer(paramLifecycleScope);
        paramLifecycleScope = k.a((f)localq);
        AppMethodBeat.o(371281);
        return paramLifecycleScope;
        label200:
        i = localArrayList.size();
        break;
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
    AppMethodBeat.i(371278);
    Object localObject = ((b)h.ax(b.class)).bzK().Ju(this.groupId);
    if ((localObject != null) && ((((aj)localObject).Jf(z.bAM())) || (((aj)localObject).bvK(z.bAM()))))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add("notify@all");
      ah localah = ah.aiuX;
      this.lKN = ((ArrayList)localObject);
    }
    AppMethodBeat.o(371278);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtGroupAllDataSource$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.ui.at.g
 * JD-Core Version:    0.7.0.1
 */