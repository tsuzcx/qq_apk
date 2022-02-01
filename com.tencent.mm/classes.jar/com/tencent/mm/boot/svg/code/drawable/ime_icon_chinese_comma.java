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

public class ime_icon_chinese_comma
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
      ((Paint)localObject2).setColor(-16579837);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(9.457501F, 19.83F);
      ((Path)localObject1).cubicTo(10.7175F, 19.5F, 11.7675F, 18.84F, 12.5475F, 17.879999F);
      ((Path)localObject1).cubicTo(13.3275F, 16.860001F, 13.7175F, 15.69F, 13.7175F, 14.37F);
      ((Path)localObject1).cubicTo(13.7175F, 13.5F, 13.5075F, 12.81F, 13.1175F, 12.27F);
      ((Path)localObject1).cubicTo(12.6975F, 11.7F, 12.1275F, 11.43F, 11.4675F, 11.43F);
      ((Path)localObject1).cubicTo(10.8675F, 11.43F, 10.4175F, 11.58F, 10.0575F, 11.94F);
      ((Path)localObject1).cubicTo(9.6975F, 12.27F, 9.5175F, 12.72F, 9.5175F, 13.29F);
      ((Path)localObject1).cubicTo(9.5175F, 13.8F, 9.6975F, 14.25F, 10.0575F, 14.61F);
      ((Path)localObject1).cubicTo(10.4175F, 14.97F, 10.8375F, 15.15F, 11.3475F, 15.15F);
      ((Path)localObject1).cubicTo(11.6475F, 15.15F, 11.8875F, 15.09F, 12.0075F, 15.03F);
      ((Path)localObject1).cubicTo(12.0075F, 15.75F, 11.7975F, 16.41F, 11.3475F, 17.040001F);
      ((Path)localObject1).cubicTo(10.8675F, 17.639999F, 10.2375F, 18.09F, 9.457501F, 18.360001F);
      ((Path)localObject1).lineTo(9.457501F, 19.83F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 230, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_icon_chinese_comma
 * JD-Core Version:    0.7.0.1
 */