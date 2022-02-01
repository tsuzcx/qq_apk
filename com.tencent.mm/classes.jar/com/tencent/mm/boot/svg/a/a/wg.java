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

public final class wg
  extends c
{
  private final int height = 25;
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
      return 25;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      c.a((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -300.0F, 0.0F, 1.0F, -360.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 80.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 256.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, -1.0F, -1.224647E-016F, 336.0F, 1.224647E-016F, -1.0F, 61.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(48.0F, 0.0F);
      ((Path)localObject2).lineTo(48.0F, 48.0F);
      ((Path)localObject2).lineTo(0.0F, 48.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.save();
      localObject2 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      arrayOfFloat = c.a(arrayOfFloat, -1.0F, 0.0F, 36.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      Object localObject3 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject3).setColor(419430400);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(12.0F, 0.0F);
      localPath.cubicTo(18.627417F, 0.0F, 24.0F, 5.372583F, 24.0F, 12.0F);
      localPath.cubicTo(24.0F, 18.627417F, 18.627417F, 24.0F, 12.0F, 24.0F);
      localPath.cubicTo(5.372583F, 24.0F, 0.0F, 18.627417F, 0.0F, 12.0F);
      localPath.cubicTo(0.0F, 5.372583F, 5.372583F, 0.0F, 12.0F, 0.0F);
      localPath.close();
      localPath.moveTo(12.0F, 2.0F);
      localPath.cubicTo(6.477152F, 2.0F, 2.0F, 6.477152F, 2.0F, 12.0F);
      localPath.cubicTo(2.0F, 17.522848F, 6.477152F, 22.0F, 12.0F, 22.0F);
      localPath.cubicTo(17.522848F, 22.0F, 22.0F, 17.522848F, 22.0F, 12.0F);
      localPath.cubicTo(22.0F, 6.477152F, 17.522848F, 2.0F, 12.0F, 2.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-2147483648);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(23.0F, 11.0F);
      ((Path)localObject3).cubicTo(23.552284F, 11.0F, 24.0F, 11.447716F, 24.0F, 12.0F);
      ((Path)localObject3).lineTo(24.0F, 12.0F);
      ((Path)localObject3).lineTo(24.0F, 12.0F);
      ((Path)localObject3).cubicTo(24.0F, 18.601927F, 18.668665F, 23.958654F, 12.076414F, 23.999762F);
      ((Path)localObject3).lineTo(12.017F, 23.999001F);
      ((Path)localObject3).lineTo(12.0F, 24.0F);
      ((Path)localObject3).cubicTo(11.487164F, 24.0F, 11.064493F, 23.61396F, 11.006728F, 23.116621F);
      ((Path)localObject3).lineTo(11.0F, 23.0F);
      ((Path)localObject3).cubicTo(11.0F, 22.447716F, 11.447716F, 22.0F, 12.0F, 22.0F);
      ((Path)localObject3).lineTo(12.0F, 22.0F);
      ((Path)localObject3).cubicTo(17.522848F, 22.0F, 22.0F, 17.522848F, 22.0F, 12.0F);
      ((Path)localObject3).lineTo(22.0F, 11.999F);
      ((Path)localObject3).lineTo(22.006727F, 11.883379F);
      ((Path)localObject3).cubicTo(22.060049F, 11.424297F, 22.424297F, 11.060049F, 22.883379F, 11.006728F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-2147483648);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 49.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(24.0F, 26.631578F);
      ((Path)localObject1).cubicTo(24.616123F, 26.631578F, 25.173965F, 26.896248F, 25.577976F, 27.324244F);
      ((Path)localObject1).lineTo(23.996475F, 29.0F);
      ((Path)localObject1).lineTo(22.420134F, 27.326248F);
      ((Path)localObject1).cubicTo(22.824295F, 26.897076F, 23.382915F, 26.631578F, 24.0F, 26.631578F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(24.0F, 23.31579F);
      ((Path)localObject1).cubicTo(25.479393F, 23.31579F, 26.818777F, 23.951595F, 27.788511F, 24.979635F);
      ((Path)localObject1).lineTo(26.524904F, 26.318941F);
      ((Path)localObject1).cubicTo(25.878475F, 25.63406F, 24.98587F, 25.210526F, 24.0F, 25.210526F);
      ((Path)localObject1).cubicTo(23.012695F, 25.210526F, 22.118925F, 25.635296F, 21.472273F, 26.321936F);
      ((Path)localObject1).lineTo(20.209602F, 24.981636F);
      ((Path)localObject1).cubicTo(21.179487F, 23.952421F, 22.51965F, 23.31579F, 24.0F, 23.31579F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(24.0F, 20.0F);
      ((Path)localObject1).cubicTo(26.343145F, 20.0F, 28.464466F, 21.007359F, 30.0F, 22.63604F);
      ((Path)localObject1).lineTo(28.736841F, 23.975821F);
      ((Path)localObject1).cubicTo(27.524578F, 22.69002F, 25.849852F, 21.894737F, 24.0F, 21.894737F);
      ((Path)localObject1).cubicTo(22.149677F, 21.894737F, 20.474571F, 22.690424F, 19.262234F, 23.976801F);
      ((Path)localObject1).lineTo(18.0F, 22.63604F);
      ((Path)localObject1).cubicTo(19.535534F, 21.007359F, 21.656855F, 20.0F, 24.0F, 20.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.wg
 * JD-Core Version:    0.7.0.1
 */