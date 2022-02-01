package com.tencent.mm.plugin.location.model;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public final class k
{
  private b.a fnd;
  private d hxT;
  private SensorManager mSensorManager;
  private b tXa;
  HashSet<WeakReference<a>> tXb;
  double tXc;
  double tXd;
  double tXe;
  double tXf;
  double tXg;
  boolean tXh;
  
  public k()
  {
    AppMethodBeat.i(55702);
    this.tXa = new b();
    this.tXb = new HashSet();
    this.tXc = 900.0D;
    this.tXd = 900.0D;
    this.tXe = -1000.0D;
    this.tXf = -1000.0D;
    this.tXg = 0.0D;
    this.tXh = false;
    this.fnd = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(55700);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(55700);
          return false;
        }
        if ((k.this.tXe != -1000.0D) && (k.this.tXf != -1000.0D)) {
          k.this.tXh = f.a(k.this.tXf, k.this.tXe, paramAnonymousFloat1, paramAnonymousFloat2, paramAnonymousInt, paramAnonymousDouble1);
        }
        k.this.tXe = paramAnonymousFloat2;
        k.this.tXf = paramAnonymousFloat1;
        if ((k.this.tXd == 900.0D) || (k.this.tXc == 900.0D))
        {
          k localk1 = k.this;
          k localk2 = k.this;
          paramAnonymousDouble1 = f.h(paramAnonymousFloat2, paramAnonymousFloat1);
          localk2.tXc = paramAnonymousDouble1;
          localk1.tXd = paramAnonymousDouble1;
        }
        for (;;)
        {
          ac.d("MicroMsg.OrientationSensorMgr", "onGetLocation, update headding, mCurrentHeading = %f, mPreviousHeading = %f mIsMove = %b", new Object[] { Double.valueOf(k.this.tXc), Double.valueOf(k.this.tXd), Boolean.valueOf(k.this.tXh) });
          AppMethodBeat.o(55700);
          return true;
          k.this.tXd = k.this.tXc;
          k.this.tXc = f.h(paramAnonymousFloat2, paramAnonymousFloat1);
        }
      }
    };
    this.mSensorManager = ((SensorManager)ai.getContext().getSystemService("sensor"));
    AppMethodBeat.o(55702);
  }
  
  private void caW()
  {
    AppMethodBeat.i(55704);
    ac.i("MicroMsg.OrientationSensorMgr", "registerSensor ");
    if (this.hxT == null) {
      this.hxT = d.aEL();
    }
    this.hxT.b(this.fnd, true);
    Sensor localSensor = this.mSensorManager.getDefaultSensor(3);
    this.mSensorManager.registerListener(this.tXa, localSensor, 1);
    AppMethodBeat.o(55704);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(55706);
    Iterator localIterator = this.tXb.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((a)localWeakReference.get()).equals(parama)))
      {
        AppMethodBeat.o(55706);
        return;
      }
    }
    this.tXb.add(new WeakReference(parama));
    ac.i("MicroMsg.OrientationSensorMgr", "registerSensorListener %d", new Object[] { Integer.valueOf(this.tXb.size()) });
    if (this.tXb.size() == 1) {
      caW();
    }
    AppMethodBeat.o(55706);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(55707);
    if ((this.tXb == null) || (parama == null))
    {
      AppMethodBeat.o(55707);
      return;
    }
    Iterator localIterator = this.tXb.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((a)localWeakReference.get()).equals(parama))) {
        this.tXb.remove(localWeakReference);
      }
    }
    ac.i("MicroMsg.OrientationSensorMgr", "unregisterSensorListener %d", new Object[] { Integer.valueOf(this.tXb.size()) });
    if (this.tXb.size() == 0) {
      cWQ();
    }
    AppMethodBeat.o(55707);
  }
  
  public final double cWP()
  {
    AppMethodBeat.i(55703);
    if (this.tXh)
    {
      ac.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = true, result = %f", new Object[] { Double.valueOf(this.tXc) });
      d = this.tXc;
      AppMethodBeat.o(55703);
      return d;
    }
    ac.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = false, result = %f", new Object[] { Double.valueOf(this.tXg) });
    double d = this.tXg;
    AppMethodBeat.o(55703);
    return d;
  }
  
  final void cWQ()
  {
    AppMethodBeat.i(55705);
    ac.i("MicroMsg.OrientationSensorMgr", "unregisterSensor ");
    this.mSensorManager.unregisterListener(this.tXa);
    d.aEL().c(this.fnd);
    AppMethodBeat.o(55705);
  }
  
  public static abstract interface a
  {
    public abstract void w(double paramDouble);
  }
  
  protected final class b
    implements SensorEventListener
  {
    private float kwE = 0.0F;
    private long timestamp = 200L;
    
    protected b() {}
    
    public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onSensorChanged(SensorEvent paramSensorEvent)
    {
      int i = 0;
      AppMethodBeat.i(55701);
      if (paramSensorEvent.sensor.getType() == 3)
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.timestamp;
        float f1 = paramSensorEvent.values[0];
        float f2;
        if (f1 > 0.0F)
        {
          f1 %= 360.0F;
          if ((l1 - l2 <= 200L) || (Math.abs(f1 - this.kwE) <= 3.0F)) {
            break label250;
          }
          paramSensorEvent = k.this;
          f2 = this.kwE;
          paramSensorEvent.tXg = f1;
          if (paramSensorEvent.tXb != null) {
            break label226;
          }
        }
        for (;;)
        {
          ac.d("MicroMsg.OrientationSensorMgr", "onOrientationChanged %f %f, mListenerList.size = %d", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Integer.valueOf(i) });
          if (paramSensorEvent.tXb == null) {
            break label238;
          }
          Iterator localIterator = paramSensorEvent.tXb.iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((k.a)localWeakReference.get()).w(paramSensorEvent.cWP());
            }
          }
          f1 = (f1 + ((int)f1 * -1 / 360 + 1) * 360) % 360.0F;
          break;
          label226:
          i = paramSensorEvent.tXb.size();
        }
        label238:
        this.kwE = f1;
        this.timestamp = System.currentTimeMillis();
      }
      label250:
      AppMethodBeat.o(55701);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.k
 * JD-Core Version:    0.7.0.1
 */