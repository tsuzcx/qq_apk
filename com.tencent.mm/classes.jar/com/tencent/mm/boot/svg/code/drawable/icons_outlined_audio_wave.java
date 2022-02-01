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

public class icons_outlined_audio_wave
  extends c
{
  private final int height = 18;
  private final int width = 18;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 18;
      return 18;
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
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -5.0F, 0.0F, 1.0F, -5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(11.55F, 5.833334F);
      ((Path)localObject2).cubicTo(12.129899F, 5.833334F, 12.6F, 6.303434F, 12.6F, 6.883333F);
      ((Path)localObject2).lineTo(12.6F, 21.116667F);
      ((Path)localObject2).cubicTo(12.6F, 21.696566F, 12.129899F, 22.166666F, 11.55F, 22.166666F);
      ((Path)localObject2).cubicTo(10.970101F, 22.166666F, 10.5F, 21.696566F, 10.5F, 21.116667F);
      ((Path)localObject2).lineTo(10.5F, 6.883333F);
      ((Path)localObject2).cubicTo(10.5F, 6.303434F, 10.970101F, 5.833334F, 11.55F, 5.833334F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(21.583334F, 9.333333F);
      ((Path)localObject2).cubicTo(22.163233F, 9.333333F, 22.633333F, 9.803434F, 22.633333F, 10.383333F);
      ((Path)localObject2).lineTo(22.633333F, 17.616667F);
      ((Path)localObject2).cubicTo(22.633333F, 18.196566F, 22.163233F, 18.666666F, 21.583334F, 18.666666F);
      ((Path)localObject2).cubicTo(21.003435F, 18.666666F, 20.533333F, 18.196566F, 20.533333F, 17.616667F);
      ((Path)localObject2).lineTo(20.533333F, 10.383333F);
      ((Path)localObject2).cubicTo(20.533333F, 9.803434F, 21.003435F, 9.333333F, 21.583334F, 9.333333F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(6.533333F, 9.333333F);
      ((Path)localObject2).cubicTo(7.113232F, 9.333333F, 7.583334F, 9.803434F, 7.583334F, 10.383333F);
      ((Path)localObject2).lineTo(7.583334F, 17.616667F);
      ((Path)localObject2).cubicTo(7.583334F, 18.196566F, 7.113232F, 18.666666F, 6.533333F, 18.666666F);
      ((Path)localObject2).cubicTo(5.953435F, 18.666666F, 5.483333F, 18.196566F, 5.483333F, 17.616667F);
      ((Path)localObject2).lineTo(5.483333F, 10.383333F);
      ((Path)localObject2).cubicTo(5.483333F, 9.803434F, 5.953435F, 9.333333F, 6.533333F, 9.333333F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.566668F, 10.733334F);
      ((Path)localObject2).cubicTo(17.146566F, 10.733334F, 17.616667F, 11.203434F, 17.616667F, 11.783333F);
      ((Path)localObject2).lineTo(17.616667F, 16.216667F);
      ((Path)localObject2).cubicTo(17.616667F, 16.796566F, 17.146566F, 17.266666F, 16.566668F, 17.266666F);
      ((Path)localObject2).cubicTo(15.986768F, 17.266666F, 15.516666F, 16.796566F, 15.516666F, 16.216667F);
      ((Path)localObject2).lineTo(15.516666F, 11.783333F);
      ((Path)localObject2).cubicTo(15.516666F, 11.203434F, 15.986768F, 10.733334F, 16.566668F, 10.733334F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_audio_wave
 * JD-Core Version:    0.7.0.1
 */