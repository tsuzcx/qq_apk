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

public final class ajx
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(45.536026F, 38.159416F);
      ((Path)localObject).cubicTo(50.24942F, 37.339699F, 53.645454F, 33.622532F, 53.645454F, 29.181818F);
      ((Path)localObject).cubicTo(53.645454F, 24.142166F, 49.159824F, 20.1F, 43.654545F, 20.1F);
      ((Path)localObject).cubicTo(38.149265F, 20.1F, 33.663635F, 24.142166F, 33.663635F, 29.181818F);
      ((Path)localObject).lineTo(33.663635F, 42.81818F);
      ((Path)localObject).cubicTo(33.663635F, 45.311462F, 31.248707F, 47.372726F, 28.199999F, 47.372726F);
      ((Path)localObject).cubicTo(25.151291F, 47.372726F, 22.736362F, 45.311462F, 22.736362F, 42.81818F);
      ((Path)localObject).cubicTo(22.736362F, 40.836388F, 24.303173F, 39.063953F, 26.592993F, 38.511238F);
      ((Path)localObject).cubicTo(27.61693F, 38.255287F, 28.55695F, 37.512451F, 28.936319F, 36.627254F);
      ((Path)localObject).cubicTo(28.997086F, 36.50983F, 29.049339F, 36.355717F, 29.076389F, 36.193413F);
      ((Path)localObject).cubicTo(29.095797F, 36.076969F, 29.100494F, 35.987602F, 29.099997F, 35.816437F);
      ((Path)localObject).cubicTo(29.099998F, 34.696651F, 28.163311F, 33.918182F, 26.927271F, 33.918182F);
      ((Path)localObject).lineTo(26.563635F, 33.918182F);
      ((Path)localObject).cubicTo(21.778351F, 34.635788F, 18.299999F, 38.397312F, 18.299999F, 42.81818F);
      ((Path)localObject).cubicTo(18.299999F, 47.857834F, 22.785629F, 51.900002F, 28.290909F, 51.900002F);
      ((Path)localObject).cubicTo(33.796185F, 51.900002F, 38.281818F, 47.857834F, 38.281818F, 42.81818F);
      ((Path)localObject).lineTo(38.281818F, 29.181818F);
      ((Path)localObject).cubicTo(38.281818F, 26.688538F, 40.696747F, 24.627274F, 43.745453F, 24.627274F);
      ((Path)localObject).cubicTo(46.794163F, 24.627274F, 49.209091F, 26.688538F, 49.209091F, 29.181818F);
      ((Path)localObject).cubicTo(49.209091F, 31.239927F, 47.659065F, 33.022903F, 45.352459F, 33.57967F);
      ((Path)localObject).cubicTo(44.305294F, 33.81221F, 43.410641F, 34.526798F, 43.009132F, 35.463654F);
      ((Path)localObject).cubicTo(42.373043F, 36.894634F, 43.386848F, 38.172726F, 45.018181F, 38.172726F);
      ((Path)localObject).lineTo(45.536026F, 38.159416F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ajx
 * JD-Core Version:    0.7.0.1
 */