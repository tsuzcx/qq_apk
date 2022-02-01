package com.tencent.mm.plugin.location.model;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public final class k
{
  private b.a fHp;
  private d hTg;
  private SensorManager mSensorManager;
  private b vlU;
  HashSet<WeakReference<a>> vlV;
  double vlW;
  double vlX;
  double vlY;
  double vlZ;
  double vma;
  boolean vmb;
  
  public k()
  {
    AppMethodBeat.i(55702);
    this.vlU = new b();
    this.vlV = new HashSet();
    this.vlW = 900.0D;
    this.vlX = 900.0D;
    this.vlY = -1000.0D;
    this.vlZ = -1000.0D;
    this.vma = 0.0D;
    this.vmb = false;
    this.fHp = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(55700);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(55700);
          return false;
        }
        if ((k.this.vlY != -1000.0D) && (k.this.vlZ != -1000.0D)) {
          k.this.vmb = f.a(k.this.vlZ, k.this.vlY, paramAnonymousFloat1, paramAnonymousFloat2, paramAnonymousInt, paramAnonymousDouble1);
        }
        k.this.vlY = paramAnonymousFloat2;
        k.this.vlZ = paramAnonymousFloat1;
        if ((k.this.vlX == 900.0D) || (k.this.vlW == 900.0D))
        {
          k localk1 = k.this;
          k localk2 = k.this;
          paramAnonymousDouble1 = f.h(paramAnonymousFloat2, paramAnonymousFloat1);
          localk2.vlW = paramAnonymousDouble1;
          localk1.vlX = paramAnonymousDouble1;
        }
        for (;;)
        {
          ae.d("MicroMsg.OrientationSensorMgr", "onGetLocation, update headding, mCurrentHeading = %f, mPreviousHeading = %f mIsMove = %b", new Object[] { Double.valueOf(k.this.vlW), Double.valueOf(k.this.vlX), Boolean.valueOf(k.this.vmb) });
          AppMethodBeat.o(55700);
          return true;
          k.this.vlX = k.this.vlW;
          k.this.vlW = f.h(paramAnonymousFloat2, paramAnonymousFloat1);
        }
      }
    };
    this.mSensorManager = ((SensorManager)ak.getContext().getSystemService("sensor"));
    AppMethodBeat.o(55702);
  }
  
  private void cgQ()
  {
    AppMethodBeat.i(55704);
    ae.i("MicroMsg.OrientationSensorMgr", "registerSensor ");
    if (this.hTg == null) {
      this.hTg = d.aIh();
    }
    this.hTg.b(this.fHp, true);
    Sensor localSensor = this.mSensorManager.getDefaultSensor(3);
    this.mSensorManager.registerListener(this.vlU, localSensor, 1);
    AppMethodBeat.o(55704);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(55706);
    Iterator localIterator = this.vlV.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((a)localWeakReference.get()).equals(parama)))
      {
        AppMethodBeat.o(55706);
        return;
      }
    }
    this.vlV.add(new WeakReference(parama));
    ae.i("MicroMsg.OrientationSensorMgr", "registerSensorListener %d", new Object[] { Integer.valueOf(this.vlV.size()) });
    if (this.vlV.size() == 1) {
      cgQ();
    }
    AppMethodBeat.o(55706);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(55707);
    if ((this.vlV == null) || (parama == null))
    {
      AppMethodBeat.o(55707);
      return;
    }
    Iterator localIterator = this.vlV.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((a)localWeakReference.get()).equals(parama))) {
        this.vlV.remove(localWeakReference);
      }
    }
    ae.i("MicroMsg.OrientationSensorMgr", "unregisterSensorListener %d", new Object[] { Integer.valueOf(this.vlV.size()) });
    if (this.vlV.size() == 0) {
      djb();
    }
    AppMethodBeat.o(55707);
  }
  
  public final double dja()
  {
    AppMethodBeat.i(55703);
    if (this.vmb)
    {
      ae.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = true, result = %f", new Object[] { Double.valueOf(this.vlW) });
      d = this.vlW;
      AppMethodBeat.o(55703);
      return d;
    }
    ae.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = false, result = %f", new Object[] { Double.valueOf(this.vma) });
    double d = this.vma;
    AppMethodBeat.o(55703);
    return d;
  }
  
  final void djb()
  {
    AppMethodBeat.i(55705);
    ae.i("MicroMsg.OrientationSensorMgr", "unregisterSensor ");
    this.mSensorManager.unregisterListener(this.vlU);
    d.aIh().c(this.fHp);
    AppMethodBeat.o(55705);
  }
  
  public static abstract interface a
  {
    public abstract void w(double paramDouble);
  }
  
  protected final class b
    implements SensorEventListener
  {
    private float kWt = 0.0F;
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
          if ((l1 - l2 <= 200L) || (Math.abs(f1 - this.kWt) <= 3.0F)) {
            break label250;
          }
          paramSensorEvent = k.this;
          f2 = this.kWt;
          paramSensorEvent.vma = f1;
          if (paramSensorEvent.vlV != null) {
            break label226;
          }
        }
        for (;;)
        {
          ae.d("MicroMsg.OrientationSensorMgr", "onOrientationChanged %f %f, mListenerList.size = %d", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Integer.valueOf(i) });
          if (paramSensorEvent.vlV == null) {
            break label238;
          }
          Iterator localIterator = paramSensorEvent.vlV.iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((k.a)localWeakReference.get()).w(paramSensorEvent.dja());
            }
          }
          f1 = (f1 + ((int)f1 * -1 / 360 + 1) * 360) % 360.0F;
          break;
          label226:
          i = paramSensorEvent.vlV.size();
        }
        label238:
        this.kWt = f1;
        this.timestamp = System.currentTimeMillis();
      }
      label250:
      AppMethodBeat.o(55701);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.k
 * JD-Core Version:    0.7.0.1
 */