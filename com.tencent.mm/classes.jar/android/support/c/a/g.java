package android.support.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.graphics.c;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

public final class g
  implements Interpolator
{
  private float[] nI;
  private float[] nJ;
  
  public g(Context paramContext, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser)
  {
    this(paramContext.getResources(), paramContext.getTheme(), paramAttributeSet, paramXmlPullParser);
  }
  
  private g(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser)
  {
    paramResources = android.support.v4.content.a.g.a(paramResources, paramTheme, paramAttributeSet, a.nu);
    if (android.support.v4.content.a.g.a(paramXmlPullParser, "pathData"))
    {
      paramTheme = android.support.v4.content.a.g.c(paramResources, paramXmlPullParser, "pathData", 4);
      paramAttributeSet = c.J(paramTheme);
      if (paramAttributeSet == null) {
        throw new InflateException("The path is null, which is created from ".concat(String.valueOf(paramTheme)));
      }
      a(paramAttributeSet);
    }
    for (;;)
    {
      paramResources.recycle();
      return;
      if (!android.support.v4.content.a.g.a(paramXmlPullParser, "controlX1")) {
        throw new InflateException("pathInterpolator requires the controlX1 attribute");
      }
      if (!android.support.v4.content.a.g.a(paramXmlPullParser, "controlY1")) {
        throw new InflateException("pathInterpolator requires the controlY1 attribute");
      }
      float f1 = android.support.v4.content.a.g.a(paramResources, paramXmlPullParser, "controlX1", 0, 0.0F);
      float f2 = android.support.v4.content.a.g.a(paramResources, paramXmlPullParser, "controlY1", 1, 0.0F);
      boolean bool = android.support.v4.content.a.g.a(paramXmlPullParser, "controlX2");
      if (bool != android.support.v4.content.a.g.a(paramXmlPullParser, "controlY2")) {
        throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
      }
      if (!bool)
      {
        paramTheme = new Path();
        paramTheme.moveTo(0.0F, 0.0F);
        paramTheme.quadTo(f1, f2, 1.0F, 1.0F);
        a(paramTheme);
      }
      else
      {
        float f3 = android.support.v4.content.a.g.a(paramResources, paramXmlPullParser, "controlX2", 2, 0.0F);
        float f4 = android.support.v4.content.a.g.a(paramResources, paramXmlPullParser, "controlY2", 3, 0.0F);
        paramTheme = new Path();
        paramTheme.moveTo(0.0F, 0.0F);
        paramTheme.cubicTo(f1, f2, f3, f4, 1.0F, 1.0F);
        a(paramTheme);
      }
    }
  }
  
  private void a(Path paramPath)
  {
    paramPath = new PathMeasure(paramPath, false);
    float f1 = paramPath.getLength();
    int k = Math.min(3000, (int)(f1 / 0.002F) + 1);
    if (k <= 0) {
      throw new IllegalArgumentException("The Path has a invalid length ".concat(String.valueOf(f1)));
    }
    this.nI = new float[k];
    this.nJ = new float[k];
    float[] arrayOfFloat = new float[2];
    int i = 0;
    while (i < k)
    {
      paramPath.getPosTan(i * f1 / (k - 1), arrayOfFloat, null);
      this.nI[i] = arrayOfFloat[0];
      this.nJ[i] = arrayOfFloat[1];
      i += 1;
    }
    if ((Math.abs(this.nI[0]) > 1.E-005D) || (Math.abs(this.nJ[0]) > 1.E-005D) || (Math.abs(this.nI[(k - 1)] - 1.0F) > 1.E-005D) || (Math.abs(this.nJ[(k - 1)] - 1.0F) > 1.E-005D)) {
      throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1) start: " + this.nI[0] + "," + this.nJ[0] + " end:" + this.nI[(k - 1)] + "," + this.nJ[(k - 1)]);
    }
    f1 = 0.0F;
    i = 0;
    int j = 0;
    while (j < k)
    {
      float f2 = this.nI[i];
      if (f2 < f1) {
        throw new IllegalArgumentException("The Path cannot loop back on itself, x :".concat(String.valueOf(f2)));
      }
      this.nI[j] = f2;
      j += 1;
      i += 1;
      f1 = f2;
    }
    if (paramPath.nextContour()) {
      throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
    }
  }
  
  public final float getInterpolation(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    int j = this.nI.length - 1;
    int i = 0;
    while (j - i > 1)
    {
      int k = (i + j) / 2;
      if (paramFloat < this.nI[k]) {
        j = k;
      } else {
        i = k;
      }
    }
    float f = this.nI[j] - this.nI[i];
    if (f == 0.0F) {
      return this.nJ[i];
    }
    paramFloat = (paramFloat - this.nI[i]) / f;
    f = this.nJ[i];
    return paramFloat * (this.nJ[j] - f) + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.c.a.g
 * JD-Core Version:    0.7.0.1
 */