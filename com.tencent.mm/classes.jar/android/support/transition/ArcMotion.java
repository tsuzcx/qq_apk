package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.support.v4.content.a.g;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class ArcMotion
  extends PathMotion
{
  private static final float zI = (float)Math.tan(Math.toRadians(35.0D));
  private float zJ = 0.0F;
  private float zK = 0.0F;
  private float zL = 70.0F;
  private float zM = 0.0F;
  private float zN = 0.0F;
  private float zO = zI;
  
  public ArcMotion() {}
  
  public ArcMotion(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.BZ);
    paramAttributeSet = (XmlPullParser)paramAttributeSet;
    float f = g.a(paramContext, paramAttributeSet, "minimumVerticalAngle", 1, 0.0F);
    this.zK = f;
    this.zN = w(f);
    f = g.a(paramContext, paramAttributeSet, "minimumHorizontalAngle", 0, 0.0F);
    this.zJ = f;
    this.zM = w(f);
    f = g.a(paramContext, paramAttributeSet, "maximumAngle", 2, 70.0F);
    this.zL = f;
    this.zO = w(f);
    paramContext.recycle();
  }
  
  private static float w(float paramFloat)
  {
    if ((paramFloat < 0.0F) || (paramFloat > 90.0F)) {
      throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }
    return (float)Math.tan(Math.toRadians(paramFloat / 2.0F));
  }
  
  public final Path getPath(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Path localPath = new Path();
    localPath.moveTo(paramFloat1, paramFloat2);
    float f1 = paramFloat3 - paramFloat1;
    float f2 = paramFloat4 - paramFloat2;
    float f3 = f2 * f2 + f1 * f1;
    float f5 = (paramFloat1 + paramFloat3) / 2.0F;
    float f6 = (paramFloat2 + paramFloat4) / 2.0F;
    float f4 = f3 * 0.25F;
    int i;
    label113:
    float f7;
    if (paramFloat2 > paramFloat4)
    {
      i = 1;
      if (Math.abs(f1) >= Math.abs(f2)) {
        break label275;
      }
      f1 = Math.abs(f3 / (2.0F * f2));
      if (i == 0) {
        break label263;
      }
      f2 = paramFloat4 + f1;
      f1 = paramFloat3;
      f3 = this.zN * f4 * this.zN;
      f7 = f5 - f1;
      float f8 = f6 - f2;
      f7 = f8 * f8 + f7 * f7;
      f4 = this.zO * f4 * this.zO;
      if (f7 >= f3) {
        break label328;
      }
    }
    for (;;)
    {
      label176:
      if (f3 != 0.0F)
      {
        f3 = (float)Math.sqrt(f3 / f7);
        f2 = (f2 - f6) * f3 + f6;
        f1 = (f1 - f5) * f3 + f5;
      }
      for (;;)
      {
        localPath.cubicTo((paramFloat1 + f1) / 2.0F, (paramFloat2 + f2) / 2.0F, (f1 + paramFloat3) / 2.0F, (f2 + paramFloat4) / 2.0F, paramFloat3, paramFloat4);
        return localPath;
        i = 0;
        break;
        label263:
        f2 = paramFloat2 + f1;
        f1 = paramFloat1;
        break label113;
        label275:
        f1 = f3 / (f1 * 2.0F);
        if (i != 0) {
          f1 += paramFloat1;
        }
        for (f2 = paramFloat2;; f2 = paramFloat4)
        {
          f3 = this.zM * f4 * this.zM;
          break;
          f1 = paramFloat3 - f1;
        }
        label328:
        if (f7 <= f4) {
          break label346;
        }
        f3 = f4;
        break label176;
      }
      label346:
      f3 = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.ArcMotion
 * JD-Core Version:    0.7.0.1
 */