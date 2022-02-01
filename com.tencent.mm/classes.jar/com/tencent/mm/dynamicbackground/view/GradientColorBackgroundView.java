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

@l(fvt={1, 1, 11}, fvu={""}, fvv={"Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backGradient", "Landroid/graphics/LinearGradient;", "beginColor", "endColor", "mColorHelper", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "mConfigChanged", "", "mLastUpdateColorTime", "", "needUpdateColor", "paint", "Landroid/graphics/Paint;", "updateMode", "buildGradient", "", "needInvalidate", "init", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setColor", "colorStart", "colorEnd", "setUpdateMode", "Companion", "dynamicbg_release"})
public final class GradientColorBackgroundView
  extends View
{
  public static final GradientColorBackgroundView.a fKo;
  private int cJT;
  private int endColor;
  private LinearGradient fKi;
  private int fKj;
  private boolean fKk;
  private a fKl;
  private long fKm;
  private boolean fKn;
  private Paint paint;
  
  static
  {
    AppMethodBeat.i(103125);
    fKo = new GradientColorBackgroundView.a((byte)0);
    AppMethodBeat.o(103125);
  }
  
  public GradientColorBackgroundView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103123);
    this.paint = new Paint();
    this.fKj = -5778734;
    this.endColor = -14072734;
    this.fKl = new a();
    this.fKm = -1L;
    this.fKn = true;
    init();
    AppMethodBeat.o(103123);
  }
  
  public GradientColorBackgroundView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103124);
    this.paint = new Paint();
    this.fKj = -5778734;
    this.endColor = -14072734;
    this.fKl = new a();
    this.fKm = -1L;
    this.fKn = true;
    init();
    AppMethodBeat.o(103124);
  }
  
  private final void da(boolean paramBoolean)
  {
    AppMethodBeat.i(189980);
    this.fKi = new LinearGradient(0.0F, 0.0F, getWidth(), getHeight(), this.fKj, this.endColor, Shader.TileMode.CLAMP);
    this.paint.setShader((Shader)this.fKi);
    if (paramBoolean) {
      invalidate();
    }
    this.fKn = false;
    AppMethodBeat.o(189980);
  }
  
  private final void init()
  {
    AppMethodBeat.i(103119);
    this.cJT = 1;
    if (this.fKk)
    {
      this.fKl.aas();
      localObject = a.fIw;
      this.fKj = a.c.j(this.fKl.fIu.fIB);
      localObject = a.fIw;
      this.endColor = a.c.j(this.fKl.fIu.fIC);
      AppMethodBeat.o(103119);
      return;
    }
    Object localObject = getContext();
    k.g(localObject, "context");
    this.fKj = ((Context)localObject).getResources().getColor(2131100263);
    localObject = getContext();
    k.g(localObject, "context");
    this.endColor = ((Context)localObject).getResources().getColor(2131100262);
    AppMethodBeat.o(103119);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(103121);
    super.onDraw(paramCanvas);
    if (this.cJT == 1) {
      if ((this.fKk) && ((this.fKm == -1L) || (System.currentTimeMillis() - this.fKm >= 60000L)))
      {
        this.fKm = System.currentTimeMillis();
        this.fKl.aas();
        a.c localc = a.fIw;
        this.fKj = a.c.j(this.fKl.fIu.fIB);
        localc = a.fIw;
        this.endColor = a.c.j(this.fKl.fIu.fIC);
        da(false);
      }
    }
    while (paramCanvas != null)
    {
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.paint);
      AppMethodBeat.o(103121);
      return;
      if ((!this.fKk) && (this.fKn))
      {
        da(true);
        continue;
        if (this.fKn) {
          da(true);
        }
      }
    }
    AppMethodBeat.o(103121);
  }
  
  public final void setUpdateMode(int paramInt)
  {
    AppMethodBeat.i(103120);
    c.i("MicroMsg.GradientColorBackgroundView", "alvinluo setUpdateMode: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.cJT != paramInt)
    {
      this.cJT = paramInt;
      this.fKm = -1L;
      if (this.fKk)
      {
        this.fKi = null;
        AppMethodBeat.o(103120);
        return;
      }
      da(true);
    }
    AppMethodBeat.o(103120);
  }
  
  @l(fvt={1, 1, 11}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(GradientColorBackgroundView paramGradientColorBackgroundView, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(189979);
      GradientColorBackgroundView.a(this.fKp, this.fKq);
      GradientColorBackgroundView.b(this.fKp, this.fKr);
      GradientColorBackgroundView.a(this.fKp);
      AppMethodBeat.o(189979);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView
 * JD-Core Version:    0.7.0.1
 */