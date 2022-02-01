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

public final class bbk
  extends c
{
  private final int height = 93;
  private final int width = 93;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 13.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(3.799622F, 0.0F);
      ((Path)localObject3).cubicTo(2.172793F, 0.0F, 0.0F, 2.291559F, 0.0F, 5.020509F);
      ((Path)localObject3).lineTo(0.0F, 61.501232F);
      ((Path)localObject3).cubicTo(0.0F, 64.230179F, 2.172793F, 66.521736F, 3.799622F, 66.521736F);
      ((Path)localObject3).lineTo(83.591682F, 66.521736F);
      ((Path)localObject3).cubicTo(85.217415F, 66.521736F, 87.391304F, 64.230179F, 87.391304F, 61.501232F);
      ((Path)localObject3).lineTo(87.391304F, 5.020509F);
      ((Path)localObject3).cubicTo(87.391304F, 2.291559F, 85.217415F, 0.0F, 83.591682F, 0.0F);
      ((Path)localObject3).lineTo(3.799622F, 0.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(10.302137F, 6.521739F);
      ((Path)localObject3).cubicTo(8.370235F, 6.521739F, 6.521739F, 8.363973F, 6.521739F, 10.252781F);
      ((Path)localObject3).lineTo(6.521739F, 56.268959F);
      ((Path)localObject3).cubicTo(6.521739F, 58.157764F, 8.370235F, 60.0F, 10.302137F, 60.0F);
      ((Path)localObject3).lineTo(77.089165F, 60.0F);
      ((Path)localObject3).cubicTo(79.020142F, 60.0F, 80.869568F, 58.157764F, 80.869568F, 56.268959F);
      ((Path)localObject3).lineTo(80.869568F, 10.252781F);
      ((Path)localObject3).cubicTo(80.869568F, 8.363973F, 79.020142F, 6.521739F, 77.089165F, 6.521739F);
      ((Path)localObject3).lineTo(10.302137F, 6.521739F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(13.0F, 18.0F);
      ((Path)localObject2).lineTo(74.304352F, 18.0F);
      ((Path)localObject2).lineTo(74.304352F, 25.826088F);
      ((Path)localObject2).lineTo(13.0F, 25.826088F);
      ((Path)localObject2).lineTo(13.0F, 18.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bbk
 * JD-Core Version:    0.7.0.1
 */