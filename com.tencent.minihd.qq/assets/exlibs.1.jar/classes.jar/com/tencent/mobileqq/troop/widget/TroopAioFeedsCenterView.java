package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import kog;

public class TroopAioFeedsCenterView
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, Observer
{
  protected static final String a = "TroopAioFeedsCenterView";
  protected Context a;
  protected ViewPager a;
  protected GestureDetector a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected SessionInfo a;
  protected QQAppInterface a;
  protected TroopFeedsDataManager a;
  protected DotIndexView a;
  protected TroopAioFeedsCenterView.FeedPagerAdapter a;
  public TroopAioFeedsCenterView.FlingGestureListener a;
  public TroopFeedViewFactory a;
  protected boolean a;
  
  public TroopAioFeedsCenterView(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager = ((TroopInfoManager)paramQQAppInterface.getManager(36)).a(Long.valueOf(Long.parseLong(paramSessionInfo.a)), true);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.addObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory = new TroopFeedViewFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager, this.jdField_a_of_type_Boolean);
    a(paramQQAppInterface, paramContext);
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    inflate(paramContext, 2130903682, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299297));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131299196));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetDotIndexView = ((DotIndexView)findViewById(2131299298));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131299299));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297582));
    if (NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("加载中，请稍候...");
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new kog(this, paramContext));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView$FeedPagerAdapter = new TroopAioFeedsCenterView.FeedPagerAdapter(this);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView$FeedPagerAdapter);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetDotIndexView.a(0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.size());
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("当前网络不可用");
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetDotIndexView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("加载中，请稍候...");
  }
  
  void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.size())) {}
    TroopFeedItem localTroopFeedItem;
    do
    {
      return;
      localTroopFeedItem = (TroopFeedItem)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.get(paramInt);
    } while (localTroopFeedItem == null);
    int i = localTroopFeedItem.type;
    if (paramInt == 0) {}
    for (String str = "0";; str = "1") {
      switch (i)
      {
      default: 
        return;
      case 0: 
      case 131: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_file", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
        return;
      }
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_bulletin", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_know", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_music", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_photo", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_video", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_vote", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_other", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, localTroopFeedItem.ex_1, "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetDotIndexView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("加载中，请稍候...");
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.deleteObserver(this);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0) {}
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetDotIndexView.setDotSelected(paramInt, true);
    a(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0) {
      return true;
    }
    return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public void setFlingGestureListener(TroopAioFeedsCenterView.FlingGestureListener paramFlingGestureListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView$FlingGestureListener = paramFlingGestureListener;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if ((paramObservable.intValue() != 101) && (paramObservable.intValue() != 102)) {
        break label197;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.size() != 0) {
        break label121;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetDotIndexView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("暂时没有新通知");
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView$FeedPagerAdapter.notifyDataSetChanged();
      if (paramObservable.intValue() == 101)
      {
        if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == 0) {
          a(0);
        }
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
      }
    }
    label121:
    while (paramObservable.intValue() != 103) {
      for (;;)
      {
        return;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.size() == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetDotIndexView.setVisibility(8);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetDotIndexView.a(0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.size());
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetDotIndexView.setVisibility(0);
        }
      }
    }
    label197:
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetDotIndexView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("数据加载失败");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("当前网络不可用");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView
 * JD-Core Version:    0.7.0.1
 */