package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.core.content.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xmlpull.v1.XmlPullParser;

public class ArcMotion
  extends PathMotion
{
  private static final float apl;
  private float apm;
  private float apn;
  private float apo;
  private float apq;
  private float apr;
  private float aps;
  
  static
  {
    AppMethodBeat.i(191668);
    apl = (float)Math.tan(Math.toRadians(35.0D));
    AppMethodBeat.o(191668);
  }
  
  public ArcMotion()
  {
    this.apm = 0.0F;
    this.apn = 0.0F;
    this.apo = 70.0F;
    this.apq = 0.0F;
    this.apr = 0.0F;
    this.aps = apl;
  }
  
  public ArcMotion(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(191645);
    this.apm = 0.0F;
    this.apn = 0.0F;
    this.apo = 70.0F;
    this.apq = 0.0F;
    this.apr = 0.0F;
    this.aps = apl;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, q.ars);
    paramAttributeSet = (XmlPullParser)paramAttributeSet;
    float f = g.a(paramContext, paramAttributeSet, "minimumVerticalAngle", 1, 0.0F);
    this.apn = f;
    this.apr = C(f);
    f = g.a(paramContext, paramAttributeSet, "minimumHorizontalAngle", 0, 0.0F);
    this.apm = f;
    this.apq = C(f);
    f = g.a(paramContext, paramAttributeSet, "maximumAngle", 2, 70.0F);
    this.apo = f;
    this.aps = C(f);
    paramContext.recycle();
    AppMethodBeat.o(191645);
  }
  
  private static float C(float paramFloat)
  {
    AppMethodBeat.i(191652);
    if ((paramFloat < 0.0F) || (paramFloat > 90.0F))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Arc must be between 0 and 90 degrees");
      AppMethodBeat.o(191652);
      throw localIllegalArgumentException;
    }
    paramFloat = (float)Math.tan(Math.toRadians(paramFloat / 2.0F));
    AppMethodBeat.o(191652);
    return paramFloat;
  }
  
  public final Path getPath(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(191667);
    Path localPath = new Path();
    localPath.moveTo(paramFloat1, paramFloat2);
    float f1 = paramFloat3 - paramFloat1;
    float f2 = paramFloat4 - paramFloat2;
    float f3 = f2 * f2 + f1 * f1;
    float f5 = (paramFloat1 + paramFloat3) / 2.0F;
    float f6 = (paramFloat2 + paramFloat4) / 2.0F;
    float f4 = f3 * 0.25F;
    int i;
    label118:
    float f7;
    if (paramFloat2 > paramFloat4)
    {
      i = 1;
      if (Math.abs(f1) >= Math.abs(f2)) {
        break label285;
      }
      f1 = Math.abs(f3 / (2.0F * f2));
      if (i == 0) {
        break label273;
      }
      f2 = paramFloat4 + f1;
      f1 = paramFloat3;
      f3 = this.apr * f4 * this.apr;
      f7 = f5 - f1;
      float f8 = f6 - f2;
      f7 = f8 * f8 + f7 * f7;
      f4 = this.aps * f4 * this.aps;
      if (f7 >= f3) {
        break label338;
      }
    }
    for (;;)
    {
      label181:
      if (f3 != 0.0F)
      {
        f3 = (float)Math.sqrt(f3 / f7);
        f2 = (f2 - f6) * f3 + f6;
        f1 = (f1 - f5) * f3 + f5;
      }
      for (;;)
      {
        localPath.cubicTo((paramFloat1 + f1) / 2.0F, (paramFloat2 + f2) / 2.0F, (f1 + paramFloat3) / 2.0F, (f2 + paramFloat4) / 2.0F, paramFloat3, paramFloat4);
        AppMethodBeat.o(191667);
        return localPath;
        i = 0;
        break;
        label273:
        f2 = paramFloat2 + f1;
        f1 = paramFloat1;
        break label118;
        label285:
        f1 = f3 / (f1 * 2.0F);
        if (i != 0) {
          f1 += paramFloat1;
        }
        for (f2 = paramFloat2;; f2 = paramFloat4)
        {
          f3 = this.apq * f4 * this.apq;
          break;
          f1 = paramFloat3 - f1;
        }
        label338:
        if (f7 <= f4) {
          break label356;
        }
        f3 = f4;
        break label181;
      }
      label356:
      f3 = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.ArcMotion
 * JD-Core Version:    0.7.0.1
 */