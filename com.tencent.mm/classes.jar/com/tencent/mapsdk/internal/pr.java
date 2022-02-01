package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pr
  extends LinearLayout
{
  private Path a;
  private Paint b;
  private Paint c;
  private RectF d;
  private float e;
  private float f;
  private int g;
  
  public pr(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(225741);
    this.g = -1;
    a();
    AppMethodBeat.o(225741);
  }
  
  private pr(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(225751);
    this.g = -1;
    a();
    AppMethodBeat.o(225751);
  }
  
  private void a()
  {
    AppMethodBeat.i(225758);
    this.f = (getResources().getDisplayMetrics().density / 2.0F);
    this.a = new Path();
    b();
    AppMethodBeat.o(225758);
  }
  
  private void a(Canvas paramCanvas)
  {
    AppMethodBeat.i(225778);
    if (Build.VERSION.SDK_INT <= 27)
    {
      this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      paramCanvas.drawPath(this.a, this.b);
      AppMethodBeat.o(225778);
      return;
    }
    this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    Path localPath = new Path();
    localPath.addRect(0.0F, 0.0F, getWidth(), getHeight(), Path.Direction.CW);
    localPath.op(this.a, Path.Op.DIFFERENCE);
    paramCanvas.drawPath(localPath, this.b);
    AppMethodBeat.o(225778);
  }
  
  private void b()
  {
    AppMethodBeat.i(225767);
    this.b = new Paint();
    this.b.setColor(this.g);
    this.b.setAntiAlias(true);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setShadowLayer(this.f, 0.0F, 0.0F, -1);
    this.c = new Paint();
    this.c.setColor(this.g);
    this.c.setAntiAlias(true);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setShadowLayer(this.f, 0.0F, 0.0F, -16777216);
    AppMethodBeat.o(225767);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(225787);
    super.onDraw(paramCanvas);
    int i = paramCanvas.saveLayer(this.d, null, 31);
    paramCanvas.drawColor(this.g);
    paramCanvas.drawPath(this.a, this.c);
    if (Build.VERSION.SDK_INT <= 27)
    {
      this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      paramCanvas.drawPath(this.a, this.b);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(i);
      AppMethodBeat.o(225787);
      return;
      this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
      Path localPath = new Path();
      localPath.addRect(0.0F, 0.0F, getWidth(), getHeight(), Path.Direction.CW);
      localPath.op(this.a, Path.Op.DIFFERENCE);
      paramCanvas.drawPath(localPath, this.b);
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225801);
    super.onMeasure(paramInt1, paramInt2);
    if (this.d == null) {
      this.d = new RectF();
    }
    this.d.right = getMeasuredWidth();
    this.d.bottom = getMeasuredHeight();
    if (this.d.width() < this.d.height()) {}
    for (this.e = (this.d.width() / 2.0F);; this.e = (this.d.height() / 2.0F))
    {
      this.a.reset();
      this.a.addRoundRect(this.d, this.e, this.e, Path.Direction.CW);
      AppMethodBeat.o(225801);
      return;
    }
  }
  
  public final void setDarkStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(225808);
    if (paramBoolean) {}
    for (this.g = Color.parseColor("#2C2C2C");; this.g = -1)
    {
      b();
      invalidate();
      AppMethodBeat.o(225808);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pr
 * JD-Core Version:    0.7.0.1
 */