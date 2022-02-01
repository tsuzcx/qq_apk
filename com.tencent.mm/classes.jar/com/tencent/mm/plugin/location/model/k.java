package com.tencent.mm.plugin.location.model;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public final class k
{
  private b.a fFl;
  private d hQo;
  private SensorManager mSensorManager;
  private b uZJ;
  HashSet<WeakReference<a>> uZK;
  double uZL;
  double uZM;
  double uZN;
  double uZO;
  double uZP;
  boolean uZQ;
  
  public k()
  {
    AppMethodBeat.i(55702);
    this.uZJ = new b();
    this.uZK = new HashSet();
    this.uZL = 900.0D;
    this.uZM = 900.0D;
    this.uZN = -1000.0D;
    this.uZO = -1000.0D;
    this.uZP = 0.0D;
    this.uZQ = false;
    this.fFl = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(55700);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(55700);
          return false;
        }
        if ((k.this.uZN != -1000.0D) && (k.this.uZO != -1000.0D)) {
          k.this.uZQ = f.a(k.this.uZO, k.this.uZN, paramAnonymousFloat1, paramAnonymousFloat2, paramAnonymousInt, paramAnonymousDouble1);
        }
        k.this.uZN = paramAnonymousFloat2;
        k.this.uZO = paramAnonymousFloat1;
        if ((k.this.uZM == 900.0D) || (k.this.uZL == 900.0D))
        {
          k localk1 = k.this;
          k localk2 = k.this;
          paramAnonymousDouble1 = f.h(paramAnonymousFloat2, paramAnonymousFloat1);
          localk2.uZL = paramAnonymousDouble1;
          localk1.uZM = paramAnonymousDouble1;
        }
        for (;;)
        {
          ad.d("MicroMsg.OrientationSensorMgr", "onGetLocation, update headding, mCurrentHeading = %f, mPreviousHeading = %f mIsMove = %b", new Object[] { Double.valueOf(k.this.uZL), Double.valueOf(k.this.uZM), Boolean.valueOf(k.this.uZQ) });
          AppMethodBeat.o(55700);
          return true;
          k.this.uZM = k.this.uZL;
          k.this.uZL = f.h(paramAnonymousFloat2, paramAnonymousFloat1);
        }
      }
    };
    this.mSensorManager = ((SensorManager)aj.getContext().getSystemService("sensor"));
    AppMethodBeat.o(55702);
  }
  
  private void cfA()
  {
    AppMethodBeat.i(55704);
    ad.i("MicroMsg.OrientationSensorMgr", "registerSensor ");
    if (this.hQo == null) {
      this.hQo = d.aHQ();
    }
    this.hQo.b(this.fFl, true);
    Sensor localSensor = this.mSensorManager.getDefaultSensor(3);
    this.mSensorManager.registerListener(this.uZJ, localSensor, 1);
    AppMethodBeat.o(55704);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(55706);
    Iterator localIterator = this.uZK.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((a)localWeakReference.get()).equals(parama)))
      {
        AppMethodBeat.o(55706);
        return;
      }
    }
    this.uZK.add(new WeakReference(parama));
    ad.i("MicroMsg.OrientationSensorMgr", "registerSensorListener %d", new Object[] { Integer.valueOf(this.uZK.size()) });
    if (this.uZK.size() == 1) {
      cfA();
    }
    AppMethodBeat.o(55706);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(55707);
    if ((this.uZK == null) || (parama == null))
    {
      AppMethodBeat.o(55707);
      return;
    }
    Iterator localIterator = this.uZK.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((a)localWeakReference.get()).equals(parama))) {
        this.uZK.remove(localWeakReference);
      }
    }
    ad.i("MicroMsg.OrientationSensorMgr", "unregisterSensorListener %d", new Object[] { Integer.valueOf(this.uZK.size()) });
    if (this.uZK.size() == 0) {
      dgc();
    }
    AppMethodBeat.o(55707);
  }
  
  public final double dgb()
  {
    AppMethodBeat.i(55703);
    if (this.uZQ)
    {
      ad.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = true, result = %f", new Object[] { Double.valueOf(this.uZL) });
      d = this.uZL;
      AppMethodBeat.o(55703);
      return d;
    }
    ad.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = false, result = %f", new Object[] { Double.valueOf(this.uZP) });
    double d = this.uZP;
    AppMethodBeat.o(55703);
    return d;
  }
  
  final void dgc()
  {
    AppMethodBeat.i(55705);
    ad.i("MicroMsg.OrientationSensorMgr", "unregisterSensor ");
    this.mSensorManager.unregisterListener(this.uZJ);
    d.aHQ().c(this.fFl);
    AppMethodBeat.o(55705);
  }
  
  public static abstract interface a
  {
    public abstract void w(double paramDouble);
  }
  
  protected final class b
    implements SensorEventListener
  {
    private float kSK = 0.0F;
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
          if ((l1 - l2 <= 200L) || (Math.abs(f1 - this.kSK) <= 3.0F)) {
            break label250;
          }
          paramSensorEvent = k.this;
          f2 = this.kSK;
          paramSensorEvent.uZP = f1;
          if (paramSensorEvent.uZK != null) {
            break label226;
          }
        }
        for (;;)
        {
          ad.d("MicroMsg.OrientationSensorMgr", "onOrientationChanged %f %f, mListenerList.size = %d", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Integer.valueOf(i) });
          if (paramSensorEvent.uZK == null) {
            break label238;
          }
          Iterator localIterator = paramSensorEvent.uZK.iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((k.a)localWeakReference.get()).w(paramSensorEvent.dgb());
            }
          }
          f1 = (f1 + ((int)f1 * -1 / 360 + 1) * 360) % 360.0F;
          break;
          label226:
          i = paramSensorEvent.uZK.size();
        }
        label238:
        this.kSK = f1;
        this.timestamp = System.currentTimeMillis();
      }
      label250:
      AppMethodBeat.o(55701);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.k
 * JD-Core Version:    0.7.0.1
 */