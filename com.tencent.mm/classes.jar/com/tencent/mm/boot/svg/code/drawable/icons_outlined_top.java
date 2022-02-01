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

public class icons_outlined_top
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.707107F, 6.221826F);
      ((Path)localObject).lineTo(18.778175F, 12.292893F);
      ((Path)localObject).cubicTo(19.168699F, 12.683417F, 19.168699F, 13.316583F, 18.778175F, 13.707107F);
      ((Path)localObject).cubicTo(18.590639F, 13.894643F, 18.336285F, 14.0F, 18.071068F, 14.0F);
      ((Path)localObject).lineTo(15.999932F, 13.999932F);
      ((Path)localObject).lineTo(16.0F, 21.0F);
      ((Path)localObject).cubicTo(16.0F, 21.552284F, 15.552284F, 22.0F, 15.0F, 22.0F);
      ((Path)localObject).lineTo(9.0F, 22.0F);
      ((Path)localObject).cubicTo(8.447715F, 22.0F, 8.0F, 21.552284F, 8.0F, 21.0F);
      ((Path)localObject).lineTo(7.999932F, 13.999932F);
      ((Path)localObject).lineTo(5.928932F, 14.0F);
      ((Path)localObject).cubicTo(5.376648F, 14.0F, 4.928932F, 13.552284F, 4.928932F, 13.0F);
      ((Path)localObject).cubicTo(4.928932F, 12.734783F, 5.034289F, 12.48043F, 5.221826F, 12.292893F);
      ((Path)localObject).lineTo(11.292893F, 6.221826F);
      ((Path)localObject).cubicTo(11.683417F, 5.831301F, 12.316583F, 5.831301F, 12.707107F, 6.221826F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 7.212F);
      ((Path)localObject).lineTo(6.411F, 12.8F);
      ((Path)localObject).lineTo(9.199921F, 12.799892F);
      ((Path)localObject).lineTo(9.2F, 20.799999F);
      ((Path)localObject).lineTo(14.8F, 20.799999F);
      ((Path)localObject).lineTo(14.799921F, 12.799892F);
      ((Path)localObject).lineTo(17.587999F, 12.8F);
      ((Path)localObject).lineTo(12.0F, 7.212F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.0F, 3.0F);
      ((Path)localObject).lineTo(20.0F, 4.2F);
      ((Path)localObject).lineTo(4.0F, 4.2F);
      ((Path)localObject).lineTo(4.0F, 3.0F);
      ((Path)localObject).lineTo(20.0F, 3.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_top
 * JD-Core Version:    0.7.0.1
 */