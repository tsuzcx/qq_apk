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

public class icons_outlined_quote_link
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1.setColor(-16777216);
      localPaint2.setColor(-16777216);
      localPaint2.setStrokeWidth(1.5F);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(54.401455F, 36.016678F);
      localPath.lineTo(51.643738F, 33.258965F);
      localPath.lineTo(58.538029F, 26.364672F);
      localPath.cubicTo(62.091801F, 22.810902F, 62.091801F, 17.049099F, 58.538029F, 13.495328F);
      localPath.cubicTo(54.984261F, 9.941557F, 49.222458F, 9.941557F, 45.668686F, 13.495328F);
      localPath.lineTo(33.029152F, 26.134863F);
      localPath.cubicTo(29.475382F, 29.688633F, 29.475382F, 35.450436F, 33.029152F, 39.004204F);
      localPath.lineTo(30.271437F, 41.761921F);
      localPath.cubicTo(25.19462F, 36.685104F, 25.19462F, 28.453962F, 30.271437F, 23.377146F);
      localPath.lineTo(42.910969F, 10.737612F);
      localPath.cubicTo(47.987785F, 5.660796F, 56.218929F, 5.660796F, 61.295746F, 10.737612F);
      localPath.cubicTo(66.372566F, 15.814427F, 66.372566F, 24.045572F, 61.295746F, 29.122389F);
      localPath.lineTo(54.401455F, 36.016678F);
      localPath.close();
      localPath.moveTo(17.631903F, 36.016678F);
      localPath.lineTo(20.38962F, 38.774395F);
      localPath.lineTo(13.495328F, 45.668686F);
      localPath.cubicTo(9.941557F, 49.222458F, 9.941557F, 54.984261F, 13.495328F, 58.538029F);
      localPath.cubicTo(17.049099F, 62.091801F, 22.810902F, 62.091801F, 26.364672F, 58.538029F);
      localPath.lineTo(39.004204F, 45.898495F);
      localPath.cubicTo(42.557976F, 42.344727F, 42.557976F, 36.582924F, 39.004204F, 33.029152F);
      localPath.lineTo(41.761921F, 30.271437F);
      localPath.cubicTo(46.838737F, 35.348251F, 46.838737F, 43.579395F, 41.761921F, 48.656212F);
      localPath.lineTo(29.122389F, 61.295746F);
      localPath.cubicTo(24.045572F, 66.372566F, 15.814427F, 66.372566F, 10.737612F, 61.295746F);
      localPath.cubicTo(5.660796F, 56.218929F, 5.660796F, 47.987785F, 10.737612F, 42.910969F);
      localPath.lineTo(17.631903F, 36.016678F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_quote_link
 * JD-Core Version:    0.7.0.1
 */