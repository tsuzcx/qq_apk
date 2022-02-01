package com.tencent.mm.plugin.finder.viewmodel.component;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine;", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "data", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/util/List;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "getData", "()Ljava/util/List;", "isConfirmDataChange", "", "stableDataMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "state", "Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$TransitionState;", "stateListeners", "Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$StateListener;", "unstableDataMap", "updateListener", "com/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$updateListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$updateListener$1;", "addStateListener", "", "listener", "attach", "clearStateListeners", "confirmedSelect", "isUpdate", "detach", "enterSelect", "exitSelect", "finishSelect", "getDiff", "Lkotlin/Pair;", "", "getStableMap", "onLoadMore", "increment", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onStateChange", "preConfirmSelect", "refreshMap", "isStable", "removeSateListener", "reportMention", "eventCode", "addCount", "deleteCount", "updateStableMap", "Companion", "StateData", "StateListener", "TransitionState", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a GMa;
  d GMb;
  private boolean GMc;
  HashMap<Long, Integer> GMd;
  private HashMap<Long, Integer> GMe;
  List<c> GMf;
  final AtFeedSelectStateMachine.updateListener.1 GMg;
  private final AppCompatActivity activity;
  private final List<? extends BaseFinderFeed> bMf;
  
  static
  {
    AppMethodBeat.i(338323);
    GMa = new a((byte)0);
    AppMethodBeat.o(338323);
  }
  
  public b(AppCompatActivity paramAppCompatActivity, List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(338265);
    this.activity = paramAppCompatActivity;
    this.bMf = paramList;
    this.GMb = d.GMj;
    this.GMd = new HashMap();
    this.GMe = new HashMap();
    this.GMf = ((List)new ArrayList());
    this.GMg = new AtFeedSelectStateMachine.updateListener.1(this, f.hfK);
    AppMethodBeat.o(338265);
  }
  
  private void a(d paramd)
  {
    AppMethodBeat.i(338288);
    s.u(paramd, "state");
    Log.i("Finder.AtFeedSelectStateMachine", "onStateChange :from " + paramd + " to: " + paramd);
    this.GMb = paramd;
    Object localObject;
    switch (e.$EnumSwitchMapping$0[paramd.ordinal()])
    {
    default: 
      localObject = new b(null, null);
    }
    for (;;)
    {
      Iterator localIterator = this.GMf.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).a(paramd, (b)localObject);
      }
      localObject = z.FrZ;
      localObject = k.aeZF;
      z.a(1, "manage_yes", "", ((as)k.d(this.activity).q(as.class)).fou());
      localObject = new b(null, null);
      continue;
      localObject = fmW();
      iH(((List)((r)localObject).bsC).size(), ((List)((r)localObject).bsD).size());
      localObject = new b((List)((r)localObject).bsC, (List)((r)localObject).bsD);
      continue;
      localObject = new b(null, null);
      ((b)localObject).GyH = this.GMc;
    }
    AppMethodBeat.o(338288);
  }
  
  private final void iH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(338305);
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("add_count", paramInt1);
    ((JSONObject)localObject1).put("delete_count", paramInt2);
    localObject1 = ((JSONObject)localObject1).toString();
    s.s(localObject1, "JSONObject().apply {\n   …unt)\n        }.toString()");
    Object localObject2 = z.FrZ;
    localObject2 = k.aeZF;
    z.a(1, "select_yes_icon", (String)localObject1, ((as)k.d(this.activity).q(as.class)).fou());
    AppMethodBeat.o(338305);
  }
  
  private final void vk(boolean paramBoolean)
  {
    AppMethodBeat.i(338297);
    if (paramBoolean) {}
    for (HashMap localHashMap = this.GMd;; localHashMap = this.GMe)
    {
      localHashMap.clear();
      Iterator localIterator = this.bMf.iterator();
      while (localIterator.hasNext())
      {
        BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)localIterator.next();
        ((Map)localHashMap).put(Long.valueOf(localBaseFinderFeed.bZA()), Integer.valueOf(localBaseFinderFeed.feedObject.getMentionListSelected()));
      }
    }
    AppMethodBeat.o(338297);
  }
  
  public final void fmS()
  {
    AppMethodBeat.i(338332);
    d locald = this.GMb;
    switch (e.$EnumSwitchMapping$0[locald.ordinal()])
    {
    default: 
      Log.i("Finder.AtFeedSelectStateMachine", s.X("enterSelect transition error! state:", this.GMb));
      AppMethodBeat.o(338332);
      return;
    case 1: 
      vk(true);
      a(d.GMk);
      AppMethodBeat.o(338332);
      return;
    }
    vk(true);
    a(d.GMk);
    AppMethodBeat.o(338332);
  }
  
  public final void fmT()
  {
    AppMethodBeat.i(338337);
    vk(false);
    a(d.GMn);
    AppMethodBeat.o(338337);
  }
  
  public final void fmU()
  {
    AppMethodBeat.i(338345);
    vk(false);
    a(d.GMl);
    AppMethodBeat.o(338345);
  }
  
  public final void fmV()
  {
    AppMethodBeat.i(338353);
    a(d.GMo);
    AppMethodBeat.o(338353);
  }
  
  public final r<List<Long>, List<Long>> fmW()
  {
    AppMethodBeat.i(338372);
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Map)this.GMe).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Integer localInteger = (Integer)this.GMd.get(localEntry.getKey());
      if ((localInteger != null) && (((Number)localEntry.getValue()).intValue() != localInteger.intValue())) {
        if (((Number)localEntry.getValue()).intValue() == 3) {
          localArrayList.add(localEntry.getKey());
        } else if (((Number)localEntry.getValue()).intValue() == 2) {
          ((ArrayList)localObject).add(localEntry.getKey());
        }
      }
    }
    localObject = new r(localObject, localArrayList);
    AppMethodBeat.o(338372);
    return localObject;
  }
  
  public final void vj(boolean paramBoolean)
  {
    AppMethodBeat.i(338361);
    this.GMd.clear();
    HashMap localHashMap = this.GMd;
    this.GMd = this.GMe;
    this.GMe = localHashMap;
    this.GMc = paramBoolean;
    a(d.GMm);
    AppMethodBeat.o(338361);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$StateData;", "", "selectList", "", "", "unSelectList", "(Ljava/util/List;Ljava/util/List;)V", "isDataChange", "", "()Z", "setDataChange", "(Z)V", "getSelectList", "()Ljava/util/List;", "getUnSelectList", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final List<Long> GMh;
    final List<Long> GMi;
    boolean GyH;
    
    public b(List<Long> paramList1, List<Long> paramList2)
    {
      this.GMh = paramList1;
      this.GMi = paramList2;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$StateListener;", "", "onStateChange", "", "state", "Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$TransitionState;", "data", "Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$StateData;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void a(b.d paramd, b.b paramb);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$TransitionState;", "", "(Ljava/lang/String;I)V", "INIT", "ENTER", "PRE_CONFIRM", "CONFIRMED", "EXIT", "DESTROY", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum d
  {
    static
    {
      AppMethodBeat.i(338703);
      GMj = new d("INIT", 0);
      GMk = new d("ENTER", 1);
      GMl = new d("PRE_CONFIRM", 2);
      GMm = new d("CONFIRMED", 3);
      GMn = new d("EXIT", 4);
      GMo = new d("DESTROY", 5);
      GMp = new d[] { GMj, GMk, GMl, GMm, GMn, GMo };
      AppMethodBeat.o(338703);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.b
 * JD-Core Version:    0.7.0.1
 */