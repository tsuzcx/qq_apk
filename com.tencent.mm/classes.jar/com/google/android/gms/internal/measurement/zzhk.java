package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.e.a;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.EventInterceptor;
import com.google.android.gms.measurement.AppMeasurement.OnEventListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class zzhk
  extends zzhh
{
  @VisibleForTesting
  protected zzid zzanp;
  private AppMeasurement.EventInterceptor zzanq;
  private final Set<AppMeasurement.OnEventListener> zzanr;
  private boolean zzans;
  private final AtomicReference<String> zzant;
  @VisibleForTesting
  protected boolean zzanu;
  
  protected zzhk(zzgl paramzzgl)
  {
    super(paramzzgl);
    AppMethodBeat.i(1672);
    this.zzanr = new CopyOnWriteArraySet();
    this.zzanu = true;
    this.zzant = new AtomicReference();
    AppMethodBeat.o(1672);
  }
  
  private final void zza(AppMeasurement.ConditionalUserProperty paramConditionalUserProperty)
  {
    AppMethodBeat.i(1704);
    long l = zzbt().currentTimeMillis();
    Preconditions.checkNotNull(paramConditionalUserProperty);
    Preconditions.checkNotEmpty(paramConditionalUserProperty.mName);
    Preconditions.checkNotEmpty(paramConditionalUserProperty.mOrigin);
    Preconditions.checkNotNull(paramConditionalUserProperty.mValue);
    paramConditionalUserProperty.mCreationTimestamp = l;
    String str = paramConditionalUserProperty.mName;
    Object localObject1 = paramConditionalUserProperty.mValue;
    if (zzgb().zzcf(str) != 0)
    {
      zzge().zzim().zzg("Invalid conditional user property name", zzga().zzbl(str));
      AppMethodBeat.o(1704);
      return;
    }
    if (zzgb().zzi(str, localObject1) != 0)
    {
      zzge().zzim().zze("Invalid conditional user property value", zzga().zzbl(str), localObject1);
      AppMethodBeat.o(1704);
      return;
    }
    Object localObject2 = zzgb().zzj(str, localObject1);
    if (localObject2 == null)
    {
      zzge().zzim().zze("Unable to normalize conditional user property value", zzga().zzbl(str), localObject1);
      AppMethodBeat.o(1704);
      return;
    }
    paramConditionalUserProperty.mValue = localObject2;
    l = paramConditionalUserProperty.mTriggerTimeout;
    if ((!TextUtils.isEmpty(paramConditionalUserProperty.mTriggerEventName)) && ((l > 15552000000L) || (l < 1L)))
    {
      zzge().zzim().zze("Invalid conditional user property timeout", zzga().zzbl(str), Long.valueOf(l));
      AppMethodBeat.o(1704);
      return;
    }
    l = paramConditionalUserProperty.mTimeToLive;
    if ((l > 15552000000L) || (l < 1L))
    {
      zzge().zzim().zze("Invalid conditional user property time to live", zzga().zzbl(str), Long.valueOf(l));
      AppMethodBeat.o(1704);
      return;
    }
    zzgd().zzc(new zzhr(this, paramConditionalUserProperty));
    AppMethodBeat.o(1704);
  }
  
  private final void zza(String paramString1, String paramString2, long paramLong, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    AppMethodBeat.i(1687);
    if (paramBundle == null)
    {
      paramBundle = new Bundle();
      zzgd().zzc(new zzic(this, paramString1, paramString2, paramLong, paramBundle, paramBoolean1, paramBoolean2, paramBoolean3, paramString3));
      AppMethodBeat.o(1687);
      return;
    }
    Bundle localBundle = new Bundle(paramBundle);
    Iterator localIterator = localBundle.keySet().iterator();
    for (;;)
    {
      paramBundle = localBundle;
      if (!localIterator.hasNext()) {
        break;
      }
      paramBundle = (String)localIterator.next();
      Object localObject = localBundle.get(paramBundle);
      if ((localObject instanceof Bundle))
      {
        localBundle.putBundle(paramBundle, new Bundle((Bundle)localObject));
      }
      else
      {
        int i;
        if ((localObject instanceof Parcelable[]))
        {
          paramBundle = (Parcelable[])localObject;
          i = 0;
          while (i < paramBundle.length)
          {
            if ((paramBundle[i] instanceof Bundle)) {
              paramBundle[i] = new Bundle((Bundle)paramBundle[i]);
            }
            i += 1;
          }
        }
        else if ((localObject instanceof ArrayList))
        {
          paramBundle = (ArrayList)localObject;
          i = 0;
          while (i < paramBundle.size())
          {
            localObject = paramBundle.get(i);
            if ((localObject instanceof Bundle)) {
              paramBundle.set(i, new Bundle((Bundle)localObject));
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private final void zza(String paramString1, String paramString2, long paramLong, Object paramObject)
  {
    AppMethodBeat.i(1690);
    zzgd().zzc(new zzhm(this, paramString1, paramString2, paramObject, paramLong));
    AppMethodBeat.o(1690);
  }
  
  private final void zza(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    AppMethodBeat.i(1686);
    zza(paramString1, paramString2, zzbt().currentTimeMillis(), paramBundle, true, paramBoolean2, paramBoolean3, null);
    AppMethodBeat.o(1686);
  }
  
  private final void zza(String paramString1, String paramString2, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(1691);
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    zzab();
    zzch();
    if (!this.zzacw.isEnabled())
    {
      zzge().zzis().log("User property not set since app measurement is disabled");
      AppMethodBeat.o(1691);
      return;
    }
    if (!this.zzacw.zzjv())
    {
      AppMethodBeat.o(1691);
      return;
    }
    zzge().zzis().zze("Setting user property (FE)", zzga().zzbj(paramString2), paramObject);
    paramString1 = new zzjx(paramString2, paramLong, paramObject, paramString1);
    zzfx().zzb(paramString1);
    AppMethodBeat.o(1691);
  }
  
  private final void zza(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    AppMethodBeat.i(1707);
    long l = zzbt().currentTimeMillis();
    Preconditions.checkNotEmpty(paramString2);
    AppMeasurement.ConditionalUserProperty localConditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
    localConditionalUserProperty.mAppId = paramString1;
    localConditionalUserProperty.mName = paramString2;
    localConditionalUserProperty.mCreationTimestamp = l;
    if (paramString3 != null)
    {
      localConditionalUserProperty.mExpiredEventName = paramString3;
      localConditionalUserProperty.mExpiredEventParams = paramBundle;
    }
    zzgd().zzc(new zzhs(this, localConditionalUserProperty));
    AppMethodBeat.o(1707);
  }
  
  @VisibleForTesting
  private final Map<String, Object> zzb(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(1715);
    if (zzgd().zzjk())
    {
      zzge().zzim().log("Cannot get user properties from analytics worker thread");
      paramString1 = Collections.emptyMap();
      AppMethodBeat.o(1715);
      return paramString1;
    }
    zzgd();
    if (zzgg.isMainThread())
    {
      zzge().zzim().log("Cannot get user properties from main thread");
      paramString1 = Collections.emptyMap();
      AppMethodBeat.o(1715);
      return paramString1;
    }
    synchronized (new AtomicReference())
    {
      this.zzacw.zzgd().zzc(new zzhu(this, ???, paramString1, paramString2, paramString3, paramBoolean));
      try
      {
        ???.wait(5000L);
        paramString2 = (List)???.get();
        if (paramString2 == null)
        {
          zzge().zzip().log("Timed out waiting for get user properties");
          paramString1 = Collections.emptyMap();
          AppMethodBeat.o(1715);
          return paramString1;
        }
      }
      catch (InterruptedException paramString1)
      {
        for (;;)
        {
          zzge().zzip().zzg("Interrupted waiting for get user properties", paramString1);
        }
      }
    }
    paramString1 = new a(paramString2.size());
    paramString2 = paramString2.iterator();
    while (paramString2.hasNext())
    {
      paramString3 = (zzjx)paramString2.next();
      paramString1.put(paramString3.name, paramString3.getValue());
    }
    AppMethodBeat.o(1715);
    return paramString1;
  }
  
  private final void zzb(AppMeasurement.ConditionalUserProperty paramConditionalUserProperty)
  {
    AppMethodBeat.i(1708);
    zzab();
    zzch();
    Preconditions.checkNotNull(paramConditionalUserProperty);
    Preconditions.checkNotEmpty(paramConditionalUserProperty.mName);
    Preconditions.checkNotEmpty(paramConditionalUserProperty.mOrigin);
    Preconditions.checkNotNull(paramConditionalUserProperty.mValue);
    if (!this.zzacw.isEnabled())
    {
      zzge().zzis().log("Conditional property not sent since Firebase Analytics is disabled");
      AppMethodBeat.o(1708);
      return;
    }
    zzjx localzzjx = new zzjx(paramConditionalUserProperty.mName, paramConditionalUserProperty.mTriggeredTimestamp, paramConditionalUserProperty.mValue, paramConditionalUserProperty.mOrigin);
    try
    {
      zzeu localzzeu1 = zzgb().zza(paramConditionalUserProperty.mTriggeredEventName, paramConditionalUserProperty.mTriggeredEventParams, paramConditionalUserProperty.mOrigin, 0L, true, false);
      zzeu localzzeu2 = zzgb().zza(paramConditionalUserProperty.mTimedOutEventName, paramConditionalUserProperty.mTimedOutEventParams, paramConditionalUserProperty.mOrigin, 0L, true, false);
      zzeu localzzeu3 = zzgb().zza(paramConditionalUserProperty.mExpiredEventName, paramConditionalUserProperty.mExpiredEventParams, paramConditionalUserProperty.mOrigin, 0L, true, false);
      paramConditionalUserProperty = new zzed(paramConditionalUserProperty.mAppId, paramConditionalUserProperty.mOrigin, localzzjx, paramConditionalUserProperty.mCreationTimestamp, false, paramConditionalUserProperty.mTriggerEventName, localzzeu2, paramConditionalUserProperty.mTriggerTimeout, localzzeu1, paramConditionalUserProperty.mTimeToLive, localzzeu3);
      zzfx().zzd(paramConditionalUserProperty);
      AppMethodBeat.o(1708);
      return;
    }
    catch (IllegalArgumentException paramConditionalUserProperty)
    {
      AppMethodBeat.o(1708);
    }
  }
  
  private final void zzb(String paramString1, String paramString2, long paramLong, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    AppMethodBeat.i(1688);
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotNull(paramBundle);
    zzab();
    zzch();
    if (!this.zzacw.isEnabled())
    {
      zzge().zzis().log("Event not sent since app measurement is disabled");
      AppMethodBeat.o(1688);
      return;
    }
    if (!this.zzans) {
      this.zzans = true;
    }
    int i;
    int j;
    for (;;)
    {
      try
      {
        localObject1 = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Object localObject1;
        zzge().zzir().log("Tag Manager is not found and thus will not be used");
        continue;
        if (localClassNotFoundException.zza("event", AppMeasurement.Event.zzacx, paramString2)) {
          continue;
        }
        i = 13;
        continue;
        if (localClassNotFoundException.zza("event", 40, paramString2)) {
          continue;
        }
        i = 2;
        continue;
        i = 0;
        continue;
        j = 0;
        continue;
        localObject3 = zzfy().zzkc();
        if ((localObject3 == null) || (paramBundle.containsKey("_sc"))) {
          continue;
        }
        ((zzie)localObject3).zzaok = true;
        if ((!paramBoolean1) || (!paramBoolean3)) {
          continue;
        }
        bool1 = true;
        zzif.zza((zzie)localObject3, paramBundle, bool1);
        bool1 = "am".equals(paramString1);
        boolean bool2 = zzka.zzci(paramString2);
        if ((!paramBoolean1) || (this.zzanq == null) || (bool2) || (bool1)) {
          continue;
        }
        zzge().zzis().zze("Passing event to registered event handler (FE)", zzga().zzbj(paramString2), zzga().zzb(paramBundle));
        this.zzanq.interceptEvent(paramString1, paramString2, paramBundle, paramLong);
        AppMethodBeat.o(1688);
        return;
        bool1 = false;
        continue;
        if (this.zzacw.zzjv()) {
          continue;
        }
        AppMethodBeat.o(1688);
        return;
        j = zzgb().zzcd(paramString2);
        if (j == 0) {
          continue;
        }
        zzge().zzio().zzg("Invalid event name. Event will not be logged (FE)", zzga().zzbj(paramString2));
        zzgb();
        paramString1 = zzka.zza(paramString2, 40, true);
        if (paramString2 == null) {
          continue;
        }
        i = paramString2.length();
        this.zzacw.zzgb().zza(paramString3, j, "_ev", paramString1, i);
        AppMethodBeat.o(1688);
        return;
        i = 0;
        continue;
        localList = CollectionUtils.listOf(new String[] { "_o", "_sn", "_sc", "_si" });
        localBundle1 = zzgb().zza(paramString2, paramBundle, localList, paramBoolean3, true);
        if (localBundle1 == null) {
          break label655;
        }
      }
      try
      {
        ((Class)localObject1).getDeclaredMethod("initialize", new Class[] { Context.class }).invoke(null, new Object[] { getContext() });
        if ((paramBoolean3) && (!"_iap".equals(paramString2)))
        {
          localObject1 = this.zzacw.zzgb();
          if (!((zzka)localObject1).zzq("event", paramString2))
          {
            i = 2;
            if (i == 0) {
              continue;
            }
            zzge().zzio().zzg("Invalid public event name. Event will not be logged (FE)", zzga().zzbj(paramString2));
            this.zzacw.zzgb();
            paramString1 = zzka.zza(paramString2, 40, true);
            if (paramString2 == null) {
              continue;
            }
            j = paramString2.length();
            this.zzacw.zzgb().zza(i, "_ev", paramString1, j);
            AppMethodBeat.o(1688);
          }
        }
      }
      catch (Exception localException)
      {
        zzge().zzip().zzg("Failed to invoke Tag Manager's initialize() method", localException);
      }
    }
    Object localObject3;
    boolean bool1;
    List localList;
    Bundle localBundle1;
    label655:
    Object localObject2;
    if ((!localBundle1.containsKey("_sc")) || (!localBundle1.containsKey("_si")))
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label1239;
      }
      localObject2 = localObject3;
    }
    label1032:
    label1182:
    label1188:
    label1191:
    label1236:
    label1239:
    for (;;)
    {
      localObject3 = new ArrayList();
      ((List)localObject3).add(localBundle1);
      long l = zzgb().zzlc().nextLong();
      i = 0;
      paramBundle = (String[])localBundle1.keySet().toArray(new String[paramBundle.size()]);
      Arrays.sort(paramBundle);
      int m = paramBundle.length;
      j = 0;
      if (j < m)
      {
        String str = paramBundle[j];
        Object localObject4 = localBundle1.get(str);
        zzgb();
        localObject4 = zzka.zze(localObject4);
        if (localObject4 == null) {
          break label1236;
        }
        localBundle1.putInt(str, localObject4.length);
        int k = 0;
        for (;;)
        {
          if (k < localObject4.length)
          {
            Bundle localBundle2 = localObject4[k];
            zzif.zza((zzie)localObject2, localBundle2, true);
            localBundle2 = zzgb().zza("_ep", localBundle2, localList, paramBoolean3, false);
            localBundle2.putString("_en", paramString2);
            localBundle2.putLong("_eid", l);
            localBundle2.putString("_gn", str);
            localBundle2.putInt("_ll", localObject4.length);
            localBundle2.putInt("_i", k);
            ((List)localObject3).add(localBundle2);
            k += 1;
            continue;
            localObject2 = new zzie(localBundle1.getString("_sn"), localBundle1.getString("_sc"), Long.valueOf(localBundle1.getLong("_si")).longValue());
            break;
          }
        }
        i = localObject4.length + i;
      }
      for (;;)
      {
        j += 1;
        break;
        if (i != 0)
        {
          localBundle1.putLong("_eid", l);
          localBundle1.putInt("_epc", i);
        }
        i = 0;
        while (i < ((List)localObject3).size())
        {
          localObject2 = (Bundle)((List)localObject3).get(i);
          if (i != 0)
          {
            j = 1;
            if (j == 0) {
              break label1182;
            }
            paramBundle = "_ep";
            ((Bundle)localObject2).putString("_o", paramString1);
            if (!paramBoolean2) {
              break label1188;
            }
            localObject2 = zzgb().zzd((Bundle)localObject2);
          }
          for (;;)
          {
            zzge().zzis().zze("Logging event (FE)", zzga().zzbj(paramString2), zzga().zzb((Bundle)localObject2));
            paramBundle = new zzeu(paramBundle, new zzer((Bundle)localObject2), paramString1, paramLong);
            zzfx().zzb(paramBundle, paramString3);
            if (bool1) {
              break label1191;
            }
            paramBundle = this.zzanr.iterator();
            while (paramBundle.hasNext()) {
              ((AppMeasurement.OnEventListener)paramBundle.next()).onEvent(paramString1, paramString2, new Bundle((Bundle)localObject2), paramLong);
            }
            j = 0;
            break;
            paramBundle = paramString2;
            break label1032;
          }
          i += 1;
        }
        if ((zzfy().zzkc() != null) && ("_ae".equals(paramString2))) {
          zzgc().zzl(true);
        }
        AppMethodBeat.o(1688);
        return;
      }
    }
  }
  
  private final void zzc(AppMeasurement.ConditionalUserProperty paramConditionalUserProperty)
  {
    AppMethodBeat.i(1709);
    zzab();
    zzch();
    Preconditions.checkNotNull(paramConditionalUserProperty);
    Preconditions.checkNotEmpty(paramConditionalUserProperty.mName);
    if (!this.zzacw.isEnabled())
    {
      zzge().zzis().log("Conditional property not cleared since Firebase Analytics is disabled");
      AppMethodBeat.o(1709);
      return;
    }
    zzjx localzzjx = new zzjx(paramConditionalUserProperty.mName, 0L, null, null);
    try
    {
      zzeu localzzeu = zzgb().zza(paramConditionalUserProperty.mExpiredEventName, paramConditionalUserProperty.mExpiredEventParams, paramConditionalUserProperty.mOrigin, paramConditionalUserProperty.mCreationTimestamp, true, false);
      paramConditionalUserProperty = new zzed(paramConditionalUserProperty.mAppId, paramConditionalUserProperty.mOrigin, localzzjx, paramConditionalUserProperty.mCreationTimestamp, paramConditionalUserProperty.mActive, paramConditionalUserProperty.mTriggerEventName, null, paramConditionalUserProperty.mTriggerTimeout, null, paramConditionalUserProperty.mTimeToLive, localzzeu);
      zzfx().zzd(paramConditionalUserProperty);
      AppMethodBeat.o(1709);
      return;
    }
    catch (IllegalArgumentException paramConditionalUserProperty)
    {
      AppMethodBeat.o(1709);
    }
  }
  
  @VisibleForTesting
  private final List<AppMeasurement.ConditionalUserProperty> zzf(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(1712);
    if (zzgd().zzjk())
    {
      zzge().zzim().log("Cannot get conditional user properties from analytics worker thread");
      paramString1 = Collections.emptyList();
      AppMethodBeat.o(1712);
      return paramString1;
    }
    zzgd();
    if (zzgg.isMainThread())
    {
      zzge().zzim().log("Cannot get conditional user properties from main thread");
      paramString1 = Collections.emptyList();
      AppMethodBeat.o(1712);
      return paramString1;
    }
    synchronized (new AtomicReference())
    {
      this.zzacw.zzgd().zzc(new zzht(this, (AtomicReference)???, paramString1, paramString2, paramString3));
      try
      {
        ???.wait(5000L);
        ??? = (List)((AtomicReference)???).get();
        if (??? == null)
        {
          zzge().zzip().zzg("Timed out waiting for get conditional user properties", paramString1);
          paramString1 = Collections.emptyList();
          AppMethodBeat.o(1712);
          return paramString1;
        }
      }
      catch (InterruptedException paramString3)
      {
        for (;;)
        {
          zzge().zzip().zze("Interrupted waiting for get conditional user properties", paramString1, paramString3);
        }
      }
    }
    paramString3 = new ArrayList(((List)???).size());
    ??? = ((List)???).iterator();
    while (((Iterator)???).hasNext())
    {
      zzed localzzed = (zzed)((Iterator)???).next();
      AppMeasurement.ConditionalUserProperty localConditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
      localConditionalUserProperty.mAppId = paramString1;
      localConditionalUserProperty.mOrigin = paramString2;
      localConditionalUserProperty.mCreationTimestamp = localzzed.creationTimestamp;
      localConditionalUserProperty.mName = localzzed.zzaep.name;
      localConditionalUserProperty.mValue = localzzed.zzaep.getValue();
      localConditionalUserProperty.mActive = localzzed.active;
      localConditionalUserProperty.mTriggerEventName = localzzed.triggerEventName;
      if (localzzed.zzaeq != null)
      {
        localConditionalUserProperty.mTimedOutEventName = localzzed.zzaeq.name;
        if (localzzed.zzaeq.zzafq != null) {
          localConditionalUserProperty.mTimedOutEventParams = localzzed.zzaeq.zzafq.zzif();
        }
      }
      localConditionalUserProperty.mTriggerTimeout = localzzed.triggerTimeout;
      if (localzzed.zzaer != null)
      {
        localConditionalUserProperty.mTriggeredEventName = localzzed.zzaer.name;
        if (localzzed.zzaer.zzafq != null) {
          localConditionalUserProperty.mTriggeredEventParams = localzzed.zzaer.zzafq.zzif();
        }
      }
      localConditionalUserProperty.mTriggeredTimestamp = localzzed.zzaep.zzaqz;
      localConditionalUserProperty.mTimeToLive = localzzed.timeToLive;
      if (localzzed.zzaes != null)
      {
        localConditionalUserProperty.mExpiredEventName = localzzed.zzaes.name;
        if (localzzed.zzaes.zzafq != null) {
          localConditionalUserProperty.mExpiredEventParams = localzzed.zzaes.zzafq.zzif();
        }
      }
      paramString3.add(localConditionalUserProperty);
    }
    AppMethodBeat.o(1712);
    return paramString3;
  }
  
  private final void zzi(boolean paramBoolean)
  {
    AppMethodBeat.i(1679);
    zzab();
    zzch();
    zzge().zzis().zzg("Setting app measurement enabled (FE)", Boolean.valueOf(paramBoolean));
    zzgf().setMeasurementEnabled(paramBoolean);
    if (zzgg().zzaz(zzfv().zzah()))
    {
      if ((this.zzacw.isEnabled()) && (this.zzanu))
      {
        zzge().zzis().log("Recording app launch after enabling measurement for the first time (FE)");
        zzkb();
        AppMethodBeat.o(1679);
        return;
      }
      zzfx().zzke();
      AppMethodBeat.o(1679);
      return;
    }
    zzfx().zzke();
    AppMethodBeat.o(1679);
  }
  
  public final void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(1705);
    zza(null, paramString1, paramString2, paramBundle);
    AppMethodBeat.o(1705);
  }
  
  public final void clearConditionalUserPropertyAs(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    AppMethodBeat.i(1706);
    Preconditions.checkNotEmpty(paramString1);
    zzfr();
    zza(paramString1, paramString2, paramString3, paramBundle);
    AppMethodBeat.o(1706);
  }
  
  public final Task<String> getAppInstanceId()
  {
    AppMethodBeat.i(1693);
    try
    {
      Object localObject = zzgf().zzja();
      if (localObject != null)
      {
        localObject = Tasks.forResult(localObject);
        AppMethodBeat.o(1693);
        return localObject;
      }
      localObject = Tasks.call(zzgd().zzjl(), new zzho(this));
      AppMethodBeat.o(1693);
      return localObject;
    }
    catch (Exception localException)
    {
      zzge().zzip().log("Failed to schedule task for getAppInstanceId");
      Task localTask = Tasks.forException(localException);
      AppMethodBeat.o(1693);
      return localTask;
    }
  }
  
  public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserProperties(String paramString1, String paramString2)
  {
    AppMethodBeat.i(1710);
    paramString1 = zzf(null, paramString1, paramString2);
    AppMethodBeat.o(1710);
    return paramString1;
  }
  
  public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserPropertiesAs(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(1711);
    Preconditions.checkNotEmpty(paramString1);
    zzfr();
    paramString1 = zzf(paramString1, paramString2, paramString3);
    AppMethodBeat.o(1711);
    return paramString1;
  }
  
  public final Map<String, Object> getUserProperties(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(1713);
    paramString1 = zzb(null, paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(1713);
    return paramString1;
  }
  
  public final Map<String, Object> getUserPropertiesAs(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(1714);
    Preconditions.checkNotEmpty(paramString1);
    zzfr();
    paramString1 = zzb(paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(1714);
    return paramString1;
  }
  
  public final void logEvent(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(1683);
    if ((this.zzanq == null) || (zzka.zzci(paramString2))) {}
    for (boolean bool = true;; bool = false)
    {
      zza(paramString1, paramString2, paramBundle, true, bool, false, null);
      AppMethodBeat.o(1683);
      return;
    }
  }
  
  public final void registerOnMeasurementEventListener(AppMeasurement.OnEventListener paramOnEventListener)
  {
    AppMethodBeat.i(1700);
    zzch();
    Preconditions.checkNotNull(paramOnEventListener);
    if (!this.zzanr.add(paramOnEventListener)) {
      zzge().zzip().log("OnEventListener already registered");
    }
    AppMethodBeat.o(1700);
  }
  
  public final void resetAnalyticsData()
  {
    AppMethodBeat.i(1697);
    long l = zzbt().currentTimeMillis();
    zzgd().zzc(new zzhq(this, l));
    AppMethodBeat.o(1697);
  }
  
  public final void setConditionalUserProperty(AppMeasurement.ConditionalUserProperty paramConditionalUserProperty)
  {
    AppMethodBeat.i(1702);
    Preconditions.checkNotNull(paramConditionalUserProperty);
    paramConditionalUserProperty = new AppMeasurement.ConditionalUserProperty(paramConditionalUserProperty);
    if (!TextUtils.isEmpty(paramConditionalUserProperty.mAppId)) {
      zzge().zzip().log("Package name should be null when calling setConditionalUserProperty");
    }
    paramConditionalUserProperty.mAppId = null;
    zza(paramConditionalUserProperty);
    AppMethodBeat.o(1702);
  }
  
  public final void setConditionalUserPropertyAs(AppMeasurement.ConditionalUserProperty paramConditionalUserProperty)
  {
    AppMethodBeat.i(1703);
    Preconditions.checkNotNull(paramConditionalUserProperty);
    Preconditions.checkNotEmpty(paramConditionalUserProperty.mAppId);
    zzfr();
    zza(new AppMeasurement.ConditionalUserProperty(paramConditionalUserProperty));
    AppMethodBeat.o(1703);
  }
  
  public final void setEventInterceptor(AppMeasurement.EventInterceptor paramEventInterceptor)
  {
    AppMethodBeat.i(1699);
    zzab();
    zzch();
    if ((paramEventInterceptor != null) && (paramEventInterceptor != this.zzanq)) {
      if (this.zzanq != null) {
        break label54;
      }
    }
    label54:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "EventInterceptor already set.");
      this.zzanq = paramEventInterceptor;
      AppMethodBeat.o(1699);
      return;
    }
  }
  
  public final void setMeasurementEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(1678);
    zzch();
    zzgd().zzc(new zzhz(this, paramBoolean));
    AppMethodBeat.o(1678);
  }
  
  public final void setMinimumSessionDuration(long paramLong)
  {
    AppMethodBeat.i(1680);
    zzgd().zzc(new zzia(this, paramLong));
    AppMethodBeat.o(1680);
  }
  
  public final void setSessionTimeoutDuration(long paramLong)
  {
    AppMethodBeat.i(1681);
    zzgd().zzc(new zzib(this, paramLong));
    AppMethodBeat.o(1681);
  }
  
  public final void setUserProperty(String paramString1, String paramString2, Object paramObject)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(1689);
    Preconditions.checkNotEmpty(paramString1);
    long l = zzbt().currentTimeMillis();
    int k = zzgb().zzcf(paramString2);
    if (k != 0)
    {
      zzgb();
      paramString1 = zzka.zza(paramString2, 24, true);
      i = j;
      if (paramString2 != null) {
        i = paramString2.length();
      }
      this.zzacw.zzgb().zza(k, "_ev", paramString1, i);
      AppMethodBeat.o(1689);
      return;
    }
    if (paramObject != null)
    {
      j = zzgb().zzi(paramString2, paramObject);
      if (j != 0)
      {
        zzgb();
        paramString1 = zzka.zza(paramString2, 24, true);
        if (((paramObject instanceof String)) || ((paramObject instanceof CharSequence))) {
          i = String.valueOf(paramObject).length();
        }
        this.zzacw.zzgb().zza(j, "_ev", paramString1, i);
        AppMethodBeat.o(1689);
        return;
      }
      paramObject = zzgb().zzj(paramString2, paramObject);
      if (paramObject != null) {
        zza(paramString1, paramString2, l, paramObject);
      }
      AppMethodBeat.o(1689);
      return;
    }
    zza(paramString1, paramString2, l, null);
    AppMethodBeat.o(1689);
  }
  
  public final void unregisterOnMeasurementEventListener(AppMeasurement.OnEventListener paramOnEventListener)
  {
    AppMethodBeat.i(1701);
    zzch();
    Preconditions.checkNotNull(paramOnEventListener);
    if (!this.zzanr.remove(paramOnEventListener)) {
      zzge().zzip().log("OnEventListener had not been registered");
    }
    AppMethodBeat.o(1701);
  }
  
  final void zza(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(1684);
    zzab();
    if ((this.zzanq == null) || (zzka.zzci(paramString2))) {}
    for (boolean bool = true;; bool = false)
    {
      zzb(paramString1, paramString2, zzbt().currentTimeMillis(), paramBundle, true, bool, false, null);
      AppMethodBeat.o(1684);
      return;
    }
  }
  
  public final void zza(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    AppMethodBeat.i(1685);
    zza(paramString1, paramString2, paramLong, paramBundle, false, true, true, null);
    AppMethodBeat.o(1685);
  }
  
  public final void zza(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(1682);
    if ((this.zzanq == null) || (zzka.zzci(paramString2))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      zza(paramString1, paramString2, paramBundle, true, paramBoolean, true, null);
      AppMethodBeat.o(1682);
      return;
    }
  }
  
  final String zzae(long paramLong)
  {
    AppMethodBeat.i(1696);
    synchronized (new AtomicReference())
    {
      zzgd().zzc(new zzhp(this, (AtomicReference)???));
      try
      {
        ???.wait(paramLong);
        ??? = (String)((AtomicReference)???).get();
        AppMethodBeat.o(1696);
        return ???;
      }
      catch (InterruptedException localInterruptedException)
      {
        zzge().zzip().log("Interrupted waiting for app instance id");
        AppMethodBeat.o(1696);
        return null;
      }
    }
  }
  
  final void zzbr(String paramString)
  {
    AppMethodBeat.i(1695);
    this.zzant.set(paramString);
    AppMethodBeat.o(1695);
  }
  
  protected final boolean zzhf()
  {
    return false;
  }
  
  public final String zzhm()
  {
    AppMethodBeat.i(1674);
    Object localObject = new AtomicReference();
    localObject = (String)zzgd().zza((AtomicReference)localObject, 15000L, "String test flag value", new zzhv(this, (AtomicReference)localObject));
    AppMethodBeat.o(1674);
    return localObject;
  }
  
  public final List<zzjx> zzj(boolean paramBoolean)
  {
    AppMethodBeat.i(1692);
    zzch();
    zzge().zzis().log("Fetching user attributes (FE)");
    if (zzgd().zzjk())
    {
      zzge().zzim().log("Cannot get all user properties from analytics worker thread");
      ??? = Collections.emptyList();
      AppMethodBeat.o(1692);
      return ???;
    }
    zzgd();
    if (zzgg.isMainThread())
    {
      zzge().zzim().log("Cannot get all user properties from main thread");
      ??? = Collections.emptyList();
      AppMethodBeat.o(1692);
      return ???;
    }
    synchronized (new AtomicReference())
    {
      this.zzacw.zzgd().zzc(new zzhn(this, (AtomicReference)???, paramBoolean));
      try
      {
        ???.wait(5000L);
        ??? = (List)((AtomicReference)???).get();
        if (??? == null)
        {
          zzge().zzip().log("Timed out waiting for get user properties");
          ??? = Collections.emptyList();
          AppMethodBeat.o(1692);
          return ???;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          zzge().zzip().zzg("Interrupted waiting for get user properties", localInterruptedException);
        }
      }
    }
    AppMethodBeat.o(1692);
    return ???;
  }
  
  public final String zzja()
  {
    AppMethodBeat.i(1694);
    String str = (String)this.zzant.get();
    AppMethodBeat.o(1694);
    return str;
  }
  
  public final Boolean zzjx()
  {
    AppMethodBeat.i(1673);
    Object localObject = new AtomicReference();
    localObject = (Boolean)zzgd().zza((AtomicReference)localObject, 15000L, "boolean test flag value", new zzhl(this, (AtomicReference)localObject));
    AppMethodBeat.o(1673);
    return localObject;
  }
  
  public final Long zzjy()
  {
    AppMethodBeat.i(1675);
    Object localObject = new AtomicReference();
    localObject = (Long)zzgd().zza((AtomicReference)localObject, 15000L, "long test flag value", new zzhw(this, (AtomicReference)localObject));
    AppMethodBeat.o(1675);
    return localObject;
  }
  
  public final Integer zzjz()
  {
    AppMethodBeat.i(1676);
    Object localObject = new AtomicReference();
    localObject = (Integer)zzgd().zza((AtomicReference)localObject, 15000L, "int test flag value", new zzhx(this, (AtomicReference)localObject));
    AppMethodBeat.o(1676);
    return localObject;
  }
  
  public final Double zzka()
  {
    AppMethodBeat.i(1677);
    Object localObject = new AtomicReference();
    localObject = (Double)zzgd().zza((AtomicReference)localObject, 15000L, "double test flag value", new zzhy(this, (AtomicReference)localObject));
    AppMethodBeat.o(1677);
    return localObject;
  }
  
  public final void zzkb()
  {
    AppMethodBeat.i(1698);
    zzab();
    zzch();
    if (!this.zzacw.zzjv())
    {
      AppMethodBeat.o(1698);
      return;
    }
    zzfx().zzkb();
    this.zzanu = false;
    String str = zzgf().zzjd();
    if (!TextUtils.isEmpty(str))
    {
      zzfw().zzch();
      if (!str.equals(Build.VERSION.RELEASE))
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("_po", str);
        logEvent("auto", "_ou", localBundle);
      }
    }
    AppMethodBeat.o(1698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzhk
 * JD-Core Version:    0.7.0.1
 */