package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion
  extends PathMotion
{
  private final Matrix qh = new Matrix();
  private Path rn;
  private final Path ro = new Path();
  
  public PatternPathMotion()
  {
    this.ro.lineTo(1.0F, 0.0F);
    this.rn = this.ro;
  }
  
  public PatternPathMotion(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ad.rL);
    try
    {
      paramAttributeSet = android.support.v4.content.a.c.b(paramContext, (XmlPullParser)paramAttributeSet, "patternPathData", 0);
      if (paramAttributeSet == null) {
        throw new RuntimeException("pathData must be supplied for patternPathMotion");
      }
    }
    finally
    {
      paramContext.recycle();
    }
    paramAttributeSet = android.support.v4.a.c.I(paramAttributeSet);
    PathMeasure localPathMeasure = new PathMeasure(paramAttributeSet, false);
    float f1 = localPathMeasure.getLength();
    float[] arrayOfFloat = new float[2];
    localPathMeasure.getPosTan(f1, arrayOfFloat, null);
    float f3 = arrayOfFloat[0];
    f1 = arrayOfFloat[1];
    localPathMeasure.getPosTan(0.0F, arrayOfFloat, null);
    float f4 = arrayOfFloat[0];
    float f2 = arrayOfFloat[1];
    if ((f4 == f3) && (f2 == f1)) {
      throw new IllegalArgumentException("pattern must not end at the starting point");
    }
    this.qh.setTranslate(-f4, -f2);
    f3 -= f4;
    f1 -= f2;
    f2 = 1.0F / r(f3, f1);
    this.qh.postScale(f2, f2);
    double d = Math.atan2(f1, f3);
    this.qh.postRotate((float)Math.toDegrees(-d));
    paramAttributeSet.transform(this.qh, this.ro);
    this.rn = paramAttributeSet;
    paramContext.recycle();
  }
  
  private static float r(float paramFloat1, float paramFloat2)
  {
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public final Path getPath(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat3 -= paramFloat1;
    paramFloat4 -= paramFloat2;
    float f = r(paramFloat3, paramFloat4);
    double d = Math.atan2(paramFloat4, paramFloat3);
    this.qh.setScale(f, f);
    this.qh.postRotate((float)Math.toDegrees(d));
    this.qh.postTranslate(paramFloat1, paramFloat2);
    Path localPath = new Path();
    this.ro.transform(this.qh, localPath);
    return localPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.PatternPathMotion
 * JD-Core Version:    0.7.0.1
 */