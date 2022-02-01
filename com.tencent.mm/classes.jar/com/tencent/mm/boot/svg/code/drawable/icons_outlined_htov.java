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

public class icons_outlined_htov
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject4 = c.instanceMatrixArray(paramVarArgs);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject4 = c.setMatrixFloatArray((float[])localObject4, -6.123234E-017F, -1.0F, 24.0F, -1.0F, 6.123234E-017F, 24.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject4 = c.setMatrixFloatArray((float[])localObject4, 1.0F, 0.0F, 4.2F, 0.0F, 1.0F, -0.52F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      Object localObject5 = c.setMatrixFloatArray((float[])localObject4, -1.83697E-016F, -1.0F, 18.6F, -1.0F, 1.83697E-016F, 10.84F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject5);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localObject4 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject3).setColor(-1);
      ((Paint)localObject4).setStrokeWidth(0.675F);
      localObject5 = c.setMatrixFloatArray((float[])localObject5, -1.83697E-016F, -1.0F, 4.547654F, 1.0F, -1.83697E-016F, 0.5786539F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject5);
      localCanvas.concat((Matrix)localObject1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(1.9845F, 4.001308F);
      localPath.lineTo(3.969F, 1.125F);
      localPath.lineTo(-1.326717E-012F, 1.125F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject3).setStrokeWidth(1.575F);
      localObject4 = c.setMatrixFloatArray((float[])localObject5, 0.9702957F, 0.241922F, -1.166898F, -0.241922F, 0.9702957F, 1.569005F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localObject5 = c.instancePath(paramVarArgs);
      ((Path)localObject5).moveTo(8.319938F, 9.343043F);
      ((Path)localObject5).cubicTo(8.436546F, 8.87535F, 8.483838F, 8.411162F, 8.483838F, 7.922247F);
      ((Path)localObject5).cubicTo(8.483838F, 5.017462F, 6.482186F, 2.580188F, 3.782953F, 1.914495F);
      ((Path)localObject5).cubicTo(3.30674F, 1.797049F, 3.138718F, 1.698133F, 3.127783F, 1.738942F);
      localCanvas.drawPath((Path)localObject5, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.575F);
      localObject3 = c.setMatrixFloatArray((float[])localObject4, -1.0F, 1.224647E-016F, 11.3625F, -1.224647E-016F, -1.0F, 22.491932F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.7875F, 1.9125F);
      ((Path)localObject2).cubicTo(0.7875F, 1.29118F, 1.29118F, 0.7875F, 1.9125F, 0.7875F);
      ((Path)localObject2).lineTo(8.887501F, 0.7875F);
      ((Path)localObject2).cubicTo(9.508822F, 0.7875F, 10.012501F, 1.29118F, 10.012501F, 1.9125F);
      ((Path)localObject2).lineTo(10.012501F, 14.6475F);
      ((Path)localObject2).cubicTo(10.012501F, 15.268821F, 9.508822F, 15.7725F, 8.887501F, 15.7725F);
      ((Path)localObject2).lineTo(1.9125F, 15.7725F);
      ((Path)localObject2).cubicTo(1.29118F, 15.7725F, 0.7875F, 15.268821F, 0.7875F, 14.6475F);
      ((Path)localObject2).lineTo(0.7875F, 1.9125F);
      ((Path)localObject2).close();
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_htov
 * JD-Core Version:    0.7.0.1
 */