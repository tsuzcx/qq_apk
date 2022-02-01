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

public class icons_outlined_camera_on
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(14.35778F, 4.45F);
      ((Path)localObject).lineTo(9.642221F, 4.45F);
      ((Path)localObject).lineTo(7.642221F, 7.45F);
      ((Path)localObject).lineTo(3.2F, 7.45F);
      ((Path)localObject).lineTo(3.2F, 18.049999F);
      ((Path)localObject).lineTo(20.799999F, 18.049999F);
      ((Path)localObject).lineTo(20.799999F, 7.45F);
      ((Path)localObject).lineTo(16.357779F, 7.45F);
      ((Path)localObject).lineTo(14.35778F, 4.45F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.732409F, 3.25F);
      ((Path)localObject).cubicTo(14.899585F, 3.25F, 15.0557F, 3.333551F, 15.148434F, 3.47265F);
      ((Path)localObject).lineTo(17.0F, 6.25F);
      ((Path)localObject).lineTo(21.0F, 6.25F);
      ((Path)localObject).cubicTo(21.552284F, 6.25F, 22.0F, 6.697715F, 22.0F, 7.25F);
      ((Path)localObject).lineTo(22.0F, 18.25F);
      ((Path)localObject).cubicTo(22.0F, 18.802284F, 21.552284F, 19.25F, 21.0F, 19.25F);
      ((Path)localObject).lineTo(3.0F, 19.25F);
      ((Path)localObject).cubicTo(2.447715F, 19.25F, 2.0F, 18.802284F, 2.0F, 18.25F);
      ((Path)localObject).lineTo(2.0F, 7.25F);
      ((Path)localObject).cubicTo(2.0F, 6.697715F, 2.447715F, 6.25F, 3.0F, 6.25F);
      ((Path)localObject).lineTo(7.0F, 6.25F);
      ((Path)localObject).lineTo(8.851566F, 3.47265F);
      ((Path)localObject).cubicTo(8.9443F, 3.333551F, 9.100415F, 3.25F, 9.267592F, 3.25F);
      ((Path)localObject).lineTo(14.732409F, 3.25F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 15.05F);
      ((Path)localObject).cubicTo(13.546397F, 15.05F, 14.8F, 13.796397F, 14.8F, 12.25F);
      ((Path)localObject).cubicTo(14.8F, 10.703603F, 13.546397F, 9.45F, 12.0F, 9.45F);
      ((Path)localObject).cubicTo(10.453603F, 9.45F, 9.2F, 10.703603F, 9.2F, 12.25F);
      ((Path)localObject).cubicTo(9.2F, 13.796397F, 10.453603F, 15.05F, 12.0F, 15.05F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 16.25F);
      ((Path)localObject).cubicTo(9.790861F, 16.25F, 8.0F, 14.459139F, 8.0F, 12.25F);
      ((Path)localObject).cubicTo(8.0F, 10.040861F, 9.790861F, 8.25F, 12.0F, 8.25F);
      ((Path)localObject).cubicTo(14.209139F, 8.25F, 16.0F, 10.040861F, 16.0F, 12.25F);
      ((Path)localObject).cubicTo(16.0F, 14.459139F, 14.209139F, 16.25F, 12.0F, 16.25F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_camera_on
 * JD-Core Version:    0.7.0.1
 */