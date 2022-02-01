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

public class app_attach_file_icon_photo
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
      Object localObject2 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(16.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 8.0F);
      ((Path)localObject3).lineTo(23.999863F, 1.049432F);
      ((Path)localObject3).cubicTo(23.999954F, 1.055166F, 24.0F, 1.060911F, 24.0F, 1.066667F);
      ((Path)localObject3).lineTo(24.0F, 30.933332F);
      ((Path)localObject3).cubicTo(24.0F, 31.522438F, 23.522438F, 32.0F, 22.933332F, 32.0F);
      ((Path)localObject3).lineTo(1.066667F, 32.0F);
      ((Path)localObject3).cubicTo(0.4775629F, 32.0F, 2.609151E-015F, 31.522438F, 0.0F, 30.933332F);
      ((Path)localObject3).lineTo(0.0F, 1.066667F);
      ((Path)localObject3).cubicTo(-7.21444E-017F, 0.4775629F, 0.4775629F, 5.523058E-016F, 1.066667F, 0.0F);
      ((Path)localObject3).lineTo(16.0F, 0.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(201326592);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(16.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 8.0F);
      ((Path)localObject3).lineTo(23.999863F, 1.049432F);
      ((Path)localObject3).cubicTo(23.999954F, 1.055166F, 24.0F, 1.060911F, 24.0F, 1.066667F);
      ((Path)localObject3).lineTo(24.0F, 30.933332F);
      ((Path)localObject3).cubicTo(24.0F, 31.522438F, 23.522438F, 32.0F, 22.933332F, 32.0F);
      ((Path)localObject3).lineTo(1.066667F, 32.0F);
      ((Path)localObject3).cubicTo(0.4775629F, 32.0F, 2.609151E-015F, 31.522438F, 0.0F, 30.933332F);
      ((Path)localObject3).lineTo(0.0F, 1.066667F);
      ((Path)localObject3).cubicTo(-7.21444E-017F, 0.4775629F, 0.4775629F, 5.523058E-016F, 1.066667F, 0.0F);
      ((Path)localObject3).lineTo(16.0F, 0.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(1275068416);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(17.360001F, 15.12F);
      ((Path)localObject3).cubicTo(17.713463F, 15.12F, 18.0F, 15.406538F, 18.0F, 15.76F);
      ((Path)localObject3).lineTo(18.0F, 24.08F);
      ((Path)localObject3).cubicTo(18.0F, 24.433462F, 17.713463F, 24.719999F, 17.360001F, 24.719999F);
      ((Path)localObject3).lineTo(6.64F, 24.719999F);
      ((Path)localObject3).cubicTo(6.286538F, 24.719999F, 6.0F, 24.433462F, 6.0F, 24.08F);
      ((Path)localObject3).lineTo(6.0F, 15.76F);
      ((Path)localObject3).cubicTo(6.0F, 15.406538F, 6.286538F, 15.12F, 6.64F, 15.12F);
      ((Path)localObject3).lineTo(17.360001F, 15.12F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(10.0688F, 19.5056F);
      ((Path)localObject3).lineTo(6.959F, 22.02F);
      ((Path)localObject3).lineTo(6.96F, 23.76F);
      ((Path)localObject3).lineTo(17.040001F, 23.76F);
      ((Path)localObject3).lineTo(17.040001F, 22.194F);
      ((Path)localObject3).lineTo(15.2F, 20.5376F);
      ((Path)localObject3).lineTo(13.940213F, 21.670834F);
      ((Path)localObject3).lineTo(14.715132F, 22.357933F);
      ((Path)localObject3).lineTo(13.279798F, 22.360001F);
      ((Path)localObject3).lineTo(10.0688F, 19.5056F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(17.040001F, 16.08F);
      ((Path)localObject3).lineTo(6.96F, 16.08F);
      ((Path)localObject3).lineTo(6.959F, 20.785F);
      ((Path)localObject3).lineTo(9.564249F, 18.679729F);
      ((Path)localObject3).cubicTo(9.86841F, 18.433813F, 10.305793F, 18.443886F, 10.59831F, 18.703547F);
      ((Path)localObject3).lineTo(13.339213F, 21.136833F);
      ((Path)localObject3).lineTo(14.771863F, 19.847179F);
      ((Path)localObject3).cubicTo(15.015258F, 19.628122F, 15.384742F, 19.628122F, 15.628138F, 19.847179F);
      ((Path)localObject3).lineTo(17.040001F, 21.118F);
      ((Path)localObject3).lineTo(17.040001F, 16.08F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(24.0F, 8.0F);
      ((Path)localObject1).lineTo(17.066668F, 8.0F);
      ((Path)localObject1).cubicTo(16.477562F, 8.0F, 16.0F, 7.522437F, 16.0F, 6.933333F);
      ((Path)localObject1).lineTo(16.0F, 0.0F);
      ((Path)localObject1).lineTo(16.0F, 0.0F);
      ((Path)localObject1).lineTo(24.0F, 8.0F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 25, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_photo
 * JD-Core Version:    0.7.0.1
 */