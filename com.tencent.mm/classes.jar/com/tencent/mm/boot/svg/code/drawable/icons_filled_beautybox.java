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

public class icons_filled_beautybox
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
      Matrix localMatrix = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.instancePaint((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 230, 31);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, -1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues((float[])localObject2);
      localCanvas.concat(localMatrix);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -3.0F, 0.0F, 1.0F, -7.0F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues((float[])localObject2);
      localCanvas.concat(localMatrix);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject3 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.176129F, 0.0F, 1.0F, 3.770538F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues((float[])localObject3);
      localCanvas.concat(localMatrix);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 0.7071068F, -0.7071068F, 16.63875F, 0.7071068F, 0.7071068F, 1.910244F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues((float[])localObject3);
      localCanvas.concat(localMatrix);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(5.113539F, 18.737814F);
      localPath.lineTo(5.990232F, 18.262329F);
      localPath.lineTo(6.913476F, 18.752909F);
      localPath.lineTo(6.913476F, 23.417412F);
      localPath.cubicTo(6.913476F, 23.638325F, 6.73439F, 23.817411F, 6.513476F, 23.817411F);
      localPath.cubicTo(6.512358F, 23.817411F, 6.51124F, 23.817406F, 6.510121F, 23.817396F);
      localPath.lineTo(5.510185F, 23.809011F);
      localPath.cubicTo(5.290587F, 23.807169F, 5.113539F, 23.62863F, 5.113539F, 23.409025F);
      localPath.lineTo(5.113539F, 18.737814F);
      localPath.lineTo(5.113539F, 18.737814F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localObject2 = c.setMatrixFloatArray((float[])localObject3, 0.7071068F, -0.7071068F, 13.542466F, 0.7071068F, 0.7071068F, -5.564915F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues((float[])localObject2);
      localCanvas.concat(localMatrix);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(13.488614F, 19.899393F);
      ((Path)localObject3).lineTo(8.816449F, 22.355698F);
      ((Path)localObject3).cubicTo(8.327604F, 22.612698F, 7.722977F, 22.424751F, 7.465976F, 21.935907F);
      ((Path)localObject3).cubicTo(7.363637F, 21.741245F, 7.328322F, 21.518278F, 7.3655F, 21.301521F);
      ((Path)localObject3).lineTo(8.257804F, 16.098988F);
      ((Path)localObject3).lineTo(4.477942F, 12.414534F);
      ((Path)localObject3).cubicTo(4.082459F, 12.029032F, 4.074366F, 11.395919F, 4.459868F, 11.000435F);
      ((Path)localObject3).cubicTo(4.613376F, 10.842952F, 4.814519F, 10.740464F, 5.032156F, 10.70884F);
      ((Path)localObject3).lineTo(10.255795F, 9.949801F);
      ((Path)localObject3).lineTo(12.591878F, 5.21638F);
      ((Path)localObject3).cubicTo(12.836301F, 4.721126F, 13.435926F, 4.517787F, 13.93118F, 4.762209F);
      ((Path)localObject3).cubicTo(14.128392F, 4.85954F, 14.28802F, 5.019167F, 14.38535F, 5.21638F);
      ((Path)localObject3).lineTo(16.721434F, 9.949801F);
      ((Path)localObject3).lineTo(21.945074F, 10.70884F);
      ((Path)localObject3).cubicTo(22.491617F, 10.788258F, 22.8703F, 11.2957F, 22.790882F, 11.842245F);
      ((Path)localObject3).cubicTo(22.759258F, 12.059882F, 22.656771F, 12.261024F, 22.499287F, 12.414534F);
      ((Path)localObject3).lineTo(18.719425F, 16.098988F);
      ((Path)localObject3).lineTo(19.611729F, 21.301521F);
      ((Path)localObject3).cubicTo(19.70509F, 21.845858F, 19.339502F, 22.362812F, 18.795166F, 22.456173F);
      ((Path)localObject3).cubicTo(18.578409F, 22.493351F, 18.35544F, 22.458036F, 18.16078F, 22.355698F);
      ((Path)localObject3).lineTo(13.488614F, 19.899393F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.setMatrixFloatArray((float[])localObject2, 0.7071068F, -0.7071068F, 17.0F, 0.7071068F, 0.7071068F, 0.02943802F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues((float[])localObject1);
      localCanvas.concat(localMatrix);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_beautybox
 * JD-Core Version:    0.7.0.1
 */