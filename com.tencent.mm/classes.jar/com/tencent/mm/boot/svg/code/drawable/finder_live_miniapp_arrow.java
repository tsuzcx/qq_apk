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

public class finder_live_miniapp_arrow
  extends c
{
  private final int height = 20;
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
      return 20;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Object localObject4 = c.instancePaint(paramVarArgs);
      ((Paint)localObject4).setFlags(385);
      ((Paint)localObject4).setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(1.0F);
      ((Paint)localObject4).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject4).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject4).setStrokeMiter(4.0F);
      ((Paint)localObject4).setPathEffect(null);
      c.instancePaint((Paint)localObject4, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject4 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject4).setColor(-526345);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 10.0F);
      localPath.cubicTo(0.0F, 4.477152F, 4.477152F, 0.0F, 10.0F, 0.0F);
      localPath.lineTo(30.0F, 0.0F);
      localPath.cubicTo(35.522846F, 0.0F, 40.0F, 4.477152F, 40.0F, 10.0F);
      localPath.lineTo(40.0F, 10.0F);
      localPath.cubicTo(40.0F, 15.522848F, 35.522846F, 20.0F, 30.0F, 20.0F);
      localPath.lineTo(10.0F, 20.0F);
      localPath.cubicTo(4.477152F, 20.0F, 0.0F, 15.522848F, 0.0F, 10.0F);
      localPath.lineTo(0.0F, 10.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject3).setColor(1275068416);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 6.123234E-017F, -1.0F, 15.0F, 1.0F, 6.123234E-017F, 5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject4 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -1.553301F, 0.0F, 1.0F, 4.7F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localObject3 = c.setMatrixFloatArray((float[])localObject4, -0.7071068F, -0.7071068F, 12.803301F, 0.7071068F, -0.7071068F, 5.303301F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(2.386634F, 1.553301F);
      ((Path)localObject1).lineTo(9.053301F, 1.553301F);
      ((Path)localObject1).lineTo(9.053301F, 1.553301F);
      ((Path)localObject1).lineTo(9.053301F, 3.219968F);
      ((Path)localObject1).lineTo(3.219968F, 3.219968F);
      ((Path)localObject1).lineTo(3.219968F, 9.053301F);
      ((Path)localObject1).lineTo(1.553301F, 9.053301F);
      ((Path)localObject1).lineTo(1.553301F, 2.386634F);
      ((Path)localObject1).cubicTo(1.553301F, 1.926397F, 1.926397F, 1.553301F, 2.386634F, 1.553301F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_live_miniapp_arrow
 * JD-Core Version:    0.7.0.1
 */