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

public class product_music_play_icon_pressed
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
      localPaint.setColor(-9276814);
      localCanvas.saveLayerAlpha(null, 128, 31);
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(33.900002F, 0.0F);
      localPath.lineTo(38.040001F, 0.0F);
      localPath.cubicTo(46.52F, 0.64F, 54.84F, 4.06F, 60.93F, 10.05F);
      localPath.cubicTo(67.459999F, 16.26F, 71.400002F, 24.959999F, 72.0F, 33.919998F);
      localPath.lineTo(72.0F, 38.040001F);
      localPath.cubicTo(71.410004F, 47.029999F, 67.470001F, 55.740002F, 60.93F, 61.950001F);
      localPath.cubicTo(54.900002F, 67.870003F, 46.700001F, 71.290001F, 38.32F, 72.0F);
      localPath.lineTo(33.950001F, 72.0F);
      localPath.cubicTo(25.01F, 71.389999F, 16.299999F, 67.519997F, 10.12F, 61.0F);
      localPath.cubicTo(4.16F, 54.919998F, 0.64F, 46.689999F, 0.0F, 38.23F);
      localPath.lineTo(0.0F, 33.93F);
      localPath.cubicTo(0.66F, 23.299999F, 6.2F, 13.1F, 14.85F, 6.87F);
      localPath.cubicTo(20.360001F, 2.78F, 27.09F, 0.58F, 33.900002F, 0.0F);
      localPath.lineTo(33.900002F, 0.0F);
      localPath.close();
      localPath.moveTo(29.450001F, 3.65F);
      localPath.cubicTo(21.99F, 5.18F, 15.07F, 9.34F, 10.31F, 15.3F);
      localPath.cubicTo(1.3F, 26.139999F, 0.57F, 42.84F, 8.63F, 54.419998F);
      localPath.cubicTo(17.32F, 67.889999F, 36.419998F, 73.029999F, 50.650002F, 65.550003F);
      localPath.cubicTo(65.309998F, 58.669998F, 72.849998F, 40.150002F, 67.110001F, 24.99F);
      localPath.cubicTo(62.07F, 9.86F, 45.049999F, 0.15F, 29.450001F, 3.65F);
      localPath.lineTo(29.450001F, 3.65F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(26.01F, 19.02F);
      ((Path)localObject).cubicTo(35.34F, 24.67F, 44.66F, 30.33F, 53.98F, 36.0F);
      ((Path)localObject).cubicTo(44.68F, 41.689999F, 35.330002F, 47.310001F, 26.030001F, 53.0F);
      ((Path)localObject).cubicTo(25.969999F, 41.669998F, 26.01F, 30.34F, 26.01F, 19.02F);
      ((Path)localObject).lineTo(26.01F, 19.02F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.product_music_play_icon_pressed
 * JD-Core Version:    0.7.0.1
 */