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

public class spannable_app_brand_link_logo_light
  extends c
{
  private final int height = 20;
  private final int width = 20;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 20;
      return 20;
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -4.0F, 0.0F, 1.0F, -18.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 18.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-526345);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(10.0F, 0.0F);
      localPath.cubicTo(15.522848F, 0.0F, 20.0F, 4.477152F, 20.0F, 10.0F);
      localPath.cubicTo(20.0F, 15.522848F, 15.522848F, 20.0F, 10.0F, 20.0F);
      localPath.cubicTo(4.477152F, 20.0F, 0.0F, 15.522848F, 0.0F, 10.0F);
      localPath.cubicTo(0.0F, 4.477152F, 4.477152F, 0.0F, 10.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-9074981);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(9.018617F, 5.18391F);
      ((Path)localObject2).lineTo(8.890989F, 5.185274F);
      ((Path)localObject2).cubicTo(8.518699F, 5.185274F, 8.302917F, 4.924064F, 8.442778F, 4.609397F);
      ((Path)localObject2).cubicTo(8.541686F, 4.378609F, 8.766817F, 4.196773F, 9.037075F, 4.136731F);
      ((Path)localObject2).cubicTo(9.823048F, 3.947014F, 10.364232F, 3.329606F, 10.364232F, 2.605002F);
      ((Path)localObject2).cubicTo(10.364232F, 1.732587F, 9.536904F, 1.019939F, 8.499616F, 1.019939F);
      ((Path)localObject2).cubicTo(7.462327F, 1.019939F, 6.634999F, 1.732587F, 6.634999F, 2.605002F);
      ((Path)localObject2).lineTo(6.634999F, 6.798293F);
      ((Path)localObject2).cubicTo(6.634999F, 8.244568F, 5.338975F, 9.40652F, 3.747219F, 9.40652F);
      ((Path)localObject2).cubicTo(2.155463F, 9.40652F, 0.8594396F, 8.244568F, 0.8594396F, 6.798293F);
      ((Path)localObject2).cubicTo(0.8594396F, 5.531107F, 1.861776F, 4.451003F, 3.216069F, 4.245977F);
      ((Path)localObject2).lineTo(3.32789F, 4.245977F);
      ((Path)localObject2).cubicTo(3.614159F, 4.245977F, 3.811516F, 4.412173F, 3.811516F, 4.645737F);
      ((Path)localObject2).cubicTo(3.811635F, 4.686376F, 3.810874F, 4.706147F, 3.806767F, 4.730792F);
      ((Path)localObject2).cubicTo(3.801529F, 4.76222F, 3.791251F, 4.791912F, 3.776102F, 4.821854F);
      ((Path)localObject2).cubicTo(3.682229F, 5.04089F, 3.438705F, 5.230298F, 3.181805F, 5.294519F);
      ((Path)localObject2).cubicTo(2.400073F, 5.483213F, 1.854647F, 6.097778F, 1.854647F, 6.798293F);
      ((Path)localObject2).cubicTo(1.854647F, 7.670709F, 2.681975F, 8.383357F, 3.719264F, 8.383357F);
      ((Path)localObject2).cubicTo(4.756553F, 8.383357F, 5.58388F, 7.670709F, 5.58388F, 6.798293F);
      ((Path)localObject2).lineTo(5.58388F, 2.605002F);
      ((Path)localObject2).cubicTo(5.58388F, 1.158728F, 6.879904F, -0.003224364F, 8.47166F, -0.003224364F);
      ((Path)localObject2).cubicTo(10.063416F, -0.003224364F, 11.35944F, 1.158728F, 11.35944F, 2.605002F);
      ((Path)localObject2).cubicTo(11.35944F, 3.885873F, 10.373533F, 4.948272F, 9.018617F, 5.18391F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.spannable_app_brand_link_logo_light
 * JD-Core Version:    0.7.0.1
 */