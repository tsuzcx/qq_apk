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

public class default_contactlabel
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-14187817);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 12.0F);
      localPath.cubicTo(0.0F, 5.372582F, 5.372582F, 0.0F, 12.0F, 0.0F);
      localPath.lineTo(108.0F, 0.0F);
      localPath.cubicTo(114.62742F, 0.0F, 120.0F, 5.372582F, 120.0F, 12.0F);
      localPath.lineTo(120.0F, 108.0F);
      localPath.cubicTo(120.0F, 114.62742F, 114.62742F, 120.0F, 108.0F, 120.0F);
      localPath.lineTo(12.0F, 120.0F);
      localPath.cubicTo(5.372582F, 120.0F, 0.0F, 114.62742F, 0.0F, 108.0F);
      localPath.lineTo(0.0F, 12.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 24.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 7.5F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(2.12132F, 33.621319F);
      ((Path)localObject2).cubicTo(0.9497474F, 32.449749F, 0.9497474F, 30.550253F, 2.12132F, 29.378679F);
      ((Path)localObject2).lineTo(30.621321F, 0.8786796F);
      ((Path)localObject2).cubicTo(31.183929F, 0.3160705F, 31.946991F, 3.042532E-014F, 32.742641F, 2.88658E-014F);
      ((Path)localObject2).lineTo(52.5F, -1.776357E-015F);
      ((Path)localObject2).cubicTo(54.156853F, -2.080716E-015F, 55.5F, 1.343146F, 55.5F, 3.0F);
      ((Path)localObject2).lineTo(55.5F, 22.757359F);
      ((Path)localObject2).cubicTo(55.5F, 23.553009F, 55.183929F, 24.316071F, 54.621319F, 24.878679F);
      ((Path)localObject2).lineTo(26.121321F, 53.378681F);
      ((Path)localObject2).cubicTo(24.949747F, 54.550251F, 23.050253F, 54.550251F, 21.878679F, 53.378681F);
      ((Path)localObject2).lineTo(2.12132F, 33.621319F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(40.5F, 19.5F);
      ((Path)localObject2).cubicTo(42.985283F, 19.5F, 45.0F, 17.485281F, 45.0F, 15.0F);
      ((Path)localObject2).cubicTo(45.0F, 12.514719F, 42.985283F, 10.5F, 40.5F, 10.5F);
      ((Path)localObject2).cubicTo(38.014717F, 10.5F, 36.0F, 12.514719F, 36.0F, 15.0F);
      ((Path)localObject2).cubicTo(36.0F, 17.485281F, 38.014717F, 19.5F, 40.5F, 19.5F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.default_contactlabel
 * JD-Core Version:    0.7.0.1
 */