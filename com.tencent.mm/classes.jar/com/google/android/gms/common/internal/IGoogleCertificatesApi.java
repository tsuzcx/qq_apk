package com.google.android.gms.common.internal;

import android.os.IInterface;
import com.google.android.gms.common.GoogleCertificatesQuery;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract interface IGoogleCertificatesApi
  extends IInterface
{
  public abstract IObjectWrapper getGoogleCertificates();
  
  public abstract IObjectWrapper getGoogleReleaseCertificates();
  
  public abstract boolean isGoogleOrPlatformSigned(GoogleCertificatesQuery paramGoogleCertificatesQuery, IObjectWrapper paramIObjectWrapper);
  
  public abstract boolean isGoogleReleaseSigned(String paramString, IObjectWrapper paramIObjectWrapper);
  
  public abstract boolean isGoogleSigned(String paramString, IObjectWrapper paramIObjectWrapper);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.internal.IGoogleCertificatesApi
 * JD-Core Version:    0.7.0.1
 */