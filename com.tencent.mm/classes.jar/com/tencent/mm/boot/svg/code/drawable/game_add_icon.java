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

public class game_add_icon
  extends c
{
  private final int height = 11;
  private final int width = 12;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 12;
      return 11;
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-2147483648);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(6.49984F, 0.166748F);
      ((Path)localObject).lineTo(5.49984F, 0.166748F);
      ((Path)localObject).lineTo(5.49984F, 5.00008F);
      ((Path)localObject).lineTo(0.666504F, 5.00008F);
      ((Path)localObject).lineTo(0.666504F, 6.00008F);
      ((Path)localObject).lineTo(5.49984F, 6.00008F);
      ((Path)localObject).lineTo(5.49984F, 10.8334F);
      ((Path)localObject).lineTo(6.49984F, 10.8334F);
      ((Path)localObject).lineTo(6.49984F, 6.00008F);
      ((Path)localObject).lineTo(11.3332F, 6.00008F);
      ((Path)localObject).lineTo(11.3332F, 5.00008F);
      ((Path)localObject).lineTo(6.49984F, 5.00008F);
      ((Path)localObject).lineTo(6.49984F, 0.166748F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.game_add_icon
 * JD-Core Version:    0.7.0.1
 */