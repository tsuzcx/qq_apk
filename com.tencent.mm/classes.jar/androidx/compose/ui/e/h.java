package androidx.compose.ui.e;

import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/AndroidPaint;", "Landroidx/compose/ui/graphics/Paint;", "()V", "_blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "I", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "setColor-8_81llA", "(J)V", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "getFilterQuality-f-v9h1I", "setFilterQuality-vDHp3xo", "internalColorFilter", "internalPaint", "Landroid/graphics/Paint;", "internalShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "", "isAntiAlias", "()Z", "setAntiAlias", "(Z)V", "Landroidx/compose/ui/graphics/PathEffect;", "pathEffect", "getPathEffect", "()Landroidx/compose/ui/graphics/PathEffect;", "setPathEffect", "(Landroidx/compose/ui/graphics/PathEffect;)V", "shader", "getShader", "()Landroid/graphics/Shader;", "setShader", "(Landroid/graphics/Shader;)V", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeCap", "getStrokeCap-KaPHkGw", "setStrokeCap-BeK7IIE", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeJoin", "getStrokeJoin-LxFBmk8", "setStrokeJoin-Ww9F2mQ", "strokeMiterLimit", "getStrokeMiterLimit", "setStrokeMiterLimit", "strokeWidth", "getStrokeWidth", "setStrokeWidth", "Landroidx/compose/ui/graphics/PaintingStyle;", "style", "getStyle-TiuSbCo", "setStyle-k9PVt8s", "asFrameworkPaint", "Landroidx/compose/ui/graphics/NativePaint;", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements am
{
  private Paint avH;
  private int avI;
  private Shader avJ;
  private aa avK;
  private ap avL;
  
  public h()
  {
    AppMethodBeat.i(206011);
    this.avH = new Paint(1);
    p.a locala = p.avT;
    this.avI = p.sU();
    AppMethodBeat.o(206011);
  }
  
  public final void J(float paramFloat)
  {
    AppMethodBeat.i(206090);
    Paint localPaint = this.avH;
    s.u(localPaint, "<this>");
    localPaint.setStrokeMiter(paramFloat);
    AppMethodBeat.o(206090);
  }
  
  public final void W(long paramLong)
  {
    AppMethodBeat.i(206031);
    Paint localPaint = this.avH;
    s.u(localPaint, "$this$setNativeColor");
    localPaint.setColor(ab.ai(paramLong));
    AppMethodBeat.o(206031);
  }
  
  public final void a(Shader paramShader)
  {
    AppMethodBeat.i(206099);
    this.avJ = paramShader;
    paramShader = this.avH;
    Shader localShader = this.avJ;
    s.u(paramShader, "<this>");
    paramShader.setShader(localShader);
    AppMethodBeat.o(206099);
  }
  
  public final void a(ap paramap)
  {
    AppMethodBeat.i(206119);
    Paint localPaint = this.avH;
    s.u(localPaint, "<this>");
    if ((k)paramap == null)
    {
      localPaint.setPathEffect(null);
      this.avL = paramap;
      AppMethodBeat.o(206119);
      return;
    }
    AppMethodBeat.o(206119);
    throw null;
  }
  
  public final void b(aa paramaa)
  {
    AppMethodBeat.i(206111);
    this.avK = paramaa;
    Paint localPaint = this.avH;
    s.u(localPaint, "<this>");
    if (paramaa == null) {}
    for (paramaa = null;; paramaa = d.a(paramaa))
    {
      localPaint.setColorFilter(paramaa);
      AppMethodBeat.o(206111);
      return;
    }
  }
  
  public final void cB(int paramInt)
  {
    AppMethodBeat.i(206043);
    this.avI = paramInt;
    Paint localPaint = this.avH;
    s.u(localPaint, "$this$setNativeBlendMode");
    if (Build.VERSION.SDK_INT >= 29)
    {
      bf.ayE.a(localPaint, paramInt);
      AppMethodBeat.o(206043);
      return;
    }
    localPaint.setXfermode((Xfermode)new PorterDuffXfermode(a.cx(paramInt)));
    AppMethodBeat.o(206043);
  }
  
  public final void cC(int paramInt)
  {
    AppMethodBeat.i(206047);
    Paint localPaint = this.avH;
    s.u(localPaint, "$this$setNativeStyle");
    Object localObject = an.axO;
    if (an.C(paramInt, an.tH())) {}
    for (localObject = Paint.Style.STROKE;; localObject = Paint.Style.FILL)
    {
      localPaint.setStyle((Paint.Style)localObject);
      AppMethodBeat.o(206047);
      return;
    }
  }
  
  public final void cD(int paramInt)
  {
    AppMethodBeat.i(206066);
    Paint localPaint = this.avH;
    s.u(localPaint, "$this$setNativeStrokeCap");
    Object localObject = bb.ayr;
    if (bb.C(paramInt, bb.tQ())) {
      localObject = Paint.Cap.SQUARE;
    }
    for (;;)
    {
      localPaint.setStrokeCap((Paint.Cap)localObject);
      AppMethodBeat.o(206066);
      return;
      localObject = bb.ayr;
      if (bb.C(paramInt, bb.tP()))
      {
        localObject = Paint.Cap.ROUND;
      }
      else
      {
        localObject = bb.ayr;
        bb.C(paramInt, bb.tO());
        localObject = Paint.Cap.BUTT;
      }
    }
  }
  
  public final void cE(int paramInt)
  {
    AppMethodBeat.i(206080);
    Paint localPaint = this.avH;
    s.u(localPaint, "$this$setNativeStrokeJoin");
    Object localObject = bc.ayv;
    if (!bc.C(paramInt, bc.tR()))
    {
      localObject = bc.ayv;
      if (bc.C(paramInt, bc.tS())) {
        localObject = Paint.Join.BEVEL;
      }
    }
    for (;;)
    {
      localPaint.setStrokeJoin((Paint.Join)localObject);
      AppMethodBeat.o(206080);
      return;
      localObject = bc.ayv;
      if (bc.C(paramInt, bc.tP())) {
        localObject = Paint.Join.ROUND;
      } else {
        localObject = Paint.Join.MITER;
      }
    }
  }
  
  public final float getAlpha()
  {
    AppMethodBeat.i(206018);
    Paint localPaint = this.avH;
    s.u(localPaint, "<this>");
    float f = localPaint.getAlpha() / 255.0F;
    AppMethodBeat.o(206018);
    return f;
  }
  
  public final float getStrokeWidth()
  {
    AppMethodBeat.i(206051);
    Paint localPaint = this.avH;
    s.u(localPaint, "<this>");
    float f = localPaint.getStrokeWidth();
    AppMethodBeat.o(206051);
    return f;
  }
  
  public final Paint sE()
  {
    return this.avH;
  }
  
  public final long sF()
  {
    AppMethodBeat.i(206026);
    Paint localPaint = this.avH;
    s.u(localPaint, "<this>");
    long l = ab.cH(localPaint.getColor());
    AppMethodBeat.o(206026);
    return l;
  }
  
  public final int sG()
  {
    return this.avI;
  }
  
  public final int sH()
  {
    AppMethodBeat.i(206060);
    Object localObject = this.avH;
    s.u(localObject, "<this>");
    localObject = ((Paint)localObject).getStrokeCap();
    if (localObject == null) {}
    for (int i = -1;; i = i.a.avl[localObject.ordinal()]) {
      switch (i)
      {
      default: 
        localObject = bb.ayr;
        i = bb.tO();
        AppMethodBeat.o(206060);
        return i;
      }
    }
    localObject = bb.ayr;
    i = bb.tO();
    AppMethodBeat.o(206060);
    return i;
    localObject = bb.ayr;
    i = bb.tP();
    AppMethodBeat.o(206060);
    return i;
    localObject = bb.ayr;
    i = bb.tQ();
    AppMethodBeat.o(206060);
    return i;
  }
  
  public final int sI()
  {
    AppMethodBeat.i(206072);
    Object localObject = this.avH;
    s.u(localObject, "<this>");
    localObject = ((Paint)localObject).getStrokeJoin();
    if (localObject == null) {}
    for (int i = -1;; i = i.a.avM[localObject.ordinal()]) {
      switch (i)
      {
      default: 
        localObject = bc.ayv;
        i = bc.tR();
        AppMethodBeat.o(206072);
        return i;
      }
    }
    localObject = bc.ayv;
    i = bc.tR();
    AppMethodBeat.o(206072);
    return i;
    localObject = bc.ayv;
    i = bc.tS();
    AppMethodBeat.o(206072);
    return i;
    localObject = bc.ayv;
    i = bc.tP();
    AppMethodBeat.o(206072);
    return i;
  }
  
  public final float sJ()
  {
    AppMethodBeat.i(206085);
    Paint localPaint = this.avH;
    s.u(localPaint, "<this>");
    float f = localPaint.getStrokeMiter();
    AppMethodBeat.o(206085);
    return f;
  }
  
  public final Shader sK()
  {
    return this.avJ;
  }
  
  public final aa sL()
  {
    return this.avK;
  }
  
  public final ap sM()
  {
    return this.avL;
  }
  
  public final void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(206022);
    Paint localPaint = this.avH;
    s.u(localPaint, "<this>");
    localPaint.setAlpha((int)(float)Math.rint(255.0F * paramFloat));
    AppMethodBeat.o(206022);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(206056);
    Paint localPaint = this.avH;
    s.u(localPaint, "<this>");
    localPaint.setStrokeWidth(paramFloat);
    AppMethodBeat.o(206056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.h
 * JD-Core Version:    0.7.0.1
 */