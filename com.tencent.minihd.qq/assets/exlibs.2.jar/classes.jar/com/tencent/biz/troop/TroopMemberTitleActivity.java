package com.tencent.biz.troop;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TroopMemberTitleActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final String a = "levelName";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  protected static final int e = 0;
  protected static final int f = 1;
  protected static final int g = 2;
  protected static final int h = 3;
  private static final int l = 1;
  protected Context a;
  protected LinearLayout a;
  private TroopInfo a;
  protected View[] a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f = null;
  private int i;
  private int j;
  private int k;
  
  public TroopMemberTitleActivity()
  {
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = null;
  }
  
  public static Intent a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3)
  {
    paramContext = new Intent(paramContext, TroopMemberTitleActivity.class);
    paramContext.putExtra("from", paramInt1);
    paramContext.putExtra("memberUin", paramString2);
    paramContext.putExtra("troopUin", paramString1);
    paramContext.putExtra("memberRole", paramInt2);
    paramContext.putExtra("levelName", paramString3);
    paramContext.putExtra("uniqueTitle", paramString4);
    paramContext.putExtra("uniqueTitleExpire", paramInt3);
    return paramContext;
  }
  
  private void a()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[0];
    Object localObject1 = (TextView)localView.findViewById(2131302353);
    Object localObject2;
    if (this.j == 2)
    {
      if (TextUtils.isEmpty(this.e)) {
        this.e = getString(2131365819);
      }
      TroopMemberListActivity.a((TextView)localObject1, 1);
      localObject2 = getString(2131363989);
      if (TextUtils.isEmpty(this.e)) {
        break label299;
      }
      ((TextView)localObject1).setText(this.e);
      ((TextView)localObject1).setTextColor(getResources().getColor(2131427404));
      localObject1 = (String)localObject2 + this.e;
      label110:
      localObject2 = (TextView)localView.findViewById(2131302352);
      if (((((TroopManager)this.app.getManager(50)).a() & 0x8) != 0) || (!"5.5.0".equals("5.9.3"))) {
        break label350;
      }
      ((TextView)localObject2).setVisibility(0);
      localObject1 = (String)localObject1 + getString(2131364008);
      label180:
      localView.setContentDescription((CharSequence)localObject1);
      localView = this.jdField_a_of_type_ArrayOfAndroidViewView[1];
      localObject2 = (TextView)localView.findViewById(2131302353);
      localObject1 = getString(2131363990);
      if (TextUtils.isEmpty(this.d)) {
        break label359;
      }
      ((TextView)localObject2).setText(this.d);
      localObject1 = (String)localObject1 + this.d;
    }
    label299:
    label350:
    label359:
    for (;;)
    {
      localView.setContentDescription((CharSequence)localObject1);
      return;
      if (this.j == 3)
      {
        if (TextUtils.isEmpty(this.e)) {
          this.e = getString(2131365820);
        }
        TroopMemberListActivity.a((TextView)localObject1, 0);
        break;
      }
      TroopMemberListActivity.a((TextView)localObject1, 2);
      break;
      ((TextView)localObject1).setText(2131367764);
      ((TextView)localObject1).setTextColor(getResources().getColor(2131427700));
      ((TextView)localObject1).setBackgroundResource(0);
      localObject1 = (String)localObject2 + getString(2131367764);
      break label110;
      ((TextView)localObject2).setVisibility(8);
      break label180;
    }
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    int m = 0;
    JSONObject localJSONObject;
    try
    {
      this.f = null;
      if (paramTroopInfo.troopLevelMap != null)
      {
        localJSONObject = new JSONObject();
        paramTroopInfo = paramTroopInfo.troopLevelMap.split("\001");
        if ((paramTroopInfo != null) && (paramTroopInfo.length > 0)) {
          for (;;)
          {
            if (m >= paramTroopInfo.length) {
              break label155;
            }
            String[] arrayOfString = paramTroopInfo[m].split("");
            int n = arrayOfString.length;
            if (n == 2) {}
            try
            {
              localJSONObject.put(arrayOfString[0], arrayOfString[1]);
              m += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("IphoneTitleBarActivity", 2, "getTroopLevelMap, catch exception, key: " + arrayOfString[0] + " value: " + arrayOfString[1]);
                }
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception paramTroopInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "getTroopLevelMap, catch exception, makeTroopLevelMapString");
      }
    }
    label155:
    this.f = localJSONObject.toString();
  }
  
  private boolean a()
  {
    Object localObject = getIntent();
    if (localObject == null) {
      return false;
    }
    this.i = ((Intent)localObject).getIntExtra("from", 0);
    this.b = ((Intent)localObject).getStringExtra("memberUin");
    this.c = ((Intent)localObject).getStringExtra("troopUin");
    this.j = ((Intent)localObject).getIntExtra("memberRole", 0);
    this.d = ((Intent)localObject).getStringExtra("levelName");
    this.e = ((Intent)localObject).getStringExtra("uniqueTitle");
    this.k = ((Intent)localObject).getIntExtra("uniqueTitleExpire", 0);
    localObject = (FriendManager)this.app.getManager(8);
    TroopManager localTroopManager = (TroopManager)this.app.getManager(50);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((FriendManager)localObject).a(this.c);
    localObject = DBUtils.a().a(this.app, this.c, this.b);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (localObject == null)) {
      return false;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
    return true;
  }
  
  protected void a(int paramInt1, View paramView, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramView.setTag(Integer.valueOf(paramInt1));
    paramView.setContentDescription(paramString1);
    TextView localTextView1 = (TextView)paramView.findViewById(2131302351);
    ImageView localImageView = (ImageView)paramView.findViewById(2131300468);
    TextView localTextView2 = (TextView)paramView.findViewById(2131302353);
    if (paramBoolean)
    {
      paramView.setOnClickListener(this);
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      localTextView1.setText(paramString1);
      localTextView2.setText(paramString2);
      switch (paramInt2)
      {
      default: 
        return;
        paramView.setOnClickListener(null);
        localImageView.setVisibility(8);
      }
    }
    paramView.setBackgroundResource(2130838153);
    return;
    paramView.setBackgroundResource(2130838155);
    return;
    paramView.setBackgroundResource(2130838151);
    return;
    paramView.setBackgroundResource(2130838156);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      return;
    }
    paramIntent = ((TroopManager)this.app.getManager(50)).a(this.c, this.b);
    this.e = paramIntent.mUniqueTitle;
    this.k = paramIntent.mUniqueTitleExpire;
    a();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!a())
    {
      finish();
      return false;
    }
    super.setContentView(2130904494);
    super.setTitle(2131366349);
    this.jdField_a_of_type_AndroidContentContext = this;
    this.mDensity = super.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296532));
    paramBundle = View.inflate(this, 2130904056, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
    paramBundle = View.inflate(this, 2130904496, null);
    a(0, paramBundle, 3, getString(2131363989), "", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(this.app.a()));
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = paramBundle;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
    Object localObject = (TextView)paramBundle.findViewById(2131302353);
    ((TextView)localObject).setIncludeFontPadding(false);
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setPadding((int)(this.mDensity * 7.0F), 0, (int)(this.mDensity * 7.0F), 0);
    ((TextView)localObject).setTextSize(1, 13.0F);
    paramBundle = ((TextView)localObject).getLayoutParams();
    paramBundle.height = ((int)(19.0F * this.mDensity));
    ((TextView)localObject).setLayoutParams(paramBundle);
    localObject = (TextView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903710, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    ((TextView)localObject).setText(2131363992);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    localObject = View.inflate(this, 2130904496, null);
    a(1, (View)localObject, 0, getString(2131363990), "", false);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = localObject;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    localObject = (TextView)((View)localObject).findViewById(2131302353);
    ((TextView)localObject).setTextColor(getResources().getColor(2131427404));
    ((TextView)localObject).setBackgroundResource(2130841670);
    ((TextView)localObject).setIncludeFontPadding(false);
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setPadding((int)(this.mDensity * 7.0F), 0, (int)(this.mDensity * 7.0F), 0);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setLayoutParams(paramBundle);
    paramBundle = View.inflate(this, 2130904496, null);
    a(2, paramBundle, 2, getString(2131363991), "", true);
    this.jdField_a_of_type_ArrayOfAndroidViewView[2] = paramBundle;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
    a();
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof Integer)) {
      switch (((Integer)paramView).intValue())
      {
      }
    }
    do
    {
      return;
      paramView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131302352);
      localObject = (TroopManager)this.app.getManager(50);
      int m = ((TroopManager)localObject).a();
      if (((m & 0x8) == 0) && ("5.5.0".equals("5.9.3")))
      {
        ((TroopManager)localObject).a(m | 0x8);
        paramView.setVisibility(8);
      }
      startActivityForResult(EditUniqueTitleActivity.a(this, 0, this.c, this.b, this.j, this.e, this.k), 1);
      ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_owner_title", 0, 0, this.c, "", "", "");
      return;
    } while (TextUtils.isEmpty(this.f));
    paramView = Uri.encode(this.f);
    Object localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("uin", this.app.a());
    ((Intent)localObject).putExtra("url", "https://qinfo.clt.qq.com/qlevel/level.html?str=" + paramView);
    ((Intent)localObject).putExtra("hide_more_button", true);
    startActivity((Intent)localObject);
    ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_see", 0, 0, this.c, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberTitleActivity
 * JD-Core Version:    0.7.0.1
 */