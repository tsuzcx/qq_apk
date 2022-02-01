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

public class ipcall_plus_menu_icon
  extends c
{
  private final int height = 55;
  private final int width = 55;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 55;
      return 55;
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(2.0F, -3.552714E-015F);
      ((Path)localObject2).cubicTo(6.066657F, -0.02062163F, 10.031018F, -0.1703468F, 14.0F, -3.552714E-015F);
      ((Path)localObject2).cubicTo(16.641615F, 1.77608F, 15.303518F, 5.678915F, 16.0F, 8.0F);
      ((Path)localObject2).cubicTo(16.01251F, 10.619844F, 18.548903F, 12.885685F, 17.0F, 15.0F);
      ((Path)localObject2).cubicTo(15.363433F, 18.066174F, 12.717196F, 20.302071F, 10.0F, 23.0F);
      ((Path)localObject2).cubicTo(15.303518F, 30.902609F, 22.143789F, 37.620277F, 30.0F, 43.0F);
      ((Path)localObject2).cubicTo(32.638859F, 40.285385F, 34.845722F, 37.720093F, 38.0F, 36.0F);
      ((Path)localObject2).cubicTo(38.879982F, 34.635757F, 40.467724F, 35.633923F, 42.0F, 36.0F);
      ((Path)localObject2).cubicTo(44.901417F, 37.300861F, 48.286602F, 36.941525F, 51.0F, 38.0F);
      ((Path)localObject2).cubicTo(53.119728F, 38.408829F, 52.929996F, 40.494999F, 53.0F, 42.0F);
      ((Path)localObject2).cubicTo(52.929996F, 44.936844F, 53.159672F, 47.891422F, 53.0F, 51.0F);
      ((Path)localObject2).cubicTo(51.422142F, 53.810555F, 47.587597F, 52.832352F, 45.0F, 53.0F);
      ((Path)localObject2).cubicTo(22.583164F, 49.648197F, 3.370492F, 30.523306F, 3.552714E-015F, 8.0F);
      ((Path)localObject2).cubicTo(0.1950087F, 5.509227F, -0.873472F, 1.546501F, 2.0F, -3.552714E-015F);
      ((Path)localObject2).lineTo(2.0F, -3.552714E-015F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ipcall_plus_menu_icon
 * JD-Core Version:    0.7.0.1
 */