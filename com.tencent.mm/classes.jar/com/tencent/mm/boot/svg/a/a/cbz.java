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

public final class cbz
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      localPaint = c.a((Paint)localObject, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 230, 31);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(3.6F);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(6.6F, 16.200001F);
      localPath.cubicTo(6.6F, 13.549034F, 8.749033F, 11.4F, 11.4F, 11.4F);
      localPath.lineTo(60.600002F, 11.4F);
      localPath.cubicTo(63.250969F, 11.4F, 65.400002F, 13.549034F, 65.400002F, 16.200001F);
      localPath.lineTo(65.400002F, 55.799999F);
      localPath.cubicTo(65.400002F, 58.450966F, 63.250969F, 60.599998F, 60.600002F, 60.599998F);
      localPath.lineTo(11.4F, 60.599998F);
      localPath.cubicTo(8.749033F, 60.599998F, 6.6F, 58.450966F, 6.6F, 55.799999F);
      localPath.lineTo(6.6F, 16.200001F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(21.450001F, 27.75F);
      localPath.lineTo(29.85F, 35.941792F);
      localPath.lineTo(21.450001F, 44.549999F);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(34.650002F, 43.349998F);
      ((Path)localObject).lineTo(51.450001F, 43.349998F);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.cbz
 * JD-Core Version:    0.7.0.1
 */