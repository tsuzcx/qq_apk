package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.biz.common.report.BnrReport;
import com.tencent.biz.helper.TroopInfoActivityHelper;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.AvatarWallView;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.GridView;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import fgx;
import fgy;
import fgz;
import fha;
import fhb;
import fhc;
import fhd;
import fhe;
import fhf;
import fhg;
import fhh;
import fhi;
import fhk;
import fhl;
import fhm;
import fhn;
import fho;
import fhp;
import fhq;
import fhr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.util.WeakReference;

public class TroopInfoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int A = 3001;
  public static final int B = 3002;
  public static final int C = 6;
  public static final int D = 5;
  public static final int E = 7;
  public static final int F = 11;
  public static final int G = 8;
  public static final int H = 9;
  public static final int I = 14;
  public static final int J = 15;
  public static final int K = 16;
  protected static final int L = 0;
  protected static final int M = 1;
  protected static final int N = 2;
  protected static final int O = 3;
  protected static final int P = 4;
  protected static final int Q = 5;
  protected static final int R = 6;
  protected static final int S = 7;
  protected static final int T = 8;
  protected static final int U = 9;
  protected static final int V = 10;
  protected static final int W = 10;
  protected static final int X = 11;
  protected static final int Y = 12;
  protected static final int Z = 13;
  public static final int a = 1;
  public static final String a = "Q.troopinfo";
  public static final int aA = 32;
  public static final int aB = 33;
  public static final int aC = 1;
  public static final int aD = 2;
  public static final int aE = 0;
  public static final int aF = 1;
  public static final int aG = 2;
  public static final int aH = 1;
  public static final int aI = 0;
  public static final int aJ = 2;
  public static final int aK = 3;
  public static final int aL = 4;
  protected static final int aN = 1;
  protected static final int aO = 2;
  protected static final int aP = 3;
  protected static final int aQ = 4;
  protected static final int aR = 5;
  protected static final int aS = 6;
  protected static final int aT = 7;
  protected static final int aU = 8;
  protected static final int aa = 14;
  public static final int ab = 31;
  public static final int ac = 2;
  public static final int ad = 3;
  public static final int ae = 4;
  public static final int af = 5;
  public static final int ag = 6;
  public static final int ah = 7;
  public static final int ai = 8;
  public static final int aj = 9;
  public static final int ak = 10;
  public static final int al = 11;
  public static final int am = 12;
  public static final int an = 14;
  public static final int ao = 18;
  public static final int ap = 19;
  public static final int aq = 21;
  public static final int ar = 22;
  public static final int as = 23;
  public static final int at = 24;
  public static final int au = 25;
  public static final int av = 24;
  public static final int aw = 26;
  public static final int ax = 30;
  public static final int ay = 13;
  public static final int az = 15;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 8;
  public static final int h = 9;
  public static final int i = 10;
  public static final int j = 11;
  public static final int k = 12;
  public static final int l = 13;
  public static final int m = 14;
  public static final int n = 15;
  public static final int o = 16;
  public static final int p = 17;
  public static final int q = 18;
  public static final int r = 19;
  public static final int s = 20;
  public static final int t = 21;
  public static final int u = 22;
  public static final int v = 23;
  public static final int w = 24;
  public static final int x = 25;
  public static final int y = 0;
  public static final int z = 18;
  public long a;
  public Dialog a;
  public Handler a;
  protected View a;
  protected LinearLayout a;
  public TextView a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new fhc(this);
  public FriendListHandler a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new fhb(this);
  public TroopHandler a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new fhe(this);
  public TroopInfo a;
  public AvatarWallAdapter a;
  public TroopInfoData a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public ArrayList a;
  public List a;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new fhp(this);
  protected boolean a;
  protected View[] a;
  public String[] a;
  public int aM = -1;
  public long b;
  public View b;
  protected String b;
  public boolean b;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString = "";
  public boolean c;
  private View d;
  public boolean d;
  protected boolean e = false;
  public boolean f = false;
  public boolean g = false;
  
  public TroopInfoActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidOsHandler = new fha(this);
  }
  
  public static Bundle a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte paramByte, long paramLong1, short paramShort, String paramString6, String paramString7, boolean paramBoolean, String paramString8, long paramLong2, long paramLong3, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putInt("troop_info_from_ex", paramInt2);
    localBundle.putString("troop_code", paramString2);
    localBundle.putString("troop_info_name", paramString3);
    localBundle.putString("troop_info_owner", paramString4);
    localBundle.putString("troop_info_admi", paramString5);
    localBundle.putByte("troop_info_opt", paramByte);
    localBundle.putLong("troop_info_classext", paramLong1);
    localBundle.putShort("troop_info_faceid", paramShort);
    localBundle.putString("troop_info_fingermemo", paramString6);
    localBundle.putString("troop_info_loca", paramString7);
    localBundle.putBoolean("troop_info_is_member", paramBoolean);
    localBundle.putString("param_return_addr", paramString8);
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramLong2);
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramLong3);
    return localBundle;
  }
  
  public static Bundle a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString);
    localBundle.putInt("troop_info_from", paramInt);
    return localBundle;
  }
  
  public static Bundle a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putInt("troop_info_from", paramInt1);
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putString("troop_info_loca", paramString2);
    }
    localBundle.putInt("troop_info_lat", paramInt2);
    localBundle.putInt("troop_info_lon", paramInt3);
    return localBundle;
  }
  
  private String a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f)) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f.length() < 2))
    {
      ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "0", "", "");
      return getString(2131364178);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k))
    {
      ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "2", "", "");
      return getString(2131364179);
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m)) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m.length() < 15))
    {
      ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "1", "", "");
      return getString(2131364180);
    }
    if (3 == this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short)
    {
      ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "3", "", "");
      return getString(2131364181);
    }
    return "";
  }
  
  private String a(int paramInt1, int paramInt2, String paramString)
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
      str = String.format("%d|%f|%f|%s", new Object[] { Integer.valueOf(0), Float.valueOf(paramInt1 / 1000000.0F), Float.valueOf(paramInt2 / 1000000.0F), paramString });
    }
    return str;
  }
  
  public static String a(Context paramContext, TroopInfoData paramTroopInfoData)
  {
    int i1 = 1;
    int i2 = 0;
    if (paramTroopInfoData == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Long.toString(paramTroopInfoData.jdField_a_of_type_Long);
    paramContext = GroupCatalogTool.a(paramContext).a(paramContext, str);
    if (!TextUtils.isEmpty(paramTroopInfoData.j)) {
      paramContext = paramTroopInfoData.j;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContext)) {
        localStringBuffer.append(paramContext + " | ");
      }
      for (;;)
      {
        if ((paramTroopInfoData.jdField_a_of_type_JavaUtilList != null) && (paramTroopInfoData.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          int i3 = paramTroopInfoData.jdField_a_of_type_JavaUtilList.size();
          for (;;)
          {
            if (i2 < i3)
            {
              if ((i1 == 0) || (!((String)paramTroopInfoData.jdField_a_of_type_JavaUtilList.get(i2)).equals(paramContext))) {
                localStringBuffer.append((String)paramTroopInfoData.jdField_a_of_type_JavaUtilList.get(i2) + " | ");
              }
              i2 += 1;
              continue;
              if ((paramContext == null) || (TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString))) {
                break label298;
              }
              if (paramContext.jdField_a_of_type_JavaLangString.equals("其他"))
              {
                paramContext = "";
                break;
              }
              if (paramContext.jdField_a_of_type_Int == 1)
              {
                if (paramContext.jdField_a_of_type_JavaUtilArrayList != null) {
                  break label298;
                }
                paramContext = paramContext.jdField_a_of_type_JavaLangString;
                break;
              }
              paramContext = paramContext.jdField_a_of_type_JavaLangString;
              break;
            }
          }
        }
        if (localStringBuffer.length() > 0) {
          localStringBuffer.delete(localStringBuffer.length() - " | ".length(), localStringBuffer.length());
        }
        return localStringBuffer.toString();
        i1 = 0;
      }
      label298:
      paramContext = "";
    }
  }
  
  public static ArrayList a(Context paramContext, TroopInfoData paramTroopInfoData)
  {
    int i1 = 1;
    int i2 = 0;
    if (paramTroopInfoData == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = Long.toString(paramTroopInfoData.jdField_a_of_type_Long);
    paramContext = GroupCatalogTool.a(paramContext).a(paramContext, (String)localObject);
    if (!TextUtils.isEmpty(paramTroopInfoData.j)) {
      paramContext = paramTroopInfoData.j;
    }
    for (;;)
    {
      localObject = new ArrayList();
      if (!TextUtils.isEmpty(paramContext))
      {
        localStringBuffer.append(paramContext + " | ");
        ((ArrayList)localObject).add(paramContext);
      }
      for (;;)
      {
        if ((paramTroopInfoData.jdField_a_of_type_JavaUtilList != null) && (paramTroopInfoData.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          int i3 = paramTroopInfoData.jdField_a_of_type_JavaUtilList.size();
          for (;;)
          {
            if (i2 < i3)
            {
              if ((i1 == 0) || (!((String)paramTroopInfoData.jdField_a_of_type_JavaUtilList.get(i2)).equals(paramContext)))
              {
                localStringBuffer.append((String)paramTroopInfoData.jdField_a_of_type_JavaUtilList.get(i2) + " | ");
                ((ArrayList)localObject).add(paramTroopInfoData.jdField_a_of_type_JavaUtilList.get(i2));
              }
              i2 += 1;
              continue;
              if ((paramContext == null) || (TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString))) {
                break label327;
              }
              if (paramContext.jdField_a_of_type_JavaLangString.equals("其他"))
              {
                paramContext = "";
                break;
              }
              if (paramContext.jdField_a_of_type_Int == 1)
              {
                if (paramContext.jdField_a_of_type_JavaUtilArrayList != null) {
                  break label327;
                }
                paramContext = paramContext.jdField_a_of_type_JavaLangString;
                break;
              }
              paramContext = paramContext.jdField_a_of_type_JavaLangString;
              break;
            }
          }
        }
        if (localStringBuffer.length() > 0) {
          localStringBuffer.delete(localStringBuffer.length() - " | ".length(), localStringBuffer.length());
        }
        return localObject;
        i1 = 0;
      }
      label327:
      paramContext = "";
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean1, int paramInt4, boolean paramBoolean2)
  {
    Intent localIntent = new Intent(this, EditActivity.class);
    localIntent.putExtra("title", paramInt3);
    localIntent.putExtra("limit", paramInt2);
    localIntent.putExtra("current", paramString);
    localIntent.putExtra("canPostNull", paramBoolean1);
    localIntent.putExtra("multiLine", paramBoolean2);
    localIntent.putExtra("support_emotion", paramInt4);
    startActivityForResult(localIntent, paramInt1);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (paramActivity != null) {}
    try
    {
      Intent localIntent = new Intent(paramActivity, TroopInfoActivity.class);
      localIntent.putExtras(paramBundle);
      paramActivity.startActivityForResult(localIntent, paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, paramActivity.toString());
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, TroopInfoActivity.class);
      localIntent.putExtras(paramBundle);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, paramContext.toString());
    }
  }
  
  private void a(XListView paramXListView)
  {
    if (paramXListView == null) {}
    do
    {
      return;
      this.jdField_c_of_type_AndroidViewView = super.getLayoutInflater().inflate(2130903690, paramXListView, false);
      this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131299327);
      w();
      ((ImageButton)this.jdField_c_of_type_AndroidViewView.findViewById(2131298164)).setOnClickListener(new fhh(this, paramXListView));
      paramXListView.a(this.jdField_c_of_type_AndroidViewView);
    } while ((3 == this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int) || (4 == this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int));
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString)
  {
    i();
    if (!paramBoolean) {
      if (!TextUtils.isEmpty(paramString)) {
        ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "5", "", "");
      }
    }
    for (;;)
    {
      QQToast.a(this, paramString, 1).b(getTitleBarHeight());
      if (paramBoolean) {
        finish();
      }
      return;
      switch ((int)paramLong)
      {
      default: 
        paramString = getString(2131368223);
        break;
      case 1281: 
        paramString = getString(2131364157);
        break;
      case 1282: 
        paramString = getString(2131364158);
        break;
      case 1283: 
        paramString = getString(2131364159);
        break;
        ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "suc_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int), "", "");
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 4))
        {
          paramString = DialogUtil.a(this, 230);
          paramString.setTitle(null);
          long l1 = this.jdField_a_of_type_Long;
          paramLong = l1;
          if (l1 <= 0L) {
            paramLong = 3L;
          }
          paramString.setMessage(getString(2131364169, new Object[] { paramLong + "" }));
          paramString.setPositiveButton(getString(2131364168), new fhd(this, paramString));
          paramString.setPositiveButtonContentDescription(getString(2131364168));
          paramString.show();
          return;
        }
        paramString = getString(2131368222);
      }
    }
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = (FriendManager)this.app.getManager(8);
      if (localObject != null) {
        break label121;
      }
    }
    label121:
    for (Object localObject = null;; localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        if ((paramInt & 0x4) > 0) {
          c(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname);
        }
        if ((paramInt & 0x2) > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt;
          u();
        }
        if ((paramInt & 0x20) > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.fingertroopmemo;
          a(6, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.fingertroopmemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
        }
      }
      return;
    }
  }
  
  private void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "saveTroopInfo| nModifyFlag = " + paramInt);
    }
    if ((paramInt & 0x3F) > 0) {}
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m, paramInt);
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, localException.toString());
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 3)
    {
      localIntent = new Intent();
      localIntent.putExtra("isNeedFinish", true);
      setResult(-1, localIntent);
      finish();
      return;
    }
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f);
    startActivity(localIntent);
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short != 3)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_JavaLangString))
      {
        startActivity(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.s, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_JavaLangString, setLastActivityName()));
        return;
      }
      startActivityForResult(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.s, null, setLastActivityName()), 8);
      return;
    }
    a(2131366967, 1);
  }
  
  private void t()
  {
    Object localObject = this.app.a();
    int i1;
    if (String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p).equals(localObject)) {
      i1 = 0;
    }
    for (;;)
    {
      localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p, i1);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p)) {
        ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.q;
      }
      if (i1 == 21)
      {
        ((ProfileActivity.AllInOne)localObject).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
        ((ProfileActivity.AllInOne)localObject).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString;
      }
      ProfileActivity.b(getActivity(), (ProfileActivity.AllInOne)localObject);
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p))
      {
        if (((FriendManager)this.app.getManager(8)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p))
        {
          i1 = 1;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)
        {
          i1 = 21;
          continue;
        }
      }
      i1 = 19;
    }
  }
  
  private void u()
  {
    new fhf(this).start();
  }
  
  private void v()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateTroopOwnerName");
    }
    new fhg(this).start();
  }
  
  private void w()
  {
    TextView localTextView;
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      localTextView = (TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131299328);
      if (4 == this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int)
      {
        localTextView.setText(2131364177);
        localTextView.setContentDescription(getString(2131364177));
      }
    }
    else
    {
      return;
    }
    localTextView.setText(2131364176);
    localTextView.setContentDescription(getString(2131364176));
  }
  
  private void x()
  {
    startTitleProgress();
    TroopInfoActivityHelper.a(this.app, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString).longValue(), new fhk(this));
  }
  
  protected void a()
  {
    Object localObject = ((FriendsManagerImp)this.app.getManager(8)).a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString));
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((TroopInfo)localObject).mTroopPicList;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
          if (str != null)
          {
            localAvatarInfo.jdField_b_of_type_JavaLangString = str;
            if (localAvatarInfo.jdField_b_of_type_JavaLangString == "-5") {}
            for (localAvatarInfo.jdField_c_of_type_JavaLangString = "SYSTEM_PHOTO";; localAvatarInfo.jdField_c_of_type_JavaLangString = "AVATAR_URL_STR")
            {
              localArrayList.add(localAvatarInfo);
              break;
            }
          }
        }
      }
    }
    if (localArrayList.size() == 0)
    {
      localObject = new AvatarWallAdapter.AvatarInfo();
      ((AvatarWallAdapter.AvatarInfo)localObject).jdField_b_of_type_JavaLangString = "-5";
      ((AvatarWallAdapter.AvatarInfo)localObject).jdField_c_of_type_JavaLangString = "SYSTEM_PHOTO";
      localArrayList.add(localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(localArrayList, 23, 0);
  }
  
  public void a(int paramInt)
  {
    String str = getString(paramInt);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(str);
    localQQCustomDialog.setMessage(null);
    localQQCustomDialog.setPositiveButton(getString(2131368226), new fhl(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButtonContentDescription(getString(2131368226));
    localQQCustomDialog.setNegativeButton(getString(2131368225), new fhm(this));
    localQQCustomDialog.setNegativeButtonContentDescription(getString(2131368225));
    localQQCustomDialog.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
    }
    TextView localTextView2;
    for (;;)
    {
      paramView.setBackgroundResource(2130838103);
      TextView localTextView1 = (TextView)paramView.findViewById(2131297001);
      localTextView2 = (TextView)paramView.findViewById(2131297409);
      paramView.findViewById(2131298739);
      paramView = paramString1;
      if (paramString1 == null) {
        paramView = "";
      }
      localTextView1.setText(paramView);
      if (6 != paramInt1) {
        break label148;
      }
      localTextView2.setEditableFactory(QQTextBuilder.a);
      localTextView2.setMovementMethod(LinkMovementMethod.getInstance());
      if (!TextUtils.isEmpty(paramString2)) {
        break;
      }
      localTextView2.setVisibility(8);
      return;
      paramView.setTag(null);
      paramView.setOnClickListener(null);
    }
    localTextView2.setVisibility(0);
    localTextView2.setText(new QQText(paramString2, 11));
    return;
    label148:
    localTextView2.setText(paramString2);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, String[] paramArrayOfString, boolean paramBoolean, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "initClrTextItemView(), tag = " + paramInt1 + ", info = " + paramArrayOfString + ", bShowArrow = " + paramBoolean);
    }
    TextView localTextView = (TextView)paramView.findViewById(2131297001);
    paramArrayOfString = paramString;
    if (paramString == null) {
      paramArrayOfString = "";
    }
    localTextView.setText(paramArrayOfString);
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
    }
    for (;;)
    {
      paramView.setBackgroundResource(2130838103);
      return;
      paramView.setTag(null);
      paramView.setOnClickListener(null);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, FormSimpleItem paramFormSimpleItem, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramFormSimpleItem.setTag(Integer.valueOf(paramInt1));
      paramFormSimpleItem.setOnClickListener(this);
      paramFormSimpleItem.a(true);
      paramFormSimpleItem.setBgType(paramInt2);
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      paramFormSimpleItem.setLeftText(str);
      paramFormSimpleItem.setLeftTextColor(0);
      paramFormSimpleItem.b().setEditableFactory(QQTextBuilder.a);
      if (paramCharSequence != null) {
        break label96;
      }
    }
    label96:
    for (paramString = "";; paramString = new QQText(paramCharSequence, 3))
    {
      paramFormSimpleItem.setRightText(paramString);
      return;
      paramFormSimpleItem.setTag(null);
      paramFormSimpleItem.setOnClickListener(null);
      paramFormSimpleItem.a(false);
      break;
    }
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      ArrayList localArrayList1 = paramIntent.getStringArrayListExtra("del_list");
      if (localArrayList1 != null)
      {
        ArrayList localArrayList2 = new ArrayList();
        Iterator localIterator = localArrayList1.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          if ((localObject != null) && (AvatarTroopUtil.b((String)localObject)))
          {
            paramInt = Integer.parseInt((String)localObject);
            localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(paramInt);
            if ((localObject != null) && (((AvatarWallAdapter.AvatarInfo)localObject).jdField_b_of_type_JavaLangString != null) && (AvatarTroopUtil.b(((AvatarWallAdapter.AvatarInfo)localObject).jdField_b_of_type_JavaLangString))) {
              localArrayList2.add(Integer.valueOf(Integer.parseInt(((AvatarWallAdapter.AvatarInfo)localObject).jdField_b_of_type_JavaLangString)));
            }
          }
        }
        if (localArrayList2.size() > 0)
        {
          a("Grp_moredata", "del_head", "");
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, 2, localArrayList2);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(localArrayList1);
      }
      paramInt = paramIntent.getIntExtra("default_avator_index", -1);
      if (paramInt != -1)
      {
        if ((paramInt > 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.getCount())) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.c(paramInt);
        }
        QQToast.a(this, getString(2131367510), 1).b(getTitleBarHeight());
      }
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateDefaultItemView(), tag = " + paramInt + ", info = " + paramString + ", bShowArrow = " + paramBoolean);
    }
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ArrayOfAndroidViewView.length)) {}
    for (View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt];; localView = null)
    {
      TextView localTextView;
      if (localView != null)
      {
        localTextView = (TextView)localView.findViewById(2131297409);
        localView.findViewById(2131298739);
        if (paramInt != 6) {
          break label197;
        }
        if (!TextUtils.isEmpty(paramString)) {
          break label162;
        }
        localTextView.setVisibility(8);
        if (!paramString.equals(getString(2131365797))) {
          break label186;
        }
        localTextView.setTextColor(-3355444);
      }
      for (;;)
      {
        if (!paramBoolean) {
          break label206;
        }
        localView.setTag(Integer.valueOf(paramInt));
        localView.setOnClickListener(this);
        return;
        label162:
        localTextView.setVisibility(0);
        localTextView.setText(new QQText(paramString, 11));
        break;
        label186:
        localTextView.setTextColor(-8355712);
        continue;
        label197:
        localTextView.setText(paramString);
      }
      label206:
      localView.setTag(null);
      localView.setOnClickListener(null);
      return;
    }
  }
  
  public void a(int paramInt1, ArrayList paramArrayList, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateClrTextItemView(), tag = " + paramInt1 + ", info = " + paramArrayList + ", bShowArrow = " + paramBoolean1);
    }
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_ArrayOfAndroidViewView.length)) {}
    for (View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1];; localView = null)
    {
      LinearLayout localLinearLayout;
      if (localView != null)
      {
        localLinearLayout = (LinearLayout)localView.findViewById(2131300630);
        localLinearLayout.removeAllViews();
        if (paramArrayList != null) {}
      }
      else
      {
        return;
      }
      int i1 = 0;
      if ((i1 < paramArrayList.size()) && (i1 < 3))
      {
        TextView localTextView = new TextView(this);
        localTextView.setId(2131296442);
        if (paramInt2 == 1) {
          localTextView.setBackgroundResource(2130839499);
        }
        for (;;)
        {
          localTextView.setTextSize(2, 15.0F);
          if (paramBoolean2) {
            localTextView.setMaxWidth(AIOUtils.a(77.0F, getResources()));
          }
          localTextView.setSingleLine();
          localTextView.setTextColor(-1);
          localTextView.setPadding(AIOUtils.a(6.0F, getResources()), AIOUtils.a(2.0F, getResources()), AIOUtils.a(8.0F, getResources()), AIOUtils.a(2.0F, getResources()));
          localTextView.setGravity(17);
          localTextView.setText((CharSequence)paramArrayList.get(i1));
          localTextView.setEllipsize(TextUtils.TruncateAt.END);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
          localLayoutParams.leftMargin = AIOUtils.a(5.0F, getResources());
          localLinearLayout.addView(localTextView, localLayoutParams);
          i1 += 1;
          break;
          if (paramInt2 == 2) {
            localTextView.setBackgroundResource(2130839498);
          } else {
            localTextView.setBackgroundResource(2130839498);
          }
        }
      }
      localView.findViewById(2131298739);
      if (paramBoolean1)
      {
        localView.setTag(Integer.valueOf(paramInt1));
        localView.setOnClickListener(this);
        return;
      }
      localView.setTag(null);
      localView.setOnClickListener(null);
      return;
    }
  }
  
  public void a(String paramString)
  {
    String str = getString(2131368229);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(str);
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setPositiveButton(getString(2131368225), new fhn(this, localQQCustomDialog));
    localQQCustomDialog.setNegativeButton(null, null);
    localQQCustomDialog.show();
  }
  
  public void a(String paramString, CharSequence paramCharSequence)
  {
    paramCharSequence = new ArrayList();
    paramCharSequence.add(paramString);
    a(1, paramCharSequence, true, 1, false);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, paramString3, "", "");
  }
  
  protected boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "checkParams");
    }
    for (;;)
    {
      try
      {
        Object localObject = getIntent().getExtras();
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString = ((Bundle)localObject).getString("troop_uin");
        if (Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString) <= 0L) {
          break label533;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int = ((Bundle)localObject).getInt("troop_info_from");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Int = ((Bundle)localObject).getInt("troop_info_from_ex");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_JavaLangString = ((Bundle)localObject).getString("param_return_addr");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean = ((Bundle)localObject).getBoolean("troop_info_is_member");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Short = ((Bundle)localObject).getShort("troop_info_faceid");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f = ((Bundle)localObject).getString("troop_info_name");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p = ((Bundle)localObject).getString("troop_info_owner");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long = ((Bundle)localObject).getLong("troop_info_classext");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k = ((Bundle)localObject).getString("troop_info_loca");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int = ((Bundle)localObject).getInt("troop_info_lat", 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int = ((Bundle)localObject).getInt("troop_info_lon", 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.v = a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m = ((Bundle)localObject).getString("troop_info_fingermemo");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = ((short)((Bundle)localObject).getByte("troop_info_opt"));
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_JavaLangString = TroopSystemMsgUtil.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.s = TroopSystemMsgUtil.c(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Long = ((Bundle)localObject).getLong("TROOP_INFO_FLAG_EXT");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_JavaUtilList = TroopInfo.getTags(((Bundle)localObject).getString("TROOP_INFO_TAGS_EXT"));
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int = ((Bundle)localObject).getInt("troop_type_ex");
        this.aM = ((Bundle)localObject).getInt("troop_type_ex");
        localObject = (FriendManager)this.app.getManager(8);
        if (localObject != null)
        {
          localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
          if (localObject != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a((TroopInfo)localObject, this.app.a());
            bool1 = true;
          }
        }
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean)
          {
            this.jdField_c_of_type_JavaLangString = "0";
            bool2 = bool1;
            return bool2;
            if (QLog.isColorLevel()) {
              QLog.e("Q.troopinfo", 2, "can't find troop info of :" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
            }
            bool1 = false;
            continue;
          }
          bool2 = bool1;
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Boolean) {
            continue;
          }
          this.jdField_c_of_type_JavaLangString = "1";
          return bool1;
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        boolean bool2;
        boolean bool1 = false;
        continue;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.troopinfo", 2, localException1.toString());
        return bool1;
      }
    }
    label533:
    return false;
  }
  
  protected void b()
  {
    long l1 = System.currentTimeMillis();
    View localView = View.inflate(this, 2130904043, null);
    Object localObject1 = (ListView)localView.findViewById(2131300624);
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add("貂蝉");
    ((ArrayList)localObject2).add("陈圆圆");
    ((ListView)localObject1).setAdapter(new ArrayAdapter(this, 17367046, (List)localObject2));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131297158));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[10];
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    localObject1 = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    a(this.jdField_a_of_type_ComTencentWidgetXListView);
    localObject1 = new XSimpleListAdapter(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject1);
    setContentView(localView);
    localObject2 = getIntent().getExtras().getString("troop_info_title");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = getString(2131366367);
    }
    setTitle((CharSequence)localObject1);
    localObject1 = Utils.a(this);
    int i1 = (SizeMeasure.e(this) - PublicAccountUtil.a(this, 128.0F) - getResources().getDimensionPixelSize(2131493199)) / 4;
    localObject2 = View.inflate(this, 2130903507, null);
    Object localObject3 = (AvatarWallView)((View)localObject2).findViewById(2131296449);
    ((AvatarWallView)localObject3).setColumnWidth(i1);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter = new AvatarWallAdapter(new WeakReference(this), this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidOsHandler, bool, "Grp_moredata");
    ((AvatarWallView)localObject3).setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter);
    ((AvatarWallView)localObject3).setNumColumns(4);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(i1);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a((GridView)localObject3);
    ((LinearLayout)localObject1).addView((View)localObject2);
    localObject2 = View.inflate(this, 2130903509, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131296554));
    ((LinearLayout)localObject1).addView((View)localObject2);
    if (!bool) {
      ((View)localObject2).setVisibility(8);
    }
    this.jdField_b_of_type_AndroidViewView = ((View)localObject2);
    ((LinearLayout)localObject1).addView(Utils.a(this));
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Long & 0x800) != 0L)
    {
      localObject2 = View.inflate(this, 2130904047, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject2;
      ((LinearLayout)localObject1).addView((View)localObject2);
      a(7, 0, (View)localObject2, getString(2131366199), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.t, false);
      ((LinearLayout)localObject1).addView(Utils.a(this));
    }
    localObject2 = View.inflate(this, 2130904047, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[3] = localObject2;
    ((LinearLayout)localObject1).addView((View)localObject2);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) && ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Long & 0x800) == 0L))
    {
      bool = true;
      a(3, 1, (View)localObject2, getString(2131367020), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, bool);
      ((LinearLayout)localObject1).addView(Utils.a(this));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e())
      {
        localObject2 = View.inflate(this, 2130904046, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[1] = localObject2;
        ((LinearLayout)localObject1).addView((View)localObject2);
        a(1, 2, (View)localObject2, getString(2131363425), null, true, 1);
        ((LinearLayout)localObject1).addView(Utils.a(this));
      }
      localObject2 = View.inflate(this, 2130904047, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject2;
      ((LinearLayout)localObject1).addView((View)localObject2);
      a(5, 2, (View)localObject2, getString(2131368048), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
      m();
      ((LinearLayout)localObject1).addView(Utils.a(this));
      localObject2 = View.inflate(this, 2130904047, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject2;
      ((LinearLayout)localObject1).addView((View)localObject2);
      a(4, 2, (View)localObject2, getString(2131366341), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
      ((LinearLayout)localObject1).addView(Utils.a(this));
      localObject2 = View.inflate(this, 2130904046, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject2;
      ((LinearLayout)localObject1).addView((View)localObject2);
      a(8, 3, (View)localObject2, getString(2131366342), null, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e(), 1);
      a(8, a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData), true, 2, true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      localObject1 = View.inflate(this, 2130904056, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      localObject2 = Utils.a(this);
      Utils.a(this, (View)localObject2, true);
      localObject3 = View.inflate(this, 2130904052, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localObject3;
      ((LinearLayout)localObject2).addView((View)localObject3);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m)) {
        break label1149;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m;
      label956:
      a(3, 3, (View)localObject3, getString(2131366186), (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      localObject1 = new LinearLayout.LayoutParams(-1, (int)(60.0F * this.mDensity));
      localObject2 = View.inflate(this, 2130904056, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131296643);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean) {
        break label1173;
      }
      if (!b()) {
        break label1164;
      }
      b(11);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      l();
      this.leftView.setOnClickListener(new fgx(this));
      this.rightViewText.setOnClickListener(new fhi(this));
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "initUI: time = " + (System.currentTimeMillis() - l1));
      }
      return;
      bool = false;
      break;
      label1149:
      localObject1 = getResources().getString(2131365797);
      break label956;
      label1164:
      b(10);
      continue;
      label1173:
      b(12);
    }
  }
  
  public void b(int paramInt)
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300625);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300626);
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 10: 
      localImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setEnabled(true);
      this.rightViewText.setText(2131368218);
      this.rightViewText.setTag(Integer.valueOf(10));
      return;
    case 11: 
      localImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setEnabled(true);
      this.rightViewText.setText(2131368218);
      this.rightViewText.setTag(Integer.valueOf(11));
      return;
    }
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130839092);
    localTextView.setText(2131365761);
    this.jdField_a_of_type_AndroidViewView.setTag(Integer.valueOf(12));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  protected void b(String paramString)
  {
    i();
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    localQQProgressDialog.a(paramString);
    localQQProgressDialog.setCancelable(false);
    localQQProgressDialog.setOnDismissListener(new fgy(this));
    this.jdField_a_of_type_AndroidAppDialog = localQQProgressDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView[9] == null) {
      return this.jdField_d_of_type_Boolean;
    }
    return ((Switch)this.jdField_a_of_type_ArrayOfAndroidViewView[9].findViewById(2131298642)).isChecked();
  }
  
  protected void broadcastRecieve(Intent paramIntent)
  {
    doOnNewIntent(paramIntent);
  }
  
  public void c()
  {
    if (!this.f)
    {
      finish();
      return;
    }
    a(2131368227);
  }
  
  public void c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(getString(2131363427), getString(2131363431));
      b(10);
      return;
    case 0: 
      a(getString(2131363428), getString(2131363432));
      b(10);
      return;
    case 2: 
      a(getString(2131363429), getString(2131363433));
      b(11);
      return;
    }
    a(getString(2131363429), getString(2131363433));
    b(11);
  }
  
  protected void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f = paramString;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) && ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Long & 0x800) == 0L)) {}
    for (boolean bool = true;; bool = false)
    {
      a(3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, bool);
      return;
    }
  }
  
  public void d()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k);
    localIntent.putExtra("lat", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int);
    localIntent.putExtra("lon", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int);
    localIntent.putExtra("name", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f);
    localIntent.putExtra("class", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long);
    localIntent.putExtra("intro", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m);
  }
  
  /* Error */
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 501	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +49 -> 55
    //   9: ldc 57
    //   11: iconst_2
    //   12: new 402	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 403	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 1409
    //   22: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_1
    //   26: invokevirtual 687	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: ldc_w 1411
    //   32: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload_2
    //   36: invokevirtual 687	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: ldc_w 1413
    //   42: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_3
    //   46: invokevirtual 922	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 411	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 505	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: iconst_m1
    //   56: iload_2
    //   57: if_icmpne +67 -> 124
    //   60: iload_1
    //   61: tableswitch	default:+63 -> 124, 5:+202->263, 6:+286->347, 7:+64->125, 8:+403->464, 9:+484->545, 10:+63->124, 11:+318->379, 12:+63->124, 13:+63->124, 14:+592->653, 15:+599->660, 16:+129->190
    //   125: aload_3
    //   126: ifnull -2 -> 124
    //   129: aload_3
    //   130: invokevirtual 1097	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   133: ifnull -9 -> 124
    //   136: aload_3
    //   137: invokevirtual 1097	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   140: astore_3
    //   141: aload_0
    //   142: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   145: aload_3
    //   146: ldc_w 1390
    //   149: invokevirtual 1100	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   152: putfield 345	com/tencent/mobileqq/troopinfo/TroopInfoData:k	Ljava/lang/String;
    //   155: aload_0
    //   156: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   159: aload_3
    //   160: ldc_w 1392
    //   163: iconst_0
    //   164: invokevirtual 1117	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   167: putfield 1119	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_d_of_type_Int	I
    //   170: aload_0
    //   171: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   174: aload_3
    //   175: ldc_w 1394
    //   178: iconst_0
    //   179: invokevirtual 1117	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   182: putfield 1121	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_e_of_type_Int	I
    //   185: aload_0
    //   186: invokevirtual 1290	com/tencent/mobileqq/activity/TroopInfoActivity:m	()V
    //   189: return
    //   190: aload_3
    //   191: ifnull -67 -> 124
    //   194: aload_3
    //   195: invokevirtual 1097	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   198: ifnull -74 -> 124
    //   201: aload_3
    //   202: invokevirtual 1097	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   205: astore_3
    //   206: aload_0
    //   207: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   210: getfield 345	com/tencent/mobileqq/troopinfo/TroopInfoData:k	Ljava/lang/String;
    //   213: aload_3
    //   214: ldc_w 1390
    //   217: invokevirtual 1100	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   220: invokestatic 1416	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   223: ifne +7 -> 230
    //   226: aload_0
    //   227: invokevirtual 1418	com/tencent/mobileqq/activity/TroopInfoActivity:k	()V
    //   230: aload_0
    //   231: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   234: aload_3
    //   235: ldc_w 1420
    //   238: invokevirtual 1100	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   241: putfield 1125	com/tencent/mobileqq/troopinfo/TroopInfoData:v	Ljava/lang/String;
    //   244: aload_0
    //   245: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   248: aload_3
    //   249: ldc_w 1390
    //   252: invokevirtual 1100	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   255: putfield 345	com/tencent/mobileqq/troopinfo/TroopInfoData:k	Ljava/lang/String;
    //   258: aload_0
    //   259: invokevirtual 1290	com/tencent/mobileqq/activity/TroopInfoActivity:m	()V
    //   262: return
    //   263: aload_3
    //   264: ldc_w 1422
    //   267: invokevirtual 1425	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   270: astore_3
    //   271: aload_3
    //   272: aload_0
    //   273: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   276: getfield 350	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   279: invokestatic 1428	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   282: ifne -158 -> 124
    //   285: aload_0
    //   286: invokevirtual 1418	com/tencent/mobileqq/activity/TroopInfoActivity:k	()V
    //   289: aload_0
    //   290: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   293: aload_3
    //   294: putfield 350	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   297: aload_0
    //   298: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   301: getfield 350	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   304: invokestatic 298	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   307: ifne +26 -> 333
    //   310: aload_0
    //   311: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   314: getfield 350	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   317: astore_3
    //   318: aload_0
    //   319: bipush 6
    //   321: aload_3
    //   322: aload_0
    //   323: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   326: invokevirtual 674	com/tencent/mobileqq/troopinfo/TroopInfoData:e	()Z
    //   329: invokevirtual 677	com/tencent/mobileqq/activity/TroopInfoActivity:a	(ILjava/lang/String;Z)V
    //   332: return
    //   333: aload_0
    //   334: invokevirtual 1033	com/tencent/mobileqq/activity/TroopInfoActivity:getResources	()Landroid/content/res/Resources;
    //   337: ldc_w 1002
    //   340: invokevirtual 1331	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   343: astore_3
    //   344: goto -26 -> 318
    //   347: aload_3
    //   348: ldc_w 1422
    //   351: invokevirtual 1425	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   354: astore_3
    //   355: aload_3
    //   356: aload_0
    //   357: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   360: getfield 312	com/tencent/mobileqq/troopinfo/TroopInfoData:f	Ljava/lang/String;
    //   363: invokestatic 1416	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   366: ifne -242 -> 124
    //   369: aload_0
    //   370: invokevirtual 1418	com/tencent/mobileqq/activity/TroopInfoActivity:k	()V
    //   373: aload_0
    //   374: aload_3
    //   375: invokevirtual 666	com/tencent/mobileqq/activity/TroopInfoActivity:c	(Ljava/lang/String;)V
    //   378: return
    //   379: ldc2_w 1429
    //   382: lstore 7
    //   384: aload_3
    //   385: ldc_w 1432
    //   388: invokevirtual 1425	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   391: invokestatic 691	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   394: lstore 5
    //   396: aload_0
    //   397: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   400: getfield 384	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Long	J
    //   403: lload 5
    //   405: lcmp
    //   406: ifeq -282 -> 124
    //   409: lload 5
    //   411: ldc2_w 1429
    //   414: lcmp
    //   415: ifeq -291 -> 124
    //   418: aload_0
    //   419: invokevirtual 1418	com/tencent/mobileqq/activity/TroopInfoActivity:k	()V
    //   422: aload_0
    //   423: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   426: lload 5
    //   428: putfield 384	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Long	J
    //   431: aload_0
    //   432: invokespecial 647	com/tencent/mobileqq/activity/TroopInfoActivity:u	()V
    //   435: return
    //   436: astore_3
    //   437: lload 7
    //   439: lstore 5
    //   441: invokestatic 501	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   444: ifeq -48 -> 396
    //   447: ldc 57
    //   449: iconst_2
    //   450: aload_3
    //   451: invokevirtual 502	java/lang/Exception:toString	()Ljava/lang/String;
    //   454: invokestatic 505	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   457: lload 7
    //   459: lstore 5
    //   461: goto -65 -> 396
    //   464: aload_0
    //   465: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   468: getfield 597	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Int	I
    //   471: iconst_2
    //   472: if_icmpeq +63 -> 535
    //   475: aload_0
    //   476: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   479: getfield 597	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Int	I
    //   482: bipush 6
    //   484: if_icmpeq +51 -> 535
    //   487: aload_0
    //   488: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   491: getfield 597	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Int	I
    //   494: bipush 15
    //   496: if_icmpeq +39 -> 535
    //   499: aload_0
    //   500: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   503: getfield 597	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Int	I
    //   506: bipush 10
    //   508: if_icmpeq +27 -> 535
    //   511: aload_0
    //   512: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   515: getfield 597	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Int	I
    //   518: bipush 11
    //   520: if_icmpeq +15 -> 535
    //   523: aload_0
    //   524: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   527: getfield 597	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Int	I
    //   530: bipush 19
    //   532: if_icmpne -408 -> 124
    //   535: aload_0
    //   536: iconst_m1
    //   537: invokevirtual 1434	com/tencent/mobileqq/activity/TroopInfoActivity:setResult	(I)V
    //   540: aload_0
    //   541: invokevirtual 590	com/tencent/mobileqq/activity/TroopInfoActivity:finish	()V
    //   544: return
    //   545: aload_3
    //   546: ldc_w 1436
    //   549: invokevirtual 1425	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   552: astore 9
    //   554: aload 9
    //   556: ifnull -432 -> 124
    //   559: aload 9
    //   561: invokevirtual 318	java/lang/String:length	()I
    //   564: ifle -440 -> 124
    //   567: new 183	java/util/ArrayList
    //   570: dup
    //   571: invokespecial 184	java/util/ArrayList:<init>	()V
    //   574: astore_3
    //   575: new 1438	org/json/JSONArray
    //   578: dup
    //   579: invokespecial 1439	org/json/JSONArray:<init>	()V
    //   582: pop
    //   583: new 1438	org/json/JSONArray
    //   586: dup
    //   587: aload 9
    //   589: invokespecial 1441	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   592: astore 9
    //   594: iload 4
    //   596: istore_1
    //   597: aload 9
    //   599: invokevirtual 1442	org/json/JSONArray:length	()I
    //   602: istore_2
    //   603: iload_1
    //   604: iload_2
    //   605: if_icmpge +25 -> 630
    //   608: aload_3
    //   609: aload 9
    //   611: iload_1
    //   612: invokevirtual 1443	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   615: invokeinterface 704 2 0
    //   620: pop
    //   621: iload_1
    //   622: iconst_1
    //   623: iadd
    //   624: istore_1
    //   625: goto -28 -> 597
    //   628: astore 9
    //   630: aload_0
    //   631: invokevirtual 1418	com/tencent/mobileqq/activity/TroopInfoActivity:k	()V
    //   634: aload_0
    //   635: getfield 173	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   638: aload_3
    //   639: putfield 416	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   642: aload_0
    //   643: getfield 214	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   646: bipush 6
    //   648: invokevirtual 1449	android/os/Handler:sendEmptyMessage	(I)Z
    //   651: pop
    //   652: return
    //   653: aload_0
    //   654: iload_2
    //   655: aload_3
    //   656: invokevirtual 1451	com/tencent/mobileqq/activity/TroopInfoActivity:a	(ILandroid/content/Intent;)V
    //   659: return
    //   660: getstatic 1454	com/tencent/mobileqq/troop/widget/AvatarWallAdapter:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   663: ifnull -539 -> 124
    //   666: aload_0
    //   667: getstatic 1454	com/tencent/mobileqq/troop/widget/AvatarWallAdapter:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   670: invokestatic 1459	com/tencent/mobileqq/utils/ImageUtil:c	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   673: astore_3
    //   674: aload_0
    //   675: invokestatic 1464	com/tencent/mobileqq/util/ProfileCardUtil:a	(Landroid/app/Activity;)I
    //   678: istore_1
    //   679: new 454	android/content/Intent
    //   682: dup
    //   683: invokespecial 705	android/content/Intent:<init>	()V
    //   686: astore 9
    //   688: aload 9
    //   690: ldc_w 1466
    //   693: bipush 100
    //   695: invokevirtual 465	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   698: pop
    //   699: aload 9
    //   701: aload_0
    //   702: ldc 2
    //   704: invokevirtual 1471	java/lang/Class:getName	()Ljava/lang/String;
    //   707: iload_1
    //   708: iload_1
    //   709: sipush 640
    //   712: sipush 640
    //   715: aload_3
    //   716: invokestatic 1473	com/tencent/mobileqq/util/ProfileCardUtil:b	()Ljava/lang/String;
    //   719: invokestatic 1478	com/tencent/mobileqq/activity/photo/PhotoUtils:a	(Landroid/content/Intent;Landroid/app/Activity;Ljava/lang/String;IIIILjava/lang/String;Ljava/lang/String;)V
    //   722: return
    //   723: astore 10
    //   725: goto -104 -> 621
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	728	0	this	TroopInfoActivity
    //   0	728	1	paramInt1	int
    //   0	728	2	paramInt2	int
    //   0	728	3	paramIntent	Intent
    //   1	594	4	i1	int
    //   394	66	5	l1	long
    //   382	76	7	l2	long
    //   552	58	9	localObject	Object
    //   628	1	9	localJSONException1	org.json.JSONException
    //   686	14	9	localIntent	Intent
    //   723	1	10	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   384	396	436	java/lang/Exception
    //   583	594	628	org/json/JSONException
    //   597	603	628	org/json/JSONException
    //   608	621	723	org/json/JSONException
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {}
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      this.g = getIntent().getExtras().getBoolean("returnMsgList", false);
      if (!a())
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "onCreate, illegal param, troopuin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
        }
        finish();
        return true;
      }
      b();
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      paramBundle = (BizTroopHandler)this.app.a(21);
      if (paramBundle != null) {
        paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onCreate(), time = " + (System.currentTimeMillis() - l1));
      }
      BnrReport.a(this.app, 78);
      ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "edit", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int), "", "");
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_c_of_type_Boolean = true;
    long l1 = 0L;
    if (QLog.isColorLevel()) {
      l1 = System.currentTimeMillis();
    }
    GroupCatalogTool.a(getApplicationContext()).a();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.c();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "onDestroy(), time = " + (System.currentTimeMillis() - l1));
    }
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (paramIntent == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramIntent;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null)
    {
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        str = (String)paramIntent.next();
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b(str);
        a("Grp_moredata", "upload_head", "");
      }
    }
    this.e = true;
    paramIntent = (AccountManager)getAppRuntime().getManager(0);
    String str = TroopUtils.a(this.app);
    if (str == null)
    {
      paramIntent.updateSKey(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    new Thread(new fho(this, str)).start();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.e)
    {
      this.e = false;
      return;
    }
    TroopAvatarManger.jdField_a_of_type_Int = 0;
    a();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "init(), isInitialized = " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.app.a(19));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    new fhq(this).start();
  }
  
  protected void f()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_JavaUtilList;
    Intent localIntent = new Intent(this, TroopTagViewActivity.class);
    localIntent.putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("isAdmin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
    Object localObject1 = Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long);
    Object localObject3 = GroupCatalogTool.a(this).a(this, (String)localObject1);
    localObject1 = "";
    int i1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.j))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.j;
      i1 = 1;
    }
    for (;;)
    {
      if (i1 != 0) {
        localIntent.putExtra("subclass", (String)localObject1);
      }
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject1 = new StringBuffer();
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            ((StringBuffer)localObject1).append((String)localObject3 + "\n");
            continue;
            if ((localObject3 == null) || (TextUtils.isEmpty(((GroupCatalogBean)localObject3).jdField_a_of_type_JavaLangString))) {
              break label333;
            }
            if (((GroupCatalogBean)localObject3).jdField_a_of_type_JavaLangString.equals("其他"))
            {
              i1 = 0;
              break;
            }
            if (((GroupCatalogBean)localObject3).jdField_a_of_type_Int == 1)
            {
              if (((GroupCatalogBean)localObject3).jdField_a_of_type_JavaUtilArrayList != null) {
                break label333;
              }
              localObject1 = ((GroupCatalogBean)localObject3).jdField_a_of_type_JavaLangString;
              i1 = 1;
              break;
            }
            localObject1 = ((GroupCatalogBean)localObject3).jdField_a_of_type_JavaLangString;
            i1 = 1;
            break;
          }
        }
        ((StringBuffer)localObject1).deleteCharAt(((StringBuffer)localObject1).length() - 1);
        localIntent.putExtra("tags", ((StringBuffer)localObject1).toString());
      }
      localIntent.putExtra("act_type", 1);
      localIntent.putExtra("uin", this.app.a());
      localIntent.putExtra("modifyToSrv", 0);
      startActivityForResult(localIntent, 9);
      return;
      label333:
      i1 = 0;
    }
  }
  
  public void finish()
  {
    i();
    d();
    setResult(-1, getIntent());
    if (this.g) {
      n();
    }
    super.finish();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e())
    {
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
      TroopLocationModifyActivity.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k, 16);
    }
  }
  
  public void h()
  {
    if (!this.f)
    {
      finish();
      return;
    }
    ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int), "", "");
    Object localObject2 = (BizTroopHandler)this.app.a(21);
    if ((localObject2 == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null))
    {
      finish();
      return;
    }
    long l4;
    try
    {
      l4 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == -1)
      {
        finish();
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      finish();
      return;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.v;
    int i2 = 0;
    long l2 = 0L;
    Object localObject1 = "";
    long l1;
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      l1 = l2;
    }
    for (int i1 = i2;; i1 = 0)
    {
      try
      {
        localObject3 = ((String)localObject3).split("\\|");
        l1 = l2;
        i1 = i2;
        i2 = Integer.valueOf(localObject3[0]).intValue();
        l1 = l2;
        i1 = i2;
        l2 = (Float.valueOf(localObject3[1]).floatValue() * 1000000.0F);
        l1 = l2;
        i1 = i2;
        l3 = (Float.valueOf(localObject3[2]).floatValue() * 1000000.0F);
        localObject1 = localObject3[3];
        l1 = l3;
        i1 = i2;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        for (;;)
        {
          long l3 = 0L;
          l2 = l1;
          l1 = l3;
          continue;
          i2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int;
          continue;
          label762:
          ((BizTroopHandler)localObject2).a(l4, i2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_JavaUtilList, i1, l2, l1, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m);
        }
        ((StringBuffer)localObject1).deleteCharAt(((StringBuffer)localObject1).length() - 1);
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTags = ((StringBuffer)localObject1).toString();
        return;
      }
      b(getString(2131368221));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 2)
      {
        i2 = 3;
        if (i2 == -1) {
          break;
        }
        if (((this.aM == 0) || (1 == this.aM)) && (i2 == 3)) {
          ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "set_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "");
        }
        if (((this.aM == 2) || (this.aM == 3) || (this.aM == 4)) && ((i2 == 0) || (1 == i2))) {
          ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "un_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "");
        }
        if (((2 != this.aM) && (4 != this.aM)) || ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int != 4))) {
          break label762;
        }
        if ((0L != l2) || (0L != l1)) {
          break label833;
        }
        l2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int;
        l1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k;
      }
      label833:
      for (;;)
      {
        ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "local_sub", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "");
        TroopInfoActivityHelper.a(this.app, l4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, i1, l2, l1, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m, new fhr(this));
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mRichFingerMemo = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopLat = ((int)l2);
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopLon = ((int)l1);
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.strLocation = ((String)localObject1);
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break;
        }
        localObject1 = new StringBuffer();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          ((StringBuffer)localObject1).append((String)localObject3 + "\n");
        }
      }
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void j()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131363426);
    this.jdField_a_of_type_ArrayOfJavaLangString = getResources().getStringArray(2131230744);
    localActionSheet.d(this.jdField_a_of_type_ArrayOfJavaLangString[3]);
    int i1 = -1;
    int i2;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 1)
    {
      i1 = 0;
      i2 = 0;
      label60:
      if (i2 >= 3) {
        break label144;
      }
      if (i1 != i2) {
        break label165;
      }
    }
    label144:
    label165:
    for (boolean bool = true;; bool = false)
    {
      localActionSheet.a(this.jdField_a_of_type_ArrayOfJavaLangString[i2], bool);
      i2 += 1;
      break label60;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 0)
      {
        i1 = 1;
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int != 3) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int != 4)) {
        break;
      }
      i1 = 2;
      break;
      localActionSheet.a(new fgz(this, localActionSheet));
      localActionSheet.show();
      return;
    }
  }
  
  public void k()
  {
    this.f = true;
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 1) {
      c(1);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 0)
      {
        c(0);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 2)
      {
        c(2);
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int != 3) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int != 4));
    c(3);
  }
  
  public void m()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int != 0)) {
      a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k, true);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e())
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k))
        {
          a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k, true);
          return;
        }
        a(5, "", true);
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k))
      {
        a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k, false);
        return;
      }
    } while (this.jdField_a_of_type_ArrayOfAndroidViewView[5] == null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[5].setVisibility(8);
  }
  
  public void n()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("tab_index", 1);
    startActivity(localIntent);
  }
  
  public void o()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(bool);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a();
    }
  }
  
  public void onBackPressed()
  {
    c();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = paramCompoundButton.getTag();
    if (!(paramCompoundButton instanceof Integer)) {
      return;
    }
    switch (((Integer)paramCompoundButton).intValue())
    {
    default: 
      return;
    }
    if (paramBoolean)
    {
      b(11);
      return;
    }
    b(10);
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof Integer)) {}
    switch (((Integer)paramView).intValue())
    {
    case 7: 
    case 9: 
    case 10: 
    case 11: 
    default: 
    case 3: 
    case 1: 
    case 4: 
    case 8: 
    case 5: 
    case 6: 
    case 12: 
      do
      {
        do
        {
          return;
          a(6, 30, 2131367020, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, false, 0, false);
          return;
          j();
          return;
          paramView = new Intent(getActivity(), TroopClassChoiceActivity.class);
          paramView.putExtra("troopGroupClassExt", Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long));
          startActivityForResult(paramView, 11);
          return;
          f();
          return;
          g();
          return;
          a(5, 900, 2131366186, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m, true, 1, true);
          a("Grp_moredata", "Clk_brief", "");
          return;
          if (!NetworkUtil.e(this))
          {
            a(2131365941, 0);
            return;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler == null);
        try
        {
          long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
          p();
          this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l1, 8388736);
          return;
        }
        catch (Exception paramView) {}
      } while (!QLog.isColorLevel());
      QLog.i("Q.troopinfo", 2, paramView.toString());
      return;
    }
    t();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void p()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131367583);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, localException.toString());
    }
  }
  
  public void q()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity
 * JD-Core Version:    0.7.0.1
 */