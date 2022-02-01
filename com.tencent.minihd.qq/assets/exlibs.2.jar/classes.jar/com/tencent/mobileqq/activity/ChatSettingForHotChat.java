package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.troop.TroopProxyActivity;
import dpj;
import dpk;
import dpn;
import dpo;
import dpp;
import java.util.ArrayList;
import java.util.List;

public class ChatSettingForHotChat
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  static final int jdField_a_of_type_Int = 6;
  static final String jdField_a_of_type_JavaLangString = "troopUin";
  static final String jdField_b_of_type_JavaLangString = "troopCode";
  private static final int jdField_c_of_type_Int = 1500;
  static final String jdField_c_of_type_JavaLangString = "memberUin";
  static final String d = "memberName";
  static final String e = "faceId";
  static final String f = "pinyin";
  public Handler a;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  public View a;
  Button jdField_a_of_type_AndroidWidgetButton;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  GridView jdField_a_of_type_AndroidWidgetGridView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout.LayoutParams a;
  public TextView a;
  public BizTroopHandler a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new dpn(this);
  public HotChatHandler a;
  public HotChatManager a;
  public HotChatObserver a;
  HotChatInfo jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
  TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public QQProgressDialog a;
  public dpp a;
  public List a;
  int jdField_b_of_type_Int = 0;
  Handler jdField_b_of_type_AndroidOsHandler = new dpj(this);
  TextView jdField_b_of_type_AndroidWidgetTextView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public String g;
  
  public ChatSettingForHotChat()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new dpk(this);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, ChatSettingForHotChat.class);
    localIntent.putExtra("troopUin", paramString);
    paramActivity.startActivityForResult(localIntent, 2000);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopCode);
      localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin);
      localIntent.putExtra("troop_info_title", "热聊成员");
      TroopProxyActivity.b(this, localIntent, this.app.a(), 0);
    }
  }
  
  public void a()
  {
    try
    {
      View localView = View.inflate(this, 2130903155, null);
      super.setContentView(localView);
      setContentBackgroundResource(2130837687);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297129));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297130));
      this.c = ((TextView)findViewById(2131297131));
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131297132);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetGridView = ((MyGridView)localView.findViewById(2131297114));
      this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Dpp = new dpp(this);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Dpp);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297133));
      setTitle(getString(2131367787));
      super.setLeftViewName(2131368091);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131297134));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297128));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      finish();
      localOutOfMemoryError.printStackTrace();
    }
  }
  
  public void b()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getString(2131369506));
    localActionSheet.a(getString(2131369505), 3);
    localActionSheet.e(2131365736);
    localActionSheet.a(new dpo(this, localActionSheet));
    localActionSheet.show();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    paramBundle = getResources();
    this.jdField_b_of_type_Int = ((this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - (paramBundle.getDimensionPixelOffset(2131493113) * 6 - paramBundle.getDimensionPixelOffset(2131493297) * 2)) / 7);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(14, -1);
    this.g = getIntent().getStringExtra("troopUin");
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager = ((HotChatManager)this.app.getManager(58));
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager != null)
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.g);
      this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = paramBundle;
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatHandler = ((HotChatHandler)this.app.a(37));
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null) {
        break label381;
      }
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler = ((BizTroopHandler)this.app.a(21));
      this.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler.c(this.g);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(HotChatManager.a(this.g, this.app));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.name);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.detail)) {
        break label364;
      }
      this.c.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("" + this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memberCount + "人");
      this.jdField_a_of_type_AndroidViewView.setContentDescription("热聊成员，" + this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memberCount + "人");
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return true;
      paramBundle = null;
      break;
      label364:
      this.c.setText(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.detail);
    }
    label381:
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(HotChatManager.a(this.g, this.app));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.g);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("0人");
    this.jdField_a_of_type_AndroidViewView.setContentDescription("热聊成员，0人");
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    QQToast.a(this, 2131365772, 0).b(getTitleBarHeight());
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null) {
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver != null) {
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131296551: 
    case 2131297132: 
      c();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForHotChat
 * JD-Core Version:    0.7.0.1
 */