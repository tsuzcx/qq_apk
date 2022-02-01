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

public final class adg
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      ((Paint)localObject).setColor(-1);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(24.0F, 35.599998F);
      localPath.cubicTo(30.406504F, 35.599998F, 35.599998F, 30.406504F, 35.599998F, 24.0F);
      localPath.cubicTo(35.599998F, 17.593496F, 30.406504F, 12.4F, 24.0F, 12.4F);
      localPath.cubicTo(17.593496F, 12.4F, 12.4F, 17.593496F, 12.4F, 24.0F);
      localPath.cubicTo(12.4F, 30.406504F, 17.593496F, 35.599998F, 24.0F, 35.599998F);
      localPath.close();
      localPath.moveTo(24.0F, 38.0F);
      localPath.cubicTo(16.268013F, 38.0F, 10.0F, 31.731987F, 10.0F, 24.0F);
      localPath.cubicTo(10.0F, 16.268013F, 16.268013F, 10.0F, 24.0F, 10.0F);
      localPath.cubicTo(31.731987F, 10.0F, 38.0F, 16.268013F, 38.0F, 24.0F);
      localPath.cubicTo(38.0F, 31.731987F, 31.731987F, 38.0F, 24.0F, 38.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(24.0F, 43.599998F);
      ((Path)localObject).cubicTo(34.82478F, 43.599998F, 43.599998F, 34.82478F, 43.599998F, 24.0F);
      ((Path)localObject).cubicTo(43.599998F, 13.175219F, 34.82478F, 4.4F, 24.0F, 4.4F);
      ((Path)localObject).cubicTo(13.175219F, 4.4F, 4.4F, 13.175219F, 4.4F, 24.0F);
      ((Path)localObject).cubicTo(4.4F, 34.82478F, 13.175219F, 43.599998F, 24.0F, 43.599998F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(24.0F, 46.0F);
      ((Path)localObject).cubicTo(11.849735F, 46.0F, 2.0F, 36.150265F, 2.0F, 24.0F);
      ((Path)localObject).cubicTo(2.0F, 11.849735F, 11.849735F, 2.0F, 24.0F, 2.0F);
      ((Path)localObject).cubicTo(36.150265F, 2.0F, 46.0F, 11.849735F, 46.0F, 24.0F);
      ((Path)localObject).cubicTo(46.0F, 36.150265F, 36.150265F, 46.0F, 24.0F, 46.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.adg
 * JD-Core Version:    0.7.0.1
 */