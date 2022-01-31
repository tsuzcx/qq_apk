package com.tencent.mm.plugin.location.model;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public final class i
{
  private SensorManager bmB;
  private b.a dZA;
  private d fwu;
  private i.b oam;
  HashSet<WeakReference<i.a>> oan;
  double oao;
  double oap;
  double oaq;
  double oar;
  double oas;
  boolean oat;
  
  public i()
  {
    AppMethodBeat.i(113320);
    this.oam = new i.b(this);
    this.oan = new HashSet();
    this.oao = 900.0D;
    this.oap = 900.0D;
    this.oaq = -1000.0D;
    this.oar = -1000.0D;
    this.oas = 0.0D;
    this.oat = false;
    this.dZA = new i.1(this);
    this.bmB = ((SensorManager)ah.getContext().getSystemService("sensor"));
    AppMethodBeat.o(113320);
  }
  
  private void bLl()
  {
    AppMethodBeat.i(113322);
    ab.i("MicroMsg.OrientationSensorMgr", "registerSensor ");
    if (this.fwu == null) {
      this.fwu = d.agQ();
    }
    this.fwu.b(this.dZA, true);
    Sensor localSensor = this.bmB.getDefaultSensor(3);
    this.bmB.registerListener(this.oam, localSensor, 1);
    AppMethodBeat.o(113322);
  }
  
  public final void a(i.a parama)
  {
    AppMethodBeat.i(113324);
    Iterator localIterator = this.oan.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((i.a)localWeakReference.get()).equals(parama)))
      {
        AppMethodBeat.o(113324);
        return;
      }
    }
    this.oan.add(new WeakReference(parama));
    ab.i("MicroMsg.OrientationSensorMgr", "registerSensorListener %d", new Object[] { Integer.valueOf(this.oan.size()) });
    if (this.oan.size() == 1) {
      bLl();
    }
    AppMethodBeat.o(113324);
  }
  
  public final void b(i.a parama)
  {
    AppMethodBeat.i(113325);
    if ((this.oan == null) || (parama == null))
    {
      AppMethodBeat.o(113325);
      return;
    }
    Iterator localIterator = this.oan.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((i.a)localWeakReference.get()).equals(parama))) {
        this.oan.remove(localWeakReference);
      }
    }
    ab.i("MicroMsg.OrientationSensorMgr", "unregisterSensorListener %d", new Object[] { Integer.valueOf(this.oan.size()) });
    if (this.oan.size() == 0) {
      bLm();
    }
    AppMethodBeat.o(113325);
  }
  
  public final double bLk()
  {
    AppMethodBeat.i(113321);
    if (this.oat)
    {
      ab.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = true, result = %f", new Object[] { Double.valueOf(this.oao) });
      d = this.oao;
      AppMethodBeat.o(113321);
      return d;
    }
    ab.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = false, result = %f", new Object[] { Double.valueOf(this.oas) });
    double d = this.oas;
    AppMethodBeat.o(113321);
    return d;
  }
  
  final void bLm()
  {
    AppMethodBeat.i(113323);
    ab.i("MicroMsg.OrientationSensorMgr", "unregisterSensor ");
    this.bmB.unregisterListener(this.oam);
    d.agQ().c(this.dZA);
    AppMethodBeat.o(113323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.i
 * JD-Core Version:    0.7.0.1
 */