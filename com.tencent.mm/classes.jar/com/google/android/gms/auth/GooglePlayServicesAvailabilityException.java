package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException
  extends UserRecoverableAuthException
{
  private final int zzx;
  
  GooglePlayServicesAvailabilityException(int paramInt, String paramString, Intent paramIntent)
  {
    super(paramString, paramIntent);
    this.zzx = paramInt;
  }
  
  public int getConnectionStatusCode()
  {
    return this.zzx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.GooglePlayServicesAvailabilityException
 * JD-Core Version:    0.7.0.1
 */