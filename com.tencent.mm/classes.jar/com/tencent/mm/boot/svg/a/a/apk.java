package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public final class apk
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
      localPaint = c.a((Paint)localObject, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(3.6F);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(36.0F, 7.799999F);
      localPath.cubicTo(51.574432F, 7.799999F, 64.199997F, 20.425568F, 64.199997F, 36.0F);
      localPath.cubicTo(64.199997F, 51.574432F, 51.574432F, 64.199997F, 36.0F, 64.199997F);
      localPath.cubicTo(20.425568F, 64.199997F, 7.799999F, 51.574432F, 7.799999F, 36.0F);
      localPath.cubicTo(7.799999F, 20.425568F, 20.425568F, 7.799999F, 36.0F, 7.799999F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 19.799999F);
      ((Path)localObject).cubicTo(44.947014F, 19.799999F, 52.200001F, 27.052986F, 52.200001F, 36.0F);
      ((Path)localObject).cubicTo(52.200001F, 44.947014F, 44.947014F, 52.200001F, 36.0F, 52.200001F);
      ((Path)localObject).cubicTo(27.052986F, 52.200001F, 19.799999F, 44.947014F, 19.799999F, 36.0F);
      ((Path)localObject).cubicTo(19.799999F, 27.052986F, 27.052986F, 19.799999F, 36.0F, 19.799999F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.apk
 * JD-Core Version:    0.7.0.1
 */