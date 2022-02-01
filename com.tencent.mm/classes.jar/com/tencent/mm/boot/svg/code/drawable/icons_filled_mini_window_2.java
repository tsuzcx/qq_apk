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

public class icons_filled_mini_window_2
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(21.0F, 13.58F);
      ((Path)localObject).cubicTo(21.512836F, 13.58F, 21.935507F, 13.966041F, 21.993273F, 14.463379F);
      ((Path)localObject).lineTo(22.0F, 14.58F);
      ((Path)localObject).lineTo(22.000185F, 20.200106F);
      ((Path)localObject).lineTo(21.99346F, 20.316832F);
      ((Path)localObject).cubicTo(21.940041F, 20.775902F, 21.575716F, 21.14006F, 21.116623F, 21.193127F);
      ((Path)localObject).lineTo(21.0F, 21.199789F);
      ((Path)localObject).lineTo(14.38F, 21.198387F);
      ((Path)localObject).cubicTo(13.867241F, 21.198082F, 13.444686F, 20.812048F, 13.386768F, 20.314779F);
      ((Path)localObject).lineTo(13.38F, 20.198175F);
      ((Path)localObject).lineTo(13.38F, 14.58F);
      ((Path)localObject).cubicTo(13.38F, 14.067164F, 13.76604F, 13.644493F, 14.263379F, 13.586728F);
      ((Path)localObject).lineTo(14.38F, 13.58F);
      ((Path)localObject).lineTo(21.0F, 13.58F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.58F, 14.78F);
      ((Path)localObject).lineTo(14.58F, 20.0F);
      ((Path)localObject).lineTo(20.799999F, 20.0F);
      ((Path)localObject).lineTo(20.799999F, 14.78F);
      ((Path)localObject).lineTo(14.58F, 14.78F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(18.5F, 3.8F);
      ((Path)localObject).cubicTo(19.012836F, 3.8F, 19.432236F, 4.182662F, 19.49F, 4.68F);
      ((Path)localObject).lineTo(19.5F, 4.8F);
      ((Path)localObject).lineTo(19.5F, 12.08F);
      ((Path)localObject).lineTo(18.299999F, 12.08F);
      ((Path)localObject).lineTo(18.299999F, 5.0F);
      ((Path)localObject).lineTo(3.2F, 5.0F);
      ((Path)localObject).lineTo(3.2F, 17.5F);
      ((Path)localObject).lineTo(11.88F, 17.5F);
      ((Path)localObject).lineTo(11.88F, 18.700001F);
      ((Path)localObject).lineTo(3.0F, 18.700001F);
      ((Path)localObject).cubicTo(2.487164F, 18.700001F, 2.064493F, 18.317339F, 2.006728F, 17.82F);
      ((Path)localObject).lineTo(2.0F, 17.700001F);
      ((Path)localObject).lineTo(2.0F, 4.8F);
      ((Path)localObject).cubicTo(2.0F, 4.287164F, 2.38604F, 3.867765F, 2.883379F, 3.81F);
      ((Path)localObject).lineTo(3.0F, 3.8F);
      ((Path)localObject).lineTo(18.5F, 3.8F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(6.248528F, 7.1F);
      ((Path)localObject).lineTo(10.001F, 10.852F);
      ((Path)localObject).lineTo(10.002333F, 7.7F);
      ((Path)localObject).lineTo(11.2F, 7.7F);
      ((Path)localObject).lineTo(11.2F, 11.9F);
      ((Path)localObject).cubicTo(11.2F, 12.452285F, 10.752285F, 12.9F, 10.2F, 12.9F);
      ((Path)localObject).lineTo(6.0F, 12.9F);
      ((Path)localObject).lineTo(6.0F, 11.703622F);
      ((Path)localObject).lineTo(9.154F, 11.703F);
      ((Path)localObject).lineTo(5.4F, 7.948528F);
      ((Path)localObject).lineTo(6.248528F, 7.1F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_mini_window_2
 * JD-Core Version:    0.7.0.1
 */