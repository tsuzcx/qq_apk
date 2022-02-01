package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.TroopMessageSettingAdapter;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import com.tencent.widget.XExpandableListView;
import ffn;
import ffo;
import ffp;
import ffq;
import ffr;
import ffs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class TroopAssisSettingActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new ffn(this);
  public TroopMessageSettingAdapter a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ffr(this);
  private XExpandableListView jdField_a_of_type_ComTencentWidgetXExpandableListView;
  public String a;
  public List a;
  public Map a;
  
  private View a()
  {
    ArrayList localArrayList = null;
    Object localObject1 = b();
    Object localObject2 = getActivity().getLayoutInflater().inflate(2130903174, null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView = ((XExpandableListView)View.inflate(this, 2130903356, null));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.a((View)localObject1);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.b((View)localObject2);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setBackgroundColor(0);
    localObject1 = (ContactFacade)this.app.getManager(52);
    if (localObject1 != null) {
      localArrayList = ((ContactFacade)localObject1).a("-1003");
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (localArrayList != null)
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Entity)((Iterator)localObject1).next();
        this.jdField_a_of_type_JavaUtilList.add(((TroopInfo)localObject2).troopuin);
      }
    }
    this.jdField_a_of_type_JavaUtilMap = TroopAssistantManager.a().a(this.app, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter = new TroopMessageSettingAdapter(this, this.app, localArrayList, this.jdField_a_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter);
    d();
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setFooterDividersEnabled(true);
    return this.jdField_a_of_type_ComTencentWidgetXExpandableListView;
  }
  
  private View b()
  {
    View localView = View.inflate(this, 2130903355, null);
    localView.findViewById(2131297905).setFocusable(true);
    Object localObject = (Switch)localView.findViewById(2131297906);
    ((Switch)localObject).setChecked(TroopAssistantManager.a().a());
    ((Switch)localObject).setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    localObject = (TextView)localView.findViewById(2131297907);
    if (TroopAssistantManager.a().d(this.app)) {
      TroopAssistantManager.a().g(this.app);
    }
    for (int i = 2131368184;; i = 2131368183)
    {
      ((TextView)localObject).setText(i);
      ((TextView)localObject).setFocusable(true);
      return localView;
    }
  }
  
  private void c()
  {
    if (this.app != null)
    {
      Handler localHandler = this.app.a(Conversation.class);
      if (localHandler != null) {
        localHandler.sendEmptyMessage(1009);
      }
      localHandler = this.app.a(TroopAssistantActivity.class);
      if (localHandler != null) {
        localHandler.sendEmptyMessage(1);
      }
    }
  }
  
  @TargetApi(8)
  private void d()
  {
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setChildDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setCacheColorHint(0);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnItemClickListener(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnGroupClickListener(new ffp(this));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnChildClickListener(new ffq(this));
  }
  
  public void a()
  {
    int i;
    if (this.leftView != null)
    {
      QQMessageFacade localQQMessageFacade = this.app.a();
      if (localQQMessageFacade != null)
      {
        i = localQQMessageFacade.e();
        if (i <= 0) {
          break label110;
        }
        if (i <= 99) {
          break label67;
        }
        this.leftView.setText(getString(2131366025) + "(99+)");
      }
    }
    return;
    label67:
    this.leftView.setText(getString(2131366025) + "(" + i + ")");
    return;
    label110:
    this.leftView.setText(getString(2131366025));
  }
  
  public void a(TroopInfo paramTroopInfo)
  {
    boolean bool2 = true;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramTroopInfo.troopuin)).intValue();
    int j = DBUtils.a().a(paramTroopInfo.troopuin, this.app);
    String str2 = getString(2131368191, new Object[] { StringUtil.a(getBaseContext(), j) });
    String str1;
    if (TextUtils.isEmpty(paramTroopInfo.troopname))
    {
      str1 = paramTroopInfo.troopuin;
      localActionSheet.a(getString(2131368190, new Object[] { str1 }));
      localActionSheet.b(str2);
      if (i != 1) {
        break label233;
      }
      bool1 = true;
      label124:
      localActionSheet.a(2131363786, bool1);
      if (i != 4) {
        break label239;
      }
      bool1 = true;
      label142:
      localActionSheet.a(2131363787, bool1);
      if (i != 2) {
        break label245;
      }
      bool1 = true;
      label160:
      localActionSheet.a(2131363788, bool1);
      if (i != 3) {
        break label251;
      }
    }
    label233:
    label239:
    label245:
    label251:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localActionSheet.a(2131363789, bool1);
      localActionSheet.d(getString(2131365736));
      localActionSheet.a(new ffo(this, i, paramTroopInfo, localActionSheet));
      localActionSheet.show();
      return;
      str1 = paramTroopInfo.troopname;
      break;
      bool1 = false;
      break label124;
      bool1 = false;
      break label142;
      bool1 = false;
      break label160;
    }
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.getGroupCount())
    {
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.c(i);
      i += 1;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = a();
    setContentView(paramBundle);
    paramBundle.setBackgroundColor(getResources().getColor(2131427574));
    setTitle(2131368172);
    b();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.a().addObserver(this);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("from");
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("conversation"))) {
      a();
    }
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
  }
  
  protected void doOnPause()
  {
    c();
    super.doOnPause();
  }
  
  public void finish()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.finish();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageRecord)) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      runOnUiThread(new ffs(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssisSettingActivity
 * JD-Core Version:    0.7.0.1
 */