package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

public class zzrx
  extends zzsa
{
  public static boolean zzadA;
  private AdvertisingIdClient.Info zzadB;
  private final zztj zzadC;
  private String zzadD;
  private boolean zzadE = false;
  private Object zzadF = new Object();
  
  zzrx(zzsc paramzzsc)
  {
    super(paramzzsc);
    this.zzadC = new zztj(paramzzsc.zznR());
  }
  
  private boolean zza(AdvertisingIdClient.Info paramInfo1, AdvertisingIdClient.Info paramInfo2)
  {
    String str2 = null;
    if (paramInfo2 == null) {}
    for (paramInfo2 = null; TextUtils.isEmpty(paramInfo2); paramInfo2 = paramInfo2.getId()) {
      return true;
    }
    String str1 = zznX().zzoQ();
    boolean bool;
    for (;;)
    {
      synchronized (this.zzadF)
      {
        if (!this.zzadE)
        {
          this.zzadD = zznJ();
          this.zzadE = true;
          paramInfo1 = String.valueOf(paramInfo2);
          str2 = String.valueOf(str1);
          if (str2.length() == 0) {
            break label240;
          }
          paramInfo1 = paramInfo1.concat(str2);
          paramInfo1 = zzbN(paramInfo1);
          if (!TextUtils.isEmpty(paramInfo1)) {
            break;
          }
          return false;
        }
      }
      if (TextUtils.isEmpty(this.zzadD))
      {
        if (paramInfo1 == null)
        {
          paramInfo1 = str2;
          if (paramInfo1 != null) {
            break label190;
          }
          paramInfo1 = String.valueOf(paramInfo2);
          paramInfo2 = String.valueOf(str1);
          if (paramInfo2.length() == 0) {
            break label178;
          }
        }
        label178:
        for (paramInfo1 = paramInfo1.concat(paramInfo2);; paramInfo1 = new String(paramInfo1))
        {
          bool = zzbO(paramInfo1);
          return bool;
          paramInfo1 = paramInfo1.getId();
          break;
        }
        label190:
        paramInfo1 = String.valueOf(paramInfo1);
        str2 = String.valueOf(str1);
        if (str2.length() != 0) {}
        for (paramInfo1 = paramInfo1.concat(str2);; paramInfo1 = new String(paramInfo1))
        {
          this.zzadD = zzbN(paramInfo1);
          break;
        }
        label240:
        paramInfo1 = new String(paramInfo1);
      }
    }
    if (paramInfo1.equals(this.zzadD)) {
      return true;
    }
    if (!TextUtils.isEmpty(this.zzadD))
    {
      zzbP("Resetting the client id because Advertising Id changed.");
      paramInfo1 = zznX().zzoR();
      zza("New client Id", paramInfo1);
    }
    for (;;)
    {
      paramInfo2 = String.valueOf(paramInfo2);
      paramInfo1 = String.valueOf(paramInfo1);
      if (paramInfo1.length() != 0) {}
      for (paramInfo1 = paramInfo2.concat(paramInfo1);; paramInfo1 = new String(paramInfo2))
      {
        bool = zzbO(paramInfo1);
        return bool;
      }
      paramInfo1 = str1;
    }
  }
  
  private static String zzbN(String paramString)
  {
    MessageDigest localMessageDigest = zztm.zzch("MD5");
    if (localMessageDigest == null) {
      return null;
    }
    return String.format(Locale.US, "%032X", new Object[] { new BigInteger(1, localMessageDigest.digest(paramString.getBytes())) });
  }
  
  private boolean zzbO(String paramString)
  {
    try
    {
      paramString = zzbN(paramString);
      zzbP("Storing hashed adid.");
      FileOutputStream localFileOutputStream = getContext().openFileOutput("gaClientIdData", 0);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      this.zzadD = paramString;
      return true;
    }
    catch (IOException paramString)
    {
      zze("Error creating hash file", paramString);
    }
    return false;
  }
  
  /* Error */
  private AdvertisingIdClient.Info zznH()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/google/android/gms/internal/zzrx:zzadC	Lcom/google/android/gms/internal/zztj;
    //   6: ldc2_w 179
    //   9: invokevirtual 184	com/google/android/gms/internal/zztj:zzA	(J)Z
    //   12: ifeq +32 -> 44
    //   15: aload_0
    //   16: getfield 41	com/google/android/gms/internal/zzrx:zzadC	Lcom/google/android/gms/internal/zztj;
    //   19: invokevirtual 187	com/google/android/gms/internal/zztj:start	()V
    //   22: aload_0
    //   23: invokevirtual 190	com/google/android/gms/internal/zzrx:zznI	()Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    //   26: astore_1
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 192	com/google/android/gms/internal/zzrx:zzadB	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    //   32: aload_1
    //   33: invokespecial 194	com/google/android/gms/internal/zzrx:zza	(Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;)Z
    //   36: ifeq +17 -> 53
    //   39: aload_0
    //   40: aload_1
    //   41: putfield 192	com/google/android/gms/internal/zzrx:zzadB	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    //   44: aload_0
    //   45: getfield 192	com/google/android/gms/internal/zzrx:zzadB	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: areturn
    //   53: aload_0
    //   54: ldc 196
    //   56: invokevirtual 199	com/google/android/gms/internal/zzrx:zzbT	(Ljava/lang/String;)V
    //   59: aload_0
    //   60: new 52	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info
    //   63: dup
    //   64: ldc 201
    //   66: iconst_0
    //   67: invokespecial 204	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:<init>	(Ljava/lang/String;Z)V
    //   70: putfield 192	com/google/android/gms/internal/zzrx:zzadB	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    //   73: goto -29 -> 44
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	zzrx
    //   26	26	1	localInfo	AdvertisingIdClient.Info
    //   76	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	44	76	finally
    //   44	49	76	finally
    //   53	73	76	finally
  }
  
  protected void zzmS() {}
  
  public String zznG()
  {
    zzob();
    Object localObject = zznH();
    if (localObject != null) {}
    for (localObject = ((AdvertisingIdClient.Info)localObject).getId();; localObject = null)
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return null;
      }
      return localObject;
    }
  }
  
  protected AdvertisingIdClient.Info zznI()
  {
    Object localObject = null;
    try
    {
      AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
      localObject = localInfo;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      zzbS("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
      return null;
    }
    catch (Throwable localThrowable)
    {
      while (zzadA) {}
      zzadA = true;
      zzd("Error getting advertiser id", localThrowable);
    }
    return localObject;
    return null;
  }
  
  protected String zznJ()
  {
    Object localObject1 = null;
    try
    {
      FileInputStream localFileInputStream = getContext().openFileInput("gaClientIdData");
      Object localObject2 = new byte[''];
      int i = localFileInputStream.read((byte[])localObject2, 0, 128);
      if (localFileInputStream.available() > 0)
      {
        zzbS("Hash file seems corrupted, deleting it.");
        localFileInputStream.close();
        getContext().deleteFile("gaClientIdData");
        return null;
      }
      if (i <= 0)
      {
        zzbP("Hash file is empty.");
        localFileInputStream.close();
        return null;
      }
      localObject2 = new String((byte[])localObject2, 0, i);
      IOException localIOException2;
      return null;
    }
    catch (IOException localIOException1)
    {
      try
      {
        localFileInputStream.close();
        return localObject2;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          localObject1 = localIOException1;
          localIOException2 = localIOException3;
        }
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        return localIOException2;
      }
      localIOException1 = localIOException1;
      zzd("Error reading Hash file, deleting it", localIOException1);
      getContext().deleteFile("gaClientIdData");
      return localObject1;
    }
    catch (FileNotFoundException localFileNotFoundException2) {}
  }
  
  public boolean zznw()
  {
    boolean bool2 = false;
    zzob();
    AdvertisingIdClient.Info localInfo = zznH();
    boolean bool1 = bool2;
    if (localInfo != null)
    {
      bool1 = bool2;
      if (!localInfo.isLimitAdTrackingEnabled()) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzrx
 * JD-Core Version:    0.7.0.1
 */