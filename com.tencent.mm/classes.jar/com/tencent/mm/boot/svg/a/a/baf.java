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

public final class baf
  extends c
{
  private final int height = 54;
  private final int width = 54;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 54;
      return 54;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      Object localObject3 = c.g(paramVarArgs);
      Object localObject2 = c.k(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localObject2 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      ((Paint)localObject2).setStrokeWidth(3.9F);
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(36.0F, 0.0F);
      localPath.lineTo(36.0F, 17.044964F);
      localPath.lineTo(53.893173F, 17.044964F);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 89.044968F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(36.0F, 36.0F);
      ((Path)localObject1).lineTo(36.0F, 53.044964F);
      ((Path)localObject1).lineTo(53.893173F, 53.044964F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.l(paramVarArgs);
      ((Path)localObject3).moveTo(17.893173F, 53.044964F);
      ((Path)localObject3).lineTo(17.893173F, 36.0F);
      ((Path)localObject3).lineTo(0.0F, 36.0F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(17.893017F, 0.03263309F);
      ((Path)localObject2).lineTo(17.893017F, 17.077597F);
      ((Path)localObject2).lineTo(-0.0001565217F, 17.077597F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.baf
 * JD-Core Version:    0.7.0.1
 */