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

public final class aom
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      ((Paint)localObject2).setColor(-3487030);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 4.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(8.017665F, 0.03940962F);
      localPath.cubicTo(20.378649F, 0.0793706F, 32.739632F, -0.03052212F, 45.09063F, 0.08936086F);
      localPath.cubicTo(48.675114F, 0.0793706F, 51.930107F, 3.306221F, 51.900154F, 6.90271F);
      localPath.cubicTo(52.079876F, 18.591301F, 51.850231F, 30.289883F, 52.0F, 41.988464F);
      localPath.cubicTo(45.999233F, 41.998455F, 39.98848F, 42.008446F, 33.987713F, 41.988464F);
      localPath.lineTo(33.987713F, 36.004307F);
      localPath.cubicTo(36.643623F, 36.014294F, 39.309525F, 35.994316F, 41.975422F, 36.004307F);
      localPath.lineTo(41.975422F, 26.014057F);
      localPath.cubicTo(39.309525F, 26.024046F, 36.63364F, 26.004066F, 33.967743F, 26.014057F);
      localPath.cubicTo(33.967743F, 23.996027F, 33.89785F, 21.958015F, 34.157452F, 19.949976F);
      localPath.cubicTo(35.725037F, 17.262598F, 39.40937F, 18.301584F, 41.975422F, 17.961916F);
      localPath.lineTo(41.975422F, 8.041599F);
      localPath.cubicTo(36.883255F, 8.301346F, 30.832565F, 6.852759F, 26.698925F, 10.659044F);
      localPath.cubicTo(22.53533F, 14.655144F, 24.402458F, 20.909039F, 24.013058F, 26.014057F);
      localPath.lineTo(18.012289F, 26.014057F);
      localPath.lineTo(18.012289F, 36.004307F);
      localPath.lineTo(24.003073F, 36.004307F);
      localPath.cubicTo(24.003073F, 38.002354F, 23.993088F, 39.990414F, 24.003073F, 41.988464F);
      localPath.cubicTo(16.005377F, 41.998455F, 7.997696F, 41.998455F, 0.0F, 41.988464F);
      localPath.cubicTo(0.1298F, 30.319853F, -0.05990784F, 18.641253F, 0.07987711F, 6.972642F);
      localPath.cubicTo(0.03993856F, 2.896621F, 4.033794F, -0.4001613F, 8.017665F, 0.03940962F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 42.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(24.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 9.956265F);
      ((Path)localObject3).cubicTo(17.728153F, 9.787177F, 11.426486F, 10.294439F, 5.184457F, 9.707606F);
      ((Path)localObject3).cubicTo(0.9899726F, 8.543887F, -0.4214416F, 3.908903F, 0.105354F, 0.0F);
      ((Path)localObject3).cubicTo(8.066923F, 0.00994632F, 16.038431F, 0.00994632F, 24.0F, 0.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(34.0F, 0.0F);
      ((Path)localObject2).cubicTo(39.962635F, 0.01989363F, 45.935188F, 0.00994682F, 51.897823F, 0.0F);
      ((Path)localObject2).cubicTo(52.403805F, 3.879258F, 51.074368F, 8.474687F, 46.927311F, 9.678251F);
      ((Path)localObject2).cubicTo(42.651276F, 10.294953F, 38.305798F, 9.80756F, 34.0F, 9.956762F);
      ((Path)localObject2).lineTo(34.0F, 0.0F);
      ((Path)localObject2).lineTo(34.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aom
 * JD-Core Version:    0.7.0.1
 */