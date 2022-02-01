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

public class emoji_pop_bg_smiley_dark
  extends c
{
  private final int height = 405;
  private final int width = 192;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 405;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
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
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1.setColor(-13882324);
      localPaint2.setColor(234881023);
      localPaint2.setStrokeWidth(1.5F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(155.25F, 272.53323F);
      localPath.cubicTo(155.25F, 262.90875F, 158.09885F, 253.49963F, 163.43755F, 245.49159F);
      localPath.lineTo(183.31438F, 215.67636F);
      localPath.cubicTo(188.4888F, 207.91472F, 191.25F, 198.7951F, 191.25F, 189.46677F);
      localPath.lineTo(191.25F, 48.0F);
      localPath.cubicTo(191.25F, 21.904545F, 170.09546F, 0.75F, 144.0F, 0.75F);
      localPath.lineTo(48.0F, 0.75F);
      localPath.cubicTo(21.904545F, 0.75F, 0.75F, 21.904545F, 0.75F, 48.0F);
      localPath.lineTo(0.75F, 189.46677F);
      localPath.cubicTo(0.75F, 198.7951F, 3.511197F, 207.91472F, 8.685623F, 215.67636F);
      localPath.lineTo(28.562452F, 245.49159F);
      localPath.cubicTo(33.901146F, 253.49963F, 36.75F, 262.90875F, 36.75F, 272.53323F);
      localPath.lineTo(36.75F, 381.0F);
      localPath.cubicTo(36.75F, 393.84061F, 47.159378F, 404.25F, 60.0F, 404.25F);
      localPath.lineTo(132.0F, 404.25F);
      localPath.cubicTo(144.84062F, 404.25F, 155.25F, 393.84061F, 155.25F, 381.0F);
      localPath.lineTo(155.25F, 272.53323F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.emoji_pop_bg_smiley_dark
 * JD-Core Version:    0.7.0.1
 */