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

public final class bpf
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      Paint localPaint2 = c.a((Paint)localObject, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.a(localPaint1, paramVarArgs);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      ((Paint)localObject).setColor(-435699360);
      localPaint2.setColor(-419430401);
      localPaint2.setStrokeWidth(2.5F);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(20.0F, 1.25F);
      localPath.cubicTo(30.355339F, 1.25F, 38.75F, 9.64466F, 38.75F, 20.0F);
      localPath.cubicTo(38.75F, 30.355339F, 30.355339F, 38.75F, 20.0F, 38.75F);
      localPath.cubicTo(9.64466F, 38.75F, 1.25F, 30.355339F, 1.25F, 20.0F);
      localPath.cubicTo(1.25F, 9.64466F, 9.64466F, 1.25F, 20.0F, 1.25F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(21.5F, 13.64F);
      ((Path)localObject).lineTo(27.156855F, 19.296854F);
      ((Path)localObject).cubicTo(27.547379F, 19.687378F, 27.547379F, 20.320543F, 27.156855F, 20.711067F);
      ((Path)localObject).lineTo(21.5F, 26.367922F);
      ((Path)localObject).lineTo(19.732233F, 24.600155F);
      ((Path)localObject).lineTo(23.080999F, 21.25F);
      ((Path)localObject).lineTo(13.0F, 21.25F);
      ((Path)localObject).lineTo(13.0F, 18.75F);
      ((Path)localObject).lineTo(23.075001F, 18.75F);
      ((Path)localObject).lineTo(19.732233F, 15.407767F);
      ((Path)localObject).lineTo(21.5F, 13.64F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bpf
 * JD-Core Version:    0.7.0.1
 */