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

public final class bbk
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
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
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, -136.0F, 0.0F, 1.0F, -533.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 104.0F, 0.0F, 1.0F, 501.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 32.0F, 0.0F, 1.0F, 32.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      Object localObject4 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject4).setColor(-526345);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 24.0F);
      localPath.cubicTo(0.0F, 10.745165F, 10.745165F, 0.0F, 24.0F, 0.0F);
      localPath.lineTo(24.0F, 0.0F);
      localPath.cubicTo(37.254837F, 0.0F, 48.0F, 10.745165F, 48.0F, 24.0F);
      localPath.lineTo(48.0F, 24.0F);
      localPath.cubicTo(48.0F, 37.254837F, 37.254837F, 48.0F, 24.0F, 48.0F);
      localPath.lineTo(24.0F, 48.0F);
      localPath.cubicTo(10.745165F, 48.0F, 0.0F, 37.254837F, 0.0F, 24.0F);
      localPath.lineTo(0.0F, 24.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-2511000);
      ((Paint)localObject2).setColor(-2511000);
      ((Paint)localObject2).setStrokeWidth(0.9F);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 11.428571F, 0.0F, 1.0F, 11.428571F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      localObject3 = c.a((Paint)localObject2, paramVarArgs);
      localObject4 = c.n(paramVarArgs);
      ((Path)localObject4).moveTo(11.428572F, 2.285714F);
      ((Path)localObject4).cubicTo(15.973414F, 2.285714F, 19.89864F, 4.938619F, 21.740171F, 8.780357F);
      ((Path)localObject4).lineTo(19.67799F, 9.76743F);
      ((Path)localObject4).cubicTo(18.204821F, 6.693885F, 15.064559F, 4.571429F, 11.428572F, 4.571429F);
      ((Path)localObject4).cubicTo(6.379111F, 4.571429F, 2.285714F, 8.664825F, 2.285714F, 13.714286F);
      ((Path)localObject4).cubicTo(2.285714F, 18.763746F, 6.379111F, 22.857143F, 11.428572F, 22.857143F);
      ((Path)localObject4).cubicTo(14.671368F, 22.857143F, 17.519855F, 21.168907F, 19.143066F, 18.623404F);
      ((Path)localObject4).lineTo(21.07189F, 19.850368F);
      ((Path)localObject4).cubicTo(19.04291F, 23.032423F, 15.4822F, 25.142857F, 11.428572F, 25.142857F);
      ((Path)localObject4).cubicTo(5.116746F, 25.142857F, 0.0F, 20.026112F, 0.0F, 13.714286F);
      ((Path)localObject4).cubicTo(0.0F, 7.40246F, 5.116746F, 2.285714F, 11.428572F, 2.285714F);
      ((Path)localObject4).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject4, 2);
      localCanvas.drawPath((Path)localObject4, (Paint)localObject1);
      localCanvas.drawPath((Path)localObject4, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(21.881815F, 0.6317853F);
      ((Path)localObject2).cubicTo(21.990536F, 0.5230645F, 22.088455F, 0.5625677F, 22.088455F, 0.7320877F);
      ((Path)localObject2).lineTo(22.088455F, 0.7320877F);
      ((Path)localObject2).lineTo(22.088455F, 10.011749F);
      ((Path)localObject2).cubicTo(22.088455F, 10.178834F, 21.951033F, 10.318692F, 21.781511F, 10.318692F);
      ((Path)localObject2).lineTo(21.781511F, 10.318692F);
      ((Path)localObject2).lineTo(12.50185F, 10.318692F);
      ((Path)localObject2).cubicTo(12.334765F, 10.318692F, 12.287424F, 10.226176F, 12.401548F, 10.112052F);
      ((Path)localObject2).lineTo(12.401548F, 10.112052F);
      ((Path)localObject2).lineTo(14.46407F, 8.049047F);
      ((Path)localObject2).lineTo(19.80274F, 8.049799F);
      ((Path)localObject2).lineTo(19.802071F, 2.710046F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.drawPath((Path)localObject2, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bbk
 * JD-Core Version:    0.7.0.1
 */