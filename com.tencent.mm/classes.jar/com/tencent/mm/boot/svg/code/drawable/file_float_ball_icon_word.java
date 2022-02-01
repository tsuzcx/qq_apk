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

public class file_float_ball_icon_word
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
      ((Paint)localObject).setColor(-13871462);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(48.0F, 0.0F);
      localPath.lineTo(48.0F, 48.0F);
      localPath.lineTo(0.0F, 48.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(23.941406F, 20.765625F);
      ((Path)localObject).lineTo(20.484375F, 33.0F);
      ((Path)localObject).lineTo(17.636719F, 33.0F);
      ((Path)localObject).lineTo(13.101563F, 16.089844F);
      ((Path)localObject).lineTo(16.242188F, 16.089844F);
      ((Path)localObject).lineTo(19.171875F, 28.898438F);
      ((Path)localObject).lineTo(19.265625F, 28.898438F);
      ((Path)localObject).lineTo(22.664063F, 16.089844F);
      ((Path)localObject).lineTo(25.335938F, 16.089844F);
      ((Path)localObject).lineTo(28.734375F, 28.898438F);
      ((Path)localObject).lineTo(28.828125F, 28.898438F);
      ((Path)localObject).lineTo(31.757813F, 16.089844F);
      ((Path)localObject).lineTo(34.898438F, 16.089844F);
      ((Path)localObject).lineTo(30.363281F, 33.0F);
      ((Path)localObject).lineTo(27.515625F, 33.0F);
      ((Path)localObject).lineTo(24.058594F, 20.765625F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.file_float_ball_icon_word
 * JD-Core Version:    0.7.0.1
 */