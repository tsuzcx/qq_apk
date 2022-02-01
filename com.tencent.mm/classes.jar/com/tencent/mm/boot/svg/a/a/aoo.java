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

public final class aoo
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
      ((Path)localObject).moveTo(20.320658F, 19.199991F);
      ((Path)localObject).lineTo(22.757717F, 60.142605F);
      ((Path)localObject).cubicTo(22.833185F, 61.410458F, 23.883381F, 62.400002F, 25.153477F, 62.400002F);
      ((Path)localObject).lineTo(46.846523F, 62.400002F);
      ((Path)localObject).cubicTo(48.116619F, 62.400002F, 49.166817F, 61.410458F, 49.242283F, 60.142605F);
      ((Path)localObject).lineTo(51.679344F, 19.199991F);
      ((Path)localObject).lineTo(55.285713F, 19.199991F);
      ((Path)localObject).lineTo(52.835922F, 60.35651F);
      ((Path)localObject).cubicTo(52.647255F, 63.526142F, 50.021767F, 66.0F, 46.846523F, 66.0F);
      ((Path)localObject).lineTo(25.153477F, 66.0F);
      ((Path)localObject).cubicTo(21.978235F, 66.0F, 19.352747F, 63.526142F, 19.164078F, 60.35651F);
      ((Path)localObject).lineTo(16.714285F, 19.199991F);
      ((Path)localObject).lineTo(20.320658F, 19.199991F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(28.5F, 27.0F);
      ((Path)localObject).lineTo(32.100037F, 27.0F);
      ((Path)localObject).lineTo(33.600037F, 54.0F);
      ((Path)localObject).lineTo(30.0F, 54.0F);
      ((Path)localObject).lineTo(28.5F, 27.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(39.899963F, 27.0F);
      ((Path)localObject).lineTo(43.5F, 27.0F);
      ((Path)localObject).lineTo(42.0F, 54.0F);
      ((Path)localObject).lineTo(38.399963F, 54.0F);
      ((Path)localObject).lineTo(39.899963F, 27.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(13.37715F, 7.059098F);
      ((Path)localObject).lineTo(60.647923F, 15.394211F);
      ((Path)localObject).cubicTo(61.463764F, 15.538066F, 62.008514F, 16.316053F, 61.864662F, 17.131895F);
      ((Path)localObject).lineTo(61.5F, 19.199991F);
      ((Path)localObject).lineTo(11.274805F, 10.343934F);
      ((Path)localObject).lineTo(11.639465F, 8.275838F);
      ((Path)localObject).cubicTo(11.78332F, 7.459996F, 12.561308F, 6.915243F, 13.37715F, 7.059098F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(32.249752F, 3.685124F);
      ((Path)localObject).lineTo(44.067444F, 5.768902F);
      ((Path)localObject).cubicTo(44.883286F, 5.912757F, 45.42804F, 6.690744F, 45.284184F, 7.506586F);
      ((Path)localObject).lineTo(44.919525F, 9.574673F);
      ((Path)localObject).lineTo(30.147408F, 6.96995F);
      ((Path)localObject).lineTo(30.512068F, 4.901863F);
      ((Path)localObject).cubicTo(30.655922F, 4.086022F, 31.43391F, 3.541269F, 32.249752F, 3.685124F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aoo
 * JD-Core Version:    0.7.0.1
 */