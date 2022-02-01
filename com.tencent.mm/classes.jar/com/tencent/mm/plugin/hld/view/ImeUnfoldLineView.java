package com.tencent.mm.plugin.hld.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.l;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeUnfoldLineView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "arrowWidth", "", "lineHeight", "mContext", "xCoordinate", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "Companion", "plugin-hld_release"})
public final class ImeUnfoldLineView
  extends View
{
  public static final a DJk;
  private float DJi;
  private float DJj;
  private Context mContext;
  private float vaN;
  
  static
  {
    AppMethodBeat.i(212715);
    DJk = new a((byte)0);
    AppMethodBeat.o(212715);
  }
  
  public ImeUnfoldLineView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImeUnfoldLineView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private ImeUnfoldLineView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(212713);
    this.mContext = paramContext;
    if (paramContext == null) {
      p.iCn();
    }
    if (paramContext.obtainStyledAttributes(paramAttributeSet, a.l.ImeUnfoldLineView, paramInt, 0).getInt(a.l.ImeUnfoldLineView_ime_unfold_line_type, 1) == 1) {}
    for (this.DJi = getResources().getDimensionPixelSize(a.d.ime_unfold_logo_divider_arrow_x_coordinate);; this.DJi = (paramContext.getDisplayMetrics().widthPixels - getResources().getDimensionPixelSize(a.d.ime_unfold_emoji_divider_arrow_x_right_coordinate)))
    {
      this.DJj = getResources().getDimensionPixelSize(a.d.ime_unfold_divider_arrow_width);
      this.vaN = getResources().getDimensionPixelSize(a.d.ime_unfold_divider_height);
      AppMethodBeat.o(212713);
      return;
      paramContext = getResources();
      p.j(paramContext, "resources");
    }
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(212709);
    p.k(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(getResources().getColor(a.c.ime_divider_color));
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(getResources().getDimensionPixelSize(a.d.ime_divider_size));
    Path localPath = new Path();
    localPath.moveTo(0.0F, this.vaN);
    localPath.lineTo(this.DJi - this.DJj / 2.0F, this.vaN);
    localPath.lineTo(this.DJi, 0.0F);
    localPath.lineTo(this.DJi + this.DJj / 2.0F, this.vaN);
    Object localObject = getContext();
    p.j(localObject, "context");
    localObject = ((Context)localObject).getResources();
    p.j(localObject, "context.resources");
    localPath.lineTo(((Resources)localObject).getDisplayMetrics().widthPixels, this.vaN);
    paramCanvas.drawPath(localPath, localPaint);
    AppMethodBeat.o(212709);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeUnfoldLineView$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.ImeUnfoldLineView
 * JD-Core Version:    0.7.0.1
 */