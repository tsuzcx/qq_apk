package androidx.compose.ui.e;

import androidx.compose.ui.n.d;
import androidx.compose.ui.n.d.a;
import androidx.compose.ui.n.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "()V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "", "getClip", "()Z", "setClip", "(Z)V", "density", "getDensity", "fontScale", "getFontScale", "graphicsDensity", "Landroidx/compose/ui/unit/Density;", "getGraphicsDensity$ui_release", "()Landroidx/compose/ui/unit/Density;", "setGraphicsDensity$ui_release", "(Landroidx/compose/ui/unit/Density;)V", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "getTransformOrigin-SzJe1aQ", "()J", "setTransformOrigin-__ExYCQ", "(J)V", "J", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "reset", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class av
  implements ae
{
  public boolean SI;
  public ay XK;
  public float alpha;
  public float ayc;
  public float ayd;
  public float aye;
  public float ayf;
  public float ayg;
  public float ayh;
  public float ayi;
  public long ayj;
  private d ayk;
  public float scaleX;
  public float scaleY;
  
  public av()
  {
    AppMethodBeat.i(206163);
    this.scaleX = 1.0F;
    this.scaleY = 1.0F;
    this.alpha = 1.0F;
    this.ayi = 8.0F;
    be.a locala = be.ayC;
    this.ayj = be.tW();
    this.XK = au.tM();
    this.ayk = f.H(1.0F, 1.0F);
    AppMethodBeat.o(206163);
  }
  
  public final void M(float paramFloat)
  {
    this.ayc = paramFloat;
  }
  
  public final void N(float paramFloat)
  {
    this.aye = paramFloat;
  }
  
  public final void O(float paramFloat)
  {
    this.ayf = paramFloat;
  }
  
  public final void P(float paramFloat)
  {
    this.ayg = paramFloat;
  }
  
  public final void Q(float paramFloat)
  {
    this.ayh = paramFloat;
  }
  
  public final void R(float paramFloat)
  {
    this.ayi = paramFloat;
  }
  
  public final void a(ay paramay)
  {
    AppMethodBeat.i(206207);
    s.u(paramay, "<set-?>");
    this.XK = paramay;
    AppMethodBeat.o(206207);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(206220);
    s.u(paramd, "<set-?>");
    this.ayk = paramd;
    AppMethodBeat.o(206220);
  }
  
  public final void aj(long paramLong)
  {
    this.ayj = paramLong;
  }
  
  public final void at(boolean paramBoolean)
  {
    this.SI = paramBoolean;
  }
  
  public final float bs(int paramInt)
  {
    AppMethodBeat.i(206255);
    ae localae = (ae)this;
    s.u(localae, "this");
    float f = d.a.a((d)localae, paramInt);
    AppMethodBeat.o(206255);
    return f;
  }
  
  public final float mn()
  {
    AppMethodBeat.i(206222);
    float f = this.ayk.mn();
    AppMethodBeat.o(206222);
    return f;
  }
  
  public final float mo()
  {
    AppMethodBeat.i(206226);
    float f = this.ayk.mo();
    AppMethodBeat.o(206226);
    return f;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(206229);
    this.scaleX = 1.0F;
    this.scaleY = 1.0F;
    this.alpha = 1.0F;
    this.ayc = 0.0F;
    this.ayd = 0.0F;
    this.aye = 0.0F;
    this.ayf = 0.0F;
    this.ayg = 0.0F;
    this.ayh = 0.0F;
    this.ayi = 8.0F;
    be.a locala = be.ayC;
    this.ayj = be.tW();
    a(au.tM());
    this.SI = false;
    AppMethodBeat.o(206229);
  }
  
  public final void setAlpha(float paramFloat)
  {
    this.alpha = paramFloat;
  }
  
  public final void setScaleX(float paramFloat)
  {
    this.scaleX = paramFloat;
  }
  
  public final void setScaleY(float paramFloat)
  {
    this.scaleY = paramFloat;
  }
  
  public final void setTranslationY(float paramFloat)
  {
    this.ayd = paramFloat;
  }
  
  public final float t(long paramLong)
  {
    AppMethodBeat.i(206250);
    ae localae = (ae)this;
    s.u(localae, "this");
    float f = d.a.a((d)localae, paramLong);
    AppMethodBeat.o(206250);
    return f;
  }
  
  public final int v(float paramFloat)
  {
    AppMethodBeat.i(206238);
    ae localae = (ae)this;
    s.u(localae, "this");
    int i = d.a.b((d)localae, paramFloat);
    AppMethodBeat.o(206238);
    return i;
  }
  
  public final float w(float paramFloat)
  {
    AppMethodBeat.i(206242);
    ae localae = (ae)this;
    s.u(localae, "this");
    paramFloat = d.a.a((d)localae, paramFloat);
    AppMethodBeat.o(206242);
    return paramFloat;
  }
  
  public final long x(float paramFloat)
  {
    AppMethodBeat.i(206246);
    ae localae = (ae)this;
    s.u(localae, "this");
    long l = d.a.c((d)localae, paramFloat);
    AppMethodBeat.o(206246);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.av
 * JD-Core Version:    0.7.0.1
 */