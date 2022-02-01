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

public class icons_filled_htov
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
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      Paint localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      Object localObject3 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint2.setColor(-1);
      ((Paint)localObject3).setColor(-1);
      ((Paint)localObject3).setStrokeWidth(0.675F);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.83697E-016F, -1.0F, 16.160561F, 1.0F, -1.83697E-016F, -10.608438F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(13.3845F, 4.214215F);
      localPath.lineTo(15.369F, 1.337907F);
      localPath.lineTo(11.4F, 1.337907F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint2.setColor(-1);
      localPaint2.setStrokeWidth(1.575F);
      localObject3 = c.setMatrixFloatArray(arrayOfFloat, 0.9702957F, 0.241922F, -0.879777F, -0.241922F, 0.9702957F, 4.333239F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(19.719938F, 9.55595F);
      ((Path)localObject1).cubicTo(19.827131F, 9.099741F, 19.883839F, 8.624069F, 19.883839F, 8.135153F);
      ((Path)localObject1).cubicTo(19.883839F, 5.230369F, 17.882187F, 2.793094F, 15.182953F, 2.127401F);
      ((Path)localObject1).cubicTo(14.70674F, 2.009956F, 14.538718F, 1.91104F, 14.527783F, 1.951849F);
      localCanvas.drawPath((Path)localObject1, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      ((Paint)localObject1).setStrokeWidth(1.575F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(6.75F, 8.764431F);
      ((Path)localObject2).cubicTo(6.75F, 8.14311F, 7.25368F, 7.639431F, 7.875F, 7.639431F);
      ((Path)localObject2).lineTo(14.85F, 7.639431F);
      ((Path)localObject2).cubicTo(15.471321F, 7.639431F, 15.975F, 8.14311F, 15.975F, 8.764431F);
      ((Path)localObject2).lineTo(15.975F, 20.68943F);
      ((Path)localObject2).cubicTo(15.975F, 21.310751F, 15.471321F, 21.81443F, 14.85F, 21.81443F);
      ((Path)localObject2).lineTo(7.875F, 21.81443F);
      ((Path)localObject2).cubicTo(7.25368F, 21.81443F, 6.75F, 21.310751F, 6.75F, 20.68943F);
      ((Path)localObject2).lineTo(6.75F, 8.764431F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(11.3625F, 17.780001F);
      ((Path)localObject1).cubicTo(11.914785F, 17.780001F, 12.3625F, 18.227716F, 12.3625F, 18.780001F);
      ((Path)localObject1).cubicTo(12.3625F, 19.332285F, 11.914785F, 19.780001F, 11.3625F, 19.780001F);
      ((Path)localObject1).cubicTo(10.810215F, 19.780001F, 10.3625F, 19.332285F, 10.3625F, 18.780001F);
      ((Path)localObject1).cubicTo(10.3625F, 18.227716F, 10.810215F, 17.780001F, 11.3625F, 17.780001F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_htov
 * JD-Core Version:    0.7.0.1
 */