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
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 11}, gfy={""}, gfz={"Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backGradient", "Landroid/graphics/LinearGradient;", "beginColor", "endColor", "mColorHelper", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "mConfigChanged", "", "mLastUpdateColorTime", "", "needUpdateColor", "paint", "Landroid/graphics/Paint;", "updateMode", "buildGradient", "", "needInvalidate", "init", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setColor", "colorStart", "colorEnd", "setUpdateMode", "Companion", "dynamicbg_release"})
public final class GradientColorBackgroundView
  extends View
{
  public static final GradientColorBackgroundView.a ghu;
  private int cSe;
  private int endColor;
  private LinearGradient gho;
  private int ghp;
  private boolean ghq;
  private a ghr;
  private long ghs;
  private boolean ght;
  private Paint paint;
  
  static
  {
    AppMethodBeat.i(103125);
    ghu = new GradientColorBackgroundView.a((byte)0);
    AppMethodBeat.o(103125);
  }
  
  public GradientColorBackgroundView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103123);
    this.paint = new Paint();
    this.ghp = -5778734;
    this.endColor = -14072734;
    this.ghr = new a();
    this.ghs = -1L;
    this.ght = true;
    init();
    AppMethodBeat.o(103123);
  }
  
  public GradientColorBackgroundView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103124);
    this.paint = new Paint();
    this.ghp = -5778734;
    this.endColor = -14072734;
    this.ghr = new a();
    this.ghs = -1L;
    this.ght = true;
    init();
    AppMethodBeat.o(103124);
  }
  
  private final void db(boolean paramBoolean)
  {
    AppMethodBeat.i(220351);
    this.gho = new LinearGradient(0.0F, 0.0F, getWidth(), getHeight(), this.ghp, this.endColor, Shader.TileMode.CLAMP);
    this.paint.setShader((Shader)this.gho);
    if (paramBoolean) {
      invalidate();
    }
    this.ght = false;
    AppMethodBeat.o(220351);
  }
  
  private final void init()
  {
    AppMethodBeat.i(103119);
    this.cSe = 1;
    if (this.ghq)
    {
      this.ghr.adV();
      localObject = a.gfC;
      this.ghp = a.c.j(this.ghr.gfA.gfH);
      localObject = a.gfC;
      this.endColor = a.c.j(this.ghr.gfA.gfI);
      AppMethodBeat.o(103119);
      return;
    }
    Object localObject = getContext();
    p.g(localObject, "context");
    this.ghp = ((Context)localObject).getResources().getColor(2131100263);
    localObject = getContext();
    p.g(localObject, "context");
    this.endColor = ((Context)localObject).getResources().getColor(2131100262);
    AppMethodBeat.o(103119);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(103121);
    super.onDraw(paramCanvas);
    if (this.cSe == 1) {
      if ((this.ghq) && ((this.ghs == -1L) || (System.currentTimeMillis() - this.ghs >= 60000L)))
      {
        this.ghs = System.currentTimeMillis();
        this.ghr.adV();
        a.c localc = a.gfC;
        this.ghp = a.c.j(this.ghr.gfA.gfH);
        localc = a.gfC;
        this.endColor = a.c.j(this.ghr.gfA.gfI);
        db(false);
      }
    }
    while (paramCanvas != null)
    {
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.paint);
      AppMethodBeat.o(103121);
      return;
      if ((!this.ghq) && (this.ght))
      {
        db(true);
        continue;
        if (this.ght) {
          db(true);
        }
      }
    }
    AppMethodBeat.o(103121);
  }
  
  public final void setUpdateMode(int paramInt)
  {
    AppMethodBeat.i(103120);
    c.i("MicroMsg.GradientColorBackgroundView", "alvinluo setUpdateMode: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.cSe != paramInt)
    {
      this.cSe = paramInt;
      this.ghs = -1L;
      if (this.ghq)
      {
        this.gho = null;
        AppMethodBeat.o(103120);
        return;
      }
      db(true);
    }
    AppMethodBeat.o(103120);
  }
  
  @l(gfx={1, 1, 11}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(GradientColorBackgroundView paramGradientColorBackgroundView, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(220350);
      GradientColorBackgroundView.a(this.ghv, this.ghw);
      GradientColorBackgroundView.b(this.ghv, this.ghx);
      GradientColorBackgroundView.a(this.ghv);
      AppMethodBeat.o(220350);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView
 * JD-Core Version:    0.7.0.1
 */