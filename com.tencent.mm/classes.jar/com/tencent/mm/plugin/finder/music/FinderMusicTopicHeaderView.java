package com.tencent.mm.plugin.finder.music;

import android.content.Context;
import android.content.res.Resources;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView;", "Landroid/support/constraint/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "pauseMusicListener", "Landroid/view/View$OnClickListener;", "playMusicListener", "player", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "getPlayer", "()Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "setPlayer", "(Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;)V", "bindMusicInfo", "", "initView", "onDetachedFromWindow", "onViewPause", "onViewResume", "onWindowFocusChanged", "hasWindowFocus", "", "plugin-finder_release"})
public final class FinderMusicTopicHeaderView
  extends ConstraintLayout
{
  private HashMap _$_findViewCache;
  private azk musicInfo;
  private a uPD;
  private View.OnClickListener uPn;
  private View.OnClickListener uPo;
  
  public FinderMusicTopicHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(248962);
    this.uPn = ((View.OnClickListener)new b(this));
    this.uPo = ((View.OnClickListener)new a(this));
    bh(paramContext);
    AppMethodBeat.o(248962);
  }
  
  public FinderMusicTopicHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(248963);
    this.uPn = ((View.OnClickListener)new b(this));
    this.uPo = ((View.OnClickListener)new a(this));
    bh(paramContext);
    AppMethodBeat.o(248963);
  }
  
  private final void bh(Context paramContext)
  {
    AppMethodBeat.i(248959);
    aa.jQ(paramContext).inflate(2131494547, (ViewGroup)this, true);
    int i = paramContext.getResources().getDimensionPixelOffset(2131165289);
    int j = paramContext.getResources().getDimensionPixelOffset(2131165296);
    setPadding(j, i, j, i);
    AppMethodBeat.o(248959);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(248964);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(248964);
    return localView1;
  }
  
  public final azk getMusicInfo()
  {
    return this.musicInfo;
  }
  
  public final a getPlayer()
  {
    return this.uPD;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(248961);
    super.onDetachedFromWindow();
    a locala = this.uPD;
    if (locala != null)
    {
      locala.release();
      AppMethodBeat.o(248961);
      return;
    }
    AppMethodBeat.o(248961);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(248960);
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean)
    {
      a locala = this.uPD;
      if (locala == null) {
        break label66;
      }
      if (locala.isPlaying() == true)
      {
        ((FrameLayout)_$_findCachedViewById(2131301374)).setOnClickListener(this.uPo);
        ((FrameLayout)_$_findCachedViewById(2131301374)).performClick();
      }
    }
    AppMethodBeat.o(248960);
    return;
    label66:
    AppMethodBeat.o(248960);
  }
  
  public final void setMusicInfo(azk paramazk)
  {
    this.musicInfo = paramazk;
  }
  
  public final void setPlayer(a parama)
  {
    this.uPD = parama;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderMusicTopicHeaderView paramFinderMusicTopicHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248957);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView$pauseMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (this.uPT.getMusicInfo() != null)
      {
        paramView = this.uPT.getPlayer();
        if (paramView != null) {
          paramView.pause();
        }
        ((WeImageView)this.uPT._$_findCachedViewById(2131301375)).setImageResource(2131690647);
        ((FrameLayout)this.uPT._$_findCachedViewById(2131301374)).setOnClickListener(FinderMusicTopicHeaderView.b(this.uPT));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView$pauseMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248957);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderMusicTopicHeaderView paramFinderMusicTopicHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248958);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView$playMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (this.uPT.getMusicInfo() != null)
      {
        paramView = this.uPT.getPlayer();
        if (paramView != null) {
          paramView.play();
        }
        ((WeImageView)this.uPT._$_findCachedViewById(2131301375)).setImageResource(2131690631);
        ((FrameLayout)this.uPT._$_findCachedViewById(2131301374)).setOnClickListener(FinderMusicTopicHeaderView.a(this.uPT));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView$playMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248958);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.music.FinderMusicTopicHeaderView
 * JD-Core Version:    0.7.0.1
 */