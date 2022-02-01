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

public class app_attach_file_icon_rar
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-7645398);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(16.0F, 0.0F);
      ((Path)localObject2).lineTo(24.0F, 8.0F);
      ((Path)localObject2).lineTo(23.999853F, 0.8725936F);
      ((Path)localObject2).cubicTo(23.99995F, 0.8780137F, 24.0F, 0.8834456F, 24.0F, 0.888889F);
      ((Path)localObject2).lineTo(24.0F, 31.111111F);
      ((Path)localObject2).cubicTo(24.0F, 31.602032F, 23.602032F, 32.0F, 23.111111F, 32.0F);
      ((Path)localObject2).lineTo(0.888889F, 32.0F);
      ((Path)localObject2).cubicTo(0.397969F, 32.0F, 5.930974E-014F, 31.602032F, 5.684342E-014F, 31.111111F);
      ((Path)localObject2).lineTo(5.684342E-014F, 0.888889F);
      ((Path)localObject2).cubicTo(5.67833E-014F, 0.397969F, 0.397969F, 5.342697E-016F, 0.888889F, 0.0F);
      ((Path)localObject2).lineTo(16.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localObject2 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(24.0F, 8.0F);
      ((Path)localObject1).lineTo(16.888889F, 8.0F);
      ((Path)localObject1).cubicTo(16.397968F, 8.0F, 16.0F, 7.602031F, 16.0F, 7.111111F);
      ((Path)localObject1).lineTo(16.0F, 0.0F);
      ((Path)localObject1).lineTo(16.0F, 0.0F);
      ((Path)localObject1).lineTo(24.0F, 8.0F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 51, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(10.577778F, 10.666667F);
      ((Path)localObject2).cubicTo(10.332318F, 10.666667F, 10.133333F, 10.467682F, 10.133333F, 10.222222F);
      ((Path)localObject2).lineTo(10.133333F, 8.444445F);
      ((Path)localObject2).cubicTo(10.133333F, 8.198984F, 10.332318F, 8.0F, 10.577778F, 8.0F);
      ((Path)localObject2).lineTo(12.266666F, 8.0F);
      ((Path)localObject2).lineTo(12.266666F, 10.666667F);
      ((Path)localObject2).lineTo(13.422222F, 10.666667F);
      ((Path)localObject2).cubicTo(13.667682F, 10.666667F, 13.866667F, 10.865651F, 13.866667F, 11.111111F);
      ((Path)localObject2).lineTo(13.866667F, 12.888889F);
      ((Path)localObject2).cubicTo(13.866667F, 13.134349F, 13.667682F, 13.333333F, 13.422222F, 13.333333F);
      ((Path)localObject2).lineTo(11.733334F, 13.333333F);
      ((Path)localObject2).lineTo(11.733334F, 10.666667F);
      ((Path)localObject2).lineTo(10.577778F, 10.666667F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(13.422222F, 0.0F);
      ((Path)localObject2).cubicTo(13.667682F, 1.04209E-017F, 13.866667F, 0.1989846F, 13.866667F, 0.4444445F);
      ((Path)localObject2).lineTo(13.866667F, 2.222222F);
      ((Path)localObject2).cubicTo(13.866667F, 2.467682F, 13.667682F, 2.666667F, 13.422222F, 2.666667F);
      ((Path)localObject2).lineTo(12.266666F, 2.666667F);
      ((Path)localObject2).lineTo(12.266666F, 5.333334F);
      ((Path)localObject2).lineTo(13.422222F, 5.333334F);
      ((Path)localObject2).cubicTo(13.667682F, 5.333334F, 13.866667F, 5.532318F, 13.866667F, 5.777778F);
      ((Path)localObject2).lineTo(13.866667F, 7.555555F);
      ((Path)localObject2).cubicTo(13.866667F, 7.801015F, 13.667682F, 8.0F, 13.422222F, 8.0F);
      ((Path)localObject2).lineTo(11.733334F, 8.0F);
      ((Path)localObject2).lineTo(11.733334F, 5.333334F);
      ((Path)localObject2).lineTo(10.577778F, 5.333334F);
      ((Path)localObject2).cubicTo(10.332318F, 5.333334F, 10.133333F, 5.134349F, 10.133333F, 4.888889F);
      ((Path)localObject2).lineTo(10.133333F, 3.111111F);
      ((Path)localObject2).cubicTo(10.133333F, 2.865651F, 10.332318F, 2.666667F, 10.577778F, 2.666667F);
      ((Path)localObject2).lineTo(11.733334F, 2.666667F);
      ((Path)localObject2).lineTo(11.733334F, 0.0F);
      ((Path)localObject2).lineTo(13.422222F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(13.422222F, 14.933333F);
      ((Path)localObject1).cubicTo(13.667682F, 14.933333F, 13.866667F, 15.132318F, 13.866667F, 15.377778F);
      ((Path)localObject1).lineTo(13.866667F, 22.48889F);
      ((Path)localObject1).cubicTo(13.866667F, 22.734348F, 13.667682F, 22.933332F, 13.422222F, 22.933332F);
      ((Path)localObject1).lineTo(10.577778F, 22.933332F);
      ((Path)localObject1).cubicTo(10.332318F, 22.933332F, 10.133333F, 22.734348F, 10.133333F, 22.48889F);
      ((Path)localObject1).lineTo(10.133333F, 15.377778F);
      ((Path)localObject1).cubicTo(10.133333F, 15.132318F, 10.332318F, 14.933333F, 10.577778F, 14.933333F);
      ((Path)localObject1).lineTo(13.422222F, 14.933333F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(13.066667F, 19.200001F);
      ((Path)localObject1).lineTo(10.933333F, 19.200001F);
      ((Path)localObject1).lineTo(10.933333F, 22.133333F);
      ((Path)localObject1).lineTo(13.066667F, 22.133333F);
      ((Path)localObject1).lineTo(13.066667F, 19.200001F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_rar
 * JD-Core Version:    0.7.0.1
 */