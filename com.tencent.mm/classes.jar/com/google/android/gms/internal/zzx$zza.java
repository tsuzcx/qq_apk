package com.google.android.gms.internal;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public final class zzx$zza
  extends HttpEntityEnclosingRequestBase
{
  public zzx$zza() {}
  
  public zzx$zza(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public final String getMethod()
  {
    return "PATCH";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzx.zza
 * JD-Core Version:    0.7.0.1
 */