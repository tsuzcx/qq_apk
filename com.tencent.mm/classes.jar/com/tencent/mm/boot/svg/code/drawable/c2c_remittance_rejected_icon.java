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

public class c2c_remittance_rejected_icon
  extends c
{
  private final int height = 30;
  private final int width = 30;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 30;
      return 30;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -2.0F, 0.0F, 1.0F, -2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(17.0F, 2.833333F);
      localPath.cubicTo(24.824034F, 2.833333F, 31.166666F, 9.175966F, 31.166666F, 17.0F);
      localPath.cubicTo(31.166666F, 24.824034F, 24.824034F, 31.166666F, 17.0F, 31.166666F);
      localPath.cubicTo(9.175966F, 31.166666F, 2.833333F, 24.824034F, 2.833333F, 17.0F);
      localPath.cubicTo(2.833333F, 9.175966F, 9.175966F, 2.833333F, 17.0F, 2.833333F);
      localPath.close();
      localPath.moveTo(17.0F, 4.533333F);
      localPath.cubicTo(10.11485F, 4.533333F, 4.533333F, 10.11485F, 4.533333F, 17.0F);
      localPath.cubicTo(4.533333F, 23.885149F, 10.11485F, 29.466667F, 17.0F, 29.466667F);
      localPath.cubicTo(23.885149F, 29.466667F, 29.466667F, 23.885149F, 29.466667F, 17.0F);
      localPath.cubicTo(29.466667F, 10.11485F, 23.885149F, 4.533333F, 17.0F, 4.533333F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, 0.7071068F, -7.406223F, -0.7071068F, 0.7071068F, 16.220474F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(20.126734F, 12.80034F);
      ((Path)localObject1).lineTo(20.126734F, 14.50034F);
      ((Path)localObject1).lineTo(13.326735F, 14.50034F);
      ((Path)localObject1).lineTo(13.326735F, 21.300341F);
      ((Path)localObject1).lineTo(11.626735F, 21.300341F);
      ((Path)localObject1).lineTo(11.626735F, 14.217007F);
      ((Path)localObject1).cubicTo(11.626735F, 13.434603F, 12.260998F, 12.80034F, 13.043402F, 12.80034F);
      ((Path)localObject1).lineTo(20.126734F, 12.80034F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(11.333333F, 16.15F);
      ((Path)localObject2).lineTo(24.083332F, 16.15F);
      ((Path)localObject2).lineTo(24.083332F, 17.85F);
      ((Path)localObject2).lineTo(11.333333F, 17.85F);
      ((Path)localObject2).lineTo(11.333333F, 16.15F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.c2c_remittance_rejected_icon
 * JD-Core Version:    0.7.0.1
 */