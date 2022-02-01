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

public final class abx
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
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(11.948242F, 20.896484F);
      ((Path)localObject).cubicTo(13.387695F, 20.896484F, 14.655273F, 20.724609F, 15.525391F, 20.423828F);
      ((Path)localObject).lineTo(15.525391F, 19.360352F);
      ((Path)localObject).cubicTo(14.794922F, 19.650391F, 13.40918F, 19.833008F, 11.958984F, 19.833008F);
      ((Path)localObject).cubicTo(7.46875F, 19.833008F, 4.181641F, 16.889648F, 4.181641F, 11.958984F);
      ((Path)localObject).cubicTo(4.181641F, 7.361328F, 7.37207F, 4.063477F, 11.744141F, 4.063477F);
      ((Path)localObject).cubicTo(16.180664F, 4.063477F, 19.263672F, 6.867188F, 19.263672F, 10.970703F);
      ((Path)localObject).cubicTo(19.263672F, 13.860352F, 18.286133F, 15.503906F, 16.857422F, 15.503906F);
      ((Path)localObject).cubicTo(15.879883F, 15.503906F, 15.364258F, 14.859375F, 15.364258F, 13.881836F);
      ((Path)localObject).lineTo(15.364258F, 7.737305F);
      ((Path)localObject).lineTo(14.118164F, 7.737305F);
      ((Path)localObject).lineTo(14.118164F, 9.251953F);
      ((Path)localObject).lineTo(14.042969F, 9.251953F);
      ((Path)localObject).cubicTo(13.645508F, 8.199219F, 12.560547F, 7.522461F, 11.314453F, 7.522461F);
      ((Path)localObject).cubicTo(9.123047F, 7.522461F, 7.597656F, 9.348633F, 7.597656F, 11.991211F);
      ((Path)localObject).cubicTo(7.597656F, 14.698242F, 9.101563F, 16.524414F, 11.314453F, 16.524414F);
      ((Path)localObject).cubicTo(12.646484F, 16.524414F, 13.645508F, 15.847656F, 14.128906F, 14.623047F);
      ((Path)localObject).lineTo(14.204102F, 14.623047F);
      ((Path)localObject).cubicTo(14.365234F, 15.826172F, 15.375F, 16.599609F, 16.65332F, 16.599609F);
      ((Path)localObject).cubicTo(19.016602F, 16.599609F, 20.43457F, 14.408203F, 20.43457F, 10.992188F);
      ((Path)localObject).cubicTo(20.43457F, 6.233398F, 16.857422F, 3.0F, 11.84082F, 3.0F);
      ((Path)localObject).cubicTo(6.663086F, 3.0F, 3.0F, 6.641602F, 3.0F, 11.916016F);
      ((Path)localObject).cubicTo(3.0F, 17.544922F, 6.738281F, 20.896484F, 11.948242F, 20.896484F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(11.486328F, 15.353516F);
      ((Path)localObject).cubicTo(9.928711F, 15.353516F, 8.929688F, 14.042969F, 8.929688F, 12.023438F);
      ((Path)localObject).cubicTo(8.929688F, 9.993164F, 9.939453F, 8.671875F, 11.49707F, 8.671875F);
      ((Path)localObject).cubicTo(13.097656F, 8.671875F, 14.09668F, 9.950195F, 14.09668F, 11.969727F);
      ((Path)localObject).cubicTo(14.09668F, 14.021484F, 13.076172F, 15.353516F, 11.486328F, 15.353516F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.abx
 * JD-Core Version:    0.7.0.1
 */