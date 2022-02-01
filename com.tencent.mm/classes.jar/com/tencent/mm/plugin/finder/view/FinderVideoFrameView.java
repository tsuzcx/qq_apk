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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textureView", "Landroid/view/TextureView;", "getTextureView", "()Landroid/view/TextureView;", "setTextureView", "(Landroid/view/TextureView;)V", "initView", "", "resize", "width", "height", "plugin-finder_release"})
public final class FinderVideoFrameView
  extends FrameLayout
{
  public TextureView aTL;
  
  public FinderVideoFrameView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(204253);
    initView();
    AppMethodBeat.o(204253);
  }
  
  public FinderVideoFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204254);
    initView();
    AppMethodBeat.o(204254);
  }
  
  public FinderVideoFrameView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204255);
    initView();
    AppMethodBeat.o(204255);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(204252);
    LayoutInflater.from(getContext()).inflate(2131496268, (ViewGroup)this, true);
    View localView = findViewById(2131308058);
    k.g(localView, "findViewById(R.id.video_frame_textureview)");
    this.aTL = ((TextureView)localView);
    AppMethodBeat.o(204252);
  }
  
  public final TextureView getTextureView()
  {
    AppMethodBeat.i(204250);
    TextureView localTextureView = this.aTL;
    if (localTextureView == null) {
      k.aVY("textureView");
    }
    AppMethodBeat.o(204250);
    return localTextureView;
  }
  
  public final void setTextureView(TextureView paramTextureView)
  {
    AppMethodBeat.i(204251);
    k.h(paramTextureView, "<set-?>");
    this.aTL = paramTextureView;
    AppMethodBeat.o(204251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderVideoFrameView
 * JD-Core Version:    0.7.0.1
 */