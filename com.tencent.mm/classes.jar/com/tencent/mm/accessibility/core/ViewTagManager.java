package com.tencent.mm.accessibility.core;

import android.view.View;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.j.b;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.ViewTag;
import com.tencent.mm.plugin.f.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/ViewTagManager;", "", "()V", "TAG", "", "tagMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/tencent/mm/accessibility/base/ViewTag;", "addObserver", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "getTagData", "view", "Landroid/view/View;", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ViewTagManager
{
  public static final ViewTagManager INSTANCE;
  private static final String TAG = "MicroMsg.Acc.ViewTagManager";
  private static final ConcurrentHashMap<Integer, Map<Integer, ViewTag>> tagMap;
  
  static
  {
    AppMethodBeat.i(234167);
    INSTANCE = new ViewTagManager();
    tagMap = new ConcurrentHashMap();
    AppMethodBeat.o(234167);
  }
  
  private final void addObserver(q paramq)
  {
    AppMethodBeat.i(234148);
    Log.i("MicroMsg.Acc.ViewTagManager", s.X("wait synchronized ", paramq));
    try
    {
      boolean bool = tagMap.containsKey(Integer.valueOf(paramq.hashCode()));
      if (bool) {
        return;
      }
      Log.i("MicroMsg.Acc.ViewTagManager", s.X("addObserver init ", paramq));
      p local1 = new p()
      {
        @z(Ho=j.a.ON_DESTROY)
        public final void onDestroy()
        {
          AppMethodBeat.i(234135);
          ViewTagManager.access$getTagMap$p().remove(Integer.valueOf(this.$owner.hashCode()));
          Log.i("MicroMsg.Acc.ViewTagManager", s.X("removeObserver onDestroy: ", this.$owner));
          AppMethodBeat.o(234135);
        }
      };
      h.ahAA.bl(new ViewTagManager..ExternalSyntheticLambda0(paramq, local1));
      tagMap.put(Integer.valueOf(paramq.hashCode()), (Map)new LinkedHashMap());
      return;
    }
    finally
    {
      AppMethodBeat.o(234148);
    }
  }
  
  private static final void addObserver$lambda-5$lambda-4(q paramq, addObserver.1.observer.1 param1)
  {
    AppMethodBeat.i(234158);
    s.u(paramq, "$owner");
    s.u(param1, "$observer");
    Log.i("MicroMsg.Acc.ViewTagManager", "addObserver in uiAtFront:" + paramq + ' ' + paramq.getLifecycle().getCurrentState().name());
    j localj = paramq.getLifecycle();
    if (localj.getCurrentState() != j.b.bHg)
    {
      localj.addObserver((p)param1);
      AppMethodBeat.o(234158);
      return;
    }
    Log.i("MicroMsg.Acc.ViewTagManager", s.X("addObserver in uiAtFront but destroy ", paramq));
    tagMap.remove(Integer.valueOf(paramq.hashCode()));
    AppMethodBeat.o(234158);
  }
  
  public final ViewTag getTagData(View paramView)
  {
    AppMethodBeat.i(234185);
    s.u(paramView, "view");
    Object localObject1 = paramView.getTag(a.a.tag_acc_tag_data);
    if ((localObject1 instanceof ViewTag)) {}
    for (localObject1 = (ViewTag)localObject1; localObject1 != null; localObject1 = null)
    {
      AppMethodBeat.o(234185);
      return localObject1;
    }
    localObject1 = paramView.getContext();
    if ((localObject1 instanceof q)) {}
    for (localObject1 = (q)localObject1; localObject1 == null; localObject1 = null)
    {
      AppMethodBeat.o(234185);
      return null;
    }
    if (!tagMap.containsKey(Integer.valueOf(localObject1.hashCode()))) {
      addObserver((q)localObject1);
    }
    Object localObject3 = (ConcurrentMap)tagMap;
    Integer localInteger = Integer.valueOf(localObject1.hashCode());
    localObject1 = ((ConcurrentMap)localObject3).get(localInteger);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = (Map)new LinkedHashMap();
      localObject3 = ((ConcurrentMap)localObject3).putIfAbsent(localInteger, localObject2);
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      s.s(localObject1, "tagMap.getOrPut(owner.ha…de(), { mutableMapOf() })");
      localObject1 = (Map)localObject1;
      localObject2 = Integer.valueOf(paramView.hashCode());
      paramView = ((Map)localObject1).get(localObject2);
      if (paramView == null)
      {
        paramView = new ViewTag();
        ((Map)localObject1).put(localObject2, paramView);
      }
      for (;;)
      {
        paramView = (ViewTag)paramView;
        AppMethodBeat.o(234185);
        return paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.ViewTagManager
 * JD-Core Version:    0.7.0.1
 */