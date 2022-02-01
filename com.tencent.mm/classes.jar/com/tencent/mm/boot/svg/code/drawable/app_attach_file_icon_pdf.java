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

public class app_attach_file_icon_pdf
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
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.instancePaint((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(40.0F, 0.0F);
      ((Path)localObject3).lineTo(40.0F, 40.0F);
      ((Path)localObject3).lineTo(0.0F, 40.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-1686720);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(16.0F, 0.0F);
      ((Path)localObject2).lineTo(24.0F, 8.0F);
      ((Path)localObject2).lineTo(23.999863F, 1.049432F);
      ((Path)localObject2).cubicTo(23.999954F, 1.055166F, 24.0F, 1.060911F, 24.0F, 1.066667F);
      ((Path)localObject2).lineTo(24.0F, 30.933332F);
      ((Path)localObject2).cubicTo(24.0F, 31.522438F, 23.522438F, 32.0F, 22.933332F, 32.0F);
      ((Path)localObject2).lineTo(1.066667F, 32.0F);
      ((Path)localObject2).cubicTo(0.4775629F, 32.0F, 2.609151E-015F, 31.522438F, 0.0F, 30.933332F);
      ((Path)localObject2).lineTo(0.0F, 1.066667F);
      ((Path)localObject2).cubicTo(-7.21444E-017F, 0.4775629F, 0.4775629F, 5.523058E-016F, 1.066667F, 0.0F);
      ((Path)localObject2).lineTo(16.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(24.0F, 8.0F);
      ((Path)localObject1).lineTo(17.066668F, 8.0F);
      ((Path)localObject1).cubicTo(16.477562F, 8.0F, 16.0F, 7.522437F, 16.0F, 6.933333F);
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(5.870833F, 22.933332F);
      ((Path)localObject1).lineTo(5.870833F, 20.945833F);
      ((Path)localObject1).lineTo(7.0875F, 20.945833F);
      ((Path)localObject1).cubicTo(8.304167F, 20.945833F, 9.158334F, 20.133333F, 9.158334F, 18.933332F);
      ((Path)localObject1).cubicTo(9.158334F, 17.733334F, 8.329166F, 16.920834F, 7.133333F, 16.920834F);
      ((Path)localObject1).lineTo(4.795833F, 16.920834F);
      ((Path)localObject1).lineTo(4.795833F, 22.933332F);
      ((Path)localObject1).lineTo(5.870833F, 22.933332F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(6.845833F, 20.079166F);
      ((Path)localObject1).lineTo(5.870833F, 20.079166F);
      ((Path)localObject1).lineTo(5.870833F, 17.799999F);
      ((Path)localObject1).lineTo(6.85F, 17.799999F);
      ((Path)localObject1).cubicTo(7.620833F, 17.799999F, 8.066667F, 18.2125F, 8.066667F, 18.933332F);
      ((Path)localObject1).cubicTo(8.066667F, 19.6625F, 7.616667F, 20.079166F, 6.845833F, 20.079166F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(12.1375F, 22.933332F);
      ((Path)localObject1).cubicTo(13.9375F, 22.933332F, 14.995833F, 21.816668F, 14.995833F, 19.9125F);
      ((Path)localObject1).cubicTo(14.995833F, 18.008333F, 13.933333F, 16.920834F, 12.1375F, 16.920834F);
      ((Path)localObject1).lineTo(9.941667F, 16.920834F);
      ((Path)localObject1).lineTo(9.941667F, 22.933332F);
      ((Path)localObject1).lineTo(12.1375F, 22.933332F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(12.025F, 22.025F);
      ((Path)localObject1).lineTo(11.016666F, 22.025F);
      ((Path)localObject1).lineTo(11.016666F, 17.829166F);
      ((Path)localObject1).lineTo(12.025F, 17.829166F);
      ((Path)localObject1).cubicTo(13.225F, 17.829166F, 13.9F, 18.570833F, 13.9F, 19.916666F);
      ((Path)localObject1).cubicTo(13.9F, 21.2875F, 13.233334F, 22.025F, 12.025F, 22.025F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(16.920834F, 22.933332F);
      ((Path)localObject1).lineTo(16.920834F, 20.479166F);
      ((Path)localObject1).lineTo(19.441668F, 20.479166F);
      ((Path)localObject1).lineTo(19.441668F, 19.604166F);
      ((Path)localObject1).lineTo(16.920834F, 19.604166F);
      ((Path)localObject1).lineTo(16.920834F, 17.829166F);
      ((Path)localObject1).lineTo(19.679167F, 17.829166F);
      ((Path)localObject1).lineTo(19.679167F, 16.920834F);
      ((Path)localObject1).lineTo(15.845833F, 16.920834F);
      ((Path)localObject1).lineTo(15.845833F, 22.933332F);
      ((Path)localObject1).lineTo(16.920834F, 22.933332F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_pdf
 * JD-Core Version:    0.7.0.1
 */