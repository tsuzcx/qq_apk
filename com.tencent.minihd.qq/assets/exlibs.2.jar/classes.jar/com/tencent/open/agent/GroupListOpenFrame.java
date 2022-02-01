package com.tencent.open.agent;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.open.base.LogUtility;
import com.tencent.widget.XListView;
import lbv;

public class GroupListOpenFrame
  extends OpenFrame
{
  protected static final String a = "GroupListOpenFrame";
  protected EditText a;
  protected TextView a;
  protected GroupListOpenFrame.GroupListAdapter a;
  protected RecommendListManager a;
  protected XListView a;
  protected TextView b;
  
  public GroupListOpenFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.b();
    LogUtility.c("GroupListOpenFrame", "-->onResume()");
    super.a();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    LogUtility.c("GroupListOpenFrame", "-->onCreate()");
    super.setContentView(2130904427);
    this.jdField_a_of_type_ComTencentOpenAgentGroupListOpenFrame$GroupListAdapter = new GroupListOpenFrame.GroupListAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131298897));
    paramBundle = (LinearLayout)super.a().getLayoutInflater().inflate(2130903442, null);
    paramBundle.findViewById(2131299461).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131298256));
    this.b = ((TextView)paramBundle.findViewById(2131298263));
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager = ((RecommendListManager)paramBundle.findViewById(2131298257));
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.setActivity(this.jdField_a_of_type_ComTencentOpenAgentFriendChooser);
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.a();
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131427375);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentGroupListOpenFrame$GroupListAdapter);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramBundle.findViewById(2131299473));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new lbv(this));
  }
  
  public void a(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    LogUtility.c("GroupListOpenFrame", "-->onStart()");
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a(false, true, "", this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.getString(2131362650));
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenAgentGroupListOpenFrame$GroupListAdapter.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.setVisibility(0);
      this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.GroupListOpenFrame
 * JD-Core Version:    0.7.0.1
 */