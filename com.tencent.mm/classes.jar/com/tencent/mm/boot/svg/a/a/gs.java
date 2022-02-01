package com.tencent.mm.boot.svg.a.a;

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

public final class gs
  extends c
{
  private final int height = 50;
  private final int width = 50;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 50;
      return 50;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, -367.0F, 0.0F, 1.0F, -369.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 367.0F, 0.0F, 1.0F, 369.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(45.0F, 43.282814F);
      ((Path)localObject3).lineTo(29.594316F, 27.877132F);
      ((Path)localObject3).cubicTo(28.999725F, 27.282539F, 28.054962F, 27.287527F, 27.469177F, 27.873312F);
      ((Path)localObject3).cubicTo(26.879307F, 28.463182F, 26.885099F, 29.410557F, 27.472996F, 29.998453F);
      ((Path)localObject3).lineTo(43.474545F, 46.0F);
      ((Path)localObject3).lineTo(29.50325F, 46.0F);
      ((Path)localObject3).cubicTo(28.665436F, 46.0F, 28.0F, 46.671574F, 28.0F, 47.5F);
      ((Path)localObject3).cubicTo(28.0F, 48.334202F, 28.673029F, 49.0F, 29.50325F, 49.0F);
      ((Path)localObject3).lineTo(46.49675F, 49.0F);
      ((Path)localObject3).cubicTo(46.497292F, 49.0F, 46.497833F, 49.0F, 46.498375F, 49.0F);
      ((Path)localObject3).cubicTo(46.498917F, 49.0F, 46.499458F, 49.0F, 46.5F, 49.0F);
      ((Path)localObject3).cubicTo(46.916557F, 49.0F, 47.291122F, 48.83218F, 47.561768F, 48.560772F);
      ((Path)localObject3).cubicTo(47.834072F, 48.288242F, 48.0F, 47.913677F, 48.0F, 47.5F);
      ((Path)localObject3).cubicTo(48.0F, 47.499458F, 48.0F, 47.498917F, 48.0F, 47.498375F);
      ((Path)localObject3).cubicTo(48.0F, 47.497833F, 48.0F, 47.497292F, 48.0F, 47.49675F);
      ((Path)localObject3).lineTo(48.0F, 30.50325F);
      ((Path)localObject3).cubicTo(48.0F, 29.665436F, 47.328426F, 29.0F, 46.5F, 29.0F);
      ((Path)localObject3).cubicTo(45.665798F, 29.0F, 45.0F, 29.673029F, 45.0F, 30.50325F);
      ((Path)localObject3).lineTo(45.0F, 43.282814F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(3.0F, 5.303134F);
      ((Path)localObject2).lineTo(18.595417F, 20.89855F);
      ((Path)localObject2).cubicTo(19.190008F, 21.493141F, 20.134769F, 21.488155F, 20.720556F, 20.902369F);
      ((Path)localObject2).cubicTo(21.310427F, 20.312498F, 21.304632F, 19.365126F, 20.716738F, 18.777229F);
      ((Path)localObject2).lineTo(4.939507F, 3.0F);
      ((Path)localObject2).lineTo(18.49675F, 3.0F);
      ((Path)localObject2).cubicTo(19.334564F, 3.0F, 20.0F, 2.328427F, 20.0F, 1.5F);
      ((Path)localObject2).cubicTo(20.0F, 0.6657972F, 19.326971F, 0.0F, 18.49675F, 0.0F);
      ((Path)localObject2).lineTo(1.503251F, 0.0F);
      ((Path)localObject2).cubicTo(1.502709F, 0.0F, 1.502167F, 2.809642E-007F, 1.501625F, 8.427533E-007F);
      ((Path)localObject2).cubicTo(1.501084F, 2.840145E-007F, 1.500542F, 0.0F, 1.5F, 0.0F);
      ((Path)localObject2).cubicTo(1.086322F, 0.0F, 0.7117559F, 0.1659292F, 0.4403929F, 0.4363941F);
      ((Path)localObject2).cubicTo(0.1659289F, 0.7117565F, 0.0F, 1.086322F, 0.0F, 1.5F);
      ((Path)localObject2).cubicTo(0.0F, 1.500542F, 2.840145E-007F, 1.501084F, 8.519021E-007F, 1.501626F);
      ((Path)localObject2).cubicTo(2.809642E-007F, 1.502167F, 0.0F, 1.502709F, 0.0F, 1.503251F);
      ((Path)localObject2).lineTo(0.0F, 18.49675F);
      ((Path)localObject2).cubicTo(0.0F, 19.326971F, 0.6657972F, 20.0F, 1.5F, 20.0F);
      ((Path)localObject2).cubicTo(2.328427F, 20.0F, 3.0F, 19.334564F, 3.0F, 18.49675F);
      ((Path)localObject2).lineTo(3.0F, 5.303134F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.gs
 * JD-Core Version:    0.7.0.1
 */