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

public final class avi
  extends c
{
  private final int height = 90;
  private final int width = 90;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 90;
      return 90;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.k(paramVarArgs);
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
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(26.0F, 1.0F);
      ((Path)localObject2).cubicTo(41.749996F, -2.702014F, 58.451546F, 6.530448F, 64.0F, 21.0F);
      ((Path)localObject2).cubicTo(69.309052F, 34.878006F, 64.155495F, 51.762508F, 52.0F, 60.0F);
      ((Path)localObject2).cubicTo(39.778633F, 68.937088F, 21.556034F, 67.746773F, 11.0F, 57.0F);
      ((Path)localObject2).cubicTo(-0.2490444F, 47.641407F, -3.211093F, 30.486835F, 4.0F, 18.0F);
      ((Path)localObject2).cubicTo(8.276852F, 9.021112F, 16.842775F, 2.579394F, 26.0F, 1.0F);
      ((Path)localObject2).lineTo(26.0F, 1.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(27.0F, 4.0F);
      ((Path)localObject2).cubicTo(12.109385F, 6.789598F, 1.303282F, 21.511627F, 3.0F, 36.0F);
      ((Path)localObject2).cubicTo(4.50916F, 51.644379F, 19.529842F, 64.360222F, 35.0F, 63.0F);
      ((Path)localObject2).cubicTo(51.368896F, 62.174374F, 64.971405F, 46.114883F, 63.0F, 30.0F);
      ((Path)localObject2).cubicTo(61.405987F, 12.758258F, 43.229362F, -0.4765971F, 27.0F, 4.0F);
      ((Path)localObject2).lineTo(27.0F, 4.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(19.0F, 19.0F);
      ((Path)localObject2).cubicTo(22.44149F, 17.715698F, 26.871679F, 21.241371F, 26.0F, 25.0F);
      ((Path)localObject2).cubicTo(25.251135F, 28.607508F, 20.484209F, 30.265413F, 18.0F, 28.0F);
      ((Path)localObject2).cubicTo(14.928059F, 25.732405F, 15.633101F, 20.811155F, 19.0F, 19.0F);
      ((Path)localObject2).lineTo(19.0F, 19.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(45.0F, 19.0F);
      ((Path)localObject2).cubicTo(48.144283F, 18.203859F, 51.808788F, 21.377556F, 51.0F, 24.0F);
      ((Path)localObject2).cubicTo(50.233788F, 27.98074F, 44.679279F, 29.259693F, 42.0F, 27.0F);
      ((Path)localObject2).cubicTo(39.723274F, 24.219673F, 41.235275F, 19.795444F, 45.0F, 19.0F);
      ((Path)localObject2).lineTo(45.0F, 19.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(15.0F, 36.0F);
      ((Path)localObject1).cubicTo(27.003326F, 35.994991F, 38.996674F, 35.994991F, 51.0F, 36.0F);
      ((Path)localObject1).cubicTo(50.890244F, 43.420006F, 46.080933F, 50.524376F, 39.0F, 53.0F);
      ((Path)localObject1).cubicTo(31.752771F, 55.694836F, 22.902439F, 52.91922F, 18.0F, 46.0F);
      ((Path)localObject1).cubicTo(16.207317F, 43.470108F, 15.219512F, 39.732548F, 15.0F, 36.0F);
      ((Path)localObject1).lineTo(15.0F, 36.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.avi
 * JD-Core Version:    0.7.0.1
 */