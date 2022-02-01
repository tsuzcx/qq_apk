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

public class icons_outlined_mvlist
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
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(3.0F, 6.5F);
      localPath.cubicTo(3.0F, 6.223857F, 3.223858F, 6.0F, 3.5F, 6.0F);
      localPath.lineTo(20.5F, 6.0F);
      localPath.cubicTo(20.776142F, 6.0F, 21.0F, 6.223857F, 21.0F, 6.5F);
      localPath.lineTo(21.0F, 6.7F);
      localPath.cubicTo(21.0F, 6.976142F, 20.776142F, 7.2F, 20.5F, 7.2F);
      localPath.lineTo(3.5F, 7.2F);
      localPath.cubicTo(3.223858F, 7.2F, 3.0F, 6.976142F, 3.0F, 6.7F);
      localPath.lineTo(3.0F, 6.5F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(3.0F, 12.45F);
      localPath.cubicTo(3.0F, 12.173858F, 3.223858F, 11.95F, 3.5F, 11.95F);
      localPath.lineTo(20.5F, 11.95F);
      localPath.cubicTo(20.776142F, 11.95F, 21.0F, 12.173858F, 21.0F, 12.45F);
      localPath.lineTo(21.0F, 12.65F);
      localPath.cubicTo(21.0F, 12.926142F, 20.776142F, 13.15F, 20.5F, 13.15F);
      localPath.lineTo(3.5F, 13.15F);
      localPath.cubicTo(3.223858F, 13.15F, 3.0F, 12.926142F, 3.0F, 12.65F);
      localPath.lineTo(3.0F, 12.45F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(3.5F, 17.9F);
      localPath.lineTo(14.0F, 17.9F);
      localPath.cubicTo(14.276142F, 17.9F, 14.5F, 18.123857F, 14.5F, 18.4F);
      localPath.lineTo(14.5F, 18.6F);
      localPath.cubicTo(14.5F, 18.876143F, 14.276142F, 19.1F, 14.0F, 19.1F);
      localPath.lineTo(3.5F, 19.1F);
      localPath.cubicTo(3.223858F, 19.1F, 3.0F, 18.876143F, 3.0F, 18.6F);
      localPath.lineTo(3.0F, 18.4F);
      localPath.cubicTo(3.0F, 18.123857F, 3.223858F, 17.9F, 3.5F, 17.9F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(21.125044F, 18.800495F);
      ((Path)localObject).lineTo(17.128647F, 21.131727F);
      ((Path)localObject).cubicTo(17.008533F, 21.201794F, 16.854364F, 21.161222F, 16.784298F, 21.041109F);
      ((Path)localObject).cubicTo(16.761835F, 21.002604F, 16.75F, 20.958822F, 16.75F, 20.914244F);
      ((Path)localObject).lineTo(16.75F, 16.251781F);
      ((Path)localObject).cubicTo(16.75F, 16.112726F, 16.862726F, 16.0F, 17.001781F, 16.0F);
      ((Path)localObject).cubicTo(17.04636F, 16.0F, 17.090139F, 16.011835F, 17.128647F, 16.034298F);
      ((Path)localObject).lineTo(21.125044F, 18.36553F);
      ((Path)localObject).cubicTo(21.245155F, 18.435595F, 21.285727F, 18.589766F, 21.215662F, 18.709877F);
      ((Path)localObject).cubicTo(21.193777F, 18.747395F, 21.16256F, 18.778612F, 21.125044F, 18.800495F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_mvlist
 * JD-Core Version:    0.7.0.1
 */