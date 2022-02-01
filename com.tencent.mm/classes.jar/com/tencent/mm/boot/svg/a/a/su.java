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

public final class su
  extends c
{
  private final int height = 240;
  private final int width = 241;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 241;
      return 240;
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
      ((Paint)localObject).setColor(-564640);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(220.0F, 121.23457F);
      localPath.cubicTo(220.0F, 64.77037F, 175.22963F, 20.0F, 118.76543F, 20.0F);
      localPath.cubicTo(64.77037F, 20.0F, 20.0F, 64.77037F, 20.0F, 121.23457F);
      localPath.cubicTo(20.0F, 175.22963F, 64.77037F, 220.0F, 118.76543F, 220.0F);
      localPath.cubicTo(175.22963F, 220.0F, 220.0F, 175.22963F, 220.0F, 121.23457F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(114.11689F, 70.980392F);
      ((Path)localObject).cubicTo(111.95148F, 70.980392F, 110.27686F, 72.725281F, 110.37761F, 74.90139F);
      ((Path)localObject).lineTo(113.37151F, 139.56976F);
      ((Path)localObject).cubicTo(113.42262F, 140.67371F, 114.36253F, 141.56863F, 115.46362F, 141.56863F);
      ((Path)localObject).lineTo(124.53638F, 141.56863F);
      ((Path)localObject).cubicTo(125.64071F, 141.56863F, 126.57727F, 140.67613F, 126.62849F, 139.56976F);
      ((Path)localObject).lineTo(129.62239F, 74.90139F);
      ((Path)localObject).cubicTo(129.72266F, 72.735878F, 128.0466F, 70.980392F, 125.88311F, 70.980392F);
      ((Path)localObject).lineTo(114.11689F, 70.980392F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(120.0F, 172.94118F);
      ((Path)localObject).cubicTo(125.41456F, 172.94118F, 129.80392F, 168.5518F, 129.80392F, 163.13725F);
      ((Path)localObject).cubicTo(129.80392F, 157.7227F, 125.41456F, 153.33333F, 120.0F, 153.33333F);
      ((Path)localObject).cubicTo(114.58544F, 153.33333F, 110.19608F, 157.7227F, 110.19608F, 163.13725F);
      ((Path)localObject).cubicTo(110.19608F, 168.5518F, 114.58544F, 172.94118F, 120.0F, 172.94118F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.su
 * JD-Core Version:    0.7.0.1
 */