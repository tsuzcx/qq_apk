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

public class finder_live_music_menu
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
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      c.instancePaint((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(24.0F, 0.0F);
      ((Path)localObject2).lineTo(24.0F, 24.0F);
      ((Path)localObject2).lineTo(0.0F, 24.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(6.0F, 17.0F);
      ((Path)localObject1).lineTo(6.0F, 18.4F);
      ((Path)localObject1).lineTo(4.0F, 18.4F);
      ((Path)localObject1).lineTo(4.0F, 17.0F);
      ((Path)localObject1).lineTo(6.0F, 17.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(20.0F, 17.0F);
      ((Path)localObject1).lineTo(20.0F, 18.4F);
      ((Path)localObject1).lineTo(7.6F, 18.4F);
      ((Path)localObject1).lineTo(7.6F, 17.0F);
      ((Path)localObject1).lineTo(20.0F, 17.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(6.0F, 11.0F);
      ((Path)localObject1).lineTo(6.0F, 12.4F);
      ((Path)localObject1).lineTo(4.0F, 12.4F);
      ((Path)localObject1).lineTo(4.0F, 11.0F);
      ((Path)localObject1).lineTo(6.0F, 11.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(20.0F, 11.0F);
      ((Path)localObject1).lineTo(20.0F, 12.4F);
      ((Path)localObject1).lineTo(7.6F, 12.4F);
      ((Path)localObject1).lineTo(7.6F, 11.0F);
      ((Path)localObject1).lineTo(20.0F, 11.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(20.0F, 5.0F);
      ((Path)localObject1).lineTo(20.0F, 6.4F);
      ((Path)localObject1).lineTo(7.6F, 6.399F);
      ((Path)localObject1).lineTo(7.6F, 5.0F);
      ((Path)localObject1).lineTo(20.0F, 5.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(6.0F, 6.399F);
      ((Path)localObject1).lineTo(4.0F, 6.4F);
      ((Path)localObject1).lineTo(4.0F, 5.0F);
      ((Path)localObject1).lineTo(6.0F, 5.0F);
      ((Path)localObject1).lineTo(6.0F, 6.399F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 205, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_live_music_menu
 * JD-Core Version:    0.7.0.1
 */