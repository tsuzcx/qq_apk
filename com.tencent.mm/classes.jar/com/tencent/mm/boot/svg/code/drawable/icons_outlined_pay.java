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

public class icons_outlined_pay
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 12.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(3.600037F, 33.0F);
      ((Path)localObject2).lineTo(3.600037F, 44.400009F);
      ((Path)localObject2).lineTo(15.0F, 44.400009F);
      ((Path)localObject2).lineTo(15.0F, 48.0F);
      ((Path)localObject2).lineTo(3.0F, 48.0F);
      ((Path)localObject2).cubicTo(1.343146F, 48.0F, -2.029061E-016F, 46.656853F, 0.0F, 45.0F);
      ((Path)localObject2).lineTo(0.0F, 45.0F);
      ((Path)localObject2).lineTo(0.0F, 33.0F);
      ((Path)localObject2).lineTo(3.600037F, 33.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(60.0F, 33.0F);
      ((Path)localObject2).lineTo(60.0F, 45.0F);
      ((Path)localObject2).cubicTo(60.0F, 46.656853F, 58.656853F, 48.0F, 57.0F, 48.0F);
      ((Path)localObject2).lineTo(45.0F, 48.0F);
      ((Path)localObject2).lineTo(45.0F, 44.400009F);
      ((Path)localObject2).lineTo(56.399963F, 44.400009F);
      ((Path)localObject2).lineTo(56.399963F, 33.0F);
      ((Path)localObject2).lineTo(60.0F, 33.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(43.910259F, 14.25F);
      ((Path)localObject2).lineTo(46.455845F, 16.795584F);
      ((Path)localObject2).lineTo(28.606602F, 34.644829F);
      ((Path)localObject2).cubicTo(27.43503F, 35.816399F, 25.535534F, 35.816399F, 24.363962F, 34.644829F);
      ((Path)localObject2).lineTo(15.0F, 25.280865F);
      ((Path)localObject2).lineTo(17.545584F, 22.735281F);
      ((Path)localObject2).lineTo(26.485281F, 31.674978F);
      ((Path)localObject2).lineTo(43.910259F, 14.25F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(15.0F, 0.0F);
      ((Path)localObject2).lineTo(15.0F, 3.599991F);
      ((Path)localObject2).lineTo(3.600037F, 3.599991F);
      ((Path)localObject2).lineTo(3.600037F, 15.0F);
      ((Path)localObject2).lineTo(0.0F, 15.0F);
      ((Path)localObject2).lineTo(0.0F, 3.0F);
      ((Path)localObject2).cubicTo(-2.029061E-016F, 1.343146F, 1.343146F, 3.043592E-016F, 3.0F, 0.0F);
      ((Path)localObject2).lineTo(15.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(57.0F, 0.0F);
      ((Path)localObject2).cubicTo(58.656853F, 3.043592E-016F, 60.0F, 1.343146F, 60.0F, 3.0F);
      ((Path)localObject2).lineTo(60.0F, 3.0F);
      ((Path)localObject2).lineTo(60.0F, 15.0F);
      ((Path)localObject2).lineTo(56.399963F, 15.0F);
      ((Path)localObject2).lineTo(56.399963F, 3.599991F);
      ((Path)localObject2).lineTo(45.0F, 3.599991F);
      ((Path)localObject2).lineTo(45.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_pay
 * JD-Core Version:    0.7.0.1
 */