package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import fou;

public class BaseChatItemLayout
  extends RelativeLayout
{
  public static final int A = -1;
  public static final int B = 0;
  public static final int C = 1;
  public static final float a;
  public static final int a = 0;
  public static CompoundButton.OnCheckedChangeListener a;
  public static final float b;
  public static final int b = 1;
  public static boolean b = false;
  public static final float c;
  public static final int c = 2131296322;
  @Deprecated
  public static final float d;
  public static final int d = 200;
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  public static final int i;
  public static final int j;
  public static final int k;
  public static final int l;
  public static final int m;
  public static final int n;
  public static final int o;
  public static final int p;
  public static final int q;
  public static final int r;
  public static final int s;
  public static final int t;
  public static final int u;
  public static final int v;
  public static final int w;
  public static final int x;
  View jdField_a_of_type_AndroidViewView;
  public CheckBox a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  public TextView a;
  public URLImageView a;
  public boolean a;
  public ImageView b;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public ImageView c;
  TextView c;
  TextView d;
  TextView e;
  TextView f;
  TextView g;
  TextView h;
  private TextView i;
  int y = 0;
  int z;
  
  static
  {
    Context localContext = BaseApplicationImpl.getContext();
    jdField_d_of_type_Float = localContext.getResources().getDisplayMetrics().density;
    jdField_a_of_type_Float = localContext.getResources().getDimensionPixelSize(2131492883);
    jdField_b_of_type_Float = localContext.getResources().getDimensionPixelSize(2131492868);
    jdField_c_of_type_Float = localContext.getResources().getDimensionPixelSize(2131492883);
    jdField_i_of_type_Int = localContext.getResources().getDimensionPixelSize(2131493055);
    j = localContext.getResources().getDimensionPixelSize(2131493056);
    k = localContext.getResources().getDimensionPixelSize(2131493057);
    l = localContext.getResources().getDimensionPixelSize(2131493058);
    m = localContext.getResources().getDimensionPixelSize(2131493059);
    n = localContext.getResources().getDimensionPixelSize(2131493062);
    o = localContext.getResources().getDimensionPixelSize(2131493063);
    p = localContext.getResources().getDimensionPixelSize(2131493064);
    q = localContext.getResources().getDimensionPixelSize(2131493065);
    t = localContext.getResources().getDimensionPixelSize(2131493074);
    s = localContext.getResources().getDimensionPixelSize(2131493073);
    r = localContext.getResources().getDimensionPixelSize(2131493061);
    a(localContext);
    u = localContext.getResources().getDimensionPixelSize(2131493069);
    v = localContext.getResources().getDimensionPixelSize(2131493070);
    w = localContext.getResources().getDimensionPixelSize(2131493068);
    x = localContext.getResources().getDimensionPixelSize(2131493076);
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new fou();
  }
  
  public BaseChatItemLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public BaseChatItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public BaseChatItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(int paramInt)
  {
    if (this.z != paramInt)
    {
      this.z = paramInt;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(3, this.z);
      }
      if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams()).addRule(3, this.z);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(3, this.z);
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(3, this.z);
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).addRule(3, this.z);
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams()).addRule(3, this.z);
      }
      if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_e_of_type_AndroidWidgetTextView == null) || (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0)) && ((this.jdField_b_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)))
      {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, this.z);
        if (QLog.isColorLevel()) {
          QLog.d("BubbleView", 2, " setTopId mTopId = " + this.z);
        }
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    jdField_e_of_type_Int = SizeMeasure.e(paramContext);
    jdField_f_of_type_Int = (int)(jdField_e_of_type_Int - 200.0F * jdField_d_of_type_Float);
    jdField_g_of_type_Int = jdField_f_of_type_Int - k - l;
    jdField_h_of_type_Int = jdField_g_of_type_Int - t * 2;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    paramView.addRule(paramInt1, paramInt2);
    paramView.addRule(paramInt3, 0);
  }
  
  private void a(TextView paramTextView, CharSequence paramCharSequence, ColorStateList paramColorStateList)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
    paramTextView.setTextSize(2, 12.0F);
    paramTextView.setIncludeFontPadding(false);
    paramTextView.setEllipsize(TextUtils.TruncateAt.END);
    paramTextView.setSingleLine();
    paramTextView.setText(paramCharSequence);
    paramTextView.setTag(paramCharSequence);
    paramTextView.setTextColor(paramColorStateList);
  }
  
  private void a(CharSequence paramCharSequence, ColorStateList paramColorStateList, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    a(paramBoolean2);
    if (this.jdField_g_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_g_of_type_AndroidWidgetTextView = new TextView(getContext());
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_g_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    }
    Object localObject = this.jdField_g_of_type_AndroidWidgetTextView;
    int i1;
    if (paramBoolean1)
    {
      i1 = jdField_g_of_type_Int - (int)(100.0F * jdField_d_of_type_Float);
      ((TextView)localObject).setMaxWidth(i1);
      a(this.jdField_g_of_type_AndroidWidgetTextView, paramCharSequence, paramColorStateList);
      if (!paramBoolean1) {
        break label428;
      }
      if (this.jdField_h_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_h_of_type_AndroidWidgetTextView = new TextView(getContext());
        paramCharSequence = new LinearLayout.LayoutParams(-2, -2);
        paramCharSequence.leftMargin = AIOUtils.a(9.0F, getContext().getResources());
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_h_of_type_AndroidWidgetTextView, paramCharSequence);
      }
      i1 = -1;
      if (paramInt2 != 0) {
        break label305;
      }
      i1 = 2130838484;
      if (i1 != -1) {
        break label319;
      }
      this.jdField_h_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramCharSequence = new StringBuilder();
      if (paramInt1 > 0)
      {
        paramCharSequence.append(" ");
        paramCharSequence.append(paramInt1).append(getResources().getString(2131363242)).append("  ");
      }
      if (paramInt3 > 100) {
        break label334;
      }
      new StringBuilder().append(100).append(getResources().getString(2131363243)).toString();
      paramCharSequence.append(":");
      a(this.jdField_h_of_type_AndroidWidgetTextView, paramCharSequence.toString(), paramColorStateList);
    }
    label305:
    label319:
    label334:
    while (this.jdField_h_of_type_AndroidWidgetTextView == null) {
      for (;;)
      {
        return;
        i1 = jdField_g_of_type_Int;
        break;
        if (paramInt2 == 1)
        {
          i1 = 2130838479;
          continue;
          this.jdField_h_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i1, 0, 0, 0);
          continue;
          if (paramInt3 <= 1000) {
            new StringBuilder().append((paramInt3 / 100 + 1) * 100).append(getResources().getString(2131363243)).toString();
          } else {
            new StringBuilder().append(getResources().getString(2131363244)).append(1000).append(getResources().getString(2131363243)).toString();
          }
        }
      }
    }
    label428:
    a(this.jdField_h_of_type_AndroidWidgetTextView, null, paramColorStateList);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_f_of_type_AndroidWidgetTextView == null) && (paramBoolean))
    {
      this.jdField_f_of_type_AndroidWidgetTextView = new TextView(getContext());
      this.jdField_f_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
      this.jdField_f_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(5.0F, getContext().getResources()), 0, AIOUtils.a(5.0F, getContext().getResources()), 0);
      this.jdField_f_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_f_of_type_AndroidWidgetTextView.setSingleLine();
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_f_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(getContext().getResources().getString(2131363238));
      this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundResource(2130842109);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.rightMargin = AIOUtils.a(3.0F, getContext().getResources());
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_f_of_type_AndroidWidgetTextView, 0, localLayoutParams);
    }
    if (this.jdField_f_of_type_AndroidWidgetTextView != null)
    {
      if (!paramBoolean) {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  void a(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_AndroidViewView != paramView)
    {
      removeView(this.jdField_a_of_type_AndroidViewView);
      addView(paramView);
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_AndroidViewView.setId(2131296322);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      int i1 = paramView.getContext().getResources().getDimensionPixelSize(2131493075);
      localLayoutParams.leftMargin = i1;
      localLayoutParams.rightMargin = i1;
      if (this.y == 1)
      {
        localLayoutParams.addRule(0, 2131296315);
        localLayoutParams.addRule(1, 0);
      }
    }
    else
    {
      paramView = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      if ((this.jdField_e_of_type_AndroidWidgetTextView == null) || (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
        break label178;
      }
      paramView.addRule(3, 2131296317);
      paramView.topMargin = AIOUtils.a(8.0F, getContext().getResources());
      if (QLog.isColorLevel()) {
        QLog.d("BubbleView", 2, " setBubbleView mTopId = R.id.chat_item_nick_name");
      }
    }
    label178:
    label236:
    do
    {
      do
      {
        return;
        localLayoutParams.addRule(1, 2131296315);
        localLayoutParams.addRule(0, 0);
        break;
        if ((this.jdField_b_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)) {
          break label236;
        }
        paramView.addRule(3, 2131296319);
        paramView.topMargin = AIOUtils.a(8.0F, getContext().getResources());
      } while (!QLog.isColorLevel());
      QLog.d("BubbleView", 2, " setBubbleView mTopId = R.id.chat_item_opentroop_nick_area");
      return;
      paramView.addRule(3, this.z);
      paramView.topMargin = m;
    } while (!QLog.isColorLevel());
    QLog.d("BubbleView", 2, " setBubbleView mTopId  = " + this.z);
  }
  
  void a(boolean paramBoolean, CharSequence paramCharSequence, ColorStateList paramColorStateList)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131296318);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = getContext().getResources().getDimensionPixelSize(2131493077);
        localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(2131493078);
        localLayoutParams.leftMargin = AIOUtils.a(12.0F, getContext().getResources());
        localLayoutParams.addRule(3, this.z);
        localLayoutParams.addRule(1, 2131296317);
        addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_d_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_d_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_d_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_d_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_d_of_type_AndroidWidgetTextView.setMaxWidth(jdField_g_of_type_Int);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_d_of_type_AndroidWidgetTextView, localLayoutParams);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
      if (this.jdField_e_of_type_AndroidWidgetTextView != null)
      {
        i1 = AIOUtils.a(136.0F, getContext().getResources());
        this.jdField_e_of_type_AndroidWidgetTextView.setMaxWidth(i1);
        this.jdField_e_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      }
    }
    while ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8))
    {
      RelativeLayout.LayoutParams localLayoutParams;
      int i1;
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  void a(boolean paramBoolean1, CharSequence paramCharSequence, ColorStateList paramColorStateList, boolean paramBoolean2)
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean1)
    {
      if (this.jdField_e_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_e_of_type_AndroidWidgetTextView.setId(2131296317);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_e_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_e_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_e_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_e_of_type_AndroidWidgetTextView.setMaxWidth(jdField_g_of_type_Int);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = this.jdField_e_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131493077);
        localLayoutParams.bottomMargin = this.jdField_e_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131493078);
        localLayoutParams.addRule(3, this.z);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131296317);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setNick mTopId = R.id.chat_item_nick_name");
          }
        }
        addView(this.jdField_e_of_type_AndroidWidgetTextView, localLayoutParams);
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams();
      if (paramBoolean2)
      {
        localLayoutParams.rightMargin = this.jdField_e_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131493079);
        localLayoutParams.leftMargin = 0;
        localLayoutParams.addRule(0, 2131296315);
        localLayoutParams.addRule(1, 0);
        if (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0)
        {
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131296317);
            if (QLog.isColorLevel()) {
              QLog.d("BubbleView", 2, " setNick mTopId = R.id.chat_item_nick_name");
            }
          }
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText(paramCharSequence);
        this.jdField_e_of_type_AndroidWidgetTextView.setTag(paramCharSequence);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0))
          {
            localLayoutParams.leftMargin = AIOUtils.a(8.0F, getContext().getResources());
            localLayoutParams.addRule(1, 2131296316);
          }
          for (;;)
          {
            localLayoutParams.rightMargin = 0;
            localLayoutParams.addRule(0, 0);
            break;
            localLayoutParams.leftMargin = this.jdField_e_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131493079);
            localLayoutParams.addRule(1, 2131296315);
          }
        } while ((this.jdField_e_of_type_AndroidWidgetTextView == null) || (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() == 8));
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      } while (this.jdField_a_of_type_AndroidViewView == null);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, this.z);
    } while (!QLog.isColorLevel());
    QLog.d("BubbleView", 2, " setNick mTopId = " + this.z);
  }
  
  void a(boolean paramBoolean1, CharSequence paramCharSequence, ColorStateList paramColorStateList, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean3)
  {
    if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (paramBoolean1)
    {
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null)
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setId(2131296319);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = getContext().getResources().getDimensionPixelSize(2131493077);
        localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(2131493078);
        localLayoutParams.leftMargin = AIOUtils.a(32.0F, getContext().getResources());
        localLayoutParams.addRule(3, this.z);
        localLayoutParams.addRule(1, 2131296315);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131296319);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setNickArea mTopId = R.id.chat_item_opentroop_nick_area");
          }
        }
        addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, localLayoutParams);
      }
      if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0))
      {
        ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams()).leftMargin = AIOUtils.a(8.0F, getContext().getResources());
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131296319);
            if (QLog.isColorLevel()) {
              QLog.d("BubbleView", 2, " setNickArea mTopId = R.id.chat_item_opentroop_nick_area");
            }
          }
        }
        a(paramCharSequence, paramColorStateList, paramBoolean2, paramInt1, paramInt2, paramInt3, paramBoolean3);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams()).leftMargin = AIOUtils.a(32.0F, getContext().getResources());
          break;
        } while ((this.jdField_b_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 8));
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      } while (this.jdField_a_of_type_AndroidViewView == null);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, this.z);
    } while (!QLog.isColorLevel());
    QLog.d("BubbleView", 2, " setNickArea mTopId = " + this.z);
  }
  
  void a(boolean paramBoolean1, CharSequence paramCharSequence, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if (paramBoolean1)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_c_of_type_AndroidWidgetTextView.setId(2131296316);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_c_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(5.0F, getContext().getResources()), 0, AIOUtils.a(5.0F, getContext().getResources()), 0);
        this.jdField_c_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_c_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_c_of_type_AndroidWidgetTextView.setGravity(17);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = this.jdField_c_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131493077);
        localLayoutParams.bottomMargin = this.jdField_c_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131493078);
        localLayoutParams.addRule(3, this.z);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131296317);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setTroopMemberLevel mTopId = R.id.chat_item_nick_name");
          }
        }
        addView(this.jdField_c_of_type_AndroidWidgetTextView, localLayoutParams);
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
      if (paramBoolean3)
      {
        localLayoutParams.rightMargin = AIOUtils.a(8.0F, getContext().getResources());
        localLayoutParams.leftMargin = 0;
        localLayoutParams.addRule(0, 2131296317);
        localLayoutParams.addRule(1, 0);
        if (!paramBoolean2) {
          break label418;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.jdField_e_of_type_Int);
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(paramInt);
        this.jdField_c_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(5.0F, getContext().getResources()), 0, AIOUtils.a(5.0F, getContext().getResources()), 0);
        if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      }
    }
    label418:
    while ((this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 8)) {
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        localLayoutParams.leftMargin = this.jdField_c_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131493079);
        localLayoutParams.rightMargin = 0;
        localLayoutParams.addRule(1, 2131296315);
        localLayoutParams.addRule(0, 0);
        continue;
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(paramInt);
      }
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public boolean a()
  {
    return this.y == 1;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((jdField_b_of_type_Boolean) && (paramMotionEvent.getAction() == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg", 4, "BaseChatItemLayout onInterceptTouchEvent...down ");
      }
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (jdField_b_of_type_Boolean)
    {
      if (paramMotionEvent.getAction() == 0) {
        if (QLog.isDevelopLevel()) {
          QLog.d("MultiMsg", 4, "BaseChatItemLayout onTouchEvent...down ");
        }
      }
      do
      {
        do
        {
          return true;
        } while (paramMotionEvent.getAction() != 1);
        paramMotionEvent = findViewById(2131296326);
      } while ((paramMotionEvent == null) || (!(paramMotionEvent instanceof CheckBox)) || (paramMotionEvent.getVisibility() != 0));
      paramMotionEvent = (CheckBox)paramMotionEvent;
      if (!paramMotionEvent.isChecked()) {}
      for (boolean bool = true;; bool = false)
      {
        paramMotionEvent.setChecked(bool);
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCheckBox(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool1 = jdField_b_of_type_Boolean;
    if (jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_AndroidWidgetCheckBox == null)
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox = new CheckBox(getContext());
        this.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(2130837974);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setId(2131296326);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        paramBaseChatItemLayout = new RelativeLayout.LayoutParams(-2, -2);
        paramBaseChatItemLayout.topMargin = x;
        paramBaseChatItemLayout.addRule(9);
        paramBaseChatItemLayout.addRule(3, this.z);
        addView(this.jdField_a_of_type_AndroidWidgetCheckBox, paramBaseChatItemLayout);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setTag(paramChatMessage);
        if (!MultiMsgProxy.a(paramChatMessage)) {
          break label314;
        }
        if ((paramChatMessage instanceof MessageForPic))
        {
          paramBaseChatItemLayout = (MessageForPic)paramChatMessage;
          bool2 = URLDrawableHelper.a(getContext(), paramBaseChatItemLayout, 65537);
          if (paramBaseChatItemLayout.isSendFromLocal()) {
            break label234;
          }
          bool1 = bool2;
        }
        if (!bool1) {
          break label329;
        }
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        if (!MultiMsgManager.a().a(paramChatMessage)) {
          break label320;
        }
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      }
    }
    label234:
    while (this.jdField_a_of_type_AndroidWidgetCheckBox == null)
    {
      for (;;)
      {
        boolean bool2;
        return;
        paramBaseChatItemLayout = new RelativeLayout.LayoutParams(-2, -2);
        paramBaseChatItemLayout.topMargin = x;
        paramBaseChatItemLayout.addRule(9);
        paramBaseChatItemLayout.addRule(3, this.z);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams(paramBaseChatItemLayout);
        continue;
        bool1 = bool2;
        if (paramBaseChatItemLayout.size <= 0L)
        {
          paramBaseChatItemLayout = paramQQAppInterface.a().a(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.uniseq);
          bool1 = bool2;
          if ((paramBaseChatItemLayout instanceof BaseTransProcessor))
          {
            paramBaseChatItemLayout = (BaseTransProcessor)paramBaseChatItemLayout;
            if ((paramBaseChatItemLayout.c() != 1003L) && (paramBaseChatItemLayout.d() != 1003L)) {}
            for (bool1 = false;; bool1 = bool2) {
              break;
            }
            bool1 = false;
          }
        }
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(4);
      return;
    }
    label314:
    label320:
    label329:
    this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
  }
  
  public void setFailedIconResource(int paramInt, View.OnClickListener paramOnClickListener)
  {
    setFailedIconResource(paramInt, paramOnClickListener, null);
  }
  
  public void setFailedIconResource(int paramInt, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_b_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_b_of_type_AndroidWidgetImageView.setId(2131296321);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getContext().getString(2131369311));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.bottomMargin = AIOUtils.a(16.0F, getContext().getResources());
      localLayoutParams.addRule(8, 2131296322);
      if (this.y != 1) {
        break label155;
      }
      localLayoutParams.addRule(0, 2131296322);
      localLayoutParams.addRule(1, 0);
    }
    for (;;)
    {
      addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setTag(paramObject);
      return;
      label155:
      localLayoutParams.addRule(1, 2131296322);
      localLayoutParams.addRule(0, 0);
    }
  }
  
  public void setFailedIconVisable(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      setFailedIconResource(2130837622, paramOnClickListener);
    }
    for (;;)
    {
      if ((jdField_b_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return;
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        Log.i("app2", "setFailedIconVisable gone");
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(null);
      }
    }
  }
  
  public void setGrayTipsText(boolean paramBoolean, CharSequence paramCharSequence, ColorStateList paramColorStateList)
  {
    int i2 = 0;
    int i1;
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_b_of_type_AndroidWidgetTextView.setId(2131296314);
        i1 = AIOUtils.a(12.0F, getContext().getResources());
        i2 = AIOUtils.a(5.0F, getContext().getResources());
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130840060);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 13.0F);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
        this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i1, i2, i1, i2);
        this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(new LinkMovementMethod());
        paramColorStateList = new RelativeLayout.LayoutParams(AIOUtils.a(235.0F, getContext().getResources()), -2);
        paramColorStateList.bottomMargin = getContext().getResources().getDimensionPixelOffset(2131493067);
        i1 = AIOUtils.a(45.0F, getContext().getResources());
        paramColorStateList.leftMargin = i1;
        paramColorStateList.rightMargin = i1;
        paramColorStateList.addRule(14);
        paramColorStateList.addRule(3, 2131296313);
        addView(this.jdField_b_of_type_AndroidWidgetTextView, paramColorStateList);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!paramCharSequence.equals(this.jdField_b_of_type_AndroidWidgetTextView.getTag()))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
        this.jdField_b_of_type_AndroidWidgetTextView.setTag(paramCharSequence);
      }
      a(2131296314);
    }
    do
    {
      while ((this.z == 2131296313) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
      {
        paramCharSequence = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        paramCharSequence.topMargin = getContext().getResources().getDimensionPixelSize(2131493066);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramCharSequence);
        return;
        if (this.jdField_b_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          i1 = i2;
          if (this.jdField_a_of_type_AndroidWidgetTextView != null)
          {
            i1 = i2;
            if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {
              i1 = 2131296313;
            }
          }
          a(i1);
        }
      }
    } while ((this.z != 2131296314) || (this.jdField_b_of_type_AndroidWidgetTextView == null));
    paramCharSequence = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    paramCharSequence.topMargin = AIOUtils.a(10.0F, getContext().getResources());
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramCharSequence);
  }
  
  public void setHeadIconVisible(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else if (this.jdField_e_of_type_AndroidWidgetTextView != null)
    {
      if (!paramBoolean) {
        break label56;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      setPendantImageVisible(paramBoolean);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label56:
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void setHeaderIcon(Drawable paramDrawable)
  {
    int i1 = getContext().getResources().getDimensionPixelSize(2131493076);
    int i2 = AIOUtils.a(16.0F, getContext().getResources());
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_a_of_type_AndroidWidgetImageView.setId(2131296315);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      int i3 = AIOUtils.a(56.0F, getContext().getResources());
      localLayoutParams = new RelativeLayout.LayoutParams(i3, i3);
      localLayoutParams.topMargin = i1;
      localLayoutParams.addRule(3, 2131296314);
      if (this.y == 1)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = i2;
        localLayoutParams.leftMargin = 0;
        localLayoutParams.addRule(3, this.z);
        addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      return;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {}
      for (localLayoutParams.leftMargin = AIOUtils.a(32.0F, getContext().getResources());; localLayoutParams.leftMargin = i2)
      {
        localLayoutParams.rightMargin = 0;
        break;
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.topMargin = i1;
      localLayoutParams.addRule(3, 2131296314);
      if (this.y != 1) {
        break label321;
      }
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.rightMargin = i2;
      localLayoutParams.leftMargin = 0;
      localLayoutParams.addRule(3, this.z);
    }
    label321:
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(11, 0);
    if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {}
    for (localLayoutParams.leftMargin = AIOUtils.a(32.0F, getContext().getResources());; localLayoutParams.leftMargin = i2)
    {
      localLayoutParams.rightMargin = 0;
      break;
    }
  }
  
  public void setHearIconPosition(int paramInt)
  {
    int i2;
    if (this.y != paramInt)
    {
      this.y = paramInt;
      if (paramInt != 1) {
        break label504;
      }
      i2 = 1;
      if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
        break label705;
      }
    }
    label388:
    label649:
    label668:
    label686:
    label705:
    for (paramInt = this.jdField_a_of_type_AndroidWidgetTextView.getId();; paramInt = 0)
    {
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
        paramInt = this.jdField_b_of_type_AndroidWidgetTextView.getId();
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidWidgetCheckBox != null) {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams()).addRule(9);
        }
        RelativeLayout.LayoutParams localLayoutParams;
        int i1;
        if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0))
        {
          localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
          i1 = AIOUtils.a(16.0F, getContext().getResources());
          if (i2 != 0)
          {
            localLayoutParams.addRule(11);
            localLayoutParams.addRule(9, 0);
            localLayoutParams.rightMargin = i1;
            localLayoutParams.leftMargin = 0;
            localLayoutParams.addRule(3, paramInt);
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0))
          {
            localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
            i1 = AIOUtils.a(9.0F, getContext().getResources());
            if (this.y != 1) {
              break label579;
            }
            localLayoutParams.addRule(11);
            localLayoutParams.addRule(9, 0);
            localLayoutParams.rightMargin = i1;
            localLayoutParams.leftMargin = 0;
            label251:
            localLayoutParams.addRule(3, this.z);
          }
          i1 = paramInt;
          if (this.jdField_e_of_type_AndroidWidgetTextView != null)
          {
            i1 = paramInt;
            if (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() == 0)
            {
              ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(3, paramInt);
              i1 = this.jdField_e_of_type_AndroidWidgetTextView.getId();
            }
          }
          paramInt = i1;
          if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
          {
            paramInt = i1;
            if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)
            {
              ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams()).addRule(3, i1);
              paramInt = this.jdField_b_of_type_AndroidWidgetLinearLayout.getId();
            }
          }
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
            if (i2 == 0) {
              break label649;
            }
            localLayoutParams.addRule(0, 2131296315);
            localLayoutParams.addRule(1, 0);
            localLayoutParams.addRule(3, paramInt);
            if (QLog.isColorLevel()) {
              QLog.d("BubbleView", 2, " setHearIconPosition mTopId = " + paramInt);
            }
          }
          if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
          {
            localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetProgressBar.getLayoutParams();
            if (i2 == 0) {
              break label668;
            }
            localLayoutParams.addRule(0, 2131296322);
            localLayoutParams.addRule(1, 0);
          }
        }
        for (;;)
        {
          if (this.jdField_b_of_type_AndroidWidgetImageView != null)
          {
            localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
            if (i2 == 0) {
              break label686;
            }
            localLayoutParams.addRule(0, 2131296322);
            localLayoutParams.addRule(1, 0);
          }
          return;
          label504:
          i2 = 0;
          break;
          localLayoutParams.addRule(9);
          localLayoutParams.addRule(11, 0);
          if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {}
          for (localLayoutParams.leftMargin = AIOUtils.a(32.0F, getContext().getResources());; localLayoutParams.leftMargin = i1)
          {
            localLayoutParams.rightMargin = 0;
            break;
          }
          label579:
          localLayoutParams.addRule(9);
          localLayoutParams.addRule(11, 0);
          localLayoutParams.rightMargin = 0;
          if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
          {
            localLayoutParams.leftMargin = AIOUtils.a(25.0F, getContext().getResources());
            break label251;
          }
          localLayoutParams.leftMargin = i1;
          break label251;
          localLayoutParams.addRule(1, 2131296315);
          localLayoutParams.addRule(0, 0);
          break label388;
          localLayoutParams.addRule(1, 2131296322);
          localLayoutParams.addRule(0, 0);
        }
        localLayoutParams.addRule(1, 2131296322);
        localLayoutParams.addRule(0, 0);
        return;
      }
    }
  }
  
  public void setPendantImage(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView == null)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
      this.jdField_a_of_type_ComTencentImageURLImageView.setId(2131296324);
      this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(70.0F, getContext().getResources()), AIOUtils.a(82.0F, getContext().getResources()));
      localLayoutParams.addRule(3, 2131296314);
      if (this.y == 1)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = AIOUtils.a(9.0F, getContext().getResources());
        localLayoutParams.leftMargin = 0;
      }
      for (;;)
      {
        localLayoutParams.addRule(3, this.z);
        addView(this.jdField_a_of_type_ComTencentImageURLImageView, localLayoutParams);
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramDrawable);
        return;
        localLayoutParams.addRule(9);
        localLayoutParams.addRule(11, 0);
        if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {
          localLayoutParams.leftMargin = AIOUtils.a(25.0F, getContext().getResources());
        } else {
          localLayoutParams.leftMargin = AIOUtils.a(9.0F, getContext().getResources());
        }
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    localLayoutParams.addRule(3, 2131296314);
    if (this.y == 1)
    {
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.rightMargin = AIOUtils.a(9.0F, getContext().getResources());
      localLayoutParams.leftMargin = 0;
    }
    for (;;)
    {
      localLayoutParams.addRule(3, this.z);
      break;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {
        localLayoutParams.leftMargin = AIOUtils.a(25.0F, getContext().getResources());
      } else {
        localLayoutParams.leftMargin = AIOUtils.a(9.0F, getContext().getResources());
      }
    }
  }
  
  public void setPendantImageVisible(boolean paramBoolean)
  {
    URLImageView localURLImageView;
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null)
    {
      localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i1 = 0;; i1 = 8)
    {
      localURLImageView.setVisibility(i1);
      return;
    }
  }
  
  public void setProgressVisable(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_AndroidWidgetProgressBar == null)
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(getContext(), null, 0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setId(2131296320);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(true);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130838130));
        i1 = AIOUtils.a(16.0F, getContext().getResources());
        localLayoutParams = new RelativeLayout.LayoutParams(i1, i1);
        localLayoutParams.bottomMargin = AIOUtils.a(18.0F, getContext().getResources());
        localLayoutParams.addRule(8, 2131296322);
        if (this.y == 1)
        {
          localLayoutParams.rightMargin = AIOUtils.a(8.0F, getContext().getResources());
          localLayoutParams.addRule(0, 2131296322);
          localLayoutParams.addRule(1, 0);
          addView(this.jdField_a_of_type_AndroidWidgetProgressBar, localLayoutParams);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetProgressBar == null) {
      for (;;)
      {
        int i1;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        localLayoutParams.leftMargin = AIOUtils.a(8.0F, getContext().getResources());
        localLayoutParams.addRule(1, 2131296322);
        localLayoutParams.addRule(0, 0);
      }
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void setTailMessage(boolean paramBoolean, CharSequence paramCharSequence, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean)
    {
      if (this.jdField_i_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_i_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_i_of_type_AndroidWidgetTextView.setId(2131296323);
        this.jdField_i_of_type_AndroidWidgetTextView.setBackgroundResource(2130838637);
        this.jdField_i_of_type_AndroidWidgetTextView.setTextSize(2, 13.0F);
        this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_i_of_type_AndroidWidgetTextView.setGravity(17);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(3, 2131296322);
        localLayoutParams.addRule(5, 2131296322);
        localLayoutParams.addRule(7, 0);
        addView(this.jdField_i_of_type_AndroidWidgetTextView, localLayoutParams);
      }
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
      if (paramCharSequence != this.jdField_i_of_type_AndroidWidgetTextView.getTag()) {
        this.jdField_i_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      }
      paramCharSequence = (RelativeLayout.LayoutParams)this.jdField_i_of_type_AndroidWidgetTextView.getLayoutParams();
      if (this.y == 1)
      {
        paramCharSequence.leftMargin = l;
        this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
      }
    }
    while (this.jdField_i_of_type_AndroidWidgetTextView == null) {
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        paramCharSequence.leftMargin = k;
      }
    }
    this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void setTimeStamp(boolean paramBoolean, long paramLong, ColorStateList paramColorStateList, CharSequence paramCharSequence)
  {
    int i1 = 2131296314;
    if ((paramBoolean) && (paramLong > 0L))
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_a_of_type_AndroidWidgetTextView.setId(2131296313);
        i1 = AIOUtils.a(14.0F, getContext().getResources());
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 11.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i1, 0, i1, 0);
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(2131493066);
        localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelOffset(2131493067);
        localLayoutParams.addRule(14);
        addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetTextView.setTag(Long.valueOf(0L));
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (((Long)this.jdField_a_of_type_AndroidWidgetTextView.getTag()).longValue() != paramLong)
      {
        if (paramCharSequence != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
        }
      }
      else
      {
        if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
          break label277;
        }
        i1 = 2131296314;
        a(i1);
      }
    }
    label277:
    while (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        paramColorStateList = TimeFormatterUtils.a(getContext(), 3, 1000L * paramLong);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramColorStateList);
        continue;
        i1 = 2131296313;
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {}
    for (;;)
    {
      a(i1);
      return;
      i1 = 0;
    }
  }
  
  public void setUnread(boolean paramBoolean, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramOnClickListener = new RelativeLayout.LayoutParams(-2, -2);
      paramOnClickListener.topMargin = AIOUtils.a(8.0F, getContext().getResources());
      paramOnClickListener.leftMargin = AIOUtils.a(-3.0F, getContext().getResources());
      paramOnClickListener.addRule(6, 2131296322);
      paramOnClickListener.addRule(1, 2131296322);
      addView(this.jdField_c_of_type_AndroidWidgetImageView, paramOnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841953);
    }
    while (this.jdField_c_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(null);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseChatItemLayout
 * JD-Core Version:    0.7.0.1
 */