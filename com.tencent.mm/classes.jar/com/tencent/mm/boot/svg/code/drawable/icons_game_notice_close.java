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

public class icons_game_notice_close
  extends c
{
  private final int height = 20;
  private final int width = 20;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 20;
      return 20;
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
      ((Path)localObject).moveTo(10.2084F, 8.91099F);
      ((Path)localObject).lineTo(5.04737F, 3.75F);
      ((Path)localObject).lineTo(4.16669F, 4.63068F);
      ((Path)localObject).lineTo(9.32767F, 9.79167F);
      ((Path)localObject).lineTo(4.16669F, 14.9527F);
      ((Path)localObject).lineTo(5.04737F, 15.8333F);
      ((Path)localObject).lineTo(10.2084F, 10.6723F);
      ((Path)localObject).lineTo(15.3693F, 15.8333F);
      ((Path)localObject).lineTo(16.25F, 14.9527F);
      ((Path)localObject).lineTo(11.089F, 9.79167F);
      ((Path)localObject).lineTo(16.25F, 4.63068F);
      ((Path)localObject).lineTo(15.3693F, 3.75F);
      ((Path)localObject).lineTo(10.2084F, 8.91099F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_game_notice_close
 * JD-Core Version:    0.7.0.1
 */