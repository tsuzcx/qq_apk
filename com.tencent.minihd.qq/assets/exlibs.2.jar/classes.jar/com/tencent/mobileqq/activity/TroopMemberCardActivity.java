package com.tencent.mobileqq.activity;

import QQService.EVIPSPEC;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.biz.common.util.Util;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberCard.CustomEntry;
import com.tencent.mobileqq.data.TroopMemberCard.GBarInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import fhy;
import fhz;
import fia;
import fib;
import fic;
import fid;
import fie;
import fif;
import fih;
import fii;
import fij;
import fik;
import fil;
import fim;
import fin;
import fio;
import fip;
import fiq;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class TroopMemberCardActivity
  extends IphoneTitleBarActivity
  implements View.OnLongClickListener
{
  public static final int A = 4;
  protected static final int B = 0;
  protected static final int C = 1;
  protected static final int D = 2;
  protected static final int E = 3;
  public static final int F = 3;
  public static final int G = 4;
  public static final int H = 5;
  public static final int J = 1;
  public static final int K = 2;
  public static final int L = 3;
  public static final int M = 4;
  public static final int N = 0;
  public static final int O = 1;
  public static final int P = 60;
  public static final byte a = 1;
  protected static final int a = 0;
  public static final byte b = 2;
  protected static final int b = 1;
  public static final byte c = 3;
  protected static final int c = 2;
  public static final byte d = 4;
  protected static final int d = 3;
  public static final byte e = 5;
  protected static final int e = 4;
  public static final byte f = 6;
  protected static final int f = 5;
  public static final byte g = 7;
  protected static final int g = 0;
  protected static final int h = 1;
  protected static final String i = "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun";
  public static final int j = 0;
  public static final int k = 1;
  public static final int l = 2;
  public static final int m = 3;
  public static final int n = 0;
  public static final int o = 1;
  public static final int p = 2;
  public static final int q = 4;
  protected static final int r = 1;
  protected static final int u = 1;
  protected static final int v = 0;
  public static final int w = 0;
  public static final int x = 1;
  public static final int y = 2;
  public static final int z = 3;
  protected int I = -1;
  protected float a;
  protected long a;
  protected Intent a;
  public Handler a;
  protected View.OnClickListener a;
  protected View a;
  public ImageView a;
  protected LinearLayout a;
  protected TextView a;
  public TroopMemberCardActivity a;
  public TroopHandler a;
  protected TroopObserver a;
  public TroopMemberCard a;
  public IconPopupWindow a;
  protected QQProgressDialog a;
  protected QQProgressNotifier a;
  protected ActionSheet.OnButtonClickListener a;
  public ActionSheet a;
  protected final String a;
  protected boolean a;
  public View[] a;
  protected View.OnClickListener b;
  protected View b;
  protected LinearLayout b;
  TextView b;
  protected TroopObserver b;
  protected String b;
  protected View.OnClickListener c;
  View c;
  protected LinearLayout c;
  public String c;
  protected View.OnClickListener d;
  public String d;
  protected View.OnClickListener e;
  public String e;
  protected View.OnClickListener f;
  public String f;
  protected View.OnClickListener g;
  protected String g;
  protected String h = "";
  protected int i = -1;
  private String j = null;
  public int s = -1;
  public int t = 1;
  
  public TroopMemberCardActivity()
  {
    this.jdField_a_of_type_JavaLangString = "Q.profilecard.TroopMemberCardActivity";
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[5];
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = new TroopMemberCard();
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fhy(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new fij(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new fik(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new fil(this);
    this.jdField_e_of_type_AndroidViewView$OnClickListener = new fim(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = new fin(this);
    this.jdField_f_of_type_AndroidViewView$OnClickListener = new fia(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new fib(this);
    this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver = new fic(this);
    this.jdField_a_of_type_AndroidContentIntent = new Intent();
    this.jdField_a_of_type_AndroidOsHandler = new fid(this);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_g_of_type_AndroidViewView$OnClickListener = new fii(this);
  }
  
  private View a(LinearLayout paramLinearLayout)
  {
    LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity).inflate(2130904011, paramLinearLayout, true);
    return paramLinearLayout.getChildAt(paramLinearLayout.getChildCount() - 1);
  }
  
  private LinearLayout a(int paramInt1, int paramInt2)
  {
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundResource(2130837951);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = paramInt1;
    localLayoutParams.bottomMargin = paramInt2;
    localLinearLayout.setLayoutParams(localLayoutParams);
    return localLinearLayout;
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, TroopMemberCardActivity.class);
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("memberUin", paramString2);
    localIntent.putExtra("fromFlag", paramInt2);
    if (paramInt1 == -1)
    {
      paramActivity.startActivity(localIntent);
      return;
    }
    paramActivity.startActivityForResult(localIntent, paramInt1);
  }
  
  private void a(ViewGroup paramViewGroup, View paramView)
  {
    int i1 = paramViewGroup.indexOfChild(paramView);
    if (i1 > 0)
    {
      paramViewGroup = paramViewGroup.getChildAt(i1);
      if (paramViewGroup.getClass().getSimpleName().endsWith("View")) {
        paramViewGroup.setVisibility(8);
      }
    }
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    int i1 = 0;
    JSONObject localJSONObject;
    try
    {
      this.j = null;
      if (paramTroopInfo.troopLevelMap != null)
      {
        localJSONObject = new JSONObject();
        paramTroopInfo = paramTroopInfo.troopLevelMap.split("\001");
        if ((paramTroopInfo != null) && (paramTroopInfo.length > 0)) {
          for (;;)
          {
            if (i1 >= paramTroopInfo.length) {
              break label160;
            }
            String[] arrayOfString = paramTroopInfo[i1].split("");
            int i2 = arrayOfString.length;
            if (i2 == 2) {}
            try
            {
              localJSONObject.put(arrayOfString[0], arrayOfString[1]);
              i1 += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.profilecard.TroopMemberCardActivity", 2, "getTroopLevelMap, catch exception, key: " + arrayOfString[0] + " value: " + arrayOfString[1]);
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
        QLog.d("Q.profilecard.TroopMemberCardActivity", 2, "getTroopLevelMap, catch exception, makeTroopLevelMapString");
      }
    }
    label160:
    this.j = localJSONObject.toString();
  }
  
  private void c(int paramInt)
  {
    if (this.I == 1) {
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          a(Long.parseLong(this.jdField_c_of_type_JavaLangString), Long.parseLong(this.jdField_e_of_type_JavaLangString), 0);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned)
          {
            ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_unblock", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
            return;
          }
        } while (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mIsShield);
        ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_unfocus", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
        return;
        a(Long.parseLong(this.jdField_c_of_type_JavaLangString), Long.parseLong(this.jdField_e_of_type_JavaLangString), 1);
        ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_sf", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
        return;
        a(Long.parseLong(this.jdField_c_of_type_JavaLangString), Long.parseLong(this.jdField_e_of_type_JavaLangString), 2);
        ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_block", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
        return;
        if (this.I != 2) {
          break;
        }
      } while (paramInt != 0);
      if (this.t == 3)
      {
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, TroopDisbandActivity.class);
        ((Intent)localObject1).putExtra("troop_uin", this.jdField_c_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("uinname", this.jdField_b_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("troop_code", this.jdField_d_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("leftViewText", 2131367789);
        startActivityForResult((Intent)localObject1, 4);
        return;
      }
      Object localObject2 = getString(2131367054);
      if (this.jdField_b_of_type_JavaLangString == null) {}
      for (Object localObject1 = this.jdField_c_of_type_JavaLangString;; localObject1 = this.jdField_b_of_type_JavaLangString + "(" + this.jdField_c_of_type_JavaLangString + ")")
      {
        localObject1 = String.format(getString(2131367049), new Object[] { localObject1 });
        localObject1 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 230).setTitle((String)localObject2).setMessage((CharSequence)localObject1);
        ((QQCustomDialog)localObject1).setPositiveButton(getString(2131366212), new fio(this, (QQCustomDialog)localObject1));
        ((QQCustomDialog)localObject1).setPositiveButtonContentDescription(getString(2131362006));
        ((QQCustomDialog)localObject1).setNegativeButton(getString(2131365736), new fip(this, (QQCustomDialog)localObject1));
        ((QQCustomDialog)localObject1).setNegativeButtonContentDescription(getString(2131362007));
        ((QQCustomDialog)localObject1).show();
        ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_quitgrp", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
        return;
      }
      if (this.I == 3)
      {
        switch (paramInt)
        {
        default: 
          return;
        case 0: 
          localObject1 = (TroopGagMgr)this.app.getManager(47);
          if (this.jdField_a_of_type_Boolean)
          {
            ((TroopGagMgr)localObject1).a(this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, 0L);
            ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "silent_card", "Clk_un", 0, 0, this.jdField_c_of_type_JavaLangString, ((TroopGagMgr)localObject1).a(this.jdField_c_of_type_JavaLangString), "", "");
            return;
          }
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, TroopMemberGagActivity.class);
          ((Intent)localObject2).putExtra("param_key_troopUin", this.jdField_c_of_type_JavaLangString);
          ((Intent)localObject2).putExtra("param_key_memberUin", this.jdField_e_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.startActivity((Intent)localObject2);
          ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "silent_card", "Clk_set", 0, 0, this.jdField_c_of_type_JavaLangString, ((TroopGagMgr)localObject1).a(this.jdField_c_of_type_JavaLangString), "", "");
          return;
        case 1: 
          a(this.jdField_c_of_type_JavaLangString, this.app.a(), this.jdField_e_of_type_JavaLangString);
          ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_report", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
          return;
        case 2: 
          if (this.t == 3)
          {
            h();
            return;
          }
          g();
          return;
        }
        g();
        return;
      }
    } while ((this.I != 4) || (paramInt != 0));
    a(this.jdField_c_of_type_JavaLangString, this.app.a(), this.jdField_e_of_type_JavaLangString);
    ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_report", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
  }
  
  private void m()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[1];
    if (localObject != null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)localObject;
      localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      localRelativeLayout.setMinimumHeight(Util.a(this, 44.0F));
      localObject = (TroopMemberCardActivity.ViewHolder)((View)localObject).getTag();
      ((TroopMemberCardActivity.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setSingleLine(false);
      ((TroopMemberCardActivity.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setMaxLines(4);
      int i1 = Util.a(this, 5.0F);
      localObject = (LinearLayout.LayoutParams)((TroopMemberCardActivity.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = i1;
      ((LinearLayout.LayoutParams)localObject).bottomMargin = i1;
    }
  }
  
  protected int a(TroopInfo paramTroopInfo, String paramString)
  {
    int i2 = 1;
    int i1 = i2;
    if (paramTroopInfo != null)
    {
      if ((paramTroopInfo.troopowneruin == null) || (!paramTroopInfo.troopowneruin.equalsIgnoreCase(paramString))) {
        break label32;
      }
      i1 = 3;
    }
    label32:
    do
    {
      do
      {
        return i1;
        i1 = i2;
      } while (paramTroopInfo.Administrator == null);
      i1 = i2;
    } while (!paramTroopInfo.Administrator.contains(paramString));
    return 2;
  }
  
  protected View a(int paramInt)
  {
    View localView = LayoutInflater.from(this).inflate(2130904496, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    localView.setTag(new TroopMemberCardActivity.ViewHolder(localView, paramInt));
    return localView;
  }
  
  public String a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt1 == 0)
    {
      localStringBuilder.append(getString(2131366573));
      localStringBuilder.append("  ");
    }
    for (;;)
    {
      if (paramInt2 != 0)
      {
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(getString(2131366575));
        localStringBuilder.append("  ");
      }
      if (!TextUtils.isEmpty(paramString1))
      {
        localStringBuilder.append(paramString1);
        localStringBuilder.append("  ");
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        localStringBuilder.append(paramString2);
        localStringBuilder.append("  ");
      }
      return localStringBuilder.toString();
      if (paramInt1 == 1)
      {
        localStringBuilder.append(getString(2131366574));
        localStringBuilder.append("  ");
      }
    }
  }
  
  public String a(long paramLong)
  {
    if (paramLong == 1L) {
      return "";
    }
    if (paramLong > 0L) {
      try
      {
        String str = DateFormat.format(getString(2131367377), 1000L * paramLong).toString();
        return str;
      }
      catch (Exception localException)
      {
        return "";
      }
    }
    return getString(2131367378);
  }
  
  protected String a(String paramString1, String paramString2)
  {
    Object localObject1;
    for (;;)
    {
      try
      {
        if (this.i == 0)
        {
          paramString1 = this.app.c();
          localObject1 = paramString1;
          if (TextUtils.isEmpty(paramString1)) {
            localObject1 = paramString2;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "getNickName, nick=" + (String)localObject1);
          break;
        }
        localObject1 = (FriendsManager)this.app.getManager(49);
        Object localObject3 = (TroopManager)this.app.getManager(50);
        Object localObject2 = ((FriendsManager)localObject1).a(paramString2);
        TroopMemberInfo localTroopMemberInfo = ((TroopManager)localObject3).a(paramString1, paramString2);
        localObject3 = ((FriendsManager)localObject1).a(paramString2);
        if (localObject2 == null) {
          break label342;
        }
        if (((Friends)localObject2).isFriend())
        {
          localObject1 = ((Friends)localObject2).remark;
          paramString1 = (String)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramString1 = ((Friends)localObject2).name;
          }
          localObject1 = paramString1;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "getNickName, Friends!=null, remark=" + ((Friends)localObject2).remark + " name=" + ((Friends)localObject2).name);
            localObject1 = paramString1;
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = localObject1;
            if (localTroopMemberInfo != null)
            {
              paramString1 = localTroopMemberInfo.friendnick;
              localObject2 = paramString1;
              if (QLog.isColorLevel())
              {
                QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "getNickName, TroopMemberInfo!=null, friendnick=" + localTroopMemberInfo.friendnick);
                localObject2 = paramString1;
              }
            }
          }
          paramString1 = (String)localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          paramString1 = (String)localObject2;
          if (localObject3 == null) {
            continue;
          }
          localObject1 = ((Card)localObject3).strNick;
          paramString1 = (String)localObject1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "getNickName, card!=null, strNick=" + ((Card)localObject3).strNick);
          paramString1 = (String)localObject1;
          continue;
        }
        localObject1 = "";
      }
      catch (Exception paramString1)
      {
        return paramString2;
      }
      continue;
      label342:
      localObject1 = "";
    }
    return localObject1;
  }
  
  protected void a()
  {
    try
    {
      startTitleProgress();
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(Long.parseLong(this.jdField_c_of_type_JavaLangString), Long.parseLong(this.jdField_e_of_type_JavaLangString));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "loadTroopMemberCard:" + localException.toString());
    }
  }
  
  public void a(int paramInt)
  {
    if (this.s == 1)
    {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("memberOperationFlag", paramInt);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("memberOperateUin", this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  protected void a(int paramInt, LinearLayout paramLinearLayout)
  {
    int i2 = paramLinearLayout.getChildCount();
    int i1 = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i1;
      if (paramInt != 0) {
        break;
      }
    }
    for (i1 = 8;; i1 = 0)
    {
      paramLinearLayout.setVisibility(i1);
      while (paramInt < i2)
      {
        localView = paramLinearLayout.getChildAt(paramInt);
        if (localView != null) {
          localView.setVisibility(8);
        }
        paramInt += 1;
      }
      a(paramLinearLayout.getChildAt(0), 3, 2131368232, 2130840474, 2131362000);
      View localView = paramLinearLayout.getChildAt(1);
      if (localView != null) {
        localView.setVisibility(0);
      }
      a(paramLinearLayout.getChildAt(2), 5, 2131368267, 2130840477, 2131362002);
      localView = paramLinearLayout.getChildAt(3);
      if (localView != null) {
        localView.setVisibility(0);
      }
      a(paramLinearLayout.getChildAt(4), 4, 2131366330, 2130840484, 2131362001);
      paramInt = 5;
      break;
      a(paramLinearLayout.getChildAt(0), 5, 2131368267, 2130840477, 2131362002);
      localView = paramLinearLayout.getChildAt(1);
      if (localView != null) {
        localView.setVisibility(0);
      }
      a(paramLinearLayout.getChildAt(2), 4, 2131366330, 2130840484, 2131362001);
      paramInt = 3;
      break;
      a(paramLinearLayout.getChildAt(0), 3, 2131368232, 2130840474, 2131362000);
      paramInt = 1;
      break;
      paramInt = 0;
      break;
    }
  }
  
  public void a(int paramInt, TroopMemberCard paramTroopMemberCard)
  {
    if (paramTroopMemberCard == null) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "updateParams: cardInfo==null, ");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "updateParams: uint32_result:" + paramTroopMemberCard.result + " memberRole:" + paramTroopMemberCard.memberRole);
      }
    } while ((paramTroopMemberCard.result != 0) && (paramTroopMemberCard.memberRole != 0));
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = paramTroopMemberCard;
    ((TroopManager)this.app.getManager(50)).a(this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, paramTroopMemberCard);
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "updateParams, TroopManager.saveTroopMemberCard");
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.TroopMemberCardActivity", 2, "updateParams, server level name:" + paramTroopMemberCard.levelName);
    }
    this.jdField_f_of_type_JavaLangString = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.remark;
    }
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.nick;
    }
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      this.jdField_f_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    }
    this.t = paramInt;
    this.jdField_g_of_type_JavaLangString = a(paramTroopMemberCard.joinTime);
    this.h = a(paramTroopMemberCard.sex, paramTroopMemberCard.age, paramTroopMemberCard.location, "");
    c();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, paramInt, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramString, paramInt2);
    }
  }
  
  protected void a(long paramLong1, long paramLong2, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong2));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(paramInt, paramLong1, localArrayList);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = new IconPopupWindow(this);
    if (this.i == 0)
    {
      this.I = 2;
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131367052, this.jdField_e_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(paramView, 1);
      return;
      this.jdField_a_of_type_Boolean = ((TroopGagMgr)this.app.getManager(47)).a(this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131367622, this.jdField_e_of_type_AndroidViewView$OnClickListener);
        this.I = 4;
      }
      else
      {
        int i1;
        if ((this.t == 3) || ((this.t == 2) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 3) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 2)))
        {
          i1 = 1;
          label149:
          if (i1 == 0) {
            break label299;
          }
          if (!this.jdField_a_of_type_Boolean) {
            break label252;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131363783, this.jdField_e_of_type_AndroidViewView$OnClickListener);
          label175:
          this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131367622, this.jdField_e_of_type_AndroidViewView$OnClickListener);
          if (this.t == 3)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 2) {
              break label270;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131365826, this.jdField_e_of_type_AndroidViewView$OnClickListener);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131365828, this.jdField_e_of_type_AndroidViewView$OnClickListener);
          this.I = 3;
          break;
          i1 = 0;
          break label149;
          label252:
          this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131363782, this.jdField_e_of_type_AndroidViewView$OnClickListener);
          break label175;
          label270:
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 1) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131365825, this.jdField_e_of_type_AndroidViewView$OnClickListener);
          }
        }
        label299:
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131367622, this.jdField_e_of_type_AndroidViewView$OnClickListener);
        this.I = 4;
      }
    }
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView != null)
    {
      paramView.setVisibility(0);
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription(getString(paramInt4));
      paramView = (TextView)paramView.findViewById(2131297022);
      paramView.setText(paramInt2);
      paramView.setContentDescription(getString(paramInt4));
    }
  }
  
  protected void a(View paramView, String paramString, boolean paramBoolean)
  {
    TroopMemberCardActivity.ViewHolder localViewHolder;
    if ((paramView.getTag() instanceof TroopMemberCardActivity.ViewHolder))
    {
      localViewHolder = (TroopMemberCardActivity.ViewHolder)paramView.getTag();
      localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      if (paramBoolean)
      {
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramView.setClickable(true);
      }
    }
    else
    {
      return;
    }
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramView.setClickable(false);
  }
  
  protected void a(LinearLayout paramLinearLayout, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    View localView = a(paramInt);
    localView.setContentDescription(paramString1);
    this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt] = localView;
    TroopMemberCardActivity.ViewHolder localViewHolder;
    if ((localView.getTag() instanceof TroopMemberCardActivity.ViewHolder))
    {
      localViewHolder = (TroopMemberCardActivity.ViewHolder)localView.getTag();
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
      localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
      if (!paramBoolean) {
        break label97;
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localView.setClickable(true);
    }
    for (;;)
    {
      paramLinearLayout.addView(localView);
      return;
      label97:
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localView.setClickable(false);
    }
  }
  
  protected void a(TextView paramTextView, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    int i2 = 0;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "showVipAndSqq:" + paramBoolean1 + ", " + paramBoolean2 + ", " + paramInt + ", " + paramBoolean3);
        }
        if ((paramBoolean1) || (paramBoolean2) || (this.i == 0)) {
          break label638;
        }
        return;
      }
      catch (Exception paramTextView)
      {
        String str2;
        if (!QLog.isColorLevel()) {
          break label637;
        }
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "showVipAndSqq:" + paramTextView.toString());
        return;
        String str1 = "https://i.gtimg.cn/club/mobile/profile/iconnew/qvip_profile_svip_" + i1 + ".png";
        continue;
        float f1 = this.jdField_a_of_type_Float * 57.0F;
        continue;
        if (!paramBoolean2) {
          continue;
        }
        if (!paramBoolean3) {
          continue;
        }
        str1 = "https://i.gtimg.cn/club/mobile/profile/iconnew/qvip_profile_vip_annual_" + i1 + ".png";
        Object localObject = new ColorDrawable(0);
        localObject = URLDrawable.getDrawable(str1, (Drawable)localObject, (Drawable)localObject);
        paramInt = (int)(this.jdField_a_of_type_Float * 24.0F);
        if (!paramBoolean3) {
          continue;
        }
        f1 = this.jdField_a_of_type_Float * 60.0F;
        ((Drawable)localObject).setBounds(0, 0, (int)f1, paramInt);
        continue;
        str1 = "https://i.gtimg.cn/club/mobile/profile/iconnew/qvip_profile_vip_" + i1 + ".png";
        continue;
        f1 = this.jdField_a_of_type_Float * 50.0F;
        continue;
        if (this.i != 0) {
          continue;
        }
        localObject = getResources().getDrawable(2130840529);
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
        str1 = "";
        continue;
        paramTextView.setPadding(0, 0, 0, 0);
        continue;
        localObject = null;
        str1 = "";
        continue;
      }
      if (paramBoolean1) {
        if (paramBoolean3)
        {
          str1 = "https://i.gtimg.cn/club/mobile/profile/iconnew/qvip_profile_svip_annual_" + i1 + ".png";
          localObject = new ColorDrawable(0);
          localObject = URLDrawable.getDrawable(str1, (Drawable)localObject, (Drawable)localObject);
          paramInt = (int)(this.jdField_a_of_type_Float * 26.0F);
          if (!paramBoolean3) {
            continue;
          }
          f1 = this.jdField_a_of_type_Float * 66.0F;
          ((Drawable)localObject).setBounds(0, 0, (int)f1, paramInt);
          str2 = paramString + "  ";
          paramInt = i2;
          paramString = str2;
          if (localObject != null)
          {
            paramInt = str2.length();
            paramString = str2 + "0";
          }
          paramString = new SpannableString(paramString);
          if (localObject != null) {
            paramString.setSpan(new ImageSpan((Drawable)localObject, 0), paramInt, paramInt + 1, 34);
          }
          if (localObject == null) {
            continue;
          }
          paramTextView.setPadding(0, 0, 0, (int)(6.0F * this.jdField_a_of_type_Float + 0.5F));
          paramTextView.setText(paramString);
          if (!QLog.isColorLevel()) {
            break label637;
          }
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "showVipAndSqq: url" + str1);
        }
      }
      label637:
      return;
      label638:
      int i1 = paramInt;
      if (paramInt < 1) {
        i1 = 1;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (isResume()) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mIsShield) {
        i1 = 2;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131367875, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131367872, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131367878, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.e(2131365736);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.f(i1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      this.I = 1;
      return;
    }
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0) {
      paramString1 = "";
    }
    ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, paramString1, paramString3, paramString2, false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (this.i == 0)
    {
      paramString3 = new ProfileActivity.AllInOne(paramString3, 0);
      paramString3.jdField_d_of_type_JavaLangString = paramString2;
      paramString3.jdField_c_of_type_JavaLangString = paramString1;
      paramString3.g = 1;
      paramString1 = ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, paramString3);
      paramString1.putExtra("AllInOne", paramString3);
      startActivityForResult(paramString1, 2);
      return;
    }
    if (paramBoolean)
    {
      paramString3 = new ProfileActivity.AllInOne(paramString3, 20);
      paramString3.jdField_d_of_type_JavaLangString = paramString2;
      paramString3.jdField_c_of_type_JavaLangString = paramString1;
      paramString3.g = 1;
      paramString1 = ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, paramString3);
      paramString1.putExtra("AllInOne", paramString3);
      startActivityForResult(paramString1, 2);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0) {}
    for (paramString3 = new ProfileActivity.AllInOne(paramString3, 19);; paramString3 = new ProfileActivity.AllInOne(paramString3, 21))
    {
      paramString3.jdField_d_of_type_JavaLangString = paramString2;
      paramString3.jdField_c_of_type_JavaLangString = paramString1;
      paramString3.g = 1;
      paramString1 = ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, paramString3);
      paramString1.putExtra("AllInOne", paramString3);
      startActivityForResult(paramString1, 2);
      return;
    }
  }
  
  protected void a(List paramList)
  {
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initCustomItems: customItemList==null or size==0, return");
      }
      return;
    }
    int i2 = paramList.size();
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initCustomItems: size=" + i2);
    }
    Object localObject = (TextView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity).inflate(2130904497, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    ((TextView)localObject).setText(2131367710);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    int i1 = 0;
    if (i1 < i2)
    {
      localObject = (TroopMemberCard.CustomEntry)paramList.get(i1);
      View localView = a(i1);
      TroopMemberCardActivity.ViewHolder localViewHolder = (TroopMemberCardActivity.ViewHolder)localView.getTag();
      if (!TextUtils.isEmpty(((TroopMemberCard.CustomEntry)localObject).label)) {
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopMemberCard.CustomEntry)localObject).label);
      }
      if (!TextUtils.isEmpty(((TroopMemberCard.CustomEntry)localObject).info)) {
        localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((TroopMemberCard.CustomEntry)localObject).info);
      }
      if ((((TroopMemberCard.CustomEntry)localObject).isClickable) && (!TextUtils.isEmpty(((TroopMemberCard.CustomEntry)localObject).linkUrl)))
      {
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localView.setClickable(true);
      }
      for (;;)
      {
        localView.setBackgroundResource(2130838103);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
        i1 += 1;
        break;
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localView.setClickable(false);
      }
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  protected void a(List paramList, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    ((View)this.jdField_b_of_type_AndroidViewView.getParent()).setVisibility(8);
    Object localObject1 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302351);
    Object localObject2 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131297479);
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131302354);
    ((TextView)localObject1).setText(paramString1);
    ((TextView)localObject2).setText(paramInt + "");
    localLinearLayout.removeAllViews();
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initTroopBar: troopBarList==null or size==0, return");
      }
      return;
    }
    int i2 = getResources().getDimensionPixelSize(2131493177);
    int i3 = getResources().getDimensionPixelSize(2131493178);
    int i1 = paramList.size();
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initTroopBar: size " + i1 + " url:" + paramString2 + " toutalCount:" + paramInt);
    }
    if (i1 > 4) {}
    for (paramInt = 4;; paramInt = i1)
    {
      i1 = 0;
      if (i1 < paramInt)
      {
        paramString2 = ((TroopMemberCard.GBarInfo)paramList.get(i1)).headUrl;
        localObject2 = new FrameLayout(this);
        localObject1 = new LinearLayout.LayoutParams(i2, i2);
        ((LinearLayout.LayoutParams)localObject1).rightMargin = i3;
        ((FrameLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = new ImageView(this);
        ((ImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Object localObject3 = new ImageView(this);
        ((ImageView)localObject3).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ((ImageView)localObject3).setBackgroundResource(2130841000);
        ((FrameLayout)localObject2).addView((View)localObject1);
        ((FrameLayout)localObject2).addView((View)localObject3);
        localLinearLayout.addView((View)localObject2);
        for (;;)
        {
          try
          {
            localObject2 = new ColorDrawable(getResources().getColor(2131427451));
            localObject3 = URLDrawable.getDrawable(paramString2, i2, i2, (Drawable)localObject2, (Drawable)localObject2, false);
            if (localObject3 == null) {
              continue;
            }
            ((ImageView)localObject1).setImageDrawable((Drawable)localObject3);
          }
          catch (Exception localException)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("Q.profilecard.TroopMemberCardActivity", 2, localException.toString());
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initTroopBar, addBar:" + paramString2);
          }
          i1 += 1;
          break;
          if (localObject2 != null) {
            ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
          }
        }
      }
      if (paramString1 != null) {
        this.jdField_b_of_type_AndroidViewView.setContentDescription(paramString1);
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      ((View)this.jdField_b_of_type_AndroidViewView.getParent()).setVisibility(0);
      return;
    }
  }
  
  protected boolean a()
  {
    Intent localIntent = getIntent();
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("troopUin");
    this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("memberUin");
    this.s = localIntent.getIntExtra("fromFlag", 0);
    if (this.s == 4) {
      ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "silent", "Clk_name", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "checkIntentParams:" + this.jdField_c_of_type_JavaLangString + "," + this.jdField_e_of_type_JavaLangString + "," + this.s);
    }
    if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || (TextUtils.isEmpty(this.app.a()))) {
      return false;
    }
    if (this.jdField_e_of_type_JavaLangString.equals(this.app.a())) {}
    for (this.i = 0;; this.i = 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.app.a(19));
      b();
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      this.app.registObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
      return true;
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    paramString1 = DBUtils.a().a(this.app, paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.isTroopFollowed;
    }
    return false;
  }
  
  protected String b(String paramString1, String paramString2)
  {
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.app.getManager(8);
    if (localFriendsManagerImp != null) {
      return localFriendsManagerImp.b(paramString1, paramString2);
    }
    return "";
  }
  
  protected void b()
  {
    boolean bool = false;
    Object localObject1 = (FriendManager)this.app.getManager(8);
    Object localObject4 = (TroopManager)this.app.getManager(50);
    Object localObject2 = ((FriendManager)localObject1).a(this.jdField_c_of_type_JavaLangString);
    Object localObject3 = DBUtils.a().a(this.app, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
    if (localObject2 != null)
    {
      this.jdField_b_of_type_JavaLangString = ((TroopInfo)localObject2).troopname;
      this.jdField_d_of_type_JavaLangString = ((TroopInfo)localObject2).troopcode;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initParams: troopInfo != null, troopCode:" + this.jdField_d_of_type_JavaLangString + ", mTroopName:" + this.jdField_b_of_type_JavaLangString);
      }
    }
    localObject4 = ((TroopManager)localObject4).a(this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
    if (localObject4 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initParams: cacheCard != null");
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = ((TroopMemberCard)localObject4);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
        this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.remark;
      }
      if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
        this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.nick;
      }
      this.t = a((TroopInfo)localObject2, this.app.a());
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend = ((FriendManager)localObject1).b(this.jdField_e_of_type_JavaLangString);
      this.jdField_g_of_type_JavaLangString = a(((TroopMemberCard)localObject4).joinTime);
      this.h = a(((TroopMemberCard)localObject4).sex, ((TroopMemberCard)localObject4).age, ((TroopMemberCard)localObject4).location, "");
      if ((localObject2 != null) && (localObject3 != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName = ((String)((TroopInfo)localObject2).getTroopLevelMap().get(Integer.valueOf(((TroopMemberInfo)localObject3).level)));
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.TroopMemberCardActivity", 2, "initParams, troopInfo levelMap:" + ((TroopInfo)localObject2).troopLevelMap + " level:" + ((TroopMemberInfo)localObject3).level + " levelName:" + this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName);
        }
        a((TroopInfo)localObject2);
      }
      return;
    }
    this.jdField_f_of_type_JavaLangString = a(this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.credit = 0;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend = ((FriendManager)localObject1).b(this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned = a(this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mIsShield = b(this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card = b(this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isAllowModCard = true;
    this.t = a((TroopInfo)localObject2, this.app.a());
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole = a((TroopInfo)localObject2, this.jdField_e_of_type_JavaLangString);
    if ((localObject2 != null) && (localObject3 != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName = ((String)((TroopInfo)localObject2).getTroopLevelMap().get(Integer.valueOf(((TroopMemberInfo)localObject3).level)));
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.TroopMemberCardActivity", 2, "initParams, troopInfo levelMap:" + ((TroopInfo)localObject2).troopLevelMap + " level:" + ((TroopMemberInfo)localObject3).level + " levelName:" + this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName);
      }
      a((TroopInfo)localObject2);
    }
    int i2;
    int i1;
    if (localObject3 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initParams: troopMemberInfo != null");
      }
      if (((TroopMemberInfo)localObject3).join_time != 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.joinTime = ((TroopMemberInfo)localObject3).join_time;
        this.jdField_g_of_type_JavaLangString = a(((TroopMemberInfo)localObject3).join_time);
      }
    }
    else
    {
      i2 = -1;
      localObject3 = ((FriendManager)localObject1).a(this.jdField_e_of_type_JavaLangString);
      if (localObject3 == null) {
        break label963;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initParams: card != null");
      }
      i2 = ((Card)localObject3).shGender;
      i1 = ((Card)localObject3).age;
      localObject2 = ((Card)localObject3).strProvince;
      localObject1 = ((Card)localObject3).strCity;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.sex = i2;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.age = i1;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.location = ((String)localObject2 + "  " + (String)localObject1);
      this.h = a(i2, i1, (String)localObject2, (String)localObject1);
      if (localObject3 == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isVip = ((Card)localObject3).isVipOpen(EVIPSPEC.E_SP_QQVIP);
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isSuperVip = ((Card)localObject3).isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isSuperQQ = ((Card)localObject3).isVipOpen(EVIPSPEC.E_SP_SUPERQQ);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isVip) {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.vipLevel = ((Card)localObject3).getVipLevel(EVIPSPEC.E_SP_QQVIP);
      }
      for (;;)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard;
        if (((Card)localObject3).iQQVipType == 1) {
          bool = true;
        }
        ((TroopMemberCard)localObject1).isYearVip = bool;
        return;
        this.jdField_g_of_type_JavaLangString = "";
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isSuperVip) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.vipLevel = ((Card)localObject3).getVipLevel(EVIPSPEC.E_SP_SUPERVIP);
        }
      }
      label963:
      localObject1 = "";
      localObject2 = "";
      i1 = 0;
    }
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  protected void b(String paramString)
  {
    Bitmap localBitmap = ImageUtil.a();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    ThreadManager.b(new fif(this, paramString));
  }
  
  public void b(String paramString1, String paramString2)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card;
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, EditInfoActivity.class);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("title", getString(2131366355));
    localIntent.putExtra("default", str);
    localIntent.putExtra("isTroopNick", true);
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("uin", paramString2);
    localIntent.putExtra("num", 60);
    startActivityForResult(localIntent, 1);
    paramString1 = "";
    if (this.i == 0) {
      paramString1 = "2";
    }
    for (;;)
    {
      ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "modify_name", "Clk", 0, 0, this.jdField_c_of_type_JavaLangString, paramString1, "", "");
      return;
      if (this.t == 3) {
        paramString1 = "0";
      } else if (this.t == 2) {
        paramString1 = "1";
      }
    }
  }
  
  protected boolean b()
  {
    boolean bool = true;
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L) {
      bool = false;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    return bool;
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    paramString1 = DBUtils.a().a(this.app, paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.mIsShielded;
    }
    return false;
  }
  
  protected void c()
  {
    Object localObject1 = (FriendsManagerImp)this.app.getManager(8);
    if (localObject1 != null) {}
    for (Object localObject2 = ((FriendsManagerImp)localObject1).a(this.jdField_c_of_type_JavaLangString);; localObject2 = null)
    {
      if (localObject2 == null) {
        finish();
      }
      Object localObject3;
      Object localObject4;
      Object localObject5;
      TextView localTextView;
      label182:
      label217:
      label371:
      boolean bool;
      label406:
      label542:
      label572:
      label751:
      int i1;
      label666:
      label675:
      label829:
      label851:
      do
      {
        return;
        localObject1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302346);
        localObject3 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302348);
        localObject4 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302349);
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302347));
        localObject5 = this.jdField_a_of_type_AndroidViewView.findViewById(2131302343);
        localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302344);
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 0) {
          break;
        }
        ((View)localObject5).setVisibility(0);
        localTextView.setText(2131366370);
        ((TextView)localObject1).setText(this.jdField_f_of_type_JavaLangString);
        if (TextUtils.isEmpty(this.h)) {
          break label1223;
        }
        ((TextView)localObject3).setText(this.h);
        ((TextView)localObject3).setVisibility(0);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0) || (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString))) {
          break label1233;
        }
        ((TextView)localObject4).setText(this.jdField_g_of_type_JavaLangString);
        ((TextView)localObject4).setVisibility(0);
        localObject1 = super.getString(2131368199) + super.getString(2131367013) + this.jdField_f_of_type_JavaLangString + this.h + this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_AndroidViewView.setContentDescription((CharSequence)localObject1);
        localObject3 = this.jdField_a_of_type_ArrayOfAndroidViewView[0];
        a((View)localObject3, this.jdField_e_of_type_JavaLangString, true);
        a(((TroopMemberCardActivity.ViewHolder)((View)localObject3).getTag()).jdField_b_of_type_AndroidWidgetTextView, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isSuperVip, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isVip, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.vipLevel, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isYearVip);
        if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isSuperVip) {
          break label1254;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isYearVip) {
          break label1243;
        }
        localObject1 = super.getString(2131364162);
        localObject1 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.vipLevel + super.getString(2131366364);
        ((View)localObject3).setContentDescription(super.getString(2131368199) + this.jdField_e_of_type_JavaLangString + (String)localObject1);
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0) {
          break label1736;
        }
        this.jdField_a_of_type_ArrayOfAndroidViewView[1].setVisibility(0);
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card;
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = getString(2131367125);
        }
        localObject3 = this.jdField_a_of_type_ArrayOfAndroidViewView[1];
        ((View)localObject3).setContentDescription(super.getString(2131366355) + (String)localObject1);
        if (this.i != 0) {
          break label1342;
        }
        a((View)localObject3, (String)localObject1, true);
        localObject1 = getString(2131366349);
        this.jdField_a_of_type_ArrayOfAndroidViewView[2].setVisibility(0);
        if (TextUtils.isEmpty(this.j)) {
          break label1390;
        }
        bool = true;
        localObject3 = this.jdField_a_of_type_ArrayOfAndroidViewView[2];
        if (bool) {
          ((View)localObject3).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        }
        localObject4 = (TroopMemberCardActivity.ViewHolder)((View)localObject3).getTag();
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 2) {
          break label1437;
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitle)) {
          break label1395;
        }
        a((View)localObject3, getString(2131365819), bool);
        localObject1 = (String)localObject1 + getString(2131365819);
        TroopMemberListActivity.a(((TroopMemberCardActivity.ViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView, 1);
        localObject5 = (TextView)((View)localObject3).findViewById(2131302352);
        if (((((TroopManager)this.app.getManager(50)).a() & 0x4) != 0) || (!"5.5.0".equals("5.9.3"))) {
          break label1694;
        }
        ((TextView)localObject5).setVisibility(0);
        localObject1 = (String)localObject1 + getString(2131364008);
        ((View)localObject3).setContentDescription((CharSequence)localObject1);
        if ((((TroopInfo)localObject2).cGroupRankSysFlag != 1) || (((TroopInfo)localObject2).cGroupRankUserFlag != 1)) {
          ((TroopMemberCardActivity.ViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        this.jdField_a_of_type_ArrayOfAndroidViewView[3].setVisibility(0);
        this.jdField_a_of_type_ArrayOfAndroidViewView[3].setContentDescription(getString(2131363749));
        localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[4];
        if (this.i == 0) {
          break label1704;
        }
        d();
        i1 = 0;
        if (this.i == 1)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
            break label1731;
          }
          i1 = 3;
        }
        a(i1, this.jdField_b_of_type_AndroidWidgetLinearLayout);
        a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.customEntryList);
        a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.gbarList, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.gbarTitle, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.gbarLinkUrl, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.gbarCount);
      } while ((!TroopMemberLbsHelper.a(this.jdField_c_of_type_JavaLangString, this.app).booleanValue()) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.distance == -1L));
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.distance >= 0L) {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.distance < 10L)
        {
          localObject1 = "0.01km";
          label964:
          localObject3 = "icon" + " " + (String)localObject1;
          localObject2 = new ImageSpan(this, 2130839097, 1);
          localObject3 = new SpannableString((CharSequence)localObject3);
          ((SpannableString)localObject3).setSpan(localObject2, 0, "icon".length(), 17);
          localObject1 = getString(2131364023, new Object[] { localObject1 });
          this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131366372) + (String)localObject1);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
        }
      }
      for (;;)
      {
        localObject1 = (FriendsManagerImp)this.app.getManager(8);
        ((TroopManager)this.app.getManager(50)).a(this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, null, -100, null, null, -100, -100, -100, -100L, (byte)-100, -100L, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.distance);
        return;
        if ((this.i != 0) && ((this.t == 2) || (this.t == 3)) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.credit == 1))
        {
          ((View)localObject5).setVisibility(0);
          localTextView.setText(2131366371);
          break;
        }
        ((View)localObject5).setVisibility(8);
        break;
        label1223:
        ((TextView)localObject3).setVisibility(8);
        break label182;
        label1233:
        ((TextView)localObject4).setVisibility(8);
        break label217;
        label1243:
        localObject1 = super.getString(2131364163);
        break label371;
        label1254:
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isVip)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isYearVip) {}
          for (localObject1 = super.getString(2131364164);; localObject1 = super.getString(2131364165))
          {
            localObject1 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.vipLevel + super.getString(2131366364);
            break;
          }
        }
        localObject1 = super.getString(2131364166);
        break label406;
        label1342:
        if (((this.t == 2) || (this.t == 3)) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isAllowModCard))
        {
          a((View)localObject3, (String)localObject1, true);
          break label542;
        }
        a((View)localObject3, (String)localObject1, false);
        break label542;
        label1390:
        bool = false;
        break label572;
        label1395:
        a((View)localObject3, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitle, bool);
        localObject1 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitle;
        break label666;
        label1437:
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 3)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitle)) {
            a((View)localObject3, getString(2131365820), bool);
          }
          for (localObject1 = (String)localObject1 + getString(2131365820);; localObject1 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitle)
          {
            TroopMemberListActivity.a(((TroopMemberCardActivity.ViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView, 0);
            break;
            a((View)localObject3, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitle, bool);
          }
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitle))
        {
          a((View)localObject3, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitle, bool);
          TroopMemberListActivity.a(((TroopMemberCardActivity.ViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView, 2);
          localObject1 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitle;
          break label675;
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName))
        {
          a((View)localObject3, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName, bool);
          TroopMemberListActivity.a(((TroopMemberCardActivity.ViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView, 3);
          localObject1 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName;
          break label675;
        }
        ((TroopMemberCardActivity.ViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        break label675;
        label1694:
        ((TextView)localObject5).setVisibility(8);
        break label751;
        label1704:
        ((View)localObject1).setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label829;
        label1731:
        i1 = 2;
        break label851;
        label1736:
        this.jdField_a_of_type_ArrayOfAndroidViewView[1].setVisibility(8);
        a((ViewGroup)this.jdField_a_of_type_ArrayOfAndroidViewView[3].getParent(), this.jdField_a_of_type_ArrayOfAndroidViewView[1]);
        a((ViewGroup)this.jdField_a_of_type_ArrayOfAndroidViewView[2].getParent(), this.jdField_a_of_type_ArrayOfAndroidViewView[1]);
        this.jdField_a_of_type_ArrayOfAndroidViewView[2].setVisibility(8);
        this.jdField_a_of_type_ArrayOfAndroidViewView[3].setVisibility(8);
        ((View)this.jdField_a_of_type_ArrayOfAndroidViewView[3].getParent()).setVisibility(8);
        this.jdField_a_of_type_ArrayOfAndroidViewView[4].setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        i1 = 0;
        if (this.i == 1) {
          if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
            break label1902;
          }
        }
        label1902:
        for (i1 = 3;; i1 = 1)
        {
          a(i1, this.jdField_b_of_type_AndroidWidgetLinearLayout);
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.distance < 10000L)
        {
          localObject1 = new DecimalFormat("0.00");
          localObject1 = ((DecimalFormat)localObject1).format(Math.round(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.distance / 10.0D) * 0.01D) + "km";
          break label964;
        }
        localObject1 = String.valueOf(Math.round(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.distance / 1000.0D)) + "km";
        break label964;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void c(String paramString)
  {
    if (!b())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "gotoQQVipWebPage, checkClickTime: false");
      }
      return;
    }
    if (this.i == 0) {}
    for (paramString = String.format("https://m.vip.qq.com/redirect/index.php?go=androidzhanghao&sid=%s&qq=%s&aid=%s&_wv=5123", new Object[] { this.app.getSid(), Integer.valueOf(0), "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun" });; paramString = String.format("https://m.vip.qq.com/redirect/index.php?go=androidzhanghao&sid=%s&qq=%s&aid=%s&_wv=5123", new Object[] { this.app.getSid(), paramString, "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun" }))
    {
      paramString = paramString + "&ADTAG=mqq_qunmingpian";
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.a());
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "gotoQQVipWebPage, url:" + paramString);
      }
      ReportController.b(this.app, "CliOper", "", "", "vip", "logo_in", 24, 0, "", "", "", "");
      return;
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this, RecentSaidActivity.class);
    localIntent.putExtra("troop_uin", paramString1);
    localIntent.putExtra("member_uin", paramString2);
    localIntent.putExtra("member_is_shield", this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mIsShield);
    startActivity(localIntent);
  }
  
  public boolean c()
  {
    if (!NetworkUtil.e(this))
    {
      a(getString(2131367328));
      return false;
    }
    return true;
  }
  
  public void d()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[4];
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mIsShield)
    {
      a(localView, super.getString(2131367878), true);
      localView.setContentDescription(super.getString(2131367714) + super.getString(2131367878));
    }
    for (;;)
    {
      localView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 4, "updateMemberSpeak");
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned)
      {
        a(localView, super.getString(2131367872), true);
        localView.setContentDescription(super.getString(2131367714) + super.getString(2131367872));
      }
      else
      {
        a(localView, super.getString(2131367875), true);
        localView.setContentDescription(super.getString(2131367714) + super.getString(2131367875));
      }
    }
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "openTroopBarPage:" + paramString);
    }
    if (!b())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "openTroopBarPage, checkClickTime: false");
      }
      return;
    }
    paramString = new Intent(this, QQBrowserActivity.class);
    paramString.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.gbarLinkUrl);
    paramString.putExtra("webStyle", "noBottomBar");
    paramString.putExtra("hide_more_button", true);
    paramString.putExtra("hide_operation_bar", true);
    paramString.putExtra("isShowAd", false);
    startActivity(paramString);
  }
  
  protected void d(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this, ChatHistory.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("member_uin", paramString2);
    localIntent.putExtra("from_troop_card", true);
    startActivityForResult(localIntent, 6);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str;
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      case 5: 
      default: 
      case 1: 
        do
        {
          return;
          a(2, getString(2131366338));
          paramIntent = this.jdField_a_of_type_ArrayOfAndroidViewView[1];
          str = b(this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card = str;
          a(paramIntent, str, true);
          paramIntent.setContentDescription(super.getString(2131366355) + str);
          a(0);
        } while (!QLog.isColorLevel());
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "doOnActivityResult, REQUEST_CODE_SET_TROOP_NICK");
        return;
      case 2: 
        if (paramIntent == null) {
          break;
        }
      }
    }
    for (boolean bool = paramIntent.getBooleanExtra("changed", false);; bool = false)
    {
      if (bool) {
        a(0);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "doOnActivityResult, REQUEST_CODE_SHOW_PERSONAL_CARD, isChanged:" + bool);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "doOnActivityResult, REQUEST_CODE_ADDFRIEND");
      return;
      bool = paramIntent.getBooleanExtra("isNeedFinish", false);
      str = paramIntent.getStringExtra("fin_tip_msg");
      paramIntent = paramIntent.getStringExtra("uin");
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "doOnActivityResult, REQUEST_CODE_TROOP_DISBAND, finSelf=" + bool + " strTip=" + str + " uin=" + paramIntent);
      }
      if (!TextUtils.isEmpty(paramIntent))
      {
        FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.app.getManager(8);
        if (localFriendsManagerImp != null)
        {
          TroopInfo localTroopInfo = localFriendsManagerImp.a(this.jdField_c_of_type_JavaLangString);
          if (localTroopInfo != null)
          {
            localTroopInfo.troopowneruin = paramIntent;
            localFriendsManagerImp.b(localTroopInfo);
          }
        }
      }
      if ((!TextUtils.isEmpty(str)) && (bool))
      {
        a(5, str, 1000);
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        a(2, str);
        return;
      }
      if (!bool) {
        break;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("isNeedFinish", true);
      setResult(-1, paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.finish();
      return;
      setResult(-1);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null) {
        break;
      }
      paramIntent = DBUtils.a().a(this.app, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitle = paramIntent.mUniqueTitle;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitleExpire = paramIntent.mUniqueTitleExpire;
      c();
      return;
      switch (paramInt1)
      {
      default: 
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null) {
        break;
      }
      paramIntent = DBUtils.a().a(this.app, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
      if (paramIntent == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitle = paramIntent.mUniqueTitle;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitleExpire = paramIntent.mUniqueTitleExpire;
      c();
      return;
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!a())
    {
      finish();
      return false;
    }
    setContentView(2130904494);
    e();
    i();
    c();
    a();
    f("exp");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.unRegistObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity = this;
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296532));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131302341));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    int i1 = (int)(this.jdField_a_of_type_Float * 20.0F + 0.5F);
    Object localObject = a(i1, 0);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity).inflate(2130904495, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    ((LinearLayout)localObject).addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302345));
    b(this.jdField_e_of_type_JavaLangString);
    a((LinearLayout)localObject);
    a((LinearLayout)localObject, 0, getString(2131368199), "", true);
    this.jdField_a_of_type_ArrayOfAndroidViewView[0].setOnLongClickListener(this);
    a((LinearLayout)localObject);
    a((LinearLayout)localObject, 1, getString(2131366355), "", true);
    m();
    a((LinearLayout)localObject);
    a((LinearLayout)localObject, 2, getString(2131366349), "", false);
    TroopMemberCardActivity.ViewHolder localViewHolder = (TroopMemberCardActivity.ViewHolder)this.jdField_a_of_type_ArrayOfAndroidViewView[2].getTag();
    localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
    localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130841670);
    localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
    localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setPadding((int)(7.0F * this.jdField_a_of_type_Float), 0, (int)(7.0F * this.jdField_a_of_type_Float), 0);
    localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 13.0F);
    ViewGroup.LayoutParams localLayoutParams = localViewHolder.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.height = ((int)(19.0F * this.jdField_a_of_type_Float));
    localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = a(i1, 0);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidWidgetLinearLayout);
    localObject = a(i1, 0);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity).inflate(2130904498, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    ((LinearLayout)localObject).addView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    localObject = a(i1, 0);
    a((LinearLayout)localObject, 3, getString(2131363749), "", true);
    this.jdField_c_of_type_AndroidViewView = a((LinearLayout)localObject);
    a((LinearLayout)localObject, 4, getString(2131367714), "", true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity).inflate(2130904497, this.jdField_a_of_type_AndroidWidgetLinearLayout, false));
    localObject = this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)(2.0F * this.jdField_a_of_type_Float));
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = getResources().getDimensionPixelSize(2131493174);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, getResources().getInteger(2131623939));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131367715);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(super.getString(2131367715));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    f();
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "openCustomItemPage:" + paramString);
    }
    if (!b())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "openCustomItemPage, checkClickTime: false");
      }
      return;
    }
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("isShowAd", false);
    startActivity(localIntent);
  }
  
  public void e(String paramString1, String paramString2)
  {
    String str1 = "";
    String str2;
    if (this.t == 3)
    {
      str1 = "0";
      str2 = "";
      if (this.i != 0) {
        break label145;
      }
      str2 = "0";
    }
    for (;;)
    {
      String str3 = "";
      if (paramString2 != null) {
        str3 = paramString2;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "doReport, actionName:" + paramString1 + " reportId:" + paramString2);
        }
        ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_card", paramString1, 0, 0, this.jdField_c_of_type_JavaLangString, str1, str2, str3);
        return;
      }
      catch (Exception paramString1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "doReport:" + paramString1.toString());
      }
      if (this.t == 2)
      {
        str1 = "1";
        break;
      }
      if (this.t != 1) {
        break;
      }
      str1 = "2";
      break;
      label145:
      if (this.i == 1) {
        str2 = "1";
      }
    }
  }
  
  protected void f()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    getResources().getColor(2131427889);
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 2130903986, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    localView = new View(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity);
    localView.setBackgroundColor(0);
    localLayoutParams = new LinearLayout.LayoutParams(1, -1);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 2130903986, null);
    localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    localView = new View(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity);
    localView.setBackgroundColor(0);
    localLayoutParams = new LinearLayout.LayoutParams(1, -1);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 2130903986, null);
    localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
  }
  
  public void f(String paramString)
  {
    e(paramString, null);
  }
  
  public void g()
  {
    Dialog localDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 2131558902);
    localDialog.setContentView(2130903294);
    ((TextView)localDialog.findViewById(2131297367)).setText(getString(2131365827));
    TextView localTextView = (TextView)localDialog.findViewById(2131296606);
    CheckBox localCheckBox = (CheckBox)localDialog.findViewById(2131297592);
    if ((localTextView.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((localCheckBox.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localCheckBox.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localTextView.setText(getString(2131365835));
    localCheckBox.setText(getString(2131365836));
    localTextView = (TextView)localDialog.findViewById(2131297370);
    Object localObject = (TextView)localDialog.findViewById(2131297371);
    localTextView.setText(17039360);
    ((TextView)localObject).setText(17039370);
    localTextView.setOnClickListener(new fiq(this, localDialog));
    ((TextView)localObject).setOnClickListener(new fhz(this, localCheckBox, localDialog));
    localDialog.show();
    ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_movegrp", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a((byte)0, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
      b(2131365843);
      ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_card", "un_admin", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
    }
    while (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 1) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a((byte)1, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
    b(2131365839);
    ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_card", "Clk_setadmin", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
  }
  
  protected void i()
  {
    if (this.i == 0) {
      setTitle(2131366353);
    }
    for (;;)
    {
      ImageView localImageView = this.rightViewImg;
      localImageView.setVisibility(0);
      localImageView.setImageResource(2130838415);
      localImageView.setContentDescription(getString(2131368801));
      localImageView.setOnClickListener(new fie(this));
      return;
      setTitle(2131366354);
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void k()
  {
    String str2 = this.jdField_f_of_type_JavaLangString;
    int i1 = 10004;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 0) {
      i1 = 3004;
    }
    for (String str1 = this.jdField_d_of_type_JavaLangString;; str1 = null)
    {
      startActivityForResult(AddFriendLogicActivity.a(this, 1, this.jdField_e_of_type_JavaLangString, str1, i1, 0, str2, null, null, null), 3);
      return;
    }
  }
  
  protected void l()
  {
    if (!TextUtils.isEmpty(this.j))
    {
      String str = Uri.encode(this.j);
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.a());
      localIntent.putExtra("url", "https://qinfo.clt.qq.com/qlevel/level.html?str=" + str);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView.setSelected(true);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131302484, getString(2131367603));
    BubbleContextMenu.a(paramView, localQQCustomMenu, this.jdField_g_of_type_AndroidViewView$OnClickListener, new fih(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberCardActivity
 * JD-Core Version:    0.7.0.1
 */