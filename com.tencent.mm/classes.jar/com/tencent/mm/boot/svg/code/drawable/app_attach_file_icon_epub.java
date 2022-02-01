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

public class app_attach_file_icon_epub
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-9061376);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(60.882355F, 0.0F);
      ((Path)localObject2).lineTo(90.0F, 29.333334F);
      ((Path)localObject2).lineTo(90.0F, 116.0F);
      ((Path)localObject2).cubicTo(90.0F, 118.20914F, 88.222305F, 120.0F, 86.029411F, 120.0F);
      ((Path)localObject2).lineTo(3.970588F, 120.0F);
      ((Path)localObject2).cubicTo(1.777693F, 120.0F, 0.0F, 118.20914F, 0.0F, 116.0F);
      ((Path)localObject2).lineTo(0.0F, 4.0F);
      ((Path)localObject2).cubicTo(0.0F, 1.790861F, 1.777693F, 0.0F, 3.970588F, 0.0F);
      ((Path)localObject2).lineTo(60.882355F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-10643968);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(90.0F, 29.333334F);
      ((Path)localObject2).lineTo(64.852943F, 29.333334F);
      ((Path)localObject2).cubicTo(62.660046F, 29.333334F, 60.882355F, 27.542473F, 60.882355F, 25.333334F);
      ((Path)localObject2).lineTo(60.882355F, 0.0F);
      ((Path)localObject2).lineTo(90.0F, 29.333334F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(58.856758F, 65.041008F);
      ((Path)localObject1).lineTo(48.816174F, 54.926056F);
      ((Path)localObject1).cubicTo(46.707176F, 52.80143F, 43.281239F, 52.801842F, 41.167931F, 54.930801F);
      ((Path)localObject1).lineTo(25.410347F, 70.805107F);
      ((Path)localObject1).cubicTo(23.295818F, 72.935303F, 23.294933F, 76.383667F, 25.405638F, 78.510002F);
      ((Path)localObject1).lineTo(41.183826F, 94.405067F);
      ((Path)localObject1).cubicTo(43.292824F, 96.529694F, 46.718761F, 96.529282F, 48.832069F, 94.400322F);
      ((Path)localObject1).lineTo(64.589653F, 78.526016F);
      ((Path)localObject1).cubicTo(66.704178F, 76.395821F, 66.705063F, 72.947456F, 64.59436F, 70.821121F);
      ((Path)localObject1).lineTo(64.114693F, 70.337898F);
      ((Path)localObject1).lineTo(45.004562F, 89.589584F);
      ((Path)localObject1).lineTo(42.375595F, 86.941139F);
      ((Path)localObject1).lineTo(32.815708F, 77.31044F);
      ((Path)localObject1).lineTo(30.186741F, 74.661995F);
      ((Path)localObject1).lineTo(44.99749F, 59.741539F);
      ((Path)localObject1).lineTo(50.255428F, 65.038422F);
      ((Path)localObject1).lineTo(40.700104F, 74.664528F);
      ((Path)localObject1).lineTo(45.002052F, 78.998344F);
      ((Path)localObject1).lineTo(58.856758F, 65.041008F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_epub
 * JD-Core Version:    0.7.0.1
 */