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

public class icons_filled_like
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
      localPaint.setColor(-436207616);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(4.535534F, 5.778174F);
      ((Path)localObject).cubicTo(6.488155F, 3.825553F, 9.65398F, 3.825553F, 11.606602F, 5.778174F);
      ((Path)localObject).cubicTo(11.789409F, 5.960981F, 12.02511F, 6.188341F, 12.313708F, 6.460254F);
      ((Path)localObject).cubicTo(12.602306F, 6.188341F, 12.838009F, 5.960981F, 13.020815F, 5.778174F);
      ((Path)localObject).cubicTo(14.973436F, 3.825553F, 18.139261F, 3.825553F, 20.091883F, 5.778174F);
      ((Path)localObject).cubicTo(22.02634F, 7.712633F, 22.044336F, 10.837829F, 20.145866F, 12.794439F);
      ((Path)localObject).lineTo(13.020779F, 19.920273F);
      ((Path)localObject).cubicTo(12.630311F, 20.310854F, 11.997147F, 20.310888F, 11.606602F, 19.920383F);
      ((Path)localObject).cubicTo(11.606589F, 19.920372F, 11.606577F, 19.920359F, 11.606602F, 19.920311F);
      ((Path)localObject).lineTo(4.481141F, 12.794849F);
      ((Path)localObject).lineTo(4.481141F, 12.794849F);
      ((Path)localObject).cubicTo(2.583082F, 10.837829F, 2.601076F, 7.712633F, 4.535534F, 5.778174F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_like
 * JD-Core Version:    0.7.0.1
 */