package com.tencent.biz.pubaccount.ecshopassit;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import cko;
import ckp;
import ckq;
import ckr;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class EcShopAssistantActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, Observer
{
  static final int jdField_a_of_type_Int = 10001;
  private static final String jdField_a_of_type_JavaLangString = "EcShopAssistantActivity";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private EcShopAssistantManager jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager;
  public RecentAdapter a;
  public DragFrameLayout a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ckq(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ckp(this);
  private SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  
  private void b()
  {
    super.setTitle(2131369995);
    String str = this.leftView.getText().toString();
    Object localObject = str;
    if (!getString(2131365114).equals(str)) {
      localObject = String.format(getResources().getString(2131363640), new Object[] { getResources().getString(2131366025) });
    }
    this.leftView.setContentDescription((CharSequence)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131298143));
    localObject = getLayoutInflater().inflate(2130903174, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(this, this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, this, 5);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(10001);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(10001);
    }
  }
  
  protected List a()
  {
    List localList = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.a();
    int i;
    ArrayList localArrayList;
    int j;
    label27:
    Object localObject;
    if (localList == null)
    {
      i = 0;
      localArrayList = new ArrayList();
      j = 0;
      if (j >= i) {
        break label180;
      }
      localObject = (EcShopData)localList.get(j);
      if (localObject != null) {
        break label68;
      }
    }
    for (;;)
    {
      j += 1;
      break label27;
      i = localList.size();
      break;
      label68:
      localObject = new RecentItemEcShop((EcShopData)localObject);
      ((RecentItemEcShop)localObject).a(this.app, BaseApplication.getContext());
      if (QLog.isDevelopLevel())
      {
        long l = System.currentTimeMillis();
        QLog.i("Q.recent.cost", 4, "[" + (l - 0L) + ", " + ((RecentItemEcShop)localObject).a() + "," + localObject.getClass().getName() + "]");
        ((RecentItemEcShop)localObject).a();
      }
      localArrayList.add(localObject);
    }
    label180:
    return localArrayList;
  }
  
  public void a() {}
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if ((paramRecentBaseData == null) || (TextUtils.isEmpty(paramRecentBaseData.a()))) {
      return;
    }
    paramView = paramRecentBaseData.a();
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("uin", paramView);
    localIntent.putExtra("uinname", paramString);
    super.startActivity(localIntent);
    ReportController.b(this.app, "P_CliOper", "Shop_lifeservice", "", "Shop_helper", "Clk_shopItem", 0, 0, paramView, "", paramRecentBaseData.b(), "");
  }
  
  public void a(View paramView, ContactsSearchableRecentUser paramContactsSearchableRecentUser, String paramString, boolean paramBoolean) {}
  
  public void a(View paramView, Object paramObject) {}
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EcShopAssistantActivity", 2, "onRecentBaseDataDelete uin:" + paramRecentBaseData.a());
      }
      paramRecentBaseData = paramRecentBaseData.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.a(paramRecentBaseData);
      }
      c();
      this.app.a().c(paramRecentBaseData, 1008);
      paramRecentBaseData = this.app.a(Conversation.class);
    } while (paramRecentBaseData == null);
    paramRecentBaseData.sendEmptyMessage(1014);
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(10001);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      super.getWindow().setFlags(16777216, 16777216);
    }
    super.setContentView(2130903608);
    super.getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager = ((EcShopAssistantManager)this.app.getManager(83));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.a()) {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.c();
    }
    super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.a().addObserver(this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.app);
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager = null;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(0);
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        localObject = this.app.a().a(((RecentBaseData)localObject).a(), ((RecentBaseData)localObject).a());
        if (localObject != null)
        {
          EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)this.app.getManager(83);
          if (localEcShopAssistantManager != null)
          {
            localEcShopAssistantManager.a(((QQMessageFacade.Message)localObject).time);
            localObject = this.app.a(Conversation.class);
            if (localObject != null) {
              ((Handler)localObject).sendEmptyMessage(1009);
            }
          }
        }
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    c();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (super.isFinishing()) {}
    do
    {
      do
      {
        return true;
      } while (paramMessage.what != 10001);
      try
      {
        super.runOnUiThread(new cko(this, a()));
        return true;
      }
      catch (Exception paramMessage) {}
    } while (!QLog.isColorLevel());
    QLog.i("EcShopAssistantActivity", 2, paramMessage.toString());
    return true;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!paramObservable.isSendFromLocal()) {
        runOnUiThread(new ckr(this));
      }
      if ((!paramObservable.isSendFromLocal()) || (paramObservable.msgtype != -2002)) {}
    }
    while (!(paramObject instanceof RecentUser))
    {
      return;
      c();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantActivity
 * JD-Core Version:    0.7.0.1
 */