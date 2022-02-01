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

public class finder_filled_fav
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
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.save();
      localObject = c.instancePaint((Paint)localObject, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(72.0F, 0.0F);
      localPath.lineTo(72.0F, 72.0F);
      localPath.lineTo(0.0F, 72.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(57.57F, 19.5F);
      localPath.cubicTo(58.912052F, 19.5F, 60.0F, 20.587948F, 60.0F, 21.93F);
      localPath.lineTo(60.0F, 60.57F);
      localPath.cubicTo(60.0F, 61.912052F, 58.912052F, 63.0F, 57.57F, 63.0F);
      localPath.lineTo(14.43F, 63.0F);
      localPath.cubicTo(13.087948F, 63.0F, 12.0F, 61.912052F, 12.0F, 60.57F);
      localPath.lineTo(12.0F, 21.93F);
      localPath.cubicTo(12.0F, 20.587948F, 13.087948F, 19.5F, 14.43F, 19.5F);
      localPath.lineTo(57.57F, 19.5F);
      localPath.close();
      localPath.moveTo(36.64146F, 27.156868F);
      localPath.cubicTo(35.923527F, 26.786366F, 35.054295F, 27.094593F, 34.69997F, 27.845312F);
      localPath.lineTo(34.69997F, 27.845312F);
      localPath.lineTo(31.313517F, 35.020367F);
      localPath.lineTo(23.741177F, 36.170937F);
      localPath.cubicTo(23.425682F, 36.218876F, 23.1341F, 36.374229F, 22.91157F, 36.612946F);
      localPath.cubicTo(22.352736F, 37.212433F, 22.364468F, 38.172123F, 22.937773F, 38.756477F);
      localPath.lineTo(22.937773F, 38.756477F);
      localPath.lineTo(28.41717F, 44.341476F);
      localPath.lineTo(27.123659F, 52.227623F);
      localPath.cubicTo(27.069767F, 52.55619F, 27.12096F, 52.894169F, 27.269314F, 53.189243F);
      localPath.cubicTo(27.641869F, 53.930248F, 28.518354F, 54.215141F, 29.226997F, 53.825573F);
      localPath.lineTo(29.226997F, 53.825573F);
      localPath.lineTo(35.999905F, 50.102238F);
      localPath.lineTo(42.772816F, 53.825573F);
      localPath.cubicTo(43.055F, 53.980701F, 43.37822F, 54.034233F, 43.69244F, 53.977879F);
      localPath.cubicTo(44.481525F, 53.836357F, 45.01149F, 53.052742F, 44.876152F, 52.227623F);
      localPath.lineTo(44.876152F, 52.227623F);
      localPath.lineTo(43.582642F, 44.341476F);
      localPath.lineTo(49.062038F, 38.756477F);
      localPath.cubicTo(49.290333F, 38.523785F, 49.4389F, 38.218887F, 49.484745F, 37.888985F);
      localPath.cubicTo(49.599873F, 37.060516F, 49.050922F, 36.291321F, 48.258636F, 36.170937F);
      localPath.lineTo(48.258636F, 36.170937F);
      localPath.lineTo(40.686295F, 35.020367F);
      localPath.lineTo(37.299839F, 27.845312F);
      localPath.cubicTo(37.158749F, 27.546371F, 36.927349F, 27.304405F, 36.64146F, 27.156868F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(16.5F, 11.958F);
      ((Path)localObject).cubicTo(16.5F, 11.152769F, 17.152769F, 10.5F, 17.958F, 10.5F);
      ((Path)localObject).lineTo(54.042F, 10.5F);
      ((Path)localObject).cubicTo(54.847233F, 10.5F, 55.5F, 11.152769F, 55.5F, 11.958F);
      ((Path)localObject).lineTo(55.5F, 12.642F);
      ((Path)localObject).cubicTo(55.5F, 13.447231F, 54.847233F, 14.1F, 54.042F, 14.1F);
      ((Path)localObject).lineTo(17.958F, 14.1F);
      ((Path)localObject).cubicTo(17.152769F, 14.1F, 16.5F, 13.447231F, 16.5F, 12.642F);
      ((Path)localObject).lineTo(16.5F, 11.958F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_filled_fav
 * JD-Core Version:    0.7.0.1
 */