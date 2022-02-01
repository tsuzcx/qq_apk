package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;

@KeepForSdk
public abstract interface StatusExceptionMapper
{
  public abstract Exception getException(Status paramStatus);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.StatusExceptionMapper
 * JD-Core Version:    0.7.0.1
 */