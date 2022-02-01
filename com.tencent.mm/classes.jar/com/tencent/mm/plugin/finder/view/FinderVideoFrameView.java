package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textureView", "Landroid/view/TextureView;", "getTextureView", "()Landroid/view/TextureView;", "setTextureView", "(Landroid/view/TextureView;)V", "initView", "", "resize", "width", "height", "plugin-finder_release"})
public final class FinderVideoFrameView
  extends FrameLayout
{
  public TextureView aND;
  
  public FinderVideoFrameView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(277728);
    initView();
    AppMethodBeat.o(277728);
  }
  
  public FinderVideoFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(277729);
    initView();
    AppMethodBeat.o(277729);
  }
  
  public FinderVideoFrameView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(277730);
    initView();
    AppMethodBeat.o(277730);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(277727);
    LayoutInflater.from(getContext()).inflate(b.g.finder_video_frame_view_layout, (ViewGroup)this, true);
    View localView = findViewById(b.f.video_frame_textureview);
    p.j(localView, "findViewById(R.id.video_frame_textureview)");
    this.aND = ((TextureView)localView);
    AppMethodBeat.o(277727);
  }
  
  public final TextureView getTextureView()
  {
    AppMethodBeat.i(277725);
    TextureView localTextureView = this.aND;
    if (localTextureView == null) {
      p.bGy("textureView");
    }
    AppMethodBeat.o(277725);
    return localTextureView;
  }
  
  public final void setTextureView(TextureView paramTextureView)
  {
    AppMethodBeat.i(277726);
    p.k(paramTextureView, "<set-?>");
    this.aND = paramTextureView;
    AppMethodBeat.o(277726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderVideoFrameView
 * JD-Core Version:    0.7.0.1
 */