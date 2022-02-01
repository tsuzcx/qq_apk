package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class float_ball_icon_game_center_default
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(48.0F, 0.0F);
      localPath.lineTo(48.0F, 48.0F);
      localPath.lineTo(0.0F, 48.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 10.0F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-352965);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(2.305055F, 13.125F);
      ((Path)localObject2).cubicTo(2.418779F, 12.841722F, 2.5899F, 12.576766F, 2.818128F, 12.348538F);
      ((Path)localObject2).lineTo(12.348538F, 2.818128F);
      ((Path)localObject2).cubicTo(12.577369F, 2.589298F, 12.842251F, 2.41826F, 13.125F, 2.304728F);
      ((Path)localObject2).lineTo(13.125F, 9.1779F);
      ((Path)localObject2).cubicTo(11.120219F, 9.539286F, 9.539286F, 11.120219F, 9.1779F, 13.125F);
      ((Path)localObject2).lineTo(2.305055F, 13.125F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-15683841);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(25.695272F, 13.125F);
      ((Path)localObject2).lineTo(18.8221F, 13.125F);
      ((Path)localObject2).cubicTo(18.460714F, 11.120219F, 16.879782F, 9.539286F, 14.875F, 9.1779F);
      ((Path)localObject2).lineTo(14.875F, 2.305055F);
      ((Path)localObject2).cubicTo(15.158278F, 2.418779F, 15.423234F, 2.5899F, 15.651462F, 2.818128F);
      ((Path)localObject2).lineTo(25.181871F, 12.348538F);
      ((Path)localObject2).cubicTo(25.410702F, 12.577369F, 25.581739F, 12.842251F, 25.695272F, 13.125F);
      ((Path)localObject2).lineTo(25.695272F, 13.125F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-16268960);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(25.694944F, 14.875F);
      ((Path)localObject2).cubicTo(25.581221F, 15.158278F, 25.410099F, 15.423234F, 25.181871F, 15.651462F);
      ((Path)localObject2).lineTo(15.651462F, 25.181871F);
      ((Path)localObject2).cubicTo(15.422631F, 25.410702F, 15.157749F, 25.581739F, 14.875F, 25.695272F);
      ((Path)localObject2).lineTo(14.875F, 18.8221F);
      ((Path)localObject2).cubicTo(16.879782F, 18.460714F, 18.460714F, 16.879782F, 18.8221F, 14.875F);
      ((Path)localObject2).lineTo(25.694944F, 14.875F);
      ((Path)localObject2).lineTo(25.694944F, 14.875F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-372399);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(2.304728F, 14.875F);
      ((Path)localObject1).lineTo(9.1779F, 14.875F);
      ((Path)localObject1).cubicTo(9.539286F, 16.879782F, 11.120219F, 18.460714F, 13.125F, 18.8221F);
      ((Path)localObject1).lineTo(13.125F, 25.694944F);
      ((Path)localObject1).cubicTo(12.841722F, 25.581221F, 12.576766F, 25.410099F, 12.348538F, 25.181871F);
      ((Path)localObject1).lineTo(2.818128F, 15.651462F);
      ((Path)localObject1).cubicTo(2.589298F, 15.422631F, 2.41826F, 15.157749F, 2.304728F, 14.875F);
      ((Path)localObject1).lineTo(2.304728F, 14.875F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.float_ball_icon_game_center_default
 * JD-Core Version:    0.7.0.1
 */