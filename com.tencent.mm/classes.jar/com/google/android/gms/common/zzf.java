package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzt.zza;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.util.zzn;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamite.DynamiteModule.zza;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

class zzf
{
  private static zzw zzayp;
  private static final Object zzayq = new Object();
  private static Context zzayr;
  
  static boolean zza(String paramString, zza paramzza)
  {
    if (!zzuZ()) {
      return false;
    }
    try
    {
      boolean bool = zzayp.zze(paramString, paramzza.zzva());
      return bool;
    }
    catch (RemoteException paramString) {}
    return false;
  }
  
  static void zzaG(Context paramContext)
  {
    try
    {
      if ((zzayr == null) && (paramContext != null)) {
        zzayr = paramContext.getApplicationContext();
      }
      return;
    }
    finally {}
  }
  
  static boolean zzb(String paramString, zza paramzza)
  {
    if (!zzuZ()) {
      return false;
    }
    try
    {
      boolean bool = zzayp.zzf(paramString, paramzza.zzva());
      return bool;
    }
    catch (RemoteException paramString) {}
    return false;
  }
  
  private static boolean zzuZ()
  {
    if (zzayp != null) {
      return true;
    }
    zzac.zzw(zzayr);
    synchronized (zzayq)
    {
      zzw localzzw = zzayp;
      if (localzzw != null) {}
    }
    return false;
  }
  
  static abstract class zza
    extends zzt.zza
  {
    private int zzays;
    
    protected zza(byte[] paramArrayOfByte)
    {
      Object localObject = paramArrayOfByte;
      if (paramArrayOfByte.length != 25)
      {
        int i = paramArrayOfByte.length;
        localObject = String.valueOf(zzn.zza(paramArrayOfByte, 0, paramArrayOfByte.length, false));
        Log.wtf("GoogleCertificates", String.valueOf(localObject).length() + 51 + "Cert hash data has incorrect length (" + i + "):\n" + (String)localObject, new Exception());
        localObject = Arrays.copyOfRange(paramArrayOfByte, 0, 25);
        if (localObject.length == 25) {
          bool = true;
        }
        i = localObject.length;
        zzac.zzb(bool, 55 + "cert hash data has incorrect length. length=" + i);
      }
      this.zzays = Arrays.hashCode((byte[])localObject);
    }
    
    protected static byte[] zzdc(String paramString)
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
      if ((paramObject == null) || (!(paramObject instanceof zzt))) {
        return false;
      }
      try
      {
        paramObject = (zzt)paramObject;
        if (paramObject.zzvb() != hashCode()) {
          return false;
        }
        paramObject = paramObject.zzva();
        if (paramObject == null) {
          return false;
        }
        paramObject = (byte[])zzd.zzF(paramObject);
        boolean bool = Arrays.equals(getBytes(), paramObject);
        return bool;
      }
      catch (RemoteException paramObject) {}
      return false;
    }
    
    abstract byte[] getBytes();
    
    public int hashCode()
    {
      return this.zzays;
    }
    
    public IObjectWrapper zzva()
    {
      return zzd.zzA(getBytes());
    }
    
    public int zzvb()
    {
      return hashCode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.zzf
 * JD-Core Version:    0.7.0.1
 */