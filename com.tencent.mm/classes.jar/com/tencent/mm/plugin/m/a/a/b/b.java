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
import d.u;
import d.v;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/RenderViewManager;", "", "wxaChannelService", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/WxaChannelService;", "(Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/WxaChannelService;)V", "engineProvider", "Lcom/tencent/mm/plugin/luggage/natives/flutter/IFlutterEngineProvider;", "lastForegroundView", "Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/IWxaRenderView;", "mContext", "Landroid/content/Context;", "mRenderViews", "", "", "viewStack", "Ljava/util/Stack;", "attachRenderView", "", "view", "parent", "Landroid/view/ViewGroup;", "forceAttachFlutterView", "", "ensureInList", "enterFullScreen", "viewId", "exitFullScreen", "obtainRenderView", "context", "onBackground", "onDestroy", "onForeground", "onInitialized", "params", "Ljava/util/HashMap;", "", "onShow", "newId", "", "oldId", "pickerSelectCallback", "id", "ok", "data", "scrollToTop", "setFlutterEngineProvider", "provider", "Companion", "luggage-native-view_release"})
public final class b
{
  public static final a uzY;
  public Context mContext;
  public final Map<Long, a> uzU;
  public a uzV;
  public Stack<a> uzW;
  public com.tencent.mm.plugin.m.a.a.b uzX;
  public final d uzr;
  
  static
  {
    AppMethodBeat.i(123851);
    uzY = new a((byte)0);
    AppMethodBeat.o(123851);
  }
  
  public b(d paramd)
  {
    AppMethodBeat.i(123850);
    this.uzr = paramd;
    this.uzU = ((Map)new LinkedHashMap());
    this.uzW = new Stack();
    AppMethodBeat.o(123850);
  }
  
  public final void a(a parama, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(123845);
    k.h(parama, "view");
    k.h(paramViewGroup, "parent");
    View localView = parama.getView();
    if ((paramBoolean) || (this.uzV == null)) {
      parama.b(this.uzV);
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
  
  public final void c(a parama)
  {
    AppMethodBeat.i(123847);
    k.h(parama, "view");
    if (((a)this.uzW.peek()).getViewId() != parama.getViewId())
    {
      AppMethodBeat.o(123847);
      return;
    }
    d(parama);
    parama.onBackground();
    parama = ae.b(u.Q("viewId", Long.valueOf(parama.getViewId())));
    this.uzr.dm(parama);
    AppMethodBeat.o(123847);
  }
  
  public final void d(a parama)
  {
    AppMethodBeat.i(123849);
    if (!this.uzU.values().contains(parama))
    {
      parama = (Throwable)new IllegalArgumentException((parama + " does not exist in RenderView's list").toString());
      AppMethodBeat.o(123849);
      throw parama;
    }
    AppMethodBeat.o(123849);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/RenderViewManager$Companion;", "", "()V", "TAG", "", "luggage-native-view_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */