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

public class icons_outlined_ocr
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
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-2565928);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(72.0F, 0.0F);
      localPath.lineTo(72.0F, 72.0F);
      localPath.lineTo(0.0F, 72.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath(localPath, c.instancePaint((Paint)localObject, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.6F, 48.0F);
      ((Path)localObject).lineTo(12.6F, 59.400002F);
      ((Path)localObject).lineTo(24.0F, 59.400002F);
      ((Path)localObject).lineTo(24.0F, 63.0F);
      ((Path)localObject).lineTo(12.0F, 63.0F);
      ((Path)localObject).cubicTo(10.461493F, 63.0F, 9.193479F, 61.841881F, 9.020184F, 60.349865F);
      ((Path)localObject).lineTo(9.0F, 60.0F);
      ((Path)localObject).lineTo(9.0F, 48.0F);
      ((Path)localObject).lineTo(12.6F, 48.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(63.0F, 48.0F);
      ((Path)localObject).lineTo(63.0F, 60.0F);
      ((Path)localObject).cubicTo(63.0F, 61.656853F, 61.656853F, 63.0F, 60.0F, 63.0F);
      ((Path)localObject).lineTo(48.0F, 63.0F);
      ((Path)localObject).lineTo(48.0F, 59.400002F);
      ((Path)localObject).lineTo(59.400002F, 59.400002F);
      ((Path)localObject).lineTo(59.400002F, 48.0F);
      ((Path)localObject).lineTo(63.0F, 48.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(38.549999F, 21.0F);
      ((Path)localObject).lineTo(48.900002F, 49.5F);
      ((Path)localObject).lineTo(44.543999F, 49.5F);
      ((Path)localObject).lineTo(42.033001F, 42.599998F);
      ((Path)localObject).lineTo(29.982F, 42.599998F);
      ((Path)localObject).lineTo(27.471001F, 49.5F);
      ((Path)localObject).lineTo(23.1F, 49.5F);
      ((Path)localObject).lineTo(33.48F, 21.0F);
      ((Path)localObject).lineTo(38.549999F, 21.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.008999F, 26.042032F);
      ((Path)localObject).lineTo(31.290001F, 39.0F);
      ((Path)localObject).lineTo(40.722F, 39.0F);
      ((Path)localObject).lineTo(36.008999F, 26.042032F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(24.0F, 9.0F);
      ((Path)localObject).lineTo(24.0F, 12.6F);
      ((Path)localObject).lineTo(12.6F, 12.6F);
      ((Path)localObject).lineTo(12.6F, 24.0F);
      ((Path)localObject).lineTo(9.0F, 24.0F);
      ((Path)localObject).lineTo(9.0F, 12.0F);
      ((Path)localObject).cubicTo(9.0F, 10.343145F, 10.343145F, 9.0F, 12.0F, 9.0F);
      ((Path)localObject).lineTo(24.0F, 9.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(60.0F, 9.0F);
      ((Path)localObject).cubicTo(61.538509F, 9.0F, 62.806522F, 10.15812F, 62.979816F, 11.650137F);
      ((Path)localObject).lineTo(63.0F, 12.0F);
      ((Path)localObject).lineTo(63.0F, 24.0F);
      ((Path)localObject).lineTo(59.400002F, 24.0F);
      ((Path)localObject).lineTo(59.400002F, 12.6F);
      ((Path)localObject).lineTo(48.0F, 12.6F);
      ((Path)localObject).lineTo(48.0F, 9.0F);
      ((Path)localObject).lineTo(60.0F, 9.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_ocr
 * JD-Core Version:    0.7.0.1
 */