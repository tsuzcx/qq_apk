package com.tencent.mm.boot.svg.code.drawable;

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

public class honey_pay_bank_logo
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
      Object localObject1 = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject4 = c.instancePaint(paramVarArgs);
      ((Paint)localObject4).setFlags(385);
      ((Paint)localObject4).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(1.0F);
      ((Paint)localObject4).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject4).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject4).setStrokeMiter(4.0F);
      ((Paint)localObject4).setPathEffect(null);
      c.instancePaint((Paint)localObject4, paramVarArgs).setStrokeWidth(1.0F);
      ((Canvas)localObject1).save();
      localObject4 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject4).setColor(-15616);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(20.0F, 0.0F);
      localPath.cubicTo(31.045696F, 0.0F, 40.0F, 8.954305F, 40.0F, 20.0F);
      localPath.cubicTo(40.0F, 31.045696F, 31.045696F, 40.0F, 20.0F, 40.0F);
      localPath.cubicTo(8.954305F, 40.0F, 0.0F, 31.045696F, 0.0F, 20.0F);
      localPath.cubicTo(0.0F, 8.954305F, 8.954305F, 0.0F, 20.0F, 0.0F);
      localPath.close();
      ((Canvas)localObject1).drawPath(localPath, (Paint)localObject4);
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).save();
      localObject4 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject4);
      ((Canvas)localObject1).concat((Matrix)localObject2);
      ((Canvas)localObject1).save();
      localObject3 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(-1);
      localObject4 = c.setMatrixFloatArray((float[])localObject4, 1.0F, 0.0F, 3.2F, 0.0F, 1.0F, 3.466667F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject4);
      ((Canvas)localObject1).concat((Matrix)localObject2);
      ((Canvas)localObject1).save();
      localObject2 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(21.952038F, 12.523949F);
      ((Path)localObject3).cubicTo(24.222239F, 8.749648F, 24.676779F, 5.066351F, 22.907307F, 3.296879F);
      ((Path)localObject3).cubicTo(21.453276F, 1.842848F, 18.613134F, 1.844189F, 15.334306F, 3.369651F);
      ((Path)localObject3).cubicTo(14.933711F, 3.556026F, 14.457878F, 3.382367F, 14.271503F, 2.981772F);
      ((Path)localObject3).cubicTo(14.085128F, 2.581178F, 14.258787F, 2.105345F, 14.659382F, 1.918969F);
      ((Path)localObject3).cubicTo(18.480469F, 0.141224F, 22.012726F, 0.1395567F, 24.038679F, 2.165509F);
      ((Path)localObject3).cubicTo(26.496927F, 4.623758F, 25.918806F, 9.221988F, 23.116028F, 13.687938F);
      ((Path)localObject3).lineTo(24.754049F, 15.325959F);
      ((Path)localObject3).cubicTo(25.326818F, 15.898728F, 25.326818F, 16.82737F, 24.754049F, 17.400139F);
      ((Path)localObject3).lineTo(17.400139F, 24.754049F);
      ((Path)localObject3).cubicTo(16.82737F, 25.326818F, 15.898728F, 25.326818F, 15.325959F, 24.754049F);
      ((Path)localObject3).lineTo(13.115574F, 22.543665F);
      ((Path)localObject3).cubicTo(9.492017F, 24.143118F, 6.058259F, 24.160192F, 4.051127F, 22.153061F);
      ((Path)localObject3).cubicTo(2.647475F, 20.749409F, 2.207673F, 18.60638F, 2.689585F, 16.114594F);
      ((Path)localObject3).cubicTo(2.77348F, 15.680804F, 3.193147F, 15.397159F, 3.626936F, 15.481053F);
      ((Path)localObject3).cubicTo(4.060726F, 15.564948F, 4.344371F, 15.984614F, 4.260476F, 16.418404F);
      ((Path)localObject3).cubicTo(3.871023F, 18.432123F, 4.201048F, 20.040239F, 5.182498F, 21.021688F);
      ((Path)localObject3).cubicTo(6.553119F, 22.392311F, 9.072025F, 22.428535F, 11.892057F, 21.320147F);
      ((Path)localObject3).lineTo(0.4295767F, 9.857667F);
      ((Path)localObject3).cubicTo(-0.1431923F, 9.284898F, -0.1431923F, 8.356257F, 0.4295767F, 7.783487F);
      ((Path)localObject3).lineTo(7.783487F, 0.4295767F);
      ((Path)localObject3).cubicTo(8.356257F, -0.1431923F, 9.284898F, -0.1431923F, 9.857667F, 0.4295767F);
      ((Path)localObject3).lineTo(21.952038F, 12.523949F);
      ((Path)localObject3).lineTo(21.952038F, 12.523949F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(21.05361F, 13.888261F);
      ((Path)localObject3).lineTo(8.820578F, 1.655229F);
      ((Path)localObject3).lineTo(1.655229F, 8.820578F);
      ((Path)localObject3).lineTo(13.443747F, 20.609095F);
      ((Path)localObject3).cubicTo(15.178481F, 19.702929F, 16.966202F, 18.399763F, 18.625792F, 16.740173F);
      ((Path)localObject3).cubicTo(19.547262F, 15.818703F, 20.358849F, 14.857731F, 21.05361F, 13.888261F);
      ((Path)localObject3).lineTo(21.05361F, 13.888261F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(22.19977F, 15.03442F);
      ((Path)localObject3).cubicTo(21.486336F, 16.005684F, 20.669256F, 16.95945F, 19.757162F, 17.871544F);
      ((Path)localObject3).cubicTo(18.133266F, 19.49544F, 16.377274F, 20.818161F, 14.625621F, 21.79097F);
      ((Path)localObject3).lineTo(16.363049F, 23.528399F);
      ((Path)localObject3).lineTo(23.528399F, 16.363049F);
      ((Path)localObject3).lineTo(22.19977F, 15.03442F);
      ((Path)localObject3).lineTo(22.19977F, 15.03442F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      ((Canvas)localObject1).drawPath((Path)localObject3, (Paint)localObject2);
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).restore();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-2565928);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(32.0F, 0.0F);
      ((Path)localObject2).lineTo(32.0F, 32.0F);
      ((Path)localObject2).lineTo(0.0F, 32.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      ((Canvas)localObject1).saveLayerAlpha(null, 0, 31);
      ((Canvas)localObject1).drawPath((Path)localObject2, c.instancePaint(localPaint, paramVarArgs));
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).restore();
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(40.0F, 0.0F);
      ((Path)localObject1).lineTo(40.0F, 40.0F);
      ((Path)localObject1).lineTo(0.0F, 40.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.honey_pay_bank_logo
 * JD-Core Version:    0.7.0.1
 */