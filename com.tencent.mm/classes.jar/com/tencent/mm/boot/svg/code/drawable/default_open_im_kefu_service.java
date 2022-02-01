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

public class default_open_im_kefu_service
  extends c
{
  private final int height = 144;
  private final int width = 144;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 144;
      return 144;
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
      localPaint2.setColor(-15432210);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 12.0F);
      localPath.cubicTo(0.0F, 5.372582F, 5.372582F, 0.0F, 12.0F, 0.0F);
      localPath.lineTo(132.0F, 0.0F);
      localPath.cubicTo(138.62741F, 0.0F, 144.0F, 5.372582F, 144.0F, 12.0F);
      localPath.lineTo(144.0F, 132.0F);
      localPath.cubicTo(144.0F, 138.62741F, 138.62741F, 144.0F, 132.0F, 144.0F);
      localPath.lineTo(12.0F, 144.0F);
      localPath.cubicTo(5.372582F, 144.0F, 0.0F, 138.62741F, 0.0F, 132.0F);
      localPath.lineTo(0.0F, 12.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 24.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(48.0F, 80.0F);
      ((Path)localObject2).cubicTo(70.091393F, 80.0F, 88.0F, 64.777679F, 88.0F, 46.0F);
      ((Path)localObject2).cubicTo(88.0F, 27.222319F, 70.091393F, 12.0F, 48.0F, 12.0F);
      ((Path)localObject2).cubicTo(25.908609F, 12.0F, 8.0F, 27.222319F, 8.0F, 46.0F);
      ((Path)localObject2).cubicTo(8.0F, 56.145618F, 13.227992F, 65.253334F, 21.519026F, 71.482933F);
      ((Path)localObject2).lineTo(20.310637F, 81.878456F);
      ((Path)localObject2).cubicTo(20.183098F, 82.975639F, 20.969151F, 83.968468F, 22.066332F, 84.096008F);
      ((Path)localObject2).cubicTo(22.44153F, 84.139618F, 22.821411F, 84.076088F, 23.162004F, 83.912773F);
      ((Path)localObject2).lineTo(35.093815F, 78.191345F);
      ((Path)localObject2).cubicTo(39.142921F, 79.363892F, 43.484066F, 80.0F, 48.0F, 80.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.default_open_im_kefu_service
 * JD-Core Version:    0.7.0.1
 */