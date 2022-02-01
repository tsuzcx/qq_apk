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

public final class qg
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.j(paramVarArgs);
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
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      Object localObject2 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject2).setColor(-2565928);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(24.0F, 0.0F);
      localPath.lineTo(24.0F, 24.0F);
      localPath.lineTo(0.0F, 24.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath(localPath, c.a((Paint)localObject2, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 1.5F, 0.0F, 1.0F, 5.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setColor(855638016);
      localPaint2.setStrokeWidth(0.5F);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.25F, 7.0F);
      ((Path)localObject2).cubicTo(0.25F, 3.272078F, 3.272078F, 0.25F, 7.0F, 0.25F);
      ((Path)localObject2).lineTo(14.0F, 0.25F);
      ((Path)localObject2).cubicTo(17.727922F, 0.25F, 20.75F, 3.272078F, 20.75F, 7.0F);
      ((Path)localObject2).lineTo(20.75F, 7.0F);
      ((Path)localObject2).cubicTo(20.75F, 10.727922F, 17.727922F, 13.75F, 14.0F, 13.75F);
      ((Path)localObject2).lineTo(7.0F, 13.75F);
      ((Path)localObject2).cubicTo(3.272078F, 13.75F, 0.25F, 10.727922F, 0.25F, 7.0F);
      ((Path)localObject2).lineTo(0.25F, 7.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(855638016);
      arrayOfFloat = c.a(arrayOfFloat, 0.7071068F, -0.7071068F, 7.909189F, 0.7071068F, 0.7071068F, -5.209189F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(10.74264F, 3.942641F);
      ((Path)localObject1).lineTo(10.74264F, 6.441641F);
      ((Path)localObject1).lineTo(13.24264F, 6.442641F);
      ((Path)localObject1).lineTo(13.24264F, 7.442641F);
      ((Path)localObject1).lineTo(10.74264F, 7.441641F);
      ((Path)localObject1).lineTo(10.74264F, 9.94264F);
      ((Path)localObject1).lineTo(9.742641F, 9.94264F);
      ((Path)localObject1).lineTo(9.742641F, 7.441641F);
      ((Path)localObject1).lineTo(7.242641F, 7.442641F);
      ((Path)localObject1).lineTo(7.242641F, 6.442641F);
      ((Path)localObject1).lineTo(9.742641F, 6.441641F);
      ((Path)localObject1).lineTo(9.742641F, 3.942641F);
      ((Path)localObject1).lineTo(10.74264F, 3.942641F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.qg
 * JD-Core Version:    0.7.0.1
 */