package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cnf;
import cnh;
import cni;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.biz.widgets.ScannerView.FileDecodeListener;
import com.tencent.biz.widgets.ScannerView.ScannerListener;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;
import oicq.wlogin_sdk.request.WtloginHelper;

public class ScannerActivity
  extends BaseActivity
  implements View.OnClickListener, ScannerView.FileDecodeListener, ScannerView.ScannerListener
{
  protected static final int a = 200;
  protected static final String a = "QrcodeScanner";
  protected static final int b = 640;
  protected static final String b = "hasShowGuide";
  protected static final int c = 0;
  protected static final String c = "^mecard.*";
  protected static final int d = 1;
  protected static final String d = "^begin:vcard[\\s\\S]*end:vcard";
  protected static final int e = 2;
  protected static final String e = "^bizcard.*;;$";
  public static final String f = "issupportwpa";
  public static final String g = "exttype";
  public static int h = 0;
  public static final String h = "extvalue";
  public static final String i = "scanForResult";
  public static final String j = "from";
  public static final String k = "finishAfterSucc";
  public static String o = "addDisSource";
  public static final String p = "open_profile_card_from_scanner";
  public static final String q = "open_troop_info_from_scanner";
  protected SharedPreferences a;
  protected Rect a;
  protected View a;
  protected TextView a;
  public ScannerView a;
  protected Runnable a;
  protected WtloginHelper a;
  protected boolean a;
  protected View b;
  protected TextView b;
  protected boolean b;
  protected View c;
  protected TextView c;
  protected boolean c;
  protected TextView d;
  protected boolean d;
  protected boolean e = false;
  protected int f;
  public boolean f;
  protected int g;
  protected boolean g;
  protected boolean h;
  protected boolean i;
  protected boolean j;
  protected String l;
  protected String m;
  protected String n;
  
  static
  {
    jdField_h_of_type_Int = 1;
  }
  
  public ScannerActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new cnh(this);
  }
  
  public Rect a()
  {
    int i1 = 640;
    int i6;
    int i3;
    int i5;
    int i4;
    int i2;
    if (this.jdField_a_of_type_AndroidGraphicsRect == null)
    {
      float f1 = getResources().getDisplayMetrics().density;
      i6 = SizeMeasure.h(this);
      i3 = SizeMeasure.i(this);
      i5 = (int)(22.0F * f1 + 0.5D);
      if (this.e) {
        break label212;
      }
      i4 = (int)(f1 * 110.0F + 0.5D);
      i2 = this.jdField_f_of_type_Int;
      i3 = i3 - i2 - i4;
    }
    for (;;)
    {
      int i7 = Math.min(i6, i3);
      i4 = i7 * 5 / 7;
      if (i4 < 200)
      {
        i1 = Math.min(i7, 200);
        i4 = (i6 - i1) / 2;
        i3 = (i3 - i1) / 2;
        if (i3 <= i5) {
          break label200;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setHeight(i3);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsRect = new Rect(i4, i3 + i2, i4 + i1, i2 + (i3 + i1));
        return this.jdField_a_of_type_AndroidGraphicsRect;
        if (i4 > 640) {
          break;
        }
        i1 = i4;
        break;
        label200:
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      label212:
      i2 = 0;
    }
  }
  
  public void a()
  {
    if ((isFinishing()) || (!isResume())) {
      return;
    }
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setMessage(2131363565);
    cni localcni = new cni(this);
    localQQCustomDialog.setPositiveButton(2131365737, localcni);
    localQQCustomDialog.setOnCancelListener(localcni);
    localQQCustomDialog.show();
  }
  
  public void a(String paramString)
  {
    if ((isFinishing()) || (!isResume())) {}
    while (this.jdField_f_of_type_Boolean) {
      return;
    }
    b(paramString);
  }
  
  protected void b(String paramString)
  {
    ScannerUtils.a(Boolean.valueOf(this.j), Boolean.valueOf(this.i), paramString, this, this.app, this.jdField_d_of_type_Boolean, this.jdField_a_of_type_ComTencentBizWidgetsScannerView, this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper, this.jdField_a_of_type_AndroidViewView);
  }
  
  public void c(String paramString)
  {
    if ((isFinishing()) || (!isResume())) {
      return;
    }
    this.jdField_f_of_type_Boolean = false;
    b(paramString);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 0L);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrcodeScanner", 2, "onCreate");
    }
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentSharedPreferences = getSharedPreferences("qrcode", 0);
    this.e = ScannerUtils.a(this, this.jdField_a_of_type_AndroidContentSharedPreferences);
    Object localObject;
    if (this.e)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QrcodeScanner", 2, "needLandScapeMode");
      }
      if (getRequestedOrientation() != 0)
      {
        this.jdField_a_of_type_Boolean = true;
        setRequestedOrientation(0);
      }
      super.setContentView(2130903625);
      this.l = "";
      this.m = "";
      this.jdField_a_of_type_AndroidViewView = findViewById(2131298999);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298972));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298997));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298996));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298998));
      this.jdField_b_of_type_AndroidViewView = findViewById(2131298993);
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView = ((ScannerView)findViewById(2131298403));
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView.setScanListener(this);
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView.setFileDecodeListener(this);
      this.jdField_f_of_type_Int = getResources().getDimensionPixelOffset(2131492923);
      this.jdField_g_of_type_Int = getResources().getDimensionPixelOffset(2131493140);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentBizWidgetsScannerView.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      paramBundle = getIntent();
      localObject = paramBundle.getStringExtra("from");
      if (!"addcontacts".equals(localObject)) {
        break label591;
      }
      StatisticCollector.a(getApplicationContext()).b(this.app, "", "addfriend_QR", 1);
      label306:
      if (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("hasShowGuide", false)) {
        break label690;
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_c_of_type_AndroidViewView = View.inflate(this, 2130903619, null);
      addContentView(this.jdField_c_of_type_AndroidViewView, new RelativeLayout.LayoutParams(-1, -1));
      this.jdField_c_of_type_AndroidViewView.findViewById(2131298983).setOnClickListener(this);
      localObject = (TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131297357);
      String str = getIntent().getExtras().getString("leftViewText");
      if (!TextUtils.isEmpty(str)) {
        ((TextView)localObject).setText(str);
      }
      str = paramBundle.getStringExtra("assignBackText");
      if (!TextUtils.isEmpty(str)) {
        ((TextView)localObject).setText(str);
      }
      ((TextView)localObject).setOnClickListener(this);
      ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131297348)).setText(2131363528);
    }
    for (;;)
    {
      findViewById(2131297357).setOnClickListener(this);
      ((TextView)findViewById(2131297348)).setText(2131363528);
      this.jdField_f_of_type_Boolean = false;
      if ((this.permissionManager.checkPermission("android.permission.CAMERA")) && (this.permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE"))) {
        break label717;
      }
      this.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.CAMERA", 200), PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).requests(new cnf(this));
      return true;
      super.setContentView(2130903624);
      this.l = getString(2131363575);
      this.m = getString(2131363576);
      break;
      label591:
      if ("ImagePreviewActivity".equals(localObject))
      {
        StatisticCollector.a(getApplicationContext()).b(this.app, "", "bigpicture_QR", 1);
        break label306;
      }
      if ("Conversation".equals(localObject))
      {
        StatisticCollector.a(getApplicationContext()).b(this.app, "", "bulb_QR", 1);
        break label306;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label306;
      }
      StatisticCollector.a(getApplicationContext()).b(this.app, "", "find_QR", 1);
      break label306;
      label690:
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
    label717:
    this.jdField_h_of_type_Boolean = super.getPackageManager().hasSystemFeature("android.hardware.camera");
    if ((!this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363558);
    }
    this.n = paramBundle.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (this.n != null) {
      this.jdField_f_of_type_Boolean = true;
    }
    this.i = paramBundle.getBooleanExtra("scanForResult", false);
    this.j = paramBundle.getBooleanExtra("finishAfterSucc", false);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrcodeScanner", 2, "onDestroy");
    }
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.n = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (this.n != null) {
      this.jdField_f_of_type_Boolean = true;
    }
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrcodeScanner", 2, "onPause");
    }
    this.jdField_f_of_type_Boolean = false;
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_g_of_type_Boolean = false;
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130839289, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.l);
    }
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.c();
    this.jdField_d_of_type_Boolean = false;
    Process.setThreadPriority(0);
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrcodeScanner", 2, "onResume");
    }
    super.doOnResume();
    Process.setThreadPriority(-19);
    if (this.n != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView.a(this.n);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.n = null;
    }
    if (!this.jdField_f_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView.b();
    }
  }
  
  public void f()
  {
    if ((isFinishing()) || (!isResume())) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363557);
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView.a()) {
        this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
      }
    } while (this.jdField_f_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.d();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130968584);
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363559);
  }
  
  public void h()
  {
    if ((isFinishing()) || (!isResume())) {}
    while (this.jdField_f_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.d();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298983: 
      this.jdField_c_of_type_Boolean = false;
      paramView.setOnClickListener(null);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      ((ViewGroup)this.jdField_c_of_type_AndroidViewView.getParent()).removeView(this.jdField_c_of_type_AndroidViewView);
      if (!this.jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizWidgetsScannerView.b();
      }
      paramView = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      paramView.putBoolean("hasShowGuide", true);
      paramView.commit();
      return;
    case 2131298996: 
      paramView = new Intent();
      paramView.setClass(this, PhotoListActivity.class);
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ScannerActivity.class.getName());
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
      paramView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      paramView.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      paramView.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
      super.startActivity(paramView);
      AlbumUtil.a(this, false, true);
      ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "saoyisao", "xiangce", 0, 1, 0, "", "", "", "");
      return;
    case 2131298997: 
      paramView = this.jdField_a_of_type_ComTencentBizWidgetsScannerView;
      boolean bool;
      if (!this.jdField_g_of_type_Boolean)
      {
        bool = true;
        this.jdField_g_of_type_Boolean = paramView.a(bool);
        if (!this.jdField_g_of_type_Boolean) {
          break label364;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130839282, 0, 0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.m);
      }
      for (;;)
      {
        ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "saoyisao", "kaideng", 0, 1, 0, "", "", "", "");
        return;
        bool = false;
        break;
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130839289, 0, 0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.l);
      }
    case 2131298998: 
      label364:
      paramView = new Intent(this, QRDisplayActivity.class);
      String str = this.app.a();
      paramView.putExtra("title", getString(2131363588));
      paramView.putExtra("nick", ContactUtils.g(this.app, str));
      paramView.putExtra("uin", str);
      paramView.putExtra("type", 1);
      super.startActivity(paramView);
      ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "saoyisao", "wode", 0, 1, 0, "", "", "", "");
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerActivity
 * JD-Core Version:    0.7.0.1
 */