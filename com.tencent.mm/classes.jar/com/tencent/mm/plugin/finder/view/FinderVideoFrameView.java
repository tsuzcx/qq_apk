package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textureView", "Landroid/view/TextureView;", "getTextureView", "()Landroid/view/TextureView;", "setTextureView", "(Landroid/view/TextureView;)V", "initView", "", "resize", "width", "height", "plugin-finder_release"})
public final class FinderVideoFrameView
  extends FrameLayout
{
  public TextureView bef;
  
  public FinderVideoFrameView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(205233);
    initView();
    AppMethodBeat.o(205233);
  }
  
  public FinderVideoFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205234);
    initView();
    AppMethodBeat.o(205234);
  }
  
  public FinderVideoFrameView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205235);
    initView();
    AppMethodBeat.o(205235);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(205232);
    LayoutInflater.from(getContext()).inflate(2131496268, (ViewGroup)this, true);
    View localView = findViewById(2131308058);
    p.g(localView, "findViewById(R.id.video_frame_textureview)");
    this.bef = ((TextureView)localView);
    AppMethodBeat.o(205232);
  }
  
  public final TextureView getTextureView()
  {
    AppMethodBeat.i(205230);
    TextureView localTextureView = this.bef;
    if (localTextureView == null) {
      p.bcb("textureView");
    }
    AppMethodBeat.o(205230);
    return localTextureView;
  }
  
  public final void setTextureView(TextureView paramTextureView)
  {
    AppMethodBeat.i(205231);
    p.h(paramTextureView, "<set-?>");
    this.bef = paramTextureView;
    AppMethodBeat.o(205231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderVideoFrameView
 * JD-Core Version:    0.7.0.1
 */