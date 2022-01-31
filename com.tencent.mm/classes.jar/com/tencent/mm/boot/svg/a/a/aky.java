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

public final class aky
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.f(paramVarArgs);
      float[] arrayOfFloat = c.e(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(5.454546F, 2.4F);
      ((Path)localObject2).lineTo(17.750187F, 2.4F);
      ((Path)localObject2).lineTo(17.750187F, 7.043026F);
      ((Path)localObject2).lineTo(6.967732F, 7.043026F);
      ((Path)localObject2).lineTo(6.967732F, 17.650599F);
      ((Path)localObject2).lineTo(2.4F, 17.650599F);
      ((Path)localObject2).lineTo(2.4F, 5.454546F);
      ((Path)localObject2).cubicTo(2.4F, 3.767567F, 3.767567F, 2.4F, 5.454546F, 2.4F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(66.538422F, 2.4F);
      ((Path)localObject2).cubicTo(68.225395F, 2.4F, 69.592964F, 3.767567F, 69.592964F, 5.454546F);
      ((Path)localObject2).lineTo(69.592964F, 17.70965F);
      ((Path)localObject2).lineTo(64.933594F, 17.70965F);
      ((Path)localObject2).lineTo(64.933594F, 7.089308F);
      ((Path)localObject2).lineTo(54.422222F, 7.089308F);
      ((Path)localObject2).lineTo(54.422222F, 2.4F);
      ((Path)localObject2).lineTo(66.538422F, 2.4F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(66.538422F, 69.599998F);
      ((Path)localObject2).lineTo(57.381817F, 69.599998F);
      ((Path)localObject2).lineTo(57.381817F, 65.289803F);
      ((Path)localObject2).lineTo(64.998459F, 65.353004F);
      ((Path)localObject2).lineTo(64.998459F, 54.332905F);
      ((Path)localObject2).lineTo(69.592964F, 54.332905F);
      ((Path)localObject2).lineTo(69.592964F, 66.545456F);
      ((Path)localObject2).cubicTo(69.592964F, 68.232437F, 68.225395F, 69.599998F, 66.538422F, 69.599998F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(5.454546F, 69.599998F);
      ((Path)localObject2).cubicTo(3.767567F, 69.599998F, 2.4F, 68.232437F, 2.4F, 66.545456F);
      ((Path)localObject2).lineTo(2.4F, 54.360416F);
      ((Path)localObject2).lineTo(6.914314F, 54.360416F);
      ((Path)localObject2).lineTo(6.914314F, 65.381577F);
      ((Path)localObject2).lineTo(14.611146F, 65.381577F);
      ((Path)localObject2).lineTo(14.611146F, 69.599998F);
      ((Path)localObject2).lineTo(5.454546F, 69.599998F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(26.836363F, 2.4F);
      ((Path)localObject2).lineTo(45.163635F, 2.4F);
      ((Path)localObject2).lineTo(45.163635F, 6.981818F);
      ((Path)localObject2).lineTo(26.836363F, 6.981818F);
      ((Path)localObject2).lineTo(26.836363F, 2.4F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(2.4F, 26.827253F);
      ((Path)localObject2).lineTo(6.981818F, 26.827253F);
      ((Path)localObject2).lineTo(6.981818F, 45.11161F);
      ((Path)localObject2).lineTo(2.4F, 45.11161F);
      ((Path)localObject2).lineTo(2.4F, 26.827253F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(65.018181F, 26.836363F);
      ((Path)localObject2).lineTo(69.599998F, 26.836363F);
      ((Path)localObject2).lineTo(69.599998F, 45.12072F);
      ((Path)localObject2).lineTo(65.018181F, 45.12072F);
      ((Path)localObject2).lineTo(65.018181F, 26.836363F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(4.2F);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(10.1F, 66.644447F);
      ((Path)localObject1).cubicTo(10.1F, 67.118256F, 10.480686F, 67.5F, 10.947369F, 67.5F);
      ((Path)localObject1).lineTo(61.052631F, 67.5F);
      ((Path)localObject1).cubicTo(61.519314F, 67.5F, 61.900002F, 67.118256F, 61.900002F, 66.644447F);
      ((Path)localObject1).lineTo(61.900002F, 64.621262F);
      ((Path)localObject1).cubicTo(61.900002F, 63.388382F, 60.891434F, 61.772232F, 59.793617F, 61.235245F);
      ((Path)localObject1).lineTo(43.11047F, 53.074818F);
      ((Path)localObject1).cubicTo(39.455238F, 51.286888F, 38.573559F, 47.065498F, 41.191284F, 43.953835F);
      ((Path)localObject1).lineTo(42.256855F, 42.687202F);
      ((Path)localObject1).cubicTo(44.101349F, 40.494667F, 45.689472F, 36.144264F, 45.689472F, 33.276772F);
      ((Path)localObject1).lineTo(45.689472F, 28.222836F);
      ((Path)localObject1).cubicTo(45.689472F, 22.855492F, 41.34779F, 18.5F, 36.0F, 18.5F);
      ((Path)localObject1).cubicTo(30.658215F, 18.5F, 26.310526F, 22.855927F, 26.310526F, 28.220982F);
      ((Path)localObject1).lineTo(26.310526F, 33.274124F);
      ((Path)localObject1).cubicTo(26.310526F, 36.147972F, 27.892551F, 40.483479F, 29.743053F, 42.68285F);
      ((Path)localObject1).lineTo(30.808622F, 43.94931F);
      ((Path)localObject1).cubicTo(33.431854F, 47.067089F, 32.54063F, 51.28413F, 28.889837F, 53.070625F);
      ((Path)localObject1).lineTo(12.206691F, 61.234428F);
      ((Path)localObject1).cubicTo(11.112965F, 61.769638F, 10.1F, 63.396774F, 10.1F, 64.621262F);
      ((Path)localObject1).lineTo(10.1F, 66.644447F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aky
 * JD-Core Version:    0.7.0.1
 */