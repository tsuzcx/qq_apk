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

public final class awt
  extends c
{
  private final int height = 450;
  private final int width = 1125;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 1125;
      return 450;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Object localObject1 = c.m(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      c.a((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-830141);
      Object localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(1125.0F, 0.0F);
      ((Path)localObject3).lineTo(1125.0F, 450.0F);
      ((Path)localObject3).lineTo(0.0F, 450.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localObject3 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject3).setColor(-7503);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(935.02209F, 137.71359F);
      ((Path)localObject2).lineTo(922.71289F, 142.13159F);
      ((Path)localObject2).lineTo(927.98267F, 153.08679F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.saveLayerAlpha(null, 51, 31);
      localObject3 = c.a((Paint)localObject3, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject3);
      localCanvas.restore();
      localObject3 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject3).setColor(-7503);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(361.60098F, 63.0F);
      ((Path)localObject2).cubicTo(356.83121F, 63.0F, 351.0058F, 70.355583F, 356.30338F, 74.583969F);
      ((Path)localObject2).cubicTo(361.60098F, 78.812347F, 366.37076F, 63.0F, 361.60098F, 63.0F);
      ((Path)localObject2).close();
      localCanvas.saveLayerAlpha(null, 51, 31);
      localObject3 = c.a((Paint)localObject3, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject3);
      localCanvas.restore();
      localObject3 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject3).setColor(-2130713935);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(196.39885F, 372.45007F);
      ((Path)localObject2).cubicTo(191.62906F, 372.45007F, 185.80365F, 379.80566F, 191.10124F, 384.03406F);
      ((Path)localObject2).cubicTo(196.39885F, 388.26242F, 201.16862F, 372.45007F, 196.39885F, 372.45007F);
      ((Path)localObject2).close();
      localCanvas.saveLayerAlpha(null, 51, 31);
      localObject3 = c.a((Paint)localObject3, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject3);
      localCanvas.restore();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-7503);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(331.19891F, 330.99368F);
      ((Path)localObject1).cubicTo(331.19891F, 330.99368F, 331.79904F, 337.22104F, 334.81866F, 340.22473F);
      ((Path)localObject1).cubicTo(337.83829F, 343.22842F, 336.03473F, 330.85147F, 336.03473F, 330.85147F);
      ((Path)localObject1).lineTo(331.19891F, 330.99368F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 51, 31);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.awt
 * JD-Core Version:    0.7.0.1
 */