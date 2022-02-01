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

public class icons_filled_remove_bg
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(4.870382F, 23.200001F);
      ((Path)localObject3).lineTo(1.818182F, 23.200001F);
      ((Path)localObject3).cubicTo(1.255856F, 23.200001F, 0.8F, 22.744144F, 0.8F, 22.181818F);
      ((Path)localObject3).lineTo(0.8F, 18.120138F);
      ((Path)localObject3).lineTo(2.304771F, 18.120138F);
      ((Path)localObject3).lineTo(2.304771F, 21.799999F);
      ((Path)localObject3).lineTo(4.870382F, 21.799999F);
      ((Path)localObject3).lineTo(21.666151F, 21.784334F);
      ((Path)localObject3).lineTo(21.666151F, 18.11097F);
      ((Path)localObject3).lineTo(23.197655F, 18.11097F);
      ((Path)localObject3).lineTo(23.197655F, 22.181818F);
      ((Path)localObject3).cubicTo(23.197655F, 22.744144F, 22.741798F, 23.200001F, 22.179474F, 23.200001F);
      ((Path)localObject3).lineTo(4.870382F, 23.200001F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(1.818182F, 0.8F);
      ((Path)localObject3).lineTo(5.916729F, 0.8F);
      ((Path)localObject3).lineTo(5.916729F, 2.347675F);
      ((Path)localObject3).lineTo(2.322577F, 2.347675F);
      ((Path)localObject3).lineTo(2.322577F, 5.883533F);
      ((Path)localObject3).lineTo(0.8F, 5.883533F);
      ((Path)localObject3).lineTo(0.8F, 1.818182F);
      ((Path)localObject3).cubicTo(0.8F, 1.255856F, 1.255856F, 0.8F, 1.818182F, 0.8F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(22.179474F, 0.8F);
      ((Path)localObject3).cubicTo(22.741798F, 0.8F, 23.197655F, 1.255856F, 23.197655F, 1.818182F);
      ((Path)localObject3).lineTo(23.197655F, 5.903216F);
      ((Path)localObject3).lineTo(21.644531F, 5.903216F);
      ((Path)localObject3).lineTo(21.644531F, 2.363103F);
      ((Path)localObject3).lineTo(18.140741F, 2.363103F);
      ((Path)localObject3).lineTo(18.140741F, 0.8F);
      ((Path)localObject3).lineTo(22.179474F, 0.8F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(8.945455F, 0.8F);
      ((Path)localObject3).lineTo(15.054545F, 0.8F);
      ((Path)localObject3).lineTo(15.054545F, 2.327273F);
      ((Path)localObject3).lineTo(8.945455F, 2.327273F);
      ((Path)localObject3).lineTo(8.945455F, 0.8F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(0.8F, 8.942418F);
      ((Path)localObject3).lineTo(2.327273F, 8.942418F);
      ((Path)localObject3).lineTo(2.327273F, 15.037204F);
      ((Path)localObject3).lineTo(0.8F, 15.037204F);
      ((Path)localObject3).lineTo(0.8F, 8.942418F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(21.672728F, 8.945455F);
      ((Path)localObject3).lineTo(23.200001F, 8.945455F);
      ((Path)localObject3).lineTo(23.200001F, 15.04024F);
      ((Path)localObject3).lineTo(21.672728F, 15.04024F);
      ((Path)localObject3).lineTo(21.672728F, 8.945455F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-100663296);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(1.4F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(3.612992F, 21.103752F);
      ((Path)localObject2).lineTo(20.387997F, 21.103752F);
      ((Path)localObject2).cubicTo(20.262011F, 20.916302F, 20.099764F, 20.75753F, 19.931206F, 20.675081F);
      ((Path)localObject2).lineTo(14.370157F, 17.954939F);
      ((Path)localObject2).cubicTo(13.151746F, 17.358963F, 12.857854F, 15.951832F, 13.730429F, 14.914611F);
      ((Path)localObject2).lineTo(14.085618F, 14.4924F);
      ((Path)localObject2).cubicTo(14.70045F, 13.761557F, 15.229825F, 12.311421F, 15.229825F, 11.35559F);
      ((Path)localObject2).lineTo(15.229825F, 9.670945F);
      ((Path)localObject2).cubicTo(15.229825F, 7.881831F, 13.782598F, 6.43F, 12.0F, 6.43F);
      ((Path)localObject2).cubicTo(10.219405F, 6.43F, 8.770175F, 7.881976F, 8.770175F, 9.670327F);
      ((Path)localObject2).lineTo(8.770175F, 11.354709F);
      ((Path)localObject2).cubicTo(8.770175F, 12.312657F, 9.297517F, 13.757827F, 9.914352F, 14.490951F);
      ((Path)localObject2).lineTo(10.269541F, 14.913103F);
      ((Path)localObject2).cubicTo(11.143951F, 15.952363F, 10.846876F, 17.358044F, 9.629946F, 17.953541F);
      ((Path)localObject2).lineTo(4.068897F, 20.67481F);
      ((Path)localObject2).cubicTo(3.901136F, 20.756903F, 3.739076F, 20.916063F, 3.612992F, 21.103752F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.drawPath((Path)localObject2, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_remove_bg
 * JD-Core Version:    0.7.0.1
 */