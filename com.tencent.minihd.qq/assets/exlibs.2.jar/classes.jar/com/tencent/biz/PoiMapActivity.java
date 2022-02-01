package com.tencent.biz;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cak;
import cal;
import cam;
import can;
import cao;
import cap;
import caq;
import car;
import cas;
import cat;
import cau;
import cav;
import caw;
import cax;
import cay;
import caz;
import cba;
import cbb;
import cbc;
import cbd;
import cbe;
import cbf;
import cbg;
import cbi;
import cbj;
import cbn;
import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.component.network.utils.PlatformUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.proto.lbsshare.LBSShare.DPBiz;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsResp;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsResp;
import com.tencent.proto.lbsshare.LBSShare.POI;
import com.tencent.proto.lbsshare.LBSShare.Shop;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PoiMapActivity
  extends QQMapActivity
  implements View.OnClickListener
{
  protected float a;
  protected int a;
  public GestureDetector a;
  public View.OnClickListener a;
  View.OnKeyListener jdField_a_of_type_AndroidViewView$OnKeyListener = new cao(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new cbe(this);
  public View a;
  public final ViewTreeObserver.OnPreDrawListener a;
  public EditText a;
  public ImageButton a;
  public ImageView a;
  public LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected AuthorizeConfig a;
  protected PoiMapActivity.PoiMapNameTask a;
  public PoiMapActivity.SearchResultAdapter a;
  public PoiMapActivity.ShopListAdapter a;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new cap(this);
  protected XListView a;
  public final String a;
  public List a;
  public boolean a;
  public PoiMapActivity.PoiTab[] a;
  public String[] a;
  protected int b;
  public View b;
  public ImageView b;
  public LinearLayout b;
  protected TextView b;
  public XListView b;
  public String b;
  public boolean b;
  public String[] b;
  protected int c;
  protected View c;
  public String c;
  public boolean c;
  protected int d;
  public View d;
  protected String d;
  protected boolean d;
  protected int e;
  protected View e;
  public boolean e;
  protected int f;
  protected View f;
  public boolean f;
  protected int g;
  View g;
  public boolean g;
  public int h;
  protected View h;
  protected boolean h;
  public int i;
  public View i;
  public boolean i;
  public int j;
  public boolean j;
  public int k;
  public int l;
  protected final int m = 10;
  protected final int n;
  public int o;
  public int p;
  public int q;
  public int r;
  public int s;
  protected int t;
  protected int u;
  public int v;
  public int w;
  
  public PoiMapActivity()
  {
    this.jdField_a_of_type_JavaLangString = "PoiMapActivity";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_n_of_type_Int = 20;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_o_of_type_Int = 0;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new car(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener = new cas(this);
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "全部", "写字楼", "小区", "商家" };
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[] { "", "281100|281200", "281000|281010|281011|281012|281013|281099", "100000|130000" };
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      if (paramBoolean)
      {
        localLayoutParams.topMargin += paramInt;
        this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      }
    }
    else
    {
      if (this.jdField_d_of_type_AndroidWidgetImageView != null)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
        if (!paramBoolean) {
          break label129;
        }
        localLayoutParams.topMargin += paramInt;
        label72:
        this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      }
      if (this.jdField_e_of_type_AndroidViewView != null)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
        if (!paramBoolean) {
          break label137;
        }
      }
    }
    label129:
    label137:
    for (localLayoutParams.topMargin += paramInt;; localLayoutParams.topMargin = (this.u + paramInt - this.t))
    {
      this.jdField_e_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.topMargin = paramInt;
      break;
      localLayoutParams.topMargin = paramInt;
      break label72;
    }
  }
  
  private void b(PoiMapActivity.POI paramPOI)
  {
    if (this.jdField_e_of_type_AndroidViewView == null) {}
    for (;;)
    {
      return;
      this.jdField_e_of_type_AndroidViewView.setVisibility(4);
      this.jdField_e_of_type_AndroidViewView.findViewById(2131300685).setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(null);
      ImageView localImageView = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131300685);
      localImageView.setVisibility(8);
      if ((paramPOI != null) && ((!TextUtils.isEmpty(paramPOI.g)) || (!TextUtils.isEmpty(paramPOI.jdField_d_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramPOI.e))))
      {
        ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131300686)).setText(paramPOI.jdField_a_of_type_JavaLangString);
        ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131300688)).setText(paramPOI.jdField_a_of_type_Int + "");
        Object localObject1 = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131300689);
        String str;
        if (!TextUtils.isEmpty(paramPOI.g))
        {
          ((TextView)localObject1).setText(super.getString(2131369245));
          localObject1 = paramPOI.g;
          str = "click_mall";
        }
        while (localObject1 != null)
        {
          Object localObject3 = "";
          Uri localUri = Uri.parse((String)localObject1);
          Object localObject2 = localObject3;
          if (localUri != null)
          {
            localObject2 = localObject3;
            if (localUri.isHierarchical()) {
              localObject2 = localUri.getQueryParameter("shop_id");
            }
          }
          if (((String)localObject1).equals(paramPOI.g)) {
            a("share_locate", "view_mall", paramPOI.jdField_c_of_type_JavaLangString, (String)localObject2, "0", "");
          }
          if (!TextUtils.isEmpty(paramPOI.i))
          {
            localObject3 = getResources().getDrawable(2130839252);
            int i1 = getResources().getDimensionPixelSize(2131493252);
            int i2 = getResources().getDimensionPixelSize(2131493253);
            localObject3 = URLDrawable.getDrawable(paramPOI.i, i1, i2, null, (Drawable)localObject3);
            if (localObject3 != null)
            {
              localImageView.setImageDrawable((Drawable)localObject3);
              localImageView.setVisibility(0);
            }
          }
          this.jdField_e_of_type_AndroidViewView.setVisibility(0);
          this.jdField_e_of_type_AndroidViewView.setOnClickListener(new cak(this, (String)localObject1, str, paramPOI, (String)localObject2));
          return;
          if (!TextUtils.isEmpty(paramPOI.jdField_d_of_type_JavaLangString))
          {
            ((TextView)localObject1).setText(super.getString(2131369246));
            localObject1 = paramPOI.jdField_d_of_type_JavaLangString;
            str = "click_share_tuan";
          }
          else if (!TextUtils.isEmpty(paramPOI.e))
          {
            ((TextView)localObject1).setText(super.getString(2131369247));
            localObject1 = paramPOI.e;
            str = "click_quan";
          }
          else
          {
            str = null;
            localObject1 = null;
          }
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131300670));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131298255);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131300672);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131300693);
    this.jdField_c_of_type_AndroidViewView.setVisibility(4);
    Object localObject = super.findViewById(2131300681);
    ((View)localObject).setContentDescription(getString(2131364129));
    ((View)localObject).setVisibility(0);
    ((View)localObject).setOnClickListener(this);
    if (this.jdField_k_of_type_Boolean)
    {
      a("rec_locate", "pageview_all", "", "", "", "");
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_j_of_type_AndroidViewView.findViewById(2131297913).setVisibility(0);
      this.jdField_j_of_type_AndroidViewView.findViewById(2131297914).setVisibility(0);
      ((View)localObject).setVisibility(8);
      if ((this.jdField_e_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.jdField_n_of_type_JavaLangString)))
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_n_of_type_JavaLangString);
      }
      j();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setOnTouchListener(new cav(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setLogoAnchor(2);
    }
    for (;;)
    {
      this.jdField_g_of_type_AndroidViewView = super.findViewById(2131297001);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131300675));
      super.findViewById(2131299461).setVisibility(8);
      localObject = (EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131299473);
      ((EditText)localObject).setFocusable(false);
      ((EditText)localObject).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      return;
      a("share_locate", "pageview_all", "", "", "", "");
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this, new cbc(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setOnTouchListener(new cbd(this));
      this.jdField_i_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131300673);
      this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
      h();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab == null) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length)) {
      return;
    }
    this.l = paramInt;
    int i2 = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
    int i1 = 0;
    label30:
    if (i1 < i2)
    {
      if (i1 != paramInt) {
        break label67;
      }
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].a(true);
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].b(true);
    }
    for (;;)
    {
      i1 += 1;
      break label30;
      break;
      label67:
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].a(false);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.getLbsShareShop");
    localIntent.putExtra("latitude", paramInt1);
    localIntent.putExtra("longitude", paramInt2);
    localIntent.putExtra("coordinate", 0);
    localIntent.putExtra("begin", paramInt3);
    localIntent.putExtra("count", paramInt4);
    super.sendBroadcast(localIntent);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.getLbsShareSearch");
    localIntent.putExtra("latitude", paramInt1);
    localIntent.putExtra("longitude", paramInt2);
    localIntent.putExtra("keyword", paramString1);
    localIntent.putExtra("category", paramString2);
    localIntent.putExtra("page", paramInt3);
    localIntent.putExtra("count", paramInt4);
    localIntent.putExtra("coordinate", 1);
    if ((paramInt3 == 0) && (TextUtils.isEmpty(paramString1))) {
      if (TextUtils.isEmpty(paramString2)) {
        localIntent.putExtra("requireMyLbs", 1);
      }
    }
    for (;;)
    {
      super.sendBroadcast(localIntent);
      return;
      localIntent.putExtra("requireMyLbs", 0);
    }
  }
  
  public void a(PoiMapActivity.POI paramPOI)
  {
    this.jdField_o_of_type_JavaLangString = paramPOI.jdField_b_of_type_JavaLangString;
    this.jdField_n_of_type_JavaLangString = paramPOI.jdField_a_of_type_JavaLangString;
    this.jdField_d_of_type_JavaLangString = paramPOI.jdField_c_of_type_JavaLangString;
    this.jdField_h_of_type_Int = paramPOI.jdField_b_of_type_Int;
    this.jdField_i_of_type_Int = paramPOI.jdField_c_of_type_Int;
    this.jdField_j_of_type_Int = this.jdField_h_of_type_Int;
    this.jdField_k_of_type_Int = this.jdField_i_of_type_Int;
    this.jdField_p_of_type_JavaLangString = paramPOI.f;
    this.jdField_b_of_type_JavaLangString = paramPOI.jdField_c_of_type_JavaLangString;
    this.jdField_d_of_type_Boolean = true;
    int i2 = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
    int i1 = 0;
    if (i1 < i2)
    {
      if (i1 == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(false);
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(0, false);
      }
      for (;;)
      {
        i1 += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].a(-1, false);
      }
    }
    a(0);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.animateTo(new GeoPoint(paramPOI.jdField_b_of_type_Int, paramPOI.jdField_c_of_type_Int));
  }
  
  protected void a(LBSShare.GetShopsByIdsResp paramGetShopsByIdsResp)
  {
    if (paramGetShopsByIdsResp == null) {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "onGetShareShopDetail null");
      }
    }
    int i1;
    label122:
    label252:
    do
    {
      do
      {
        return;
        i1 = paramGetShopsByIdsResp.ec.get();
        if (i1 != 0) {
          break;
        }
      } while (!paramGetShopsByIdsResp.shops.has());
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramGetShopsByIdsResp.shops.get().iterator();
      if (localIterator.hasNext())
      {
        LBSShare.DPBiz localDPBiz = (LBSShare.DPBiz)localIterator.next();
        PoiMapActivity.SingleShops localSingleShops = new PoiMapActivity.SingleShops(this);
        localSingleShops.jdField_a_of_type_Int = 1;
        if (localDPBiz.id.has())
        {
          paramGetShopsByIdsResp = localDPBiz.id.get();
          localSingleShops.h = paramGetShopsByIdsResp;
          if (!localDPBiz.name.has()) {
            break label378;
          }
          paramGetShopsByIdsResp = localDPBiz.name.get();
          localSingleShops.e = paramGetShopsByIdsResp;
          if (!localDPBiz.logo.has()) {
            break label384;
          }
          paramGetShopsByIdsResp = localDPBiz.logo.get();
          localSingleShops.f = paramGetShopsByIdsResp;
          if (!localDPBiz.url.has()) {
            break label390;
          }
          paramGetShopsByIdsResp = localDPBiz.url.get();
          localSingleShops.g = paramGetShopsByIdsResp;
          if (!localDPBiz.avg_price.has()) {
            break label396;
          }
          paramGetShopsByIdsResp = localDPBiz.avg_price.get();
          localSingleShops.jdField_b_of_type_JavaLangString = paramGetShopsByIdsResp;
          if (!localDPBiz.biz_zone.has()) {
            break label402;
          }
          paramGetShopsByIdsResp = localDPBiz.biz_zone.get();
          localSingleShops.jdField_c_of_type_JavaLangString = paramGetShopsByIdsResp;
          if (!localDPBiz.category.has()) {
            break label408;
          }
          paramGetShopsByIdsResp = localDPBiz.category.get();
          localSingleShops.jdField_a_of_type_JavaLangString = paramGetShopsByIdsResp;
          if (!localDPBiz.has_quan.has()) {
            break label414;
          }
          i1 = localDPBiz.has_quan.get();
          localSingleShops.jdField_c_of_type_Int = i1;
          if (!localDPBiz.has_tuan.has()) {
            break label419;
          }
          i1 = localDPBiz.has_tuan.get();
          localSingleShops.jdField_b_of_type_Int = i1;
          if (!localDPBiz.rate.has()) {
            break label424;
          }
        }
        for (i1 = localDPBiz.rate.get();; i1 = 0)
        {
          localSingleShops.jdField_d_of_type_Int = i1;
          localArrayList.add(localSingleShops);
          break;
          paramGetShopsByIdsResp = "";
          break label122;
          paramGetShopsByIdsResp = "";
          break label148;
          paramGetShopsByIdsResp = "";
          break label174;
          paramGetShopsByIdsResp = "";
          break label200;
          paramGetShopsByIdsResp = "";
          break label226;
          paramGetShopsByIdsResp = "";
          break label252;
          paramGetShopsByIdsResp = "";
          break label278;
          i1 = 0;
          break label304;
          i1 = 0;
          break label330;
        }
      }
      a(localArrayList);
      return;
    } while (!QLog.isColorLevel());
    label148:
    label174:
    label200:
    label226:
    label378:
    QLog.i("PoiMapActivity", 2, "onGetShareShopDetail error:" + i1);
    label278:
    label304:
    label330:
    return;
  }
  
  protected void a(LBSShare.LocationResp paramLocationResp, Bundle paramBundle)
  {
    if (paramLocationResp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "onGetLbsShareSearch null");
      }
      return;
    }
    int i6 = paramLocationResp.ec.get();
    boolean bool1;
    String str1;
    int i3;
    int i4;
    int i5;
    String str2;
    int i1;
    ArrayList localArrayList;
    if (paramLocationResp.is_foreign.get() == 1)
    {
      bool1 = true;
      this.jdField_j_of_type_Boolean = bool1;
      str1 = paramBundle.getString("keyword");
      i3 = paramBundle.getInt("latitude");
      i4 = paramBundle.getInt("longitude");
      i5 = paramBundle.getInt("page");
      str2 = paramBundle.getString("category");
      bool1 = false;
      if (i6 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PoiMapActivity", 2, "onGetLbsShareSearch error:" + i6);
        }
        QQToast.a(this, super.getString(2131369265), 0).a();
      }
      i1 = 0;
      i2 = 0;
      paramBundle = null;
      if (i6 != 0) {
        break label1497;
      }
      localArrayList = new ArrayList();
      if (!this.jdField_j_of_type_Boolean) {
        break label1026;
      }
      paramBundle = new GeoPoint(i3, i4);
      if (this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask != null) {
        break label882;
      }
    }
    for (;;)
    {
      Object localObject;
      PoiMapActivity.POI localPOI;
      try
      {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask = new PoiMapActivity.PoiMapNameTask(this);
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.a(paramBundle);
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.execute(new Void[0]);
        paramBundle = new PoiMapActivity.POI(this);
        paramBundle.jdField_a_of_type_JavaLangString = super.getResources().getString(2131369272);
        paramBundle.jdField_b_of_type_JavaLangString = "";
        this.jdField_o_of_type_JavaLangString = paramBundle.jdField_b_of_type_JavaLangString;
        paramBundle.jdField_b_of_type_Int = i3;
        paramBundle.jdField_c_of_type_Int = i4;
        paramBundle.jdField_d_of_type_JavaLangString = "";
        localArrayList.add(paramBundle);
        i1 = 1;
        if (!paramLocationResp.poilist.has()) {
          break label1418;
        }
        paramBundle = paramLocationResp.poilist.get();
        if (paramBundle.size() <= 0) {
          break label1327;
        }
        i1 = 1;
        bool1 = true;
        localObject = paramBundle.iterator();
        i2 = i1;
        bool2 = bool1;
        if (!((Iterator)localObject).hasNext()) {
          break label1424;
        }
        LBSShare.POI localPOI1 = (LBSShare.POI)((Iterator)localObject).next();
        localPOI = new PoiMapActivity.POI(this);
        if (!localPOI1.name.has()) {
          break label1335;
        }
        paramBundle = localPOI1.name.get();
        localPOI.jdField_a_of_type_JavaLangString = paramBundle;
        if (!localPOI1.shop_url.has()) {
          break label1341;
        }
        paramBundle = localPOI1.shop_url.get();
        localPOI.jdField_d_of_type_JavaLangString = paramBundle;
        if (!TextUtils.isEmpty(localPOI.jdField_d_of_type_JavaLangString)) {
          a("share_locate", "view_share_tuan", "", "", "", "");
        }
        if (!localPOI1.addr.has()) {
          break label1347;
        }
        paramBundle = localPOI1.addr.get();
        localPOI.jdField_b_of_type_JavaLangString = paramBundle;
        if (!localPOI1.lat.has()) {
          break label1353;
        }
        i2 = localPOI1.lat.get();
        localPOI.jdField_b_of_type_Int = i2;
        if (!localPOI1.lng.has()) {
          break label1359;
        }
        i2 = localPOI1.lng.get();
        localPOI.jdField_c_of_type_Int = i2;
        if (!localPOI1.id.has()) {
          break label1365;
        }
        paramBundle = localPOI1.id.get();
        localPOI.jdField_c_of_type_JavaLangString = paramBundle;
        if (!localPOI1.shop_url_quan.has()) {
          break label1371;
        }
        paramBundle = localPOI1.shop_url_quan.get();
        localPOI.e = paramBundle;
        if (!localPOI1.shop_count.has()) {
          break label1377;
        }
        i2 = localPOI1.shop_count.get();
        localPOI.jdField_a_of_type_Int = i2;
        if (!localPOI1.shangquan_url.has()) {
          break label1383;
        }
        paramBundle = localPOI1.shangquan_url.get();
        localPOI.g = paramBundle;
        if (!localPOI1.shangquan_wording.has()) {
          break label1389;
        }
        paramBundle = localPOI1.shangquan_wording.get();
        localPOI.h = paramBundle;
        if (!localPOI1.POI_preview_url.has()) {
          break label1395;
        }
        paramBundle = localPOI1.POI_preview_url.get();
        localPOI.i = paramBundle;
        if ((TextUtils.isEmpty(localPOI.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(localPOI.e))) {
          a("share_locate", "view_quan", "", "", "", "");
        }
        if (!localPOI1.dpid.has()) {
          break label1401;
        }
        paramBundle = localPOI1.dpid.get();
        localPOI.f = paramBundle;
        if ((!this.jdField_d_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || (!this.jdField_d_of_type_JavaLangString.equals(localPOI.jdField_c_of_type_JavaLangString))) {
          break label1407;
        }
        if (!localArrayList.isEmpty())
        {
          paramBundle = (PoiMapActivity.POI)localArrayList.get(0);
          if ((this.jdField_n_of_type_JavaLangString.equals(paramBundle.jdField_a_of_type_JavaLangString)) && (this.jdField_o_of_type_JavaLangString.equals(paramBundle.jdField_b_of_type_JavaLangString))) {
            localArrayList.remove(0);
          }
        }
        localArrayList.add(0, localPOI);
        continue;
        bool1 = false;
      }
      catch (RejectedExecutionException paramBundle)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PoiMapActivity", 2, paramBundle.getMessage());
        continue;
      }
      label882:
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.a = paramBundle;
      if (PlatformUtil.a() >= 11)
      {
        localObject = ((ThreadPoolExecutor)PoiMapActivity.PoiMapNameTask.THREAD_POOL_EXECUTOR).getQueue();
        if ((localObject != null) && (((BlockingQueue)localObject).size() > 0)) {
          ((BlockingQueue)localObject).removeAll((Collection)localObject);
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.getStatus() != AsyncTask.Status.FINISHED)
      {
        if (!this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.isCancelled()) {
          this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.cancel(true);
        }
      }
      else
      {
        try
        {
          localObject = new PoiMapActivity.PoiMapNameTask(this);
          ((PoiMapActivity.PoiMapNameTask)localObject).a(paramBundle);
          this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask = ((PoiMapActivity.PoiMapNameTask)localObject);
          this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.execute(new Void[0]);
        }
        catch (RejectedExecutionException paramBundle) {}
        if (QLog.isColorLevel())
        {
          QLog.d("PoiMapActivity", 2, paramBundle.getMessage());
          continue;
          label1026:
          i1 = i2;
          if (paramLocationResp.mylbs.has())
          {
            localObject = (LBSShare.POI)paramLocationResp.mylbs.get();
            localPOI = new PoiMapActivity.POI(this);
            if (((LBSShare.POI)localObject).name.has())
            {
              paramBundle = ((LBSShare.POI)localObject).name.get();
              label1081:
              localPOI.jdField_a_of_type_JavaLangString = paramBundle;
              if (!((LBSShare.POI)localObject).shop_url.has()) {
                break label1278;
              }
              paramBundle = ((LBSShare.POI)localObject).shop_url.get();
              label1107:
              localPOI.jdField_d_of_type_JavaLangString = paramBundle;
              if (!((LBSShare.POI)localObject).addr.has()) {
                break label1284;
              }
              paramBundle = ((LBSShare.POI)localObject).addr.get();
              label1133:
              localPOI.jdField_b_of_type_JavaLangString = paramBundle;
              if (!((LBSShare.POI)localObject).lat.has()) {
                break label1290;
              }
              i1 = ((LBSShare.POI)localObject).lat.get();
              label1159:
              localPOI.jdField_b_of_type_Int = i1;
              if (!((LBSShare.POI)localObject).lng.has()) {
                break label1295;
              }
              i1 = ((LBSShare.POI)localObject).lng.get();
              label1185:
              localPOI.jdField_c_of_type_Int = i1;
              if ((!this.jdField_d_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_n_of_type_JavaLangString))) {
                break label1300;
              }
              localPOI.jdField_a_of_type_JavaLangString = this.jdField_n_of_type_JavaLangString;
              localPOI.jdField_d_of_type_JavaLangString = "";
              localPOI.jdField_b_of_type_JavaLangString = this.jdField_o_of_type_JavaLangString;
              localPOI.jdField_b_of_type_Int = this.jdField_h_of_type_Int;
              localPOI.jdField_c_of_type_Int = this.jdField_i_of_type_Int;
            }
            for (;;)
            {
              localArrayList.add(localPOI);
              i1 = 1;
              break;
              paramBundle = super.getResources().getString(2131369272);
              break label1081;
              label1278:
              paramBundle = "";
              break label1107;
              label1284:
              paramBundle = "";
              break label1133;
              label1290:
              i1 = 0;
              break label1159;
              label1295:
              i1 = 0;
              break label1185;
              label1300:
              localPOI.jdField_a_of_type_JavaLangString = super.getResources().getString(2131369272);
              this.jdField_o_of_type_JavaLangString = localPOI.jdField_b_of_type_JavaLangString;
            }
            label1327:
            i1 = 0;
            bool1 = false;
            continue;
            label1335:
            paramBundle = "";
            continue;
            label1341:
            paramBundle = "";
            continue;
            label1347:
            paramBundle = "";
            continue;
            label1353:
            i2 = 0;
            continue;
            label1359:
            i2 = 0;
            continue;
            label1365:
            paramBundle = "";
            continue;
            label1371:
            paramBundle = "";
            continue;
            label1377:
            i2 = 0;
            continue;
            label1383:
            paramBundle = "";
            continue;
            label1389:
            paramBundle = "";
            continue;
            label1395:
            paramBundle = "";
            continue;
            label1401:
            paramBundle = "";
            continue;
            label1407:
            localArrayList.add(localPOI);
          }
        }
      }
    }
    label1418:
    boolean bool2 = false;
    int i2 = i1;
    label1424:
    if (paramLocationResp.next.has())
    {
      i1 = paramLocationResp.next.get();
      paramLocationResp = localArrayList;
      bool1 = bool2;
    }
    for (;;)
    {
      if (i2 == 0) {}
      for (bool2 = true;; bool2 = false)
      {
        runOnUiThread(new caq(this, bool1, str2, str1, paramLocationResp, i1, i3, i4, i5, bool2));
        return;
        i1 = 0;
        break;
      }
      label1497:
      i2 = 0;
      paramLocationResp = paramBundle;
    }
  }
  
  protected void a(LBSShare.NearByShopsResp paramNearByShopsResp, Bundle paramBundle)
  {
    if (paramNearByShopsResp == null) {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "onGetLbsShareShop null");
      }
    }
    int i1;
    label79:
    label113:
    label249:
    label380:
    do
    {
      return;
      i1 = paramNearByShopsResp.ec.get();
      if (i1 == 0)
      {
        int i4 = paramBundle.getInt("begin", 0);
        int i2;
        LBSShare.Shop localShop;
        PoiMapActivity.GeneralShops localGeneralShops;
        if (paramNearByShopsResp.next_begin.has())
        {
          i1 = paramNearByShopsResp.next_begin.get();
          if (!paramNearByShopsResp.total.has()) {
            break label430;
          }
          i2 = paramNearByShopsResp.total.get();
          paramBundle = null;
          if (!paramNearByShopsResp.poilist.has()) {
            break label496;
          }
          paramBundle = new ArrayList();
          Iterator localIterator = paramNearByShopsResp.poilist.get().iterator();
          if (!localIterator.hasNext()) {
            break label496;
          }
          localShop = (LBSShare.Shop)localIterator.next();
          localGeneralShops = new PoiMapActivity.GeneralShops(this);
          localGeneralShops.jdField_a_of_type_Int = 1;
          if (!localShop.id.has()) {
            break label436;
          }
          paramNearByShopsResp = localShop.id.get();
          localGeneralShops.h = paramNearByShopsResp;
          if (!localShop.name.has()) {
            break label442;
          }
          paramNearByShopsResp = localShop.name.get();
          localGeneralShops.e = paramNearByShopsResp;
          if (!localShop.logo.has()) {
            break label448;
          }
          paramNearByShopsResp = localShop.logo.get();
          localGeneralShops.f = paramNearByShopsResp;
          if (!localShop.url.has()) {
            break label454;
          }
          paramNearByShopsResp = localShop.url.get();
          localGeneralShops.g = paramNearByShopsResp;
          if (!localShop.detail.has()) {
            break label460;
          }
          paramNearByShopsResp = localShop.detail.get();
          localGeneralShops.jdField_a_of_type_JavaLangString = paramNearByShopsResp;
          if (!localShop.discount.has()) {
            break label466;
          }
          paramNearByShopsResp = localShop.discount.get();
          localGeneralShops.jdField_b_of_type_JavaLangString = paramNearByShopsResp;
          if (!localShop.price.has()) {
            break label472;
          }
          paramNearByShopsResp = localShop.price.get();
          localGeneralShops.jdField_c_of_type_JavaLangString = paramNearByShopsResp;
          if (!localShop.soldnum.has()) {
            break label478;
          }
          paramNearByShopsResp = localShop.soldnum.get();
          localGeneralShops.jdField_d_of_type_JavaLangString = paramNearByShopsResp;
          if (!localShop.has_tuan.has()) {
            break label484;
          }
          i3 = localShop.has_tuan.get();
          localGeneralShops.jdField_b_of_type_Int = i3;
          if (!localShop.has_quan.has()) {
            break label490;
          }
        }
        for (int i3 = localShop.has_quan.get();; i3 = 0)
        {
          localGeneralShops.jdField_c_of_type_Int = i3;
          paramBundle.add(localGeneralShops);
          break label113;
          i1 = 0;
          break;
          i2 = 0;
          break label79;
          paramNearByShopsResp = "";
          break label171;
          paramNearByShopsResp = "";
          break label197;
          paramNearByShopsResp = "";
          break label223;
          paramNearByShopsResp = "";
          break label249;
          paramNearByShopsResp = "";
          break label275;
          paramNearByShopsResp = "";
          break label301;
          paramNearByShopsResp = "";
          break label327;
          paramNearByShopsResp = "";
          break label353;
          i3 = 0;
          break label380;
        }
        a(paramBundle, i2, i4, i1);
        return;
      }
    } while (!QLog.isColorLevel());
    label171:
    label197:
    label223:
    label353:
    label484:
    label490:
    label496:
    QLog.i("PoiMapActivity", 2, "onGetLbsShareShop error:" + i1);
    label275:
    label301:
    label327:
    label460:
    label466:
    label472:
    label478:
    return;
  }
  
  protected void a(GeoPoint paramGeoPoint)
  {
    int i1 = paramGeoPoint.getLatitudeE6();
    int i2 = paramGeoPoint.getLongitudeE6();
    super.a(paramGeoPoint);
    if (QLog.isColorLevel()) {
      QLog.d("PoiMapActivity", 2, "lat=" + i1 + ", lon=" + i2);
    }
    this.jdField_n_of_type_JavaLangString = "";
    this.jdField_h_of_type_Int = i1;
    this.jdField_i_of_type_Int = i2;
    this.jdField_j_of_type_Int = this.jdField_h_of_type_Int;
    this.jdField_k_of_type_Int = this.jdField_i_of_type_Int;
    this.jdField_d_of_type_Boolean = false;
    i2 = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
    i1 = 0;
    if (i1 < i2)
    {
      if (i1 == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(false);
        if (this.jdField_h_of_type_Boolean) {
          this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(-1, false);
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(0, false);
        continue;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].a(-1, true);
      }
    }
    this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[this.l].b(true);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131369243));
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_o_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    a(this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, paramString, "", 0, 20);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter.notifyDataSetChanged();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  public void a(String paramString, List paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_e_of_type_Boolean = paramBoolean;
      this.jdField_g_of_type_Boolean = false;
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break label152;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131366465));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter.notifyDataSetChanged();
      return;
      if (this.jdField_o_of_type_Int == 0) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        a("share_locate", "click_sch", paramString, "0", "", "");
        break;
      }
      a("share_locate", "click_sch", paramString, "1", "", "");
      break;
      label152:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter.a(paramArrayList, true, 0, 0, false);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter.jdField_d_of_type_Int = 1;
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(super.getResources().getString(2131369352));
    this.q = super.getResources().getDimensionPixelSize(2131493256);
    k();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArrayList == null) {
      return;
    }
    boolean bool;
    if ((paramInt3 > 0) && (paramInt3 < paramInt1)) {
      bool = true;
    }
    for (;;)
    {
      if (paramInt2 == 0)
      {
        if ((paramInt1 <= 0) || (this.jdField_d_of_type_AndroidViewView == null)) {
          break;
        }
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(super.getResources().getString(2131369242, new Object[] { String.valueOf(paramInt1) }));
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter.a(paramArrayList, true, paramInt2, paramInt3, bool);
        if (paramInt1 < 3)
        {
          this.q = (super.getResources().getDimensionPixelSize(2131493256) * paramInt1);
          return;
          bool = false;
        }
        else
        {
          this.q = this.jdField_p_of_type_Int;
          return;
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter.a(paramArrayList, false, paramInt2, paramInt3, bool);
  }
  
  public void a(ArrayList paramArrayList, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if ((this.jdField_h_of_type_Int != paramInt1) && (this.jdField_i_of_type_Int != paramInt2)) {}
    label130:
    for (;;)
    {
      return;
      paramInt2 = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= paramInt2) {
          break label130;
        }
        if (this.jdField_b_of_type_ArrayOfJavaLangString[paramInt1].equals(paramString))
        {
          paramString = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[paramInt1];
          if (paramInt3 != 0) {}
          for (boolean bool = true;; bool = false)
          {
            paramString.a(paramArrayList, bool, paramInt4, paramBoolean);
            if ((paramInt1 != 0) || (!this.jdField_h_of_type_Boolean)) {
              break;
            }
            if ((paramArrayList == null) || (paramArrayList.size() <= 1)) {
              break label113;
            }
            this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(1, true);
            return;
          }
          label113:
          this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(0, true);
          return;
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void b()
  {
    this.jdField_i_of_type_Boolean = false;
    Dialog localDialog = new Dialog(this);
    localDialog.setCanceledOnTouchOutside(true);
    InputMethodManager localInputMethodManager = (InputMethodManager)super.getSystemService("input_method");
    int i1 = this.jdField_g_of_type_AndroidViewView.getHeight();
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
    ((TranslateAnimation)localObject1).setDuration(300L);
    ((TranslateAnimation)localObject1).setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject1);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setSoftInputMode(36);
    localDialog.setContentView(2130904393);
    Object localObject2 = localDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject2).x = 0;
    ((WindowManager.LayoutParams)localObject2).y = 0;
    ((WindowManager.LayoutParams)localObject2).dimAmount = 0.0F;
    ((WindowManager.LayoutParams)localObject2).width = -1;
    ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject2).gravity = 51;
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable(-419430401));
    localObject2 = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(300L);
    cbf localcbf = new cbf(this, (TranslateAnimation)localObject1, localDialog, i1, (TranslateAnimation)localObject2);
    ((TranslateAnimation)localObject1).setAnimationListener(localcbf);
    ((TranslateAnimation)localObject2).setAnimationListener(localcbf);
    localDialog.setOnDismissListener(new cbg(this, (TranslateAnimation)localObject2, localInputMethodManager));
    this.jdField_h_of_type_AndroidViewView = localDialog.findViewById(2131296742);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localDialog.findViewById(2131299473));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new cbn(this, null));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this.jdField_a_of_type_AndroidViewView$OnKeyListener);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localDialog.findViewById(2131299465));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new cbi(this));
    localObject1 = (Button)localDialog.findViewById(2131299461);
    ((Button)localObject1).setVisibility(0);
    ((Button)localObject1).setOnClickListener(new cbj(this, localDialog));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localDialog.findViewById(2131297286));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localDialog.findViewById(2131297284));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new cal(this, localDialog));
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)localDialog.findViewById(2131302032));
    this.jdField_b_of_type_ComTencentWidgetXListView.setBackgroundDrawable(super.getResources().getDrawable(2130837687));
    this.jdField_b_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter = new PoiMapActivity.SearchResultAdapter(this, this);
    this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter);
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(new cam(this, localInputMethodManager));
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnItemClickListener(new can(this, localDialog));
    if (1 == OfflineDownloader.a(getApplicationContext())) {}
    for (this.jdField_f_of_type_Boolean = true;; this.jdField_f_of_type_Boolean = false)
    {
      this.jdField_c_of_type_Boolean = true;
      return;
    }
  }
  
  protected void b(String paramString)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.getShareShopDetail");
    localIntent.putExtra("shop_id", paramString);
    super.sendBroadcast(localIntent);
  }
  
  protected void c()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      a("rec_locate", "click_rec_return", "", "", "", "");
      return;
    }
    a("share_locate", "click_rec_return", "", "", "", "");
  }
  
  protected void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMapCenter();
    double d1 = ((GeoPoint)localObject).getLatitudeE6() / 1000000.0D;
    double d2 = ((GeoPoint)localObject).getLongitudeE6() / 1000000.0D;
    String str2 = String.valueOf(d1) + "," + String.valueOf(d2);
    String str3;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject = "0";
      str3 = this.l + 1 + "";
      if (!this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[this.l].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Boolean) {
        break label198;
      }
    }
    label198:
    for (String str1 = "2";; str1 = "1")
    {
      a("share_locate", "click_send", str2, (String)localObject, str3, str1);
      if (this.jdField_j_of_type_Boolean)
      {
        a("rec_locate", "send_googlestation", "", "", "", "");
        a("rec_locate", "send_foursquare", "", "", "", "");
      }
      return;
      localObject = this.jdField_b_of_type_JavaLangString;
      break;
    }
  }
  
  protected void e()
  {
    a("rec_locate", "click_view", "", "", "", "");
  }
  
  protected void f()
  {
    super.f();
    String str = "{" + "\"id\":\"" + this.jdField_b_of_type_JavaLangString + "\"," + "\"title\":\"" + this.jdField_n_of_type_JavaLangString + "\"," + "\"address\":\"" + this.jdField_o_of_type_JavaLangString + "\"," + "\"location\":{" + "\"lat\":\"" + this.jdField_j_of_type_Int * 1.0F / 1000000.0D + "\"," + "\"lon\":\"" + this.jdField_k_of_type_Int * 1.0F / 1000000.0D + "\"" + "}" + "}";
    Intent localIntent = new Intent();
    localIntent.putExtra("result", str);
    setResult(-1, localIntent);
    finish();
  }
  
  protected void g()
  {
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    Object localObject2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("poi_category", "");
    Object localObject1;
    String[] arrayOfString;
    int i1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = null;
      try
      {
        localObject2 = new JSONArray((String)localObject2);
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          try
          {
            int i2;
            localObject3 = localObject1.getJSONObject(i1);
            str = ((JSONObject)localObject3).getString("name");
            localObject3 = ((JSONObject)localObject3).getString("id");
            localObject2[i1] = str;
            arrayOfString[i1] = localObject3;
            i1 += 1;
          }
          catch (JSONException localJSONException1)
          {
            localJSONException1.printStackTrace();
            i1 = 1;
          }
          localJSONException2 = localJSONException2;
          localJSONException2.printStackTrace();
        }
      }
      if ((localObject1 != null) && (localObject1.length() > 0))
      {
        i2 = localObject1.length();
        localObject2 = new String[i2];
        arrayOfString = new String[i2];
        i1 = 0;
        if (i1 >= i2) {
          break label198;
        }
      }
    }
    for (;;)
    {
      Object localObject3;
      String str;
      if (i1 == 0)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = localJSONException2;
        this.jdField_b_of_type_ArrayOfJavaLangString = arrayOfString;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("PoiMapActivity", 4, "mTabName:" + this.jdField_a_of_type_ArrayOfJavaLangString.toString());
      }
      return;
      label198:
      i1 = 0;
    }
  }
  
  public void h()
  {
    this.s = super.getResources().getDimensionPixelSize(2131493245);
    this.v = super.getResources().getDimensionPixelSize(2131493247);
    this.w = super.getResources().getDimensionPixelSize(2131493243);
    this.t = super.getResources().getDimensionPixelSize(2131493250);
    this.u = super.getResources().getDimensionPixelSize(2131493251);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131300676));
    this.jdField_e_of_type_AndroidViewView = super.findViewById(2131300684);
    this.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_c_of_type_Int);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(null);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(this.jdField_d_of_type_Int);
    this.jdField_e_of_type_AndroidViewView.setVisibility(4);
    if (this.jdField_r_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.jdField_o_of_type_AndroidViewView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      this.jdField_o_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    Object localObject = (FrameLayout)super.findViewById(2131300677);
    this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab = new PoiMapActivity.PoiTab[this.jdField_a_of_type_ArrayOfJavaLangString.length];
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -1);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams1.weight = 1.0F;
    int i2 = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      PoiMapActivity.PoiTab localPoiTab = new PoiMapActivity.PoiTab(this, this, this.jdField_a_of_type_ArrayOfJavaLangString[i1], i1);
      if (i1 == 0)
      {
        localPoiTab.a(true);
        localPoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Int = 0;
      }
      if (i1 == i2 - 1) {
        localPoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView.a();
      }
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1] = localPoiTab;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localPoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView, localLayoutParams1);
      ((FrameLayout)localObject).addView(localPoiTab.jdField_a_of_type_ComTencentWidgetXListView, localLayoutParams2);
      i1 += 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getViewTreeObserver().addOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    }
    if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    }
  }
  
  protected void i()
  {
    super.i();
    this.jdField_c_of_type_AndroidViewView.setVisibility(4);
  }
  
  protected void j()
  {
    this.jdField_p_of_type_Int = super.getResources().getDimensionPixelSize(2131493254);
    this.jdField_d_of_type_AndroidViewView = super.findViewById(2131300698);
    this.jdField_f_of_type_AndroidViewView = super.findViewById(2131300699);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131300701));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131300700));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131300702));
    this.jdField_d_of_type_AndroidViewView.setBackgroundColor(this.jdField_c_of_type_Int);
    this.jdField_f_of_type_AndroidViewView.setBackgroundDrawable(null);
    this.jdField_f_of_type_AndroidViewView.setBackgroundResource(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter = new PoiMapActivity.ShopListAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new cat(this));
    if (!TextUtils.isEmpty(this.jdField_p_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter.a(this.jdField_p_of_type_JavaLangString);
      a("rec_locate", "view_shangjia", this.jdField_p_of_type_JavaLangString, "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new cau(this));
      return;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter.a();
      a("rec_locate", "view_near_food", "", "", "", "");
    }
  }
  
  protected void k()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.q);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new caw(this));
    this.jdField_d_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
  }
  
  public void l()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.q);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new cax(this));
    this.jdField_d_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
  }
  
  public void m()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while ((this.s <= 0) || (this.jdField_r_of_type_Int <= 0)) {
      return;
    }
    ValueAnimation localValueAnimation = new ValueAnimation(Integer.valueOf(this.jdField_r_of_type_Int + this.s), Integer.valueOf(this.jdField_r_of_type_Int), new cay(this));
    localValueAnimation.setDuration(300L);
    localValueAnimation.setFillAfter(true);
    localValueAnimation.setAnimationListener(new caz(this));
    this.jdField_o_of_type_AndroidViewView.startAnimation(localValueAnimation);
  }
  
  public void n()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    while ((this.s <= 0) || (this.jdField_r_of_type_Int <= 0)) {
      return;
    }
    ValueAnimation localValueAnimation = new ValueAnimation(Integer.valueOf(this.jdField_r_of_type_Int), Integer.valueOf(this.jdField_r_of_type_Int + this.s), new cba(this));
    localValueAnimation.setDuration(300L);
    localValueAnimation.setFillAfter(true);
    localValueAnimation.setAnimationListener(new cbb(this));
    this.jdField_o_of_type_AndroidViewView.startAnimation(localValueAnimation);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      a(true);
      if (this.jdField_k_of_type_Boolean)
      {
        a("rec_locate", "click_locate_rec", "", "", "", "");
        return;
      }
      a("share_locate", "click_locate_share", "", "", "", "");
      return;
      if (this.jdField_a_of_type_Boolean) {
        l();
      }
      for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
      {
        a("rec_locate", "click_near_food", "", "", "", "");
        return;
        k();
      }
    } while (this.jdField_b_of_type_Boolean);
    m();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId")))
    {
      this.jdField_a_of_type_Int = super.getResources().getColor(2131427972);
      this.jdField_b_of_type_Int = super.getResources().getColor(2131427934);
      this.jdField_c_of_type_Int = super.getResources().getColor(2131427562);
      this.jdField_d_of_type_Int = 2130841855;
      this.jdField_e_of_type_Int = 2130838123;
    }
    for (this.jdField_f_of_type_Int = 2130839558;; this.jdField_f_of_type_Int = 2130839559)
    {
      this.jdField_g_of_type_Int = Color.rgb(0, 121, 255);
      this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
      g();
      a();
      return;
      this.jdField_a_of_type_Int = super.getResources().getColor(2131427974);
      this.jdField_b_of_type_Int = super.getResources().getColor(2131427937);
      this.jdField_c_of_type_Int = super.getResources().getColor(2131427559);
      this.jdField_d_of_type_Int = 2130841856;
      this.jdField_e_of_type_Int = 2130838124;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity
 * JD-Core Version:    0.7.0.1
 */