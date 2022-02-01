package com.tencent.biz.pubaccount.assistant;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import ckh;
import cki;
import ckj;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.XListView;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class PubAccountAssistantSettingActivity
  extends IphoneTitleBarActivity
{
  private Handler jdField_a_of_type_AndroidOsHandler = new ckh(this);
  private PubAccountAssistantSettingAdapter jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter;
  private PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new cki(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private Comparator jdField_a_of_type_JavaUtilComparator = new ckj(this);
  private List jdField_a_of_type_JavaUtilList;
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList = ((PublicAccountDataManager)this.app.getManager(54)).a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    label84:
    while (localIterator.hasNext())
    {
      PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localIterator.next();
      if ((localPublicAccountInfo.accountFlag & 0x800000) != 0) {}
      for (int i = 1;; i = 0)
      {
        if ((localPublicAccountInfo.mShowMsgFlag != -1) && (i == 0)) {
          break label84;
        }
        localIterator.remove();
        break;
      }
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter = new PubAccountAssistantSettingAdapter(this.app, getApplicationContext(), this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903604);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131298961));
    paramBundle = View.inflate(this, 2130903605, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(paramBundle);
    a();
    setTitle(2131363633);
    paramBundle = (PublicAccountHandler)this.app.a(10);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    paramBundle.a();
    String str = this.leftView.getText().toString();
    paramBundle = str;
    if (!getString(2131365114).equals(str)) {
      paramBundle = String.format(getResources().getString(2131363640), new Object[] { str });
    }
    this.leftView.setContentDescription(paramBundle);
    ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.app.getAccount(), "mp_msg_zhushou_2", "share_succ", 0, 0, "", "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.assistant.PubAccountAssistantSettingActivity
 * JD-Core Version:    0.7.0.1
 */