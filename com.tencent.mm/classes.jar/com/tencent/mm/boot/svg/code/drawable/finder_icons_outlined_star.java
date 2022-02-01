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

public class finder_icons_outlined_star
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
      localPaint1.setColor(-436207616);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(13.941434F, 11.280649F);
      ((Path)localObject2).lineTo(17.882868F, 7.438701F);
      ((Path)localObject2).lineTo(12.435941F, 6.647216F);
      ((Path)localObject2).lineTo(10.0F, 1.711462F);
      ((Path)localObject2).lineTo(7.56406F, 6.647216F);
      ((Path)localObject2).lineTo(2.117132F, 7.438701F);
      ((Path)localObject2).lineTo(6.058566F, 11.280649F);
      ((Path)localObject2).lineTo(5.12812F, 16.705568F);
      ((Path)localObject2).lineTo(10.0F, 14.144269F);
      ((Path)localObject2).lineTo(14.871881F, 16.705568F);
      ((Path)localObject2).lineTo(13.941434F, 11.280649F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(10.0F, 15.5F);
      ((Path)localObject2).lineTo(5.327835F, 17.956303F);
      ((Path)localObject2).cubicTo(4.83899F, 18.213305F, 4.234363F, 18.025356F, 3.977362F, 17.536512F);
      ((Path)localObject2).cubicTo(3.875023F, 17.341852F, 3.839708F, 17.118883F, 3.876885F, 16.902126F);
      ((Path)localObject2).lineTo(4.769189F, 11.699594F);
      ((Path)localObject2).lineTo(0.9893278F, 8.01514F);
      ((Path)localObject2).cubicTo(0.5938442F, 7.629638F, 0.5857519F, 6.996525F, 0.971253F, 6.601041F);
      ((Path)localObject2).cubicTo(1.124762F, 6.443558F, 1.325904F, 6.34107F, 1.543541F, 6.309446F);
      ((Path)localObject2).lineTo(6.767181F, 5.550407F);
      ((Path)localObject2).lineTo(9.103264F, 0.8169857F);
      ((Path)localObject2).cubicTo(9.347686F, 0.321732F, 9.947312F, 0.1183931F, 10.442566F, 0.3628154F);
      ((Path)localObject2).cubicTo(10.639778F, 0.4601456F, 10.799406F, 0.6197732F, 10.896736F, 0.8169857F);
      ((Path)localObject2).lineTo(13.232819F, 5.550407F);
      ((Path)localObject2).lineTo(18.456459F, 6.309446F);
      ((Path)localObject2).cubicTo(19.003004F, 6.388864F, 19.381685F, 6.896307F, 19.302267F, 7.442851F);
      ((Path)localObject2).cubicTo(19.270643F, 7.660488F, 19.168156F, 7.86163F, 19.010672F, 8.01514F);
      ((Path)localObject2).lineTo(15.230811F, 11.699594F);
      ((Path)localObject2).lineTo(16.123116F, 16.902126F);
      ((Path)localObject2).cubicTo(16.216476F, 17.446463F, 15.850888F, 17.963419F, 15.306552F, 18.05678F);
      ((Path)localObject2).cubicTo(15.089794F, 18.093956F, 14.866826F, 18.058641F, 14.672166F, 17.956303F);
      ((Path)localObject2).lineTo(10.0F, 15.5F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_icons_outlined_star
 * JD-Core Version:    0.7.0.1
 */