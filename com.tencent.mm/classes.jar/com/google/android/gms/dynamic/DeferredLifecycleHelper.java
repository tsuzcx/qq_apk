package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.ConnectionErrorMessages;
import java.util.LinkedList;

public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate>
{
  private T zzabc;
  private Bundle zzabd;
  private LinkedList<zza> zzabe;
  private final OnDelegateCreatedListener<T> zzabf = new zza(this);
  
  public static void showGooglePlayUnavailableMessage(FrameLayout paramFrameLayout)
  {
    Object localObject = GoogleApiAvailability.getInstance();
    Context localContext = paramFrameLayout.getContext();
    int i = ((GoogleApiAvailabilityLight)localObject).isGooglePlayServicesAvailable(localContext);
    String str2 = ConnectionErrorMessages.getErrorMessage(localContext, i);
    String str1 = ConnectionErrorMessages.getErrorDialogButtonMessage(localContext, i);
    LinearLayout localLinearLayout = new LinearLayout(paramFrameLayout.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.addView(localLinearLayout);
    paramFrameLayout = new TextView(paramFrameLayout.getContext());
    paramFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.setText(str2);
    localLinearLayout.addView(paramFrameLayout);
    paramFrameLayout = ((GoogleApiAvailabilityLight)localObject).getErrorResolutionIntent(localContext, i, null);
    if (paramFrameLayout != null)
    {
      localObject = new Button(localContext);
      ((Button)localObject).setId(16908313);
      ((Button)localObject).setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      ((Button)localObject).setText(str1);
      localLinearLayout.addView((View)localObject);
      ((Button)localObject).setOnClickListener(new zze(localContext, paramFrameLayout));
    }
  }
  
  private final void zza(Bundle paramBundle, zza paramzza)
  {
    if (this.zzabc != null)
    {
      paramzza.zza(this.zzabc);
      return;
    }
    if (this.zzabe == null) {
      this.zzabe = new LinkedList();
    }
    this.zzabe.add(paramzza);
    if (paramBundle != null)
    {
      if (this.zzabd != null) {
        break label76;
      }
      this.zzabd = ((Bundle)paramBundle.clone());
    }
    for (;;)
    {
      createDelegate(this.zzabf);
      return;
      label76:
      this.zzabd.putAll(paramBundle);
    }
  }
  
  private final void zzm(int paramInt)
  {
    while ((!this.zzabe.isEmpty()) && (((zza)this.zzabe.getLast()).getState() >= paramInt)) {
      this.zzabe.removeLast();
    }
  }
  
  protected abstract void createDelegate(OnDelegateCreatedListener<T> paramOnDelegateCreatedListener);
  
  public T getDelegate()
  {
    return this.zzabc;
  }
  
  protected void handleGooglePlayUnavailable(FrameLayout paramFrameLayout)
  {
    showGooglePlayUnavailableMessage(paramFrameLayout);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    zza(paramBundle, new zzc(this, paramBundle));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramLayoutInflater.getContext());
    zza(paramBundle, new zzd(this, localFrameLayout, paramLayoutInflater, paramViewGroup, paramBundle));
    if (this.zzabc == null) {
      handleGooglePlayUnavailable(localFrameLayout);
    }
    return localFrameLayout;
  }
  
  public void onDestroy()
  {
    if (this.zzabc != null)
    {
      this.zzabc.onDestroy();
      return;
    }
    zzm(1);
  }
  
  public void onDestroyView()
  {
    if (this.zzabc != null)
    {
      this.zzabc.onDestroyView();
      return;
    }
    zzm(2);
  }
  
  public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
  {
    zza(paramBundle2, new zzb(this, paramActivity, paramBundle1, paramBundle2));
  }
  
  public void onLowMemory()
  {
    if (this.zzabc != null) {
      this.zzabc.onLowMemory();
    }
  }
  
  public void onPause()
  {
    if (this.zzabc != null)
    {
      this.zzabc.onPause();
      return;
    }
    zzm(5);
  }
  
  public void onResume()
  {
    zza(null, new zzg(this));
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.zzabc != null) {
      this.zzabc.onSaveInstanceState(paramBundle);
    }
    while (this.zzabd == null) {
      return;
    }
    paramBundle.putAll(this.zzabd);
  }
  
  public void onStart()
  {
    zza(null, new zzf(this));
  }
  
  public void onStop()
  {
    if (this.zzabc != null)
    {
      this.zzabc.onStop();
      return;
    }
    zzm(4);
  }
  
  static abstract interface zza
  {
    public abstract int getState();
    
    public abstract void zza(LifecycleDelegate paramLifecycleDelegate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.dynamic.DeferredLifecycleHelper
 * JD-Core Version:    0.7.0.1
 */