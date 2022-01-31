package com.google.android.gms.internal;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.analytics.zzh;
import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzsi
  extends zzsa
{
  private boolean mStarted;
  private final zzsg zzaeA;
  private final zztf zzaeB;
  private final zzte zzaeC;
  private final zzsf zzaeD;
  private long zzaeE;
  private final zzsr zzaeF;
  private final zzsr zzaeG;
  private final zztj zzaeH;
  private long zzaeI;
  private boolean zzaeJ;
  
  protected zzsi(zzsc paramzzsc, zzsd paramzzsd)
  {
    super(paramzzsc);
    zzac.zzw(paramzzsd);
    this.zzaeE = -9223372036854775808L;
    this.zzaeC = paramzzsd.zzk(paramzzsc);
    this.zzaeA = paramzzsd.zzm(paramzzsc);
    this.zzaeB = paramzzsd.zzn(paramzzsc);
    this.zzaeD = paramzzsd.zzo(paramzzsc);
    this.zzaeH = new zztj(zznR());
    this.zzaeF = new zzsi.1(this, paramzzsc);
    this.zzaeG = new zzsi.2(this, paramzzsc);
  }
  
  private void zza(zzse paramzzse, zzrl paramzzrl)
  {
    zzac.zzw(paramzzse);
    zzac.zzw(paramzzrl);
    Object localObject1 = new zza(zznQ());
    ((zza)localObject1).zzbo(paramzzse.zzok());
    ((zza)localObject1).enableAdvertisingIdCollection(paramzzse.zzol());
    localObject1 = ((zza)localObject1).zzmo();
    zzrt localzzrt = (zzrt)((com.google.android.gms.analytics.zze)localObject1).zzb(zzrt.class);
    localzzrt.zzbE("data");
    localzzrt.zzT(true);
    ((com.google.android.gms.analytics.zze)localObject1).zza(paramzzrl);
    zzro localzzro = (zzro)((com.google.android.gms.analytics.zze)localObject1).zzb(zzro.class);
    zzrk localzzrk = (zzrk)((com.google.android.gms.analytics.zze)localObject1).zzb(zzrk.class);
    Iterator localIterator = paramzzse.zzfE().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      if ("an".equals(str)) {
        localzzrk.setAppName((String)localObject2);
      } else if ("av".equals(str)) {
        localzzrk.setAppVersion((String)localObject2);
      } else if ("aid".equals(str)) {
        localzzrk.setAppId((String)localObject2);
      } else if ("aiid".equals(str)) {
        localzzrk.setAppInstallerId((String)localObject2);
      } else if ("uid".equals(str)) {
        localzzrt.setUserId((String)localObject2);
      } else {
        localzzro.set(str, (String)localObject2);
      }
    }
    zzb("Sending installation campaign to", paramzzse.zzok(), paramzzrl);
    ((com.google.android.gms.analytics.zze)localObject1).zzq(zznW().zzqe());
    ((com.google.android.gms.analytics.zze)localObject1).zzmG();
  }
  
  private boolean zzbW(String paramString)
  {
    return zzadg.zzbi(getContext()).checkCallingOrSelfPermission(paramString) == 0;
  }
  
  private void zzoB()
  {
    zzb(new zzsu()
    {
      public void zzf(Throwable paramAnonymousThrowable)
      {
        zzsi.this.zzoH();
      }
    });
  }
  
  private void zzoC()
  {
    try
    {
      this.zzaeA.zzot();
      zzoH();
      this.zzaeG.zzy(86400000L);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        zzd("Failed to delete stale hits", localSQLiteException);
      }
    }
  }
  
  private boolean zzoI()
  {
    if (this.zzaeJ) {}
    while (zzoO() <= 0L) {
      return false;
    }
    return true;
  }
  
  private void zzoJ()
  {
    zzst localzzst = zznV();
    if (!localzzst.zzpD()) {}
    long l;
    do
    {
      do
      {
        return;
      } while (localzzst.zzcy());
      l = zzou();
    } while ((l == 0L) || (Math.abs(zznR().currentTimeMillis() - l) > zznT().zzpf()));
    zza("Dispatch alarm scheduled (ms)", Long.valueOf(zznT().zzpe()));
    localzzst.schedule();
  }
  
  private void zzoK()
  {
    zzoJ();
    long l2 = zzoO();
    long l1 = zznW().zzqg();
    if (l1 != 0L)
    {
      l1 = l2 - Math.abs(zznR().currentTimeMillis() - l1);
      if (l1 <= 0L) {}
    }
    for (;;)
    {
      zza("Dispatch scheduled (ms)", Long.valueOf(l1));
      if (!this.zzaeF.zzcy()) {
        break;
      }
      l1 = Math.max(1L, l1 + this.zzaeF.zzpA());
      this.zzaeF.zzz(l1);
      return;
      l1 = Math.min(zznT().zzpc(), l2);
      continue;
      l1 = Math.min(zznT().zzpc(), l2);
    }
    this.zzaeF.zzy(l1);
  }
  
  private void zzoL()
  {
    zzoM();
    zzoN();
  }
  
  private void zzoM()
  {
    if (this.zzaeF.zzcy()) {
      zzbP("All hits dispatched or no network/service. Going to power save mode");
    }
    this.zzaeF.cancel();
  }
  
  private void zzoN()
  {
    zzst localzzst = zznV();
    if (localzzst.zzcy()) {
      localzzst.cancel();
    }
  }
  
  private void zzoz()
  {
    zzmR();
    Context localContext = zznQ().getContext();
    if (!zzth.zzak(localContext)) {
      zzbS("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
    }
    do
    {
      while (!CampaignTrackingReceiver.zzak(localContext))
      {
        zzbS("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        return;
        if (!zzti.zzal(localContext)) {
          zzbT("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
      }
    } while (CampaignTrackingService.zzal(localContext));
    zzbS("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
  }
  
  protected void onServiceConnected()
  {
    zzmR();
    zzoE();
  }
  
  void start()
  {
    zzob();
    if (!this.mStarted) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zza(bool, "Analytics backend already started");
      this.mStarted = true;
      zznU().zzg(new Runnable()
      {
        public void run()
        {
          zzsi.this.zzoA();
        }
      });
      return;
    }
  }
  
  public void zzW(boolean paramBoolean)
  {
    zzoH();
  }
  
  /* Error */
  public long zza(zzse paramzzse, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 38	com/google/android/gms/common/internal/zzac:zzw	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 436	com/google/android/gms/internal/zzsi:zzob	()V
    //   9: aload_0
    //   10: invokevirtual 394	com/google/android/gms/internal/zzsi:zzmR	()V
    //   13: aload_0
    //   14: getfield 56	com/google/android/gms/internal/zzsi:zzaeA	Lcom/google/android/gms/internal/zzsg;
    //   17: invokevirtual 459	com/google/android/gms/internal/zzsg:beginTransaction	()V
    //   20: aload_0
    //   21: getfield 56	com/google/android/gms/internal/zzsi:zzaeA	Lcom/google/android/gms/internal/zzsg;
    //   24: aload_1
    //   25: invokevirtual 462	com/google/android/gms/internal/zzse:zzoj	()J
    //   28: aload_1
    //   29: invokevirtual 465	com/google/android/gms/internal/zzse:zzmy	()Ljava/lang/String;
    //   32: invokevirtual 468	com/google/android/gms/internal/zzsg:zza	(JLjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 56	com/google/android/gms/internal/zzsi:zzaeA	Lcom/google/android/gms/internal/zzsg;
    //   39: aload_1
    //   40: invokevirtual 462	com/google/android/gms/internal/zzse:zzoj	()J
    //   43: aload_1
    //   44: invokevirtual 465	com/google/android/gms/internal/zzse:zzmy	()Ljava/lang/String;
    //   47: aload_1
    //   48: invokevirtual 107	com/google/android/gms/internal/zzse:zzok	()Ljava/lang/String;
    //   51: invokevirtual 471	com/google/android/gms/internal/zzsg:zza	(JLjava/lang/String;Ljava/lang/String;)J
    //   54: lstore_3
    //   55: iload_2
    //   56: ifne +32 -> 88
    //   59: aload_1
    //   60: lload_3
    //   61: invokevirtual 474	com/google/android/gms/internal/zzse:zzs	(J)V
    //   64: aload_0
    //   65: getfield 56	com/google/android/gms/internal/zzsi:zzaeA	Lcom/google/android/gms/internal/zzsg;
    //   68: aload_1
    //   69: invokevirtual 477	com/google/android/gms/internal/zzsg:zzb	(Lcom/google/android/gms/internal/zzse;)V
    //   72: aload_0
    //   73: getfield 56	com/google/android/gms/internal/zzsi:zzaeA	Lcom/google/android/gms/internal/zzsg;
    //   76: invokevirtual 480	com/google/android/gms/internal/zzsg:setTransactionSuccessful	()V
    //   79: aload_0
    //   80: getfield 56	com/google/android/gms/internal/zzsi:zzaeA	Lcom/google/android/gms/internal/zzsg;
    //   83: invokevirtual 483	com/google/android/gms/internal/zzsg:endTransaction	()V
    //   86: lload_3
    //   87: lreturn
    //   88: aload_1
    //   89: lconst_1
    //   90: lload_3
    //   91: ladd
    //   92: invokevirtual 474	com/google/android/gms/internal/zzse:zzs	(J)V
    //   95: goto -31 -> 64
    //   98: astore_1
    //   99: aload_0
    //   100: ldc_w 485
    //   103: aload_1
    //   104: invokevirtual 488	com/google/android/gms/internal/zzsi:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   107: aload_0
    //   108: getfield 56	com/google/android/gms/internal/zzsi:zzaeA	Lcom/google/android/gms/internal/zzsg;
    //   111: invokevirtual 483	com/google/android/gms/internal/zzsg:endTransaction	()V
    //   114: ldc2_w 489
    //   117: lreturn
    //   118: astore_1
    //   119: aload_0
    //   120: ldc_w 492
    //   123: aload_1
    //   124: invokevirtual 488	com/google/android/gms/internal/zzsi:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   127: lload_3
    //   128: lreturn
    //   129: astore_1
    //   130: aload_0
    //   131: ldc_w 492
    //   134: aload_1
    //   135: invokevirtual 488	com/google/android/gms/internal/zzsi:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   138: goto -24 -> 114
    //   141: astore_1
    //   142: aload_0
    //   143: getfield 56	com/google/android/gms/internal/zzsi:zzaeA	Lcom/google/android/gms/internal/zzsg;
    //   146: invokevirtual 483	com/google/android/gms/internal/zzsg:endTransaction	()V
    //   149: aload_1
    //   150: athrow
    //   151: astore 5
    //   153: aload_0
    //   154: ldc_w 492
    //   157: aload 5
    //   159: invokevirtual 488	com/google/android/gms/internal/zzsi:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   162: goto -13 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	zzsi
    //   0	165	1	paramzzse	zzse
    //   0	165	2	paramBoolean	boolean
    //   54	74	3	l	long
    //   151	7	5	localSQLiteException	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   13	55	98	android/database/sqlite/SQLiteException
    //   59	64	98	android/database/sqlite/SQLiteException
    //   64	79	98	android/database/sqlite/SQLiteException
    //   88	95	98	android/database/sqlite/SQLiteException
    //   79	86	118	android/database/sqlite/SQLiteException
    //   107	114	129	android/database/sqlite/SQLiteException
    //   13	55	141	finally
    //   59	64	141	finally
    //   64	79	141	finally
    //   88	95	141	finally
    //   99	107	141	finally
    //   142	149	151	android/database/sqlite/SQLiteException
  }
  
  public void zza(zzsu paramzzsu, long paramLong)
  {
    zzh.zzmR();
    zzob();
    long l1 = -1L;
    long l2 = zznW().zzqg();
    if (l2 != 0L) {
      l1 = Math.abs(zznR().currentTimeMillis() - l2);
    }
    zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(l1));
    zzoD();
    try
    {
      zzoF();
      zznW().zzqh();
      zzoH();
      if (paramzzsu != null) {
        paramzzsu.zzf(null);
      }
      if (this.zzaeI != paramLong) {
        this.zzaeC.zzpZ();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        zze("Local dispatch failed", localThrowable);
        zznW().zzqh();
        zzoH();
      } while (paramzzsu == null);
      paramzzsu.zzf(localThrowable);
    }
  }
  
  public void zza(zzsz paramzzsz)
  {
    zzac.zzw(paramzzsz);
    zzh.zzmR();
    zzob();
    if (this.zzaeJ) {
      zzbQ("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
    }
    for (;;)
    {
      paramzzsz = zzf(paramzzsz);
      zzoD();
      if (!this.zzaeD.zzb(paramzzsz)) {
        break;
      }
      zzbQ("Hit sent to the device AnalyticsService for delivery");
      return;
      zza("Delivering hit", paramzzsz);
    }
    try
    {
      this.zzaeA.zzc(paramzzsz);
      zzoH();
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zze("Delivery failed to save hit to a database", localSQLiteException);
      zznS().zza(paramzzsz, "deliver: failed to insert hit to database");
    }
  }
  
  public void zzb(zzsu paramzzsu)
  {
    zza(paramzzsu, this.zzaeI);
  }
  
  public void zzbX(String paramString)
  {
    zzac.zzdr(paramString);
    zzmR();
    zzrl localzzrl = zztm.zza(zznS(), paramString);
    if (localzzrl == null) {
      zzd("Parsing failed. Ignoring invalid campaign data", paramString);
    }
    for (;;)
    {
      return;
      String str = zznW().zzqi();
      if (paramString.equals(str))
      {
        zzbS("Ignoring duplicate install campaign");
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        zzd("Ignoring multiple install campaigns. original, new", str, paramString);
        return;
      }
      zznW().zzcb(paramString);
      if (zznW().zzqf().zzA(zznT().zzpy()))
      {
        zzd("Campaign received too late, ignoring", localzzrl);
        return;
      }
      zzb("Received installation campaign", localzzrl);
      paramString = this.zzaeA.zzw(0L).iterator();
      while (paramString.hasNext()) {
        zza((zzse)paramString.next(), localzzrl);
      }
    }
  }
  
  protected void zzc(zzse paramzzse)
  {
    zzmR();
    zzb("Sending first hit to property", paramzzse.zzok());
    if (zznW().zzqf().zzA(zznT().zzpy())) {}
    do
    {
      return;
      localObject = zznW().zzqi();
    } while (TextUtils.isEmpty((CharSequence)localObject));
    Object localObject = zztm.zza(zznS(), (String)localObject);
    zzb("Found relevant installation campaign", localObject);
    zza(paramzzse, (zzrl)localObject);
  }
  
  zzsz zzf(zzsz paramzzsz)
  {
    if (!TextUtils.isEmpty(paramzzsz.zzpU())) {}
    do
    {
      return paramzzsz;
      localObject2 = zznW().zzqj().zzqm();
    } while (localObject2 == null);
    Object localObject1 = (Long)((Pair)localObject2).second;
    Object localObject2 = (String)((Pair)localObject2).first;
    localObject1 = String.valueOf(localObject1);
    localObject1 = String.valueOf(localObject1).length() + 1 + String.valueOf(localObject2).length() + (String)localObject1 + ":" + (String)localObject2;
    localObject2 = new HashMap(paramzzsz.zzfE());
    ((Map)localObject2).put("_m", localObject1);
    return zzsz.zza(this, paramzzsz, (Map)localObject2);
  }
  
  protected void zzmS()
  {
    this.zzaeA.initialize();
    this.zzaeB.initialize();
    this.zzaeD.initialize();
  }
  
  public void zznK()
  {
    zzh.zzmR();
    zzob();
    zzbP("Delete all hits from local store");
    try
    {
      this.zzaeA.zzor();
      this.zzaeA.zzos();
      zzoH();
      zzoD();
      if (this.zzaeD.zzon()) {
        zzbP("Device service unavailable. Can't clear hits stored on the device service.");
      }
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        zzd("Failed to delete hits from store", localSQLiteException);
      }
    }
  }
  
  public void zznN()
  {
    zzh.zzmR();
    zzob();
    zzbP("Service disconnected");
  }
  
  void zznP()
  {
    zzmR();
    this.zzaeI = zznR().currentTimeMillis();
  }
  
  protected void zzoA()
  {
    zzob();
    zzoz();
    zznW().zzqe();
    if (!zzbW("android.permission.ACCESS_NETWORK_STATE"))
    {
      zzbT("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
      zzoP();
    }
    if (!zzbW("android.permission.INTERNET"))
    {
      zzbT("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
      zzoP();
    }
    if (zzti.zzal(getContext())) {
      zzbP("AnalyticsService registered in the app manifest and enabled");
    }
    for (;;)
    {
      if ((!this.zzaeJ) && (!this.zzaeA.isEmpty())) {
        zzoD();
      }
      zzoH();
      return;
      zzbS("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
    }
  }
  
  protected void zzoD()
  {
    if (this.zzaeJ) {}
    do
    {
      long l;
      do
      {
        do
        {
          return;
        } while ((!zznT().zzoX()) || (this.zzaeD.isConnected()));
        l = zznT().zzps();
      } while (!this.zzaeH.zzA(l));
      this.zzaeH.start();
      zzbP("Connecting to service");
    } while (!this.zzaeD.connect());
    zzbP("Connected to service");
    this.zzaeH.clear();
    onServiceConnected();
  }
  
  public void zzoE()
  {
    zzh.zzmR();
    zzob();
    if (!zznT().zzoX()) {
      zzbS("Service client disabled. Can't dispatch local hits to device AnalyticsService");
    }
    if (!this.zzaeD.isConnected()) {
      zzbP("Service not connected");
    }
    while (this.zzaeA.isEmpty()) {
      return;
    }
    zzbP("Dispatching local hits to device AnalyticsService");
    for (;;)
    {
      try
      {
        List localList = this.zzaeA.zzu(zznT().zzpg());
        if (!localList.isEmpty()) {
          break label122;
        }
        zzoH();
        return;
      }
      catch (SQLiteException localSQLiteException1)
      {
        zze("Failed to read hits from store", localSQLiteException1);
        zzoL();
        return;
      }
      label103:
      Object localObject;
      localSQLiteException1.remove(localObject);
      try
      {
        this.zzaeA.zzv(((zzsz)localObject).zzpP());
        label122:
        if (!localSQLiteException1.isEmpty())
        {
          localObject = (zzsz)localSQLiteException1.get(0);
          if (this.zzaeD.zzb((zzsz)localObject)) {
            break label103;
          }
          zzoH();
          return;
        }
      }
      catch (SQLiteException localSQLiteException2)
      {
        zze("Failed to remove hit that was send for delivery", localSQLiteException2);
        zzoL();
      }
    }
  }
  
  protected boolean zzoF()
  {
    int j = 1;
    zzh.zzmR();
    zzob();
    zzbP("Dispatching a batch of local hits");
    int i;
    if (!this.zzaeD.isConnected())
    {
      i = 1;
      if (this.zzaeB.zzqa()) {
        break label60;
      }
    }
    for (;;)
    {
      if ((i == 0) || (j == 0)) {
        break label65;
      }
      zzbP("No network or service available. Will retry later");
      return false;
      i = 0;
      break;
      label60:
      j = 0;
    }
    label65:
    long l3 = Math.max(zznT().zzpg(), zznT().zzph());
    ArrayList localArrayList = new ArrayList();
    long l1 = 0L;
    try
    {
      for (;;)
      {
        this.zzaeA.beginTransaction();
        localArrayList.clear();
        try
        {
          localList = this.zzaeA.zzu(l3);
          if (localList.isEmpty())
          {
            zzbP("Store is empty, nothing to dispatch");
            zzoL();
            try
            {
              this.zzaeA.setTransactionSuccessful();
              this.zzaeA.endTransaction();
              return false;
            }
            catch (SQLiteException localSQLiteException1)
            {
              zze("Failed to commit local dispatch transaction", localSQLiteException1);
              zzoL();
              return false;
            }
          }
          zza("Hits loaded from store. count", Integer.valueOf(localList.size()));
          localObject2 = localList.iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext()) {
              if (((zzsz)((Iterator)localObject2).next()).zzpP() == l1)
              {
                zzd("Database contains successfully uploaded hit", Long.valueOf(l1), Integer.valueOf(localList.size()));
                zzoL();
                try
                {
                  this.zzaeA.setTransactionSuccessful();
                  this.zzaeA.endTransaction();
                  return false;
                }
                catch (SQLiteException localSQLiteException2)
                {
                  zze("Failed to commit local dispatch transaction", localSQLiteException2);
                  zzoL();
                  return false;
                }
              }
            }
          }
        }
        catch (SQLiteException localSQLiteException3)
        {
          List localList;
          Object localObject2;
          zzd("Failed to read hits from persisted store", localSQLiteException3);
          zzoL();
          try
          {
            this.zzaeA.setTransactionSuccessful();
            this.zzaeA.endTransaction();
            return false;
          }
          catch (SQLiteException localSQLiteException4)
          {
            zze("Failed to commit local dispatch transaction", localSQLiteException4);
            zzoL();
            return false;
          }
          long l2 = l1;
          if (this.zzaeD.isConnected())
          {
            zzbP("Service connected, sending hits to the service");
            for (;;)
            {
              l2 = l1;
              if (!localList.isEmpty())
              {
                localObject2 = (zzsz)localList.get(0);
                l2 = l1;
                if (this.zzaeD.zzb((zzsz)localObject2))
                {
                  l1 = Math.max(l1, ((zzsz)localObject2).zzpP());
                  localList.remove(localObject2);
                  zzb("Hit sent do device AnalyticsService for delivery", localObject2);
                  try
                  {
                    this.zzaeA.zzv(((zzsz)localObject2).zzpP());
                    localSQLiteException4.add(Long.valueOf(((zzsz)localObject2).zzpP()));
                  }
                  catch (SQLiteException localSQLiteException5)
                  {
                    zze("Failed to remove hit that was send for delivery", localSQLiteException5);
                    zzoL();
                    try
                    {
                      this.zzaeA.setTransactionSuccessful();
                      this.zzaeA.endTransaction();
                      return false;
                    }
                    catch (SQLiteException localSQLiteException6)
                    {
                      zze("Failed to commit local dispatch transaction", localSQLiteException6);
                      zzoL();
                      return false;
                    }
                  }
                }
              }
            }
          }
          l1 = l2;
          if (this.zzaeB.zzqa())
          {
            localList = this.zzaeB.zzt(localList);
            localObject2 = localList.iterator();
            for (l1 = l2; ((Iterator)localObject2).hasNext(); l1 = Math.max(l1, ((Long)((Iterator)localObject2).next()).longValue())) {}
          }
          try
          {
            this.zzaeA.zzr(localList);
            localSQLiteException6.addAll(localList);
            boolean bool = localSQLiteException6.isEmpty();
            if (bool) {
              try
              {
                this.zzaeA.setTransactionSuccessful();
                this.zzaeA.endTransaction();
                return false;
              }
              catch (SQLiteException localSQLiteException7)
              {
                zze("Failed to commit local dispatch transaction", localSQLiteException7);
                zzoL();
                return false;
              }
            }
          }
          catch (SQLiteException localSQLiteException8)
          {
            zze("Failed to remove successfully uploaded hits", localSQLiteException8);
            zzoL();
            try
            {
              this.zzaeA.setTransactionSuccessful();
              this.zzaeA.endTransaction();
              return false;
            }
            catch (SQLiteException localSQLiteException9)
            {
              zze("Failed to commit local dispatch transaction", localSQLiteException9);
              zzoL();
              return false;
            }
            try
            {
              this.zzaeA.setTransactionSuccessful();
              this.zzaeA.endTransaction();
            }
            catch (SQLiteException localSQLiteException10)
            {
              zze("Failed to commit local dispatch transaction", localSQLiteException10);
              zzoL();
              return false;
            }
          }
        }
      }
      return false;
    }
    finally
    {
      try
      {
        this.zzaeA.setTransactionSuccessful();
        this.zzaeA.endTransaction();
        throw localObject1;
      }
      catch (SQLiteException localSQLiteException11)
      {
        zze("Failed to commit local dispatch transaction", localSQLiteException11);
        zzoL();
      }
    }
  }
  
  public void zzoG()
  {
    zzh.zzmR();
    zzob();
    zzbQ("Sync dispatching local hits");
    long l = this.zzaeI;
    zzoD();
    try
    {
      zzoF();
      zznW().zzqh();
      zzoH();
      if (this.zzaeI != l) {
        this.zzaeC.zzpZ();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      zze("Sync local dispatch failed", localThrowable);
      zzoH();
    }
  }
  
  public void zzoH()
  {
    zznQ().zzmR();
    zzob();
    if (!zzoI())
    {
      this.zzaeC.unregister();
      zzoL();
      return;
    }
    if (this.zzaeA.isEmpty())
    {
      this.zzaeC.unregister();
      zzoL();
      return;
    }
    if (!((Boolean)zzsw.zzafS.get()).booleanValue()) {
      this.zzaeC.zzpX();
    }
    for (boolean bool = this.zzaeC.isConnected(); bool; bool = true)
    {
      zzoK();
      return;
    }
    zzoL();
    zzoJ();
  }
  
  public long zzoO()
  {
    long l;
    if (this.zzaeE != -9223372036854775808L) {
      l = this.zzaeE;
    }
    do
    {
      return l;
      l = zznT().zzpd();
    } while (!zzmB().zzpK());
    return zzmB().zzqB() * 1000L;
  }
  
  public void zzoP()
  {
    zzob();
    zzmR();
    this.zzaeJ = true;
    this.zzaeD.disconnect();
    zzoH();
  }
  
  public long zzou()
  {
    zzh.zzmR();
    zzob();
    try
    {
      long l = this.zzaeA.zzou();
      return l;
    }
    catch (SQLiteException localSQLiteException)
    {
      zze("Failed to get min/max hit times from local store", localSQLiteException);
    }
    return 0L;
  }
  
  public void zzx(long paramLong)
  {
    zzh.zzmR();
    zzob();
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    this.zzaeE = l;
    zzoH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzsi
 * JD-Core Version:    0.7.0.1
 */