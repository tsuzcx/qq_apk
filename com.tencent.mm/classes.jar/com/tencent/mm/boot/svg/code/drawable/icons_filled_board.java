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

public class icons_filled_board
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
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(21.0F, 3.0F);
      ((Path)localObject).cubicTo(21.552284F, 3.0F, 22.0F, 3.447715F, 22.0F, 4.0F);
      ((Path)localObject).lineTo(22.0F, 15.0F);
      ((Path)localObject).cubicTo(22.0F, 15.552284F, 21.552284F, 16.0F, 21.0F, 16.0F);
      ((Path)localObject).lineTo(16.098F, 16.0F);
      ((Path)localObject).lineTo(16.964001F, 17.5F);
      ((Path)localObject).lineTo(17.0F, 17.5F);
      ((Path)localObject).lineTo(17.0F, 17.563F);
      ((Path)localObject).lineTo(19.00205F, 21.03109F);
      ((Path)localObject).lineTo(17.27F, 22.03109F);
      ((Path)localObject).lineTo(15.808F, 19.5F);
      ((Path)localObject).lineTo(8.193F, 19.5F);
      ((Path)localObject).lineTo(6.732051F, 22.03109F);
      ((Path)localObject).lineTo(5.0F, 21.03109F);
      ((Path)localObject).lineTo(7.0F, 17.565001F);
      ((Path)localObject).lineTo(7.0F, 17.5F);
      ((Path)localObject).lineTo(7.037F, 17.5F);
      ((Path)localObject).lineTo(7.903F, 16.0F);
      ((Path)localObject).lineTo(3.0F, 16.0F);
      ((Path)localObject).cubicTo(2.447715F, 16.0F, 2.0F, 15.552284F, 2.0F, 15.0F);
      ((Path)localObject).lineTo(2.0F, 4.0F);
      ((Path)localObject).cubicTo(2.0F, 3.447715F, 2.447715F, 3.0F, 3.0F, 3.0F);
      ((Path)localObject).lineTo(21.0F, 3.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(13.787F, 16.0F);
      ((Path)localObject).lineTo(10.214F, 16.0F);
      ((Path)localObject).lineTo(9.348F, 17.5F);
      ((Path)localObject).lineTo(14.653F, 17.5F);
      ((Path)localObject).lineTo(13.787F, 16.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.0F, 5.0F);
      ((Path)localObject).lineTo(4.0F, 5.0F);
      ((Path)localObject).lineTo(4.0F, 14.0F);
      ((Path)localObject).lineTo(20.0F, 14.0F);
      ((Path)localObject).lineTo(20.0F, 5.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_board
 * JD-Core Version:    0.7.0.1
 */