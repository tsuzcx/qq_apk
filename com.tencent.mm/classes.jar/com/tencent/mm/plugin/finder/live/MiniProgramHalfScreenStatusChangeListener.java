package com.tencent.mm.plugin.finder.live;

import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WeAppHalfScreenStatusChangeListener;
import com.tencent.mm.plugin.finder.live.component.q;
import com.tencent.mm.plugin.finder.live.component.r;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.view.router.c;
import com.tencent.mm.plugin.finder.live.viewmodel.component.i;
import com.tencent.mm.plugin.findersdk.a.ci;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/MiniProgramHalfScreenStatusChangeListener;", "Lcom/tencent/mm/plugin/appbrand/config/WeAppHalfScreenStatusChangeListener;", "Lcom/tencent/mm/plugin/findersdk/api/IMiniProgramHalfScreenStatusChangeListener;", "basePluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "(Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;)V", "rBasePluginLayout", "Ljava/lang/ref/WeakReference;", "style", "", "exitMiniPro", "", "exitMiniWindow", "onEnterFullScreen", "onEnterHalfScreen", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MiniProgramHalfScreenStatusChangeListener
  extends WeAppHalfScreenStatusChangeListener
  implements ci
{
  public static final MiniProgramHalfScreenStatusChangeListener.a Bxs;
  private WeakReference<com.tencent.mm.plugin.finder.live.view.a> Bxt;
  private int style;
  
  static
  {
    AppMethodBeat.i(350715);
    Bxs = new MiniProgramHalfScreenStatusChangeListener.a((byte)0);
    AppMethodBeat.o(350715);
  }
  
  public MiniProgramHalfScreenStatusChangeListener(com.tencent.mm.plugin.finder.live.view.a parama)
  {
    AppMethodBeat.i(350691);
    this.Bxt = new WeakReference(parama);
    AppMethodBeat.o(350691);
  }
  
  private final void ehg()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    AppMethodBeat.i(350710);
    com.tencent.mm.plugin.finder.live.view.a locala = (com.tencent.mm.plugin.finder.live.view.a)this.Bxt.get();
    if (locala != null) {}
    Object localObject2;
    for (int i = locala.hashCode();; i = 0)
    {
      Log.i("MiniProgramHalfScreenStatusChangeListener", s.X("exitMiniWindow baseLivePluginLayout:", Integer.valueOf(i)));
      if (!(locala instanceof c)) {
        break;
      }
      localObject2 = ((c)locala).getUicFragment();
      if (localObject2 == null) {
        break label273;
      }
      if (((Fragment)localObject2).isAdded()) {
        localObject1 = localObject2;
      }
      if (localObject1 == null) {
        break label273;
      }
      localObject2 = k.aeZF;
      ((i)k.y((Fragment)localObject1).q(i.class)).ehR();
      localObject1 = aj.CGT;
      aj.elP();
      localObject1 = ((c)locala).getStartUIC();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.b)localObject1).ezQ();
      }
      AppMethodBeat.o(350710);
      return;
    }
    if ((locala instanceof com.tencent.mm.plugin.finder.live.view.router.a))
    {
      localObject2 = ((com.tencent.mm.plugin.finder.live.view.router.a)locala).getUicFragment();
      if (localObject2 != null)
      {
        localObject1 = localObject3;
        if (((Fragment)localObject2).isAdded()) {
          localObject1 = localObject2;
        }
        if (localObject1 != null)
        {
          localObject2 = k.aeZF;
          ((r)k.y((Fragment)localObject1).q(r.class)).ehR();
          localObject1 = ((com.tencent.mm.plugin.finder.live.view.router.a)locala).getStartUIC();
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).su(true);
          }
          AppMethodBeat.o(350710);
        }
      }
    }
    else if ((locala instanceof com.tencent.mm.plugin.finder.live.view.router.b))
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.view.router.b)locala).getUicFragment();
      if (localObject1 != null) {
        if (!((Fragment)localObject1).isAdded()) {
          break label279;
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = k.aeZF;
        ((q)k.y((Fragment)localObject1).q(q.class)).ehR();
        localObject1 = aj.CGT;
        aj.elP();
      }
      label273:
      AppMethodBeat.o(350710);
      return;
      label279:
      localObject1 = null;
    }
  }
  
  public final void ckU()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    AppMethodBeat.i(350723);
    super.ckU();
    this.style = 1;
    com.tencent.mm.plugin.finder.live.view.a locala = (com.tencent.mm.plugin.finder.live.view.a)this.Bxt.get();
    Object localObject2;
    if ((locala instanceof c))
    {
      localObject2 = ((c)locala).getUicFragment();
      if (localObject2 != null)
      {
        if (((Fragment)localObject2).isAdded()) {
          localObject1 = localObject2;
        }
        if (localObject1 != null)
        {
          localObject2 = k.aeZF;
          ((i)k.y((Fragment)localObject1).q(i.class)).ehO();
          localObject1 = ((c)locala).getStartUIC();
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.b)localObject1).ezw();
          }
        }
      }
      if (locala == null) {
        break label284;
      }
    }
    label282:
    label284:
    for (int i = locala.hashCode();; i = 0)
    {
      Log.i("MiniProgramHalfScreenStatusChangeListener", s.X("onEnterFullScreen baseLivePluginLayout:", Integer.valueOf(i)));
      AppMethodBeat.o(350723);
      return;
      if ((locala instanceof com.tencent.mm.plugin.finder.live.view.router.a))
      {
        localObject2 = ((com.tencent.mm.plugin.finder.live.view.router.a)locala).getUicFragment();
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
        localObject2 = k.aeZF;
        ((r)k.y((Fragment)localObject1).q(r.class)).ehO();
        localObject1 = ((com.tencent.mm.plugin.finder.live.view.router.a)locala).getStartUIC();
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).ezw();
        break;
      }
      if (!(locala instanceof com.tencent.mm.plugin.finder.live.view.router.b)) {
        break;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.view.router.b)locala).getUicFragment();
      if (localObject1 == null) {
        break;
      }
      if (((Fragment)localObject1).isAdded()) {}
      for (;;)
      {
        if (localObject1 == null) {
          break label282;
        }
        localObject2 = k.aeZF;
        ((q)k.y((Fragment)localObject1).q(q.class)).ehO();
        localObject1 = ((com.tencent.mm.plugin.finder.live.view.router.b)locala).getStartUIC();
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).ezw();
        break;
        localObject1 = null;
      }
      break;
    }
  }
  
  public final void ckV()
  {
    AppMethodBeat.i(350730);
    super.ckV();
    this.style = 0;
    Log.i("MiniProgramHalfScreenStatusChangeListener", "onEnterHalfScreen!");
    ehg();
    AppMethodBeat.o(350730);
  }
  
  public final void ehf()
  {
    AppMethodBeat.i(350738);
    Log.i("MiniProgramHalfScreenStatusChangeListener", "exitMiniPro style:" + this.style + '!');
    if (this.style == 1) {
      ehg();
    }
    AppMethodBeat.o(350738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.MiniProgramHalfScreenStatusChangeListener
 * JD-Core Version:    0.7.0.1
 */