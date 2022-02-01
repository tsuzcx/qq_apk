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

public class appitem_del_btn_pressed
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
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
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-3194563);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(28.0F, 0.0F);
      localPath.lineTo(31.91F, 0.0F);
      localPath.cubicTo(46.529999F, 0.77F, 59.150002F, 13.36F, 60.0F, 27.969999F);
      localPath.lineTo(60.0F, 31.799999F);
      localPath.cubicTo(59.299999F, 46.689999F, 46.27F, 59.57F, 31.35F, 60.0F);
      localPath.lineTo(28.48F, 60.0F);
      localPath.cubicTo(13.76F, 59.470001F, 0.96F, 46.869999F, 0.0F, 32.200001F);
      localPath.lineTo(0.0F, 28.26F);
      localPath.cubicTo(0.67F, 13.56F, 13.33F, 0.84F, 28.0F, 0.0F);
      localPath.moveTo(13.35F, 25.51F);
      localPath.cubicTo(11.47F, 26.709999F, 12.06F, 29.219999F, 11.97F, 31.09F);
      localPath.cubicTo(11.7F, 32.880001F, 12.89F, 35.049999F, 14.89F, 34.939999F);
      localPath.cubicTo(24.629999F, 35.080002F, 34.380001F, 34.970001F, 44.130001F, 34.990002F);
      localPath.cubicTo(45.919998F, 35.310001F, 47.970001F, 34.09F, 47.959999F, 32.139999F);
      localPath.cubicTo(47.98F, 29.780001F, 48.759998F, 26.290001F, 45.990002F, 25.15F);
      localPath.cubicTo(36.689999F, 24.77F, 27.35F, 25.139999F, 18.040001F, 24.98F);
      localPath.cubicTo(16.5F, 25.15F, 14.73F, 24.65F, 13.35F, 25.51F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-665128);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(13.35F, 25.51F);
      ((Path)localObject).cubicTo(14.73F, 24.65F, 16.5F, 25.15F, 18.040001F, 24.98F);
      ((Path)localObject).cubicTo(27.35F, 25.139999F, 36.689999F, 24.77F, 45.990002F, 25.15F);
      ((Path)localObject).cubicTo(48.759998F, 26.290001F, 47.98F, 29.780001F, 47.959999F, 32.139999F);
      ((Path)localObject).cubicTo(47.970001F, 34.09F, 45.919998F, 35.310001F, 44.130001F, 34.990002F);
      ((Path)localObject).cubicTo(34.380001F, 34.970001F, 24.629999F, 35.080002F, 14.89F, 34.939999F);
      ((Path)localObject).cubicTo(12.89F, 35.049999F, 11.7F, 32.880001F, 11.97F, 31.09F);
      ((Path)localObject).cubicTo(12.06F, 29.219999F, 11.47F, 26.709999F, 13.35F, 25.51F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.appitem_del_btn_pressed
 * JD-Core Version:    0.7.0.1
 */