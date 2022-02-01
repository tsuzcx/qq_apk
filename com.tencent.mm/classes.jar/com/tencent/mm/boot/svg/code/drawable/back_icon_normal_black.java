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

public class back_icon_normal_black
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      ((Path)localObject).moveTo(48.054966F, 24.0F);
      ((Path)localObject).cubicTo(49.474079F, 25.437006F, 50.893192F, 26.874012F, 52.292316F, 28.320997F);
      ((Path)localObject).cubicTo(46.73579F, 33.869438F, 41.179264F, 39.407902F, 35.632729F, 44.956341F);
      ((Path)localObject).cubicTo(47.755154F, 44.96632F, 59.877575F, 44.956341F, 72.0F, 44.96632F);
      ((Path)localObject).lineTo(72.0F, 51.013721F);
      ((Path)localObject).lineTo(35.58276F, 51.013721F);
      ((Path)localObject).cubicTo(41.129295F, 56.612057F, 46.725796F, 62.15052F, 52.292316F, 67.728897F);
      ((Path)localObject).cubicTo(50.873203F, 69.155922F, 49.444096F, 70.572975F, 48.014992F, 72.0F);
      ((Path)localObject).cubicTo(40.009995F, 64.006653F, 32.004997F, 56.013306F, 24.0F, 48.019958F);
      ((Path)localObject).cubicTo(32.014992F, 40.016632F, 40.02998F, 32.003326F, 48.054966F, 24.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.back_icon_normal_black
 * JD-Core Version:    0.7.0.1
 */