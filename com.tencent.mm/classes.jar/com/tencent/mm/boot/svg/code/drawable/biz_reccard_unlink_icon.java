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

public class biz_reccard_unlink_icon
  extends c
{
  private final int height = 14;
  private final int width = 20;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 20;
      return 14;
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
      localObject = c.instancePaint((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.instancePaint((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setColor(-2631721);
      ((Paint)localObject).setStrokeWidth(0.5F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.25F, 7.0F);
      localPath.cubicTo(0.25F, 3.272078F, 3.272078F, 0.25F, 7.0F, 0.25F);
      localPath.lineTo(13.0F, 0.25F);
      localPath.cubicTo(16.727922F, 0.25F, 19.75F, 3.272078F, 19.75F, 7.0F);
      localPath.lineTo(19.75F, 7.0F);
      localPath.cubicTo(19.75F, 10.727922F, 16.727922F, 13.75F, 13.0F, 13.75F);
      localPath.lineTo(7.0F, 13.75F);
      localPath.cubicTo(3.272078F, 13.75F, 0.25F, 10.727922F, 0.25F, 7.0F);
      localPath.lineTo(0.25F, 7.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-2631721);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.353554F, 4.02022F);
      ((Path)localObject).lineTo(13.02022F, 4.686887F);
      ((Path)localObject).lineTo(10.686F, 7.02F);
      ((Path)localObject).lineTo(13.02022F, 9.353554F);
      ((Path)localObject).lineTo(12.353554F, 10.02022F);
      ((Path)localObject).lineTo(10.02F, 7.686F);
      ((Path)localObject).lineTo(7.686887F, 10.02022F);
      ((Path)localObject).lineTo(7.02022F, 9.353554F);
      ((Path)localObject).lineTo(9.353F, 7.02F);
      ((Path)localObject).lineTo(7.02022F, 4.686887F);
      ((Path)localObject).lineTo(7.686887F, 4.02022F);
      ((Path)localObject).lineTo(10.02F, 6.353F);
      ((Path)localObject).lineTo(12.353554F, 4.02022F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.biz_reccard_unlink_icon
 * JD-Core Version:    0.7.0.1
 */