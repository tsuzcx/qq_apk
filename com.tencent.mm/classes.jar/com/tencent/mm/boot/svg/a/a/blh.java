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

public final class blh
  extends c
{
  private final int height = 24;
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
      return 24;
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
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-436207616);
      localCanvas.save();
      localObject = c.a((Paint)localObject, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(12.0F, 2.5F);
      localPath.lineTo(20.0F, 5.5F);
      localPath.lineTo(20.0F, 11.253789F);
      localPath.cubicTo(20.0F, 16.100143F, 16.701654F, 20.324587F, 12.0F, 21.5F);
      localPath.cubicTo(7.298345F, 20.324587F, 4.0F, 16.100143F, 4.0F, 11.253789F);
      localPath.lineTo(4.0F, 5.5F);
      localPath.lineTo(12.0F, 2.5F);
      localPath.close();
      localPath.moveTo(12.0F, 3.736932F);
      localPath.lineTo(5.2F, 6.436932F);
      localPath.lineTo(5.2F, 11.253789F);
      localPath.cubicTo(5.2F, 15.448791F, 7.98811F, 19.118086F, 12.0F, 20.258121F);
      localPath.cubicTo(16.01189F, 19.118086F, 18.799999F, 15.448791F, 18.799999F, 11.253789F);
      localPath.lineTo(18.801006F, 10.326383F);
      localPath.cubicTo(15.521906F, 12.101424F, 10.328912F, 14.912494F, 10.328912F, 14.912494F);
      localPath.lineTo(10.269167F, 14.94499F);
      localPath.cubicTo(10.195391F, 14.97961F, 10.112337F, 15.0F, 10.024304F, 15.0F);
      localPath.cubicTo(9.81995F, 15.0F, 9.6423F, 14.89444F, 9.549062F, 14.738543F);
      localPath.lineTo(9.513533F, 14.665479F);
      localPath.lineTo(8.026025F, 11.602328F);
      localPath.cubicTo(8.009957F, 11.568983F, 8.0F, 11.531177F, 8.0F, 11.494432F);
      localPath.cubicTo(8.0F, 11.353402F, 8.121979F, 11.239135F, 8.272245F, 11.239135F);
      localPath.cubicTo(8.333801F, 11.239135F, 8.389698F, 11.258038F, 8.435412F, 11.289897F);
      localPath.lineTo(10.190413F, 12.462525F);
      localPath.cubicTo(10.318275F, 12.541111F, 10.471936F, 12.587414F, 10.636687F, 12.587414F);
      localPath.cubicTo(10.734677F, 12.587414F, 10.828594F, 12.570422F, 10.915722F, 12.540474F);
      localPath.cubicTo(10.915722F, 12.540474F, 16.605129F, 10.16986F, 18.801807F, 9.256366F);
      localPath.lineTo(18.799999F, 6.436932F);
      localPath.lineTo(12.0F, 3.736932F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-2565928);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath((Path)localObject, c.a(localPaint, paramVarArgs));
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.blh
 * JD-Core Version:    0.7.0.1
 */