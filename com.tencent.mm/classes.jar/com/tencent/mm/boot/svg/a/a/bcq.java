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

public final class bcq
  extends c
{
  private final int height = 268;
  private final int width = 268;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 268;
      return 268;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      float[] arrayOfFloat = c.g(paramVarArgs);
      Object localObject2 = c.k(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 9.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-2763307);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(19.441139F, 1.681452F);
      localPath.cubicTo(21.571093F, 1.181501F, 23.771044F, 1.051513F, 25.960997F, 1.021516F);
      localPath.lineTo(217.99675F, 1.021516F);
      localPath.cubicTo(223.20663F, 1.051513F, 228.63652F, 0.6115558F, 233.57642F, 2.611362F);
      localPath.cubicTo(242.6562F, 5.981036F, 249.10606F, 15.260138F, 248.98607F, 24.969196F);
      localPath.cubicTo(248.99608F, 91.642738F, 249.01607F, 158.32628F, 248.97607F, 224.99982F);
      localPath.cubicTo(249.32607F, 237.79858F, 237.84631F, 249.31747F, 225.03661F, 248.97751F);
      localPath.cubicTo(158.34807F, 249.00749F, 91.649544F, 249.00749F, 24.961018F, 248.97751F);
      localPath.cubicTo(12.1513F, 249.30746F, 0.681554F, 237.79858F, 1.011547F, 224.98982F);
      localPath.cubicTo(1.001547F, 158.32628F, 0.9915472F, 91.65274F, 1.011547F, 24.989195F);
      localPath.cubicTo(0.8315507F, 14.180242F, 8.901373F, 4.021226F, 19.441139F, 1.681452F);
      localPath.lineTo(19.441139F, 1.681452F);
      localPath.close();
      localPath.moveTo(20.37277F, 4.509965F);
      localPath.cubicTo(11.114031F, 6.489831F, 3.805027F, 15.399228F, 4.014998F, 24.928583F);
      localPath.cubicTo(3.995001F, 91.634064F, 3.995001F, 158.32956F, 4.014998F, 225.02504F);
      localPath.cubicTo(3.70504F, 236.20428F, 13.813663F, 246.32359F, 25.00214F, 245.97362F);
      localPath.cubicTo(91.643066F, 246.01361F, 158.28398F, 246.00362F, 224.92491F, 245.97362F);
      localPath.cubicTo(234.5036F, 246.2536F, 243.48238F, 238.9341F, 245.47211F, 229.63472F);
      localPath.cubicTo(246.20201F, 225.79498F, 245.95204F, 221.86525F, 245.98204F, 217.97551F);
      localPath.cubicTo(245.95204F, 153.64987F, 245.99203F, 89.324226F, 245.96205F, 25.008577F);
      localPath.cubicTo(246.29201F, 13.809336F, 236.17339F, 3.690021F, 224.98491F, 4.029998F);
      localPath.cubicTo(158.64394F, 3.980001F, 92.312973F, 4.029998F, 25.982006F, 4.0F);
      localPath.cubicTo(24.102262F, 4.049997F, 22.222519F, 4.129991F, 20.37277F, 4.509965F);
      localPath.lineTo(20.37277F, 4.509965F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 3.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(17.37277F, 1.509966F);
      ((Path)localObject2).cubicTo(19.222519F, 1.129991F, 21.102262F, 1.049997F, 22.982006F, 1.0F);
      ((Path)localObject2).cubicTo(89.312973F, 1.029998F, 155.64394F, 0.9800013F, 221.98491F, 1.029998F);
      ((Path)localObject2).cubicTo(233.17339F, 0.690021F, 243.29201F, 10.809336F, 242.96205F, 22.008577F);
      ((Path)localObject2).cubicTo(242.99203F, 86.324226F, 242.95204F, 150.64987F, 242.98204F, 214.97551F);
      ((Path)localObject2).cubicTo(242.95204F, 218.86525F, 243.20201F, 222.79498F, 242.47211F, 226.63472F);
      ((Path)localObject2).cubicTo(240.48238F, 235.9341F, 231.5036F, 243.2536F, 221.92491F, 242.97362F);
      ((Path)localObject2).cubicTo(155.28398F, 243.00362F, 88.643066F, 243.01361F, 22.00214F, 242.97362F);
      ((Path)localObject2).cubicTo(10.813663F, 243.32359F, 0.7050402F, 233.20428F, 1.014998F, 222.02504F);
      ((Path)localObject2).cubicTo(0.9950007F, 155.32956F, 0.9950007F, 88.634064F, 1.014998F, 21.928583F);
      ((Path)localObject2).cubicTo(0.8050265F, 12.399228F, 8.114031F, 3.489831F, 17.37277F, 1.509966F);
      ((Path)localObject2).lineTo(17.37277F, 1.509966F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bcq
 * JD-Core Version:    0.7.0.1
 */