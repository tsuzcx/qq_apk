package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class icon_vip_empty
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
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(28.666666F, 6.0F);
      localPath.cubicTo(29.403046F, 6.0F, 30.0F, 6.596954F, 30.0F, 7.333334F);
      localPath.lineTo(30.0F, 24.666666F);
      localPath.cubicTo(30.0F, 25.403046F, 29.403046F, 26.0F, 28.666666F, 26.0F);
      localPath.lineTo(3.333333F, 26.0F);
      localPath.cubicTo(2.596954F, 26.0F, 2.0F, 25.403046F, 2.0F, 24.666666F);
      localPath.lineTo(2.0F, 7.333334F);
      localPath.cubicTo(2.0F, 6.596954F, 2.596954F, 6.0F, 3.333333F, 6.0F);
      localPath.lineTo(28.666666F, 6.0F);
      localPath.close();
      localPath.moveTo(28.4F, 7.6F);
      localPath.lineTo(3.6F, 7.6F);
      localPath.lineTo(3.6F, 24.4F);
      localPath.lineTo(28.4F, 24.4F);
      localPath.lineTo(28.4F, 7.6F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(10.666667F, 20.666666F);
      ((Path)localObject).lineTo(14.053333F, 11.146667F);
      ((Path)localObject).lineTo(12.36F, 11.146667F);
      ((Path)localObject).lineTo(9.746667F, 18.906666F);
      ((Path)localObject).lineTo(9.706667F, 18.906666F);
      ((Path)localObject).lineTo(7.093333F, 11.146667F);
      ((Path)localObject).lineTo(5.4F, 11.146667F);
      ((Path)localObject).lineTo(8.786667F, 20.666666F);
      ((Path)localObject).lineTo(10.666667F, 20.666666F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.613333F, 20.666666F);
      ((Path)localObject).lineTo(16.613333F, 11.146667F);
      ((Path)localObject).lineTo(15.053333F, 11.146667F);
      ((Path)localObject).lineTo(15.053333F, 20.666666F);
      ((Path)localObject).lineTo(16.613333F, 20.666666F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.040001F, 20.666666F);
      ((Path)localObject).lineTo(20.040001F, 17.013332F);
      ((Path)localObject).lineTo(22.4F, 17.013332F);
      ((Path)localObject).cubicTo(24.719999F, 17.013332F, 25.879999F, 16.026667F, 25.879999F, 14.066667F);
      ((Path)localObject).cubicTo(25.879999F, 12.12F, 24.719999F, 11.146667F, 22.426666F, 11.146667F);
      ((Path)localObject).lineTo(18.48F, 11.146667F);
      ((Path)localObject).lineTo(18.48F, 20.666666F);
      ((Path)localObject).lineTo(20.040001F, 20.666666F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(22.306667F, 15.68F);
      ((Path)localObject).lineTo(20.040001F, 15.68F);
      ((Path)localObject).lineTo(20.040001F, 12.48F);
      ((Path)localObject).lineTo(22.306667F, 12.48F);
      ((Path)localObject).cubicTo(22.986668F, 12.48F, 23.493334F, 12.6F, 23.813334F, 12.853333F);
      ((Path)localObject).cubicTo(24.133333F, 13.093333F, 24.306667F, 13.493333F, 24.306667F, 14.066667F);
      ((Path)localObject).cubicTo(24.306667F, 14.64F, 24.146667F, 15.053333F, 23.826666F, 15.306666F);
      ((Path)localObject).cubicTo(23.506666F, 15.546667F, 23.0F, 15.68F, 22.306667F, 15.68F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_vip_empty
 * JD-Core Version:    0.7.0.1
 */