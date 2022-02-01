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

public final class kt
  extends c
{
  private final int height = 44;
  private final int width = 44;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 44;
      return 44;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      Paint localPaint2 = c.a((Paint)localObject, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.a(localPaint1, paramVarArgs);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      ((Paint)localObject).setColor(1711276032);
      localPaint2.setColor(-855638017);
      localPaint2.setStrokeWidth(1.023256F);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(21.488373F, 43.488373F);
      localPath.cubicTo(33.710506F, 43.488373F, 43.488373F, 34.01968F, 43.488373F, 22.511627F);
      localPath.cubicTo(43.488373F, 10.132299F, 33.867699F, 0.5116279F, 21.488373F, 0.5116279F);
      localPath.cubicTo(9.980321F, 0.5116279F, 0.5116279F, 10.289494F, 0.5116279F, 22.511627F);
      localPath.cubicTo(0.5116279F, 33.867699F, 10.132299F, 43.488373F, 21.488373F, 43.488373F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-419430401);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(19.648998F, 14.164668F);
      ((Path)localObject).cubicTo(19.477705F, 14.057058F, 19.279774F, 14.0F, 19.077778F, 14.0F);
      ((Path)localObject).cubicTo(18.482538F, 14.0F, 18.0F, 14.485024F, 18.0F, 15.083333F);
      ((Path)localObject).lineTo(18.0F, 28.931593F);
      ((Path)localObject).cubicTo(18.0F, 29.134632F, 18.056767F, 29.333584F, 18.163824F, 29.505758F);
      ((Path)localObject).cubicTo(18.479301F, 30.013124F, 19.144236F, 30.16736F, 19.648998F, 29.850258F);
      ((Path)localObject).lineTo(30.670794F, 22.926128F);
      ((Path)localObject).cubicTo(30.809578F, 22.838942F, 30.926786F, 22.721128F, 31.013527F, 22.581629F);
      ((Path)localObject).cubicTo(31.329002F, 22.074265F, 31.175556F, 21.405901F, 30.670794F, 21.088799F);
      ((Path)localObject).lineTo(19.648998F, 14.164668F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.kt
 * JD-Core Version:    0.7.0.1
 */