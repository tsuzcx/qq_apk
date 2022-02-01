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

public final class ty
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
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
      ((Paint)localObject).setColor(-921103);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(120.0F, 0.0F);
      localPath.lineTo(120.0F, 120.0F);
      localPath.lineTo(0.0F, 120.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-3552823);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(50.865784F, 61.30489F);
      ((Path)localObject).cubicTo(54.721588F, 67.430023F, 48.319912F, 70.203362F, 45.646229F, 71.743996F);
      ((Path)localObject).cubicTo(34.143787F, 78.287827F, 29.117647F, 80.738686F, 29.117647F, 83.922951F);
      ((Path)localObject).lineTo(29.117647F, 88.272575F);
      ((Path)localObject).cubicTo(29.117647F, 89.670944F, 30.16357F, 90.882355F, 31.727423F, 90.882355F);
      ((Path)localObject).lineTo(88.272575F, 90.882355F);
      ((Path)localObject).cubicTo(89.836433F, 90.882355F, 90.882355F, 89.670944F, 90.882355F, 88.272575F);
      ((Path)localObject).lineTo(90.882355F, 83.922951F);
      ((Path)localObject).cubicTo(90.882355F, 80.738686F, 85.856216F, 78.287827F, 74.353767F, 71.743996F);
      ((Path)localObject).cubicTo(71.680084F, 70.203362F, 65.278412F, 67.430023F, 69.134216F, 61.30489F);
      ((Path)localObject).cubicTo(72.558441F, 56.21983F, 75.230331F, 54.148472F, 75.223694F, 45.646229F);
      ((Path)localObject).cubicTo(75.230331F, 37.574806F, 69.261391F, 29.117647F, 60.434963F, 29.117647F);
      ((Path)localObject).cubicTo(50.738609F, 29.117647F, 44.769665F, 37.574806F, 44.776306F, 45.646229F);
      ((Path)localObject).cubicTo(44.769665F, 54.148472F, 47.441559F, 56.21983F, 50.865784F, 61.30489F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ty
 * JD-Core Version:    0.7.0.1
 */