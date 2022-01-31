package com.google.android.gms.common.util;

import android.os.ParcelFileDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class zzp
{
  public static long zza(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    return zza(paramInputStream, paramOutputStream, false);
  }
  
  public static long zza(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean)
  {
    return zza(paramInputStream, paramOutputStream, paramBoolean, 1024);
  }
  
  public static long zza(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    long l = 0L;
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte, 0, paramInt);
        if (i == -1) {
          break;
        }
        l += i;
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      if (!paramBoolean) {
        break label73;
      }
    }
    finally
    {
      if (paramBoolean)
      {
        zzb(paramInputStream);
        zzb(paramOutputStream);
      }
    }
    zzb(paramInputStream);
    zzb(paramOutputStream);
    label73:
    return l;
  }
  
  public static void zza(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor != null) {}
    try
    {
      paramParcelFileDescriptor.close();
      return;
    }
    catch (IOException paramParcelFileDescriptor) {}
  }
  
  public static byte[] zza(InputStream paramInputStream, boolean paramBoolean)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    zza(paramInputStream, localByteArrayOutputStream, paramBoolean);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static void zzb(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static byte[] zzj(InputStream paramInputStream)
  {
    return zza(paramInputStream, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.util.zzp
 * JD-Core Version:    0.7.0.1
 */