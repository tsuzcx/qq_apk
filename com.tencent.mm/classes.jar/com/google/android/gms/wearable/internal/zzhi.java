package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

final class zzhi
  implements Runnable
{
  zzhi(zzhg paramzzhg, Uri paramUri, BaseImplementation.ResultHolder paramResultHolder, boolean paramBoolean, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(101399);
    Log.isLoggable("WearableClient", 2);
    if (!"file".equals(this.zzco.getScheme()))
    {
      this.zzfh.setFailedResult(new Status(10, "Channel.receiveFile used with non-file URI"));
      AppMethodBeat.o(101399);
      return;
    }
    File localFile = new File(this.zzco.getPath());
    int i;
    if (this.zzcp) {
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
          ((zzep)this.zzfi.getService()).zza(new zzhf(this.zzfh), this.zzcs, localParcelFileDescriptor);
          try
          {
            localParcelFileDescriptor.close();
            AppMethodBeat.o(101399);
            return;
          }
          catch (IOException localIOException1)
          {
            String str;
            AppMethodBeat.o(101399);
            return;
          }
          i = 0;
        }
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException = localRemoteException;
        this.zzfh.setFailedResult(new Status(8));
        try
        {
          localIOException1.close();
          AppMethodBeat.o(101399);
          return;
        }
        catch (IOException localIOException2)
        {
          AppMethodBeat.o(101399);
          return;
        }
      }
      finally {}
      localFileNotFoundException = localFileNotFoundException;
      str = String.valueOf(localFile);
      new StringBuilder(String.valueOf(str).length() + 49).append("File couldn't be opened for Channel.receiveFile: ").append(str);
      this.zzfh.setFailedResult(new Status(13));
      AppMethodBeat.o(101399);
      return;
    }
    try
    {
      localIOException2.close();
      label238:
      AppMethodBeat.o(101399);
      throw localObject;
    }
    catch (IOException localIOException3)
    {
      break label238;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzhi
 * JD-Core Version:    0.7.0.1
 */