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

public final class eq
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
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
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
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 2.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 2.364199F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-363518);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(14.047222F, 7.763637F);
      localPath.cubicTo(13.317105F, 9.086945F, 11.402164F, 9.4689F, 9.769939F, 8.616678F);
      localPath.cubicTo(8.137714F, 7.764457F, 7.406192F, 6.000683F, 8.136028F, 4.677102F);
      localPath.cubicTo(8.866145F, 3.353794F, 10.781087F, 2.971839F, 12.413592F, 3.824334F);
      localPath.cubicTo(14.045817F, 4.676555F, 14.77734F, 6.440328F, 14.047222F, 7.763637F);
      localPath.moveTo(14.302398F, 2.890089F);
      localPath.cubicTo(10.474764F, -0.49419F, 4.921883F, -0.615311F, 1.899963F, 2.619686F);
      localPath.cubicTo(-1.121958F, 5.854682F, -0.4685621F, 11.220642F, 3.359073F, 14.604921F);
      localPath.cubicTo(7.186708F, 17.989473F, 12.739588F, 18.110868F, 15.761789F, 14.875872F);
      localPath.cubicTo(18.783428F, 11.640875F, 18.130314F, 6.274641F, 14.302398F, 2.890089F);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 15.969142F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-363518);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(2.052225F, 0.09713904F);
      ((Path)localObject2).cubicTo(3.545621F, -0.2745187F, 5.136534F, 0.8064973F, 5.605293F, 2.511845F);
      ((Path)localObject2).cubicTo(6.074051F, 4.216925F, 5.243044F, 5.900615F, 3.749649F, 6.272273F);
      ((Path)localObject2).cubicTo(2.255972F, 6.64393F, 0.6653396F, 5.562647F, 0.196581F, 3.857567F);
      ((Path)localObject2).cubicTo(-0.272178F, 2.152487F, 0.558548F, 0.4687968F, 2.052225F, 0.09713904F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.eq
 * JD-Core Version:    0.7.0.1
 */