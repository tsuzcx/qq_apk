package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public final class zzg
  extends zzc.zza
{
  private Fragment zzaRN;
  
  private zzg(Fragment paramFragment)
  {
    this.zzaRN = paramFragment;
  }
  
  public static zzg zza(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new zzg(paramFragment);
    }
    return null;
  }
  
  public final Bundle getArguments()
  {
    return this.zzaRN.getArguments();
  }
  
  public final int getId()
  {
    return this.zzaRN.getId();
  }
  
  public final boolean getRetainInstance()
  {
    return this.zzaRN.getRetainInstance();
  }
  
  public final String getTag()
  {
    return this.zzaRN.getTag();
  }
  
  public final int getTargetRequestCode()
  {
    return this.zzaRN.getTargetRequestCode();
  }
  
  public final boolean getUserVisibleHint()
  {
    return this.zzaRN.getUserVisibleHint();
  }
  
  public final IObjectWrapper getView()
  {
    return zzd.zzA(this.zzaRN.getView());
  }
  
  public final boolean isAdded()
  {
    return this.zzaRN.isAdded();
  }
  
  public final boolean isDetached()
  {
    return this.zzaRN.isDetached();
  }
  
  public final boolean isHidden()
  {
    return this.zzaRN.isHidden();
  }
  
  public final boolean isInLayout()
  {
    return this.zzaRN.isInLayout();
  }
  
  public final boolean isRemoving()
  {
    return this.zzaRN.isRemoving();
  }
  
  public final boolean isResumed()
  {
    return this.zzaRN.isResumed();
  }
  
  public final boolean isVisible()
  {
    return this.zzaRN.isVisible();
  }
  
  public final void setHasOptionsMenu(boolean paramBoolean)
  {
    this.zzaRN.setHasOptionsMenu(paramBoolean);
  }
  
  public final void setMenuVisibility(boolean paramBoolean)
  {
    this.zzaRN.setMenuVisibility(paramBoolean);
  }
  
  public final void setRetainInstance(boolean paramBoolean)
  {
    this.zzaRN.setRetainInstance(paramBoolean);
  }
  
  public final void setUserVisibleHint(boolean paramBoolean)
  {
    this.zzaRN.setUserVisibleHint(paramBoolean);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    this.zzaRN.startActivity(paramIntent);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.zzaRN.startActivityForResult(paramIntent, paramInt);
  }
  
  public final IObjectWrapper zzBN()
  {
    return zzd.zzA(this.zzaRN.getActivity());
  }
  
  public final zzc zzBO()
  {
    return zza(this.zzaRN.getParentFragment());
  }
  
  public final IObjectWrapper zzBP()
  {
    return zzd.zzA(this.zzaRN.getResources());
  }
  
  public final zzc zzBQ()
  {
    return zza(this.zzaRN.getTargetFragment());
  }
  
  public final void zzD(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (View)zzd.zzF(paramIObjectWrapper);
    this.zzaRN.registerForContextMenu(paramIObjectWrapper);
  }
  
  public final void zzE(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (View)zzd.zzF(paramIObjectWrapper);
    this.zzaRN.unregisterForContextMenu(paramIObjectWrapper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.dynamic.zzg
 * JD-Core Version:    0.7.0.1
 */