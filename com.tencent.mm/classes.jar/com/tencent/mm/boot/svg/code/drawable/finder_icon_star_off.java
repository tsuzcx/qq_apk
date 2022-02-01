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

public class finder_icon_star_off
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
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -64.0F, 0.0F, 1.0F, -95.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 64.0F, 0.0F, 1.0F, 95.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localPaint2.setColor(419430400);
      localPaint2.setStrokeWidth(0.5F);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.25F, 0.25F);
      ((Path)localObject1).lineTo(23.75F, 0.25F);
      ((Path)localObject1).lineTo(23.75F, 23.75F);
      ((Path)localObject1).lineTo(0.25F, 23.75F);
      ((Path)localObject1).lineTo(0.25F, 0.25F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.drawPath((Path)localObject1, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(12.442566F, 3.362815F);
      ((Path)localObject1).cubicTo(12.639778F, 3.460146F, 12.799406F, 3.619773F, 12.896736F, 3.816986F);
      ((Path)localObject1).lineTo(15.232819F, 8.550407F);
      ((Path)localObject1).lineTo(20.456459F, 9.309445F);
      ((Path)localObject1).cubicTo(21.003004F, 9.388864F, 21.381685F, 9.896306F, 21.302267F, 10.442851F);
      ((Path)localObject1).cubicTo(21.270643F, 10.660488F, 21.168156F, 10.86163F, 21.010672F, 11.01514F);
      ((Path)localObject1).lineTo(17.23081F, 14.699594F);
      ((Path)localObject1).lineTo(17.712339F, 17.513329F);
      ((Path)localObject1).lineTo(21.426451F, 21.227922F);
      ((Path)localObject1).lineTo(20.577923F, 22.07645F);
      ((Path)localObject1).lineTo(18.064339F, 19.563328F);
      ((Path)localObject1).lineTo(18.064339F, 19.565329F);
      ((Path)localObject1).lineTo(16.595339F, 18.096329F);
      ((Path)localObject1).lineTo(16.595339F, 18.094328F);
      ((Path)localObject1).lineTo(8.327339F, 9.826328F);
      ((Path)localObject1).lineTo(8.325339F, 9.826328F);
      ((Path)localObject1).lineTo(7.267339F, 8.768329F);
      ((Path)localObject1).lineTo(7.269339F, 8.768329F);
      ((Path)localObject1).lineTo(3.85F, 5.348528F);
      ((Path)localObject1).lineTo(4.698528F, 4.5F);
      ((Path)localObject1).lineTo(8.751339F, 8.552328F);
      ((Path)localObject1).lineTo(8.767181F, 8.550407F);
      ((Path)localObject1).lineTo(11.103264F, 3.816986F);
      ((Path)localObject1).cubicTo(11.347686F, 3.321732F, 11.947312F, 3.118393F, 12.442566F, 3.362815F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(5.784339F, 8.983329F);
      ((Path)localObject1).lineTo(6.843339F, 10.042329F);
      ((Path)localObject1).lineTo(4.117132F, 10.438701F);
      ((Path)localObject1).lineTo(8.058566F, 14.280649F);
      ((Path)localObject1).lineTo(7.12812F, 19.705568F);
      ((Path)localObject1).lineTo(12.0F, 17.14427F);
      ((Path)localObject1).lineTo(16.101339F, 19.300329F);
      ((Path)localObject1).lineTo(17.699617F, 20.898529F);
      ((Path)localObject1).cubicTo(17.584959F, 20.97653F, 17.45215F, 21.031807F, 17.306551F, 21.05678F);
      ((Path)localObject1).cubicTo(17.089794F, 21.093956F, 16.866827F, 21.058641F, 16.672165F, 20.956303F);
      ((Path)localObject1).lineTo(12.0F, 18.5F);
      ((Path)localObject1).lineTo(7.327835F, 20.956303F);
      ((Path)localObject1).cubicTo(6.83899F, 21.213305F, 6.234363F, 21.025356F, 5.977362F, 20.536512F);
      ((Path)localObject1).cubicTo(5.875023F, 20.341852F, 5.839708F, 20.118883F, 5.876885F, 19.902126F);
      ((Path)localObject1).lineTo(6.769189F, 14.699594F);
      ((Path)localObject1).lineTo(2.989328F, 11.01514F);
      ((Path)localObject1).cubicTo(2.593844F, 10.629638F, 2.585752F, 9.996525F, 2.971253F, 9.601041F);
      ((Path)localObject1).cubicTo(3.124762F, 9.443558F, 3.325904F, 9.34107F, 3.543541F, 9.309445F);
      ((Path)localObject1).lineTo(5.784339F, 8.983329F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(12.0F, 4.711462F);
      ((Path)localObject1).lineTo(9.656339F, 9.457329F);
      ((Path)localObject1).lineTo(16.24334F, 16.044329F);
      ((Path)localObject1).lineTo(15.941434F, 14.280649F);
      ((Path)localObject1).lineTo(19.882868F, 10.438701F);
      ((Path)localObject1).lineTo(14.435941F, 9.647216F);
      ((Path)localObject1).lineTo(12.0F, 4.711462F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_icon_star_off
 * JD-Core Version:    0.7.0.1
 */