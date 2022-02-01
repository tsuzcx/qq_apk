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

public class icons_filled_pay_transfer
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 14.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(52.015984F, 26.5F);
      ((Path)localObject2).cubicTo(52.84441F, 26.5F, 53.515984F, 27.171574F, 53.515984F, 28.0F);
      ((Path)localObject2).cubicTo(53.515984F, 28.470095F, 53.295597F, 28.913002F, 52.920616F, 29.19651F);
      ((Path)localObject2).lineTo(34.561848F, 43.076824F);
      ((Path)localObject2).cubicTo(34.033195F, 43.476513F, 33.280624F, 43.371971F, 32.880932F, 42.843319F);
      ((Path)localObject2).cubicTo(32.647045F, 42.53397F, 32.577076F, 42.130657F, 32.693104F, 41.760601F);
      ((Path)localObject2).lineTo(35.596638F, 32.5F);
      ((Path)localObject2).lineTo(1.5F, 32.5F);
      ((Path)localObject2).lineTo(1.5F, 26.5F);
      ((Path)localObject2).lineTo(52.015984F, 26.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(21.115791F, 1.15668F);
      ((Path)localObject2).cubicTo(21.349678F, 1.466031F, 21.419645F, 1.869344F, 21.303619F, 2.239398F);
      ((Path)localObject2).lineTo(18.400084F, 11.5F);
      ((Path)localObject2).lineTo(52.5F, 11.5F);
      ((Path)localObject2).lineTo(52.5F, 17.5F);
      ((Path)localObject2).lineTo(1.98074F, 17.5F);
      ((Path)localObject2).cubicTo(1.152313F, 17.5F, 0.4807397F, 16.828426F, 0.4807397F, 16.0F);
      ((Path)localObject2).cubicTo(0.4807397F, 15.529904F, 0.7011237F, 15.086998F, 1.076107F, 14.803489F);
      ((Path)localObject2).lineTo(19.434875F, 0.9231775F);
      ((Path)localObject2).cubicTo(19.963528F, 0.5234855F, 20.716099F, 0.6280282F, 21.115791F, 1.15668F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_pay_transfer
 * JD-Core Version:    0.7.0.1
 */