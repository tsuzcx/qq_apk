package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class kr
  extends c
{
  private final int height = 14;
  private final int width = 20;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(13.0F, 0.0F);
      localPath.cubicTo(16.865993F, 0.0F, 20.0F, 3.134007F, 20.0F, 7.0F);
      localPath.cubicTo(20.0F, 10.865993F, 16.865993F, 14.0F, 13.0F, 14.0F);
      localPath.lineTo(7.0F, 14.0F);
      localPath.cubicTo(3.134007F, 14.0F, 0.0F, 10.865993F, 0.0F, 7.0F);
      localPath.cubicTo(0.0F, 3.134007F, 3.134007F, 0.0F, 7.0F, 0.0F);
      localPath.lineTo(13.0F, 0.0F);
      localPath.close();
      localPath.moveTo(13.0F, 0.5F);
      localPath.lineTo(7.0F, 0.5F);
      localPath.cubicTo(3.410149F, 0.5F, 0.5F, 3.410149F, 0.5F, 7.0F);
      localPath.cubicTo(0.5F, 10.51181F, 3.284996F, 13.373151F, 6.766866F, 13.495897F);
      localPath.lineTo(7.0F, 13.5F);
      localPath.lineTo(13.0F, 13.5F);
      localPath.cubicTo(16.589851F, 13.5F, 19.5F, 10.58985F, 19.5F, 7.0F);
      localPath.cubicTo(19.5F, 3.48819F, 16.715004F, 0.6268495F, 13.233134F, 0.504103F);
      localPath.lineTo(13.0F, 0.5F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
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
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.kr
 * JD-Core Version:    0.7.0.1
 */