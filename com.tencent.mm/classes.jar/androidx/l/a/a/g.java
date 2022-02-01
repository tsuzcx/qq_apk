package androidx.l.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.core.graphics.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xmlpull.v1.XmlPullParser;

public final class g
  implements Interpolator
{
  private float[] bvM;
  private float[] bvN;
  
  public g(Context paramContext, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser)
  {
    this(paramContext.getResources(), paramContext.getTheme(), paramAttributeSet, paramXmlPullParser);
    AppMethodBeat.i(192607);
    AppMethodBeat.o(192607);
  }
  
  private g(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(192621);
    paramResources = androidx.core.content.a.g.a(paramResources, paramTheme, paramAttributeSet, a.aFa);
    if (androidx.core.content.a.g.a(paramXmlPullParser, "pathData"))
    {
      paramTheme = androidx.core.content.a.g.c(paramResources, paramXmlPullParser, "pathData", 4);
      paramAttributeSet = d.au(paramTheme);
      if (paramAttributeSet == null)
      {
        paramResources = new InflateException("The path is null, which is created from ".concat(String.valueOf(paramTheme)));
        AppMethodBeat.o(192621);
        throw paramResources;
      }
      b(paramAttributeSet);
    }
    for (;;)
    {
      paramResources.recycle();
      AppMethodBeat.o(192621);
      return;
      if (!androidx.core.content.a.g.a(paramXmlPullParser, "controlX1"))
      {
        paramResources = new InflateException("pathInterpolator requires the controlX1 attribute");
        AppMethodBeat.o(192621);
        throw paramResources;
      }
      if (!androidx.core.content.a.g.a(paramXmlPullParser, "controlY1"))
      {
        paramResources = new InflateException("pathInterpolator requires the controlY1 attribute");
        AppMethodBeat.o(192621);
        throw paramResources;
      }
      float f1 = androidx.core.content.a.g.a(paramResources, paramXmlPullParser, "controlX1", 0, 0.0F);
      float f2 = androidx.core.content.a.g.a(paramResources, paramXmlPullParser, "controlY1", 1, 0.0F);
      boolean bool = androidx.core.content.a.g.a(paramXmlPullParser, "controlX2");
      if (bool != androidx.core.content.a.g.a(paramXmlPullParser, "controlY2"))
      {
        paramResources = new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        AppMethodBeat.o(192621);
        throw paramResources;
      }
      if (!bool)
      {
        paramTheme = new Path();
        paramTheme.moveTo(0.0F, 0.0F);
        paramTheme.quadTo(f1, f2, 1.0F, 1.0F);
        b(paramTheme);
      }
      else
      {
        float f3 = androidx.core.content.a.g.a(paramResources, paramXmlPullParser, "controlX2", 2, 0.0F);
        float f4 = androidx.core.content.a.g.a(paramResources, paramXmlPullParser, "controlY2", 3, 0.0F);
        paramTheme = new Path();
        paramTheme.moveTo(0.0F, 0.0F);
        paramTheme.cubicTo(f1, f2, f3, f4, 1.0F, 1.0F);
        b(paramTheme);
      }
    }
  }
  
  private void b(Path paramPath)
  {
    AppMethodBeat.i(192637);
    paramPath = new PathMeasure(paramPath, false);
    float f1 = paramPath.getLength();
    int k = Math.min(3000, (int)(f1 / 0.002F) + 1);
    if (k <= 0)
    {
      paramPath = new IllegalArgumentException("The Path has a invalid length ".concat(String.valueOf(f1)));
      AppMethodBeat.o(192637);
      throw paramPath;
    }
    this.bvM = new float[k];
    this.bvN = new float[k];
    float[] arrayOfFloat = new float[2];
    int i = 0;
    while (i < k)
    {
      paramPath.getPosTan(i * f1 / (k - 1), arrayOfFloat, null);
      this.bvM[i] = arrayOfFloat[0];
      this.bvN[i] = arrayOfFloat[1];
      i += 1;
    }
    if ((Math.abs(this.bvM[0]) > 1.E-005D) || (Math.abs(this.bvN[0]) > 1.E-005D) || (Math.abs(this.bvM[(k - 1)] - 1.0F) > 1.E-005D) || (Math.abs(this.bvN[(k - 1)] - 1.0F) > 1.E-005D))
    {
      paramPath = new IllegalArgumentException("The Path must start at (0,0) and end at (1,1) start: " + this.bvM[0] + "," + this.bvN[0] + " end:" + this.bvM[(k - 1)] + "," + this.bvN[(k - 1)]);
      AppMethodBeat.o(192637);
      throw paramPath;
    }
    f1 = 0.0F;
    i = 0;
    int j = 0;
    while (j < k)
    {
      float f2 = this.bvM[i];
      if (f2 < f1)
      {
        paramPath = new IllegalArgumentException("The Path cannot loop back on itself, x :".concat(String.valueOf(f2)));
        AppMethodBeat.o(192637);
        throw paramPath;
      }
      this.bvM[j] = f2;
      j += 1;
      i += 1;
      f1 = f2;
    }
    if (paramPath.nextContour())
    {
      paramPath = new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
      AppMethodBeat.o(192637);
      throw paramPath;
    }
    AppMethodBeat.o(192637);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    int j = this.bvM.length - 1;
    int i = 0;
    while (j - i > 1)
    {
      int k = (i + j) / 2;
      if (paramFloat < this.bvM[k]) {
        j = k;
      } else {
        i = k;
      }
    }
    float f = this.bvM[j] - this.bvM[i];
    if (f == 0.0F) {
      return this.bvN[i];
    }
    paramFloat = (paramFloat - this.bvM[i]) / f;
    f = this.bvN[i];
    return paramFloat * (this.bvN[j] - f) + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.l.a.a.g
 * JD-Core Version:    0.7.0.1
 */