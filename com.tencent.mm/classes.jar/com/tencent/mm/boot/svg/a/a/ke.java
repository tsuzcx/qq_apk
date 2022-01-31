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

public final class ke
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.i(paramVarArgs);
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
      ((Paint)localObject).setColor(-15028967);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(48.0F, 80.0F);
      localPath.cubicTo(65.673111F, 80.0F, 80.0F, 65.673111F, 80.0F, 48.0F);
      localPath.cubicTo(80.0F, 30.326887F, 65.673111F, 16.0F, 48.0F, 16.0F);
      localPath.cubicTo(30.326887F, 16.0F, 16.0F, 30.326887F, 16.0F, 48.0F);
      localPath.cubicTo(16.0F, 65.673111F, 30.326887F, 80.0F, 48.0F, 80.0F);
      localPath.close();
      localPath.moveTo(48.0F, 88.0F);
      localPath.cubicTo(25.908609F, 88.0F, 8.0F, 70.091393F, 8.0F, 48.0F);
      localPath.cubicTo(8.0F, 25.908609F, 25.908609F, 8.0F, 48.0F, 8.0F);
      localPath.cubicTo(70.091393F, 8.0F, 88.0F, 25.908609F, 88.0F, 48.0F);
      localPath.cubicTo(88.0F, 70.091393F, 70.091393F, 88.0F, 48.0F, 88.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-15028967);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(48.0F, 65.0F);
      ((Path)localObject).cubicTo(57.38884F, 65.0F, 65.0F, 57.38884F, 65.0F, 48.0F);
      ((Path)localObject).cubicTo(65.0F, 38.61116F, 57.38884F, 31.0F, 48.0F, 31.0F);
      ((Path)localObject).cubicTo(38.61116F, 31.0F, 31.0F, 38.61116F, 31.0F, 48.0F);
      ((Path)localObject).cubicTo(31.0F, 57.38884F, 38.61116F, 65.0F, 48.0F, 65.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.0F, 73.0F);
      ((Path)localObject).cubicTo(34.192883F, 73.0F, 23.0F, 61.807117F, 23.0F, 48.0F);
      ((Path)localObject).cubicTo(23.0F, 34.192883F, 34.192883F, 23.0F, 48.0F, 23.0F);
      ((Path)localObject).cubicTo(61.807117F, 23.0F, 73.0F, 34.192883F, 73.0F, 48.0F);
      ((Path)localObject).cubicTo(73.0F, 61.807117F, 61.807117F, 73.0F, 48.0F, 73.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ke
 * JD-Core Version:    0.7.0.1
 */