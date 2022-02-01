package com.tencent.mm.plugin.finder.viewmodel.component;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hz;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine;", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "data", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/util/List;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "getData", "()Ljava/util/List;", "isConfirmDataChange", "", "stableDataMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "state", "Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$TransitionState;", "stateListeners", "Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$StateListener;", "unstableDataMap", "updateListener", "com/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$updateListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$updateListener$1;", "addStateListener", "", "listener", "attach", "clearStateListeners", "confirmedSelect", "isUpdate", "detach", "enterSelect", "exitSelect", "finishSelect", "getDiff", "Lkotlin/Pair;", "", "getStableMap", "onLoadMore", "increment", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onStateChange", "preConfirmSelect", "refreshMap", "isStable", "removeSateListener", "reportMention", "eventCode", "addCount", "deleteCount", "updateStableMap", "Companion", "StateData", "StateListener", "TransitionState", "plugin-finder_release"})
public final class b
{
  public static final a BhJ;
  d BhD;
  private boolean BhE;
  HashMap<Long, Integer> BhF;
  private HashMap<Long, Integer> BhG;
  List<c> BhH;
  final e BhI;
  private final List<? extends BaseFinderFeed> tYs;
  private final AppCompatActivity xGq;
  
  static
  {
    AppMethodBeat.i(288462);
    BhJ = new a((byte)0);
    AppMethodBeat.o(288462);
  }
  
  public b(AppCompatActivity paramAppCompatActivity, List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(288461);
    this.xGq = paramAppCompatActivity;
    this.tYs = paramList;
    this.BhD = d.BhM;
    this.BhF = new HashMap();
    this.BhG = new HashMap();
    this.BhH = ((List)new ArrayList());
    this.BhI = new e(this);
    AppMethodBeat.o(288461);
  }
  
  private final void hl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(288460);
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("add_count", paramInt1);
    ((JSONObject)localObject1).put("delete_count", paramInt2);
    localObject1 = ((JSONObject)localObject1).toString();
    p.j(localObject1, "JSONObject().apply {\n   …unt)\n        }.toString()");
    Object localObject2 = n.zWF;
    localObject2 = g.Xox;
    n.a(1, "select_yes_icon", (String)localObject1, ((aj)g.b(this.xGq).i(aj.class)).ekY());
    AppMethodBeat.o(288460);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(288456);
    p.k(paramd, "state");
    Log.i("Finder.AtFeedSelectStateMachine", "onStateChange :from " + paramd + " to: " + paramd);
    this.BhD = paramd;
    Object localObject;
    switch (c.jLJ[paramd.ordinal()])
    {
    default: 
      localObject = new b(null, null);
    }
    for (;;)
    {
      Iterator localIterator = this.BhH.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).a(paramd, (b)localObject);
      }
      localObject = n.zWF;
      localObject = g.Xox;
      n.a(1, "manage_yes", "", ((aj)g.b(this.xGq).i(aj.class)).ekY());
      localObject = new b(null, null);
      continue;
      localObject = ekh();
      hl(((List)((o)localObject).Mx).size(), ((List)((o)localObject).My).size());
      localObject = new b((List)((o)localObject).Mx, (List)((o)localObject).My);
      continue;
      localObject = new b(null, null);
      ((b)localObject).AXb = this.BhE;
    }
    AppMethodBeat.o(288456);
  }
  
  public final void ekg()
  {
    AppMethodBeat.i(288451);
    rB(false);
    a(d.BhQ);
    AppMethodBeat.o(288451);
  }
  
  public final o<List<Long>, List<Long>> ekh()
  {
    AppMethodBeat.i(288459);
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Map)this.BhG).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Integer localInteger = (Integer)this.BhF.get(localEntry.getKey());
      if (localInteger != null)
      {
        int i = ((Number)localEntry.getValue()).intValue();
        if (localInteger == null) {}
        for (;;)
        {
          if (((Number)localEntry.getValue()).intValue() != 3) {
            break label150;
          }
          localArrayList.add(localEntry.getKey());
          break;
          if (i == localInteger.intValue()) {
            break;
          }
        }
        label150:
        if (((Number)localEntry.getValue()).intValue() == 2) {
          ((ArrayList)localObject).add(localEntry.getKey());
        }
      }
    }
    localObject = new o(localObject, localArrayList);
    AppMethodBeat.o(288459);
    return localObject;
  }
  
  public final void rA(boolean paramBoolean)
  {
    AppMethodBeat.i(288452);
    this.BhF.clear();
    HashMap localHashMap = this.BhF;
    this.BhF = this.BhG;
    this.BhG = localHashMap;
    this.BhE = paramBoolean;
    a(d.BhP);
    AppMethodBeat.o(288452);
  }
  
  final void rB(boolean paramBoolean)
  {
    AppMethodBeat.i(288458);
    if (paramBoolean) {}
    for (HashMap localHashMap = this.BhF;; localHashMap = this.BhG)
    {
      localHashMap.clear();
      Iterator localIterator = this.tYs.iterator();
      while (localIterator.hasNext())
      {
        BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)localIterator.next();
        ((Map)localHashMap).put(Long.valueOf(localBaseFinderFeed.mf()), Integer.valueOf(localBaseFinderFeed.feedObject.getMentionListSelected()));
      }
    }
    AppMethodBeat.o(288458);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$StateData;", "", "selectList", "", "", "unSelectList", "(Ljava/util/List;Ljava/util/List;)V", "isDataChange", "", "()Z", "setDataChange", "(Z)V", "getSelectList", "()Ljava/util/List;", "getUnSelectList", "plugin-finder_release"})
  public static final class b
  {
    boolean AXb;
    final List<Long> BhK;
    final List<Long> BhL;
    
    public b(List<Long> paramList1, List<Long> paramList2)
    {
      this.BhK = paramList1;
      this.BhL = paramList2;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$StateListener;", "", "onStateChange", "", "state", "Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$TransitionState;", "data", "Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$StateData;", "plugin-finder_release"})
  public static abstract interface c
  {
    public abstract void a(b.d paramd, b.b paramb);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$TransitionState;", "", "(Ljava/lang/String;I)V", "INIT", "ENTER", "PRE_CONFIRM", "CONFIRMED", "EXIT", "DESTROY", "plugin-finder_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(289784);
      d locald1 = new d("INIT", 0);
      BhM = locald1;
      d locald2 = new d("ENTER", 1);
      BhN = locald2;
      d locald3 = new d("PRE_CONFIRM", 2);
      BhO = locald3;
      d locald4 = new d("CONFIRMED", 3);
      BhP = locald4;
      d locald5 = new d("EXIT", 4);
      BhQ = locald5;
      d locald6 = new d("DESTROY", 5);
      BhR = locald6;
      BhS = new d[] { locald1, locald2, locald3, locald4, locald5, locald6 };
      AppMethodBeat.o(289784);
    }
    
    private d() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$updateListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderAtFeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends IListener<hz>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.b
 * JD-Core Version:    0.7.0.1
 */