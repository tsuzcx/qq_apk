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

public final class yr
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
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.m(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.a((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-855638017);
      localObject3 = c.a((float[])localObject2, 1.0F, 0.0F, 17.0F, 0.0F, 1.0F, 15.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a(localPaint, paramVarArgs);
      localObject3 = c.a((float[])localObject3, -6.123234E-017F, 1.0F, -23.840988F, 1.0F, 6.123234E-017F, 23.840988F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(15.25F, 24.75F);
      localPath.lineTo(15.25F, 39.0F);
      localPath.lineTo(10.75F, 39.0F);
      localPath.lineTo(10.75F, 32.43F);
      localPath.lineTo(4.09099F, 39.090992F);
      localPath.lineTo(0.9090098F, 35.909008F);
      localPath.lineTo(7.568F, 29.25F);
      localPath.lineTo(1.0F, 29.25F);
      localPath.lineTo(1.0F, 24.75F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a(localPaint, paramVarArgs);
      localObject3 = c.a((float[])localObject3, 6.123234E-017F, -1.0F, 64.0F, 1.0F, 6.123234E-017F, -0.1590118F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(39.25F, 24.75F);
      localPath.lineTo(39.25F, 39.0F);
      localPath.lineTo(34.75F, 39.0F);
      localPath.lineTo(34.75F, 32.43F);
      localPath.lineTo(28.09099F, 39.090992F);
      localPath.lineTo(24.90901F, 35.909008F);
      localPath.lineTo(31.569F, 29.249001F);
      localPath.lineTo(25.0F, 29.25F);
      localPath.lineTo(25.0F, 24.75F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a(localPaint, paramVarArgs);
      localObject3 = c.a((float[])localObject3, -6.123234E-017F, 1.0F, 0.1590099F, -1.0F, -6.123234E-017F, 16.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(15.25F, 0.75F);
      localPath.lineTo(15.25F, 15.0F);
      localPath.lineTo(10.75F, 15.0F);
      localPath.lineTo(10.75F, 8.43F);
      localPath.lineTo(4.09099F, 15.09099F);
      localPath.lineTo(0.9090098F, 11.90901F);
      localPath.lineTo(7.57F, 5.249F);
      localPath.lineTo(1.0F, 5.25F);
      localPath.lineTo(1.0F, 0.75F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject2 = c.a((float[])localObject3, 6.123234E-017F, -1.0F, 40.0F, -1.0F, -6.123234E-017F, 40.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(39.25F, 0.75F);
      ((Path)localObject1).lineTo(39.25F, 15.0F);
      ((Path)localObject1).lineTo(34.75F, 15.0F);
      ((Path)localObject1).lineTo(34.75F, 8.43F);
      ((Path)localObject1).lineTo(28.09099F, 15.09099F);
      ((Path)localObject1).lineTo(24.90901F, 11.90901F);
      ((Path)localObject1).lineTo(31.569F, 5.25F);
      ((Path)localObject1).lineTo(25.0F, 5.25F);
      ((Path)localObject1).lineTo(25.0F, 0.75F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.yr
 * JD-Core Version:    0.7.0.1
 */