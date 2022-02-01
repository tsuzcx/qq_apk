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

public class msg_state_fail_resend
  extends c
{
  private final int height = 66;
  private final int width = 66;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 66;
      return 66;
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
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-499359);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(33.0F, 0.0F);
      localPath.cubicTo(51.225395F, 0.0F, 66.0F, 14.774603F, 66.0F, 33.0F);
      localPath.cubicTo(66.0F, 51.225395F, 51.225395F, 66.0F, 33.0F, 66.0F);
      localPath.cubicTo(14.774603F, 66.0F, 0.0F, 51.225395F, 0.0F, 33.0F);
      localPath.cubicTo(0.0F, 14.774603F, 14.774603F, 0.0F, 33.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 30.0F, 0.0F, 1.0F, 17.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(3.0F, 27.0F);
      ((Path)localObject2).cubicTo(4.656855F, 27.0F, 6.0F, 28.343145F, 6.0F, 30.0F);
      ((Path)localObject2).cubicTo(6.0F, 31.656855F, 4.656855F, 33.0F, 3.0F, 33.0F);
      ((Path)localObject2).cubicTo(1.343146F, 33.0F, 0.0F, 31.656855F, 0.0F, 30.0F);
      ((Path)localObject2).cubicTo(0.0F, 28.343145F, 1.343146F, 27.0F, 3.0F, 27.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(6.0F, 0.0F);
      ((Path)localObject2).lineTo(5.057815F, 23.0F);
      ((Path)localObject2).lineTo(1.001121F, 23.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.msg_state_fail_resend
 * JD-Core Version:    0.7.0.1
 */