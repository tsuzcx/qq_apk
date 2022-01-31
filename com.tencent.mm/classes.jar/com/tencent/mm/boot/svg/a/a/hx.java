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

public final class hx
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.i(paramVarArgs);
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
      ((Paint)localObject).setColor(-16896);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(115.8F, 60.688889F);
      localPath.cubicTo(115.8F, 29.181868F, 90.81813F, 4.2F, 59.311111F, 4.2F);
      localPath.cubicTo(29.181868F, 4.2F, 4.2F, 29.181868F, 4.2F, 60.688889F);
      localPath.cubicTo(4.2F, 90.81813F, 29.181868F, 115.8F, 59.311111F, 115.8F);
      localPath.cubicTo(90.81813F, 115.8F, 115.8F, 90.81813F, 115.8F, 60.688889F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(57.790684F, 34.200001F);
      ((Path)localObject).lineTo(62.209316F, 34.200001F);
      ((Path)localObject).cubicTo(63.301052F, 34.200001F, 64.166962F, 35.09441F, 64.126213F, 36.197716F);
      ((Path)localObject).lineTo(62.836727F, 71.108124F);
      ((Path)localObject).cubicTo(62.816696F, 71.650375F, 62.351761F, 72.10244F, 61.798832F, 72.10244F);
      ((Path)localObject).lineTo(58.201168F, 72.10244F);
      ((Path)localObject).cubicTo(57.639423F, 72.10244F, 57.183556F, 71.657272F, 57.163273F, 71.108124F);
      ((Path)localObject).lineTo(55.873791F, 36.197716F);
      ((Path)localObject).cubicTo(55.833225F, 35.099537F, 56.691257F, 34.200001F, 57.790684F, 34.200001F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(60.0F, 85.800003F);
      ((Path)localObject).cubicTo(57.680405F, 85.800003F, 55.799999F, 83.919594F, 55.799999F, 81.599998F);
      ((Path)localObject).cubicTo(55.799999F, 79.280403F, 57.680405F, 77.400002F, 60.0F, 77.400002F);
      ((Path)localObject).cubicTo(62.319595F, 77.400002F, 64.199997F, 79.280403F, 64.199997F, 81.599998F);
      ((Path)localObject).cubicTo(64.199997F, 83.919594F, 62.319595F, 85.800003F, 60.0F, 85.800003F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.hx
 * JD-Core Version:    0.7.0.1
 */