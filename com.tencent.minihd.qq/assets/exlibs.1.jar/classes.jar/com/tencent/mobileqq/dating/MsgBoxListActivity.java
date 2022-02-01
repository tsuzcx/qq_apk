package com.tencent.mobileqq.dating;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import idh;
import idj;
import idk;
import idm;
import idn;
import ido;
import idp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;

public class MsgBoxListActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, IFlingSwitch, AbsListView.OnScrollListener, SwipListView.RightIconMenuListener, Observer
{
  private static final int jdField_a_of_type_Int = 0;
  public static final String a = "msgType";
  private static final String jdField_b_of_type_JavaLangString = "DatingMsgListActivity";
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new idj(this);
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new idh(this);
  private CarrierHelper jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper;
  private FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  protected FaceDecoder a;
  private List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean = false;
  private String d = "";
  
  private TopGestureLayout a()
  {
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    Object localObject = localViewGroup;
    if (localView != null)
    {
      localObject = localViewGroup;
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
    }
    localObject = ((ViewGroup)localObject).getChildAt(0);
    if ((localObject instanceof TopGestureLayout)) {
      return (TopGestureLayout)localObject;
    }
    return null;
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    Intent localIntent = new Intent(paramContext, MsgBoxListActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  private void a(List paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    Object localObject = null;
    Iterator localIterator = paramList.iterator();
    label21:
    boolean bool;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (TextUtils.isEmpty(localMessageRecord.senderuin))
        {
          localIterator.remove();
        }
        else
        {
          if (localMessageRecord.istroop != 7100) {
            break label314;
          }
          localObject = localMessageRecord;
          if (!this.jdField_c_of_type_Boolean)
          {
            localObject = localMessageRecord;
            if (this.jdField_b_of_type_Int == 1001)
            {
              long l1 = this.app.a().j(this.jdField_c_of_type_JavaLangString);
              long l2 = localMessageRecord.time;
              if (this.app.a().a(localMessageRecord.senderuin, localMessageRecord.istroop) <= 0) {
                break label277;
              }
              bool = true;
              label148:
              if (QLog.isDevelopLevel()) {
                QLog.d("DatingMsgListActivity", 4, "checkMessageList lastEnterTime=" + l1 + " msgTime=" + l2 + " hasUnread=" + bool);
              }
              if ((l1 < l2) && (bool))
              {
                this.jdField_c_of_type_Boolean = true;
                ReportController.b(this.app, "CliOper", "", "", "0X80050D5", "0X80050D5", 0, 0, "", "", "", "");
              }
              localObject = localMessageRecord;
              if (l1 < l2)
              {
                this.app.a().h(this.jdField_c_of_type_JavaLangString, l2);
                localObject = localMessageRecord;
              }
            }
          }
        }
      }
    }
    label277:
    label314:
    for (;;)
    {
      break label21;
      bool = false;
      break label148;
      if ((!this.jdField_c_of_type_Boolean) || (localObject == null)) {
        break;
      }
      paramList.remove(localObject);
      paramList.add(0, localObject);
      return;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (!a())
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected List a()
  {
    if ((this.jdField_b_of_type_Int == -1) || (this.jdField_c_of_type_JavaLangString == null)) {
      return null;
    }
    Object localObject = this.app.a(this.jdField_b_of_type_Int).a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Int);
    a((List)localObject);
    int i;
    ArrayList localArrayList;
    label73:
    String str;
    if (localObject == null)
    {
      i = 0;
      localArrayList = new ArrayList(i);
      Iterator localIterator = ((List)localObject).iterator();
      if (!localIterator.hasNext()) {
        break label259;
      }
      localObject = (MessageRecord)localIterator.next();
      str = ((MessageRecord)localObject).senderuin + "_" + ((MessageRecord)localObject).istroop;
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(str)) {
        break label231;
      }
      localObject = (RecentMsgBoxItem)this.jdField_a_of_type_JavaUtilMap.get(str);
    }
    for (;;)
    {
      ((RecentMsgBoxItem)localObject).a(this.app, BaseApplication.getContext());
      localArrayList.add(localObject);
      if (!QLog.isDevelopLevel()) {
        break label73;
      }
      QLog.d("DatingMsgListActivity", 4, "item update time cost = " + (System.currentTimeMillis() - 0L));
      break label73;
      i = ((List)localObject).size();
      break;
      label231:
      localObject = new RecentMsgBoxItem((MessageRecord)localObject);
      this.jdField_a_of_type_JavaUtilMap.put(str, localObject);
    }
    label259:
    if (QLog.isDevelopLevel())
    {
      long l = System.currentTimeMillis();
      QLog.d("DatingMsgListActivity", 4, "makeRecetBaseData | Message Record size:" + i + " | start cost time:" + (0L - this.jdField_a_of_type_Long) + " | makeRecetBaseData cost time:" + (l - 0L));
    }
    return localArrayList;
  }
  
  public void a()
  {
    QQMessageFacade localQQMessageFacade = this.app.a();
    int i;
    if (localQQMessageFacade != null)
    {
      i = localQQMessageFacade.e();
      if (i <= 0) {
        break label105;
      }
      if (i > 99) {
        this.leftView.setText(getString(2131366025) + "(99+)");
      }
    }
    else
    {
      return;
    }
    this.leftView.setText(getString(2131366025) + "(" + i + ")");
    return;
    label105:
    setLeftViewName(getIntent().putExtra("leftViewText", getString(2131366025)));
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    paramView = paramRecentBaseData.a();
    paramString = (FriendManager)this.app.getManager(8);
    if (paramString != null) {}
    for (paramBoolean = paramString.b(paramView);; paramBoolean = false)
    {
      Intent localIntent = new Intent(this, ChatActivity.class);
      localIntent.putExtra("uin", paramView);
      if (paramBoolean) {
        localIntent.putExtra("uintype", 0);
      }
      for (;;)
      {
        paramString = ContactUtils.m(this.app, paramRecentBaseData.a());
        paramView = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramView = ContactUtils.b(this.app, paramRecentBaseData.a(), false);
        }
        localIntent.putExtra("uinname", paramView);
        startActivity(localIntent);
        return;
        localIntent.putExtra("uintype", paramRecentBaseData.a());
        if (paramRecentBaseData.a() == 7100) {
          ReportController.b(this.app, "CliOper", "", "", "0X80050D6", "0X80050D6", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void a(View paramView, ContactsSearchableRecentUser paramContactsSearchableRecentUser, String paramString, boolean paramBoolean) {}
  
  public void a(View paramView, Object paramObject) {}
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData != null)
    {
      if (this.app.a().a(paramRecentBaseData.a(), paramRecentBaseData.a()) > 0)
      {
        this.d = (paramRecentBaseData.a() + "_" + this.jdField_b_of_type_Int);
        RecentUtil.a(this.app, paramRecentBaseData.a(), this.jdField_b_of_type_Int);
        this.app.a().c(paramRecentBaseData.a(), this.jdField_b_of_type_Int);
      }
      this.app.a().a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Int, paramRecentBaseData.a(), this.app.a());
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    if ((paramInt == 0) || (paramInt == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(false);
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = paramInt;
      if ((paramInt != 0) || (!this.jdField_b_of_type_Boolean)) {
        break;
      }
      b();
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(true);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) {
      b();
    }
  }
  
  protected boolean a()
  {
    return (this.jdField_c_of_type_Int != 0) && (this.jdField_c_of_type_Int != 1);
  }
  
  public void b(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903944);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131300162));
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_b_of_type_Int = getIntent().getIntExtra("uintype", -1);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)findViewById(2131300158));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131300159);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
    if (this.jdField_b_of_type_Int == 1010)
    {
      setTitle(2131369715);
      paramBundle = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300161);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300160)).setImageResource(2130840380);
      paramBundle.setText(getResources().getString(2131369788));
      if ((this.jdField_b_of_type_Int == 1010) || (this.jdField_b_of_type_Int == 1001)) {
        if (this.jdField_b_of_type_Int != 1010) {
          break label492;
        }
      }
    }
    label492:
    for (int i = 2;; i = 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper = new CarrierHelper(this, null, i);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a(this));
      ThreadManager.c(new idk(this));
      this.jdField_a_of_type_AndroidOsHandler = new CustomHandler(ThreadManager.b(), this);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new idm(this));
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver, true);
      this.app.a().addObserver(this);
      if (QLog.isColorLevel())
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        QLog.d("DatingMsgListActivity", 2, "BOX UIN:" + this.jdField_c_of_type_JavaLangString + "|BOX TYPE:" + this.jdField_b_of_type_Int);
      }
      return true;
      if (this.jdField_b_of_type_Int == 1001)
      {
        setTitle(2131366652);
        paramBundle = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300161);
        ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300160)).setImageResource(2130840359);
        paramBundle.setText(getResources().getString(2131365779));
        break;
      }
      if (this.jdField_b_of_type_Int != 1009) {
        break;
      }
      setTitle(2131366665);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper != null) {
      ThreadManager.c(new idn(this));
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a(1, Boolean.valueOf(false));
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a();
    b();
    this.jdField_c_of_type_Int = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a(1, Boolean.valueOf(true));
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_JavaUtilList = a();
      runOnUiThread(new ido(this));
    }
  }
  
  protected boolean onBackEvent()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.putExtra("tab_index", 1);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
    return super.onBackEvent();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_Boolean = true;
      }
    }
    else
    {
      return;
    }
    paramObject = paramObservable.senderuin + "_" + paramObservable.istroop;
    if (QLog.isColorLevel()) {
      QLog.d("DatingMsgListActivity", 2, "update key:" + paramObject + "|mDelItemKey:" + this.d);
    }
    if (paramObject.equals(this.d))
    {
      this.d = "";
      return;
    }
    runOnUiThread(new idp(this, paramObservable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxListActivity
 * JD-Core Version:    0.7.0.1
 */