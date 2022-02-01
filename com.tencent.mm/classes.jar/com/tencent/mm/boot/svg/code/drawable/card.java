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

public class card
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 192;
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
      localPaint.setColor(-15432210);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(16.0F, 40.006973F);
      ((Path)localObject).cubicTo(16.0F, 35.584843F, 19.642445F, 32.0F, 23.934425F, 32.0F);
      ((Path)localObject).lineTo(168.06558F, 32.0F);
      ((Path)localObject).cubicTo(172.44763F, 32.0F, 176.0F, 35.557049F, 176.0F, 40.006973F);
      ((Path)localObject).lineTo(176.0F, 151.99303F);
      ((Path)localObject).cubicTo(176.0F, 156.41516F, 172.35756F, 160.0F, 168.06558F, 160.0F);
      ((Path)localObject).lineTo(23.934425F, 160.0F);
      ((Path)localObject).cubicTo(19.552362F, 160.0F, 16.0F, 156.44295F, 16.0F, 151.99303F);
      ((Path)localObject).lineTo(16.0F, 40.006973F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(25.6F, 41.599998F);
      ((Path)localObject).lineTo(25.6F, 150.39999F);
      ((Path)localObject).lineTo(166.39999F, 150.39999F);
      ((Path)localObject).lineTo(166.39999F, 41.599998F);
      ((Path)localObject).lineTo(25.6F, 41.599998F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(40.0F, 64.0F);
      ((Path)localObject).lineTo(152.0F, 64.0F);
      ((Path)localObject).lineTo(152.0F, 73.599998F);
      ((Path)localObject).lineTo(40.0F, 73.599998F);
      ((Path)localObject).lineTo(40.0F, 64.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.card
 * JD-Core Version:    0.7.0.1
 */