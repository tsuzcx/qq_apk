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

public class app_brand_half_screenc_capsule_bar_close_light
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -29.0F, 0.0F, 1.0F, -29.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 29.0F, 0.0F, 1.0F, 29.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      Paint localPaint2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-1728053249);
      localPaint1.setColor(865572759);
      localPaint1.setStrokeWidth(0.5F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(16.0F, 0.25F);
      localPath.cubicTo(24.698486F, 0.25F, 31.75F, 7.301515F, 31.75F, 16.0F);
      localPath.cubicTo(31.75F, 24.698486F, 24.698486F, 31.75F, 16.0F, 31.75F);
      localPath.cubicTo(7.301515F, 31.75F, 0.25F, 24.698486F, 0.25F, 16.0F);
      localPath.cubicTo(0.25F, 7.301515F, 7.301515F, 0.25F, 16.0F, 0.25F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-436207616);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(6.0F, 4.8F);
      ((Path)localObject2).lineTo(10.8F, 0.0F);
      ((Path)localObject2).lineTo(12.0F, 1.2F);
      ((Path)localObject2).lineTo(7.2F, 6.0F);
      ((Path)localObject2).lineTo(12.0F, 10.8F);
      ((Path)localObject2).lineTo(10.8F, 12.0F);
      ((Path)localObject2).lineTo(6.0F, 7.2F);
      ((Path)localObject2).lineTo(1.2F, 12.0F);
      ((Path)localObject2).lineTo(0.0F, 10.8F);
      ((Path)localObject2).lineTo(4.8F, 6.0F);
      ((Path)localObject2).lineTo(0.0F, 1.2F);
      ((Path)localObject2).lineTo(1.2F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_half_screenc_capsule_bar_close_light
 * JD-Core Version:    0.7.0.1
 */