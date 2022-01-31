package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import a.f.b.j;
import a.l;
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
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GradientColorBackgroundView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backGradient", "Landroid/graphics/LinearGradient;", "beginColor", "endColor", "mColorHelper", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundColorHelper;", "mLastUpdateColorTime", "", "needUpdateColor", "", "paint", "Landroid/graphics/Paint;", "updateMode", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "resetGradient", "needInvalidate", "setUpdateMode", "updateColor", "Companion", "plugin-appbrand-integration_release"})
public final class GradientColorBackgroundView
  extends View
{
  public static final GradientColorBackgroundView.a jhD;
  private int bWw;
  private int beginColor;
  private int endColor;
  private boolean jhA;
  private a jhB;
  private long jhC;
  private LinearGradient jhz;
  private Paint paint;
  
  static
  {
    AppMethodBeat.i(135262);
    jhD = new GradientColorBackgroundView.a((byte)0);
    AppMethodBeat.o(135262);
  }
  
  public GradientColorBackgroundView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(135260);
    this.paint = new Paint();
    this.beginColor = -5778734;
    this.endColor = -14072734;
    this.jhB = new a();
    this.jhC = -1L;
    init();
    AppMethodBeat.o(135260);
  }
  
  public GradientColorBackgroundView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(135261);
    this.paint = new Paint();
    this.beginColor = -5778734;
    this.endColor = -14072734;
    this.jhB = new a();
    this.jhC = -1L;
    init();
    AppMethodBeat.o(135261);
  }
  
  private final void fk(boolean paramBoolean)
  {
    AppMethodBeat.i(135259);
    this.jhz = new LinearGradient(0.0F, 0.0F, getWidth(), getHeight(), this.beginColor, this.endColor, Shader.TileMode.CLAMP);
    this.paint.setShader((Shader)this.jhz);
    if (paramBoolean) {
      invalidate();
    }
    AppMethodBeat.o(135259);
  }
  
  private final void init()
  {
    AppMethodBeat.i(135256);
    this.bWw = 1;
    if (this.jhA)
    {
      this.jhB.aPF();
      this.beginColor = a.i(this.jhB.aPE().jgr);
      this.endColor = a.i(this.jhB.aPE().jgs);
      AppMethodBeat.o(135256);
      return;
    }
    Context localContext = getContext();
    j.p(localContext, "context");
    this.beginColor = localContext.getResources().getColor(2131689691);
    localContext = getContext();
    j.p(localContext, "context");
    this.endColor = localContext.getResources().getColor(2131689689);
    AppMethodBeat.o(135256);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(135258);
    super.onDraw(paramCanvas);
    if (this.bWw == 1) {
      if ((this.jhA) && ((this.jhC == -1L) || (System.currentTimeMillis() - this.jhC >= 60000L)))
      {
        this.jhC = System.currentTimeMillis();
        this.jhB.aPF();
        this.beginColor = a.i(this.jhB.aPE().jgr);
        this.endColor = a.i(this.jhB.aPE().jgs);
        fk(false);
      }
    }
    while (paramCanvas != null)
    {
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.paint);
      AppMethodBeat.o(135258);
      return;
      if ((!this.jhA) && (this.jhz == null))
      {
        fk(true);
        continue;
        if (this.jhz == null) {
          fk(true);
        }
      }
    }
    AppMethodBeat.o(135258);
  }
  
  public final void setUpdateMode(int paramInt)
  {
    AppMethodBeat.i(135257);
    ab.i("MicroMsg.GradientColorBackgroundView", "alvinluo setUpdateMode: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.bWw != paramInt)
    {
      this.bWw = paramInt;
      this.jhC = -1L;
      if (this.jhA)
      {
        this.jhz = null;
        AppMethodBeat.o(135257);
        return;
      }
      fk(true);
    }
    AppMethodBeat.o(135257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GradientColorBackgroundView
 * JD-Core Version:    0.7.0.1
 */