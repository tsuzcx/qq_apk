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

public final class lo
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -102.0F, 0.0F, 1.0F, -1105.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.restore();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-8683388);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(27.860264F, 42.224224F);
      localPath.lineTo(16.244278F, 48.809719F);
      localPath.lineTo(11.775919F, 32.292778F);
      localPath.cubicTo(11.293263F, 30.495869F, 11.832553F, 28.662212F, 13.041141F, 27.405102F);
      localPath.lineTo(27.860264F, 42.224224F);
      localPath.close();
      localPath.moveTo(22.487175F, 24.123215F);
      localPath.lineTo(32.122139F, 21.56749F);
      localPath.lineTo(32.157063F, 33.793102F);
      localPath.lineTo(22.487175F, 24.123215F);
      localPath.close();
      localPath.moveTo(58.562431F, 72.926392F);
      localPath.lineTo(62.774803F, 77.138763F);
      localPath.lineTo(51.687485F, 88.06427F);
      localPath.cubicTo(49.648521F, 90.080627F, 46.351482F, 90.080627F, 44.312519F, 88.06427F);
      localPath.lineTo(32.122139F, 76.009048F);
      localPath.lineTo(45.397076F, 68.372643F);
      localPath.cubicTo(47.002213F, 67.428818F, 48.997791F, 67.428818F, 50.646313F, 68.372643F);
      localPath.lineTo(58.562431F, 72.926392F);
      localPath.close();
      localPath.moveTo(72.13884F, 73.774879F);
      localPath.lineTo(63.847919F, 65.483963F);
      localPath.lineTo(63.83448F, 60.77914F);
      localPath.cubicTo(63.83448F, 58.977291F, 64.832268F, 57.261246F, 66.437408F, 56.317421F);
      localPath.lineTo(79.755722F, 48.766819F);
      localPath.lineTo(84.224083F, 65.24086F);
      localPath.cubicTo(84.961578F, 67.986534F, 83.313057F, 70.818008F, 80.536606F, 71.547333F);
      localPath.lineTo(72.13884F, 73.774879F);
      localPath.close();
      localPath.moveTo(32.165524F, 60.822041F);
      localPath.lineTo(32.122139F, 76.009048F);
      localPath.lineTo(15.4634F, 71.590233F);
      localPath.cubicTo(12.686943F, 70.860909F, 11.038423F, 68.029434F, 11.775919F, 65.28376F);
      localPath.lineTo(16.244278F, 48.809719F);
      localPath.lineTo(29.562593F, 56.360321F);
      localPath.cubicTo(31.167734F, 57.261246F, 32.165524F, 58.977291F, 32.165524F, 60.822041F);
      localPath.close();
      localPath.moveTo(63.83448F, 36.754498F);
      localPath.lineTo(63.877865F, 21.56749F);
      localPath.lineTo(80.536606F, 25.986307F);
      localPath.cubicTo(83.313057F, 26.715628F, 84.961578F, 29.547104F, 84.224083F, 32.292778F);
      localPath.lineTo(79.755722F, 48.766819F);
      localPath.lineTo(66.437408F, 41.216217F);
      localPath.cubicTo(64.832268F, 40.315292F, 63.83448F, 38.599247F, 63.83448F, 36.754498F);
      localPath.close();
      localPath.moveTo(45.397076F, 29.203894F);
      localPath.lineTo(32.122139F, 21.56749F);
      localPath.lineTo(44.312519F, 9.512265F);
      localPath.cubicTo(46.351482F, 7.495912F, 49.648521F, 7.495912F, 51.687485F, 9.512265F);
      localPath.lineTo(63.877865F, 21.56749F);
      localPath.lineTo(50.602928F, 29.203894F);
      localPath.cubicTo(48.997791F, 30.147718F, 47.002213F, 30.147718F, 45.397076F, 29.203894F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-8683388);
      arrayOfFloat = c.a(arrayOfFloat, 0.7071068F, -0.7071068F, 48.001785F, 0.7071068F, 0.7071068F, -19.882988F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(2.001786F, 45.401787F);
      ((Path)localObject).cubicTo(2.001786F, 44.904732F, 2.40473F, 44.501785F, 2.901786F, 44.501785F);
      ((Path)localObject).lineTo(93.101784F, 44.501785F);
      ((Path)localObject).cubicTo(93.598839F, 44.501785F, 94.001785F, 44.904732F, 94.001785F, 45.401787F);
      ((Path)localObject).lineTo(94.001785F, 50.601784F);
      ((Path)localObject).cubicTo(94.001785F, 51.098839F, 93.598839F, 51.501785F, 93.101784F, 51.501785F);
      ((Path)localObject).lineTo(2.901786F, 51.501785F);
      ((Path)localObject).cubicTo(2.40473F, 51.501785F, 2.001786F, 51.098839F, 2.001786F, 50.601784F);
      ((Path)localObject).lineTo(2.001786F, 45.401787F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.lo
 * JD-Core Version:    0.7.0.1
 */