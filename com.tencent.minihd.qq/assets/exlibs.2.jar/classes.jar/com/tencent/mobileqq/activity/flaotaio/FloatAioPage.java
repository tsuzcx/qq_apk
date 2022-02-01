package com.tencent.mobileqq.activity.flaotaio;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;
import glm;
import glo;
import gls;

public class FloatAioPage
{
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private Intent jdField_a_of_type_AndroidContentIntent;
  public BaseFloatChatPie a;
  public ControllerCallBack a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  public FloatAioPage(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramQQAppInterface.a().getApplicationContext();
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
  }
  
  private int a(int paramInt)
  {
    return (int)(paramInt * this.jdField_a_of_type_Float + 0.5F);
  }
  
  private void a(Intent paramIntent)
  {
    switch (paramIntent.getIntExtra("uintype", -1))
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie = new FriendFloatChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie = new TroopFloatChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return;
    case 3000: 
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie = new DiscussFloatChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie = new StrangerFloatChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
  }
  
  private boolean b(Intent paramIntent)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())
    {
      c();
      return true;
    }
    if (!c(paramIntent))
    {
      c();
      return true;
    }
    return false;
  }
  
  private boolean c(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uin");
    int i = paramIntent.getIntExtra("uintype", -1);
    if (str == null) {
      return false;
    }
    if (i == -1) {
      return false;
    }
    if ((paramIntent.hasExtra("account")) && (!((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(str)))
    {
      paramIntent.removeExtra("account");
      return false;
    }
    return (!paramIntent.getBooleanExtra("shortcut", false)) || (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(str));
  }
  
  public Intent a()
  {
    return this.jdField_a_of_type_AndroidContentIntent;
  }
  
  public CharSequence a(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if ((paramCharSequence instanceof QQText))
    {
      String str = ((QQText)paramCharSequence).toString();
      localObject = paramCharSequence;
      if (str != null) {
        localObject = new QQText(str, 3, 24);
      }
    }
    return localObject;
  }
  
  public void a()
  {
    a(false, null);
  }
  
  public void a(ControllerCallBack paramControllerCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioControllerCallBack = paramControllerCallBack;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie.a(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioControllerCallBack != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioControllerCallBack.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, FloatAioController.MsgBarInfo paramMsgBarInfo)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      WindowManager localWindowManager = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
      localLayoutParams.flags = 262176;
      localLayoutParams.format = -3;
      localLayoutParams.softInputMode = 18;
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localLayoutParams.type = 2002;
      if (paramBoolean) {
        localLayoutParams.windowAnimations = 2131558951;
      }
      try
      {
        for (;;)
        {
          localWindowManager.addView(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie.a(), localLayoutParams);
          label102:
          if (!paramBoolean) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie.a().getViewTreeObserver().addOnGlobalLayoutListener(new glm(this, paramMsgBarInfo));
          return;
          localLayoutParams.windowAnimations = 2131558950;
        }
      }
      catch (Exception localException)
      {
        break label102;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie.b();
  }
  
  public boolean a(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    if (b(a())) {}
    do
    {
      return false;
      a(paramIntent);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie.e();
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.equals(this.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie.q();
      }
      ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie.a());
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioControllerCallBack == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioControllerCallBack.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void b(boolean paramBoolean, FloatAioController.MsgBarInfo paramMsgBarInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie.a();
    View localView1 = ((View)localObject).findViewById(2131297680);
    TextView localTextView1 = (TextView)((View)localObject).findViewById(2131297682);
    View localView2 = ((View)localObject).findViewById(2131297684);
    View localView3 = ((View)localObject).findViewById(2131297695);
    TextView localTextView2 = (TextView)((View)localObject).findViewById(2131297696);
    TextView localTextView3 = (TextView)((View)localObject).findViewById(2131297697);
    View localView4 = ((View)localObject).findViewById(2131297694);
    localView3.setVisibility(0);
    ((View)localObject).findViewById(2131297026);
    View localView5 = ((View)localObject).findViewById(2131297686);
    XListView localXListView = (XListView)((View)localObject).findViewById(2131297034);
    View localView6 = ((View)localObject).findViewById(2131297693);
    View localView7 = ((View)localObject).findViewById(2131297691);
    ImageView localImageView = (ImageView)((View)localObject).findViewById(2131297698);
    localView6.setVisibility(4);
    localView7.setVisibility(0);
    int k = a(61);
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493083);
    int n = m - localView6.getHeight() - a(6);
    localView2.setVisibility(4);
    int i1 = localTextView1.getTop() - a(8);
    if (paramBoolean)
    {
      if (paramMsgBarInfo != null)
      {
        localTextView2.setText(a(paramMsgBarInfo.d));
        localObject = (ImageView)((View)localObject).findViewById(2131297692);
        if (paramMsgBarInfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
          ((ImageView)localObject).setImageDrawable(paramMsgBarInfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
      }
      localObject = (FrameLayout.LayoutParams)localView3.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).topMargin = (localView1.getPaddingTop() + a(8) + localTextView1.getHeight() + a(4));
      ((FrameLayout.LayoutParams)localObject).leftMargin = localView1.getPaddingLeft();
      localView5.setVisibility(4);
      localObject = localView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = k;
      localView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localView6.setTranslationY(-n);
      localView7.setTranslationY(-n);
      localTextView1.setTranslationY(-i1);
      localXListView.setTranscriptMode(0);
      localXListView.setVerticalScrollBarEnabled(false);
    }
    int i;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    if (!paramBoolean)
    {
      j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493085);
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493086);
      i2 = localView1.getPaddingTop();
      i3 = localView1.getPaddingBottom();
      i2 = this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie.a(m - j - i - i2 - i3, this.jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie.a(localImageView);
      paramBoolean = this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie.d();
      i3 = a(8);
      i4 = localTextView1.getHeight();
      i5 = a(4);
      i6 = FloatBaseChatItemLayout.p;
      i7 = FloatBaseChatItemLayout.q;
      if (!paramBoolean) {
        break label1048;
      }
      i = a(20);
      i2 = i7 + (j + i2 - (i3 + i4 + i5) + i6) + i;
      i3 = a(24);
      i4 = a(6);
      i5 = FloatBaseChatItemLayout.s;
      j = 0;
      i = j;
      if (paramMsgBarInfo != null)
      {
        i = j;
        if (!TextUtils.isEmpty(paramMsgBarInfo.jdField_a_of_type_JavaLangCharSequence))
        {
          localTextView3.setVisibility(0);
          localObject = (FrameLayout.LayoutParams)localView3.getLayoutParams();
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localTextView3.getLayoutParams();
          localLayoutParams.leftMargin = ((FrameLayout.LayoutParams)localObject).leftMargin;
          localLayoutParams.topMargin = ((FrameLayout.LayoutParams)localObject).topMargin;
          localTextView2.setText(paramMsgBarInfo.b);
          localTextView3.setText(paramMsgBarInfo.jdField_a_of_type_JavaLangCharSequence);
          i = (int)localTextView3.getPaint().measureText(paramMsgBarInfo.jdField_a_of_type_JavaLangCharSequence.toString());
          localTextView2.setTranslationX(i);
        }
      }
      localView4.setVisibility(0);
      localView4.setAlpha(0.0F);
      j = this.jdField_a_of_type_ArrayOfInt[0];
      i6 = this.jdField_a_of_type_ArrayOfInt[1];
      paramMsgBarInfo = (FrameLayout.LayoutParams)localView4.getLayoutParams();
      localObject = (FrameLayout.LayoutParams)localView3.getLayoutParams();
      paramMsgBarInfo.width = j;
      paramMsgBarInfo.height = i6;
      paramMsgBarInfo.topMargin = (((FrameLayout.LayoutParams)localObject).topMargin + localView3.getPaddingTop() - FloatBaseChatItemLayout.q);
      paramMsgBarInfo.leftMargin = (((FrameLayout.LayoutParams)localObject).leftMargin + localView3.getPaddingLeft() - FloatBaseChatItemLayout.s);
      localTextView2.setMaxWidth(j - FloatBaseChatItemLayout.t - FloatBaseChatItemLayout.s);
      localTextView2.setSingleLine(false);
      i6 = a(60);
      if (!paramBoolean) {
        break label1053;
      }
    }
    label1048:
    label1053:
    for (int j = a(20);; j = 0)
    {
      localImageView.setVisibility(0);
      localImageView.setAlpha(0.2F);
      localObject = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
      i7 = ((FrameLayout.LayoutParams)localObject).topMargin;
      ((FrameLayout.LayoutParams)localObject).topMargin = (paramMsgBarInfo.topMargin + i7);
      ((FrameLayout.LayoutParams)localObject).rightMargin = (((FrameLayout.LayoutParams)localObject).rightMargin - localView3.getPaddingLeft() - localView1.getPaddingLeft());
      i7 = localView1.getLeft();
      int i8 = localView1.getRight();
      int i9 = localView1.getTop();
      paramMsgBarInfo = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      paramMsgBarInfo.setDuration(400L);
      paramMsgBarInfo.setInterpolator(new DecelerateInterpolator(1.2F));
      paramMsgBarInfo.addListener(new glo(this, localView2, localView6, localView1, localView5, localView7, localTextView3, localXListView, localView3, localView4, localImageView));
      paramMsgBarInfo.addUpdateListener(new gls(this, k, m, localView1, i7, i9, i8, localTextView1, i1, localView2, localView3, i2, i3 + i4 + i5, i, localTextView2, localTextView3, localView4, localImageView, i2 - j, i6, localView6, n, localView7));
      paramMsgBarInfo.start();
      return;
      i = 0;
      break;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie.a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie.s();
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie.t();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatAioPage
 * JD-Core Version:    0.7.0.1
 */