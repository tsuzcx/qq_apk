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

public class wechat_wallet_authenticate
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.instancePaint((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -107.0F, 0.0F, 1.0F, -102.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 107.0F, 0.0F, 1.0F, 102.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 3.333333F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(12.122681F, 18.976938F);
      ((Path)localObject2).cubicTo(11.972169F, 19.053703F, 11.802728F, 19.098915F, 11.623129F, 19.098915F);
      ((Path)localObject2).cubicTo(11.20622F, 19.098915F, 10.843791F, 18.864853F, 10.653573F, 18.519175F);
      ((Path)localObject2).lineTo(10.581087F, 18.357168F);
      ((Path)localObject2).lineTo(7.546377F, 11.565125F);
      ((Path)localObject2).cubicTo(7.513597F, 11.491185F, 7.493282F, 11.407356F, 7.493282F, 11.325882F);
      ((Path)localObject2).cubicTo(7.493282F, 11.013171F, 7.742135F, 10.7598F, 8.048699F, 10.7598F);
      ((Path)localObject2).cubicTo(8.17428F, 10.7598F, 8.288319F, 10.801714F, 8.38158F, 10.872356F);
      ((Path)localObject2).lineTo(11.962012F, 13.472473F);
      ((Path)localObject2).cubicTo(12.222869F, 13.646725F, 12.536358F, 13.749392F, 12.872471F, 13.749392F);
      ((Path)localObject2).cubicTo(13.072384F, 13.749392F, 13.263987F, 13.711716F, 13.441739F, 13.645311F);
      ((Path)localObject2).lineTo(30.280155F, 6.001319F);
      ((Path)localObject2).cubicTo(27.262066F, 2.372176F, 22.291014F, 0.0F, 16.666204F, 0.0F);
      ((Path)localObject2).cubicTo(7.460964F, 0.0F, 0.0F, 6.343228F, 0.0F, 14.168066F);
      ((Path)localObject2).cubicTo(0.0F, 18.43676F, 2.244291F, 22.280184F, 5.758239F, 24.877474F);
      ((Path)localObject2).cubicTo(6.040334F, 25.082338F, 6.224549F, 25.419067F, 6.224549F, 25.800537F);
      ((Path)localObject2).cubicTo(6.224549F, 25.926752F, 6.199156F, 26.040722F, 6.165914F, 26.161285F);
      ((Path)localObject2).cubicTo(5.885666F, 27.229401F, 5.436439F, 28.93895F, 5.415662F, 29.019482F);
      ((Path)localObject2).cubicTo(5.380574F, 29.152761F, 5.325632F, 29.293104F, 5.325632F, 29.433918F);
      ((Path)localObject2).cubicTo(5.325632F, 29.746159F, 5.574023F, 30.0F, 5.881973F, 30.0F);
      ((Path)localObject2).cubicTo(6.002013F, 30.0F, 6.100354F, 29.954317F, 6.202388F, 29.894978F);
      ((Path)localObject2).lineTo(9.851151F, 27.745562F);
      ((Path)localObject2).cubicTo(10.125396F, 27.584026F, 10.415801F, 27.484184F, 10.736217F, 27.484184F);
      ((Path)localObject2).cubicTo(10.906581F, 27.484184F, 11.071405F, 27.511028F, 11.226072F, 27.559536F);
      ((Path)localObject2).cubicTo(12.928336F, 28.058743F, 14.764952F, 28.336132F, 16.666204F, 28.336132F);
      ((Path)localObject2).cubicTo(25.870985F, 28.336132F, 33.333332F, 21.992905F, 33.333332F, 14.168066F);
      ((Path)localObject2).cubicTo(33.333332F, 11.798716F, 32.644947F, 9.566412F, 31.434389F, 7.603491F);
      ((Path)localObject2).lineTo(12.244568F, 18.904884F);
      ((Path)localObject2).lineTo(12.122681F, 18.976938F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-2565928);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(40.0F, 0.0F);
      ((Path)localObject1).lineTo(40.0F, 40.0F);
      ((Path)localObject1).lineTo(0.0F, 40.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath((Path)localObject1, c.instancePaint(localPaint, paramVarArgs));
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.wechat_wallet_authenticate
 * JD-Core Version:    0.7.0.1
 */