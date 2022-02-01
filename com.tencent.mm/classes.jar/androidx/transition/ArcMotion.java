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
  private static final float cdV;
  private float cdW;
  private float cdX;
  private float cdY;
  private float cdZ;
  private float cea;
  private float ceb;
  
  static
  {
    AppMethodBeat.i(201232);
    cdV = (float)Math.tan(Math.toRadians(35.0D));
    AppMethodBeat.o(201232);
  }
  
  public ArcMotion()
  {
    this.cdW = 0.0F;
    this.cdX = 0.0F;
    this.cdY = 70.0F;
    this.cdZ = 0.0F;
    this.cea = 0.0F;
    this.ceb = cdV;
  }
  
  public ArcMotion(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(201214);
    this.cdW = 0.0F;
    this.cdX = 0.0F;
    this.cdY = 70.0F;
    this.cdZ = 0.0F;
    this.cea = 0.0F;
    this.ceb = cdV;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, q.cga);
    paramAttributeSet = (XmlPullParser)paramAttributeSet;
    float f = g.a(paramContext, paramAttributeSet, "minimumVerticalAngle", 1, 0.0F);
    this.cdX = f;
    this.cea = aJ(f);
    f = g.a(paramContext, paramAttributeSet, "minimumHorizontalAngle", 0, 0.0F);
    this.cdW = f;
    this.cdZ = aJ(f);
    f = g.a(paramContext, paramAttributeSet, "maximumAngle", 2, 70.0F);
    this.cdY = f;
    this.ceb = aJ(f);
    paramContext.recycle();
    AppMethodBeat.o(201214);
  }
  
  private static float aJ(float paramFloat)
  {
    AppMethodBeat.i(201222);
    if ((paramFloat < 0.0F) || (paramFloat > 90.0F))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Arc must be between 0 and 90 degrees");
      AppMethodBeat.o(201222);
      throw localIllegalArgumentException;
    }
    paramFloat = (float)Math.tan(Math.toRadians(paramFloat / 2.0F));
    AppMethodBeat.o(201222);
    return paramFloat;
  }
  
  public final Path getPath(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(201243);
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
      f3 = this.cea * f4 * this.cea;
      f7 = f5 - f1;
      float f8 = f6 - f2;
      f7 = f8 * f8 + f7 * f7;
      f4 = this.ceb * f4 * this.ceb;
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
        AppMethodBeat.o(201243);
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
          f3 = this.cdZ * f4 * this.cdZ;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.transition.ArcMotion
 * JD-Core Version:    0.7.0.1
 */