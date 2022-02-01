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

public class default_round_avatar
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -24.0F, 0.0F, 1.0F, -91.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 91.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-1184275);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(16.0F, 0.0F);
      localPath.cubicTo(24.836555F, -1.623249E-015F, 32.0F, 7.163444F, 32.0F, 16.0F);
      localPath.cubicTo(32.0F, 24.836555F, 24.836555F, 32.0F, 16.0F, 32.0F);
      localPath.cubicTo(7.163444F, 32.0F, 1.082166E-015F, 24.836555F, 0.0F, 16.0F);
      localPath.cubicTo(-1.082166E-015F, 7.163444F, 7.163444F, 1.623249E-015F, 16.0F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(637534208);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 5.6F, 0.0F, 1.0F, 5.6F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(2.166667F, 17.933332F);
      ((Path)localObject2).lineTo(2.166667F, 16.740068F);
      ((Path)localObject2).lineTo(2.166667F, 16.740068F);
      ((Path)localObject2).cubicTo(2.166667F, 16.146324F, 2.598398F, 15.45432F, 3.132218F, 15.193822F);
      ((Path)localObject2).lineTo(8.037857F, 12.799924F);
      ((Path)localObject2).cubicTo(8.749327F, 12.452735F, 8.914758F, 11.683761F, 8.400986F, 11.074821F);
      ((Path)localObject2).lineTo(8.087658F, 10.703453F);
      ((Path)localObject2).cubicTo(7.450142F, 9.947847F, 6.933333F, 8.53623F, 6.933333F, 7.548052F);
      ((Path)localObject2).lineTo(6.933333F, 6.066303F);
      ((Path)localObject2).cubicTo(6.933333F, 4.151917F, 8.489308F, 2.6F, 10.4F, 2.6F);
      ((Path)localObject2).cubicTo(12.314587F, 2.6F, 13.866667F, 4.153916F, 13.866667F, 6.066846F);
      ((Path)localObject2).lineTo(13.866667F, 7.548828F);
      ((Path)localObject2).cubicTo(13.866667F, 8.536057F, 13.347475F, 9.951813F, 12.712342F, 10.704697F);
      ((Path)localObject2).lineTo(12.399014F, 11.076115F);
      ((Path)localObject2).cubicTo(11.888095F, 11.681757F, 12.047696F, 12.452611F, 12.762142F, 12.801109F);
      ((Path)localObject2).lineTo(17.667782F, 15.194016F);
      ((Path)localObject2).cubicTo(18.201042F, 15.454133F, 18.633333F, 16.141813F, 18.633333F, 16.740068F);
      ((Path)localObject2).lineTo(18.633333F, 17.933332F);
      ((Path)localObject2).cubicTo(18.633333F, 18.080608F, 18.513943F, 18.200001F, 18.366667F, 18.200001F);
      ((Path)localObject2).lineTo(2.433333F, 18.200001F);
      ((Path)localObject2).cubicTo(2.286058F, 18.200001F, 2.166667F, 18.080608F, 2.166667F, 17.933332F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.default_round_avatar
 * JD-Core Version:    0.7.0.1
 */