package com.google.android.gms.common.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract interface ICertData
  extends IInterface
{
  public abstract IObjectWrapper getBytesWrapped();
  
  public abstract int getHashCode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.internal.ICertData
 * JD-Core Version:    0.7.0.1
 */