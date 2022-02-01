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

public class icons_filled_ban_comment_off
  extends c
{
  private final int height = 20;
  private final int width = 20;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 20;
      return 20;
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(3.443095F, 5.211209F);
      ((Path)localObject).lineTo(14.021553F, 15.788755F);
      ((Path)localObject).cubicTo(12.829179F, 16.348253F, 11.458336F, 16.666666F, 10.0F, 16.666666F);
      ((Path)localObject).cubicTo(9.193584F, 16.666666F, 8.41392F, 16.569304F, 7.676393F, 16.387651F);
      ((Path)localObject).lineTo(7.311212F, 16.289864F);
      ((Path)localObject).lineTo(4.825418F, 17.481827F);
      ((Path)localObject).cubicTo(4.754461F, 17.515852F, 4.675319F, 17.529087F, 4.597153F, 17.52F);
      ((Path)localObject).cubicTo(4.397145F, 17.496752F, 4.246765F, 17.335484F, 4.230095F, 17.142401F);
      ((Path)localObject).lineTo(4.231382F, 17.058012F);
      ((Path)localObject).lineTo(4.483131F, 14.892278F);
      ((Path)localObject).cubicTo(2.755832F, 13.594444F, 1.666667F, 11.697003F, 1.666667F, 9.583333F);
      ((Path)localObject).cubicTo(1.666667F, 7.933424F, 2.330318F, 6.415267F, 3.443095F, 5.211209F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(3.767767F, 2.0F);
      ((Path)localObject).lineTo(5.428408F, 3.660069F);
      ((Path)localObject).cubicTo(6.740953F, 2.926673F, 8.311856F, 2.5F, 10.0F, 2.5F);
      ((Path)localObject).cubicTo(14.602373F, 2.5F, 18.333334F, 5.671316F, 18.333334F, 9.583333F);
      ((Path)localObject).cubicTo(18.333334F, 11.43012F, 17.50185F, 13.111835F, 16.139734F, 14.372758F);
      ((Path)localObject).lineTo(17.909903F, 16.142136F);
      ((Path)localObject).lineTo(17.02602F, 17.02602F);
      ((Path)localObject).lineTo(15.151068F, 15.151761F);
      ((Path)localObject).lineTo(2.883884F, 2.883884F);
      ((Path)localObject).lineTo(3.767767F, 2.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_ban_comment_off
 * JD-Core Version:    0.7.0.1
 */