package com.google.android.gms.common;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.base.R.styleable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonCreator;
import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
  private View zzbw;
  private View.OnClickListener zzbx;
  
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
    AppMethodBeat.i(10955);
    this.zzbx = null;
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.SignInButton, 0, 0);
    try
    {
      this.mSize = paramContext.getInt(0, 0);
      this.mColor = paramContext.getInt(1, 2);
      paramContext.recycle();
      setStyle(this.mSize, this.mColor);
      AppMethodBeat.o(10955);
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(10955);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(10963);
    if ((this.zzbx != null) && (paramView == this.zzbw)) {
      this.zzbx.onClick(this);
    }
    AppMethodBeat.o(10963);
  }
  
  public final void setColorScheme(int paramInt)
  {
    AppMethodBeat.i(10957);
    setStyle(this.mSize, paramInt);
    AppMethodBeat.o(10957);
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(10962);
    super.setEnabled(paramBoolean);
    this.zzbw.setEnabled(paramBoolean);
    AppMethodBeat.o(10962);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(10961);
    this.zzbx = paramOnClickListener;
    if (this.zzbw != null) {
      this.zzbw.setOnClickListener(this);
    }
    AppMethodBeat.o(10961);
  }
  
  @Deprecated
  public final void setScopes(Scope[] paramArrayOfScope)
  {
    AppMethodBeat.i(10958);
    setStyle(this.mSize, this.mColor);
    AppMethodBeat.o(10958);
  }
  
  public final void setSize(int paramInt)
  {
    AppMethodBeat.i(10956);
    setStyle(paramInt, this.mColor);
    AppMethodBeat.o(10956);
  }
  
  public final void setStyle(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10959);
    this.mSize = paramInt1;
    this.mColor = paramInt2;
    Context localContext = getContext();
    if (this.zzbw != null) {
      removeView(this.zzbw);
    }
    try
    {
      this.zzbw = SignInButtonCreator.createView(localContext, this.mSize, this.mColor);
      addView(this.zzbw);
      this.zzbw.setEnabled(isEnabled());
      this.zzbw.setOnClickListener(this);
      AppMethodBeat.o(10959);
      return;
    }
    catch (RemoteCreator.RemoteCreatorException localRemoteCreatorException)
    {
      for (;;)
      {
        paramInt1 = this.mSize;
        paramInt2 = this.mColor;
        SignInButtonImpl localSignInButtonImpl = new SignInButtonImpl(localContext);
        localSignInButtonImpl.configure(localContext.getResources(), paramInt1, paramInt2);
        this.zzbw = localSignInButtonImpl;
      }
    }
  }
  
  @Deprecated
  public final void setStyle(int paramInt1, int paramInt2, Scope[] paramArrayOfScope)
  {
    AppMethodBeat.i(10960);
    setStyle(paramInt1, paramInt2);
    AppMethodBeat.o(10960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.SignInButton
 * JD-Core Version:    0.7.0.1
 */