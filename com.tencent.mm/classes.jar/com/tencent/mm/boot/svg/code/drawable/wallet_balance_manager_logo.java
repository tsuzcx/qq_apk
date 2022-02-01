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

public class wallet_balance_manager_logo
  extends c
{
  private final int height = 240;
  private final int width = 240;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 240;
      return 240;
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
      ((Paint)localObject).setColor(-407039);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(120.0F, 0.0F);
      localPath.cubicTo(186.27417F, 0.0F, 240.0F, 53.72583F, 240.0F, 120.0F);
      localPath.cubicTo(240.0F, 186.27417F, 186.27417F, 240.0F, 120.0F, 240.0F);
      localPath.cubicTo(53.72583F, 240.0F, 0.0F, 186.27417F, 0.0F, 120.0F);
      localPath.cubicTo(0.0F, 53.72583F, 53.72583F, 0.0F, 120.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(120.0F, 21.0F);
      localPath.cubicTo(174.67619F, 21.0F, 219.0F, 65.323807F, 219.0F, 120.0F);
      localPath.cubicTo(219.0F, 174.67619F, 174.67619F, 219.0F, 120.0F, 219.0F);
      localPath.cubicTo(65.323807F, 219.0F, 21.0F, 174.67619F, 21.0F, 120.0F);
      localPath.cubicTo(21.0F, 65.323807F, 65.323807F, 21.0F, 120.0F, 21.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 102, 31);
      localCanvas.drawPath(localPath, c.instancePaint((Paint)localObject, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-407039);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(125.57143F, 108.0F);
      ((Path)localObject).lineTo(142.28572F, 72.0F);
      ((Path)localObject).lineTo(159.0F, 72.0F);
      ((Path)localObject).lineTo(142.28572F, 108.0F);
      ((Path)localObject).lineTo(159.0F, 108.0F);
      ((Path)localObject).lineTo(159.0F, 123.0F);
      ((Path)localObject).lineTo(126.0F, 123.0F);
      ((Path)localObject).lineTo(126.0F, 135.0F);
      ((Path)localObject).lineTo(159.0F, 135.0F);
      ((Path)localObject).lineTo(159.0F, 150.0F);
      ((Path)localObject).lineTo(126.0F, 150.0F);
      ((Path)localObject).lineTo(126.0F, 171.0F);
      ((Path)localObject).lineTo(114.0F, 171.0F);
      ((Path)localObject).lineTo(114.0F, 150.0F);
      ((Path)localObject).lineTo(81.0F, 150.0F);
      ((Path)localObject).lineTo(81.0F, 135.0F);
      ((Path)localObject).lineTo(114.0F, 135.0F);
      ((Path)localObject).lineTo(114.0F, 123.0F);
      ((Path)localObject).lineTo(81.0F, 123.0F);
      ((Path)localObject).lineTo(81.0F, 108.0F);
      ((Path)localObject).lineTo(97.714287F, 108.0F);
      ((Path)localObject).lineTo(81.0F, 72.0F);
      ((Path)localObject).lineTo(97.714287F, 72.0F);
      ((Path)localObject).lineTo(114.42857F, 108.0F);
      ((Path)localObject).lineTo(125.57143F, 108.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.wallet_balance_manager_logo
 * JD-Core Version:    0.7.0.1
 */