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

public final class bub
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
      ((Paint)localObject).setColor(-1);
      localCanvas.save();
      localObject = c.a((Paint)localObject, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 12.0F);
      localPath.cubicTo(0.0F, 5.372582F, 5.372582F, 0.0F, 12.0F, 0.0F);
      localPath.lineTo(12.0F, 0.0F);
      localPath.cubicTo(18.627419F, 0.0F, 24.0F, 5.372582F, 24.0F, 12.0F);
      localPath.lineTo(24.0F, 12.0F);
      localPath.cubicTo(24.0F, 18.627419F, 18.627419F, 24.0F, 12.0F, 24.0F);
      localPath.lineTo(12.0F, 24.0F);
      localPath.cubicTo(5.372582F, 24.0F, 0.0F, 18.627419F, 0.0F, 12.0F);
      localPath.lineTo(0.0F, 12.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16268960);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(8.897905F, 8.756343F);
      ((Path)localObject).lineTo(8.093485F, 8.282515F);
      ((Path)localObject).lineTo(7.720701F, 8.941259F);
      ((Path)localObject).cubicTo(6.451809F, 11.183511F, 6.908858F, 13.968303F, 8.6956F, 15.557907F);
      ((Path)localObject).lineTo(7.811896F, 17.119495F);
      ((Path)localObject).lineTo(9.420736F, 18.067152F);
      ((Path)localObject).lineTo(10.30444F, 16.505564F);
      ((Path)localObject).lineTo(10.30444F, 16.505564F);
      ((Path)localObject).cubicTo(12.547149F, 17.289433F, 15.139547F, 16.300861F, 16.40844F, 14.05861F);
      ((Path)localObject).lineTo(16.781223F, 13.399865F);
      ((Path)localObject).lineTo(15.976804F, 12.926036F);
      ((Path)localObject).lineTo(15.604019F, 13.584781F);
      ((Path)localObject).cubicTo(14.407016F, 15.7F, 11.875845F, 16.439146F, 9.999716F, 15.334046F);
      ((Path)localObject).cubicTo(7.966277F, 14.136288F, 7.328117F, 11.530307F, 8.525121F, 9.415088F);
      ((Path)localObject).lineTo(8.897905F, 8.756343F);
      ((Path)localObject).lineTo(8.897905F, 8.756343F);
      ((Path)localObject).lineTo(8.897905F, 8.756343F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(7.646646F, 17.675043F);
      ((Path)localObject).cubicTo(7.634969F, 17.550129F, 7.712002F, 17.499817F, 7.819568F, 17.563177F);
      ((Path)localObject).lineTo(9.04028F, 18.282215F);
      ((Path)localObject).cubicTo(9.147459F, 18.345346F, 9.143215F, 18.438997F, 9.031784F, 18.490932F);
      ((Path)localObject).lineTo(7.980113F, 18.981091F);
      ((Path)localObject).cubicTo(7.868241F, 19.033232F, 7.768041F, 18.973745F, 7.75641F, 18.849323F);
      ((Path)localObject).lineTo(7.646646F, 17.675043F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(11.453351F, 6.515008F);
      ((Path)localObject).cubicTo(12.272532F, 5.06744F, 14.091164F, 4.569142F, 15.512824F, 5.406545F);
      ((Path)localObject).cubicTo(16.934797F, 6.244133F, 17.421965F, 8.097922F, 16.601641F, 9.547512F);
      ((Path)localObject).lineTo(14.632907F, 13.026451F);
      ((Path)localObject).cubicTo(13.813726F, 14.474019F, 11.995094F, 14.972317F, 10.573434F, 14.134913F);
      ((Path)localObject).cubicTo(9.15146F, 13.297326F, 8.664292F, 11.443537F, 9.484617F, 9.993947F);
      ((Path)localObject).lineTo(11.453351F, 6.515008F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bub
 * JD-Core Version:    0.7.0.1
 */