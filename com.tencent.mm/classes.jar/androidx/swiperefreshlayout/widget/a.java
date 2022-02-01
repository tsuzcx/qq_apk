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
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
  extends ImageView
{
  Animation.AnimationListener ccK;
  int ccL;
  
  a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(193233);
    float f = getContext().getResources().getDisplayMetrics().density;
    int i = (int)(1.75F * f);
    int j = (int)(0.0F * f);
    this.ccL = ((int)(3.5F * f));
    if (Lx())
    {
      paramContext = new ShapeDrawable(new OvalShape());
      z.k(this, f * 4.0F);
    }
    for (;;)
    {
      paramContext.getPaint().setColor(-328966);
      z.a(this, paramContext);
      AppMethodBeat.o(193233);
      return;
      paramContext = new ShapeDrawable(new a(this.ccL));
      setLayerType(1, paramContext.getPaint());
      paramContext.getPaint().setShadowLayer(this.ccL, j, i, 503316480);
      i = this.ccL;
      setPadding(i, i, i, i);
    }
  }
  
  private static boolean Lx()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public final void onAnimationEnd()
  {
    AppMethodBeat.i(193260);
    super.onAnimationEnd();
    if (this.ccK != null) {
      this.ccK.onAnimationEnd(getAnimation());
    }
    AppMethodBeat.o(193260);
  }
  
  public final void onAnimationStart()
  {
    AppMethodBeat.i(193255);
    super.onAnimationStart();
    if (this.ccK != null) {
      this.ccK.onAnimationStart(getAnimation());
    }
    AppMethodBeat.o(193255);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193247);
    super.onMeasure(paramInt1, paramInt2);
    if (!Lx()) {
      setMeasuredDimension(getMeasuredWidth() + this.ccL * 2, getMeasuredHeight() + this.ccL * 2);
    }
    AppMethodBeat.o(193247);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(193268);
    if ((getBackground() instanceof ShapeDrawable)) {
      ((ShapeDrawable)getBackground()).getPaint().setColor(paramInt);
    }
    AppMethodBeat.o(193268);
  }
  
  final class a
    extends OvalShape
  {
    private RadialGradient ccM;
    private Paint ccN;
    
    a(int paramInt)
    {
      AppMethodBeat.i(193242);
      this.ccN = new Paint();
      a.this.ccL = paramInt;
      gE((int)rect().width());
      AppMethodBeat.o(193242);
    }
    
    private void gE(int paramInt)
    {
      AppMethodBeat.i(193246);
      float f1 = paramInt / 2;
      float f2 = paramInt / 2;
      float f3 = a.this.ccL;
      Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
      this.ccM = new RadialGradient(f1, f2, f3, new int[] { 1023410176, 0 }, null, localTileMode);
      this.ccN.setShader(this.ccM);
      AppMethodBeat.o(193246);
    }
    
    public final void draw(Canvas paramCanvas, Paint paramPaint)
    {
      AppMethodBeat.i(193261);
      int i = a.this.getWidth();
      int j = a.this.getHeight();
      paramCanvas.drawCircle(i / 2, j / 2, i / 2, this.ccN);
      paramCanvas.drawCircle(i / 2, j / 2, i / 2 - a.this.ccL, paramPaint);
      AppMethodBeat.o(193261);
    }
    
    protected final void onResize(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(193254);
      super.onResize(paramFloat1, paramFloat2);
      gE((int)paramFloat1);
      AppMethodBeat.o(193254);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.swiperefreshlayout.widget.a
 * JD-Core Version:    0.7.0.1
 */