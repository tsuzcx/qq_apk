package com.tencent.mm.plugin.finder.feed.jumper;

import android.os.Handler;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/BaseJumperEventHandler;", "Lcom/tencent/mm/plugin/finder/feed/jumper/JumperViewEventHandler;", "()V", "delayPreloadTime", "", "getDelayPreloadTime", "()J", "delayPreloadTime$delegate", "Lkotlin/Lazy;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "setHolder", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "isVideoPlayFinished", "", "()Z", "setVideoPlayFinished", "(Z)V", "jumpInfoEx", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoEx;", "getJumpInfoEx", "()Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoEx;", "setJumpInfoEx", "(Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoEx;)V", "preloadRunnable", "Ljava/lang/Runnable;", "getPreloadRunnable", "()Ljava/lang/Runnable;", "preloadRunnable$delegate", "preloadSwitchOn", "getPreloadSwitchOn", "preloadSwitchOn$delegate", "doPreload", "", "getReportType", "", "onClick", "jumpView", "Landroid/view/View;", "infoEx", "onClickAfter", "onClickBefore", "onClickDo", "onDataUpdate", "onDeepEnjoyMedia", "onExposed", "isExposed", "onVideoReplay", "postPreloadTask", "removePreloadTask", "shouldPreload", "shouldPreloadInner", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
  implements s
{
  public static final d.a Bdt;
  private com.tencent.mm.view.recyclerview.j AIz;
  private k Bdu;
  private final kotlin.j Bdv;
  private final kotlin.j Bdw;
  private final kotlin.j Bdx;
  private boolean Bdy;
  private final kotlin.j rdm;
  
  static
  {
    AppMethodBeat.i(364238);
    Bdt = new d.a((byte)0);
    AppMethodBeat.o(364238);
  }
  
  public d()
  {
    AppMethodBeat.i(364205);
    this.Bdv = kotlin.k.cm((a)new d(this));
    this.Bdw = kotlin.k.cm((a)d.e.BdC);
    this.Bdx = kotlin.k.cm((a)d.b.Bdz);
    this.rdm = kotlin.k.cm((a)d.c.BdA);
    AppMethodBeat.o(364205);
  }
  
  private boolean edB()
  {
    AppMethodBeat.i(364231);
    if ((edy()) && (ape()))
    {
      AppMethodBeat.o(364231);
      return true;
    }
    AppMethodBeat.o(364231);
    return false;
  }
  
  private final Runnable edx()
  {
    AppMethodBeat.i(364211);
    Runnable localRunnable = (Runnable)this.Bdv.getValue();
    AppMethodBeat.o(364211);
    return localRunnable;
  }
  
  private final boolean edy()
  {
    AppMethodBeat.i(364216);
    boolean bool = ((Boolean)this.Bdw.getValue()).booleanValue();
    AppMethodBeat.o(364216);
    return bool;
  }
  
  private final long edz()
  {
    AppMethodBeat.i(364220);
    long l = ((Number)this.Bdx.getValue()).longValue();
    AppMethodBeat.o(364220);
    return l;
  }
  
  private final Handler getHandler()
  {
    AppMethodBeat.i(364224);
    Handler localHandler = (Handler)this.rdm.getValue();
    AppMethodBeat.o(364224);
    return localHandler;
  }
  
  public void a(k paramk)
  {
    AppMethodBeat.i(364313);
    kotlin.g.b.s.u(paramk, "infoEx");
    Log.i("BaseJumperEventHandler", "onDataUpdate");
    this.Bdu = paramk;
    AppMethodBeat.o(364313);
  }
  
  public void a(com.tencent.mm.view.recyclerview.j paramj, View paramView, k paramk)
  {
    AppMethodBeat.i(364274);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramView, "jumpView");
    kotlin.g.b.s.u(paramk, "infoEx");
    AppMethodBeat.o(364274);
  }
  
  public void a(boolean paramBoolean, com.tencent.mm.view.recyclerview.j paramj, View paramView, k paramk)
  {
    AppMethodBeat.i(364292);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramView, "jumpView");
    kotlin.g.b.s.u(paramk, "infoEx");
    this.Bdy = false;
    paramk.hYb = edC();
    this.Bdu = paramk;
    this.AIz = paramj;
    if (paramBoolean)
    {
      paramView = e.BdD;
      paramj = paramj.context;
      kotlin.g.b.s.s(paramj, "holder.context");
      int i = edC();
      kotlin.g.b.s.u(paramj, "context");
      kotlin.g.b.s.u(paramk, "infoEx");
      e.a(paramj, "feed_jumpicon", 0, paramk, i, 0, 32);
      if (!edB())
      {
        Log.i("BaseJumperEventHandler", "not preload, delayPreloadTime=" + edz() + " shouldPreload()=" + ape());
        AppMethodBeat.o(364292);
        return;
      }
      paramj = this.Bdu;
      if (paramj == null)
      {
        paramj = null;
        if (!kotlin.g.b.s.p("comment", paramj)) {
          break label206;
        }
        getHandler().post(edx());
      }
      for (;;)
      {
        Log.i("BaseJumperEventHandler", "post preloadRunnable");
        AppMethodBeat.o(364292);
        return;
        paramj = paramj.source;
        break;
        label206:
        getHandler().postDelayed(edx(), edz());
      }
    }
    if (edB())
    {
      getHandler().removeCallbacks(edx());
      Log.i("BaseJumperEventHandler", "remove preloadRunnable");
    }
    AppMethodBeat.o(364292);
  }
  
  public boolean ape()
  {
    return false;
  }
  
  public final void b(com.tencent.mm.view.recyclerview.j paramj, View paramView, k paramk)
  {
    AppMethodBeat.i(364266);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramView, "jumpView");
    kotlin.g.b.s.u(paramk, "infoEx");
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramView, "jumpView");
    kotlin.g.b.s.u(paramk, "infoEx");
    a(paramj, paramView, paramk);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramView, "jumpView");
    kotlin.g.b.s.u(paramk, "infoEx");
    paramView = e.BdD;
    paramj = paramj.context;
    kotlin.g.b.s.s(paramj, "holder.context");
    int i = edC();
    kotlin.g.b.s.u(paramj, "context");
    kotlin.g.b.s.u(paramk, "infoEx");
    e.a(paramj, "feed_jumpicon", 1, paramk, i, 0, 32);
    AppMethodBeat.o(364266);
  }
  
  public final void c(com.tencent.mm.view.recyclerview.j paramj, View paramView, k paramk)
  {
    AppMethodBeat.i(364297);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramView, "jumpView");
    kotlin.g.b.s.u(paramk, "infoEx");
    AppMethodBeat.o(364297);
  }
  
  public final void d(com.tencent.mm.view.recyclerview.j paramj, View paramView, k paramk)
  {
    AppMethodBeat.i(364304);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramView, "jumpView");
    kotlin.g.b.s.u(paramk, "infoEx");
    this.Bdy = true;
    AppMethodBeat.o(364304);
  }
  
  public final boolean edA()
  {
    return this.Bdy;
  }
  
  public int edC()
  {
    return 0;
  }
  
  public void edu() {}
  
  public final com.tencent.mm.view.recyclerview.j edv()
  {
    return this.AIz;
  }
  
  public final k edw()
  {
    return this.Bdu;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/lang/Runnable;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<Runnable>
  {
    d(d paramd)
    {
      super();
    }
    
    private static final void a(d paramd)
    {
      AppMethodBeat.i(364146);
      kotlin.g.b.s.u(paramd, "this$0");
      Log.i("BaseJumperEventHandler", "doPreload");
      paramd.edu();
      AppMethodBeat.o(364146);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.jumper.d
 * JD-Core Version:    0.7.0.1
 */