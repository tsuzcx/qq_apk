package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class setting_plugin_uninstall
  extends c
{
  private final int height = 44;
  private final int width = 48;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 44;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-3750202);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 13.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(9.666615F, 0.0F);
      localPath.lineTo(11.372898F, 0.0F);
      localPath.cubicTo(19.305622F, 0.02008788F, 24.773712F, 9.732577F, 20.512991F, 16.52228F);
      localPath.cubicTo(16.801077F, 23.834269F, 5.156437F, 23.824224F, 1.464478F, 16.502193F);
      localPath.cubicTo(-2.556764F, 9.973632F, 2.20287F, 0.8738228F, 9.666615F, 0.0F);
      localPath.lineTo(9.666615F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 22.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(6.158603F, 1.137319F);
      localPath.cubicTo(12.047705F, -2.00158F, 20.032927F, 1.687126F, 21.580063F, 8.154857F);
      localPath.cubicTo(23.476555F, 14.432654F, 18.695402F, 21.130304F, 12.34715F, 22.0F);
      localPath.lineTo(9.921639F, 22.0F);
      localPath.cubicTo(4.64141F, 21.400211F, 0.359335F, 16.991756F, 0.0F, 11.673622F);
      localPath.lineTo(0.0F, 9.884251F);
      localPath.cubicTo(0.6188548F, 6.23553F, 2.714976F, 2.736758F, 6.158603F, 1.137319F);
      localPath.lineTo(6.158603F, 1.137319F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 26.0F, 0.0F, 1.0F, 22.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.06973729F, 11.944695F);
      ((Path)localObject2).cubicTo(-0.7299077F, 5.407746F, 5.477336F, -0.7793648F, 12.014434F, 0.08023384F);
      ((Path)localObject2).cubicTo(17.142157F, 0.400085F, 21.220346F, 4.75805F, 22.0F, 9.70574F);
      ((Path)localObject2).lineTo(22.0F, 12.044648F);
      ((Path)localObject2).cubicTo(21.440248F, 17.152264F, 17.332073F, 21.260345F, 12.284314F, 22.0F);
      ((Path)localObject2).lineTo(10.015322F, 22.0F);
      ((Path)localObject2).cubicTo(4.877603F, 21.440262F, 0.3795997F, 17.192245F, 0.06973729F, 11.944695F);
      ((Path)localObject2).lineTo(0.06973729F, 11.944695F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.setting_plugin_uninstall
 * JD-Core Version:    0.7.0.1
 */