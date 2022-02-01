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

public class diehua
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
      localPaint1.setColor(-855638017);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 18.0F, 0.0F, 1.0F, 18.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(35.200096F, 1.336288F);
      ((Path)localObject2).cubicTo(35.713497F, 1.873547F, 36.0F, 2.588059F, 36.0F, 3.331179F);
      ((Path)localObject2).lineTo(36.0F, 32.639317F);
      ((Path)localObject2).cubicTo(36.0F, 34.234039F, 34.707222F, 35.526817F, 33.112499F, 35.526817F);
      ((Path)localObject2).cubicTo(32.369381F, 35.526817F, 31.654867F, 35.240314F, 31.117609F, 34.726913F);
      ((Path)localObject2).lineTo(17.912905F, 22.108675F);
      ((Path)localObject2).lineTo(4.9219F, 34.663368F);
      ((Path)localObject2).cubicTo(3.775109F, 35.771523F, 1.947113F, 35.740204F, 0.8389573F, 34.593414F);
      ((Path)localObject2).cubicTo(0.3187033F, 34.055023F, 0.02790548F, 33.335606F, 0.02790548F, 32.586918F);
      ((Path)localObject2).lineTo(0.02790548F, 3.383576F);
      ((Path)localObject2).cubicTo(0.02790548F, 1.788854F, 1.320683F, 0.4960758F, 2.915406F, 0.4960758F);
      ((Path)localObject2).cubicTo(3.664091F, 0.4960758F, 4.383508F, 0.7868736F, 4.9219F, 1.307128F);
      ((Path)localObject2).lineTo(17.912905F, 13.860674F);
      ((Path)localObject2).lineTo(31.117609F, 1.243581F);
      ((Path)localObject2).cubicTo(32.270557F, 0.141833F, 34.098351F, 0.1833391F, 35.200096F, 1.336288F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.diehua
 * JD-Core Version:    0.7.0.1
 */