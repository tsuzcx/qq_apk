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

public class icons_outlined_imac_lock
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      localPaint1.setColor(-436207616);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(21.004602F, 11.0F);
      ((Path)localObject2).cubicTo(21.554346F, 11.0F, 22.0F, 11.446699F, 22.0F, 11.995942F);
      ((Path)localObject2).lineTo(22.0F, 17.504059F);
      ((Path)localObject2).cubicTo(22.0F, 18.054102F, 21.544336F, 18.5F, 21.004602F, 18.5F);
      ((Path)localObject2).lineTo(12.995398F, 18.5F);
      ((Path)localObject2).cubicTo(12.445655F, 18.5F, 12.0F, 18.053301F, 12.0F, 17.504059F);
      ((Path)localObject2).lineTo(12.0F, 17.5F);
      ((Path)localObject2).lineTo(6.696681F, 17.5F);
      ((Path)localObject2).cubicTo(6.642261F, 17.5F, 6.588206F, 17.491116F, 6.536648F, 17.473698F);
      ((Path)localObject2).cubicTo(6.275033F, 17.385315F, 6.1346F, 17.101583F, 6.222983F, 16.839968F);
      ((Path)localObject2).lineTo(6.844592F, 15.0F);
      ((Path)localObject2).lineTo(1.0F, 15.0F);
      ((Path)localObject2).cubicTo(0.4477153F, 15.0F, -2.220446E-016F, 14.552284F, -2.220446E-016F, 14.0F);
      ((Path)localObject2).lineTo(-2.220446E-016F, 1.0F);
      ((Path)localObject2).cubicTo(-2.220446E-016F, 0.4477153F, 0.4477153F, 0.0F, 1.0F, 0.0F);
      ((Path)localObject2).lineTo(19.0F, 0.0F);
      ((Path)localObject2).cubicTo(19.552284F, 0.0F, 20.0F, 0.4477153F, 20.0F, 1.0F);
      ((Path)localObject2).lineTo(20.0F, 11.0F);
      ((Path)localObject2).lineTo(21.004602F, 11.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(20.799999F, 12.2F);
      ((Path)localObject2).lineTo(20.0F, 12.199F);
      ((Path)localObject2).lineTo(20.0F, 12.2F);
      ((Path)localObject2).lineTo(13.199F, 12.2F);
      ((Path)localObject2).lineTo(13.2F, 17.299999F);
      ((Path)localObject2).lineTo(20.799999F, 17.299999F);
      ((Path)localObject2).lineTo(20.799999F, 12.2F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.0F, 14.999F);
      ((Path)localObject2).lineTo(8.111226F, 14.999988F);
      ((Path)localObject2).lineTo(7.672034F, 16.299999F);
      ((Path)localObject2).lineTo(12.0F, 16.299999F);
      ((Path)localObject2).lineTo(12.0F, 14.999F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.0F, 12.2F);
      ((Path)localObject2).lineTo(1.199F, 12.2F);
      ((Path)localObject2).lineTo(1.2F, 13.8F);
      ((Path)localObject2).lineTo(12.0F, 13.799F);
      ((Path)localObject2).lineTo(12.0F, 12.2F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(18.799999F, 1.2F);
      ((Path)localObject2).lineTo(1.2F, 1.2F);
      ((Path)localObject2).lineTo(1.199F, 11.0F);
      ((Path)localObject2).lineTo(14.0F, 11.0F);
      ((Path)localObject2).lineTo(14.0F, 10.7F);
      ((Path)localObject2).cubicTo(14.0F, 8.932689F, 15.343145F, 7.5F, 17.0F, 7.5F);
      ((Path)localObject2).cubicTo(17.675409F, 7.5F, 18.298687F, 7.738076F, 18.8001F, 8.139846F);
      ((Path)localObject2).lineTo(18.799999F, 1.2F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(17.0F, 8.7F);
      ((Path)localObject2).cubicTo(16.023817F, 8.7F, 15.2F, 9.578738F, 15.2F, 10.7F);
      ((Path)localObject2).lineTo(15.2F, 11.0F);
      ((Path)localObject2).lineTo(18.799999F, 11.0F);
      ((Path)localObject2).lineTo(18.799999F, 10.7F);
      ((Path)localObject2).cubicTo(18.799999F, 9.578738F, 17.976183F, 8.7F, 17.0F, 8.7F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_imac_lock
 * JD-Core Version:    0.7.0.1
 */