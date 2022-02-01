package com.tencent.mm.plugin.appbrand.widget.g;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.LinearInterpolator;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.h;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.tencentmap.mapsdk.map.Projection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  public AnimatorSet cis;
  private LinkedList<b.h> uMu;
  Marker uMv;
  private SoSoMapView uMw;
  f uMx;
  
  public c(LinkedList<b.h> paramLinkedList, Marker paramMarker, SoSoMapView paramSoSoMapView)
  {
    AppMethodBeat.i(146584);
    this.uMu = paramLinkedList;
    this.uMv = paramMarker;
    this.uMw = paramSoSoMapView;
    init();
    AppMethodBeat.o(146584);
  }
  
  private ValueAnimator a(b.h paramh)
  {
    AppMethodBeat.i(146586);
    Object localObject = new LatLng[2];
    localObject[0] = new LatLng(paramh.sdT, paramh.sdS);
    localObject[1] = new LatLng(paramh.latitude, paramh.longitude);
    final e locale1 = this.uMx.b(localObject[0]);
    final e locale2 = this.uMx.b(localObject[1]);
    final double[] arrayOfDouble = new double[1];
    Projection localProjection = this.uMw.getProjection();
    int i = 0;
    double d = 0.0D;
    while (i <= 0)
    {
      arrayOfDouble[0] = localProjection.distanceBetween(localObject[0], localObject[1]);
      d = arrayOfDouble[0] + 0.0D;
      i += 1;
    }
    localObject = new ValueAnimator();
    ((ValueAnimator)localObject).setDuration((paramh.duration * arrayOfDouble[0] / d));
    ((ValueAnimator)localObject).setInterpolator(new LinearInterpolator());
    ((ValueAnimator)localObject).setFloatValues(new float[] { (float)arrayOfDouble[0] });
    ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(146582);
        if (locale1.equals(locale2))
        {
          AppMethodBeat.o(146582);
          return;
        }
        double d4 = Double.parseDouble(String.valueOf(paramAnonymousValueAnimator.getAnimatedValue()));
        double d1 = locale1.x;
        double d2 = (locale2.x - locale1.x) * d4 / arrayOfDouble[0];
        double d3 = locale1.y;
        d4 = d4 * (locale2.y - locale1.y) / arrayOfDouble[0];
        paramAnonymousValueAnimator = c.this.uMv;
        f localf = c.this.uMx;
        e locale = new e(d1 + d2, d4 + d3);
        d1 = locale.x / localf.uMJ;
        paramAnonymousValueAnimator.setPosition(new LatLng(90.0D - Math.toDegrees(Math.atan(Math.exp(-(0.5D - locale.y / localf.uMJ) * 2.0D * 3.141592653589793D)) * 2.0D), (d1 - 0.5D) * 360.0D));
        AppMethodBeat.o(146582);
      }
    });
    AppMethodBeat.o(146586);
    return localObject;
  }
  
  private ValueAnimator b(b.h paramh)
  {
    AppMethodBeat.i(323990);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { this.uMv.getRotation(), this.uMv.getRotation() + paramh.aBi });
    localValueAnimator.setDuration(paramh.duration);
    localValueAnimator.setInterpolator(new LinearInterpolator());
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(146583);
        double d = Double.parseDouble(String.valueOf(paramAnonymousValueAnimator.getAnimatedValue()));
        c.this.uMv.setRotation((float)d);
        AppMethodBeat.o(146583);
      }
    });
    AppMethodBeat.o(323990);
    return localValueAnimator;
  }
  
  private void init()
  {
    AppMethodBeat.i(146585);
    this.cis = new AnimatorSet();
    this.uMx = new f();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.uMu.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (b.h)localIterator.next();
      if ((((b.h)localObject).aBi != 0.0F) && (((b.h)localObject).latitude != 0.0D) && (((b.h)localObject).longitude != 0.0D))
      {
        ValueAnimator localValueAnimator = a((b.h)localObject);
        localObject = b((b.h)localObject);
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.play((Animator)localObject).with(localValueAnimator);
        localArrayList.add(localAnimatorSet);
      }
      else if (((b.h)localObject).aBi != 0.0F)
      {
        localArrayList.add(b((b.h)localObject));
      }
      else
      {
        localArrayList.add(a((b.h)localObject));
      }
    }
    this.cis.playSequentially(localArrayList);
    AppMethodBeat.o(146585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.g.c
 * JD-Core Version:    0.7.0.1
 */