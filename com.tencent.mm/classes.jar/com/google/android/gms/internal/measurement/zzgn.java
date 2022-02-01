package com.google.android.gms.internal.measurement;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class zzgn
  extends zzez
{
  private final zzjr zzajp;
  private Boolean zzanc;
  private String zzand;
  
  public zzgn(zzjr paramzzjr)
  {
    this(paramzzjr, null);
  }
  
  private zzgn(zzjr paramzzjr, String paramString)
  {
    AppMethodBeat.i(1613);
    Preconditions.checkNotNull(paramzzjr);
    this.zzajp = paramzzjr;
    this.zzand = null;
    AppMethodBeat.o(1613);
  }
  
  private final void zzb(zzdz paramzzdz, boolean paramBoolean)
  {
    AppMethodBeat.i(1621);
    Preconditions.checkNotNull(paramzzdz);
    zzc(paramzzdz.packageName, false);
    this.zzajp.zzgb().zzcg(paramzzdz.zzadm);
    AppMethodBeat.o(1621);
  }
  
  private final void zzc(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(1622);
    if (TextUtils.isEmpty(paramString))
    {
      this.zzajp.zzge().zzim().log("Measurement Service called without app package");
      paramString = new SecurityException("Measurement Service called without app package");
      AppMethodBeat.o(1622);
      throw paramString;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (this.zzanc == null)
        {
          if (("com.google.android.gms".equals(this.zzand)) || (UidVerifier.isGooglePlayServicesUid(this.zzajp.getContext(), Binder.getCallingUid()))) {
            break label237;
          }
          paramBoolean = bool;
          if (GoogleSignatureVerifier.getInstance(this.zzajp.getContext()).isUidGoogleSigned(Binder.getCallingUid())) {
            break label237;
          }
          this.zzanc = Boolean.valueOf(paramBoolean);
        }
        if (!this.zzanc.booleanValue())
        {
          if ((this.zzand == null) && (GooglePlayServicesUtilLight.uidHasPackageName(this.zzajp.getContext(), Binder.getCallingUid(), paramString))) {
            this.zzand = paramString;
          }
          if (!paramString.equals(this.zzand))
          {
            SecurityException localSecurityException1 = new SecurityException(String.format("Unknown calling package name '%s'.", new Object[] { paramString }));
            AppMethodBeat.o(1622);
            throw localSecurityException1;
          }
        }
      }
      catch (SecurityException localSecurityException2)
      {
        this.zzajp.zzge().zzim().zzg("Measurement Service called with invalid calling package. appId", zzfg.zzbm(paramString));
        AppMethodBeat.o(1622);
        throw localSecurityException2;
      }
      AppMethodBeat.o(1622);
      return;
      label237:
      paramBoolean = true;
    }
  }
  
  @VisibleForTesting
  private final void zze(Runnable paramRunnable)
  {
    AppMethodBeat.i(1632);
    Preconditions.checkNotNull(paramRunnable);
    if ((((Boolean)zzew.zzaia.get()).booleanValue()) && (this.zzajp.zzgd().zzjk()))
    {
      paramRunnable.run();
      AppMethodBeat.o(1632);
      return;
    }
    this.zzajp.zzgd().zzc(paramRunnable);
    AppMethodBeat.o(1632);
  }
  
  /* Error */
  public final List<zzjx> zza(zzdz paramzzdz, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 1619
    //   3: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: iconst_0
    //   9: invokespecial 203	com/google/android/gms/internal/measurement/zzgn:zzb	(Lcom/google/android/gms/internal/measurement/zzdz;Z)V
    //   12: aload_0
    //   13: getfield 33	com/google/android/gms/internal/measurement/zzgn:zzajp	Lcom/google/android/gms/internal/measurement/zzjr;
    //   16: invokevirtual 183	com/google/android/gms/internal/measurement/zzjr:zzgd	()Lcom/google/android/gms/internal/measurement/zzgg;
    //   19: new 205	com/google/android/gms/internal/measurement/zzhd
    //   22: dup
    //   23: aload_0
    //   24: aload_1
    //   25: invokespecial 208	com/google/android/gms/internal/measurement/zzhd:<init>	(Lcom/google/android/gms/internal/measurement/zzgn;Lcom/google/android/gms/internal/measurement/zzdz;)V
    //   28: invokevirtual 211	com/google/android/gms/internal/measurement/zzgg:zzb	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   31: astore_3
    //   32: aload_3
    //   33: invokeinterface 214 1 0
    //   38: checkcast 216	java/util/List
    //   41: astore 4
    //   43: new 218	java/util/ArrayList
    //   46: dup
    //   47: aload 4
    //   49: invokeinterface 221 1 0
    //   54: invokespecial 223	java/util/ArrayList:<init>	(I)V
    //   57: astore_3
    //   58: aload 4
    //   60: invokeinterface 227 1 0
    //   65: astore 4
    //   67: aload 4
    //   69: invokeinterface 232 1 0
    //   74: ifeq +81 -> 155
    //   77: aload 4
    //   79: invokeinterface 235 1 0
    //   84: checkcast 237	com/google/android/gms/internal/measurement/zzjz
    //   87: astore 5
    //   89: iload_2
    //   90: ifne +14 -> 104
    //   93: aload 5
    //   95: getfield 240	com/google/android/gms/internal/measurement/zzjz:name	Ljava/lang/String;
    //   98: invokestatic 243	com/google/android/gms/internal/measurement/zzka:zzci	(Ljava/lang/String;)Z
    //   101: ifne -34 -> 67
    //   104: aload_3
    //   105: new 245	com/google/android/gms/internal/measurement/zzjx
    //   108: dup
    //   109: aload 5
    //   111: invokespecial 248	com/google/android/gms/internal/measurement/zzjx:<init>	(Lcom/google/android/gms/internal/measurement/zzjz;)V
    //   114: invokeinterface 251 2 0
    //   119: pop
    //   120: goto -53 -> 67
    //   123: astore_3
    //   124: aload_0
    //   125: getfield 33	com/google/android/gms/internal/measurement/zzgn:zzajp	Lcom/google/android/gms/internal/measurement/zzjr;
    //   128: invokevirtual 78	com/google/android/gms/internal/measurement/zzjr:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   131: invokevirtual 84	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   134: ldc 253
    //   136: aload_1
    //   137: getfield 47	com/google/android/gms/internal/measurement/zzdz:packageName	Ljava/lang/String;
    //   140: invokestatic 160	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   143: aload_3
    //   144: invokevirtual 256	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   147: sipush 1619
    //   150: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aconst_null
    //   154: areturn
    //   155: sipush 1619
    //   158: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_3
    //   162: areturn
    //   163: astore_3
    //   164: goto -40 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	zzgn
    //   0	167	1	paramzzdz	zzdz
    //   0	167	2	paramBoolean	boolean
    //   31	74	3	localObject1	Object
    //   123	39	3	localInterruptedException	InterruptedException
    //   163	1	3	localExecutionException	ExecutionException
    //   41	37	4	localObject2	Object
    //   87	23	5	localzzjz	zzjz
    // Exception table:
    //   from	to	target	type
    //   32	67	123	java/lang/InterruptedException
    //   67	89	123	java/lang/InterruptedException
    //   93	104	123	java/lang/InterruptedException
    //   104	120	123	java/lang/InterruptedException
    //   32	67	163	java/util/concurrent/ExecutionException
    //   67	89	163	java/util/concurrent/ExecutionException
    //   93	104	163	java/util/concurrent/ExecutionException
    //   104	120	163	java/util/concurrent/ExecutionException
  }
  
  public final List<zzed> zza(String paramString1, String paramString2, zzdz paramzzdz)
  {
    AppMethodBeat.i(1629);
    zzb(paramzzdz, false);
    paramString1 = this.zzajp.zzgd().zzb(new zzgv(this, paramzzdz, paramString1, paramString2));
    try
    {
      paramString1 = (List)paramString1.get();
      AppMethodBeat.o(1629);
      return paramString1;
    }
    catch (InterruptedException paramString1)
    {
      this.zzajp.zzge().zzim().zzg("Failed to get conditional user properties", paramString1);
      paramString1 = Collections.emptyList();
      AppMethodBeat.o(1629);
      return paramString1;
    }
    catch (ExecutionException paramString1)
    {
      label53:
      break label53;
    }
  }
  
  /* Error */
  public final List<zzjx> zza(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 1628
    //   3: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: iconst_1
    //   9: invokespecial 51	com/google/android/gms/internal/measurement/zzgn:zzc	(Ljava/lang/String;Z)V
    //   12: aload_0
    //   13: getfield 33	com/google/android/gms/internal/measurement/zzgn:zzajp	Lcom/google/android/gms/internal/measurement/zzjr;
    //   16: invokevirtual 183	com/google/android/gms/internal/measurement/zzjr:zzgd	()Lcom/google/android/gms/internal/measurement/zzgg;
    //   19: new 276	com/google/android/gms/internal/measurement/zzgu
    //   22: dup
    //   23: aload_0
    //   24: aload_1
    //   25: aload_2
    //   26: aload_3
    //   27: invokespecial 279	com/google/android/gms/internal/measurement/zzgu:<init>	(Lcom/google/android/gms/internal/measurement/zzgn;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   30: invokevirtual 211	com/google/android/gms/internal/measurement/zzgg:zzb	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   33: astore_2
    //   34: aload_2
    //   35: invokeinterface 214 1 0
    //   40: checkcast 216	java/util/List
    //   43: astore_3
    //   44: new 218	java/util/ArrayList
    //   47: dup
    //   48: aload_3
    //   49: invokeinterface 221 1 0
    //   54: invokespecial 223	java/util/ArrayList:<init>	(I)V
    //   57: astore_2
    //   58: aload_3
    //   59: invokeinterface 227 1 0
    //   64: astore_3
    //   65: aload_3
    //   66: invokeinterface 232 1 0
    //   71: ifeq +82 -> 153
    //   74: aload_3
    //   75: invokeinterface 235 1 0
    //   80: checkcast 237	com/google/android/gms/internal/measurement/zzjz
    //   83: astore 5
    //   85: iload 4
    //   87: ifne +14 -> 101
    //   90: aload 5
    //   92: getfield 240	com/google/android/gms/internal/measurement/zzjz:name	Ljava/lang/String;
    //   95: invokestatic 243	com/google/android/gms/internal/measurement/zzka:zzci	(Ljava/lang/String;)Z
    //   98: ifne -33 -> 65
    //   101: aload_2
    //   102: new 245	com/google/android/gms/internal/measurement/zzjx
    //   105: dup
    //   106: aload 5
    //   108: invokespecial 248	com/google/android/gms/internal/measurement/zzjx:<init>	(Lcom/google/android/gms/internal/measurement/zzjz;)V
    //   111: invokeinterface 251 2 0
    //   116: pop
    //   117: goto -52 -> 65
    //   120: astore_2
    //   121: aload_0
    //   122: getfield 33	com/google/android/gms/internal/measurement/zzgn:zzajp	Lcom/google/android/gms/internal/measurement/zzjr;
    //   125: invokevirtual 78	com/google/android/gms/internal/measurement/zzjr:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   128: invokevirtual 84	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   131: ldc 253
    //   133: aload_1
    //   134: invokestatic 160	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   137: aload_2
    //   138: invokevirtual 256	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   141: invokestatic 272	java/util/Collections:emptyList	()Ljava/util/List;
    //   144: astore_1
    //   145: sipush 1628
    //   148: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_1
    //   152: areturn
    //   153: sipush 1628
    //   156: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload_2
    //   160: areturn
    //   161: astore_2
    //   162: goto -41 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	zzgn
    //   0	165	1	paramString1	String
    //   0	165	2	paramString2	String
    //   0	165	3	paramString3	String
    //   0	165	4	paramBoolean	boolean
    //   83	24	5	localzzjz	zzjz
    // Exception table:
    //   from	to	target	type
    //   34	65	120	java/lang/InterruptedException
    //   65	85	120	java/lang/InterruptedException
    //   90	101	120	java/lang/InterruptedException
    //   101	117	120	java/lang/InterruptedException
    //   34	65	161	java/util/concurrent/ExecutionException
    //   65	85	161	java/util/concurrent/ExecutionException
    //   90	101	161	java/util/concurrent/ExecutionException
    //   101	117	161	java/util/concurrent/ExecutionException
  }
  
  /* Error */
  public final List<zzjx> zza(String paramString1, String paramString2, boolean paramBoolean, zzdz paramzzdz)
  {
    // Byte code:
    //   0: sipush 1627
    //   3: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload 4
    //   9: iconst_0
    //   10: invokespecial 203	com/google/android/gms/internal/measurement/zzgn:zzb	(Lcom/google/android/gms/internal/measurement/zzdz;Z)V
    //   13: aload_0
    //   14: getfield 33	com/google/android/gms/internal/measurement/zzgn:zzajp	Lcom/google/android/gms/internal/measurement/zzjr;
    //   17: invokevirtual 183	com/google/android/gms/internal/measurement/zzjr:zzgd	()Lcom/google/android/gms/internal/measurement/zzgg;
    //   20: new 283	com/google/android/gms/internal/measurement/zzgt
    //   23: dup
    //   24: aload_0
    //   25: aload 4
    //   27: aload_1
    //   28: aload_2
    //   29: invokespecial 284	com/google/android/gms/internal/measurement/zzgt:<init>	(Lcom/google/android/gms/internal/measurement/zzgn;Lcom/google/android/gms/internal/measurement/zzdz;Ljava/lang/String;Ljava/lang/String;)V
    //   32: invokevirtual 211	com/google/android/gms/internal/measurement/zzgg:zzb	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   35: astore_1
    //   36: aload_1
    //   37: invokeinterface 214 1 0
    //   42: checkcast 216	java/util/List
    //   45: astore_2
    //   46: new 218	java/util/ArrayList
    //   49: dup
    //   50: aload_2
    //   51: invokeinterface 221 1 0
    //   56: invokespecial 223	java/util/ArrayList:<init>	(I)V
    //   59: astore_1
    //   60: aload_2
    //   61: invokeinterface 227 1 0
    //   66: astore_2
    //   67: aload_2
    //   68: invokeinterface 232 1 0
    //   73: ifeq +85 -> 158
    //   76: aload_2
    //   77: invokeinterface 235 1 0
    //   82: checkcast 237	com/google/android/gms/internal/measurement/zzjz
    //   85: astore 5
    //   87: iload_3
    //   88: ifne +14 -> 102
    //   91: aload 5
    //   93: getfield 240	com/google/android/gms/internal/measurement/zzjz:name	Ljava/lang/String;
    //   96: invokestatic 243	com/google/android/gms/internal/measurement/zzka:zzci	(Ljava/lang/String;)Z
    //   99: ifne -32 -> 67
    //   102: aload_1
    //   103: new 245	com/google/android/gms/internal/measurement/zzjx
    //   106: dup
    //   107: aload 5
    //   109: invokespecial 248	com/google/android/gms/internal/measurement/zzjx:<init>	(Lcom/google/android/gms/internal/measurement/zzjz;)V
    //   112: invokeinterface 251 2 0
    //   117: pop
    //   118: goto -51 -> 67
    //   121: astore_1
    //   122: aload_0
    //   123: getfield 33	com/google/android/gms/internal/measurement/zzgn:zzajp	Lcom/google/android/gms/internal/measurement/zzjr;
    //   126: invokevirtual 78	com/google/android/gms/internal/measurement/zzjr:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   129: invokevirtual 84	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   132: ldc 253
    //   134: aload 4
    //   136: getfield 47	com/google/android/gms/internal/measurement/zzdz:packageName	Ljava/lang/String;
    //   139: invokestatic 160	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   142: aload_1
    //   143: invokevirtual 256	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   146: invokestatic 272	java/util/Collections:emptyList	()Ljava/util/List;
    //   149: astore_1
    //   150: sipush 1627
    //   153: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_1
    //   157: areturn
    //   158: sipush 1627
    //   161: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: aload_1
    //   165: areturn
    //   166: astore_1
    //   167: goto -45 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	zzgn
    //   0	170	1	paramString1	String
    //   0	170	2	paramString2	String
    //   0	170	3	paramBoolean	boolean
    //   0	170	4	paramzzdz	zzdz
    //   85	23	5	localzzjz	zzjz
    // Exception table:
    //   from	to	target	type
    //   36	67	121	java/lang/InterruptedException
    //   67	87	121	java/lang/InterruptedException
    //   91	102	121	java/lang/InterruptedException
    //   102	118	121	java/lang/InterruptedException
    //   36	67	166	java/util/concurrent/ExecutionException
    //   67	87	166	java/util/concurrent/ExecutionException
    //   91	102	166	java/util/concurrent/ExecutionException
    //   102	118	166	java/util/concurrent/ExecutionException
  }
  
  public final void zza(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(1623);
    zze(new zzhf(this, paramString2, paramString3, paramString1, paramLong));
    AppMethodBeat.o(1623);
  }
  
  public final void zza(zzdz paramzzdz)
  {
    AppMethodBeat.i(1620);
    zzb(paramzzdz, false);
    zze(new zzhe(this, paramzzdz));
    AppMethodBeat.o(1620);
  }
  
  public final void zza(zzed paramzzed, zzdz paramzzdz)
  {
    AppMethodBeat.i(1625);
    Preconditions.checkNotNull(paramzzed);
    Preconditions.checkNotNull(paramzzed.zzaep);
    zzb(paramzzdz, false);
    zzed localzzed = new zzed(paramzzed);
    localzzed.packageName = paramzzdz.packageName;
    if (paramzzed.zzaep.getValue() == null)
    {
      zze(new zzgp(this, localzzed, paramzzdz));
      AppMethodBeat.o(1625);
      return;
    }
    zze(new zzgq(this, localzzed, paramzzdz));
    AppMethodBeat.o(1625);
  }
  
  public final void zza(zzeu paramzzeu, zzdz paramzzdz)
  {
    AppMethodBeat.i(1615);
    Preconditions.checkNotNull(paramzzeu);
    zzb(paramzzdz, false);
    zze(new zzgy(this, paramzzeu, paramzzdz));
    AppMethodBeat.o(1615);
  }
  
  public final void zza(zzeu paramzzeu, String paramString1, String paramString2)
  {
    AppMethodBeat.i(1616);
    Preconditions.checkNotNull(paramzzeu);
    Preconditions.checkNotEmpty(paramString1);
    zzc(paramString1, true);
    zze(new zzgz(this, paramzzeu, paramString1));
    AppMethodBeat.o(1616);
  }
  
  public final void zza(zzjx paramzzjx, zzdz paramzzdz)
  {
    AppMethodBeat.i(1618);
    Preconditions.checkNotNull(paramzzjx);
    zzb(paramzzdz, false);
    if (paramzzjx.getValue() == null)
    {
      zze(new zzhb(this, paramzzjx, paramzzdz));
      AppMethodBeat.o(1618);
      return;
    }
    zze(new zzhc(this, paramzzjx, paramzzdz));
    AppMethodBeat.o(1618);
  }
  
  public final byte[] zza(zzeu paramzzeu, String paramString)
  {
    AppMethodBeat.i(1617);
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramzzeu);
    zzc(paramString, true);
    this.zzajp.zzge().zzis().zzg("Log and bundle. event", this.zzajp.zzga().zzbj(paramzzeu.name));
    long l1 = this.zzajp.zzbt().nanoTime() / 1000000L;
    Object localObject = this.zzajp.zzgd().zzc(new zzha(this, paramzzeu, paramString));
    try
    {
      byte[] arrayOfByte = (byte[])((Future)localObject).get();
      localObject = arrayOfByte;
      if (arrayOfByte == null)
      {
        this.zzajp.zzge().zzim().zzg("Log and bundle returned null. appId", zzfg.zzbm(paramString));
        localObject = new byte[0];
      }
      long l2 = this.zzajp.zzbt().nanoTime() / 1000000L;
      this.zzajp.zzge().zzis().zzd("Log and bundle processed. event, size, time_ms", this.zzajp.zzga().zzbj(paramzzeu.name), Integer.valueOf(localObject.length), Long.valueOf(l2 - l1));
      AppMethodBeat.o(1617);
      return localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      this.zzajp.zzge().zzim().zzd("Failed to log and bundle. appId, event, error", zzfg.zzbm(paramString), this.zzajp.zzga().zzbj(paramzzeu.name), localInterruptedException);
      AppMethodBeat.o(1617);
      return null;
    }
    catch (ExecutionException localExecutionException)
    {
      label209:
      break label209;
    }
  }
  
  public final void zzb(zzdz paramzzdz)
  {
    AppMethodBeat.i(1614);
    zzb(paramzzdz, false);
    zze(new zzgo(this, paramzzdz));
    AppMethodBeat.o(1614);
  }
  
  public final void zzb(zzed paramzzed)
  {
    AppMethodBeat.i(1626);
    Preconditions.checkNotNull(paramzzed);
    Preconditions.checkNotNull(paramzzed.zzaep);
    zzc(paramzzed.packageName, true);
    zzed localzzed = new zzed(paramzzed);
    if (paramzzed.zzaep.getValue() == null)
    {
      zze(new zzgr(this, localzzed));
      AppMethodBeat.o(1626);
      return;
    }
    zze(new zzgs(this, localzzed));
    AppMethodBeat.o(1626);
  }
  
  public final String zzc(zzdz paramzzdz)
  {
    AppMethodBeat.i(1624);
    zzb(paramzzdz, false);
    paramzzdz = this.zzajp.zzh(paramzzdz);
    AppMethodBeat.o(1624);
    return paramzzdz;
  }
  
  public final void zzd(zzdz paramzzdz)
  {
    AppMethodBeat.i(1631);
    zzc(paramzzdz.packageName, false);
    zze(new zzgx(this, paramzzdz));
    AppMethodBeat.o(1631);
  }
  
  public final List<zzed> zze(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(1630);
    zzc(paramString1, true);
    paramString1 = this.zzajp.zzgd().zzb(new zzgw(this, paramString1, paramString2, paramString3));
    try
    {
      paramString1 = (List)paramString1.get();
      AppMethodBeat.o(1630);
      return paramString1;
    }
    catch (InterruptedException paramString1)
    {
      this.zzajp.zzge().zzim().zzg("Failed to get conditional user properties", paramString1);
      paramString1 = Collections.emptyList();
      AppMethodBeat.o(1630);
      return paramString1;
    }
    catch (ExecutionException paramString1)
    {
      label53:
      break label53;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzgn
 * JD-Core Version:    0.7.0.1
 */