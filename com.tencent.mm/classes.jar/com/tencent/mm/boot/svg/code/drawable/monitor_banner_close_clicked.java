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

public class monitor_banner_close_clicked
  extends c
{
  private final int height = 46;
  private final int width = 46;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 46;
      return 46;
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
      localCanvas.saveLayerAlpha(null, 64, 31);
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject3).setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -996.0F, 0.0F, 1.0F, -265.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject4 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -1.0F, 0.0F, 1.0F, 216.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localObject3 = c.setMatrixFloatArray((float[])localObject4, 0.7071068F, -0.7071068F, 350.08917F, 0.7071068F, 0.7071068F, -700.33722F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(1018.4283F, 70.428261F);
      ((Path)localObject1).lineTo(990.42639F, 70.428261F);
      ((Path)localObject1).lineTo(990.42639F, 74.424553F);
      ((Path)localObject1).lineTo(1018.4283F, 74.424553F);
      ((Path)localObject1).lineTo(1018.4283F, 102.42641F);
      ((Path)localObject1).lineTo(1022.4246F, 102.42641F);
      ((Path)localObject1).lineTo(1022.4246F, 74.424553F);
      ((Path)localObject1).lineTo(1050.4264F, 74.424553F);
      ((Path)localObject1).lineTo(1050.4264F, 70.428261F);
      ((Path)localObject1).lineTo(1022.4246F, 70.428261F);
      ((Path)localObject1).lineTo(1022.4246F, 42.426407F);
      ((Path)localObject1).lineTo(1018.4283F, 42.426407F);
      ((Path)localObject1).lineTo(1018.4283F, 70.428261F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.monitor_banner_close_clicked
 * JD-Core Version:    0.7.0.1
 */