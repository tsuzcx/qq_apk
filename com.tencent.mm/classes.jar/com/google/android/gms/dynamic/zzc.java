package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;

public abstract interface zzc
  extends IInterface
{
  public abstract Bundle getArguments();
  
  public abstract int getId();
  
  public abstract boolean getRetainInstance();
  
  public abstract String getTag();
  
  public abstract int getTargetRequestCode();
  
  public abstract boolean getUserVisibleHint();
  
  public abstract IObjectWrapper getView();
  
  public abstract boolean isAdded();
  
  public abstract boolean isDetached();
  
  public abstract boolean isHidden();
  
  public abstract boolean isInLayout();
  
  public abstract boolean isRemoving();
  
  public abstract boolean isResumed();
  
  public abstract boolean isVisible();
  
  public abstract void setHasOptionsMenu(boolean paramBoolean);
  
  public abstract void setMenuVisibility(boolean paramBoolean);
  
  public abstract void setRetainInstance(boolean paramBoolean);
  
  public abstract void setUserVisibleHint(boolean paramBoolean);
  
  public abstract void startActivity(Intent paramIntent);
  
  public abstract void startActivityForResult(Intent paramIntent, int paramInt);
  
  public abstract IObjectWrapper zzBN();
  
  public abstract zzc zzBO();
  
  public abstract IObjectWrapper zzBP();
  
  public abstract zzc zzBQ();
  
  public abstract void zzD(IObjectWrapper paramIObjectWrapper);
  
  public abstract void zzE(IObjectWrapper paramIObjectWrapper);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.dynamic.zzc
 * JD-Core Version:    0.7.0.1
 */