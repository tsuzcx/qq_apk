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

public class app_attach_file_icon_keynote
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Object localObject4 = c.instancePaint(paramVarArgs);
      ((Paint)localObject4).setFlags(385);
      ((Paint)localObject4).setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(1.0F);
      ((Paint)localObject4).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject4).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject4).setStrokeMiter(4.0F);
      ((Paint)localObject4).setPathEffect(null);
      c.instancePaint((Paint)localObject4, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject4 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject4).setColor(-14776843);
      Object localObject5 = c.instancePath(paramVarArgs);
      ((Path)localObject5).moveTo(16.0F, 0.0F);
      ((Path)localObject5).lineTo(24.0F, 8.0F);
      ((Path)localObject5).lineTo(23.999863F, 1.049432F);
      ((Path)localObject5).cubicTo(23.999954F, 1.055166F, 24.0F, 1.060911F, 24.0F, 1.066667F);
      ((Path)localObject5).lineTo(24.0F, 30.933332F);
      ((Path)localObject5).cubicTo(24.0F, 31.522438F, 23.522438F, 32.0F, 22.933332F, 32.0F);
      ((Path)localObject5).lineTo(1.066667F, 32.0F);
      ((Path)localObject5).cubicTo(0.4775629F, 32.0F, 2.609151E-015F, 31.522438F, 0.0F, 30.933332F);
      ((Path)localObject5).lineTo(0.0F, 1.066667F);
      ((Path)localObject5).cubicTo(-7.21444E-017F, 0.4775629F, 0.4775629F, 5.523058E-016F, 1.066667F, 0.0F);
      ((Path)localObject5).lineTo(16.0F, 0.0F);
      ((Path)localObject5).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject5, 2);
      localCanvas.drawPath((Path)localObject5, (Paint)localObject4);
      localCanvas.restore();
      localObject5 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject5).setColor(-16777216);
      localObject4 = c.instancePath(paramVarArgs);
      ((Path)localObject4).moveTo(24.0F, 8.0F);
      ((Path)localObject4).lineTo(17.066668F, 8.0F);
      ((Path)localObject4).cubicTo(16.477562F, 8.0F, 16.0F, 7.522437F, 16.0F, 6.933333F);
      ((Path)localObject4).lineTo(16.0F, 0.0F);
      ((Path)localObject4).lineTo(16.0F, 0.0F);
      ((Path)localObject4).lineTo(24.0F, 8.0F);
      ((Path)localObject4).close();
      localCanvas.saveLayerAlpha(null, 51, 31);
      localObject5 = c.instancePaint((Paint)localObject5, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject4, 2);
      localCanvas.drawPath((Path)localObject4, (Paint)localObject5);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 6.133333F, 0.0F, 1.0F, 14.666667F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(3.2F, 11.166667F);
      ((Path)localObject3).cubicTo(3.2F, 10.890525F, 3.423858F, 10.666667F, 3.7F, 10.666667F);
      ((Path)localObject3).lineTo(8.033334F, 10.666667F);
      ((Path)localObject3).cubicTo(8.309476F, 10.666667F, 8.533334F, 10.890525F, 8.533334F, 11.166667F);
      ((Path)localObject3).lineTo(8.533334F, 11.166667F);
      ((Path)localObject3).cubicTo(8.533334F, 11.442809F, 8.309476F, 11.666667F, 8.033334F, 11.666667F);
      ((Path)localObject3).lineTo(3.7F, 11.666667F);
      ((Path)localObject3).cubicTo(3.423858F, 11.666667F, 3.2F, 11.442809F, 3.2F, 11.166667F);
      ((Path)localObject3).lineTo(3.2F, 11.166667F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 5.333334F);
      ((Path)localObject3).lineTo(11.733334F, 5.333334F);
      ((Path)localObject3).cubicTo(11.733334F, 5.922437F, 11.255771F, 6.4F, 10.666667F, 6.4F);
      ((Path)localObject3).lineTo(1.066667F, 6.4F);
      ((Path)localObject3).cubicTo(0.4775629F, 6.4F, 5.162336E-016F, 5.922437F, 0.0F, 5.333334F);
      ((Path)localObject3).lineTo(0.0F, 5.333334F);
      ((Path)localObject3).lineTo(0.0F, 5.333334F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(5.6F, 6.08F);
      ((Path)localObject3).cubicTo(5.6F, 5.814903F, 5.814903F, 5.6F, 6.08F, 5.6F);
      ((Path)localObject3).lineTo(6.12F, 5.6F);
      ((Path)localObject3).cubicTo(6.385097F, 5.6F, 6.6F, 5.814903F, 6.6F, 6.08F);
      ((Path)localObject3).lineTo(6.6F, 10.453334F);
      ((Path)localObject3).cubicTo(6.6F, 10.718431F, 6.385097F, 10.933333F, 6.12F, 10.933333F);
      ((Path)localObject3).lineTo(6.08F, 10.933333F);
      ((Path)localObject3).cubicTo(5.814903F, 10.933333F, 5.6F, 10.718431F, 5.6F, 10.453334F);
      ((Path)localObject3).lineTo(5.6F, 6.08F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(1.927738F, 0.0F);
      ((Path)localObject2).lineTo(9.650041F, 0.0F);
      ((Path)localObject2).cubicTo(9.904998F, -2.688795E-016F, 10.124299F, 0.1804498F, 10.173392F, 0.4306358F);
      ((Path)localObject2).lineTo(11.044444F, 4.869565F);
      ((Path)localObject2).lineTo(11.044444F, 4.869565F);
      ((Path)localObject2).lineTo(0.5333334F, 4.869565F);
      ((Path)localObject2).lineTo(1.404385F, 0.4306358F);
      ((Path)localObject2).cubicTo(1.453479F, 0.1804498F, 1.67278F, 4.683492E-017F, 1.927738F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.666028F, 3.698016F);
      ((Path)localObject2).lineTo(4.945681F, 2.498263F);
      ((Path)localObject2).lineTo(6.113702F, 3.282984F);
      ((Path)localObject2).cubicTo(6.203775F, 3.341494F, 6.322458F, 3.329943F, 6.396555F, 3.255382F);
      ((Path)localObject2).lineTo(8.023494F, 1.485858F);
      ((Path)localObject2).lineTo(7.702483F, 1.172722F);
      ((Path)localObject2).lineTo(6.201948F, 2.814025F);
      ((Path)localObject2).lineTo(5.053129F, 2.02927F);
      ((Path)localObject2).cubicTo(4.970434F, 1.970743F, 4.857476F, 1.982318F, 4.782503F, 2.056925F);
      ((Path)localObject2).lineTo(3.372861F, 3.384988F);
      ((Path)localObject2).lineTo(3.666028F, 3.698016F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_keynote
 * JD-Core Version:    0.7.0.1
 */