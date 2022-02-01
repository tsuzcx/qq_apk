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

public class icons_filled_star_identify_enterprise_sold
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.571429F, 0.0F, 1.0F, 3.571429F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-15432210);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(23.73465F, 0.9581761F);
      ((Path)localObject2).lineTo(26.126421F, 6.731255F);
      ((Path)localObject2).lineTo(31.898968F, 9.122494F);
      ((Path)localObject2).cubicTo(32.497654F, 9.370478F, 32.781956F, 10.05684F, 32.53397F, 10.655527F);
      ((Path)localObject2).lineTo(30.142637F, 16.427259F);
      ((Path)localObject2).lineTo(32.53397F, 22.201616F);
      ((Path)localObject2).cubicTo(32.781956F, 22.800303F, 32.497654F, 23.486666F, 31.898968F, 23.73465F);
      ((Path)localObject2).lineTo(26.125225F, 26.126146F);
      ((Path)localObject2).lineTo(23.73465F, 31.898968F);
      ((Path)localObject2).cubicTo(23.486666F, 32.497654F, 22.800303F, 32.781956F, 22.201616F, 32.53397F);
      ((Path)localObject2).lineTo(16.429222F, 30.142363F);
      ((Path)localObject2).lineTo(10.655527F, 32.53397F);
      ((Path)localObject2).cubicTo(10.05684F, 32.781956F, 9.370478F, 32.497654F, 9.122494F, 31.898968F);
      ((Path)localObject2).lineTo(6.730335F, 26.124952F);
      ((Path)localObject2).lineTo(0.9581761F, 23.73465F);
      ((Path)localObject2).cubicTo(0.3594891F, 23.486666F, 0.07518837F, 22.800303F, 0.3231726F, 22.201616F);
      ((Path)localObject2).lineTo(2.714119F, 16.428947F);
      ((Path)localObject2).lineTo(0.3231726F, 10.655527F);
      ((Path)localObject2).cubicTo(0.07518837F, 10.05684F, 0.3594891F, 9.370478F, 0.9581761F, 9.122494F);
      ((Path)localObject2).lineTo(6.731529F, 6.730061F);
      ((Path)localObject2).lineTo(9.122494F, 0.9581761F);
      ((Path)localObject2).cubicTo(9.370478F, 0.3594891F, 10.05684F, 0.07518837F, 10.655527F, 0.3231726F);
      ((Path)localObject2).lineTo(16.427532F, 2.713845F);
      ((Path)localObject2).lineTo(22.201616F, 0.3231726F);
      ((Path)localObject2).cubicTo(22.800303F, 0.07518837F, 23.486666F, 0.3594891F, 23.73465F, 0.9581761F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(14.467633F, 19.994099F);
      ((Path)localObject1).lineTo(23.799828F, 10.661904F);
      ((Path)localObject1).lineTo(25.570707F, 12.432784F);
      ((Path)localObject1).lineTo(15.225742F, 22.773451F);
      ((Path)localObject1).cubicTo(14.809213F, 23.190039F, 14.133837F, 23.189899F, 13.717364F, 22.773252F);
      ((Path)localObject1).cubicTo(13.717325F, 22.773214F, 13.717287F, 22.773176F, 13.717364F, 22.773022F);
      ((Path)localObject1).lineTo(8.095238F, 17.14683F);
      ((Path)localObject1).lineTo(8.095238F, 17.14683F);
      ((Path)localObject1).lineTo(9.857801F, 15.384266F);
      ((Path)localObject1).lineTo(14.467633F, 19.994099F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_star_identify_enterprise_sold
 * JD-Core Version:    0.7.0.1
 */