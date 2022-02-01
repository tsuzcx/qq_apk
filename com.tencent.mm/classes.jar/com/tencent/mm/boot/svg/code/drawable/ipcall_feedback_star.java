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

public class ipcall_feedback_star
  extends c
{
  private final int height = 90;
  private final int width = 90;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 90;
      return 90;
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
      localCanvas.saveLayerAlpha(null, 25, 31);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(44.999012F, 71.646385F);
      ((Path)localObject).lineTo(18.061729F, 87.246506F);
      ((Path)localObject).cubicTo(16.15247F, 88.352211F, 15.124873F, 87.531441F, 15.765567F, 85.416451F);
      ((Path)localObject).lineTo(24.811031F, 55.556461F);
      ((Path)localObject).lineTo(1.004314F, 34.664188F);
      ((Path)localObject).cubicTo(-0.6587564F, 33.204716F, -0.2076475F, 32.021576F, 1.996635F, 32.021576F);
      ((Path)localObject).lineTo(31.459358F, 32.021576F);
      ((Path)localObject).lineTo(43.445843F, 3.529796F);
      ((Path)localObject).cubicTo(44.303635F, 1.49083F, 45.693748F, 1.489306F, 46.552185F, 3.529796F);
      ((Path)localObject).lineTo(58.538666F, 32.021576F);
      ((Path)localObject).lineTo(88.001389F, 32.021576F);
      ((Path)localObject).cubicTo(90.212502F, 32.021576F, 90.656677F, 33.204803F, 88.993713F, 34.664188F);
      ((Path)localObject).lineTo(65.186996F, 55.556461F);
      ((Path)localObject).lineTo(74.23246F, 85.416451F);
      ((Path)localObject).cubicTo(74.873581F, 87.532867F, 73.844276F, 88.351463F, 71.936295F, 87.246506F);
      ((Path)localObject).lineTo(44.999012F, 71.646385F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ipcall_feedback_star
 * JD-Core Version:    0.7.0.1
 */