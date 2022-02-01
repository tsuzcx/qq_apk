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

public final class ada
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-855310);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(48.0F, 0.0F);
      localPath.lineTo(48.0F, 48.0F);
      localPath.lineTo(0.0F, 48.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localObject2 = c.a((float[])localObject2, 0.7071068F, -0.7071068F, 29.803303F, 0.7071068F, 0.7071068F, 13.332738F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 16.5F);
      ((Path)localObject2).lineTo(1.777778F, 16.5F);
      ((Path)localObject2).lineTo(1.777778F, 19.5F);
      ((Path)localObject2).cubicTo(1.777778F, 21.003441F, 2.996558F, 22.222221F, 4.5F, 22.222221F);
      ((Path)localObject2).cubicTo(6.003442F, 22.222221F, 7.222222F, 21.003441F, 7.222222F, 19.5F);
      ((Path)localObject2).lineTo(7.222222F, 13.5F);
      ((Path)localObject2).cubicTo(7.222222F, 11.996558F, 6.003442F, 10.777778F, 4.5F, 10.777778F);
      ((Path)localObject2).lineTo(4.5F, 9.0F);
      ((Path)localObject2).cubicTo(6.985282F, 9.0F, 9.0F, 11.014719F, 9.0F, 13.5F);
      ((Path)localObject2).lineTo(9.0F, 19.5F);
      ((Path)localObject2).cubicTo(9.0F, 21.985281F, 6.985282F, 24.0F, 4.5F, 24.0F);
      ((Path)localObject2).cubicTo(2.014719F, 24.0F, 0.0F, 21.985281F, 0.0F, 19.5F);
      ((Path)localObject2).lineTo(0.0F, 16.5F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(9.0F, 7.5F);
      ((Path)localObject2).lineTo(7.222222F, 7.5F);
      ((Path)localObject2).lineTo(7.222222F, 4.5F);
      ((Path)localObject2).cubicTo(7.222222F, 2.996558F, 6.003442F, 1.777778F, 4.5F, 1.777778F);
      ((Path)localObject2).cubicTo(2.996558F, 1.777778F, 1.777778F, 2.996558F, 1.777778F, 4.5F);
      ((Path)localObject2).lineTo(1.777778F, 10.5F);
      ((Path)localObject2).cubicTo(1.777778F, 12.003442F, 2.996558F, 13.222222F, 4.5F, 13.222222F);
      ((Path)localObject2).lineTo(4.5F, 15.0F);
      ((Path)localObject2).cubicTo(2.014719F, 15.0F, 0.0F, 12.985281F, 0.0F, 10.5F);
      ((Path)localObject2).lineTo(0.0F, 4.5F);
      ((Path)localObject2).cubicTo(0.0F, 2.014719F, 2.014719F, 4.565388E-016F, 4.5F, 0.0F);
      ((Path)localObject2).cubicTo(6.985282F, -4.565388E-016F, 9.0F, 2.014719F, 9.0F, 4.5F);
      ((Path)localObject2).lineTo(9.0F, 7.5F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ada
 * JD-Core Version:    0.7.0.1
 */