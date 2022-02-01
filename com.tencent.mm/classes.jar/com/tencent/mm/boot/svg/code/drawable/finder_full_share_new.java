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

public class finder_full_share_new
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
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(13.003701F, 2.998029F);
      ((Path)localObject).cubicTo(13.267266F, 2.998029F, 13.520174F, 3.102082F, 13.707429F, 3.28756F);
      ((Path)localObject).lineTo(20.878723F, 10.3908F);
      ((Path)localObject).cubicTo(21.240923F, 10.74956F, 21.271357F, 11.316653F, 20.968204F, 11.710394F);
      ((Path)localObject).lineTo(20.878723F, 11.811739F);
      ((Path)localObject).lineTo(13.707429F, 18.91498F);
      ((Path)localObject).cubicTo(13.315047F, 19.303637F, 12.68189F, 19.300619F, 12.293232F, 18.908237F);
      ((Path)localObject).cubicTo(12.107754F, 18.720982F, 12.003701F, 18.468075F, 12.003701F, 18.20451F);
      ((Path)localObject).lineTo(12.003701F, 14.921581F);
      ((Path)localObject).cubicTo(9.665079F, 15.109543F, 6.25164F, 16.491343F, 4.475864F, 20.821827F);
      ((Path)localObject).cubicTo(4.180841F, 21.541285F, 3.457108F, 21.535069F, 3.299599F, 20.602539F);
      ((Path)localObject).cubicTo(2.053116F, 13.222767F, 6.25164F, 8.214798F, 12.003701F, 7.308379F);
      ((Path)localObject).lineTo(12.003701F, 3.998029F);
      ((Path)localObject).cubicTo(12.003701F, 3.445745F, 12.451417F, 2.998029F, 13.003701F, 2.998029F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(13.503F, 5.197F);
      ((Path)localObject).lineTo(13.503701F, 8.590516F);
      ((Path)localObject).lineTo(12.237193F, 8.790094F);
      ((Path)localObject).cubicTo(7.838257F, 9.483286F, 4.881491F, 12.737297F, 4.603574F, 17.360922F);
      ((Path)localObject).lineTo(4.593F, 17.554001F);
      ((Path)localObject).lineTo(4.638346F, 17.493921F);
      ((Path)localObject).cubicTo(6.441858F, 15.089221F, 8.94338F, 13.745797F, 11.589006F, 13.454446F);
      ((Path)localObject).lineTo(11.88353F, 13.426402F);
      ((Path)localObject).lineTo(13.503701F, 13.296185F);
      ((Path)localObject).lineTo(13.503F, 17.004999F);
      ((Path)localObject).lineTo(19.465F, 11.101F);
      ((Path)localObject).lineTo(13.503F, 5.197F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_full_share_new
 * JD-Core Version:    0.7.0.1
 */