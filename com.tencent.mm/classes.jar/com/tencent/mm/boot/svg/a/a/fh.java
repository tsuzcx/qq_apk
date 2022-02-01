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

public final class fh
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.BUTT);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localPaint1.setStrokeMiter(4.0F);
      localPaint1.setPathEffect(null);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -307.0F, 0.0F, 1.0F, -749.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 307.0F, 0.0F, 1.0F, 749.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      Paint localPaint2 = c.a((Paint)localObject2, paramVarArgs);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(855638016);
      localPaint1.setColor(-1);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(16.0F, 31.5F);
      localPath.cubicTo(24.560413F, 31.5F, 31.5F, 24.560413F, 31.5F, 16.0F);
      localPath.cubicTo(31.5F, 7.439586F, 24.560413F, 0.5F, 16.0F, 0.5F);
      localPath.cubicTo(7.439586F, 0.5F, 0.5F, 7.439586F, 0.5F, 16.0F);
      localPath.cubicTo(0.5F, 24.560413F, 7.439586F, 31.5F, 16.0F, 31.5F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(15.0F, 3.590705F);
      ((Path)localObject2).lineTo(6.666667F, 5.417628F);
      ((Path)localObject2).lineTo(6.666667F, 15.163136F);
      ((Path)localObject2).lineTo(6.666667F, 16.001057F);
      ((Path)localObject2).cubicTo(6.666667F, 16.78138F, 6.144095F, 17.542246F, 5.441226F, 17.870054F);
      ((Path)localObject2).cubicTo(5.310566F, 17.930992F, 4.485161F, 18.115479F, 4.377384F, 18.137161F);
      ((Path)localObject2).cubicTo(3.341805F, 18.345497F, 2.546121F, 17.458466F, 2.502302F, 16.561483F);
      ((Path)localObject2).cubicTo(2.458482F, 15.664502F, 3.046719F, 14.916552F, 3.729225F, 14.779246F);
      ((Path)localObject2).lineTo(4.656247F, 14.54665F);
      ((Path)localObject2).cubicTo(5.103234F, 14.434498F, 5.416667F, 14.032707F, 5.416667F, 13.571865F);
      ((Path)localObject2).lineTo(5.416667F, 5.259788F);
      ((Path)localObject2).lineTo(5.416667F, 5.10113F);
      ((Path)localObject2).cubicTo(5.416667F, 4.63128F, 5.743765F, 4.224795F, 6.202738F, 4.12428F);
      ((Path)localObject2).lineTo(15.643036F, 2.056866F);
      ((Path)localObject2).cubicTo(15.912786F, 1.997792F, 16.17935F, 2.168577F, 16.238424F, 2.438327F);
      ((Path)localObject2).cubicTo(16.246119F, 2.473461F, 16.25F, 2.509324F, 16.25F, 2.545291F);
      ((Path)localObject2).lineTo(16.25F, 2.906164F);
      ((Path)localObject2).lineTo(16.25F, 12.944818F);
      ((Path)localObject2).lineTo(16.25F, 13.78274F);
      ((Path)localObject2).cubicTo(16.25F, 14.563063F, 15.722891F, 15.323929F, 15.013919F, 15.651737F);
      ((Path)localObject2).cubicTo(14.882124F, 15.712675F, 14.049552F, 15.897161F, 13.94084F, 15.918844F);
      ((Path)localObject2).cubicTo(12.896268F, 16.12718F, 12.093675F, 15.240149F, 12.049476F, 14.343167F);
      ((Path)localObject2).cubicTo(12.005276F, 13.446185F, 12.59862F, 12.698235F, 13.287052F, 12.560929F);
      ((Path)localObject2).lineTo(14.23615F, 12.32634F);
      ((Path)localObject2).cubicTo(14.684809F, 12.215445F, 15.0F, 11.81286F, 15.0F, 11.3507F);
      ((Path)localObject2).lineTo(15.0F, 3.590705F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.fh
 * JD-Core Version:    0.7.0.1
 */