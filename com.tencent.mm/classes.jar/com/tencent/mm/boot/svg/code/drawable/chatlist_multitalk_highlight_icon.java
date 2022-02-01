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

public class chatlist_multitalk_highlight_icon
  extends c
{
  private final int height = 45;
  private final int width = 45;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 45;
      return 45;
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
      localPaint.setColor(-15028967);
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(18.074301F, 25.925699F);
      localPath.cubicTo(21.81657F, 29.667971F, 25.362413F, 31.423225F, 26.673681F, 31.320438F);
      localPath.cubicTo(27.984949F, 31.217651F, 31.250372F, 28.972013F, 32.791916F, 29.001904F);
      localPath.cubicTo(33.532799F, 29.01627F, 38.374222F, 32.290524F, 38.960274F, 32.669083F);
      localPath.cubicTo(39.546329F, 33.047638F, 40.089733F, 33.489841F, 39.987553F, 34.049404F);
      localPath.cubicTo(39.885376F, 34.608967F, 37.757626F, 40.772552F, 32.325485F, 39.919037F);
      localPath.cubicTo(26.893343F, 39.065521F, 19.320179F, 33.209579F, 15.004804F, 28.995195F);
      localPath.lineTo(18.074301F, 25.925699F);
      localPath.lineTo(18.074301F, 25.925699F);
      localPath.close();
      localPath.moveTo(18.074301F, 25.925699F);
      localPath.cubicTo(14.33203F, 22.18343F, 12.576774F, 18.637587F, 12.679562F, 17.326319F);
      localPath.cubicTo(12.782349F, 16.015051F, 15.027987F, 12.749629F, 14.998096F, 11.208082F);
      localPath.cubicTo(14.983731F, 10.467202F, 11.709476F, 5.625779F, 11.330918F, 5.039724F);
      localPath.cubicTo(10.952361F, 4.45367F, 10.510159F, 3.910268F, 9.950595F, 4.012446F);
      localPath.cubicTo(9.391031F, 4.114624F, 3.227449F, 6.242374F, 4.080963F, 11.674515F);
      localPath.cubicTo(4.934478F, 17.106657F, 10.790419F, 24.679821F, 15.004804F, 28.995195F);
      localPath.lineTo(18.074301F, 25.925699F);
      localPath.lineTo(18.074301F, 25.925699F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(39.25F, 16.954916F);
      ((Path)localObject).cubicTo(39.652576F, 17.126341F, 40.0F, 16.789431F, 40.0F, 16.273945F);
      ((Path)localObject).lineTo(40.0F, 7.718901F);
      ((Path)localObject).cubicTo(40.0F, 7.141902F, 39.615803F, 6.899748F, 39.25F, 7.03793F);
      ((Path)localObject).cubicTo(39.033016F, 7.290326F, 36.0F, 10.012693F, 36.0F, 10.012693F);
      ((Path)localObject).lineTo(36.0F, 13.939582F);
      ((Path)localObject).cubicTo(36.0F, 13.939582F, 39.103306F, 16.747684F, 39.25F, 16.954916F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(22.0F, 8.47057F);
      ((Path)localObject).cubicTo(22.0F, 8.210681F, 22.256189F, 8.0F, 22.570713F, 8.0F);
      ((Path)localObject).lineTo(33.429287F, 8.0F);
      ((Path)localObject).cubicTo(33.744484F, 8.0F, 34.0F, 8.209868F, 34.0F, 8.47057F);
      ((Path)localObject).lineTo(34.0F, 15.52943F);
      ((Path)localObject).cubicTo(34.0F, 15.789319F, 33.743813F, 16.0F, 33.429287F, 16.0F);
      ((Path)localObject).lineTo(22.570713F, 16.0F);
      ((Path)localObject).cubicTo(22.255516F, 16.0F, 22.0F, 15.790132F, 22.0F, 15.52943F);
      ((Path)localObject).lineTo(22.0F, 8.47057F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.chatlist_multitalk_highlight_icon
 * JD-Core Version:    0.7.0.1
 */