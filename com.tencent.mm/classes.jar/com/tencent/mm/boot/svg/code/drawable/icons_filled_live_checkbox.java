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

public class icons_filled_live_checkbox
  extends c
{
  private final int height = 16;
  private final int width = 16;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 16;
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
      ((Paint)localObject).setColor(-40634);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(16.0F, 8.098765F);
      localPath.cubicTo(16.0F, 3.58163F, 12.41837F, 0.0F, 7.901235F, 0.0F);
      localPath.cubicTo(3.58163F, 0.0F, 0.0F, 3.58163F, 0.0F, 8.098765F);
      localPath.cubicTo(0.0F, 12.41837F, 3.58163F, 16.0F, 7.901235F, 16.0F);
      localPath.cubicTo(12.41837F, 16.0F, 16.0F, 12.41837F, 16.0F, 8.098765F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(6.909308F, 10.209139F);
      ((Path)localObject).lineTo(4.707107F, 8.006938F);
      ((Path)localObject).lineTo(4.0F, 8.714046F);
      ((Path)localObject).lineTo(6.437903F, 11.151948F);
      ((Path)localObject).cubicTo(6.698252F, 11.412297F, 7.120362F, 11.412297F, 7.380712F, 11.151948F);
      ((Path)localObject).lineTo(12.49222F, 6.04044F);
      ((Path)localObject).lineTo(12.49222F, 6.04044F);
      ((Path)localObject).lineTo(11.785113F, 5.333334F);
      ((Path)localObject).lineTo(6.909308F, 10.209139F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_live_checkbox
 * JD-Core Version:    0.7.0.1
 */