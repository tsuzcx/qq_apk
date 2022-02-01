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

public class icons_outlined_colorful_handoff_success
  extends c
{
  private final int height = 33;
  private final int width = 34;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 34;
      return 33;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
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
      ((Paint)localObject2).setColor(-1184275);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(17.406498F, 20.448332F);
      ((Path)localObject3).lineTo(18.969162F, 24.743322F);
      ((Path)localObject3).cubicTo(19.119043F, 25.155495F, 18.906414F, 25.611132F, 18.49424F, 25.761013F);
      ((Path)localObject3).cubicTo(18.407257F, 25.792643F, 18.315413F, 25.808823F, 18.222857F, 25.808823F);
      ((Path)localObject3).lineTo(8.578614F, 25.808823F);
      ((Path)localObject3).cubicTo(8.140036F, 25.808823F, 7.784497F, 25.453285F, 7.784497F, 25.014706F);
      ((Path)localObject3).cubicTo(7.784497F, 24.92215F, 7.800678F, 24.830305F, 7.832308F, 24.743322F);
      ((Path)localObject3).lineTo(9.393498F, 20.448332F);
      ((Path)localObject3).lineTo(17.406498F, 20.448332F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(1.389706F, 0.0F);
      ((Path)localObject2).lineTo(25.411764F, 0.0F);
      ((Path)localObject2).cubicTo(26.179277F, 2.126121E-015F, 26.80147F, 0.622193F, 26.80147F, 1.389706F);
      ((Path)localObject2).lineTo(26.80147F, 17.470589F);
      ((Path)localObject2).cubicTo(26.80147F, 18.238102F, 26.179277F, 18.860294F, 25.411764F, 18.860294F);
      ((Path)localObject2).lineTo(1.389706F, 18.860294F);
      ((Path)localObject2).cubicTo(0.622193F, 18.860294F, 9.821717E-016F, 18.238102F, 0.0F, 17.470589F);
      ((Path)localObject2).lineTo(0.0F, 1.389706F);
      ((Path)localObject2).cubicTo(-9.399328E-017F, 0.622193F, 0.622193F, 8.071237E-016F, 1.389706F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(17.56418F, 5.955883F);
      ((Path)localObject2).lineTo(18.36397F, 6.827039F);
      ((Path)localObject2).lineTo(13.229698F, 12.093872F);
      ((Path)localObject2).cubicTo(12.84595F, 12.487528F, 12.250469F, 12.510681F, 11.841828F, 12.166817F);
      ((Path)localObject2).lineTo(11.751024F, 12.080949F);
      ((Path)localObject2).lineTo(9.430147F, 9.620091F);
      ((Path)localObject2).lineTo(10.243455F, 8.763032F);
      ((Path)localObject2).lineTo(12.497311F, 11.152122F);
      ((Path)localObject2).lineTo(17.56418F, 5.955883F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_colorful_handoff_success
 * JD-Core Version:    0.7.0.1
 */