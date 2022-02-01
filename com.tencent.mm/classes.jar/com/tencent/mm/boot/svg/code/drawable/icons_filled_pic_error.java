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

public class icons_filled_pic_error
  extends c
{
  private final int height = 56;
  private final int width = 56;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 56;
      return 56;
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
      localCanvas.saveLayerAlpha(null, 230, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-2147483648);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, -4.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(49.019127F, 9.333333F);
      ((Path)localObject3).cubicTo(50.270954F, 9.333333F, 51.333332F, 10.455986F, 51.333332F, 11.840849F);
      ((Path)localObject3).lineTo(51.333549F, 28.073263F);
      ((Path)localObject3).cubicTo(50.895702F, 28.024853F, 50.450752F, 28.0F, 50.0F, 28.0F);
      ((Path)localObject3).cubicTo(49.49535F, 28.0F, 48.997971F, 28.031151F, 48.509689F, 28.091637F);
      ((Path)localObject3).lineTo(48.509766F, 12.081787F);
      ((Path)localObject3).lineTo(7.416992F, 12.081787F);
      ((Path)localObject3).lineTo(7.416667F, 32.920334F);
      ((Path)localObject3).lineTo(19.131573F, 23.448271F);
      ((Path)localObject3).cubicTo(20.210865F, 22.575432F, 21.944126F, 22.617764F, 22.984489F, 23.531862F);
      ((Path)localObject3).lineTo(33.429485F, 32.709194F);
      ((Path)localObject3).lineTo(38.754574F, 28.180828F);
      ((Path)localObject3).cubicTo(39.833073F, 27.263687F, 41.549019F, 27.28232F, 42.596008F, 28.221863F);
      ((Path)localObject3).lineTo(44.072102F, 29.564013F);
      ((Path)localObject3).cubicTo(40.445568F, 31.628412F, 38.0F, 35.52861F, 38.0F, 40.0F);
      ((Path)localObject3).cubicTo(38.0F, 42.467003F, 38.74445F, 44.760132F, 40.020954F, 46.666996F);
      ((Path)localObject3).lineTo(6.980874F, 46.666668F);
      ((Path)localObject3).cubicTo(5.729046F, 46.666668F, 4.666667F, 45.544014F, 4.666667F, 44.159149F);
      ((Path)localObject3).lineTo(4.666667F, 11.840849F);
      ((Path)localObject3).cubicTo(4.666667F, 10.450645F, 5.702773F, 9.333333F, 6.980874F, 9.333333F);
      ((Path)localObject3).lineTo(49.019127F, 9.333333F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(46.0F, 30.0F);
      ((Path)localObject2).cubicTo(51.522846F, 30.0F, 56.0F, 34.477154F, 56.0F, 40.0F);
      ((Path)localObject2).cubicTo(56.0F, 45.522846F, 51.522846F, 50.0F, 46.0F, 50.0F);
      ((Path)localObject2).cubicTo(40.477154F, 50.0F, 36.0F, 45.522846F, 36.0F, 40.0F);
      ((Path)localObject2).cubicTo(36.0F, 34.477154F, 40.477154F, 30.0F, 46.0F, 30.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(45.996197F, 43.928833F);
      ((Path)localObject2).cubicTo(45.441063F, 43.928833F, 45.0F, 44.362942F, 45.0F, 44.928833F);
      ((Path)localObject2).cubicTo(45.0F, 45.494724F, 45.441063F, 45.928833F, 45.996197F, 45.928833F);
      ((Path)localObject2).cubicTo(46.56654F, 45.928833F, 47.0F, 45.494724F, 47.0F, 44.928833F);
      ((Path)localObject2).cubicTo(47.0F, 44.362942F, 46.56654F, 43.928833F, 45.996197F, 43.928833F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(47.0F, 34.342773F);
      ((Path)localObject2).lineTo(45.0F, 34.342773F);
      ((Path)localObject2).lineTo(45.143497F, 42.342773F);
      ((Path)localObject2).lineTo(46.856503F, 42.342773F);
      ((Path)localObject2).lineTo(47.0F, 34.342773F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_pic_error
 * JD-Core Version:    0.7.0.1
 */