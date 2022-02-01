package com.tencent.mm.plugin.finder.megavideo.bullet;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bulletManager", "Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager;", "getBulletManager", "()Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager;", "feed", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;)V", "playStatusListener", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "getPlayStatusListener", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "onAttach", "", "onBind", "onConfigurationChange", "isLandscape", "", "onDetach", "onDetachedFromWindow", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
public final class MegaVideoBulletView
  extends TextureView
{
  public bm uKb;
  private final a uKc;
  private final FinderLongVideoPlayerSeekBar.b uKd;
  
  public MegaVideoBulletView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(248274);
    this.uKc = new a((View)this);
    this.uKd = ((FinderLongVideoPlayerSeekBar.b)new a(this));
    AppMethodBeat.o(248274);
  }
  
  public MegaVideoBulletView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(248275);
    this.uKc = new a((View)this);
    this.uKd = ((FinderLongVideoPlayerSeekBar.b)new a(this));
    AppMethodBeat.o(248275);
  }
  
  public final a getBulletManager()
  {
    return this.uKc;
  }
  
  public final bm getFeed()
  {
    AppMethodBeat.i(248270);
    bm localbm = this.uKb;
    if (localbm == null) {
      p.btv("feed");
    }
    AppMethodBeat.o(248270);
    return localbm;
  }
  
  public final FinderLongVideoPlayerSeekBar.b getPlayStatusListener()
  {
    return this.uKd;
  }
  
  protected final void onDetachedFromWindow()
  {
    int i = 0;
    AppMethodBeat.i(248273);
    super.onDetachedFromWindow();
    a locala = this.uKc;
    if ((((a)locala).uJO == null) || (!locala.iuM))
    {
      AppMethodBeat.o(248273);
      return;
    }
    locala.iuM = false;
    Object localObject1 = new StringBuilder("onDetach: id = ");
    Object localObject2 = locala.uJO;
    if (localObject2 == null) {
      p.btv("megaVideoFeed");
    }
    Log.i("MegaVideoBulletManager", ((bm)localObject2).lT() + "， this=" + locala.hashCode());
    localObject1 = locala.uJP;
    if (localObject1 == null) {
      p.btv("danmakuManager");
    }
    ((com.tencent.mm.danmaku.a.g)localObject1).release();
    localObject1 = locala.uJQ;
    if (localObject1 == null) {
      p.btv("bulletLoader");
    }
    ((com.tencent.mm.plugin.finder.megavideo.loader.a)localObject1).context = null;
    localObject2 = new StringBuilder("onDetach ");
    Object localObject3 = ((com.tencent.mm.plugin.finder.megavideo.loader.a)localObject1).uJO;
    if (localObject3 == null) {
      p.btv("megaVideoFeed");
    }
    localObject2 = ((StringBuilder)localObject2).append(localObject3).append(' ');
    localObject3 = ((com.tencent.mm.plugin.finder.megavideo.loader.a)localObject1).uLj;
    if (localObject3 != null) {
      i = localObject3.hashCode();
    }
    Log.i("Finder.MegaVideoBulletLoader", i);
    com.tencent.mm.kernel.g.azz().b(6865, (i)localObject1);
    com.tencent.mm.kernel.g.azz().b(4101, (i)locala);
    AppMethodBeat.o(248273);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(248272);
    p.h(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      com.tencent.mm.danmaku.a.g localg = this.uKc.uJP;
      if (localg == null) {
        p.btv("danmakuManager");
      }
      localg.c(new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY() + (int)getY()));
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(248272);
    return bool;
  }
  
  public final void setFeed(bm parambm)
  {
    AppMethodBeat.i(248271);
    p.h(parambm, "<set-?>");
    this.uKb = parambm;
    AppMethodBeat.o(248271);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletView$playStatusListener$1", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "onPlayStatusChange", "", "isPlay", "", "onProgress", "times", "", "onSeekTo", "timeStamp", "", "plugin-finder_release"})
  public static final class a
    implements FinderLongVideoPlayerSeekBar.b
  {
    public final void kr(final boolean paramBoolean)
    {
      AppMethodBeat.i(248267);
      d.h((kotlin.g.a.a)new a(this, paramBoolean));
      AppMethodBeat.o(248267);
    }
    
    public final void onProgress(final long paramLong)
    {
      AppMethodBeat.i(248268);
      d.h((kotlin.g.a.a)new b(this, paramLong));
      AppMethodBeat.o(248268);
    }
    
    public final void rk(final int paramInt)
    {
      AppMethodBeat.i(248269);
      d.h((kotlin.g.a.a)new c(this, paramInt));
      AppMethodBeat.o(248269);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(MegaVideoBulletView.a parama, boolean paramBoolean)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(MegaVideoBulletView.a parama, long paramLong)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<x>
    {
      c(MegaVideoBulletView.a parama, int paramInt)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.bullet.MegaVideoBulletView
 * JD-Core Version:    0.7.0.1
 */