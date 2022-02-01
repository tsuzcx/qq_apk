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

public class icons_outlined_capslock
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.660628F, 2.762998F);
      ((Path)localObject).lineTo(12.707107F, 2.806605F);
      ((Path)localObject).lineTo(21.538647F, 12.839372F);
      ((Path)localObject).cubicTo(21.903502F, 13.25398F, 21.863169F, 13.885859F, 21.448563F, 14.250713F);
      ((Path)localObject).cubicTo(21.265991F, 14.411376F, 21.03113F, 14.5F, 20.787933F, 14.5F);
      ((Path)localObject).lineTo(16.999065F, 14.499699F);
      ((Path)localObject).lineTo(17.0F, 19.5F);
      ((Path)localObject).cubicTo(17.0F, 20.052284F, 16.552284F, 20.5F, 16.0F, 20.5F);
      ((Path)localObject).lineTo(8.0F, 20.5F);
      ((Path)localObject).cubicTo(7.447715F, 20.5F, 7.0F, 20.052284F, 7.0F, 19.5F);
      ((Path)localObject).lineTo(6.999066F, 14.499699F);
      ((Path)localObject).lineTo(3.212066F, 14.5F);
      ((Path)localObject).cubicTo(2.659781F, 14.5F, 2.212066F, 14.052284F, 2.212066F, 13.5F);
      ((Path)localObject).cubicTo(2.212066F, 13.256804F, 2.30069F, 13.021942F, 2.461353F, 12.839372F);
      ((Path)localObject).lineTo(11.249287F, 2.853084F);
      ((Path)localObject).cubicTo(11.614141F, 2.438476F, 12.24602F, 2.398143F, 12.660628F, 2.762998F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 3.816F);
      ((Path)localObject).lineTo(3.654F, 13.3F);
      ((Path)localObject).lineTo(8.198842F, 13.299603F);
      ((Path)localObject).lineTo(8.199F, 19.299F);
      ((Path)localObject).lineTo(15.8F, 19.299F);
      ((Path)localObject).lineTo(15.798841F, 13.299603F);
      ((Path)localObject).lineTo(20.344F, 13.299F);
      ((Path)localObject).lineTo(12.0F, 3.816F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_capslock
 * JD-Core Version:    0.7.0.1
 */