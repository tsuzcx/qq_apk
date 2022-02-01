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

public class default_readerapp
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 192;
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
      ((Paint)localObject).setColor(-1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(192.0F, 0.0F);
      localPath.lineTo(192.0F, 192.0F);
      localPath.lineTo(0.0F, 192.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(96.031303F, 160.60699F);
      localPath.cubicTo(131.821F, 160.60699F, 160.83501F, 131.59399F, 160.83501F, 95.803497F);
      localPath.cubicTo(160.83501F, 60.0135F, 131.821F, 31.0F, 96.031303F, 31.0F);
      localPath.cubicTo(60.241299F, 31.0F, 31.2278F, 60.0135F, 31.2278F, 95.803497F);
      localPath.cubicTo(31.2278F, 131.59399F, 60.241299F, 160.60699F, 96.031303F, 160.60699F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-65451);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(141.89F, 141.619F);
      localPath.cubicTo(145.157F, 138.353F, 145.157F, 133.039F, 141.89F, 129.77299F);
      localPath.cubicTo(138.62399F, 126.507F, 133.311F, 126.507F, 130.04401F, 129.77299F);
      localPath.lineTo(130.00101F, 129.73F);
      localPath.cubicTo(105.743F, 152.332F, 68.376602F, 152.942F, 43.422001F, 131.60201F);
      localPath.cubicTo(42.855801F, 131.123F, 42.071899F, 131.82001F, 42.507401F, 132.47301F);
      localPath.cubicTo(44.7285F, 135.696F, 47.254398F, 138.78799F, 50.128799F, 141.662F);
      localPath.cubicTo(75.475304F, 167.009F, 116.5F, 167.009F, 141.847F, 141.70599F);
      localPath.cubicTo(141.847F, 141.662F, 141.847F, 141.619F, 141.89F, 141.619F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-13904215);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(112.973F, 33.0905F);
      localPath.lineTo(112.929F, 33.0905F);
      localPath.cubicTo(112.929F, 33.0905F, 112.929F, 33.0905F, 112.885F, 33.0905F);
      localPath.cubicTo(112.842F, 33.0905F, 112.842F, 33.0905F, 112.798F, 33.046902F);
      localPath.cubicTo(108.356F, 31.9146F, 103.827F, 34.571201F, 102.607F, 39.013401F);
      localPath.cubicTo(101.432F, 43.455601F, 104.045F, 48.0284F, 108.443F, 49.247799F);
      localPath.lineTo(108.443F, 49.291401F);
      localPath.cubicTo(140.192F, 58.959599F, 159.44099F, 90.969398F, 153.431F, 123.284F);
      localPath.cubicTo(153.30099F, 124.024F, 154.302F, 124.329F, 154.651F, 123.676F);
      localPath.cubicTo(156.349F, 120.148F, 157.69901F, 116.403F, 158.78799F, 112.484F);
      localPath.cubicTo(168.021F, 77.904198F, 147.508F, 42.410301F, 112.973F, 33.0905F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-11233);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(91.023003F, 31.126801F);
      localPath.cubicTo(87.103401F, 31.4317F, 83.1838F, 32.0849F, 79.264297F, 33.1301F);
      localPath.cubicTo(44.597801F, 42.319401F, 23.998301F, 77.856796F, 33.1875F, 112.523F);
      localPath.cubicTo(34.4505F, 116.922F, 38.979801F, 119.535F, 43.422001F, 118.359F);
      localPath.cubicTo(47.864201F, 117.183F, 50.520802F, 112.654F, 49.388401F, 108.212F);
      localPath.cubicTo(41.984798F, 75.853401F, 60.188999F, 43.233898F, 91.197197F, 32.389801F);
      localPath.cubicTo(91.981102F, 32.128502F, 91.763298F, 31.0833F, 91.023003F, 31.126801F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16756012);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(120.855F, 101.378F);
      ((Path)localObject).cubicTo(120.289F, 99.549103F, 119.505F, 97.4151F, 118.721F, 95.368202F);
      ((Path)localObject).lineTo(115.847F, 88.225899F);
      ((Path)localObject).cubicTo(115.847F, 88.138802F, 115.89F, 86.745201F, 115.89F, 86.004799F);
      ((Path)localObject).cubicTo(115.89F, 73.8106F, 110.142F, 61.529301F, 95.987701F, 61.529301F);
      ((Path)localObject).cubicTo(81.833702F, 61.529301F, 76.084999F, 73.8106F, 76.084999F, 86.004799F);
      ((Path)localObject).cubicTo(76.084999F, 86.745201F, 76.128502F, 88.138802F, 76.128502F, 88.225899F);
      ((Path)localObject).lineTo(73.254204F, 95.368202F);
      ((Path)localObject).cubicTo(72.470299F, 97.4151F, 71.686401F, 99.549103F, 71.120201F, 101.378F);
      ((Path)localObject).cubicTo(68.420097F, 110.088F, 69.2911F, 113.66F, 69.944298F, 113.747F);
      ((Path)localObject).cubicTo(71.3815F, 113.921F, 75.518799F, 107.214F, 75.518799F, 107.214F);
      ((Path)localObject).cubicTo(75.518799F, 111.09F, 77.522202F, 116.186F, 81.833702F, 119.844F);
      ((Path)localObject).cubicTo(80.222298F, 120.323F, 78.219002F, 121.107F, 76.956001F, 122.065F);
      ((Path)localObject).cubicTo(75.8237F, 122.892F, 75.9543F, 123.763F, 76.172096F, 124.112F);
      ((Path)localObject).cubicTo(77.0867F, 125.636F, 91.763298F, 125.07F, 95.987701F, 124.634F);
      ((Path)localObject).cubicTo(100.212F, 125.113F, 114.889F, 125.68F, 115.803F, 124.112F);
      ((Path)localObject).cubicTo(116.021F, 123.763F, 116.152F, 122.892F, 115.019F, 122.065F);
      ((Path)localObject).cubicTo(113.756F, 121.107F, 111.753F, 120.366F, 110.142F, 119.844F);
      ((Path)localObject).cubicTo(114.453F, 116.186F, 116.457F, 111.09F, 116.457F, 107.214F);
      ((Path)localObject).cubicTo(116.457F, 107.214F, 120.594F, 113.921F, 122.031F, 113.747F);
      ((Path)localObject).cubicTo(122.684F, 113.66F, 123.555F, 110.045F, 120.855F, 101.378F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.default_readerapp
 * JD-Core Version:    0.7.0.1
 */