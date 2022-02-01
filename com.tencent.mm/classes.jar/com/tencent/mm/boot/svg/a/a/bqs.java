package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class bqs
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-16896);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(22.700001F, 0.0F);
      localPath.lineTo(25.07F, 0.0F);
      localPath.cubicTo(36.939999F, 0.34F, 47.299999F, 10.5F, 48.0F, 22.33F);
      localPath.lineTo(48.0F, 25.389999F);
      localPath.cubicTo(47.470001F, 37.150002F, 37.360001F, 47.34F, 25.6F, 48.0F);
      localPath.lineTo(22.610001F, 48.0F);
      localPath.cubicTo(10.79F, 47.470001F, 0.57F, 37.25F, 0.0F, 25.440001F);
      localPath.lineTo(0.0F, 22.469999F);
      localPath.cubicTo(0.61F, 10.66F, 10.88F, 0.5F, 22.700001F, 0.0F);
      localPath.lineTo(22.700001F, 0.0F);
      localPath.close();
      localPath.moveTo(23.290903F, 13.335449F);
      localPath.cubicTo(20.390598F, 14.737528F, 22.898153F, 19.267319F, 25.697754F, 17.65934F);
      localPath.cubicTo(28.628271F, 16.237654F, 26.080433F, 11.747081F, 23.290903F, 13.335449F);
      localPath.lineTo(23.290903F, 13.335449F);
      localPath.close();
      localPath.moveTo(20.0F, 20.0F);
      localPath.lineTo(20.009979F, 20.98F);
      localPath.cubicTo(20.758484F, 20.99F, 22.255489F, 21.01F, 23.003992F, 21.02F);
      localPath.lineTo(23.003992F, 34.98F);
      localPath.cubicTo(22.255489F, 34.990002F, 20.758484F, 35.009998F, 20.009979F, 35.02F);
      localPath.lineTo(20.009979F, 36.0F);
      localPath.lineTo(30.0F, 36.0F);
      localPath.lineTo(29.990021F, 35.02F);
      localPath.cubicTo(29.241516F, 35.009998F, 27.744511F, 34.990002F, 26.996008F, 34.98F);
      localPath.cubicTo(26.996008F, 29.99F, 27.005987F, 24.99F, 26.996008F, 20.0F);
      localPath.lineTo(20.0F, 20.0F);
      localPath.lineTo(20.0F, 20.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 20.0F, 0.0F, 1.0F, 13.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(3.290903F, 0.3354494F);
      ((Path)localObject2).cubicTo(6.080433F, -1.252919F, 8.628271F, 3.237653F, 5.697754F, 4.659341F);
      ((Path)localObject2).cubicTo(2.898153F, 6.267319F, 0.3905976F, 1.737528F, 3.290903F, 0.3354494F);
      ((Path)localObject2).lineTo(3.290903F, 0.3354494F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 7.0F);
      ((Path)localObject2).lineTo(6.996008F, 7.0F);
      ((Path)localObject2).cubicTo(7.005988F, 11.99F, 6.996008F, 16.99F, 6.996008F, 21.98F);
      ((Path)localObject2).cubicTo(7.744511F, 21.99F, 9.241517F, 22.01F, 9.99002F, 22.02F);
      ((Path)localObject2).lineTo(10.0F, 23.0F);
      ((Path)localObject2).lineTo(0.00998004F, 23.0F);
      ((Path)localObject2).lineTo(0.00998004F, 22.02F);
      ((Path)localObject2).cubicTo(0.7584831F, 22.01F, 2.255489F, 21.99F, 3.003992F, 21.98F);
      ((Path)localObject2).lineTo(3.003992F, 8.020001F);
      ((Path)localObject2).cubicTo(2.255489F, 8.01F, 0.7584831F, 7.99F, 0.00998004F, 7.98F);
      ((Path)localObject2).lineTo(0.0F, 7.0F);
      ((Path)localObject2).lineTo(0.0F, 7.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bqs
 * JD-Core Version:    0.7.0.1
 */