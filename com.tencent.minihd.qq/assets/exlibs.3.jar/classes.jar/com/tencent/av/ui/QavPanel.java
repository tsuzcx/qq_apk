package com.tencent.av.ui;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import bzq;
import com.tencent.av.utils.DrawableTools;
import com.tencent.av.utils.UITools1;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.session.QavSession;
import com.tencent.qphone.base.util.QLog;
import mqq.app.BaseActivity;

public class QavPanel
  extends RelativeLayout
{
  private static final String jdField_a_of_type_JavaLangString = "QavPanel";
  public int a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  View jdField_a_of_type_AndroidViewView = null;
  Button jdField_a_of_type_AndroidWidgetButton = null;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new bzq(this);
  public SeekBar a;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  QavPanelSoundWaveView jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  View jdField_b_of_type_AndroidViewView = null;
  Button jdField_b_of_type_AndroidWidgetButton = null;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  public boolean b;
  View jdField_c_of_type_AndroidViewView = null;
  Button jdField_c_of_type_AndroidWidgetButton = null;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  Button jdField_d_of_type_AndroidWidgetButton = null;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  Button e = null;
  Button f = null;
  
  public QavPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidWidgetSeekBar = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    a();
  }
  
  public QavPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidWidgetSeekBar = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    a();
  }
  
  public QavPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidWidgetSeekBar = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    a();
  }
  
  static void a(ImageButton paramImageButton, int paramInt)
  {
    if (paramImageButton == null) {
      return;
    }
    paramImageButton.setImageDrawable(DrawableTools.b(paramImageButton.getResources(), paramInt));
    paramImageButton.setAdjustViewBounds(true);
  }
  
  private void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131298343);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131298439));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131298431));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131298433));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(10);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131298430));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131298438));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131298358));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131298328));
    Drawable localDrawable;
    if (this.jdField_b_of_type_AndroidWidgetButton != null)
    {
      localDrawable = getResources().getDrawable(2130838766);
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, paramInt, paramInt);
        this.jdField_b_of_type_AndroidWidgetButton.setCompoundDrawables(null, localDrawable, null, null);
      }
    }
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131298329));
    if (this.jdField_c_of_type_AndroidWidgetButton != null)
    {
      localDrawable = getResources().getDrawable(2130838776);
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, paramInt, paramInt);
        this.jdField_c_of_type_AndroidWidgetButton.setCompoundDrawables(null, localDrawable, null, null);
      }
    }
    i();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131298435));
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131298436));
    this.e = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131298310));
    this.f = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131298312));
    if (paramBoolean2) {}
    for (paramInt = 2;; paramInt = 1)
    {
      a(paramBoolean1, paramInt, false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
  }
  
  private void g()
  {
    if ((getContext() instanceof BaseActivity)) {
      BaseActivity localBaseActivity = (BaseActivity)getContext();
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = new QavPanelSoundWaveView(getContext());
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.a(true);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131493732));
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131493733);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setLayoutParams(localLayoutParams);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)getParent()).findViewById(2131298339);
    if (this.jdField_a_of_type_AndroidViewView == null) {}
  }
  
  public static void setBtnTopDrawable(View paramView, int paramInt)
  {
    if ((paramView instanceof Button)) {
      setBtnTopDrawable((Button)paramView, paramInt);
    }
    while (!(paramView instanceof ImageButton)) {
      return;
    }
    a((ImageButton)paramView, paramInt);
  }
  
  public static void setBtnTopDrawable(TextView paramTextView, int paramInt)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setCompoundDrawables(null, DrawableTools.a(paramTextView.getResources(), paramInt), null, null);
  }
  
  View a(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(paramInt, this, false);
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  void a() {}
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("updateEffectBtn, effectType[").append(paramInt).append("], mEffectDrawable[");
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label71;
      }
    }
    label71:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QavPanel", 2, bool + "], ignoreSetSelected[" + paramBoolean + "]");
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    g();
    int i = getResources().getDimensionPixelSize(2131493722);
    this.jdField_b_of_type_Int = paramInt;
    h();
    a(this.jdField_b_of_type_Int);
    switch (this.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        addView(this.jdField_b_of_type_AndroidViewView);
      }
      addView(this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView);
      bringChildToFront(this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView);
      f();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      if (QLog.isColorLevel()) {
        QLog.d("QavPanel", 2, "[red dot]  register red dot receiver");
      }
      this.jdField_a_of_type_Boolean = true;
      e();
      b();
      setBackgroundColor(33554431);
      return;
      b(i, paramBoolean1, paramBoolean2);
    }
  }
  
  void a(boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean) {
      setWaveEnable(false);
    }
    View localView;
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      localView = this.jdField_c_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label33;
      }
    }
    for (;;)
    {
      localView.setVisibility(i);
      return;
      label33:
      i = 8;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "videoSession :" + paramBoolean1 + ", localHasVideo:" + paramInt + ", isVipFunCall:" + paramBoolean2);
    }
    a(paramBoolean1);
    a(paramInt);
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setViewAccText, id" + LayoutDef.a(paramInt) + ", text[" + paramString + "]");
    }
    View localView = b(paramInt);
    if (localView != null)
    {
      UITools1.a(localView, paramString);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setViewSelected, id" + LayoutDef.a(paramInt) + ", selected[" + paramBoolean + "]");
    }
    View localView = b(paramInt);
    if (localView != null)
    {
      localView.setSelected(paramBoolean);
      return true;
    }
    return false;
  }
  
  public View b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.d("QavPanel", 1, "turnViewType2View,  未处理的按钮，msgType[" + paramInt + "]，Name[" + LayoutDef.a(paramInt));
      return null;
    case 2131298310: 
      return this.e;
    case 2131298437: 
      return this.jdField_a_of_type_AndroidWidgetTextView;
    case 2131298328: 
      return this.jdField_b_of_type_AndroidWidgetButton;
    case 2131298312: 
      return this.f;
    case 2131298439: 
      return this.jdField_a_of_type_AndroidWidgetButton;
    case 2131298339: 
      return this.jdField_a_of_type_AndroidViewView;
    case 2131298329: 
      return this.jdField_c_of_type_AndroidWidgetButton;
    case 2131298435: 
      return this.jdField_a_of_type_AndroidWidgetFrameLayout;
    }
    return this.jdField_d_of_type_AndroidWidgetButton;
  }
  
  void b()
  {
    setBtnTopDrawable(this.e, 2130838762);
    setBtnTopDrawable(this.f, 2130838742);
    setBtnTopDrawable(this.jdField_a_of_type_AndroidViewView, 2130838755);
  }
  
  public void c()
  {
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_Boolean = false;
    QavSession localQavSession = QavBussinessCtrl.a().a();
    if (localQavSession != null) {}
    for (int i = localQavSession.d;; i = this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.jdField_a_of_type_Int);
      return;
    }
  }
  
  public void d()
  {
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_b_of_type_Boolean = true;
  }
  
  void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131298437));
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131427628));
    }
  }
  
  void f()
  {
    Object localObject = getResources().getDisplayMetrics();
    int j = getResources().getDimensionPixelSize(2131493732);
    int k = getResources().getDimensionPixelSize(2131493734);
    int i = 0;
    if (this.jdField_b_of_type_Int == 2130903474) {
      i = ((DisplayMetrics)localObject).widthPixels * 880 / 750;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "adjustPanel, heightPixels[" + ((DisplayMetrics)localObject).heightPixels + "], widthPixels[" + ((DisplayMetrics)localObject).widthPixels + "], waveHeight[" + j + "], shadowHeight[" + k + "], videoHeight[" + i + "], mPanelType[" + this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView != null)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = j;
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = k;
      this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setWaveEnable(boolean paramBoolean)
  {
    AVLog.d("QavPanel", String.format("setWaveEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView != null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.f();
        this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.g();
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel
 * JD-Core Version:    0.7.0.1
 */