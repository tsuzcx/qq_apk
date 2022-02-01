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

public class ic_download_pause_alert
  extends c
{
  private final int height = 64;
  private final int width = 64;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 64;
      return 64;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.instancePaint((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -148.0F, 0.0F, 1.0F, -486.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 446.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject2, -1.0F, -1.224647E-016F, 212.0F, 1.224647E-016F, -1.0F, 104.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(64.0F, 0.0F);
      ((Path)localObject2).lineTo(64.0F, 64.0F);
      ((Path)localObject2).lineTo(0.0F, 64.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, -1.0F, 0.0F, 56.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(419430400);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(24.0F, 0.0F);
      ((Path)localObject3).cubicTo(37.254833F, 0.0F, 48.0F, 10.745166F, 48.0F, 24.0F);
      ((Path)localObject3).cubicTo(48.0F, 37.254833F, 37.254833F, 48.0F, 24.0F, 48.0F);
      ((Path)localObject3).cubicTo(10.745166F, 48.0F, 0.0F, 37.254833F, 0.0F, 24.0F);
      ((Path)localObject3).cubicTo(0.0F, 10.745166F, 10.745166F, 0.0F, 24.0F, 0.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(24.0F, 4.0F);
      ((Path)localObject3).cubicTo(12.954305F, 4.0F, 4.0F, 12.954305F, 4.0F, 24.0F);
      ((Path)localObject3).cubicTo(4.0F, 35.045696F, 12.954305F, 44.0F, 24.0F, 44.0F);
      ((Path)localObject3).cubicTo(35.045696F, 44.0F, 44.0F, 35.045696F, 44.0F, 24.0F);
      ((Path)localObject3).cubicTo(44.0F, 12.954305F, 35.045696F, 4.0F, 24.0F, 4.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-2147483648);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(46.0F, 22.0F);
      ((Path)localObject2).cubicTo(47.104568F, 22.0F, 48.0F, 22.89543F, 48.0F, 24.0F);
      ((Path)localObject2).lineTo(48.0F, 24.0F);
      ((Path)localObject2).lineTo(48.0F, 24.0F);
      ((Path)localObject2).cubicTo(48.0F, 37.221699F, 37.308495F, 47.946259F, 24.099363F, 47.999798F);
      ((Path)localObject2).lineTo(24.025F, 47.999001F);
      ((Path)localObject2).lineTo(24.0F, 48.0F);
      ((Path)localObject2).cubicTo(22.945639F, 48.0F, 22.081835F, 47.184124F, 22.005486F, 46.149261F);
      ((Path)localObject2).lineTo(22.0F, 46.0F);
      ((Path)localObject2).cubicTo(22.0F, 44.895432F, 22.89543F, 44.0F, 24.0F, 44.0F);
      ((Path)localObject2).lineTo(24.0F, 44.0F);
      ((Path)localObject2).cubicTo(35.045696F, 44.0F, 44.0F, 35.045696F, 44.0F, 24.0F);
      ((Path)localObject2).lineTo(44.0F, 23.999001F);
      ((Path)localObject2).lineTo(44.005486F, 23.850739F);
      ((Path)localObject2).cubicTo(44.078197F, 22.865156F, 44.865158F, 22.078199F, 45.850739F, 22.005486F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-2147483648);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(28.0F, 24.0F);
      ((Path)localObject1).lineTo(28.0F, 40.0F);
      ((Path)localObject1).lineTo(24.0F, 40.0F);
      ((Path)localObject1).lineTo(24.0F, 24.0F);
      ((Path)localObject1).lineTo(28.0F, 24.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(40.0F, 24.0F);
      ((Path)localObject1).lineTo(40.0F, 40.0F);
      ((Path)localObject1).lineTo(36.0F, 40.0F);
      ((Path)localObject1).lineTo(36.0F, 24.0F);
      ((Path)localObject1).lineTo(40.0F, 24.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ic_download_pause_alert
 * JD-Core Version:    0.7.0.1
 */