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

public class icons_filled_music2
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
      localPaint.setColor(-436207616);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(11.5F, 4.276247F);
      ((Path)localObject).cubicTo(11.5F, 4.1579F, 11.582233F, 4.05876F, 11.692677F, 4.03285F);
      ((Path)localObject).lineTo(11.762453F, 4.026557F);
      ((Path)localObject).lineTo(11.762453F, 4.026557F);
      ((Path)localObject).lineTo(16.274876F, 4.477488F);
      ((Path)localObject).cubicTo(16.402676F, 4.490268F, 16.5F, 4.597809F, 16.5F, 4.726247F);
      ((Path)localObject).lineTo(16.5F, 7.223753F);
      ((Path)localObject).cubicTo(16.5F, 7.3421F, 16.417767F, 7.44124F, 16.307323F, 7.46715F);
      ((Path)localObject).lineTo(16.237547F, 7.473443F);
      ((Path)localObject).lineTo(16.237547F, 7.473443F);
      ((Path)localObject).lineTo(13.5F, 7.199247F);
      ((Path)localObject).lineTo(13.5F, 17.0F);
      ((Path)localObject).cubicTo(13.5F, 18.597681F, 12.25108F, 19.903662F, 10.676272F, 19.994907F);
      ((Path)localObject).lineTo(10.5F, 20.0F);
      ((Path)localObject).cubicTo(8.843145F, 20.0F, 7.5F, 18.656855F, 7.5F, 17.0F);
      ((Path)localObject).cubicTo(7.5F, 15.343145F, 8.843145F, 14.0F, 10.5F, 14.0F);
      ((Path)localObject).cubicTo(10.850972F, 14.0F, 11.187867F, 14.060269F, 11.5009F, 14.171024F);
      ((Path)localObject).lineTo(11.5F, 4.276247F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_music2
 * JD-Core Version:    0.7.0.1
 */