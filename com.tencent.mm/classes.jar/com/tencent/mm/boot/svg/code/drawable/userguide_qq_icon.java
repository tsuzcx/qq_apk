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

public class userguide_qq_icon
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
      localPaint.setColor(-12799249);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(48.11264F, 11.0F);
      ((Path)localObject).cubicTo(29.075232F, 11.190086F, 20.986343F, 26.826294F, 20.986343F, 40.877155F);
      ((Path)localObject).cubicTo(9.261343F, 52.839657F, 12.905231F, 69.573708F, 16.545231F, 69.573708F);
      ((Path)localObject).cubicTo(18.859121F, 69.951294F, 22.617083F, 63.596981F, 22.617083F, 63.596981F);
      ((Path)localObject).cubicTo(22.617083F, 63.596981F, 22.733749F, 67.556465F, 25.812454F, 71.138359F);
      ((Path)localObject).cubicTo(22.417454F, 72.655174F, 20.195602F, 75.137932F, 20.195602F, 77.949135F);
      ((Path)localObject).cubicTo(20.195602F, 82.570686F, 26.175417F, 86.316811F, 33.553936F, 86.316811F);
      ((Path)localObject).cubicTo(39.042454F, 86.316811F, 43.753193F, 84.242676F, 45.80912F, 81.278877F);
      ((Path)localObject).lineTo(50.492638F, 81.278877F);
      ((Path)localObject).cubicTo(52.547268F, 84.242676F, 57.258011F, 86.316811F, 62.746529F, 86.316811F);
      ((Path)localObject).cubicTo(70.123749F, 86.316811F, 76.106155F, 82.571983F, 76.106155F, 77.949135F);
      ((Path)localObject).cubicTo(76.106155F, 75.137932F, 73.884308F, 72.656464F, 70.489304F, 71.138359F);
      ((Path)localObject).cubicTo(73.568008F, 67.556465F, 73.684677F, 63.596981F, 73.684677F, 63.596981F);
      ((Path)localObject).cubicTo(73.684677F, 63.596981F, 77.441345F, 69.951294F, 79.756531F, 69.573708F);
      ((Path)localObject).cubicTo(83.39653F, 69.572411F, 87.039124F, 52.838364F, 75.314117F, 40.875862F);
      ((Path)localObject).cubicTo(75.314117F, 26.826294F, 67.14875F, 11.181034F, 48.11264F, 11.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.userguide_qq_icon
 * JD-Core Version:    0.7.0.1
 */