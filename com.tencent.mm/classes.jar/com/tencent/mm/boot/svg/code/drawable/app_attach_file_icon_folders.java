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

public class app_attach_file_icon_folders
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-2049700);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(86.25F, 32.253368F);
      ((Path)localObject).lineTo(86.25F, 28.75F);
      ((Path)localObject).cubicTo(86.25F, 26.678932F, 84.571068F, 25.0F, 82.5F, 25.0F);
      ((Path)localObject).lineTo(7.5F, 25.0F);
      ((Path)localObject).cubicTo(5.428932F, 25.0F, 3.75F, 26.678932F, 3.75F, 28.75F);
      ((Path)localObject).lineTo(3.75F, 32.253368F);
      ((Path)localObject).cubicTo(4.85315F, 31.615229F, 6.133923F, 31.25F, 7.5F, 31.25F);
      ((Path)localObject).lineTo(82.5F, 31.25F);
      ((Path)localObject).cubicTo(83.866074F, 31.25F, 85.146851F, 31.615229F, 86.25F, 32.253368F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(3.75F, 10.0F);
      ((Path)localObject).lineTo(29.696699F, 10.0F);
      ((Path)localObject).cubicTo(30.691261F, 10.0F, 31.645088F, 10.395088F, 32.348351F, 11.09835F);
      ((Path)localObject).lineTo(37.651649F, 16.401649F);
      ((Path)localObject).cubicTo(38.354912F, 17.104912F, 39.308739F, 17.5F, 40.303303F, 17.5F);
      ((Path)localObject).lineTo(86.25F, 17.5F);
      ((Path)localObject).cubicTo(88.321068F, 17.5F, 90.0F, 19.178932F, 90.0F, 21.25F);
      ((Path)localObject).lineTo(90.0F, 76.25F);
      ((Path)localObject).cubicTo(90.0F, 78.321068F, 88.321068F, 80.0F, 86.25F, 80.0F);
      ((Path)localObject).lineTo(3.75F, 80.0F);
      ((Path)localObject).cubicTo(1.678932F, 80.0F, 2.536327E-016F, 78.321068F, 0.0F, 76.25F);
      ((Path)localObject).lineTo(-8.881784E-016F, 13.75F);
      ((Path)localObject).cubicTo(-1.141811E-015F, 11.678932F, 1.678932F, 10.0F, 3.75F, 10.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_folders
 * JD-Core Version:    0.7.0.1
 */