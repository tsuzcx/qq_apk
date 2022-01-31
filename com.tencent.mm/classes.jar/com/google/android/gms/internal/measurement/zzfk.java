package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class zzfk
  extends zzjq
{
  private final SSLSocketFactory zzajg;
  
  public zzfk(zzjr paramzzjr)
  {
    super(paramzzjr);
    AppMethodBeat.i(68904);
    if (Build.VERSION.SDK_INT < 19) {}
    for (paramzzjr = new zzkb();; paramzzjr = null)
    {
      this.zzajg = paramzzjr;
      AppMethodBeat.o(68904);
      return;
    }
  }
  
  private static byte[] zzb(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(68906);
    byte[] arrayOfByte = null;
    Object localObject = arrayOfByte;
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = arrayOfByte;
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      localObject = paramHttpURLConnection;
      arrayOfByte = new byte[1024];
      for (;;)
      {
        localObject = paramHttpURLConnection;
        int i = paramHttpURLConnection.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localObject = paramHttpURLConnection;
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localObject = paramHttpURLConnection;
    }
    finally
    {
      if (localObject != null) {
        ((InputStream)localObject).close();
      }
      AppMethodBeat.o(68906);
    }
    arrayOfByte = localByteArrayOutputStream.toByteArray();
    if (paramHttpURLConnection != null) {
      paramHttpURLConnection.close();
    }
    AppMethodBeat.o(68906);
    return arrayOfByte;
  }
  
  @VisibleForTesting
  protected final HttpURLConnection zzb(URL paramURL)
  {
    AppMethodBeat.i(68907);
    paramURL = paramURL.openConnection();
    if (!(paramURL instanceof HttpURLConnection))
    {
      paramURL = new IOException("Failed to obtain HTTP connection");
      AppMethodBeat.o(68907);
      throw paramURL;
    }
    if ((this.zzajg != null) && ((paramURL instanceof HttpsURLConnection))) {
      ((HttpsURLConnection)paramURL).setSSLSocketFactory(this.zzajg);
    }
    paramURL = (HttpURLConnection)paramURL;
    paramURL.setDefaultUseCaches(false);
    paramURL.setConnectTimeout(60000);
    paramURL.setReadTimeout(61000);
    paramURL.setInstanceFollowRedirects(false);
    paramURL.setDoInput(true);
    AppMethodBeat.o(68907);
    return paramURL;
  }
  
  public final boolean zzex()
  {
    AppMethodBeat.i(68905);
    zzch();
    Object localObject1 = (ConnectivityManager)getContext().getSystemService("connectivity");
    try
    {
      localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
      if ((localObject1 != null) && (((NetworkInfo)localObject1).isConnected()))
      {
        AppMethodBeat.o(68905);
        return true;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
      AppMethodBeat.o(68905);
    }
    return false;
  }
  
  protected final boolean zzhf()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfk
 * JD-Core Version:    0.7.0.1
 */