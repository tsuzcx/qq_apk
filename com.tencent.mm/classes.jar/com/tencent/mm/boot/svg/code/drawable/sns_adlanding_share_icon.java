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

public class sns_adlanding_share_icon
  extends c
{
  private final int height = 16;
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
      return 16;
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -127.0F, 0.0F, 1.0F, -613.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 134.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 103.0F, 0.0F, 1.0F, 477.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(16.0F, 0.0F);
      ((Path)localObject).lineTo(16.0F, 16.0F);
      ((Path)localObject).lineTo(0.0F, 16.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-11048043);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(5.2F, 4.0F);
      ((Path)localObject).lineTo(5.2F, 4.96F);
      ((Path)localObject).lineTo(2.96F, 4.96F);
      ((Path)localObject).lineTo(2.96F, 15.04F);
      ((Path)localObject).lineTo(13.84F, 15.04F);
      ((Path)localObject).lineTo(13.84F, 4.96F);
      ((Path)localObject).lineTo(11.6F, 4.96F);
      ((Path)localObject).lineTo(11.6F, 4.0F);
      ((Path)localObject).lineTo(14.000834F, 4.0F);
      ((Path)localObject).cubicTo(14.440696F, 4.0F, 14.8F, 4.356671F, 14.8F, 4.796647F);
      ((Path)localObject).lineTo(14.8F, 15.203353F);
      ((Path)localObject).cubicTo(14.8F, 15.640863F, 14.443329F, 16.0F, 14.003353F, 16.0F);
      ((Path)localObject).lineTo(2.796647F, 16.0F);
      ((Path)localObject).cubicTo(2.359136F, 16.0F, 2.0F, 15.643329F, 2.0F, 15.203353F);
      ((Path)localObject).lineTo(2.0F, 4.796647F);
      ((Path)localObject).cubicTo(2.0F, 4.359136F, 2.357799F, 4.0F, 2.799165F, 4.0F);
      ((Path)localObject).lineTo(5.2F, 4.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(8.965686F, 0.5372583F);
      ((Path)localObject).lineTo(11.228427F, 2.8F);
      ((Path)localObject).lineTo(10.549604F, 3.478823F);
      ((Path)localObject).lineTo(8.879995F, 1.809213F);
      ((Path)localObject).lineTo(8.879995F, 9.2F);
      ((Path)localObject).lineTo(7.919995F, 9.2F);
      ((Path)localObject).lineTo(7.919995F, 1.809223F);
      ((Path)localObject).lineTo(6.250395F, 3.478823F);
      ((Path)localObject).lineTo(5.571573F, 2.8F);
      ((Path)localObject).lineTo(7.834314F, 0.5372583F);
      ((Path)localObject).cubicTo(8.146734F, 0.2248389F, 8.653266F, 0.2248389F, 8.965686F, 0.5372583F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.sns_adlanding_share_icon
 * JD-Core Version:    0.7.0.1
 */