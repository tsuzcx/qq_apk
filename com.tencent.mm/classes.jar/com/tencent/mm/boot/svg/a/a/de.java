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

public final class de
  extends c
{
  private final int height = 90;
  private final int width = 90;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 90;
      return 90;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.k(paramVarArgs);
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
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(90.0F, 0.0F);
      localPath.lineTo(90.0F, 90.0F);
      localPath.lineTo(0.0F, 90.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.a((float[])localObject2, 0.7071068F, -0.7071068F, 55.691124F, 0.7071068F, 0.7071068F, 21.750002F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 153, 4);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 33.0F);
      ((Path)localObject2).lineTo(3.75F, 33.0F);
      ((Path)localObject2).lineTo(3.75F, 39.0F);
      ((Path)localObject2).cubicTo(3.75F, 41.899494F, 6.100505F, 44.25F, 9.0F, 44.25F);
      ((Path)localObject2).cubicTo(11.899495F, 44.25F, 14.25F, 41.899494F, 14.25F, 39.0F);
      ((Path)localObject2).lineTo(14.25F, 27.0F);
      ((Path)localObject2).cubicTo(14.25F, 24.100506F, 11.899495F, 21.75F, 9.0F, 21.75F);
      ((Path)localObject2).lineTo(9.0F, 18.0F);
      ((Path)localObject2).cubicTo(13.970563F, 18.0F, 18.0F, 22.029438F, 18.0F, 27.0F);
      ((Path)localObject2).lineTo(18.0F, 39.0F);
      ((Path)localObject2).cubicTo(18.0F, 43.970562F, 13.970563F, 48.0F, 9.0F, 48.0F);
      ((Path)localObject2).cubicTo(4.029437F, 48.0F, 0.0F, 43.970562F, 0.0F, 39.0F);
      ((Path)localObject2).lineTo(0.0F, 33.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(0.0F, 33.0F);
      ((Path)localObject2).lineTo(3.75F, 33.0F);
      ((Path)localObject2).lineTo(3.75F, 39.0F);
      ((Path)localObject2).cubicTo(3.75F, 41.899494F, 6.100505F, 44.25F, 9.0F, 44.25F);
      ((Path)localObject2).cubicTo(11.899495F, 44.25F, 14.25F, 41.899494F, 14.25F, 39.0F);
      ((Path)localObject2).lineTo(14.25F, 27.0F);
      ((Path)localObject2).cubicTo(14.25F, 24.100506F, 11.899495F, 21.75F, 9.0F, 21.75F);
      ((Path)localObject2).lineTo(9.0F, 18.0F);
      ((Path)localObject2).cubicTo(13.970563F, 18.0F, 18.0F, 22.029438F, 18.0F, 27.0F);
      ((Path)localObject2).lineTo(18.0F, 39.0F);
      ((Path)localObject2).cubicTo(18.0F, 43.970562F, 13.970563F, 48.0F, 9.0F, 48.0F);
      ((Path)localObject2).cubicTo(4.029437F, 48.0F, 0.0F, 43.970562F, 0.0F, 39.0F);
      ((Path)localObject2).lineTo(0.0F, 33.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(18.0F, 15.0F);
      ((Path)localObject2).lineTo(14.25F, 15.0F);
      ((Path)localObject2).lineTo(14.25F, 9.0F);
      ((Path)localObject2).cubicTo(14.25F, 6.100505F, 11.899495F, 3.75F, 9.0F, 3.75F);
      ((Path)localObject2).cubicTo(6.100505F, 3.75F, 3.75F, 6.100505F, 3.75F, 9.0F);
      ((Path)localObject2).lineTo(3.75F, 21.0F);
      ((Path)localObject2).cubicTo(3.75F, 23.899494F, 6.100505F, 26.25F, 9.0F, 26.25F);
      ((Path)localObject2).lineTo(9.0F, 30.0F);
      ((Path)localObject2).cubicTo(4.029437F, 30.0F, 0.0F, 25.970562F, 0.0F, 21.0F);
      ((Path)localObject2).lineTo(0.0F, 9.0F);
      ((Path)localObject2).cubicTo(0.0F, 4.029437F, 4.029437F, 9.130776E-016F, 9.0F, 0.0F);
      ((Path)localObject2).cubicTo(13.970563F, -9.130776E-016F, 18.0F, 4.029437F, 18.0F, 9.0F);
      ((Path)localObject2).lineTo(18.0F, 15.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.de
 * JD-Core Version:    0.7.0.1
 */