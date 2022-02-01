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

public class default_readerapp_plugin
  extends c
{
  private final int height = 58;
  private final int width = 58;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 58;
      return 58;
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
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16756007);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(58.0F, 0.0F);
      localPath.lineTo(58.0F, 58.0F);
      localPath.lineTo(0.0F, 58.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(43.120098F, 42.996799F);
      localPath.cubicTo(44.125099F, 41.991798F, 44.125099F, 40.356998F, 43.120098F, 39.352001F);
      localPath.cubicTo(42.115002F, 38.347F, 40.480202F, 38.347F, 39.475201F, 39.352001F);
      localPath.lineTo(39.4618F, 39.3386F);
      localPath.cubicTo(31.9979F, 46.293301F, 20.5005F, 46.494301F, 12.8221F, 39.914799F);
      localPath.cubicTo(12.6479F, 39.767399F, 12.4067F, 39.9818F, 12.5407F, 40.1828F);
      localPath.cubicTo(13.2241F, 41.1744F, 14.0013F, 42.125801F, 14.8858F, 43.010201F);
      localPath.cubicTo(22.6847F, 50.8092F, 35.307701F, 50.8092F, 43.106701F, 43.023602F);
      localPath.cubicTo(43.106701F, 43.010201F, 43.106701F, 42.996799F, 43.120098F, 42.996799F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(34.222301F, 9.60338F);
      localPath.lineTo(34.2089F, 9.60338F);
      localPath.cubicTo(34.2089F, 9.60338F, 34.2089F, 9.60338F, 34.195499F, 9.60338F);
      localPath.cubicTo(34.182098F, 9.60338F, 34.182098F, 9.60338F, 34.168701F, 9.58998F);
      localPath.cubicTo(32.801899F, 9.24158F, 31.4083F, 10.059F, 31.0331F, 11.4258F);
      localPath.cubicTo(30.6712F, 12.7926F, 31.4753F, 14.1997F, 32.828701F, 14.5749F);
      localPath.lineTo(32.828701F, 14.5883F);
      localPath.cubicTo(42.5975F, 17.563101F, 48.520401F, 27.4123F, 46.671101F, 37.355301F);
      localPath.cubicTo(46.630901F, 37.583099F, 46.939098F, 37.676899F, 47.046299F, 37.475899F);
      localPath.cubicTo(47.568901F, 36.390499F, 47.984299F, 35.237999F, 48.319401F, 34.032001F);
      localPath.cubicTo(51.160198F, 23.3922F, 44.848701F, 12.471F, 34.222301F, 9.60338F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(27.468599F, 9.00041F);
      localPath.cubicTo(26.2626F, 9.09421F, 25.056601F, 9.29521F, 23.8505F, 9.61682F);
      localPath.cubicTo(13.1839F, 12.4443F, 6.84564F, 23.378901F, 9.67309F, 34.045399F);
      localPath.cubicTo(10.0617F, 35.398899F, 11.4553F, 36.2029F, 12.8221F, 35.841099F);
      localPath.cubicTo(14.189F, 35.479301F, 15.0064F, 34.085602F, 14.658F, 32.7188F);
      localPath.cubicTo(12.3799F, 22.7624F, 17.981199F, 12.7257F, 27.5222F, 9.38901F);
      localPath.cubicTo(27.763399F, 9.30861F, 27.6964F, 8.98701F, 27.468599F, 9.00041F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(36.647701F, 30.615F);
      ((Path)localObject).cubicTo(36.473499F, 30.0522F, 36.2323F, 29.395599F, 35.9911F, 28.765699F);
      ((Path)localObject).lineTo(35.106701F, 26.5681F);
      ((Path)localObject).cubicTo(35.106701F, 26.5413F, 35.120098F, 26.112499F, 35.120098F, 25.884701F);
      ((Path)localObject).cubicTo(35.120098F, 22.132601F, 33.351299F, 18.3538F, 28.996201F, 18.3538F);
      ((Path)localObject).cubicTo(24.6411F, 18.3538F, 22.872299F, 22.132601F, 22.872299F, 25.884701F);
      ((Path)localObject).cubicTo(22.872299F, 26.112499F, 22.8857F, 26.5413F, 22.8857F, 26.5681F);
      ((Path)localObject).lineTo(22.001301F, 28.765699F);
      ((Path)localObject).cubicTo(21.760099F, 29.395599F, 21.5189F, 30.0522F, 21.3447F, 30.615F);
      ((Path)localObject).cubicTo(20.513901F, 33.294998F, 20.7819F, 34.393799F, 20.982901F, 34.420601F);
      ((Path)localObject).cubicTo(21.4251F, 34.474201F, 22.698099F, 32.410599F, 22.698099F, 32.410599F);
      ((Path)localObject).cubicTo(22.698099F, 33.603199F, 23.314501F, 35.171101F, 24.6411F, 36.2967F);
      ((Path)localObject).cubicTo(24.1453F, 36.444099F, 23.5289F, 36.685299F, 23.140301F, 36.980099F);
      ((Path)localObject).cubicTo(22.791901F, 37.234699F, 22.8321F, 37.502701F, 22.899099F, 37.609901F);
      ((Path)localObject).cubicTo(23.1805F, 38.078899F, 27.6964F, 37.904701F, 28.996201F, 37.770699F);
      ((Path)localObject).cubicTo(30.296F, 37.918098F, 34.811901F, 38.0923F, 35.0933F, 37.609901F);
      ((Path)localObject).cubicTo(35.160301F, 37.502701F, 35.2005F, 37.234699F, 34.8521F, 36.980099F);
      ((Path)localObject).cubicTo(34.463501F, 36.685299F, 33.847099F, 36.4575F, 33.351299F, 36.2967F);
      ((Path)localObject).cubicTo(34.677898F, 35.171101F, 35.2943F, 33.603199F, 35.2943F, 32.410599F);
      ((Path)localObject).cubicTo(35.2943F, 32.410599F, 36.567299F, 34.474201F, 37.009602F, 34.420601F);
      ((Path)localObject).cubicTo(37.210602F, 34.393799F, 37.4786F, 33.281601F, 36.647701F, 30.615F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.default_readerapp_plugin
 * JD-Core Version:    0.7.0.1
 */