package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.a.a.a;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.Button;
import com.google.android.gms.R.color;
import com.google.android.gms.R.drawable;
import com.google.android.gms.R.string;

public final class zzak
  extends Button
{
  public zzak(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public zzak(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 16842824);
  }
  
  private void zza(Resources paramResources)
  {
    setTypeface(Typeface.DEFAULT_BOLD);
    setTextSize(14.0F);
    float f = paramResources.getDisplayMetrics().density;
    setMinHeight((int)(f * 48.0F + 0.5F));
    setMinWidth((int)(f * 48.0F + 0.5F));
  }
  
  private void zzb(Resources paramResources, int paramInt1, int paramInt2)
  {
    Drawable localDrawable = a.f(paramResources.getDrawable(zze(paramInt1, zzg(paramInt2, R.drawable.common_google_signin_btn_icon_dark, R.drawable.common_google_signin_btn_icon_light, R.drawable.common_google_signin_btn_icon_light), zzg(paramInt2, R.drawable.common_google_signin_btn_text_dark, R.drawable.common_google_signin_btn_text_light, R.drawable.common_google_signin_btn_text_light))));
    a.a(localDrawable, paramResources.getColorStateList(R.color.common_google_signin_btn_tint));
    a.a(localDrawable, PorterDuff.Mode.SRC_ATOP);
    setBackgroundDrawable(localDrawable);
  }
  
  private void zzc(Resources paramResources, int paramInt1, int paramInt2)
  {
    setTextColor((ColorStateList)zzac.zzw(paramResources.getColorStateList(zzg(paramInt2, R.color.common_google_signin_btn_text_dark, R.color.common_google_signin_btn_text_light, R.color.common_google_signin_btn_text_light))));
    switch (paramInt1)
    {
    default: 
      throw new IllegalStateException(32 + "Unknown button size: " + paramInt1);
    case 0: 
      setText(paramResources.getString(R.string.common_signin_button_text));
    }
    for (;;)
    {
      setTransformationMethod(null);
      return;
      setText(paramResources.getString(R.string.common_signin_button_text_long));
      continue;
      setText(null);
    }
  }
  
  private int zze(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    default: 
      throw new IllegalStateException(32 + "Unknown button size: " + paramInt1);
    case 2: 
      paramInt3 = paramInt2;
    }
    return paramInt3;
  }
  
  private int zzg(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    switch (paramInt1)
    {
    default: 
      throw new IllegalStateException(33 + "Unknown color scheme: " + paramInt1);
    case 1: 
      paramInt2 = paramInt3;
    case 0: 
      return paramInt2;
    }
    return paramInt4;
  }
  
  public final void zza(Resources paramResources, int paramInt1, int paramInt2)
  {
    zza(paramResources);
    zzb(paramResources, paramInt1, paramInt2);
    zzc(paramResources, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzak
 * JD-Core Version:    0.7.0.1
 */