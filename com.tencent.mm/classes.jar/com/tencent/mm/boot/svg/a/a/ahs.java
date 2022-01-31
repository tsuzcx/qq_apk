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

public final class ahs
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-15028967);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(31.450109F, 60.4841F);
      ((Path)localObject).lineTo(32.711105F, 58.771122F);
      ((Path)localObject).lineTo(32.711105F, 58.771122F);
      ((Path)localObject).cubicTo(33.365929F, 57.881584F, 34.617882F, 57.691311F, 35.50742F, 58.346134F);
      ((Path)localObject).cubicTo(35.517391F, 58.353477F, 35.527294F, 58.360909F, 35.537128F, 58.368431F);
      ((Path)localObject).lineTo(49.747337F, 69.241776F);
      ((Path)localObject).lineTo(49.747337F, 69.241776F);
      ((Path)localObject).cubicTo(50.488701F, 69.809052F, 51.523895F, 69.788017F, 52.241604F, 69.191093F);
      ((Path)localObject).lineTo(89.730385F, 38.011433F);
      ((Path)localObject).lineTo(89.730385F, 38.011433F);
      ((Path)localObject).cubicTo(90.52095F, 37.35392F, 91.681259F, 37.403004F, 92.413467F, 38.124935F);
      ((Path)localObject).lineTo(93.147606F, 38.848774F);
      ((Path)localObject).lineTo(93.147606F, 38.848774F);
      ((Path)localObject).cubicTo(93.934151F, 39.624283F, 93.9431F, 40.890579F, 93.167587F, 41.677128F);
      ((Path)localObject).cubicTo(93.160156F, 41.684666F, 93.152664F, 41.692146F, 93.145111F, 41.699566F);
      ((Path)localObject).lineTo(52.450825F, 81.682739F);
      ((Path)localObject).lineTo(52.450825F, 81.682739F);
      ((Path)localObject).cubicTo(51.662922F, 82.456879F, 50.396641F, 82.445717F, 49.622509F, 81.657814F);
      ((Path)localObject).cubicTo(49.618988F, 81.654228F, 49.615482F, 81.650635F, 49.611988F, 81.647026F);
      ((Path)localObject).lineTo(31.623617F, 63.060673F);
      ((Path)localObject).lineTo(31.623617F, 63.060673F);
      ((Path)localObject).cubicTo(30.944754F, 62.359241F, 30.871418F, 61.270214F, 31.450109F, 60.4841F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ahs
 * JD-Core Version:    0.7.0.1
 */