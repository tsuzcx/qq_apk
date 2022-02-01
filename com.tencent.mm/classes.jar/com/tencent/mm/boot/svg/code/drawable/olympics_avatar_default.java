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

public class olympics_avatar_default
  extends c
{
  private final int height = 65;
  private final int width = 65;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 65;
      return 65;
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
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-921103);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(65.0F, 0.0F);
      localPath.lineTo(65.0F, 65.0F);
      localPath.lineTo(0.0F, 65.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-3552823);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(25.142698F, 27.003969F);
      ((Path)localObject).lineTo(25.142698F, 24.064348F);
      ((Path)localObject).cubicTo(25.142698F, 20.012562F, 28.435797F, 16.727942F, 32.500034F, 16.727942F);
      ((Path)localObject).cubicTo(36.563381F, 16.727942F, 39.857372F, 20.013426F, 39.857372F, 24.064348F);
      ((Path)localObject).lineTo(39.857372F, 27.003969F);
      ((Path)localObject).cubicTo(39.857372F, 29.026474F, 38.771454F, 31.903463F, 37.433113F, 33.428532F);
      ((Path)localObject).lineTo(36.646946F, 34.324383F);
      ((Path)localObject).cubicTo(35.575672F, 35.545113F, 35.899075F, 37.097618F, 37.369473F, 37.792088F);
      ((Path)localObject).lineTo(46.690765F, 42.194534F);
      ((Path)localObject).cubicTo(47.792805F, 42.715027F, 48.826298F, 44.114929F, 48.998196F, 45.314709F);
      ((Path)localObject).lineTo(49.213051F, 46.814285F);
      ((Path)localObject).cubicTo(49.328403F, 47.619392F, 48.761047F, 48.27206F, 47.945927F, 48.27206F);
      ((Path)localObject).lineTo(17.054144F, 48.27206F);
      ((Path)localObject).cubicTo(16.238981F, 48.27206F, 15.67134F, 47.621696F, 15.787023F, 46.814285F);
      ((Path)localObject).lineTo(16.001875F, 45.314709F);
      ((Path)localObject).cubicTo(16.174198F, 44.111977F, 17.209604F, 42.713734F, 18.301889F, 42.197613F);
      ((Path)localObject).lineTo(27.630598F, 37.789665F);
      ((Path)localObject).cubicTo(29.100912F, 37.094925F, 29.425009F, 35.543324F, 28.353128F, 34.322517F);
      ((Path)localObject).lineTo(27.566959F, 33.427124F);
      ((Path)localObject).cubicTo(26.228077F, 31.902218F, 25.142698F, 29.026176F, 25.142698F, 27.003969F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.olympics_avatar_default
 * JD-Core Version:    0.7.0.1
 */