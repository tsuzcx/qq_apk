package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class icons_outlined_live
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
      localObject = c.instancePaint((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setStrokeWidth(1.0F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(72.0F, 0.0F);
      localPath.lineTo(72.0F, 72.0F);
      localPath.lineTo(0.0F, 72.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.save();
      localObject = c.instancePaint((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(5.4F);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(36.0F, 8.700001F);
      localPath.cubicTo(51.077374F, 8.700001F, 63.299999F, 20.922626F, 63.299999F, 36.0F);
      localPath.cubicTo(63.299999F, 51.077374F, 51.077374F, 63.299999F, 36.0F, 63.299999F);
      localPath.cubicTo(20.922626F, 63.299999F, 8.700001F, 51.077374F, 8.700001F, 36.0F);
      localPath.cubicTo(8.700001F, 20.922626F, 20.922626F, 8.700001F, 36.0F, 8.700001F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 19.5F);
      ((Path)localObject).cubicTo(45.112698F, 19.5F, 52.5F, 26.887302F, 52.5F, 36.0F);
      ((Path)localObject).cubicTo(52.5F, 45.112698F, 45.112698F, 52.5F, 36.0F, 52.5F);
      ((Path)localObject).cubicTo(26.887302F, 52.5F, 19.5F, 45.112698F, 19.5F, 36.0F);
      ((Path)localObject).cubicTo(19.5F, 26.887302F, 26.887302F, 19.5F, 36.0F, 19.5F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_live
 * JD-Core Version:    0.7.0.1
 */