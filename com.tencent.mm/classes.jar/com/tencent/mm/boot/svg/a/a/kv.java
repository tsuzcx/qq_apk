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

public final class kv
  extends c
{
  private final int height = 44;
  private final int width = 44;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 44;
      return 44;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setColor(-16339370);
      localPaint2.setStrokeWidth(1.2F);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(22.594595F, 43.400002F);
      localPath.cubicTo(33.818893F, 43.400002F, 43.400002F, 33.818893F, 43.400002F, 22.594595F);
      localPath.cubicTo(43.400002F, 10.363577F, 33.994289F, 0.6F, 22.594595F, 0.6F);
      localPath.cubicTo(10.181107F, 0.6F, 0.6F, 10.181107F, 0.6F, 22.594595F);
      localPath.cubicTo(0.6F, 33.994289F, 10.363577F, 43.400002F, 22.594595F, 43.400002F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 15.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-16268960);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(5.18545F, 12.556349F);
      ((Path)localObject2).cubicTo(6.553268F, 11.188531F, 7.333334F, 9.34425F, 7.333334F, 7.3709F);
      ((Path)localObject2).cubicTo(7.333334F, 5.39755F, 6.553268F, 3.553268F, 5.18545F, 2.18545F);
      ((Path)localObject2).lineTo(6.741085F, 0.629815F);
      ((Path)localObject2).cubicTo(8.466279F, 2.355009F, 9.533334F, 4.738342F, 9.533334F, 7.3709F);
      ((Path)localObject2).cubicTo(9.533334F, 10.003457F, 8.466279F, 12.38679F, 6.741085F, 14.111984F);
      ((Path)localObject2).lineTo(5.18545F, 12.556349F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.11127F, 10.482169F);
      ((Path)localObject2).lineTo(-4.547474E-013F, 7.3709F);
      ((Path)localObject2).lineTo(3.11127F, 4.25963F);
      ((Path)localObject2).cubicTo(3.907513F, 5.055873F, 4.4F, 6.155873F, 4.4F, 7.3709F);
      ((Path)localObject2).cubicTo(4.4F, 8.585926F, 3.907513F, 9.685926F, 3.11127F, 10.482169F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(419430400);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(5.18545F, 12.556349F);
      ((Path)localObject1).cubicTo(6.553268F, 11.188531F, 7.333334F, 9.34425F, 7.333334F, 7.3709F);
      ((Path)localObject1).cubicTo(7.333334F, 5.39755F, 6.553268F, 3.553268F, 5.18545F, 2.18545F);
      ((Path)localObject1).lineTo(6.741085F, 0.629815F);
      ((Path)localObject1).cubicTo(8.466279F, 2.355009F, 9.533334F, 4.738342F, 9.533334F, 7.3709F);
      ((Path)localObject1).cubicTo(9.533334F, 10.003457F, 8.466279F, 12.38679F, 6.741085F, 14.111984F);
      ((Path)localObject1).lineTo(5.18545F, 12.556349F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(3.11127F, 10.482169F);
      ((Path)localObject1).lineTo(-4.547474E-013F, 7.3709F);
      ((Path)localObject1).lineTo(3.11127F, 4.25963F);
      ((Path)localObject1).cubicTo(3.907513F, 5.055873F, 4.4F, 6.155873F, 4.4F, 7.3709F);
      ((Path)localObject1).cubicTo(4.4F, 8.585926F, 3.907513F, 9.685926F, 3.11127F, 10.482169F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.kv
 * JD-Core Version:    0.7.0.1
 */