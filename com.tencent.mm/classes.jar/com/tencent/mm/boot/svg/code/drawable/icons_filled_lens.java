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

public class icons_filled_lens
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
      localPaint.setColor(-1);
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(12.0F, 22.285715F);
      localPath.cubicTo(6.319357F, 22.285715F, 1.714286F, 17.680643F, 1.714286F, 12.0F);
      localPath.cubicTo(1.714286F, 6.319357F, 6.319357F, 1.714286F, 12.0F, 1.714286F);
      localPath.cubicTo(17.680643F, 1.714286F, 22.285715F, 6.319357F, 22.285715F, 12.0F);
      localPath.cubicTo(22.285715F, 17.680643F, 17.680643F, 22.285715F, 12.0F, 22.285715F);
      localPath.close();
      localPath.moveTo(12.0F, 15.52653F);
      localPath.cubicTo(13.947649F, 15.52653F, 15.52653F, 13.947649F, 15.52653F, 12.0F);
      localPath.cubicTo(15.52653F, 10.052351F, 13.947649F, 8.47347F, 12.0F, 8.47347F);
      localPath.cubicTo(10.052351F, 8.47347F, 8.47347F, 10.052351F, 8.47347F, 12.0F);
      localPath.cubicTo(8.47347F, 13.947649F, 10.052351F, 15.52653F, 12.0F, 15.52653F);
      localPath.close();
      localPath.moveTo(12.0F, 19.934694F);
      localPath.cubicTo(7.61779F, 19.934694F, 4.065306F, 16.38221F, 4.065306F, 12.0F);
      localPath.cubicTo(4.065306F, 7.61779F, 7.61779F, 4.065306F, 12.0F, 4.065306F);
      localPath.cubicTo(16.38221F, 4.065306F, 19.934694F, 7.61779F, 19.934694F, 12.0F);
      localPath.cubicTo(19.934694F, 16.38221F, 16.38221F, 19.934694F, 12.0F, 19.934694F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(16.042969F, 9.010965F);
      ((Path)localObject).cubicTo(15.474904F, 9.010965F, 15.014398F, 8.550458F, 15.014398F, 7.982394F);
      ((Path)localObject).cubicTo(15.014398F, 7.41433F, 15.474904F, 6.953823F, 16.042969F, 6.953823F);
      ((Path)localObject).cubicTo(16.611032F, 6.953823F, 17.071541F, 7.41433F, 17.071541F, 7.982394F);
      ((Path)localObject).cubicTo(17.071541F, 8.550458F, 16.611032F, 9.010965F, 16.042969F, 9.010965F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_lens
 * JD-Core Version:    0.7.0.1
 */