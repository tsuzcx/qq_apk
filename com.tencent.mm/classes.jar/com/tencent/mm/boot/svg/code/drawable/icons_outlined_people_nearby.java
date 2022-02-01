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

public class icons_outlined_people_nearby
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
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 12.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(18.392099F, 24.5868F);
      ((Path)localObject2).cubicTo(28.532101F, 24.5868F, 36.782101F, 33.580799F, 36.782101F, 44.635799F);
      ((Path)localObject2).lineTo(36.782101F, 47.9268F);
      ((Path)localObject2).lineTo(33.182098F, 47.9268F);
      ((Path)localObject2).lineTo(33.182098F, 44.635799F);
      ((Path)localObject2).cubicTo(33.182098F, 35.566799F, 26.549101F, 28.1868F, 18.392099F, 28.1868F);
      ((Path)localObject2).cubicTo(10.2351F, 28.1868F, 3.5991F, 35.566799F, 3.5991F, 44.635799F);
      ((Path)localObject2).lineTo(3.5991F, 47.9268F);
      ((Path)localObject2).lineTo(-0.0009F, 47.9268F);
      ((Path)localObject2).lineTo(-0.0009F, 44.635799F);
      ((Path)localObject2).cubicTo(-0.0009F, 33.580799F, 8.2491F, 24.5868F, 18.392099F, 24.5868F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(45.0495F, 28.894199F);
      ((Path)localObject2).cubicTo(53.026577F, 28.894199F, 59.551109F, 35.880653F, 59.880455F, 44.603077F);
      ((Path)localObject2).lineTo(59.893501F, 45.2952F);
      ((Path)localObject2).lineTo(59.893501F, 47.926201F);
      ((Path)localObject2).lineTo(56.296501F, 47.926201F);
      ((Path)localObject2).lineTo(56.296501F, 45.2952F);
      ((Path)localObject2).cubicTo(56.296501F, 38.236198F, 51.2505F, 32.494202F, 45.0495F, 32.494202F);
      ((Path)localObject2).cubicTo(43.177502F, 32.494202F, 41.3265F, 33.0312F, 39.688499F, 34.0452F);
      ((Path)localObject2).cubicTo(39.1665F, 32.9562F, 38.581501F, 31.909201F, 37.918499F, 30.919201F);
      ((Path)localObject2).cubicTo(40.0965F, 29.599199F, 42.553501F, 28.894199F, 45.0495F, 28.894199F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(45.3102F, 8.3781F);
      ((Path)localObject2).cubicTo(49.939201F, 8.3781F, 53.707199F, 12.1431F, 53.707199F, 16.775101F);
      ((Path)localObject2).cubicTo(53.707199F, 21.4041F, 49.939201F, 25.1721F, 45.3102F, 25.1721F);
      ((Path)localObject2).cubicTo(40.6782F, 25.1721F, 36.9072F, 21.4041F, 36.9072F, 16.775101F);
      ((Path)localObject2).cubicTo(36.9072F, 12.1431F, 40.6782F, 8.3781F, 45.3102F, 8.3781F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(45.3102F, 11.9781F);
      ((Path)localObject2).cubicTo(42.661201F, 11.9781F, 40.507198F, 14.1291F, 40.507198F, 16.775101F);
      ((Path)localObject2).cubicTo(40.507198F, 19.4181F, 42.661201F, 21.5721F, 45.3102F, 21.5721F);
      ((Path)localObject2).cubicTo(47.953201F, 21.5721F, 50.107201F, 19.4181F, 50.107201F, 16.775101F);
      ((Path)localObject2).cubicTo(50.107201F, 14.1291F, 47.953201F, 11.9781F, 45.3102F, 11.9781F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(18.075899F, 0.0006F);
      ((Path)localObject2).cubicTo(23.613899F, 0.0006F, 28.1229F, 4.5066F, 28.1229F, 10.0446F);
      ((Path)localObject2).cubicTo(28.1229F, 15.5856F, 23.613899F, 20.0916F, 18.075899F, 20.0916F);
      ((Path)localObject2).cubicTo(12.5319F, 20.0916F, 8.0229F, 15.5856F, 8.0229F, 10.0446F);
      ((Path)localObject2).cubicTo(8.0229F, 4.5066F, 12.5319F, 0.0006F, 18.075899F, 0.0006F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(18.075899F, 3.6006F);
      ((Path)localObject2).cubicTo(14.5179F, 3.6006F, 11.6259F, 6.4926F, 11.6259F, 10.0446F);
      ((Path)localObject2).cubicTo(11.6259F, 13.5996F, 14.5179F, 16.4916F, 18.075899F, 16.4916F);
      ((Path)localObject2).cubicTo(21.630899F, 16.4916F, 24.519899F, 13.5996F, 24.519899F, 10.0446F);
      ((Path)localObject2).cubicTo(24.519899F, 6.4926F, 21.630899F, 3.6006F, 18.075899F, 3.6006F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_people_nearby
 * JD-Core Version:    0.7.0.1
 */