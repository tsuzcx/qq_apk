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

public class fts_video_icon
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
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.BUTT);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localPaint1.setStrokeMiter(4.0F);
      localPaint1.setPathEffect(null);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localCanvas.save();
      Paint localPaint2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint2.setColor(-420614675);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(12.0F, 0.0F);
      localPath.cubicTo(18.627419F, 0.0F, 24.0F, 5.372582F, 24.0F, 12.0F);
      localPath.cubicTo(24.0F, 18.627419F, 18.627419F, 24.0F, 12.0F, 24.0F);
      localPath.cubicTo(5.372582F, 24.0F, 0.0F, 18.627419F, 0.0F, 12.0F);
      localPath.cubicTo(0.0F, 5.372582F, 5.372582F, 0.0F, 12.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 4.8F, 0.0F, 1.0F, 4.8F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      c.instancePaint(localPaint1, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(5.840879F, 3.047057F);
      ((Path)localObject2).lineTo(11.455324F, 6.5021F);
      ((Path)localObject2).cubicTo(11.793983F, 6.710505F, 11.899573F, 7.153987F, 11.691168F, 7.492644F);
      ((Path)localObject2).cubicTo(11.632097F, 7.588635F, 11.551315F, 7.669417F, 11.455324F, 7.728488F);
      ((Path)localObject2).lineTo(5.840879F, 11.183531F);
      ((Path)localObject2).cubicTo(5.502222F, 11.391936F, 5.05874F, 11.286345F, 4.850336F, 10.947687F);
      ((Path)localObject2).cubicTo(4.780503F, 10.834209F, 4.743529F, 10.70358F, 4.743529F, 10.570337F);
      ((Path)localObject2).lineTo(4.743529F, 3.660251F);
      ((Path)localObject2).cubicTo(4.743529F, 3.262606F, 5.065885F, 2.940251F, 5.46353F, 2.940251F);
      ((Path)localObject2).cubicTo(5.596773F, 2.940251F, 5.727402F, 2.977225F, 5.840879F, 3.047057F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.fts_video_icon
 * JD-Core Version:    0.7.0.1
 */