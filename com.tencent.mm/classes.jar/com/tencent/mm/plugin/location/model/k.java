package com.tencent.mm.plugin.location.model;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public final class k
{
  private b Kco;
  HashSet<WeakReference<a>> Kcp;
  double Kcq;
  double Kcr;
  double Kcs;
  double Kct;
  double Kcu;
  boolean Kcv;
  private b.a lsF;
  private SensorManager mSensorManager;
  private d owr;
  
  public k()
  {
    AppMethodBeat.i(55702);
    this.Kco = new b();
    this.Kcp = new HashSet();
    this.Kcq = 900.0D;
    this.Kcr = 900.0D;
    this.Kcs = -1000.0D;
    this.Kct = -1000.0D;
    this.Kcu = 0.0D;
    this.Kcv = false;
    this.lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(264941);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(264941);
          return false;
        }
        if ((k.this.Kcs != -1000.0D) && (k.this.Kct != -1000.0D)) {
          k.this.Kcv = f.a(k.this.Kct, k.this.Kcs, paramAnonymousFloat1, paramAnonymousFloat2, paramAnonymousInt, paramAnonymousDouble1);
        }
        k.this.Kcs = paramAnonymousFloat2;
        k localk1 = k.this;
        paramAnonymousDouble1 = paramAnonymousFloat1;
        localk1.Kct = paramAnonymousDouble1;
        if ((k.this.Kcr == 900.0D) || (k.this.Kcq == 900.0D))
        {
          localk1 = k.this;
          k localk2 = k.this;
          paramAnonymousDouble1 = f.k(paramAnonymousFloat2, paramAnonymousDouble1);
          localk2.Kcq = paramAnonymousDouble1;
          localk1.Kcr = paramAnonymousDouble1;
        }
        for (;;)
        {
          Log.d("MicroMsg.OrientationSensorMgr", "onGetLocation, update headding, mCurrentHeading = %f, mPreviousHeading = %f mIsMove = %b", new Object[] { Double.valueOf(k.this.Kcq), Double.valueOf(k.this.Kcr), Boolean.valueOf(k.this.Kcv) });
          AppMethodBeat.o(264941);
          return true;
          k.this.Kcr = k.this.Kcq;
          k.this.Kcq = f.k(paramAnonymousFloat2, paramAnonymousDouble1);
        }
      }
    };
    this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    AppMethodBeat.o(55702);
  }
  
  private void dxC()
  {
    AppMethodBeat.i(55704);
    Log.i("MicroMsg.OrientationSensorMgr", "registerSensor ");
    if (this.owr == null) {
      this.owr = d.bJl();
    }
    this.owr.a(this.lsF, true);
    Sensor localSensor = this.mSensorManager.getDefaultSensor(3);
    this.mSensorManager.registerListener(this.Kco, localSensor, 1);
    AppMethodBeat.o(55704);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(55706);
    Iterator localIterator = this.Kcp.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((a)localWeakReference.get()).equals(parama)))
      {
        AppMethodBeat.o(55706);
        return;
      }
    }
    this.Kcp.add(new WeakReference(parama));
    Log.i("MicroMsg.OrientationSensorMgr", "registerSensorListener %d", new Object[] { Integer.valueOf(this.Kcp.size()) });
    if (this.Kcp.size() == 1) {
      dxC();
    }
    AppMethodBeat.o(55706);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(55707);
    if ((this.Kcp == null) || (parama == null))
    {
      AppMethodBeat.o(55707);
      return;
    }
    Iterator localIterator = this.Kcp.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((a)localWeakReference.get()).equals(parama))) {
        this.Kcp.remove(localWeakReference);
      }
    }
    Log.i("MicroMsg.OrientationSensorMgr", "unregisterSensorListener %d", new Object[] { Integer.valueOf(this.Kcp.size()) });
    if (this.Kcp.size() == 0) {
      fUw();
    }
    AppMethodBeat.o(55707);
  }
  
  public final double fUv()
  {
    AppMethodBeat.i(55703);
    if (this.Kcv)
    {
      Log.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = true, result = %f", new Object[] { Double.valueOf(this.Kcq) });
      d = this.Kcq;
      AppMethodBeat.o(55703);
      return d;
    }
    Log.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = false, result = %f", new Object[] { Double.valueOf(this.Kcu) });
    double d = this.Kcu;
    AppMethodBeat.o(55703);
    return d;
  }
  
  final void fUw()
  {
    AppMethodBeat.i(55705);
    Log.i("MicroMsg.OrientationSensorMgr", "unregisterSensor ");
    this.mSensorManager.unregisterListener(this.Kco);
    d.bJl().a(this.lsF);
    AppMethodBeat.o(55705);
  }
  
  public static abstract interface a
  {
    public abstract void Q(double paramDouble);
  }
  
  protected final class b
    implements SensorEventListener
  {
    private float seV = 0.0F;
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
          if ((l1 - l2 <= 200L) || (Math.abs(f1 - this.seV) <= 3.0F)) {
            break label250;
          }
          paramSensorEvent = k.this;
          f2 = this.seV;
          paramSensorEvent.Kcu = f1;
          if (paramSensorEvent.Kcp != null) {
            break label226;
          }
        }
        for (;;)
        {
          Log.d("MicroMsg.OrientationSensorMgr", "onOrientationChanged %f %f, mListenerList.size = %d", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Integer.valueOf(i) });
          if (paramSensorEvent.Kcp == null) {
            break label238;
          }
          Iterator localIterator = paramSensorEvent.Kcp.iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((k.a)localWeakReference.get()).Q(paramSensorEvent.fUv());
            }
          }
          f1 = (f1 + ((int)f1 * -1 / 360 + 1) * 360) % 360.0F;
          break;
          label226:
          i = paramSensorEvent.Kcp.size();
        }
        label238:
        this.seV = f1;
        this.timestamp = System.currentTimeMillis();
      }
      label250:
      AppMethodBeat.o(55701);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.k
 * JD-Core Version:    0.7.0.1
 */