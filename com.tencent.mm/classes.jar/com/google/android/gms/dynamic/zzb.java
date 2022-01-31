package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

@SuppressLint({"NewApi"})
public final class zzb
  extends zzc.zza
{
  private Fragment zzaRK;
  
  private zzb(Fragment paramFragment)
  {
    this.zzaRK = paramFragment;
  }
  
  public static zzb zza(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new zzb(paramFragment);
    }
    return null;
  }
  
  public final Bundle getArguments()
  {
    return this.zzaRK.getArguments();
  }
  
  public final int getId()
  {
    return this.zzaRK.getId();
  }
  
  public final boolean getRetainInstance()
  {
    return this.zzaRK.getRetainInstance();
  }
  
  public final String getTag()
  {
    return this.zzaRK.getTag();
  }
  
  public final int getTargetRequestCode()
  {
    return this.zzaRK.getTargetRequestCode();
  }
  
  public final boolean getUserVisibleHint()
  {
    return this.zzaRK.getUserVisibleHint();
  }
  
  public final IObjectWrapper getView()
  {
    return zzd.zzA(this.zzaRK.getView());
  }
  
  public final boolean isAdded()
  {
    return this.zzaRK.isAdded();
  }
  
  public final boolean isDetached()
  {
    return this.zzaRK.isDetached();
  }
  
  public final boolean isHidden()
  {
    return this.zzaRK.isHidden();
  }
  
  public final boolean isInLayout()
  {
    return this.zzaRK.isInLayout();
  }
  
  public final boolean isRemoving()
  {
    return this.zzaRK.isRemoving();
  }
  
  public final boolean isResumed()
  {
    return this.zzaRK.isResumed();
  }
  
  public final boolean isVisible()
  {
    return this.zzaRK.isVisible();
  }
  
  public final void setHasOptionsMenu(boolean paramBoolean)
  {
    this.zzaRK.setHasOptionsMenu(paramBoolean);
  }
  
  public final void setMenuVisibility(boolean paramBoolean)
  {
    this.zzaRK.setMenuVisibility(paramBoolean);
  }
  
  public final void setRetainInstance(boolean paramBoolean)
  {
    this.zzaRK.setRetainInstance(paramBoolean);
  }
  
  public final void setUserVisibleHint(boolean paramBoolean)
  {
    this.zzaRK.setUserVisibleHint(paramBoolean);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    this.zzaRK.startActivity(paramIntent);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.zzaRK.startActivityForResult(paramIntent, paramInt);
  }
  
  public final IObjectWrapper zzBN()
  {
    return zzd.zzA(this.zzaRK.getActivity());
  }
  
  public final zzc zzBO()
  {
    return zza(this.zzaRK.getParentFragment());
  }
  
  public final IObjectWrapper zzBP()
  {
    return zzd.zzA(this.zzaRK.getResources());
  }
  
  public final zzc zzBQ()
  {
    return zza(this.zzaRK.getTargetFragment());
  }
  
  public final void zzD(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (View)zzd.zzF(paramIObjectWrapper);
    this.zzaRK.registerForContextMenu(paramIObjectWrapper);
  }
  
  public final void zzE(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (View)zzd.zzF(paramIObjectWrapper);
    this.zzaRK.unregisterForContextMenu(paramIObjectWrapper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.dynamic.zzb
 * JD-Core Version:    0.7.0.1
 */