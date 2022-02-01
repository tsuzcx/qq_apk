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

public class finder_live_olympic_cert_bubble_bg
  extends c
{
  private final int height = 48;
  private final int width = 227;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 227;
      return 48;
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -13.0F, 0.0F, 1.0F, -14.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-2960686);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(234.0F, 14.0F);
      ((Path)localObject2).cubicTo(237.31371F, 14.0F, 240.0F, 16.686291F, 240.0F, 20.0F);
      ((Path)localObject2).lineTo(240.0F, 52.0F);
      ((Path)localObject2).cubicTo(240.0F, 55.313709F, 237.31371F, 58.0F, 234.0F, 58.0F);
      ((Path)localObject2).lineTo(130.73199F, 58.0F);
      ((Path)localObject2).lineTo(127.72231F, 61.01123F);
      ((Path)localObject2).cubicTo(127.09024F, 61.643299F, 126.06545F, 61.643299F, 125.43339F, 61.01123F);
      ((Path)localObject2).lineTo(122.423F, 58.0F);
      ((Path)localObject2).lineTo(19.0F, 58.0F);
      ((Path)localObject2).cubicTo(15.686292F, 58.0F, 13.0F, 55.313709F, 13.0F, 52.0F);
      ((Path)localObject2).lineTo(13.0F, 20.0F);
      ((Path)localObject2).cubicTo(13.0F, 16.686291F, 15.686292F, 14.0F, 19.0F, 14.0F);
      ((Path)localObject2).lineTo(234.0F, 14.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_live_olympic_cert_bubble_bg
 * JD-Core Version:    0.7.0.1
 */