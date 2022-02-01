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

public class actionbar_icon_light_search
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(51.487274F, 48.305294F);
      ((Path)localObject).lineTo(62.849243F, 59.667263F);
      ((Path)localObject).lineTo(59.667263F, 62.849243F);
      ((Path)localObject).lineTo(48.305294F, 51.487274F);
      ((Path)localObject).cubicTo(44.151031F, 54.930374F, 38.817215F, 57.0F, 33.0F, 57.0F);
      ((Path)localObject).cubicTo(19.745142F, 57.0F, 9.0F, 46.254856F, 9.0F, 33.0F);
      ((Path)localObject).cubicTo(9.0F, 19.745142F, 19.745142F, 9.0F, 33.0F, 9.0F);
      ((Path)localObject).cubicTo(46.254856F, 9.0F, 57.0F, 19.745142F, 57.0F, 33.0F);
      ((Path)localObject).cubicTo(57.0F, 38.817215F, 54.930374F, 44.151031F, 51.487274F, 48.305294F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(52.542278F, 33.006664F);
      ((Path)localObject).cubicTo(52.542278F, 22.237095F, 43.811852F, 13.506665F, 33.042278F, 13.506665F);
      ((Path)localObject).cubicTo(22.272707F, 13.506665F, 13.542279F, 22.237095F, 13.542279F, 33.006664F);
      ((Path)localObject).cubicTo(13.542279F, 43.776237F, 22.272707F, 52.506664F, 33.042278F, 52.506664F);
      ((Path)localObject).cubicTo(43.811852F, 52.506664F, 52.542278F, 43.776237F, 52.542278F, 33.006664F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.actionbar_icon_light_search
 * JD-Core Version:    0.7.0.1
 */