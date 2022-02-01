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

public class icons_outlined_vtoh
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 5.76F, 0.0F, 1.0F, 0.202101F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 6.123234E-017F, -1.0F, 17.192093F, -1.0F, -6.123234E-017F, 10.002673F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(3.808108F, 8.712087E-013F);
      localPath.lineTo(3.808636F, 1.65094F);
      localPath.cubicTo(6.658098F, 1.990312F, 9.07661F, 4.057225F, 9.793031F, 6.930634F);
      localPath.cubicTo(9.904462F, 7.377557F, 9.971774F, 7.804071F, 9.994242F, 8.231253F);
      localPath.lineTo(10.002673F, 8.552093F);
      localPath.lineTo(8.322673F, 8.552093F);
      localPath.cubicTo(8.322673F, 8.159513F, 8.270389F, 7.768037F, 8.162934F, 7.337063F);
      localPath.cubicTo(7.634591F, 5.217992F, 5.889055F, 3.674942F, 3.809068F, 3.34677F);
      localPath.lineTo(3.808108F, 5.254784F);
      localPath.lineTo(-1.820766E-014F, 2.627392F);
      localPath.lineTo(3.808108F, 8.712087E-013F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 3.67394E-016F, 9.6F, -3.67394E-016F, -1.0F, 26.246239F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(8.475F, 5.763119F);
      ((Path)localObject).cubicTo(9.09632F, 5.763119F, 9.6F, 6.266799F, 9.6F, 6.888119F);
      ((Path)localObject).lineTo(9.6F, 19.35812F);
      ((Path)localObject).cubicTo(9.6F, 19.979439F, 9.09632F, 20.48312F, 8.475F, 20.48312F);
      ((Path)localObject).lineTo(1.125F, 20.48312F);
      ((Path)localObject).cubicTo(0.5036796F, 20.48312F, 0.0F, 19.979439F, 0.0F, 19.35812F);
      ((Path)localObject).lineTo(0.0F, 6.888119F);
      ((Path)localObject).cubicTo(0.0F, 6.266799F, 0.5036796F, 5.763119F, 1.125F, 5.763119F);
      ((Path)localObject).lineTo(8.475F, 5.763119F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_vtoh
 * JD-Core Version:    0.7.0.1
 */