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

public class icons_outlined_ban_chats
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
      localObject = c.instancePaint(localPaint, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(4.33865F, 6.036916F);
      localPath.lineTo(5.187309F, 6.885722F);
      localPath.cubicTo(3.94282F, 8.14978F, 3.2F, 9.761186F, 3.2F, 11.5F);
      localPath.cubicTo(3.2F, 13.575924F, 4.25693F, 15.526096F, 6.100595F, 16.911364F);
      localPath.lineTo(6.65126F, 17.325113F);
      localPath.lineTo(6.416194F, 19.34734F);
      localPath.lineTo(8.667453F, 18.267838F);
      localPath.lineTo(9.10724F, 18.395193F);
      localPath.cubicTo(10.028542F, 18.661985F, 11.00221F, 18.799999F, 12.0F, 18.799999F);
      localPath.cubicTo(13.531021F, 18.799999F, 14.964503F, 18.476244F, 16.211903F, 17.909487F);
      localPath.lineTo(17.110563F, 18.80768F);
      localPath.cubicTo(15.614987F, 19.564985F, 13.86726F, 20.0F, 12.0F, 20.0F);
      localPath.cubicTo(10.871017F, 20.0F, 9.78573F, 19.840973F, 8.773454F, 19.547836F);
      localPath.lineTo(5.790501F, 20.978193F);
      localPath.cubicTo(5.705353F, 21.019022F, 5.610383F, 21.034904F, 5.516583F, 21.024002F);
      localPath.cubicTo(5.242288F, 20.992117F, 5.045775F, 20.74391F, 5.077659F, 20.469614F);
      localPath.lineTo(5.379757F, 17.870733F);
      localPath.cubicTo(3.306998F, 16.313334F, 2.0F, 14.036405F, 2.0F, 11.5F);
      localPath.cubicTo(2.0F, 9.419866F, 2.879064F, 7.514251F, 4.33865F, 6.036916F);
      localPath.close();
      localPath.moveTo(12.0F, 3.0F);
      localPath.cubicTo(17.522848F, 3.0F, 22.0F, 6.80558F, 22.0F, 11.5F);
      localPath.cubicTo(22.0F, 14.210763F, 20.507133F, 16.625151F, 18.182104F, 18.181562F);
      localPath.lineTo(17.315809F, 17.314682F);
      localPath.cubicTo(19.439318F, 15.973351F, 20.799999F, 13.853369F, 20.799999F, 11.5F);
      localPath.cubicTo(20.799999F, 7.515484F, 16.899429F, 4.2F, 12.0F, 4.2F);
      localPath.cubicTo(9.715966F, 4.2F, 7.649012F, 4.920545F, 6.093122F, 6.093511F);
      localPath.lineTo(5.238181F, 5.237689F);
      localPath.cubicTo(7.018337F, 3.848201F, 9.392634F, 3.0F, 12.0F, 3.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(3.848529F, 3.848528F);
      ((Path)localObject).lineTo(4.697057F, 3.0F);
      ((Path)localObject).lineTo(21.424978F, 19.727922F);
      ((Path)localObject).lineTo(20.57645F, 20.57645F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_ban_chats
 * JD-Core Version:    0.7.0.1
 */