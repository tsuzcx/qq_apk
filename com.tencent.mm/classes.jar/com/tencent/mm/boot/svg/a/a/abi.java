package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class abi
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-436207616);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(11.285586F, 5.464466F);
      localPath.cubicTo(11.468393F, 5.647273F, 11.704096F, 5.874633F, 11.992693F, 6.146545F);
      localPath.cubicTo(12.281291F, 5.874633F, 12.516994F, 5.647273F, 12.6998F, 5.464466F);
      localPath.cubicTo(14.652422F, 3.511845F, 17.818247F, 3.511845F, 19.770868F, 5.464466F);
      localPath.cubicTo(21.705326F, 7.398924F, 21.72332F, 10.52412F, 19.82485F, 12.480731F);
      localPath.lineTo(19.676683F, 12.627813F);
      localPath.cubicTo(19.085428F, 11.355511F, 17.983234F, 10.5F, 16.721153F, 10.5F);
      localPath.cubicTo(15.306767F, 10.5F, 14.093185F, 11.574452F, 13.57438F, 13.104225F);
      localPath.cubicTo(12.694549F, 13.166085F, 12.0F, 13.899432F, 12.0F, 14.795F);
      localPath.lineTo(12.0F, 14.795F);
      localPath.lineTo(12.000716F, 19.8995F);
      localPath.cubicTo(11.742132F, 19.901571F, 11.482896F, 19.803965F, 11.285586F, 19.606676F);
      localPath.lineTo(4.160126F, 12.481141F);
      localPath.cubicTo(2.262066F, 10.52412F, 2.280061F, 7.398924F, 4.214519F, 5.464466F);
      localPath.cubicTo(6.167141F, 3.511845F, 9.332965F, 3.511845F, 11.285586F, 5.464466F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(16.75F, 11.625F);
      ((Path)localObject).cubicTo(17.992641F, 11.625F, 19.0F, 12.699516F, 19.0F, 14.025F);
      ((Path)localObject).lineTo(19.0F, 14.25F);
      ((Path)localObject).lineTo(19.753452F, 14.25F);
      ((Path)localObject).cubicTo(20.165758F, 14.25F, 20.5F, 14.585024F, 20.5F, 14.996957F);
      ((Path)localObject).lineTo(20.5F, 19.128044F);
      ((Path)localObject).cubicTo(20.5F, 19.540577F, 20.158251F, 19.875F, 19.753452F, 19.875F);
      ((Path)localObject).lineTo(13.746549F, 19.875F);
      ((Path)localObject).cubicTo(13.334241F, 19.875F, 13.0F, 19.539976F, 13.0F, 19.128044F);
      ((Path)localObject).lineTo(13.0F, 14.996957F);
      ((Path)localObject).cubicTo(13.0F, 14.584424F, 13.341748F, 14.25F, 13.746549F, 14.25F);
      ((Path)localObject).lineTo(14.5F, 14.25F);
      ((Path)localObject).lineTo(14.5F, 14.025F);
      ((Path)localObject).cubicTo(14.5F, 12.699516F, 15.50736F, 11.625F, 16.75F, 11.625F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.75F, 12.525F);
      ((Path)localObject).cubicTo(16.017862F, 12.525F, 15.4F, 13.184053F, 15.4F, 14.025F);
      ((Path)localObject).lineTo(15.4F, 14.25F);
      ((Path)localObject).lineTo(18.1F, 14.25F);
      ((Path)localObject).lineTo(18.1F, 14.025F);
      ((Path)localObject).cubicTo(18.1F, 13.184053F, 17.482138F, 12.525F, 16.75F, 12.525F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.abi
 * JD-Core Version:    0.7.0.1
 */