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

public class icons_filled_contacts
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(3.0F, 60.0F);
      ((Path)localObject).lineTo(3.0F, 57.946388F);
      ((Path)localObject).cubicTo(3.0F, 55.891125F, 4.494453F, 53.495724F, 6.342293F, 52.593998F);
      ((Path)localObject).lineTo(23.323353F, 44.30743F);
      ((Path)localObject).cubicTo(25.786131F, 43.105621F, 26.358778F, 40.443787F, 24.580336F, 38.335918F);
      ((Path)localObject).lineTo(23.495739F, 37.050415F);
      ((Path)localObject).cubicTo(21.288954F, 34.434856F, 19.5F, 29.548489F, 19.5F, 26.127872F);
      ((Path)localObject).lineTo(19.5F, 20.998741F);
      ((Path)localObject).cubicTo(19.5F, 14.37202F, 24.886068F, 9.0F, 31.5F, 9.0F);
      ((Path)localObject).cubicTo(38.127419F, 9.0F, 43.5F, 14.378941F, 43.5F, 21.000622F);
      ((Path)localObject).lineTo(43.5F, 26.130558F);
      ((Path)localObject).cubicTo(43.5F, 29.547888F, 41.702797F, 34.448582F, 39.504261F, 37.054718F);
      ((Path)localObject).lineTo(38.419662F, 38.340397F);
      ((Path)localObject).cubicTo(36.651096F, 40.436852F, 37.203564F, 43.105194F, 39.676647F, 44.311531F);
      ((Path)localObject).lineTo(56.657707F, 52.594673F);
      ((Path)localObject).cubicTo(58.503605F, 53.495079F, 60.0F, 55.875511F, 60.0F, 57.946388F);
      ((Path)localObject).lineTo(60.0F, 60.0F);
      ((Path)localObject).cubicTo(60.0F, 61.656853F, 58.656853F, 63.0F, 57.0F, 63.0F);
      ((Path)localObject).lineTo(6.0F, 63.0F);
      ((Path)localObject).cubicTo(4.343146F, 63.0F, 3.0F, 61.656853F, 3.0F, 60.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(60.0F, 43.5F);
      ((Path)localObject).lineTo(69.0F, 43.5F);
      ((Path)localObject).lineTo(69.0F, 48.0F);
      ((Path)localObject).lineTo(60.0F, 48.0F);
      ((Path)localObject).lineTo(60.0F, 43.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(54.0F, 34.5F);
      ((Path)localObject).lineTo(69.0F, 34.5F);
      ((Path)localObject).lineTo(69.0F, 39.0F);
      ((Path)localObject).lineTo(54.0F, 39.0F);
      ((Path)localObject).lineTo(54.0F, 34.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.0F, 25.5F);
      ((Path)localObject).lineTo(69.0F, 25.5F);
      ((Path)localObject).lineTo(69.0F, 30.0F);
      ((Path)localObject).lineTo(48.0F, 30.0F);
      ((Path)localObject).lineTo(48.0F, 25.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_contacts
 * JD-Core Version:    0.7.0.1
 */