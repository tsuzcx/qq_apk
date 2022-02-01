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

public class toolbar_icon_dark_del_normal
  extends c
{
  private final int height = 96;
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
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
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
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-14046139);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(96.0F, 0.0F);
      localPath.lineTo(96.0F, 96.0F);
      localPath.lineTo(0.0F, 96.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath(localPath, c.instancePaint(localPaint2, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 12.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 204, 31);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 10.0F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(10.320658F, 10.199991F);
      ((Path)localObject2).lineTo(12.757717F, 51.142605F);
      ((Path)localObject2).cubicTo(12.833185F, 52.410458F, 13.88338F, 53.400002F, 15.153477F, 53.400002F);
      ((Path)localObject2).lineTo(36.846523F, 53.400002F);
      ((Path)localObject2).cubicTo(38.116619F, 53.400002F, 39.166817F, 52.410458F, 39.242283F, 51.142605F);
      ((Path)localObject2).lineTo(41.679344F, 10.199991F);
      ((Path)localObject2).lineTo(10.320658F, 10.199991F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(45.285713F, 10.199991F);
      ((Path)localObject2).lineTo(42.835922F, 51.35651F);
      ((Path)localObject2).cubicTo(42.647255F, 54.526142F, 40.021767F, 57.0F, 36.846523F, 57.0F);
      ((Path)localObject2).lineTo(15.153477F, 57.0F);
      ((Path)localObject2).cubicTo(11.978235F, 57.0F, 9.352747F, 54.526142F, 9.164078F, 51.35651F);
      ((Path)localObject2).lineTo(6.714286F, 10.199991F);
      ((Path)localObject2).lineTo(0.5F, 10.199991F);
      ((Path)localObject2).lineTo(0.5F, 8.099991F);
      ((Path)localObject2).cubicTo(0.5F, 7.271564F, 1.171573F, 6.599991F, 2.0F, 6.599991F);
      ((Path)localObject2).lineTo(50.0F, 6.599991F);
      ((Path)localObject2).cubicTo(50.828426F, 6.599991F, 51.5F, 7.271564F, 51.5F, 8.099991F);
      ((Path)localObject2).lineTo(51.5F, 10.199991F);
      ((Path)localObject2).lineTo(45.285713F, 10.199991F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(32.0F, 8.185671E-005F);
      ((Path)localObject2).cubicTo(32.828426F, 8.185671E-005F, 33.5F, 0.6716548F, 33.5F, 1.500082F);
      ((Path)localObject2).lineTo(33.5F, 3.600073F);
      ((Path)localObject2).lineTo(18.5F, 3.600073F);
      ((Path)localObject2).lineTo(18.5F, 1.500082F);
      ((Path)localObject2).cubicTo(18.5F, 0.6716548F, 19.171574F, 8.185671E-005F, 20.0F, 8.185671E-005F);
      ((Path)localObject2).lineTo(32.0F, 8.185671E-005F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(18.5F, 18.0F);
      ((Path)localObject2).lineTo(22.100037F, 18.0F);
      ((Path)localObject2).lineTo(23.600037F, 45.0F);
      ((Path)localObject2).lineTo(20.0F, 45.0F);
      ((Path)localObject2).lineTo(18.5F, 18.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(29.899963F, 18.0F);
      ((Path)localObject2).lineTo(33.5F, 18.0F);
      ((Path)localObject2).lineTo(32.0F, 45.0F);
      ((Path)localObject2).lineTo(28.399963F, 45.0F);
      ((Path)localObject2).lineTo(29.899963F, 18.0F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.toolbar_icon_dark_del_normal
 * JD-Core Version:    0.7.0.1
 */