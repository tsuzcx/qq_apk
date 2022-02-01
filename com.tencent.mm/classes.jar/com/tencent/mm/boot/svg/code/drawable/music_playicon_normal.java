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

public class music_playicon_normal
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      ((Paint)localObject).setColor(419430400);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(36.0F, 1.5F);
      localPath.cubicTo(55.053825F, 1.5F, 70.5F, 16.946175F, 70.5F, 36.0F);
      localPath.cubicTo(70.5F, 55.053825F, 55.053825F, 70.5F, 36.0F, 70.5F);
      localPath.cubicTo(16.946175F, 70.5F, 1.5F, 55.053825F, 1.5F, 36.0F);
      localPath.cubicTo(1.5F, 16.946175F, 16.946175F, 1.5F, 36.0F, 1.5F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 72.0F);
      ((Path)localObject).cubicTo(55.882252F, 72.0F, 72.0F, 55.882252F, 72.0F, 36.0F);
      ((Path)localObject).cubicTo(72.0F, 16.117748F, 55.882252F, 0.0F, 36.0F, 0.0F);
      ((Path)localObject).cubicTo(16.117748F, 0.0F, 0.0F, 16.117748F, 0.0F, 36.0F);
      ((Path)localObject).cubicTo(0.0F, 55.882252F, 16.117748F, 72.0F, 36.0F, 72.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 67.5F);
      ((Path)localObject).cubicTo(53.396969F, 67.5F, 67.5F, 53.396969F, 67.5F, 36.0F);
      ((Path)localObject).cubicTo(67.5F, 18.603031F, 53.396969F, 4.5F, 36.0F, 4.5F);
      ((Path)localObject).cubicTo(18.603031F, 4.5F, 4.5F, 18.603031F, 4.5F, 36.0F);
      ((Path)localObject).cubicTo(4.5F, 53.396969F, 18.603031F, 67.5F, 36.0F, 67.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(27.0F, 48.223015F);
      ((Path)localObject).cubicTo(27.0F, 49.878769F, 28.177517F, 50.57029F, 29.625708F, 49.769974F);
      ((Path)localObject).lineTo(51.37429F, 37.751019F);
      ((Path)localObject).cubicTo(52.824429F, 36.949627F, 52.822483F, 35.649239F, 51.37429F, 34.848923F);
      ((Path)localObject).lineTo(29.625708F, 22.829967F);
      ((Path)localObject).cubicTo(28.17557F, 22.028574F, 27.0F, 22.719145F, 27.0F, 24.376926F);
      ((Path)localObject).lineTo(27.0F, 48.223015F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.music_playicon_normal
 * JD-Core Version:    0.7.0.1
 */