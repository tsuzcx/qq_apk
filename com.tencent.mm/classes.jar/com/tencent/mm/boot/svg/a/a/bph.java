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

public final class bph
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
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
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-13684945);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(30.0F, 0.0F);
      localPath.cubicTo(46.568542F, 0.0F, 60.0F, 13.431458F, 60.0F, 30.0F);
      localPath.cubicTo(60.0F, 46.568542F, 46.568542F, 60.0F, 30.0F, 60.0F);
      localPath.cubicTo(13.431458F, 60.0F, 0.0F, 46.568542F, 0.0F, 30.0F);
      localPath.cubicTo(0.0F, 13.431458F, 13.431458F, 0.0F, 30.0F, 0.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 245, 31);
      localCanvas.drawPath(localPath, c.a(localPaint2, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-8548183);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 14.0F, 0.0F, 1.0F, 14.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(25.055851F, 16.551729F);
      ((Path)localObject2).lineTo(24.672968F, 16.555822F);
      ((Path)localObject2).cubicTo(23.556097F, 16.555822F, 22.908751F, 15.772191F, 23.328331F, 14.828192F);
      ((Path)localObject2).cubicTo(23.625059F, 14.135827F, 24.300451F, 13.590319F, 25.111223F, 13.410193F);
      ((Path)localObject2).cubicTo(27.469143F, 12.841042F, 29.092695F, 10.988818F, 29.092695F, 8.815007F);
      ((Path)localObject2).cubicTo(29.092695F, 6.197762F, 26.610712F, 4.059816F, 23.498846F, 4.059816F);
      ((Path)localObject2).cubicTo(20.38698F, 4.059816F, 17.904997F, 6.197762F, 17.904997F, 8.815007F);
      ((Path)localObject2).lineTo(17.904997F, 21.39488F);
      ((Path)localObject2).cubicTo(17.904997F, 25.733704F, 14.016926F, 29.219561F, 9.241657F, 29.219561F);
      ((Path)localObject2).cubicTo(4.466389F, 29.219561F, 0.5783189F, 25.733704F, 0.5783189F, 21.39488F);
      ((Path)localObject2).cubicTo(0.5783189F, 17.593321F, 3.585328F, 14.353009F, 7.648207F, 13.73793F);
      ((Path)localObject2).lineTo(7.98367F, 13.73793F);
      ((Path)localObject2).cubicTo(8.842476F, 13.73793F, 9.434549F, 14.236519F, 9.434549F, 14.937212F);
      ((Path)localObject2).cubicTo(9.434904F, 15.059127F, 9.432623F, 15.118441F, 9.420301F, 15.192375F);
      ((Path)localObject2).cubicTo(9.404586F, 15.286661F, 9.373752F, 15.375737F, 9.328306F, 15.465561F);
      ((Path)localObject2).cubicTo(9.046687F, 16.122671F, 8.316116F, 16.690893F, 7.545414F, 16.883558F);
      ((Path)localObject2).cubicTo(5.20022F, 17.44964F, 3.563942F, 19.293333F, 3.563942F, 21.39488F);
      ((Path)localObject2).cubicTo(3.563942F, 24.012125F, 6.045925F, 26.150072F, 9.157792F, 26.150072F);
      ((Path)localObject2).cubicTo(12.269658F, 26.150072F, 14.751641F, 24.012125F, 14.751641F, 21.39488F);
      ((Path)localObject2).lineTo(14.751641F, 8.815007F);
      ((Path)localObject2).cubicTo(14.751641F, 4.476183F, 18.639711F, 0.9903269F, 23.41498F, 0.9903269F);
      ((Path)localObject2).cubicTo(28.190248F, 0.9903269F, 32.07832F, 4.476183F, 32.07832F, 8.815007F);
      ((Path)localObject2).cubicTo(32.07832F, 12.657618F, 29.120598F, 15.844817F, 25.055851F, 16.551729F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bph
 * JD-Core Version:    0.7.0.1
 */