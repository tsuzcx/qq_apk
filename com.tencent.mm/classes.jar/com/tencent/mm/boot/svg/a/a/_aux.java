package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class aux
  extends c
{
  private final int height = 102;
  private final int width = 102;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject1 = c.i(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      Object localObject2 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-986896);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(102.0F, 0.0F);
      localPath.lineTo(102.0F, 102.0F);
      localPath.lineTo(0.0F, 102.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 0, 4);
      localCanvas.drawPath(localPath, c.a((Paint)localObject2, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-11048043);
      ((Paint)localObject1).setStrokeWidth(6.0F);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 50.0F);
      ((Path)localObject2).cubicTo(24.0F, 48.895432F, 24.89543F, 48.0F, 26.0F, 48.0F);
      ((Path)localObject2).lineTo(76.0F, 48.0F);
      ((Path)localObject2).cubicTo(77.104568F, 48.0F, 78.0F, 48.895432F, 78.0F, 50.0F);
      ((Path)localObject2).lineTo(78.0F, 79.0F);
      ((Path)localObject2).cubicTo(78.0F, 80.104568F, 77.104568F, 81.0F, 76.0F, 81.0F);
      ((Path)localObject2).lineTo(26.0F, 81.0F);
      ((Path)localObject2).cubicTo(24.89543F, 81.0F, 24.0F, 80.104568F, 24.0F, 79.0F);
      ((Path)localObject2).lineTo(24.0F, 50.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-11048043);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(28.5F, 35.0F);
      ((Path)localObject2).cubicTo(28.5F, 22.573593F, 38.573593F, 12.5F, 51.0F, 12.5F);
      ((Path)localObject2).cubicTo(63.426407F, 12.5F, 73.5F, 22.573593F, 73.5F, 35.0F);
      ((Path)localObject2).lineTo(67.5F, 35.0F);
      ((Path)localObject2).cubicTo(67.5F, 25.887302F, 60.112698F, 18.5F, 51.0F, 18.5F);
      ((Path)localObject2).cubicTo(41.887302F, 18.5F, 34.5F, 25.887302F, 34.5F, 35.0F);
      ((Path)localObject2).lineTo(28.5F, 35.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-11048043);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(28.5F, 35.0F);
      ((Path)localObject2).lineTo(34.5F, 35.0F);
      ((Path)localObject2).lineTo(34.5F, 47.0F);
      ((Path)localObject2).lineTo(28.5F, 47.0F);
      ((Path)localObject2).lineTo(28.5F, 35.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-11048043);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(67.5F, 35.0F);
      ((Path)localObject1).lineTo(73.5F, 35.0F);
      ((Path)localObject1).lineTo(73.5F, 35.0F);
      ((Path)localObject1).lineTo(73.5F, 35.0F);
      ((Path)localObject1).cubicTo(73.5F, 36.656853F, 72.156853F, 38.0F, 70.5F, 38.0F);
      ((Path)localObject1).lineTo(70.5F, 38.0F);
      ((Path)localObject1).lineTo(70.5F, 38.0F);
      ((Path)localObject1).cubicTo(68.843147F, 38.0F, 67.5F, 36.656853F, 67.5F, 35.0F);
      ((Path)localObject1).lineTo(67.5F, 35.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aux
 * JD-Core Version:    0.7.0.1
 */