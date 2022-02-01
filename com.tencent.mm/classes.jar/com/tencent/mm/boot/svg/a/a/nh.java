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

public final class nh
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.BUTT);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localPaint1.setStrokeMiter(4.0F);
      localPaint1.setPathEffect(null);
      c.a(localPaint1, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 230, 31);
      localCanvas.save();
      localPaint1 = c.a((Paint)localObject2, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(30.0F, 0.0F);
      localPath.cubicTo(46.568542F, 0.0F, 60.0F, 13.431458F, 60.0F, 30.0F);
      localPath.cubicTo(60.0F, 46.568542F, 46.568542F, 60.0F, 30.0F, 60.0F);
      localPath.lineTo(30.0F, 54.75F);
      localPath.cubicTo(43.669048F, 54.75F, 54.75F, 43.669048F, 54.75F, 30.0F);
      localPath.cubicTo(54.75F, 16.330952F, 43.669048F, 5.25F, 30.0F, 5.25F);
      localPath.lineTo(30.0F, 0.0F);
      localPath.close();
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      Paint localPaint3 = c.m(paramVarArgs);
      localPaint3.setFlags(385);
      localPaint3.setStyle(Paint.Style.STROKE);
      localPaint2.setColor(-16777216);
      localPaint3.setStrokeWidth(1.0F);
      localPaint3.setStrokeCap(Paint.Cap.BUTT);
      localPaint3.setStrokeJoin(Paint.Join.MITER);
      localPaint3.setStrokeMiter(4.0F);
      localPaint3.setPathEffect(null);
      arrayOfFloat = c.a(arrayOfFloat, 60.0F, 0.0F, 30.0F, 0.0F, 60.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 0.9408692F, 0.0F, 0.9408692F, 0.9055908F, new int[] { 508256, 1275576672 }, new float[] { 0.0F, 1.0F }, (Matrix)localObject1, 0);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a((Paint)localObject2, paramVarArgs);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(30.0F, 0.0F);
      localPath.lineTo(30.0F, 5.25F);
      localPath.cubicTo(16.330952F, 5.25F, 5.25F, 16.330952F, 5.25F, 30.0F);
      localPath.cubicTo(5.25F, 43.669048F, 16.330952F, 54.75F, 30.0F, 54.75F);
      localPath.lineTo(30.0F, 60.0F);
      localPath.cubicTo(13.431458F, 60.0F, 0.0F, 46.568542F, 0.0F, 30.0F);
      localPath.cubicTo(0.0F, 13.431458F, 13.431458F, 0.0F, 30.0F, 0.0F);
      localPath.close();
      localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      localPaint3 = c.m(paramVarArgs);
      localPaint3.setFlags(385);
      localPaint3.setStyle(Paint.Style.STROKE);
      localPaint2.setColor(-16777216);
      localPaint3.setStrokeWidth(1.0F);
      localPaint3.setStrokeCap(Paint.Cap.BUTT);
      localPaint3.setStrokeJoin(Paint.Join.MITER);
      localPaint3.setStrokeMiter(4.0F);
      localPaint3.setPathEffect(null);
      arrayOfFloat = c.a(arrayOfFloat, 30.0F, 0.0F, 0.0F, 0.0F, 60.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 1.0F, 0.08673706F, 1.0F, 0.906287F, new int[] { -16268960, 1275576672 }, new float[] { 0.0F, 1.0F }, (Matrix)localObject1, 0);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16268960);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(30.375F, 0.0F);
      ((Path)localObject2).cubicTo(31.824747F, 0.0F, 33.0F, 1.175252F, 33.0F, 2.625F);
      ((Path)localObject2).cubicTo(33.0F, 4.074748F, 31.824747F, 5.25F, 30.375F, 5.25F);
      ((Path)localObject2).cubicTo(28.925253F, 5.25F, 27.75F, 4.074748F, 27.75F, 2.625F);
      ((Path)localObject2).cubicTo(27.75F, 1.175252F, 28.925253F, 0.0F, 30.375F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.nh
 * JD-Core Version:    0.7.0.1
 */