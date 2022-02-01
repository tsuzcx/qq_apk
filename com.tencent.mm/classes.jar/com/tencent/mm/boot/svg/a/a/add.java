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

public final class add
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-11048043);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 4.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(12.309931F, 11.561403F);
      ((Path)localObject2).lineTo(16.424265F, 15.675735F);
      ((Path)localObject2).lineTo(15.575736F, 16.524263F);
      ((Path)localObject2).lineTo(11.452851F, 12.401379F);
      ((Path)localObject2).cubicTo(10.24281F, 13.400067F, 8.691467F, 14.0F, 7.0F, 14.0F);
      ((Path)localObject2).cubicTo(3.134F, 14.0F, 0.0F, 10.866F, 0.0F, 7.0F);
      ((Path)localObject2).cubicTo(0.0F, 3.134F, 3.134F, 0.0F, 7.0F, 0.0F);
      ((Path)localObject2).cubicTo(10.866F, 0.0F, 14.0F, 3.134F, 14.0F, 7.0F);
      ((Path)localObject2).cubicTo(14.0F, 8.742484F, 13.363332F, 10.336264F, 12.309931F, 11.561403F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.799997F, 7.000012F);
      ((Path)localObject2).cubicTo(12.799997F, 3.796755F, 10.203255F, 1.200012F, 6.999997F, 1.200012F);
      ((Path)localObject2).cubicTo(3.79674F, 1.200012F, 1.199997F, 3.796755F, 1.199997F, 7.000012F);
      ((Path)localObject2).cubicTo(1.199997F, 10.20327F, 3.79674F, 12.800013F, 6.999997F, 12.800013F);
      ((Path)localObject2).cubicTo(10.203255F, 12.800013F, 12.799997F, 10.20327F, 12.799997F, 7.000012F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.add
 * JD-Core Version:    0.7.0.1
 */