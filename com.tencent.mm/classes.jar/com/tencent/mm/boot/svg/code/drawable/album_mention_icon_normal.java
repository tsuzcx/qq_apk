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

public class album_mention_icon_normal
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(11.269531F, 8.1875F);
      ((Path)localObject).cubicTo(9.570313F, 8.1875F, 8.46875F, 9.628906F, 8.46875F, 11.84375F);
      ((Path)localObject).cubicTo(8.46875F, 14.046875F, 9.558594F, 15.476563F, 11.257813F, 15.476563F);
      ((Path)localObject).cubicTo(12.992188F, 15.476563F, 14.105469F, 14.023438F, 14.105469F, 11.785156F);
      ((Path)localObject).cubicTo(14.105469F, 9.582031F, 13.015625F, 8.1875F, 11.269531F, 8.1875F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(11.644531F, 2.0F);
      ((Path)localObject).cubicTo(16.779823F, 2.0F, 21.019531F, 5.527344F, 21.019531F, 10.71875F);
      ((Path)localObject).cubicTo(21.019531F, 14.445313F, 19.472656F, 16.835938F, 16.894531F, 16.835938F);
      ((Path)localObject).cubicTo(15.5F, 16.835938F, 14.398438F, 15.992188F, 14.222656F, 14.679688F);
      ((Path)localObject).lineTo(14.140625F, 14.679688F);
      ((Path)localObject).cubicTo(13.613281F, 16.015625F, 12.523438F, 16.753906F, 11.070313F, 16.753906F);
      ((Path)localObject).cubicTo(8.65625F, 16.753906F, 7.015625F, 14.761719F, 7.015625F, 11.808594F);
      ((Path)localObject).cubicTo(7.015625F, 8.925781F, 8.679688F, 6.933594F, 11.070313F, 6.933594F);
      ((Path)localObject).cubicTo(12.429688F, 6.933594F, 13.613281F, 7.671875F, 14.046875F, 8.820313F);
      ((Path)localObject).lineTo(14.128906F, 8.820313F);
      ((Path)localObject).lineTo(14.128906F, 7.167969F);
      ((Path)localObject).lineTo(15.488281F, 7.167969F);
      ((Path)localObject).lineTo(15.488281F, 13.871094F);
      ((Path)localObject).cubicTo(15.488281F, 14.9375F, 16.050781F, 15.640625F, 17.117188F, 15.640625F);
      ((Path)localObject).cubicTo(18.675781F, 15.640625F, 19.742188F, 13.847656F, 19.742188F, 10.695313F);
      ((Path)localObject).cubicTo(19.742188F, 6.21875F, 16.238195F, 3.175705F, 11.644531F, 3.175705F);
      ((Path)localObject).cubicTo(7.050867F, 3.175705F, 3.289063F, 6.525638F, 3.289063F, 11.773438F);
      ((Path)localObject).cubicTo(3.289063F, 16.648184F, 7.303185F, 20.363281F, 11.773438F, 20.363281F);
      ((Path)localObject).cubicTo(13.355469F, 20.363281F, 14.867188F, 20.164063F, 15.664063F, 19.847656F);
      ((Path)localObject).lineTo(15.664063F, 21.007813F);
      ((Path)localObject).cubicTo(14.714844F, 21.335938F, 13.332031F, 21.523438F, 11.761719F, 21.523438F);
      ((Path)localObject).cubicTo(6.197949F, 21.523438F, 2.0F, 17.325605F, 2.0F, 11.726563F);
      ((Path)localObject).cubicTo(2.0F, 6.127519F, 6.509238F, 2.0F, 11.644531F, 2.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.album_mention_icon_normal
 * JD-Core Version:    0.7.0.1
 */