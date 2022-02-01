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

public class voiceinput_icon_button
  extends c
{
  private final int height = 189;
  private final int width = 189;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 189;
      return 189;
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
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-16268960);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(94.5F, 0.0F);
      localPath.cubicTo(146.69092F, 0.0F, 189.0F, 42.30909F, 189.0F, 94.5F);
      localPath.cubicTo(189.0F, 146.69092F, 146.69092F, 189.0F, 94.5F, 189.0F);
      localPath.cubicTo(42.30909F, 189.0F, 0.0F, 146.69092F, 0.0F, 94.5F);
      localPath.cubicTo(0.0F, 42.30909F, 42.30909F, 0.0F, 94.5F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 44.5F, 0.0F, 1.0F, 39.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 0.8660254F, -0.5F, 46.363972F, 0.5F, 0.8660254F, 0.1238961F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(14.281093F, 17.051855F);
      ((Path)localObject2).cubicTo(14.281093F, 7.868282F, 21.725847F, 0.4235266F, 30.90942F, 0.4235266F);
      ((Path)localObject2).lineTo(30.909422F, 0.4235266F);
      ((Path)localObject2).cubicTo(40.092995F, 0.4235266F, 47.53775F, 7.868282F, 47.53775F, 17.051855F);
      ((Path)localObject2).lineTo(47.53775F, 43.997627F);
      ((Path)localObject2).cubicTo(47.53775F, 53.181198F, 40.092995F, 60.625954F, 30.909422F, 60.625954F);
      ((Path)localObject2).lineTo(30.90942F, 60.625954F);
      ((Path)localObject2).cubicTo(21.725847F, 60.625954F, 14.281093F, 53.181198F, 14.281093F, 43.997627F);
      ((Path)localObject2).lineTo(14.281093F, 17.051855F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(7.629761F, 33.86932F);
      ((Path)localObject2).lineTo(7.629761F, 44.035454F);
      ((Path)localObject2).cubicTo(7.629761F, 56.892452F, 18.05242F, 67.315109F, 30.90942F, 67.315109F);
      ((Path)localObject2).cubicTo(43.766418F, 67.315109F, 54.189079F, 56.892452F, 54.189079F, 44.035454F);
      ((Path)localObject2).lineTo(54.189079F, 33.86932F);
      ((Path)localObject2).lineTo(60.840408F, 33.86932F);
      ((Path)localObject2).lineTo(60.840408F, 44.07328F);
      ((Path)localObject2).cubicTo(60.840408F, 60.60371F, 47.43985F, 74.004272F, 30.90942F, 74.004272F);
      ((Path)localObject2).cubicTo(14.378991F, 74.004272F, 0.9784303F, 60.60371F, 0.9784303F, 44.07328F);
      ((Path)localObject2).lineTo(0.9784303F, 33.86932F);
      ((Path)localObject2).lineTo(7.629761F, 33.86932F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(27.583754F, 70.659691F);
      ((Path)localObject2).lineTo(34.235085F, 70.659691F);
      ((Path)localObject2).lineTo(34.235085F, 80.693428F);
      ((Path)localObject2).lineTo(27.583754F, 80.693428F);
      ((Path)localObject2).lineTo(27.583754F, 70.659691F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(27.583754F, 84.03801F);
      ((Path)localObject1).lineTo(34.235085F, 84.03801F);
      ((Path)localObject1).lineTo(31.560646F, 90.282692F);
      ((Path)localObject1).cubicTo(31.406612F, 90.642357F, 30.990179F, 90.809052F, 30.630516F, 90.655014F);
      ((Path)localObject1).cubicTo(30.463182F, 90.583351F, 30.329857F, 90.45002F, 30.258192F, 90.282692F);
      ((Path)localObject1).lineTo(27.583754F, 84.03801F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.voiceinput_icon_button
 * JD-Core Version:    0.7.0.1
 */