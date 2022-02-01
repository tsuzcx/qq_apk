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

public class back_icon_pressed
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-8355712);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 25.0F, 0.0F, 1.0F, 24.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 128, 31);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(-3.552714E-015F, 24.0F);
      ((Path)localObject2).cubicTo(8.006664F, 16.0F, 16.013329F, 8.0F, 24.0F, 3.552714E-015F);
      ((Path)localObject2).cubicTo(25.549355F, 1.36829F, 26.918783F, 2.876405F, 28.0F, 4.0F);
      ((Path)localObject2).cubicTo(22.620575F, 9.877653F, 17.152853F, 15.440699F, 12.0F, 21.0F);
      ((Path)localObject2).cubicTo(23.760099F, 20.973783F, 35.875053F, 20.943821F, 48.0F, 21.0F);
      ((Path)localObject2).lineTo(48.0F, 27.0F);
      ((Path)localObject2).cubicTo(35.855061F, 27.026217F, 23.710121F, 26.996254F, 12.0F, 27.0F);
      ((Path)localObject2).cubicTo(17.112869F, 32.559299F, 22.610579F, 38.142323F, 28.0F, 44.0F);
      ((Path)localObject2).cubicTo(26.878801F, 45.133583F, 25.519367F, 46.651684F, 24.0F, 48.0F);
      ((Path)localObject2).cubicTo(15.993336F, 40.019974F, 7.986672F, 32.019974F, -3.552714E-015F, 24.0F);
      ((Path)localObject2).lineTo(-3.552714E-015F, 24.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.back_icon_pressed
 * JD-Core Version:    0.7.0.1
 */