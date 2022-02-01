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

public class icons_outlined_stick_on
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
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      c.instancePaint((Paint)localObject1, paramVarArgs).setStrokeWidth(1.0F);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(24.0F, 0.0F);
      ((Path)localObject1).lineTo(24.0F, 24.0F);
      ((Path)localObject1).lineTo(0.0F, 24.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      Object localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(8.75F, 11.5F);
      ((Path)localObject1).lineTo(21.25F, 11.5F);
      ((Path)localObject1).cubicTo(21.664213F, 11.5F, 22.0F, 11.835787F, 22.0F, 12.25F);
      ((Path)localObject1).cubicTo(22.0F, 12.664213F, 21.664213F, 13.0F, 21.25F, 13.0F);
      ((Path)localObject1).lineTo(8.75F, 13.0F);
      ((Path)localObject1).cubicTo(8.335787F, 13.0F, 8.0F, 12.664213F, 8.0F, 12.25F);
      ((Path)localObject1).cubicTo(8.0F, 11.835787F, 8.335787F, 11.5F, 8.75F, 11.5F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 76, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(2.0F, 12.25F);
      ((Path)localObject2).cubicTo(2.0F, 11.835787F, 2.335786F, 11.5F, 2.75F, 11.5F);
      ((Path)localObject2).lineTo(5.25F, 11.5F);
      ((Path)localObject2).cubicTo(5.664214F, 11.5F, 6.0F, 11.835787F, 6.0F, 12.25F);
      ((Path)localObject2).lineTo(6.0F, 12.25F);
      ((Path)localObject2).cubicTo(6.0F, 12.664213F, 5.664214F, 13.0F, 5.25F, 13.0F);
      ((Path)localObject2).lineTo(2.75F, 13.0F);
      ((Path)localObject2).cubicTo(2.335786F, 13.0F, 2.0F, 12.664213F, 2.0F, 12.25F);
      ((Path)localObject2).lineTo(2.0F, 12.25F);
      ((Path)localObject2).close();
      localCanvas.saveLayerAlpha(null, 76, 31);
      localCanvas.drawPath((Path)localObject2, c.instancePaint((Paint)localObject1, paramVarArgs));
      localCanvas.restore();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(8.75F, 16.5F);
      ((Path)localObject1).lineTo(21.25F, 16.5F);
      ((Path)localObject1).cubicTo(21.664213F, 16.5F, 22.0F, 16.835787F, 22.0F, 17.25F);
      ((Path)localObject1).cubicTo(22.0F, 17.664213F, 21.664213F, 18.0F, 21.25F, 18.0F);
      ((Path)localObject1).lineTo(8.75F, 18.0F);
      ((Path)localObject1).cubicTo(8.335787F, 18.0F, 8.0F, 17.664213F, 8.0F, 17.25F);
      ((Path)localObject1).cubicTo(8.0F, 16.835787F, 8.335787F, 16.5F, 8.75F, 16.5F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 76, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(2.0F, 17.25F);
      ((Path)localObject2).cubicTo(2.0F, 16.835787F, 2.335786F, 16.5F, 2.75F, 16.5F);
      ((Path)localObject2).lineTo(5.25F, 16.5F);
      ((Path)localObject2).cubicTo(5.664214F, 16.5F, 6.0F, 16.835787F, 6.0F, 17.25F);
      ((Path)localObject2).lineTo(6.0F, 17.25F);
      ((Path)localObject2).cubicTo(6.0F, 17.664213F, 5.664214F, 18.0F, 5.25F, 18.0F);
      ((Path)localObject2).lineTo(2.75F, 18.0F);
      ((Path)localObject2).cubicTo(2.335786F, 18.0F, 2.0F, 17.664213F, 2.0F, 17.25F);
      ((Path)localObject2).lineTo(2.0F, 17.25F);
      ((Path)localObject2).close();
      localCanvas.saveLayerAlpha(null, 76, 31);
      localCanvas.drawPath((Path)localObject2, c.instancePaint((Paint)localObject1, paramVarArgs));
      localCanvas.restore();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(9.0F, 6.0F);
      ((Path)localObject1).lineTo(21.0F, 6.0F);
      ((Path)localObject1).cubicTo(21.552284F, 6.0F, 22.0F, 6.447715F, 22.0F, 7.0F);
      ((Path)localObject1).cubicTo(22.0F, 7.552285F, 21.552284F, 8.0F, 21.0F, 8.0F);
      ((Path)localObject1).lineTo(9.0F, 8.0F);
      ((Path)localObject1).cubicTo(8.447715F, 8.0F, 8.0F, 7.552285F, 8.0F, 7.0F);
      ((Path)localObject1).cubicTo(8.0F, 6.447715F, 8.447715F, 6.0F, 9.0F, 6.0F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 128, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(2.0F, 7.0F);
      ((Path)localObject1).cubicTo(2.0F, 6.447715F, 2.447715F, 6.0F, 3.0F, 6.0F);
      ((Path)localObject1).lineTo(5.0F, 6.0F);
      ((Path)localObject1).cubicTo(5.552285F, 6.0F, 6.0F, 6.447715F, 6.0F, 7.0F);
      ((Path)localObject1).lineTo(6.0F, 7.0F);
      ((Path)localObject1).cubicTo(6.0F, 7.552285F, 5.552285F, 8.0F, 5.0F, 8.0F);
      ((Path)localObject1).lineTo(3.0F, 8.0F);
      ((Path)localObject1).cubicTo(2.447715F, 8.0F, 2.0F, 7.552285F, 2.0F, 7.0F);
      ((Path)localObject1).lineTo(2.0F, 7.0F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 128, 31);
      localCanvas.drawPath((Path)localObject1, c.instancePaint(localPaint, paramVarArgs));
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_stick_on
 * JD-Core Version:    0.7.0.1
 */