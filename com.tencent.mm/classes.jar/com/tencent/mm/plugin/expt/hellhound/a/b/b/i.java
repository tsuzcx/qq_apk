package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import d.g.b.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLEndCallback;", "", "mRLCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;)V", "mMethodMap", "Ljava/util/HashMap;", "", "", "Landroid/util/Pair;", "getMRLCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "mRefeshLoadMoreListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLEndCallback$mRefeshLoadMoreListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLEndCallback$mRefeshLoadMoreListener$1;", "startMonitor", "", "Companion", "plugin-expt_release"})
public final class i
{
  public static final a KHk;
  final HashMap<String, List<Pair<String, String>>> KGr;
  final b KHi;
  final l KHj;
  
  static
  {
    AppMethodBeat.i(205201);
    KHk = new a((byte)0);
    AppMethodBeat.o(205201);
  }
  
  public i(l paraml)
  {
    AppMethodBeat.i(205200);
    this.KHj = paraml;
    this.KGr = new HashMap();
    paraml = new ArrayList();
    paraml.add(Pair.create("onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V"));
    ((Map)this.KGr).put("com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", paraml);
    this.KHi = new b(this);
    AppMethodBeat.o(205200);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLEndCallback$Companion;", "", "()V", "DESC_onFetchDone", "", "NAME_onFetchDone", "SUPER_NAME", "TAG", "plugin-expt_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLEndCallback$mRefeshLoadMoreListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      int j = 1;
      AppMethodBeat.i(205199);
      if ((k.g(paramString2, "onFetchDone")) && (k.g(paramString3, "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V")) && (paramArrayOfObject != null))
      {
        int i;
        if (paramArrayOfObject.length == 0)
        {
          i = 1;
          if (i != 0) {
            break label103;
          }
          i = j;
        }
        for (;;)
        {
          if (i != 0)
          {
            paramString1 = this.KHl.KHj.ai(paramArrayOfObject);
            if ((paramString1 == null) || (paramString1.pullType != l.c.KHG.value))
            {
              j.KHt.a(paramString1);
              AppMethodBeat.o(205199);
              return;
              i = 0;
              break;
              label103:
              i = 0;
              continue;
            }
            j.KHt.fRt();
          }
        }
      }
      AppMethodBeat.o(205199);
    }
    
    public final void g(String paramString, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.i
 * JD-Core Version:    0.7.0.1
 */