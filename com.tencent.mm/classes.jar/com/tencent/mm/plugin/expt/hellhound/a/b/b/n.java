package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import d.g.b.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback;", "", "mParent", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;)V", "mMethodMap", "Ljava/util/HashMap;", "", "", "Landroid/util/Pair;", "getMParent", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "mTopicRefreshLoadMoreListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback$mTopicRefreshLoadMoreListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback$mTopicRefreshLoadMoreListener$1;", "monitor", "", "unmonitor", "Companion", "plugin-expt_release"})
public final class n
{
  public static final a rfd;
  final HashMap<String, List<Pair<String, String>>> rdA;
  final b rfb;
  final l rfc;
  
  static
  {
    AppMethodBeat.i(196527);
    rfd = new a((byte)0);
    AppMethodBeat.o(196527);
  }
  
  public n(l paraml)
  {
    AppMethodBeat.i(196526);
    this.rfc = paraml;
    this.rdA = new HashMap();
    paraml = new ArrayList();
    paraml.add(Pair.create("onLoadEnd", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;)V"));
    ((Map)this.rdA).put("com/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$FeedLoadCallback", paraml);
    this.rfb = new b(this);
    AppMethodBeat.o(196526);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback$Companion;", "", "()V", "DESC_onLoadEnd", "", "INTERFACE_NAME", "NAME_onLoadEnd", "plugin-expt_release"})
  public static final class a {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback$mTopicRefreshLoadMoreListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      int j = 1;
      AppMethodBeat.i(196525);
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
            paramString1 = this.rfe.rfc.p(paramArrayOfObject);
            if ((paramString1 == null) || (paramString1.pullType != l.c.reV.value))
            {
              j.reI.a(paramString1);
              AppMethodBeat.o(196525);
              return;
              i = 0;
              break;
              label103:
              i = 0;
              continue;
            }
            j.reI.cqm();
          }
        }
      }
      AppMethodBeat.o(196525);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.n
 * JD-Core Version:    0.7.0.1
 */