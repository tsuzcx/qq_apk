package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter.ViewTag;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import dxv;
import dxw;
import dxx;
import dxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ForwardFriendListActivity
  extends BaseForwardSelectionActivity
  implements View.OnClickListener
{
  public static final int a = 1;
  public static final String a = "extra_choose_friend";
  public static final int b = 2;
  public static final String b = "extra_add_special_friend";
  public static final String c = "extra_choose_friend_uin";
  public static final String d = "extra_choose_friend_name";
  public static final String e = "key_is_from_friendsforward_activity";
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ForwardSelectionFriendListAdapter jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private PinnedHeaderExpandableListView jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView;
  private TextView b;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int d;
  
  private void a()
  {
    b();
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView = ((PinnedHeaderExpandableListView)findViewById(2131297739));
    View localView = LayoutInflater.from(getActivity()).inflate(2130904390, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView, false);
    a(localView);
    localView.findViewById(2131299461).setVisibility(8);
    EditText localEditText = (EditText)localView.findViewById(2131299473);
    localEditText.setFocusable(false);
    localEditText.setOnClickListener(this);
    localEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.a(localView);
    this.jdField_c_of_type_Int = getIntent().getIntExtra("extra_choose_friend", 0);
    Utils.b(this, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView);
    Utils.a(this, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      return;
    }
    Contacts.a += 1;
    this.jdField_a_of_type_AndroidAppDialog = new dxv(this, this, this.app, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations, 6);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    paramInt = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -paramInt);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -paramInt, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new dxw(this));
    localTranslateAnimation2.setAnimationListener(new dxx(this, paramInt));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new dxy(this, paramInt, localTranslateAnimation2));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation1);
  }
  
  private void a(View paramView)
  {
    Utils.a(this, paramView);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296742));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297738));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297348));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("选择好友");
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297357));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b = ((TextView)findViewById(2131297358));
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297361));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
    IphoneTitleBarActivity.setLayerType(this.b);
  }
  
  private void c()
  {
    a();
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(49));
    }
    Object localObject1 = this.app;
    Object localObject2 = this.app;
    localObject1 = (FriendManager)((QQAppInterface)localObject1).getManager(8);
    if (localObject1 == null) {
      return false;
    }
    if (!((FriendManager)localObject1).b()) {
      return false;
    }
    localObject1 = ((FriendManager)localObject1).c();
    localObject2 = new ArrayList();
    QQAppInterface localQQAppInterface;
    if (this.jdField_c_of_type_Int == 1)
    {
      localObject3 = new Groups();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        ForwardSelectionFriendListAdapter.b(-1008);
        ((Groups)localObject3).group_id = ForwardSelectionFriendListAdapter.b();
        ((Groups)localObject3).group_name = "最近联系人";
        ((List)localObject2).add(0, localObject3);
        ((List)localObject2).addAll((Collection)localObject1);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter != null) {
        break label215;
      }
      localObject3 = this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView;
      localQQAppInterface = this.app;
      if (this.jdField_c_of_type_Int != 1) {
        break label210;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter = new ForwardSelectionFriendListAdapter(this, (ExpandableListView)localObject3, localQQAppInterface, (List)localObject2, this);
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter);
      return true;
      ForwardSelectionFriendListAdapter.b(0);
      ((Groups)localObject3).group_id = ForwardSelectionFriendListAdapter.b();
      break;
      label210:
      localObject2 = localObject1;
    }
    label215:
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter;
    if (this.jdField_c_of_type_Int == 1) {}
    for (;;)
    {
      ((ForwardSelectionFriendListAdapter)localObject3).a((List)localObject2, true);
      break;
      localObject2 = localObject1;
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      ((SearchResultDialog)this.jdField_a_of_type_AndroidAppDialog).a(paramConfiguration);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.d = getIntent().getIntExtra("extra_add_special_friend", 0);
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawable(null);
    setContentView(2130903330);
    a();
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter.a();
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setAdapter((PinnedHeaderExpandableListView.ExpandableListAdapter)null);
    }
    if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("qqBaseActivity", 2, "SearchResultDialog dismiss Exception:" + localException.toString());
        }
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.d == 2) {
      overridePendingTransition(2130968583, 2130968584);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      localObject = (ForwardSelectionFriendListAdapter.ViewTag)paramView.getTag();
      if (localObject != null)
      {
        localObject = ((ForwardSelectionFriendListAdapter.ViewTag)localObject).a;
        if ((localObject != null) && ((localObject instanceof Friends)))
        {
          localObject = (Friends)localObject;
          if ((this.jdField_c_of_type_Int != 1) || (localObject == null)) {
            break label264;
          }
          if (this.d != 2) {
            break label223;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(((Friends)localObject).uin) == null) {
            break;
          }
          QQToast.a(this, getString(2131369173), 0).b(getTitleBarHeight());
        }
      }
      return;
    case 2131299473: 
      if (this.jdField_c_of_type_Int == 1)
      {
        a(12);
        return;
      }
      a(8);
      return;
    case 2131297357: 
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.v == 11))
      {
        ForwardOperations.a(this, false, "shareToQQ", this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a);
        com.tencent.mobileqq.app.PhoneContactManagerImp.c = false;
      }
      finish();
      return;
    }
    paramView = new Intent(this, QQSpecialFriendSettingActivity.class);
    paramView.putExtra("key_friend_uin", ((Friends)localObject).uin);
    paramView.putExtra("key_is_from_friendsforward_activity", true);
    startActivity(paramView);
    return;
    label223:
    paramView = new Intent();
    paramView.putExtra("extra_choose_friend_uin", ((Friends)localObject).uin);
    paramView.putExtra("extra_choose_friend_name", ((Friends)localObject).name);
    setResult(-1, paramView);
    finish();
    return;
    label264:
    paramView = (TextView)paramView.findViewById(16908308);
    if (paramView != null) {
      if (paramView.getText() != null) {
        paramView = paramView.getText().toString();
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.v == 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.w == 13))
      {
        if (Utils.b(((Friends)localObject).uin))
        {
          QQToast.a(this, 1, "不能送书给此类好友", 0).b(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight());
          return;
          paramView = null;
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(((Friends)localObject).uin, -1, "", "");
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.v != 17) {
          setResult(1);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(((Friends)localObject).uin, 0, ((Friends)localObject).uin, paramView);
        return;
        paramView = "Ta";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardFriendListActivity
 * JD-Core Version:    0.7.0.1
 */