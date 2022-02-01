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

public class remittance_cancle
  extends c
{
  private final int height = 186;
  private final int width = 186;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 186;
      return 186;
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
      ((Paint)localObject).setColor(-16896);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(186.0F, 94.148148F);
      localPath.cubicTo(186.0F, 41.636444F, 144.36356F, 0.0F, 91.851852F, 0.0F);
      localPath.cubicTo(41.636444F, 0.0F, 0.0F, 41.636444F, 0.0F, 94.148148F);
      localPath.cubicTo(0.0F, 144.36356F, 41.636444F, 186.0F, 91.851852F, 186.0F);
      localPath.cubicTo(144.36356F, 186.0F, 186.0F, 144.36356F, 186.0F, 94.148148F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(107.5779F, 70.849312F);
      ((Path)localObject).cubicTo(122.7227F, 70.849312F, 135.0F, 83.191872F, 135.0F, 98.42466F);
      ((Path)localObject).cubicTo(135.0F, 113.6541F, 122.72481F, 126.0F, 107.5779F, 126.0F);
      ((Path)localObject).lineTo(55.890526F, 126.0F);
      ((Path)localObject).cubicTo(55.398701F, 126.0F, 55.0F, 125.58803F, 55.0F, 125.10005F);
      ((Path)localObject).lineTo(55.0F, 117.85886F);
      ((Path)localObject).cubicTo(55.0F, 117.36182F, 55.393009F, 116.9589F, 55.890583F, 116.9589F);
      ((Path)localObject).lineTo(107.58115F, 116.9589F);
      ((Path)localObject).cubicTo(117.75454F, 116.9589F, 126.01124F, 108.66084F, 126.01124F, 98.42466F);
      ((Path)localObject).cubicTo(126.01124F, 88.186226F, 117.7598F, 79.890411F, 107.58115F, 79.890411F);
      ((Path)localObject).lineTo(75.558434F, 79.890411F);
      ((Path)localObject).lineTo(75.558434F, 89.567261F);
      ((Path)localObject).cubicTo(75.558434F, 90.565697F, 74.914932F, 90.893188F, 74.12114F, 90.296753F);
      ((Path)localObject).lineTo(55.596493F, 76.377876F);
      ((Path)localObject).cubicTo(54.799637F, 75.779144F, 54.8027F, 74.81443F, 55.596493F, 74.217995F);
      ((Path)localObject).lineTo(74.12114F, 60.299118F);
      ((Path)localObject).cubicTo(74.917999F, 59.700382F, 75.558434F, 60.029289F, 75.558434F, 61.02861F);
      ((Path)localObject).lineTo(75.558434F, 70.849312F);
      ((Path)localObject).lineTo(107.5779F, 70.849312F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.remittance_cancle
 * JD-Core Version:    0.7.0.1
 */