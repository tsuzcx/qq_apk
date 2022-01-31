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

public final class ats
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
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
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-1);
      localCanvas.save();
      localObject = c.a((Paint)localObject, paramVarArgs);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(0.0F, 30.0F);
      localPath.cubicTo(0.0F, 13.431458F, 13.431458F, 0.0F, 30.0F, 0.0F);
      localPath.lineTo(30.0F, 0.0F);
      localPath.cubicTo(46.568542F, 0.0F, 60.0F, 13.431458F, 60.0F, 30.0F);
      localPath.lineTo(60.0F, 30.0F);
      localPath.cubicTo(60.0F, 46.568542F, 46.568542F, 60.0F, 30.0F, 60.0F);
      localPath.lineTo(30.0F, 60.0F);
      localPath.cubicTo(13.431458F, 60.0F, 0.0F, 46.568542F, 0.0F, 30.0F);
      localPath.lineTo(0.0F, 30.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-15028967);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(22.244762F, 21.890858F);
      ((Path)localObject).lineTo(20.233713F, 20.706285F);
      ((Path)localObject).lineTo(19.301752F, 22.353148F);
      ((Path)localObject).cubicTo(16.129522F, 27.958778F, 17.272146F, 34.920757F, 21.739F, 38.894768F);
      ((Path)localObject).lineTo(19.529739F, 42.798737F);
      ((Path)localObject).lineTo(23.551842F, 45.167881F);
      ((Path)localObject).lineTo(25.761101F, 41.263912F);
      ((Path)localObject).lineTo(25.761101F, 41.263912F);
      ((Path)localObject).cubicTo(31.367872F, 43.223583F, 37.848869F, 40.752155F, 41.021099F, 35.146523F);
      ((Path)localObject).lineTo(41.95306F, 33.499664F);
      ((Path)localObject).lineTo(39.942009F, 32.31509F);
      ((Path)localObject).lineTo(39.010048F, 33.961952F);
      ((Path)localObject).cubicTo(36.01754F, 39.25F, 29.689611F, 41.097866F, 24.999289F, 38.335117F);
      ((Path)localObject).cubicTo(19.915693F, 35.340721F, 18.320293F, 28.825768F, 21.312803F, 23.53772F);
      ((Path)localObject).lineTo(22.244762F, 21.890858F);
      ((Path)localObject).lineTo(22.244762F, 21.890858F);
      ((Path)localObject).lineTo(22.244762F, 21.890858F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(19.116613F, 44.187607F);
      ((Path)localObject).cubicTo(19.087423F, 43.875324F, 19.280006F, 43.749542F, 19.54892F, 43.907944F);
      ((Path)localObject).lineTo(22.600702F, 45.705536F);
      ((Path)localObject).cubicTo(22.868649F, 45.863365F, 22.85804F, 46.097492F, 22.57946F, 46.227333F);
      ((Path)localObject).lineTo(19.950281F, 47.452728F);
      ((Path)localObject).cubicTo(19.670603F, 47.583076F, 19.420101F, 47.434364F, 19.391026F, 47.123306F);
      ((Path)localObject).lineTo(19.116613F, 44.187607F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(28.633377F, 16.287519F);
      ((Path)localObject).cubicTo(30.681328F, 12.6686F, 35.227909F, 11.422856F, 38.782059F, 13.516363F);
      ((Path)localObject).cubicTo(42.336994F, 15.610331F, 43.554913F, 20.244806F, 41.504101F, 23.86878F);
      ((Path)localObject).lineTo(36.582268F, 32.566128F);
      ((Path)localObject).cubicTo(34.534317F, 36.185047F, 29.987736F, 37.43079F, 26.433584F, 35.337284F);
      ((Path)localObject).cubicTo(22.878649F, 33.243317F, 21.660732F, 28.608841F, 23.711542F, 24.984867F);
      ((Path)localObject).lineTo(28.633377F, 16.287519F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ats
 * JD-Core Version:    0.7.0.1
 */