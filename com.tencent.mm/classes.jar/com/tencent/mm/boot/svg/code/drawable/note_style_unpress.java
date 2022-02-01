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

public class note_style_unpress
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
      Object localObject2 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(3.6F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(21.0F, 11.55F);
      ((Path)localObject3).lineTo(63.0F, 11.55F);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(3.6F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(21.0F, 31.799999F);
      ((Path)localObject3).lineTo(63.0F, 31.799999F);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(3.6F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(21.0F, 52.049999F);
      ((Path)localObject2).lineTo(63.0F, 52.049999F);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(5.090625F, 18.0F);
      ((Path)localObject2).lineTo(5.090625F, 7.06875F);
      ((Path)localObject2).lineTo(5.034375F, 7.06875F);
      ((Path)localObject2).lineTo(1.584375F, 9.45F);
      ((Path)localObject2).lineTo(1.584375F, 6.9F);
      ((Path)localObject2).lineTo(5.08125F, 4.471875F);
      ((Path)localObject2).lineTo(7.89375F, 4.471875F);
      ((Path)localObject2).lineTo(7.89375F, 18.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(6.375F, 27.75F);
      ((Path)localObject2).cubicTo(8.238961F, 27.75F, 9.75F, 29.26104F, 9.75F, 31.125F);
      ((Path)localObject2).cubicTo(9.75F, 32.98896F, 8.238961F, 34.5F, 6.375F, 34.5F);
      ((Path)localObject2).cubicTo(4.511039F, 34.5F, 3.0F, 32.98896F, 3.0F, 31.125F);
      ((Path)localObject2).cubicTo(3.0F, 29.26104F, 4.511039F, 27.75F, 6.375F, 27.75F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(3.0F, 48.0F);
      ((Path)localObject1).lineTo(9.75F, 48.0F);
      ((Path)localObject1).lineTo(9.75F, 54.75F);
      ((Path)localObject1).lineTo(3.0F, 54.75F);
      ((Path)localObject1).lineTo(3.0F, 48.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.note_style_unpress
 * JD-Core Version:    0.7.0.1
 */