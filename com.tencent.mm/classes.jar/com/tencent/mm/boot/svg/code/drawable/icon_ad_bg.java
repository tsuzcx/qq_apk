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

public class icon_ad_bg
  extends c
{
  private final int height = 173;
  private final int width = 332;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 332;
      return 173;
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
      ((Paint)localObject).setColor(-1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(4.0F, 12.9921F);
      localPath.cubicTo(4.0F, 8.57385F, 7.58172F, 4.99213F, 12.0F, 4.99213F);
      localPath.lineTo(320.0F, 4.99213F);
      localPath.cubicTo(324.418F, 4.99213F, 328.0F, 8.57385F, 328.0F, 12.9921F);
      localPath.lineTo(328.0F, 160.992F);
      localPath.cubicTo(328.0F, 165.41F, 324.418F, 168.992F, 320.0F, 168.992F);
      localPath.lineTo(12.0F, 168.992F);
      localPath.cubicTo(7.58172F, 168.992F, 4.0F, 165.41F, 4.0F, 160.992F);
      localPath.lineTo(4.0F, 12.9921F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(312.0F, 5.4357F);
      ((Path)localObject).cubicTo(310.16299F, 5.4357F, 309.70001F, 4.99095F, 309.12799F, 4.44728F);
      ((Path)localObject).lineTo(305.97101F, 1.44573F);
      ((Path)localObject).cubicTo(305.34601F, 0.851289F, 304.349F, 0.851559F, 303.724F, 1.44573F);
      ((Path)localObject).lineTo(300.56699F, 4.44728F);
      ((Path)localObject).cubicTo(299.99399F, 4.99191F, 298.883F, 5.4357F, 298.034F, 5.4357F);
      ((Path)localObject).lineTo(298.0F, 7.20997F);
      ((Path)localObject).lineTo(312.0F, 7.20997F);
      ((Path)localObject).lineTo(312.0F, 5.4357F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_ad_bg
 * JD-Core Version:    0.7.0.1
 */