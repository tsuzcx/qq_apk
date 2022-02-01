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

public final class aby
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
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(59.312603F, 16.393398F);
      localPath.cubicTo(63.008801F, 20.089596F, 64.372772F, 25.234852F, 63.404514F, 30.000513F);
      localPath.lineTo(59.706318F, 30.000799F);
      localPath.cubicTo(60.74369F, 26.183155F, 59.761009F, 21.932972F, 56.767021F, 18.938982F);
      localPath.cubicTo(52.315044F, 14.487006F, 45.096962F, 14.487006F, 40.644985F, 18.938982F);
      localPath.cubicTo(40.068192F, 19.515778F, 39.336575F, 20.221498F, 38.446796F, 21.059835F);
      localPath.lineTo(35.978081F, 23.385826F);
      localPath.lineTo(33.509365F, 21.059835F);
      localPath.cubicTo(32.619587F, 20.221498F, 31.88797F, 19.515778F, 31.311176F, 18.938982F);
      localPath.cubicTo(26.859198F, 14.487006F, 19.641117F, 14.487006F, 15.189141F, 18.938982F);
      localPath.cubicTo(10.783566F, 23.344557F, 10.732704F, 30.470612F, 15.025975F, 34.897854F);
      localPath.lineTo(35.977951F, 55.850048F);
      localPath.lineTo(36.0F, 55.827F);
      localPath.lineTo(36.000156F, 59.698513F);
      localPath.cubicTo(35.225063F, 59.704212F, 34.448181F, 59.411385F, 33.856758F, 58.820026F);
      localPath.lineTo(12.480378F, 37.443424F);
      localPath.cubicTo(6.786199F, 31.572361F, 6.840182F, 22.196774F, 12.643557F, 16.393398F);
      localPath.cubicTo(18.501421F, 10.535534F, 27.998896F, 10.535534F, 33.856758F, 16.393398F);
      localPath.cubicTo(34.405178F, 16.941818F, 35.112286F, 17.623898F, 35.978081F, 18.439636F);
      localPath.cubicTo(36.843872F, 17.623898F, 37.55098F, 16.941818F, 38.0994F, 16.393398F);
      localPath.cubicTo(43.957264F, 10.535534F, 53.454739F, 10.535534F, 59.312603F, 16.393398F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(61.5F, 52.5F);
      ((Path)localObject).lineTo(61.5F, 56.099998F);
      ((Path)localObject).lineTo(42.0F, 56.099998F);
      ((Path)localObject).lineTo(42.0F, 52.5F);
      ((Path)localObject).lineTo(61.5F, 52.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(61.5F, 43.5F);
      ((Path)localObject).lineTo(61.5F, 47.099998F);
      ((Path)localObject).lineTo(42.0F, 47.099998F);
      ((Path)localObject).lineTo(42.0F, 43.5F);
      ((Path)localObject).lineTo(61.5F, 43.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(61.5F, 34.5F);
      ((Path)localObject).lineTo(61.5F, 38.099998F);
      ((Path)localObject).lineTo(42.0F, 38.099998F);
      ((Path)localObject).lineTo(42.0F, 34.5F);
      ((Path)localObject).lineTo(61.5F, 34.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aby
 * JD-Core Version:    0.7.0.1
 */