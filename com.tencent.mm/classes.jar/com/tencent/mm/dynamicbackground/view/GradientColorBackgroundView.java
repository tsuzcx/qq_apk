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
import com.tencent.mm.dynamicbackground.a.a.b;
import com.tencent.mm.dynamicbackground.a.a.c;
import com.tencent.mm.dynamicbackground.a.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 11}, hxE={""}, hxF={"Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backGradient", "Landroid/graphics/LinearGradient;", "beginColor", "endColor", "mColorHelper", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "mConfigChanged", "", "mLastUpdateColorTime", "", "needUpdateColor", "paint", "Landroid/graphics/Paint;", "updateMode", "buildGradient", "", "needInvalidate", "init", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setColor", "colorStart", "colorEnd", "setUpdateMode", "Companion", "dynamicbg_release"})
public final class GradientColorBackgroundView
  extends View
{
  public static final GradientColorBackgroundView.a gTc;
  private int beginColor;
  private int endColor;
  private LinearGradient gSX;
  private boolean gSY;
  private a gSZ;
  private long gTa;
  private boolean gTb;
  private Paint paint;
  private int updateMode;
  
  static
  {
    AppMethodBeat.i(103125);
    gTc = new GradientColorBackgroundView.a((byte)0);
    AppMethodBeat.o(103125);
  }
  
  public GradientColorBackgroundView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(230550);
    this.paint = new Paint();
    this.beginColor = -5778734;
    this.endColor = -14072734;
    this.gSZ = new a();
    this.gTa = -1L;
    this.gTb = true;
    init();
    AppMethodBeat.o(230550);
  }
  
  public GradientColorBackgroundView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103123);
    this.paint = new Paint();
    this.beginColor = -5778734;
    this.endColor = -14072734;
    this.gSZ = new a();
    this.gTa = -1L;
    this.gTb = true;
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
    this.gSZ = new a();
    this.gTa = -1L;
    this.gTb = true;
    init();
    AppMethodBeat.o(103124);
  }
  
  private final void dL(boolean paramBoolean)
  {
    AppMethodBeat.i(230549);
    this.gSX = new LinearGradient(0.0F, 0.0F, getWidth(), getHeight(), this.beginColor, this.endColor, Shader.TileMode.CLAMP);
    this.paint.setShader((Shader)this.gSX);
    if (paramBoolean) {
      invalidate();
    }
    this.gTb = false;
    AppMethodBeat.o(230549);
  }
  
  private final void init()
  {
    AppMethodBeat.i(103119);
    this.updateMode = 1;
    if (this.gSY)
    {
      this.gSZ.atO();
      localObject = a.gRm;
      this.beginColor = a.c.j(this.gSZ.gRk.gRr);
      localObject = a.gRm;
      this.endColor = a.c.j(this.gSZ.gRk.gRs);
      AppMethodBeat.o(103119);
      return;
    }
    Object localObject = getContext();
    p.g(localObject, "context");
    this.beginColor = ((Context)localObject).getResources().getColor(2131100297);
    localObject = getContext();
    p.g(localObject, "context");
    this.endColor = ((Context)localObject).getResources().getColor(2131100296);
    AppMethodBeat.o(103119);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(103121);
    super.onDraw(paramCanvas);
    if (this.updateMode == 1) {
      if ((this.gSY) && ((this.gTa == -1L) || (System.currentTimeMillis() - this.gTa >= 60000L)))
      {
        this.gTa = System.currentTimeMillis();
        this.gSZ.atO();
        a.c localc = a.gRm;
        this.beginColor = a.c.j(this.gSZ.gRk.gRr);
        localc = a.gRm;
        this.endColor = a.c.j(this.gSZ.gRk.gRs);
        dL(false);
      }
    }
    while (paramCanvas != null)
    {
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.paint);
      AppMethodBeat.o(103121);
      return;
      if ((!this.gSY) && (this.gTb))
      {
        dL(true);
        continue;
        if (this.gTb) {
          dL(true);
        }
      }
    }
    AppMethodBeat.o(103121);
  }
  
  public final void setColor(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(230548);
    post((Runnable)new b(this, paramInt1, paramInt2));
    AppMethodBeat.o(230548);
  }
  
  public final void setUpdateMode(int paramInt)
  {
    AppMethodBeat.i(103120);
    c.i("MicroMsg.GradientColorBackgroundView", "alvinluo setUpdateMode: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.updateMode != paramInt)
    {
      this.updateMode = paramInt;
      this.gTa = -1L;
      if (this.gSY)
      {
        this.gSX = null;
        AppMethodBeat.o(103120);
        return;
      }
      dL(true);
    }
    AppMethodBeat.o(103120);
  }
  
  @l(hxD={1, 1, 11}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(GradientColorBackgroundView paramGradientColorBackgroundView, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(230547);
      GradientColorBackgroundView.a(this.gTd, paramInt1);
      GradientColorBackgroundView.b(this.gTd, paramInt2);
      GradientColorBackgroundView.a(this.gTd);
      AppMethodBeat.o(230547);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView
 * JD-Core Version:    0.7.0.1
 */