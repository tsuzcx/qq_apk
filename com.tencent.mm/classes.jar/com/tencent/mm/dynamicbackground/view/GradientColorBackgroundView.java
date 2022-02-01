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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backGradient", "Landroid/graphics/LinearGradient;", "beginColor", "endColor", "mColorHelper", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "mConfigChanged", "", "mLastUpdateColorTime", "", "needUpdateColor", "paint", "Landroid/graphics/Paint;", "updateMode", "buildGradient", "", "needInvalidate", "init", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setColor", "colorStart", "colorEnd", "setUpdateMode", "Companion", "dynamicbg_release"}, k=1, mv={1, 1, 11})
public final class GradientColorBackgroundView
  extends View
{
  public static final GradientColorBackgroundView.a mdq;
  private int beginColor;
  private int endColor;
  private LinearGradient mdl;
  private boolean mdm;
  private a mdn;
  private long mdo;
  private boolean mdp;
  private Paint paint;
  private int updateMode;
  
  static
  {
    AppMethodBeat.i(103125);
    mdq = new GradientColorBackgroundView.a((byte)0);
    AppMethodBeat.o(103125);
  }
  
  public GradientColorBackgroundView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(233184);
    this.paint = new Paint();
    this.beginColor = -5778734;
    this.endColor = -14072734;
    this.mdn = new a();
    this.mdo = -1L;
    this.mdp = true;
    init();
    AppMethodBeat.o(233184);
  }
  
  public GradientColorBackgroundView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103123);
    this.paint = new Paint();
    this.beginColor = -5778734;
    this.endColor = -14072734;
    this.mdn = new a();
    this.mdo = -1L;
    this.mdp = true;
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
    this.mdn = new a();
    this.mdo = -1L;
    this.mdp = true;
    init();
    AppMethodBeat.o(103124);
  }
  
  private final void eX(boolean paramBoolean)
  {
    AppMethodBeat.i(233180);
    this.mdl = new LinearGradient(0.0F, 0.0F, getWidth(), getHeight(), this.beginColor, this.endColor, Shader.TileMode.CLAMP);
    this.paint.setShader((Shader)this.mdl);
    if (paramBoolean) {
      invalidate();
    }
    this.mdp = false;
    AppMethodBeat.o(233180);
  }
  
  private final void init()
  {
    AppMethodBeat.i(103119);
    this.updateMode = 1;
    if (this.mdm)
    {
      this.mdn.aTB();
      localObject = a.mbv;
      this.beginColor = a.c.s(this.mdn.mbt.mbA);
      localObject = a.mbv;
      this.endColor = a.c.s(this.mdn.mbt.mbB);
      AppMethodBeat.o(103119);
      return;
    }
    Object localObject = getContext();
    s.r(localObject, "context");
    this.beginColor = ((Context)localObject).getResources().getColor(a.a.dynamic_bg_start_color);
    localObject = getContext();
    s.r(localObject, "context");
    this.endColor = ((Context)localObject).getResources().getColor(a.a.dynamic_bg_end_color);
    AppMethodBeat.o(103119);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(103121);
    super.onDraw(paramCanvas);
    if (this.updateMode == 1) {
      if ((this.mdm) && ((this.mdo == -1L) || (System.currentTimeMillis() - this.mdo >= 60000L)))
      {
        this.mdo = System.currentTimeMillis();
        this.mdn.aTB();
        a.c localc = a.mbv;
        this.beginColor = a.c.s(this.mdn.mbt.mbA);
        localc = a.mbv;
        this.endColor = a.c.s(this.mdn.mbt.mbB);
        eX(false);
      }
    }
    while (paramCanvas != null)
    {
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.paint);
      AppMethodBeat.o(103121);
      return;
      if ((!this.mdm) && (this.mdp))
      {
        eX(true);
        continue;
        if (this.mdp) {
          eX(true);
        }
      }
    }
    AppMethodBeat.o(103121);
  }
  
  public final void setColor(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(233205);
    post((Runnable)new b(this, paramInt1, paramInt2));
    AppMethodBeat.o(233205);
  }
  
  public final void setUpdateMode(int paramInt)
  {
    AppMethodBeat.i(103120);
    c.i("MicroMsg.GradientColorBackgroundView", "alvinluo setUpdateMode: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.updateMode != paramInt)
    {
      this.updateMode = paramInt;
      this.mdo = -1L;
      if (this.mdm)
      {
        this.mdl = null;
        AppMethodBeat.o(103120);
        return;
      }
      eX(true);
    }
    AppMethodBeat.o(103120);
  }
  
  @Metadata(bv={1, 0, 2}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 11})
  static final class b
    implements Runnable
  {
    b(GradientColorBackgroundView paramGradientColorBackgroundView, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(233152);
      GradientColorBackgroundView.a(this.mdr, paramInt1);
      GradientColorBackgroundView.b(this.mdr, paramInt2);
      GradientColorBackgroundView.a(this.mdr);
      AppMethodBeat.o(233152);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView
 * JD-Core Version:    0.7.0.1
 */