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

public final class abn
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(9.0F, 16.667093F);
      localPath.lineTo(36.0F, 8.25F);
      localPath.lineTo(63.0F, 16.667093F);
      localPath.lineTo(63.0F, 26.25F);
      localPath.lineTo(9.0F, 26.25F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(9.0F, 55.41F);
      localPath.lineTo(63.0F, 55.41F);
      localPath.lineTo(63.0F, 63.75F);
      localPath.lineTo(9.0F, 63.75F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(14.345581F, 30.0F);
      localPath.lineTo(22.238159F, 30.0F);
      localPath.lineTo(22.238159F, 51.670166F);
      localPath.lineTo(14.345581F, 51.670166F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(32.057789F, 30.0F);
      localPath.lineTo(39.950367F, 30.0F);
      localPath.lineTo(39.950367F, 51.670166F);
      localPath.lineTo(32.057789F, 51.670166F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(49.77F, 30.0F);
      ((Path)localObject).lineTo(57.662579F, 30.0F);
      ((Path)localObject).lineTo(57.662579F, 51.670166F);
      ((Path)localObject).lineTo(49.77F, 51.670166F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.abn
 * JD-Core Version:    0.7.0.1
 */