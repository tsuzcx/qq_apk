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

public class icons_outlined_vtoh_new
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
      localPaint.setColor(-436207616);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(14.0F, 5.5F);
      ((Path)localObject).cubicTo(14.552284F, 5.5F, 15.0F, 5.947715F, 15.0F, 6.5F);
      ((Path)localObject).lineTo(15.0F, 19.5F);
      ((Path)localObject).cubicTo(15.0F, 20.052284F, 14.552284F, 20.5F, 14.0F, 20.5F);
      ((Path)localObject).lineTo(6.0F, 20.5F);
      ((Path)localObject).cubicTo(5.447715F, 20.5F, 5.0F, 20.052284F, 5.0F, 19.5F);
      ((Path)localObject).lineTo(5.0F, 6.5F);
      ((Path)localObject).cubicTo(5.0F, 5.947715F, 5.447715F, 5.5F, 6.0F, 5.5F);
      ((Path)localObject).lineTo(14.0F, 5.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(13.5F, 7.0F);
      ((Path)localObject).lineTo(6.5F, 7.0F);
      ((Path)localObject).lineTo(6.5F, 19.0F);
      ((Path)localObject).lineTo(13.5F, 19.0F);
      ((Path)localObject).lineTo(13.5F, 7.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.216405F, 2.254379F);
      ((Path)localObject).lineTo(14.0F, 2.25F);
      ((Path)localObject).lineTo(14.0F, 0.75F);
      ((Path)localObject).cubicTo(17.648605F, 0.75F, 20.621082F, 3.644847F, 20.745918F, 7.263029F);
      ((Path)localObject).lineTo(20.75F, 7.5F);
      ((Path)localObject).lineTo(20.75F, 8.189F);
      ((Path)localObject).lineTo(21.969669F, 6.96967F);
      ((Path)localObject).lineTo(23.030331F, 8.03033F);
      ((Path)localObject).lineTo(20.530331F, 10.53033F);
      ((Path)localObject).cubicTo(20.264063F, 10.796597F, 19.847401F, 10.820803F, 19.553789F, 10.602948F);
      ((Path)localObject).lineTo(19.469669F, 10.53033F);
      ((Path)localObject).lineTo(16.969669F, 8.03033F);
      ((Path)localObject).lineTo(18.030331F, 6.96967F);
      ((Path)localObject).lineTo(19.25F, 8.189F);
      ((Path)localObject).lineTo(19.25F, 7.5F);
      ((Path)localObject).cubicTo(19.25F, 4.672992F, 17.015551F, 2.367868F, 14.216405F, 2.254379F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_vtoh_new
 * JD-Core Version:    0.7.0.1
 */