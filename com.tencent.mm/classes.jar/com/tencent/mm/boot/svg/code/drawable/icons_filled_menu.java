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

public class icons_filled_menu
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
      localCanvas.saveLayerAlpha(null, 230, 31);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(10.0F, 0.0F);
      ((Path)localObject2).cubicTo(15.522847F, 0.0F, 20.0F, 4.477152F, 20.0F, 10.0F);
      ((Path)localObject2).cubicTo(20.0F, 15.522847F, 15.522847F, 20.0F, 10.0F, 20.0F);
      ((Path)localObject2).cubicTo(4.477152F, 20.0F, 0.0F, 15.522847F, 0.0F, 10.0F);
      ((Path)localObject2).cubicTo(0.0F, 4.477152F, 4.477152F, 0.0F, 10.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(6.199F, 12.799F);
      ((Path)localObject2).lineTo(5.0F, 12.8F);
      ((Path)localObject2).lineTo(5.0F, 14.0F);
      ((Path)localObject2).lineTo(6.199F, 13.999F);
      ((Path)localObject2).lineTo(6.199F, 12.799F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(15.0F, 12.8F);
      ((Path)localObject2).lineTo(7.199F, 12.799F);
      ((Path)localObject2).lineTo(7.199F, 13.999F);
      ((Path)localObject2).lineTo(15.0F, 14.0F);
      ((Path)localObject2).lineTo(15.0F, 12.8F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(6.199F, 9.4F);
      ((Path)localObject2).lineTo(5.0F, 9.4F);
      ((Path)localObject2).lineTo(5.0F, 10.6F);
      ((Path)localObject2).lineTo(6.199F, 10.6F);
      ((Path)localObject2).lineTo(6.199F, 9.4F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(15.0F, 9.4F);
      ((Path)localObject2).lineTo(7.199F, 9.4F);
      ((Path)localObject2).lineTo(7.199F, 10.6F);
      ((Path)localObject2).lineTo(15.0F, 10.6F);
      ((Path)localObject2).lineTo(15.0F, 9.4F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(15.0F, 6.0F);
      ((Path)localObject2).lineTo(7.2F, 6.0F);
      ((Path)localObject2).lineTo(7.199F, 7.199F);
      ((Path)localObject2).lineTo(15.0F, 7.2F);
      ((Path)localObject2).lineTo(15.0F, 6.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(5.0F, 6.0F);
      ((Path)localObject2).lineTo(5.0F, 7.2F);
      ((Path)localObject2).lineTo(6.199F, 7.199F);
      ((Path)localObject2).lineTo(6.2F, 6.0F);
      ((Path)localObject2).lineTo(5.0F, 6.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_menu
 * JD-Core Version:    0.7.0.1
 */