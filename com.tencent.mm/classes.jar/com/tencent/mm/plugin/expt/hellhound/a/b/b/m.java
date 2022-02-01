package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import d.g.b.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback;", "", "mParent", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;)V", "mMethodMap", "Ljava/util/HashMap;", "", "", "Landroid/util/Pair;", "getMParent", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "mTopicRefreshLoadMoreListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback$mTopicRefreshLoadMoreListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback$mTopicRefreshLoadMoreListener$1;", "monitor", "", "unmonitor", "Companion", "plugin-expt_release"})
public final class m
{
  public static final a qoa;
  final HashMap<String, List<Pair<String, String>>> qmF;
  final b qnY;
  final l qnZ;
  
  static
  {
    AppMethodBeat.i(195510);
    qoa = new a((byte)0);
    AppMethodBeat.o(195510);
  }
  
  public m(l paraml)
  {
    AppMethodBeat.i(195509);
    this.qnZ = paraml;
    this.qmF = new HashMap();
    paraml = new ArrayList();
    paraml.add(Pair.create("onLoadEnd", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;)V"));
    ((Map)this.qmF).put("com/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$FeedLoadCallback", paraml);
    this.qnY = new b(this);
    AppMethodBeat.o(195509);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback$Companion;", "", "()V", "DESC_onLoadEnd", "", "INTERFACE_NAME", "NAME_onLoadEnd", "plugin-expt_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback$mTopicRefreshLoadMoreListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      int j = 1;
      AppMethodBeat.i(195508);
      if ((k.g("onLoadEnd", paramString2)) && (k.g("(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;)V", paramString3)) && (paramArrayOfObject != null))
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
            paramString1 = this.qob.qnZ.q(paramArrayOfObject);
            if ((paramString1 == null) || (paramString1.pullType != l.c.qnU.value))
            {
              j.qnH.a(paramString1);
              AppMethodBeat.o(195508);
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
      AppMethodBeat.o(195508);
    }
    
    public final void f(String paramString, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.m
 * JD-Core Version:    0.7.0.1
 */