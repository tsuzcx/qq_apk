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

public class album_ad_link_tag_weapp_dark
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-2130706433);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(34.008598F, 25.981501F);
      ((Path)localObject).lineTo(33.5368F, 25.989201F);
      ((Path)localObject).cubicTo(32.1101F, 25.989201F, 31.2799F, 24.9426F, 31.8162F, 23.735901F);
      ((Path)localObject).cubicTo(32.183498F, 22.879F, 33.0121F, 22.2171F, 33.9907F, 21.999701F);
      ((Path)localObject).cubicTo(36.609001F, 21.367701F, 38.387901F, 19.321501F, 38.387901F, 16.942499F);
      ((Path)localObject).cubicTo(38.387901F, 14.0584F, 35.6343F, 11.708F, 32.194901F, 11.708F);
      ((Path)localObject).cubicTo(28.7556F, 11.708F, 26.002001F, 14.0584F, 26.002001F, 16.942499F);
      ((Path)localObject).lineTo(26.002001F, 31.3195F);
      ((Path)localObject).cubicTo(26.002001F, 36.383301F, 21.4758F, 40.462002F, 15.901F, 40.462002F);
      ((Path)localObject).cubicTo(10.3262F, 40.462002F, 5.80005F, 36.383301F, 5.80005F, 31.3195F);
      ((Path)localObject).cubicTo(5.80005F, 26.879299F, 9.30473F, 23.0893F, 14.0799F, 22.3687F);
      ((Path)localObject).lineTo(14.4633F, 22.3687F);
      ((Path)localObject).cubicTo(15.5434F, 22.3687F, 16.321501F, 23.015301F, 16.321501F, 23.9387F);
      ((Path)localObject).cubicTo(16.321899F, 24.097F, 16.3181F, 24.170099F, 16.302401F, 24.2638F);
      ((Path)localObject).cubicTo(16.281401F, 24.3902F, 16.2404F, 24.511101F, 16.183901F, 24.621901F);
      ((Path)localObject).cubicTo(15.8396F, 25.4252F, 14.9596F, 26.1206F, 14.0094F, 26.358101F);
      ((Path)localObject).cubicTo(11.41F, 26.9856F, 9.61219F, 29.0194F, 9.61219F, 31.3195F);
      ((Path)localObject).cubicTo(9.61219F, 34.203701F, 12.3658F, 36.554001F, 15.8052F, 36.554001F);
      ((Path)localObject).cubicTo(19.244499F, 36.554001F, 21.9981F, 34.203701F, 21.9981F, 31.3195F);
      ((Path)localObject).lineTo(21.9981F, 16.942499F);
      ((Path)localObject).cubicTo(21.9981F, 11.8787F, 26.5243F, 7.80002F, 32.099098F, 7.80002F);
      ((Path)localObject).cubicTo(37.673901F, 7.80002F, 42.2001F, 11.8787F, 42.2001F, 16.942499F);
      ((Path)localObject).cubicTo(42.2001F, 21.4062F, 38.777802F, 25.1521F, 34.008598F, 25.981501F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.album_ad_link_tag_weapp_dark
 * JD-Core Version:    0.7.0.1
 */