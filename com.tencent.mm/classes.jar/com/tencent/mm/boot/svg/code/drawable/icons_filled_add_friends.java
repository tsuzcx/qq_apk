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

public class icons_filled_add_friends
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(56.249981F, 32.25F);
      ((Path)localObject).lineTo(56.249981F, 24.0F);
      ((Path)localObject).lineTo(60.749981F, 24.0F);
      ((Path)localObject).lineTo(60.749981F, 32.25F);
      ((Path)localObject).lineTo(69.0F, 32.25F);
      ((Path)localObject).lineTo(69.0F, 36.75F);
      ((Path)localObject).lineTo(60.749981F, 36.75F);
      ((Path)localObject).lineTo(60.749981F, 45.0F);
      ((Path)localObject).lineTo(56.249981F, 45.0F);
      ((Path)localObject).lineTo(56.249981F, 36.75F);
      ((Path)localObject).lineTo(48.0F, 36.75F);
      ((Path)localObject).lineTo(48.0F, 34.5F);
      ((Path)localObject).lineTo(48.0F, 32.25F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(23.495739F, 37.050415F);
      ((Path)localObject).cubicTo(21.288954F, 34.434856F, 19.5F, 29.548491F, 19.5F, 26.127872F);
      ((Path)localObject).lineTo(19.5F, 20.998741F);
      ((Path)localObject).cubicTo(19.5F, 14.372019F, 24.886068F, 9.0F, 31.5F, 9.0F);
      ((Path)localObject).cubicTo(38.127419F, 9.0F, 43.5F, 14.378941F, 43.5F, 21.000622F);
      ((Path)localObject).lineTo(43.5F, 26.130556F);
      ((Path)localObject).cubicTo(43.5F, 29.547886F, 41.702797F, 34.448578F, 39.504261F, 37.054718F);
      ((Path)localObject).lineTo(38.419662F, 38.340397F);
      ((Path)localObject).cubicTo(36.651096F, 40.436852F, 37.20356F, 43.10519F, 39.676647F, 44.311531F);
      ((Path)localObject).lineTo(56.657707F, 52.594673F);
      ((Path)localObject).cubicTo(58.503605F, 53.495079F, 60.0F, 55.875511F, 60.0F, 57.946392F);
      ((Path)localObject).lineTo(60.0F, 60.004688F);
      ((Path)localObject).cubicTo(60.0F, 61.658955F, 58.647224F, 63.000004F, 56.995712F, 63.000004F);
      ((Path)localObject).lineTo(6.004292F, 63.000004F);
      ((Path)localObject).cubicTo(4.345069F, 63.000004F, 3.000003F, 61.667271F, 3.000003F, 60.004688F);
      ((Path)localObject).lineTo(3.000003F, 57.946392F);
      ((Path)localObject).cubicTo(3.000003F, 55.891125F, 4.494455F, 53.495728F, 6.342296F, 52.594002F);
      ((Path)localObject).lineTo(23.323357F, 44.307434F);
      ((Path)localObject).cubicTo(25.786137F, 43.105625F, 26.358782F, 40.443794F, 24.580339F, 38.335922F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_add_friends
 * JD-Core Version:    0.7.0.1
 */