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

public class grid_item_video_pic
  extends c
{
  private final int height = 30;
  private final int width = 55;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 55;
      return 30;
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
      localPaint.setColor(-1);
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 4.0F);
      localPath.cubicTo(0.0F, 1.790861F, 1.790861F, 0.0F, 4.0F, 0.0F);
      localPath.lineTo(30.0F, 0.0F);
      localPath.cubicTo(32.209141F, 0.0F, 34.0F, 1.790861F, 34.0F, 4.0F);
      localPath.lineTo(34.0F, 26.0F);
      localPath.cubicTo(34.0F, 28.209139F, 32.209141F, 30.0F, 30.0F, 30.0F);
      localPath.lineTo(4.0F, 30.0F);
      localPath.cubicTo(1.790861F, 30.0F, 0.0F, 28.209139F, 0.0F, 26.0F);
      localPath.lineTo(0.0F, 4.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(38.71698F, 13.0F);
      ((Path)localObject).cubicTo(43.576469F, 8.820671F, 48.100197F, 4.156057F, 54.0F, 1.0F);
      ((Path)localObject).cubicTo(54.131836F, 10.646817F, 54.071522F, 20.353184F, 54.0F, 30.0F);
      ((Path)localObject).lineTo(52.981133F, 30.0F);
      ((Path)localObject).cubicTo(47.165295F, 25.652977F, 41.495552F, 21.266256F, 35.660378F, 17.0F);
      ((Path)localObject).cubicTo(34.679802F, 14.844969F, 37.29351F, 13.584531F, 38.71698F, 13.0F);
      ((Path)localObject).lineTo(38.71698F, 13.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.grid_item_video_pic
 * JD-Core Version:    0.7.0.1
 */