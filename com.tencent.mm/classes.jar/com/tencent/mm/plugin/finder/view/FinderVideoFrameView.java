package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textureView", "Landroid/view/TextureView;", "getTextureView", "()Landroid/view/TextureView;", "setTextureView", "(Landroid/view/TextureView;)V", "initView", "", "resize", "width", "height", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderVideoFrameView
  extends FrameLayout
{
  public TextureView cHz;
  
  public FinderVideoFrameView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(344408);
    initView();
    AppMethodBeat.o(344408);
  }
  
  public FinderVideoFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344419);
    initView();
    AppMethodBeat.o(344419);
  }
  
  public FinderVideoFrameView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344432);
    initView();
    AppMethodBeat.o(344432);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(344446);
    LayoutInflater.from(getContext()).inflate(e.f.finder_video_frame_view_layout, (ViewGroup)this, true);
    View localView = findViewById(e.e.video_frame_textureview);
    s.s(localView, "findViewById(R.id.video_frame_textureview)");
    setTextureView((TextureView)localView);
    AppMethodBeat.o(344446);
  }
  
  public final TextureView getTextureView()
  {
    AppMethodBeat.i(344459);
    TextureView localTextureView = this.cHz;
    if (localTextureView != null)
    {
      AppMethodBeat.o(344459);
      return localTextureView;
    }
    s.bIx("textureView");
    AppMethodBeat.o(344459);
    return null;
  }
  
  public final void setTextureView(TextureView paramTextureView)
  {
    AppMethodBeat.i(344467);
    s.u(paramTextureView, "<set-?>");
    this.cHz = paramTextureView;
    AppMethodBeat.o(344467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderVideoFrameView
 * JD-Core Version:    0.7.0.1
 */