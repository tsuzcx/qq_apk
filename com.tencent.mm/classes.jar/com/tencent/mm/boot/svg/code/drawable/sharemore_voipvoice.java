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

public class sharemore_voipvoice
  extends c
{
  private final int height = 54;
  private final int width = 54;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 54;
      return 54;
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
      localPaint.setColor(-8683387);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(22.908676F, 30.950693F);
      ((Path)localObject).cubicTo(27.023159F, 35.1021F, 30.232687F, 36.895073F, 32.456608F, 36.895073F);
      ((Path)localObject).cubicTo(34.680527F, 36.895073F, 37.381214F, 34.497978F, 39.075436F, 34.455441F);
      ((Path)localObject).cubicTo(40.475136F, 34.420296F, 45.419086F, 37.832767F, 45.94186F, 38.324558F);
      ((Path)localObject).cubicTo(46.464634F, 38.816353F, 47.099957F, 39.55505F, 46.986763F, 40.054779F);
      ((Path)localObject).cubicTo(46.873569F, 40.554508F, 44.113312F, 47.862286F, 38.140881F, 46.915455F);
      ((Path)localObject).cubicTo(32.168449F, 45.968628F, 23.842045F, 39.472462F, 19.097456F, 34.797325F);
      ((Path)localObject).lineTo(22.908676F, 30.950693F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.985262F, 21.787113F);
      ((Path)localObject).cubicTo(17.054878F, 19.63332F, 19.520647F, 16.662056F, 19.493423F, 14.951664F);
      ((Path)localObject).cubicTo(19.463087F, 13.04565F, 16.725452F, 8.970869F, 15.613527F, 7.997586F);
      ((Path)localObject).cubicTo(14.5016F, 7.024304F, 14.318393F, 6.923723F, 13.703174F, 7.037072F);
      ((Path)localObject).cubicTo(13.087955F, 7.150421F, 6.148705F, 9.55696F, 7.087112F, 15.582992F);
      ((Path)localObject).cubicTo(8.025518F, 21.609024F, 14.463901F, 30.010153F, 19.097456F, 34.797325F);
      ((Path)localObject).lineTo(22.911219F, 30.946669F);
      ((Path)localObject).cubicTo(18.796738F, 26.795259F, 16.915646F, 23.940908F, 16.985262F, 21.787113F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.sharemore_voipvoice
 * JD-Core Version:    0.7.0.1
 */