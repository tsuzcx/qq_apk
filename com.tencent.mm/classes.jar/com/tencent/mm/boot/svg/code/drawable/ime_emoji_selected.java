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

public class ime_emoji_selected
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
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
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -556.0F, 0.0F, 1.0F, -982.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 556.0F, 0.0F, 1.0F, 982.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePaint(localPaint2, paramVarArgs);
      ((Paint)localObject1).setColor(-12799119);
      ((Paint)localObject2).setColor(-12799119);
      ((Paint)localObject2).setStrokeWidth(2.0F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(20.0F, 1.0F);
      localPath.cubicTo(30.493412F, 1.0F, 39.0F, 9.506589F, 39.0F, 20.0F);
      localPath.cubicTo(39.0F, 30.493412F, 30.493412F, 39.0F, 20.0F, 39.0F);
      localPath.cubicTo(9.506589F, 39.0F, 1.0F, 30.493412F, 1.0F, 20.0F);
      localPath.cubicTo(1.0F, 9.506589F, 9.506589F, 1.0F, 20.0F, 1.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject1);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(13.0F, 13.0F);
      ((Path)localObject2).cubicTo(13.0F, 12.447715F, 13.447715F, 12.0F, 14.0F, 12.0F);
      ((Path)localObject2).lineTo(15.0F, 12.0F);
      ((Path)localObject2).cubicTo(15.552285F, 12.0F, 16.0F, 12.447715F, 16.0F, 13.0F);
      ((Path)localObject2).lineTo(16.0F, 18.0F);
      ((Path)localObject2).cubicTo(16.0F, 18.552284F, 15.552285F, 19.0F, 15.0F, 19.0F);
      ((Path)localObject2).lineTo(14.0F, 19.0F);
      ((Path)localObject2).cubicTo(13.447715F, 19.0F, 13.0F, 18.552284F, 13.0F, 18.0F);
      ((Path)localObject2).lineTo(13.0F, 13.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 13.0F);
      ((Path)localObject2).cubicTo(24.0F, 12.447715F, 24.447716F, 12.0F, 25.0F, 12.0F);
      ((Path)localObject2).lineTo(26.0F, 12.0F);
      ((Path)localObject2).cubicTo(26.552284F, 12.0F, 27.0F, 12.447715F, 27.0F, 13.0F);
      ((Path)localObject2).lineTo(27.0F, 18.0F);
      ((Path)localObject2).cubicTo(27.0F, 18.552284F, 26.552284F, 19.0F, 26.0F, 19.0F);
      ((Path)localObject2).lineTo(25.0F, 19.0F);
      ((Path)localObject2).cubicTo(24.447716F, 19.0F, 24.0F, 18.552284F, 24.0F, 18.0F);
      ((Path)localObject2).lineTo(24.0F, 13.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1.setColor(-1);
      localPaint2.setColor(-1);
      localPaint2.setStrokeWidth(2.0F);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(28.0F, 23.0F);
      ((Path)localObject1).lineTo(28.0F, 24.0F);
      ((Path)localObject1).cubicTo(28.0F, 25.656855F, 27.328426F, 27.156855F, 26.242641F, 28.242641F);
      ((Path)localObject1).cubicTo(25.156855F, 29.328426F, 23.656855F, 30.0F, 22.0F, 30.0F);
      ((Path)localObject1).lineTo(22.0F, 30.0F);
      ((Path)localObject1).lineTo(18.0F, 30.0F);
      ((Path)localObject1).cubicTo(16.343145F, 30.0F, 14.843145F, 29.328426F, 13.75736F, 28.242641F);
      ((Path)localObject1).cubicTo(12.671573F, 27.156855F, 12.0F, 25.656855F, 12.0F, 24.0F);
      ((Path)localObject1).lineTo(12.0F, 24.0F);
      ((Path)localObject1).lineTo(12.0F, 23.0F);
      ((Path)localObject1).lineTo(28.0F, 23.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.drawPath((Path)localObject1, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_emoji_selected
 * JD-Core Version:    0.7.0.1
 */