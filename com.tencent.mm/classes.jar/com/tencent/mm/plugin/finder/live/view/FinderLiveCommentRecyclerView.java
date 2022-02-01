package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCommentRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cropTopLength", "getCropTopLength", "()I", "setCropTopLength", "(I)V", "fadeLength", "getFadeLength", "setFadeLength", "gradientRectTop", "Landroid/graphics/Rect;", "getGradientRectTop", "()Landroid/graphics/Rect;", "gradientRectTop$delegate", "Lkotlin/Lazy;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "onDraw", "c", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveCommentRecyclerView
  extends RecyclerView
{
  private static final FinderLiveCommentRecyclerView.a DMi;
  @Deprecated
  private static final int[] DMn;
  private int DMj;
  private int DMk;
  private final j DMl;
  private final j DMm;
  
  static
  {
    AppMethodBeat.i(358029);
    DMi = new FinderLiveCommentRecyclerView.a((byte)0);
    DMn = new int[] { 0, -16777216 };
    AppMethodBeat.o(358029);
  }
  
  public FinderLiveCommentRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(358000);
    this.DMj = -1;
    this.DMk = -1;
    this.DMl = k.cm((a)c.DMp);
    this.DMm = k.cm((a)FinderLiveCommentRecyclerView.b.DMo);
    AppMethodBeat.o(358000);
  }
  
  public FinderLiveCommentRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(358008);
    this.DMj = -1;
    this.DMk = -1;
    this.DMl = k.cm((a)c.DMp);
    this.DMm = k.cm((a)FinderLiveCommentRecyclerView.b.DMo);
    AppMethodBeat.o(358008);
  }
  
  private final Rect getGradientRectTop()
  {
    AppMethodBeat.i(358022);
    Rect localRect = (Rect)this.DMm.getValue();
    AppMethodBeat.o(358022);
    return localRect;
  }
  
  private final Paint getPaint()
  {
    AppMethodBeat.i(358018);
    Paint localPaint = (Paint)this.DMl.getValue();
    AppMethodBeat.o(358018);
    return localPaint;
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(358080);
    if (paramCanvas == null)
    {
      super.dispatchDraw(paramCanvas);
      AppMethodBeat.o(358080);
      return;
    }
    if ((this.DMj <= 0) || (this.DMk <= 0))
    {
      super.dispatchDraw(paramCanvas);
      AppMethodBeat.o(358080);
      return;
    }
    int i = getPaddingLeft();
    int j = getPaddingTop() + this.DMj;
    int k = getWidth();
    int m = getPaddingRight();
    int n = j + this.DMk;
    getGradientRectTop().set(i, j, k - m, n);
    getPaint().setShader((Shader)new LinearGradient(i, j, i, n, DMn, null, Shader.TileMode.CLAMP));
    i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
    super.dispatchDraw(paramCanvas);
    paramCanvas.drawRect(getGradientRectTop(), getPaint());
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(358080);
  }
  
  public final int getCropTopLength()
  {
    return this.DMj;
  }
  
  public final int getFadeLength()
  {
    return this.DMk;
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(358069);
    super.onDraw(paramCanvas);
    if ((this.DMj > 0) && (paramCanvas != null)) {
      paramCanvas.clipRect(new Rect(0, this.DMj, getWidth(), getHeight()));
    }
    AppMethodBeat.o(358069);
  }
  
  public final void setCropTopLength(int paramInt)
  {
    this.DMj = paramInt;
  }
  
  public final void setFadeLength(int paramInt)
  {
    this.DMk = paramInt;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/Paint;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<Paint>
  {
    public static final c DMp;
    
    static
    {
      AppMethodBeat.i(357749);
      DMp = new c();
      AppMethodBeat.o(357749);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveCommentRecyclerView
 * JD-Core Version:    0.7.0.1
 */