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

public class note_bold_unpress
  extends c
{
  private final int height = 144;
  private final int width = 144;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 144;
      return 144;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject, paramVarArgs);
      localPaint.setColor(-855638017);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 28.799999F);
      localPath.cubicTo(0.0F, 12.894198F, 12.894198F, 0.0F, 28.799999F, 0.0F);
      localPath.lineTo(115.2F, 0.0F);
      localPath.cubicTo(131.1058F, 0.0F, 144.0F, 12.894198F, 144.0F, 28.799999F);
      localPath.lineTo(144.0F, 115.2F);
      localPath.cubicTo(144.0F, 131.1058F, 131.1058F, 144.0F, 115.2F, 144.0F);
      localPath.lineTo(28.799999F, 144.0F);
      localPath.cubicTo(12.894198F, 144.0F, 0.0F, 131.1058F, 0.0F, 115.2F);
      localPath.lineTo(0.0F, 28.799999F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localPaint = c.instancePaint((Paint)localObject, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(55.950001F, 100.0F);
      ((Path)localObject).lineTo(55.950001F, 45.325001F);
      ((Path)localObject).lineTo(71.025002F, 45.325001F);
      ((Path)localObject).cubicTo(82.050003F, 45.325001F, 89.25F, 49.375F, 89.25F, 58.599998F);
      ((Path)localObject).cubicTo(89.25F, 64.224998F, 86.324997F, 68.875F, 80.849998F, 70.525002F);
      ((Path)localObject).lineTo(80.849998F, 70.900002F);
      ((Path)localObject).cubicTo(87.900002F, 72.099998F, 92.550003F, 76.525002F, 92.550003F, 84.025002F);
      ((Path)localObject).cubicTo(92.550003F, 94.599998F, 84.449997F, 100.0F, 72.150002F, 100.0F);
      ((Path)localObject).lineTo(55.950001F, 100.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(60.450001F, 69.175003F);
      ((Path)localObject).lineTo(69.599998F, 69.175003F);
      ((Path)localObject).cubicTo(80.400002F, 69.175003F, 84.75F, 65.349998F, 84.75F, 59.125F);
      ((Path)localObject).cubicTo(84.75F, 51.700001F, 79.724998F, 49.0F, 70.050003F, 49.0F);
      ((Path)localObject).lineTo(60.450001F, 49.0F);
      ((Path)localObject).lineTo(60.450001F, 69.175003F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(60.450001F, 96.25F);
      ((Path)localObject).lineTo(71.099998F, 96.25F);
      ((Path)localObject).cubicTo(81.675003F, 96.25F, 88.125F, 92.5F, 88.125F, 84.025002F);
      ((Path)localObject).cubicTo(88.125F, 76.375F, 81.974998F, 72.775002F, 71.099998F, 72.775002F);
      ((Path)localObject).lineTo(60.450001F, 72.775002F);
      ((Path)localObject).lineTo(60.450001F, 96.25F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 230, 31);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.note_bold_unpress
 * JD-Core Version:    0.7.0.1
 */