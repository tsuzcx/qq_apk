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

public class biz_finder_play_icon
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
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localCanvas.save();
      localObject = c.instancePaint((Paint)localObject, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(9.524097F, 4.937906F);
      localPath.lineTo(19.616055F, 11.148342F);
      localPath.cubicTo(20.086412F, 11.437793F, 20.233067F, 12.05374F, 19.943617F, 12.524097F);
      localPath.cubicTo(19.861572F, 12.657418F, 19.749376F, 12.769615F, 19.616055F, 12.851658F);
      localPath.lineTo(9.524097F, 19.062094F);
      localPath.cubicTo(9.05374F, 19.351545F, 8.437793F, 19.204891F, 8.148342F, 18.734533F);
      localPath.cubicTo(8.051353F, 18.576925F, 8.0F, 18.395494F, 8.0F, 18.210436F);
      localPath.lineTo(8.0F, 5.789565F);
      localPath.cubicTo(8.0F, 5.23728F, 8.447715F, 4.789565F, 9.0F, 4.789565F);
      localPath.cubicTo(9.18506F, 4.789565F, 9.366489F, 4.840917F, 9.524097F, 4.937906F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(9.524097F, 4.937906F);
      ((Path)localObject).lineTo(19.616055F, 11.148342F);
      ((Path)localObject).cubicTo(20.086412F, 11.437793F, 20.233067F, 12.05374F, 19.943617F, 12.524097F);
      ((Path)localObject).cubicTo(19.861572F, 12.657418F, 19.749376F, 12.769615F, 19.616055F, 12.851658F);
      ((Path)localObject).lineTo(9.524097F, 19.062094F);
      ((Path)localObject).cubicTo(9.05374F, 19.351545F, 8.437793F, 19.204891F, 8.148342F, 18.734533F);
      ((Path)localObject).cubicTo(8.051353F, 18.576925F, 8.0F, 18.395494F, 8.0F, 18.210436F);
      ((Path)localObject).lineTo(8.0F, 5.789565F);
      ((Path)localObject).cubicTo(8.0F, 5.23728F, 8.447715F, 4.789565F, 9.0F, 4.789565F);
      ((Path)localObject).cubicTo(9.18506F, 4.789565F, 9.366489F, 4.840917F, 9.524097F, 4.937906F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.biz_finder_play_icon
 * JD-Core Version:    0.7.0.1
 */