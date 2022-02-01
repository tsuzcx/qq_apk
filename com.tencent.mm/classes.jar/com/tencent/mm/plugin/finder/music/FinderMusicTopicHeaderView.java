package com.tencent.mm.plugin.finder.music;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "pauseMusicListener", "Landroid/view/View$OnClickListener;", "playMusicListener", "player", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "getPlayer", "()Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "setPlayer", "(Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;)V", "bindMusicInfo", "", "initView", "onDetachedFromWindow", "onViewPause", "onViewResume", "onWindowFocusChanged", "hasWindowFocus", "", "plugin-finder_release"})
public final class FinderMusicTopicHeaderView
  extends ConstraintLayout
{
  private HashMap _$_findViewCache;
  private bfg musicInfo;
  private View.OnClickListener zBJ;
  private View.OnClickListener zBK;
  private a zBY;
  
  public FinderMusicTopicHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(243309);
    this.zBJ = ((View.OnClickListener)new b(this));
    this.zBK = ((View.OnClickListener)new a(this));
    bv(paramContext);
    AppMethodBeat.o(243309);
  }
  
  public FinderMusicTopicHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(243310);
    this.zBJ = ((View.OnClickListener)new b(this));
    this.zBK = ((View.OnClickListener)new a(this));
    bv(paramContext);
    AppMethodBeat.o(243310);
  }
  
  private final void bv(Context paramContext)
  {
    AppMethodBeat.i(243305);
    ad.kS(paramContext).inflate(b.g.finder_music_topic_feed_header, (ViewGroup)this, true);
    int i = paramContext.getResources().getDimensionPixelOffset(b.d.Edge_1_5_A);
    int j = paramContext.getResources().getDimensionPixelOffset(b.d.Edge_2A);
    setPadding(j, i, j, i);
    AppMethodBeat.o(243305);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(243312);
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
    AppMethodBeat.o(243312);
    return localView1;
  }
  
  public final bfg getMusicInfo()
  {
    return this.musicInfo;
  }
  
  public final a getPlayer()
  {
    return this.zBY;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(243308);
    super.onDetachedFromWindow();
    a locala = this.zBY;
    if (locala != null)
    {
      locala.release();
      AppMethodBeat.o(243308);
      return;
    }
    AppMethodBeat.o(243308);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(243307);
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean)
    {
      a locala = this.zBY;
      if (locala == null) {
        break label68;
      }
      if (locala.isPlaying() == true)
      {
        ((FrameLayout)_$_findCachedViewById(b.f.finder_music_play_icon_container)).setOnClickListener(this.zBK);
        ((FrameLayout)_$_findCachedViewById(b.f.finder_music_play_icon_container)).performClick();
      }
    }
    AppMethodBeat.o(243307);
    return;
    label68:
    AppMethodBeat.o(243307);
  }
  
  public final void setMusicInfo(bfg parambfg)
  {
    this.musicInfo = parambfg;
  }
  
  public final void setPlayer(a parama)
  {
    this.zBY = parama;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderMusicTopicHeaderView paramFinderMusicTopicHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(280017);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView$pauseMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (this.zCr.getMusicInfo() != null)
      {
        paramView = this.zCr.getPlayer();
        if (paramView != null) {
          paramView.pause();
        }
        ((WeImageView)this.zCr._$_findCachedViewById(b.f.finder_music_play_iv)).setImageResource(b.i.icons_filled_play);
        ((FrameLayout)this.zCr._$_findCachedViewById(b.f.finder_music_play_icon_container)).setOnClickListener(FinderMusicTopicHeaderView.b(this.zCr));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView$pauseMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(280017);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderMusicTopicHeaderView paramFinderMusicTopicHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289596);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView$playMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (this.zCr.getMusicInfo() != null)
      {
        paramView = this.zCr.getPlayer();
        if (paramView != null) {
          paramView.play();
        }
        ((WeImageView)this.zCr._$_findCachedViewById(b.f.finder_music_play_iv)).setImageResource(b.i.icons_filled_pause);
        ((FrameLayout)this.zCr._$_findCachedViewById(b.f.finder_music_play_icon_container)).setOnClickListener(FinderMusicTopicHeaderView.a(this.zCr));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView$playMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(289596);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.music.FinderMusicTopicHeaderView
 * JD-Core Version:    0.7.0.1
 */