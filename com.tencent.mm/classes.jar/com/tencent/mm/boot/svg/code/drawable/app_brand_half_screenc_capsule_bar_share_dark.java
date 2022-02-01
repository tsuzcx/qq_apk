package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class app_brand_half_screenc_capsule_bar_share_dark
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.STROKE);
      localPaint2.setColor(-16777216);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.BUTT);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localPaint1.setStrokeMiter(4.0F);
      localPaint1.setPathEffect(null);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -24.0F, 0.0F, 1.0F, -383.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 383.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      Paint localPaint3 = c.instancePaint(localPaint2, paramVarArgs);
      Paint localPaint4 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint3.setColor(637534208);
      localPaint4.setColor(1107296255);
      localPaint4.setStrokeWidth(0.5F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(16.0F, 0.25F);
      localPath.cubicTo(24.698486F, 0.25F, 31.75F, 7.301515F, 31.75F, 16.0F);
      localPath.cubicTo(31.75F, 24.698486F, 24.698486F, 31.75F, 16.0F, 31.75F);
      localPath.cubicTo(7.301515F, 31.75F, 0.25F, 24.698486F, 0.25F, 16.0F);
      localPath.cubicTo(0.25F, 7.301515F, 7.301515F, 0.25F, 16.0F, 0.25F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint3);
      localCanvas.drawPath(localPath, localPaint4);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject2).setColor(-65536);
      localPaint2.setColor(-6842473);
      localPaint2.setStrokeWidth(0.75F);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.375F, 0.375F);
      ((Path)localObject1).lineTo(23.625F, 0.375F);
      ((Path)localObject1).lineTo(23.625F, 23.625F);
      ((Path)localObject1).lineTo(0.375F, 23.625F);
      ((Path)localObject1).lineTo(0.375F, 0.375F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.drawPath((Path)localObject1, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localPaint1.setStrokeWidth(1.4F);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(13.972332F, 4.900759F);
      ((Path)localObject1).cubicTo(14.071325F, 4.900759F, 14.166303F, 4.939902F, 14.23655F, 5.009651F);
      ((Path)localObject1).lineTo(19.047237F, 9.786202F);
      ((Path)localObject1).cubicTo(19.341171F, 10.07805F, 19.342863F, 10.55292F, 19.051014F, 10.846854F);
      ((Path)localObject1).lineTo(19.047237F, 10.850631F);
      ((Path)localObject1).lineTo(14.23655F, 15.627181F);
      ((Path)localObject1).cubicTo(14.089583F, 15.773106F, 13.852148F, 15.77226F, 13.706224F, 15.625293F);
      ((Path)localObject1).cubicTo(13.636475F, 15.555045F, 13.597332F, 15.460068F, 13.597332F, 15.361073F);
      ((Path)localObject1).lineTo(13.597443F, 11.939095F);
      ((Path)localObject1).cubicTo(8.348105F, 11.809454F, 6.297263F, 16.47753F, 5.638596F, 18.198992F);
      ((Path)localObject1).lineTo(5.563353F, 18.39835F);
      ((Path)localObject1).cubicTo(5.426857F, 18.764101F, 5.372739F, 18.925327F, 5.372739F, 18.760862F);
      ((Path)localObject1).cubicTo(4.890029F, 13.352647F, 7.572263F, 8.40489F, 13.596654F, 8.059141F);
      ((Path)localObject1).lineTo(13.597332F, 5.275759F);
      ((Path)localObject1).cubicTo(13.597332F, 5.068652F, 13.765224F, 4.900759F, 13.972332F, 4.900759F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_half_screenc_capsule_bar_share_dark
 * JD-Core Version:    0.7.0.1
 */