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

public final class aqh
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
      ((Path)localObject).moveTo(62.549999F, 25.413738F);
      ((Path)localObject).cubicTo(62.549999F, 18.25061F, 56.113007F, 12.45F, 48.148563F, 12.45F);
      ((Path)localObject).cubicTo(40.184116F, 12.45F, 33.747124F, 18.25061F, 33.747124F, 25.413738F);
      ((Path)localObject).lineTo(33.747124F, 46.979233F);
      ((Path)localObject).cubicTo(33.747124F, 51.748341F, 29.256884F, 55.58099F, 23.707668F, 55.58099F);
      ((Path)localObject).cubicTo(18.158451F, 55.58099F, 13.668211F, 51.748341F, 13.668211F, 46.979233F);
      ((Path)localObject).cubicTo(13.668211F, 43.163658F, 16.618019F, 39.826721F, 20.834455F, 38.808975F);
      ((Path)localObject).cubicTo(22.039108F, 38.507828F, 23.166615F, 37.616833F, 23.598444F, 36.611534F);
      ((Path)localObject).cubicTo(23.658064F, 36.493694F, 23.69515F, 36.384315F, 23.713804F, 36.272388F);
      ((Path)localObject).cubicTo(23.728848F, 36.182133F, 23.732689F, 36.109043F, 23.732109F, 35.908947F);
      ((Path)localObject).cubicTo(23.732109F, 34.971008F, 22.928375F, 34.303036F, 21.694889F, 34.303036F);
      ((Path)localObject).lineTo(21.187166F, 34.297966F);
      ((Path)localObject).cubicTo(14.425144F, 35.321667F, 9.45F, 40.701839F, 9.45F, 46.979233F);
      ((Path)localObject).cubicTo(9.45F, 54.142361F, 15.886992F, 59.94297F, 23.851439F, 59.94297F);
      ((Path)localObject).cubicTo(31.815884F, 59.94297F, 38.252876F, 54.142361F, 38.252876F, 46.979233F);
      ((Path)localObject).lineTo(38.252876F, 25.413738F);
      ((Path)localObject).cubicTo(38.252876F, 20.64463F, 42.743114F, 16.811981F, 48.292332F, 16.811981F);
      ((Path)localObject).cubicTo(53.841549F, 16.811981F, 58.331791F, 20.64463F, 58.331791F, 25.413738F);
      ((Path)localObject).cubicTo(58.331791F, 29.344591F, 55.412464F, 32.702663F, 51.154003F, 33.730492F);
      ((Path)localObject).cubicTo(49.911591F, 34.006512F, 48.867401F, 34.840534F, 48.411232F, 35.904827F);
      ((Path)localObject).cubicTo(47.841995F, 37.185532F, 48.673428F, 38.233707F, 50.300301F, 38.23373F);
      ((Path)localObject).lineTo(50.920006F, 38.227108F);
      ((Path)localObject).cubicTo(57.70792F, 37.031017F, 62.549999F, 31.720058F, 62.549999F, 25.413738F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aqh
 * JD-Core Version:    0.7.0.1
 */