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
  private b.a gmA;
  private d iOv;
  private SensorManager mSensorManager;
  private b yFM;
  HashSet<WeakReference<a>> yFN;
  double yFO;
  double yFP;
  double yFQ;
  double yFR;
  double yFS;
  boolean yFT;
  
  public k()
  {
    AppMethodBeat.i(55702);
    this.yFM = new b();
    this.yFN = new HashSet();
    this.yFO = 900.0D;
    this.yFP = 900.0D;
    this.yFQ = -1000.0D;
    this.yFR = -1000.0D;
    this.yFS = 0.0D;
    this.yFT = false;
    this.gmA = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(55700);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(55700);
          return false;
        }
        if ((k.this.yFQ != -1000.0D) && (k.this.yFR != -1000.0D)) {
          k.this.yFT = f.a(k.this.yFR, k.this.yFQ, paramAnonymousFloat1, paramAnonymousFloat2, paramAnonymousInt, paramAnonymousDouble1);
        }
        k.this.yFQ = paramAnonymousFloat2;
        k.this.yFR = paramAnonymousFloat1;
        if ((k.this.yFP == 900.0D) || (k.this.yFO == 900.0D))
        {
          k localk1 = k.this;
          k localk2 = k.this;
          paramAnonymousDouble1 = f.h(paramAnonymousFloat2, paramAnonymousFloat1);
          localk2.yFO = paramAnonymousDouble1;
          localk1.yFP = paramAnonymousDouble1;
        }
        for (;;)
        {
          Log.d("MicroMsg.OrientationSensorMgr", "onGetLocation, update headding, mCurrentHeading = %f, mPreviousHeading = %f mIsMove = %b", new Object[] { Double.valueOf(k.this.yFO), Double.valueOf(k.this.yFP), Boolean.valueOf(k.this.yFT) });
          AppMethodBeat.o(55700);
          return true;
          k.this.yFP = k.this.yFO;
          k.this.yFO = f.h(paramAnonymousFloat2, paramAnonymousFloat1);
        }
      }
    };
    this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    AppMethodBeat.o(55702);
  }
  
  private void cED()
  {
    AppMethodBeat.i(55704);
    Log.i("MicroMsg.OrientationSensorMgr", "registerSensor ");
    if (this.iOv == null) {
      this.iOv = d.bca();
    }
    this.iOv.b(this.gmA, true);
    Sensor localSensor = this.mSensorManager.getDefaultSensor(3);
    this.mSensorManager.registerListener(this.yFM, localSensor, 1);
    AppMethodBeat.o(55704);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(55706);
    Iterator localIterator = this.yFN.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((a)localWeakReference.get()).equals(parama)))
      {
        AppMethodBeat.o(55706);
        return;
      }
    }
    this.yFN.add(new WeakReference(parama));
    Log.i("MicroMsg.OrientationSensorMgr", "registerSensorListener %d", new Object[] { Integer.valueOf(this.yFN.size()) });
    if (this.yFN.size() == 1) {
      cED();
    }
    AppMethodBeat.o(55706);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(55707);
    if ((this.yFN == null) || (parama == null))
    {
      AppMethodBeat.o(55707);
      return;
    }
    Iterator localIterator = this.yFN.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((a)localWeakReference.get()).equals(parama))) {
        this.yFN.remove(localWeakReference);
      }
    }
    Log.i("MicroMsg.OrientationSensorMgr", "unregisterSensorListener %d", new Object[] { Integer.valueOf(this.yFN.size()) });
    if (this.yFN.size() == 0) {
      ecM();
    }
    AppMethodBeat.o(55707);
  }
  
  public final double ecL()
  {
    AppMethodBeat.i(55703);
    if (this.yFT)
    {
      Log.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = true, result = %f", new Object[] { Double.valueOf(this.yFO) });
      d = this.yFO;
      AppMethodBeat.o(55703);
      return d;
    }
    Log.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = false, result = %f", new Object[] { Double.valueOf(this.yFS) });
    double d = this.yFS;
    AppMethodBeat.o(55703);
    return d;
  }
  
  final void ecM()
  {
    AppMethodBeat.i(55705);
    Log.i("MicroMsg.OrientationSensorMgr", "unregisterSensor ");
    this.mSensorManager.unregisterListener(this.yFM);
    d.bca().c(this.gmA);
    AppMethodBeat.o(55705);
  }
  
  public static abstract interface a
  {
    public abstract void w(double paramDouble);
  }
  
  protected final class b
    implements SensorEventListener
  {
    private float mbC = 0.0F;
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
          if ((l1 - l2 <= 200L) || (Math.abs(f1 - this.mbC) <= 3.0F)) {
            break label250;
          }
          paramSensorEvent = k.this;
          f2 = this.mbC;
          paramSensorEvent.yFS = f1;
          if (paramSensorEvent.yFN != null) {
            break label226;
          }
        }
        for (;;)
        {
          Log.d("MicroMsg.OrientationSensorMgr", "onOrientationChanged %f %f, mListenerList.size = %d", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Integer.valueOf(i) });
          if (paramSensorEvent.yFN == null) {
            break label238;
          }
          Iterator localIterator = paramSensorEvent.yFN.iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((k.a)localWeakReference.get()).w(paramSensorEvent.ecL());
            }
          }
          f1 = (f1 + ((int)f1 * -1 / 360 + 1) * 360) % 360.0F;
          break;
          label226:
          i = paramSensorEvent.yFN.size();
        }
        label238:
        this.mbC = f1;
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