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

public final class wz
  extends c
{
  private final int height = 144;
  private final int width = 144;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 144;
      return 144;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Object localObject1 = c.m(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      Object localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-855638017);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 28.799999F);
      localPath.cubicTo(0.0F, 12.894198F, 12.894198F, 0.0F, 28.799999F, 0.0F);
      localPath.lineTo(115.2F, 0.0F);
      localPath.cubicTo(131.1058F, 0.0F, 144.0F, 12.894198F, 144.0F, 28.799999F);
      localPath.lineTo(144.0F, 115.2F);
      localPath.cubicTo(144.0F, 131.1058F, 131.1058F, 144.0F, 115.2F, 144.0F);
      localPath.lineTo(28.799999F, 144.0F);
      localPath.cubicTo(12.894198F, 144.0F, 0.0F, 131.1058F, 0.0F, 115.2F);
      localPath.lineTo(0.0F, 28.799999F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-14477034);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(94.199997F, 67.734596F);
      ((Path)localObject2).lineTo(94.199997F, 89.8806F);
      ((Path)localObject2).cubicTo(94.199997F, 92.265602F, 92.264999F, 94.2006F, 89.879997F, 94.2006F);
      ((Path)localObject2).lineTo(55.32F, 94.2006F);
      ((Path)localObject2).cubicTo(52.935001F, 94.2006F, 51.0F, 92.265602F, 51.0F, 89.8806F);
      ((Path)localObject2).lineTo(51.0F, 55.320599F);
      ((Path)localObject2).cubicTo(51.0F, 52.932598F, 52.935001F, 51.000599F, 55.32F, 51.000599F);
      ((Path)localObject2).lineTo(89.879997F, 51.000599F);
      ((Path)localObject2).cubicTo(90.219002F, 51.000599F, 90.552002F, 51.0396F, 90.866997F, 51.114601F);
      ((Path)localObject2).lineTo(87.599998F, 54.600601F);
      ((Path)localObject2).lineTo(55.32F, 54.600601F);
      ((Path)localObject2).cubicTo(54.921001F, 54.600601F, 54.599998F, 54.9216F, 54.599998F, 55.320599F);
      ((Path)localObject2).lineTo(54.599998F, 89.8806F);
      ((Path)localObject2).cubicTo(54.599998F, 90.276604F, 54.921001F, 90.600601F, 55.32F, 90.600601F);
      ((Path)localObject2).lineTo(89.879997F, 90.600601F);
      ((Path)localObject2).cubicTo(90.278999F, 90.600601F, 90.599998F, 90.276604F, 90.599998F, 89.8806F);
      ((Path)localObject2).lineTo(90.599998F, 71.5746F);
      ((Path)localObject2).lineTo(94.199997F, 67.734596F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(3.6F);
      localPaint.setStrokeCap(Paint.Cap.SQUARE);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(63.647999F, 67.407082F);
      ((Path)localObject1).lineTo(73.500633F, 78.480003F);
      ((Path)localObject1).lineTo(96.0F, 54.48867F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.wz
 * JD-Core Version:    0.7.0.1
 */