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

public class backup_move
  extends c
{
  private final int height = 372;
  private final int width = 438;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 438;
      return 372;
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
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-15028967);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(179.05263F, 156.0F);
      localPath.cubicTo(177.91896F, 156.0F, 177.0F, 154.65694F, 177.0F, 153.00008F);
      localPath.cubicTo(177.0F, 151.34306F, 177.91896F, 150.0F, 179.05263F, 150.0F);
      localPath.lineTo(244.52821F, 150.0F);
      localPath.cubicTo(245.66188F, 150.0F, 246.58084F, 151.34306F, 246.58084F, 152.99992F);
      localPath.cubicTo(246.58084F, 154.65678F, 245.66188F, 156.0F, 244.52821F, 156.0F);
      localPath.lineTo(179.05263F, 156.0F);
      localPath.close();
      localPath.moveTo(179.49249F, 174.68736F);
      localPath.cubicTo(178.11589F, 174.68736F, 177.0F, 173.3443F, 177.0F, 171.68744F);
      localPath.cubicTo(177.0F, 170.03043F, 178.11589F, 168.68736F, 179.49249F, 168.68736F);
      localPath.lineTo(258.99854F, 168.68736F);
      localPath.cubicTo(260.37515F, 168.68736F, 261.49103F, 170.03043F, 261.49103F, 171.68729F);
      localPath.cubicTo(261.49103F, 173.3443F, 260.37515F, 174.68736F, 258.99854F, 174.68736F);
      localPath.lineTo(179.49249F, 174.68736F);
      localPath.close();
      localPath.moveTo(179.45447F, 193.47983F);
      localPath.cubicTo(178.09886F, 193.47983F, 177.0F, 192.13673F, 177.0F, 190.47983F);
      localPath.cubicTo(177.0F, 188.82294F, 178.09886F, 187.47983F, 179.45447F, 187.47983F);
      localPath.lineTo(219.27608F, 187.47983F);
      localPath.cubicTo(220.63168F, 187.47983F, 221.73055F, 188.82294F, 221.73055F, 190.47983F);
      localPath.cubicTo(221.73042F, 192.13673F, 220.63155F, 193.47983F, 219.27608F, 193.47983F);
      localPath.lineTo(179.45447F, 193.47983F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(247.0F, 120.0F);
      localPath.lineTo(247.0F, 45.0F);
      localPath.lineTo(419.0F, 45.0F);
      localPath.lineTo(419.0F, 318.0F);
      localPath.lineTo(247.0F, 318.0F);
      localPath.lineTo(247.0F, 225.46962F);
      localPath.lineTo(248.5F, 225.46962F);
      localPath.lineTo(248.5F, 316.5F);
      localPath.lineTo(417.5F, 316.5F);
      localPath.lineTo(417.5F, 46.5F);
      localPath.lineTo(248.5F, 46.5F);
      localPath.lineTo(248.5F, 120.0F);
      localPath.lineTo(247.0F, 120.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(234.0F, 120.0F);
      localPath.lineTo(234.0F, 21.991756F);
      localPath.cubicTo(234.0F, 13.170865F, 241.1606F, 6.0F, 249.99364F, 6.0F);
      localPath.lineTo(416.00635F, 6.0F);
      localPath.cubicTo(424.83609F, 6.0F, 432.0F, 13.159754F, 432.0F, 21.991756F);
      localPath.lineTo(432.0F, 350.00824F);
      localPath.cubicTo(432.0F, 358.82913F, 424.83942F, 366.0F, 416.00635F, 366.0F);
      localPath.lineTo(249.99364F, 366.0F);
      localPath.cubicTo(241.16389F, 366.0F, 234.0F, 358.84024F, 234.0F, 350.00824F);
      localPath.lineTo(234.0F, 225.46962F);
      localPath.lineTo(237.0F, 225.46962F);
      localPath.lineTo(237.0F, 350.00754F);
      localPath.cubicTo(237.0F, 357.18307F, 242.82472F, 363.0F, 250.00838F, 363.0F);
      localPath.lineTo(415.99164F, 363.0F);
      localPath.cubicTo(423.17596F, 363.0F, 429.0F, 357.18747F, 429.0F, 350.00754F);
      localPath.lineTo(429.0F, 21.992458F);
      localPath.cubicTo(429.0F, 14.816921F, 423.17526F, 9.0F, 415.99164F, 9.0F);
      localPath.lineTo(250.00838F, 9.0F);
      localPath.cubicTo(242.82405F, 9.0F, 237.0F, 14.812543F, 237.0F, 21.992458F);
      localPath.lineTo(237.0F, 120.0F);
      localPath.lineTo(234.0F, 120.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(320.0F, 24.0F);
      localPath.lineTo(346.0F, 24.0F);
      localPath.lineTo(346.0F, 27.0F);
      localPath.lineTo(320.0F, 27.0F);
      localPath.lineTo(320.0F, 24.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(171.0F, 225.46962F);
      localPath.lineTo(171.0F, 312.00461F);
      localPath.cubicTo(171.0F, 320.83633F, 163.83279F, 328.0F, 154.99161F, 328.0F);
      localPath.lineTo(22.008387F, 328.0F);
      localPath.cubicTo(13.169351F, 328.0F, 6.0F, 320.83862F, 6.0F, 312.00461F);
      localPath.lineTo(6.0F, 45.995407F);
      localPath.cubicTo(6.0F, 37.163662F, 13.167199F, 30.0F, 22.008387F, 30.0F);
      localPath.lineTo(154.99161F, 30.0F);
      localPath.cubicTo(163.83064F, 30.0F, 171.0F, 37.161388F, 171.0F, 45.995407F);
      localPath.lineTo(171.0F, 120.0F);
      localPath.lineTo(168.0F, 120.0F);
      localPath.lineTo(168.0F, 45.994846F);
      localPath.cubicTo(168.0F, 38.817989F, 162.17625F, 33.0F, 155.00523F, 33.0F);
      localPath.lineTo(21.99477F, 33.0F);
      localPath.cubicTo(14.817957F, 33.0F, 9.0F, 38.816368F, 9.0F, 45.994846F);
      localPath.lineTo(9.0F, 312.00516F);
      localPath.cubicTo(9.0F, 319.18201F, 14.823739F, 325.0F, 21.99477F, 325.0F);
      localPath.lineTo(155.00523F, 325.0F);
      localPath.cubicTo(162.18204F, 325.0F, 168.0F, 319.18362F, 168.0F, 312.00516F);
      localPath.lineTo(168.0F, 225.46962F);
      localPath.lineTo(171.0F, 225.46962F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(161.0F, 225.46962F);
      localPath.lineTo(161.0F, 288.0F);
      localPath.lineTo(18.0F, 288.0F);
      localPath.lineTo(18.0F, 62.0F);
      localPath.lineTo(161.0F, 62.0F);
      localPath.lineTo(161.0F, 120.0F);
      localPath.lineTo(159.5F, 120.0F);
      localPath.lineTo(159.5F, 63.5F);
      localPath.lineTo(19.5F, 63.5F);
      localPath.lineTo(19.5F, 286.5F);
      localPath.lineTo(159.5F, 286.5F);
      localPath.lineTo(159.5F, 225.46962F);
      localPath.lineTo(161.0F, 225.46962F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(77.0F, 45.0F);
      localPath.lineTo(100.0F, 45.0F);
      localPath.lineTo(100.0F, 47.5F);
      localPath.lineTo(77.0F, 47.5F);
      localPath.lineTo(77.0F, 45.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(182.65118F, 249.89926F);
      ((Path)localObject).lineTo(182.5955F, 225.46962F);
      ((Path)localObject).lineTo(155.88837F, 225.46962F);
      ((Path)localObject).cubicTo(149.33305F, 225.46962F, 144.0F, 220.17123F, 144.0F, 213.65854F);
      ((Path)localObject).lineTo(144.0F, 131.81108F);
      ((Path)localObject).cubicTo(144.0F, 125.29839F, 149.33305F, 120.0F, 155.88837F, 120.0F);
      ((Path)localObject).lineTo(282.11163F, 120.0F);
      ((Path)localObject).cubicTo(288.66693F, 120.0F, 294.0F, 125.29839F, 294.0F, 131.81108F);
      ((Path)localObject).lineTo(294.0F, 213.65854F);
      ((Path)localObject).cubicTo(294.0F, 220.17123F, 288.66693F, 225.46962F, 282.11163F, 225.46962F);
      ((Path)localObject).lineTo(219.13837F, 225.46962F);
      ((Path)localObject).lineTo(191.35858F, 253.56952F);
      ((Path)localObject).cubicTo(190.35439F, 254.50647F, 189.10912F, 254.99985F, 187.80786F, 255.0F);
      ((Path)localObject).cubicTo(184.97136F, 255.00031F, 182.6581F, 252.7121F, 182.65118F, 249.89926F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(185.58853F, 247.54555F);
      ((Path)localObject).lineTo(185.60806F, 222.6283F);
      ((Path)localObject).lineTo(158.50444F, 222.48622F);
      ((Path)localObject).cubicTo(150.85406F, 222.5878F, 147.13077F, 218.84735F, 147.09161F, 211.11259F);
      ((Path)localObject).lineTo(147.0F, 134.37363F);
      ((Path)localObject).cubicTo(147.13213F, 125.48259F, 152.01384F, 122.98F, 158.41283F, 123.0F);
      ((Path)localObject).lineTo(279.58716F, 123.0F);
      ((Path)localObject).cubicTo(289.20505F, 123.0F, 291.02707F, 128.21953F, 291.0F, 134.37363F);
      ((Path)localObject).lineTo(291.09161F, 211.11259F);
      ((Path)localObject).cubicTo(291.11636F, 218.63168F, 288.02811F, 222.59373F, 279.67877F, 222.48622F);
      ((Path)localObject).lineTo(217.95168F, 222.58171F);
      ((Path)localObject).lineTo(190.55521F, 250.40294F);
      ((Path)localObject).cubicTo(189.59119F, 251.30519F, 188.85378F, 251.84087F, 187.63156F, 251.84087F);
      ((Path)localObject).cubicTo(185.60806F, 251.86566F, 185.59517F, 250.2542F, 185.58853F, 247.54555F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.backup_move
 * JD-Core Version:    0.7.0.1
 */