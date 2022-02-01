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
  private b EjF;
  HashSet<WeakReference<a>> EjG;
  double EjH;
  double EjI;
  double EjJ;
  double EjK;
  double EjL;
  boolean EjM;
  private b.a iQJ;
  private d lEL;
  private SensorManager mSensorManager;
  
  public k()
  {
    AppMethodBeat.i(55702);
    this.EjF = new b();
    this.EjG = new HashSet();
    this.EjH = 900.0D;
    this.EjI = 900.0D;
    this.EjJ = -1000.0D;
    this.EjK = -1000.0D;
    this.EjL = 0.0D;
    this.EjM = false;
    this.iQJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(55700);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(55700);
          return false;
        }
        if ((k.this.EjJ != -1000.0D) && (k.this.EjK != -1000.0D)) {
          k.this.EjM = f.a(k.this.EjK, k.this.EjJ, paramAnonymousFloat1, paramAnonymousFloat2, paramAnonymousInt, paramAnonymousDouble1);
        }
        k.this.EjJ = paramAnonymousFloat2;
        k.this.EjK = paramAnonymousFloat1;
        if ((k.this.EjI == 900.0D) || (k.this.EjH == 900.0D))
        {
          k localk1 = k.this;
          k localk2 = k.this;
          paramAnonymousDouble1 = f.g(paramAnonymousFloat2, paramAnonymousFloat1);
          localk2.EjH = paramAnonymousDouble1;
          localk1.EjI = paramAnonymousDouble1;
        }
        for (;;)
        {
          Log.d("MicroMsg.OrientationSensorMgr", "onGetLocation, update headding, mCurrentHeading = %f, mPreviousHeading = %f mIsMove = %b", new Object[] { Double.valueOf(k.this.EjH), Double.valueOf(k.this.EjI), Boolean.valueOf(k.this.EjM) });
          AppMethodBeat.o(55700);
          return true;
          k.this.EjI = k.this.EjH;
          k.this.EjH = f.g(paramAnonymousFloat2, paramAnonymousFloat1);
        }
      }
    };
    this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    AppMethodBeat.o(55702);
  }
  
  private void cTj()
  {
    AppMethodBeat.i(55704);
    Log.i("MicroMsg.OrientationSensorMgr", "registerSensor ");
    if (this.lEL == null) {
      this.lEL = d.blq();
    }
    this.lEL.b(this.iQJ, true);
    Sensor localSensor = this.mSensorManager.getDefaultSensor(3);
    this.mSensorManager.registerListener(this.EjF, localSensor, 1);
    AppMethodBeat.o(55704);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(55706);
    Iterator localIterator = this.EjG.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((a)localWeakReference.get()).equals(parama)))
      {
        AppMethodBeat.o(55706);
        return;
      }
    }
    this.EjG.add(new WeakReference(parama));
    Log.i("MicroMsg.OrientationSensorMgr", "registerSensorListener %d", new Object[] { Integer.valueOf(this.EjG.size()) });
    if (this.EjG.size() == 1) {
      cTj();
    }
    AppMethodBeat.o(55706);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(55707);
    if ((this.EjG == null) || (parama == null))
    {
      AppMethodBeat.o(55707);
      return;
    }
    Iterator localIterator = this.EjG.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((a)localWeakReference.get()).equals(parama))) {
        this.EjG.remove(localWeakReference);
      }
    }
    Log.i("MicroMsg.OrientationSensorMgr", "unregisterSensorListener %d", new Object[] { Integer.valueOf(this.EjG.size()) });
    if (this.EjG.size() == 0) {
      eMe();
    }
    AppMethodBeat.o(55707);
  }
  
  public final double eMd()
  {
    AppMethodBeat.i(55703);
    if (this.EjM)
    {
      Log.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = true, result = %f", new Object[] { Double.valueOf(this.EjH) });
      d = this.EjH;
      AppMethodBeat.o(55703);
      return d;
    }
    Log.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = false, result = %f", new Object[] { Double.valueOf(this.EjL) });
    double d = this.EjL;
    AppMethodBeat.o(55703);
    return d;
  }
  
  final void eMe()
  {
    AppMethodBeat.i(55705);
    Log.i("MicroMsg.OrientationSensorMgr", "unregisterSensor ");
    this.mSensorManager.unregisterListener(this.EjF);
    d.blq().b(this.iQJ);
    AppMethodBeat.o(55705);
  }
  
  public static abstract interface a
  {
    public abstract void x(double paramDouble);
  }
  
  protected final class b
    implements SensorEventListener
  {
    private float oZt = 0.0F;
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
          if ((l1 - l2 <= 200L) || (Math.abs(f1 - this.oZt) <= 3.0F)) {
            break label250;
          }
          paramSensorEvent = k.this;
          f2 = this.oZt;
          paramSensorEvent.EjL = f1;
          if (paramSensorEvent.EjG != null) {
            break label226;
          }
        }
        for (;;)
        {
          Log.d("MicroMsg.OrientationSensorMgr", "onOrientationChanged %f %f, mListenerList.size = %d", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Integer.valueOf(i) });
          if (paramSensorEvent.EjG == null) {
            break label238;
          }
          Iterator localIterator = paramSensorEvent.EjG.iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((k.a)localWeakReference.get()).x(paramSensorEvent.eMd());
            }
          }
          f1 = (f1 + ((int)f1 * -1 / 360 + 1) * 360) % 360.0F;
          break;
          label226:
          i = paramSensorEvent.EjG.size();
        }
        label238:
        this.oZt = f1;
        this.timestamp = System.currentTimeMillis();
      }
      label250:
      AppMethodBeat.o(55701);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.k
 * JD-Core Version:    0.7.0.1
 */