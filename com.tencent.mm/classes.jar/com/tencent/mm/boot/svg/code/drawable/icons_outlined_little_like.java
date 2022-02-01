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

public class icons_outlined_little_like
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
      ((Path)localObject).moveTo(34.819805F, 19.393398F);
      ((Path)localObject).lineTo(35.978344F, 20.524906F);
      ((Path)localObject).cubicTo(36.27388F, 20.808432F, 36.594807F, 21.11334F, 36.941124F, 21.439636F);
      ((Path)localObject).lineTo(38.328171F, 20.11566F);
      ((Path)localObject).cubicTo(38.59832F, 19.853519F, 38.843079F, 19.612766F, 39.062447F, 19.393398F);
      ((Path)localObject).cubicTo(44.920311F, 13.535534F, 54.417786F, 13.535534F, 60.27565F, 19.393398F);
      ((Path)localObject).cubicTo(66.079025F, 25.196774F, 66.133003F, 34.572361F, 60.437599F, 40.442192F);
      ((Path)localObject).lineTo(39.062447F, 61.819805F);
      ((Path)localObject).cubicTo(37.890934F, 62.99144F, 35.99144F, 62.991539F, 34.819805F, 61.820026F);
      ((Path)localObject).lineTo(13.443423F, 40.443424F);
      ((Path)localObject).cubicTo(7.749244F, 34.572361F, 7.803227F, 25.196774F, 13.606602F, 19.393398F);
      ((Path)localObject).cubicTo(19.464466F, 13.535534F, 28.961941F, 13.535534F, 34.819805F, 19.393398F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(57.164379F, 22.504667F);
      ((Path)localObject).cubicTo(53.024822F, 18.36511F, 46.313274F, 18.36511F, 42.173717F, 22.504667F);
      ((Path)localObject).lineTo(40.956974F, 23.693327F);
      ((Path)localObject).lineTo(39.958447F, 24.642101F);
      ((Path)localObject).lineTo(36.941124F, 27.48498F);
      ((Path)localObject).lineTo(32.925278F, 23.693327F);
      ((Path)localObject).cubicTo(32.46368F, 23.250423F, 32.058395F, 22.854528F, 31.708536F, 22.504667F);
      ((Path)localObject).cubicTo(27.568977F, 18.36511F, 20.85743F, 18.36511F, 16.717871F, 22.504667F);
      ((Path)localObject).cubicTo(12.767772F, 26.454769F, 12.58272F, 32.757175F, 16.143637F, 36.882938F);
      ((Path)localObject).lineTo(16.554708F, 37.332169F);
      ((Path)localObject).lineTo(36.938999F, 57.716999F);
      ((Path)localObject).lineTo(57.279762F, 37.378197F);
      ((Path)localObject).cubicTo(61.163967F, 33.375034F, 61.258965F, 27.071199F, 57.587784F, 22.95302F);
      ((Path)localObject).lineTo(57.164379F, 22.504667F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_little_like
 * JD-Core Version:    0.7.0.1
 */