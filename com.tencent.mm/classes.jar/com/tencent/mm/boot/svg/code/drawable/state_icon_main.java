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

public class state_icon_main
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
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(3.339746F, 7.0F);
      ((Path)localObject).cubicTo(6.10117F, 2.217074F, 12.217073F, 0.5783222F, 17.0F, 3.339746F);
      ((Path)localObject).lineTo(17.0F, 3.339746F);
      ((Path)localObject).lineTo(17.097633F, 3.403883F);
      ((Path)localObject).cubicTo(17.499458F, 3.702578F, 17.622444F, 4.261643F, 17.366026F, 4.705771F);
      ((Path)localObject).cubicTo(17.109608F, 5.1499F, 16.563951F, 5.322924F, 16.104361F, 5.124281F);
      ((Path)localObject).lineTo(16.104361F, 5.124281F);
      ((Path)localObject).lineTo(16.0F, 5.071797F);
      ((Path)localObject).cubicTo(12.173659F, 2.862658F, 7.280936F, 4.173659F, 5.071797F, 8.0F);
      ((Path)localObject).cubicTo(3.591467F, 10.564006F, 3.691769F, 13.606845F, 5.07037F, 16.000193F);
      ((Path)localObject).lineTo(5.071797F, 16.0F);
      ((Path)localObject).cubicTo(5.276962F, 16.355358F, 5.505274F, 16.68902F, 5.753728F, 17.000181F);
      ((Path)localObject).cubicTo(5.774791F, 17.028175F, 5.79742F, 17.056076F, 5.820252F, 17.083838F);
      ((Path)localObject).lineTo(5.753728F, 17.000181F);
      ((Path)localObject).cubicTo(5.866292F, 17.141157F, 5.982991F, 17.277514F, 6.103544F, 17.409176F);
      ((Path)localObject).cubicTo(6.126354F, 17.434662F, 6.149538F, 17.459597F, 6.1729F, 17.484398F);
      ((Path)localObject).lineTo(6.103544F, 17.409176F);
      ((Path)localObject).cubicTo(6.13994F, 17.448925F, 6.176687F, 17.488247F, 6.213778F, 17.52714F);
      ((Path)localObject).lineTo(6.1729F, 17.484398F);
      ((Path)localObject).cubicTo(6.695265F, 18.038975F, 7.306295F, 18.527693F, 8.0F, 18.928204F);
      ((Path)localObject).lineTo(8.0F, 18.928204F);
      ((Path)localObject).lineTo(8.108397F, 18.991055F);
      ((Path)localObject).cubicTo(10.484714F, 20.310894F, 13.474615F, 20.386234F, 16.0F, 18.928204F);
      ((Path)localObject).cubicTo(19.826342F, 16.719065F, 21.137342F, 11.826341F, 18.928204F, 8.0F);
      ((Path)localObject).lineTo(18.875719F, 7.895639F);
      ((Path)localObject).cubicTo(18.677076F, 7.436049F, 18.8501F, 6.890392F, 19.29423F, 6.633975F);
      ((Path)localObject).cubicTo(19.738358F, 6.377557F, 20.297422F, 6.500542F, 20.596117F, 6.902367F);
      ((Path)localObject).lineTo(20.660254F, 7.0F);
      ((Path)localObject).cubicTo(23.421679F, 11.782927F, 21.782927F, 17.89883F, 17.0F, 20.660254F);
      ((Path)localObject).cubicTo(13.028214F, 22.953365F, 8.137232F, 22.212206F, 5.011252F, 19.156004F);
      ((Path)localObject).cubicTo(4.98872F, 19.13382F, 4.966528F, 19.111971F, 4.944453F, 19.090033F);
      ((Path)localObject).cubicTo(4.904726F, 19.050493F, 4.865265F, 19.010504F, 4.826102F, 18.970137F);
      ((Path)localObject).cubicTo(1.784838F, 15.843189F, 1.051224F, 10.963836F, 3.339746F, 7.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.state_icon_main
 * JD-Core Version:    0.7.0.1
 */