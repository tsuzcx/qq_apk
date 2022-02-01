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

public class app_brand_star_delete
  extends c
{
  private final int height = 20;
  private final int width = 20;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 20;
      return 20;
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
      localPaint.setColor(-772816);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(10.0F, 0.0F);
      ((Path)localObject).cubicTo(15.522847F, 0.0F, 20.0F, 4.477152F, 20.0F, 10.0F);
      ((Path)localObject).cubicTo(20.0F, 15.522847F, 15.522847F, 20.0F, 10.0F, 20.0F);
      ((Path)localObject).cubicTo(4.477152F, 20.0F, 0.0F, 15.522847F, 0.0F, 10.0F);
      ((Path)localObject).cubicTo(0.0F, 4.477152F, 4.477152F, 0.0F, 10.0F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.0F, 9.5F);
      ((Path)localObject).lineTo(6.0F, 9.5F);
      ((Path)localObject).cubicTo(5.723857F, 9.5F, 5.5F, 9.723858F, 5.5F, 10.0F);
      ((Path)localObject).cubicTo(5.5F, 10.276142F, 5.723857F, 10.5F, 6.0F, 10.5F);
      ((Path)localObject).lineTo(6.0F, 10.5F);
      ((Path)localObject).lineTo(14.0F, 10.5F);
      ((Path)localObject).cubicTo(14.276142F, 10.5F, 14.5F, 10.276142F, 14.5F, 10.0F);
      ((Path)localObject).cubicTo(14.5F, 9.723858F, 14.276142F, 9.5F, 14.0F, 9.5F);
      ((Path)localObject).lineTo(14.0F, 9.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_star_delete
 * JD-Core Version:    0.7.0.1
 */