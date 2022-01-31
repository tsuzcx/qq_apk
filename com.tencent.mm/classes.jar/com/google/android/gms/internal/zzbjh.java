package com.google.android.gms.internal;

import com.google.android.gms.tagmanager.zzbo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class zzbjh
  implements zzbji
{
  private HttpURLConnection zzbMt;
  private InputStream zzbMu = null;
  
  private InputStream zzd(HttpURLConnection paramHttpURLConnection)
  {
    int i = paramHttpURLConnection.getResponseCode();
    if (i == 200) {
      return paramHttpURLConnection.getInputStream();
    }
    paramHttpURLConnection = 25 + "Bad response: " + i;
    if (i == 404) {
      throw new FileNotFoundException(paramHttpURLConnection);
    }
    if (i == 503) {
      throw new zzbjk(paramHttpURLConnection);
    }
    throw new IOException(paramHttpURLConnection);
  }
  
  private void zze(HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      if (this.zzbMu != null) {
        this.zzbMu.close();
      }
      if (paramHttpURLConnection != null) {
        paramHttpURLConnection.disconnect();
      }
      return;
    }
    catch (IOException localIOException)
    {
      str = String.valueOf(localIOException.getMessage());
      if (str.length() == 0) {}
    }
    for (String str = "HttpUrlConnectionNetworkClient: Error when closing http input stream: ".concat(str);; str = new String("HttpUrlConnectionNetworkClient: Error when closing http input stream: "))
    {
      zzbo.zzb(str, localIOException);
      break;
    }
  }
  
  public void close()
  {
    zze(this.zzbMt);
  }
  
  public InputStream zzhX(String paramString)
  {
    this.zzbMt = zzhY(paramString);
    this.zzbMu = zzd(this.zzbMt);
    return this.zzbMu;
  }
  
  HttpURLConnection zzhY(String paramString)
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setReadTimeout(20000);
    paramString.setConnectTimeout(20000);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzbjh
 * JD-Core Version:    0.7.0.1
 */