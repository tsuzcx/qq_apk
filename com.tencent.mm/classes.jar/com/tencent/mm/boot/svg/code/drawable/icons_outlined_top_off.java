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

public class icons_outlined_top_off
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
      ((Path)localObject).moveTo(7.408529F, 9.105F);
      ((Path)localObject).lineTo(8.256529F, 9.953F);
      ((Path)localObject).lineTo(6.412F, 11.799F);
      ((Path)localObject).lineTo(9.2F, 11.8F);
      ((Path)localObject).lineTo(9.2F, 20.799999F);
      ((Path)localObject).lineTo(14.8F, 20.799999F);
      ((Path)localObject).lineTo(14.799529F, 16.496F);
      ((Path)localObject).lineTo(15.999529F, 17.695999F);
      ((Path)localObject).lineTo(16.0F, 21.0F);
      ((Path)localObject).cubicTo(16.0F, 21.552284F, 15.552284F, 22.0F, 15.0F, 22.0F);
      ((Path)localObject).lineTo(9.0F, 22.0F);
      ((Path)localObject).cubicTo(8.447715F, 22.0F, 8.0F, 21.552284F, 8.0F, 21.0F);
      ((Path)localObject).lineTo(8.0F, 13.0F);
      ((Path)localObject).lineTo(5.928932F, 13.0F);
      ((Path)localObject).cubicTo(5.376648F, 13.0F, 4.928932F, 12.552284F, 4.928932F, 12.0F);
      ((Path)localObject).cubicTo(4.928932F, 11.734783F, 5.034289F, 11.48043F, 5.221826F, 11.292893F);
      ((Path)localObject).lineTo(7.408529F, 9.105F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(4.697057F, 3.0F);
      ((Path)localObject).lineTo(9.105529F, 7.408F);
      ((Path)localObject).lineTo(11.292893F, 5.221826F);
      ((Path)localObject).cubicTo(11.683417F, 4.831301F, 12.316583F, 4.831301F, 12.707107F, 5.221826F);
      ((Path)localObject).lineTo(18.778175F, 11.292893F);
      ((Path)localObject).cubicTo(19.168699F, 11.683417F, 19.168699F, 12.316583F, 18.778175F, 12.707107F);
      ((Path)localObject).cubicTo(18.590639F, 12.894643F, 18.336285F, 13.0F, 18.071068F, 13.0F);
      ((Path)localObject).lineTo(16.0F, 13.0F);
      ((Path)localObject).lineTo(15.999529F, 14.302F);
      ((Path)localObject).lineTo(21.424978F, 19.727922F);
      ((Path)localObject).lineTo(20.57645F, 20.57645F);
      ((Path)localObject).lineTo(3.848529F, 3.848528F);
      ((Path)localObject).lineTo(4.697057F, 3.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 6.212F);
      ((Path)localObject).lineTo(9.953528F, 8.257F);
      ((Path)localObject).lineTo(14.799529F, 13.102F);
      ((Path)localObject).lineTo(14.8F, 11.8F);
      ((Path)localObject).lineTo(17.587999F, 11.8F);
      ((Path)localObject).lineTo(12.0F, 6.212F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_top_off
 * JD-Core Version:    0.7.0.1
 */