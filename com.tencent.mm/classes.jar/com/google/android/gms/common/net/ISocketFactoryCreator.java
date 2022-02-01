package com.google.android.gms.common.net;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract interface ISocketFactoryCreator
  extends IInterface
{
  public abstract IObjectWrapper newSocketFactory(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3, boolean paramBoolean);
  
  public abstract IObjectWrapper newSocketFactoryWithCacheDir(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.net.ISocketFactoryCreator
 * JD-Core Version:    0.7.0.1
 */