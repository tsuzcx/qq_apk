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

public class icons_filled_vr
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
      localCanvas.saveLayerAlpha(null, 230, 31);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(19.0F, 2.5F);
      ((Path)localObject).cubicTo(19.552284F, 2.5F, 20.0F, 2.947715F, 20.0F, 3.5F);
      ((Path)localObject).lineTo(20.0F, 20.5F);
      ((Path)localObject).cubicTo(20.0F, 21.052284F, 19.552284F, 21.5F, 19.0F, 21.5F);
      ((Path)localObject).lineTo(5.0F, 21.5F);
      ((Path)localObject).cubicTo(4.447715F, 21.5F, 4.0F, 21.052284F, 4.0F, 20.5F);
      ((Path)localObject).lineTo(4.0F, 3.5F);
      ((Path)localObject).cubicTo(4.0F, 2.947715F, 4.447715F, 2.5F, 5.0F, 2.5F);
      ((Path)localObject).lineTo(19.0F, 2.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(7.450858F, 8.75F);
      ((Path)localObject).lineTo(6.0F, 8.75F);
      ((Path)localObject).lineTo(8.115444F, 15.5F);
      ((Path)localObject).lineTo(9.762871F, 15.5F);
      ((Path)localObject).lineTo(11.887675F, 8.75F);
      ((Path)localObject).lineTo(10.48362F, 8.75F);
      ((Path)localObject).lineTo(9.585023F, 12.033784F);
      ((Path)localObject).cubicTo(9.369735F, 12.781756F, 9.210609F, 13.456757F, 8.995319F, 14.213851F);
      ((Path)localObject).lineTo(8.948518F, 14.213851F);
      ((Path)localObject).cubicTo(8.723869F, 13.456757F, 8.583464F, 12.781756F, 8.368175F, 12.033784F);
      ((Path)localObject).lineTo(7.450858F, 8.75F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(15.098284F, 8.75F);
      ((Path)localObject).lineTo(12.683308F, 8.75F);
      ((Path)localObject).lineTo(12.683308F, 15.5F);
      ((Path)localObject).lineTo(14.068643F, 15.5F);
      ((Path)localObject).lineTo(14.068643F, 12.945946F);
      ((Path)localObject).lineTo(15.032762F, 12.945946F);
      ((Path)localObject).lineTo(16.455538F, 15.5F);
      ((Path)localObject).lineTo(18.0F, 15.5F);
      ((Path)localObject).lineTo(16.380655F, 12.736149F);
      ((Path)localObject).cubicTo(17.176287F, 12.435135F, 17.700468F, 11.805743F, 17.700468F, 10.793243F);
      ((Path)localObject).cubicTo(17.700468F, 9.242568F, 16.549143F, 8.75F, 15.098284F, 8.75F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.967238F, 9.817229F);
      ((Path)localObject).cubicTo(15.856474F, 9.817229F, 16.343214F, 10.063514F, 16.343214F, 10.793243F);
      ((Path)localObject).cubicTo(16.343214F, 11.513851F, 15.856474F, 11.878716F, 14.967238F, 11.878716F);
      ((Path)localObject).lineTo(14.068643F, 11.878716F);
      ((Path)localObject).lineTo(14.068643F, 9.817229F);
      ((Path)localObject).lineTo(14.967238F, 9.817229F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_vr
 * JD-Core Version:    0.7.0.1
 */