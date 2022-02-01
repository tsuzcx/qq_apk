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

public final class li
  extends c
{
  private final int height = 80;
  private final int width = 80;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 80;
      return 80;
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
      localCanvas.save();
      localPaint1 = c.a((Paint)localObject2, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(40.0F, 0.0F);
      localPath.cubicTo(62.091389F, 0.0F, 80.0F, 17.908609F, 80.0F, 40.0F);
      localPath.cubicTo(80.0F, 62.091389F, 62.091389F, 80.0F, 40.0F, 80.0F);
      localPath.lineTo(40.0F, 73.0F);
      localPath.cubicTo(58.225395F, 73.0F, 73.0F, 58.225395F, 73.0F, 40.0F);
      localPath.cubicTo(73.0F, 21.774603F, 58.225395F, 7.0F, 40.0F, 7.0F);
      localPath.lineTo(40.0F, 0.0F);
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
      arrayOfFloat = c.a(arrayOfFloat, 80.0F, 0.0F, 40.0F, 0.0F, 80.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 0.9408692F, 0.0F, 0.9408692F, 0.9055908F, new int[] { 13421772, -2134061876 }, new float[] { 0.0F, 0.9971495F }, (Matrix)localObject1, 0);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a((Paint)localObject2, paramVarArgs);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(40.0F, 0.0F);
      localPath.lineTo(40.0F, 7.0F);
      localPath.cubicTo(21.774603F, 7.0F, 7.0F, 21.774603F, 7.0F, 40.0F);
      localPath.cubicTo(7.0F, 58.225395F, 21.774603F, 73.0F, 40.0F, 73.0F);
      localPath.lineTo(40.0F, 80.0F);
      localPath.cubicTo(17.908609F, 80.0F, 0.0F, 62.091389F, 0.0F, 40.0F);
      localPath.cubicTo(0.0F, 17.908609F, 17.908609F, 0.0F, 40.0F, 0.0F);
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
      arrayOfFloat = c.a(arrayOfFloat, 40.0F, 0.0F, 0.0F, 0.0F, 80.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 1.0F, 0.1008556F, 1.0F, 0.8932232F, new int[] { -3355444, -2134061876 }, new float[] { 0.0009237754F, 1.0F }, (Matrix)localObject1, 0);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-3355444);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(40.5F, 0.0F);
      ((Path)localObject2).cubicTo(42.432999F, 0.0F, 44.0F, 1.567003F, 44.0F, 3.5F);
      ((Path)localObject2).cubicTo(44.0F, 5.432997F, 42.432999F, 7.0F, 40.5F, 7.0F);
      ((Path)localObject2).cubicTo(38.567001F, 7.0F, 37.0F, 5.432997F, 37.0F, 3.5F);
      ((Path)localObject2).cubicTo(37.0F, 1.567003F, 38.567001F, 0.0F, 40.5F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.li
 * JD-Core Version:    0.7.0.1
 */