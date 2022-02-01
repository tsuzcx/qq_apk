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

public class finder_live_beauty_icon
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
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
      localCanvas.saveLayerAlpha(null, 230, 31);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 2.666667F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(13.333333F, 0.6666667F);
      localPath.cubicTo(16.130625F, 0.6666667F, 18.726723F, 1.528082F, 20.870827F, 3.000114F);
      localPath.cubicTo(20.672939F, 3.258396F, 20.481079F, 3.480102F, 20.294516F, 3.666667F);
      localPath.cubicTo(19.927374F, 4.033808F, 19.424139F, 4.421456F, 18.784813F, 4.82961F);
      localPath.cubicTo(17.189112F, 3.879174F, 15.324966F, 3.333333F, 13.333333F, 3.333333F);
      localPath.cubicTo(7.442296F, 3.333333F, 2.666667F, 8.108963F, 2.666667F, 14.0F);
      localPath.cubicTo(2.666667F, 19.891037F, 7.442296F, 24.666666F, 13.333333F, 24.666666F);
      localPath.cubicTo(19.224371F, 24.666666F, 24.0F, 19.891037F, 24.0F, 14.0F);
      localPath.cubicTo(24.0F, 13.76653F, 23.992498F, 13.534813F, 23.977726F, 13.305075F);
      localPath.cubicTo(24.534388F, 12.008838F, 25.34915F, 11.117908F, 26.199657F, 10.488136F);
      localPath.cubicTo(26.504166F, 11.608049F, 26.666666F, 12.785048F, 26.666666F, 14.0F);
      localPath.cubicTo(26.666666F, 21.363796F, 20.69713F, 27.333334F, 13.333333F, 27.333334F);
      localPath.cubicTo(5.969537F, 27.333334F, 0.0F, 21.363796F, 0.0F, 14.0F);
      localPath.cubicTo(0.0F, 6.636203F, 5.969537F, 0.6666667F, 13.333333F, 0.6666667F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 6.666667F, 0.0F, 1.0F, 9.733333F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(11.333333F, 0.0F);
      ((Path)localObject2).cubicTo(12.437902F, 0.0F, 13.333333F, 0.8954305F, 13.333333F, 2.0F);
      ((Path)localObject2).cubicTo(13.333333F, 3.104569F, 12.437902F, 4.0F, 11.333333F, 4.0F);
      ((Path)localObject2).cubicTo(10.228764F, 4.0F, 9.333333F, 3.104569F, 9.333333F, 2.0F);
      ((Path)localObject2).cubicTo(9.333333F, 0.8954305F, 10.228764F, 0.0F, 11.333333F, 0.0F);
      ((Path)localObject2).lineTo(11.333333F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(2.0F, 0.0F);
      ((Path)localObject2).cubicTo(3.104569F, 0.0F, 4.0F, 0.8954305F, 4.0F, 2.0F);
      ((Path)localObject2).cubicTo(4.0F, 3.104569F, 3.104569F, 4.0F, 2.0F, 4.0F);
      ((Path)localObject2).cubicTo(0.8954305F, 4.0F, 0.0F, 3.104569F, 0.0F, 2.0F);
      ((Path)localObject2).cubicTo(0.0F, 0.8954305F, 0.8954305F, 0.0F, 2.0F, 0.0F);
      ((Path)localObject2).lineTo(2.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(6.666667F, 10.755723F);
      ((Path)localObject2).cubicTo(8.665655F, 10.755723F, 10.32216F, 9.249073F, 10.61923F, 7.333334F);
      ((Path)localObject2).cubicTo(10.393229F, 7.333334F, 2.909993F, 7.333334F, 2.708064F, 7.333334F);
      ((Path)localObject2).cubicTo(2.987994F, 9.268772F, 4.653682F, 10.755723F, 6.666667F, 10.755723F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(23.333334F, 2.0F);
      ((Path)localObject1).cubicTo(23.951733F, 3.396177F, 24.535067F, 4.368399F, 25.083334F, 4.916667F);
      ((Path)localObject1).cubicTo(25.631601F, 5.464934F, 26.603823F, 6.048267F, 28.0F, 6.666667F);
      ((Path)localObject1).cubicTo(26.569643F, 7.319245F, 25.597422F, 7.902579F, 25.083334F, 8.416667F);
      ((Path)localObject1).cubicTo(24.569246F, 8.930755F, 23.985912F, 9.902977F, 23.333334F, 11.333333F);
      ((Path)localObject1).cubicTo(22.672304F, 9.894527F, 22.088972F, 8.922304F, 21.583334F, 8.416667F);
      ((Path)localObject1).cubicTo(21.077696F, 7.911029F, 20.105473F, 7.327695F, 18.666666F, 6.666667F);
      ((Path)localObject1).cubicTo(20.096769F, 6.014341F, 21.068993F, 5.431008F, 21.583334F, 4.916667F);
      ((Path)localObject1).cubicTo(22.097673F, 4.402326F, 22.681007F, 3.430104F, 23.333334F, 2.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_live_beauty_icon
 * JD-Core Version:    0.7.0.1
 */