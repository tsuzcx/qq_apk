package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

public abstract interface ContainerHolder
  extends Releasable, Result
{
  public abstract Container getContainer();
  
  public abstract void refresh();
  
  public abstract void setContainerAvailableListener(ContainerHolder.ContainerAvailableListener paramContainerAvailableListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ContainerHolder
 * JD-Core Version:    0.7.0.1
 */