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

public class icons_filled_return
  extends c
{
  private final int height = 12;
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
      return 12;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      c.instancePaint((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(24.0F, 0.0F);
      ((Path)localObject2).lineTo(24.0F, 12.0F);
      ((Path)localObject2).lineTo(0.0F, 12.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(12.752577F, 9.139913F);
      ((Path)localObject1).lineTo(17.548809F, 3.658505F);
      ((Path)localObject1).cubicTo(17.912491F, 3.242868F, 17.870373F, 2.611105F, 17.454737F, 2.247423F);
      ((Path)localObject1).cubicTo(17.272446F, 2.087918F, 17.038454F, 2.0F, 16.796232F, 2.0F);
      ((Path)localObject1).lineTo(7.203768F, 2.0F);
      ((Path)localObject1).cubicTo(6.651484F, 2.0F, 6.203768F, 2.447715F, 6.203768F, 3.0F);
      ((Path)localObject1).cubicTo(6.203768F, 3.242223F, 6.291687F, 3.476213F, 6.451191F, 3.658505F);
      ((Path)localObject1).lineTo(11.247423F, 9.139913F);
      ((Path)localObject1).cubicTo(11.611105F, 9.555549F, 12.242868F, 9.597667F, 12.658504F, 9.233984F);
      ((Path)localObject1).cubicTo(12.691916F, 9.20475F, 12.723342F, 9.173323F, 12.752577F, 9.139913F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 204, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_return
 * JD-Core Version:    0.7.0.1
 */