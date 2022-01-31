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

public final class avw
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
      Object localObject1 = c.f(paramVarArgs);
      Object localObject3 = c.e(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(55.381916F, 0.0F);
      ((Path)localObject3).lineTo(56.457024F, 0.0F);
      ((Path)localObject3).cubicTo(56.297745F, 7.262626F, 57.581902F, 14.484849F, 58.0F, 21.727272F);
      ((Path)localObject3).cubicTo(50.484203F, 22.0F, 42.968407F, 22.222221F, 35.45261F, 22.505051F);
      ((Path)localObject3).cubicTo(38.090603F, 19.474747F, 40.937649F, 16.626263F, 43.515915F, 13.535354F);
      ((Path)localObject3).cubicTo(35.601929F, 10.222222F, 26.085238F, 10.989899F, 19.09704F, 16.161615F);
      ((Path)localObject3).cubicTo(12.01925F, 21.111111F, 8.166781F, 29.898991F, 8.52515F, 38.525253F);
      ((Path)localObject3).cubicTo(6.036476F, 38.676769F, 3.557756F, 38.838383F, 1.069082F, 39.0F);
      ((Path)localObject3).cubicTo(0.2030232F, 25.969698F, 7.549591F, 12.848485F, 19.196587F, 7.222222F);
      ((Path)localObject3).cubicTo(28.434547F, 2.474747F, 39.82272F, 2.89899F, 48.921314F, 7.79798F);
      ((Path)localObject3).cubicTo(50.752979F, 5.79798F, 52.495052F, 3.69697F, 54.625359F, 2.0F);
      ((Path)localObject3).cubicTo(54.814495F, 1.505051F, 55.192776F, 0.5050505F, 55.381916F, 0.0F);
      ((Path)localObject3).lineTo(55.381916F, 0.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(48.933964F, 55.036011F);
      ((Path)localObject2).cubicTo(55.348537F, 49.984196F, 58.860096F, 41.668911F, 58.411175F, 33.484974F);
      ((Path)localObject2).cubicTo(60.915154F, 33.323315F, 63.409153F, 33.161659F, 65.90316F, 33.0F);
      ((Path)localObject2).cubicTo(67.140182F, 48.397926F, 56.386044F, 63.331089F, 41.681408F, 67.190674F);
      ((Path)localObject2).lineTo(41.491863F, 68.039375F);
      ((Path)localObject2).lineTo(41.471909F, 67.130051F);
      ((Path)localObject2).cubicTo(33.650719F, 69.251816F, 25.151159F, 68.009064F, 18.028288F, 64.189896F);
      ((Path)localObject2).cubicTo(15.614094F, 66.776428F, 13.229828F, 69.403366F, 10.815634F, 72.0F);
      ((Path)localObject2).cubicTo(10.197121F, 64.59404F, 9.608537F, 57.188084F, 9.0F, 49.782124F);
      ((Path)localObject2).lineTo(30.927269F, 49.782124F);
      ((Path)localObject2).cubicTo(28.443243F, 52.631348F, 25.959215F, 55.480572F, 23.415333F, 58.269173F);
      ((Path)localObject2).cubicTo(31.625589F, 62.219688F, 41.890903F, 60.774872F, 48.933964F, 55.036011F);
      ((Path)localObject2).lineTo(48.933964F, 55.036011F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.avw
 * JD-Core Version:    0.7.0.1
 */