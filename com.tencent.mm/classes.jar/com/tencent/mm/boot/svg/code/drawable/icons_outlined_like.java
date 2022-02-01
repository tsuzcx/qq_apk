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

public class icons_outlined_like
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(57.853916F, 37.935287F);
      ((Path)localObject).cubicTo(62.186268F, 33.470257F, 62.135693F, 26.344612F, 57.730064F, 21.938982F);
      ((Path)localObject).cubicTo(53.278088F, 17.487005F, 46.060009F, 17.487005F, 41.608028F, 21.938982F);
      ((Path)localObject).cubicTo(41.031235F, 22.515778F, 40.299618F, 23.221498F, 39.40984F, 24.059835F);
      ((Path)localObject).lineTo(36.941124F, 26.385826F);
      ((Path)localObject).lineTo(34.472408F, 24.059835F);
      ((Path)localObject).cubicTo(33.582634F, 23.221498F, 32.851017F, 22.515778F, 32.27422F, 21.938982F);
      ((Path)localObject).cubicTo(27.822245F, 17.487005F, 20.604162F, 17.487005F, 16.152185F, 21.938982F);
      ((Path)localObject).cubicTo(11.746612F, 26.344557F, 11.695749F, 33.470612F, 15.989021F, 37.897854F);
      ((Path)localObject).lineTo(36.940998F, 58.850048F);
      ((Path)localObject).lineTo(57.853916F, 37.935287F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(13.606602F, 19.393398F);
      ((Path)localObject).cubicTo(19.464466F, 13.535534F, 28.961941F, 13.535534F, 34.819805F, 19.393398F);
      ((Path)localObject).cubicTo(35.368225F, 19.941818F, 36.075333F, 20.623898F, 36.941124F, 21.439636F);
      ((Path)localObject).cubicTo(37.806919F, 20.623898F, 38.514027F, 19.941818F, 39.062447F, 19.393398F);
      ((Path)localObject).cubicTo(44.920311F, 13.535534F, 54.417786F, 13.535534F, 60.27565F, 19.393398F);
      ((Path)localObject).cubicTo(66.079025F, 25.196774F, 66.133003F, 34.572361F, 60.437599F, 40.442192F);
      ((Path)localObject).lineTo(39.062447F, 61.819805F);
      ((Path)localObject).cubicTo(37.890934F, 62.99144F, 35.99144F, 62.991539F, 34.819805F, 61.820026F);
      ((Path)localObject).lineTo(13.443423F, 40.443424F);
      ((Path)localObject).cubicTo(7.749244F, 34.572361F, 7.803227F, 25.196774F, 13.606602F, 19.393398F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_like
 * JD-Core Version:    0.7.0.1
 */