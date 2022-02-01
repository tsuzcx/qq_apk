package com.tencent.mobileqq.activity;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qq.jce.wup.UniPacket;
import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.util.SubString;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.config.QQMapConstants;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQMapView.QQMapViewObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SelectPicPopupWindow;
import com.tencent.mobileqq.widget.SelectPicPopupWindow.ViewHolder;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsResp;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsResp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapActivity;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import esq;
import est;
import esu;
import esv;
import esw;
import esx;
import esy;
import esz;
import eta;
import etb;
import etc;
import etd;
import ete;
import etg;
import eth;
import eti;
import etj;
import etk;
import etl;
import etm;
import etn;
import etr;
import ets;
import ett;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.RejectedExecutionException;
import mqq.app.ApplicationLifeController;
import org.json.JSONException;
import org.json.JSONObject;

public class QQMapActivity
  extends MapActivity
  implements QQMapView.QQMapViewObserver, SkinnableActivityProcesser.Callback
{
  protected static final int A = 2;
  private static final int jdField_a_of_type_Int = 0;
  private static final int jdField_b_of_type_Int = 1;
  public static final String e = "QQMapActivity";
  protected static final String f = "fetch_address";
  protected static final String g = "get_location";
  protected static final String h = "com.tencent.mobileqq.onGetStreetViewUrl";
  public static final String r = "group_activity";
  public static final String t = "forward_location";
  protected static final int x = 0;
  protected static final int y = 0;
  protected static final int z = 1;
  protected int B;
  public int C = 0;
  public double a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new eth(this);
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new esw(this);
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  public AsyncBack a;
  SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new etb(this, 1, true, 0L, true, true, "QQMapActivity");
  private IconPopupWindow jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
  public QQMapView a;
  public SelectPicPopupWindow a;
  GeoPoint jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint;
  public MapController a;
  SkinnableActivityProcesser jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser;
  protected ActionSheet a;
  public double b;
  float jdField_b_of_type_Float;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new eti(this);
  public View.OnClickListener b;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  protected List b;
  protected View.OnClickListener c;
  public ImageView c;
  protected TextView c;
  protected View.OnClickListener d;
  public ImageView d;
  protected TextView d;
  protected View.OnClickListener e;
  protected ImageView e;
  protected TextView e;
  protected View.OnClickListener f;
  protected ImageView f;
  public TextView f;
  protected View.OnClickListener g = new esv(this);
  public String i = "";
  protected View j;
  protected String j;
  protected View k;
  public String k;
  public boolean k;
  protected View l;
  public String l;
  public boolean l;
  protected View m;
  public String m;
  public boolean m;
  protected View n;
  public String n;
  boolean n;
  protected View o;
  public String o;
  protected boolean o;
  protected String p;
  public boolean p;
  public String q;
  public boolean q;
  protected boolean r = false;
  public String s;
  public boolean s;
  public boolean t = false;
  
  public QQMapActivity()
  {
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_q_of_type_Boolean = true;
    this.jdField_s_of_type_Boolean = false;
    this.jdField_q_of_type_JavaLangString = null;
    this.jdField_s_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack = null;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new etl(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new ets(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new ett(this);
    this.jdField_e_of_type_AndroidViewView$OnClickListener = new est(this);
    this.jdField_f_of_type_AndroidViewView$OnClickListener = new esu(this);
  }
  
  static String a(Context paramContext)
  {
    int i1 = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == i1) {
        return localRunningAppProcessInfo.processName;
      }
    }
    return null;
  }
  
  private void a()
  {
    if ((this.jdField_l_of_type_JavaLangString == null) || (this.jdField_l_of_type_JavaLangString.length() == 0))
    {
      if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_f_of_type_AndroidWidgetImageView != null) {
        this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_l_of_type_AndroidViewView != null) {
        this.jdField_l_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setClickable(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(null);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_c_of_type_AndroidWidgetTextView == null);
        if ((this.jdField_l_of_type_AndroidViewView != null) && (!this.jdField_o_of_type_Boolean))
        {
          this.jdField_l_of_type_AndroidViewView.setVisibility(0);
          this.jdField_l_of_type_AndroidViewView.setOnClickListener(new esq(this));
        }
      } while (this.jdField_c_of_type_AndroidWidgetTextView.getText().length() <= 0);
      if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    } while (this.jdField_f_of_type_AndroidWidgetImageView == null);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void a(double paramDouble1, double paramDouble2)
  {
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController != null)
    {
      GeoPoint localGeoPoint = new GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D));
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setCenter(localGeoPoint);
      if ((this.jdField_k_of_type_JavaLangString == null) || (this.jdField_k_of_type_JavaLangString.length() <= 0)) {
        a(localGeoPoint, this.jdField_c_of_type_AndroidWidgetTextView, false);
      }
    }
    else
    {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_k_of_type_JavaLangString);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    a();
  }
  
  private void a(GeoPoint paramGeoPoint, TextView paramTextView, boolean paramBoolean)
  {
    this.i = "";
    try
    {
      new QQMapActivity.GetLocNameTask(this, paramGeoPoint, paramTextView).execute(new GeoPoint[] { paramGeoPoint });
      if (paramBoolean) {
        u();
      }
      return;
    }
    catch (RejectedExecutionException paramGeoPoint)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQMapActivity", 2, paramGeoPoint.getMessage());
    }
  }
  
  private boolean a(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    if (paramString.contains("geo:0,0")) {
      localIntent.setClassName(QQMapConstants.f, QQMapConstants.c);
    }
    for (;;)
    {
      try
      {
        a(this, localIntent);
        bool = true;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        boolean bool = false;
        continue;
        if (!paramString.startsWith("bdapp")) {
          continue;
        }
        int i1 = 4;
        continue;
        if (!paramString.startsWith("androidamap")) {
          continue;
        }
        i1 = 3;
        continue;
        if (!paramString.startsWith("geo:0,0")) {
          continue;
        }
        i1 = 6;
        continue;
        i1 = -1;
        continue;
      }
      if (!paramString.startsWith("sosogeo")) {
        continue;
      }
      i1 = 1;
      if (i1 != -1) {
        ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_navig", 0, 0, String.valueOf(i1), "", "", "");
      }
      return bool;
      if (paramString.startsWith("sosogeo")) {
        localIntent.setClassName(QQMapConstants.d, QQMapConstants.b);
      }
    }
  }
  
  private void b()
  {
    Object localObject5 = null;
    Object localObject4 = null;
    Bundle localBundle = getIntent().getExtras();
    String str = localBundle.getString("options");
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(str);
        if (localObject1 == null) {
          break label577;
        }
        localObject5 = ((JSONObject)localObject1).optString("lat");
        str = ((JSONObject)localObject1).optString("lng");
        this.jdField_n_of_type_JavaLangString = ((JSONObject)localObject1).optString("title");
        this.jdField_k_of_type_JavaLangString = ((JSONObject)localObject1).optString("desc");
        if (((JSONObject)localObject1).has("from")) {
          localObject4 = ((JSONObject)localObject1).optString("from");
        }
        this.jdField_s_of_type_JavaLangString = ((String)localObject4);
        this.jdField_n_of_type_Boolean = "share".equals(((JSONObject)localObject1).opt("action"));
        this.jdField_j_of_type_JavaLangString = ("http://maps.google.com/maps?q=" + (String)localObject5 + "," + str + "&iwloc=A&hl=zh-CN (" + this.jdField_k_of_type_JavaLangString + ")");
        localObject1 = str;
        localObject4 = localObject5;
        localObject5 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject5 = localBundle.getString("lat");
        }
        localObject4 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject4 = localBundle.getString("lon");
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject4)))
        {
          this.jdField_k_of_type_Boolean = true;
          this.jdField_a_of_type_Double = Double.valueOf((String)localObject5).doubleValue();
          this.jdField_b_of_type_Double = Double.valueOf((String)localObject4).doubleValue();
        }
        if (TextUtils.isEmpty(this.jdField_n_of_type_JavaLangString)) {
          this.jdField_n_of_type_JavaLangString = localBundle.getString("title");
        }
        this.jdField_o_of_type_JavaLangString = localBundle.getString("summary");
        if (TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
          this.jdField_j_of_type_JavaLangString = localBundle.getString("url");
        }
        if (TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) {
          this.jdField_k_of_type_JavaLangString = localBundle.getString("loc");
        }
        if ((this.jdField_k_of_type_JavaLangString != null) && (this.jdField_k_of_type_JavaLangString.contains("+"))) {
          this.jdField_k_of_type_JavaLangString = this.jdField_k_of_type_JavaLangString.replace("+", " ");
        }
        this.jdField_p_of_type_JavaLangString = localBundle.getString("dpid");
        if (this.jdField_k_of_type_Boolean) {
          sendBroadcast(new Intent("com.tencent.mobileqq.getStreetViewUrl").putExtra("latitude", this.jdField_a_of_type_Double).putExtra("longitude", this.jdField_b_of_type_Double));
        }
        this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968642);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatMode(2);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatCount(1);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968643);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setRepeatMode(2);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setRepeatCount(1);
        return;
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("get_params", 2, "parse params failed, options : " + str);
        }
        Object localObject2 = null;
        continue;
      }
      catch (NullPointerException localNullPointerException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("get_params", 2, "parse params failed, options : " + str);
        }
      }
      Object localObject3 = null;
      continue;
      label577:
      localObject4 = null;
      localObject3 = localObject5;
    }
  }
  
  private boolean b(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    try
    {
      a(this, paramString, 0);
      return true;
    }
    catch (ActivityNotFoundException paramString) {}
    return false;
  }
  
  private static boolean b(String paramString, ArrayList paramArrayList)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while ((!paramString.equals(BaseApplicationImpl.a(paramArrayList, false))) && (!paramString.equals(BaseApplicationImpl.a(paramArrayList, true)))) {
      return false;
    }
    return true;
  }
  
  private static boolean b(ArrayList paramArrayList, Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      bool1 = true;
    }
    do
    {
      return bool1;
      paramContext = a(paramContext);
      bool1 = bool2;
    } while (paramContext == null);
    int i1 = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= paramArrayList.size()) {
        break;
      }
      if (paramContext.equals(paramArrayList.get(i1))) {
        return true;
      }
      i1 += 1;
    }
  }
  
  private void g()
  {
    findViewById(2131298255).setVisibility(8);
    this.jdField_o_of_type_AndroidViewView = findViewById(2131300671);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView = ((QQMapView)findViewById(2131300679));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299200));
    this.jdField_l_of_type_AndroidViewView = findViewById(2131300682);
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), 2130841594);
      if (localBitmap != null)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        this.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, localBitmap.getHeight());
        this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300683));
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130841596);
        this.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, localBitmap.getHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setContentDescription(getString(2131364128));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setLogoMarginRate(0, 0.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setLogoMarginRate(1, 0.8F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setLogoMarginRate(2, 0.0F);
      if (!this.jdField_k_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setObserver(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setBuiltInZoomControls(false);
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController = this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getController();
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setZoom(16);
        h();
        k();
        j();
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        MapView.LayoutParams localLayoutParams = null;
        continue;
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setObserver(null);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
        try
        {
          this.jdField_j_of_type_AndroidViewView = getLayoutInflater().inflate(2130903357, null);
          localLayoutParams = new MapView.LayoutParams(-2, -2, null, 81);
          localLayoutParams.point = new GeoPoint((int)(this.jdField_a_of_type_Double * 1000000.0D), (int)(this.jdField_b_of_type_Double * 1000000.0D));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.addView(this.jdField_j_of_type_AndroidViewView, localLayoutParams);
          this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_j_of_type_AndroidViewView.findViewById(2131297913));
          this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
          this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_j_of_type_AndroidViewView.findViewById(2131297914));
          this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(4);
          this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131297911));
          this.jdField_m_of_type_AndroidViewView = this.jdField_j_of_type_AndroidViewView.findViewById(2131297910);
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131297912));
          this.jdField_c_of_type_AndroidWidgetTextView.setText("");
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
          this.jdField_n_of_type_AndroidViewView = this.jdField_j_of_type_AndroidViewView.findViewById(2131297915);
          this.jdField_n_of_type_AndroidViewView.setVisibility(8);
          a();
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQMapActivity", 2, localNotFoundException.getMessage());
          }
          super.finish();
        }
      }
    }
  }
  
  private void h()
  {
    String str = TimeZone.getDefault().getID();
    if (QLog.isColorLevel()) {
      QLog.d("QQMapActivity", 2, "default timezone:" + str);
    }
    if (((!"Asia/Shanghai".equals(str)) && (!"Asia/Hong_Kong".equals(str)) && (!"Asia/Chongqing".equals(str)) && (!"Asia/Beijing".equals(str))) || (!"zh".equals(Locale.getDefault().getLanguage())))
    {
      ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "call_googlemap", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setGoogleMapEnable(true);
      findViewById(2131300680).setVisibility(0);
      this.r = true;
    }
  }
  
  private void j()
  {
    Object localObject = (ViewGroup)findViewById(2131297347);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131297001);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131297357);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  private void k()
  {
    ((ImageView)findViewById(2131300695)).setOnClickListener(new esx(this));
    ((ImageView)findViewById(2131300696)).setOnClickListener(new esy(this));
    ((ImageView)findViewById(2131300697)).setOnClickListener(new esz(this));
  }
  
  private void l()
  {
    ThreadManager.a(new etj(this));
  }
  
  public Dialog a(int paramInt1, int paramInt2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return a(getResources().getString(paramInt1), getResources().getString(paramInt2), paramOnDismissListener);
  }
  
  public Dialog a(String paramString)
  {
    Dialog localDialog = new Dialog(this, 2131558902);
    localDialog.setContentView(2130903223);
    TextView localTextView = (TextView)localDialog.findViewById(2131296606);
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
    return localDialog;
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Dialog localDialog = new Dialog(this, 2131558902);
    localDialog.setContentView(2130903211);
    TextView localTextView = (TextView)localDialog.findViewById(2131297367);
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = (TextView)localDialog.findViewById(2131296606);
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = (TextView)localDialog.findViewById(2131297370);
    if (paramString1 != null) {
      paramString1.setText(2131366941);
    }
    paramString1 = (TextView)localDialog.findViewById(2131297371);
    if (paramString1 != null) {
      paramString1.setText(2131366374);
    }
    localDialog.setOnDismissListener(paramOnDismissListener);
    return localDialog;
  }
  
  public Intent a()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    GeoPoint localGeoPoint = this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMapCenter();
    double d1 = localGeoPoint.getLatitudeE6() / 1000000.0D;
    double d2 = localGeoPoint.getLongitudeE6() / 1000000.0D;
    localBundle.putString("latitude", String.valueOf(d1));
    localBundle.putString("longitude", String.valueOf(d2));
    localBundle.putString("description", this.i);
    if ((TextUtils.isEmpty(this.jdField_n_of_type_JavaLangString)) || (this.jdField_n_of_type_JavaLangString.equals(getString(2131369272)))) {
      this.jdField_n_of_type_JavaLangString = getString(2131366588);
    }
    if (TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString)) {
      this.jdField_o_of_type_JavaLangString = "Unknown Address";
    }
    localBundle.putString("title", this.jdField_n_of_type_JavaLangString);
    localBundle.putString("summary", this.jdField_o_of_type_JavaLangString);
    localBundle.putString("dianping_id", this.jdField_p_of_type_JavaLangString);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  public final Object a(byte[] paramArrayOfByte, String paramString, Object paramObject)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramObject);
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    catch (RuntimeException paramArrayOfByte) {}
    return null;
  }
  
  protected String a()
  {
    String str = QQMapConstants.jdField_j_of_type_JavaLangString;
    return getSharedPreferences("QQMAP", 0).getString(str, null);
  }
  
  public List a()
  {
    PackageManager localPackageManager = getPackageManager();
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse("geo:0,0"));
    return localPackageManager.queryIntentActivities(localIntent, 0);
  }
  
  public void a(LBSShare.GetShopsByIdsResp paramGetShopsByIdsResp) {}
  
  public void a(LBSShare.LocationResp paramLocationResp, Bundle paramBundle) {}
  
  public void a(LBSShare.NearByShopsResp paramNearByShopsResp, Bundle paramBundle) {}
  
  public void a(GeoPoint paramGeoPoint) {}
  
  public void a(GeoPoint paramGeoPoint, String paramString)
  {
    Object localObject = new MapView.LayoutParams(-2, -2, null, 0, getResources().getDimensionPixelSize(2131493246), 81);
    ((MapView.LayoutParams)localObject).point = paramGeoPoint;
    if (this.jdField_k_of_type_AndroidViewView == null)
    {
      this.jdField_k_of_type_AndroidViewView = getLayoutInflater().inflate(2130903357, null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.addView(this.jdField_k_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131297912));
      this.jdField_d_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_k_of_type_AndroidViewView.findViewById(2131297913).setVisibility(8);
      this.jdField_k_of_type_AndroidViewView.findViewById(2131297914).setVisibility(8);
      this.jdField_k_of_type_AndroidViewView.findViewById(2131297910).setVisibility(4);
      paramGeoPoint = (ImageView)this.jdField_k_of_type_AndroidViewView.findViewById(2131297917);
      paramGeoPoint.setImageResource(2130837677);
      paramGeoPoint.setBackgroundDrawable(null);
      paramGeoPoint = (ImageView)this.jdField_k_of_type_AndroidViewView.findViewById(2131297916);
      localObject = AnimationUtils.loadAnimation(this, 17432576);
      ((Animation)localObject).setDuration(800L);
      ((Animation)localObject).setRepeatCount(2);
      ((Animation)localObject).setRepeatCount(-1);
      paramGeoPoint.startAnimation((Animation)localObject);
    }
    for (;;)
    {
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.updateViewLayout(this.jdField_k_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.t = paramBoolean;
    if (!NetworkUtil.e(this)) {
      w();
    }
    for (;;)
    {
      SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      return;
      super.showDialog(0);
      if (QLog.isColorLevel()) {
        QLog.d("get_location", 2, "start get lacation");
      }
    }
  }
  
  boolean a(GeoPoint paramGeoPoint)
  {
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint == null) {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = paramGeoPoint;
    }
    while ((paramGeoPoint == null) || (Math.abs(paramGeoPoint.getLatitudeE6() - this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6()) >= 1) || (Math.abs(paramGeoPoint.getLongitudeE6() - this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6()) >= 1)) {
      return false;
    }
    return true;
  }
  
  boolean a(List paramList1, List paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return false;
    }
    if (paramList1.size() == paramList2.size()) {}
    for (int i1 = paramList1.size(); i1 == 0; i1 = 0) {
      return false;
    }
    int i2 = 0;
    while (i2 < i1)
    {
      if (!((ResolveInfo)paramList1.get(i2)).activityInfo.packageName.equalsIgnoreCase(((ResolveInfo)paramList2.get(i2)).activityInfo.packageName)) {
        return false;
      }
      i2 += 1;
    }
    return true;
  }
  
  public boolean a(List paramList, boolean paramBoolean)
  {
    boolean bool2 = false;
    Object localObject1 = null;
    int i2 = paramList.size();
    boolean bool1 = bool2;
    if (paramList != null)
    {
      if (paramList.size() != 0) {
        break label38;
      }
      bool1 = bool2;
    }
    label38:
    int i1;
    Object localObject3;
    Object localObject5;
    do
    {
      return bool1;
      i1 = 0;
      localObject4 = null;
      localObject3 = null;
      bool1 = false;
      localObject2 = null;
      if (i1 >= i2) {
        break label228;
      }
      localObject5 = (ResolveInfo)paramList.get(i1);
      if (!((ResolveInfo)localObject5).activityInfo.packageName.equalsIgnoreCase(QQMapConstants.d)) {
        break;
      }
      bool2 = true;
      bool1 = true;
    } while (paramBoolean);
    Object localObject2 = localObject4;
    Object localObject4 = localObject5;
    bool1 = bool2;
    for (;;)
    {
      i1 += 1;
      localObject5 = localObject4;
      localObject4 = localObject2;
      localObject2 = localObject5;
      break;
      Object localObject6;
      if (((ResolveInfo)localObject5).activityInfo.packageName.equalsIgnoreCase(QQMapConstants.g))
      {
        localObject6 = localObject2;
        localObject2 = localObject4;
        localObject3 = localObject5;
        localObject4 = localObject6;
      }
      else if (((ResolveInfo)localObject5).activityInfo.packageName.equalsIgnoreCase(QQMapConstants.e))
      {
        localObject4 = localObject2;
        localObject2 = localObject5;
      }
      else if (((ResolveInfo)localObject5).activityInfo.packageName.equalsIgnoreCase(QQMapConstants.f))
      {
        localObject6 = localObject2;
        localObject1 = localObject5;
        localObject2 = localObject4;
        localObject4 = localObject6;
        continue;
        label228:
        paramList.removeAll(paramList);
        if (localObject2 != null) {
          paramList.add(localObject2);
        }
        if (localObject3 != null) {
          paramList.add(localObject3);
        }
        if (localObject4 != null) {
          paramList.add(localObject4);
        }
        if (localObject1 != null) {
          paramList.add(localObject1);
        }
        return bool1;
      }
      else
      {
        localObject5 = localObject2;
        localObject2 = localObject4;
        localObject4 = localObject5;
      }
    }
  }
  
  public void b(GeoPoint paramGeoPoint)
  {
    if ((!this.jdField_k_of_type_Boolean) && (!a(paramGeoPoint)))
    {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = paramGeoPoint;
      a(paramGeoPoint);
    }
  }
  
  public void c() {}
  
  public void c(GeoPoint paramGeoPoint) {}
  
  public void c(String paramString)
  {
    String str = QQMapConstants.jdField_j_of_type_JavaLangString;
    SharedPreferences.Editor localEditor = getSharedPreferences("QQMAP", 0).edit();
    localEditor.putString(str, paramString);
    localEditor.commit();
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void i()
  {
    this.jdField_l_of_type_Boolean = false;
    findViewById(2131300693).setVisibility(0);
    if (!this.jdField_k_of_type_Boolean)
    {
      TextView localTextView = (TextView)findViewById(2131297360);
      localTextView.setVisibility(0);
      localTextView.setText(localTextView.getTag().toString());
    }
  }
  
  public void o()
  {
    int i2 = a(this).getDimensionPixelSize(2131492923);
    if (Utils.b() < 31457280L)
    {
      QQToast.a(this, 1, getString(2131364039), 1).b(i2);
      return;
    }
    int i1 = 0;
    while ((this.jdField_q_of_type_JavaLangString == null) && (i1 < 3)) {
      try
      {
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(QQMapConstants.h).openConnection();
        localHttpURLConnection.setRequestMethod("GET");
        localHttpURLConnection.setInstanceFollowRedirects(false);
        localHttpURLConnection.addRequestProperty("Accept-Charset", "UTF-8;");
        localHttpURLConnection.connect();
        this.jdField_q_of_type_JavaLangString = localHttpURLConnection.getHeaderField(QQMapConstants.jdField_k_of_type_JavaLangString);
        localHttpURLConnection.disconnect();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i1 += 1;
      }
    }
    if (this.jdField_q_of_type_JavaLangString == null)
    {
      QQToast.a(this, 1, getString(2131364028), 1).b(i2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.dismiss();
      return;
    }
    Object localObject1 = ((SelectPicPopupWindow.ViewHolder)this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.a.get(0)).jdField_a_of_type_AndroidWidgetTextView;
    Object localObject2;
    if (this.C == 0)
    {
      localObject2 = ((SelectPicPopupWindow.ViewHolder)this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.a.get(0)).jdField_a_of_type_AndroidWidgetProgressBar;
      if (((ProgressBar)localObject2).getVisibility() == 8)
      {
        ((ProgressBar)localObject2).setVisibility(0);
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setBackgroundDrawable(null);
        ((TextView)localObject1).setText(getString(2131364036));
      }
      localObject1 = "QQMAP" + QQMapConstants.h;
      localObject2 = getSharedPreferences("QQMAP", 0);
      String str = ((SharedPreferences)localObject2).getString((String)localObject1, null);
      if ((!TextUtils.isEmpty(str)) && (!str.equalsIgnoreCase(this.jdField_q_of_type_JavaLangString))) {
        break label374;
      }
    }
    for (;;)
    {
      ThreadManager.a(new etd(this));
      localObject2 = ((SharedPreferences)localObject2).edit();
      ((SharedPreferences.Editor)localObject2).putString((String)localObject1, this.jdField_q_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject2).commit();
      this.C = 1;
      return;
      if (this.C != 2) {
        break;
      }
      ((TextView)localObject1).setText(getString(2131364036));
      break;
      label374:
      OfflineDownloader.a(QQMapConstants.i);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      Intent localIntent = new Intent("Common_BroadcastReceiver");
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      localIntent.putExtra("forward_location", true);
      sendBroadcast(localIntent);
      super.finish();
    }
  }
  
  public void onBackPressed()
  {
    super.setResult(-1, new Intent());
    try
    {
      c();
      super.onBackPressed();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      super.finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser = new SkinnableActivityProcesser(this, this);
    setContentView(2130904064);
    this.jdField_m_of_type_JavaLangString = super.getIntent().getStringExtra("uin");
    sendBroadcast(new Intent("com.tencent.mobileqq.addLbsObserver"));
    b();
    s();
    g();
    if (this.jdField_k_of_type_Boolean) {
      a(this.jdField_a_of_type_Double, this.jdField_b_of_type_Double);
    }
    for (;;)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.onGetStreetViewUrl");
      paramBundle.addAction("com.tencent.mobileqq.onGetLbsShareSearch");
      paramBundle.addAction("com.tencent.mobileqq.onGetLbsShareShop");
      paramBundle.addAction("com.tencent.mobileqq.onGetShareShopDetail");
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramBundle);
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      return;
      a(true);
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    }
    Dialog localDialog;
    View localView;
    do
    {
      return localObject;
      return a(getString(2131366568));
      localDialog = a(2131366583, 2131366584, new etc(this));
      localObject = localDialog.findViewById(2131297370);
      if (localObject != null) {
        ((View)localObject).setOnClickListener(new ete(this, localDialog));
      }
      localView = localDialog.findViewById(2131297371);
      localObject = localDialog;
    } while (localView == null);
    localView.setOnClickListener(new etg(this, localDialog));
    return localDialog;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser != null) {
      this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser.destory();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.destroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
    sendBroadcast(new Intent("com.tencent.mobileqq.removeLbsObserver"));
    sendBroadcast(new Intent("com.tencent.mobileqq.unregisterReceiver"));
    super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_s_of_type_Boolean)
    {
      this.jdField_s_of_type_Boolean = false;
      List localList = a();
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow != null) && (a(localList, true))) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.a(0);
      }
    }
    BaseActivity.mAppForground = GesturePWDUtils.getAppForground(this);
    if ((!BaseActivity.mAppForground) && (GesturePWDUtils.getGesturePWDState(this, this.jdField_m_of_type_JavaLangString) == 2) && (GesturePWDUtils.getGesturePWDMode(this, this.jdField_m_of_type_JavaLangString) == 21))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqbaseactivity", 2, "qqmapactivity.start lock. GesturePWDUnlockActivity");
      }
      super.startActivity(new Intent(this, GesturePWDUnlockActivity.class));
    }
    for (this.jdField_p_of_type_Boolean = true;; this.jdField_p_of_type_Boolean = false)
    {
      if (!BaseActivity.mAppForground)
      {
        BaseActivity.mAppForground = true;
        GesturePWDUtils.setAppForground(this, BaseActivity.mAppForground);
      }
      this.jdField_q_of_type_Boolean = false;
      if ((!this.t) && (!this.jdField_k_of_type_Boolean)) {
        a(false);
      }
      return;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    ApplicationLifeController.getController().onActivityStart(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    this.jdField_q_of_type_Boolean = true;
    ApplicationLifeController.getController().onActivityStop(this);
    BaseActivity.mAppForground = GesturePWDUtils.getAppForground(this);
    SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    if (!BaseActivity.mAppForground) {
      GesturePWDUtils.setAppForground(this, BaseActivity.mAppForground);
    }
  }
  
  protected void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    sendBroadcast(new Intent("com.tencent.mobileqq.showNotification"));
  }
  
  public void p()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.d(super.getString(2131365736));
    localActionSheet.a(super.getString(2131364040), 1);
    localActionSheet.a(new etk(this, localActionSheet));
    localActionSheet.show();
  }
  
  public void q()
  {
    Object localObject2 = a();
    String str1;
    Object localObject1;
    if ((this.jdField_n_of_type_JavaLangString != null) && (!this.jdField_n_of_type_JavaLangString.equals(super.getString(2131366588))))
    {
      str1 = this.jdField_n_of_type_JavaLangString;
      if (localObject2 == null) {
        break label338;
      }
      if (!((String)localObject2).startsWith("sosogeo")) {
        break label124;
      }
      localObject1 = "sosogeo://?q=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "(" + str1 + ")";
    }
    for (;;)
    {
      if (!a((String)localObject1)) {
        break label338;
      }
      return;
      str1 = this.jdField_k_of_type_JavaLangString;
      break;
      label124:
      if (((String)localObject2).startsWith("bdapp"))
      {
        localObject1 = "bdapp://map/marker?location=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "&title=" + str1 + "&content=" + this.jdField_k_of_type_JavaLangString + "&src=tencent|qq&coord_type=gcj02";
      }
      else if (((String)localObject2).startsWith("androidamap"))
      {
        localObject1 = "androidamap://viewMap?sourceApplication=tencentqq&lat=" + this.jdField_a_of_type_Double + "&lon=" + this.jdField_b_of_type_Double + "&dev=0&style=0&poiname=" + str1;
      }
      else
      {
        localObject1 = localObject2;
        if (((String)localObject2).startsWith("geo:0,0")) {
          localObject1 = "geo:0,0?q=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "(" + str1 + ")";
        }
      }
    }
    label338:
    localObject2 = a();
    PackageManager localPackageManager = getPackageManager();
    boolean bool1 = a((List)localObject2, false);
    boolean bool2 = a(this.jdField_b_of_type_JavaUtilList, (List)localObject2);
    this.jdField_b_of_type_JavaUtilList = ((List)localObject2);
    Drawable localDrawable;
    Object localObject3;
    Object localObject4;
    label535:
    Object localObject5;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow = new SelectPicPopupWindow(getApplicationContext(), null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.a(getString(2131364029), 0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.a(getString(2131364030), 0, this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.b(getString(2131364031), 0, this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.a(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.setOnDismissListener(new etm(this));
      if (!bool1)
      {
        localDrawable = super.getResources().getDrawable(2130839296);
        localObject3 = super.getString(2131364032);
        localObject4 = super.getString(2131364033);
        if (!new File(QQMapConstants.i).exists()) {
          break label846;
        }
        localObject1 = super.getString(2131364035);
        localObject5 = "sosogeo://?q=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "(" + str1 + ")";
        this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.a(localDrawable, 1, (String)localObject3, (String)localObject4, 0, (String)localObject5, (String)localObject1);
        this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack = new etn(this);
      }
      localObject3 = ((List)localObject2).iterator();
    }
    label1082:
    for (;;)
    {
      label629:
      if (!((Iterator)localObject3).hasNext()) {
        break label1084;
      }
      localObject5 = (ResolveInfo)((Iterator)localObject3).next();
      String str2 = ((ResolveInfo)localObject5).activityInfo.packageName;
      localDrawable = null;
      localObject1 = null;
      localObject4 = ((ResolveInfo)localObject5).activityInfo.applicationInfo.loadLabel(localPackageManager);
      if (str2.equals(QQMapConstants.d))
      {
        localObject2 = getString(2131364033);
        localObject1 = "sosogeo://?q=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "(" + str1 + ")";
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label1082;
        }
        localDrawable = FileCategoryUtil.b(getApplicationContext(), ((ResolveInfo)localObject5).activityInfo.applicationInfo.publicSourceDir);
        this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.a(localDrawable, 0, ((CharSequence)localObject4).toString(), (String)localObject2, 1, (String)localObject1, null);
        break label629;
        if (bool2)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.showAtLocation(findViewById(2131300670), 17, 0, 0);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow = new SelectPicPopupWindow(getApplicationContext(), null);
        break;
        label846:
        localObject1 = super.getString(2131364034);
        break label535;
        if (str2.equals(QQMapConstants.e))
        {
          localObject1 = "androidamap://viewMap?sourceApplication=tencentqq&lat=" + this.jdField_a_of_type_Double + "&lon=" + this.jdField_b_of_type_Double + "&dev=0&style=0&poiname=" + str1;
          localObject2 = localDrawable;
        }
        else if (str2.equals(QQMapConstants.f))
        {
          localObject1 = "geo:0,0?q=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "(" + str1 + ")";
          localObject2 = localDrawable;
        }
        else
        {
          localObject2 = localDrawable;
          if (str2.equals(QQMapConstants.g))
          {
            localObject1 = "bdapp://map/marker?location=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "&title=" + str1 + "&content=" + this.jdField_k_of_type_JavaLangString + "&src=tencent|qq&coord_type=gcj02";
            localObject2 = localDrawable;
          }
        }
      }
    }
    label1084:
    this.jdField_a_of_type_ComTencentMobileqqWidgetSelectPicPopupWindow.showAtLocation(findViewById(2131300670), 17, 0, 0);
  }
  
  public void r()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_l_of_type_JavaLangString);
    localIntent.putExtra("reqType", 4);
    super.startActivity(localIntent);
    e();
  }
  
  public void s()
  {
    Object localObject = (TextView)findViewById(2131297357);
    ((TextView)localObject).setText(getIntent().getExtras().getString("leftViewText"));
    ((TextView)localObject).setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    localObject = (TextView)findViewById(2131297348);
    if ("group_activity".equals(this.jdField_s_of_type_JavaLangString))
    {
      ((TextView)localObject).setText("活动地点");
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297360));
      if (!this.jdField_k_of_type_Boolean) {
        break label238;
      }
      if (!this.jdField_n_of_type_Boolean) {
        break label184;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131366313);
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setTag(this.jdField_f_of_type_AndroidWidgetTextView.getText());
      this.jdField_f_of_type_AndroidWidgetTextView.postDelayed(new etr(this), 2000L);
      return;
      if (this.jdField_k_of_type_Boolean)
      {
        ((TextView)localObject).setText(2131366488);
        break;
      }
      ((TextView)localObject).setText(2131366567);
      break;
      label184:
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject = (ImageView)findViewById(2131297361);
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setImageResource(2130838415);
      ((ImageView)localObject).setContentDescription(getString(2131366569));
      ((ImageView)localObject).setOnClickListener(this.g);
    }
    label238:
    if ("group_activity".equals(this.jdField_s_of_type_JavaLangString)) {
      this.jdField_f_of_type_AndroidWidgetTextView.setText("确认");
    }
    for (;;)
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      break;
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131366313);
    }
  }
  
  public void t()
  {
    Object localObject2 = SubString.a(this.jdField_n_of_type_JavaLangString, 45, "UTF-8", "...");
    String str1 = SubString.a(this.jdField_k_of_type_JavaLangString, 90, "UTF-8", "...");
    Object localObject3 = "我在这里，点击查看：http://maps.google.com/maps?q=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "&iwloc=A&hl=zh-CN (" + str1 + ")";
    if (!getResources().getString(2131364171).equals(localObject2)) {}
    for (Object localObject1 = getResources().getString(2131368068) + " " + (String)localObject2;; localObject1 = getResources().getString(2131368068))
    {
      String str2 = "mqqapi://app/action?pkg=com.tencent.minihd.qq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=" + this.jdField_a_of_type_Double + "&lon=" + this.jdField_b_of_type_Double + "&title=" + (String)localObject2 + "&loc=" + str1;
      localObject1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(32).a((String)localObject1).d((String)localObject3).a("plugin", str2, str2, str2, str2).a();
      localObject3 = StructMsgElementFactory.a(2);
      ((AbsStructMsgItem)localObject3).a("https://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", (String)localObject2, str1);
      ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject3);
      localObject2 = new Intent(this, ForwardRecentActivity.class);
      ((Intent)localObject2).putExtra("forward_type", -3);
      ((Intent)localObject2).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      b(this, (Intent)localObject2, 0);
      return;
    }
  }
  
  public void u()
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      this.jdField_d_of_type_AndroidWidgetImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  public void v()
  {
    a(true);
  }
  
  public void w()
  {
    DialogUtil.a(this, 230).setTitle(getString(2131366980)).setMessage(2131365730).setPositiveButton(getString(2131366373), new eta(this)).show();
  }
  
  public void x()
  {
    this.jdField_l_of_type_Boolean = true;
    super.showDialog(1);
    if (!this.jdField_k_of_type_Boolean)
    {
      findViewById(2131300693).setVisibility(4);
      TextView localTextView = (TextView)findViewById(2131297360);
      localTextView.setVisibility(0);
      localTextView.setText(2131366941);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity
 * JD-Core Version:    0.7.0.1
 */