package com.tencent.mm.boot.svg.a.a;

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

public final class ako
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      c.a((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      arrayOfFloat = c.a(arrayOfFloat, 0.9816272F, 0.190809F, -1.876319F, -0.190809F, 0.9816272F, 4.513677F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(22.5F, 6.0F);
      localPath.cubicTo(24.985281F, 6.0F, 27.0F, 8.686291F, 27.0F, 12.0F);
      localPath.cubicTo(27.0F, 15.313709F, 24.985281F, 18.0F, 22.5F, 18.0F);
      localPath.cubicTo(20.014719F, 18.0F, 18.0F, 15.313709F, 18.0F, 12.0F);
      localPath.cubicTo(18.0F, 8.686291F, 20.014719F, 6.0F, 22.5F, 6.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      arrayOfFloat = c.a(arrayOfFloat, 0.9986295F, 0.05233596F, -0.5974791F, -0.05233596F, 0.9986295F, 1.783196F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(33.75F, 7.5F);
      ((Path)localObject1).cubicTo(35.821068F, 7.5F, 37.5F, 9.649033F, 37.5F, 12.3F);
      ((Path)localObject1).cubicTo(37.5F, 14.950968F, 35.821068F, 17.1F, 33.75F, 17.1F);
      ((Path)localObject1).cubicTo(31.678932F, 17.1F, 30.0F, 14.950968F, 30.0F, 12.3F);
      ((Path)localObject1).cubicTo(30.0F, 9.649033F, 31.678932F, 7.5F, 33.75F, 7.5F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(42.0F, 11.25F);
      ((Path)localObject2).cubicTo(43.656853F, 11.25F, 45.0F, 12.928932F, 45.0F, 15.0F);
      ((Path)localObject2).cubicTo(45.0F, 17.071068F, 43.656853F, 18.75F, 42.0F, 18.75F);
      ((Path)localObject2).cubicTo(40.343147F, 18.75F, 39.0F, 17.071068F, 39.0F, 15.0F);
      ((Path)localObject2).cubicTo(39.0F, 12.928932F, 40.343147F, 11.25F, 42.0F, 11.25F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(48.75F, 15.0F);
      ((Path)localObject2).cubicTo(49.992641F, 15.0F, 51.0F, 16.343145F, 51.0F, 18.0F);
      ((Path)localObject2).cubicTo(51.0F, 19.656855F, 49.992641F, 21.0F, 48.75F, 21.0F);
      ((Path)localObject2).cubicTo(47.507359F, 21.0F, 46.5F, 19.656855F, 46.5F, 18.0F);
      ((Path)localObject2).cubicTo(46.5F, 16.343145F, 47.507359F, 15.0F, 48.75F, 15.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(31.130859F, 46.280273F);
      ((Path)localObject1).cubicTo(32.262218F, 42.195225F, 29.339392F, 38.728355F, 23.910645F, 34.257202F);
      ((Path)localObject1).cubicTo(18.481897F, 29.786047F, 20.38916F, 21.634277F, 28.19458F, 19.817139F);
      ((Path)localObject1).cubicTo(36.0F, 18.0F, 52.963871F, 22.421211F, 53.517334F, 36.619263F);
      ((Path)localObject1).cubicTo(54.070797F, 50.817314F, 44.246662F, 67.374153F, 34.348709F, 65.900803F);
      ((Path)localObject1).cubicTo(24.450758F, 64.427452F, 29.999498F, 50.365322F, 31.130859F, 46.280273F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ako
 * JD-Core Version:    0.7.0.1
 */