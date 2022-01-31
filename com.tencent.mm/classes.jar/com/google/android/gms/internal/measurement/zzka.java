package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.security.auth.x500.X500Principal;

public final class zzka
  extends zzhh
{
  private static final String[] zzard = { "firebase_", "google_", "ga_" };
  private SecureRandom zzare;
  private final AtomicLong zzarf;
  private int zzarg;
  private Integer zzarh;
  
  zzka(zzgl paramzzgl)
  {
    super(paramzzgl);
    AppMethodBeat.i(69498);
    this.zzarh = null;
    this.zzarf = new AtomicLong(0L);
    AppMethodBeat.o(69498);
  }
  
  static MessageDigest getMessageDigest(String paramString)
  {
    AppMethodBeat.i(69531);
    int i = 0;
    while (i < 2) {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
        if (localMessageDigest != null)
        {
          AppMethodBeat.o(69531);
          return localMessageDigest;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        i += 1;
      }
    }
    AppMethodBeat.o(69531);
    return null;
  }
  
  public static zzko zza(zzkn paramzzkn, String paramString)
  {
    AppMethodBeat.i(69543);
    paramzzkn = paramzzkn.zzata;
    int j = paramzzkn.length;
    int i = 0;
    while (i < j)
    {
      zzko localzzko = paramzzkn[i];
      if (localzzko.name.equals(paramString))
      {
        AppMethodBeat.o(69543);
        return localzzko;
      }
      i += 1;
    }
    AppMethodBeat.o(69543);
    return null;
  }
  
  private static Object zza(int paramInt, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(69514);
    if (paramObject == null)
    {
      AppMethodBeat.o(69514);
      return null;
    }
    if (((paramObject instanceof Long)) || ((paramObject instanceof Double)))
    {
      AppMethodBeat.o(69514);
      return paramObject;
    }
    long l;
    if ((paramObject instanceof Integer))
    {
      l = ((Integer)paramObject).intValue();
      AppMethodBeat.o(69514);
      return Long.valueOf(l);
    }
    if ((paramObject instanceof Byte))
    {
      l = ((Byte)paramObject).byteValue();
      AppMethodBeat.o(69514);
      return Long.valueOf(l);
    }
    if ((paramObject instanceof Short))
    {
      l = ((Short)paramObject).shortValue();
      AppMethodBeat.o(69514);
      return Long.valueOf(l);
    }
    if ((paramObject instanceof Boolean))
    {
      if (((Boolean)paramObject).booleanValue()) {}
      for (l = 1L;; l = 0L)
      {
        AppMethodBeat.o(69514);
        return Long.valueOf(l);
      }
    }
    if ((paramObject instanceof Float))
    {
      double d = ((Float)paramObject).doubleValue();
      AppMethodBeat.o(69514);
      return Double.valueOf(d);
    }
    if (((paramObject instanceof String)) || ((paramObject instanceof Character)) || ((paramObject instanceof CharSequence)))
    {
      paramObject = zza(String.valueOf(paramObject), paramInt, paramBoolean);
      AppMethodBeat.o(69514);
      return paramObject;
    }
    AppMethodBeat.o(69514);
    return null;
  }
  
  public static String zza(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(69515);
    if (paramString.codePointCount(0, paramString.length()) > paramInt)
    {
      if (paramBoolean)
      {
        paramString = String.valueOf(paramString.substring(0, paramString.offsetByCodePoints(0, paramInt))).concat("...");
        AppMethodBeat.o(69515);
        return paramString;
      }
      AppMethodBeat.o(69515);
      return null;
    }
    AppMethodBeat.o(69515);
    return paramString;
  }
  
  public static String zza(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(69554);
    Preconditions.checkNotNull(paramArrayOfString1);
    Preconditions.checkNotNull(paramArrayOfString2);
    int j = Math.min(paramArrayOfString1.length, paramArrayOfString2.length);
    int i = 0;
    while (i < j)
    {
      if (zzs(paramString, paramArrayOfString1[i]))
      {
        paramString = paramArrayOfString2[i];
        AppMethodBeat.o(69554);
        return paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(69554);
    return null;
  }
  
  private static void zza(Bundle paramBundle, Object paramObject)
  {
    AppMethodBeat.i(69520);
    Preconditions.checkNotNull(paramBundle);
    if ((paramObject != null) && (((paramObject instanceof String)) || ((paramObject instanceof CharSequence)))) {
      paramBundle.putLong("_el", String.valueOf(paramObject).length());
    }
    AppMethodBeat.o(69520);
  }
  
  private static boolean zza(Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(69519);
    if (paramBundle.getLong("_err") == 0L)
    {
      paramBundle.putLong("_err", paramInt);
      AppMethodBeat.o(69519);
      return true;
    }
    AppMethodBeat.o(69519);
    return false;
  }
  
  private final boolean zza(String paramString1, String paramString2, int paramInt, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(69512);
    if (paramObject == null)
    {
      AppMethodBeat.o(69512);
      return true;
    }
    if (((paramObject instanceof Long)) || ((paramObject instanceof Float)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Byte)) || ((paramObject instanceof Short)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Double)))
    {
      AppMethodBeat.o(69512);
      return true;
    }
    if (((paramObject instanceof String)) || ((paramObject instanceof Character)) || ((paramObject instanceof CharSequence)))
    {
      paramObject = String.valueOf(paramObject);
      if (paramObject.codePointCount(0, paramObject.length()) > paramInt)
      {
        zzge().zzip().zzd("Value is too long; discarded. Value kind, name, value length", paramString1, paramString2, Integer.valueOf(paramObject.length()));
        AppMethodBeat.o(69512);
        return false;
      }
      AppMethodBeat.o(69512);
      return true;
    }
    if (((paramObject instanceof Bundle)) && (paramBoolean))
    {
      AppMethodBeat.o(69512);
      return true;
    }
    int i;
    if (((paramObject instanceof Parcelable[])) && (paramBoolean))
    {
      paramString1 = (Parcelable[])paramObject;
      i = paramString1.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramObject = paramString1[paramInt];
        if (!(paramObject instanceof Bundle))
        {
          zzge().zzip().zze("All Parcelable[] elements must be of type Bundle. Value type, name", paramObject.getClass(), paramString2);
          AppMethodBeat.o(69512);
          return false;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(69512);
      return true;
    }
    if (((paramObject instanceof ArrayList)) && (paramBoolean))
    {
      paramString1 = (ArrayList)paramObject;
      i = paramString1.size();
      paramInt = 0;
      while (paramInt < i)
      {
        paramObject = paramString1.get(paramInt);
        paramInt += 1;
        if (!(paramObject instanceof Bundle))
        {
          zzge().zzip().zze("All ArrayList elements must be of type Bundle. Value type, name", paramObject.getClass(), paramString2);
          AppMethodBeat.o(69512);
          return false;
        }
      }
      AppMethodBeat.o(69512);
      return true;
    }
    AppMethodBeat.o(69512);
    return false;
  }
  
  public static boolean zza(long[] paramArrayOfLong, int paramInt)
  {
    if (paramInt >= paramArrayOfLong.length << 6) {}
    while ((paramArrayOfLong[(paramInt / 64)] & 1L << paramInt % 64) == 0L) {
      return false;
    }
    return true;
  }
  
  static byte[] zza(Parcelable paramParcelable)
  {
    AppMethodBeat.i(69552);
    if (paramParcelable == null)
    {
      AppMethodBeat.o(69552);
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    try
    {
      paramParcelable.writeToParcel(localParcel, 0);
      paramParcelable = localParcel.marshall();
      return paramParcelable;
    }
    finally
    {
      localParcel.recycle();
      AppMethodBeat.o(69552);
    }
  }
  
  public static long[] zza(BitSet paramBitSet)
  {
    AppMethodBeat.i(69539);
    int k = (paramBitSet.length() + 63) / 64;
    long[] arrayOfLong = new long[k];
    int i = 0;
    while (i < k)
    {
      arrayOfLong[i] = 0L;
      int j = 0;
      while ((j < 64) && ((i << 6) + j < paramBitSet.length()))
      {
        if (paramBitSet.get((i << 6) + j)) {
          arrayOfLong[i] |= 1L << j;
        }
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(69539);
    return arrayOfLong;
  }
  
  static zzko[] zza(zzko[] paramArrayOfzzko, String paramString, Object paramObject)
  {
    AppMethodBeat.i(69545);
    int j = paramArrayOfzzko.length;
    int i = 0;
    while (i < j)
    {
      localObject = paramArrayOfzzko[i];
      if (paramString.equals(((zzko)localObject).name))
      {
        ((zzko)localObject).zzate = null;
        ((zzko)localObject).zzajf = null;
        ((zzko)localObject).zzarc = null;
        if ((paramObject instanceof Long)) {
          ((zzko)localObject).zzate = ((Long)paramObject);
        }
        for (;;)
        {
          AppMethodBeat.o(69545);
          return paramArrayOfzzko;
          if ((paramObject instanceof String)) {
            ((zzko)localObject).zzajf = ((String)paramObject);
          } else if ((paramObject instanceof Double)) {
            ((zzko)localObject).zzarc = ((Double)paramObject);
          }
        }
      }
      i += 1;
    }
    Object localObject = new zzko[paramArrayOfzzko.length + 1];
    System.arraycopy(paramArrayOfzzko, 0, localObject, 0, paramArrayOfzzko.length);
    zzko localzzko = new zzko();
    localzzko.name = paramString;
    if ((paramObject instanceof Long)) {
      localzzko.zzate = ((Long)paramObject);
    }
    for (;;)
    {
      localObject[paramArrayOfzzko.length] = localzzko;
      AppMethodBeat.o(69545);
      return localObject;
      if ((paramObject instanceof String)) {
        localzzko.zzajf = ((String)paramObject);
      } else if ((paramObject instanceof Double)) {
        localzzko.zzarc = ((Double)paramObject);
      }
    }
  }
  
  public static Object zzb(zzkn paramzzkn, String paramString)
  {
    AppMethodBeat.i(69544);
    paramzzkn = zza(paramzzkn, paramString);
    if (paramzzkn != null)
    {
      if (paramzzkn.zzajf != null)
      {
        paramzzkn = paramzzkn.zzajf;
        AppMethodBeat.o(69544);
        return paramzzkn;
      }
      if (paramzzkn.zzate != null)
      {
        paramzzkn = paramzzkn.zzate;
        AppMethodBeat.o(69544);
        return paramzzkn;
      }
      if (paramzzkn.zzarc != null)
      {
        paramzzkn = paramzzkn.zzarc;
        AppMethodBeat.o(69544);
        return paramzzkn;
      }
    }
    AppMethodBeat.o(69544);
    return null;
  }
  
  @VisibleForTesting
  static long zzc(byte[] paramArrayOfByte)
  {
    int j = 0;
    AppMethodBeat.i(69532);
    Preconditions.checkNotNull(paramArrayOfByte);
    if (paramArrayOfByte.length > 0) {}
    long l;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      l = 0L;
      int i = paramArrayOfByte.length - 1;
      while ((i >= 0) && (i >= paramArrayOfByte.length - 8))
      {
        l += ((paramArrayOfByte[i] & 0xFF) << j);
        j += 8;
        i -= 1;
      }
    }
    AppMethodBeat.o(69532);
    return l;
  }
  
  public static boolean zzc(Context paramContext, String paramString)
  {
    AppMethodBeat.i(69535);
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null)
      {
        AppMethodBeat.o(69535);
        return false;
      }
      paramContext = localPackageManager.getServiceInfo(new ComponentName(paramContext, paramString), 0);
      if (paramContext != null)
      {
        boolean bool = paramContext.enabled;
        if (bool)
        {
          AppMethodBeat.o(69535);
          return true;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(69535);
    }
    return false;
  }
  
  static boolean zzcc(String paramString)
  {
    AppMethodBeat.i(69502);
    Preconditions.checkNotEmpty(paramString);
    if ((paramString.charAt(0) != '_') || (paramString.equals("_ep")))
    {
      AppMethodBeat.o(69502);
      return true;
    }
    AppMethodBeat.o(69502);
    return false;
  }
  
  private static int zzch(String paramString)
  {
    AppMethodBeat.i(69521);
    if ("_ldl".equals(paramString))
    {
      AppMethodBeat.o(69521);
      return 2048;
    }
    if ("_id".equals(paramString))
    {
      AppMethodBeat.o(69521);
      return 256;
    }
    AppMethodBeat.o(69521);
    return 36;
  }
  
  public static boolean zzci(String paramString)
  {
    AppMethodBeat.i(69537);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("_")))
    {
      AppMethodBeat.o(69537);
      return true;
    }
    AppMethodBeat.o(69537);
    return false;
  }
  
  static boolean zzck(String paramString)
  {
    AppMethodBeat.i(69541);
    if ((paramString != null) && (paramString.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)")) && (paramString.length() <= 310))
    {
      AppMethodBeat.o(69541);
      return true;
    }
    AppMethodBeat.o(69541);
    return false;
  }
  
  static boolean zzcl(String paramString)
  {
    AppMethodBeat.i(69550);
    Preconditions.checkNotEmpty(paramString);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(69550);
        return false;
        if (paramString.equals("_in"))
        {
          i = 0;
          continue;
          if (paramString.equals("_ui"))
          {
            i = 1;
            continue;
            if (paramString.equals("_ug")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    AppMethodBeat.o(69550);
    return true;
  }
  
  public static boolean zzd(Intent paramIntent)
  {
    AppMethodBeat.i(69504);
    paramIntent = paramIntent.getStringExtra("android.intent.extra.REFERRER_NAME");
    if (("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(paramIntent)) || ("https://www.google.com".equals(paramIntent)) || ("android-app://com.google.appcrawler".equals(paramIntent)))
    {
      AppMethodBeat.o(69504);
      return true;
    }
    AppMethodBeat.o(69504);
    return false;
  }
  
  static boolean zzd(zzeu paramzzeu, zzdz paramzzdz)
  {
    AppMethodBeat.i(69549);
    Preconditions.checkNotNull(paramzzeu);
    Preconditions.checkNotNull(paramzzdz);
    if (TextUtils.isEmpty(paramzzdz.zzadm))
    {
      AppMethodBeat.o(69549);
      return false;
    }
    AppMethodBeat.o(69549);
    return true;
  }
  
  @VisibleForTesting
  private final boolean zze(Context paramContext, String paramString)
  {
    AppMethodBeat.i(69548);
    X500Principal localX500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
    try
    {
      paramContext = Wrappers.packageManager(paramContext).getPackageInfo(paramString, 64);
      if ((paramContext != null) && (paramContext.signatures != null) && (paramContext.signatures.length > 0))
      {
        paramContext = paramContext.signatures[0];
        boolean bool = ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(paramContext.toByteArray()))).getSubjectX500Principal().equals(localX500Principal);
        AppMethodBeat.o(69548);
        return bool;
      }
    }
    catch (CertificateException paramContext)
    {
      zzge().zzim().zzg("Error obtaining certificate", paramContext);
      AppMethodBeat.o(69548);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        zzge().zzim().zzg("Package name not found", paramContext);
      }
    }
  }
  
  public static Bundle[] zze(Object paramObject)
  {
    AppMethodBeat.i(69517);
    if ((paramObject instanceof Bundle))
    {
      paramObject = (Bundle)paramObject;
      AppMethodBeat.o(69517);
      return new Bundle[] { paramObject };
    }
    if ((paramObject instanceof Parcelable[]))
    {
      paramObject = (Bundle[])Arrays.copyOf((Parcelable[])paramObject, ((Parcelable[])paramObject).length, [Landroid.os.Bundle.class);
      AppMethodBeat.o(69517);
      return paramObject;
    }
    if ((paramObject instanceof ArrayList))
    {
      paramObject = (ArrayList)paramObject;
      paramObject = (Bundle[])paramObject.toArray(new Bundle[paramObject.size()]);
      AppMethodBeat.o(69517);
      return paramObject;
    }
    AppMethodBeat.o(69517);
    return null;
  }
  
  /* Error */
  public static Object zzf(Object paramObject)
  {
    // Byte code:
    //   0: ldc_w 491
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 491
    //   13: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: new 493	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 494	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore_1
    //   26: new 496	java/io/ObjectOutputStream
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 499	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   34: astore_2
    //   35: aload_2
    //   36: aload_0
    //   37: invokevirtual 503	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   40: aload_2
    //   41: invokevirtual 506	java/io/ObjectOutputStream:flush	()V
    //   44: new 508	java/io/ObjectInputStream
    //   47: dup
    //   48: new 441	java/io/ByteArrayInputStream
    //   51: dup
    //   52: aload_1
    //   53: invokevirtual 509	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   56: invokespecial 449	java/io/ByteArrayInputStream:<init>	([B)V
    //   59: invokespecial 512	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 516	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   67: astore_0
    //   68: aload_2
    //   69: invokevirtual 519	java/io/ObjectOutputStream:close	()V
    //   72: aload_1
    //   73: invokevirtual 520	java/io/ObjectInputStream:close	()V
    //   76: ldc_w 491
    //   79: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_0
    //   83: areturn
    //   84: astore_0
    //   85: aconst_null
    //   86: astore_1
    //   87: aconst_null
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull +7 -> 97
    //   93: aload_2
    //   94: invokevirtual 519	java/io/ObjectOutputStream:close	()V
    //   97: aload_1
    //   98: ifnull +7 -> 105
    //   101: aload_1
    //   102: invokevirtual 520	java/io/ObjectInputStream:close	()V
    //   105: ldc_w 491
    //   108: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_0
    //   112: athrow
    //   113: astore_0
    //   114: ldc_w 491
    //   117: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aconst_null
    //   121: areturn
    //   122: astore_0
    //   123: goto -9 -> 114
    //   126: astore_0
    //   127: aconst_null
    //   128: astore_1
    //   129: goto -40 -> 89
    //   132: astore_0
    //   133: goto -44 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramObject	Object
    //   25	104	1	localObject	Object
    //   34	60	2	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   18	35	84	finally
    //   68	76	113	java/io/IOException
    //   93	97	113	java/io/IOException
    //   101	105	113	java/io/IOException
    //   105	113	113	java/io/IOException
    //   68	76	122	java/lang/ClassNotFoundException
    //   93	97	122	java/lang/ClassNotFoundException
    //   101	105	122	java/lang/ClassNotFoundException
    //   105	113	122	java/lang/ClassNotFoundException
    //   35	63	126	finally
    //   63	68	132	finally
  }
  
  private final boolean zzr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69506);
    if (paramString2 == null)
    {
      zzge().zzim().zzg("Name is required and can't be null. Type", paramString1);
      AppMethodBeat.o(69506);
      return false;
    }
    if (paramString2.length() == 0)
    {
      zzge().zzim().zzg("Name is required and can't be empty. Type", paramString1);
      AppMethodBeat.o(69506);
      return false;
    }
    int i = paramString2.codePointAt(0);
    if ((!Character.isLetter(i)) && (i != 95))
    {
      zzge().zzim().zze("Name must start with a letter or _ (underscore). Type, name", paramString1, paramString2);
      AppMethodBeat.o(69506);
      return false;
    }
    int j = paramString2.length();
    i = Character.charCount(i);
    while (i < j)
    {
      int k = paramString2.codePointAt(i);
      if ((k != 95) && (!Character.isLetterOrDigit(k)))
      {
        zzge().zzim().zze("Name must consist of letters, digits or _ (underscores). Type, name", paramString1, paramString2);
        AppMethodBeat.o(69506);
        return false;
      }
      i += Character.charCount(k);
    }
    AppMethodBeat.o(69506);
    return true;
  }
  
  public static boolean zzs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69538);
    if ((paramString1 == null) && (paramString2 == null))
    {
      AppMethodBeat.o(69538);
      return true;
    }
    if (paramString1 == null)
    {
      AppMethodBeat.o(69538);
      return false;
    }
    boolean bool = paramString1.equals(paramString2);
    AppMethodBeat.o(69538);
    return bool;
  }
  
  public final Bundle zza(Uri paramUri)
  {
    AppMethodBeat.i(69503);
    if (paramUri == null)
    {
      AppMethodBeat.o(69503);
      return null;
    }
    for (;;)
    {
      try
      {
        if (!paramUri.isHierarchical()) {
          break label326;
        }
        str4 = paramUri.getQueryParameter("utm_campaign");
        str3 = paramUri.getQueryParameter("utm_source");
        str2 = paramUri.getQueryParameter("utm_medium");
        str1 = paramUri.getQueryParameter("gclid");
        if ((!TextUtils.isEmpty(str4)) || (!TextUtils.isEmpty(str3)) || (!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str1)))
        {
          Bundle localBundle = new Bundle();
          if (!TextUtils.isEmpty(str4)) {
            localBundle.putString("campaign", str4);
          }
          if (!TextUtils.isEmpty(str3)) {
            localBundle.putString("source", str3);
          }
          if (!TextUtils.isEmpty(str2)) {
            localBundle.putString("medium", str2);
          }
          if (!TextUtils.isEmpty(str1)) {
            localBundle.putString("gclid", str1);
          }
          str1 = paramUri.getQueryParameter("utm_term");
          if (!TextUtils.isEmpty(str1)) {
            localBundle.putString("term", str1);
          }
          str1 = paramUri.getQueryParameter("utm_content");
          if (!TextUtils.isEmpty(str1)) {
            localBundle.putString("content", str1);
          }
          str1 = paramUri.getQueryParameter("aclid");
          if (!TextUtils.isEmpty(str1)) {
            localBundle.putString("aclid", str1);
          }
          str1 = paramUri.getQueryParameter("cp1");
          if (!TextUtils.isEmpty(str1)) {
            localBundle.putString("cp1", str1);
          }
          paramUri = paramUri.getQueryParameter("anid");
          if (!TextUtils.isEmpty(paramUri)) {
            localBundle.putString("anid", paramUri);
          }
          AppMethodBeat.o(69503);
          return localBundle;
        }
      }
      catch (UnsupportedOperationException paramUri)
      {
        zzge().zzip().zzg("Install referrer url isn't a hierarchical URI", paramUri);
        AppMethodBeat.o(69503);
        return null;
      }
      AppMethodBeat.o(69503);
      return null;
      label326:
      String str1 = null;
      String str2 = null;
      String str3 = null;
      String str4 = null;
    }
  }
  
  public final Bundle zza(String paramString, Bundle paramBundle, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(69518);
    Bundle localBundle = null;
    if (paramBundle != null)
    {
      localBundle = new Bundle(paramBundle);
      Iterator localIterator = paramBundle.keySet().iterator();
      int k = 0;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        int i = 0;
        int j = 0;
        if ((paramList == null) || (!paramList.contains(str)))
        {
          if (paramBoolean1)
          {
            if (zzq("event param", str)) {
              break label178;
            }
            j = 3;
          }
          label100:
          i = j;
          if (j == 0)
          {
            if (zzr("event param", str)) {
              break label224;
            }
            i = 3;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label270;
          }
          if (zza(localBundle, i))
          {
            localBundle.putString("_ev", zza(str, 40, true));
            if (i == 3) {
              zza(localBundle, str);
            }
          }
          localBundle.remove(str);
          break;
          label178:
          if (!zza("event param", null, str))
          {
            j = 14;
            break label100;
          }
          if (!zza("event param", 40, str))
          {
            j = 3;
            break label100;
          }
          j = 0;
          break label100;
          label224:
          if (!zza("event param", null, str)) {
            i = 14;
          } else if (!zza("event param", 40, str)) {
            i = 3;
          } else {
            i = 0;
          }
        }
        label270:
        Object localObject = paramBundle.get(str);
        zzab();
        if (paramBoolean2) {
          if ((localObject instanceof Parcelable[]))
          {
            i = ((Parcelable[])localObject).length;
            label303:
            if (i <= 1000) {
              break label436;
            }
            zzge().zzip().zzd("Parameter array is too long; discarded. Value kind, name, array length", "param", str, Integer.valueOf(i));
            i = 0;
            label337:
            if (i != 0) {
              break label442;
            }
            i = 17;
          }
        }
        for (;;)
        {
          if ((i == 0) || ("_ev".equals(str))) {
            break label529;
          }
          if (zza(localBundle, i))
          {
            localBundle.putString("_ev", zza(str, 40, true));
            zza(localBundle, paramBundle.get(str));
          }
          localBundle.remove(str);
          break;
          if ((localObject instanceof ArrayList))
          {
            i = ((ArrayList)localObject).size();
            break label303;
          }
          i = 1;
          break label337;
          label436:
          i = 1;
          break label337;
          label442:
          if (((zzgg().zzaw(zzfv().zzah())) && (zzci(paramString))) || (zzci(str))) {}
          for (boolean bool = zza("param", str, 256, localObject, paramBoolean2);; bool = zza("param", str, 100, localObject, paramBoolean2))
          {
            if (!bool) {
              break label523;
            }
            i = 0;
            break;
          }
          label523:
          i = 4;
        }
        label529:
        if (zzcc(str))
        {
          j = k + 1;
          i = j;
          if (j > 25)
          {
            localObject = 48 + "Event can't contain more than 25 params";
            zzge().zzim().zze((String)localObject, zzga().zzbj(paramString), zzga().zzb(paramBundle));
            zza(localBundle, 5);
            localBundle.remove(str);
            k = j;
          }
        }
        else
        {
          i = k;
        }
        k = i;
      }
    }
    AppMethodBeat.o(69518);
    return localBundle;
  }
  
  final <T extends Parcelable> T zza(byte[] paramArrayOfByte, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(69551);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(69551);
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
      localParcel.setDataPosition(0);
      paramArrayOfByte = (Parcelable)paramCreator.createFromParcel(localParcel);
      return paramArrayOfByte;
    }
    catch (SafeParcelReader.ParseException paramArrayOfByte)
    {
      zzge().zzim().log("Failed to load parcelable from buffer");
      return null;
    }
    finally
    {
      localParcel.recycle();
      AppMethodBeat.o(69551);
    }
  }
  
  final zzeu zza(String paramString1, Bundle paramBundle, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(69546);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(69546);
      return null;
    }
    if (zzcd(paramString1) != 0)
    {
      zzge().zzim().zzg("Invalid conditional property event name", zzga().zzbl(paramString1));
      paramString1 = new IllegalArgumentException();
      AppMethodBeat.o(69546);
      throw paramString1;
    }
    if (paramBundle != null) {}
    for (paramBundle = new Bundle(paramBundle);; paramBundle = new Bundle())
    {
      paramBundle.putString("_o", paramString2);
      paramString1 = new zzeu(paramString1, new zzer(zzd(zza(paramString1, paramBundle, CollectionUtils.listOf("_o"), false, false))), paramString2, paramLong);
      AppMethodBeat.o(69546);
      return paramString1;
    }
  }
  
  public final void zza(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(69527);
    zza(null, paramInt1, paramString1, paramString2, paramInt2);
    AppMethodBeat.o(69527);
  }
  
  public final void zza(Bundle paramBundle, String paramString, Object paramObject)
  {
    AppMethodBeat.i(69526);
    if (paramBundle == null)
    {
      AppMethodBeat.o(69526);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramBundle.putLong(paramString, ((Long)paramObject).longValue());
      AppMethodBeat.o(69526);
      return;
    }
    if ((paramObject instanceof String))
    {
      paramBundle.putString(paramString, String.valueOf(paramObject));
      AppMethodBeat.o(69526);
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
      AppMethodBeat.o(69526);
      return;
    }
    if (paramString != null) {
      if (paramObject == null) {
        break label137;
      }
    }
    label137:
    for (paramBundle = paramObject.getClass().getSimpleName();; paramBundle = null)
    {
      zzge().zziq().zze("Not putting event parameter. Invalid value type. name, type", zzga().zzbk(paramString), paramBundle);
      AppMethodBeat.o(69526);
      return;
    }
  }
  
  public final void zza(zzko paramzzko, Object paramObject)
  {
    AppMethodBeat.i(69525);
    Preconditions.checkNotNull(paramObject);
    paramzzko.zzajf = null;
    paramzzko.zzate = null;
    paramzzko.zzarc = null;
    if ((paramObject instanceof String))
    {
      paramzzko.zzajf = ((String)paramObject);
      AppMethodBeat.o(69525);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramzzko.zzate = ((Long)paramObject);
      AppMethodBeat.o(69525);
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramzzko.zzarc = ((Double)paramObject);
      AppMethodBeat.o(69525);
      return;
    }
    zzge().zzim().zzg("Ignoring invalid (type) event param value", paramObject);
    AppMethodBeat.o(69525);
  }
  
  public final void zza(zzks paramzzks, Object paramObject)
  {
    AppMethodBeat.i(69524);
    Preconditions.checkNotNull(paramObject);
    paramzzks.zzajf = null;
    paramzzks.zzate = null;
    paramzzks.zzarc = null;
    if ((paramObject instanceof String))
    {
      paramzzks.zzajf = ((String)paramObject);
      AppMethodBeat.o(69524);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramzzks.zzate = ((Long)paramObject);
      AppMethodBeat.o(69524);
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramzzks.zzarc = ((Double)paramObject);
      AppMethodBeat.o(69524);
      return;
    }
    zzge().zzim().zzg("Ignoring invalid (type) user attribute value", paramObject);
    AppMethodBeat.o(69524);
  }
  
  public final void zza(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(69528);
    paramString1 = new Bundle();
    zza(paramString1, paramInt1);
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.putString(paramString2, paramString3);
    }
    if ((paramInt1 == 6) || (paramInt1 == 7) || (paramInt1 == 2)) {
      paramString1.putLong("_el", paramInt2);
    }
    this.zzacw.zzfu().logEvent("auto", "_err", paramString1);
    AppMethodBeat.o(69528);
  }
  
  public final boolean zza(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(69534);
    if ((paramLong1 == 0L) || (paramLong2 <= 0L))
    {
      AppMethodBeat.o(69534);
      return true;
    }
    if (Math.abs(zzbt().currentTimeMillis() - paramLong1) > paramLong2)
    {
      AppMethodBeat.o(69534);
      return true;
    }
    AppMethodBeat.o(69534);
    return false;
  }
  
  final boolean zza(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(69508);
    if (paramString2 == null)
    {
      zzge().zzim().zzg("Name is required and can't be null. Type", paramString1);
      AppMethodBeat.o(69508);
      return false;
    }
    if (paramString2.codePointCount(0, paramString2.length()) > paramInt)
    {
      zzge().zzim().zzd("Name is too long. Type, maximum supported length, name", paramString1, Integer.valueOf(paramInt), paramString2);
      AppMethodBeat.o(69508);
      return false;
    }
    AppMethodBeat.o(69508);
    return true;
  }
  
  final boolean zza(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    AppMethodBeat.i(69507);
    if (paramString2 == null)
    {
      zzge().zzim().zzg("Name is required and can't be null. Type", paramString1);
      AppMethodBeat.o(69507);
      return false;
    }
    Preconditions.checkNotNull(paramString2);
    int i = 0;
    if (i < zzard.length) {
      if (!paramString2.startsWith(zzard[i])) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label108;
      }
      zzge().zzim().zze("Name starts with reserved prefix. Type, name", paramString1, paramString2);
      AppMethodBeat.o(69507);
      return false;
      i += 1;
      break;
    }
    label108:
    if (paramArrayOfString != null)
    {
      Preconditions.checkNotNull(paramArrayOfString);
      i = 0;
      if (i < paramArrayOfString.length) {
        if (!zzs(paramString2, paramArrayOfString[i])) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label184;
        }
        zzge().zzim().zze("Name is reserved. Type, name", paramString1, paramString2);
        AppMethodBeat.o(69507);
        return false;
        i += 1;
        break;
      }
    }
    label184:
    AppMethodBeat.o(69507);
    return true;
  }
  
  public final byte[] zza(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69529);
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramArrayOfByte);
      localGZIPOutputStream.close();
      localByteArrayOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      AppMethodBeat.o(69529);
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      zzge().zzim().zzg("Failed to gzip content", paramArrayOfByte);
      AppMethodBeat.o(69529);
      throw paramArrayOfByte;
    }
  }
  
  public final byte[] zzb(zzkp paramzzkp)
  {
    AppMethodBeat.i(69533);
    try
    {
      byte[] arrayOfByte = new byte[paramzzkp.zzvm()];
      zzabw localzzabw = zzabw.zzb(arrayOfByte, 0, arrayOfByte.length);
      paramzzkp.zza(localzzabw);
      localzzabw.zzve();
      AppMethodBeat.o(69533);
      return arrayOfByte;
    }
    catch (IOException paramzzkp)
    {
      zzge().zzim().zzg("Data loss. Failed to serialize batch", paramzzkp);
      AppMethodBeat.o(69533);
    }
    return null;
  }
  
  public final byte[] zzb(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69530);
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      GZIPInputStream localGZIPInputStream = new GZIPInputStream(paramArrayOfByte);
      localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = localGZIPInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localGZIPInputStream.close();
    }
    catch (IOException paramArrayOfByte)
    {
      zzge().zzim().zzg("Failed to ungzip content", paramArrayOfByte);
      AppMethodBeat.o(69530);
      throw paramArrayOfByte;
    }
    paramArrayOfByte.close();
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(69530);
    return paramArrayOfByte;
  }
  
  public final int zzcd(String paramString)
  {
    AppMethodBeat.i(69509);
    if (!zzr("event", paramString))
    {
      AppMethodBeat.o(69509);
      return 2;
    }
    if (!zza("event", AppMeasurement.Event.zzacx, paramString))
    {
      AppMethodBeat.o(69509);
      return 13;
    }
    if (!zza("event", 40, paramString))
    {
      AppMethodBeat.o(69509);
      return 2;
    }
    AppMethodBeat.o(69509);
    return 0;
  }
  
  public final int zzce(String paramString)
  {
    AppMethodBeat.i(69510);
    if (!zzq("user property", paramString))
    {
      AppMethodBeat.o(69510);
      return 6;
    }
    if (!zza("user property", AppMeasurement.UserProperty.zzadb, paramString))
    {
      AppMethodBeat.o(69510);
      return 15;
    }
    if (!zza("user property", 24, paramString))
    {
      AppMethodBeat.o(69510);
      return 6;
    }
    AppMethodBeat.o(69510);
    return 0;
  }
  
  public final int zzcf(String paramString)
  {
    AppMethodBeat.i(69511);
    if (!zzr("user property", paramString))
    {
      AppMethodBeat.o(69511);
      return 6;
    }
    if (!zza("user property", AppMeasurement.UserProperty.zzadb, paramString))
    {
      AppMethodBeat.o(69511);
      return 15;
    }
    if (!zza("user property", 24, paramString))
    {
      AppMethodBeat.o(69511);
      return 6;
    }
    AppMethodBeat.o(69511);
    return 0;
  }
  
  public final boolean zzcg(String paramString)
  {
    AppMethodBeat.i(69513);
    if (TextUtils.isEmpty(paramString))
    {
      zzge().zzim().log("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
      AppMethodBeat.o(69513);
      return false;
    }
    Preconditions.checkNotNull(paramString);
    if (!paramString.matches("^1:\\d+:android:[a-f0-9]+$"))
    {
      zzge().zzim().zzg("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", paramString);
      AppMethodBeat.o(69513);
      return false;
    }
    AppMethodBeat.o(69513);
    return true;
  }
  
  public final boolean zzcj(String paramString)
  {
    AppMethodBeat.i(69540);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(69540);
      return false;
    }
    boolean bool = zzgg().zzhj().equals(paramString);
    AppMethodBeat.o(69540);
    return bool;
  }
  
  final long zzd(Context paramContext, String paramString)
  {
    long l = -1L;
    AppMethodBeat.i(69547);
    zzab();
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotEmpty(paramString);
    PackageManager localPackageManager = paramContext.getPackageManager();
    MessageDigest localMessageDigest = getMessageDigest("MD5");
    if (localMessageDigest == null) {
      zzge().zzim().log("Could not get MD5 instance");
    }
    for (;;)
    {
      AppMethodBeat.o(69547);
      return l;
      if (localPackageManager != null) {
        try
        {
          if (!zze(paramContext, paramString))
          {
            paramContext = Wrappers.packageManager(paramContext).getPackageInfo(getContext().getPackageName(), 64);
            if ((paramContext.signatures != null) && (paramContext.signatures.length > 0))
            {
              l = zzc(localMessageDigest.digest(paramContext.signatures[0].toByteArray()));
              continue;
            }
            zzge().zzip().log("Could not get signatures");
          }
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          zzge().zzim().zzg("Package name not found", paramContext);
        }
      } else {
        l = 0L;
      }
    }
  }
  
  final Bundle zzd(Bundle paramBundle)
  {
    AppMethodBeat.i(69542);
    Bundle localBundle = new Bundle();
    if (paramBundle != null)
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = zzh(str, paramBundle.get(str));
        if (localObject == null) {
          zzge().zzip().zzg("Param value can't be null", zzga().zzbk(str));
        } else {
          zza(localBundle, str, localObject);
        }
      }
    }
    AppMethodBeat.o(69542);
    return localBundle;
  }
  
  public final Object zzh(String paramString, Object paramObject)
  {
    int i = 256;
    AppMethodBeat.i(69516);
    if ("_ev".equals(paramString))
    {
      paramString = zza(256, paramObject, true);
      AppMethodBeat.o(69516);
      return paramString;
    }
    if (zzci(paramString)) {}
    for (;;)
    {
      paramString = zza(i, paramObject, false);
      AppMethodBeat.o(69516);
      return paramString;
      i = 100;
    }
  }
  
  protected final boolean zzhf()
  {
    return true;
  }
  
  public final int zzi(String paramString, Object paramObject)
  {
    AppMethodBeat.i(69522);
    if ("_ldl".equals(paramString)) {}
    for (boolean bool = zza("user property referrer", paramString, zzch(paramString), paramObject, false); bool; bool = zza("user property", paramString, zzch(paramString), paramObject, false))
    {
      AppMethodBeat.o(69522);
      return 0;
    }
    AppMethodBeat.o(69522);
    return 7;
  }
  
  protected final void zzih()
  {
    AppMethodBeat.i(69499);
    zzab();
    SecureRandom localSecureRandom = new SecureRandom();
    long l2 = localSecureRandom.nextLong();
    long l1 = l2;
    if (l2 == 0L)
    {
      l2 = localSecureRandom.nextLong();
      l1 = l2;
      if (l2 == 0L)
      {
        zzge().zzip().log("Utils falling back to Random for random id");
        l1 = l2;
      }
    }
    this.zzarf.set(l1);
    AppMethodBeat.o(69499);
  }
  
  public final Object zzj(String paramString, Object paramObject)
  {
    AppMethodBeat.i(69523);
    if ("_ldl".equals(paramString))
    {
      paramString = zza(zzch(paramString), paramObject, true);
      AppMethodBeat.o(69523);
      return paramString;
    }
    paramString = zza(zzch(paramString), paramObject, false);
    AppMethodBeat.o(69523);
    return paramString;
  }
  
  public final long zzlb()
  {
    AppMethodBeat.i(69500);
    long l1;
    if (this.zzarf.get() == 0L) {
      synchronized (this.zzarf)
      {
        l1 = new Random(System.nanoTime() ^ zzbt().currentTimeMillis()).nextLong();
        int i = this.zzarg + 1;
        this.zzarg = i;
        long l2 = i;
        AppMethodBeat.o(69500);
        return l1 + l2;
      }
    }
    synchronized (this.zzarf)
    {
      this.zzarf.compareAndSet(-1L, 1L);
      l1 = this.zzarf.getAndIncrement();
      AppMethodBeat.o(69500);
      return l1;
    }
  }
  
  final SecureRandom zzlc()
  {
    AppMethodBeat.i(69501);
    zzab();
    if (this.zzare == null) {
      this.zzare = new SecureRandom();
    }
    SecureRandom localSecureRandom = this.zzare;
    AppMethodBeat.o(69501);
    return localSecureRandom;
  }
  
  public final int zzld()
  {
    AppMethodBeat.i(69555);
    if (this.zzarh == null) {
      this.zzarh = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(getContext()) / 1000);
    }
    int i = this.zzarh.intValue();
    AppMethodBeat.o(69555);
    return i;
  }
  
  final boolean zzq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69505);
    if (paramString2 == null)
    {
      zzge().zzim().zzg("Name is required and can't be null. Type", paramString1);
      AppMethodBeat.o(69505);
      return false;
    }
    if (paramString2.length() == 0)
    {
      zzge().zzim().zzg("Name is required and can't be empty. Type", paramString1);
      AppMethodBeat.o(69505);
      return false;
    }
    int i = paramString2.codePointAt(0);
    if (!Character.isLetter(i))
    {
      zzge().zzim().zze("Name must start with a letter. Type, name", paramString1, paramString2);
      AppMethodBeat.o(69505);
      return false;
    }
    int j = paramString2.length();
    i = Character.charCount(i);
    while (i < j)
    {
      int k = paramString2.codePointAt(i);
      if ((k != 95) && (!Character.isLetterOrDigit(k)))
      {
        zzge().zzim().zze("Name must consist of letters, digits or _ (underscores). Type, name", paramString1, paramString2);
        AppMethodBeat.o(69505);
        return false;
      }
      i += Character.charCount(k);
    }
    AppMethodBeat.o(69505);
    return true;
  }
  
  public final boolean zzx(String paramString)
  {
    AppMethodBeat.i(69536);
    zzab();
    if (Wrappers.packageManager(getContext()).checkCallingOrSelfPermission(paramString) == 0)
    {
      AppMethodBeat.o(69536);
      return true;
    }
    zzge().zzis().zzg("Permission not granted", paramString);
    AppMethodBeat.o(69536);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzka
 * JD-Core Version:    0.7.0.1
 */