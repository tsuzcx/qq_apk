package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class voiceinput_icon_button_care
  extends c
{
  private final int height = 189;
  private final int width = 189;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 189;
      return 189;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-16676542);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(94.5F, 0.0F);
      localPath.cubicTo(146.69092F, 0.0F, 189.0F, 42.30909F, 189.0F, 94.5F);
      localPath.cubicTo(189.0F, 146.69092F, 146.69092F, 189.0F, 94.5F, 189.0F);
      localPath.cubicTo(42.30909F, 189.0F, 0.0F, 146.69092F, 0.0F, 94.5F);
      localPath.cubicTo(0.0F, 42.30909F, 42.30909F, 0.0F, 94.5F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.8660254F, -0.5F, 59.728077F, 0.5F, 0.8660254F, -34.824978F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(98.173996F, 132.51166F);
      ((Path)localObject).lineTo(95.499557F, 138.75635F);
      ((Path)localObject).cubicTo(95.345528F, 139.11601F, 94.929092F, 139.2827F, 94.569427F, 139.12866F);
      ((Path)localObject).cubicTo(94.402092F, 139.05701F, 94.268768F, 138.92368F, 94.197105F, 138.75635F);
      ((Path)localObject).lineTo(91.522667F, 132.51166F);
      ((Path)localObject).lineTo(98.173996F, 132.51166F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(71.568672F, 82.342972F);
      ((Path)localObject).lineTo(71.568672F, 92.509102F);
      ((Path)localObject).cubicTo(71.568672F, 105.3661F, 81.991333F, 115.78876F, 94.848335F, 115.78876F);
      ((Path)localObject).cubicTo(107.70533F, 115.78876F, 118.12799F, 105.3661F, 118.12799F, 92.509102F);
      ((Path)localObject).lineTo(118.12799F, 82.342972F);
      ((Path)localObject).lineTo(124.77932F, 82.342972F);
      ((Path)localObject).lineTo(124.77932F, 92.546936F);
      ((Path)localObject).cubicTo(124.77932F, 107.95316F, 113.13948F, 120.64075F, 98.174294F, 122.29521F);
      ((Path)localObject).lineTo(98.173996F, 129.16708F);
      ((Path)localObject).lineTo(91.522667F, 129.16708F);
      ((Path)localObject).lineTo(91.522369F, 122.29521F);
      ((Path)localObject).cubicTo(76.557182F, 120.64075F, 64.917343F, 107.95316F, 64.917343F, 92.546936F);
      ((Path)localObject).lineTo(64.917343F, 82.342972F);
      ((Path)localObject).lineTo(71.568672F, 82.342972F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(94.848335F, 48.897179F);
      ((Path)localObject).cubicTo(104.03191F, 48.897179F, 111.47666F, 56.341934F, 111.47666F, 65.525505F);
      ((Path)localObject).lineTo(111.47666F, 92.471275F);
      ((Path)localObject).cubicTo(111.47666F, 101.65485F, 104.03191F, 109.09961F, 94.848335F, 109.09961F);
      ((Path)localObject).cubicTo(85.664757F, 109.09961F, 78.220001F, 101.65485F, 78.220001F, 92.471275F);
      ((Path)localObject).lineTo(78.220001F, 65.525505F);
      ((Path)localObject).cubicTo(78.220001F, 56.341934F, 85.664757F, 48.897179F, 94.848335F, 48.897179F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.voiceinput_icon_button_care
 * JD-Core Version:    0.7.0.1
 */