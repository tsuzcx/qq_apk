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

public final class alj
  extends c
{
  private final int height = 210;
  private final int width = 210;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 210;
      return 210;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.h(paramVarArgs);
      c.g(paramVarArgs);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.k(paramVarArgs);
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
      ((Paint)localObject).setColor(-2471350);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(105.0F, 0.0F);
      localPath.cubicTo(162.9899F, 0.0F, 210.0F, 47.010098F, 210.0F, 105.0F);
      localPath.cubicTo(210.0F, 162.9899F, 162.9899F, 210.0F, 105.0F, 210.0F);
      localPath.cubicTo(47.010098F, 210.0F, 0.0F, 162.9899F, 0.0F, 105.0F);
      localPath.cubicTo(0.0F, 47.010098F, 47.010098F, 0.0F, 105.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(105.0F, 96.461639F);
      ((Path)localObject).cubicTo(93.324905F, 96.461639F, 85.055748F, 99.221352F, 83.170647F, 101.40075F);
      ((Path)localObject).cubicTo(81.285538F, 103.58014F, 79.694786F, 112.07398F, 77.243507F, 114.4038F);
      ((Path)localObject).cubicTo(76.065399F, 115.52354F, 63.405796F, 117.93891F, 61.901104F, 118.25871F);
      ((Path)localObject).cubicTo(60.396412F, 118.57851F, 58.858971F, 118.73449F, 58.145496F, 117.71458F);
      ((Path)localObject).cubicTo(57.432022F, 116.69469F, 51.136547F, 103.91579F, 60.941509F, 96.859039F);
      ((Path)localObject).cubicTo(70.746475F, 89.802299F, 91.694466F, 87.155647F, 105.0F, 87.0F);
      ((Path)localObject).lineTo(105.0F, 96.461639F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(105.0F, 96.461639F);
      ((Path)localObject).cubicTo(116.67509F, 96.461639F, 124.94425F, 99.221352F, 126.82935F, 101.40075F);
      ((Path)localObject).cubicTo(128.71446F, 103.58014F, 130.30522F, 112.07398F, 132.7565F, 114.4038F);
      ((Path)localObject).cubicTo(133.9346F, 115.52354F, 146.59421F, 117.93891F, 148.09889F, 118.25871F);
      ((Path)localObject).cubicTo(149.60359F, 118.57851F, 151.14102F, 118.73449F, 151.85451F, 117.71458F);
      ((Path)localObject).cubicTo(152.56798F, 116.69469F, 158.86345F, 103.91579F, 149.05849F, 96.859039F);
      ((Path)localObject).cubicTo(139.25352F, 89.802299F, 118.30553F, 87.155647F, 105.0F, 87.0F);
      ((Path)localObject).lineTo(105.0F, 96.461639F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.alj
 * JD-Core Version:    0.7.0.1
 */