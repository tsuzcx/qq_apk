package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textureView", "Landroid/view/TextureView;", "getTextureView", "()Landroid/view/TextureView;", "setTextureView", "(Landroid/view/TextureView;)V", "initView", "", "resize", "width", "height", "plugin-finder_release"})
public final class FinderVideoFrameView
  extends FrameLayout
{
  public TextureView bec;
  
  public FinderVideoFrameView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(255015);
    initView();
    AppMethodBeat.o(255015);
  }
  
  public FinderVideoFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(255016);
    initView();
    AppMethodBeat.o(255016);
  }
  
  public FinderVideoFrameView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(255017);
    initView();
    AppMethodBeat.o(255017);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(255014);
    LayoutInflater.from(getContext()).inflate(2131494670, (ViewGroup)this, true);
    View localView = findViewById(2131309768);
    p.g(localView, "findViewById(R.id.video_frame_textureview)");
    this.bec = ((TextureView)localView);
    AppMethodBeat.o(255014);
  }
  
  public final TextureView getTextureView()
  {
    AppMethodBeat.i(255012);
    TextureView localTextureView = this.bec;
    if (localTextureView == null) {
      p.btv("textureView");
    }
    AppMethodBeat.o(255012);
    return localTextureView;
  }
  
  public final void setTextureView(TextureView paramTextureView)
  {
    AppMethodBeat.i(255013);
    p.h(paramTextureView, "<set-?>");
    this.bec = paramTextureView;
    AppMethodBeat.o(255013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderVideoFrameView
 * JD-Core Version:    0.7.0.1
 */