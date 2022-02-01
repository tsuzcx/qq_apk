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

public final class ns
  extends c
{
  private final int height = 102;
  private final int width = 102;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 102;
      return 102;
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
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(51.0F, 102.0F);
      localPath.cubicTo(79.166519F, 102.0F, 102.0F, 79.166519F, 102.0F, 51.0F);
      localPath.cubicTo(102.0F, 22.833477F, 79.166519F, 0.0F, 51.0F, 0.0F);
      localPath.cubicTo(22.833477F, 0.0F, 0.0F, 22.833477F, 0.0F, 51.0F);
      localPath.cubicTo(0.0F, 79.166519F, 22.833477F, 102.0F, 51.0F, 102.0F);
      localPath.close();
      localPath.moveTo(51.0F, 98.0F);
      localPath.cubicTo(76.957382F, 98.0F, 98.0F, 76.957382F, 98.0F, 51.0F);
      localPath.cubicTo(98.0F, 25.042616F, 76.957382F, 4.0F, 51.0F, 4.0F);
      localPath.cubicTo(25.042616F, 4.0F, 4.0F, 25.042616F, 4.0F, 51.0F);
      localPath.cubicTo(4.0F, 76.957382F, 25.042616F, 98.0F, 51.0F, 98.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 14.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 24.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(15.415947F, 1.211335F);
      ((Path)localObject3).cubicTo(16.290796F, 0.542333F, 17.0F, 0.8949788F, 17.0F, 1.997005F);
      ((Path)localObject3).lineTo(17.0F, 24.002995F);
      ((Path)localObject3).cubicTo(17.0F, 25.105911F, 16.291174F, 25.457956F, 15.415947F, 24.788666F);
      ((Path)localObject3).lineTo(1.584053F, 14.211334F);
      ((Path)localObject3).cubicTo(0.7092046F, 13.542333F, 0.7088254F, 12.457957F, 1.584053F, 11.788666F);
      ((Path)localObject3).lineTo(15.415947F, 1.211335F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(14.0F, 9.0F);
      ((Path)localObject2).lineTo(55.0F, 9.0F);
      ((Path)localObject2).lineTo(55.0F, 17.0F);
      ((Path)localObject2).lineTo(14.0F, 17.0F);
      ((Path)localObject2).lineTo(14.0F, 9.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ns
 * JD-Core Version:    0.7.0.1
 */