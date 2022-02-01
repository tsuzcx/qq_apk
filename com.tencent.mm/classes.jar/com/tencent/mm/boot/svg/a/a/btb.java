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

public final class btb
  extends c
{
  private final int height = 80;
  private final int width = 80;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 80;
      return 80;
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
      ((Paint)localObject).setColor(-7960954);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(37.509998F, 0.0F);
      localPath.lineTo(41.009998F, 0.0F);
      localPath.cubicTo(50.900002F, 0.33F, 60.66F, 4.26F, 67.739998F, 11.21F);
      localPath.cubicTo(74.93F, 18.030001F, 79.209999F, 27.6F, 80.0F, 37.439999F);
      localPath.lineTo(80.0F, 41.849998F);
      localPath.cubicTo(79.43F, 53.110001F, 73.989998F, 64.059998F, 65.120003F, 71.080002F);
      localPath.cubicTo(58.759998F, 76.389999F, 50.68F, 79.260002F, 42.490002F, 80.0F);
      localPath.lineTo(37.869999F, 80.0F);
      localPath.cubicTo(29.1F, 79.360001F, 20.48F, 76.099998F, 13.87F, 70.230003F);
      localPath.cubicTo(5.72F, 63.349998F, 0.79F, 53.07F, 0.0F, 42.48F);
      localPath.lineTo(0.0F, 37.709999F);
      localPath.cubicTo(0.69F, 27.780001F, 5.0F, 18.120001F, 12.23F, 11.24F);
      localPath.cubicTo(18.959999F, 4.59F, 28.139999F, 0.8F, 37.509998F, 0.0F);
      localPath.lineTo(37.509998F, 0.0F);
      localPath.close();
      localPath.moveTo(17.290001F, 19.27F);
      localPath.cubicTo(14.37F, 19.98F, 12.73F, 23.07F, 12.98F, 25.93F);
      localPath.cubicTo(13.01F, 35.970001F, 12.9F, 46.02F, 13.03F, 56.060001F);
      localPath.cubicTo(12.91F, 59.669998F, 16.42F, 62.419998F, 19.879999F, 62.009998F);
      localPath.cubicTo(33.619999F, 61.990002F, 47.349998F, 62.099998F, 61.09F, 61.959999F);
      localPath.cubicTo(64.239998F, 62.060001F, 67.059998F, 59.240002F, 66.959999F, 56.080002F);
      localPath.cubicTo(67.139999F, 46.73F, 66.93F, 37.380001F, 67.050003F, 28.030001F);
      localPath.cubicTo(67.0F, 25.540001F, 67.269997F, 22.59F, 65.230003F, 20.74F);
      localPath.cubicTo(63.09F, 18.48F, 59.73F, 19.07F, 56.939999F, 18.950001F);
      localPath.cubicTo(43.73F, 19.209999F, 30.469999F, 18.58F, 17.290001F, 19.27F);
      localPath.lineTo(17.290001F, 19.27F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-7566196);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(56.0F, 47.0F);
      ((Path)localObject).lineTo(49.991882F, 47.0F);
      ((Path)localObject).cubicTo(48.893398F, 47.0F, 48.0F, 47.898079F, 48.0F, 49.00592F);
      ((Path)localObject).lineTo(48.0F, 51.99408F);
      ((Path)localObject).cubicTo(48.0F, 53.113445F, 48.891796F, 54.0F, 49.991882F, 54.0F);
      ((Path)localObject).lineTo(61.008118F, 54.0F);
      ((Path)localObject).cubicTo(62.106602F, 54.0F, 63.0F, 53.101921F, 63.0F, 51.99408F);
      ((Path)localObject).lineTo(63.0F, 49.007019F);
      ((Path)localObject).lineTo(63.0F, 37.991882F);
      ((Path)localObject).cubicTo(63.0F, 36.893398F, 62.101921F, 36.0F, 60.99408F, 36.0F);
      ((Path)localObject).lineTo(58.00592F, 36.0F);
      ((Path)localObject).cubicTo(56.886555F, 36.0F, 56.0F, 36.891796F, 56.0F, 37.991882F);
      ((Path)localObject).lineTo(56.0F, 47.0F);
      ((Path)localObject).lineTo(56.0F, 47.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(17.0F, 27.005919F);
      ((Path)localObject).cubicTo(17.0F, 25.898081F, 17.895857F, 25.0F, 18.997391F, 25.0F);
      ((Path)localObject).lineTo(24.002609F, 25.0F);
      ((Path)localObject).cubicTo(25.105738F, 25.0F, 26.0F, 25.886555F, 26.0F, 27.005919F);
      ((Path)localObject).lineTo(26.0F, 29.994081F);
      ((Path)localObject).cubicTo(26.0F, 31.101919F, 25.104143F, 32.0F, 24.002609F, 32.0F);
      ((Path)localObject).lineTo(18.997391F, 32.0F);
      ((Path)localObject).cubicTo(17.894262F, 32.0F, 17.0F, 31.113445F, 17.0F, 29.994081F);
      ((Path)localObject).lineTo(17.0F, 27.005919F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(17.0F, 38.00592F);
      ((Path)localObject).cubicTo(17.0F, 36.898079F, 17.893543F, 36.0F, 19.00276F, 36.0F);
      ((Path)localObject).lineTo(27.99724F, 36.0F);
      ((Path)localObject).cubicTo(29.103334F, 36.0F, 30.0F, 36.886555F, 30.0F, 38.00592F);
      ((Path)localObject).lineTo(30.0F, 40.99408F);
      ((Path)localObject).cubicTo(30.0F, 42.101921F, 29.106457F, 43.0F, 27.99724F, 43.0F);
      ((Path)localObject).lineTo(19.00276F, 43.0F);
      ((Path)localObject).cubicTo(17.896666F, 43.0F, 17.0F, 42.113445F, 17.0F, 40.99408F);
      ((Path)localObject).lineTo(17.0F, 38.00592F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(28.0F, 49.00592F);
      ((Path)localObject).cubicTo(28.0F, 47.898079F, 28.892622F, 47.0F, 29.995089F, 47.0F);
      ((Path)localObject).lineTo(44.00491F, 47.0F);
      ((Path)localObject).cubicTo(45.10677F, 47.0F, 46.0F, 47.886555F, 46.0F, 49.00592F);
      ((Path)localObject).lineTo(46.0F, 51.99408F);
      ((Path)localObject).cubicTo(46.0F, 53.101921F, 45.107376F, 54.0F, 44.00491F, 54.0F);
      ((Path)localObject).lineTo(29.995089F, 54.0F);
      ((Path)localObject).cubicTo(28.893232F, 54.0F, 28.0F, 53.113445F, 28.0F, 51.99408F);
      ((Path)localObject).lineTo(28.0F, 49.00592F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(28.0F, 27.005919F);
      ((Path)localObject).cubicTo(28.0F, 25.898081F, 28.895857F, 25.0F, 29.997391F, 25.0F);
      ((Path)localObject).lineTo(35.002609F, 25.0F);
      ((Path)localObject).cubicTo(36.105736F, 25.0F, 37.0F, 25.886555F, 37.0F, 27.005919F);
      ((Path)localObject).lineTo(37.0F, 29.994081F);
      ((Path)localObject).cubicTo(37.0F, 31.101919F, 36.104141F, 32.0F, 35.002609F, 32.0F);
      ((Path)localObject).lineTo(29.997391F, 32.0F);
      ((Path)localObject).cubicTo(28.894262F, 32.0F, 28.0F, 31.113445F, 28.0F, 29.994081F);
      ((Path)localObject).lineTo(28.0F, 27.005919F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(32.0F, 38.00592F);
      ((Path)localObject).cubicTo(32.0F, 36.898079F, 32.895859F, 36.0F, 33.997391F, 36.0F);
      ((Path)localObject).lineTo(39.002609F, 36.0F);
      ((Path)localObject).cubicTo(40.105736F, 36.0F, 41.0F, 36.886555F, 41.0F, 38.00592F);
      ((Path)localObject).lineTo(41.0F, 40.99408F);
      ((Path)localObject).cubicTo(41.0F, 42.101921F, 40.104141F, 43.0F, 39.002609F, 43.0F);
      ((Path)localObject).lineTo(33.997391F, 43.0F);
      ((Path)localObject).cubicTo(32.894264F, 43.0F, 32.0F, 42.113445F, 32.0F, 40.99408F);
      ((Path)localObject).lineTo(32.0F, 38.00592F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(17.0F, 49.00592F);
      ((Path)localObject).cubicTo(17.0F, 47.898079F, 17.895857F, 47.0F, 18.997391F, 47.0F);
      ((Path)localObject).lineTo(24.002609F, 47.0F);
      ((Path)localObject).cubicTo(25.105738F, 47.0F, 26.0F, 47.886555F, 26.0F, 49.00592F);
      ((Path)localObject).lineTo(26.0F, 51.99408F);
      ((Path)localObject).cubicTo(26.0F, 53.101921F, 25.104143F, 54.0F, 24.002609F, 54.0F);
      ((Path)localObject).lineTo(18.997391F, 54.0F);
      ((Path)localObject).cubicTo(17.894262F, 54.0F, 17.0F, 53.113445F, 17.0F, 51.99408F);
      ((Path)localObject).lineTo(17.0F, 49.00592F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(43.0F, 38.00592F);
      ((Path)localObject).cubicTo(43.0F, 36.898079F, 43.895859F, 36.0F, 44.997391F, 36.0F);
      ((Path)localObject).lineTo(50.002609F, 36.0F);
      ((Path)localObject).cubicTo(51.105736F, 36.0F, 52.0F, 36.886555F, 52.0F, 38.00592F);
      ((Path)localObject).lineTo(52.0F, 40.99408F);
      ((Path)localObject).cubicTo(52.0F, 42.101921F, 51.104141F, 43.0F, 50.002609F, 43.0F);
      ((Path)localObject).lineTo(44.997391F, 43.0F);
      ((Path)localObject).cubicTo(43.894264F, 43.0F, 43.0F, 42.113445F, 43.0F, 40.99408F);
      ((Path)localObject).lineTo(43.0F, 38.00592F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(39.0F, 27.005919F);
      ((Path)localObject).cubicTo(39.0F, 25.898081F, 39.895859F, 25.0F, 40.997391F, 25.0F);
      ((Path)localObject).lineTo(46.002609F, 25.0F);
      ((Path)localObject).cubicTo(47.105736F, 25.0F, 48.0F, 25.886555F, 48.0F, 27.005919F);
      ((Path)localObject).lineTo(48.0F, 29.994081F);
      ((Path)localObject).cubicTo(48.0F, 31.101919F, 47.104141F, 32.0F, 46.002609F, 32.0F);
      ((Path)localObject).lineTo(40.997391F, 32.0F);
      ((Path)localObject).cubicTo(39.894264F, 32.0F, 39.0F, 31.113445F, 39.0F, 29.994081F);
      ((Path)localObject).lineTo(39.0F, 27.005919F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(50.0F, 27.005919F);
      ((Path)localObject).cubicTo(50.0F, 25.898081F, 50.893543F, 25.0F, 52.002762F, 25.0F);
      ((Path)localObject).lineTo(60.997238F, 25.0F);
      ((Path)localObject).cubicTo(62.103333F, 25.0F, 63.0F, 25.886555F, 63.0F, 27.005919F);
      ((Path)localObject).lineTo(63.0F, 29.994081F);
      ((Path)localObject).cubicTo(63.0F, 31.101919F, 62.106457F, 32.0F, 60.997238F, 32.0F);
      ((Path)localObject).lineTo(52.002762F, 32.0F);
      ((Path)localObject).cubicTo(50.896667F, 32.0F, 50.0F, 31.113445F, 50.0F, 29.994081F);
      ((Path)localObject).lineTo(50.0F, 27.005919F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.btb
 * JD-Core Version:    0.7.0.1
 */