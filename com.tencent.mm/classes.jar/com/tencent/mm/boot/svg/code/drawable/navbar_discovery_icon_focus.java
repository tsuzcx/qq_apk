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

public class navbar_discovery_icon_focus
  extends c
{
  private final int height = 84;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 84;
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
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-12206054);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 14.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(31.552F, 0.089F);
      ((Path)localObject3).cubicTo(36.477001F, -0.264F, 41.480999F, 0.453F, 46.096001F, 2.217F);
      ((Path)localObject3).cubicTo(52.452F, 4.625F, 58.036999F, 9.004F, 61.912998F, 14.586F);
      ((Path)localObject3).cubicTo(63.992001F, 17.566F, 65.587997F, 20.882999F, 66.614998F, 24.368999F);
      ((Path)localObject3).cubicTo(68.773003F, 31.659F, 68.400002F, 39.674F, 65.539001F, 46.720001F);
      ((Path)localObject3).cubicTo(63.272999F, 52.354F, 59.455002F, 57.347F, 54.626999F, 61.028999F);
      ((Path)localObject3).cubicTo(49.384998F, 65.052002F, 42.943001F, 67.485001F, 36.348F, 67.917999F);
      ((Path)localObject3).cubicTo(31.983999F, 68.218002F, 27.561001F, 67.681F, 23.403999F, 66.314003F);
      ((Path)localObject3).cubicTo(17.003F, 64.228996F, 11.27F, 60.173F, 7.147F, 54.854F);
      ((Path)localObject3).cubicTo(4.738F, 51.758999F, 2.868F, 48.243999F, 1.658F, 44.512001F);
      ((Path)localObject3).cubicTo(0.025F, 39.504002F, -0.4F, 34.113998F, 0.381F, 28.907F);
      ((Path)localObject3).cubicTo(1.448F, 21.662001F, 4.972F, 14.819F, 10.213F, 9.709F);
      ((Path)localObject3).cubicTo(15.02F, 4.983F, 21.263F, 1.734F, 27.902F, 0.548F);
      ((Path)localObject3).cubicTo(29.108999F, 0.329F, 30.327999F, 0.176F, 31.552F, 0.089F);
      ((Path)localObject3).lineTo(31.552F, 0.089F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(30.438999F, 26.843F);
      ((Path)localObject3).cubicTo(28.893F, 27.608999F, 27.608999F, 28.891001F, 26.841999F, 30.437F);
      ((Path)localObject3).cubicTo(23.198999F, 37.657001F, 19.552999F, 44.875F, 15.911F, 52.096001F);
      ((Path)localObject3).cubicTo(23.174F, 48.431F, 30.436001F, 44.764999F, 37.699001F, 41.099998F);
      ((Path)localObject3).cubicTo(39.146999F, 40.347F, 40.354F, 39.139F, 41.103001F, 37.688F);
      ((Path)localObject3).cubicTo(44.771999F, 30.427F, 48.437F, 23.165001F, 52.104F, 15.904F);
      ((Path)localObject3).cubicTo(44.882F, 19.549999F, 37.66F, 23.195F, 30.438999F, 26.843F);
      ((Path)localObject3).lineTo(30.438999F, 26.843F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(33.346001F, 31.079F);
      ((Path)localObject2).cubicTo(34.928001F, 30.679001F, 36.667999F, 31.815001F, 36.943001F, 33.421001F);
      ((Path)localObject2).cubicTo(37.306F, 35.014F, 36.122002F, 36.729F, 34.507F, 36.960999F);
      ((Path)localObject2).cubicTo(32.928001F, 37.277F, 31.267F, 36.087002F, 31.044001F, 34.497002F);
      ((Path)localObject2).cubicTo(30.753F, 32.98F, 31.834999F, 31.384001F, 33.346001F, 31.079F);
      ((Path)localObject2).lineTo(33.346001F, 31.079F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.navbar_discovery_icon_focus
 * JD-Core Version:    0.7.0.1
 */