package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.managers.DiscussionMemberManager;
import com.tencent.mobileqq.managers.DiscussionMemberManager.CacheData;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import cooperation.qzone.QZoneShareManager;
import dvc;
import dvd;
import dve;
import dvf;
import dvg;
import dvh;
import dvi;
import dvk;
import dvl;
import dvm;
import dvn;
import dvo;
import dvq;
import dvr;
import dvt;
import dvu;
import dvv;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.TicketManager;

public class DiscussionInfoCardActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final int A = 0;
  private static final int B = 18;
  private static final int C = -1;
  private static final int D = -1;
  private static final int E = 0;
  private static final int F = 1;
  static final String jdField_a_of_type_JavaLangString = "memberUin";
  public static final int b = 1000;
  static final String jdField_b_of_type_JavaLangString = "memberName";
  public static int c = 0;
  static final String jdField_c_of_type_JavaLangString = "faceId";
  public static int d = 0;
  static final String jdField_d_of_type_JavaLangString = "pinyin";
  public static int e = 0;
  public static final String e = "D2GType";
  public static final int f = 1;
  public static final String f = "0";
  public static final int g = 2;
  public static final String g = "1";
  public static final String h = "2";
  public static final String i = "3";
  private static final String j;
  private static final int y = 16;
  private static final int z = 17;
  private int G = -1;
  private int H = -1;
  private final int I = 8;
  private float jdField_a_of_type_Float;
  protected final int a;
  private long jdField_a_of_type_Long;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  protected ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new dvh(this);
  private CardHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new dvt(this);
  private DiscussionHandler jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new dvr(this);
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dvq(this);
  public DiscussionInfo a;
  private DiscussionMemberManager jdField_a_of_type_ComTencentMobileqqManagersDiscussionMemberManager;
  protected FormSimpleItem a;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private IconPopupWindow jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
  private MyGridView jdField_a_of_type_ComTencentMobileqqWidgetMyGridView;
  public QQProgressDialog a;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  private dvv jdField_a_of_type_Dvv;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSimpleItem e;
  private FormSimpleItem f;
  private FormSimpleItem g;
  protected final int h;
  private FormSimpleItem h;
  protected final int i;
  private FormSimpleItem i;
  protected final int j;
  protected int k;
  private String k;
  private int jdField_l_of_type_Int;
  private String jdField_l_of_type_JavaLangString;
  private int jdField_m_of_type_Int;
  private String jdField_m_of_type_JavaLangString;
  private int jdField_n_of_type_Int = 0;
  private String jdField_n_of_type_JavaLangString;
  private int jdField_o_of_type_Int;
  private String jdField_o_of_type_JavaLangString;
  private int jdField_p_of_type_Int;
  private String jdField_p_of_type_JavaLangString;
  private int jdField_q_of_type_Int;
  private String jdField_q_of_type_JavaLangString;
  private int r;
  private final int s = 0;
  private final int t = 1;
  private final int u = 2;
  private final int v = 3;
  private final int w = 8;
  private final int x = 9;
  
  static
  {
    jdField_j_of_type_JavaLangString = DiscussionInfoCardActivity.class.getSimpleName();
    jdField_c_of_type_Int = 0;
    jdField_d_of_type_Int = 0;
    jdField_e_of_type_Int = 0;
  }
  
  public DiscussionInfoCardActivity()
  {
    this.m = 0;
    this.o = 0;
    this.p = 0;
    this.q = 4;
    this.jdField_a_of_type_Int = 10;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 1;
    this.jdField_j_of_type_Int = 2;
    this.jdField_a_of_type_AndroidOsHandler = new dvo(this);
  }
  
  private Bitmap a()
  {
    Bitmap localBitmap2 = FaceDrawable.a(this.app, 101, this.jdField_l_of_type_JavaLangString).a();
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = ImageUtil.e();
    }
    return TroopShareUtility.a(localBitmap1);
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str1;
    if ((paramString == null) || (paramInt <= 0)) {
      str1 = "";
    }
    for (;;)
    {
      return str1;
      try
      {
        byte[] arrayOfByte = paramString.getBytes("utf-8");
        str1 = paramString;
        if (paramInt >= arrayOfByte.length) {
          continue;
        }
        str1 = new String(arrayOfByte, paramInt - 1, 3, "utf-8");
        String str2 = new String(arrayOfByte, paramInt - 2, 3, "utf-8");
        int i1;
        if ((str1.length() == 1) && (paramString.contains(str1))) {
          i1 = paramInt - 1;
        }
        for (;;)
        {
          return new String(arrayOfByte, 0, i1, "utf-8");
          i1 = paramInt;
          if (str2.length() == 1)
          {
            boolean bool = paramString.contains(str2);
            i1 = paramInt;
            if (bool) {
              i1 = paramInt - 2;
            }
          }
        }
        return paramString;
      }
      catch (Exception localException) {}
    }
  }
  
  @SuppressLint({"NewApi"})
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "discuss", "copy_link", 0, 0, "", "", "", "");
    paramQQAppInterface = BaseApplicationImpl.getContext();
    jdField_d_of_type_Int += 1;
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramLong > 0L))
    {
      paramString1 = "点击链接加入讨论组\"" + paramString2 + "\":\n" + paramString1;
      if (Build.VERSION.SDK_INT < 11) {
        ((android.text.ClipboardManager)paramQQAppInterface.getSystemService("clipboard")).setText(paramString1);
      }
      for (;;)
      {
        QQToast.a(paramQQAppInterface, 2, "已复制讨论组链接", 0).b(paramQQAppInterface.getResources().getDimensionPixelSize(2131492923));
        return;
        ((android.content.ClipboardManager)paramQQAppInterface.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("discussion_url", paramString1));
      }
    }
    QQToast.a(paramQQAppInterface, 2, "复制讨论组链接失败", 0).b(paramQQAppInterface.getResources().getDimensionPixelSize(2131492923));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, String paramString3, long paramLong, QQProgressDialog paramQQProgressDialog)
  {
    jdField_e_of_type_Int += 1;
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramQQProgressDialog != null)) {}
    try
    {
      paramQQProgressDialog.show();
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, "2", "", "", "");
      String str = ((TicketManager)paramQQAppInterface.getManager(2)).getSkey(paramQQAppInterface.getAccount());
      if (!TextUtils.isEmpty(str))
      {
        new Thread(new dvi(paramLong, paramQQAppInterface, paramString2, str, paramString3, paramString1, paramActivity, paramInt, paramQQProgressDialog)).start();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_j_of_type_JavaLangString, 2, localException.toString());
        }
      }
      if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
        paramQQProgressDialog.dismiss();
      }
      QQToast.a(paramActivity, -1, "拉取讨论组连接失败，请重试！", 0).b(paramActivity.getResources().getDimensionPixelSize(2131492923));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, "3", "", "", "");
    paramString3 = String.format(paramContext.getString(2131368375), new Object[] { paramString3 });
    paramString2 = QRUtils.a(paramContext, "temp_discuss_link_share_" + paramString2 + ".png", TroopShareUtility.a(paramString1, paramContext.getResources()));
    if (TextUtils.isEmpty(paramString2)) {
      QQToast.a(paramContext, 1, 2131363590, 0).b(paramContext.getResources().getDimensionPixelSize(2131492923));
    }
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(paramString2)) {
        localArrayList.add(paramString2);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("title", paramString3);
      localBundle.putString("desc", "");
      localBundle.putLong("req_share_id", 0L);
      localBundle.putString("detail_url", paramString1);
      localBundle.putStringArrayList("image_url", localArrayList);
      QZoneShareManager.a(paramQQAppInterface, paramContext, localBundle, null);
    } while (!QLog.isColorLevel());
    QLog.i(jdField_j_of_type_JavaLangString, 2, "shareToQzone.title:" + paramString3 + " filePath:" + paramString2 + " shareLink:" + paramString1 + " desc:" + "");
  }
  
  private void a(MyGridView paramMyGridView)
  {
    int i2 = SizeMeasure.e(this);
    float f1 = getResources().getDisplayMetrics().density;
    int i3 = (int)(32.0F * f1);
    int i1 = (int)(32.0F * f1);
    int i4 = (int)(66.0F * f1);
    int i5 = (int)(50.0F * f1);
    i1 = (i2 - i3) / (i1 + i5);
    i2 = (i2 - i3 - i1 * i4 - (i4 - i5)) / (i1 + 1) + (i4 - i5) / 2;
    i3 = (int)(f1 * 20.0F);
    this.m = i2;
    this.jdField_n_of_type_Int = i2;
    this.o = i3;
    this.p = i3;
    this.q = i1;
    paramMyGridView.setPadding(this.m, this.o, this.jdField_n_of_type_Int, this.p);
  }
  
  private void a(HashMap paramHashMap)
  {
    int i1 = 1;
    String str2;
    String str1;
    if ((paramHashMap != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      str2 = (String)paramHashMap.get("memberName");
      str1 = "";
      if (str2 != null) {
        str1 = ChnToSpell.a(str2, 1);
      }
      paramHashMap.put("pinyin", str1);
      if (TextUtils.isEmpty(str1)) {
        this.jdField_a_of_type_JavaUtilList.add(paramHashMap);
      }
    }
    else
    {
      return;
    }
    do
    {
      i1 += 1;
      if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      str2 = (String)((HashMap)this.jdField_a_of_type_JavaUtilList.get(i1)).get("pinyin");
    } while ((!TextUtils.isEmpty(str2)) && (str2.compareTo(str1) <= 0));
    this.jdField_a_of_type_JavaUtilList.add(i1, paramHashMap);
    return;
    this.jdField_a_of_type_JavaUtilList.add(paramHashMap);
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqManagersDiscussionMemberManager != null)
    {
      DiscussionMemberManager.CacheData localCacheData = this.jdField_a_of_type_ComTencentMobileqqManagersDiscussionMemberManager.a(this.jdField_l_of_type_JavaLangString);
      bool1 = bool2;
      if (localCacheData != null)
      {
        bool1 = bool2;
        if (localCacheData.jdField_a_of_type_JavaUtilList != null)
        {
          bool1 = bool2;
          if (localCacheData.jdField_a_of_type_JavaUtilList.size() > 8)
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilArrayList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(localCacheData.jdField_a_of_type_JavaUtilList);
            this.jdField_a_of_type_JavaUtilArrayList.addAll(localCacheData.jdField_a_of_type_JavaUtilArrayList);
            this.r = this.jdField_a_of_type_JavaUtilList.size();
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void b(String paramString)
  {
    try
    {
      new Thread(new dvl(this, paramString)).start();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void c()
  {
    jdField_c_of_type_Int = 0;
    jdField_d_of_type_Int = 0;
    jdField_e_of_type_Int = 0;
  }
  
  private void j()
  {
    QQToast.a(this, getString(2131365941), 0).b(getTitleBarHeight());
  }
  
  private void k()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
    if (this.jdField_k_of_type_JavaLangString == null) {
      this.jdField_k_of_type_JavaLangString = this.jdField_l_of_type_JavaLangString;
    }
    this.jdField_l_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin");
    this.jdField_l_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((FriendsManagerImp)this.app.getManager(8)).a(this.jdField_l_of_type_JavaLangString);
    l();
  }
  
  private void l()
  {
    Object localObject1 = (XListView)View.inflate(this, 2130903353, null);
    ((XListView)localObject1).setDivider(null);
    ((XListView)localObject1).setVerticalScrollBarEnabled(false);
    ((XListView)localObject1).setPadding(0, 0, 0, 0);
    Object localObject2 = View.inflate(this, 2130903154, null);
    ((XListView)localObject1).setAdapter(new XSimpleListAdapter((View)localObject2));
    setContentView((View)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)((View)localObject2).findViewById(2131297126));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)((View)localObject2).findViewById(2131297114));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)((View)localObject2).findViewById(2131297113));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)((View)localObject2).findViewById(2131297119));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)((View)localObject2).findViewById(2131297118));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)((View)localObject2).findViewById(2131297117));
    this.f = ((FormSimpleItem)((View)localObject2).findViewById(2131297121));
    this.g = ((FormSimpleItem)((View)localObject2).findViewById(2131297122));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)((View)localObject2).findViewById(2131297124));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131297125));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject2).findViewById(2131297128));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)((View)localObject2).findViewById(2131297127));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)((View)localObject2).findViewById(2131297116));
    this.jdField_a_of_type_AndroidViewView = ((View)localObject2).findViewById(2131297115);
    this.jdField_i_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)((View)localObject2).findViewById(2131297120));
    i();
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = ((View)localObject2).findViewById(2131297123);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(false);
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new dvc(this));
    this.jdField_i_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    setTitle(2131367787);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_k_of_type_JavaLangString);
    localObject1 = ((FriendManager)this.app.getManager(8)).a(this.jdField_l_of_type_JavaLangString);
    if (localObject1 == null)
    {
      a(1, getString(2131366379));
      finish();
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.parseLong(this.jdField_l_of_type_JavaLangString));
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(jdField_j_of_type_JavaLangString, 2, "initDiscussionView getDiscussInfo error disUin=" + this.jdField_l_of_type_JavaLangString, localException);
        return;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 4, "DiscussionInfo.DiscussionFlag:" + localException.DiscussionFlag);
    }
    w();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(localException.hasCollect);
    localObject2 = getString(2131367848);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription((CharSequence)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new dvk(this, localException));
    this.jdField_a_of_type_ComTencentMobileqqManagersDiscussionMemberManager = ((DiscussionMemberManager)this.app.getManager(29));
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.valueOf(this.jdField_l_of_type_JavaLangString).longValue());
    if ((localException != null) && (localException.ownerUin != null) && (this.app != null) && (this.app.a() != null) && (localException.ownerUin.equals(this.app.a())))
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      a();
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("编辑讨论组名称");
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367801));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("删除讨论组成员");
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363748));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363533));
      this.f.setContentDescription(getString(2131366331));
      this.g.setContentDescription(getString(2131366332));
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367772));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131367848));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131367852));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131367783));
      b(this.jdField_l_of_type_JavaLangString);
      return;
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void m()
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
  
  private void n() {}
  
  private void o()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X80040F4", "0X80040F4", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidContentIntent = new Intent(this, EditActivity.class);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("title", 2131366624);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("limit", 48);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("current", this.jdField_k_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("canPostNull", false);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("multiLine", false);
    startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 0);
  }
  
  private void p()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "2", "", "", "");
    Intent localIntent = new Intent(this, ChatHistory.class);
    localIntent.putExtra("uin", this.jdField_l_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_l_of_type_Int);
    startActivityForResult(localIntent, 1000);
  }
  
  private void q()
  {
    FileManagerReporter.a("0X8004E02");
    Intent localIntent = new Intent(this, FMActivity.class);
    localIntent.putExtra("tab_tab_type", 0);
    localIntent.putExtra("uin", this.jdField_l_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_l_of_type_Int);
    startActivity(localIntent);
  }
  
  private void r()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
    Intent localIntent = new Intent();
    localIntent.putExtra("friendUin", this.jdField_l_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_l_of_type_Int);
    localIntent.putExtra("bg_replace_entrance", 62);
    PhotoUtils.a(this, localIntent);
  }
  
  private void s()
  {
    ReportController.b(this.app, "CliOper", "", "", "discuss", "dis_mng_mber", 0, 0, "", "", "", "");
    Intent localIntent = TroopMemberListActivity.a(this, this.jdField_l_of_type_JavaLangString, 1);
    localIntent.putExtra("param_is_pop_up_style", true);
    startActivityForResult(localIntent, 9);
  }
  
  private void t()
  {
    Object localObject2 = this.jdField_k_of_type_JavaLangString;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = getString(2131366631);
    }
    localObject2 = DialogUtil.a(this, 230);
    ((QQCustomDialog)localObject2).setTitle(getString(2131367783));
    ((QQCustomDialog)localObject2).setMessage(String.format(getString(2131367784), new Object[] { localObject1 }));
    ((QQCustomDialog)localObject2).setPositiveButton(2131367855, new dvd(this));
    ((QQCustomDialog)localObject2).setNegativeButton(2131366375, new dve(this));
    ((QQCustomDialog)localObject2).show();
  }
  
  private void u()
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", this.jdField_l_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_k_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_l_of_type_Int);
    localIntent.putExtra("isNeedUpdate", this.jdField_a_of_type_Boolean);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
  }
  
  private void v()
  {
    if ((this.r >= 8) && (this.jdField_a_of_type_ComTencentMobileqqManagersDiscussionMemberManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqManagersDiscussionMemberManager.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_l_of_type_JavaLangString);
    }
  }
  
  private void w()
  {
    Object localObject = (FriendsManagerImp)this.app.getManager(8);
    if (localObject != null)
    {
      localObject = ((FriendsManagerImp)localObject).a(this.jdField_l_of_type_JavaLangString, this.app.a());
      if (localObject == null) {
        break label123;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 4, "DiscussionMemberInfo.flag:" + ((DiscussionMemberInfo)localObject).flag);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(3);
        localFormSwitchItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if ((((DiscussionMemberInfo)localObject).flag & 0x1) != 0) {
          break label118;
        }
        bool = true;
        localFormSwitchItem.setChecked(bool);
      }
    }
    label118:
    label123:
    while (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) {
      for (;;)
      {
        FormSwitchItem localFormSwitchItem;
        return;
        boolean bool = false;
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(0);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) {
      this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName;
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!isResume()) {
      return;
    }
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2130904387);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131366988));
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ChnToSpell.a(this);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        HashMap localHashMap = (HashMap)localIterator.next();
        if ((localHashMap != null) && (TextUtils.isEmpty((String)localHashMap.get("pinyin"))))
        {
          String str2 = (String)localHashMap.get("memberName");
          String str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = (String)localHashMap.get("memberUin");
          }
          if (!TextUtils.isEmpty(str1)) {
            localHashMap.put("pinyin", ChnToSpell.a(str1, 1));
          }
        }
      }
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        a((HashMap)paramArrayList.get(i1));
        i1 += 1;
      }
      this.r = this.jdField_a_of_type_JavaUtilList.size();
    }
  }
  
  public void a(List paramList)
  {
    ChnToSpell.a(this);
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      FriendManager localFriendManager = (FriendManager)this.app.getManager(8);
      Object localObject1 = new DiscussionMemberInfo();
      int i1 = 0;
      DiscussionMemberInfo localDiscussionMemberInfo;
      label117:
      Object localObject2;
      if (i1 < paramList.size())
      {
        localDiscussionMemberInfo = (DiscussionMemberInfo)paramList.get(i1);
        if (localDiscussionMemberInfo != null)
        {
          if (!localDiscussionMemberInfo.memberUin.equals(this.app.a())) {
            break label117;
          }
          ((DiscussionMemberInfo)localObject1).memberUin = localDiscussionMemberInfo.memberUin;
          ((DiscussionMemberInfo)localObject1).memberName = ContactUtils.a(this.app, localDiscussionMemberInfo);
        }
        for (;;)
        {
          i1 += 1;
          break;
          localObject2 = new DiscussionMemberInfo();
          ((DiscussionMemberInfo)localObject2).memberUin = localDiscussionMemberInfo.memberUin;
          ((DiscussionMemberInfo)localObject2).memberName = ContactUtils.a(localDiscussionMemberInfo, this.app);
          ((DiscussionMemberInfo)localObject2).discussionUin = ChnToSpell.a(((DiscussionMemberInfo)localObject2).memberName, 1);
          localArrayList.add(localObject2);
        }
      }
      Collections.sort(localArrayList, new dvu(this));
      localArrayList.add(0, localObject1);
      paramList = new ArrayList();
      localObject1 = new ArrayList();
      i1 = 0;
      while (i1 < localArrayList.size())
      {
        localDiscussionMemberInfo = (DiscussionMemberInfo)localArrayList.get(i1);
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("memberUin", localDiscussionMemberInfo.memberUin);
        ((HashMap)localObject2).put("memberName", localDiscussionMemberInfo.memberName);
        if (i1 > 0) {
          ((HashMap)localObject2).put("pinyin", localDiscussionMemberInfo.discussionUin);
        }
        Friends localFriends = localFriendManager.c(localDiscussionMemberInfo.memberUin);
        if (localFriends != null) {
          ((HashMap)localObject2).put("faceId", Short.valueOf(localFriends.faceid));
        }
        paramList.add(localObject2);
        ((ArrayList)localObject1).add(localDiscussionMemberInfo.memberUin);
        i1 += 1;
      }
      if (paramList.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
        paramList.clear();
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        }
      }
    }
  }
  
  protected void b()
  {
    ReportController.b(this.app, "CliOper", "", this.jdField_l_of_type_JavaLangString, "discuss", "discuss_QR", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidContentIntent = new Intent(getActivity(), QRDisplayActivity.class);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("title", getString(2131363585));
    this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.jdField_l_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("nick", this.jdField_k_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("type", 5);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("discussion_shorturl", this.jdField_n_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.jdField_l_of_type_JavaLangString, true);
    if ((localObject instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)localObject).getBitmap();
      this.jdField_a_of_type_AndroidContentIntent.putExtra("face", (Parcelable)localObject);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 10);
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null) {
      return;
    }
    switch (this.jdField_k_of_type_Int)
    {
    default: 
      return;
    case 0: 
      e();
      return;
    case 1: 
      ReportController.b(this.app, "P_CliOper", "Grp_discuss", "", "discuss_set", "Clk_grptab", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode), "", "", "");
      ChatSettingForTroop.a(this, TroopInfoActivity.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode), 16), 2);
      return;
    }
    Bundle localBundle = TroopInfoActivity.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode), 16);
    localBundle.putInt("D2GType", 1);
    ChatSettingForTroop.a(this, localBundle, 2);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DiscussionInfoCardActivity", 2, "requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
    }
    if (-1 == paramInt2) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (this.jdField_a_of_type_Dvv == null);
          this.jdField_a_of_type_Dvv.notifyDataSetChanged();
          return;
          u();
          finish();
          return;
          setResult(-1);
          this.jdField_a_of_type_Boolean = true;
          return;
          addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
          return;
          localObject = "";
          if (paramIntent != null) {
            localObject = paramIntent.getStringExtra("result");
          }
        } while ((localObject == null) || (((String)localObject).equals("")) || (((String)localObject).equals(this.jdField_k_of_type_JavaLangString)));
        if (NetworkUtil.e(this))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.valueOf(this.jdField_l_of_type_JavaLangString).longValue(), (String)localObject);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
          a(getString(2131367790));
          this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          return;
        }
        a(1, getString(2131367136));
        return;
        switch (paramIntent.getIntExtra("param_subtype", -1))
        {
        default: 
          return;
        case 0: 
          ReportController.b(this.app, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
        }
        Object localObject = new Intent(this, ChatActivity.class);
        paramIntent = paramIntent.getStringExtra("roomId");
        ((Intent)localObject).putExtra("uin", paramIntent);
        ((Intent)localObject).putExtra("uintype", 3000);
        ((Intent)localObject).putExtra("uinname", ContactUtils.a(this.app, getApplicationContext(), paramIntent));
        ((Intent)localObject).putExtra("isBack2Root", true);
        ((Intent)localObject).setFlags(67108864);
        getActivity().startActivity((Intent)localObject);
        finish();
        return;
      } while ((paramInt2 != 0) || (3 != paramInt1));
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("finchat", false))) {
        finish();
      }
    } while (this.jdField_a_of_type_Dvv == null);
    this.jdField_a_of_type_Dvv.notifyDataSetChanged();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.a(6));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.app.a(DiscussionInfoCardActivity.class, this.jdField_a_of_type_AndroidOsHandler);
    k();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_l_of_type_Int == 1) {
      GroupCatalogTool.a(this).a();
    }
    try
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing()))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.b();
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
      }
      v();
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      this.app.a(DiscussionInfoCardActivity.class);
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
  
  protected void doOnPause()
  {
    m();
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Dvv != null) {
      this.jdField_a_of_type_Dvv.notifyDataSetChanged();
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (ChatBackground.a(this, this.app.getAccount(), this.jdField_l_of_type_JavaLangString)) {}
    for (int i1 = 2131370020;; i1 = 2131370018)
    {
      localTextView.setText(i1);
      if ((this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && (!ChatBackground.a(this, this.app.getAccount(), false))) {
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.b();
      }
      return;
    }
  }
  
  protected void e()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(getString(2131368992));
    localQQCustomDialog.setMessage(getString(2131367861));
    localQQCustomDialog.setPositiveButton(2131367860, new dvf(this));
    localQQCustomDialog.setNegativeButton(2131366375, new dvg(this));
    localQQCustomDialog.show();
  }
  
  public void f()
  {
    try
    {
      int i1 = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin).intValue();
      BizTroopHandler localBizTroopHandler = (BizTroopHandler)this.app.a(21);
      if (localBizTroopHandler == null) {
        return;
      }
      try
      {
        long l1 = Long.parseLong(this.app.a());
        localBizTroopHandler.a(0L, 1, l1, 2, a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName, 30), "", 10010, i1, 1, 0L, 0L, 0, "", null, 3, false);
        g();
        return;
      }
      catch (NumberFormatException localNumberFormatException1) {}
      return;
    }
    catch (NumberFormatException localNumberFormatException2) {}
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131368032);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void i()
  {
    int i1 = 2131368992;
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null)
    {
      this.jdField_i_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      return;
    }
    this.jdField_i_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode == 0L) || (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupUin == 0L))
    {
      this.jdField_k_of_type_Int = 0;
      this.jdField_i_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131368992));
    }
    for (;;)
    {
      this.jdField_i_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getResources().getString(i1));
      return;
      FriendManager localFriendManager = (FriendManager)this.app.getManager(8);
      if (localFriendManager == null)
      {
        this.jdField_i_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        return;
      }
      if (localFriendManager.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode)) != null)
      {
        this.jdField_k_of_type_Int = 1;
        this.jdField_i_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131368994));
        i1 = 2131368994;
      }
      else
      {
        this.jdField_k_of_type_Int = 2;
        this.jdField_i_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131368995));
        i1 = 2131368995;
      }
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    this.G = -1;
    this.H = -1;
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long < 1000L) {
      return;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    switch (paramView.getId())
    {
    case 2131297114: 
    case 2131297115: 
    case 2131297117: 
    case 2131297124: 
    case 2131297125: 
    case 2131297126: 
    case 2131297127: 
    default: 
      return;
    case 2131297113: 
      o();
      return;
    case 2131297119: 
      n();
      return;
    case 2131297118: 
      b();
      return;
    case 2131297121: 
      p();
      return;
    case 2131297122: 
      q();
      return;
    case 2131297123: 
      ReportController.b(null, "CliOper", "", "", "0X8006279", "0X8006279", 0, 0, "2", "", "", "");
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.c();
      ChatBackground.a(this, this.app.getAccount(), false);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = new IconPopupWindow(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131370018, new dvm(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131370019, new dvn(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(), 0, 12, 12);
      return;
    case 2131297128: 
      t();
      return;
    case 2131297120: 
      d();
      return;
    }
    s();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (3000 == this.jdField_l_of_type_Int)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView);
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
    }
    super.onConfigurationChanged(paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity
 * JD-Core Version:    0.7.0.1
 */