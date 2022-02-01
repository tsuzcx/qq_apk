package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class v_verify
  extends c
{
  private final int height = 16;
  private final int width = 16;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 16;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      Object localObject2 = c.instancePaint(localPaint1, paramVarArgs);
      Paint localPaint2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localPaint2.setColor(855638016);
      localPaint2.setStrokeWidth(0.5F);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.25F, 0.25F);
      ((Path)localObject1).lineTo(15.75F, 0.25F);
      ((Path)localObject1).lineTo(15.75F, 15.75F);
      ((Path)localObject1).lineTo(0.25F, 15.75F);
      ((Path)localObject1).lineTo(0.25F, 0.25F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.drawPath((Path)localObject1, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-352965);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(11.023459F, 2.055746F);
      ((Path)localObject2).lineTo(11.879267F, 4.120642F);
      ((Path)localObject2).lineTo(13.944254F, 4.976541F);
      ((Path)localObject2).cubicTo(14.318434F, 5.131531F, 14.496121F, 5.560507F, 14.341131F, 5.934687F);
      ((Path)localObject2).lineTo(13.485154F, 7.999445F);
      ((Path)localObject2).lineTo(14.341131F, 10.065313F);
      ((Path)localObject2).cubicTo(14.496121F, 10.439493F, 14.318434F, 10.868469F, 13.944254F, 11.023459F);
      ((Path)localObject2).lineTo(11.878266F, 11.878815F);
      ((Path)localObject2).lineTo(11.023459F, 13.944254F);
      ((Path)localObject2).cubicTo(10.868469F, 14.318434F, 10.439493F, 14.496121F, 10.065313F, 14.341131F);
      ((Path)localObject2).lineTo(8.000387F, 13.485085F);
      ((Path)localObject2).lineTo(5.934687F, 14.341131F);
      ((Path)localObject2).cubicTo(5.560507F, 14.496121F, 5.131531F, 14.318434F, 4.976541F, 13.944254F);
      ((Path)localObject2).lineTo(4.121018F, 11.878197F);
      ((Path)localObject2).lineTo(2.055746F, 11.023459F);
      ((Path)localObject2).cubicTo(1.681567F, 10.868469F, 1.503879F, 10.439493F, 1.658869F, 10.065313F);
      ((Path)localObject2).lineTo(2.513824F, 7.999936F);
      ((Path)localObject2).lineTo(1.658869F, 5.934687F);
      ((Path)localObject2).cubicTo(1.503879F, 5.560507F, 1.681567F, 5.131531F, 2.055746F, 4.976541F);
      ((Path)localObject2).lineTo(4.120711F, 4.120565F);
      ((Path)localObject2).lineTo(4.976541F, 2.055746F);
      ((Path)localObject2).cubicTo(5.131531F, 1.681567F, 5.560507F, 1.503879F, 5.934687F, 1.658869F);
      ((Path)localObject2).lineTo(7.999897F, 2.513754F);
      ((Path)localObject2).lineTo(10.065313F, 1.658869F);
      ((Path)localObject2).cubicTo(10.439493F, 1.503879F, 10.868469F, 1.681567F, 11.023459F, 2.055746F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(7.215625F, 9.426211F);
      ((Path)localObject1).lineTo(10.948503F, 5.693333F);
      ((Path)localObject1).lineTo(11.656855F, 6.401685F);
      ((Path)localObject1).lineTo(7.688609F, 10.368281F);
      ((Path)localObject1).cubicTo(7.428278F, 10.628649F, 7.006168F, 10.628562F, 6.745873F, 10.368158F);
      ((Path)localObject1).cubicTo(6.745849F, 10.368134F, 6.745824F, 10.36811F, 6.745873F, 10.368012F);
      ((Path)localObject1).lineTo(4.666667F, 8.287303F);
      ((Path)localObject1).lineTo(4.666667F, 8.287303F);
      ((Path)localObject1).lineTo(5.371692F, 7.582278F);
      ((Path)localObject1).lineTo(7.215625F, 9.426211F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.v_verify
 * JD-Core Version:    0.7.0.1
 */