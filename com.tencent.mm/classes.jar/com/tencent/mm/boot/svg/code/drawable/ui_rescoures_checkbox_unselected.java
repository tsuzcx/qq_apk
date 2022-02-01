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

public class ui_rescoures_checkbox_unselected
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(68.400002F, 36.444443F);
      ((Path)localObject).cubicTo(68.400002F, 18.105558F, 53.89444F, 3.6F, 35.555557F, 3.6F);
      ((Path)localObject).cubicTo(17.983149F, 3.6F, 3.6F, 18.230572F, 3.6F, 36.444443F);
      ((Path)localObject).cubicTo(3.6F, 53.89444F, 18.105558F, 68.400002F, 35.555557F, 68.400002F);
      ((Path)localObject).cubicTo(53.769428F, 68.400002F, 68.400002F, 54.01685F, 68.400002F, 36.444443F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(72.0F, 36.444443F);
      ((Path)localObject).cubicTo(72.0F, 55.882668F, 55.882668F, 72.0F, 35.555557F, 72.0F);
      ((Path)localObject).cubicTo(16.117332F, 72.0F, 0.0F, 55.882668F, 0.0F, 36.444443F);
      ((Path)localObject).cubicTo(0.0F, 16.117332F, 16.117332F, 0.0F, 35.555557F, 0.0F);
      ((Path)localObject).cubicTo(55.882668F, 0.0F, 72.0F, 16.117332F, 72.0F, 36.444443F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ui_rescoures_checkbox_unselected
 * JD-Core Version:    0.7.0.1
 */