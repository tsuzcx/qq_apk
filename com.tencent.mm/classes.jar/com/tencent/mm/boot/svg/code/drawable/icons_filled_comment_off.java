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

public class icons_filled_comment_off
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
      ((Path)localObject).moveTo(3.173298F, 5.293189F);
      ((Path)localObject).lineTo(15.879F, 18.0F);
      ((Path)localObject).lineTo(11.5F, 18.0F);
      ((Path)localObject).lineTo(9.207107F, 20.290001F);
      ((Path)localObject).cubicTo(8.816583F, 20.680525F, 8.183417F, 20.680525F, 7.792893F, 20.290001F);
      ((Path)localObject).cubicTo(7.605357F, 20.102463F, 7.5F, 19.855217F, 7.5F, 19.59F);
      ((Path)localObject).lineTo(7.5F, 18.0F);
      ((Path)localObject).lineTo(5.0F, 18.0F);
      ((Path)localObject).cubicTo(3.619288F, 18.0F, 2.5F, 16.880713F, 2.5F, 15.5F);
      ((Path)localObject).lineTo(2.5F, 7.0F);
      ((Path)localObject).cubicTo(2.5F, 6.34014F, 2.755647F, 5.739989F, 3.173298F, 5.293189F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(4.12132F, 2.0F);
      ((Path)localObject).lineTo(6.62F, 4.499F);
      ((Path)localObject).lineTo(19.0F, 4.5F);
      ((Path)localObject).cubicTo(20.380713F, 4.5F, 21.5F, 5.619288F, 21.5F, 7.0F);
      ((Path)localObject).lineTo(21.5F, 15.5F);
      ((Path)localObject).cubicTo(21.5F, 16.548952F, 20.853979F, 17.447018F, 19.938099F, 17.818033F);
      ((Path)localObject).lineTo(21.091883F, 18.970562F);
      ((Path)localObject).lineTo(20.031223F, 20.031223F);
      ((Path)localObject).lineTo(3.06066F, 3.06066F);
      ((Path)localObject).lineTo(4.12132F, 2.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_comment_off
 * JD-Core Version:    0.7.0.1
 */