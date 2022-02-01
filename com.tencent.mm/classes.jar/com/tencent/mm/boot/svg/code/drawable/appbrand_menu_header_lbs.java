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

public class appbrand_menu_header_lbs
  extends c
{
  private final int height = 12;
  private final int width = 11;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 11;
      return 12;
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -286.0F, 0.0F, 1.0F, -423.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 279.0F, 0.0F, 1.0F, 417.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 1.0F);
      localPath.lineTo(14.0F, 1.0F);
      localPath.lineTo(14.0F, 15.0F);
      localPath.lineTo(0.0F, 15.0F);
      localPath.lineTo(0.0F, 1.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath(localPath, c.instancePaint(localPaint2, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 7.093145F, 0.7071068F, 0.7071068F, -3.68934F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(8.323189F, 1.454765F);
      ((Path)localObject).lineTo(11.987649F, 11.762449F);
      ((Path)localObject).cubicTo(12.051114F, 11.940967F, 11.957845F, 12.137132F, 11.779327F, 12.200596F);
      ((Path)localObject).cubicTo(11.673446F, 12.238238F, 11.555841F, 12.221637F, 11.464518F, 12.156157F);
      ((Path)localObject).lineTo(7.999954F, 9.672035F);
      ((Path)localObject).lineTo(7.999954F, 9.672035F);
      ((Path)localObject).lineTo(4.535392F, 12.156157F);
      ((Path)localObject).cubicTo(4.381418F, 12.266557F, 4.1671F, 12.231234F, 4.0567F, 12.07726F);
      ((Path)localObject).cubicTo(3.991219F, 11.985935F, 3.974618F, 11.868331F, 4.01226F, 11.762449F);
      ((Path)localObject).lineTo(7.67672F, 1.454765F);
      ((Path)localObject).cubicTo(7.740184F, 1.276248F, 7.936349F, 1.182979F, 8.114866F, 1.246443F);
      ((Path)localObject).cubicTo(8.212108F, 1.281013F, 8.288619F, 1.357524F, 8.323189F, 1.454765F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.appbrand_menu_header_lbs
 * JD-Core Version:    0.7.0.1
 */