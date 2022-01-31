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
    AppMethodBeat.i(69090);
    Preconditions.checkNotNull(paramzzjr);
    this.zzajp = paramzzjr;
    this.zzand = null;
    AppMethodBeat.o(69090);
  }
  
  private final void zzb(zzdz paramzzdz, boolean paramBoolean)
  {
    AppMethodBeat.i(69098);
    Preconditions.checkNotNull(paramzzdz);
    zzc(paramzzdz.packageName, false);
    this.zzajp.zzgb().zzcg(paramzzdz.zzadm);
    AppMethodBeat.o(69098);
  }
  
  private final void zzc(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(69099);
    if (TextUtils.isEmpty(paramString))
    {
      this.zzajp.zzge().zzim().log("Measurement Service called without app package");
      paramString = new SecurityException("Measurement Service called without app package");
      AppMethodBeat.o(69099);
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
            break label232;
          }
          paramBoolean = bool;
          if (GoogleSignatureVerifier.getInstance(this.zzajp.getContext()).isUidGoogleSigned(Binder.getCallingUid())) {
            break label232;
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
            AppMethodBeat.o(69099);
            throw localSecurityException1;
          }
        }
      }
      catch (SecurityException localSecurityException2)
      {
        this.zzajp.zzge().zzim().zzg("Measurement Service called with invalid calling package. appId", zzfg.zzbm(paramString));
        AppMethodBeat.o(69099);
        throw localSecurityException2;
      }
      AppMethodBeat.o(69099);
      return;
      label232:
      paramBoolean = true;
    }
  }
  
  @VisibleForTesting
  private final void zze(Runnable paramRunnable)
  {
    AppMethodBeat.i(69109);
    Preconditions.checkNotNull(paramRunnable);
    if ((((Boolean)zzew.zzaia.get()).booleanValue()) && (this.zzajp.zzgd().zzjk()))
    {
      paramRunnable.run();
      AppMethodBeat.o(69109);
      return;
    }
    this.zzajp.zzgd().zzc(paramRunnable);
    AppMethodBeat.o(69109);
  }
  
  /* Error */
  public final List<zzjx> zza(zzdz paramzzdz, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 206
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: iconst_0
    //   8: invokespecial 208	com/google/android/gms/internal/measurement/zzgn:zzb	(Lcom/google/android/gms/internal/measurement/zzdz;Z)V
    //   11: aload_0
    //   12: getfield 34	com/google/android/gms/internal/measurement/zzgn:zzajp	Lcom/google/android/gms/internal/measurement/zzjr;
    //   15: invokevirtual 187	com/google/android/gms/internal/measurement/zzjr:zzgd	()Lcom/google/android/gms/internal/measurement/zzgg;
    //   18: new 210	com/google/android/gms/internal/measurement/zzhd
    //   21: dup
    //   22: aload_0
    //   23: aload_1
    //   24: invokespecial 213	com/google/android/gms/internal/measurement/zzhd:<init>	(Lcom/google/android/gms/internal/measurement/zzgn;Lcom/google/android/gms/internal/measurement/zzdz;)V
    //   27: invokevirtual 216	com/google/android/gms/internal/measurement/zzgg:zzb	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   30: astore_3
    //   31: aload_3
    //   32: invokeinterface 219 1 0
    //   37: checkcast 221	java/util/List
    //   40: astore 4
    //   42: new 223	java/util/ArrayList
    //   45: dup
    //   46: aload 4
    //   48: invokeinterface 226 1 0
    //   53: invokespecial 228	java/util/ArrayList:<init>	(I)V
    //   56: astore_3
    //   57: aload 4
    //   59: invokeinterface 232 1 0
    //   64: astore 4
    //   66: aload 4
    //   68: invokeinterface 237 1 0
    //   73: ifeq +81 -> 154
    //   76: aload 4
    //   78: invokeinterface 240 1 0
    //   83: checkcast 242	com/google/android/gms/internal/measurement/zzjz
    //   86: astore 5
    //   88: iload_2
    //   89: ifne +14 -> 103
    //   92: aload 5
    //   94: getfield 245	com/google/android/gms/internal/measurement/zzjz:name	Ljava/lang/String;
    //   97: invokestatic 248	com/google/android/gms/internal/measurement/zzka:zzci	(Ljava/lang/String;)Z
    //   100: ifne -34 -> 66
    //   103: aload_3
    //   104: new 250	com/google/android/gms/internal/measurement/zzjx
    //   107: dup
    //   108: aload 5
    //   110: invokespecial 253	com/google/android/gms/internal/measurement/zzjx:<init>	(Lcom/google/android/gms/internal/measurement/zzjz;)V
    //   113: invokeinterface 256 2 0
    //   118: pop
    //   119: goto -53 -> 66
    //   122: astore_3
    //   123: aload_0
    //   124: getfield 34	com/google/android/gms/internal/measurement/zzgn:zzajp	Lcom/google/android/gms/internal/measurement/zzjr;
    //   127: invokevirtual 81	com/google/android/gms/internal/measurement/zzjr:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   130: invokevirtual 87	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   133: ldc_w 258
    //   136: aload_1
    //   137: getfield 49	com/google/android/gms/internal/measurement/zzdz:packageName	Ljava/lang/String;
    //   140: invokestatic 163	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   143: aload_3
    //   144: invokevirtual 261	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   147: ldc 206
    //   149: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aconst_null
    //   153: areturn
    //   154: ldc 206
    //   156: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload_3
    //   160: areturn
    //   161: astore_3
    //   162: goto -39 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	zzgn
    //   0	165	1	paramzzdz	zzdz
    //   0	165	2	paramBoolean	boolean
    //   30	74	3	localObject1	Object
    //   122	38	3	localInterruptedException	InterruptedException
    //   161	1	3	localExecutionException	ExecutionException
    //   40	37	4	localObject2	Object
    //   86	23	5	localzzjz	zzjz
    // Exception table:
    //   from	to	target	type
    //   31	66	122	java/lang/InterruptedException
    //   66	88	122	java/lang/InterruptedException
    //   92	103	122	java/lang/InterruptedException
    //   103	119	122	java/lang/InterruptedException
    //   31	66	161	java/util/concurrent/ExecutionException
    //   66	88	161	java/util/concurrent/ExecutionException
    //   92	103	161	java/util/concurrent/ExecutionException
    //   103	119	161	java/util/concurrent/ExecutionException
  }
  
  public final List<zzed> zza(String paramString1, String paramString2, zzdz paramzzdz)
  {
    AppMethodBeat.i(69106);
    zzb(paramzzdz, false);
    paramString1 = this.zzajp.zzgd().zzb(new zzgv(this, paramzzdz, paramString1, paramString2));
    try
    {
      paramString1 = (List)paramString1.get();
      AppMethodBeat.o(69106);
      return paramString1;
    }
    catch (InterruptedException paramString1)
    {
      this.zzajp.zzge().zzim().zzg("Failed to get conditional user properties", paramString1);
      paramString1 = Collections.emptyList();
      AppMethodBeat.o(69106);
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
    //   0: ldc_w 281
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: iconst_1
    //   9: invokespecial 53	com/google/android/gms/internal/measurement/zzgn:zzc	(Ljava/lang/String;Z)V
    //   12: aload_0
    //   13: getfield 34	com/google/android/gms/internal/measurement/zzgn:zzajp	Lcom/google/android/gms/internal/measurement/zzjr;
    //   16: invokevirtual 187	com/google/android/gms/internal/measurement/zzjr:zzgd	()Lcom/google/android/gms/internal/measurement/zzgg;
    //   19: new 283	com/google/android/gms/internal/measurement/zzgu
    //   22: dup
    //   23: aload_0
    //   24: aload_1
    //   25: aload_2
    //   26: aload_3
    //   27: invokespecial 286	com/google/android/gms/internal/measurement/zzgu:<init>	(Lcom/google/android/gms/internal/measurement/zzgn;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   30: invokevirtual 216	com/google/android/gms/internal/measurement/zzgg:zzb	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   33: astore_2
    //   34: aload_2
    //   35: invokeinterface 219 1 0
    //   40: checkcast 221	java/util/List
    //   43: astore_3
    //   44: new 223	java/util/ArrayList
    //   47: dup
    //   48: aload_3
    //   49: invokeinterface 226 1 0
    //   54: invokespecial 228	java/util/ArrayList:<init>	(I)V
    //   57: astore_2
    //   58: aload_3
    //   59: invokeinterface 232 1 0
    //   64: astore_3
    //   65: aload_3
    //   66: invokeinterface 237 1 0
    //   71: ifeq +83 -> 154
    //   74: aload_3
    //   75: invokeinterface 240 1 0
    //   80: checkcast 242	com/google/android/gms/internal/measurement/zzjz
    //   83: astore 5
    //   85: iload 4
    //   87: ifne +14 -> 101
    //   90: aload 5
    //   92: getfield 245	com/google/android/gms/internal/measurement/zzjz:name	Ljava/lang/String;
    //   95: invokestatic 248	com/google/android/gms/internal/measurement/zzka:zzci	(Ljava/lang/String;)Z
    //   98: ifne -33 -> 65
    //   101: aload_2
    //   102: new 250	com/google/android/gms/internal/measurement/zzjx
    //   105: dup
    //   106: aload 5
    //   108: invokespecial 253	com/google/android/gms/internal/measurement/zzjx:<init>	(Lcom/google/android/gms/internal/measurement/zzjz;)V
    //   111: invokeinterface 256 2 0
    //   116: pop
    //   117: goto -52 -> 65
    //   120: astore_2
    //   121: aload_0
    //   122: getfield 34	com/google/android/gms/internal/measurement/zzgn:zzajp	Lcom/google/android/gms/internal/measurement/zzjr;
    //   125: invokevirtual 81	com/google/android/gms/internal/measurement/zzjr:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   128: invokevirtual 87	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   131: ldc_w 258
    //   134: aload_1
    //   135: invokestatic 163	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   138: aload_2
    //   139: invokevirtual 261	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   142: invokestatic 278	java/util/Collections:emptyList	()Ljava/util/List;
    //   145: astore_1
    //   146: ldc_w 281
    //   149: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_1
    //   153: areturn
    //   154: ldc_w 281
    //   157: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_2
    //   161: areturn
    //   162: astore_2
    //   163: goto -42 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	zzgn
    //   0	166	1	paramString1	String
    //   0	166	2	paramString2	String
    //   0	166	3	paramString3	String
    //   0	166	4	paramBoolean	boolean
    //   83	24	5	localzzjz	zzjz
    // Exception table:
    //   from	to	target	type
    //   34	65	120	java/lang/InterruptedException
    //   65	85	120	java/lang/InterruptedException
    //   90	101	120	java/lang/InterruptedException
    //   101	117	120	java/lang/InterruptedException
    //   34	65	162	java/util/concurrent/ExecutionException
    //   65	85	162	java/util/concurrent/ExecutionException
    //   90	101	162	java/util/concurrent/ExecutionException
    //   101	117	162	java/util/concurrent/ExecutionException
  }
  
  /* Error */
  public final List<zzjx> zza(String paramString1, String paramString2, boolean paramBoolean, zzdz paramzzdz)
  {
    // Byte code:
    //   0: ldc_w 289
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload 4
    //   9: iconst_0
    //   10: invokespecial 208	com/google/android/gms/internal/measurement/zzgn:zzb	(Lcom/google/android/gms/internal/measurement/zzdz;Z)V
    //   13: aload_0
    //   14: getfield 34	com/google/android/gms/internal/measurement/zzgn:zzajp	Lcom/google/android/gms/internal/measurement/zzjr;
    //   17: invokevirtual 187	com/google/android/gms/internal/measurement/zzjr:zzgd	()Lcom/google/android/gms/internal/measurement/zzgg;
    //   20: new 291	com/google/android/gms/internal/measurement/zzgt
    //   23: dup
    //   24: aload_0
    //   25: aload 4
    //   27: aload_1
    //   28: aload_2
    //   29: invokespecial 292	com/google/android/gms/internal/measurement/zzgt:<init>	(Lcom/google/android/gms/internal/measurement/zzgn;Lcom/google/android/gms/internal/measurement/zzdz;Ljava/lang/String;Ljava/lang/String;)V
    //   32: invokevirtual 216	com/google/android/gms/internal/measurement/zzgg:zzb	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   35: astore_1
    //   36: aload_1
    //   37: invokeinterface 219 1 0
    //   42: checkcast 221	java/util/List
    //   45: astore_2
    //   46: new 223	java/util/ArrayList
    //   49: dup
    //   50: aload_2
    //   51: invokeinterface 226 1 0
    //   56: invokespecial 228	java/util/ArrayList:<init>	(I)V
    //   59: astore_1
    //   60: aload_2
    //   61: invokeinterface 232 1 0
    //   66: astore_2
    //   67: aload_2
    //   68: invokeinterface 237 1 0
    //   73: ifeq +86 -> 159
    //   76: aload_2
    //   77: invokeinterface 240 1 0
    //   82: checkcast 242	com/google/android/gms/internal/measurement/zzjz
    //   85: astore 5
    //   87: iload_3
    //   88: ifne +14 -> 102
    //   91: aload 5
    //   93: getfield 245	com/google/android/gms/internal/measurement/zzjz:name	Ljava/lang/String;
    //   96: invokestatic 248	com/google/android/gms/internal/measurement/zzka:zzci	(Ljava/lang/String;)Z
    //   99: ifne -32 -> 67
    //   102: aload_1
    //   103: new 250	com/google/android/gms/internal/measurement/zzjx
    //   106: dup
    //   107: aload 5
    //   109: invokespecial 253	com/google/android/gms/internal/measurement/zzjx:<init>	(Lcom/google/android/gms/internal/measurement/zzjz;)V
    //   112: invokeinterface 256 2 0
    //   117: pop
    //   118: goto -51 -> 67
    //   121: astore_1
    //   122: aload_0
    //   123: getfield 34	com/google/android/gms/internal/measurement/zzgn:zzajp	Lcom/google/android/gms/internal/measurement/zzjr;
    //   126: invokevirtual 81	com/google/android/gms/internal/measurement/zzjr:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   129: invokevirtual 87	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   132: ldc_w 258
    //   135: aload 4
    //   137: getfield 49	com/google/android/gms/internal/measurement/zzdz:packageName	Ljava/lang/String;
    //   140: invokestatic 163	com/google/android/gms/internal/measurement/zzfg:zzbm	(Ljava/lang/String;)Ljava/lang/Object;
    //   143: aload_1
    //   144: invokevirtual 261	com/google/android/gms/internal/measurement/zzfi:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   147: invokestatic 278	java/util/Collections:emptyList	()Ljava/util/List;
    //   150: astore_1
    //   151: ldc_w 289
    //   154: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aload_1
    //   158: areturn
    //   159: ldc_w 289
    //   162: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aload_1
    //   166: areturn
    //   167: astore_1
    //   168: goto -46 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	zzgn
    //   0	171	1	paramString1	String
    //   0	171	2	paramString2	String
    //   0	171	3	paramBoolean	boolean
    //   0	171	4	paramzzdz	zzdz
    //   85	23	5	localzzjz	zzjz
    // Exception table:
    //   from	to	target	type
    //   36	67	121	java/lang/InterruptedException
    //   67	87	121	java/lang/InterruptedException
    //   91	102	121	java/lang/InterruptedException
    //   102	118	121	java/lang/InterruptedException
    //   36	67	167	java/util/concurrent/ExecutionException
    //   67	87	167	java/util/concurrent/ExecutionException
    //   91	102	167	java/util/concurrent/ExecutionException
    //   102	118	167	java/util/concurrent/ExecutionException
  }
  
  public final void zza(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(69100);
    zze(new zzhf(this, paramString2, paramString3, paramString1, paramLong));
    AppMethodBeat.o(69100);
  }
  
  public final void zza(zzdz paramzzdz)
  {
    AppMethodBeat.i(69097);
    zzb(paramzzdz, false);
    zze(new zzhe(this, paramzzdz));
    AppMethodBeat.o(69097);
  }
  
  public final void zza(zzed paramzzed, zzdz paramzzdz)
  {
    AppMethodBeat.i(69102);
    Preconditions.checkNotNull(paramzzed);
    Preconditions.checkNotNull(paramzzed.zzaep);
    zzb(paramzzdz, false);
    zzed localzzed = new zzed(paramzzed);
    localzzed.packageName = paramzzdz.packageName;
    if (paramzzed.zzaep.getValue() == null)
    {
      zze(new zzgp(this, localzzed, paramzzdz));
      AppMethodBeat.o(69102);
      return;
    }
    zze(new zzgq(this, localzzed, paramzzdz));
    AppMethodBeat.o(69102);
  }
  
  public final void zza(zzeu paramzzeu, zzdz paramzzdz)
  {
    AppMethodBeat.i(69092);
    Preconditions.checkNotNull(paramzzeu);
    zzb(paramzzdz, false);
    zze(new zzgy(this, paramzzeu, paramzzdz));
    AppMethodBeat.o(69092);
  }
  
  public final void zza(zzeu paramzzeu, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69093);
    Preconditions.checkNotNull(paramzzeu);
    Preconditions.checkNotEmpty(paramString1);
    zzc(paramString1, true);
    zze(new zzgz(this, paramzzeu, paramString1));
    AppMethodBeat.o(69093);
  }
  
  public final void zza(zzjx paramzzjx, zzdz paramzzdz)
  {
    AppMethodBeat.i(69095);
    Preconditions.checkNotNull(paramzzjx);
    zzb(paramzzdz, false);
    if (paramzzjx.getValue() == null)
    {
      zze(new zzhb(this, paramzzjx, paramzzdz));
      AppMethodBeat.o(69095);
      return;
    }
    zze(new zzhc(this, paramzzjx, paramzzdz));
    AppMethodBeat.o(69095);
  }
  
  public final byte[] zza(zzeu paramzzeu, String paramString)
  {
    AppMethodBeat.i(69094);
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
      AppMethodBeat.o(69094);
      return localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      this.zzajp.zzge().zzim().zzd("Failed to log and bundle. appId, event, error", zzfg.zzbm(paramString), this.zzajp.zzga().zzbj(paramzzeu.name), localInterruptedException);
      AppMethodBeat.o(69094);
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
    AppMethodBeat.i(69091);
    zzb(paramzzdz, false);
    zze(new zzgo(this, paramzzdz));
    AppMethodBeat.o(69091);
  }
  
  public final void zzb(zzed paramzzed)
  {
    AppMethodBeat.i(69103);
    Preconditions.checkNotNull(paramzzed);
    Preconditions.checkNotNull(paramzzed.zzaep);
    zzc(paramzzed.packageName, true);
    zzed localzzed = new zzed(paramzzed);
    if (paramzzed.zzaep.getValue() == null)
    {
      zze(new zzgr(this, localzzed));
      AppMethodBeat.o(69103);
      return;
    }
    zze(new zzgs(this, localzzed));
    AppMethodBeat.o(69103);
  }
  
  public final String zzc(zzdz paramzzdz)
  {
    AppMethodBeat.i(69101);
    zzb(paramzzdz, false);
    paramzzdz = this.zzajp.zzh(paramzzdz);
    AppMethodBeat.o(69101);
    return paramzzdz;
  }
  
  public final void zzd(zzdz paramzzdz)
  {
    AppMethodBeat.i(69108);
    zzc(paramzzdz.packageName, false);
    zze(new zzgx(this, paramzzdz));
    AppMethodBeat.o(69108);
  }
  
  public final List<zzed> zze(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(69107);
    zzc(paramString1, true);
    paramString1 = this.zzajp.zzgd().zzb(new zzgw(this, paramString1, paramString2, paramString3));
    try
    {
      paramString1 = (List)paramString1.get();
      AppMethodBeat.o(69107);
      return paramString1;
    }
    catch (InterruptedException paramString1)
    {
      this.zzajp.zzge().zzim().zzg("Failed to get conditional user properties", paramString1);
      paramString1 = Collections.emptyList();
      AppMethodBeat.o(69107);
      return paramString1;
    }
    catch (ExecutionException paramString1)
    {
      label53:
      break label53;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzgn
 * JD-Core Version:    0.7.0.1
 */