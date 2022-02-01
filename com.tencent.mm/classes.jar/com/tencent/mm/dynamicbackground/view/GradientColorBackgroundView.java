package com.tencent.mm.dynamicbackground.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.a.a;
import com.tencent.mm.dynamicbackground.a.a;
import com.tencent.mm.dynamicbackground.a.a.b;
import com.tencent.mm.dynamicbackground.a.a.c;
import com.tencent.mm.dynamicbackground.a.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 11}, iBL={""}, iBM={"Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backGradient", "Landroid/graphics/LinearGradient;", "beginColor", "endColor", "mColorHelper", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "mConfigChanged", "", "mLastUpdateColorTime", "", "needUpdateColor", "paint", "Landroid/graphics/Paint;", "updateMode", "buildGradient", "", "needInvalidate", "init", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setColor", "colorStart", "colorEnd", "setUpdateMode", "Companion", "dynamicbg_release"})
public final class GradientColorBackgroundView
  extends View
{
  public static final GradientColorBackgroundView.a jDB;
  private int beginColor;
  private int endColor;
  private boolean jDA;
  private LinearGradient jDw;
  private boolean jDx;
  private a jDy;
  private long jDz;
  private Paint paint;
  private int updateMode;
  
  static
  {
    AppMethodBeat.i(103125);
    jDB = new GradientColorBackgroundView.a((byte)0);
    AppMethodBeat.o(103125);
  }
  
  public GradientColorBackgroundView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(214081);
    this.paint = new Paint();
    this.beginColor = -5778734;
    this.endColor = -14072734;
    this.jDy = new a();
    this.jDz = -1L;
    this.jDA = true;
    init();
    AppMethodBeat.o(214081);
  }
  
  public GradientColorBackgroundView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103123);
    this.paint = new Paint();
    this.beginColor = -5778734;
    this.endColor = -14072734;
    this.jDy = new a();
    this.jDz = -1L;
    this.jDA = true;
    init();
    AppMethodBeat.o(103123);
  }
  
  public GradientColorBackgroundView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103124);
    this.paint = new Paint();
    this.beginColor = -5778734;
    this.endColor = -14072734;
    this.jDy = new a();
    this.jDz = -1L;
    this.jDA = true;
    init();
    AppMethodBeat.o(103124);
  }
  
  private final void ek(boolean paramBoolean)
  {
    AppMethodBeat.i(214080);
    this.jDw = new LinearGradient(0.0F, 0.0F, getWidth(), getHeight(), this.beginColor, this.endColor, Shader.TileMode.CLAMP);
    this.paint.setShader((Shader)this.jDw);
    if (paramBoolean) {
      invalidate();
    }
    this.jDA = false;
    AppMethodBeat.o(214080);
  }
  
  private final void init()
  {
    AppMethodBeat.i(103119);
    this.updateMode = 1;
    if (this.jDx)
    {
      this.jDy.aAG();
      localObject = a.jBI;
      this.beginColor = a.c.j(this.jDy.jBG.jBN);
      localObject = a.jBI;
      this.endColor = a.c.j(this.jDy.jBG.jBO);
      AppMethodBeat.o(103119);
      return;
    }
    Object localObject = getContext();
    p.j(localObject, "context");
    this.beginColor = ((Context)localObject).getResources().getColor(a.a.dynamic_bg_start_color);
    localObject = getContext();
    p.j(localObject, "context");
    this.endColor = ((Context)localObject).getResources().getColor(a.a.dynamic_bg_end_color);
    AppMethodBeat.o(103119);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(103121);
    super.onDraw(paramCanvas);
    if (this.updateMode == 1) {
      if ((this.jDx) && ((this.jDz == -1L) || (System.currentTimeMillis() - this.jDz >= 60000L)))
      {
        this.jDz = System.currentTimeMillis();
        this.jDy.aAG();
        a.c localc = a.jBI;
        this.beginColor = a.c.j(this.jDy.jBG.jBN);
        localc = a.jBI;
        this.endColor = a.c.j(this.jDy.jBG.jBO);
        ek(false);
      }
    }
    while (paramCanvas != null)
    {
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.paint);
      AppMethodBeat.o(103121);
      return;
      if ((!this.jDx) && (this.jDA))
      {
        ek(true);
        continue;
        if (this.jDA) {
          ek(true);
        }
      }
    }
    AppMethodBeat.o(103121);
  }
  
  public final void setColor(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(214074);
    post((Runnable)new b(this, paramInt1, paramInt2));
    AppMethodBeat.o(214074);
  }
  
  public final void setUpdateMode(int paramInt)
  {
    AppMethodBeat.i(103120);
    c.i("MicroMsg.GradientColorBackgroundView", "alvinluo setUpdateMode: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.updateMode != paramInt)
    {
      this.updateMode = paramInt;
      this.jDz = -1L;
      if (this.jDx)
      {
        this.jDw = null;
        AppMethodBeat.o(103120);
        return;
      }
      ek(true);
    }
    AppMethodBeat.o(103120);
  }
  
  @l(iBK={1, 1, 11}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(GradientColorBackgroundView paramGradientColorBackgroundView, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(214071);
      GradientColorBackgroundView.a(this.jDC, paramInt1);
      GradientColorBackgroundView.b(this.jDC, paramInt2);
      GradientColorBackgroundView.a(this.jDC);
      AppMethodBeat.o(214071);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView
 * JD-Core Version:    0.7.0.1
 */