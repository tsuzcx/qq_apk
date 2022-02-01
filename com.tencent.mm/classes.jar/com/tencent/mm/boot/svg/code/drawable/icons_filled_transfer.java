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

public class icons_filled_transfer
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(27.400084F, 25.5F);
      ((Path)localObject).lineTo(61.5F, 25.5F);
      ((Path)localObject).lineTo(61.5F, 31.5F);
      ((Path)localObject).lineTo(10.98074F, 31.5F);
      ((Path)localObject).cubicTo(10.152312F, 31.5F, 9.48074F, 30.828426F, 9.48074F, 30.0F);
      ((Path)localObject).cubicTo(9.48074F, 29.529905F, 9.701123F, 29.086998F, 10.076107F, 28.80349F);
      ((Path)localObject).lineTo(28.434875F, 14.923178F);
      ((Path)localObject).cubicTo(28.963528F, 14.523485F, 29.716099F, 14.628028F, 30.115791F, 15.15668F);
      ((Path)localObject).cubicTo(30.349678F, 15.466031F, 30.419645F, 15.869344F, 30.303619F, 16.239397F);
      ((Path)localObject).lineTo(27.400084F, 25.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(44.596638F, 46.5F);
      ((Path)localObject).lineTo(10.5F, 46.5F);
      ((Path)localObject).lineTo(10.5F, 40.5F);
      ((Path)localObject).lineTo(56.996723F, 40.5F);
      ((Path)localObject).lineTo(61.015984F, 40.5F);
      ((Path)localObject).cubicTo(61.84441F, 40.5F, 62.515984F, 41.171574F, 62.515984F, 42.0F);
      ((Path)localObject).cubicTo(62.515984F, 42.470097F, 62.295597F, 42.913002F, 61.920616F, 43.19651F);
      ((Path)localObject).lineTo(43.561848F, 57.076824F);
      ((Path)localObject).cubicTo(43.033195F, 57.476513F, 42.280624F, 57.371971F, 41.880932F, 56.843319F);
      ((Path)localObject).cubicTo(41.647045F, 56.53397F, 41.577076F, 56.130657F, 41.693104F, 55.760601F);
      ((Path)localObject).lineTo(44.596638F, 46.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_transfer
 * JD-Core Version:    0.7.0.1
 */