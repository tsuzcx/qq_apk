package com.tencent.mm.plugin.finder.live;

import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WeAppHalfScreenStatusChangeListener;
import com.tencent.mm.plugin.finder.live.component.h;
import com.tencent.mm.plugin.finder.live.component.i;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g.a;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/MiniProgramHalfScreenStatusChangeListener;", "Lcom/tencent/mm/plugin/appbrand/config/WeAppHalfScreenStatusChangeListener;", "basePluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "(Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;)V", "enableMiniWindow", "", "getEnableMiniWindow", "()Z", "setEnableMiniWindow", "(Z)V", "rBasePluginLayout", "Ljava/lang/ref/WeakReference;", "style", "", "exitMiniPro", "", "exitMiniWindow", "onEnterFullScreen", "onEnterHalfScreen", "Companion", "plugin-finder_release"})
public final class MiniProgramHalfScreenStatusChangeListener
  extends WeAppHalfScreenStatusChangeListener
{
  public static final a xWB;
  int style;
  boolean xWA;
  private WeakReference<com.tencent.mm.plugin.finder.live.view.a> xWz;
  
  static
  {
    AppMethodBeat.i(286748);
    xWB = new a((byte)0);
    AppMethodBeat.o(286748);
  }
  
  public MiniProgramHalfScreenStatusChangeListener(com.tencent.mm.plugin.finder.live.view.a parama)
  {
    AppMethodBeat.i(286747);
    this.xWz = new WeakReference(parama);
    parama = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.inl().aSr()).intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.xWA = bool;
      AppMethodBeat.o(286747);
      return;
    }
  }
  
  public final void bLx()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    AppMethodBeat.i(286743);
    super.bLx();
    this.style = 1;
    if (!this.xWA)
    {
      Log.i("MiniProgramHalfScreenStatusChangeListener", "onEnterFullScreen disable!");
      AppMethodBeat.o(286743);
      return;
    }
    com.tencent.mm.plugin.finder.live.view.a locala = (com.tencent.mm.plugin.finder.live.view.a)this.xWz.get();
    Object localObject2;
    if ((locala instanceof com.tencent.mm.plugin.finder.live.view.router.c))
    {
      localObject2 = locala.getUicFragment();
      if (localObject2 != null)
      {
        if (((Fragment)localObject2).isAdded()) {
          localObject1 = localObject2;
        }
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.ui.component.g.Xox;
          ((com.tencent.mm.plugin.finder.live.viewmodel.component.g)com.tencent.mm.ui.component.g.h((Fragment)localObject1).i(com.tencent.mm.plugin.finder.live.viewmodel.component.g.class)).dxh();
          localObject1 = ((com.tencent.mm.plugin.finder.live.view.router.c)locala).getStartUIC();
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.c)localObject1).dHn();
          }
        }
      }
      localObject1 = new StringBuilder("onEnterFullScreen baseLivePluginLayout:");
      if (locala == null) {
        break label304;
      }
    }
    label302:
    label304:
    for (int i = locala.hashCode();; i = 0)
    {
      Log.i("MiniProgramHalfScreenStatusChangeListener", i);
      AppMethodBeat.o(286743);
      return;
      if ((locala instanceof com.tencent.mm.plugin.finder.live.view.router.a))
      {
        localObject2 = locala.getUicFragment();
        if (localObject2 == null) {
          break;
        }
        localObject1 = localObject3;
        if (((Fragment)localObject2).isAdded()) {
          localObject1 = localObject2;
        }
        if (localObject1 == null) {
          break;
        }
        localObject2 = com.tencent.mm.ui.component.g.Xox;
        ((i)com.tencent.mm.ui.component.g.h((Fragment)localObject1).i(i.class)).dxh();
        localObject1 = ((com.tencent.mm.plugin.finder.live.view.router.a)locala).getStartUIC();
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).dHn();
        break;
      }
      if (!(locala instanceof com.tencent.mm.plugin.finder.live.view.router.b)) {
        break;
      }
      localObject1 = locala.getUicFragment();
      if (localObject1 == null) {
        break;
      }
      if (((Fragment)localObject1).isAdded()) {}
      for (;;)
      {
        if (localObject1 == null) {
          break label302;
        }
        localObject2 = com.tencent.mm.ui.component.g.Xox;
        ((h)com.tencent.mm.ui.component.g.h((Fragment)localObject1).i(h.class)).dxh();
        localObject1 = ((com.tencent.mm.plugin.finder.live.view.router.b)locala).getStartUIC();
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).dHn();
        break;
        localObject1 = null;
      }
      break;
    }
  }
  
  public final void bLy()
  {
    AppMethodBeat.i(286745);
    super.bLy();
    this.style = 0;
    Log.i("MiniProgramHalfScreenStatusChangeListener", "onEnterHalfScreen enableMiniWindow:" + this.xWA + '!');
    dwN();
    AppMethodBeat.o(286745);
  }
  
  final void dwN()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(286746);
    if (!this.xWA)
    {
      AppMethodBeat.o(286746);
      return;
    }
    com.tencent.mm.plugin.finder.live.view.a locala = (com.tencent.mm.plugin.finder.live.view.a)this.xWz.get();
    Object localObject3 = new StringBuilder("exitMiniWindow baseLivePluginLayout:");
    if (locala != null) {}
    for (int i = locala.hashCode();; i = 0)
    {
      Log.i("MiniProgramHalfScreenStatusChangeListener", i);
      if (!(locala instanceof com.tencent.mm.plugin.finder.live.view.router.c)) {
        break label167;
      }
      localObject2 = locala.getUicFragment();
      if (localObject2 == null) {
        break label161;
      }
      if (((Fragment)localObject2).isAdded()) {
        localObject1 = localObject2;
      }
      if (localObject1 == null) {
        break label161;
      }
      localObject2 = com.tencent.mm.ui.component.g.Xox;
      ((com.tencent.mm.plugin.finder.live.viewmodel.component.g)com.tencent.mm.ui.component.g.h((Fragment)localObject1).i(com.tencent.mm.plugin.finder.live.viewmodel.component.g.class)).dxk();
      localObject1 = ah.yhC;
      ah.dzE();
      localObject1 = ((com.tencent.mm.plugin.finder.live.view.router.c)locala).getStartUIC();
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.c)localObject1).dHD();
      AppMethodBeat.o(286746);
      return;
    }
    AppMethodBeat.o(286746);
    return;
    label161:
    AppMethodBeat.o(286746);
    return;
    label167:
    if ((locala instanceof com.tencent.mm.plugin.finder.live.view.router.a))
    {
      localObject3 = locala.getUicFragment();
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((Fragment)localObject3).isAdded()) {
          localObject1 = localObject3;
        }
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.ui.component.g.Xox;
          ((i)com.tencent.mm.ui.component.g.h((Fragment)localObject1).i(i.class)).dxk();
          localObject1 = ((com.tencent.mm.plugin.finder.live.view.router.a)locala).getStartUIC();
          if (localObject1 != null)
          {
            ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).pE(true);
            AppMethodBeat.o(286746);
            return;
          }
          AppMethodBeat.o(286746);
          return;
        }
      }
      AppMethodBeat.o(286746);
      return;
    }
    if ((locala instanceof com.tencent.mm.plugin.finder.live.view.router.b))
    {
      localObject1 = locala.getUicFragment();
      if (localObject1 != null)
      {
        if (((Fragment)localObject1).isAdded()) {}
        while (localObject1 != null)
        {
          localObject2 = com.tencent.mm.ui.component.g.Xox;
          ((h)com.tencent.mm.ui.component.g.h((Fragment)localObject1).i(h.class)).dxk();
          localObject1 = ah.yhC;
          ah.dzE();
          AppMethodBeat.o(286746);
          return;
          localObject1 = null;
        }
      }
    }
    AppMethodBeat.o(286746);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/MiniProgramHalfScreenStatusChangeListener$Companion;", "", "()V", "STYLE_FULLSCREEN", "", "STYLE_HALFSCREEN", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.MiniProgramHalfScreenStatusChangeListener
 * JD-Core Version:    0.7.0.1
 */