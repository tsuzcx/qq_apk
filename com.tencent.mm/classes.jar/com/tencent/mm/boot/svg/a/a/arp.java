package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class arp
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
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 3.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(3.6F, 12.6F);
      ((Path)localObject2).lineTo(3.6F, 59.400002F);
      ((Path)localObject2).lineTo(32.400002F, 59.400002F);
      ((Path)localObject2).lineTo(32.400002F, 39.0F);
      ((Path)localObject2).lineTo(36.0F, 39.0F);
      ((Path)localObject2).lineTo(36.0F, 60.0F);
      ((Path)localObject2).cubicTo(36.0F, 61.656853F, 34.656853F, 63.0F, 33.0F, 63.0F);
      ((Path)localObject2).lineTo(3.0F, 63.0F);
      ((Path)localObject2).cubicTo(1.343146F, 63.0F, 2.029061E-016F, 61.656853F, 0.0F, 60.0F);
      ((Path)localObject2).lineTo(0.0F, 12.0F);
      ((Path)localObject2).cubicTo(-2.029061E-016F, 10.343145F, 1.343146F, 9.0F, 3.0F, 9.0F);
      ((Path)localObject2).lineTo(9.0F, 9.0F);
      ((Path)localObject2).lineTo(9.0F, 12.6F);
      ((Path)localObject2).lineTo(3.6F, 12.6F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.11055F, 1.210308F);
      ((Path)localObject2).lineTo(19.060284F, 1.210308F);
      ((Path)localObject2).cubicTo(19.474497F, 1.210308F, 19.810284F, 1.546095F, 19.810284F, 1.960308F);
      ((Path)localObject2).cubicTo(19.810284F, 1.968547F, 19.810148F, 1.976786F, 19.809877F, 1.98502F);
      ((Path)localObject2).lineTo(19.409327F, 14.13502F);
      ((Path)localObject2).cubicTo(19.395996F, 14.539394F, 19.064329F, 14.860309F, 18.659735F, 14.860309F);
      ((Path)localObject2).lineTo(16.511099F, 14.860309F);
      ((Path)localObject2).cubicTo(16.106504F, 14.860309F, 15.774837F, 14.539394F, 15.761506F, 14.13502F);
      ((Path)localObject2).lineTo(15.360956F, 1.98502F);
      ((Path)localObject2).cubicTo(15.347308F, 1.571032F, 15.671849F, 1.224363F, 16.085838F, 1.210716F);
      ((Path)localObject2).cubicTo(16.094072F, 1.210444F, 16.10231F, 1.210308F, 16.11055F, 1.210308F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(35.839252F, 8.160385F);
      ((Path)localObject2).lineTo(37.92503F, 10.246162F);
      ((Path)localObject2).cubicTo(38.217926F, 10.539056F, 38.217926F, 11.013929F, 37.92503F, 11.306823F);
      ((Path)localObject2).cubicTo(37.919205F, 11.312649F, 37.913284F, 11.318378F, 37.907269F, 11.324009F);
      ((Path)localObject2).lineTo(29.03269F, 19.632124F);
      ((Path)localObject2).cubicTo(28.737329F, 19.908634F, 28.275883F, 19.90103F, 27.989792F, 19.614939F);
      ((Path)localObject2).lineTo(26.470478F, 18.095625F);
      ((Path)localObject2).cubicTo(26.184387F, 17.809532F, 26.176783F, 17.348087F, 26.453291F, 17.052727F);
      ((Path)localObject2).lineTo(34.76141F, 8.178147F);
      ((Path)localObject2).cubicTo(35.044491F, 7.875763F, 35.519108F, 7.860116F, 35.821491F, 8.143199F);
      ((Path)localObject2).cubicTo(35.827507F, 8.14883F, 35.833427F, 8.154559F, 35.839252F, 8.160385F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(44.875107F, 27.025133F);
      ((Path)localObject2).lineTo(44.875107F, 29.974867F);
      ((Path)localObject2).cubicTo(44.875107F, 30.38908F, 44.539322F, 30.724867F, 44.125107F, 30.724867F);
      ((Path)localObject2).cubicTo(44.116871F, 30.724867F, 44.108631F, 30.724731F, 44.100395F, 30.724461F);
      ((Path)localObject2).lineTo(31.950396F, 30.32391F);
      ((Path)localObject2).cubicTo(31.546022F, 30.310579F, 31.225109F, 29.978912F, 31.225109F, 29.574318F);
      ((Path)localObject2).lineTo(31.225109F, 27.425682F);
      ((Path)localObject2).cubicTo(31.225109F, 27.021088F, 31.546022F, 26.689421F, 31.950396F, 26.67609F);
      ((Path)localObject2).lineTo(44.100395F, 26.275539F);
      ((Path)localObject2).cubicTo(44.514385F, 26.261892F, 44.861053F, 26.586432F, 44.874702F, 27.000422F);
      ((Path)localObject2).cubicTo(44.874973F, 27.008656F, 44.875107F, 27.016893F, 44.875107F, 27.025133F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.arp
 * JD-Core Version:    0.7.0.1
 */