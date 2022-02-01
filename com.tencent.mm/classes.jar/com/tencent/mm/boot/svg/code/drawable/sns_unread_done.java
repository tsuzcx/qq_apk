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

public class sns_unread_done
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -43.0F, 0.0F, 1.0F, -78.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 43.0F, 0.0F, 1.0F, 78.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      Paint localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(14211288);
      Object localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(48.0F, 0.0F);
      ((Path)localObject3).lineTo(48.0F, 48.0F);
      ((Path)localObject3).lineTo(0.0F, 48.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localObject3 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint2.setColor(14211288);
      ((Paint)localObject3).setColor(1275068416);
      ((Paint)localObject3).setStrokeWidth(3.0F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(24.0F, 4.5F);
      localPath.cubicTo(34.769554F, 4.5F, 43.5F, 13.230447F, 43.5F, 24.0F);
      localPath.cubicTo(43.5F, 34.769554F, 34.769554F, 43.5F, 24.0F, 43.5F);
      localPath.cubicTo(13.230447F, 43.5F, 4.5F, 34.769554F, 4.5F, 24.0F);
      localPath.cubicTo(4.5F, 13.230447F, 13.230447F, 4.5F, 24.0F, 4.5F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint1.setColor(-16777216);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.5F);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 13.0F, 0.0F, 1.0F, 16.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 76, 31);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.92F, 0.0F, 1.0F, 0.8F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(7.612075F, 13.324579F);
      ((Path)localObject2).lineTo(1.668679F, 7.215168F);
      ((Path)localObject2).lineTo(0.48F, 8.43705F);
      ((Path)localObject2).lineTo(6.751941F, 14.884184F);
      ((Path)localObject2).cubicTo(7.214072F, 15.359222F, 7.973798F, 15.369687F, 8.448836F, 14.907557F);
      ((Path)localObject2).cubicTo(8.456735F, 14.899873F, 8.464526F, 14.892081F, 8.47221F, 14.884184F);
      ((Path)localObject2).lineTo(21.48F, 1.513051F);
      ((Path)localObject2).lineTo(21.48F, 1.513051F);
      ((Path)localObject2).lineTo(20.291321F, 0.2911688F);
      ((Path)localObject2).lineTo(7.612075F, 13.324579F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.drawPath((Path)localObject2, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.sns_unread_done
 * JD-Core Version:    0.7.0.1
 */