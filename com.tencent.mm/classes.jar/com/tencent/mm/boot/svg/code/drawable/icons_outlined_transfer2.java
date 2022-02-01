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

public class icons_outlined_transfer2
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      ((Path)localObject).moveTo(36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 62.400002F);
      ((Path)localObject).cubicTo(50.580318F, 62.400002F, 62.400002F, 50.580318F, 62.400002F, 36.0F);
      ((Path)localObject).cubicTo(62.400002F, 21.419683F, 50.580318F, 9.6F, 36.0F, 9.6F);
      ((Path)localObject).cubicTo(21.419683F, 9.6F, 9.6F, 21.419683F, 9.6F, 36.0F);
      ((Path)localObject).cubicTo(9.6F, 50.580318F, 21.419683F, 62.400002F, 36.0F, 62.400002F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(29.369705F, 29.771019F);
      ((Path)localObject).lineTo(51.0F, 29.771019F);
      ((Path)localObject).lineTo(51.0F, 33.371021F);
      ((Path)localObject).lineTo(27.0F, 33.371021F);
      ((Path)localObject).lineTo(22.637648F, 33.371017F);
      ((Path)localObject).cubicTo(21.809219F, 33.371017F, 21.137648F, 32.699448F, 21.137648F, 31.871019F);
      ((Path)localObject).cubicTo(21.137648F, 31.427069F, 21.334305F, 31.005924F, 21.674694F, 30.720922F);
      ((Path)localObject).lineTo(31.158936F, 22.779951F);
      ((Path)localObject).cubicTo(31.66708F, 22.354492F, 32.423916F, 22.421522F, 32.849377F, 22.929667F);
      ((Path)localObject).cubicTo(33.189541F, 23.335938F, 33.222973F, 23.917223F, 32.931637F, 24.359818F);
      ((Path)localObject).lineTo(29.369705F, 29.771019F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(42.767944F, 42.240002F);
      ((Path)localObject).lineTo(21.137648F, 42.240002F);
      ((Path)localObject).lineTo(21.137648F, 38.639999F);
      ((Path)localObject).lineTo(45.137646F, 38.639999F);
      ((Path)localObject).lineTo(49.5F, 38.639999F);
      ((Path)localObject).cubicTo(50.328426F, 38.639999F, 51.0F, 39.311573F, 51.0F, 40.139999F);
      ((Path)localObject).cubicTo(51.0F, 40.58395F, 50.803345F, 41.005096F, 50.462952F, 41.290096F);
      ((Path)localObject).lineTo(40.97871F, 49.231068F);
      ((Path)localObject).cubicTo(40.470566F, 49.656528F, 39.71373F, 49.5895F, 39.288273F, 49.081352F);
      ((Path)localObject).cubicTo(38.948109F, 48.675083F, 38.914673F, 48.093796F, 39.206013F, 47.651203F);
      ((Path)localObject).lineTo(42.767944F, 42.240002F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_transfer2
 * JD-Core Version:    0.7.0.1
 */