package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.concurrent.Callable;

final class zzhh
  implements Callable<Boolean>
{
  zzhh(zzhg paramzzhg, ParcelFileDescriptor paramParcelFileDescriptor, byte[] paramArrayOfByte) {}
  
  private final Boolean zzd()
  {
    AppMethodBeat.i(101397);
    if (Log.isLoggable("WearableClient", 3))
    {
      localObject1 = String.valueOf(this.zzfg);
      new StringBuilder(String.valueOf(localObject1).length() + 36).append("processAssets: writing data to FD : ").append((String)localObject1);
    }
    localObject1 = new ParcelFileDescriptor.AutoCloseOutputStream(this.zzfg);
    try
    {
      ((ParcelFileDescriptor.AutoCloseOutputStream)localObject1).write(this.zzee);
      ((ParcelFileDescriptor.AutoCloseOutputStream)localObject1).flush();
      if (Log.isLoggable("WearableClient", 3))
      {
        localObject2 = String.valueOf(this.zzfg);
        new StringBuilder(String.valueOf(localObject2).length() + 27).append("processAssets: wrote data: ").append((String)localObject2);
      }
      localObject2 = Boolean.TRUE;
    }
    catch (IOException localIOException4)
    {
      Object localObject2;
      label169:
      String str1 = String.valueOf(this.zzfg);
      new StringBuilder(String.valueOf(str1).length() + 36).append("processAssets: writing data failed: ").append(str1);
      try
      {
        if (Log.isLoggable("WearableClient", 3))
        {
          str1 = String.valueOf(this.zzfg);
          new StringBuilder(String.valueOf(str1).length() + 24).append("processAssets: closing: ").append(str1);
        }
        ((ParcelFileDescriptor.AutoCloseOutputStream)localObject1).close();
      }
      catch (IOException localIOException2)
      {
        break label260;
      }
      localObject1 = Boolean.FALSE;
      AppMethodBeat.o(101397);
      return localObject1;
    }
    finally
    {
      try
      {
        String str2;
        if (Log.isLoggable("WearableClient", 3))
        {
          str2 = String.valueOf(this.zzfg);
          new StringBuilder(String.valueOf(str2).length() + 24).append("processAssets: closing: ").append(str2);
        }
        ((ParcelFileDescriptor.AutoCloseOutputStream)localObject1).close();
      }
      catch (IOException localIOException1)
      {
        break label320;
      }
      AppMethodBeat.o(101397);
    }
    try
    {
      if (Log.isLoggable("WearableClient", 3))
      {
        str2 = String.valueOf(this.zzfg);
        new StringBuilder(String.valueOf(str2).length() + 24).append("processAssets: closing: ").append(str2);
      }
      ((ParcelFileDescriptor.AutoCloseOutputStream)localObject1).close();
    }
    catch (IOException localIOException3)
    {
      break label169;
    }
    AppMethodBeat.o(101397);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzhh
 * JD-Core Version:    0.7.0.1
 */