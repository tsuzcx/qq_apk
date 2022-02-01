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

public class connect_android_pad
  extends c
{
  private final int height = 308;
  private final int width = 408;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 408;
      return 308;
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
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(375.0F, 28.0F);
      localPath.cubicTo(381.62741F, 28.0F, 387.0F, 33.372581F, 387.0F, 40.0F);
      localPath.lineTo(387.0F, 268.0F);
      localPath.cubicTo(387.0F, 274.62741F, 381.62741F, 280.0F, 375.0F, 280.0F);
      localPath.lineTo(33.0F, 280.0F);
      localPath.cubicTo(26.372583F, 280.0F, 21.0F, 274.62741F, 21.0F, 268.0F);
      localPath.lineTo(21.0F, 40.0F);
      localPath.cubicTo(21.0F, 33.372581F, 26.372583F, 28.0F, 33.0F, 28.0F);
      localPath.lineTo(375.0F, 28.0F);
      localPath.close();
      localPath.moveTo(375.0F, 31.0F);
      localPath.lineTo(33.0F, 31.0F);
      localPath.cubicTo(28.206957F, 31.0F, 24.289017F, 34.746761F, 24.015278F, 39.47118F);
      localPath.lineTo(24.0F, 40.0F);
      localPath.lineTo(24.0F, 268.0F);
      localPath.cubicTo(24.0F, 272.79303F, 27.746759F, 276.71097F, 32.47118F, 276.98471F);
      localPath.lineTo(33.0F, 277.0F);
      localPath.lineTo(375.0F, 277.0F);
      localPath.cubicTo(379.79303F, 277.0F, 383.71097F, 273.25323F, 383.98471F, 268.52881F);
      localPath.lineTo(384.0F, 268.0F);
      localPath.lineTo(384.0F, 40.0F);
      localPath.cubicTo(384.0F, 35.206959F, 380.25323F, 31.289017F, 375.52881F, 31.015278F);
      localPath.lineTo(375.0F, 31.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(204.0F, 37.0F);
      ((Path)localObject).cubicTo(205.65686F, 37.0F, 207.0F, 38.343147F, 207.0F, 40.0F);
      ((Path)localObject).cubicTo(207.0F, 41.656853F, 205.65686F, 43.0F, 204.0F, 43.0F);
      ((Path)localObject).cubicTo(202.34314F, 43.0F, 201.0F, 41.656853F, 201.0F, 40.0F);
      ((Path)localObject).cubicTo(201.0F, 38.343147F, 202.34314F, 37.0F, 204.0F, 37.0F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.connect_android_pad
 * JD-Core Version:    0.7.0.1
 */