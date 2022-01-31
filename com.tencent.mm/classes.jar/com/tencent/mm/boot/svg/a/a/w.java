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

public final class w
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Object localObject = c.i(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localObject = c.a((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localPaint = c.a((Paint)localObject, paramVarArgs);
      localPaint.setColor(-16777216);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(72.0F, 0.0F);
      localPath.lineTo(72.0F, 72.0F);
      localPath.lineTo(0.0F, 72.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 0, 4);
      localCanvas.drawPath(localPath, c.a(localPaint, paramVarArgs));
      localCanvas.restore();
      localPaint = c.a((Paint)localObject, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(34.0F, 59.313408F);
      ((Path)localObject).cubicTo(23.340136F, 58.30629F, 15.0F, 49.330818F, 15.0F, 38.407406F);
      ((Path)localObject).lineTo(15.0F, 26.185184F);
      ((Path)localObject).lineTo(15.0F, 37.0F);
      ((Path)localObject).lineTo(19.0F, 37.0F);
      ((Path)localObject).lineTo(19.0F, 37.851852F);
      ((Path)localObject).cubicTo(19.0F, 47.240692F, 26.611158F, 54.851852F, 36.0F, 54.851852F);
      ((Path)localObject).cubicTo(45.38884F, 54.851852F, 53.0F, 47.240692F, 53.0F, 37.851852F);
      ((Path)localObject).lineTo(53.0F, 37.0F);
      ((Path)localObject).lineTo(57.0F, 37.0F);
      ((Path)localObject).lineTo(57.0F, 26.185184F);
      ((Path)localObject).lineTo(57.0F, 38.407406F);
      ((Path)localObject).cubicTo(57.0F, 49.330818F, 48.659866F, 58.30629F, 38.0F, 59.313408F);
      ((Path)localObject).lineTo(38.0F, 62.950619F);
      ((Path)localObject).lineTo(34.0F, 62.950619F);
      ((Path)localObject).lineTo(34.0F, 59.313408F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(23.0F, 62.950619F);
      ((Path)localObject).lineTo(49.0F, 62.950619F);
      ((Path)localObject).lineTo(49.0F, 67.0F);
      ((Path)localObject).lineTo(23.0F, 67.0F);
      ((Path)localObject).lineTo(23.0F, 62.950619F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 6.259259F);
      ((Path)localObject).lineTo(36.0F, 6.259259F);
      ((Path)localObject).cubicTo(43.179703F, 6.259259F, 49.0F, 12.079557F, 49.0F, 19.25926F);
      ((Path)localObject).lineTo(49.0F, 37.802467F);
      ((Path)localObject).cubicTo(49.0F, 44.98217F, 43.179703F, 50.802467F, 36.0F, 50.802467F);
      ((Path)localObject).lineTo(36.0F, 50.802467F);
      ((Path)localObject).lineTo(36.0F, 50.802467F);
      ((Path)localObject).cubicTo(28.820299F, 50.802467F, 23.0F, 44.98217F, 23.0F, 37.802467F);
      ((Path)localObject).lineTo(23.0F, 19.25926F);
      ((Path)localObject).cubicTo(23.0F, 12.079557F, 28.820299F, 6.259259F, 36.0F, 6.259259F);
      ((Path)localObject).lineTo(36.0F, 6.259259F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 76, 4);
      localPaint = c.a(localPaint, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.w
 * JD-Core Version:    0.7.0.1
 */