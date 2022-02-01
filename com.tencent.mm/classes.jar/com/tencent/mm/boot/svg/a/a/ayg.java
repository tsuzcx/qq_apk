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

public final class ayg
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.STROKE);
      localPaint2.setColor(-16777216);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.BUTT);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localPaint1.setStrokeMiter(4.0F);
      localPaint1.setPathEffect(null);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setColor(-8617594);
      localCanvas.save();
      Object localObject = c.a(localPaint2, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(96.0F, 48.0F);
      localPath.cubicTo(96.0F, 74.509666F, 74.509666F, 96.0F, 48.0F, 96.0F);
      localPath.cubicTo(21.490332F, 96.0F, 0.0F, 74.509666F, 0.0F, 48.0F);
      localPath.cubicTo(0.0F, 21.490332F, 21.490332F, 0.0F, 48.0F, 0.0F);
      localPath.cubicTo(74.509666F, 0.0F, 96.0F, 21.490332F, 96.0F, 48.0F);
      localPath.close();
      localPath.moveTo(2.232558F, 48.0F);
      localPath.cubicTo(2.232558F, 73.276657F, 22.723339F, 93.767441F, 48.0F, 93.767441F);
      localPath.cubicTo(73.276657F, 93.767441F, 93.767441F, 73.276657F, 93.767441F, 48.0F);
      localPath.cubicTo(93.767441F, 22.723339F, 73.276657F, 2.232558F, 48.0F, 2.232558F);
      localPath.cubicTo(22.723339F, 2.232558F, 2.232558F, 22.723339F, 2.232558F, 48.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-8617594);
      localPaint1.setStrokeWidth(2.0F);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(61.0F, 51.0F);
      ((Path)localObject).cubicTo(59.552845F, 51.154545F, 58.837399F, 50.327274F, 60.0F, 49.0F);
      ((Path)localObject).cubicTo(59.672085F, 48.436363F, 60.506775F, 47.727272F, 62.0F, 48.0F);
      ((Path)localObject).cubicTo(65.037941F, 46.663635F, 67.542007F, 43.945454F, 68.0F, 41.0F);
      ((Path)localObject).cubicTo(67.542007F, 36.736362F, 63.845528F, 33.545456F, 60.0F, 33.0F);
      ((Path)localObject).cubicTo(54.544716F, 33.545456F, 50.84824F, 36.736362F, 51.0F, 41.0F);
      ((Path)localObject).lineTo(51.0F, 58.0F);
      ((Path)localObject).cubicTo(50.84824F, 64.272728F, 45.482384F, 69.0F, 39.0F, 69.0F);
      ((Path)localObject).cubicTo(32.365852F, 69.0F, 27.0F, 64.272728F, 27.0F, 58.0F);
      ((Path)localObject).cubicTo(27.0F, 53.163635F, 31.173441F, 48.790909F, 37.0F, 48.0F);
      ((Path)localObject).cubicTo(38.208672F, 47.963638F, 38.804878F, 49.618183F, 38.0F, 50.0F);
      ((Path)localObject).cubicTo(37.759224F, 50.496105F, 37.373985F, 51.390907F, 36.0F, 51.0F);
      ((Path)localObject).cubicTo(32.962059F, 52.454544F, 30.457994F, 55.172726F, 30.0F, 58.0F);
      ((Path)localObject).cubicTo(30.457994F, 62.263638F, 34.154472F, 65.454544F, 38.0F, 66.0F);
      ((Path)localObject).cubicTo(43.455284F, 65.454544F, 47.15176F, 62.263638F, 47.0F, 58.0F);
      ((Path)localObject).lineTo(47.0F, 41.0F);
      ((Path)localObject).cubicTo(47.15176F, 34.727272F, 52.517616F, 30.0F, 59.0F, 30.0F);
      ((Path)localObject).cubicTo(65.634148F, 30.0F, 71.0F, 34.727272F, 71.0F, 41.0F);
      ((Path)localObject).cubicTo(71.0F, 45.954544F, 66.826561F, 50.209091F, 61.0F, 51.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ayg
 * JD-Core Version:    0.7.0.1
 */