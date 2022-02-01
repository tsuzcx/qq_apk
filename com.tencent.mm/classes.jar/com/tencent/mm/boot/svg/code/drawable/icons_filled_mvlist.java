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

public class icons_filled_mvlist
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(15.75F, 14.685259F);
      ((Path)localObject).cubicTo(15.794264F, 14.685259F, 15.837733F, 14.697011F, 15.875968F, 14.719315F);
      ((Path)localObject).lineTo(21.129808F, 17.784056F);
      ((Path)localObject).cubicTo(21.249071F, 17.853626F, 21.289356F, 18.006704F, 21.219786F, 18.125967F);
      ((Path)localObject).cubicTo(21.198057F, 18.163219F, 21.167061F, 18.194216F, 21.129808F, 18.215944F);
      ((Path)localObject).lineTo(15.875968F, 21.280685F);
      ((Path)localObject).cubicTo(15.756704F, 21.350256F, 15.603625F, 21.309971F, 15.534056F, 21.190708F);
      ((Path)localObject).cubicTo(15.511752F, 21.152475F, 15.5F, 21.109005F, 15.5F, 21.064741F);
      ((Path)localObject).lineTo(15.5F, 14.935259F);
      ((Path)localObject).cubicTo(15.5F, 14.797188F, 15.611929F, 14.685259F, 15.75F, 14.685259F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 16.5F);
      ((Path)localObject).cubicTo(12.552284F, 16.5F, 13.0F, 16.947716F, 13.0F, 17.5F);
      ((Path)localObject).cubicTo(13.0F, 18.052284F, 12.552284F, 18.5F, 12.0F, 18.5F);
      ((Path)localObject).lineTo(4.0F, 18.5F);
      ((Path)localObject).cubicTo(3.447715F, 18.5F, 3.0F, 18.052284F, 3.0F, 17.5F);
      ((Path)localObject).cubicTo(3.0F, 16.947716F, 3.447715F, 16.5F, 4.0F, 16.5F);
      ((Path)localObject).lineTo(12.0F, 16.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.0F, 10.5F);
      ((Path)localObject).cubicTo(20.552284F, 10.5F, 21.0F, 10.947716F, 21.0F, 11.5F);
      ((Path)localObject).cubicTo(21.0F, 12.052284F, 20.552284F, 12.5F, 20.0F, 12.5F);
      ((Path)localObject).lineTo(4.0F, 12.5F);
      ((Path)localObject).cubicTo(3.447715F, 12.5F, 3.0F, 12.052284F, 3.0F, 11.5F);
      ((Path)localObject).cubicTo(3.0F, 10.947716F, 3.447715F, 10.5F, 4.0F, 10.5F);
      ((Path)localObject).lineTo(20.0F, 10.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.0F, 4.5F);
      ((Path)localObject).cubicTo(20.552284F, 4.5F, 21.0F, 4.947715F, 21.0F, 5.5F);
      ((Path)localObject).cubicTo(21.0F, 6.052285F, 20.552284F, 6.5F, 20.0F, 6.5F);
      ((Path)localObject).lineTo(4.0F, 6.5F);
      ((Path)localObject).cubicTo(3.447715F, 6.5F, 3.0F, 6.052285F, 3.0F, 5.5F);
      ((Path)localObject).cubicTo(3.0F, 4.947715F, 3.447715F, 4.5F, 4.0F, 4.5F);
      ((Path)localObject).lineTo(20.0F, 4.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_mvlist
 * JD-Core Version:    0.7.0.1
 */