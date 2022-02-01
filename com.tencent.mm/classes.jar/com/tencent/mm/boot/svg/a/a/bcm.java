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

public final class bcm
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      Paint localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-2147483648);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 9.6F);
      localPath.cubicTo(0.0F, 4.298066F, 4.298066F, 0.0F, 9.6F, 0.0F);
      localPath.lineTo(86.400002F, 0.0F);
      localPath.cubicTo(91.701935F, 0.0F, 96.0F, 4.298066F, 96.0F, 9.6F);
      localPath.lineTo(96.0F, 86.400002F);
      localPath.cubicTo(96.0F, 91.701935F, 91.701935F, 96.0F, 86.400002F, 96.0F);
      localPath.lineTo(9.6F, 96.0F);
      localPath.cubicTo(4.298066F, 96.0F, 0.0F, 91.701935F, 0.0F, 86.400002F);
      localPath.lineTo(0.0F, 9.6F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 20.571428F, 0.0F, 1.0F, 25.714287F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 33.428574F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(43.885715F, 0.0F);
      ((Path)localObject1).lineTo(52.114285F, 0.0F);
      ((Path)localObject1).cubicTo(53.629124F, -2.474211E-015F, 54.857143F, 1.247207F, 54.857143F, 2.785714F);
      ((Path)localObject1).lineTo(54.857143F, 30.642857F);
      ((Path)localObject1).cubicTo(54.857143F, 32.181366F, 53.629124F, 33.42857F, 52.114285F, 33.42857F);
      ((Path)localObject1).lineTo(13.714286F, 33.42857F);
      ((Path)localObject1).cubicTo(12.199448F, 33.42857F, 10.971429F, 32.181366F, 10.971429F, 30.642857F);
      ((Path)localObject1).lineTo(10.971429F, 22.285715F);
      ((Path)localObject1).lineTo(14.262857F, 22.285715F);
      ((Path)localObject1).lineTo(14.262857F, 30.085714F);
      ((Path)localObject1).lineTo(51.565716F, 30.085714F);
      ((Path)localObject1).lineTo(51.565716F, 3.342857F);
      ((Path)localObject1).lineTo(43.885715F, 3.342857F);
      ((Path)localObject1).lineTo(43.885715F, 0.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      ((Paint)localObject1).setStrokeWidth(2.88F);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(1.44F, 14.982857F);
      ((Path)localObject2).cubicTo(1.44F, 13.657373F, 2.514517F, 12.582857F, 3.84F, 12.582857F);
      ((Path)localObject2).lineTo(40.045712F, 12.582857F);
      ((Path)localObject2).cubicTo(41.371197F, 12.582857F, 42.445713F, 13.657373F, 42.445713F, 14.982857F);
      ((Path)localObject2).lineTo(42.445713F, 40.731426F);
      ((Path)localObject2).cubicTo(42.445713F, 42.056911F, 41.371197F, 43.131428F, 40.045712F, 43.131428F);
      ((Path)localObject2).lineTo(3.84F, 43.131428F);
      ((Path)localObject2).cubicTo(2.514517F, 43.131428F, 1.44F, 42.056911F, 1.44F, 40.731426F);
      ((Path)localObject2).lineTo(1.44F, 14.982857F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bcm
 * JD-Core Version:    0.7.0.1
 */