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

public class fav_note_toolbar_location
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
      localObject = c.instancePaint(localPaint, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(36.195572F, 63.7295F);
      localPath.cubicTo(36.18903F, 63.723602F, 36.182568F, 63.717976F, 36.176186F, 63.712605F);
      localPath.lineTo(36.195572F, 63.7295F);
      localPath.close();
      localPath.moveTo(36.740509F, 62.905819F);
      localPath.cubicTo(37.448799F, 62.267334F, 38.24197F, 61.523434F, 39.098534F, 60.683678F);
      localPath.cubicTo(41.551903F, 58.278442F, 44.006676F, 55.600571F, 46.290497F, 52.73064F);
      localPath.cubicTo(52.408028F, 45.043129F, 56.134178F, 37.461308F, 56.386459F, 30.719046F);
      localPath.cubicTo(56.395481F, 30.477993F, 56.400002F, 30.23831F, 56.400002F, 30.0F);
      localPath.cubicTo(56.400002F, 18.733391F, 47.266609F, 9.6F, 36.0F, 9.6F);
      localPath.cubicTo(24.733391F, 9.6F, 15.6F, 18.733391F, 15.6F, 30.0F);
      localPath.cubicTo(15.6F, 30.23831F, 15.604521F, 30.477993F, 15.61354F, 30.719046F);
      localPath.cubicTo(15.865823F, 37.461308F, 19.59197F, 45.043129F, 25.709501F, 52.73064F);
      localPath.cubicTo(27.993324F, 55.600571F, 30.448099F, 58.278442F, 32.901466F, 60.683678F);
      localPath.cubicTo(33.75803F, 61.523434F, 34.551201F, 62.267334F, 35.259491F, 62.905819F);
      localPath.cubicTo(35.590477F, 63.204189F, 35.840916F, 63.424175F, 36.0F, 63.561043F);
      localPath.cubicTo(36.159084F, 63.424175F, 36.409523F, 63.204189F, 36.740509F, 62.905819F);
      localPath.close();
      localPath.moveTo(33.785156F, 66.403427F);
      localPath.cubicTo(33.785156F, 66.403427F, 12.0F, 48.054832F, 12.0F, 30.0F);
      localPath.cubicTo(12.0F, 16.745167F, 22.745167F, 6.0F, 36.0F, 6.0F);
      localPath.cubicTo(49.254833F, 6.0F, 60.0F, 16.745167F, 60.0F, 30.0F);
      localPath.cubicTo(60.0F, 48.054832F, 38.214844F, 66.403427F, 38.214844F, 66.403427F);
      localPath.cubicTo(37.000694F, 67.518059F, 35.008381F, 67.506104F, 33.785156F, 66.403427F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 38.400002F);
      ((Path)localObject).cubicTo(40.639191F, 38.400002F, 44.400002F, 34.639191F, 44.400002F, 30.0F);
      ((Path)localObject).cubicTo(44.400002F, 25.360807F, 40.639191F, 21.6F, 36.0F, 21.6F);
      ((Path)localObject).cubicTo(31.360807F, 21.6F, 27.6F, 25.360807F, 27.6F, 30.0F);
      ((Path)localObject).cubicTo(27.6F, 34.639191F, 31.360807F, 38.400002F, 36.0F, 38.400002F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 42.0F);
      ((Path)localObject).cubicTo(29.372583F, 42.0F, 24.0F, 36.627419F, 24.0F, 30.0F);
      ((Path)localObject).cubicTo(24.0F, 23.372583F, 29.372583F, 18.0F, 36.0F, 18.0F);
      ((Path)localObject).cubicTo(42.627419F, 18.0F, 48.0F, 23.372583F, 48.0F, 30.0F);
      ((Path)localObject).cubicTo(48.0F, 36.627419F, 42.627419F, 42.0F, 36.0F, 42.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.fav_note_toolbar_location
 * JD-Core Version:    0.7.0.1
 */