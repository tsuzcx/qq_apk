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

public class album_ad_link_tag_weapp
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      localPaint.setColor(1275068416);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(34.008598F, 25.981501F);
      ((Path)localObject).lineTo(33.536701F, 25.9891F);
      ((Path)localObject).cubicTo(32.110001F, 25.9891F, 31.2799F, 24.942499F, 31.8162F, 23.735901F);
      ((Path)localObject).cubicTo(32.183498F, 22.878901F, 33.0121F, 22.2171F, 33.9907F, 21.999701F);
      ((Path)localObject).cubicTo(36.608898F, 21.367701F, 38.387901F, 19.3214F, 38.387901F, 16.942499F);
      ((Path)localObject).cubicTo(38.387901F, 14.0583F, 35.634201F, 11.708F, 32.194901F, 11.708F);
      ((Path)localObject).cubicTo(28.755501F, 11.708F, 26.0019F, 14.0583F, 26.0019F, 16.942499F);
      ((Path)localObject).lineTo(26.0019F, 31.3195F);
      ((Path)localObject).cubicTo(26.0019F, 36.383301F, 21.4758F, 40.462002F, 15.901F, 40.462002F);
      ((Path)localObject).cubicTo(10.3261F, 40.462002F, 5.8F, 36.383301F, 5.8F, 31.3195F);
      ((Path)localObject).cubicTo(5.8F, 26.879299F, 9.30469F, 23.0893F, 14.0799F, 22.3687F);
      ((Path)localObject).lineTo(14.4633F, 22.3687F);
      ((Path)localObject).cubicTo(15.5434F, 22.3687F, 16.3214F, 23.015301F, 16.3214F, 23.9387F);
      ((Path)localObject).cubicTo(16.321899F, 24.096901F, 16.318001F, 24.170099F, 16.302401F, 24.2638F);
      ((Path)localObject).cubicTo(16.2813F, 24.3902F, 16.240299F, 24.511101F, 16.1838F, 24.621901F);
      ((Path)localObject).cubicTo(15.8396F, 25.4251F, 14.9595F, 26.1206F, 14.0093F, 26.358101F);
      ((Path)localObject).cubicTo(11.41F, 26.9855F, 9.61214F, 29.0193F, 9.61214F, 31.3195F);
      ((Path)localObject).cubicTo(9.61214F, 34.203602F, 12.3658F, 36.554001F, 15.8051F, 36.554001F);
      ((Path)localObject).cubicTo(19.244499F, 36.554001F, 21.9981F, 34.203602F, 21.9981F, 31.3195F);
      ((Path)localObject).lineTo(21.9981F, 16.942499F);
      ((Path)localObject).cubicTo(21.9981F, 11.8787F, 26.5242F, 7.8F, 32.098999F, 7.8F);
      ((Path)localObject).cubicTo(37.673901F, 7.8F, 42.200001F, 11.8787F, 42.200001F, 16.942499F);
      ((Path)localObject).cubicTo(42.200001F, 21.4062F, 38.777802F, 25.1521F, 34.008598F, 25.981501F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.album_ad_link_tag_weapp
 * JD-Core Version:    0.7.0.1
 */