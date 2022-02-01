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

public class sight_list_checkbox_selected
  extends c
{
  private final int height = 90;
  private final int width = 90;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 90;
      return 90;
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
      localPaint1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint1.setColor(-2565928);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(45.0F, 12.0F);
      localPath.cubicTo(63.225395F, 12.0F, 78.0F, 26.774603F, 78.0F, 45.0F);
      localPath.cubicTo(78.0F, 63.225395F, 63.225395F, 78.0F, 45.0F, 78.0F);
      localPath.cubicTo(26.774603F, 78.0F, 12.0F, 63.225395F, 12.0F, 45.0F);
      localPath.cubicTo(12.0F, 26.774603F, 26.774603F, 12.0F, 45.0F, 12.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(45.0F, 12.0F);
      localPath.cubicTo(63.225395F, 12.0F, 78.0F, 26.774603F, 78.0F, 45.0F);
      localPath.cubicTo(78.0F, 63.225395F, 63.225395F, 78.0F, 45.0F, 78.0F);
      localPath.cubicTo(26.774603F, 78.0F, 12.0F, 63.225395F, 12.0F, 45.0F);
      localPath.cubicTo(12.0F, 26.774603F, 26.774603F, 12.0F, 45.0F, 12.0F);
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 66.0F, 0.0F, 12.0F, 0.0F, 66.0F, 12.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 0.5F, 0.0F, 0.5F, 1.0F, new int[] { -10560163, -5768183 }, new float[] { 0.0F, 1.0F }, (Matrix)localObject1, 0);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(38.250305F, 53.508274F);
      ((Path)localObject2).lineTo(29.742029F, 45.0F);
      ((Path)localObject2).lineTo(25.49939F, 49.242641F);
      ((Path)localObject2).lineTo(38.22731F, 61.970562F);
      ((Path)localObject2).lineTo(38.283035F, 61.914837F);
      ((Path)localObject2).lineTo(38.30603F, 61.937832F);
      ((Path)localObject2).lineTo(64.621933F, 35.621929F);
      ((Path)localObject2).lineTo(60.379292F, 31.37929F);
      ((Path)localObject2).lineTo(38.250305F, 53.508274F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.sight_list_checkbox_selected
 * JD-Core Version:    0.7.0.1
 */