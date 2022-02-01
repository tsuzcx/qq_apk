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

public class icons_outlined_font
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(34.450928F, 52.877197F);
      ((Path)localObject).lineTo(30.946289F, 42.89502F);
      ((Path)localObject).lineTo(17.072754F, 42.89502F);
      ((Path)localObject).lineTo(13.568115F, 52.877197F);
      ((Path)localObject).lineTo(9.0F, 52.877197F);
      ((Path)localObject).lineTo(21.858398F, 18.0F);
      ((Path)localObject).lineTo(26.160645F, 18.0F);
      ((Path)localObject).lineTo(39.019043F, 52.877197F);
      ((Path)localObject).lineTo(34.450928F, 52.877197F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(23.937012F, 23.293213F);
      ((Path)localObject).lineTo(18.35376F, 39.197021F);
      ((Path)localObject).lineTo(29.665283F, 39.197021F);
      ((Path)localObject).lineTo(24.082031F, 23.293213F);
      ((Path)localObject).lineTo(23.937012F, 23.293213F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(50.983154F, 49.469238F);
      ((Path)localObject).cubicTo(55.237061F, 49.469238F, 58.35498F, 46.713867F, 58.35498F, 42.967529F);
      ((Path)localObject).lineTo(58.35498F, 40.864746F);
      ((Path)localObject).lineTo(51.539063F, 41.299805F);
      ((Path)localObject).cubicTo(47.623535F, 41.541504F, 45.593262F, 42.967529F, 45.593262F, 45.481201F);
      ((Path)localObject).cubicTo(45.593262F, 47.898193F, 47.696045F, 49.469238F, 50.983154F, 49.469238F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(50.088867F, 53.118896F);
      ((Path)localObject).cubicTo(44.795654F, 53.118896F, 41.291016F, 50.073486F, 41.291016F, 45.457031F);
      ((Path)localObject).cubicTo(41.291016F, 40.985596F, 44.723145F, 38.351074F, 51.055664F, 37.964355F);
      ((Path)localObject).lineTo(58.35498F, 37.529297F);
      ((Path)localObject).lineTo(58.35498F, 35.354004F);
      ((Path)localObject).cubicTo(58.35498F, 32.115234F, 56.228027F, 30.32666F, 52.38501F, 30.32666F);
      ((Path)localObject).cubicTo(49.36377F, 30.32666F, 47.115967F, 31.873535F, 46.608398F, 34.338867F);
      ((Path)localObject).lineTo(42.572021F, 34.338867F);
      ((Path)localObject).cubicTo(42.692871F, 29.939941F, 46.970947F, 26.580322F, 52.43335F, 26.580322F);
      ((Path)localObject).cubicTo(58.59668F, 26.580322F, 62.560547F, 29.867432F, 62.560547F, 34.991455F);
      ((Path)localObject).lineTo(62.560547F, 52.877197F);
      ((Path)localObject).lineTo(58.57251F, 52.877197F);
      ((Path)localObject).lineTo(58.57251F, 48.357422F);
      ((Path)localObject).lineTo(58.47583F, 48.357422F);
      ((Path)localObject).cubicTo(57.001465F, 51.257813F, 53.738525F, 53.118896F, 50.088867F, 53.118896F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_font
 * JD-Core Version:    0.7.0.1
 */