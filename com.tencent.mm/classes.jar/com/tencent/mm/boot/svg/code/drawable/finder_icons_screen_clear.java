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

public class finder_icons_screen_clear
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
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 2.83871F, 0.0F, 1.0F, 3.777778F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      Object localObject4 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject4).setColor(-1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(21.580645F, 12.0F);
      localPath.cubicTo(25.215034F, 12.0F, 28.161291F, 14.959895F, 28.161291F, 18.611111F);
      localPath.cubicTo(28.161291F, 22.262327F, 25.215034F, 25.222221F, 21.580645F, 25.222221F);
      localPath.cubicTo(17.946255F, 25.222221F, 15.0F, 22.262327F, 15.0F, 18.611111F);
      localPath.cubicTo(15.0F, 14.959895F, 17.946255F, 12.0F, 21.580645F, 12.0F);
      localPath.close();
      localPath.moveTo(18.059921F, 14.998893F);
      localPath.cubicTo(17.127178F, 15.916567F, 16.548388F, 17.195934F, 16.548388F, 18.611111F);
      localPath.cubicTo(16.548388F, 21.403217F, 18.801405F, 23.666666F, 21.580645F, 23.666666F);
      localPath.cubicTo(22.393244F, 23.666666F, 23.160856F, 23.473171F, 23.840324F, 23.129541F);
      localPath.close();
      localPath.moveTo(21.580645F, 13.555555F);
      localPath.cubicTo(20.767288F, 13.555555F, 19.998999F, 13.749413F, 19.319061F, 14.093644F);
      localPath.lineTo(25.10137F, 22.22333F);
      localPath.cubicTo(26.034111F, 21.305655F, 26.612904F, 20.026289F, 26.612904F, 18.611111F);
      localPath.cubicTo(26.612904F, 15.819005F, 24.359884F, 13.555555F, 21.580645F, 13.555555F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.16129F, 0.0F, 1.0F, 0.222222F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject3).setColor(-1);
      localObject4 = c.instancePath(paramVarArgs);
      ((Path)localObject4).moveTo(23.333334F, 0.0F);
      ((Path)localObject4).cubicTo(24.069714F, 0.0F, 24.666666F, 0.5969537F, 24.666666F, 1.333333F);
      ((Path)localObject4).lineTo(24.666666F, 13.333333F);
      ((Path)localObject4).lineTo(23.066668F, 13.333333F);
      ((Path)localObject4).lineTo(23.066668F, 1.6F);
      ((Path)localObject4).lineTo(1.6F, 1.6F);
      ((Path)localObject4).lineTo(1.6F, 19.733334F);
      ((Path)localObject4).lineTo(15.955078F, 19.733334F);
      ((Path)localObject4).lineTo(15.955078F, 21.333334F);
      ((Path)localObject4).lineTo(1.333333F, 21.333334F);
      ((Path)localObject4).cubicTo(0.5969537F, 21.333334F, 0.0F, 20.73638F, 0.0F, 20.0F);
      ((Path)localObject4).lineTo(0.0F, 1.333333F);
      ((Path)localObject4).cubicTo(0.0F, 0.5969537F, 0.5969537F, 0.0F, 1.333333F, 0.0F);
      ((Path)localObject4).lineTo(23.333334F, 0.0F);
      ((Path)localObject4).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject4, 1);
      localCanvas.drawPath((Path)localObject4, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      ((Paint)localObject2).setStrokeWidth(1.4F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.SQUARE);
      localObject3 = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 5.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(13.5F, 0.5F);
      ((Path)localObject3).lineTo(0.5F, 0.5F);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(13.638889F, 4.5F);
      ((Path)localObject3).lineTo(0.5F, 4.5F);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(7.5F, 8.5F);
      ((Path)localObject2).lineTo(0.5F, 8.5F);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_icons_screen_clear
 * JD-Core Version:    0.7.0.1
 */