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

public final class bcz
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-12863723);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 11.0F, 0.0F, 1.0F, 18.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(20.389967F, 3.894499F);
      ((Path)localObject2).cubicTo(25.58415F, -1.789939F, 35.671696F, -1.147176F, 40.123852F, 5.139853F);
      ((Path)localObject2).cubicTo(45.819405F, 12.81284F, 43.142094F, 23.930635F, 36.814816F, 30.378355F);
      ((Path)localObject2).cubicTo(35.431038F, 31.493147F, 34.297943F, 33.853294F, 36.082817F, 35.178993F);
      ((Path)localObject2).cubicTo(43.282478F, 39.407169F, 51.224163F, 43.203491F, 56.358181F, 50.052937F);
      ((Path)localObject2).cubicTo(58.895111F, 53.226582F, 58.082893F, 57.545147F, 56.659004F, 61.0F);
      ((Path)localObject2).cubicTo(38.51947F, 60.879482F, 20.369913F, 60.969872F, 2.23038F, 60.959827F);
      ((Path)localObject2).cubicTo(1.017067F, 57.545147F, 0.1045755F, 53.427444F, 2.491092F, 50.293976F);
      ((Path)localObject2).cubicTo(7.524838F, 43.324009F, 15.596879F, 39.668293F, 22.706291F, 35.289467F);
      ((Path)localObject2).cubicTo(24.63155F, 33.93364F, 23.418236F, 31.483105F, 22.044485F, 30.257837F);
      ((Path)localObject2).cubicTo(15.677098F, 23.338089F, 13.631513F, 11.226018F, 20.389967F, 3.894499F);
      ((Path)localObject2).lineTo(20.389967F, 3.894499F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(49.614113F, 20.012203F);
      ((Path)localObject2).cubicTo(57.728481F, 20.052027F, 65.832779F, 19.922604F, 73.947144F, 20.081894F);
      ((Path)localObject2).cubicTo(74.017616F, 21.694714F, 74.017616F, 23.307535F, 73.947144F, 24.920355F);
      ((Path)localObject2).cubicTo(65.631432F, 25.069691F, 57.315716F, 24.950222F, 49.0F, 25.0F);
      ((Path)localObject2).cubicTo(49.231552F, 23.3374F, 49.422832F, 21.674803F, 49.614113F, 20.012203F);
      ((Path)localObject2).lineTo(49.614113F, 20.012203F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(45.0F, 33.156006F);
      ((Path)localObject2).cubicTo(54.639053F, 32.909058F, 64.298187F, 33.007835F, 73.947289F, 33.096737F);
      ((Path)localObject2).cubicTo(74.01757F, 34.696972F, 74.01757F, 36.297203F, 73.947289F, 37.897438F);
      ((Path)localObject2).cubicTo(66.928848F, 37.927071F, 59.900372F, 38.154263F, 52.902016F, 37.818413F);
      ((Path)localObject2).cubicTo(50.191032F, 36.405861F, 47.239071F, 35.269894F, 45.0F, 33.156006F);
      ((Path)localObject2).lineTo(45.0F, 33.156006F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(62.0F, 46.0F);
      ((Path)localObject1).cubicTo(65.979408F, 46.009979F, 69.958824F, 45.980042F, 73.938232F, 46.079842F);
      ((Path)localObject1).cubicTo(74.018829F, 47.696606F, 74.018829F, 49.313374F, 73.948303F, 50.930141F);
      ((Path)localObject1).cubicTo(70.70433F, 51.029942F, 67.460358F, 50.990021F, 64.206306F, 51.0F);
      ((Path)localObject1).cubicTo(63.541393F, 49.303394F, 62.805958F, 47.636726F, 62.0F, 46.0F);
      ((Path)localObject1).lineTo(62.0F, 46.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bcz
 * JD-Core Version:    0.7.0.1
 */