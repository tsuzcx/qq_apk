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

public final class aqh
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      Object localObject = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-16777216);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(36.0F, 66.0F);
      localPath.cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      localPath.cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      localPath.cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      localPath.cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      localPath.close();
      localPath.moveTo(36.0F, 62.400002F);
      localPath.cubicTo(50.580318F, 62.400002F, 62.400002F, 50.580318F, 62.400002F, 36.0F);
      localPath.cubicTo(62.400002F, 21.419683F, 50.580318F, 9.6F, 36.0F, 9.6F);
      localPath.cubicTo(21.419683F, 9.6F, 9.6F, 21.419683F, 9.6F, 36.0F);
      localPath.cubicTo(9.6F, 50.580318F, 21.419683F, 62.400002F, 36.0F, 62.400002F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      arrayOfFloat = c.a(arrayOfFloat, 0.7071068F, -0.7071068F, 36.0F, 0.7071068F, 0.7071068F, -14.911686F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(37.799999F, 34.200001F);
      ((Path)localObject).lineTo(51.0F, 34.200001F);
      ((Path)localObject).lineTo(51.0F, 37.799999F);
      ((Path)localObject).lineTo(37.799999F, 37.799999F);
      ((Path)localObject).lineTo(37.799999F, 51.0F);
      ((Path)localObject).lineTo(34.200001F, 51.0F);
      ((Path)localObject).lineTo(34.200001F, 37.799999F);
      ((Path)localObject).lineTo(21.0F, 37.799999F);
      ((Path)localObject).lineTo(21.0F, 34.200001F);
      ((Path)localObject).lineTo(34.200001F, 34.200001F);
      ((Path)localObject).lineTo(34.200001F, 21.0F);
      ((Path)localObject).lineTo(37.799999F, 21.0F);
      ((Path)localObject).lineTo(37.799999F, 34.200001F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aqh
 * JD-Core Version:    0.7.0.1
 */