package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FadeOutLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backBitmap", "Landroid/graphics/Bitmap;", "backCanvas", "Landroid/graphics/Canvas;", "composeShader", "Landroid/graphics/ComposeShader;", "endColor", "fadingLen", "gradientPaint", "Landroid/graphics/Paint;", "getGradientPaint", "()Landroid/graphics/Paint;", "gradientPaint$delegate", "Lkotlin/Lazy;", "startColor", "checkInitShader", "", "gradientLen", "forceUpdate", "", "draw", "canvas", "setRightFadingLength", "gradientLength", "feedId", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FadeOutLinearLayout
  extends LinearLayout
{
  public static final FadeOutLinearLayout.a GwJ;
  private final int CRt;
  private ComposeShader GwK;
  private final j GwL;
  private Bitmap GwM;
  private Canvas GwN;
  private int GwO;
  private final int endColor;
  
  static
  {
    AppMethodBeat.i(344951);
    GwJ = new FadeOutLinearLayout.a((byte)0);
    AppMethodBeat.o(344951);
  }
  
  public FadeOutLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344922);
    this.CRt = -16777216;
    this.GwL = k.cm((a)FadeOutLinearLayout.b.GwP);
    AppMethodBeat.o(344922);
  }
  
  public FadeOutLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344929);
    this.CRt = -16777216;
    this.GwL = k.cm((a)FadeOutLinearLayout.b.GwP);
    AppMethodBeat.o(344929);
  }
  
  private final void aS(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(344942);
    Object localObject1;
    if (this.GwM != null)
    {
      localObject1 = this.GwM;
      if ((localObject1 == null) || (((Bitmap)localObject1).getWidth() != getWidth())) {
        break label222;
      }
    }
    label222:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = this.GwM;
        i = j;
        if (localObject1 != null)
        {
          i = j;
          if (((Bitmap)localObject1).getHeight() == getHeight()) {
            i = 1;
          }
        }
        if (i != 0) {}
      }
      else
      {
        this.GwM = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        localObject1 = this.GwM;
        s.checkNotNull(localObject1);
        this.GwN = new Canvas((Bitmap)localObject1);
        paramBoolean = true;
      }
      if (paramBoolean)
      {
        localObject1 = new LinearGradient(getWidth() - paramInt, 0.0F, getWidth(), 0.0F, this.CRt, this.endColor, Shader.TileMode.CLAMP);
        Object localObject2 = this.GwM;
        s.checkNotNull(localObject2);
        Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
        localObject2 = new BitmapShader((Bitmap)localObject2, localTileMode, localTileMode);
        this.GwK = new ComposeShader((Shader)localObject1, (Shader)localObject2, PorterDuff.Mode.SRC_IN);
      }
      AppMethodBeat.o(344942);
      return;
    }
  }
  
  private final Paint getGradientPaint()
  {
    AppMethodBeat.i(344935);
    Paint localPaint = (Paint)this.GwL.getValue();
    AppMethodBeat.o(344935);
    return localPaint;
  }
  
  public final void ax(int paramInt, long paramLong)
  {
    AppMethodBeat.i(344958);
    Log.i("FadeOutLinearLayout", "setRightFadingLength: feedId = " + d.hF(paramLong) + ", fadingLen = " + paramInt + ", width = " + getWidth());
    int i;
    if ((paramInt > 0) && (getWidth() > 0) && (getHeight() > 0)) {
      if (paramInt > getWidth())
      {
        i = getWidth();
        aS(i, true);
        label89:
        this.GwO = paramInt;
        if (paramInt != 0) {
          break label131;
        }
      }
    }
    label131:
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      AppMethodBeat.o(344958);
      return;
      i = paramInt;
      break;
      this.GwK = null;
      break label89;
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(344963);
    s.u(paramCanvas, "canvas");
    if ((getWidth() <= 0) || (getHeight() <= 0))
    {
      super.draw(paramCanvas);
      AppMethodBeat.o(344963);
      return;
    }
    if (this.GwK == null) {}
    for (Object localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null) {
        super.draw(paramCanvas);
      }
      AppMethodBeat.o(344963);
      return;
      aS(this.GwO, false);
      localObject = this.GwN;
      if (localObject != null) {
        ((Canvas)localObject).drawColor(0, PorterDuff.Mode.CLEAR);
      }
      super.draw(this.GwN);
      paramCanvas.save();
      getGradientPaint().setShader((Shader)this.GwK);
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), getGradientPaint());
      paramCanvas.restore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FadeOutLinearLayout
 * JD-Core Version:    0.7.0.1
 */