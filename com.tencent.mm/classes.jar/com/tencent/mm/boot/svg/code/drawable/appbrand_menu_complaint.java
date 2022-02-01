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

public class appbrand_menu_complaint
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(30.995142F, 4.200261F);
      ((Path)localObject2).lineTo(4.23486F, 50.562687F);
      ((Path)localObject2).lineTo(57.764397F, 50.558201F);
      ((Path)localObject2).lineTo(30.995142F, 4.200261F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.195968F, 54.162773F);
      ((Path)localObject2).cubicTo(1.539114F, 54.162773F, 0.195717F, 52.819878F, 0.195717F, 51.163025F);
      ((Path)localObject2).cubicTo(0.195717F, 50.636444F, 0.3342319F, 50.119129F, 0.597469F, 49.663071F);
      ((Path)localObject2).lineTo(28.396782F, 1.500515F);
      ((Path)localObject2).cubicTo(29.225044F, 0.06554246F, 31.059759F, -0.4262931F, 32.494732F, 0.4019698F);
      ((Path)localObject2).cubicTo(32.950855F, 0.6652439F, 33.329639F, 1.043954F, 33.592999F, 1.500029F);
      ((Path)localObject2).lineTo(61.40163F, 49.657925F);
      ((Path)localObject2).cubicTo(62.230164F, 51.092743F, 61.73867F, 52.927547F, 60.303852F, 53.756081F);
      ((Path)localObject2).cubicTo(59.847824F, 54.019413F, 59.330513F, 54.15807F, 58.803913F, 54.158112F);
      ((Path)localObject2).lineTo(3.195968F, 54.162773F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(29.117676F, 20.862305F);
      ((Path)localObject2).lineTo(32.882324F, 20.862305F);
      ((Path)localObject2).lineTo(32.589355F, 35.027344F);
      ((Path)localObject2).lineTo(29.410645F, 35.027344F);
      ((Path)localObject2).lineTo(29.117676F, 20.862305F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(30.992676F, 42.292969F);
      ((Path)localObject2).cubicTo(29.806152F, 42.292969F, 28.868652F, 41.370117F, 28.868652F, 40.212891F);
      ((Path)localObject2).cubicTo(28.868652F, 39.055664F, 29.806152F, 38.147461F, 30.992676F, 38.147461F);
      ((Path)localObject2).cubicTo(32.193848F, 38.147461F, 33.131348F, 39.055664F, 33.131348F, 40.212891F);
      ((Path)localObject2).cubicTo(33.131348F, 41.370117F, 32.193848F, 42.292969F, 30.992676F, 42.292969F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.appbrand_menu_complaint
 * JD-Core Version:    0.7.0.1
 */