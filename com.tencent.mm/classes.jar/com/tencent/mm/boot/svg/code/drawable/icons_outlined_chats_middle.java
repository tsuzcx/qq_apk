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

public class icons_outlined_chats_middle
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      localPaint.setColor(-16726153);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(26.002359F, 54.803513F);
      ((Path)localObject).lineTo(27.321718F, 55.185577F);
      ((Path)localObject).cubicTo(30.085625F, 55.985954F, 33.006626F, 56.400002F, 36.0F, 56.400002F);
      ((Path)localObject).cubicTo(50.698292F, 56.400002F, 62.400002F, 46.453548F, 62.400002F, 34.5F);
      ((Path)localObject).cubicTo(62.400002F, 22.546453F, 50.698292F, 12.6F, 36.0F, 12.6F);
      ((Path)localObject).cubicTo(21.30171F, 12.6F, 9.6F, 22.546453F, 9.6F, 34.5F);
      ((Path)localObject).cubicTo(9.6F, 40.727772F, 12.770791F, 46.578289F, 18.301785F, 50.734089F);
      ((Path)localObject).lineTo(19.953779F, 51.975342F);
      ((Path)localObject).lineTo(19.248581F, 58.042023F);
      ((Path)localObject).lineTo(26.002359F, 54.803513F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 60.0F);
      ((Path)localObject).cubicTo(32.613049F, 60.0F, 29.357191F, 59.522919F, 26.320362F, 58.643509F);
      ((Path)localObject).lineTo(17.371504F, 62.934578F);
      ((Path)localObject).cubicTo(17.116058F, 63.057068F, 16.831148F, 63.104713F, 16.549749F, 63.072006F);
      ((Path)localObject).cubicTo(15.726863F, 62.976353F, 15.137323F, 62.231728F, 15.232977F, 61.40884F);
      ((Path)localObject).lineTo(16.139269F, 53.612202F);
      ((Path)localObject).cubicTo(9.920994F, 48.939999F, 6.0F, 42.109215F, 6.0F, 34.5F);
      ((Path)localObject).cubicTo(6.0F, 20.416739F, 19.431458F, 9.0F, 36.0F, 9.0F);
      ((Path)localObject).cubicTo(52.568542F, 9.0F, 66.0F, 20.416739F, 66.0F, 34.5F);
      ((Path)localObject).cubicTo(66.0F, 48.58326F, 52.568542F, 60.0F, 36.0F, 60.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_chats_middle
 * JD-Core Version:    0.7.0.1
 */