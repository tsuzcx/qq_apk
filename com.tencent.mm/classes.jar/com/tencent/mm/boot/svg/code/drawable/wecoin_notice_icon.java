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

public class wecoin_notice_icon
  extends c
{
  private final int height = 18;
  private final int width = 21;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 21;
      return 18;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-15658735);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -1574.0F, 0.0F, 1.0F, -6077.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 191.0F, 0.0F, 1.0F, 5493.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 87.0F, 0.0F, 1.0F, 40.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 1294.0F, 0.0F, 1.0F, 541.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(15.333333F, 3.536165F);
      ((Path)localObject2).cubicTo(15.701523F, 3.536165F, 16.0F, 3.834642F, 16.0F, 4.202832F);
      ((Path)localObject2).lineTo(16.0F, 4.202832F);
      ((Path)localObject2).lineTo(16.0F, 19.797169F);
      ((Path)localObject2).cubicTo(16.0F, 19.922115F, 15.964887F, 20.044546F, 15.898665F, 20.150501F);
      ((Path)localObject2).cubicTo(15.703526F, 20.462725F, 15.292225F, 20.55764F, 14.98F, 20.362501F);
      ((Path)localObject2).lineTo(14.98F, 20.362501F);
      ((Path)localObject2).lineTo(8.0F, 16.0F);
      ((Path)localObject2).lineTo(6.0F, 16.0F);
      ((Path)localObject2).cubicTo(3.790861F, 16.0F, 2.0F, 14.209139F, 2.0F, 12.0F);
      ((Path)localObject2).cubicTo(2.0F, 9.790861F, 3.790861F, 8.0F, 6.0F, 8.0F);
      ((Path)localObject2).lineTo(6.0F, 8.0F);
      ((Path)localObject2).lineTo(8.0F, 8.0F);
      ((Path)localObject2).lineTo(14.98F, 3.6375F);
      ((Path)localObject2).cubicTo(15.085955F, 3.571278F, 15.208387F, 3.536165F, 15.333333F, 3.536165F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(18.442959F, 15.105398F);
      ((Path)localObject2).lineTo(22.446865F, 17.105398F);
      ((Path)localObject2).lineTo(21.553135F, 18.894602F);
      ((Path)localObject2).lineTo(17.549229F, 16.894602F);
      ((Path)localObject2).lineTo(18.442959F, 15.105398F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(22.0F, 11.0F);
      ((Path)localObject2).lineTo(22.0F, 13.0F);
      ((Path)localObject2).lineTo(17.996094F, 13.0F);
      ((Path)localObject2).lineTo(17.996094F, 11.0F);
      ((Path)localObject2).lineTo(22.0F, 11.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(21.553135F, 5.105398F);
      ((Path)localObject2).lineTo(22.446865F, 6.894602F);
      ((Path)localObject2).lineTo(18.442959F, 8.894602F);
      ((Path)localObject2).lineTo(17.549229F, 7.105398F);
      ((Path)localObject2).lineTo(21.553135F, 5.105398F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.wecoin_notice_icon
 * JD-Core Version:    0.7.0.1
 */