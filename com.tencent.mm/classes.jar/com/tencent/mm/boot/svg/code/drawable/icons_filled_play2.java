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

public class icons_filled_play2
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
      ((Path)localObject).moveTo(12.0F, 2.0F);
      ((Path)localObject).cubicTo(17.522848F, 2.0F, 22.0F, 6.477152F, 22.0F, 12.0F);
      ((Path)localObject).cubicTo(22.0F, 17.522848F, 17.522848F, 22.0F, 12.0F, 22.0F);
      ((Path)localObject).cubicTo(6.477152F, 22.0F, 2.0F, 17.522848F, 2.0F, 12.0F);
      ((Path)localObject).cubicTo(2.0F, 6.477152F, 6.477152F, 2.0F, 12.0F, 2.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(10.5F, 8.304248F);
      ((Path)localObject).cubicTo(10.223858F, 8.304248F, 10.0F, 8.528106F, 10.0F, 8.804248F);
      ((Path)localObject).lineTo(10.0F, 15.195752F);
      ((Path)localObject).cubicTo(10.0F, 15.289462F, 10.026335F, 15.381286F, 10.076001F, 15.460752F);
      ((Path)localObject).cubicTo(10.222356F, 15.694921F, 10.530831F, 15.766107F, 10.764999F, 15.619752F);
      ((Path)localObject).lineTo(15.878203F, 12.423999F);
      ((Path)localObject).cubicTo(15.942588F, 12.383759F, 15.996963F, 12.329384F, 16.037203F, 12.264999F);
      ((Path)localObject).cubicTo(16.183558F, 12.030831F, 16.112371F, 11.722356F, 15.878203F, 11.576001F);
      ((Path)localObject).lineTo(10.764999F, 8.380248F);
      ((Path)localObject).cubicTo(10.685534F, 8.330583F, 10.59371F, 8.304248F, 10.5F, 8.304248F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_play2
 * JD-Core Version:    0.7.0.1
 */