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
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "pauseMusicListener", "Landroid/view/View$OnClickListener;", "playMusicListener", "player", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "getPlayer", "()Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "setPlayer", "(Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;)V", "bindMusicInfo", "", "initView", "onDetachedFromWindow", "onViewPause", "onViewResume", "onWindowFocusChanged", "hasWindowFocus", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderMusicTopicHeaderView
  extends ConstraintLayout
{
  private View.OnClickListener EED;
  private View.OnClickListener EEE;
  private a EEM;
  private bqj musicInfo;
  
  public FinderMusicTopicHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(330782);
    this.EED = new FinderMusicTopicHeaderView..ExternalSyntheticLambda1(this);
    this.EEE = new FinderMusicTopicHeaderView..ExternalSyntheticLambda0(this);
    ci(paramContext);
    AppMethodBeat.o(330782);
  }
  
  public FinderMusicTopicHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(330793);
    this.EED = new FinderMusicTopicHeaderView..ExternalSyntheticLambda1(this);
    this.EEE = new FinderMusicTopicHeaderView..ExternalSyntheticLambda0(this);
    ci(paramContext);
    AppMethodBeat.o(330793);
  }
  
  private static final void a(FinderMusicTopicHeaderView paramFinderMusicTopicHeaderView, View paramView)
  {
    AppMethodBeat.i(330810);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderMusicTopicHeaderView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderMusicTopicHeaderView, "this$0");
    if (paramFinderMusicTopicHeaderView.getMusicInfo() != null)
    {
      paramView = paramFinderMusicTopicHeaderView.getPlayer();
      if (paramView != null) {
        paramView.play();
      }
      ((WeImageView)paramFinderMusicTopicHeaderView.findViewById(e.e.finder_music_play_iv)).setImageResource(e.g.icons_filled_pause);
      ((FrameLayout)paramFinderMusicTopicHeaderView.findViewById(e.e.finder_music_play_icon_container)).setOnClickListener(paramFinderMusicTopicHeaderView.EEE);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330810);
  }
  
  private static final void b(FinderMusicTopicHeaderView paramFinderMusicTopicHeaderView, View paramView)
  {
    AppMethodBeat.i(330818);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderMusicTopicHeaderView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderMusicTopicHeaderView, "this$0");
    if (paramFinderMusicTopicHeaderView.getMusicInfo() != null)
    {
      paramView = paramFinderMusicTopicHeaderView.getPlayer();
      if (paramView != null) {
        paramView.pause();
      }
      ((WeImageView)paramFinderMusicTopicHeaderView.findViewById(e.e.finder_music_play_iv)).setImageResource(e.g.icons_filled_play);
      ((FrameLayout)paramFinderMusicTopicHeaderView.findViewById(e.e.finder_music_play_icon_container)).setOnClickListener(paramFinderMusicTopicHeaderView.EED);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330818);
  }
  
  private final void ci(Context paramContext)
  {
    AppMethodBeat.i(330801);
    af.mU(paramContext).inflate(e.f.finder_music_topic_feed_header, (ViewGroup)this, true);
    int i = paramContext.getResources().getDimensionPixelOffset(e.c.Edge_1_5_A);
    int j = paramContext.getResources().getDimensionPixelOffset(e.c.Edge_2A);
    setPadding(j, i, j, i);
    AppMethodBeat.o(330801);
  }
  
  public final bqj getMusicInfo()
  {
    return this.musicInfo;
  }
  
  public final a getPlayer()
  {
    return this.EEM;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(330861);
    super.onDetachedFromWindow();
    a locala = this.EEM;
    if (locala != null) {
      locala.release();
    }
    AppMethodBeat.o(330861);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(330854);
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean)
    {
      a locala = this.EEM;
      if ((locala == null) || (locala.isPlaying() != true)) {
        break label74;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        ((FrameLayout)findViewById(e.e.finder_music_play_icon_container)).setOnClickListener(this.EEE);
        ((FrameLayout)findViewById(e.e.finder_music_play_icon_container)).performClick();
      }
      AppMethodBeat.o(330854);
      return;
      label74:
      i = 0;
    }
  }
  
  public final void setMusicInfo(bqj parambqj)
  {
    this.musicInfo = parambqj;
  }
  
  public final void setPlayer(a parama)
  {
    this.EEM = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.music.FinderMusicTopicHeaderView
 * JD-Core Version:    0.7.0.1
 */