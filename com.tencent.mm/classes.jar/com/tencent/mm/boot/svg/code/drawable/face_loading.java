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

public class face_loading
  extends c
{
  private final int height = 168;
  private final int width = 168;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 168;
      return 168;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.BUTT);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localPaint1.setStrokeMiter(4.0F);
      localPaint1.setPathEffect(null);
      c.instancePaint(localPaint1, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 230, 31);
      localCanvas.save();
      localPaint1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(84.0F, 0.0F);
      localPath.cubicTo(130.39192F, 0.0F, 168.0F, 37.608082F, 168.0F, 84.0F);
      localPath.cubicTo(168.0F, 130.39192F, 130.39192F, 168.0F, 84.0F, 168.0F);
      localPath.lineTo(84.0F, 153.3F);
      localPath.cubicTo(122.27333F, 153.3F, 153.3F, 122.27333F, 153.3F, 84.0F);
      localPath.cubicTo(153.3F, 45.726665F, 122.27333F, 14.7F, 84.0F, 14.7F);
      localPath.lineTo(84.0F, 0.0F);
      localPath.close();
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      Paint localPaint3 = c.instancePaint(paramVarArgs);
      localPaint3.setFlags(385);
      localPaint3.setStyle(Paint.Style.STROKE);
      localPaint2.setColor(-16777216);
      localPaint3.setStrokeWidth(1.0F);
      localPaint3.setStrokeCap(Paint.Cap.BUTT);
      localPaint3.setStrokeJoin(Paint.Join.MITER);
      localPaint3.setStrokeMiter(4.0F);
      localPaint3.setPathEffect(null);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 168.0F, 0.0F, 84.0F, 0.0F, 168.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 0.9408692F, 0.0F, 0.9408692F, 0.9055908F, new int[] { 15592941, 1290661357 }, new float[] { 0.0F, 1.0F }, (Matrix)localObject1, 0);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(84.0F, 0.0F);
      localPath.lineTo(84.0F, 14.7F);
      localPath.cubicTo(45.726665F, 14.7F, 14.7F, 45.726665F, 14.7F, 84.0F);
      localPath.cubicTo(14.7F, 122.27333F, 45.726665F, 153.3F, 84.0F, 153.3F);
      localPath.lineTo(84.0F, 168.0F);
      localPath.cubicTo(37.608082F, 168.0F, 0.0F, 130.39192F, 0.0F, 84.0F);
      localPath.cubicTo(0.0F, 37.608082F, 37.608082F, 0.0F, 84.0F, 0.0F);
      localPath.close();
      localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      localPaint3 = c.instancePaint(paramVarArgs);
      localPaint3.setFlags(385);
      localPaint3.setStyle(Paint.Style.STROKE);
      localPaint2.setColor(-16777216);
      localPaint3.setStrokeWidth(1.0F);
      localPaint3.setStrokeCap(Paint.Cap.BUTT);
      localPaint3.setStrokeJoin(Paint.Join.MITER);
      localPaint3.setStrokeMiter(4.0F);
      localPaint3.setPathEffect(null);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 84.0F, 0.0F, 0.0F, 0.0F, 168.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 1.0F, 0.08673706F, 1.0F, 0.906287F, new int[] { -1184275, 1290661357 }, new float[] { 0.0F, 1.0F }, (Matrix)localObject1, 0);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-1184275);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(85.050003F, 0.0F);
      ((Path)localObject2).cubicTo(89.109299F, 0.0F, 92.400002F, 3.290707F, 92.400002F, 7.35F);
      ((Path)localObject2).cubicTo(92.400002F, 11.409293F, 89.109299F, 14.7F, 85.050003F, 14.7F);
      ((Path)localObject2).cubicTo(80.990707F, 14.7F, 77.700005F, 11.409293F, 77.700005F, 7.35F);
      ((Path)localObject2).cubicTo(77.700005F, 3.290707F, 80.990707F, 0.0F, 85.050003F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.face_loading
 * JD-Core Version:    0.7.0.1
 */