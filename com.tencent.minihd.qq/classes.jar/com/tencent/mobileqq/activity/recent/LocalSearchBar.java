package com.tencent.mobileqq.activity.recent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import guy;

public class LocalSearchBar
  implements DialogInterface.OnDismissListener, View.OnClickListener, Animation.AnimationListener, AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private View jdField_a_of_type_AndroidViewView;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton = null;
  private SearchResultDialog jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = null;
  private OnRecentUserOpsListener jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private int jdField_b_of_type_Int = 4;
  private long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton = null;
  private int jdField_c_of_type_Int = 1;
  private long jdField_c_of_type_Long = 0L;
  private View jdField_c_of_type_AndroidViewView;
  
  public LocalSearchBar(XListView paramXListView, View paramView1, View paramView2, BaseActivity paramBaseActivity, OnRecentUserOpsListener paramOnRecentUserOpsListener, View paramView3, int paramInt1, int paramInt2)
  {
    if (paramView3 != null) {}
    for (paramXListView = paramView3;; paramXListView = null)
    {
      if (paramXListView == null) {
        paramXListView = paramView1.findViewById(2131297008);
      }
      for (;;)
      {
        paramXListView.findViewById(2131299461).setVisibility(8);
        IphoneTitleBarActivity.setLayerType(paramXListView);
        this.jdField_a_of_type_AndroidViewView = paramView1;
        this.jdField_b_of_type_AndroidViewView = paramView2;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = paramOnRecentUserOpsListener;
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
        this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297977);
        this.jdField_b_of_type_Int = paramInt1;
        this.jdField_c_of_type_Int = paramInt2;
        paramView1 = (EditText)paramXListView.findViewById(2131299473);
        paramView1.setFocusableInTouchMode(false);
        paramView1.setCursorVisible(false);
        paramView1.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramXListView.findViewById(2131302027));
        this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)paramXListView.findViewById(2131300437));
        b(null);
        return;
      }
    }
  }
  
  private void b(Configuration paramConfiguration)
  {
    int j = 0;
    if ((paramConfiguration != null) && (paramConfiguration.orientation == 2))
    {
      Conversation.b = false;
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130842152);
    }
    int i;
    if (paramConfiguration == null)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getConfiguration().orientation;
      if (i != 2) {
        break label123;
      }
      if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      }
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null)
      {
        paramConfiguration = this.jdField_b_of_type_AndroidWidgetImageButton;
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) {
          i = 8;
        }
        paramConfiguration.setVisibility(i);
      }
    }
    for (;;)
    {
      if (!(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof Conversation)) {
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      }
      return;
      i = paramConfiguration.orientation;
      break;
      label123:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "showSearchDialog() mLoaLocalSearchDialog = " + this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) {
      return;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = new guy(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_b_of_type_Int, this, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.setOnDismissListener(this);
    }
    if ((this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null) || (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null))
    {
      this.jdField_a_of_type_Int = 30;
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -this.jdField_a_of_type_Int, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    }
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130837687);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.show();
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   4: ifnull +19 -> 23
    //   7: iconst_1
    //   8: invokestatic 211	com/tencent/mobileqq/activity/Conversation:b	(Z)V
    //   11: aload_0
    //   12: getfield 30	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   15: invokevirtual 214	com/tencent/mobileqq/activity/contact/SearchResultDialog:dismiss	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 30	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   23: return
    //   24: astore_1
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 30	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   30: return
    //   31: astore_1
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 30	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	LocalSearchBar
    //   24	1	1	localException	java.lang.Exception
    //   31	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	24	java/lang/Exception
    //   7	18	31	finally
  }
  
  public void a(Configuration paramConfiguration)
  {
    b(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.a(paramConfiguration);
    }
  }
  
  /* Error */
  public void a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   4: ifnull +19 -> 23
    //   7: iconst_1
    //   8: invokestatic 211	com/tencent/mobileqq/activity/Conversation:b	(Z)V
    //   11: aload_0
    //   12: getfield 30	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   15: invokevirtual 214	com/tencent/mobileqq/activity/contact/SearchResultDialog:dismiss	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 30	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   23: return
    //   24: astore_1
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 30	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   30: return
    //   31: astore_1
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 30	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	LocalSearchBar
    //   0	39	1	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   7	18	24	java/lang/Exception
    //   7	18	31	finally
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramLong = System.currentTimeMillis();
    long l = Math.abs(paramLong - this.jdField_b_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onItemClick() gap = " + l);
    }
    if (l < 250L) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "onItemClick() 点击太快了吧， pos = " + paramInt);
      }
    }
    label183:
    for (;;)
    {
      return;
      this.jdField_b_of_type_Long = paramLong;
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "onItemClick() pos = " + paramInt);
      }
      paramAdapterView = paramAdapterView.a();
      if (paramAdapterView == null) {}
      for (paramAdapterView = null;; paramAdapterView = paramAdapterView.getItem(paramInt))
      {
        if (!(paramAdapterView instanceof ContactsSearchableRecentUser)) {
          break label183;
        }
        paramAdapterView = (ContactsSearchableRecentUser)paramAdapterView;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramView, paramAdapterView, paramAdapterView.a(), false);
        return;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) {
      Conversation.b(true);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) && (AIOUtils.h)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.dismiss();
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation)
    {
      this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidViewView.requestLayout();
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setBackgroundResource(0);
      }
    }
    while (paramAnimation != this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.show();
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setAnimation(null);
    }
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.PerfTrace", 2, "conversationTab search up anim time: " + (System.currentTimeMillis() - this.jdField_c_of_type_Long));
    }
    ThreadPriorityManager.a(false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageButton) {
      if (Conversation.b) {
        ((Conversation)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).k();
      }
    }
    long l;
    do
    {
      return;
      ((Conversation)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).c(true);
      return;
      l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "onClick() time stamp = " + (l - this.jdField_a_of_type_Long));
      }
    } while (l - this.jdField_a_of_type_Long <= 1000L);
    this.jdField_a_of_type_Long = l;
    Conversation.b(false);
    d();
    b(null);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    Conversation.b(true);
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130837687);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = null;
    b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.LocalSearchBar
 * JD-Core Version:    0.7.0.1
 */