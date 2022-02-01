package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class appbrand_menu_share_appmsg
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16268960);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(33.75F, 20.999361F);
      ((Path)localObject).lineTo(33.75F, 40.5F);
      ((Path)localObject).lineTo(38.25F, 40.5F);
      ((Path)localObject).lineTo(38.25F, 20.999361F);
      ((Path)localObject).lineTo(57.003132F, 21.0F);
      ((Path)localObject).cubicTo(58.652611F, 21.0F, 60.0F, 22.337517F, 60.0F, 23.987425F);
      ((Path)localObject).lineTo(60.0F, 63.012573F);
      ((Path)localObject).cubicTo(60.0F, 64.653236F, 58.662483F, 66.0F, 57.012573F, 66.0F);
      ((Path)localObject).lineTo(14.987426F, 66.0F);
      ((Path)localObject).cubicTo(13.346761F, 66.0F, 12.0F, 64.662483F, 12.0F, 63.012573F);
      ((Path)localObject).lineTo(12.0F, 23.987425F);
      ((Path)localObject).cubicTo(12.0F, 22.34676F, 13.341744F, 21.0F, 14.99687F, 21.0F);
      ((Path)localObject).lineTo(33.75F, 20.999361F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(37.992161F, 6.485886F);
      ((Path)localObject).lineTo(38.136162F, 6.62084F);
      ((Path)localObject).cubicTo(38.136269F, 6.620947F, 38.136375F, 6.621053F, 38.136162F, 6.621481F);
      ((Path)localObject).lineTo(46.620003F, 15.106602F);
      ((Path)localObject).lineTo(43.438499F, 18.288582F);
      ((Path)localObject).lineTo(38.25F, 13.09936F);
      ((Path)localObject).lineTo(38.25F, 20.999361F);
      ((Path)localObject).lineTo(33.75F, 20.999361F);
      ((Path)localObject).lineTo(33.75F, 13.128361F);
      ((Path)localObject).lineTo(28.591501F, 18.288582F);
      ((Path)localObject).lineTo(25.41F, 15.106602F);
      ((Path)localObject).lineTo(33.893841F, 6.621481F);
      ((Path)localObject).cubicTo(35.018158F, 5.496378F, 36.813705F, 5.451242F, 37.992161F, 6.485886F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.appbrand_menu_share_appmsg
 * JD-Core Version:    0.7.0.1
 */