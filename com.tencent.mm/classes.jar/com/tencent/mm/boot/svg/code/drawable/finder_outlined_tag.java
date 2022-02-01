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

public class finder_outlined_tag
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
      ((Path)localObject).moveTo(30.6F, 10.5F);
      ((Path)localObject).lineTo(28.834999F, 25.499001F);
      ((Path)localObject).lineTo(42.634998F, 25.499001F);
      ((Path)localObject).lineTo(44.400002F, 10.5F);
      ((Path)localObject).lineTo(48.0F, 10.5F);
      ((Path)localObject).lineTo(46.235001F, 25.499001F);
      ((Path)localObject).lineTo(60.0F, 25.5F);
      ((Path)localObject).lineTo(60.0F, 29.1F);
      ((Path)localObject).lineTo(45.812F, 29.099001F);
      ((Path)localObject).lineTo(44.188F, 42.898998F);
      ((Path)localObject).lineTo(60.0F, 42.900002F);
      ((Path)localObject).lineTo(60.0F, 46.5F);
      ((Path)localObject).lineTo(43.764999F, 46.499001F);
      ((Path)localObject).lineTo(42.0F, 61.5F);
      ((Path)localObject).lineTo(38.400002F, 61.5F);
      ((Path)localObject).lineTo(40.165001F, 46.499001F);
      ((Path)localObject).lineTo(26.365F, 46.499001F);
      ((Path)localObject).lineTo(24.6F, 61.5F);
      ((Path)localObject).lineTo(21.0F, 61.5F);
      ((Path)localObject).lineTo(22.764999F, 46.499001F);
      ((Path)localObject).lineTo(9.0F, 46.5F);
      ((Path)localObject).lineTo(9.0F, 42.900002F);
      ((Path)localObject).lineTo(23.188F, 42.898998F);
      ((Path)localObject).lineTo(24.812F, 29.099001F);
      ((Path)localObject).lineTo(9.0F, 29.1F);
      ((Path)localObject).lineTo(9.0F, 25.5F);
      ((Path)localObject).lineTo(25.235001F, 25.499001F);
      ((Path)localObject).lineTo(27.0F, 10.5F);
      ((Path)localObject).lineTo(30.6F, 10.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(40.588001F, 42.898998F);
      ((Path)localObject).lineTo(42.212002F, 29.099001F);
      ((Path)localObject).lineTo(28.412001F, 29.099001F);
      ((Path)localObject).lineTo(26.788F, 42.898998F);
      ((Path)localObject).lineTo(40.588001F, 42.898998F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_outlined_tag
 * JD-Core Version:    0.7.0.1
 */