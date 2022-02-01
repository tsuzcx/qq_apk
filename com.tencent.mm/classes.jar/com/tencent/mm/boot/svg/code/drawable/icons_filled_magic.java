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

public class icons_filled_magic
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(72.0F, 0.0F);
      ((Path)localObject).lineTo(72.0F, 72.0F);
      ((Path)localObject).lineTo(0.0F, 72.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(43.920025F, 10.000783F);
      ((Path)localObject).cubicTo(44.194809F, 10.4123F, 44.326271F, 10.902925F, 44.29406F, 11.396701F);
      ((Path)localObject).lineTo(43.52095F, 23.248135F);
      ((Path)localObject).lineTo(52.845592F, 30.603762F);
      ((Path)localObject).cubicTo(53.821224F, 31.373375F, 53.988232F, 32.788174F, 53.21862F, 33.763802F);
      ((Path)localObject).cubicTo(52.912155F, 34.152302F, 52.486168F, 34.42894F, 52.006603F, 34.550892F);
      ((Path)localObject).lineTo(43.084999F, 36.819F);
      ((Path)localObject).lineTo(61.361191F, 57.843174F);
      ((Path)localObject).cubicTo(61.90469F, 58.468395F, 61.83844F, 59.415829F, 61.213215F, 59.959328F);
      ((Path)localObject).lineTo(59.85474F, 61.140232F);
      ((Path)localObject).cubicTo(59.229519F, 61.683731F, 58.282082F, 61.617481F, 57.738586F, 60.99226F);
      ((Path)localObject).lineTo(39.542F, 40.060001F);
      ((Path)localObject).lineTo(36.382175F, 48.619194F);
      ((Path)localObject).cubicTo(35.951714F, 49.784897F, 34.657772F, 50.380928F, 33.492069F, 49.950466F);
      ((Path)localObject).cubicTo(33.027882F, 49.779057F, 32.633144F, 49.459404F, 32.368969F, 49.040997F);
      ((Path)localObject).lineTo(26.028326F, 38.998566F);
      ((Path)localObject).lineTo(14.161004F, 38.528625F);
      ((Path)localObject).cubicTo(12.919337F, 38.479458F, 11.952626F, 37.433025F, 12.001796F, 36.19136F);
      ((Path)localObject).cubicTo(12.021375F, 35.696918F, 12.203402F, 35.222725F, 12.519695F, 34.842186F);
      ((Path)localObject).lineTo(20.11125F, 25.708593F);
      ((Path)localObject).lineTo(16.890985F, 14.27688F);
      ((Path)localObject).cubicTo(16.554052F, 13.080791F, 17.250536F, 11.838029F, 18.446627F, 11.501096F);
      ((Path)localObject).cubicTo(18.922916F, 11.366927F, 19.430151F, 11.39351F, 19.889807F, 11.576729F);
      ((Path)localObject).lineTo(30.922287F, 15.974293F);
      ((Path)localObject).lineTo(40.799377F, 9.379045F);
      ((Path)localObject).cubicTo(41.832806F, 8.68899F, 43.229969F, 8.967351F, 43.920025F, 10.000783F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_magic
 * JD-Core Version:    0.7.0.1
 */