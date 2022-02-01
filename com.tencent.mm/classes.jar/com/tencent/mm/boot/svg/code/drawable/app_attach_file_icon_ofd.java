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

public class app_attach_file_icon_ofd
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
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-9132032);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(16.235294F, 0.0F);
      ((Path)localObject2).lineTo(24.0F, 7.822222F);
      ((Path)localObject2).lineTo(24.0F, 30.933332F);
      ((Path)localObject2).cubicTo(24.0F, 31.522436F, 23.525948F, 32.0F, 22.941177F, 32.0F);
      ((Path)localObject2).lineTo(1.058824F, 32.0F);
      ((Path)localObject2).cubicTo(0.4740515F, 32.0F, 0.0F, 31.522436F, 0.0F, 30.933332F);
      ((Path)localObject2).lineTo(0.0F, 1.066667F);
      ((Path)localObject2).cubicTo(0.0F, 0.4775629F, 0.4740515F, 0.0F, 1.058824F, 0.0F);
      ((Path)localObject2).lineTo(16.235294F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(6.980469F, 22.49375F);
      ((Path)localObject2).cubicTo(8.621094F, 22.49375F, 9.652344F, 21.376562F, 9.652344F, 19.583593F);
      ((Path)localObject2).cubicTo(9.652344F, 17.790625F, 8.621094F, 16.669531F, 6.980469F, 16.669531F);
      ((Path)localObject2).cubicTo(5.335938F, 16.669531F, 4.304688F, 17.790625F, 4.304688F, 19.583593F);
      ((Path)localObject2).cubicTo(4.304688F, 21.376562F, 5.335938F, 22.49375F, 6.980469F, 22.49375F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(6.980469F, 21.634375F);
      ((Path)localObject2).cubicTo(5.972656F, 21.634375F, 5.335938F, 20.8375F, 5.335938F, 19.583593F);
      ((Path)localObject2).cubicTo(5.335938F, 18.325781F, 5.972656F, 17.528906F, 6.980469F, 17.528906F);
      ((Path)localObject2).cubicTo(7.984375F, 17.528906F, 8.625F, 18.325781F, 8.625F, 19.583593F);
      ((Path)localObject2).cubicTo(8.625F, 20.8375F, 7.984375F, 21.634375F, 6.980469F, 21.634375F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(11.460938F, 22.4F);
      ((Path)localObject2).lineTo(11.460938F, 20.099218F);
      ((Path)localObject2).lineTo(13.824219F, 20.099218F);
      ((Path)localObject2).lineTo(13.824219F, 19.278906F);
      ((Path)localObject2).lineTo(11.460938F, 19.278906F);
      ((Path)localObject2).lineTo(11.460938F, 17.614843F);
      ((Path)localObject2).lineTo(14.046875F, 17.614843F);
      ((Path)localObject2).lineTo(14.046875F, 16.763281F);
      ((Path)localObject2).lineTo(10.453125F, 16.763281F);
      ((Path)localObject2).lineTo(10.453125F, 22.4F);
      ((Path)localObject2).lineTo(11.460938F, 22.4F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.835938F, 22.4F);
      ((Path)localObject2).cubicTo(18.523438F, 22.4F, 19.515625F, 21.353125F, 19.515625F, 19.567968F);
      ((Path)localObject2).cubicTo(19.515625F, 17.782812F, 18.519531F, 16.763281F, 16.835938F, 16.763281F);
      ((Path)localObject2).lineTo(14.777344F, 16.763281F);
      ((Path)localObject2).lineTo(14.777344F, 22.4F);
      ((Path)localObject2).lineTo(16.835938F, 22.4F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.730469F, 21.548437F);
      ((Path)localObject2).lineTo(15.785156F, 21.548437F);
      ((Path)localObject2).lineTo(15.785156F, 17.614843F);
      ((Path)localObject2).lineTo(16.730469F, 17.614843F);
      ((Path)localObject2).cubicTo(17.855469F, 17.614843F, 18.488281F, 18.310156F, 18.488281F, 19.571875F);
      ((Path)localObject2).cubicTo(18.488281F, 20.857031F, 17.863281F, 21.548437F, 16.730469F, 21.548437F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-10643968);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(24.0F, 7.822222F);
      ((Path)localObject1).lineTo(17.294117F, 7.822222F);
      ((Path)localObject1).cubicTo(16.709345F, 7.822222F, 16.235294F, 7.344659F, 16.235294F, 6.755556F);
      ((Path)localObject1).lineTo(16.235294F, 0.0F);
      ((Path)localObject1).lineTo(24.0F, 7.822222F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_ofd
 * JD-Core Version:    0.7.0.1
 */