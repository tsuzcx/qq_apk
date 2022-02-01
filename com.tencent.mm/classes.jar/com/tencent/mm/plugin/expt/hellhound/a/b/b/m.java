package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import d.g.b.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback;", "", "mParent", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;)V", "mMethodMap", "Ljava/util/HashMap;", "", "", "Landroid/util/Pair;", "getMParent", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "mTopicRefreshLoadMoreListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback$mTopicRefreshLoadMoreListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback$mTopicRefreshLoadMoreListener$1;", "monitor", "", "unmonitor", "Companion", "plugin-expt_release"})
public final class m
{
  public static final a qWY;
  final HashMap<String, List<Pair<String, String>>> qVC;
  final b qWW;
  final l qWX;
  
  static
  {
    AppMethodBeat.i(210856);
    qWY = new a((byte)0);
    AppMethodBeat.o(210856);
  }
  
  public m(l paraml)
  {
    AppMethodBeat.i(210855);
    this.qWX = paraml;
    this.qVC = new HashMap();
    paraml = new ArrayList();
    paraml.add(Pair.create("onLoadEnd", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;)V"));
    ((Map)this.qVC).put("com/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$FeedLoadCallback", paraml);
    this.qWW = new b(this);
    AppMethodBeat.o(210855);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback$Companion;", "", "()V", "DESC_onLoadEnd", "", "INTERFACE_NAME", "NAME_onLoadEnd", "plugin-expt_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback$mTopicRefreshLoadMoreListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      int j = 1;
      AppMethodBeat.i(210854);
      if ((p.i("onLoadEnd", paramString2)) && (p.i("(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;)V", paramString3)) && (paramArrayOfObject != null))
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
            paramString1 = this.qWZ.qWX.q(paramArrayOfObject);
            if ((paramString1 == null) || (paramString1.pullType != l.c.qWS.value))
            {
              j.qWF.a(paramString1);
              AppMethodBeat.o(210854);
              return;
              i = 0;
              break;
              label103:
              i = 0;
              continue;
            }
            j.qWF.coK();
          }
        }
      }
      AppMethodBeat.o(210854);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.m
 * JD-Core Version:    0.7.0.1
 */