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
import com.google.android.gms.common.internal.zzh;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate>
{
  private T zzaRA;
  private Bundle zzaRB;
  private LinkedList<zza> zzaRC;
  private final zze<T> zzaRD = new zza.1(this);
  
  private void zza(Bundle paramBundle, zza paramzza)
  {
    if (this.zzaRA != null)
    {
      paramzza.zzb(this.zzaRA);
      return;
    }
    if (this.zzaRC == null) {
      this.zzaRC = new LinkedList();
    }
    this.zzaRC.add(paramzza);
    if (paramBundle != null)
    {
      if (this.zzaRB != null) {
        break label76;
      }
      this.zzaRB = ((Bundle)paramBundle.clone());
    }
    for (;;)
    {
      zza(this.zzaRD);
      return;
      label76:
      this.zzaRB.putAll(paramBundle);
    }
  }
  
  static void zza(FrameLayout paramFrameLayout, GoogleApiAvailability paramGoogleApiAvailability)
  {
    Context localContext = paramFrameLayout.getContext();
    int i = paramGoogleApiAvailability.isGooglePlayServicesAvailable(localContext);
    String str2 = zzh.zzi(localContext, i);
    String str1 = zzh.zzk(localContext, i);
    LinearLayout localLinearLayout = new LinearLayout(paramFrameLayout.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.addView(localLinearLayout);
    paramFrameLayout = new TextView(paramFrameLayout.getContext());
    paramFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.setText(str2);
    localLinearLayout.addView(paramFrameLayout);
    paramFrameLayout = paramGoogleApiAvailability.zzb(localContext, i, null);
    if (paramFrameLayout != null)
    {
      paramGoogleApiAvailability = new Button(localContext);
      paramGoogleApiAvailability.setId(16908313);
      paramGoogleApiAvailability.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      paramGoogleApiAvailability.setText(str1);
      localLinearLayout.addView(paramGoogleApiAvailability);
      paramGoogleApiAvailability.setOnClickListener(new zza.5(localContext, paramFrameLayout));
    }
  }
  
  public static void zzb(FrameLayout paramFrameLayout)
  {
    zza(paramFrameLayout, GoogleApiAvailability.getInstance());
  }
  
  private void zzgt(int paramInt)
  {
    while ((!this.zzaRC.isEmpty()) && (((zza)this.zzaRC.getLast()).getState() >= paramInt)) {
      this.zzaRC.removeLast();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    zza(paramBundle, new zza.3(this, paramBundle));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramLayoutInflater.getContext());
    zza(paramBundle, new zza.4(this, localFrameLayout, paramLayoutInflater, paramViewGroup, paramBundle));
    if (this.zzaRA == null) {
      zza(localFrameLayout);
    }
    return localFrameLayout;
  }
  
  public void onDestroy()
  {
    if (this.zzaRA != null)
    {
      this.zzaRA.onDestroy();
      return;
    }
    zzgt(1);
  }
  
  public void onDestroyView()
  {
    if (this.zzaRA != null)
    {
      this.zzaRA.onDestroyView();
      return;
    }
    zzgt(2);
  }
  
  public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
  {
    zza(paramBundle2, new zza.2(this, paramActivity, paramBundle1, paramBundle2));
  }
  
  public void onLowMemory()
  {
    if (this.zzaRA != null) {
      this.zzaRA.onLowMemory();
    }
  }
  
  public void onPause()
  {
    if (this.zzaRA != null)
    {
      this.zzaRA.onPause();
      return;
    }
    zzgt(5);
  }
  
  public void onResume()
  {
    zza(null, new zza()
    {
      public int getState()
      {
        return 5;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onResume();
      }
    });
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.zzaRA != null) {
      this.zzaRA.onSaveInstanceState(paramBundle);
    }
    while (this.zzaRB == null) {
      return;
    }
    paramBundle.putAll(this.zzaRB);
  }
  
  public void onStart()
  {
    zza(null, new zza()
    {
      public int getState()
      {
        return 4;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onStart();
      }
    });
  }
  
  public void onStop()
  {
    if (this.zzaRA != null)
    {
      this.zzaRA.onStop();
      return;
    }
    zzgt(4);
  }
  
  public T zzBM()
  {
    return this.zzaRA;
  }
  
  protected void zza(FrameLayout paramFrameLayout)
  {
    zzb(paramFrameLayout);
  }
  
  protected abstract void zza(zze<T> paramzze);
  
  private static abstract interface zza
  {
    public abstract int getState();
    
    public abstract void zzb(LifecycleDelegate paramLifecycleDelegate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.dynamic.zza
 * JD-Core Version:    0.7.0.1
 */