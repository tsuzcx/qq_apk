package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class finder_outlined_fav
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
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      Object localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-2565928);
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(72.0F, 0.0F);
      localPath.lineTo(72.0F, 72.0F);
      localPath.lineTo(0.0F, 72.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-2565928);
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(72.0F, 0.0F);
      localPath.lineTo(72.0F, 72.0F);
      localPath.lineTo(0.0F, 72.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(3.6F);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(13.8F, 23.73F);
      localPath.cubicTo(13.8F, 22.387947F, 14.887947F, 21.299999F, 16.23F, 21.299999F);
      localPath.lineTo(55.77F, 21.299999F);
      localPath.cubicTo(57.112053F, 21.299999F, 58.200001F, 22.387947F, 58.200001F, 23.73F);
      localPath.lineTo(58.200001F, 58.77F);
      localPath.cubicTo(58.200001F, 60.112053F, 57.112053F, 61.200001F, 55.77F, 61.200001F);
      localPath.lineTo(16.23F, 61.200001F);
      localPath.cubicTo(14.887947F, 61.200001F, 13.8F, 60.112053F, 13.8F, 58.77F);
      localPath.lineTo(13.8F, 23.73F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(16.5F, 11.958F);
      ((Path)localObject2).cubicTo(16.5F, 11.152769F, 17.152769F, 10.5F, 17.958F, 10.5F);
      ((Path)localObject2).lineTo(54.042F, 10.5F);
      ((Path)localObject2).cubicTo(54.847233F, 10.5F, 55.5F, 11.152769F, 55.5F, 11.958F);
      ((Path)localObject2).lineTo(55.5F, 12.642F);
      ((Path)localObject2).cubicTo(55.5F, 13.447231F, 54.847233F, 14.1F, 54.042F, 14.1F);
      ((Path)localObject2).lineTo(17.958F, 14.1F);
      ((Path)localObject2).cubicTo(17.152769F, 14.1F, 16.5F, 13.447231F, 16.5F, 12.642F);
      ((Path)localObject2).lineTo(16.5F, 11.958F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(3.375F);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(35.999905F, 29.044691F);
      ((Path)localObject1).lineTo(32.455849F, 36.553661F);
      ((Path)localObject1).lineTo(24.349121F, 37.785435F);
      ((Path)localObject1).lineTo(30.220894F, 43.77037F);
      ((Path)localObject1).lineTo(28.853815F, 52.105042F);
      ((Path)localObject1).lineTo(35.999905F, 48.176556F);
      ((Path)localObject1).lineTo(43.145996F, 52.105042F);
      ((Path)localObject1).lineTo(41.778919F, 43.77037F);
      ((Path)localObject1).lineTo(47.650692F, 37.785435F);
      ((Path)localObject1).lineTo(39.543961F, 36.553661F);
      ((Path)localObject1).lineTo(35.999905F, 29.044691F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_outlined_fav
 * JD-Core Version:    0.7.0.1
 */