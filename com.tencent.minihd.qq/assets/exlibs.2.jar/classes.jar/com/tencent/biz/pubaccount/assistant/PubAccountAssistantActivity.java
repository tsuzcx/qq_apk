package com.tencent.biz.pubaccount.assistant;

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
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import cka;
import ckb;
import ckc;
import ckd;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentPubAccountAssistantItem;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class PubAccountAssistantActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, Observer
{
  static final int jdField_a_of_type_Int = 1001;
  private static final String jdField_a_of_type_JavaLangString = "PubAccountAssistantActivity";
  Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ckd(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ckc(this);
  SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  boolean jdField_a_of_type_Boolean;
  public boolean b = true;
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131298143));
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2130903611, null);
    View localView = getLayoutInflater().inflate(2130903174, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b(localView);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(this, this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, this, 3);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
  }
  
  private void e()
  {
    setTitle(2131363628);
    this.rightViewText.setText(2131363717);
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setOnClickListener(this);
    c();
    String str2 = this.leftView.getText().toString();
    String str1 = str2;
    if (!getString(2131365114).equals(str2)) {
      str1 = String.format(getResources().getString(2131363640), new Object[] { getResources().getString(2131366025) });
    }
    this.leftView.setContentDescription(str1);
  }
  
  private void f()
  {
    if (PubAccountAssistantManager.a().a(this.app)) {
      PubAccountAssistantManager.a().a(this.app.a().createEntityManager(), this.app);
    }
    if (this.b)
    {
      this.b = PubAccountAssistantManager.a().c(this.app);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.b))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(8);
        PubAccountAssistantManager.a().b(this.app, false);
        a();
      }
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.a().addObserver(this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.app);
    }
  }
  
  protected List a()
  {
    List localList = PubAccountAssistantManager.a().a(this.app);
    int i;
    ArrayList localArrayList;
    int j;
    label30:
    Object localObject;
    if (localList == null)
    {
      i = 0;
      localArrayList = new ArrayList();
      j = 0;
      if (j >= i) {
        break label188;
      }
      localObject = (PubAccountAssistantData)localList.get(j);
      if (localObject != null) {
        break label71;
      }
    }
    for (;;)
    {
      j += 1;
      break label30;
      i = localList.size();
      break;
      label71:
      localObject = new RecentPubAccountAssistantItem((PubAccountAssistantData)localObject);
      ((RecentPubAccountAssistantItem)localObject).a(this.app, BaseApplication.getContext());
      if (QLog.isDevelopLevel())
      {
        long l = System.currentTimeMillis();
        QLog.i("Q.recent.cost", 4, "[" + (l - 0L) + ", " + ((RecentPubAccountAssistantItem)localObject).a() + "," + localObject.getClass().getName() + "]");
        ((RecentPubAccountAssistantItem)localObject).a();
      }
      localArrayList.add(localObject);
    }
    label188:
    return localArrayList;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b()) {
        break label41;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    label41:
    while (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if ((paramRecentBaseData == null) || (TextUtils.isEmpty(paramRecentBaseData.a()))) {
      return;
    }
    if (paramRecentBaseData.b() > 0) {
      this.jdField_a_of_type_Boolean = true;
    }
    String str = paramRecentBaseData.a();
    if (paramRecentBaseData.a() == 1024)
    {
      ReportController.b(this.app, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, str, "1", "", "");
      paramView = new Intent(this, ChatActivity.class);
      paramView.putExtra("chat_subType", 1);
      paramView.putExtra("uintype", 1024);
    }
    for (;;)
    {
      paramView.putExtra("uin", str);
      paramView.putExtra("uinname", paramString);
      startActivity(paramView);
      return;
      PublicAccountHandler.a(this.app, str, "Pb_account_lifeservice", "mp_msg_sys_4", "contacts_aio");
      paramView = new Intent(this, ChatActivity.class);
      paramView.putExtra("uintype", 1008);
    }
  }
  
  public void a(View paramView, ContactsSearchableRecentUser paramContactsSearchableRecentUser, String paramString, boolean paramBoolean) {}
  
  public void a(View paramView, Object paramObject)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298967: 
      this.b = false;
      startActivity(new Intent(this, PubAccountAssistantSettingActivity.class));
      ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.app.getAccount(), "mp_msg_zhushou_shezhi", "share_succ", 0, 0, "", "", "", "");
      return;
    }
    this.b = false;
    b();
    ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.app.getAccount(), "mp_msg_zhushou_know", "share_succ", 0, 0, "", "", "", "");
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData == null) {}
    do
    {
      return;
      paramRecentBaseData = paramRecentBaseData.a();
      PubAccountAssistantManager.a().c(paramRecentBaseData, this.app);
      b();
      this.app.a().c(paramRecentBaseData, 1008);
      paramRecentBaseData = this.app.a(Conversation.class);
    } while (paramRecentBaseData == null);
    paramRecentBaseData.sendEmptyMessage(1014);
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    }
  }
  
  public void c() {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    setContentView(2130903608);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    d();
    e();
    f();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.app.getAccount(), "mp_msg_zhushou_1", "share_succ", 0, 0, "", "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
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
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
    if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(0);
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        localObject = this.app.a().a(((RecentBaseData)localObject).a(), ((RecentBaseData)localObject).a());
        if (localObject != null)
        {
          PubAccountAssistantManager.a().a(this.app, ((QQMessageFacade.Message)localObject).time);
          localObject = this.app.a(Conversation.class);
          if (localObject != null) {
            ((Handler)localObject).sendEmptyMessage(1009);
          }
        }
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (isFinishing()) {}
    do
    {
      do
      {
        return true;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null) || (paramMessage.what != 1001));
      try
      {
        runOnUiThread(new cka(this, a()));
        return true;
      }
      catch (Exception paramMessage) {}
    } while (!QLog.isColorLevel());
    QLog.i("PubAccountAssistantActivity", 2, paramMessage.toString());
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    this.b = false;
    startActivity(new Intent(this, PubAccountAssistantSettingActivity.class));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!paramObservable.isSendFromLocal()) {
        runOnUiThread(new ckb(this));
      }
      if ((!paramObservable.isSendFromLocal()) || (paramObservable.msgtype != -2002)) {}
    }
    while (!(paramObject instanceof RecentUser))
    {
      return;
      b();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.assistant.PubAccountAssistantActivity
 * JD-Core Version:    0.7.0.1
 */