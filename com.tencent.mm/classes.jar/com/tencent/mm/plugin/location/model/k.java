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
  private b.a fjJ;
  private d gXu;
  private SensorManager mSensorManager;
  private b sON;
  HashSet<WeakReference<a>> sOO;
  double sOP;
  double sOQ;
  double sOR;
  double sOS;
  double sOT;
  boolean sOU;
  
  public k()
  {
    AppMethodBeat.i(55702);
    this.sON = new b();
    this.sOO = new HashSet();
    this.sOP = 900.0D;
    this.sOQ = 900.0D;
    this.sOR = -1000.0D;
    this.sOS = -1000.0D;
    this.sOT = 0.0D;
    this.sOU = false;
    this.fjJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(55700);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(55700);
          return false;
        }
        if ((k.this.sOR != -1000.0D) && (k.this.sOS != -1000.0D)) {
          k.this.sOU = f.a(k.this.sOS, k.this.sOR, paramAnonymousFloat1, paramAnonymousFloat2, paramAnonymousInt, paramAnonymousDouble1);
        }
        k.this.sOR = paramAnonymousFloat2;
        k.this.sOS = paramAnonymousFloat1;
        if ((k.this.sOQ == 900.0D) || (k.this.sOP == 900.0D))
        {
          k localk1 = k.this;
          k localk2 = k.this;
          paramAnonymousDouble1 = f.h(paramAnonymousFloat2, paramAnonymousFloat1);
          localk2.sOP = paramAnonymousDouble1;
          localk1.sOQ = paramAnonymousDouble1;
        }
        for (;;)
        {
          ad.d("MicroMsg.OrientationSensorMgr", "onGetLocation, update headding, mCurrentHeading = %f, mPreviousHeading = %f mIsMove = %b", new Object[] { Double.valueOf(k.this.sOP), Double.valueOf(k.this.sOQ), Boolean.valueOf(k.this.sOU) });
          AppMethodBeat.o(55700);
          return true;
          k.this.sOQ = k.this.sOP;
          k.this.sOP = f.h(paramAnonymousFloat2, paramAnonymousFloat1);
        }
      }
    };
    this.mSensorManager = ((SensorManager)aj.getContext().getSystemService("sensor"));
    AppMethodBeat.o(55702);
  }
  
  private void bTI()
  {
    AppMethodBeat.i(55704);
    ad.i("MicroMsg.OrientationSensorMgr", "registerSensor ");
    if (this.gXu == null) {
      this.gXu = d.axT();
    }
    this.gXu.b(this.fjJ, true);
    Sensor localSensor = this.mSensorManager.getDefaultSensor(3);
    this.mSensorManager.registerListener(this.sON, localSensor, 1);
    AppMethodBeat.o(55704);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(55706);
    Iterator localIterator = this.sOO.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((a)localWeakReference.get()).equals(parama)))
      {
        AppMethodBeat.o(55706);
        return;
      }
    }
    this.sOO.add(new WeakReference(parama));
    ad.i("MicroMsg.OrientationSensorMgr", "registerSensorListener %d", new Object[] { Integer.valueOf(this.sOO.size()) });
    if (this.sOO.size() == 1) {
      bTI();
    }
    AppMethodBeat.o(55706);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(55707);
    if ((this.sOO == null) || (parama == null))
    {
      AppMethodBeat.o(55707);
      return;
    }
    Iterator localIterator = this.sOO.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((a)localWeakReference.get()).equals(parama))) {
        this.sOO.remove(localWeakReference);
      }
    }
    ad.i("MicroMsg.OrientationSensorMgr", "unregisterSensorListener %d", new Object[] { Integer.valueOf(this.sOO.size()) });
    if (this.sOO.size() == 0) {
      cJl();
    }
    AppMethodBeat.o(55707);
  }
  
  public final double cJk()
  {
    AppMethodBeat.i(55703);
    if (this.sOU)
    {
      ad.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = true, result = %f", new Object[] { Double.valueOf(this.sOP) });
      d = this.sOP;
      AppMethodBeat.o(55703);
      return d;
    }
    ad.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = false, result = %f", new Object[] { Double.valueOf(this.sOT) });
    double d = this.sOT;
    AppMethodBeat.o(55703);
    return d;
  }
  
  final void cJl()
  {
    AppMethodBeat.i(55705);
    ad.i("MicroMsg.OrientationSensorMgr", "unregisterSensor ");
    this.mSensorManager.unregisterListener(this.sON);
    d.axT().c(this.fjJ);
    AppMethodBeat.o(55705);
  }
  
  public static abstract interface a
  {
    public abstract void x(double paramDouble);
  }
  
  protected final class b
    implements SensorEventListener
  {
    private float jVS = 0.0F;
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
          if ((l1 - l2 <= 200L) || (Math.abs(f1 - this.jVS) <= 3.0F)) {
            break label250;
          }
          paramSensorEvent = k.this;
          f2 = this.jVS;
          paramSensorEvent.sOT = f1;
          if (paramSensorEvent.sOO != null) {
            break label226;
          }
        }
        for (;;)
        {
          ad.d("MicroMsg.OrientationSensorMgr", "onOrientationChanged %f %f, mListenerList.size = %d", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Integer.valueOf(i) });
          if (paramSensorEvent.sOO == null) {
            break label238;
          }
          Iterator localIterator = paramSensorEvent.sOO.iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((k.a)localWeakReference.get()).x(paramSensorEvent.cJk());
            }
          }
          f1 = (f1 + ((int)f1 * -1 / 360 + 1) * 360) % 360.0F;
          break;
          label226:
          i = paramSensorEvent.sOO.size();
        }
        label238:
        this.jVS = f1;
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