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

public class icons_outlined_umbrella
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
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(12.0F, 11.206182F);
      localPath.cubicTo(12.298234F, 11.206182F, 12.545647F, 11.423773F, 12.592147F, 11.708859F);
      localPath.lineTo(12.6F, 11.806183F);
      localPath.lineTo(12.6F, 19.486572F);
      localPath.cubicTo(12.6F, 20.867285F, 11.523762F, 21.996628F, 10.164428F, 22.081457F);
      localPath.lineTo(10.0F, 22.086573F);
      localPath.lineTo(9.787842F, 22.086573F);
      localPath.cubicTo(8.40713F, 22.086573F, 7.277787F, 21.010334F, 7.192957F, 19.651001F);
      localPath.lineTo(7.187842F, 19.486572F);
      localPath.lineTo(7.187842F, 19.241272F);
      localPath.cubicTo(7.187842F, 18.909901F, 7.456471F, 18.641272F, 7.787842F, 18.641272F);
      localPath.cubicTo(8.086076F, 18.641272F, 8.333489F, 18.858862F, 8.379989F, 19.14395F);
      localPath.lineTo(8.387842F, 19.241272F);
      localPath.lineTo(8.387842F, 19.486572F);
      localPath.cubicTo(8.387842F, 20.214289F, 8.94307F, 20.812325F, 9.653012F, 20.880163F);
      localPath.lineTo(9.787842F, 20.886572F);
      localPath.lineTo(10.0F, 20.886572F);
      localPath.cubicTo(10.727716F, 20.886572F, 11.325752F, 20.331343F, 11.393591F, 19.621401F);
      localPath.lineTo(11.4F, 19.486572F);
      localPath.lineTo(11.4F, 11.806183F);
      localPath.cubicTo(11.4F, 11.474812F, 11.66863F, 11.206182F, 12.0F, 11.206182F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(12.0F, 2.0F);
      localPath.cubicTo(12.298234F, 2.0F, 12.545647F, 2.21759F, 12.592147F, 2.502677F);
      localPath.lineTo(12.6F, 2.6F);
      localPath.lineTo(12.6F, 3.388025F);
      localPath.cubicTo(12.6F, 3.719396F, 12.33137F, 3.988025F, 12.0F, 3.988025F);
      localPath.cubicTo(11.701766F, 3.988025F, 11.454353F, 3.770435F, 11.407853F, 3.485348F);
      localPath.lineTo(11.4F, 3.388025F);
      localPath.lineTo(11.4F, 2.6F);
      localPath.cubicTo(11.4F, 2.268629F, 11.66863F, 2.0F, 12.0F, 2.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 3.0F);
      ((Path)localObject).cubicTo(17.522848F, 3.0F, 22.0F, 7.477152F, 22.0F, 13.0F);
      ((Path)localObject).lineTo(21.99679F, 13.2559F);
      ((Path)localObject).cubicTo(21.04615F, 12.470693F, 19.828043F, 12.0F, 18.5F, 12.0F);
      ((Path)localObject).cubicTo(17.222574F, 12.0F, 16.046865F, 12.435496F, 15.113922F, 13.165782F);
      ((Path)localObject).cubicTo(14.228573F, 12.556596F, 13.155931F, 12.2F, 12.0F, 12.2F);
      ((Path)localObject).cubicTo(10.844069F, 12.2F, 9.771427F, 12.556596F, 8.88676F, 13.166119F);
      ((Path)localObject).cubicTo(7.953135F, 12.435496F, 6.777425F, 12.0F, 5.5F, 12.0F);
      ((Path)localObject).cubicTo(4.171528F, 12.0F, 2.953063F, 12.470997F, 2.002483F, 13.255113F);
      ((Path)localObject).lineTo(2.0F, 13.0F);
      ((Path)localObject).cubicTo(2.0F, 7.477152F, 6.477152F, 3.0F, 12.0F, 3.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 4.2F);
      ((Path)localObject).cubicTo(7.834195F, 4.2F, 4.344464F, 7.094616F, 3.432379F, 10.974886F);
      ((Path)localObject).lineTo(3.396F, 11.138F);
      ((Path)localObject).lineTo(3.4972F, 11.104778F);
      ((Path)localObject).cubicTo(4.045496F, 10.933295F, 4.618878F, 10.831864F, 5.205589F, 10.806384F);
      ((Path)localObject).lineTo(5.5F, 10.8F);
      ((Path)localObject).cubicTo(6.61134F, 10.8F, 7.682928F, 11.072138F, 8.636548F, 11.578147F);
      ((Path)localObject).lineTo(8.931F, 11.744F);
      ((Path)localObject).lineTo(9.003594F, 11.706253F);
      ((Path)localObject).cubicTo(9.830683F, 11.29174F, 10.740587F, 11.051286F, 11.684259F, 11.007339F);
      ((Path)localObject).lineTo(12.0F, 11.0F);
      ((Path)localObject).cubicTo(13.055876F, 11.0F, 14.07688F, 11.245533F, 14.996115F, 11.705804F);
      ((Path)localObject).lineTo(15.069F, 11.744F);
      ((Path)localObject).lineTo(15.106622F, 11.721795F);
      ((Path)localObject).cubicTo(16.037876F, 11.173693F, 17.094498F, 10.855881F, 18.197954F, 10.806719F);
      ((Path)localObject).lineTo(18.5F, 10.8F);
      ((Path)localObject).cubicTo(19.189444F, 10.8F, 19.863317F, 10.904756F, 20.502981F, 11.104957F);
      ((Path)localObject).lineTo(20.601F, 11.138F);
      ((Path)localObject).lineTo(20.567585F, 10.982241F);
      ((Path)localObject).cubicTo(19.674538F, 7.175608F, 16.310091F, 4.32104F, 12.259465F, 4.203752F);
      ((Path)localObject).lineTo(12.0F, 4.2F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_umbrella
 * JD-Core Version:    0.7.0.1
 */