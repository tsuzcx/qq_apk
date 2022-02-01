package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import d.g.b.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLEndCallback;", "", "mRLCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;)V", "mMethodMap", "Ljava/util/HashMap;", "", "", "Landroid/util/Pair;", "getMRLCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "mRefeshLoadMoreListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLEndCallback$mRefeshLoadMoreListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLEndCallback$mRefeshLoadMoreListener$1;", "startMonitor", "", "Companion", "plugin-expt_release"})
public final class i
{
  public static final a qny;
  final HashMap<String, List<Pair<String, String>>> qmF;
  final b qnw;
  final l qnx;
  
  static
  {
    AppMethodBeat.i(195460);
    qny = new a((byte)0);
    AppMethodBeat.o(195460);
  }
  
  public i(l paraml)
  {
    AppMethodBeat.i(195459);
    this.qnx = paraml;
    this.qmF = new HashMap();
    paraml = new ArrayList();
    paraml.add(Pair.create("onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V"));
    ((Map)this.qmF).put("com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", paraml);
    this.qnw = new b(this);
    AppMethodBeat.o(195459);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLEndCallback$Companion;", "", "()V", "DESC_onFetchDone", "", "NAME_onFetchDone", "SUPER_NAME", "TAG", "plugin-expt_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLEndCallback$mRefeshLoadMoreListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      int j = 1;
      AppMethodBeat.i(195458);
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
            paramString1 = this.qnz.qnx.q(paramArrayOfObject);
            if ((paramString1 == null) || (paramString1.pullType != l.c.qnU.value))
            {
              j.qnH.a(paramString1);
              AppMethodBeat.o(195458);
              return;
              i = 0;
              break;
              label103:
              i = 0;
              continue;
            }
            j.qnH.cjy();
          }
        }
      }
      AppMethodBeat.o(195458);
    }
    
    public final void f(String paramString, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.i
 * JD-Core Version:    0.7.0.1
 */