package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.widget.BounceScrollView;
import hkr;
import java.lang.reflect.Method;

public class IphoneTitleBarActivity
  extends BaseActivity
{
  public static final int LAYER_TYPE_SOFTWARE = 1;
  protected static final String TAG = "IphoneTitleBarActivity";
  private Drawable ad;
  protected TextView centerView;
  private boolean isRightHighlightButton;
  protected TextView leftView;
  protected TextView leftViewNotBack;
  protected float mDensity;
  private Drawable[] mOldDrawables;
  private int mOldPadding;
  private View mTitleContainer = null;
  protected View.OnClickListener onBackListeger = new hkr(this);
  protected TextView rightHighLView;
  protected ImageView rightViewImg;
  protected TextView rightViewText;
  protected TextView textBeforeRight;
  protected ViewGroup vg;
  
  public static void setLayerType(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT <= 10) {
      return;
    }
    try
    {
      paramView.getClass().getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(paramView, new Object[] { Integer.valueOf(0), null });
      return;
    }
    catch (Exception paramView) {}
  }
  
  public void enableLeftBtn(boolean paramBoolean)
  {
    if (this.leftViewNotBack != null) {
      this.leftViewNotBack.setEnabled(paramBoolean);
    }
  }
  
  protected void enableRightHighlight(boolean paramBoolean)
  {
    if ((this.rightHighLView == null) || (!this.isRightHighlightButton)) {
      return;
    }
    if (paramBoolean)
    {
      this.rightViewText.setVisibility(8);
      this.rightHighLView.setVisibility(0);
      return;
    }
    this.rightViewText.setVisibility(0);
    this.rightHighLView.setVisibility(8);
  }
  
  public View getRightTextView()
  {
    this.rightViewText = ((TextView)findViewById(2131297360));
    setLayerType(this.rightViewText);
    return this.rightViewText;
  }
  
  public String getTextTitle()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.centerView != null)
    {
      localObject1 = localObject2;
      if ((this.centerView instanceof TextView))
      {
        CharSequence localCharSequence = this.centerView.getText();
        localObject1 = localObject2;
        if (localCharSequence != null) {
          localObject1 = localCharSequence.toString();
        }
      }
    }
    return localObject1;
  }
  
  public void hideTitleBar()
  {
    try
    {
      this.mTitleContainer = ((View)findViewById(2131297347).getParent());
      this.mTitleContainer.setVisibility(8);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void init(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130841809));
    if (this.leftView == null)
    {
      this.vg = ((ViewGroup)findViewById(2131297347));
      setLayerType(this.vg);
      onCreateLeftView();
      onCreateCenterView();
      onCreateRightView();
      onCreateBeforeRightView();
      setLeftViewName(paramIntent);
    }
  }
  
  public boolean onBackEvent2()
  {
    onBackEvent();
    finish();
    return false;
  }
  
  protected View onCreateBeforeRightView()
  {
    this.textBeforeRight = ((TextView)findViewById(2131297359));
    return this.textBeforeRight;
  }
  
  public View onCreateCenterView()
  {
    this.centerView = ((TextView)findViewById(2131297348));
    return this.centerView;
  }
  
  protected View onCreateLeftView()
  {
    this.leftView = ((TextView)findViewById(2131297357));
    this.leftView.setOnClickListener(this.onBackListeger);
    setLayerType(this.leftView);
    return this.leftView;
  }
  
  public View onCreateRightView()
  {
    this.rightViewText = ((TextView)findViewById(2131297360));
    this.rightViewImg = ((ImageView)findViewById(2131297361));
    setLayerType(this.rightViewText);
    setLayerType(this.rightViewImg);
    return this.rightViewText;
  }
  
  @TargetApi(11)
  public void removeWebViewLayerType()
  {
    if (Build.VERSION.SDK_INT == 16) {
      this.vg.setLayerType(0, null);
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(7);
  }
  
  public void setBeforeRightButton(int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (this.textBeforeRight != null)
    {
      if (paramInt > 0) {
        this.textBeforeRight.setText(paramInt);
      }
      if (paramOnClickListener != null) {
        this.textBeforeRight.setOnClickListener(paramOnClickListener);
      }
    }
  }
  
  public void setClickableTitle(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener)
  {
    setTitle(paramCharSequence);
    if ((this.centerView != null) && ((this.centerView instanceof TextView)))
    {
      paramCharSequence = this.centerView;
      if (paramOnClickListener == null) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      paramCharSequence.setClickable(bool);
      this.centerView.setOnClickListener(paramOnClickListener);
      return;
    }
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    getWindow().setFeatureInt(7, 2130903206);
    if (this.mTitleContainer != null) {
      this.mTitleContainer.setVisibility(0);
    }
    this.mDensity = getResources().getDisplayMetrics().density;
    init(getIntent());
  }
  
  public void setContentView(View paramView)
  {
    this.mDensity = getResources().getDisplayMetrics().density;
    super.setContentView(paramView);
    getWindow().setFeatureInt(7, 2130903206);
    if (this.mTitleContainer != null) {
      this.mTitleContainer.setVisibility(0);
    }
    init(getIntent());
  }
  
  public View setContentViewB(int paramInt)
  {
    BounceScrollView localBounceScrollView = (BounceScrollView)View.inflate(this, 2130903129, null);
    View localView = View.inflate(this, paramInt, null);
    localBounceScrollView.addView(localView);
    setContentView(localBounceScrollView);
    return localView;
  }
  
  public void setContentViewC(int paramInt)
  {
    super.setContentView(paramInt);
  }
  
  public void setContentViewNoBackground(int paramInt)
  {
    setContentView(paramInt);
    getWindow().setBackgroundDrawable(null);
  }
  
  public void setContentViewNoTitle(int paramInt)
  {
    this.mDensity = getResources().getDisplayMetrics().density;
    super.setContentView(paramInt);
    getWindow().setFeatureInt(7, 2130903222);
    try
    {
      this.mTitleContainer = ((View)findViewById(2131297386).getParent());
      this.mTitleContainer.setVisibility(8);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public String setLastActivityName()
  {
    if ((this.centerView == null) || (this.centerView.getText() == null) || (this.centerView.getText().length() == 0)) {
      return getString(2131366374);
    }
    return this.centerView.getText().toString();
  }
  
  public void setLeftButton(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.leftView.setVisibility(8);
    this.leftViewNotBack = ((TextView)findViewById(2131297358));
    setLayerType(this.leftViewNotBack);
    this.leftViewNotBack.setVisibility(0);
    this.leftViewNotBack.setText(paramInt);
    if (paramOnClickListener == null)
    {
      this.leftViewNotBack.setOnClickListener(this.onBackListeger);
      return;
    }
    this.leftViewNotBack.setOnClickListener(paramOnClickListener);
  }
  
  public void setLeftViewName(int paramInt)
  {
    if ((this.leftView != null) && ((this.leftView instanceof TextView)))
    {
      if (this.leftViewNotBack != null) {
        this.leftViewNotBack.setVisibility(8);
      }
      this.leftView.setVisibility(0);
    }
  }
  
  public void setLeftViewName(Intent paramIntent)
  {
    if ((this.leftView != null) && ((this.leftView instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
      if (this.leftViewNotBack != null) {
        this.leftViewNotBack.setVisibility(8);
      }
    }
    try
    {
      this.leftView.setVisibility(0);
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  public void setRightButton(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.isRightHighlightButton = false;
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(paramInt);
    this.rightViewText.setEnabled(true);
    if (paramOnClickListener != null) {
      this.rightViewText.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected void setRightHighlightButton(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.isRightHighlightButton = true;
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(paramInt);
    this.rightViewText.setEnabled(false);
    this.rightHighLView = ((TextView)getLayoutInflater().inflate(2130903209, null));
    setLayerType(this.rightHighLView);
    this.rightHighLView.setText(paramInt);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 1);
    localLayoutParams.addRule(15, 1);
    this.vg.addView(this.rightHighLView, localLayoutParams);
    this.rightHighLView.setVisibility(8);
    if (paramOnClickListener != null) {
      this.rightHighLView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.centerView != null) && ((this.centerView instanceof TextView)))
    {
      this.centerView.setText(paramCharSequence);
      super.setTitle(paramCharSequence);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence, String paramString)
  {
    setTitle(paramCharSequence);
    super.setTitle(paramString);
  }
  
  public void showContentViewTitle(boolean paramBoolean)
  {
    try
    {
      View localView = (View)findViewById(2131297347).getParent();
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        localView.setVisibility(i);
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public boolean startTitleProgress()
  {
    if (this.ad == null)
    {
      Resources localResources = getResources();
      if (isModeleWindow()) {}
      for (int i = 2130838135;; i = 2130838132)
      {
        this.ad = localResources.getDrawable(i);
        this.mOldDrawables = this.centerView.getCompoundDrawables();
        this.mOldPadding = this.centerView.getCompoundDrawablePadding();
        this.centerView.setCompoundDrawablePadding(10);
        this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.ad, this.mOldDrawables[1], this.mOldDrawables[2], this.mOldDrawables[3]);
        ((Animatable)this.ad).start();
        return true;
      }
    }
    return false;
  }
  
  public boolean stopTitleProgress()
  {
    if (this.ad != null)
    {
      ((Animatable)this.ad).stop();
      this.ad = null;
      this.centerView.setCompoundDrawablePadding(this.mOldPadding);
      this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.mOldDrawables[0], this.mOldDrawables[1], this.mOldDrawables[2], this.mOldDrawables[3]);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.IphoneTitleBarActivity
 * JD-Core Version:    0.7.0.1
 */