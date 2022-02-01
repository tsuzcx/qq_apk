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

public final class afp
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
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
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-1150121);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(23.357143F, 31.267857F);
      localPath.cubicTo(25.82522F, 35.67271F, 21.368435F, 37.603485F, 19.517857F, 38.94643F);
      localPath.cubicTo(11.49915F, 43.231812F, 8.0F, 44.938072F, 8.0F, 46.625F);
      localPath.lineTo(8.0F, 50.464287F);
      localPath.cubicTo(8.0F, 51.156628F, 8.728162F, 52.0F, 9.535714F, 52.0F);
      localPath.lineTo(49.464287F, 52.0F);
      localPath.cubicTo(50.271839F, 52.0F, 51.0F, 51.156628F, 51.0F, 50.464287F);
      localPath.lineTo(51.0F, 46.625F);
      localPath.cubicTo(51.0F, 44.938072F, 47.500851F, 43.231812F, 39.482143F, 38.94643F);
      localPath.cubicTo(37.631565F, 37.603485F, 33.174782F, 35.67271F, 35.642857F, 31.267857F);
      localPath.cubicTo(38.243069F, 27.868282F, 40.103214F, 26.426222F, 40.25F, 20.517857F);
      localPath.cubicTo(40.103214F, 14.887795F, 35.947693F, 9.0F, 29.5F, 9.0F);
      localPath.cubicTo(23.052307F, 9.0F, 18.896786F, 14.887795F, 18.75F, 20.517857F);
      localPath.cubicTo(18.896786F, 26.426222F, 20.756931F, 27.868282F, 23.357143F, 31.267857F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-1150121);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(43.0F, 35.0F);
      localPath.lineTo(43.0F, 24.87092F);
      localPath.lineTo(43.0F, 20.50185F);
      localPath.cubicTo(43.0F, 13.046129F, 36.955845F, 7.0F, 29.5F, 7.0F);
      localPath.cubicTo(24.75873F, 7.0F, 29.5F, 7.0F, 29.5F, 7.0F);
      localPath.cubicTo(22.040064F, 7.0F, 16.0F, 13.045625F, 16.0F, 20.503281F);
      localPath.cubicTo(16.0F, 20.503281F, 16.0F, 26.211F, 16.0F, 24.426191F);
      localPath.lineTo(16.0F, 35.0F);
      localPath.lineTo(43.0F, 35.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-1);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(22.200684F, 38.115723F);
      localPath.cubicTo(22.200684F, 38.115723F, 21.690918F, 42.961914F, 23.961914F, 45.899902F);
      localPath.cubicTo(26.230072F, 48.834221F, 29.463587F, 44.642944F, 29.583549F, 43.118626F);
      localPath.cubicTo(26.589844F, 42.558025F, 22.200684F, 38.115723F, 22.200684F, 38.115723F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, -1.0F, 0.0F, 66.791992F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(29.706408F, 38.115723F);
      ((Path)localObject).cubicTo(29.706408F, 38.115723F, 29.196642F, 42.961914F, 31.467638F, 45.899902F);
      ((Path)localObject).cubicTo(33.738636F, 48.837891F, 37.022217F, 44.632446F, 37.134521F, 43.112915F);
      ((Path)localObject).cubicTo(34.140381F, 42.558025F, 29.706408F, 38.115723F, 29.706408F, 38.115723F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.afp
 * JD-Core Version:    0.7.0.1
 */