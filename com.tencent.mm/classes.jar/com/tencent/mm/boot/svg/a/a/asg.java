package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class asg
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.i(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-1);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(24.0F, 0.0F);
      localPath.lineTo(24.0F, 24.0F);
      localPath.lineTo(0.0F, 24.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-2697514);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(7.192773F, 3.993903F);
      ((Path)localObject).lineTo(7.188635F, 3.991586F);
      ((Path)localObject).lineTo(10.872541F, 0.444912F);
      ((Path)localObject).cubicTo(11.48871F, -0.148304F, 12.485069F, -0.148304F, 13.101239F, 0.444912F);
      ((Path)localObject).lineTo(16.785145F, 3.991586F);
      ((Path)localObject).lineTo(12.773489F, 6.238233F);
      ((Path)localObject).cubicTo(12.30153F, 6.515909F, 11.69847F, 6.515909F, 11.200291F, 6.238233F);
      ((Path)localObject).lineTo(7.201767F, 3.99894F);
      ((Path)localObject).lineTo(7.214855F, 8.459637F);
      ((Path)localObject).cubicTo(7.214855F, 9.002367F, 6.913326F, 9.507231F, 6.415146F, 9.784906F);
      ((Path)localObject).lineTo(2.390381F, 12.00631F);
      ((Path)localObject).lineTo(1.053162F, 7.146989F);
      ((Path)localObject).cubicTo(0.8302923F, 6.339206F, 1.328472F, 5.506179F, 2.167511F, 5.291612F);
      ((Path)localObject).lineTo(7.192773F, 3.993903F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(7.201767F, 20.00106F);
      ((Path)localObject).lineTo(11.200291F, 17.761766F);
      ((Path)localObject).cubicTo(11.69847F, 17.484091F, 12.30153F, 17.484091F, 12.786599F, 17.761766F);
      ((Path)localObject).lineTo(16.798254F, 20.008415F);
      ((Path)localObject).lineTo(13.101239F, 23.555088F);
      ((Path)localObject).cubicTo(12.485069F, 24.148304F, 11.48871F, 24.148304F, 10.872541F, 23.555088F);
      ((Path)localObject).lineTo(7.188635F, 20.008415F);
      ((Path)localObject).lineTo(7.192773F, 20.006098F);
      ((Path)localObject).lineTo(2.167511F, 18.708387F);
      ((Path)localObject).cubicTo(1.328472F, 18.49382F, 0.8302923F, 17.660793F, 1.053162F, 16.85301F);
      ((Path)localObject).lineTo(2.403491F, 12.00631F);
      ((Path)localObject).lineTo(6.428256F, 14.227715F);
      ((Path)localObject).cubicTo(6.913326F, 14.492769F, 7.214855F, 14.997633F, 7.214855F, 15.540363F);
      ((Path)localObject).lineTo(7.201767F, 20.00106F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(17.571743F, 14.215094F);
      ((Path)localObject).lineTo(21.59651F, 11.99369F);
      ((Path)localObject).lineTo(22.946838F, 16.840389F);
      ((Path)localObject).cubicTo(23.169708F, 17.648172F, 22.671528F, 18.481199F, 21.832489F, 18.695766F);
      ((Path)localObject).lineTo(16.798254F, 19.995792F);
      ((Path)localObject).lineTo(16.785145F, 15.527741F);
      ((Path)localObject).cubicTo(16.772036F, 14.997633F, 17.073565F, 14.492769F, 17.571743F, 14.215094F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.785145F, 8.459637F);
      ((Path)localObject).lineTo(16.798254F, 3.991586F);
      ((Path)localObject).lineTo(21.832489F, 5.291612F);
      ((Path)localObject).cubicTo(22.671528F, 5.506179F, 23.169708F, 6.339206F, 22.946838F, 7.146989F);
      ((Path)localObject).lineTo(21.59651F, 11.99369F);
      ((Path)localObject).lineTo(17.571743F, 9.772286F);
      ((Path)localObject).cubicTo(17.073565F, 9.507231F, 16.772036F, 9.002367F, 16.785145F, 8.459637F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.asg
 * JD-Core Version:    0.7.0.1
 */