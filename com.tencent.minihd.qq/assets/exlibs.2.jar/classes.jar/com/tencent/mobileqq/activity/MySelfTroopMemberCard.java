package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.UIThreadPool;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import ekx;
import eky;
import ekz;
import ela;
import elb;
import elc;
import eld;
import ele;
import elf;
import java.util.HashMap;

public class MySelfTroopMemberCard
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String a = "show_level";
  public byte a;
  private Dialog jdField_a_of_type_AndroidAppDialog = null;
  private Handler jdField_a_of_type_AndroidOsHandler = new ekx(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  public TextView a;
  public TroopHandler a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new ela(this);
  private TroopMemberCardInfo jdField_a_of_type_ComTencentMobileqqDataTroopMemberCardInfo = null;
  public ActionSheet a;
  boolean jdField_a_of_type_Boolean = false;
  private byte jdField_b_of_type_Byte = this.jdField_a_of_type_Byte;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  public TextView b;
  public String b;
  public boolean b;
  private Animation jdField_c_of_type_AndroidViewAnimationAnimation;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout = null;
  public TextView c;
  public String c;
  public boolean c;
  private Animation jdField_d_of_type_AndroidViewAnimationAnimation;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout = null;
  public TextView d;
  public String d;
  public boolean d;
  private RelativeLayout e;
  public TextView e;
  public String e;
  public boolean e;
  private RelativeLayout f;
  public TextView f;
  public String f;
  public boolean f;
  private TextView g;
  public String g;
  
  public MySelfTroopMemberCard()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    this.jdField_e_of_type_AndroidWidgetTextView = null;
    this.jdField_f_of_type_AndroidWidgetTextView = null;
    this.jdField_g_of_type_AndroidWidgetTextView = null;
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Byte = -1;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968746);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968748);
    this.jdField_c_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968627);
    this.jdField_d_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968628);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298020));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298023));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298027));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298031));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298035));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298039));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298016));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131298017));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131298021));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131298024));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131298028));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131298032));
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131298036));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    for (;;)
    {
      UIThreadPool.a(new eky(this));
      return;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte paramByte)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    for (;;)
    {
      this.jdField_a_of_type_Byte = paramByte;
      this.jdField_e_of_type_JavaLangString = paramString4;
      this.jdField_f_of_type_JavaLangString = paramString5;
      this.jdField_g_of_type_JavaLangString = paramString6;
      this.jdField_a_of_type_AndroidOsHandler.post(new ekz(this, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6));
      return;
      this.jdField_d_of_type_JavaLangString = paramString1;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    String str = getString(2131366167);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(str);
    switch (this.jdField_a_of_type_Byte)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.e(2131365736);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new elf(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131366573), 1, true);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131366574), 1, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131366361), 1, false);
      continue;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131366573), 1, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131366574), 1, true);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131366361), 1, false);
      continue;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131366573), 1, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131366574), 1, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131366361), 1, true);
      continue;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131366573), 1, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131366574), 1, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131366361), 1, false);
    }
  }
  
  @Deprecated
  private void c()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!isFinishing()))
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog.cancel();
    }
  }
  
  public void a()
  {
    Object localObject3 = null;
    Object localObject1 = DBUtils.a().a(this.app, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    Object localObject2;
    if (localObject1 == null)
    {
      TroopMemberInfo localTroopMemberInfo = DBUtils.a().a(this.app, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
      if (localTroopMemberInfo == null) {
        break label175;
      }
      String str = localTroopMemberInfo.troopnick;
      localObject1 = str;
      localObject2 = localObject3;
      if (localTroopMemberInfo.level > 0)
      {
        Object localObject4 = (FriendsManagerImp)this.app.getManager(8);
        localObject1 = str;
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((FriendsManagerImp)localObject4).a(this.jdField_b_of_type_JavaLangString);
          localObject1 = str;
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject4 = ((TroopInfo)localObject4).getTroopLevelMap();
            localObject1 = str;
            localObject2 = localObject3;
            if (localObject4 != null)
            {
              localObject2 = (String)((HashMap)localObject4).get(Integer.valueOf(localTroopMemberInfo.level));
              localObject1 = str;
            }
          }
        }
      }
    }
    for (;;)
    {
      a((String)localObject1, (String)localObject2, "", "", "", "", (byte)-1);
      return;
      a((TroopMemberCardInfo)localObject1, true);
      return;
      label175:
      localObject1 = null;
      localObject2 = localObject3;
    }
  }
  
  public void a(TroopMemberCardInfo paramTroopMemberCardInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCardInfo = paramTroopMemberCardInfo;
    String str1;
    if (!paramBoolean)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_d_of_type_JavaLangString = paramTroopMemberCardInfo.name;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_Byte = paramTroopMemberCardInfo.sex;
        this.jdField_b_of_type_Byte = paramTroopMemberCardInfo.sex;
        if (this.jdField_a_of_type_Byte != 0) {
          break label158;
        }
        str1 = "男";
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str1);
        if (!this.jdField_d_of_type_Boolean)
        {
          this.jdField_e_of_type_JavaLangString = paramTroopMemberCardInfo.tel;
          this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString);
        }
        if (!this.jdField_e_of_type_Boolean)
        {
          this.jdField_f_of_type_JavaLangString = paramTroopMemberCardInfo.email;
          this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
        }
        if (!this.jdField_f_of_type_Boolean)
        {
          this.jdField_g_of_type_JavaLangString = paramTroopMemberCardInfo.memo;
          this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_g_of_type_JavaLangString);
        }
        return;
        label158:
        if (this.jdField_a_of_type_Byte == 1) {
          str1 = "女";
        } else {
          str1 = "";
        }
      }
    }
    String str2 = paramTroopMemberCardInfo.name;
    byte b1 = paramTroopMemberCardInfo.sex;
    this.jdField_b_of_type_Byte = b1;
    if (b1 == 0) {
      str1 = "男";
    }
    for (;;)
    {
      String str3 = paramTroopMemberCardInfo.tel;
      String str4 = paramTroopMemberCardInfo.email;
      String str5 = paramTroopMemberCardInfo.memo;
      a(str2, paramTroopMemberCardInfo.level, str1, str3, str4, str5, b1);
      return;
      if (b1 == 1) {
        str1 = "女";
      } else {
        str1 = "";
      }
    }
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nick", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("nickboolean", this.jdField_b_of_type_Boolean);
    if (this.jdField_b_of_type_Byte == this.jdField_a_of_type_Byte) {}
    for (;;)
    {
      localIntent.putExtra("phone", this.jdField_e_of_type_JavaLangString);
      localIntent.putExtra("phoneboolean", this.jdField_d_of_type_Boolean);
      localIntent.putExtra("mail", this.jdField_f_of_type_JavaLangString);
      localIntent.putExtra("mailboolean", this.jdField_e_of_type_Boolean);
      localIntent.putExtra("remark", this.jdField_g_of_type_JavaLangString);
      localIntent.putExtra("remarkboolean", this.jdField_f_of_type_Boolean);
      setResult(-1, localIntent);
      super.finish();
      return;
      localIntent.putExtra("sex", this.jdField_a_of_type_Byte);
      localIntent.putExtra("sexboolean", this.jdField_c_of_type_Boolean);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 != -1) || (paramIntent == null)) {
      return;
    }
    paramIntent = paramIntent.getStringExtra("savetxt");
    switch (paramInt1)
    {
    default: 
      return;
    case 2131298017: 
      this.jdField_a_of_type_AndroidOsHandler.post(new elb(this, paramIntent));
      return;
    case 2131298028: 
      this.jdField_a_of_type_AndroidOsHandler.post(new elc(this, paramIntent));
      return;
    case 2131298032: 
      this.jdField_a_of_type_AndroidOsHandler.post(new eld(this, paramIntent));
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ele(this, paramIntent));
  }
  
  protected boolean onBackEvent()
  {
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298017: 
      paramView = new Intent(this, EditInfoActivity.class);
      paramView.putExtra("type", 0);
      paramView.putExtra("title", getResources().getString(2131366355));
      paramView.putExtra("default", this.jdField_a_of_type_AndroidWidgetTextView.getText());
      paramView.putExtra("subtype", 2131298017);
      paramView.putExtra("num", 21);
      startActivityForResult(paramView, 2131298017);
      return;
    case 2131298024: 
      b();
      return;
    case 2131298028: 
      paramView = new Intent(this, EditInfoActivity.class);
      paramView.putExtra("type", 0);
      paramView.putExtra("title", getResources().getString(2131366358));
      paramView.putExtra("default", this.jdField_d_of_type_AndroidWidgetTextView.getText());
      paramView.putExtra("subtype", 2131298028);
      paramView.putExtra("num", 20);
      startActivityForResult(paramView, 2131298028);
      return;
    case 2131298032: 
      paramView = new Intent(this, EditInfoActivity.class);
      paramView.putExtra("type", 0);
      paramView.putExtra("title", getResources().getString(2131366359));
      paramView.putExtra("default", this.jdField_e_of_type_AndroidWidgetTextView.getText());
      paramView.putExtra("subtype", 2131298032);
      paramView.putExtra("num", 30);
      startActivityForResult(paramView, 2131298032);
      return;
    }
    paramView = new Intent(this, EditInfoActivity.class);
    paramView.putExtra("type", 1);
    paramView.putExtra("title", getResources().getString(2131366360));
    paramView.putExtra("default", this.jdField_f_of_type_AndroidWidgetTextView.getText());
    paramView.putExtra("subtype", 2131298036);
    paramView.putExtra("num", 84);
    startActivityForResult(paramView, 2131298036);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = setContentViewB(2130903383);
    setTitle(getString(2131366353));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.app.a(19));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("troopuin");
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("memberuin");
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("show_level", false);
    a(paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MySelfTroopMemberCard
 * JD-Core Version:    0.7.0.1
 */