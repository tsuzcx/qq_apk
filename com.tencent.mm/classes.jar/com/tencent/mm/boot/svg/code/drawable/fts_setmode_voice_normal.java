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

public class fts_setmode_voice_normal
  extends c
{
  private final int height = 144;
  private final int width = 144;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 144;
      return 144;
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 24.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-15028967);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(41.623169F, 65.789192F);
      ((Path)localObject2).lineTo(41.977798F, 65.992409F);
      ((Path)localObject2).cubicTo(51.303997F, 69.16349F, 62.08437F, 65.164299F, 67.361F, 56.093422F);
      ((Path)localObject2).lineTo(68.911209F, 53.428516F);
      ((Path)localObject2).lineTo(65.566063F, 51.511677F);
      ((Path)localObject2).lineTo(64.015854F, 54.176582F);
      ((Path)localObject2).cubicTo(59.03817F, 62.733551F, 48.512413F, 65.723717F, 40.710613F, 61.253113F);
      ((Path)localObject2).cubicTo(32.254654F, 56.407665F, 29.600893F, 45.865349F, 34.578579F, 37.30838F);
      ((Path)localObject2).lineTo(36.128788F, 34.643475F);
      ((Path)localObject2).lineTo(36.274845F, 34.194435F);
      ((Path)localObject2).lineTo(32.783642F, 32.726635F);
      ((Path)localObject2).lineTo(31.233435F, 35.391541F);
      ((Path)localObject2).cubicTo(26.03302F, 44.331394F, 27.804018F, 55.403114F, 34.969021F, 61.877071F);
      ((Path)localObject2).lineTo(29.981249F, 70.516144F);
      ((Path)localObject2).lineTo(30.39813F, 75.444328F);
      ((Path)localObject2).cubicTo(30.483181F, 76.449745F, 31.284433F, 76.90377F, 32.189484F, 76.478569F);
      ((Path)localObject2).lineTo(36.665859F, 74.375504F);
      ((Path)localObject2).lineTo(41.623169F, 65.789192F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(63.940453F, 21.108919F);
      ((Path)localObject2).cubicTo(58.015858F, 17.731424F, 50.436932F, 19.741205F, 47.023098F, 25.579679F);
      ((Path)localObject2).lineTo(38.818642F, 39.611271F);
      ((Path)localObject2).cubicTo(35.400043F, 45.457897F, 37.430252F, 52.934784F, 43.356152F, 56.313019F);
      ((Path)localObject2).cubicTo(49.280746F, 59.690514F, 56.859673F, 57.680733F, 60.273506F, 51.842258F);
      ((Path)localObject2).lineTo(68.477959F, 37.810669F);
      ((Path)localObject2).cubicTo(71.896561F, 31.964041F, 69.866356F, 24.487156F, 63.940453F, 21.108919F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-15028967);
      localPaint.setStrokeWidth(3.0F);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(94.5F, 48.0F);
      ((Path)localObject1).cubicTo(94.5F, 22.317848F, 73.681755F, 1.5F, 48.0F, 1.5F);
      ((Path)localObject1).cubicTo(22.318247F, 1.5F, 1.5F, 22.317848F, 1.5F, 48.0F);
      ((Path)localObject1).cubicTo(1.5F, 73.682152F, 22.318247F, 94.5F, 48.0F, 94.5F);
      ((Path)localObject1).cubicTo(73.681755F, 94.5F, 94.5F, 73.682152F, 94.5F, 48.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.fts_setmode_voice_normal
 * JD-Core Version:    0.7.0.1
 */