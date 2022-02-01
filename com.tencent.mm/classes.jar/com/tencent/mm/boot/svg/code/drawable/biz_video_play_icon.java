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

public class biz_video_play_icon
  extends c
{
  private final int height = 7;
  private final int width = 6;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 6;
      return 7;
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 230, 31);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -275.0F, 0.0F, 1.0F, -432.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 314.0F, 0.0F, 1.0F, 381.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 41.999996F, 0.0F, 1.0F, 48.666668F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(4.682732F, 2.458604F);
      ((Path)localObject2).lineTo(8.70237F, 4.932228F);
      ((Path)localObject2).cubicTo(9.015942F, 5.125195F, 9.113711F, 5.535826F, 8.920744F, 5.849398F);
      ((Path)localObject2).cubicTo(8.866049F, 5.938279F, 8.79125F, 6.013077F, 8.70237F, 6.067772F);
      ((Path)localObject2).lineTo(4.682732F, 8.541396F);
      ((Path)localObject2).cubicTo(4.36916F, 8.734364F, 3.958529F, 8.636594F, 3.765561F, 8.323022F);
      ((Path)localObject2).cubicTo(3.700902F, 8.21795F, 3.666667F, 8.096997F, 3.666667F, 7.973624F);
      ((Path)localObject2).lineTo(3.666667F, 3.026376F);
      ((Path)localObject2).cubicTo(3.666667F, 2.658186F, 3.965143F, 2.35971F, 4.333334F, 2.35971F);
      ((Path)localObject2).cubicTo(4.456707F, 2.35971F, 4.57766F, 2.393945F, 4.682732F, 2.458604F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.biz_video_play_icon
 * JD-Core Version:    0.7.0.1
 */