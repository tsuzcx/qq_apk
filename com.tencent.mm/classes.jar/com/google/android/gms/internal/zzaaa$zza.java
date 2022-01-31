package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class zzaaa$zza
  implements GoogleApiClient.OnConnectionFailedListener
{
  public final int zzazO;
  public final GoogleApiClient zzazP;
  public final GoogleApiClient.OnConnectionFailedListener zzazQ;
  
  public zzaaa$zza(zzaaa paramzzaaa, int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.zzazO = paramInt;
    this.zzazP = paramGoogleApiClient;
    this.zzazQ = paramOnConnectionFailedListener;
    paramGoogleApiClient.registerConnectionFailedListener(this);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("GoogleApiClient #").print(this.zzazO);
    paramPrintWriter.println(":");
    this.zzazP.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    String str = String.valueOf(paramConnectionResult);
    new StringBuilder(String.valueOf(str).length() + 27).append("beginFailureResolution for ").append(str);
    this.zzazR.zzb(paramConnectionResult, this.zzazO);
  }
  
  public void zzvy()
  {
    this.zzazP.unregisterConnectionFailedListener(this);
    this.zzazP.disconnect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzaaa.zza
 * JD-Core Version:    0.7.0.1
 */