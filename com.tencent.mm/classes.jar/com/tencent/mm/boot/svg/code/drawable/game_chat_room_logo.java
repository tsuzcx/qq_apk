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

public class game_chat_room_logo
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-15683857);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(20.000099F, 12.6667F);
      ((Path)localObject).cubicTo(20.000099F, 16.716801F, 16.716801F, 20.0F, 12.6667F, 20.0F);
      ((Path)localObject).cubicTo(12.4514F, 20.0F, 12.2382F, 19.9907F, 12.0276F, 19.9725F);
      ((Path)localObject).cubicTo(12.0094F, 19.7619F, 12.0001F, 19.5487F, 12.0001F, 19.3333F);
      ((Path)localObject).cubicTo(12.0001F, 15.2832F, 15.2833F, 12.0F, 19.333401F, 12.0F);
      ((Path)localObject).cubicTo(19.5488F, 12.0F, 19.761999F, 12.0093F, 19.972601F, 12.0275F);
      ((Path)localObject).cubicTo(19.990801F, 12.2381F, 20.000099F, 12.4513F, 20.000099F, 12.6667F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(19.200899F, 9.33419F);
      ((Path)localObject).cubicTo(13.7832F, 9.40455F, 9.40463F, 13.7832F, 9.33428F, 19.2008F);
      ((Path)localObject).cubicTo(6.95936F, 17.9872F, 5.33341F, 15.5168F, 5.33341F, 12.6667F);
      ((Path)localObject).cubicTo(5.33341F, 8.61658F, 8.61666F, 5.33333F, 12.6667F, 5.33333F);
      ((Path)localObject).cubicTo(15.5169F, 5.33333F, 17.987301F, 6.95927F, 19.200899F, 9.33419F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(22.2383F, 9.76178F);
      ((Path)localObject).cubicTo(20.993799F, 5.65564F, 17.1793F, 2.66666F, 12.6667F, 2.66666F);
      ((Path)localObject).cubicTo(7.1439F, 2.66666F, 2.66675F, 7.14382F, 2.66675F, 12.6667F);
      ((Path)localObject).cubicTo(2.66675F, 17.179199F, 5.65572F, 20.9937F, 9.76187F, 22.238199F);
      ((Path)localObject).cubicTo(11.0064F, 26.3444F, 14.8209F, 29.3333F, 19.333401F, 29.3333F);
      ((Path)localObject).cubicTo(24.8563F, 29.3333F, 29.333401F, 24.856199F, 29.333401F, 19.3333F);
      ((Path)localObject).cubicTo(29.333401F, 14.8208F, 26.3444F, 11.0063F, 22.2383F, 9.76178F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(22.665899F, 12.7992F);
      ((Path)localObject).cubicTo(22.595501F, 18.216801F, 18.2169F, 22.5954F, 12.7993F, 22.6658F);
      ((Path)localObject).cubicTo(14.0129F, 25.040701F, 16.483299F, 26.6667F, 19.333401F, 26.6667F);
      ((Path)localObject).cubicTo(23.383499F, 26.6667F, 26.6667F, 23.3834F, 26.6667F, 19.3333F);
      ((Path)localObject).cubicTo(26.6667F, 16.4832F, 25.0408F, 14.0128F, 22.665899F, 12.7992F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.game_chat_room_logo
 * JD-Core Version:    0.7.0.1
 */