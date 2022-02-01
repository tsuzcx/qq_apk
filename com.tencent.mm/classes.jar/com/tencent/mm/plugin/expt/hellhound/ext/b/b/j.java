package com.tencent.mm.plugin.expt.hellhound.ext.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLEndCallback;", "", "mRLCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;)V", "mMethodMap", "Ljava/util/HashMap;", "", "", "Landroid/util/Pair;", "getMRLCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "mRefeshLoadMoreListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLEndCallback$mRefeshLoadMoreListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLEndCallback$mRefeshLoadMoreListener$1;", "startMonitor", "", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j.a zHM;
  final HashMap<String, List<Pair<String, String>>> zGg;
  final m zHN;
  final b zHO;
  
  static
  {
    AppMethodBeat.i(300575);
    zHM = new j.a((byte)0);
    AppMethodBeat.o(300575);
  }
  
  public j(m paramm)
  {
    AppMethodBeat.i(300570);
    this.zHN = paramm;
    this.zGg = new HashMap();
    paramm = new ArrayList();
    paramm.add(Pair.create("onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V"));
    ((Map)this.zGg).put("com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", paramm);
    this.zHO = new b(this);
    AppMethodBeat.o(300570);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLEndCallback$mRefeshLoadMoreListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements d
  {
    b(j paramj) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      int j = 1;
      AppMethodBeat.i(300546);
      if ((s.p(paramString2, "onFetchDone")) && (s.p(paramString3, "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V")) && (paramArrayOfObject != null))
      {
        paramString1 = this.zHP;
        if (paramArrayOfObject.length == 0)
        {
          i = 1;
          if (i != 0) {
            break label113;
          }
          i = 1;
          label53:
          if (i == 0) {
            break label131;
          }
          paramString1 = paramString1.zHN.r(paramArrayOfObject);
          if ((paramString1 == null) || (paramString1.pullType != m.c.zIl.value)) {
            break label119;
          }
        }
        label113:
        label119:
        for (int i = j;; i = 0)
        {
          if (i != 0) {
            break label125;
          }
          k.zHQ.a(paramString1);
          AppMethodBeat.o(300546);
          return;
          i = 0;
          break;
          i = 0;
          break label53;
        }
        label125:
        k.zHQ.dKf();
      }
      label131:
      AppMethodBeat.o(300546);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.b.j
 * JD-Core Version:    0.7.0.1
 */