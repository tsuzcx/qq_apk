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

public class coin_normal
  extends c
{
  private final int height = 20;
  private final int width = 20;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 20;
      return 20;
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-8727808);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(14.660116F, 5.929586F);
      ((Path)localObject).cubicTo(13.89521F, 5.170589F, 12.896751F, 4.746091F, 11.80079F, 4.633592F);
      ((Path)localObject).cubicTo(11.662472F, 4.96959F, 11.447815F, 5.349088F, 11.123562F, 5.793086F);
      ((Path)localObject).cubicTo(10.205221F, 7.05158F, 8.798612F, 7.647828F, 8.798612F, 7.647828F);
      ((Path)localObject).cubicTo(8.798612F, 7.647828F, 10.273247F, 6.090085F, 10.447845F, 4.599842F);
      ((Path)localObject).cubicTo(10.534765F, 3.858095F, 10.381331F, 2.9341F, 10.048763F, 2.600351F);
      ((Path)localObject).cubicTo(9.850735F, 2.400102F, 9.511364F, 2.517102F, 9.483398F, 2.796101F);
      ((Path)localObject).cubicTo(9.438804F, 3.253598F, 9.267229F, 3.879845F, 8.818263F, 4.473843F);
      ((Path)localObject).cubicTo(8.458486F, 4.95009F, 7.695092F, 5.499088F, 7.422235F, 5.687337F);
      ((Path)localObject).cubicTo(6.764658F, 6.070585F, 6.130512F, 6.550582F, 5.547763F, 7.12883F);
      ((Path)localObject).cubicTo(2.698263F, 9.956316F, 2.157085F, 14.004797F, 4.339938F, 16.170786F);
      ((Path)localObject).cubicTo(6.522035F, 18.336027F, 10.602035F, 17.79978F, 13.451535F, 14.971542F);
      ((Path)localObject).cubicTo(16.30179F, 12.143306F, 16.842968F, 8.095575F, 14.660116F, 5.929586F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.coin_normal
 * JD-Core Version:    0.7.0.1
 */