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

public class connect_android_pad
  extends c
{
  private final int height = 104;
  private final int width = 104;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 104;
      return 104;
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
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 16.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(100.59016F, 0.0F);
      ((Path)localObject3).cubicTo(102.47337F, 0.0F, 104.0F, 1.526636F, 104.0F, 3.409836F);
      ((Path)localObject3).lineTo(104.0F, 68.196724F);
      ((Path)localObject3).cubicTo(104.0F, 70.079926F, 102.47337F, 71.60656F, 100.59016F, 71.60656F);
      ((Path)localObject3).lineTo(3.409836F, 71.60656F);
      ((Path)localObject3).cubicTo(1.526636F, 71.60656F, 0.0F, 70.079926F, 0.0F, 68.196724F);
      ((Path)localObject3).lineTo(0.0F, 3.409836F);
      ((Path)localObject3).cubicTo(0.0F, 1.526636F, 1.526636F, 0.0F, 3.409836F, 0.0F);
      ((Path)localObject3).lineTo(100.59016F, 0.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(100.59016F, 0.852459F);
      ((Path)localObject3).lineTo(3.409836F, 0.852459F);
      ((Path)localObject3).cubicTo(2.047879F, 0.852459F, 0.934584F, 1.917112F, 0.8568003F, 3.259571F);
      ((Path)localObject3).lineTo(0.852459F, 3.409836F);
      ((Path)localObject3).lineTo(0.852459F, 68.196724F);
      ((Path)localObject3).cubicTo(0.852459F, 69.558678F, 1.917112F, 70.671974F, 3.259571F, 70.749756F);
      ((Path)localObject3).lineTo(3.409836F, 70.754097F);
      ((Path)localObject3).lineTo(100.59016F, 70.754097F);
      ((Path)localObject3).cubicTo(101.95213F, 70.754097F, 103.06541F, 69.689445F, 103.1432F, 68.346985F);
      ((Path)localObject3).lineTo(103.14754F, 68.196724F);
      ((Path)localObject3).lineTo(103.14754F, 3.409836F);
      ((Path)localObject3).cubicTo(103.14754F, 2.047879F, 102.08289F, 0.934584F, 100.74043F, 0.8568003F);
      ((Path)localObject3).lineTo(100.59016F, 0.852459F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(52.0F, 2.409836F);
      ((Path)localObject2).cubicTo(52.552284F, 2.409836F, 53.0F, 2.857551F, 53.0F, 3.409836F);
      ((Path)localObject2).cubicTo(53.0F, 3.962121F, 52.552284F, 4.409836F, 52.0F, 4.409836F);
      ((Path)localObject2).cubicTo(51.447716F, 4.409836F, 51.0F, 3.962121F, 51.0F, 3.409836F);
      ((Path)localObject2).cubicTo(51.0F, 2.857551F, 51.447716F, 2.409836F, 52.0F, 2.409836F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.connect_android_pad
 * JD-Core Version:    0.7.0.1
 */