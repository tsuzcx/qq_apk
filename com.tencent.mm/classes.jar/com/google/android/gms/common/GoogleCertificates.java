package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ICertData;
import com.google.android.gms.common.internal.ICertData.Stub;
import com.google.android.gms.common.internal.IGoogleCertificatesApi;
import com.google.android.gms.common.internal.IGoogleCertificatesApi.Stub;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.concurrent.GuardedBy;

@CheckReturnValue
final class GoogleCertificates
{
  private static volatile IGoogleCertificatesApi zzax;
  private static final Object zzay;
  private static Context zzaz;
  @GuardedBy("GoogleCertificates.class")
  private static Set<ICertData> zzba;
  @GuardedBy("GoogleCertificates.class")
  private static Set<ICertData> zzbb;
  
  static
  {
    AppMethodBeat.i(4406);
    zzay = new Object();
    AppMethodBeat.o(4406);
  }
  
  /* Error */
  static void init(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: sipush 4400
    //   6: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 42	com/google/android/gms/common/GoogleCertificates:zzaz	Landroid/content/Context;
    //   12: ifnonnull +24 -> 36
    //   15: aload_0
    //   16: ifnull +20 -> 36
    //   19: aload_0
    //   20: invokevirtual 48	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   23: putstatic 42	com/google/android/gms/common/GoogleCertificates:zzaz	Landroid/content/Context;
    //   26: sipush 4400
    //   29: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: ldc 2
    //   34: monitorexit
    //   35: return
    //   36: sipush 4400
    //   39: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: goto -10 -> 32
    //   45: astore_0
    //   46: ldc 2
    //   48: monitorexit
    //   49: aload_0
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	15	45	finally
    //   19	32	45	finally
    //   36	42	45	finally
  }
  
  static zzg zza(String paramString, CertData paramCertData, boolean paramBoolean)
  {
    boolean bool1 = true;
    AppMethodBeat.i(4405);
    try
    {
      zzc();
      Preconditions.checkNotNull(zzaz);
      GoogleCertificatesQuery localGoogleCertificatesQuery = new GoogleCertificatesQuery(paramString, paramCertData, paramBoolean);
      boolean bool2;
      if (paramBoolean) {
        break label132;
      }
    }
    catch (DynamiteModule.LoadingException paramString)
    {
      try
      {
        bool2 = zzax.isGoogleOrPlatformSigned(localGoogleCertificatesQuery, ObjectWrapper.wrap(zzaz.getPackageManager()));
        if (!bool2) {
          break label100;
        }
        paramString = zzg.zzg();
        AppMethodBeat.o(4405);
        return paramString;
      }
      catch (RemoteException paramString)
      {
        paramString = zzg.zza("module call", paramString);
        AppMethodBeat.o(4405);
        return paramString;
      }
      paramString = paramString;
      paramString = zzg.zza("module init", paramString);
      AppMethodBeat.o(4405);
      return paramString;
    }
    label100:
    if (zza(paramString, paramCertData, true).zzbl) {}
    for (;;)
    {
      paramString = zzg.zza(paramString, paramCertData, paramBoolean, bool1);
      AppMethodBeat.o(4405);
      return paramString;
      label132:
      bool1 = false;
    }
  }
  
  private static Set<ICertData> zza(IBinder[] paramArrayOfIBinder)
  {
    AppMethodBeat.i(4402);
    int j = paramArrayOfIBinder.length;
    HashSet localHashSet = new HashSet(j);
    int i = 0;
    while (i < j)
    {
      ICertData localICertData = ICertData.Stub.asInterface(paramArrayOfIBinder[i]);
      if (localICertData != null) {
        localHashSet.add(localICertData);
      }
      i += 1;
    }
    AppMethodBeat.o(4402);
    return localHashSet;
  }
  
  private static void zzc()
  {
    AppMethodBeat.i(4401);
    if (zzax != null)
    {
      AppMethodBeat.o(4401);
      return;
    }
    Preconditions.checkNotNull(zzaz);
    synchronized (zzay)
    {
      if (zzax == null) {
        zzax = IGoogleCertificatesApi.Stub.asInterface(DynamiteModule.load(zzaz, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
      }
      AppMethodBeat.o(4401);
      return;
    }
  }
  
  /* Error */
  static Set<ICertData> zzd()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: sipush 4403
    //   6: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 154	com/google/android/gms/common/GoogleCertificates:zzba	Ljava/util/Set;
    //   12: ifnull +18 -> 30
    //   15: getstatic 154	com/google/android/gms/common/GoogleCertificates:zzba	Ljava/util/Set;
    //   18: astore_0
    //   19: sipush 4403
    //   22: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: invokestatic 57	com/google/android/gms/common/GoogleCertificates:zzc	()V
    //   33: getstatic 70	com/google/android/gms/common/GoogleCertificates:zzax	Lcom/google/android/gms/common/internal/IGoogleCertificatesApi;
    //   36: invokeinterface 158 1 0
    //   41: astore_0
    //   42: aload_0
    //   43: ifnonnull +36 -> 79
    //   46: invokestatic 163	java/util/Collections:emptySet	()Ljava/util/Set;
    //   49: astore_0
    //   50: sipush 4403
    //   53: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -31 -> 25
    //   59: astore_0
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    //   65: astore_0
    //   66: invokestatic 163	java/util/Collections:emptySet	()Ljava/util/Set;
    //   69: astore_0
    //   70: sipush 4403
    //   73: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: goto -51 -> 25
    //   79: aload_0
    //   80: invokestatic 167	com/google/android/gms/dynamic/ObjectWrapper:unwrap	(Lcom/google/android/gms/dynamic/IObjectWrapper;)Ljava/lang/Object;
    //   83: checkcast 169	[Landroid/os/IBinder;
    //   86: invokestatic 171	com/google/android/gms/common/GoogleCertificates:zza	([Landroid/os/IBinder;)Ljava/util/Set;
    //   89: putstatic 154	com/google/android/gms/common/GoogleCertificates:zzba	Ljava/util/Set;
    //   92: getstatic 154	com/google/android/gms/common/GoogleCertificates:zzba	Ljava/util/Set;
    //   95: astore_0
    //   96: sipush 4403
    //   99: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: goto -77 -> 25
    //   105: astore_0
    //   106: invokestatic 163	java/util/Collections:emptySet	()Ljava/util/Set;
    //   109: astore_0
    //   110: sipush 4403
    //   113: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: goto -91 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	32	0	localObject1	Object
    //   59	5	0	localObject2	Object
    //   65	1	0	localLoadingException	DynamiteModule.LoadingException
    //   69	27	0	localSet1	Set
    //   105	1	0	localRemoteException	RemoteException
    //   109	1	0	localSet2	Set
    // Exception table:
    //   from	to	target	type
    //   3	25	59	finally
    //   30	33	59	finally
    //   33	42	59	finally
    //   46	50	59	finally
    //   50	56	59	finally
    //   66	76	59	finally
    //   79	92	59	finally
    //   92	102	59	finally
    //   106	116	59	finally
    //   30	33	65	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   33	42	105	android/os/RemoteException
    //   46	50	105	android/os/RemoteException
    //   79	92	105	android/os/RemoteException
  }
  
  /* Error */
  static Set<ICertData> zze()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: sipush 4404
    //   6: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 175	com/google/android/gms/common/GoogleCertificates:zzbb	Ljava/util/Set;
    //   12: ifnull +18 -> 30
    //   15: getstatic 175	com/google/android/gms/common/GoogleCertificates:zzbb	Ljava/util/Set;
    //   18: astore_0
    //   19: sipush 4404
    //   22: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: invokestatic 57	com/google/android/gms/common/GoogleCertificates:zzc	()V
    //   33: getstatic 70	com/google/android/gms/common/GoogleCertificates:zzax	Lcom/google/android/gms/common/internal/IGoogleCertificatesApi;
    //   36: invokeinterface 178 1 0
    //   41: astore_0
    //   42: aload_0
    //   43: ifnonnull +36 -> 79
    //   46: invokestatic 163	java/util/Collections:emptySet	()Ljava/util/Set;
    //   49: astore_0
    //   50: sipush 4404
    //   53: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -31 -> 25
    //   59: astore_0
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    //   65: astore_0
    //   66: invokestatic 163	java/util/Collections:emptySet	()Ljava/util/Set;
    //   69: astore_0
    //   70: sipush 4404
    //   73: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: goto -51 -> 25
    //   79: aload_0
    //   80: invokestatic 167	com/google/android/gms/dynamic/ObjectWrapper:unwrap	(Lcom/google/android/gms/dynamic/IObjectWrapper;)Ljava/lang/Object;
    //   83: checkcast 169	[Landroid/os/IBinder;
    //   86: invokestatic 171	com/google/android/gms/common/GoogleCertificates:zza	([Landroid/os/IBinder;)Ljava/util/Set;
    //   89: putstatic 175	com/google/android/gms/common/GoogleCertificates:zzbb	Ljava/util/Set;
    //   92: getstatic 175	com/google/android/gms/common/GoogleCertificates:zzbb	Ljava/util/Set;
    //   95: astore_0
    //   96: sipush 4404
    //   99: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: goto -77 -> 25
    //   105: astore_0
    //   106: invokestatic 163	java/util/Collections:emptySet	()Ljava/util/Set;
    //   109: astore_0
    //   110: sipush 4404
    //   113: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: goto -91 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	32	0	localObject1	Object
    //   59	5	0	localObject2	Object
    //   65	1	0	localLoadingException	DynamiteModule.LoadingException
    //   69	27	0	localSet1	Set
    //   105	1	0	localRemoteException	RemoteException
    //   109	1	0	localSet2	Set
    // Exception table:
    //   from	to	target	type
    //   3	25	59	finally
    //   30	33	59	finally
    //   33	42	59	finally
    //   46	50	59	finally
    //   50	56	59	finally
    //   66	76	59	finally
    //   79	92	59	finally
    //   92	102	59	finally
    //   106	116	59	finally
    //   30	33	65	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   33	42	105	android/os/RemoteException
    //   46	50	105	android/os/RemoteException
    //   79	92	105	android/os/RemoteException
  }
  
  static abstract class CertData
    extends ICertData.Stub
  {
    private int zzbc;
    
    protected CertData(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte.length == 25) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        this.zzbc = Arrays.hashCode(paramArrayOfByte);
        return;
      }
    }
    
    protected static byte[] zzd(String paramString)
    {
      try
      {
        paramString = paramString.getBytes("ISO-8859-1");
        return paramString;
      }
      catch (UnsupportedEncodingException paramString)
      {
        throw new AssertionError(paramString);
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof ICertData))) {
        return false;
      }
      try
      {
        paramObject = (ICertData)paramObject;
        if (paramObject.getHashCode() != hashCode()) {
          return false;
        }
        paramObject = paramObject.getBytesWrapped();
        if (paramObject == null) {
          return false;
        }
        paramObject = (byte[])ObjectWrapper.unwrap(paramObject);
        boolean bool = Arrays.equals(getBytes(), paramObject);
        return bool;
      }
      catch (RemoteException paramObject) {}
      return false;
    }
    
    abstract byte[] getBytes();
    
    public IObjectWrapper getBytesWrapped()
    {
      return ObjectWrapper.wrap(getBytes());
    }
    
    public int getHashCode()
    {
      return hashCode();
    }
    
    public int hashCode()
    {
      return this.zzbc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.GoogleCertificates
 * JD-Core Version:    0.7.0.1
 */