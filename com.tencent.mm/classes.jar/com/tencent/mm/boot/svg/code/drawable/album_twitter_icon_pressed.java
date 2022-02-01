package com.tencent.mm.boot.svg.code.drawable;

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

public class album_twitter_icon_pressed
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-14835214);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(15.75F, 0.0F);
      ((Path)localObject2).cubicTo(16.992001F, 0.0F, 18.0F, 1.008F, 18.0F, 2.25F);
      ((Path)localObject2).lineTo(18.0F, 15.75F);
      ((Path)localObject2).cubicTo(18.0F, 16.992001F, 16.992001F, 18.0F, 15.75F, 18.0F);
      ((Path)localObject2).lineTo(2.25F, 18.0F);
      ((Path)localObject2).cubicTo(1.008F, 18.0F, 0.0F, 16.992001F, 0.0F, 15.75F);
      ((Path)localObject2).lineTo(0.0F, 2.25F);
      ((Path)localObject2).cubicTo(0.0F, 1.008F, 1.008F, 0.0F, 2.25F, 0.0F);
      ((Path)localObject2).lineTo(15.75F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(11.1645F, 4.428F);
      ((Path)localObject2).cubicTo(9.891F, 4.428F, 8.856F, 5.463F, 8.856F, 6.7365F);
      ((Path)localObject2).cubicTo(8.856F, 6.9165F, 8.8785F, 7.092F, 8.9145F, 7.263F);
      ((Path)localObject2).cubicTo(6.9975F, 7.1685F, 5.2965F, 6.246F, 4.158F, 4.851F);
      ((Path)localObject2).cubicTo(3.96F, 5.193F, 3.8475F, 5.589F, 3.8475F, 6.012F);
      ((Path)localObject2).cubicTo(3.8475F, 6.813F, 4.257F, 7.5195F, 4.8735F, 7.9335F);
      ((Path)localObject2).cubicTo(4.4955F, 7.92F, 4.14F, 7.8165F, 3.8295F, 7.6455F);
      ((Path)localObject2).lineTo(3.8295F, 7.677F);
      ((Path)localObject2).lineTo(3.8295F, 7.677F);
      ((Path)localObject2).cubicTo(3.8295F, 8.793F, 4.626F, 9.729F, 5.679F, 9.9405F);
      ((Path)localObject2).cubicTo(5.4855F, 9.9945F, 5.283F, 10.0215F, 5.0715F, 10.0215F);
      ((Path)localObject2).cubicTo(4.923F, 10.0215F, 4.779F, 10.008F, 4.6395F, 9.981F);
      ((Path)localObject2).cubicTo(4.932F, 10.899F, 5.787F, 11.565F, 6.795F, 11.583F);
      ((Path)localObject2).cubicTo(6.003F, 12.204F, 5.0085F, 12.573F, 3.9285F, 12.573F);
      ((Path)localObject2).cubicTo(3.744F, 12.573F, 3.5595F, 12.564F, 3.3795F, 12.5415F);
      ((Path)localObject2).cubicTo(4.3965F, 13.1895F, 5.6115F, 13.572F, 6.912F, 13.572F);
      ((Path)localObject2).cubicTo(11.1555F, 13.572F, 13.4775F, 10.053F, 13.4775F, 7.0065F);
      ((Path)localObject2).cubicTo(13.4775F, 6.9075F, 13.4775F, 6.8085F, 13.473F, 6.7095F);
      ((Path)localObject2).cubicTo(13.923F, 6.3855F, 14.3145F, 5.976F, 14.625F, 5.5125F);
      ((Path)localObject2).cubicTo(14.211F, 5.697F, 13.7655F, 5.8185F, 13.2975F, 5.877F);
      ((Path)localObject2).cubicTo(13.7745F, 5.5935F, 14.139F, 5.139F, 14.3145F, 4.599F);
      ((Path)localObject2).cubicTo(13.869F, 4.8645F, 13.374F, 5.0535F, 12.8475F, 5.157F);
      ((Path)localObject2).cubicTo(12.4245F, 4.707F, 11.826F, 4.428F, 11.1645F, 4.428F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.album_twitter_icon_pressed
 * JD-Core Version:    0.7.0.1
 */