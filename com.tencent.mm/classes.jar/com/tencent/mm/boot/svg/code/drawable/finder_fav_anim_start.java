package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class finder_fav_anim_start
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
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 18.5F);
      ((Path)localObject).lineTo(7.327835F, 20.956303F);
      ((Path)localObject).cubicTo(6.83899F, 21.213305F, 6.234363F, 21.025356F, 5.977362F, 20.536512F);
      ((Path)localObject).cubicTo(5.875023F, 20.341852F, 5.839708F, 20.118883F, 5.876885F, 19.902126F);
      ((Path)localObject).lineTo(6.769189F, 14.699594F);
      ((Path)localObject).lineTo(2.989328F, 11.01514F);
      ((Path)localObject).cubicTo(2.593844F, 10.629638F, 2.585752F, 9.996525F, 2.971253F, 9.601041F);
      ((Path)localObject).cubicTo(3.124762F, 9.443558F, 3.325904F, 9.34107F, 3.543541F, 9.309445F);
      ((Path)localObject).lineTo(8.767181F, 8.550407F);
      ((Path)localObject).lineTo(11.103264F, 3.816986F);
      ((Path)localObject).cubicTo(11.347686F, 3.321732F, 11.947312F, 3.118393F, 12.442566F, 3.362815F);
      ((Path)localObject).cubicTo(12.639778F, 3.460146F, 12.799406F, 3.619773F, 12.896736F, 3.816986F);
      ((Path)localObject).lineTo(15.232819F, 8.550407F);
      ((Path)localObject).lineTo(20.456459F, 9.309445F);
      ((Path)localObject).cubicTo(21.003004F, 9.388864F, 21.381685F, 9.896306F, 21.302267F, 10.442851F);
      ((Path)localObject).cubicTo(21.270643F, 10.660488F, 21.168156F, 10.86163F, 21.010672F, 11.01514F);
      ((Path)localObject).lineTo(17.23081F, 14.699594F);
      ((Path)localObject).lineTo(18.123116F, 19.902126F);
      ((Path)localObject).cubicTo(18.216476F, 20.446463F, 17.850889F, 20.963419F, 17.306551F, 21.05678F);
      ((Path)localObject).cubicTo(17.089794F, 21.093956F, 16.866827F, 21.058641F, 16.672165F, 20.956303F);
      ((Path)localObject).lineTo(12.0F, 18.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_fav_anim_start
 * JD-Core Version:    0.7.0.1
 */