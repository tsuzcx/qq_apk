package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.a;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.Button;
import com.google.android.gms.common.util.DeviceProperties;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SignInButtonImpl
  extends Button
{
  public SignInButtonImpl(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SignInButtonImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 16842824);
  }
  
  private static int zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(61385);
    switch (paramInt1)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException(33 + "Unknown color scheme: " + paramInt1);
      AppMethodBeat.o(61385);
      throw localIllegalStateException;
    case 0: 
      AppMethodBeat.o(61385);
      return paramInt2;
    case 1: 
      AppMethodBeat.o(61385);
      return paramInt3;
    }
    AppMethodBeat.o(61385);
    return paramInt4;
  }
  
  public final void configure(Resources paramResources, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61384);
    setTypeface(Typeface.DEFAULT_BOLD);
    setTextSize(14.0F);
    float f = paramResources.getDisplayMetrics().density;
    setMinHeight((int)(f * 48.0F + 0.5F));
    setMinWidth((int)(f * 48.0F + 0.5F));
    int j = zza(paramInt2, 2130838449, 2130838454, 2130838454);
    int i = zza(paramInt2, 2130838458, 2130838463, 2130838463);
    switch (paramInt1)
    {
    default: 
      paramResources = new IllegalStateException(32 + "Unknown button size: " + paramInt1);
      AppMethodBeat.o(61384);
      throw paramResources;
    case 2: 
      i = j;
    }
    Drawable localDrawable = a.e(paramResources.getDrawable(i));
    a.a(localDrawable, paramResources.getColorStateList(2131690747));
    a.a(localDrawable, PorterDuff.Mode.SRC_ATOP);
    setBackgroundDrawable(localDrawable);
    setTextColor((ColorStateList)Preconditions.checkNotNull(paramResources.getColorStateList(zza(paramInt2, 2131690745, 2131690746, 2131690746))));
    switch (paramInt1)
    {
    default: 
      paramResources = new IllegalStateException(32 + "Unknown button size: " + paramInt1);
      AppMethodBeat.o(61384);
      throw paramResources;
    case 0: 
      setText(paramResources.getString(2131296302));
    }
    for (;;)
    {
      setTransformationMethod(null);
      if (DeviceProperties.isWearable(getContext())) {
        setGravity(19);
      }
      AppMethodBeat.o(61384);
      return;
      setText(paramResources.getString(2131296303));
      continue;
      setText(null);
    }
  }
  
  public final void configure(Resources paramResources, SignInButtonConfig paramSignInButtonConfig)
  {
    AppMethodBeat.i(61383);
    configure(paramResources, paramSignInButtonConfig.getButtonSize(), paramSignInButtonConfig.getColorScheme());
    AppMethodBeat.o(61383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.SignInButtonImpl
 * JD-Core Version:    0.7.0.1
 */