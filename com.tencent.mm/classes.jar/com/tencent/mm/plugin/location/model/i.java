package com.tencent.mm.plugin.location.model;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public final class i
{
  private SensorManager aVT = (SensorManager)ae.getContext().getSystemService("sensor");
  private a.a dig = new i.1(this);
  private c egs;
  private i.b lDa = new i.b(this);
  HashSet<WeakReference<i.a>> lDb = new HashSet();
  double lDc = 900.0D;
  double lDd = 900.0D;
  double lDe = -1000.0D;
  double lDf = -1000.0D;
  double lDg = 0.0D;
  boolean lDh = false;
  
  private void bdR()
  {
    y.i("MicroMsg.OrientationSensorMgr", "registerSensor ");
    if (this.egs == null) {
      this.egs = c.Ob();
    }
    this.egs.b(this.dig, true);
    Sensor localSensor = this.aVT.getDefaultSensor(3);
    this.aVT.registerListener(this.lDa, localSensor, 1);
  }
  
  public final void a(i.a parama)
  {
    Iterator localIterator = this.lDb.iterator();
    WeakReference localWeakReference;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localWeakReference = (WeakReference)localIterator.next();
    } while ((localWeakReference == null) || (localWeakReference.get() == null) || (!((i.a)localWeakReference.get()).equals(parama)));
    do
    {
      return;
      this.lDb.add(new WeakReference(parama));
      y.i("MicroMsg.OrientationSensorMgr", "registerSensorListener %d", new Object[] { Integer.valueOf(this.lDb.size()) });
    } while (this.lDb.size() != 1);
    bdR();
  }
  
  public final void b(i.a parama)
  {
    if ((this.lDb == null) || (parama == null)) {}
    do
    {
      return;
      Iterator localIterator = this.lDb.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (((i.a)localWeakReference.get()).equals(parama))) {
          this.lDb.remove(localWeakReference);
        }
      }
      y.i("MicroMsg.OrientationSensorMgr", "unregisterSensorListener %d", new Object[] { Integer.valueOf(this.lDb.size()) });
    } while (this.lDb.size() != 0);
    bdS();
  }
  
  public final double bdQ()
  {
    if (this.lDh)
    {
      y.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = true, result = %f", new Object[] { Double.valueOf(this.lDc) });
      return this.lDc;
    }
    y.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = false, result = %f", new Object[] { Double.valueOf(this.lDg) });
    return this.lDg;
  }
  
  final void bdS()
  {
    y.i("MicroMsg.OrientationSensorMgr", "unregisterSensor ");
    this.aVT.unregisterListener(this.lDa);
    c.Ob().c(this.dig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.i
 * JD-Core Version:    0.7.0.1
 */