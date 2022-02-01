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

public final class lz
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-15683841);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(61.194798F, 19.200624F);
      localPath.lineTo(36.597427F, 33.401924F);
      localPath.lineTo(12.0F, 19.200594F);
      localPath.cubicTo(12.061533F, 19.16046F, 12.123658F, 19.122423F, 12.186299F, 19.086618F);
      localPath.lineTo(34.008553F, 6.612736F);
      localPath.cubicTo(35.438347F, 5.795446F, 37.757584F, 5.796063F, 39.186298F, 6.612736F);
      localPath.lineTo(61.008553F, 19.086618F);
      localPath.cubicTo(61.071178F, 19.122416F, 61.133286F, 19.160461F, 61.194798F, 19.200624F);
      localPath.lineTo(61.194798F, 19.200624F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-372399);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(64.163666F, 23.027594F);
      localPath.cubicTo(64.184158F, 23.187063F, 64.194801F, 23.344381F, 64.194801F, 23.49818F);
      localPath.lineTo(64.194801F, 48.50182F);
      localPath.cubicTo(64.194801F, 50.120968F, 63.034641F, 52.09671F, 61.605927F, 52.913383F);
      localPath.lineTo(39.783672F, 65.38726F);
      localPath.cubicTo(39.675545F, 65.449074F, 39.562328F, 65.506203F, 39.444798F, 65.558655F);
      localPath.lineTo(39.444798F, 37.299038F);
      localPath.lineTo(64.163666F, 23.027594F);
      localPath.lineTo(64.163666F, 23.027594F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-15616);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(33.411125F, 65.38726F);
      ((Path)localObject).lineTo(11.588874F, 52.913383F);
      ((Path)localObject).cubicTo(10.159078F, 52.096092F, 9.0F, 50.107227F, 9.0F, 48.50182F);
      ((Path)localObject).lineTo(9.0F, 23.49818F);
      ((Path)localObject).cubicTo(9.0F, 23.344044F, 9.010513F, 23.186676F, 9.030771F, 23.027386F);
      ((Path)localObject).lineTo(33.75F, 37.299038F);
      ((Path)localObject).lineTo(33.75F, 65.558647F);
      ((Path)localObject).cubicTo(33.632458F, 65.506195F, 33.519241F, 65.449066F, 33.411125F, 65.38726F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.lz
 * JD-Core Version:    0.7.0.1
 */