package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.core.content.a.g;
import androidx.core.graphics.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion
  extends PathMotion
{
  private final Matrix JR;
  private Path aqX;
  private final Path aqY;
  
  public PatternPathMotion()
  {
    AppMethodBeat.i(192439);
    this.aqY = new Path();
    this.JR = new Matrix();
    this.aqY.lineTo(1.0F, 0.0F);
    this.aqX = this.aqY;
    AppMethodBeat.o(192439);
  }
  
  public PatternPathMotion(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(192441);
    this.aqY = new Path();
    this.JR = new Matrix();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, q.art);
    try
    {
      paramAttributeSet = g.c(paramContext, (XmlPullParser)paramAttributeSet, "patternPathData", 0);
      if (paramAttributeSet == null)
      {
        paramAttributeSet = new RuntimeException("pathData must be supplied for patternPathMotion");
        AppMethodBeat.o(192441);
        throw paramAttributeSet;
      }
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(192441);
    }
    paramAttributeSet = d.A(paramAttributeSet);
    PathMeasure localPathMeasure = new PathMeasure(paramAttributeSet, false);
    float f1 = localPathMeasure.getLength();
    float[] arrayOfFloat = new float[2];
    localPathMeasure.getPosTan(f1, arrayOfFloat, null);
    float f3 = arrayOfFloat[0];
    f1 = arrayOfFloat[1];
    localPathMeasure.getPosTan(0.0F, arrayOfFloat, null);
    float f4 = arrayOfFloat[0];
    float f2 = arrayOfFloat[1];
    if ((f4 == f3) && (f2 == f1))
    {
      paramAttributeSet = new IllegalArgumentException("pattern must not end at the starting point");
      AppMethodBeat.o(192441);
      throw paramAttributeSet;
    }
    this.JR.setTranslate(-f4, -f2);
    f3 -= f4;
    f1 -= f2;
    f2 = 1.0F / j(f3, f1);
    this.JR.postScale(f2, f2);
    double d = Math.atan2(f1, f3);
    this.JR.postRotate((float)Math.toDegrees(-d));
    paramAttributeSet.transform(this.JR, this.aqY);
    this.aqX = paramAttributeSet;
    paramContext.recycle();
    AppMethodBeat.o(192441);
  }
  
  private static float j(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(192449);
    paramFloat1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
    AppMethodBeat.o(192449);
    return paramFloat1;
  }
  
  public final Path getPath(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(192446);
    paramFloat3 -= paramFloat1;
    paramFloat4 -= paramFloat2;
    float f = j(paramFloat3, paramFloat4);
    double d = Math.atan2(paramFloat4, paramFloat3);
    this.JR.setScale(f, f);
    this.JR.postRotate((float)Math.toDegrees(d));
    this.JR.postTranslate(paramFloat1, paramFloat2);
    Path localPath = new Path();
    this.aqY.transform(this.JR, localPath);
    AppMethodBeat.o(192446);
    return localPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.PatternPathMotion
 * JD-Core Version:    0.7.0.1
 */