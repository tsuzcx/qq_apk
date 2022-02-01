package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import d.g.b.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback;", "", "mParent", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;)V", "mMethodMap", "Ljava/util/HashMap;", "", "", "Landroid/util/Pair;", "getMParent", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "mTopicRefreshLoadMoreListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback$mTopicRefreshLoadMoreListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback$mTopicRefreshLoadMoreListener$1;", "monitor", "", "unmonitor", "Companion", "plugin-expt_release"})
public final class m
{
  public static final a KHM;
  final HashMap<String, List<Pair<String, String>>> KGr;
  final b KHK;
  final l KHL;
  
  static
  {
    AppMethodBeat.i(205251);
    KHM = new a((byte)0);
    AppMethodBeat.o(205251);
  }
  
  public m(l paraml)
  {
    AppMethodBeat.i(205250);
    this.KHL = paraml;
    this.KGr = new HashMap();
    paraml = new ArrayList();
    paraml.add(Pair.create("onLoadEnd", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;)V"));
    ((Map)this.KGr).put("com/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$FeedLoadCallback", paraml);
    this.KHK = new b(this);
    AppMethodBeat.o(205250);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback$Companion;", "", "()V", "DESC_onLoadEnd", "", "INTERFACE_NAME", "NAME_onLoadEnd", "plugin-expt_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/TopicRLCalback$mTopicRefreshLoadMoreListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      int j = 1;
      AppMethodBeat.i(205249);
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
            paramString1 = this.KHN.KHL.ai(paramArrayOfObject);
            if ((paramString1 == null) || (paramString1.pullType != l.c.KHG.value))
            {
              j.KHt.a(paramString1);
              AppMethodBeat.o(205249);
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
      AppMethodBeat.o(205249);
    }
    
    public final void g(String paramString, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.m
 * JD-Core Version:    0.7.0.1
 */