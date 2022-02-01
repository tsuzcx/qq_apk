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

public class ime_fault_replacement
  extends c
{
  private final int height = 3;
  private final int width = 4;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 4;
      return 3;
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
      localPaint1.setColor(-372399);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -36.0F, 0.0F, 1.0F, -953.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(36.002911F, 956.01483F);
      ((Path)localObject2).cubicTo(37.027832F, 956.01483F, 37.132671F, 954.89673F, 37.94693F, 954.89673F);
      ((Path)localObject2).cubicTo(38.762009F, 954.89673F, 38.764191F, 956.01483F, 39.998959F, 956.01483F);
      ((Path)localObject2).cubicTo(40.0F, 955.21429F, 40.0F, 954.89673F, 40.0F, 954.15802F);
      ((Path)localObject2).cubicTo(39.262695F, 954.15802F, 39.157394F, 953.0F, 37.999603F, 953.0F);
      ((Path)localObject2).cubicTo(36.840992F, 953.0F, 36.606049F, 954.15802F, 36.0F, 954.15802F);
      ((Path)localObject2).cubicTo(36.0F, 954.89673F, 36.0F, 955.47693F, 36.002911F, 956.01483F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_fault_replacement
 * JD-Core Version:    0.7.0.1
 */