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

public final class bvw
  extends c
{
  private final int height = 34;
  private final int width = 34;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 34;
      return 34;
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
      localPaint.setColor(-1);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(13.0F, 0.0F);
      localPath.lineTo(21.0F, 0.0F);
      localPath.cubicTo(27.690001F, 0.44F, 33.419998F, 6.1F, 34.0F, 13.0F);
      localPath.lineTo(34.0F, 21.0F);
      localPath.cubicTo(33.560001F, 27.719999F, 27.92F, 33.41F, 21.0F, 34.0F);
      localPath.lineTo(13.0F, 34.0F);
      localPath.cubicTo(6.3F, 33.580002F, 0.58F, 27.91F, 0.0F, 21.0F);
      localPath.lineTo(0.0F, 13.0F);
      localPath.cubicTo(0.44F, 6.3F, 6.1F, 0.62F, 13.0F, 0.0F);
      localPath.lineTo(13.0F, 0.0F);
      localPath.close();
      localPath.moveTo(11.0F, 4.0F);
      localPath.cubicTo(6.261938F, 5.234581F, 2.737458F, 10.576861F, 3.0F, 16.0F);
      localPath.cubicTo(2.499184F, 21.251474F, 4.504662F, 27.081224F, 9.0F, 30.0F);
      localPath.cubicTo(12.725139F, 31.349081F, 16.597101F, 31.030733F, 20.0F, 31.0F);
      localPath.cubicTo(25.691252F, 30.483572F, 30.476601F, 25.668554F, 31.0F, 20.0F);
      localPath.cubicTo(31.181498F, 15.700277F, 31.231138F, 10.626603F, 28.0F, 7.0F);
      localPath.cubicTo(23.973688F, 2.399292F, 17.004154F, 2.518673F, 11.0F, 4.0F);
      localPath.lineTo(11.0F, 4.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(15.0F, 6.0F);
      ((Path)localObject).cubicTo(16.379942F, 5.866749F, 17.790102F, 5.85669F, 19.0F, 6.0F);
      ((Path)localObject).cubicTo(19.059246F, 9.588673F, 19.079391F, 12.747278F, 19.0F, 16.0F);
      ((Path)localObject).cubicTo(21.940002F, 15.926003F, 24.790541F, 15.926003F, 28.0F, 16.0F);
      ((Path)localObject).cubicTo(28.124561F, 17.243765F, 28.124561F, 18.642F, 28.0F, 20.0F);
      ((Path)localObject).cubicTo(23.410599F, 19.647926F, 19.089464F, 20.5432F, 15.0F, 19.0F);
      ((Path)localObject).cubicTo(15.100726F, 15.040789F, 15.090653F, 10.715309F, 15.0F, 6.0F);
      ((Path)localObject).lineTo(15.0F, 6.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bvw
 * JD-Core Version:    0.7.0.1
 */