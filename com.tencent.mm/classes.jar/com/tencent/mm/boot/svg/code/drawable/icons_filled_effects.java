package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class icons_filled_effects
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 2.0F);
      ((Path)localObject).cubicTo(17.522848F, 2.0F, 22.0F, 6.477152F, 22.0F, 12.0F);
      ((Path)localObject).cubicTo(22.0F, 17.522848F, 17.522848F, 22.0F, 12.0F, 22.0F);
      ((Path)localObject).cubicTo(6.477152F, 22.0F, 2.0F, 17.522848F, 2.0F, 12.0F);
      ((Path)localObject).cubicTo(2.0F, 6.477152F, 6.477152F, 2.0F, 12.0F, 2.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 13.0F);
      ((Path)localObject).cubicTo(10.438151F, 13.0F, 8.95667F, 13.126555F, 7.555555F, 13.379665F);
      ((Path)localObject).cubicTo(7.555555F, 15.834265F, 9.545402F, 17.82411F, 12.0F, 17.82411F);
      ((Path)localObject).cubicTo(14.454598F, 17.82411F, 16.444445F, 15.834265F, 16.444445F, 13.379665F);
      ((Path)localObject).cubicTo(15.04333F, 13.126555F, 13.561849F, 13.0F, 12.0F, 13.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.053873F, 7.300098F);
      ((Path)localObject).cubicTo(17.981472F, 6.782615F, 15.611561F, 6.878015F, 12.944138F, 7.586297F);
      ((Path)localObject).cubicTo(12.75793F, 7.616282F, 12.443216F, 7.632701F, 12.0F, 7.635557F);
      ((Path)localObject).lineTo(12.0F, 7.635557F);
      ((Path)localObject).lineTo(11.817918F, 7.633503F);
      ((Path)localObject).cubicTo(11.469488F, 7.627733F, 11.215469F, 7.611998F, 11.055862F, 7.586297F);
      ((Path)localObject).cubicTo(8.388439F, 6.878015F, 6.018527F, 6.782615F, 3.945573F, 7.300237F);
      ((Path)localObject).cubicTo(3.409824F, 7.434339F, 3.084226F, 7.977361F, 3.218329F, 8.513109F);
      ((Path)localObject).lineTo(3.218329F, 8.513109F);
      ((Path)localObject).lineTo(3.296685F, 8.81923F);
      ((Path)localObject).cubicTo(3.741305F, 10.516429F, 4.194755F, 11.576686F, 4.657037F, 12.0F);
      ((Path)localObject).cubicTo(5.540419F, 12.808919F, 6.414741F, 13.103516F, 8.34413F, 12.551758F);
      ((Path)localObject).cubicTo(9.630389F, 12.183919F, 10.5343F, 11.311744F, 11.055862F, 9.93523F);
      ((Path)localObject).lineTo(11.055862F, 9.93523F);
      ((Path)localObject).lineTo(12.944138F, 9.93523F);
      ((Path)localObject).lineTo(13.040147F, 10.172909F);
      ((Path)localObject).cubicTo(13.573365F, 11.412607F, 14.445273F, 12.205557F, 15.65587F, 12.551758F);
      ((Path)localObject).cubicTo(17.585258F, 13.103516F, 18.459581F, 12.808919F, 19.342964F, 12.0F);
      ((Path)localObject).cubicTo(19.805244F, 11.576686F, 20.258696F, 10.516429F, 20.703314F, 8.81923F);
      ((Path)localObject).lineTo(20.703314F, 8.81923F);
      ((Path)localObject).lineTo(20.781672F, 8.513109F);
      ((Path)localObject).lineTo(20.803463F, 8.398346F);
      ((Path)localObject).cubicTo(20.868187F, 7.901872F, 20.551888F, 7.424756F, 20.05415F, 7.300168F);
      ((Path)localObject).lineTo(20.05415F, 7.300168F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_effects
 * JD-Core Version:    0.7.0.1
 */