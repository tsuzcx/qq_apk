package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaad.zzb;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

class zzcx$2
  implements Runnable
{
  zzcx$2(zzcx paramzzcx, Uri paramUri, zzaad.zzb paramzzb, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    Log.isLoggable("WearableClient", 2);
    if (!"file".equals(this.zzbBz.getScheme()))
    {
      this.zzbVh.zzB(new Status(10, "Channel.receiveFile used with non-file URI"));
      return;
    }
    File localFile = new File(this.zzbBz.getPath());
    int i;
    if (this.zzbUc) {
      i = 33554432;
    }
    try
    {
      localParcelFileDescriptor = ParcelFileDescriptor.open(localFile, i | 0x28000000);
    }
    catch (FileNotFoundException localRemoteException)
    {
      try
      {
        for (;;)
        {
          ParcelFileDescriptor localParcelFileDescriptor;
          ((zzbw)this.zzbVi.zzxD()).zza(new zzcw.zzu(this.zzbVh), this.zzaiD, localParcelFileDescriptor);
          try
          {
            localParcelFileDescriptor.close();
            return;
          }
          catch (IOException localIOException1)
          {
            return;
          }
          i = 0;
        }
      }
      catch (RemoteException localRemoteException)
      {
        String str;
        localRemoteException = localRemoteException;
        this.zzbVh.zzB(new Status(8));
        try
        {
          str.close();
          return;
        }
        catch (IOException localIOException2)
        {
          return;
        }
      }
      finally {}
      localFileNotFoundException = localFileNotFoundException;
      str = String.valueOf(localFile);
      new StringBuilder(String.valueOf(str).length() + 49).append("File couldn't be opened for Channel.receiveFile: ").append(str);
      this.zzbVh.zzB(new Status(13));
      return;
    }
    try
    {
      localIOException2.close();
      label203:
      throw localObject;
    }
    catch (IOException localIOException3)
    {
      break label203;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcx.2
 * JD-Core Version:    0.7.0.1
 */