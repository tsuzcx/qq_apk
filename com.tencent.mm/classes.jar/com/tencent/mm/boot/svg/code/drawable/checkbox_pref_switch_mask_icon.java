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

public class checkbox_pref_switch_mask_icon
  extends c
{
  private final int height = 24;
  private final int width = 46;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 46;
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
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(419430400);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(12.0F, 0.0F);
      localPath.lineTo(34.0F, 0.0F);
      localPath.cubicTo(40.627419F, -1.217437E-015F, 46.0F, 5.372583F, 46.0F, 12.0F);
      localPath.cubicTo(46.0F, 18.627417F, 40.627419F, 24.0F, 34.0F, 24.0F);
      localPath.lineTo(12.0F, 24.0F);
      localPath.cubicTo(5.372583F, 24.0F, 8.116245E-016F, 18.627417F, 0.0F, 12.0F);
      localPath.cubicTo(-8.116245E-016F, 5.372583F, 5.372583F, 1.217437E-015F, 12.0F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 2.0F);
      ((Path)localObject).cubicTo(17.522848F, 2.0F, 22.0F, 6.477152F, 22.0F, 12.0F);
      ((Path)localObject).cubicTo(22.0F, 17.522848F, 17.522848F, 22.0F, 12.0F, 22.0F);
      ((Path)localObject).cubicTo(6.477152F, 22.0F, 2.0F, 17.522848F, 2.0F, 12.0F);
      ((Path)localObject).cubicTo(2.0F, 6.477152F, 6.477152F, 2.0F, 12.0F, 2.0F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.checkbox_pref_switch_mask_icon
 * JD-Core Version:    0.7.0.1
 */