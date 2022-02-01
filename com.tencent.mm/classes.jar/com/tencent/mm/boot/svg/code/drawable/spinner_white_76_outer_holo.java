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

public class spinner_white_76_outer_holo
  extends c
{
  private final int height = 228;
  private final int width = 228;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 228;
      return 228;
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
      localPath.moveTo(114.0F, 0.0F);
      localPath.cubicTo(176.96046F, 0.0F, 228.0F, 51.039539F, 228.0F, 114.0F);
      localPath.cubicTo(228.0F, 176.96046F, 176.96046F, 228.0F, 114.0F, 228.0F);
      localPath.lineTo(114.0F, 208.05F);
      localPath.cubicTo(165.94238F, 208.05F, 208.05F, 165.94238F, 208.05F, 114.0F);
      localPath.cubicTo(208.05F, 62.057621F, 165.94238F, 19.950001F, 114.0F, 19.950001F);
      localPath.lineTo(114.0F, 0.0F);
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 228.0F, 0.0F, 114.0F, 0.0F, 228.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 0.9408692F, 0.0F, 0.9408692F, 0.9055908F, new int[] { 15592941, 1290661357 }, new float[] { 0.0F, 1.0F }, (Matrix)localObject1, 0);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(114.0F, 0.0F);
      localPath.lineTo(114.0F, 19.950001F);
      localPath.cubicTo(62.057621F, 19.950001F, 19.950001F, 62.057621F, 19.950001F, 114.0F);
      localPath.cubicTo(19.950001F, 165.94238F, 62.057621F, 208.05F, 114.0F, 208.05F);
      localPath.lineTo(114.0F, 228.0F);
      localPath.cubicTo(51.039539F, 228.0F, 0.0F, 176.96046F, 0.0F, 114.0F);
      localPath.cubicTo(0.0F, 51.039539F, 51.039539F, 0.0F, 114.0F, 0.0F);
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 114.0F, 0.0F, 0.0F, 0.0F, 228.0F, 0.0F, 0.0F, 0.0F, 1.0F);
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
      ((Path)localObject2).moveTo(115.425F, 0.0F);
      ((Path)localObject2).cubicTo(120.93404F, 0.0F, 125.4F, 4.46596F, 125.4F, 9.975F);
      ((Path)localObject2).cubicTo(125.4F, 15.484041F, 120.93404F, 19.950001F, 115.425F, 19.950001F);
      ((Path)localObject2).cubicTo(109.91596F, 19.950001F, 105.45F, 15.484041F, 105.45F, 9.975F);
      ((Path)localObject2).cubicTo(105.45F, 4.46596F, 109.91596F, 0.0F, 115.425F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.spinner_white_76_outer_holo
 * JD-Core Version:    0.7.0.1
 */