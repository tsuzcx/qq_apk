package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class finder_feed_dislike
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(1.654015F, 3.351F);
      ((Path)localObject2).lineTo(2.503048F, 4.198969F);
      ((Path)localObject2).cubicTo(2.46277F, 4.235951F, 2.423097F, 4.273959F, 2.384062F, 4.312994F);
      ((Path)localObject2).cubicTo(0.9155371F, 5.781519F, 0.8985832F, 8.156871F, 2.329674F, 9.632617F);
      ((Path)localObject2).lineTo(9.313666F, 16.616682F);
      ((Path)localObject2).lineTo(12.116015F, 13.813F);
      ((Path)localObject2).lineTo(12.964015F, 14.661F);
      ((Path)localObject2).lineTo(10.020815F, 17.606602F);
      ((Path)localObject2).cubicTo(9.630311F, 17.997147F, 8.997147F, 17.997179F, 8.606602F, 17.606676F);
      ((Path)localObject2).lineTo(1.481141F, 10.481141F);
      ((Path)localObject2).cubicTo(-0.4169186F, 8.52412F, -0.3989243F, 5.398924F, 1.535534F, 3.464466F);
      ((Path)localObject2).lineTo(1.654015F, 3.351F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(1.697057F, 0.0F);
      ((Path)localObject2).lineTo(3.849036F, 2.150849F);
      ((Path)localObject2).cubicTo(5.498065F, 1.73694F, 7.316948F, 2.174812F, 8.606602F, 3.464466F);
      ((Path)localObject2).cubicTo(8.789409F, 3.647273F, 9.02511F, 3.874633F, 9.313708F, 4.146545F);
      ((Path)localObject2).cubicTo(9.602306F, 3.874633F, 9.838009F, 3.647273F, 10.020815F, 3.464466F);
      ((Path)localObject2).cubicTo(11.973436F, 1.511845F, 15.139261F, 1.511845F, 17.091883F, 3.464466F);
      ((Path)localObject2).cubicTo(19.02634F, 5.398924F, 19.044336F, 8.52412F, 17.145866F, 10.480731F);
      ((Path)localObject2).lineTo(14.661016F, 12.964F);
      ((Path)localObject2).lineTo(18.424978F, 16.727922F);
      ((Path)localObject2).lineTo(17.57645F, 17.57645F);
      ((Path)localObject2).lineTo(0.8485287F, 0.8485282F);
      ((Path)localObject2).lineTo(1.697057F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(4.900784F, 3.203794F);
      ((Path)localObject2).lineTo(13.813015F, 12.116F);
      ((Path)localObject2).lineTo(16.284639F, 9.645095F);
      ((Path)localObject2).cubicTo(17.728756F, 8.156752F, 17.711899F, 5.781537F, 16.243355F, 4.312994F);
      ((Path)localObject2).cubicTo(14.759362F, 2.829002F, 12.353335F, 2.829002F, 10.869344F, 4.312994F);
      ((Path)localObject2).cubicTo(10.677078F, 4.505259F, 10.433207F, 4.7405F, 10.136614F, 5.019945F);
      ((Path)localObject2).lineTo(9.313708F, 5.795275F);
      ((Path)localObject2).lineTo(8.490803F, 5.019945F);
      ((Path)localObject2).cubicTo(8.194211F, 4.7405F, 7.950338F, 4.505259F, 7.758074F, 4.312994F);
      ((Path)localObject2).cubicTo(6.972758F, 3.527679F, 5.929234F, 3.157945F, 4.900784F, 3.203794F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_feed_dislike
 * JD-Core Version:    0.7.0.1
 */