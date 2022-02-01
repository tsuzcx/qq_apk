package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import cmi;
import cmj;
import cmk;
import cml;
import cmm;
import cmn;
import cmp;
import cmq;
import cmr;
import cms;
import cmt;
import cmu;
import cmw;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.qrcode.CodeMaskManager;
import com.tencent.biz.qrcode.CodeMaskManager.Callback;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.ForwardHandlerActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class QRDisplayActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, CodeMaskManager.Callback
{
  protected static final int a = 60000;
  public static final String a;
  protected static final int b = 1;
  public static final String b = "qrcode";
  protected static final int c = 2;
  public static final String c = "user";
  public static final String d = "group";
  public static final String e = "discussion";
  protected static final int h = -160;
  protected static final int i = -161;
  protected static final String k = "memberUin";
  protected long a;
  public Bitmap a;
  public Bundle a;
  protected Handler a;
  protected View.OnClickListener a;
  protected View a;
  public ImageView a;
  public BitMatrix a;
  protected CodeMaskManager a;
  QRDisplayActivity.GetNicknameObserver jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$GetNicknameObserver = new cmi(this);
  public DiscussionHandler a;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new cmm(this);
  IconPopupWindow jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public Runnable a;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  public long b;
  public Bitmap b;
  public View b;
  public IconPopupWindow b;
  public ActionSheet b;
  public Runnable b;
  public List b;
  public boolean b;
  public View c;
  protected Runnable c;
  protected boolean c;
  protected int d;
  public View d;
  public boolean d;
  public int e;
  public View e;
  public int f;
  public String f;
  public int g;
  public String g;
  public String h;
  public String i;
  int j;
  public String j;
  public int k;
  public String l;
  
  static
  {
    jdField_a_of_type_JavaLangString = QRDisplayActivity.class.getSimpleName();
  }
  
  public QRDisplayActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRunnable = new cmn(this);
    this.jdField_b_of_type_JavaLangRunnable = new cmp(this);
    this.jdField_c_of_type_JavaLangRunnable = new cmq(this);
    this.jdField_b_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new cmr(this);
  }
  
  public BitMatrix a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      paramString = "user" + paramString;
    }
    for (;;)
    {
      paramString = getSharedPreferences("qrcode", 0).getString(paramString, null);
      if (paramString != null) {
        break label104;
      }
      return null;
      if (paramInt1 == 2)
      {
        paramString = "group" + paramString;
      }
      else
      {
        if (paramInt1 != 5) {
          break;
        }
        paramString = "discussion" + paramString;
      }
    }
    return null;
    label104:
    return QRUtils.a(paramString, paramInt2);
  }
  
  public String a()
  {
    String str;
    if (this.jdField_e_of_type_Int == 1) {
      str = "user" + this.h;
    }
    for (;;)
    {
      return getSharedPreferences("qrcode", 0).getString(str, null);
      if (this.jdField_e_of_type_Int == 2)
      {
        str = "group" + this.h;
      }
      else
      {
        if (this.jdField_e_of_type_Int != 5) {
          break;
        }
        str = "discussion" + this.h;
      }
    }
    return null;
  }
  
  public String a(String paramString)
  {
    paramString = "discussionnick_name" + paramString;
    return getSharedPreferences("qrcode", 0).getString(paramString, null);
  }
  
  public String a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int m = 0;
    while (m < paramList.size())
    {
      localStringBuffer.append((String)paramList.get(m));
      if (m != paramList.size() - 1) {
        localStringBuffer.append("、");
      }
      m += 1;
    }
    return localStringBuffer.toString();
  }
  
  protected void a()
  {
    if (this.jdField_b_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(2131363594, 1);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(2131363596, 1);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(2131363597, 1);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.e(2131365736);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new cms(this));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new cmt(this));
    }
    if (!this.jdField_b_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    String str;
    switch (paramInt)
    {
    default: 
      str = "获取讨论组链接失败";
    }
    for (;;)
    {
      a(2130838242, str);
      finish();
      return;
      str = "讨论组不存在";
      continue;
      str = "你已不在此讨论组";
    }
  }
  
  void a(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "template ready, draw qrcode");
    }
    if ((this.jdField_b_of_type_Boolean) || (super.isFinishing())) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    Bitmap localBitmap1 = (Bitmap)paramBundle.getParcelable("bkg");
    Bitmap localBitmap2 = (Bitmap)paramBundle.getParcelable("qrbkg");
    int i2 = paramBundle.getInt("B");
    int i3 = paramBundle.getInt("W");
    Rect localRect = (Rect)paramBundle.getParcelable("qrloc");
    ArrayList localArrayList = paramBundle.getParcelableArrayList("clip");
    if (paramBundle.containsKey("qrsz"))
    {
      m = paramBundle.getInt("qrsz");
      localObject1 = a();
      if (localObject1 != null) {
        this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = QRUtils.a((String)localObject1, m);
      }
    }
    int i4 = this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a();
    Object localObject1 = new int[i4 * i4];
    int m = 0;
    while (m < i4)
    {
      int n = 0;
      if (n < i4)
      {
        if (this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a(n, m)) {}
        for (int i1 = i2;; i1 = i3)
        {
          localObject1[(m * i4 + n)] = i1;
          n += 1;
          break;
        }
      }
      m += 1;
    }
    Bitmap localBitmap3 = Bitmap.createBitmap(i4, i4, Bitmap.Config.ARGB_8888);
    localBitmap3.setPixels((int[])localObject1, 0, i4, 0, 0, i4, i4);
    Object localObject2 = null;
    localObject1 = localObject2;
    if ((this.jdField_a_of_type_Long & 0x800) != 0L)
    {
      if (this.jdField_d_of_type_Int == 2) {
        localObject1 = BitmapFactory.decodeResource(getResources(), 2130838652);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = QRUtils.a(this, localBitmap1, this.jdField_a_of_type_AndroidGraphicsBitmap, paramBundle.getInt("nameClr"), this.f, localBitmap2, localBitmap3, paramBundle.getInt("head"), paramBundle.getInt("tipsClr"), this.g, localRect, localArrayList, (Bitmap)localObject1);
      localBitmap3.recycle();
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
        break label435;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      localObject1 = localObject2;
      if (this.jdField_d_of_type_Int != 1) {
        break;
      }
      localObject1 = BitmapFactory.decodeResource(getResources(), 2130839096);
      break;
      label435:
      if (super.isResume())
      {
        paramBundle = DialogUtil.a(this, 230);
        paramBundle.setMessage(2131363530);
        paramBundle.setPositiveButton(2131365737, new cmj(this));
        paramBundle.show();
      }
      else
      {
        super.finish();
      }
    }
  }
  
  protected void a(View paramView, int paramInt)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow = new IconPopupWindow(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131363594, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131363596, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131363597, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(paramView, paramInt);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramInt == 1) {}
    for (paramString1 = "user" + paramString1;; paramString1 = "group" + paramString1)
    {
      SharedPreferences.Editor localEditor = getSharedPreferences("qrcode", 0).edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
      do
      {
        return;
      } while (paramInt != 2);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = "discussionnick_name" + paramString1;
    SharedPreferences.Editor localEditor = getSharedPreferences("qrcode", 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public void b()
  {
    ThreadManager.b(new cmu(this));
    String str = null;
    if (this.jdField_e_of_type_Int == 1) {
      str = "saveConsumerQRcard";
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplication.getContext()).b(this.app, "", str, 1);
      return;
      if (this.jdField_e_of_type_Int == 2) {
        str = "saveGroupQRcard";
      }
    }
  }
  
  public void c()
  {
    String str1 = "temp_qrcode_share_" + this.h + ".png";
    String str3;
    try
    {
      str3 = QRUtils.a(this, str1, this.jdField_b_of_type_AndroidGraphicsBitmap);
      if (TextUtils.isEmpty(str3))
      {
        QRUtils.a(1, 2131363592);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QRUtils.a(1, 2131363591);
      return;
    }
    String str2;
    if (this.jdField_e_of_type_Int == 2)
    {
      str2 = getString(2131363562, new Object[] { this.f, this.h });
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.jdField_a_of_type_JavaLangString = this.app.getAccount();
      localUserInfo.b = ContactUtils.g(this.app, this.app.getAccount());
      localUserInfo.c = this.app.getSid();
      QZoneHelper.a(this, localUserInfo, str3, super.getString(2131363560), str2, 1);
      str2 = null;
      if (this.jdField_e_of_type_Int != 1) {
        break label231;
      }
      str2 = "shareConsumerQRcard";
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplication.getContext()).b(this.app, "", str2, 1);
      return;
      if (this.jdField_e_of_type_Int == 5)
      {
        str2 = getString(2131363561, new Object[] { this.f });
        break;
      }
      str2 = getString(2131363563);
      break;
      label231:
      if (this.jdField_e_of_type_Int == 2) {
        str2 = "shareGroupQRcard";
      }
    }
  }
  
  public void d()
  {
    if ((this.jdField_b_of_type_Boolean) || (super.isFinishing())) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "get code template");
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager;
    boolean bool2 = this.jdField_c_of_type_Boolean;
    if ((this.jdField_a_of_type_Long & 0x800) != 0L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ((CodeMaskManager)localObject).a(this, bool2, bool1, this.jdField_d_of_type_Int);
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    if (this.jdField_e_of_type_Int == 1) {}
    for (localObject = "changeConsumerQRcard";; localObject = "changeGroupQRcard")
    {
      StatisticCollector.a(BaseApplication.getContext()).b(this.app, "", (String)localObject, 1);
      return;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 != 1) {
        break label91;
      }
      a(0, getString(2131363595));
      if (QLog.isColorLevel()) {
        QLog.i("QRDisplayActivity", 2, "shareQRCode success");
      }
      if ((this.k & 0x1) != 0) {
        ReportController.b(this.app, "P_CliOper", "", "", "0X800416F", "0X800416F", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label91:
      if (paramInt1 == 2)
      {
        Intent localIntent = new Intent(this, ForwardHandlerActivity.class);
        localIntent.putExtras(paramIntent);
        localIntent.setFlags(67108864);
        startActivity(localIntent);
      }
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
    super.doOnConfigurationChanged(paramConfiguration);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    super.setContentView(2130903617);
    paramBundle = super.getIntent();
    this.k = paramBundle.getIntExtra("reportFlag", 0);
    super.setTitle(paramBundle.getStringExtra("title"));
    this.f = paramBundle.getStringExtra("nick");
    this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)paramBundle.getParcelableExtra("face"));
    this.jdField_e_of_type_Int = paramBundle.getIntExtra("type", 1);
    this.h = paramBundle.getStringExtra("uin");
    this.jdField_a_of_type_Long = paramBundle.getLongExtra("GroupFlagExt", 0L);
    this.jdField_d_of_type_Int = ((int)paramBundle.getLongExtra("AuthGroupType", 0L));
    Object localObject2;
    Object localObject1;
    int m;
    if (this.jdField_e_of_type_Int == 1)
    {
      this.g = getString(2131363582);
      this.jdField_b_of_type_AndroidViewView = super.findViewById(2131298971);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131298974));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView = super.findViewById(2131298970);
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131298975);
      this.jdField_d_of_type_AndroidViewView = findViewById(2131298976);
      this.jdField_e_of_type_AndroidViewView = findViewById(2131298977);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131368156));
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "display qrcode, type: " + this.jdField_e_of_type_Int);
      }
      if (this.jdField_e_of_type_Int != 5) {
        break label1025;
      }
      getIntent().getStringExtra("discussion_shorturl");
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      if (this.app != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.a(6));
        this.app.registObserver(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$GetNicknameObserver);
      }
      this.leftView.setContentDescription(getString(2131363746));
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131363747));
      setResult(-1, getIntent());
      paramBundle = (FriendsManagerImp)this.app.getManager(8);
      localObject2 = (DiscussionManager)this.app.getManager(51);
      localObject1 = ((DiscussionManager)localObject2).a(this.h);
      if (localObject1 != null) {
        break label605;
      }
      e();
      m = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager = new CodeMaskManager(this);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 60000L);
      if (m != 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.f + "," + this.g);
        this.jdField_c_of_type_AndroidViewView.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      if ((this.k & 0x1) != 0) {
        ReportController.b(this.app, "P_CliOper", "", "", "0X800416D", "0X800416D", 0, 0, "", "", "", "");
      }
      return true;
      if (this.jdField_e_of_type_Int == 2)
      {
        this.g = getString(2131363583);
        break;
      }
      if (this.jdField_e_of_type_Int != 5) {
        break;
      }
      this.g = getString(2131363584);
      break;
      label605:
      localObject2 = ((DiscussionManager)localObject2).a(this.h);
      if (localObject2 != null)
      {
        this.jdField_j_of_type_Int = ((List)localObject2).size();
        if ((((DiscussionInfo)localObject1).DiscussionFlag & 0x40) >>> 6 != 0L)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 4, "title not defined, join by nicks");
          }
          if (localObject2 != null) {
            localObject1 = ((List)localObject2).iterator();
          }
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label849;
          }
          localObject2 = (DiscussionMemberInfo)((Iterator)localObject1).next();
          if (this.app.getAccount().equals(((DiscussionMemberInfo)localObject2).memberUin))
          {
            this.jdField_b_of_type_JavaUtilList.add(ContactUtils.g(this.app, ((DiscussionMemberInfo)localObject2).memberUin));
            continue;
            this.jdField_j_of_type_Int = 0;
            break;
          }
          Friends localFriends = paramBundle.c(((DiscussionMemberInfo)localObject2).memberUin);
          if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.name))) {
            this.jdField_b_of_type_JavaUtilList.add(localFriends.name);
          } else if (a(((DiscussionMemberInfo)localObject2).memberUin) != null) {
            this.jdField_b_of_type_JavaUtilList.add(a(((DiscussionMemberInfo)localObject2).memberUin));
          } else {
            this.jdField_a_of_type_JavaUtilList.add(((DiscussionMemberInfo)localObject2).memberUin);
          }
        }
        label849:
        if ((this.jdField_b_of_type_JavaUtilList.size() < 5) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 4, "fetch nicks from server");
          }
          paramBundle = new String[this.jdField_a_of_type_JavaUtilList.size()];
          localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
          m = 0;
          while (((Iterator)localObject1).hasNext())
          {
            paramBundle[m] = ((String)((Iterator)localObject1).next());
            m += 1;
          }
          ((DiscussionHandler)this.app.a(6)).a(new String[] { "20002" }, paramBundle);
        }
        for (int n = 0;; n = 1)
        {
          m = n;
          if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
            break;
          }
          Collections.sort(this.jdField_b_of_type_JavaUtilList, new cmw(this));
          this.f = a(this.jdField_b_of_type_JavaUtilList);
          m = n;
          break;
        }
      }
      label1025:
      m = 1;
    }
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager.a();
    if (this.jdField_e_of_type_Int == 5)
    {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$GetNicknameObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow.b();
      this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
    super.doOnDestroy();
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if (super.isResume())
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
      localQQCustomDialog.setMessage(2131363529);
      localQQCustomDialog.setPositiveButton(2131365737, new cmk(this));
      localQQCustomDialog.show();
      return;
    }
    finish();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131298976) || (paramView.getId() == 2131298974)) {
      if (!this.jdField_a_of_type_Boolean) {
        a(paramView, 4);
      }
    }
    do
    {
      return;
      if ((paramView.getId() == 2131298980) || (paramView.getId() == 2131298977))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = IconPopupWindow.a(this, this);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(paramView, 4);
        DiscussionInfoCardActivity.c += 1;
        ReportController.b(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
        return;
      }
      if (paramView.getTag() == IconPopupWindow.a)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131367583);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
        }
        DiscussionInfoCardActivity.a(this.app, this, 2, this.jdField_j_of_type_JavaLangString, this.h, this.f, this.jdField_j_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
        return;
      }
      if (paramView.getTag() == IconPopupWindow.b)
      {
        DiscussionInfoCardActivity.a(this.app, this, this.i, this.h, this.f);
        return;
      }
    } while (paramView.getTag() != IconPopupWindow.c);
    DiscussionInfoCardActivity.a(this.app, this.jdField_b_of_type_Long, this.i, this.f);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      int m = -1;
      if (!WXShareHelper.a().a()) {
        m = 2131367829;
      }
      for (;;)
      {
        if (m == -1) {
          break label89;
        }
        QRUtils.a(1, m);
        break;
        if (!WXShareHelper.a().b()) {
          m = 2131367830;
        }
      }
      label89:
      if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new cml(this);
        WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      }
      paramView = this.app;
      label132:
      String str1;
      Bitmap localBitmap;
      String str2;
      if (paramInt == 2)
      {
        paramAdapterView = "1";
        ReportController.b(paramView, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, paramAdapterView, "", "", "");
        this.l = String.valueOf(System.currentTimeMillis());
        paramAdapterView = WXShareHelper.a();
        paramView = this.l;
        str1 = String.format(getString(2131368375), new Object[] { this.f });
        localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
        str2 = this.i;
        if (paramInt != 2) {
          break label249;
        }
      }
      label249:
      for (paramInt = 0;; paramInt = 1)
      {
        paramAdapterView.a(paramView, str1, localBitmap, "", str2, paramInt);
        break;
        paramAdapterView = "0";
        break label132;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131367583);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
      }
      DiscussionInfoCardActivity.a(this.app, this, 2, this.jdField_j_of_type_JavaLangString, this.h, this.f, this.jdField_j_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
      continue;
      DiscussionInfoCardActivity.a(this.app, this, this.i, this.h, this.f);
      continue;
      DiscussionInfoCardActivity.a(this.app, this.jdField_b_of_type_Long, this.i, this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity
 * JD-Core Version:    0.7.0.1
 */