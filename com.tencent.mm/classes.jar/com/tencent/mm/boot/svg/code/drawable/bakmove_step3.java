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

public class bakmove_step3
  extends c
{
  private final int height = 54;
  private final int width = 54;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 54;
      return 54;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      c.instancePaint((Paint)localObject1, paramVarArgs).setStrokeWidth(1.0F);
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localCanvas.save();
      Object localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(26.0F, 0.0F);
      localPath.cubicTo(12.509529F, 0.4932912F, 0.7483469F, 11.868587F, 0.0F, 25.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(29.0F, 0.0F);
      localPath.lineTo(54.0F, 0.0F);
      localPath.lineTo(54.0F, 26.0F);
      localPath.cubicTo(53.497437F, 12.494164F, 42.12574F, 0.738521F, 29.0F, 0.0F);
      localPath.lineTo(29.0F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(21.436541F, 3.717582F);
      localPath.cubicTo(32.972836F, 0.6226771F, 45.939915F, 7.864154F, 49.611916F, 19.182091F);
      localPath.cubicTo(53.063801F, 28.296535F, 49.862053F, 39.253902F, 42.39798F, 45.403648F);
      localPath.cubicTo(32.812748F, 53.947189F, 16.643925F, 52.504902F, 8.659567F, 42.468998F);
      localPath.cubicTo(3.51676F, 36.369331F, 1.555689F, 27.595425F, 4.127093F, 19.973345F);
      localPath.cubicTo(6.498387F, 11.990694F, 13.352127F, 5.620598F, 21.436541F, 3.717582F);
      localPath.lineTo(21.436541F, 3.717582F);
      localPath.close();
      localPath.moveTo(21.829847F, 14.14869F);
      localPath.cubicTo(18.914087F, 15.684807F, 18.011591F, 19.130964F, 17.585136F, 22.19309F);
      localPath.lineTo(20.88768F, 22.19309F);
      localPath.cubicTo(21.353806F, 20.303263F, 21.552156F, 17.999088F, 23.386904F, 16.917742F);
      localPath.cubicTo(26.253077F, 14.825794F, 31.519297F, 16.462971F, 31.291193F, 20.535702F);
      localPath.cubicTo(31.42012F, 24.274933F, 27.463018F, 25.437128F, 24.517504F, 25.447233F);
      localPath.cubicTo(24.507587F, 26.083914F, 24.487751F, 27.357273F, 24.477835F, 28.004059F);
      localPath.cubicTo(27.691122F, 27.781727F, 32.015175F, 28.701376F, 32.372208F, 32.652836F);
      localPath.cubicTo(33.225117F, 36.897369F, 28.484526F, 39.979706F, 24.765444F, 38.817513F);
      localPath.cubicTo(21.839766F, 38.382954F, 20.768669F, 35.320827F, 20.282709F, 32.753895F);
      localPath.cubicTo(19.181862F, 32.753895F, 18.090931F, 32.753895F, 17.0F, 32.764F);
      localPath.cubicTo(17.32728F, 35.431992F, 17.902496F, 38.393059F, 20.203369F, 40.050449F);
      localPath.cubicTo(24.071215F, 42.849819F, 30.011827F, 42.637592F, 33.572231F, 39.393559F);
      localPath.cubicTo(37.49958F, 35.704857F, 36.65659F, 27.801939F, 31.082924F, 26.316353F);
      localPath.cubicTo(33.235031F, 24.800447F, 35.525986F, 22.546803F, 34.722664F, 19.585735F);
      localPath.cubicTo(34.33588F, 13.380631F, 26.441509F, 11.541333F, 21.829847F, 14.14869F);
      localPath.lineTo(21.829847F, 14.14869F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 28.0F);
      localPath.cubicTo(0.5033557F, 41.49572F, 11.873273F, 53.241245F, 25.0F, 54.0F);
      localPath.lineTo(0.0F, 54.0F);
      localPath.lineTo(0.0F, 28.0F);
      localPath.lineTo(0.0F, 28.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(28.0F, 54.0F);
      ((Path)localObject2).cubicTo(41.500584F, 53.507099F, 53.261765F, 42.121056F, 54.0F, 29.0F);
      ((Path)localObject2).lineTo(54.0F, 54.0F);
      ((Path)localObject2).lineTo(28.0F, 54.0F);
      ((Path)localObject2).lineTo(28.0F, 54.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16139513);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(25.709999F, 0.0F);
      ((Path)localObject2).lineTo(28.629999F, 0.0F);
      ((Path)localObject2).cubicTo(41.950001F, 0.73F, 53.490002F, 12.35F, 54.0F, 25.700001F);
      ((Path)localObject2).lineTo(54.0F, 28.639999F);
      ((Path)localObject2).cubicTo(53.27F, 41.950001F, 41.639999F, 53.5F, 28.290001F, 54.0F);
      ((Path)localObject2).lineTo(25.33F, 54.0F);
      ((Path)localObject2).cubicTo(12.03F, 53.25F, 0.51F, 41.639999F, 0.0F, 28.299999F);
      ((Path)localObject2).lineTo(0.0F, 25.34F);
      ((Path)localObject2).cubicTo(0.74F, 12.03F, 12.37F, 0.5F, 25.709999F, 0.0F);
      ((Path)localObject2).lineTo(25.709999F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(21.436541F, 3.717582F);
      ((Path)localObject2).cubicTo(13.352127F, 5.620598F, 6.498387F, 11.990694F, 4.127093F, 19.973345F);
      ((Path)localObject2).cubicTo(1.555689F, 27.595425F, 3.51676F, 36.369331F, 8.659567F, 42.468998F);
      ((Path)localObject2).cubicTo(16.643925F, 52.504902F, 32.812748F, 53.947189F, 42.39798F, 45.403648F);
      ((Path)localObject2).cubicTo(49.862053F, 39.253902F, 53.063801F, 28.296535F, 49.611916F, 19.182091F);
      ((Path)localObject2).cubicTo(45.939915F, 7.864154F, 32.972836F, 0.6226771F, 21.436541F, 3.717582F);
      ((Path)localObject2).lineTo(21.436541F, 3.717582F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(21.829847F, 14.14869F);
      ((Path)localObject1).cubicTo(26.441509F, 11.541333F, 34.33588F, 13.380631F, 34.722664F, 19.585735F);
      ((Path)localObject1).cubicTo(35.525986F, 22.546803F, 33.235031F, 24.800447F, 31.082924F, 26.316353F);
      ((Path)localObject1).cubicTo(36.65659F, 27.801939F, 37.49958F, 35.704857F, 33.572231F, 39.393559F);
      ((Path)localObject1).cubicTo(30.011827F, 42.637592F, 24.071215F, 42.849819F, 20.203369F, 40.050449F);
      ((Path)localObject1).cubicTo(17.902496F, 38.393059F, 17.32728F, 35.431992F, 17.0F, 32.764F);
      ((Path)localObject1).cubicTo(18.090931F, 32.753895F, 19.181862F, 32.753895F, 20.282709F, 32.753895F);
      ((Path)localObject1).cubicTo(20.768669F, 35.320827F, 21.839766F, 38.382954F, 24.765444F, 38.817513F);
      ((Path)localObject1).cubicTo(28.484526F, 39.979706F, 33.225117F, 36.897369F, 32.372208F, 32.652836F);
      ((Path)localObject1).cubicTo(32.015175F, 28.701376F, 27.691122F, 27.781727F, 24.477835F, 28.004059F);
      ((Path)localObject1).cubicTo(24.487751F, 27.357273F, 24.507587F, 26.083914F, 24.517504F, 25.447233F);
      ((Path)localObject1).cubicTo(27.463018F, 25.437128F, 31.42012F, 24.274933F, 31.291193F, 20.535702F);
      ((Path)localObject1).cubicTo(31.519297F, 16.462971F, 26.253077F, 14.825794F, 23.386904F, 16.917742F);
      ((Path)localObject1).cubicTo(21.552156F, 17.999088F, 21.353806F, 20.303263F, 20.88768F, 22.19309F);
      ((Path)localObject1).lineTo(17.585136F, 22.19309F);
      ((Path)localObject1).cubicTo(18.011591F, 19.130964F, 18.914087F, 15.684807F, 21.829847F, 14.14869F);
      ((Path)localObject1).lineTo(21.829847F, 14.14869F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.bakmove_step3
 * JD-Core Version:    0.7.0.1
 */