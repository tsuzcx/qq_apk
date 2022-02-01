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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/view/ImeUnfoldLineView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "arrowWidth", "", "lineHeight", "mContext", "xCoordinate", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeUnfoldLineView
  extends View
{
  public static final ImeUnfoldLineView.a JAk;
  private float JAl;
  private float JAm;
  private Context mContext;
  private float ymJ;
  
  static
  {
    AppMethodBeat.i(312538);
    JAk = new ImeUnfoldLineView.a((byte)0);
    AppMethodBeat.o(312538);
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
    AppMethodBeat.i(312522);
    this.mContext = paramContext;
    s.checkNotNull(paramContext);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.l.ImeUnfoldLineView, paramInt, 0);
    s.s(paramContext, "context!!.obtainStyledAt…ineView, defStyleAttr, 0)");
    if (paramContext.getInt(a.l.ImeUnfoldLineView_ime_unfold_line_type, 1) == 1) {}
    for (this.JAl = getResources().getDimensionPixelSize(a.d.ime_unfold_logo_divider_arrow_x_coordinate);; this.JAl = (getResources().getDisplayMetrics().widthPixels - getResources().getDimensionPixelSize(a.d.ime_unfold_emoji_divider_arrow_x_right_coordinate)))
    {
      this.JAm = getResources().getDimensionPixelSize(a.d.ime_unfold_divider_arrow_width);
      this.ymJ = getResources().getDimensionPixelSize(a.d.ime_unfold_divider_height);
      AppMethodBeat.o(312522);
      return;
    }
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(312557);
    s.u(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(getResources().getColor(a.c.ime_divider_color));
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(getResources().getDimensionPixelSize(a.d.ime_divider_size));
    Path localPath = new Path();
    localPath.moveTo(0.0F, this.ymJ);
    localPath.lineTo(this.JAl - this.JAm / 2.0F, this.ymJ);
    localPath.lineTo(this.JAl, 0.0F);
    localPath.lineTo(this.JAl + this.JAm / 2.0F, this.ymJ);
    localPath.lineTo(getContext().getResources().getDisplayMetrics().widthPixels, this.ymJ);
    paramCanvas.drawPath(localPath, localPaint);
    AppMethodBeat.o(312557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.ImeUnfoldLineView
 * JD-Core Version:    0.7.0.1
 */