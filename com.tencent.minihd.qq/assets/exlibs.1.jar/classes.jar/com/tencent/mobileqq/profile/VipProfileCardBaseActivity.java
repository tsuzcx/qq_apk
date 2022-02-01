package com.tencent.mobileqq.profile;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import jmt;
import jmu;
import jmv;
import jmw;
import jmx;
import jmy;
import org.json.JSONException;
import org.json.JSONObject;

public class VipProfileCardBaseActivity
  extends IphoneTitleBarActivity
{
  public static final int A = 1;
  public static final int B = 2;
  public static final String a = "ProfileCard.VipProfileCardBaseActivity";
  public static final String b = "ExternAid";
  public static final String d = "CurrentTemplateId";
  public static final String e = "CurrentBackgroundId";
  public static final int f = 1;
  public static final String f = "CurrentBackgroundUrl";
  public static final int g = 2;
  public static final String g = "CurrentBackgroundColor";
  public static final int h = 3;
  public static final int i = 4;
  public static final int j = 5;
  public static final int k = 6;
  public static final int l = 7;
  public static final int m = 8;
  public static final int n = 9;
  public static final int o = 16;
  public static final int p = 17;
  public static final int q = 18;
  public static final int r = 20;
  public static final int s = 21;
  public static final int t = 22;
  public static final int u = 23;
  public static final int v = 24;
  public static final int w = 25;
  public int C = 30000;
  protected int D;
  protected int E;
  protected int F;
  protected float a;
  public int a;
  public long a;
  public Context a;
  public DialogInterface.OnClickListener a;
  @SuppressLint({"HandlerLeak"})
  public Handler a;
  public CardHandler a;
  protected CardObserver a;
  protected QQCustomDialog a;
  protected QQProgressDialog a;
  public Runnable a;
  protected ArrayList a;
  protected boolean a;
  protected int b;
  public DialogInterface.OnClickListener b;
  protected boolean b;
  protected int c;
  protected String c;
  public int d = 0;
  protected int e = 1;
  public String h = null;
  public int x = 2;
  public int y = -1;
  public int z = -1;
  
  public VipProfileCardBaseActivity()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_AndroidOsHandler = new jmt(this);
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new jmu(this);
    this.jdField_a_of_type_JavaLangRunnable = new jmv(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new jmw(this);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new jmx(this);
  }
  
  protected int a()
  {
    View localView = getWindow().getDecorView();
    if (localView == null) {}
    int i1;
    do
    {
      return 0;
      i1 = localView.getBottom() - localView.getTop();
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "mScreenHeight : " + this.D + " realHeight : " + i1);
      }
    } while ((i1 == 0) || (i1 >= this.D));
    return this.D - i1;
  }
  
  public int a(String paramString, DownloadListener paramDownloadListener)
  {
    if (ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, paramString)) {
      return 19;
    }
    paramString = new DownloadTask(paramString, new File(ProfileCardUtil.b(this.jdField_a_of_type_AndroidContentContext, paramString)));
    if (paramDownloadListener != null) {
      paramString.a(paramDownloadListener);
    }
    paramString.e = "profileCardDownload";
    paramString.d = "VIP_profilecard";
    return DownloaderFactory.a(paramString, this.app);
  }
  
  public ArrayList a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      this.jdField_a_of_type_JavaUtilArrayList = ProfileCardUtil.a(this.app, false, false);
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  protected void a() {}
  
  protected void a(long paramLong1, long paramLong2)
  {
    a(paramLong1, paramLong2, null, 0);
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131369057);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      label54:
      this.app.a(new jmy(this, paramLong1, paramLong2, paramString, paramInt));
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.C);
      return;
    }
    catch (Exception localException)
    {
      break label54;
    }
  }
  
  public void a(ProfileCardBackground paramProfileCardBackground)
  {
    if (paramProfileCardBackground == null) {}
    long l1;
    do
    {
      return;
      l1 = NetConnInfoCenter.getServerTime();
    } while ((paramProfileCardBackground.d != 1) || (l1 >= paramProfileCardBackground.f) || (l1 <= paramProfileCardBackground.e));
    paramProfileCardBackground.jdField_c_of_type_Int = 1;
  }
  
  public void a(ProfileCardTemplate paramProfileCardTemplate)
  {
    if (paramProfileCardTemplate == null) {}
    long l1;
    do
    {
      return;
      l1 = NetConnInfoCenter.getServerTime();
    } while ((paramProfileCardTemplate.jdField_h_of_type_Int != 1) || (l1 >= paramProfileCardTemplate.j) || (l1 <= paramProfileCardTemplate.i));
    paramProfileCardTemplate.g = "1";
  }
  
  public boolean a(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(49);
    Card localCard = localFriendsManager.a(this.app.a());
    if ((localCard != null) && (paramLong >= 0L))
    {
      localCard.lCurrentStyleId = paramLong;
      localCard.lCurrentBgId = paramInt1;
      localCard.strCurrentBgUrl = paramString;
      localCard.backgroundColor = paramInt2;
      localCard.templateRet = paramInt3;
      if (!localFriendsManager.a(localCard))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ProfileCard.VipProfileCardBaseActivity", 4, "save card in db failed ");
        }
        return false;
      }
      return true;
    }
    return false;
  }
  
  public boolean a(Message paramMessage)
  {
    return false;
  }
  
  protected boolean a(ProfileCardTemplate paramProfileCardTemplate, ProfileCardBackground paramProfileCardBackground, boolean paramBoolean)
  {
    if ((paramProfileCardTemplate != null) && (paramProfileCardBackground != null))
    {
      if (paramProfileCardTemplate.jdField_h_of_type_Long == 0L) {
        return true;
      }
      int i3 = Integer.valueOf(paramProfileCardTemplate.g).intValue();
      int i1 = paramProfileCardBackground.jdField_c_of_type_Int;
      boolean bool = ProfileCardUtil.a(paramProfileCardBackground);
      if (bool) {
        i1 = paramProfileCardTemplate.o;
      }
      if (i3 >= i1)
      {
        this.jdField_c_of_type_Int = 1;
        if (i3 == i1) {
          this.jdField_c_of_type_Int = 2;
        }
      }
      for (int i2 = i3;; i2 = i1)
      {
        this.jdField_b_of_type_Int = i2;
        if ((i2 != 0) && (i2 != 1)) {
          break;
        }
        return true;
        this.jdField_c_of_type_Int = 0;
      }
      if (i2 == 2)
      {
        if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_Int = 1;
          if (bool) {
            this.jdField_c_of_type_JavaLangString = "mvip.gongneng.android.mingpian_zidingyi";
          }
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 4, String.format("getAid mIsQQVipOpen : %b, mIsSuperVipOpen : %b, styleAuth : %d, bgAuth : %d, mNeedVipType : %d, mAid : %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(i3), Integer.valueOf(i1), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_c_of_type_JavaLangString }));
            }
            if (paramBoolean) {
              d();
            }
            return false;
            if (this.e == 1) {
              this.jdField_c_of_type_JavaLangString = ProfileCardUtil.a(this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, i3, i1, this.jdField_a_of_type_Int);
            } else {
              this.jdField_c_of_type_JavaLangString = ProfileCardUtil.a(3);
            }
          }
        }
      }
      else if (i2 == 4)
      {
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_Int = 2;
          if (bool) {
            this.jdField_c_of_type_JavaLangString = "mvip.gongneng.android.mingpian_zidingyi";
          }
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 4, String.format("getAid mIsQQVipOpen : %b, mIsSuperVipOpen : %b, styleAuth : %d, bgAuth : %d, mNeedVipType : %d, mAid : %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(i3), Integer.valueOf(i1), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_c_of_type_JavaLangString }));
            }
            if (paramBoolean) {
              d();
            }
            return false;
            if (this.e == 1) {
              this.jdField_c_of_type_JavaLangString = ProfileCardUtil.a(this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, i3, i1, this.jdField_a_of_type_Int);
            } else {
              this.jdField_c_of_type_JavaLangString = ProfileCardUtil.a(6);
            }
          }
        }
      }
      else if (i2 == 5) {
        return true;
      }
    }
    return true;
  }
  
  public long[] a()
  {
    ArrayList localArrayList = a();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0)
      {
        localObject1 = new long[localArrayList.size()];
        int i1 = 0;
        while (i1 < localArrayList.size())
        {
          localObject1[i1] = ((ProfileCardTemplate)localArrayList.get(i1)).jdField_h_of_type_Long;
          i1 += 1;
        }
      }
    }
    return localObject1;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 268	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   4: ifnull +25 -> 29
    //   7: aload_0
    //   8: getfield 268	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   11: invokevirtual 415	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   14: ifeq +15 -> 29
    //   17: aload_0
    //   18: getfield 268	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   21: invokevirtual 418	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 268	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 268	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 268	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	VipProfileCardBaseActivity
    //   30	1	1	localException	Exception
    //   37	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	30	java/lang/Exception
    //   17	24	37	finally
  }
  
  protected void c()
  {
    this.jdField_b_of_type_Boolean = VipUtils.a(this.app);
    this.jdField_a_of_type_Boolean = VipUtils.b(this.app);
  }
  
  public void d()
  {
    e();
    String str2;
    String str1;
    if (this.jdField_a_of_type_Int == 2)
    {
      str2 = getString(2131369031);
      if (this.jdField_c_of_type_Int == 2) {
        str1 = getString(2131369040);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 0, str2, str1, 2131369041, 2131369042, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      if (this.jdField_c_of_type_Int == 1)
      {
        str1 = getString(2131369036);
      }
      else
      {
        str1 = getString(2131369038);
        continue;
        str2 = getString(2131369033);
        if (this.jdField_c_of_type_Int == 2) {
          str1 = getString(2131369039);
        } else if (this.jdField_c_of_type_Int == 1) {
          str1 = getString(2131369035);
        } else {
          str1 = getString(2131369037);
        }
      }
    }
  }
  
  @TargetApi(9)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getResources().getDisplayMetrics();
    this.E = paramBundle.widthPixels;
    this.D = paramBundle.heightPixels;
    this.F = paramBundle.densityDpi;
    this.jdField_a_of_type_Float = paramBundle.density;
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    e();
    b();
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void f()
  {
    Object localObject2 = null;
    Intent localIntent = getIntent();
    Object localObject1 = localObject2;
    if (localIntent != null)
    {
      localObject1 = localObject2;
      if (localIntent.hasExtra("ExternAid")) {
        localObject1 = localIntent.getStringExtra("ExternAid");
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = this.jdField_c_of_type_JavaLangString;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 2)
      {
        VipUtils.b((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 3, (String)localObject1);
        ReportController.b(this.app, "P_CliOper", "Vip_SummaryCard", "", "0X80044E0", "0X80044E0", 0, 0, "", "", "", VipUtils.a(this.app, this.app.a()));
        return;
      }
      VipUtils.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 3, (String)localObject1);
      ReportController.b(this.app, "P_CliOper", "Vip_SummaryCard", "", "0X80044DF", "0X80044DF", 0, 0, "", "", "", VipUtils.a(this.app, this.app.a()));
      return;
    }
  }
  
  public void g()
  {
    Card localCard = ((FriendsManager)this.app.getManager(49)).a(this.app.a());
    if (localCard != null)
    {
      if (localCard.templateRet == 0) {
        break label114;
      }
      this.jdField_a_of_type_Long = 0L;
      this.y = -1;
      this.z = 1;
      this.h = null;
    }
    label114:
    label251:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, String.format("readInfofromDB , mCurrentStyleId : %s , mCurrentBackgroundId : %s , mCurrentBackgroundColor : %s , mCurrentBackgroundUrl : %s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.y), Integer.valueOf(this.z), this.h }));
      }
      return;
      Intent localIntent = getIntent();
      if (localIntent == null)
      {
        this.jdField_a_of_type_Long = ((int)localCard.lCurrentStyleId);
        this.y = ((int)localCard.lCurrentBgId);
        this.h = localCard.backgroundUrl;
        this.z = ((int)localCard.backgroundColor);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Long != -1L) {
          break label251;
        }
        this.jdField_a_of_type_Long = 0L;
        break;
        if (!localIntent.hasExtra("CurrentTemplateId")) {
          this.jdField_a_of_type_Long = ((int)localCard.lCurrentStyleId);
        }
        if (!localIntent.hasExtra("CurrentBackgroundId")) {
          this.y = ((int)localCard.lCurrentBgId);
        }
        if (!localIntent.hasExtra("CurrentBackgroundUrl")) {
          this.h = localCard.backgroundUrl;
        }
        if (!localIntent.hasExtra("CurrentBackgroundColor")) {
          this.z = ((int)localCard.backgroundColor);
        }
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    if ((paramInt1 == 4) && (paramInt2 == -1) && (paramIntent != null))
    {
      String str = null;
      if (paramIntent.hasExtra("result"))
      {
        Object localObject = paramIntent.getStringExtra("result");
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, resultStr : " + (String)localObject);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          try
          {
            localObject = new JSONObject((String)localObject);
            if (localObject == null) {
              return;
            }
            localObject = ((JSONObject)localObject).get("payState");
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, stateObj : " + localObject);
            }
            if ((localObject == null) || (!"0".equals(String.valueOf(localObject)))) {
              return;
            }
            if (paramIntent.hasExtra("callbackSn")) {
              str = paramIntent.getStringExtra("callbackSn");
            }
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, callbackSn : " + str);
            }
            if ("svip".equals(str)) {
              this.jdField_b_of_type_Boolean = true;
            }
            for (;;)
            {
              a();
              return;
              this.jdField_a_of_type_Boolean = true;
            }
            QLog.e("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, Exception : " + paramIntent.getMessage());
          }
          catch (JSONException paramIntent)
          {
            paramIntent.printStackTrace();
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.e("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, JSONException : " + paramIntent.getMessage());
            return;
          }
          catch (Exception paramIntent)
          {
            paramIntent.printStackTrace();
            if (!QLog.isColorLevel()) {
              return;
            }
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, data contain no result key.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardBaseActivity
 * JD-Core Version:    0.7.0.1
 */