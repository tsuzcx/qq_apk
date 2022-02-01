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

public class icons_outlined_min_window
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      c.instancePaint((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(24.0F, 0.0F);
      ((Path)localObject2).lineTo(24.0F, 24.0F);
      ((Path)localObject2).lineTo(0.0F, 24.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 11.857233F, 0.7071068F, 0.7071068F, -5.497213F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(13.271446F, 13.528806F);
      ((Path)localObject1).lineTo(16.80698F, 17.064341F);
      ((Path)localObject1).lineTo(15.746321F, 18.125F);
      ((Path)localObject1).lineTo(13.313699F, 15.69234F);
      ((Path)localObject1).lineTo(13.31434F, 22.564341F);
      ((Path)localObject1).lineTo(11.81434F, 22.564341F);
      ((Path)localObject1).lineTo(11.813699F, 15.69234F);
      ((Path)localObject1).lineTo(9.38236F, 18.125F);
      ((Path)localObject1).lineTo(8.321699F, 17.064341F);
      ((Path)localObject1).lineTo(11.857233F, 13.528806F);
      ((Path)localObject1).cubicTo(12.247757F, 13.138282F, 12.880922F, 13.138282F, 13.271446F, 13.528806F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(13.31434F, 0.5643398F);
      ((Path)localObject1).lineTo(13.313699F, 7.43434F);
      ((Path)localObject1).lineTo(15.746321F, 5.00368F);
      ((Path)localObject1).lineTo(16.80698F, 6.06434F);
      ((Path)localObject1).lineTo(13.271446F, 9.599874F);
      ((Path)localObject1).cubicTo(12.880922F, 9.990398F, 12.247757F, 9.990398F, 11.857233F, 9.599874F);
      ((Path)localObject1).lineTo(11.857233F, 9.599874F);
      ((Path)localObject1).lineTo(8.321699F, 6.06434F);
      ((Path)localObject1).lineTo(9.38236F, 5.00368F);
      ((Path)localObject1).lineTo(11.813699F, 7.43634F);
      ((Path)localObject1).lineTo(11.81434F, 0.5643398F);
      ((Path)localObject1).lineTo(13.31434F, 0.5643398F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_min_window
 * JD-Core Version:    0.7.0.1
 */