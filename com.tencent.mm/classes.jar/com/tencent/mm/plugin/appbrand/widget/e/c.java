package com.tencent.mm.plugin.appbrand.widget.e;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.g;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.tencentmap.mapsdk.map.Projection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  private LinkedList<b.g> jru;
  Marker jrv;
  private SoSoMapView jrw;
  f jrx;
  public AnimatorSet nC;
  
  public c(LinkedList<b.g> paramLinkedList, Marker paramMarker, SoSoMapView paramSoSoMapView)
  {
    AppMethodBeat.i(51262);
    this.jru = paramLinkedList;
    this.jrv = paramMarker;
    this.jrw = paramSoSoMapView;
    init();
    AppMethodBeat.o(51262);
  }
  
  private ValueAnimator a(b.g paramg)
  {
    AppMethodBeat.i(51264);
    Object localObject = new LatLng[2];
    localObject[0] = new LatLng(paramg.hPj, paramg.hPi);
    localObject[1] = new LatLng(paramg.latitude, paramg.longitude);
    e locale1 = this.jrx.b(localObject[0]);
    e locale2 = this.jrx.b(localObject[1]);
    double[] arrayOfDouble = new double[1];
    Projection localProjection = this.jrw.getProjection();
    int i = 0;
    double d = 0.0D;
    while (i <= 0)
    {
      arrayOfDouble[0] = localProjection.distanceBetween(localObject[0], localObject[1]);
      d = arrayOfDouble[0] + 0.0D;
      i += 1;
    }
    localObject = new ValueAnimator();
    ((ValueAnimator)localObject).setDuration((paramg.duration * arrayOfDouble[0] / d));
    ((ValueAnimator)localObject).setInterpolator(new LinearInterpolator());
    ((ValueAnimator)localObject).setFloatValues(new float[] { (float)arrayOfDouble[0] });
    ((ValueAnimator)localObject).addUpdateListener(new c.1(this, locale1, locale2, arrayOfDouble));
    AppMethodBeat.o(51264);
    return localObject;
  }
  
  private void init()
  {
    AppMethodBeat.i(51263);
    this.nC = new AnimatorSet();
    this.jrx = new f();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jru.iterator();
    while (localIterator.hasNext())
    {
      b.g localg = (b.g)localIterator.next();
      if (localg.rotate != 0.0F)
      {
        ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { this.jrv.getRotation(), this.jrv.getRotation() + localg.rotate });
        localValueAnimator.setDuration(localg.duration);
        localValueAnimator.setInterpolator(new LinearInterpolator());
        localValueAnimator.addUpdateListener(new c.2(this));
        localArrayList.add(localValueAnimator);
      }
      else
      {
        localArrayList.add(a(localg));
      }
    }
    this.nC.playSequentially(localArrayList);
    AppMethodBeat.o(51263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.c
 * JD-Core Version:    0.7.0.1
 */