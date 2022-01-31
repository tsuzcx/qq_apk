package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
public final class zzii
  extends zzhh
{
  private final zziw zzaox;
  private zzey zzaoy;
  private volatile Boolean zzaoz;
  private final zzem zzapa;
  private final zzjm zzapb;
  private final List<Runnable> zzapc;
  private final zzem zzapd;
  
  protected zzii(zzgl paramzzgl)
  {
    super(paramzzgl);
    AppMethodBeat.i(69276);
    this.zzapc = new ArrayList();
    this.zzapb = new zzjm(paramzzgl.zzbt());
    this.zzaox = new zziw(this);
    this.zzapa = new zzij(this, paramzzgl);
    this.zzapd = new zzio(this, paramzzgl);
    AppMethodBeat.o(69276);
  }
  
  private final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(69294);
    zzab();
    if (this.zzaoy != null)
    {
      this.zzaoy = null;
      zzge().zzit().zzg("Disconnected from device MeasurementService", paramComponentName);
      zzab();
      zzdf();
    }
    AppMethodBeat.o(69294);
  }
  
  private final void zzcu()
  {
    AppMethodBeat.i(69290);
    zzab();
    this.zzapb.start();
    this.zzapa.zzh(((Long)zzew.zzaho.get()).longValue());
    AppMethodBeat.o(69290);
  }
  
  private final void zzcv()
  {
    AppMethodBeat.i(69295);
    zzab();
    if (!isConnected())
    {
      AppMethodBeat.o(69295);
      return;
    }
    zzge().zzit().log("Inactivity, disconnecting from the service");
    disconnect();
    AppMethodBeat.o(69295);
  }
  
  private final void zzf(Runnable paramRunnable)
  {
    AppMethodBeat.i(69296);
    zzab();
    if (isConnected())
    {
      paramRunnable.run();
      AppMethodBeat.o(69296);
      return;
    }
    if (this.zzapc.size() >= 1000L)
    {
      zzge().zzim().log("Discarding data. Max runnable queue size reached");
      AppMethodBeat.o(69296);
      return;
    }
    this.zzapc.add(paramRunnable);
    this.zzapd.zzh(60000L);
    zzdf();
    AppMethodBeat.o(69296);
  }
  
  private final zzdz zzk(boolean paramBoolean)
  {
    AppMethodBeat.i(69298);
    zzfb localzzfb = zzfv();
    if (paramBoolean) {}
    for (Object localObject = zzge().zziv();; localObject = null)
    {
      localObject = localzzfb.zzbi((String)localObject);
      AppMethodBeat.o(69298);
      return localObject;
    }
  }
  
  private final void zzkg()
  {
    AppMethodBeat.i(69297);
    zzab();
    zzge().zzit().zzg("Processing queued up service tasks", Integer.valueOf(this.zzapc.size()));
    Iterator localIterator = this.zzapc.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      try
      {
        localRunnable.run();
      }
      catch (Exception localException)
      {
        zzge().zzim().zzg("Task exception while flushing queue", localException);
      }
    }
    this.zzapc.clear();
    this.zzapd.cancel();
    AppMethodBeat.o(69297);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(69293);
    zzab();
    zzch();
    try
    {
      ConnectionTracker.getInstance().unbindService(getContext(), this.zzaox);
      label27:
      this.zzaoy = null;
      AppMethodBeat.o(69293);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label27;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label27;
    }
  }
  
  public final boolean isConnected()
  {
    AppMethodBeat.i(69277);
    zzab();
    zzch();
    if (this.zzaoy != null)
    {
      AppMethodBeat.o(69277);
      return true;
    }
    AppMethodBeat.o(69277);
    return false;
  }
  
  protected final void resetAnalyticsData()
  {
    AppMethodBeat.i(69286);
    zzab();
    zzch();
    zzdz localzzdz = zzk(false);
    zzfz().resetAnalyticsData();
    zzf(new zzik(this, localzzdz));
    AppMethodBeat.o(69286);
  }
  
  @VisibleForTesting
  protected final void zza(zzey paramzzey)
  {
    AppMethodBeat.i(69292);
    zzab();
    Preconditions.checkNotNull(paramzzey);
    this.zzaoy = paramzzey;
    zzcu();
    zzkg();
    AppMethodBeat.o(69292);
  }
  
  @VisibleForTesting
  final void zza(zzey paramzzey, AbstractSafeParcelable paramAbstractSafeParcelable, zzdz paramzzdz)
  {
    AppMethodBeat.i(69279);
    zzab();
    zzch();
    int j = 0;
    int i = 100;
    ArrayList localArrayList;
    Object localObject;
    if ((j < 1001) && (i == 100))
    {
      localArrayList = new ArrayList();
      localObject = zzfz().zzp(100);
      if (localObject == null) {
        break label307;
      }
      localArrayList.addAll((Collection)localObject);
    }
    label307:
    for (i = ((List)localObject).size();; i = 0)
    {
      if ((paramAbstractSafeParcelable != null) && (i < 100)) {
        localArrayList.add(paramAbstractSafeParcelable);
      }
      localArrayList = (ArrayList)localArrayList;
      int m = localArrayList.size();
      int k = 0;
      while (k < m)
      {
        localObject = localArrayList.get(k);
        k += 1;
        localObject = (AbstractSafeParcelable)localObject;
        if ((localObject instanceof zzeu)) {
          try
          {
            paramzzey.zza((zzeu)localObject, paramzzdz);
          }
          catch (RemoteException localRemoteException1)
          {
            zzge().zzim().zzg("Failed to send event to the service", localRemoteException1);
          }
        } else if ((localRemoteException1 instanceof zzjx)) {
          try
          {
            paramzzey.zza((zzjx)localRemoteException1, paramzzdz);
          }
          catch (RemoteException localRemoteException2)
          {
            zzge().zzim().zzg("Failed to send attribute to the service", localRemoteException2);
          }
        } else if ((localRemoteException2 instanceof zzed)) {
          try
          {
            paramzzey.zza((zzed)localRemoteException2, paramzzdz);
          }
          catch (RemoteException localRemoteException3)
          {
            zzge().zzim().zzg("Failed to send conditional property to the service", localRemoteException3);
          }
        } else {
          zzge().zzim().log("Discarding data. Unrecognized parcel type.");
        }
      }
      j += 1;
      break;
      AppMethodBeat.o(69279);
      return;
    }
  }
  
  public final void zza(AtomicReference<String> paramAtomicReference)
  {
    AppMethodBeat.i(69287);
    zzab();
    zzch();
    zzf(new zzil(this, paramAtomicReference, zzk(false)));
    AppMethodBeat.o(69287);
  }
  
  protected final void zza(AtomicReference<List<zzed>> paramAtomicReference, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(69282);
    zzab();
    zzch();
    zzf(new zzis(this, paramAtomicReference, paramString1, paramString2, paramString3, zzk(false)));
    AppMethodBeat.o(69282);
  }
  
  protected final void zza(AtomicReference<List<zzjx>> paramAtomicReference, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(69283);
    zzab();
    zzch();
    zzf(new zzit(this, paramAtomicReference, paramString1, paramString2, paramString3, paramBoolean, zzk(false)));
    AppMethodBeat.o(69283);
  }
  
  protected final void zza(AtomicReference<List<zzjx>> paramAtomicReference, boolean paramBoolean)
  {
    AppMethodBeat.i(69285);
    zzab();
    zzch();
    zzf(new zziv(this, paramAtomicReference, zzk(false), paramBoolean));
    AppMethodBeat.o(69285);
  }
  
  protected final void zzb(zzeu paramzzeu, String paramString)
  {
    AppMethodBeat.i(69280);
    Preconditions.checkNotNull(paramzzeu);
    zzab();
    zzch();
    if (zzfz().zza(paramzzeu)) {}
    for (boolean bool = true;; bool = false)
    {
      zzf(new zziq(this, true, bool, paramzzeu, zzk(true), paramString));
      AppMethodBeat.o(69280);
      return;
    }
  }
  
  protected final void zzb(zzie paramzzie)
  {
    AppMethodBeat.i(69289);
    zzab();
    zzch();
    zzf(new zzin(this, paramzzie));
    AppMethodBeat.o(69289);
  }
  
  protected final void zzb(zzjx paramzzjx)
  {
    AppMethodBeat.i(69284);
    zzab();
    zzch();
    if (zzfz().zza(paramzzjx)) {}
    for (boolean bool = true;; bool = false)
    {
      zzf(new zziu(this, bool, paramzzjx, zzk(true)));
      AppMethodBeat.o(69284);
      return;
    }
  }
  
  protected final void zzd(zzed paramzzed)
  {
    AppMethodBeat.i(69281);
    Preconditions.checkNotNull(paramzzed);
    zzab();
    zzch();
    if (zzfz().zzc(paramzzed)) {}
    for (boolean bool = true;; bool = false)
    {
      zzf(new zzir(this, true, bool, new zzed(paramzzed), zzk(true), paramzzed));
      AppMethodBeat.o(69281);
      return;
    }
  }
  
  final void zzdf()
  {
    int j = 1;
    AppMethodBeat.i(69291);
    zzab();
    zzch();
    if (isConnected())
    {
      AppMethodBeat.o(69291);
      return;
    }
    boolean bool2;
    if (this.zzaoz == null)
    {
      zzab();
      zzch();
      localObject = zzgf().zzjb();
      if ((localObject != null) && (((Boolean)localObject).booleanValue()))
      {
        bool2 = true;
        this.zzaoz = Boolean.valueOf(bool2);
      }
    }
    else
    {
      if (!this.zzaoz.booleanValue()) {
        break label423;
      }
      this.zzaox.zzkh();
      AppMethodBeat.o(69291);
      return;
    }
    boolean bool1;
    if (zzfv().zzik() == 1)
    {
      bool1 = true;
      i = 1;
    }
    for (;;)
    {
      bool2 = bool1;
      if (i == 0) {
        break;
      }
      zzgf().zzf(bool1);
      bool2 = bool1;
      break;
      zzge().zzit().log("Checking service availability");
      localObject = zzgb();
      i = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(((zzhg)localObject).getContext(), 12451);
      switch (i)
      {
      default: 
        zzge().zzip().zzg("Unexpected service status", Integer.valueOf(i));
        bool1 = false;
        i = 0;
        break;
      case 0: 
        zzge().zzit().log("Service available");
        bool1 = true;
        i = 1;
        break;
      case 1: 
        zzge().zzit().log("Service missing");
        bool1 = false;
        i = 1;
        break;
      case 18: 
        zzge().zzip().log("Service updating");
        bool1 = true;
        i = 1;
        break;
      case 2: 
        zzge().zzis().log("Service container out of date");
        if (zzgb().zzld() < 12600)
        {
          bool1 = false;
          i = 1;
        }
        else
        {
          localObject = zzgf().zzjb();
          if ((localObject == null) || (((Boolean)localObject).booleanValue())) {}
          for (bool1 = true;; bool1 = false)
          {
            i = 0;
            break;
          }
        }
        break;
      case 3: 
        zzge().zzip().log("Service disabled");
        bool1 = false;
        i = 0;
        break;
      case 9: 
        zzge().zzip().log("Service invalid");
        bool1 = false;
        i = 0;
      }
    }
    label423:
    Object localObject = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
    if ((localObject != null) && (((List)localObject).size() > 0)) {}
    for (int i = j; i != 0; i = 0)
    {
      localObject = new Intent("com.google.android.gms.measurement.START");
      ((Intent)localObject).setComponent(new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
      this.zzaox.zzc((Intent)localObject);
      AppMethodBeat.o(69291);
      return;
    }
    zzge().zzim().log("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
    AppMethodBeat.o(69291);
  }
  
  protected final boolean zzhf()
  {
    return false;
  }
  
  protected final void zzkb()
  {
    AppMethodBeat.i(69288);
    zzab();
    zzch();
    zzf(new zzim(this, zzk(true)));
    AppMethodBeat.o(69288);
  }
  
  protected final void zzke()
  {
    AppMethodBeat.i(69278);
    zzab();
    zzch();
    zzf(new zzip(this, zzk(true)));
    AppMethodBeat.o(69278);
  }
  
  final Boolean zzkf()
  {
    return this.zzaoz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzii
 * JD-Core Version:    0.7.0.1
 */