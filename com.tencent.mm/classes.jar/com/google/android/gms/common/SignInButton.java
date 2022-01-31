package com.google.android.gms.common;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzaj;
import com.google.android.gms.common.internal.zzak;
import com.google.android.gms.dynamic.zzf.zza;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton
  extends FrameLayout
  implements View.OnClickListener
{
  public static final int COLOR_AUTO = 2;
  public static final int COLOR_DARK = 0;
  public static final int COLOR_LIGHT = 1;
  public static final int SIZE_ICON_ONLY = 2;
  public static final int SIZE_STANDARD = 0;
  public static final int SIZE_WIDE = 1;
  private int mColor;
  private int mSize;
  private View zzayF;
  private View.OnClickListener zzayG = null;
  
  public SignInButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    zzb(paramContext, paramAttributeSet);
    setStyle(this.mSize, this.mColor);
  }
  
  private void zzaO(Context paramContext)
  {
    if (this.zzayF != null) {
      removeView(this.zzayF);
    }
    try
    {
      this.zzayF = zzaj.zzd(paramContext, this.mSize, this.mColor);
      addView(this.zzayF);
      this.zzayF.setEnabled(isEnabled());
      this.zzayF.setOnClickListener(this);
      return;
    }
    catch (zzf.zza localzza)
    {
      for (;;)
      {
        this.zzayF = zzc(paramContext, this.mSize, this.mColor);
      }
    }
  }
  
  private void zzb(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.SignInButton, 0, 0);
    try
    {
      this.mSize = paramContext.getInt(R.styleable.SignInButton_buttonSize, 0);
      this.mColor = paramContext.getInt(R.styleable.SignInButton_colorScheme, 2);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private static Button zzc(Context paramContext, int paramInt1, int paramInt2)
  {
    zzak localzzak = new zzak(paramContext);
    localzzak.zza(paramContext.getResources(), paramInt1, paramInt2);
    return localzzak;
  }
  
  public final void onClick(View paramView)
  {
    if ((this.zzayG != null) && (paramView == this.zzayF)) {
      this.zzayG.onClick(this);
    }
  }
  
  public final void setColorScheme(int paramInt)
  {
    setStyle(this.mSize, paramInt);
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.zzayF.setEnabled(paramBoolean);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.zzayG = paramOnClickListener;
    if (this.zzayF != null) {
      this.zzayF.setOnClickListener(this);
    }
  }
  
  @Deprecated
  public final void setScopes(Scope[] paramArrayOfScope)
  {
    setStyle(this.mSize, this.mColor);
  }
  
  public final void setSize(int paramInt)
  {
    setStyle(paramInt, this.mColor);
  }
  
  public final void setStyle(int paramInt1, int paramInt2)
  {
    this.mSize = paramInt1;
    this.mColor = paramInt2;
    zzaO(getContext());
  }
  
  @Deprecated
  public final void setStyle(int paramInt1, int paramInt2, Scope[] paramArrayOfScope)
  {
    setStyle(paramInt1, paramInt2);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ButtonSize {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.SignInButton
 * JD-Core Version:    0.7.0.1
 */