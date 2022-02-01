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

@l(gjZ={1, 1, 11}, gka={""}, gkb={"Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backGradient", "Landroid/graphics/LinearGradient;", "beginColor", "endColor", "mColorHelper", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "mConfigChanged", "", "mLastUpdateColorTime", "", "needUpdateColor", "paint", "Landroid/graphics/Paint;", "updateMode", "buildGradient", "", "needInvalidate", "init", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setColor", "colorStart", "colorEnd", "setUpdateMode", "Companion", "dynamicbg_release"})
public final class GradientColorBackgroundView
  extends View
{
  public static final GradientColorBackgroundView.a gjM;
  private int cSO;
  private int endColor;
  private LinearGradient gjG;
  private int gjH;
  private boolean gjI;
  private a gjJ;
  private long gjK;
  private boolean gjL;
  private Paint paint;
  
  static
  {
    AppMethodBeat.i(103125);
    gjM = new GradientColorBackgroundView.a((byte)0);
    AppMethodBeat.o(103125);
  }
  
  public GradientColorBackgroundView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103123);
    this.paint = new Paint();
    this.gjH = -5778734;
    this.endColor = -14072734;
    this.gjJ = new a();
    this.gjK = -1L;
    this.gjL = true;
    init();
    AppMethodBeat.o(103123);
  }
  
  public GradientColorBackgroundView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103124);
    this.paint = new Paint();
    this.gjH = -5778734;
    this.endColor = -14072734;
    this.gjJ = new a();
    this.gjK = -1L;
    this.gjL = true;
    init();
    AppMethodBeat.o(103124);
  }
  
  private final void db(boolean paramBoolean)
  {
    AppMethodBeat.i(195403);
    this.gjG = new LinearGradient(0.0F, 0.0F, getWidth(), getHeight(), this.gjH, this.endColor, Shader.TileMode.CLAMP);
    this.paint.setShader((Shader)this.gjG);
    if (paramBoolean) {
      invalidate();
    }
    this.gjL = false;
    AppMethodBeat.o(195403);
  }
  
  private final void init()
  {
    AppMethodBeat.i(103119);
    this.cSO = 1;
    if (this.gjI)
    {
      this.gjJ.aeh();
      localObject = a.ghU;
      this.gjH = a.c.j(this.gjJ.ghS.ghZ);
      localObject = a.ghU;
      this.endColor = a.c.j(this.gjJ.ghS.gia);
      AppMethodBeat.o(103119);
      return;
    }
    Object localObject = getContext();
    p.g(localObject, "context");
    this.gjH = ((Context)localObject).getResources().getColor(2131100263);
    localObject = getContext();
    p.g(localObject, "context");
    this.endColor = ((Context)localObject).getResources().getColor(2131100262);
    AppMethodBeat.o(103119);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(103121);
    super.onDraw(paramCanvas);
    if (this.cSO == 1) {
      if ((this.gjI) && ((this.gjK == -1L) || (System.currentTimeMillis() - this.gjK >= 60000L)))
      {
        this.gjK = System.currentTimeMillis();
        this.gjJ.aeh();
        a.c localc = a.ghU;
        this.gjH = a.c.j(this.gjJ.ghS.ghZ);
        localc = a.ghU;
        this.endColor = a.c.j(this.gjJ.ghS.gia);
        db(false);
      }
    }
    while (paramCanvas != null)
    {
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.paint);
      AppMethodBeat.o(103121);
      return;
      if ((!this.gjI) && (this.gjL))
      {
        db(true);
        continue;
        if (this.gjL) {
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
    if (this.cSO != paramInt)
    {
      this.cSO = paramInt;
      this.gjK = -1L;
      if (this.gjI)
      {
        this.gjG = null;
        AppMethodBeat.o(103120);
        return;
      }
      db(true);
    }
    AppMethodBeat.o(103120);
  }
  
  @l(gjZ={1, 1, 11}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(GradientColorBackgroundView paramGradientColorBackgroundView, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(195402);
      GradientColorBackgroundView.a(this.gjN, this.gjO);
      GradientColorBackgroundView.b(this.gjN, this.gjP);
      GradientColorBackgroundView.a(this.gjN);
      AppMethodBeat.o(195402);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView
 * JD-Core Version:    0.7.0.1
 */