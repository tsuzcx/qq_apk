package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
  extends ImageView
{
  Animation.AnimationListener aoa;
  int aob;
  
  a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(256291);
    float f = getContext().getResources().getDisplayMetrics().density;
    int i = (int)(1.75F * f);
    int j = (int)(0.0F * f);
    this.aob = ((int)(3.5F * f));
    if (mV())
    {
      paramContext = new ShapeDrawable(new OvalShape());
      w.j(this, f * 4.0F);
    }
    for (;;)
    {
      paramContext.getPaint().setColor(-328966);
      w.a(this, paramContext);
      AppMethodBeat.o(256291);
      return;
      paramContext = new ShapeDrawable(new a(this.aob));
      setLayerType(1, paramContext.getPaint());
      paramContext.getPaint().setShadowLayer(this.aob, j, i, 503316480);
      i = this.aob;
      setPadding(i, i, i, i);
    }
  }
  
  private static boolean mV()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public final void onAnimationEnd()
  {
    AppMethodBeat.i(256294);
    super.onAnimationEnd();
    if (this.aoa != null) {
      this.aoa.onAnimationEnd(getAnimation());
    }
    AppMethodBeat.o(256294);
  }
  
  public final void onAnimationStart()
  {
    AppMethodBeat.i(256293);
    super.onAnimationStart();
    if (this.aoa != null) {
      this.aoa.onAnimationStart(getAnimation());
    }
    AppMethodBeat.o(256293);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256292);
    super.onMeasure(paramInt1, paramInt2);
    if (!mV()) {
      setMeasuredDimension(getMeasuredWidth() + this.aob * 2, getMeasuredHeight() + this.aob * 2);
    }
    AppMethodBeat.o(256292);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(256295);
    if ((getBackground() instanceof ShapeDrawable)) {
      ((ShapeDrawable)getBackground()).getPaint().setColor(paramInt);
    }
    AppMethodBeat.o(256295);
  }
  
  final class a
    extends OvalShape
  {
    private RadialGradient aoc;
    private Paint aod;
    
    a(int paramInt)
    {
      AppMethodBeat.i(256285);
      this.aod = new Paint();
      a.this.aob = paramInt;
      du((int)rect().width());
      AppMethodBeat.o(256285);
    }
    
    private void du(int paramInt)
    {
      AppMethodBeat.i(256289);
      float f1 = paramInt / 2;
      float f2 = paramInt / 2;
      float f3 = a.this.aob;
      Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
      this.aoc = new RadialGradient(f1, f2, f3, new int[] { 1023410176, 0 }, null, localTileMode);
      this.aod.setShader(this.aoc);
      AppMethodBeat.o(256289);
    }
    
    public final void draw(Canvas paramCanvas, Paint paramPaint)
    {
      AppMethodBeat.i(256288);
      int i = a.this.getWidth();
      int j = a.this.getHeight();
      paramCanvas.drawCircle(i / 2, j / 2, i / 2, this.aod);
      paramCanvas.drawCircle(i / 2, j / 2, i / 2 - a.this.aob, paramPaint);
      AppMethodBeat.o(256288);
    }
    
    protected final void onResize(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(256287);
      super.onResize(paramFloat1, paramFloat2);
      du((int)paramFloat1);
      AppMethodBeat.o(256287);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.swiperefreshlayout.widget.a
 * JD-Core Version:    0.7.0.1
 */