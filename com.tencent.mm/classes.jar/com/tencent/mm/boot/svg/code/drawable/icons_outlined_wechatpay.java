package com.tencent.mm.boot.svg.code.drawable;

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

public class icons_outlined_wechatpay
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(30.0F, 0.0F);
      ((Path)localObject2).cubicTo(46.568542F, 0.0F, 60.0F, 11.404438F, 60.0F, 25.472527F);
      ((Path)localObject2).cubicTo(60.0F, 39.540615F, 46.568542F, 50.945053F, 30.0F, 50.945053F);
      ((Path)localObject2).cubicTo(26.61305F, 50.945053F, 23.357191F, 50.468487F, 20.320362F, 49.590019F);
      ((Path)localObject2).lineTo(11.421126F, 53.852699F);
      ((Path)localObject2).cubicTo(11.157928F, 53.978771F, 10.863624F, 54.025394F, 10.574291F, 53.986851F);
      ((Path)localObject2).cubicTo(9.753134F, 53.877464F, 9.176225F, 53.123825F, 9.285729F, 52.303555F);
      ((Path)localObject2).lineTo(10.302671F, 44.68589F);
      ((Path)localObject2).cubicTo(3.989763F, 40.01606F, 0.0F, 33.139908F, 0.0F, 25.472527F);
      ((Path)localObject2).cubicTo(0.0F, 11.404438F, 13.431458F, 0.0F, 30.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(30.0F, 3.6F);
      ((Path)localObject2).cubicTo(15.301022F, 3.6F, 3.6F, 13.535152F, 3.6F, 25.472527F);
      ((Path)localObject2).cubicTo(3.6F, 31.746346F, 6.826998F, 37.636932F, 12.443596F, 41.791683F);
      ((Path)localObject2).lineTo(14.152247F, 43.055618F);
      ((Path)localObject2).lineTo(13.368248F, 48.928364F);
      ((Path)localObject2).lineTo(20.002657F, 45.750523F);
      ((Path)localObject2).lineTo(21.320723F, 46.131802F);
      ((Path)localObject2).cubicTo(24.084929F, 46.931404F, 27.006273F, 47.345051F, 30.0F, 47.345051F);
      ((Path)localObject2).cubicTo(44.698978F, 47.345051F, 56.400002F, 37.409901F, 56.400002F, 25.472527F);
      ((Path)localObject2).cubicTo(56.400002F, 21.823044F, 55.306374F, 18.360697F, 53.367802F, 15.31216F);
      ((Path)localObject2).lineTo(22.040222F, 34.051979F);
      ((Path)localObject2).lineTo(21.820826F, 34.181679F);
      ((Path)localObject2).cubicTo(21.549904F, 34.319855F, 21.244909F, 34.401234F, 20.921633F, 34.401234F);
      ((Path)localObject2).cubicTo(20.171196F, 34.401234F, 19.518824F, 33.979923F, 19.176432F, 33.357704F);
      ((Path)localObject2).lineTo(19.045958F, 33.06609F);
      ((Path)localObject2).lineTo(13.583479F, 20.840412F);
      ((Path)localObject2).cubicTo(13.524474F, 20.707321F, 13.487908F, 20.556429F, 13.487908F, 20.409775F);
      ((Path)localObject2).cubicTo(13.487908F, 19.846895F, 13.935843F, 19.390827F, 14.487659F, 19.390827F);
      ((Path)localObject2).cubicTo(14.713704F, 19.390827F, 14.918973F, 19.466274F, 15.086844F, 19.59343F);
      ((Path)localObject2).lineTo(21.531622F, 24.27364F);
      ((Path)localObject2).cubicTo(22.001163F, 24.587292F, 22.565445F, 24.772093F, 23.170448F, 24.772093F);
      ((Path)localObject2).cubicTo(23.530293F, 24.772093F, 23.875177F, 24.704277F, 24.195129F, 24.584749F);
      ((Path)localObject2).lineTo(51.223049F, 12.48385F);
      ((Path)localObject2).cubicTo(46.433304F, 7.118606F, 38.747524F, 3.6F, 30.0F, 3.6F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_wechatpay
 * JD-Core Version:    0.7.0.1
 */