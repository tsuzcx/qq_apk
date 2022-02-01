package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class icons_outlined_transfer_text
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 9.0F);
      ((Path)localObject).lineTo(60.0F, 9.0F);
      ((Path)localObject).cubicTo(61.656853F, 9.0F, 63.0F, 10.343145F, 63.0F, 12.0F);
      ((Path)localObject).lineTo(63.0F, 60.0F);
      ((Path)localObject).cubicTo(63.0F, 61.656853F, 61.656853F, 63.0F, 60.0F, 63.0F);
      ((Path)localObject).lineTo(12.0F, 63.0F);
      ((Path)localObject).cubicTo(10.343145F, 63.0F, 9.0F, 61.656853F, 9.0F, 60.0F);
      ((Path)localObject).lineTo(9.0F, 12.0F);
      ((Path)localObject).cubicTo(9.0F, 10.343145F, 10.343145F, 9.0F, 12.0F, 9.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.6F, 12.6F);
      ((Path)localObject).lineTo(12.6F, 59.400002F);
      ((Path)localObject).lineTo(59.400002F, 59.400002F);
      ((Path)localObject).lineTo(59.400002F, 12.6F);
      ((Path)localObject).lineTo(12.6F, 12.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(22.709999F, 26.58F);
      ((Path)localObject).lineTo(34.59F, 26.58F);
      ((Path)localObject).cubicTo(33.84F, 25.200001F, 32.91F, 23.91F, 31.83F, 22.68F);
      ((Path)localObject).lineTo(34.98F, 21.540001F);
      ((Path)localObject).cubicTo(36.060001F, 22.950001F, 37.049999F, 24.629999F, 37.950001F, 26.58F);
      ((Path)localObject).lineTo(49.290001F, 26.58F);
      ((Path)localObject).lineTo(49.290001F, 29.700001F);
      ((Path)localObject).lineTo(44.759998F, 29.700001F);
      ((Path)localObject).cubicTo(43.32F, 34.200001F, 41.220001F, 37.950001F, 38.459999F, 40.98F);
      ((Path)localObject).cubicTo(41.549999F, 43.439999F, 45.389999F, 45.48F, 49.950001F, 47.16F);
      ((Path)localObject).lineTo(48.209999F, 49.830002F);
      ((Path)localObject).cubicTo(43.41F, 48.029999F, 39.419998F, 45.810001F, 36.240002F, 43.169998F);
      ((Path)localObject).cubicTo(32.880001F, 46.139999F, 28.74F, 48.330002F, 23.85F, 49.709999F);
      ((Path)localObject).lineTo(22.17F, 46.950001F);
      ((Path)localObject).cubicTo(26.940001F, 45.720001F, 30.9F, 43.799999F, 34.02F, 41.16F);
      ((Path)localObject).cubicTo(30.780001F, 37.860001F, 28.530001F, 34.049999F, 27.27F, 29.700001F);
      ((Path)localObject).lineTo(22.709999F, 29.700001F);
      ((Path)localObject).lineTo(22.709999F, 26.58F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(30.27F, 29.700001F);
      ((Path)localObject).cubicTo(31.5F, 33.240002F, 33.48F, 36.330002F, 36.240002F, 39.029999F);
      ((Path)localObject).cubicTo(38.580002F, 36.450001F, 40.349998F, 33.330002F, 41.52F, 29.700001F);
      ((Path)localObject).lineTo(30.27F, 29.700001F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_transfer_text
 * JD-Core Version:    0.7.0.1
 */