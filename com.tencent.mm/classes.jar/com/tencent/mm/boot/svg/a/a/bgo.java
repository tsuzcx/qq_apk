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

public final class bgo
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-420614675);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(12.0F, 1.0F);
      localPath.cubicTo(18.075132F, 1.0F, 23.0F, 5.924868F, 23.0F, 12.0F);
      localPath.cubicTo(23.0F, 18.075132F, 18.075132F, 23.0F, 12.0F, 23.0F);
      localPath.cubicTo(5.924868F, 23.0F, 1.0F, 18.075132F, 1.0F, 12.0F);
      localPath.cubicTo(1.0F, 5.924868F, 5.924868F, 1.0F, 12.0F, 1.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 5.4F, 0.0F, 1.0F, 5.4F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(5.295904F, 2.764018F);
      ((Path)localObject).lineTo(10.347847F, 5.872906F);
      ((Path)localObject).cubicTo(10.658283F, 6.063943F, 10.755075F, 6.470469F, 10.564037F, 6.780905F);
      ((Path)localObject).cubicTo(10.509889F, 6.868897F, 10.435839F, 6.942946F, 10.347847F, 6.997095F);
      ((Path)localObject).lineTo(5.295905F, 10.105983F);
      ((Path)localObject).cubicTo(4.985468F, 10.29702F, 4.578943F, 10.200229F, 4.387906F, 9.889792F);
      ((Path)localObject).cubicTo(4.323893F, 9.785771F, 4.29F, 9.666028F, 4.29F, 9.543888F);
      ((Path)localObject).lineTo(4.29F, 3.326113F);
      ((Path)localObject).cubicTo(4.29F, 2.961605F, 4.585493F, 2.666113F, 4.95F, 2.666113F);
      ((Path)localObject).cubicTo(5.07214F, 2.666113F, 5.191884F, 2.700006F, 5.295905F, 2.764019F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bgo
 * JD-Core Version:    0.7.0.1
 */