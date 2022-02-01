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

public class album_icon_nor
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
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
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 15.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 7.5F, 0.0F, 1.0F, 13.125F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(70.5F, 40.908176F);
      ((Path)localObject2).lineTo(70.5F, 6.375F);
      ((Path)localObject2).lineTo(4.5F, 6.375F);
      ((Path)localObject2).lineTo(4.5F, 39.720825F);
      ((Path)localObject2).lineTo(23.247171F, 24.559719F);
      ((Path)localObject2).cubicTo(24.981747F, 23.156944F, 27.767345F, 23.224977F, 29.439358F, 24.694063F);
      ((Path)localObject2).lineTo(46.22596F, 39.443348F);
      ((Path)localObject2).lineTo(54.784134F, 32.165615F);
      ((Path)localObject2).cubicTo(56.517441F, 30.691641F, 59.275211F, 30.721584F, 60.957867F, 32.231564F);
      ((Path)localObject2).lineTo(70.5F, 40.908176F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(70.5F, 46.851036F);
      ((Path)localObject2).lineTo(57.84819F, 35.467094F);
      ((Path)localObject2).lineTo(49.64241F, 42.445156F);
      ((Path)localObject2).lineTo(54.684147F, 46.875F);
      ((Path)localObject2).lineTo(48.041878F, 46.875F);
      ((Path)localObject2).lineTo(26.272711F, 27.900312F);
      ((Path)localObject2).lineTo(4.5F, 45.508213F);
      ((Path)localObject2).lineTo(4.5F, 57.375F);
      ((Path)localObject2).lineTo(70.5F, 57.375F);
      ((Path)localObject2).lineTo(70.5F, 46.851036F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.719262F, 1.875F);
      ((Path)localObject2).lineTo(71.280739F, 1.875F);
      ((Path)localObject2).cubicTo(73.292603F, 1.875F, 75.0F, 3.679264F, 75.0F, 5.904936F);
      ((Path)localObject2).lineTo(75.0F, 57.845062F);
      ((Path)localObject2).cubicTo(75.0F, 60.079319F, 73.334831F, 61.875F, 71.280739F, 61.875F);
      ((Path)localObject2).lineTo(3.719262F, 61.875F);
      ((Path)localObject2).cubicTo(1.707396F, 61.875F, 0.0F, 60.070736F, 0.0F, 57.845062F);
      ((Path)localObject2).lineTo(0.0F, 5.904936F);
      ((Path)localObject2).cubicTo(0.0F, 3.670681F, 1.66517F, 1.875F, 3.719262F, 1.875F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.album_icon_nor
 * JD-Core Version:    0.7.0.1
 */