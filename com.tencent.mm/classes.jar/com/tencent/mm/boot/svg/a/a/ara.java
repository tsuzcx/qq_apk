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

public final class ara
  extends c
{
  private final int height = 76;
  private final int width = 76;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 76;
      return 76;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.k(paramVarArgs);
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
      localPaint2.setColor(-789517);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(0.0F, 4.0F);
      localPath.cubicTo(0.0F, 1.790861F, 1.790861F, 0.0F, 4.0F, 0.0F);
      localPath.lineTo(72.0F, 0.0F);
      localPath.cubicTo(74.209137F, 0.0F, 76.0F, 1.790861F, 76.0F, 4.0F);
      localPath.lineTo(76.0F, 72.0F);
      localPath.cubicTo(76.0F, 74.209137F, 74.209137F, 76.0F, 72.0F, 76.0F);
      localPath.lineTo(4.0F, 76.0F);
      localPath.cubicTo(1.790861F, 76.0F, 0.0F, 74.209137F, 0.0F, 72.0F);
      localPath.lineTo(0.0F, 4.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-5658199);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 23.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(11.048801F, 4.034698F);
      ((Path)localObject2).cubicTo(16.060522F, -0.743125F, 23.669407F, 1.700647F, 29.878258F, 1.132096F);
      ((Path)localObject2).cubicTo(29.898548F, 4.144418F, 29.898548F, 7.146766F, 29.878258F, 10.159089F);
      ((Path)localObject2).cubicTo(26.469477F, 10.288758F, 22.959244F, 9.760106F, 19.631624F, 10.607945F);
      ((Path)localObject2).cubicTo(16.557634F, 12.134055F, 17.521427F, 15.994218F, 17.318523F, 18.737226F);
      ((Path)localObject2).cubicTo(21.549065F, 18.737226F, 25.769459F, 18.737226F, 30.0F, 18.757175F);
      ((Path)localObject2).cubicTo(29.513031F, 21.789448F, 29.005772F, 24.811745F, 28.468079F, 27.834042F);
      ((Path)localObject2).cubicTo(24.765087F, 27.844017F, 21.072241F, 27.853991F, 17.379395F, 27.863966F);
      ((Path)localObject2).cubicTo(17.328669F, 35.564339F, 17.38954F, 43.274689F, 17.348959F, 50.985039F);
      ((Path)localObject2).cubicTo(14.234388F, 51.004986F, 11.109673F, 51.004986F, 7.995102F, 50.985039F);
      ((Path)localObject2).cubicTo(7.954522F, 43.274689F, 8.015392F, 35.574314F, 7.964667F, 27.863966F);
      ((Path)localObject2).cubicTo(5.651566F, 27.863966F, 3.338464F, 27.844017F, 1.015218F, 27.844017F);
      ((Path)localObject2).cubicTo(0.9949274F, 24.811745F, 0.9949274F, 21.779472F, 1.015218F, 18.747202F);
      ((Path)localObject2).cubicTo(3.338464F, 18.747202F, 5.661711F, 18.737226F, 7.984957F, 18.727251F);
      ((Path)localObject2).cubicTo(8.14728F, 13.779861F, 6.889278F, 7.805089F, 11.048801F, 4.034698F);
      ((Path)localObject2).lineTo(11.048801F, 4.034698F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ara
 * JD-Core Version:    0.7.0.1
 */