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
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FadeOutLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backBitmap", "Landroid/graphics/Bitmap;", "backCanvas", "Landroid/graphics/Canvas;", "composeShader", "Landroid/graphics/ComposeShader;", "endColor", "fadingLen", "gradientPaint", "Landroid/graphics/Paint;", "getGradientPaint", "()Landroid/graphics/Paint;", "gradientPaint$delegate", "Lkotlin/Lazy;", "startColor", "checkInitShader", "", "gradientLen", "forceUpdate", "", "draw", "canvas", "setRightFadingLength", "gradientLength", "feedId", "", "Companion", "plugin-finder_release"})
public final class FadeOutLinearLayout
  extends LinearLayout
{
  public static final a AUw;
  private ComposeShader AUq;
  private final int AUr;
  private final f AUs;
  private Bitmap AUt;
  private Canvas AUu;
  private int AUv;
  private final int endColor;
  
  static
  {
    AppMethodBeat.i(272462);
    AUw = new a((byte)0);
    AppMethodBeat.o(272462);
  }
  
  public FadeOutLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(272460);
    this.AUr = -16777216;
    this.AUs = g.ar((a)b.AUx);
    AppMethodBeat.o(272460);
  }
  
  public FadeOutLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(272461);
    this.AUr = -16777216;
    this.AUs = g.ar((a)b.AUx);
    AppMethodBeat.o(272461);
  }
  
  private final void ax(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(272459);
    if (this.AUt != null)
    {
      localObject1 = this.AUt;
      if ((localObject1 != null) && (((Bitmap)localObject1).getWidth() == getWidth()))
      {
        localObject1 = this.AUt;
        if ((localObject1 != null) && (((Bitmap)localObject1).getHeight() == getHeight())) {
          break label96;
        }
      }
    }
    this.AUt = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    Object localObject1 = this.AUt;
    if (localObject1 == null) {
      p.iCn();
    }
    this.AUu = new Canvas((Bitmap)localObject1);
    paramBoolean = true;
    label96:
    if (paramBoolean)
    {
      localObject1 = new LinearGradient(getWidth() - paramInt, 0.0F, getWidth(), 0.0F, this.AUr, this.endColor, Shader.TileMode.CLAMP);
      Object localObject2 = this.AUt;
      if (localObject2 == null) {
        p.iCn();
      }
      Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
      localObject2 = new BitmapShader((Bitmap)localObject2, localTileMode, localTileMode);
      this.AUq = new ComposeShader((Shader)localObject1, (Shader)localObject2, PorterDuff.Mode.SRC_IN);
    }
    AppMethodBeat.o(272459);
  }
  
  private final Paint getGradientPaint()
  {
    AppMethodBeat.i(272455);
    Paint localPaint = (Paint)this.AUs.getValue();
    AppMethodBeat.o(272455);
    return localPaint;
  }
  
  public final void ar(int paramInt, long paramLong)
  {
    boolean bool = true;
    AppMethodBeat.i(272457);
    Log.i("FadeOutLinearLayout", "setRightFadingLength: feedId = " + d.Fw(paramLong) + ", fadingLen = " + paramInt);
    if ((paramInt > 0) && (getWidth() > paramInt))
    {
      ax(paramInt, true);
      this.AUv = paramInt;
      if (paramInt != 0) {
        break label92;
      }
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      AppMethodBeat.o(272457);
      return;
      this.AUq = null;
      break;
      label92:
      bool = false;
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(272458);
    p.k(paramCanvas, "canvas");
    if (this.AUq != null)
    {
      ax(this.AUv, false);
      Canvas localCanvas = this.AUu;
      if (localCanvas != null) {
        localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      }
      super.draw(this.AUu);
      paramCanvas.save();
      getGradientPaint().setShader((Shader)this.AUq);
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), getGradientPaint());
      paramCanvas.restore();
      AppMethodBeat.o(272458);
      return;
    }
    super.draw(paramCanvas);
    AppMethodBeat.o(272458);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FadeOutLinearLayout$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/graphics/Paint;", "invoke"})
  static final class b
    extends q
    implements a<Paint>
  {
    public static final b AUx;
    
    static
    {
      AppMethodBeat.i(230050);
      AUx = new b();
      AppMethodBeat.o(230050);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FadeOutLinearLayout
 * JD-Core Version:    0.7.0.1
 */