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

public class mall_index_balance_icon_normal
  extends c
{
  private final int height = 93;
  private final int width = 93;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 93;
      return 93;
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
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 31.0F, 0.0F, 1.0F, 31.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.restore();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(78.991554F, 14.00827F);
      ((Path)localObject3).cubicTo(97.669479F, 31.740889F, 97.669479F, 61.25771F, 78.991554F, 78.991447F);
      ((Path)localObject3).cubicTo(61.258163F, 97.669518F, 31.741741F, 97.669518F, 14.008727F, 78.991447F);
      ((Path)localObject3).cubicTo(-4.669576F, 61.25771F, -4.669576F, 31.740889F, 14.008727F, 14.00827F);
      ((Path)localObject3).cubicTo(31.740246F, -4.669423F, 61.258163F, -4.669423F, 78.991554F, 14.00827F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(86.384529F, 48.423794F);
      ((Path)localObject3).cubicTo(86.384529F, 25.276369F, 68.759476F, 7.65122F, 48.424061F, 7.65122F);
      ((Path)localObject3).cubicTo(25.275711F, 7.65122F, 7.651712F, 25.276369F, 7.651712F, 48.423794F);
      ((Path)localObject3).cubicTo(7.651712F, 68.759315F, 25.276764F, 86.38446F, 45.612175F, 86.38446F);
      ((Path)localObject3).cubicTo(68.759476F, 86.38446F, 86.384529F, 68.759315F, 86.384529F, 48.423794F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(48.44434F, 43.142254F);
      ((Path)localObject2).lineTo(55.190773F, 29.0F);
      ((Path)localObject2).lineTo(61.51553F, 29.0F);
      ((Path)localObject2).lineTo(54.769096F, 43.142254F);
      ((Path)localObject2).lineTo(61.51553F, 43.142254F);
      ((Path)localObject2).lineTo(61.51553F, 48.44558F);
      ((Path)localObject2).lineTo(49.287769F, 48.44558F);
      ((Path)localObject2).lineTo(49.287769F, 53.306904F);
      ((Path)localObject2).lineTo(61.51553F, 53.306904F);
      ((Path)localObject2).lineTo(61.51553F, 58.610229F);
      ((Path)localObject2).lineTo(49.287769F, 58.610229F);
      ((Path)localObject2).lineTo(49.287769F, 66.565216F);
      ((Path)localObject2).lineTo(44.227966F, 66.565216F);
      ((Path)localObject2).lineTo(44.227966F, 58.610229F);
      ((Path)localObject2).lineTo(32.0F, 58.610229F);
      ((Path)localObject2).lineTo(32.0F, 53.306904F);
      ((Path)localObject2).lineTo(44.227966F, 53.306904F);
      ((Path)localObject2).lineTo(44.227966F, 48.44558F);
      ((Path)localObject2).lineTo(32.0F, 48.44558F);
      ((Path)localObject2).lineTo(32.0F, 43.142254F);
      ((Path)localObject2).lineTo(38.746433F, 43.142254F);
      ((Path)localObject2).lineTo(32.0F, 29.0F);
      ((Path)localObject2).lineTo(38.324757F, 29.0F);
      ((Path)localObject2).lineTo(45.07119F, 43.142254F);
      ((Path)localObject2).lineTo(48.44434F, 43.142254F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.mall_index_balance_icon_normal
 * JD-Core Version:    0.7.0.1
 */