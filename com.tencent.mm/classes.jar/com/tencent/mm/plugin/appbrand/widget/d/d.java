package com.tencent.mm.plugin.appbrand.widget.d;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.e;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.tencentmap.mapsdk.map.Projection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  private LinkedList<b.e> hzr;
  Marker hzs;
  private SoSoMapView hzt;
  g hzu;
  public AnimatorSet mF;
  
  public d(LinkedList<b.e> paramLinkedList, Marker paramMarker, SoSoMapView paramSoSoMapView)
  {
    this.hzr = paramLinkedList;
    this.hzs = paramMarker;
    this.hzt = paramSoSoMapView;
    init();
  }
  
  private ValueAnimator a(b.e parame)
  {
    Object localObject = new LatLng[2];
    localObject[0] = new LatLng(parame.gup, parame.guo);
    localObject[1] = new LatLng(parame.latitude, parame.longitude);
    f localf1 = this.hzu.b(localObject[0]);
    f localf2 = this.hzu.b(localObject[1]);
    double[] arrayOfDouble = new double[1];
    Projection localProjection = this.hzt.getProjection();
    int i = 0;
    double d = 0.0D;
    while (i <= 0)
    {
      arrayOfDouble[0] = localProjection.distanceBetween(localObject[0], localObject[1]);
      d = arrayOfDouble[0] + 0.0D;
      i += 1;
    }
    localObject = new ValueAnimator();
    ((ValueAnimator)localObject).setDuration((parame.duration * arrayOfDouble[0] / d));
    ((ValueAnimator)localObject).setInterpolator(new LinearInterpolator());
    ((ValueAnimator)localObject).setFloatValues(new float[] { (float)arrayOfDouble[0] });
    ((ValueAnimator)localObject).addUpdateListener(new d.1(this, localf1, localf2, arrayOfDouble));
    return localObject;
  }
  
  private void init()
  {
    this.mF = new AnimatorSet();
    this.hzu = new g();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.hzr.iterator();
    while (localIterator.hasNext())
    {
      b.e locale = (b.e)localIterator.next();
      if (locale.rotate != 0.0F)
      {
        ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { this.hzs.getRotation(), this.hzs.getRotation() + locale.rotate });
        localValueAnimator.setDuration(locale.duration);
        localValueAnimator.setInterpolator(new LinearInterpolator());
        localValueAnimator.addUpdateListener(new d.2(this));
        localArrayList.add(localValueAnimator);
      }
      else
      {
        localArrayList.add(a(locale));
      }
    }
    this.mF.playSequentially(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.d
 * JD-Core Version:    0.7.0.1
 */