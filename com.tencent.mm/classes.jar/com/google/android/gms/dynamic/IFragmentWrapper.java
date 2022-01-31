package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;

public abstract interface IFragmentWrapper
  extends IInterface
{
  public abstract IObjectWrapper getActivity();
  
  public abstract Bundle getArguments();
  
  public abstract int getId();
  
  public abstract IFragmentWrapper getParentFragment();
  
  public abstract IObjectWrapper getResources();
  
  public abstract boolean getRetainInstance();
  
  public abstract String getTag();
  
  public abstract IFragmentWrapper getTargetFragment();
  
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
  
  public abstract void registerForContextMenu(IObjectWrapper paramIObjectWrapper);
  
  public abstract void setHasOptionsMenu(boolean paramBoolean);
  
  public abstract void setMenuVisibility(boolean paramBoolean);
  
  public abstract void setRetainInstance(boolean paramBoolean);
  
  public abstract void setUserVisibleHint(boolean paramBoolean);
  
  public abstract void startActivity(Intent paramIntent);
  
  public abstract void startActivityForResult(Intent paramIntent, int paramInt);
  
  public abstract void unregisterForContextMenu(IObjectWrapper paramIObjectWrapper);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.dynamic.IFragmentWrapper
 * JD-Core Version:    0.7.0.1
 */