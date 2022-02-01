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
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 11}, fNZ={""}, fOa={"Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backGradient", "Landroid/graphics/LinearGradient;", "beginColor", "endColor", "mColorHelper", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "mConfigChanged", "", "mLastUpdateColorTime", "", "needUpdateColor", "paint", "Landroid/graphics/Paint;", "updateMode", "buildGradient", "", "needInvalidate", "init", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setColor", "colorStart", "colorEnd", "setUpdateMode", "Companion", "dynamicbg_release"})
public final class GradientColorBackgroundView
  extends View
{
  public static final GradientColorBackgroundView.a fNU;
  private int cHa;
  private int endColor;
  private LinearGradient fNO;
  private int fNP;
  private boolean fNQ;
  private a fNR;
  private long fNS;
  private boolean fNT;
  private Paint paint;
  
  static
  {
    AppMethodBeat.i(103125);
    fNU = new GradientColorBackgroundView.a((byte)0);
    AppMethodBeat.o(103125);
  }
  
  public GradientColorBackgroundView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103123);
    this.paint = new Paint();
    this.fNP = -5778734;
    this.endColor = -14072734;
    this.fNR = new a();
    this.fNS = -1L;
    this.fNT = true;
    init();
    AppMethodBeat.o(103123);
  }
  
  public GradientColorBackgroundView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103124);
    this.paint = new Paint();
    this.fNP = -5778734;
    this.endColor = -14072734;
    this.fNR = new a();
    this.fNS = -1L;
    this.fNT = true;
    init();
    AppMethodBeat.o(103124);
  }
  
  private final void cZ(boolean paramBoolean)
  {
    AppMethodBeat.i(195759);
    this.fNO = new LinearGradient(0.0F, 0.0F, getWidth(), getHeight(), this.fNP, this.endColor, Shader.TileMode.CLAMP);
    this.paint.setShader((Shader)this.fNO);
    if (paramBoolean) {
      invalidate();
    }
    this.fNT = false;
    AppMethodBeat.o(195759);
  }
  
  private final void init()
  {
    AppMethodBeat.i(103119);
    this.cHa = 1;
    if (this.fNQ)
    {
      this.fNR.abr();
      localObject = a.fMc;
      this.fNP = a.c.j(this.fNR.fMa.fMh);
      localObject = a.fMc;
      this.endColor = a.c.j(this.fNR.fMa.fMi);
      AppMethodBeat.o(103119);
      return;
    }
    Object localObject = getContext();
    k.g(localObject, "context");
    this.fNP = ((Context)localObject).getResources().getColor(2131100263);
    localObject = getContext();
    k.g(localObject, "context");
    this.endColor = ((Context)localObject).getResources().getColor(2131100262);
    AppMethodBeat.o(103119);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(103121);
    super.onDraw(paramCanvas);
    if (this.cHa == 1) {
      if ((this.fNQ) && ((this.fNS == -1L) || (System.currentTimeMillis() - this.fNS >= 60000L)))
      {
        this.fNS = System.currentTimeMillis();
        this.fNR.abr();
        a.c localc = a.fMc;
        this.fNP = a.c.j(this.fNR.fMa.fMh);
        localc = a.fMc;
        this.endColor = a.c.j(this.fNR.fMa.fMi);
        cZ(false);
      }
    }
    while (paramCanvas != null)
    {
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.paint);
      AppMethodBeat.o(103121);
      return;
      if ((!this.fNQ) && (this.fNT))
      {
        cZ(true);
        continue;
        if (this.fNT) {
          cZ(true);
        }
      }
    }
    AppMethodBeat.o(103121);
  }
  
  public final void setUpdateMode(int paramInt)
  {
    AppMethodBeat.i(103120);
    c.i("MicroMsg.GradientColorBackgroundView", "alvinluo setUpdateMode: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.cHa != paramInt)
    {
      this.cHa = paramInt;
      this.fNS = -1L;
      if (this.fNQ)
      {
        this.fNO = null;
        AppMethodBeat.o(103120);
        return;
      }
      cZ(true);
    }
    AppMethodBeat.o(103120);
  }
  
  @l(fNY={1, 1, 11}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(GradientColorBackgroundView paramGradientColorBackgroundView, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(195758);
      GradientColorBackgroundView.a(this.fNV, this.fNW);
      GradientColorBackgroundView.b(this.fNV, this.fNX);
      GradientColorBackgroundView.a(this.fNV);
      AppMethodBeat.o(195758);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView
 * JD-Core Version:    0.7.0.1
 */