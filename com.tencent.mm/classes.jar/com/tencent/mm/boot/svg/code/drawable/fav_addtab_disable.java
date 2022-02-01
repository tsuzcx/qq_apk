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

public class fav_addtab_disable
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
      localCanvas.saveLayerAlpha(null, 76, 31);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(1.207107F, 11.207107F);
      ((Path)localObject2).cubicTo(0.816583F, 10.816583F, 0.816583F, 10.183417F, 1.207107F, 9.792893F);
      ((Path)localObject2).lineTo(10.707107F, 0.2928932F);
      ((Path)localObject2).cubicTo(10.894643F, 0.1053568F, 11.148997F, 1.073389E-014F, 11.414213F, 1.021405E-014F);
      ((Path)localObject2).lineTo(18.0F, 0.0F);
      ((Path)localObject2).cubicTo(18.552284F, -1.014531E-016F, 19.0F, 0.4477153F, 19.0F, 1.0F);
      ((Path)localObject2).lineTo(19.0F, 7.585786F);
      ((Path)localObject2).cubicTo(19.0F, 7.851003F, 18.894644F, 8.105357F, 18.707108F, 8.292893F);
      ((Path)localObject2).lineTo(9.207107F, 17.792892F);
      ((Path)localObject2).cubicTo(8.816583F, 18.183418F, 8.183417F, 18.183418F, 7.792893F, 17.792892F);
      ((Path)localObject2).lineTo(1.207107F, 11.207107F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(17.799999F, 7.502944F);
      ((Path)localObject2).lineTo(17.799999F, 1.2F);
      ((Path)localObject2).lineTo(11.497056F, 1.2F);
      ((Path)localObject2).lineTo(2.197056F, 10.5F);
      ((Path)localObject2).lineTo(8.5F, 16.802944F);
      ((Path)localObject2).lineTo(17.799999F, 7.502944F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(14.0F, 6.5F);
      ((Path)localObject2).cubicTo(13.171573F, 6.5F, 12.5F, 5.828427F, 12.5F, 5.0F);
      ((Path)localObject2).cubicTo(12.5F, 4.171573F, 13.171573F, 3.5F, 14.0F, 3.5F);
      ((Path)localObject2).cubicTo(14.828427F, 3.5F, 15.5F, 4.171573F, 15.5F, 5.0F);
      ((Path)localObject2).cubicTo(15.5F, 5.828427F, 14.828427F, 6.5F, 14.0F, 6.5F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.fav_addtab_disable
 * JD-Core Version:    0.7.0.1
 */