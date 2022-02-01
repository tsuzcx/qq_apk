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

public class icons_filled_music_comment
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(19.0F, 4.5F);
      ((Path)localObject).cubicTo(20.380713F, 4.5F, 21.5F, 5.619288F, 21.5F, 7.0F);
      ((Path)localObject).lineTo(21.5F, 15.5F);
      ((Path)localObject).cubicTo(21.5F, 16.880713F, 20.380713F, 18.0F, 19.0F, 18.0F);
      ((Path)localObject).lineTo(12.455F, 18.0F);
      ((Path)localObject).lineTo(7.97872F, 21.005764F);
      ((Path)localObject).cubicTo(7.923774F, 21.042656F, 7.862335F, 21.068089F, 7.798067F, 21.080944F);
      ((Path)localObject).lineTo(7.7F, 21.090654F);
      ((Path)localObject).cubicTo(7.45454F, 21.090654F, 7.250392F, 20.91378F, 7.208056F, 20.680531F);
      ((Path)localObject).lineTo(7.2F, 20.590654F);
      ((Path)localObject).lineTo(7.2F, 18.0F);
      ((Path)localObject).lineTo(5.0F, 18.0F);
      ((Path)localObject).cubicTo(3.619288F, 18.0F, 2.5F, 16.880713F, 2.5F, 15.5F);
      ((Path)localObject).lineTo(2.5F, 7.0F);
      ((Path)localObject).cubicTo(2.5F, 5.619288F, 3.619288F, 4.5F, 5.0F, 4.5F);
      ((Path)localObject).lineTo(19.0F, 4.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.103492F, 7.0F);
      ((Path)localObject).lineTo(12.060873F, 7.003843F);
      ((Path)localObject).cubicTo(11.993414F, 7.01967F, 11.943186F, 7.080224F, 11.943186F, 7.15251F);
      ((Path)localObject).lineTo(11.943186F, 7.15251F);
      ((Path)localObject).lineTo(11.943736F, 11.939682F);
      ((Path)localObject).cubicTo(11.752537F, 11.872033F, 11.546762F, 11.83522F, 11.33239F, 11.83522F);
      ((Path)localObject).cubicTo(10.320389F, 11.83522F, 9.5F, 12.655609F, 9.5F, 13.66761F);
      ((Path)localObject).cubicTo(9.5F, 14.679611F, 10.320389F, 15.5F, 11.33239F, 15.5F);
      ((Path)localObject).lineTo(11.33239F, 15.5F);
      ((Path)localObject).lineTo(11.440057F, 15.496889F);
      ((Path)localObject).cubicTo(12.401943F, 15.441156F, 13.16478F, 14.643468F, 13.16478F, 13.66761F);
      ((Path)localObject).lineTo(13.16478F, 13.66761F);
      ((Path)localObject).lineTo(13.16478F, 8.937868F);
      ((Path)localObject).lineTo(14.836864F, 9.105346F);
      ((Path)localObject).lineTo(14.879482F, 9.101502F);
      ((Path)localObject).cubicTo(14.946941F, 9.085676F, 14.997169F, 9.025122F, 14.997169F, 8.952836F);
      ((Path)localObject).lineTo(14.997169F, 8.952836F);
      ((Path)localObject).lineTo(14.997169F, 7.427368F);
      ((Path)localObject).cubicTo(14.997169F, 7.348918F, 14.937724F, 7.283233F, 14.859664F, 7.275427F);
      ((Path)localObject).lineTo(14.859664F, 7.275427F);
      ((Path)localObject).lineTo(12.103492F, 7.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_music_comment
 * JD-Core Version:    0.7.0.1
 */