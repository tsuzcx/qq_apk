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

public class actionbar_search_icon
  extends c
{
  private final int height = 96;
  private final int width = 79;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 79;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Object localObject4 = c.instancePaint(paramVarArgs);
      ((Paint)localObject4).setFlags(385);
      ((Paint)localObject4).setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(1.0F);
      ((Paint)localObject4).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject4).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject4).setStrokeMiter(4.0F);
      ((Paint)localObject4).setPathEffect(null);
      c.instancePaint((Paint)localObject4, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject3).setColor(-1);
      localObject4 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -9.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localObject3 = c.setMatrixFloatArray((float[])localObject4, 0.7071068F, 0.7071068F, -16.991314F, -0.7071068F, 0.7071068F, 40.313557F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(43.16711F, 52.7369F);
      ((Path)localObject1).cubicTo(54.452175F, 51.26688F, 63.16711F, 41.61657F, 63.16711F, 29.93078F);
      ((Path)localObject1).cubicTo(63.16711F, 17.228231F, 52.869659F, 6.93078F, 40.16711F, 6.93078F);
      ((Path)localObject1).cubicTo(27.46456F, 6.93078F, 17.167109F, 17.228231F, 17.167109F, 29.93078F);
      ((Path)localObject1).cubicTo(17.167109F, 41.61657F, 25.882044F, 51.26688F, 37.16711F, 52.7369F);
      ((Path)localObject1).lineTo(37.16711F, 73.400368F);
      ((Path)localObject1).cubicTo(37.16711F, 73.954346F, 37.618084F, 74.403435F, 38.157887F, 74.403435F);
      ((Path)localObject1).lineTo(42.176331F, 74.403435F);
      ((Path)localObject1).cubicTo(42.723522F, 74.403435F, 43.16711F, 73.964516F, 43.16711F, 73.400368F);
      ((Path)localObject1).lineTo(43.16711F, 52.7369F);
      ((Path)localObject1).lineTo(43.16711F, 52.7369F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(40.16711F, 46.930782F);
      ((Path)localObject1).cubicTo(49.55595F, 46.930782F, 57.16711F, 39.319622F, 57.16711F, 29.93078F);
      ((Path)localObject1).cubicTo(57.16711F, 20.541941F, 49.55595F, 12.93078F, 40.16711F, 12.93078F);
      ((Path)localObject1).cubicTo(30.778269F, 12.93078F, 23.167109F, 20.541941F, 23.167109F, 29.93078F);
      ((Path)localObject1).cubicTo(23.167109F, 39.319622F, 30.778269F, 46.930782F, 40.16711F, 46.930782F);
      ((Path)localObject1).lineTo(40.16711F, 46.930782F);
      ((Path)localObject1).lineTo(40.16711F, 46.930782F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.actionbar_search_icon
 * JD-Core Version:    0.7.0.1
 */