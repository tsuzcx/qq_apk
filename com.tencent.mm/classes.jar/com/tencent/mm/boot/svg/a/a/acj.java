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

public final class acj
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      localPaint2.setColor(-10197008);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(120.0F, 0.0F);
      localPath.lineTo(120.0F, 120.0F);
      localPath.lineTo(0.0F, 120.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 33.0F, 0.0F, 1.0F, 30.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(45.0F, 6.926539F);
      ((Path)localObject2).lineTo(15.0F, 13.503461F);
      ((Path)localObject2).lineTo(15.0F, 48.587288F);
      ((Path)localObject2).lineTo(15.0F, 51.603806F);
      ((Path)localObject2).cubicTo(15.0F, 54.412968F, 13.118741F, 57.152088F, 10.588413F, 58.332195F);
      ((Path)localObject2).cubicTo(10.118035F, 58.551575F, 7.146579F, 59.215725F, 6.758582F, 59.293781F);
      ((Path)localObject2).cubicTo(3.030496F, 60.043785F, 0.1660346F, 56.850475F, 0.00828486F, 53.621342F);
      ((Path)localObject2).cubicTo(-0.1494649F, 50.392208F, 1.96819F, 47.699585F, 4.425209F, 47.205288F);
      ((Path)localObject2).lineTo(8.218742F, 46.253464F);
      ((Path)localObject2).cubicTo(9.559703F, 45.917004F, 10.5F, 44.711636F, 10.5F, 43.329109F);
      ((Path)localObject2).lineTo(10.5F, 12.935236F);
      ((Path)localObject2).lineTo(10.5F, 11.881246F);
      ((Path)localObject2).cubicTo(10.5F, 10.471695F, 11.481296F, 9.252241F, 12.858213F, 8.950698F);
      ((Path)localObject2).lineTo(47.679108F, 1.324965F);
      ((Path)localObject2).cubicTo(48.488354F, 1.14774F, 49.288048F, 1.660097F, 49.465275F, 2.469345F);
      ((Path)localObject2).cubicTo(49.488358F, 2.57475F, 49.5F, 2.682337F, 49.5F, 2.790239F);
      ((Path)localObject2).lineTo(49.5F, 4.462189F);
      ((Path)localObject2).lineTo(49.5F, 40.601345F);
      ((Path)localObject2).lineTo(49.5F, 43.617863F);
      ((Path)localObject2).cubicTo(49.5F, 46.427025F, 47.602406F, 49.166145F, 45.050106F, 50.346252F);
      ((Path)localObject2).cubicTo(44.575645F, 50.565632F, 41.578388F, 51.229782F, 41.187023F, 51.307838F);
      ((Path)localObject2).cubicTo(37.426563F, 52.057846F, 34.537231F, 48.864536F, 34.378109F, 45.635403F);
      ((Path)localObject2).cubicTo(34.21899F, 42.406269F, 36.355034F, 39.713642F, 38.833385F, 39.219345F);
      ((Path)localObject2).lineTo(42.70845F, 38.261543F);
      ((Path)localObject2).cubicTo(44.054424F, 37.928856F, 45.0F, 36.721104F, 45.0F, 35.334625F);
      ((Path)localObject2).lineTo(45.0F, 6.926539F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.acj
 * JD-Core Version:    0.7.0.1
 */