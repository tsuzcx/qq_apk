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

public class connectkeyboad_banner_icon_maclock
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
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
      ((Paint)localObject2).setColor(-9538696);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 17.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(46.0F, 55.0F);
      ((Path)localObject3).lineTo(46.0F, 55.577999F);
      ((Path)localObject3).lineTo(46.215F, 56.113998F);
      ((Path)localObject3).lineTo(47.769001F, 60.0F);
      ((Path)localObject3).lineTo(33.230999F, 60.0F);
      ((Path)localObject3).lineTo(34.785F, 56.113998F);
      ((Path)localObject3).lineTo(35.0F, 55.577999F);
      ((Path)localObject3).lineTo(35.0F, 55.0F);
      ((Path)localObject3).lineTo(46.0F, 55.0F);
      ((Path)localObject3).lineTo(46.0F, 55.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(3.0F, 4.44F);
      ((Path)localObject3).cubicTo(3.0F, 3.645F, 3.64F, 3.0F, 4.445F, 3.0F);
      ((Path)localObject3).lineTo(75.555F, 3.0F);
      ((Path)localObject3).cubicTo(76.352997F, 3.0F, 77.0F, 3.637F, 77.0F, 4.44F);
      ((Path)localObject3).lineTo(77.0F, 29.0F);
      ((Path)localObject3).lineTo(80.0F, 29.0F);
      ((Path)localObject3).lineTo(80.0F, 4.316F);
      ((Path)localObject3).cubicTo(80.0F, 1.925F, 78.068001F, 0.0F, 75.684998F, 0.0F);
      ((Path)localObject3).lineTo(4.315F, 0.0F);
      ((Path)localObject3).cubicTo(1.938F, 0.0F, 0.0F, 1.932F, 0.0F, 4.316F);
      ((Path)localObject3).lineTo(0.0F, 50.683998F);
      ((Path)localObject3).cubicTo(0.0F, 53.075001F, 1.932F, 55.0F, 4.315F, 55.0F);
      ((Path)localObject3).lineTo(32.0F, 55.0F);
      ((Path)localObject3).lineTo(30.0F, 60.0F);
      ((Path)localObject3).lineTo(26.0F, 62.0F);
      ((Path)localObject3).lineTo(26.0F, 63.0F);
      ((Path)localObject3).lineTo(55.0F, 63.0F);
      ((Path)localObject3).lineTo(55.0F, 62.0F);
      ((Path)localObject3).lineTo(51.0F, 60.0F);
      ((Path)localObject3).lineTo(49.0F, 55.0F);
      ((Path)localObject3).lineTo(59.0F, 55.0F);
      ((Path)localObject3).lineTo(59.0F, 52.0F);
      ((Path)localObject3).lineTo(49.0F, 52.0F);
      ((Path)localObject3).lineTo(32.0F, 52.0F);
      ((Path)localObject3).lineTo(4.445F, 52.0F);
      ((Path)localObject3).cubicTo(3.647F, 52.0F, 3.0F, 51.362999F, 3.0F, 50.560001F);
      ((Path)localObject3).lineTo(3.0F, 43.0F);
      ((Path)localObject3).lineTo(59.0F, 43.0F);
      ((Path)localObject3).lineTo(59.0F, 40.0F);
      ((Path)localObject3).lineTo(3.0F, 40.0F);
      ((Path)localObject3).lineTo(3.0F, 4.44F);
      ((Path)localObject3).lineTo(3.0F, 4.44F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(65.0F, 60.0F);
      ((Path)localObject2).lineTo(84.0F, 60.0F);
      ((Path)localObject2).lineTo(84.0F, 46.0F);
      ((Path)localObject2).lineTo(65.0F, 46.0F);
      ((Path)localObject2).lineTo(65.0F, 60.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(69.0F, 37.0F);
      ((Path)localObject2).cubicTo(69.0F, 35.895F, 69.900002F, 35.0F, 70.991997F, 35.0F);
      ((Path)localObject2).lineTo(78.008003F, 35.0F);
      ((Path)localObject2).cubicTo(79.108002F, 35.0F, 80.0F, 35.887001F, 80.0F, 37.0F);
      ((Path)localObject2).lineTo(80.0F, 43.0F);
      ((Path)localObject2).lineTo(69.0F, 43.0F);
      ((Path)localObject2).lineTo(69.0F, 37.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(84.132004F, 43.0F);
      ((Path)localObject2).lineTo(83.0F, 43.0F);
      ((Path)localObject2).lineTo(83.0F, 37.754002F);
      ((Path)localObject2).cubicTo(83.0F, 34.574001F, 80.422997F, 32.0F, 77.245003F, 32.0F);
      ((Path)localObject2).lineTo(71.754997F, 32.0F);
      ((Path)localObject2).cubicTo(68.582001F, 32.0F, 66.0F, 34.576F, 66.0F, 37.754002F);
      ((Path)localObject2).lineTo(66.0F, 43.0F);
      ((Path)localObject2).lineTo(64.867996F, 43.0F);
      ((Path)localObject2).cubicTo(63.291F, 43.0F, 62.0F, 44.292F, 62.0F, 45.887001F);
      ((Path)localObject2).lineTo(62.0F, 60.112999F);
      ((Path)localObject2).cubicTo(62.0F, 61.717999F, 63.284F, 63.0F, 64.867996F, 63.0F);
      ((Path)localObject2).lineTo(84.132004F, 63.0F);
      ((Path)localObject2).cubicTo(85.709F, 63.0F, 87.0F, 61.708F, 87.0F, 60.112999F);
      ((Path)localObject2).lineTo(87.0F, 45.887001F);
      ((Path)localObject2).cubicTo(87.0F, 44.280998F, 85.716003F, 43.0F, 84.132004F, 43.0F);
      ((Path)localObject2).lineTo(84.132004F, 43.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.connectkeyboad_banner_icon_maclock
 * JD-Core Version:    0.7.0.1
 */