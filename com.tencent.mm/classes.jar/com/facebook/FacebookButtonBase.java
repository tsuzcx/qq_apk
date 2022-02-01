package com.facebook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.core.content.a;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.common.R.color;
import com.facebook.common.R.style;
import com.facebook.internal.FragmentWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class FacebookButtonBase
  extends Button
{
  private String analyticsButtonCreatedEventName;
  private String analyticsButtonTappedEventName;
  private View.OnClickListener externalOnClickListener;
  private View.OnClickListener internalOnClickListener;
  private boolean overrideCompoundPadding;
  private int overrideCompoundPaddingLeft;
  private int overrideCompoundPaddingRight;
  private FragmentWrapper parentFragment;
  
  protected FacebookButtonBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    super(paramContext, paramAttributeSet, 0);
    if (paramInt2 == 0) {
      paramInt2 = getDefaultStyleResource();
    }
    for (;;)
    {
      int i = paramInt2;
      if (paramInt2 == 0) {
        i = R.style.com_facebook_button;
      }
      configureButton(paramContext, paramAttributeSet, paramInt1, i);
      this.analyticsButtonCreatedEventName = paramString1;
      this.analyticsButtonTappedEventName = paramString2;
      setClickable(true);
      setFocusable(true);
      return;
    }
  }
  
  private void logButtonCreated(Context paramContext)
  {
    AppEventsLogger.newLogger(paramContext).logSdkEvent(this.analyticsButtonCreatedEventName, null, null);
  }
  
  private void logButtonTapped(Context paramContext)
  {
    AppEventsLogger.newLogger(paramContext).logSdkEvent(this.analyticsButtonTappedEventName, null, null);
  }
  
  private void parseBackgroundAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    if (isInEditMode()) {
      return;
    }
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, new int[] { 16842964 }, paramInt1, paramInt2);
    for (;;)
    {
      try
      {
        if (paramAttributeSet.hasValue(0))
        {
          paramInt1 = paramAttributeSet.getResourceId(0, 0);
          if (paramInt1 != 0)
          {
            setBackgroundResource(paramInt1);
            return;
          }
          setBackgroundColor(paramAttributeSet.getColor(0, 0));
          continue;
        }
        setBackgroundColor(a.w(paramContext, R.color.com_facebook_blue));
      }
      finally
      {
        paramAttributeSet.recycle();
      }
    }
  }
  
  @SuppressLint({"ResourceType"})
  private void parseCompoundDrawableAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, new int[] { 16843119, 16843117, 16843120, 16843118, 16843121 }, paramInt1, paramInt2);
    try
    {
      setCompoundDrawablesWithIntrinsicBounds(paramContext.getResourceId(0, 0), paramContext.getResourceId(1, 0), paramContext.getResourceId(2, 0), paramContext.getResourceId(3, 0));
      setCompoundDrawablePadding(paramContext.getDimensionPixelSize(4, 0));
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void parseContentAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, new int[] { 16842966, 16842967, 16842968, 16842969 }, paramInt1, paramInt2);
    try
    {
      setPadding(paramContext.getDimensionPixelSize(0, 0), paramContext.getDimensionPixelSize(1, 0), paramContext.getDimensionPixelSize(2, 0), paramContext.getDimensionPixelSize(3, 0));
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  /* Error */
  private void parseTextAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 84	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   4: aload_2
    //   5: iconst_1
    //   6: newarray int
    //   8: dup
    //   9: iconst_0
    //   10: ldc 156
    //   12: iastore
    //   13: iload_3
    //   14: iload 4
    //   16: invokevirtual 91	android/content/res/Resources$Theme:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   19: astore 5
    //   21: aload_0
    //   22: aload 5
    //   24: iconst_0
    //   25: invokevirtual 160	android/content/res/TypedArray:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   28: invokevirtual 164	com/facebook/FacebookButtonBase:setTextColor	(Landroid/content/res/ColorStateList;)V
    //   31: aload 5
    //   33: invokevirtual 109	android/content/res/TypedArray:recycle	()V
    //   36: aload_1
    //   37: invokevirtual 84	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   40: aload_2
    //   41: iconst_1
    //   42: newarray int
    //   44: dup
    //   45: iconst_0
    //   46: ldc 165
    //   48: iastore
    //   49: iload_3
    //   50: iload 4
    //   52: invokevirtual 91	android/content/res/Resources$Theme:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   55: astore 5
    //   57: aload_0
    //   58: aload 5
    //   60: iconst_0
    //   61: bipush 17
    //   63: invokevirtual 168	android/content/res/TypedArray:getInt	(II)I
    //   66: invokevirtual 171	com/facebook/FacebookButtonBase:setGravity	(I)V
    //   69: aload 5
    //   71: invokevirtual 109	android/content/res/TypedArray:recycle	()V
    //   74: aload_1
    //   75: invokevirtual 84	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   78: aload_2
    //   79: iconst_3
    //   80: newarray int
    //   82: dup
    //   83: iconst_0
    //   84: ldc 172
    //   86: iastore
    //   87: dup
    //   88: iconst_1
    //   89: ldc 173
    //   91: iastore
    //   92: dup
    //   93: iconst_2
    //   94: ldc 174
    //   96: iastore
    //   97: iload_3
    //   98: iload 4
    //   100: invokevirtual 91	android/content/res/Resources$Theme:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   103: astore_1
    //   104: aload_0
    //   105: iconst_0
    //   106: aload_1
    //   107: iconst_0
    //   108: iconst_0
    //   109: invokevirtual 142	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   112: i2f
    //   113: invokevirtual 178	com/facebook/FacebookButtonBase:setTextSize	(IF)V
    //   116: aload_0
    //   117: aload_1
    //   118: iconst_1
    //   119: iconst_1
    //   120: invokevirtual 168	android/content/res/TypedArray:getInt	(II)I
    //   123: invokestatic 184	android/graphics/Typeface:defaultFromStyle	(I)Landroid/graphics/Typeface;
    //   126: invokevirtual 188	com/facebook/FacebookButtonBase:setTypeface	(Landroid/graphics/Typeface;)V
    //   129: aload_0
    //   130: aload_1
    //   131: iconst_2
    //   132: invokevirtual 192	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   135: invokevirtual 196	com/facebook/FacebookButtonBase:setText	(Ljava/lang/CharSequence;)V
    //   138: aload_1
    //   139: invokevirtual 109	android/content/res/TypedArray:recycle	()V
    //   142: return
    //   143: astore_1
    //   144: aload 5
    //   146: invokevirtual 109	android/content/res/TypedArray:recycle	()V
    //   149: aload_1
    //   150: athrow
    //   151: astore_1
    //   152: aload 5
    //   154: invokevirtual 109	android/content/res/TypedArray:recycle	()V
    //   157: aload_1
    //   158: athrow
    //   159: astore_2
    //   160: aload_1
    //   161: invokevirtual 109	android/content/res/TypedArray:recycle	()V
    //   164: aload_2
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	FacebookButtonBase
    //   0	166	1	paramContext	Context
    //   0	166	2	paramAttributeSet	AttributeSet
    //   0	166	3	paramInt1	int
    //   0	166	4	paramInt2	int
    //   19	134	5	localTypedArray	TypedArray
    // Exception table:
    //   from	to	target	type
    //   21	31	143	finally
    //   57	69	151	finally
    //   104	138	159	finally
  }
  
  private void setupOnClickListener()
  {
    super.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(7617);
        FacebookButtonBase.this.logButtonTapped(FacebookButtonBase.this.getContext());
        if (FacebookButtonBase.this.internalOnClickListener != null)
        {
          FacebookButtonBase.this.internalOnClickListener.onClick(paramAnonymousView);
          AppMethodBeat.o(7617);
          return;
        }
        if (FacebookButtonBase.this.externalOnClickListener != null) {
          FacebookButtonBase.this.externalOnClickListener.onClick(paramAnonymousView);
        }
        AppMethodBeat.o(7617);
      }
    });
  }
  
  public void callExternalOnClickListener(View paramView)
  {
    if (this.externalOnClickListener != null) {
      this.externalOnClickListener.onClick(paramView);
    }
  }
  
  protected void configureButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    parseBackgroundAttributes(paramContext, paramAttributeSet, paramInt1, paramInt2);
    parseCompoundDrawableAttributes(paramContext, paramAttributeSet, paramInt1, paramInt2);
    parseContentAttributes(paramContext, paramAttributeSet, paramInt1, paramInt2);
    parseTextAttributes(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setupOnClickListener();
  }
  
  public Activity getActivity()
  {
    for (Context localContext = getContext(); (!(localContext instanceof Activity)) && ((localContext instanceof ContextWrapper)); localContext = ((ContextWrapper)localContext).getBaseContext()) {}
    if ((localContext instanceof Activity)) {
      return (Activity)localContext;
    }
    throw new FacebookException("Unable to get Activity.");
  }
  
  public int getCompoundPaddingLeft()
  {
    if (this.overrideCompoundPadding) {
      return this.overrideCompoundPaddingLeft;
    }
    return super.getCompoundPaddingLeft();
  }
  
  public int getCompoundPaddingRight()
  {
    if (this.overrideCompoundPadding) {
      return this.overrideCompoundPaddingRight;
    }
    return super.getCompoundPaddingRight();
  }
  
  protected abstract int getDefaultRequestCode();
  
  protected int getDefaultStyleResource()
  {
    return 0;
  }
  
  public androidx.fragment.app.Fragment getFragment()
  {
    if (this.parentFragment != null) {
      return this.parentFragment.getSupportFragment();
    }
    return null;
  }
  
  public android.app.Fragment getNativeFragment()
  {
    if (this.parentFragment != null) {
      return this.parentFragment.getNativeFragment();
    }
    return null;
  }
  
  public int getRequestCode()
  {
    return getDefaultRequestCode();
  }
  
  protected int measureTextWidth(String paramString)
  {
    return (int)Math.ceil(getPaint().measureText(paramString));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode()) {
      logButtonCreated(getContext());
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((getGravity() & 0x1) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        i = getCompoundPaddingLeft();
        int j = getCompoundPaddingRight();
        int k = getCompoundDrawablePadding();
        k = Math.min((getWidth() - (k + i) - j - measureTextWidth(getText().toString())) / 2, (i - getPaddingLeft()) / 2);
        this.overrideCompoundPaddingLeft = (i - k);
        this.overrideCompoundPaddingRight = (j + k);
        this.overrideCompoundPadding = true;
      }
      super.onDraw(paramCanvas);
      this.overrideCompoundPadding = false;
      return;
    }
  }
  
  public void setFragment(android.app.Fragment paramFragment)
  {
    this.parentFragment = new FragmentWrapper(paramFragment);
  }
  
  public void setFragment(androidx.fragment.app.Fragment paramFragment)
  {
    this.parentFragment = new FragmentWrapper(paramFragment);
  }
  
  protected void setInternalOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.internalOnClickListener = paramOnClickListener;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.externalOnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.FacebookButtonBase
 * JD-Core Version:    0.7.0.1
 */