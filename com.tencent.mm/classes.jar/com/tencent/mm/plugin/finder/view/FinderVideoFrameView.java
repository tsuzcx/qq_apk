package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textureView", "Landroid/view/TextureView;", "getTextureView", "()Landroid/view/TextureView;", "setTextureView", "(Landroid/view/TextureView;)V", "initView", "", "resize", "width", "height", "plugin-finder_release"})
public final class FinderVideoFrameView
  extends FrameLayout
{
  public TextureView aST;
  
  public FinderVideoFrameView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(200183);
    initView();
    AppMethodBeat.o(200183);
  }
  
  public FinderVideoFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200184);
    initView();
    AppMethodBeat.o(200184);
  }
  
  public FinderVideoFrameView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200185);
    initView();
    AppMethodBeat.o(200185);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(200182);
    LayoutInflater.from(getContext()).inflate(2131496267, (ViewGroup)this, true);
    View localView = findViewById(2131307915);
    k.g(localView, "findViewById(R.id.video_frame_textureview)");
    this.aST = ((TextureView)localView);
    AppMethodBeat.o(200182);
  }
  
  public final TextureView getTextureView()
  {
    AppMethodBeat.i(200180);
    TextureView localTextureView = this.aST;
    if (localTextureView == null) {
      k.aPZ("textureView");
    }
    AppMethodBeat.o(200180);
    return localTextureView;
  }
  
  public final void setTextureView(TextureView paramTextureView)
  {
    AppMethodBeat.i(200181);
    k.h(paramTextureView, "<set-?>");
    this.aST = paramTextureView;
    AppMethodBeat.o(200181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderVideoFrameView
 * JD-Core Version:    0.7.0.1
 */