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

public class icons_outlined_envelopes
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
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 10.5F, 0.0F, 1.0F, 5.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(25.5F, 30.5F);
      ((Path)localObject2).cubicTo(28.606602F, 30.5F, 31.125F, 27.981602F, 31.125F, 24.875F);
      ((Path)localObject2).cubicTo(31.125F, 21.768398F, 28.606602F, 19.25F, 25.5F, 19.25F);
      ((Path)localObject2).cubicTo(22.393398F, 19.25F, 19.875F, 21.768398F, 19.875F, 24.875F);
      ((Path)localObject2).cubicTo(19.875F, 27.981602F, 22.393398F, 30.5F, 25.5F, 30.5F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint2, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(4.95F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(46.650002F, 3.094385F);
      ((Path)localObject2).cubicTo(46.960659F, 3.094385F, 47.241909F, 3.220305F, 47.445496F, 3.42389F);
      ((Path)localObject2).cubicTo(47.649078F, 3.627475F, 47.775002F, 3.908725F, 47.775002F, 4.219385F);
      ((Path)localObject2).lineTo(47.775002F, 4.219385F);
      ((Path)localObject2).lineTo(47.775002F, 56.848732F);
      ((Path)localObject2).cubicTo(47.775002F, 57.159389F, 47.649078F, 57.440639F, 47.445496F, 57.644226F);
      ((Path)localObject2).cubicTo(47.241909F, 57.847809F, 46.960659F, 57.973732F, 46.650002F, 57.973732F);
      ((Path)localObject2).lineTo(46.650002F, 57.973732F);
      ((Path)localObject2).lineTo(4.35F, 57.973732F);
      ((Path)localObject2).cubicTo(4.03934F, 57.973732F, 3.75809F, 57.847809F, 3.554505F, 57.644226F);
      ((Path)localObject2).cubicTo(3.35092F, 57.440639F, 3.225F, 57.159389F, 3.225F, 56.848732F);
      ((Path)localObject2).lineTo(3.225F, 56.848732F);
      ((Path)localObject2).lineTo(3.225F, 4.219385F);
      ((Path)localObject2).cubicTo(3.225F, 3.908725F, 3.35092F, 3.627475F, 3.554505F, 3.42389F);
      ((Path)localObject2).cubicTo(3.75809F, 3.220305F, 4.03934F, 3.094385F, 4.35F, 3.094385F);
      ((Path)localObject2).lineTo(4.35F, 3.094385F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1.setColor(-16777216);
      localPaint2.setColor(-16777216);
      localPaint2.setStrokeWidth(2.25F);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(3.028015F, 7.681593F);
      ((Path)localObject1).cubicTo(3.028015F, 15.295336F, 10.917F, 21.713449F, 19.684799F, 23.7188F);
      ((Path)localObject1).cubicTo(19.568399F, 24.201651F, 19.5F, 24.703764F, 19.5F, 25.2239F);
      ((Path)localObject1).cubicTo(19.5F, 25.430214F, 19.510799F, 25.634043F, 19.530001F, 25.835386F);
      ((Path)localObject1).cubicTo(13.7418F, 24.903242F, 7.086415F, 22.641865F, 3.028015F, 19.468849F);
      ((Path)localObject1).lineTo(3.028015F, 7.681593F);
      ((Path)localObject1).cubicTo(3.028015F, 7.681593F, 2.617695F, 4.320863F, 3.028015F, 3.335754F);
      ((Path)localObject1).cubicTo(3.438335F, 2.350646F, 5.257324F, 2.329407F, 5.257324F, 2.329407F);
      ((Path)localObject1).lineTo(44.426514F, 2.329407F);
      ((Path)localObject1).lineTo(47.220886F, 3.335754F);
      ((Path)localObject1).lineTo(48.046143F, 7.681593F);
      ((Path)localObject1).lineTo(48.046143F, 19.468849F);
      ((Path)localObject1).cubicTo(43.987743F, 22.641865F, 37.258202F, 24.903242F, 31.469999F, 25.835386F);
      ((Path)localObject1).cubicTo(31.489201F, 25.634043F, 31.5F, 25.430214F, 31.5F, 25.2239F);
      ((Path)localObject1).cubicTo(31.5F, 24.703764F, 31.431601F, 24.201651F, 31.315201F, 23.7188F);
      ((Path)localObject1).cubicTo(40.083F, 21.713449F, 48.046143F, 15.295336F, 48.046143F, 7.681593F);
      ((Path)localObject1).cubicTo(48.046143F, 7.681593F, 47.672394F, 2.91796F, 44.426514F, 2.329407F);
      ((Path)localObject1).cubicTo(35.889668F, 0.7814772F, 14.429889F, 2.329407F, 5.257324F, 2.329407F);
      ((Path)localObject1).cubicTo(3.917481F, 2.329407F, 3.028015F, 7.681593F, 3.028015F, 7.681593F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.drawPath((Path)localObject1, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_envelopes
 * JD-Core Version:    0.7.0.1
 */