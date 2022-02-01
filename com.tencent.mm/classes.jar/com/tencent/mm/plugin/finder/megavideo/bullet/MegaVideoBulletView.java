package com.tencent.mm.plugin.finder.megavideo.bullet;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.danmaku.a.g;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bulletManager", "Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager;", "getBulletManager", "()Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager;", "feed", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;)V", "playStatusListener", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "getPlayStatusListener", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "onAttach", "", "onBind", "onConfigurationChange", "isLandscape", "", "currRatio", "", "onDetach", "onDetachedFromWindow", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
public final class MegaVideoBulletView
  extends TextureView
{
  public bs zvJ;
  public final a zvK;
  private final FinderLongVideoPlayerSeekBar.b zvL;
  
  public MegaVideoBulletView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(291732);
    this.zvK = new a((View)this);
    this.zvL = ((FinderLongVideoPlayerSeekBar.b)new a(this));
    AppMethodBeat.o(291732);
  }
  
  public MegaVideoBulletView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(291733);
    this.zvK = new a((View)this);
    this.zvL = ((FinderLongVideoPlayerSeekBar.b)new a(this));
    AppMethodBeat.o(291733);
  }
  
  public final a getBulletManager()
  {
    return this.zvK;
  }
  
  public final bs getFeed()
  {
    AppMethodBeat.i(291728);
    bs localbs = this.zvJ;
    if (localbs == null) {
      p.bGy("feed");
    }
    AppMethodBeat.o(291728);
    return localbs;
  }
  
  public final FinderLongVideoPlayerSeekBar.b getPlayStatusListener()
  {
    return this.zvL;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(291731);
    super.onDetachedFromWindow();
    a locala = this.zvK;
    if ((((a)locala).zvv == null) || (!locala.ljV))
    {
      AppMethodBeat.o(291731);
      return;
    }
    locala.ljV = false;
    Object localObject = new StringBuilder("onDetach: id = ");
    bs localbs = locala.zvv;
    if (localbs == null) {
      p.bGy("megaVideoFeed");
    }
    Log.i("MegaVideoBulletManager", localbs.mf() + "， this=" + locala.hashCode());
    localObject = locala.zvw;
    if (localObject == null) {
      p.bGy("danmakuManager");
    }
    ((g)localObject).release();
    if (locala.zvx == null) {
      p.bGy("bulletLoader");
    }
    AppMethodBeat.o(291731);
    throw null;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(291730);
    p.k(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      g localg = this.zvK.zvw;
      if (localg == null) {
        p.bGy("danmakuManager");
      }
      localg.c(new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY() + (int)getY()));
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(291730);
    return bool;
  }
  
  public final void setFeed(bs parambs)
  {
    AppMethodBeat.i(291729);
    p.k(parambs, "<set-?>");
    this.zvJ = parambs;
    AppMethodBeat.o(291729);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletView$playStatusListener$1", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "onPlayStatusChange", "", "isPlay", "", "onProgress", "times", "", "onReplay", "onSeekTo", "timeStamp", "", "plugin-finder_release"})
  public static final class a
    implements FinderLongVideoPlayerSeekBar.b
  {
    public final void LX(final long paramLong)
    {
      AppMethodBeat.i(289569);
      d.uiThread((kotlin.g.a.a)new b(this, paramLong));
      AppMethodBeat.o(289569);
    }
    
    public final void dJB()
    {
      AppMethodBeat.i(289571);
      d.uiThread((kotlin.g.a.a)new c(this));
      AppMethodBeat.o(289571);
    }
    
    public final void lE(final boolean paramBoolean)
    {
      AppMethodBeat.i(289568);
      d.uiThread((kotlin.g.a.a)new a(this, paramBoolean));
      AppMethodBeat.o(289568);
    }
    
    public final void tY(final int paramInt)
    {
      AppMethodBeat.i(289570);
      d.uiThread((kotlin.g.a.a)new d(this, paramInt));
      AppMethodBeat.o(289570);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(MegaVideoBulletView.a parama, boolean paramBoolean)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(MegaVideoBulletView.a parama, long paramLong)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<x>
    {
      c(MegaVideoBulletView.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements kotlin.g.a.a<x>
    {
      d(MegaVideoBulletView.a parama, int paramInt)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.bullet.MegaVideoBulletView
 * JD-Core Version:    0.7.0.1
 */