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

public class finder_bgm_gif_first_page
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(11.000303F, 3.054895F);
      ((Path)localObject).lineTo(11.000472F, 4.263444F);
      ((Path)localObject).cubicTo(7.164701F, 4.754101F, 4.2F, 8.030829F, 4.2F, 12.0F);
      ((Path)localObject).cubicTo(4.2F, 16.307821F, 7.692179F, 19.799999F, 12.0F, 19.799999F);
      ((Path)localObject).cubicTo(16.307821F, 19.799999F, 19.799999F, 16.307821F, 19.799999F, 12.0F);
      ((Path)localObject).cubicTo(19.799999F, 9.97815F, 19.030729F, 8.135974F, 17.768913F, 6.750194F);
      ((Path)localObject).lineTo(19.057739F, 6.41477F);
      ((Path)localObject).cubicTo(20.273821F, 7.949388F, 21.0F, 9.88989F, 21.0F, 12.0F);
      ((Path)localObject).cubicTo(21.0F, 16.970562F, 16.970562F, 21.0F, 12.0F, 21.0F);
      ((Path)localObject).cubicTo(7.029437F, 21.0F, 3.0F, 16.970562F, 3.0F, 12.0F);
      ((Path)localObject).cubicTo(3.0F, 7.367343F, 6.500207F, 3.552202F, 11.000303F, 3.054895F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(19.296652F, 1.561232F);
      ((Path)localObject).lineTo(19.29916F, 1.573954F);
      ((Path)localObject).lineTo(19.299999F, 3.879964F);
      ((Path)localObject).cubicTo(19.299999F, 3.92531F, 19.269487F, 3.96498F, 19.22566F, 3.976616F);
      ((Path)localObject).lineTo(14.499F, 5.230869F);
      ((Path)localObject).lineTo(14.5F, 12.0F);
      ((Path)localObject).cubicTo(14.5F, 13.325483F, 13.468464F, 14.410039F, 12.164375F, 14.494682F);
      ((Path)localObject).lineTo(12.0F, 14.5F);
      ((Path)localObject).cubicTo(10.619288F, 14.5F, 9.5F, 13.380712F, 9.5F, 12.0F);
      ((Path)localObject).cubicTo(9.5F, 10.619288F, 10.619288F, 9.5F, 12.0F, 9.5F);
      ((Path)localObject).cubicTo(12.476136F, 9.5F, 12.921185F, 9.633106F, 13.299963F, 9.864139F);
      ((Path)localObject).lineTo(13.3F, 3.819039F);
      ((Path)localObject).cubicTo(13.3F, 3.365584F, 13.605117F, 2.968887F, 14.043387F, 2.852525F);
      ((Path)localObject).lineTo(19.174339F, 1.490242F);
      ((Path)localObject).cubicTo(19.227718F, 1.47607F, 19.282478F, 1.507853F, 19.296652F, 1.561232F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_bgm_gif_first_page
 * JD-Core Version:    0.7.0.1
 */