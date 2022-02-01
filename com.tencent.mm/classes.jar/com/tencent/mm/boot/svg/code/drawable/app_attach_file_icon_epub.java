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

public class app_attach_file_icon_epub
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
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-9061376);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(16.235294F, 0.0F);
      ((Path)localObject2).lineTo(24.0F, 7.822222F);
      ((Path)localObject2).lineTo(24.0F, 30.933332F);
      ((Path)localObject2).cubicTo(24.0F, 31.522436F, 23.525948F, 32.0F, 22.941177F, 32.0F);
      ((Path)localObject2).lineTo(1.058824F, 32.0F);
      ((Path)localObject2).cubicTo(0.4740515F, 32.0F, 0.0F, 31.522436F, 0.0F, 30.933332F);
      ((Path)localObject2).lineTo(0.0F, 1.066667F);
      ((Path)localObject2).cubicTo(0.0F, 0.4775629F, 0.4740515F, 0.0F, 1.058824F, 0.0F);
      ((Path)localObject2).lineTo(16.235294F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-10643968);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 7.822222F);
      ((Path)localObject2).lineTo(17.294117F, 7.822222F);
      ((Path)localObject2).cubicTo(16.709345F, 7.822222F, 16.235294F, 7.344659F, 16.235294F, 6.755556F);
      ((Path)localObject2).lineTo(16.235294F, 0.0F);
      ((Path)localObject2).lineTo(24.0F, 7.822222F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(15.695135F, 17.344269F);
      ((Path)localObject1).lineTo(13.017647F, 14.646948F);
      ((Path)localObject1).cubicTo(12.455247F, 14.080381F, 11.541663F, 14.080491F, 10.978115F, 14.648213F);
      ((Path)localObject1).lineTo(6.776093F, 18.881361F);
      ((Path)localObject1).cubicTo(6.212218F, 19.449413F, 6.211982F, 20.368979F, 6.774837F, 20.936001F);
      ((Path)localObject1).lineTo(10.982353F, 25.174685F);
      ((Path)localObject1).cubicTo(11.544753F, 25.741251F, 12.458337F, 25.741142F, 13.021885F, 25.17342F);
      ((Path)localObject1).lineTo(17.223907F, 20.940271F);
      ((Path)localObject1).cubicTo(17.787781F, 20.372219F, 17.788017F, 19.452656F, 17.225164F, 18.885632F);
      ((Path)localObject1).lineTo(17.097252F, 18.756773F);
      ((Path)localObject1).lineTo(12.001217F, 23.890554F);
      ((Path)localObject1).lineTo(11.300159F, 23.184303F);
      ((Path)localObject1).lineTo(8.750855F, 20.616117F);
      ((Path)localObject1).lineTo(8.049798F, 19.909866F);
      ((Path)localObject1).lineTo(11.999331F, 15.931077F);
      ((Path)localObject1).lineTo(13.401447F, 17.34358F);
      ((Path)localObject1).lineTo(10.853361F, 19.91054F);
      ((Path)localObject1).lineTo(12.000547F, 21.066225F);
      ((Path)localObject1).lineTo(15.695135F, 17.344269F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_epub
 * JD-Core Version:    0.7.0.1
 */