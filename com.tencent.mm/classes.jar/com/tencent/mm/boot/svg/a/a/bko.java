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

public final class bko
  extends c
{
  private final int height = 32;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 32;
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
      localPaint.setColor(-419430401);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(14.5F, 19.85078F);
      ((Path)localObject).lineTo(14.5F, 30.0F);
      ((Path)localObject).cubicTo(14.5F, 30.552284F, 14.052284F, 31.0F, 13.5F, 31.0F);
      ((Path)localObject).lineTo(10.5F, 31.0F);
      ((Path)localObject).cubicTo(9.947715F, 31.0F, 9.5F, 30.552284F, 9.5F, 30.0F);
      ((Path)localObject).lineTo(9.5F, 19.85078F);
      ((Path)localObject).cubicTo(9.5F, 19.623709F, 9.422719F, 19.403399F, 9.280869F, 19.226086F);
      ((Path)localObject).lineTo(7.719131F, 17.273914F);
      ((Path)localObject).cubicTo(7.577281F, 17.096601F, 7.5F, 16.876291F, 7.5F, 16.64922F);
      ((Path)localObject).lineTo(7.5F, 14.0F);
      ((Path)localObject).cubicTo(7.5F, 13.447716F, 7.947715F, 13.0F, 8.5F, 13.0F);
      ((Path)localObject).lineTo(15.5F, 13.0F);
      ((Path)localObject).cubicTo(16.052284F, 13.0F, 16.5F, 13.447716F, 16.5F, 14.0F);
      ((Path)localObject).lineTo(16.5F, 16.64922F);
      ((Path)localObject).cubicTo(16.5F, 16.876291F, 16.42272F, 17.096601F, 16.280869F, 17.273914F);
      ((Path)localObject).lineTo(14.719131F, 19.226086F);
      ((Path)localObject).cubicTo(14.577281F, 19.403399F, 14.5F, 19.623709F, 14.5F, 19.85078F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(13.3F, 19.079063F);
      ((Path)localObject).lineTo(15.3F, 16.579063F);
      ((Path)localObject).lineTo(15.3F, 14.2F);
      ((Path)localObject).lineTo(8.7F, 14.2F);
      ((Path)localObject).lineTo(8.7F, 16.579063F);
      ((Path)localObject).lineTo(10.7F, 19.079063F);
      ((Path)localObject).lineTo(10.7F, 29.799999F);
      ((Path)localObject).lineTo(13.3F, 29.799999F);
      ((Path)localObject).lineTo(13.3F, 19.079063F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(8.1F, 11.0F);
      ((Path)localObject).lineTo(15.9F, 11.0F);
      ((Path)localObject).cubicTo(16.231371F, 11.0F, 16.5F, 11.268629F, 16.5F, 11.6F);
      ((Path)localObject).cubicTo(16.5F, 11.931371F, 16.231371F, 12.2F, 15.9F, 12.2F);
      ((Path)localObject).lineTo(8.1F, 12.2F);
      ((Path)localObject).cubicTo(7.768629F, 12.2F, 7.5F, 11.931371F, 7.5F, 11.6F);
      ((Path)localObject).cubicTo(7.5F, 11.268629F, 7.768629F, 11.0F, 8.1F, 11.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 21.0F);
      ((Path)localObject).cubicTo(12.33137F, 21.0F, 12.6F, 21.268629F, 12.6F, 21.6F);
      ((Path)localObject).lineTo(12.6F, 22.9F);
      ((Path)localObject).cubicTo(12.6F, 23.231371F, 12.33137F, 23.5F, 12.0F, 23.5F);
      ((Path)localObject).cubicTo(11.66863F, 23.5F, 11.4F, 23.231371F, 11.4F, 22.9F);
      ((Path)localObject).lineTo(11.4F, 21.6F);
      ((Path)localObject).cubicTo(11.4F, 21.268629F, 11.66863F, 21.0F, 12.0F, 21.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bko
 * JD-Core Version:    0.7.0.1
 */