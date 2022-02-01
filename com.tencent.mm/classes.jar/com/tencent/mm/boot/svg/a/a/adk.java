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

public final class adk
  extends c
{
  private final int height = 16;
  private final int width = 20;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 20;
      return 16;
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
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, -320.0F, 0.0F, 1.0F, -110.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 108.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 320.0F, 0.0F, 1.0F, 2.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(20.0F, 16.0F);
      ((Path)localObject3).lineTo(0.0F, 16.0F);
      ((Path)localObject3).lineTo(0.0F, 9.25F);
      ((Path)localObject3).lineTo(0.0F, 9.25F);
      ((Path)localObject3).cubicTo(-1.690884E-017F, 9.111929F, 0.1119288F, 9.0F, 0.25F, 9.0F);
      ((Path)localObject3).lineTo(1.75F, 9.0F);
      ((Path)localObject3).lineTo(1.75F, 9.0F);
      ((Path)localObject3).cubicTo(1.888071F, 9.0F, 2.0F, 9.111929F, 2.0F, 9.25F);
      ((Path)localObject3).lineTo(2.0F, 14.0F);
      ((Path)localObject3).lineTo(18.0F, 14.0F);
      ((Path)localObject3).lineTo(18.0F, 9.25F);
      ((Path)localObject3).lineTo(18.0F, 9.25F);
      ((Path)localObject3).cubicTo(18.0F, 9.111929F, 18.111929F, 9.0F, 18.25F, 9.0F);
      ((Path)localObject3).lineTo(19.75F, 9.0F);
      ((Path)localObject3).lineTo(19.75F, 9.0F);
      ((Path)localObject3).cubicTo(19.888071F, 9.0F, 20.0F, 9.111929F, 20.0F, 9.25F);
      ((Path)localObject3).lineTo(20.0F, 16.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(14.0F, 0.0F);
      ((Path)localObject2).lineTo(19.0F, 4.0F);
      ((Path)localObject2).lineTo(14.0F, 8.0F);
      ((Path)localObject2).lineTo(14.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(5.0F, 11.0F);
      ((Path)localObject2).cubicTo(4.995516F, 7.91632F, 7.619254F, 2.002248F, 14.0F, 2.0F);
      ((Path)localObject2).cubicTo(13.975887F, 2.0F, 13.975887F, 3.333333F, 14.0F, 6.0F);
      ((Path)localObject2).cubicTo(10.277842F, 6.054565F, 7.277841F, 7.721232F, 5.0F, 11.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.adk
 * JD-Core Version:    0.7.0.1
 */