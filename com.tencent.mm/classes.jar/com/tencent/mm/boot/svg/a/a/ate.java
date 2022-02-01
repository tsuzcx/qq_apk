package com.tencent.mm.boot.svg.a.a;

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

public final class ate
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(16.764002F, 11.250007F);
      localPath.cubicTo(17.243593F, 10.420647F, 17.5F, 9.47784F, 17.5F, 8.5F);
      localPath.cubicTo(17.5F, 5.462434F, 15.037566F, 3.0F, 12.0F, 3.0F);
      localPath.cubicTo(8.962434F, 3.0F, 6.5F, 5.462434F, 6.5F, 8.5F);
      localPath.cubicTo(6.5F, 11.537566F, 8.962434F, 14.0F, 12.0F, 14.0F);
      localPath.lineTo(12.0F, 12.0F);
      localPath.cubicTo(10.067003F, 12.0F, 8.5F, 10.432997F, 8.5F, 8.5F);
      localPath.cubicTo(8.5F, 6.567003F, 10.067003F, 5.0F, 12.0F, 5.0F);
      localPath.cubicTo(13.932997F, 5.0F, 15.5F, 6.567003F, 15.5F, 8.5F);
      localPath.cubicTo(15.5F, 9.123929F, 15.337409F, 9.721776F, 15.032639F, 10.248816F);
      localPath.lineTo(16.764002F, 11.250007F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      arrayOfFloat = c.a(arrayOfFloat, -0.5F, 0.8660254F, -1.052558F, -0.8660254F, -0.5F, 29.892305F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(12.778858F, 18.146908F);
      localPath.cubicTo(13.314517F, 17.283787F, 13.602885F, 16.286898F, 13.602885F, 15.25F);
      localPath.cubicTo(13.602885F, 12.212434F, 11.140451F, 9.75F, 8.102885F, 9.75F);
      localPath.cubicTo(5.06532F, 9.75F, 2.602886F, 12.212434F, 2.602886F, 15.25F);
      localPath.cubicTo(2.602886F, 18.287565F, 5.06532F, 20.75F, 8.102885F, 20.75F);
      localPath.lineTo(8.102885F, 18.75F);
      localPath.cubicTo(6.169889F, 18.75F, 4.602886F, 17.182997F, 4.602886F, 15.25F);
      localPath.cubicTo(4.602886F, 13.317003F, 6.169889F, 11.75F, 8.102885F, 11.75F);
      localPath.cubicTo(10.035882F, 11.75F, 11.602885F, 13.317003F, 11.602885F, 15.25F);
      localPath.cubicTo(11.602885F, 15.911496F, 11.420044F, 16.543581F, 11.079515F, 17.092283F);
      localPath.lineTo(12.778858F, 18.146908F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      arrayOfFloat = c.a(arrayOfFloat, -0.5F, -0.8660254F, 37.052559F, 0.8660254F, -0.5F, 9.107696F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(20.71245F, 17.90926F);
      ((Path)localObject).cubicTo(21.159218F, 17.101671F, 21.397114F, 16.191933F, 21.397114F, 15.25F);
      ((Path)localObject).cubicTo(21.397114F, 12.212434F, 18.934681F, 9.75F, 15.897115F, 9.75F);
      ((Path)localObject).cubicTo(12.859549F, 9.75F, 10.397115F, 12.212434F, 10.397115F, 15.25F);
      ((Path)localObject).cubicTo(10.397115F, 18.287565F, 12.859549F, 20.75F, 15.897115F, 20.75F);
      ((Path)localObject).lineTo(15.897115F, 18.75F);
      ((Path)localObject).cubicTo(13.964118F, 18.75F, 12.397115F, 17.182997F, 12.397115F, 15.25F);
      ((Path)localObject).cubicTo(12.397115F, 13.317003F, 13.964118F, 11.75F, 15.897115F, 11.75F);
      ((Path)localObject).cubicTo(17.830111F, 11.75F, 19.397114F, 13.317003F, 19.397114F, 15.25F);
      ((Path)localObject).cubicTo(19.397114F, 15.851086F, 19.246248F, 16.428015F, 18.962397F, 16.941109F);
      ((Path)localObject).lineTo(20.71245F, 17.90926F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ate
 * JD-Core Version:    0.7.0.1
 */