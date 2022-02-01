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

public class fav_list_success
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
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-15028967);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(57.0F, 30.370371F);
      ((Path)localObject3).cubicTo(57.0F, 15.087965F, 44.912033F, 3.0F, 29.629629F, 3.0F);
      ((Path)localObject3).cubicTo(14.985957F, 3.0F, 3.0F, 15.192142F, 3.0F, 30.370371F);
      ((Path)localObject3).cubicTo(3.0F, 44.912033F, 15.087965F, 57.0F, 29.629629F, 57.0F);
      ((Path)localObject3).cubicTo(44.807858F, 57.0F, 57.0F, 45.014042F, 57.0F, 30.370371F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(60.0F, 30.370371F);
      ((Path)localObject3).cubicTo(60.0F, 46.56889F, 46.56889F, 60.0F, 29.629629F, 60.0F);
      ((Path)localObject3).cubicTo(13.431111F, 60.0F, 0.0F, 46.56889F, 0.0F, 30.370371F);
      ((Path)localObject3).cubicTo(0.0F, 13.431111F, 13.431111F, 0.0F, 29.629629F, 0.0F);
      ((Path)localObject3).cubicTo(46.56889F, 0.0F, 60.0F, 13.431111F, 60.0F, 30.370371F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(16.671656F, 32.738823F);
      ((Path)localObject2).cubicTo(16.300711F, 32.33078F, 16.3125F, 31.6875F, 16.710756F, 31.289244F);
      ((Path)localObject2).lineTo(17.289244F, 30.710756F);
      ((Path)localObject2).cubicTo(17.681784F, 30.318216F, 18.34375F, 30.300781F, 18.752621F, 30.658543F);
      ((Path)localObject2).lineTo(25.247379F, 36.341457F);
      ((Path)localObject2).cubicTo(25.66304F, 36.705162F, 26.347137F, 36.704933F, 26.759602F, 36.35434F);
      ((Path)localObject2).lineTo(45.240398F, 20.645662F);
      ((Path)localObject2).cubicTo(45.659916F, 20.289072F, 46.3125F, 20.3125F, 46.710758F, 20.710756F);
      ((Path)localObject2).lineTo(47.289242F, 21.289244F);
      ((Path)localObject2).cubicTo(47.681782F, 21.681784F, 47.671932F, 22.313156F, 47.280529F, 22.686768F);
      ((Path)localObject2).lineTo(26.719471F, 42.313232F);
      ((Path)localObject2).cubicTo(26.322119F, 42.692524F, 25.70072F, 42.670792F, 25.328344F, 42.261177F);
      ((Path)localObject2).lineTo(16.671656F, 32.738823F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.fav_list_success
 * JD-Core Version:    0.7.0.1
 */