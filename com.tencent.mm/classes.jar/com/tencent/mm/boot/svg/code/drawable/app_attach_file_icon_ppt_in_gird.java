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

public class app_attach_file_icon_ppt_in_gird
  extends c
{
  private final int height = 80;
  private final int width = 80;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 80;
      return 80;
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(26.302921F, 41.794167F);
      ((Path)localObject).lineTo(26.302921F, 19.211407F);
      ((Path)localObject).lineTo(42.211685F, 19.211407F);
      ((Path)localObject).cubicTo(45.428864F, 19.211407F, 48.290138F, 20.02573F, 49.282246F, 20.948542F);
      ((Path)localObject).cubicTo(51.91206F, 23.283072F, 54.585167F, 22.735918F, 54.585167F, 29.634218F);
      ((Path)localObject).cubicTo(54.585167F, 36.532516F, 51.91206F, 37.732571F, 49.282246F, 40.05703F);
      ((Path)localObject).cubicTo(48.290138F, 41.038528F, 45.428864F, 41.840698F, 42.211685F, 41.794167F);
      ((Path)localObject).lineTo(26.302921F, 41.794167F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(21.0F, 14.0F);
      ((Path)localObject).lineTo(21.0F, 66.114059F);
      ((Path)localObject).lineTo(26.302921F, 66.114059F);
      ((Path)localObject).lineTo(26.302921F, 47.005573F);
      ((Path)localObject).lineTo(43.979324F, 47.005573F);
      ((Path)localObject).cubicTo(49.142723F, 47.143589F, 53.855812F, 44.454838F, 56.352806F, 41.794167F);
      ((Path)localObject).cubicTo(58.849804F, 39.133495F, 59.888088F, 35.379871F, 59.888088F, 31.371353F);
      ((Path)localObject).cubicTo(59.888088F, 25.94755F, 58.535789F, 22.28079F, 56.352806F, 19.211407F);
      ((Path)localObject).cubicTo(53.8633F, 15.711034F, 49.142723F, 14.0F, 43.979324F, 14.0F);
      ((Path)localObject).lineTo(21.0F, 14.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_ppt_in_gird
 * JD-Core Version:    0.7.0.1
 */