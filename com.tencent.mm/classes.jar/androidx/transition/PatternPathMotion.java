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
  private final Matrix bpU;
  private Path cfG;
  private final Path cfH;
  
  public PatternPathMotion()
  {
    AppMethodBeat.i(201247);
    this.cfH = new Path();
    this.bpU = new Matrix();
    this.cfH.lineTo(1.0F, 0.0F);
    this.cfG = this.cfH;
    AppMethodBeat.o(201247);
  }
  
  public PatternPathMotion(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(201269);
    this.cfH = new Path();
    this.bpU = new Matrix();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, q.cgb);
    try
    {
      paramAttributeSet = g.c(paramContext, (XmlPullParser)paramAttributeSet, "patternPathData", 0);
      if (paramAttributeSet == null)
      {
        paramAttributeSet = new RuntimeException("pathData must be supplied for patternPathMotion");
        AppMethodBeat.o(201269);
        throw paramAttributeSet;
      }
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(201269);
    }
    paramAttributeSet = d.au(paramAttributeSet);
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
      AppMethodBeat.o(201269);
      throw paramAttributeSet;
    }
    this.bpU.setTranslate(-f4, -f2);
    f3 -= f4;
    f1 -= f2;
    f2 = 1.0F / S(f3, f1);
    this.bpU.postScale(f2, f2);
    double d = Math.atan2(f1, f3);
    this.bpU.postRotate((float)Math.toDegrees(-d));
    paramAttributeSet.transform(this.bpU, this.cfH);
    this.cfG = paramAttributeSet;
    paramContext.recycle();
    AppMethodBeat.o(201269);
  }
  
  private static float S(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(201277);
    paramFloat1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
    AppMethodBeat.o(201277);
    return paramFloat1;
  }
  
  public final Path getPath(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(201285);
    paramFloat3 -= paramFloat1;
    paramFloat4 -= paramFloat2;
    float f = S(paramFloat3, paramFloat4);
    double d = Math.atan2(paramFloat4, paramFloat3);
    this.bpU.setScale(f, f);
    this.bpU.postRotate((float)Math.toDegrees(d));
    this.bpU.postTranslate(paramFloat1, paramFloat2);
    Path localPath = new Path();
    this.cfH.transform(this.bpU, localPath);
    AppMethodBeat.o(201285);
    return localPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.transition.PatternPathMotion
 * JD-Core Version:    0.7.0.1
 */