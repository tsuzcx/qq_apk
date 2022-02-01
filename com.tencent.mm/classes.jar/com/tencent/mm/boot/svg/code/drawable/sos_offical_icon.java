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

public class sos_offical_icon
  extends c
{
  private final int height = 42;
  private final int width = 42;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 42;
      return 42;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint2, paramVarArgs);
      ((Paint)localObject1).setColor(-4210753);
      ((Paint)localObject1).setStrokeWidth(2.38417F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(13.255814F, 19.44186F);
      ((Path)localObject2).cubicTo(15.75252F, 23.571234F, 11.813965F, 25.277498F, 9.72093F, 26.511627F);
      ((Path)localObject2).cubicTo(3.092273F, 30.251368F, 0.0F, 31.759228F, 0.0F, 33.581394F);
      ((Path)localObject2).lineTo(0.0F, 36.232559F);
      ((Path)localObject2).cubicTo(0.0F, 37.254696F, 0.6434917F, 38.0F, 1.767442F, 38.0F);
      ((Path)localObject2).lineTo(36.232559F, 38.0F);
      ((Path)localObject2).cubicTo(37.356506F, 38.0F, 38.0F, 37.254696F, 38.0F, 36.232559F);
      ((Path)localObject2).lineTo(38.0F, 33.581394F);
      ((Path)localObject2).cubicTo(38.0F, 31.759228F, 34.907726F, 30.251368F, 28.27907F, 26.511627F);
      ((Path)localObject2).cubicTo(26.186035F, 25.277498F, 22.24748F, 23.571234F, 24.744186F, 19.44186F);
      ((Path)localObject2).cubicTo(26.726433F, 16.674295F, 28.370281F, 15.399918F, 28.27907F, 10.604651F);
      ((Path)localObject2).cubicTo(28.370281F, 5.203167F, 24.697962F, 0.0F, 19.44186F, 0.0F);
      ((Path)localObject2).cubicTo(13.302039F, 0.0F, 9.629718F, 5.203167F, 9.72093F, 10.604651F);
      ((Path)localObject2).cubicTo(9.629718F, 15.399918F, 11.273568F, 16.674295F, 13.255814F, 19.44186F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-4737097);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(16.347082F, 34.103432F);
      ((Path)localObject1).lineTo(18.393309F, 36.052551F);
      ((Path)localObject1).lineTo(18.393309F, 36.052551F);
      ((Path)localObject1).cubicTo(18.723711F, 36.367271F, 19.241936F, 36.370655F, 19.57642F, 36.060276F);
      ((Path)localObject1).lineTo(21.677546F, 34.110565F);
      ((Path)localObject1).lineTo(21.677546F, 34.110565F);
      ((Path)localObject1).cubicTo(22.181849F, 33.642605F, 22.360359F, 32.919991F, 22.131973F, 32.27103F);
      ((Path)localObject1).lineTo(18.981232F, 23.318182F);
      ((Path)localObject1).lineTo(15.904492F, 32.292583F);
      ((Path)localObject1).lineTo(15.904492F, 32.292583F);
      ((Path)localObject1).cubicTo(15.685678F, 32.930836F, 15.858533F, 33.638069F, 16.347082F, 34.103432F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.sos_offical_icon
 * JD-Core Version:    0.7.0.1
 */