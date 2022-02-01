package com.tencent.mm.plugin.m.a.a.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.m.a.a.a.a.d;
import d.a.ae;
import d.g.b.k;
import d.l;
import d.o;
import d.u;
import d.v;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/RenderViewManager;", "", "wxaChannelService", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/WxaChannelService;", "(Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/WxaChannelService;)V", "engineProvider", "Lcom/tencent/mm/plugin/luggage/natives/flutter/IFlutterEngineProvider;", "lastForegroundView", "Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/IWxaRenderView;", "mContext", "Landroid/content/Context;", "mRenderViews", "", "", "viewStack", "Ljava/util/Stack;", "attachRenderView", "", "view", "parent", "Landroid/view/ViewGroup;", "forceAttachFlutterView", "", "ensureInList", "enterFullScreen", "viewId", "exitFullScreen", "obtainRenderView", "context", "onBackground", "onDestroy", "onForeground", "onInitialized", "params", "Ljava/util/HashMap;", "", "onShow", "newId", "", "oldId", "pickerSelectCallback", "id", "ok", "data", "scrollToTop", "setFlutterEngineProvider", "provider", "Companion", "luggage-native-view_release"})
public final class b
{
  public static final b.a trE;
  private Context mContext;
  public final d tqZ;
  public final Map<Long, a> trA;
  private a trB;
  private Stack<a> trC;
  private com.tencent.mm.plugin.m.a.a.b trD;
  
  static
  {
    AppMethodBeat.i(123851);
    trE = new b.a((byte)0);
    AppMethodBeat.o(123851);
  }
  
  public b(d paramd)
  {
    AppMethodBeat.i(123850);
    this.tqZ = paramd;
    this.trA = ((Map)new LinkedHashMap());
    this.trC = new Stack();
    AppMethodBeat.o(123850);
  }
  
  private void a(a parama, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(123845);
    k.h(parama, "view");
    k.h(paramViewGroup, "parent");
    View localView = parama.getView();
    if ((paramBoolean) || (this.trB == null)) {
      parama.c(this.trB);
    }
    if ((k.g(localView.getParent(), paramViewGroup) ^ true))
    {
      if (localView.getParent() != null)
      {
        parama = localView.getParent();
        if (parama == null)
        {
          parama = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(123845);
          throw parama;
        }
        ((ViewGroup)parama).removeView(localView);
      }
      paramViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(123845);
  }
  
  private void b(a parama)
  {
    AppMethodBeat.i(123848);
    k.h(parama, "view");
    parama.onDestroy();
    Map localMap = ae.b(u.P("viewId", Long.valueOf(parama.getViewId())));
    this.tqZ.bc(localMap);
    this.trA.remove(Long.valueOf(parama.getViewId()));
    AppMethodBeat.o(123848);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(123847);
    k.h(parama, "view");
    if (((a)this.trC.peek()).getViewId() != parama.getViewId())
    {
      AppMethodBeat.o(123847);
      return;
    }
    d(parama);
    parama.onBackground();
    parama = ae.b(u.P("viewId", Long.valueOf(parama.getViewId())));
    this.tqZ.dl(parama);
    AppMethodBeat.o(123847);
  }
  
  public final void a(a parama, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(123844);
    k.h(parama, "view");
    k.h(paramViewGroup, "parent");
    d(parama);
    Object localObject;
    if (!this.trC.contains(parama))
    {
      if (!this.trC.empty())
      {
        localObject = this.trC.peek();
        k.g(localObject, "viewStack.peek()");
        a((a)localObject);
      }
      this.trC.push(parama);
      parama.cNb();
    }
    for (;;)
    {
      parama.onForeground();
      localObject = ae.b(u.P("viewId", Long.valueOf(parama.getViewId())));
      this.tqZ.dk(localObject);
      a(parama, paramViewGroup, true);
      this.trB = parama;
      AppMethodBeat.o(123844);
      return;
      do
      {
        localObject = (a)this.trC.peek();
        if ((k.g(localObject, parama) ^ true))
        {
          ((a)localObject).cNa();
          k.g(localObject, "top");
          a((a)localObject);
          b((a)localObject);
          this.trC.pop();
        }
      } while ((k.g(localObject, parama) ^ true));
    }
  }
  
  public final void a(a parama, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(123843);
    k.h(parama, "view");
    k.h(paramHashMap, "params");
    d(parama);
    parama = ae.b(new o[] { u.P("viewId", Long.valueOf(parama.getViewId())) });
    parama.putAll((Map)paramHashMap);
    this.tqZ.aX(parama);
    AppMethodBeat.o(123843);
  }
  
  public final void a(com.tencent.mm.plugin.m.a.a.b paramb)
  {
    AppMethodBeat.i(123842);
    k.h(paramb, "provider");
    this.trD = paramb;
    AppMethodBeat.o(123842);
  }
  
  public final a b(long paramLong, Context paramContext)
  {
    AppMethodBeat.i(123841);
    k.h(paramContext, "context");
    this.mContext = paramContext;
    Object localObject = (a)this.trA.get(Long.valueOf(paramLong));
    if (localObject != null)
    {
      AppMethodBeat.o(123841);
      return localObject;
    }
    localObject = this.trD;
    if (localObject == null) {
      k.fvU();
    }
    paramContext = new c(paramContext, paramLong, (com.tencent.mm.plugin.m.a.a.b)localObject);
    this.trA.put(Long.valueOf(paramLong), paramContext);
    paramContext = (a)paramContext;
    AppMethodBeat.o(123841);
    return paramContext;
  }
  
  public final void d(a parama)
  {
    AppMethodBeat.i(123849);
    if (!this.trA.values().contains(parama))
    {
      parama = (Throwable)new IllegalArgumentException((parama + " does not exist in RenderView's list").toString());
      AppMethodBeat.o(123849);
      throw parama;
    }
    AppMethodBeat.o(123849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */