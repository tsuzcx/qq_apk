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

public final class apz
  extends c
{
  private final int height = 46;
  private final int width = 46;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 46;
      return 46;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-12206054);
      localCanvas.save();
      Object localObject3 = c.a(localPaint2, paramVarArgs);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(21.719999F, 0.0F);
      localPath.lineTo(24.059999F, 0.0F);
      localPath.cubicTo(35.450001F, 0.38F, 45.34F, 10.09F, 46.0F, 21.459999F);
      localPath.lineTo(46.0F, 24.299999F);
      localPath.cubicTo(45.5F, 35.700001F, 35.650002F, 45.5F, 24.26F, 46.0F);
      localPath.lineTo(21.93F, 46.0F);
      localPath.cubicTo(10.47F, 45.630001F, 0.54F, 35.779999F, 0.0F, 24.34F);
      localPath.lineTo(0.0F, 21.82F);
      localPath.cubicTo(0.44F, 10.39F, 10.3F, 0.51F, 21.719999F, 0.0F);
      localPath.lineTo(21.719999F, 0.0F);
      localPath.close();
      localPath.moveTo(17.58F, 13.59F);
      localPath.cubicTo(15.96F, 15.34F, 16.17F, 17.82F, 15.82F, 20.0F);
      localPath.lineTo(12.99F, 20.0F);
      localPath.cubicTo(13.0F, 24.34F, 13.0F, 28.67F, 13.0F, 33.0F);
      localPath.lineTo(33.0F, 33.0F);
      localPath.cubicTo(33.0F, 28.67F, 33.0F, 24.34F, 33.009998F, 20.0F);
      localPath.lineTo(30.18F, 20.0F);
      localPath.cubicTo(29.83F, 17.83F, 30.07F, 15.34F, 28.43F, 13.6F);
      localPath.cubicTo(25.84F, 10.18F, 20.17F, 10.17F, 17.58F, 13.59F);
      localPath.lineTo(17.58F, 13.59F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(18.82F, 20.0F);
      ((Path)localObject3).cubicTo(18.799999F, 17.379999F, 19.709999F, 13.9F, 22.99F, 14.0F);
      ((Path)localObject3).cubicTo(26.26F, 13.87F, 27.219999F, 17.370001F, 27.18F, 20.0F);
      ((Path)localObject3).lineTo(18.82F, 20.0F);
      ((Path)localObject3).lineTo(18.82F, 20.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 11.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(5.58F, 2.59F);
      ((Path)localObject2).cubicTo(8.17F, -0.83F, 13.84F, -0.82F, 16.43F, 2.6F);
      ((Path)localObject2).cubicTo(18.07F, 4.34F, 17.83F, 6.83F, 18.18F, 9.0F);
      ((Path)localObject2).lineTo(21.01F, 9.0F);
      ((Path)localObject2).cubicTo(21.0F, 13.34F, 21.0F, 17.67F, 21.0F, 22.0F);
      ((Path)localObject2).lineTo(1.0F, 22.0F);
      ((Path)localObject2).cubicTo(1.0F, 17.67F, 1.0F, 13.34F, 0.99F, 9.0F);
      ((Path)localObject2).lineTo(3.82F, 9.0F);
      ((Path)localObject2).cubicTo(4.17F, 6.82F, 3.96F, 4.34F, 5.58F, 2.59F);
      ((Path)localObject2).lineTo(5.58F, 2.59F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(6.82F, 9.0F);
      ((Path)localObject2).lineTo(15.18F, 9.0F);
      ((Path)localObject2).cubicTo(15.22F, 6.37F, 14.26F, 2.87F, 10.99F, 3.0F);
      ((Path)localObject2).cubicTo(7.71F, 2.9F, 6.8F, 6.38F, 6.82F, 9.0F);
      ((Path)localObject2).lineTo(6.82F, 9.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.apz
 * JD-Core Version:    0.7.0.1
 */