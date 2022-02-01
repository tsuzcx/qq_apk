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

public class coupon
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
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
      localPath.moveTo(28.666666F, 6.0F);
      localPath.cubicTo(29.403046F, 6.0F, 30.0F, 6.596954F, 30.0F, 7.333334F);
      localPath.lineTo(30.001003F, 13.5F);
      localPath.cubicTo(28.594185F, 13.5F, 27.454546F, 14.619288F, 27.454546F, 16.0F);
      localPath.cubicTo(27.454546F, 17.325483F, 28.504837F, 18.410038F, 29.832636F, 18.494682F);
      localPath.lineTo(30.0F, 18.5F);
      localPath.lineTo(30.0F, 24.666666F);
      localPath.cubicTo(30.0F, 25.403046F, 29.403046F, 26.0F, 28.666666F, 26.0F);
      localPath.lineTo(3.333333F, 26.0F);
      localPath.cubicTo(2.596954F, 26.0F, 2.0F, 25.403046F, 2.0F, 24.666666F);
      localPath.lineTo(2.0F, 18.5F);
      localPath.cubicTo(3.405816F, 18.5F, 4.545455F, 17.380713F, 4.545455F, 16.0F);
      localPath.cubicTo(4.545455F, 14.619288F, 3.405816F, 13.5F, 2.0F, 13.5F);
      localPath.lineTo(2.0F, 7.333334F);
      localPath.cubicTo(2.0F, 6.596954F, 2.596954F, 6.0F, 3.333333F, 6.0F);
      localPath.lineTo(28.666666F, 6.0F);
      localPath.close();
      localPath.moveTo(28.399F, 7.6F);
      localPath.lineTo(3.599F, 7.6F);
      localPath.lineTo(3.599F, 12.217F);
      localPath.lineTo(3.744854F, 12.280006F);
      localPath.cubicTo(5.101418F, 12.903452F, 6.062619F, 14.231622F, 6.140364F, 15.794811F);
      localPath.lineTo(6.145454F, 16.0F);
      localPath.cubicTo(6.145454F, 17.651552F, 5.160399F, 19.069443F, 3.744854F, 19.719994F);
      localPath.lineTo(3.599F, 19.782F);
      localPath.lineTo(3.599F, 24.4F);
      localPath.lineTo(28.399F, 24.4F);
      localPath.lineTo(28.399F, 19.782F);
      localPath.lineTo(28.386677F, 19.77784F);
      localPath.cubicTo(26.956083F, 19.17976F, 25.938618F, 17.811419F, 25.859509F, 16.202349F);
      localPath.lineTo(25.854546F, 16.0F);
      localPath.cubicTo(25.854546F, 14.348448F, 26.839602F, 12.930558F, 28.255262F, 12.280006F);
      localPath.lineTo(28.400999F, 12.217F);
      localPath.lineTo(28.399F, 7.6F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(20.614584F, 12.333333F);
      localPath.cubicTo(20.911123F, 12.333333F, 21.151516F, 12.573726F, 21.151516F, 12.870265F);
      localPath.lineTo(21.151516F, 13.396401F);
      localPath.cubicTo(21.151516F, 13.692941F, 20.911123F, 13.933333F, 20.614584F, 13.933333F);
      localPath.lineTo(10.233901F, 13.933333F);
      localPath.cubicTo(9.937363F, 13.933333F, 9.69697F, 13.692941F, 9.69697F, 13.396401F);
      localPath.lineTo(9.69697F, 12.870265F);
      localPath.cubicTo(9.69697F, 12.573726F, 9.937363F, 12.333333F, 10.233901F, 12.333333F);
      localPath.lineTo(20.614584F, 12.333333F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(16.796402F, 17.333334F);
      ((Path)localObject).cubicTo(17.092941F, 17.333334F, 17.333334F, 17.573727F, 17.333334F, 17.870266F);
      ((Path)localObject).lineTo(17.333334F, 18.396402F);
      ((Path)localObject).cubicTo(17.333334F, 18.692942F, 17.092941F, 18.933332F, 16.796402F, 18.933332F);
      ((Path)localObject).lineTo(10.233901F, 18.933332F);
      ((Path)localObject).cubicTo(9.937363F, 18.933332F, 9.69697F, 18.692942F, 9.69697F, 18.396402F);
      ((Path)localObject).lineTo(9.69697F, 17.870266F);
      ((Path)localObject).cubicTo(9.69697F, 17.573727F, 9.937363F, 17.333334F, 10.233901F, 17.333334F);
      ((Path)localObject).lineTo(16.796402F, 17.333334F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.coupon
 * JD-Core Version:    0.7.0.1
 */