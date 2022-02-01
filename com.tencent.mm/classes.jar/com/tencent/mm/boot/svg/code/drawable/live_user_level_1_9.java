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

public class live_user_level_1_9
  extends c
{
  private final int height = 24;
  private final int width = 16;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 24;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 10.828426F, 0.7071068F, 0.7071068F, -2.142135F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(8.0F, 14.4F);
      ((Path)localObject).lineTo(4.687624F, 15.838614F);
      ((Path)localObject).cubicTo(4.484995F, 15.926618F, 4.249391F, 15.833697F, 4.161387F, 15.631068F);
      ((Path)localObject).cubicTo(4.117241F, 15.529425F, 4.117241F, 15.414021F, 4.161387F, 15.312377F);
      ((Path)localObject).lineTo(5.6F, 12.0F);
      ((Path)localObject).lineTo(5.6F, 12.0F);
      ((Path)localObject).lineTo(4.161387F, 8.687623F);
      ((Path)localObject).cubicTo(4.073382F, 8.484995F, 4.166303F, 8.249391F, 4.368931F, 8.161387F);
      ((Path)localObject).cubicTo(4.470576F, 8.117241F, 4.585979F, 8.117241F, 4.687624F, 8.161387F);
      ((Path)localObject).lineTo(8.0F, 9.6F);
      ((Path)localObject).lineTo(8.0F, 9.6F);
      ((Path)localObject).lineTo(11.312377F, 8.161387F);
      ((Path)localObject).cubicTo(11.515005F, 8.073382F, 11.750609F, 8.166303F, 11.838614F, 8.368932F);
      ((Path)localObject).cubicTo(11.882759F, 8.470575F, 11.882759F, 8.58598F, 11.838614F, 8.687623F);
      ((Path)localObject).lineTo(10.4F, 12.0F);
      ((Path)localObject).lineTo(10.4F, 12.0F);
      ((Path)localObject).lineTo(11.838614F, 15.312377F);
      ((Path)localObject).cubicTo(11.926618F, 15.515005F, 11.833697F, 15.750609F, 11.631068F, 15.838614F);
      ((Path)localObject).cubicTo(11.529425F, 15.882759F, 11.414021F, 15.882759F, 11.312377F, 15.838614F);
      ((Path)localObject).lineTo(8.0F, 14.4F);
      ((Path)localObject).lineTo(8.0F, 14.4F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint2);
      localCanvas.restore();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-2565928);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(16.0F, 0.0F);
      ((Path)localObject).lineTo(16.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath((Path)localObject, c.instancePaint(localPaint1, paramVarArgs));
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.live_user_level_1_9
 * JD-Core Version:    0.7.0.1
 */