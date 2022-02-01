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

public final class m
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(5.1F, 59.400002F);
      localPath.lineTo(54.900002F, 59.400002F);
      localPath.lineTo(54.900002F, 57.946388F);
      localPath.cubicTo(54.900002F, 57.258179F, 54.194038F, 56.130058F, 53.57943F, 55.830261F);
      localPath.lineTo(36.59837F, 47.547119F);
      localPath.cubicTo(32.018623F, 45.313179F, 30.886719F, 39.908741F, 34.168011F, 36.019104F);
      localPath.lineTo(35.252609F, 34.733425F);
      localPath.cubicTo(36.906586F, 32.772804F, 38.400002F, 28.693172F, 38.400002F, 26.130558F);
      localPath.lineTo(38.400002F, 21.000622F);
      localPath.cubicTo(38.400002F, 16.364742F, 34.636768F, 12.6F, 30.0F, 12.6F);
      localPath.cubicTo(25.368927F, 12.6F, 21.6F, 16.365608F, 21.6F, 20.998741F);
      localPath.lineTo(21.6F, 26.127872F);
      localPath.cubicTo(21.6F, 28.696991F, 23.08724F, 32.761452F, 24.747236F, 34.728935F);
      localPath.lineTo(25.831833F, 36.014439F);
      localPath.cubicTo(29.119909F, 39.911579F, 27.975643F, 45.310951F, 23.402159F, 47.542759F);
      localPath.lineTo(6.421099F, 55.82933F);
      localPath.cubicTo(5.811051F, 56.127026F, 5.1F, 57.266029F, 5.1F, 57.946388F);
      localPath.lineTo(5.1F, 59.400002F);
      localPath.close();
      localPath.moveTo(21.995739F, 37.050415F);
      localPath.cubicTo(19.788954F, 34.434856F, 18.0F, 29.548489F, 18.0F, 26.127872F);
      localPath.lineTo(18.0F, 20.998741F);
      localPath.cubicTo(18.0F, 14.37202F, 23.386068F, 9.0F, 30.0F, 9.0F);
      localPath.cubicTo(36.627419F, 9.0F, 42.0F, 14.378941F, 42.0F, 21.000622F);
      localPath.lineTo(42.0F, 26.130558F);
      localPath.cubicTo(42.0F, 29.547888F, 40.202797F, 34.448582F, 38.004261F, 37.054718F);
      localPath.lineTo(36.919662F, 38.340397F);
      localPath.cubicTo(35.151096F, 40.436852F, 35.703564F, 43.105194F, 38.176647F, 44.311531F);
      localPath.lineTo(55.157707F, 52.594673F);
      localPath.cubicTo(57.003605F, 53.495079F, 58.5F, 55.875511F, 58.5F, 57.946388F);
      localPath.lineTo(58.5F, 60.004684F);
      localPath.cubicTo(58.5F, 61.658951F, 57.147224F, 63.0F, 55.495712F, 63.0F);
      localPath.lineTo(4.504289F, 63.0F);
      localPath.cubicTo(2.845066F, 63.0F, 1.5F, 61.667267F, 1.5F, 60.004684F);
      localPath.lineTo(1.5F, 57.946388F);
      localPath.cubicTo(1.5F, 55.891125F, 2.994453F, 53.495724F, 4.842293F, 52.593998F);
      localPath.lineTo(21.823353F, 44.30743F);
      localPath.cubicTo(24.286131F, 43.105621F, 24.858778F, 40.443787F, 23.080336F, 38.335918F);
      localPath.lineTo(21.995739F, 37.050415F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(42.777729F, 12.601175F);
      ((Path)localObject).cubicTo(43.873131F, 12.211928F, 45.052574F, 12.0F, 46.281265F, 12.0F);
      ((Path)localObject).lineTo(46.718735F, 12.0F);
      ((Path)localObject).cubicTo(52.488968F, 12.0F, 57.166668F, 16.679132F, 57.166668F, 22.426958F);
      ((Path)localObject).lineTo(57.166668F, 26.224447F);
      ((Path)localObject).cubicTo(57.166668F, 29.100399F, 55.586826F, 33.146996F, 53.64127F, 35.259216F);
      ((Path)localObject).lineTo(52.458092F, 36.543751F);
      ((Path)localObject).cubicTo(50.89642F, 38.239201F, 51.303001F, 40.420994F, 53.385597F, 41.426277F);
      ((Path)localObject).lineTo(67.68544F, 48.328896F);
      ((Path)localObject).cubicTo(69.239876F, 49.079231F, 70.5F, 51.097424F, 70.5F, 52.831097F);
      ((Path)localObject).lineTo(70.5F, 54.924091F);
      ((Path)localObject).cubicTo(70.5F, 56.070583F, 69.562706F, 57.0F, 68.406639F, 57.0F);
      ((Path)localObject).lineTo(61.5F, 57.0F);
      ((Path)localObject).cubicTo(61.5F, 55.734264F, 60.827721F, 54.570892F, 59.736752F, 53.942154F);
      ((Path)localObject).lineTo(47.184334F, 46.708065F);
      ((Path)localObject).cubicTo(45.729706F, 45.869747F, 44.833332F, 44.318584F, 44.833332F, 42.639679F);
      ((Path)localObject).lineTo(44.833332F, 19.23913F);
      ((Path)localObject).cubicTo(44.833332F, 16.775564F, 44.074463F, 14.489244F, 42.777729F, 12.601175F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(61.5F, 53.400002F);
      ((Path)localObject).lineTo(66.900002F, 53.400002F);
      ((Path)localObject).lineTo(66.900002F, 52.831097F);
      ((Path)localObject).cubicTo(66.900002F, 52.475437F, 66.427338F, 51.719067F, 66.120476F, 51.570946F);
      ((Path)localObject).lineTo(51.820641F, 44.668327F);
      ((Path)localObject).cubicTo(47.562214F, 42.612762F, 46.61134F, 37.577648F, 49.810184F, 34.104778F);
      ((Path)localObject).lineTo(50.993362F, 32.820244F);
      ((Path)localObject).cubicTo(52.327118F, 31.372231F, 53.566666F, 28.196087F, 53.566666F, 26.224447F);
      ((Path)localObject).lineTo(53.566666F, 22.426958F);
      ((Path)localObject).cubicTo(53.566666F, 18.664661F, 50.498043F, 15.6F, 46.718735F, 15.6F);
      ((Path)localObject).lineTo(46.281265F, 15.6F);
      ((Path)localObject).cubicTo(45.615555F, 15.6F, 44.966045F, 15.693862F, 44.344559F, 15.876227F);
      ((Path)localObject).cubicTo(44.662544F, 16.941574F, 44.833332F, 18.070406F, 44.833332F, 19.23913F);
      ((Path)localObject).lineTo(44.833332F, 42.639679F);
      ((Path)localObject).cubicTo(44.833332F, 44.318584F, 45.729706F, 45.869747F, 47.184334F, 46.708065F);
      ((Path)localObject).lineTo(59.736752F, 53.942154F);
      ((Path)localObject).cubicTo(60.827721F, 54.570892F, 61.5F, 55.734264F, 61.5F, 56.993443F);
      ((Path)localObject).lineTo(61.5F, 53.400002F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.m
 * JD-Core Version:    0.7.0.1
 */