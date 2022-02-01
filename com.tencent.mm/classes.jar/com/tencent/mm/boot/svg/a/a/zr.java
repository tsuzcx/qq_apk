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

public final class zr
  extends c
{
  private final int height = 135;
  private final int width = 135;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 135;
      return 135;
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
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-10589839);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(64.43F, 0.0F);
      localPath.lineTo(70.360001F, 0.0F);
      localPath.cubicTo(86.610001F, 0.76F, 102.53F, 7.46F, 114.22F, 18.809999F);
      localPath.cubicTo(126.68F, 30.6F, 134.12F, 47.299999F, 135.0F, 64.400002F);
      localPath.lineTo(135.0F, 70.040001F);
      localPath.cubicTo(134.31F, 87.589996F, 126.58F, 104.75F, 113.69F, 116.7F);
      localPath.cubicTo(102.12F, 127.7F, 86.529999F, 134.17F, 70.610001F, 135.0F);
      localPath.lineTo(64.610001F, 135.0F);
      localPath.cubicTo(48.610001F, 134.24001F, 32.93F, 127.74F, 21.299999F, 116.69F);
      localPath.cubicTo(8.43F, 104.77F, 0.74F, 87.650002F, 0.0F, 70.150002F);
      localPath.lineTo(0.0F, 64.68F);
      localPath.cubicTo(0.8F, 47.25F, 8.47F, 30.209999F, 21.280001F, 18.33F);
      localPath.cubicTo(32.869999F, 7.3F, 48.48F, 0.83F, 64.43F, 0.0F);
      localPath.lineTo(64.43F, 0.0F);
      localPath.close();
      localPath.moveTo(52.66F, 42.66F);
      localPath.cubicTo(44.709999F, 48.709999F, 41.529999F, 59.900002F, 44.75F, 69.309998F);
      localPath.cubicTo(48.779999F, 81.400002F, 57.880001F, 91.019997F, 67.519997F, 99.0F);
      localPath.cubicTo(77.110001F, 90.989998F, 86.230003F, 81.410004F, 90.25F, 69.309998F);
      localPath.cubicTo(93.470001F, 59.919998F, 90.300003F, 48.73F, 82.360001F, 42.669998F);
      localPath.cubicTo(74.010002F, 35.84F, 61.009998F, 35.84F, 52.66F, 42.66F);
      localPath.lineTo(52.66F, 42.66F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(63.25F, 50.279999F);
      ((Path)localObject).cubicTo(69.489998F, 47.700001F, 77.269997F, 51.599998F, 79.0F, 58.099998F);
      ((Path)localObject).cubicTo(81.0F, 64.220001F, 77.059998F, 71.370003F, 70.860001F, 73.019997F);
      ((Path)localObject).cubicTo(64.779999F, 74.970001F, 57.700001F, 71.089996F, 56.009998F, 64.959999F);
      ((Path)localObject).cubicTo(54.110001F, 59.139999F, 57.5F, 52.330002F, 63.25F, 50.279999F);
      ((Path)localObject).lineTo(63.25F, 50.279999F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.zr
 * JD-Core Version:    0.7.0.1
 */