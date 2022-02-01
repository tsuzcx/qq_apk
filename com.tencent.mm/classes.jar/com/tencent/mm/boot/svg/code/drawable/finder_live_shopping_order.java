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

public class finder_live_shopping_order
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
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
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(11.4F, 0.6F);
      ((Path)localObject2).cubicTo(11.731371F, 0.6F, 12.0F, 0.8686292F, 12.0F, 1.2F);
      ((Path)localObject2).lineTo(11.999F, 2.099F);
      ((Path)localObject2).lineTo(14.5F, 2.1F);
      ((Path)localObject2).cubicTo(15.328427F, 2.1F, 16.0F, 2.771573F, 16.0F, 3.6F);
      ((Path)localObject2).lineTo(16.0F, 19.1F);
      ((Path)localObject2).cubicTo(16.0F, 19.928427F, 15.328427F, 20.6F, 14.5F, 20.6F);
      ((Path)localObject2).lineTo(1.5F, 20.6F);
      ((Path)localObject2).cubicTo(0.6715729F, 20.6F, -1.652012E-013F, 19.928427F, -1.652012E-013F, 19.1F);
      ((Path)localObject2).lineTo(-1.652012E-013F, 3.6F);
      ((Path)localObject2).cubicTo(-1.652012E-013F, 2.771573F, 0.6715729F, 2.1F, 1.5F, 2.1F);
      ((Path)localObject2).lineTo(3.999F, 2.099F);
      ((Path)localObject2).lineTo(4.0F, 1.2F);
      ((Path)localObject2).cubicTo(4.0F, 0.8686292F, 4.268629F, 0.6F, 4.6F, 0.6F);
      ((Path)localObject2).cubicTo(4.931371F, 0.6F, 5.2F, 0.8686292F, 5.2F, 1.2F);
      ((Path)localObject2).lineTo(5.199F, 2.099F);
      ((Path)localObject2).lineTo(10.799F, 2.099F);
      ((Path)localObject2).lineTo(10.8F, 1.2F);
      ((Path)localObject2).cubicTo(10.8F, 0.8686292F, 11.068629F, 0.6F, 11.4F, 0.6F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(10.799F, 3.299F);
      ((Path)localObject2).lineTo(5.199F, 3.299F);
      ((Path)localObject2).lineTo(5.2F, 4.5F);
      ((Path)localObject2).cubicTo(5.2F, 4.831371F, 4.931371F, 5.1F, 4.6F, 5.1F);
      ((Path)localObject2).cubicTo(4.268629F, 5.1F, 4.0F, 4.831371F, 4.0F, 4.5F);
      ((Path)localObject2).lineTo(3.999F, 3.299F);
      ((Path)localObject2).lineTo(1.5F, 3.3F);
      ((Path)localObject2).cubicTo(1.334315F, 3.3F, 1.2F, 3.434315F, 1.2F, 3.6F);
      ((Path)localObject2).lineTo(1.2F, 19.1F);
      ((Path)localObject2).cubicTo(1.2F, 19.265686F, 1.334315F, 19.4F, 1.5F, 19.4F);
      ((Path)localObject2).lineTo(14.5F, 19.4F);
      ((Path)localObject2).cubicTo(14.665686F, 19.4F, 14.8F, 19.265686F, 14.8F, 19.1F);
      ((Path)localObject2).lineTo(14.8F, 3.6F);
      ((Path)localObject2).cubicTo(14.8F, 3.434315F, 14.665686F, 3.3F, 14.5F, 3.3F);
      ((Path)localObject2).lineTo(11.999F, 3.299F);
      ((Path)localObject2).lineTo(12.0F, 4.5F);
      ((Path)localObject2).cubicTo(12.0F, 4.831371F, 11.731371F, 5.1F, 11.4F, 5.1F);
      ((Path)localObject2).cubicTo(11.068629F, 5.1F, 10.8F, 4.831371F, 10.8F, 4.5F);
      ((Path)localObject2).lineTo(10.799F, 3.299F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.4F, 12.6F);
      ((Path)localObject2).cubicTo(12.731371F, 12.6F, 13.0F, 12.868629F, 13.0F, 13.2F);
      ((Path)localObject2).cubicTo(13.0F, 13.531371F, 12.731371F, 13.8F, 12.4F, 13.8F);
      ((Path)localObject2).lineTo(3.6F, 13.8F);
      ((Path)localObject2).cubicTo(3.268629F, 13.8F, 3.0F, 13.531371F, 3.0F, 13.2F);
      ((Path)localObject2).cubicTo(3.0F, 12.868629F, 3.268629F, 12.6F, 3.6F, 12.6F);
      ((Path)localObject2).lineTo(12.4F, 12.6F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.4F, 9.1F);
      ((Path)localObject2).cubicTo(12.731371F, 9.1F, 13.0F, 9.36863F, 13.0F, 9.7F);
      ((Path)localObject2).cubicTo(13.0F, 10.031371F, 12.731371F, 10.3F, 12.4F, 10.3F);
      ((Path)localObject2).lineTo(3.6F, 10.3F);
      ((Path)localObject2).cubicTo(3.268629F, 10.3F, 3.0F, 10.031371F, 3.0F, 9.7F);
      ((Path)localObject2).cubicTo(3.0F, 9.36863F, 3.268629F, 9.1F, 3.6F, 9.1F);
      ((Path)localObject2).lineTo(12.4F, 9.1F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_live_shopping_order
 * JD-Core Version:    0.7.0.1
 */