package com.tencent.mobileqq.troop.activity;

import NearbyGroup.RspActivity;
import NearbyGroup.RspGetNearbyGroup;
import NearbyGroup.RspHotGrp;
import NearbyGroup.RspTopic;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.activity.TroopNearByBigMapActivity;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper;
import com.tencent.mobileqq.troop.data.GroupAreaWrapper;
import com.tencent.mobileqq.troop.data.GroupAreaWrapper.ActivityInfo;
import com.tencent.mobileqq.troop.data.GroupAreaWrapper.TopicInfo;
import com.tencent.mobileqq.troop.data.NearbyTroopsExpandableListViewAdapter;
import com.tencent.mobileqq.troop.widget.NearbyTroopsExpandableListView;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.HorizontalScrollLayout;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import kdg;
import kdi;
import kdj;
import kdl;
import kdm;
import kdn;
import kdo;
import kdp;
import kdq;
import kdr;
import kdu;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.cs.nearby_troop_activity.nearby_troop_activity.ActivityDigest;
import tencent.im.cs.nearby_troop_activity.nearby_troop_activity.RspBody;
import tencent.im.cs.nearby_troop_hot.nearby_troop_hot.HotQunMsg;
import tencent.im.cs.nearby_troop_hot.nearby_troop_hot.HotQunRsp;
import tencent.im.cs.nearby_troop_hot.nearby_troop_hot.QunInfo;
import tencent.im.cs.nearby_troop_hot.nearby_troop_hot.RetInfo;
import tencent.im.cs.nearby_troop_post.nearby_troop_post.RspBody;
import tencent.im.cs.nearby_troop_post.nearby_troop_post.RspNearbyPostInfo;
import tencent.im.group.nearbybanner.nearbybanner.BannerInfo;
import tencent.im.group.nearbybanner.nearbybanner.CreateGroupBanner;
import tencent.im.group.nearbybanner.nearbybanner.RecommGroupBanner;
import tencent.im.group.nearbybanner.nearbybanner.SearchBanner;
import tencent.im.group.nearbybanner.nearbybanner.SetGroupBanner;
import tencent.im.group.nearbybanner.nearbybanner.WebBanner;

public class NearbyTroopsView
  extends NearbyTroopsBaseView
  implements View.OnClickListener, OverScrollViewListener
{
  public static final int A = 0;
  public static final int B = 1;
  public static final int F = -1;
  public static final int G = 0;
  public static final String a = "NearByTroop";
  public static final String b = "banner_url";
  public static final String c;
  public static final String f = "NearbyTroopsActivity";
  public static final boolean f = true;
  public static final String g = "near_troop_last_refresh_time";
  public static final int h = 1000;
  public static final String h = "lat";
  public static final int i = 100;
  public static final String i = "lon";
  public static final int j = 99;
  public static final String j = "from";
  public static final String k = "mode";
  public static final int l = 1000;
  public static final String l = "_nearby_troops_5_0.nb";
  public static final int m = 800;
  public static final String m = "need_to_show_map_entrance";
  public static final int n = 2;
  public static final String n = "is_show_mapentry";
  public static final int o = 3;
  protected static final String o = "https://qun.qq.com/search/mobileqq/nearbyGroupClassify.json";
  public static final int p = 4;
  public static final String p = "https://qun.qq.com/qqweb/m/qun/search/index.html?_wv=1031&_bid=347";
  public static final int q = 0;
  public static final String q = "location_name";
  public static final int r = 1;
  public static final int s = 5;
  protected static final String s = "nearby_group_classify_last_modify_time";
  public static final int t = 1;
  protected static final String t = "nearby_group_classify_sp";
  public static final int u = 2;
  protected static final String u = "nearby_group_classify_content";
  public static final int v = 3;
  public static final String v = "filter_id";
  public static final int w = 4;
  private static final String w = "classify_json_data";
  public static final int x = 5;
  private static final String x = "last_modify";
  public static final int y = 6;
  public static final int z = 7;
  public int C = 0;
  protected int D = 0;
  protected int E = 1;
  public int a;
  public Context a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public GestureDetector a;
  private View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new kdo(this);
  View jdField_a_of_type_AndroidViewView;
  public ViewTreeObserver.OnGlobalLayoutListener a;
  Button jdField_a_of_type_AndroidWidgetButton;
  public EditText a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  public LBSObserver a;
  public NearbyTroopsView.UIHandler a;
  public NearbyTroopsExpandableListViewAdapter a;
  public NearbyTroopsExpandableListView a;
  HorizontalScrollLayout jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout;
  public PullRefreshHeader a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new kdl(this);
  public ArrayList a;
  private nearbybanner.BannerInfo jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo = null;
  public boolean a;
  public String[] a;
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  protected TextView b;
  public ArrayList b;
  public int c;
  View c;
  public RelativeLayout c;
  public ArrayList c;
  public int d;
  public View d;
  public String d;
  public boolean d;
  public int e;
  public View e;
  public String e;
  public boolean e;
  public int f;
  public View f;
  public int g;
  protected View g;
  public boolean g;
  public boolean h = false;
  boolean i = false;
  public boolean j = false;
  protected int k;
  public boolean k;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private boolean o = true;
  public String r;
  
  static
  {
    jdField_c_of_type_JavaLangString = AppConstants.aG + "qbiz/troop/banner_data";
  }
  
  public NearbyTroopsView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_e_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_g_of_type_Int = 0;
    this.jdField_g_of_type_AndroidViewView = null;
    this.jdField_k_of_type_Int = 0;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetEditText = null;
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new kdi(this);
    this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new kdj(this);
  }
  
  private String a()
  {
    String str = null;
    SharedPreferences localSharedPreferences = a().getSharedPreferences("nearby_group_classify_sp", 0);
    if (localSharedPreferences != null) {
      str = localSharedPreferences.getString("nearby_group_classify_content", null);
    }
    return str;
  }
  
  private void a(int paramInt, Bitmap paramBitmap)
  {
    if (paramInt != 0) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "grp_tab", "exp_banner", 0, 0, "", "", "", "");
    paramInt = paramBitmap.getHeight();
    this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setSelectionFromTop(0, -this.jdField_c_of_type_AndroidWidgetRelativeLayout.getTop());
    this.jdField_b_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnGlobalLayoutListener(new kdg(this, paramInt));
    ThreadPriorityManager.a(true);
  }
  
  private void a(ViewGroup paramViewGroup, JSONObject paramJSONObject)
  {
    int i2 = 0;
    if ((paramViewGroup == null) || (paramJSONObject == null)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          JSONArray localJSONArray = paramJSONObject.getJSONArray("content");
          paramJSONObject = paramJSONObject.optJSONObject("moreItem");
          if (paramJSONObject != null) {
            localJSONArray.put(paramJSONObject);
          }
          if (localJSONArray.length() != 0)
          {
            int i1 = localJSONArray.length();
            int i3 = SizeMeasure.e(getContext());
            if (i1 <= 4)
            {
              i1 = i3 / 4;
              paramJSONObject = new LinearLayout.LayoutParams(-1, -2);
              paramJSONObject.setMargins(0, 0, 0, 0);
              paramViewGroup.setLayoutParams(paramJSONObject);
            }
            for (;;)
            {
              this.jdField_k_of_type_Int = i1;
              paramViewGroup.removeAllViews();
              while (i2 < localJSONArray.length())
              {
                Object localObject = localJSONArray.getJSONObject(i2);
                paramJSONObject = new kdr(null);
                paramJSONObject.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("cid");
                paramJSONObject.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("icon_url");
                paramJSONObject.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).getString("jump_url");
                paramJSONObject.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).getString("wording");
                paramJSONObject.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("order");
                paramJSONObject.jdField_c_of_type_Int = ((JSONObject)localObject).getInt("type");
                if (paramJSONObject.jdField_a_of_type_Int == 99)
                {
                  localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903706, null);
                  a(paramJSONObject, (View)localObject, i1);
                  ((View)localObject).setVisibility(8);
                  paramViewGroup.addView((View)localObject);
                  this.jdField_g_of_type_AndroidViewView = ((View)localObject);
                }
                localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903706, null);
                a(paramJSONObject, (View)localObject, i1);
                paramViewGroup.addView((View)localObject);
                i2 += 1;
              }
              i1 = i3 * 2 / 9;
            }
            paramViewGroup.invalidate();
            return;
          }
        }
        catch (JSONException paramViewGroup) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("NearbyTroopsActivity", 2, "fillClassifyContent==>JSONException");
  }
  
  private void a(kdr paramkdr, View paramView, int paramInt)
  {
    if ((paramkdr == null) || (paramView == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("NearbyTroopsActivity", 2, "fillEachClassifyItem==> item == null || itemView == null");
      }
      return;
    }
    Object localObject2 = null;
    ImageView localImageView = (ImageView)paramView.findViewById(2131299367);
    if (0 == 0) {
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839489);
    }
    String str = paramkdr.jdField_a_of_type_JavaLangString;
    Object localObject3 = paramkdr.jdField_c_of_type_JavaLangString;
    Object localObject1 = localObject3;
    if (localObject3 != null)
    {
      localObject1 = localObject3;
      if (4 < ((String)localObject3).length()) {
        localObject1 = ((String)localObject3).substring(0, 4);
      }
    }
    try
    {
      localObject3 = new URL(str);
      localObject2 = URLDrawable.getDrawable(new URL("third_part", ((URL)localObject3).getAuthority(), ((URL)localObject3).getFile()), (Drawable)localObject2, (Drawable)localObject2);
      if (localObject2 != null) {
        localImageView.setImageDrawable((Drawable)localObject2);
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        localMalformedURLException.printStackTrace();
      }
    }
    localObject2 = (TextView)paramView.findViewById(2131299368);
    ((TextView)localObject2).setText((CharSequence)localObject1);
    if (paramkdr.jdField_a_of_type_Int == this.D)
    {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130839504);
    }
    paramView.setTag(new kdu(this, 5, paramkdr));
    paramView.setOnClickListener(this);
    paramView.setContentDescription(String.format(a().getString(2131364142), new Object[] { localObject1 }));
    paramView.setLayoutParams(new LinearLayout.LayoutParams(paramInt, -2));
  }
  
  private static String b(Reader paramReader)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i1 = paramReader.read();
      if (i1 == -1) {
        break;
      }
      localStringBuilder.append((char)i1);
    }
    return localStringBuilder.toString();
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      try
      {
        SharedPreferences.Editor localEditor = a().getSharedPreferences("nearby_group_classify_sp", 0).edit();
        localEditor.putString("nearby_group_classify_content", paramString);
        localEditor.commit();
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("NearbyTroopsActivity", 2, "storeClassifyData===>Exception");
  }
  
  private void c(String paramString)
  {
    o();
    ThreadManager.a(new kdp(this, paramString, a().getSharedPreferences("nearby_group_classify_sp", 0).getLong("nearby_group_classify_last_modify_time", 0L)));
  }
  
  private void n()
  {
    if (this.jdField_d_of_type_AndroidViewView == null)
    {
      ImageButton localImageButton = new ImageButton(a());
      localImageButton.setImageResource(2130839505);
      localImageButton.setBackgroundResource(17170445);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
      float f1 = a().getResources().getDisplayMetrics().density;
      localLayoutParams.bottomMargin = ((int)(25.0F * f1));
      localLayoutParams.rightMargin = ((int)(f1 * 25.0F));
      localImageButton.setLayoutParams(localLayoutParams);
      localImageButton.setOnClickListener(this);
      localImageButton.setContentDescription(a().getResources().getString(2131364141));
      this.jdField_d_of_type_AndroidViewView = localImageButton;
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      addView(this.jdField_d_of_type_AndroidViewView);
      return;
    }
    requestLayout();
  }
  
  private void o()
  {
    if (this.jdField_e_of_type_Boolean) {}
    while (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
  }
  
  private void p()
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public int a()
  {
    return this.D;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().getPreferences().getLong("near_troop_last_refresh_time", 0L);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.h();
      this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    label345:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (paramInt2 == -1)
          {
            f();
            return;
            if ((paramInt2 != -1) || (paramIntent == null)) {
              break label345;
            }
            paramIntent = paramIntent.getStringExtra("data");
            if (TextUtils.isEmpty(paramIntent))
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "grp_tab", "Close_more", 0, 0, "", "", "", "");
              if (QLog.isColorLevel()) {
                QLog.d("NearbyTroopsActivity", 2, "onActivityResult, data empty");
              }
            }
            else
            {
              try
              {
                if (QLog.isColorLevel()) {
                  QLog.d("NearbyTroopsActivity", 2, "onActivityResult, data:" + paramIntent);
                }
                paramIntent = new JSONObject(paramIntent);
                kdr localkdr = new kdr(null);
                localkdr.jdField_a_of_type_Int = paramIntent.getInt("cid");
                localkdr.jdField_a_of_type_JavaLangString = paramIntent.getString("icon_url");
                localkdr.jdField_b_of_type_JavaLangString = paramIntent.getString("jump_url");
                localkdr.jdField_c_of_type_JavaLangString = paramIntent.getString("wording");
                localkdr.jdField_c_of_type_Int = paramIntent.getInt("type");
                if (this.jdField_g_of_type_AndroidViewView != null)
                {
                  paramInt1 = this.jdField_g_of_type_AndroidViewView.getVisibility();
                  a(localkdr, this.jdField_g_of_type_AndroidViewView, this.jdField_k_of_type_Int);
                  this.jdField_g_of_type_AndroidViewView.setVisibility(0);
                  this.jdField_g_of_type_AndroidViewView.performClick();
                  if ((paramInt1 == 8) && (this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout.getChildAt(0) != null))
                  {
                    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout.scrollBy(this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout.getChildAt(0).getWidth(), 0);
                    return;
                  }
                }
              }
              catch (Exception paramIntent) {}
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("NearbyTroopsActivity", 2, "onActivityResult-REQUEST_FOR_TROOP_TYPE_SELECT:" + paramIntent.toString());
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "grp_tab", "Close_more", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.d("NearbyTroopsActivity", 2, "onActivityResult, !(resultCode == Activity.RESULT_OK && data != null)");
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().getPreferences().edit().putLong("near_troop_last_refresh_time", paramLong).commit();
  }
  
  public void a(RspActivity paramRspActivity)
  {
    if (paramRspActivity == null) {}
    for (;;)
    {
      return;
      Object localObject1 = new nearby_troop_activity.RspBody();
      try
      {
        localObject1 = (nearby_troop_activity.RspBody)((nearby_troop_activity.RspBody)localObject1).mergeFrom(paramRspActivity.strRspAct);
        if (((nearby_troop_activity.RspBody)localObject1).has())
        {
          Object localObject2 = ((nearby_troop_activity.RspBody)localObject1).rpt_activity;
          if ((localObject2 != null) && (((PBRepeatMessageField)localObject2).has()))
          {
            localObject2 = ((PBRepeatMessageField)localObject2).get();
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              localObject2 = (nearby_troop_activity.ActivityDigest)((List)localObject2).get(0);
              if (localObject2 != null)
              {
                GroupAreaWrapper.ActivityInfo localActivityInfo = new GroupAreaWrapper.ActivityInfo(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a());
                localActivityInfo.address = ((nearby_troop_activity.ActivityDigest)localObject2).str_loc_name.get();
                localActivityInfo.desc = ((nearby_troop_activity.RspBody)localObject1).str_wording.get();
                localActivityInfo.distance = ((nearby_troop_activity.ActivityDigest)localObject2).uint32_distance.get();
                localActivityInfo.number = ((int)((nearby_troop_activity.ActivityDigest)localObject2).uint64_enroll.get());
                localActivityInfo.title = ((nearby_troop_activity.ActivityDigest)localObject2).str_name.get();
                localActivityInfo.type = ((nearby_troop_activity.RspBody)localObject1).str_title.get();
                localActivityInfo.image_url = ((nearby_troop_activity.ActivityDigest)localObject2).str_cover_url.get();
                localActivityInfo.title_url = ((nearby_troop_activity.RspBody)localObject1).str_url_list.get();
                localActivityInfo.desc_url = ((nearby_troop_activity.ActivityDigest)localObject2).str_url_info.get();
                localObject1 = new GroupAreaWrapper(localActivityInfo);
                if (this.jdField_c_of_type_JavaUtilArrayList.size() > paramRspActivity.shShowPos)
                {
                  this.jdField_c_of_type_JavaUtilArrayList.add(paramRspActivity.shShowPos, localObject1);
                  return;
                }
                this.jdField_c_of_type_JavaUtilArrayList.add(localObject1);
                return;
              }
            }
          }
        }
      }
      catch (Exception paramRspActivity) {}
    }
  }
  
  public void a(RspGetNearbyGroup paramRspGetNearbyGroup)
  {
    if ((paramRspGetNearbyGroup == null) || (paramRspGetNearbyGroup.stRspHotGrp == null))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
      return;
    }
    nearby_troop_hot.HotQunMsg localHotQunMsg = new nearby_troop_hot.HotQunMsg();
    try
    {
      localHotQunMsg.mergeFrom(paramRspGetNearbyGroup.stRspHotGrp.strRspHotGrp);
      if ((localHotQunMsg == null) || (!localHotQunMsg.msg_rsp_body.has()))
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
        return;
      }
    }
    catch (Exception paramRspGetNearbyGroup)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
      return;
    }
    if ((localHotQunMsg.msg_rsp_body.ret_info == null) || (!localHotQunMsg.msg_rsp_body.ret_info.has()) || (localHotQunMsg.msg_rsp_body.qun_info == null) || (!localHotQunMsg.msg_rsp_body.qun_info.has()))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
      return;
    }
    if (((nearby_troop_hot.RetInfo)localHotQunMsg.msg_rsp_body.ret_info.get()).ret_code.get() != 0)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
      return;
    }
    paramRspGetNearbyGroup = (nearby_troop_hot.QunInfo)localHotQunMsg.msg_rsp_body.qun_info.get();
    a(paramRspGetNearbyGroup.title.get(), paramRspGetNearbyGroup.desc.get(), paramRspGetNearbyGroup.url.get());
  }
  
  public void a(RspTopic paramRspTopic)
  {
    if (paramRspTopic == null) {}
    for (;;)
    {
      return;
      Object localObject = new nearby_troop_post.RspBody();
      try
      {
        ((nearby_troop_post.RspBody)localObject).mergeFrom(paramRspTopic.strRspTopic);
        label22:
        if (!((nearby_troop_post.RspBody)localObject).has()) {
          continue;
        }
        localObject = ((nearby_troop_post.RspBody)localObject).msg_subcmd0x1_rsp_nearbypostinfo;
        if ((localObject == null) || (!((nearby_troop_post.RspNearbyPostInfo)localObject).has())) {
          continue;
        }
        GroupAreaWrapper.TopicInfo localTopicInfo = new GroupAreaWrapper.TopicInfo(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a());
        localTopicInfo.address = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_post_address.get();
        localTopicInfo.desc = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_desc.get();
        localTopicInfo.distance = ((nearby_troop_post.RspNearbyPostInfo)localObject).uint32_distance.get();
        localTopicInfo.number = ((nearby_troop_post.RspNearbyPostInfo)localObject).uint32_post_replys.get();
        localTopicInfo.title = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_post_title.get();
        localTopicInfo.type = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_title.get();
        localTopicInfo.image_url = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_post_picture_url.get();
        localTopicInfo.desc_url = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_post_url.get();
        localTopicInfo.title_url = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_title_url.get();
        localObject = new GroupAreaWrapper(localTopicInfo);
        if (this.jdField_c_of_type_JavaUtilArrayList.size() > paramRspTopic.shShowPos)
        {
          this.jdField_c_of_type_JavaUtilArrayList.add(paramRspTopic.shShowPos, localObject);
          return;
        }
        this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
        return;
      }
      catch (Exception localException)
      {
        break label22;
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    a(false, paramIntent);
  }
  
  public void a(Intent paramIntent, NearbyTroopsBaseView.INearbyTroopContext paramINearbyTroopContext)
  {
    super.a(paramIntent, paramINearbyTroopContext);
    a(true, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.c(this.D);
    }
  }
  
  void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    this.jdField_d_of_type_JavaLangString = paramString3;
    if (!this.jdField_g_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    l();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(true));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "hot", "exp", 0, 0, "", "", "", "");
  }
  
  /* Error */
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: new 1034	java/io/ObjectOutputStream
    //   9: dup
    //   10: new 1036	java/io/BufferedOutputStream
    //   13: dup
    //   14: aload_0
    //   15: getfield 258	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsBaseView$INearbyTroopContext;
    //   18: invokeinterface 1037 1 0
    //   23: ldc 49
    //   25: iconst_0
    //   26: invokevirtual 1041	android/app/Activity:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   29: invokespecial 1044	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: invokespecial 1045	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   35: astore 6
    //   37: aload 6
    //   39: astore 7
    //   41: aload 6
    //   43: aload_1
    //   44: invokevirtual 1048	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   47: aload 6
    //   49: astore 7
    //   51: aload 6
    //   53: aload_2
    //   54: invokevirtual 1048	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   57: aload 6
    //   59: astore 7
    //   61: aload 6
    //   63: aload_3
    //   64: invokevirtual 1048	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   67: aload 6
    //   69: astore 7
    //   71: aload 6
    //   73: iload 4
    //   75: invokevirtual 1051	java/io/ObjectOutputStream:writeInt	(I)V
    //   78: aload 6
    //   80: astore 7
    //   82: aload 6
    //   84: iload 5
    //   86: invokevirtual 1051	java/io/ObjectOutputStream:writeInt	(I)V
    //   89: aload 6
    //   91: astore 7
    //   93: aload 6
    //   95: invokevirtual 1054	java/io/ObjectOutputStream:flush	()V
    //   98: aload 6
    //   100: ifnull +8 -> 108
    //   103: aload 6
    //   105: invokevirtual 1057	java/io/ObjectOutputStream:close	()V
    //   108: return
    //   109: astore_1
    //   110: aload_1
    //   111: invokevirtual 1058	java/io/IOException:printStackTrace	()V
    //   114: return
    //   115: astore_1
    //   116: aconst_null
    //   117: astore 6
    //   119: aload 6
    //   121: astore 7
    //   123: aload_1
    //   124: invokevirtual 1059	java/io/FileNotFoundException:printStackTrace	()V
    //   127: aload 6
    //   129: ifnull -21 -> 108
    //   132: aload 6
    //   134: invokevirtual 1057	java/io/ObjectOutputStream:close	()V
    //   137: return
    //   138: astore_1
    //   139: aload_1
    //   140: invokevirtual 1058	java/io/IOException:printStackTrace	()V
    //   143: return
    //   144: astore_2
    //   145: aload 8
    //   147: astore_1
    //   148: aload_1
    //   149: astore 7
    //   151: aload_2
    //   152: invokevirtual 1058	java/io/IOException:printStackTrace	()V
    //   155: aload_1
    //   156: ifnull -48 -> 108
    //   159: aload_1
    //   160: invokevirtual 1057	java/io/ObjectOutputStream:close	()V
    //   163: return
    //   164: astore_1
    //   165: aload_1
    //   166: invokevirtual 1058	java/io/IOException:printStackTrace	()V
    //   169: return
    //   170: astore_1
    //   171: aload 7
    //   173: ifnull +8 -> 181
    //   176: aload 7
    //   178: invokevirtual 1057	java/io/ObjectOutputStream:close	()V
    //   181: aload_1
    //   182: athrow
    //   183: astore_2
    //   184: aload_2
    //   185: invokevirtual 1058	java/io/IOException:printStackTrace	()V
    //   188: goto -7 -> 181
    //   191: astore_1
    //   192: goto -21 -> 171
    //   195: astore_2
    //   196: aload 6
    //   198: astore_1
    //   199: goto -51 -> 148
    //   202: astore_1
    //   203: goto -84 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	NearbyTroopsView
    //   0	206	1	paramArrayList1	ArrayList
    //   0	206	2	paramArrayList2	ArrayList
    //   0	206	3	paramArrayList3	ArrayList
    //   0	206	4	paramInt1	int
    //   0	206	5	paramInt2	int
    //   35	162	6	localObjectOutputStream	java.io.ObjectOutputStream
    //   1	176	7	localObject1	Object
    //   4	142	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   103	108	109	java/io/IOException
    //   6	37	115	java/io/FileNotFoundException
    //   132	137	138	java/io/IOException
    //   6	37	144	java/io/IOException
    //   159	163	164	java/io/IOException
    //   6	37	170	finally
    //   151	155	170	finally
    //   176	181	183	java/io/IOException
    //   41	47	191	finally
    //   51	57	191	finally
    //   61	67	191	finally
    //   71	78	191	finally
    //   82	89	191	finally
    //   93	98	191	finally
    //   123	127	191	finally
    //   41	47	195	java/io/IOException
    //   51	57	195	java/io/IOException
    //   61	67	195	java/io/IOException
    //   71	78	195	java/io/IOException
    //   82	89	195	java/io/IOException
    //   93	98	195	java/io/IOException
    //   41	47	202	java/io/FileNotFoundException
    //   51	57	202	java/io/FileNotFoundException
    //   61	67	202	java/io/FileNotFoundException
    //   71	78	202	java/io/FileNotFoundException
    //   82	89	202	java/io/FileNotFoundException
    //   93	98	202	java/io/FileNotFoundException
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)) {}
    }
    while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView == null)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendEmptyMessageDelayed(3, 800L);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      a(System.currentTimeMillis());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(1, this.jdField_a_of_type_AndroidContentContext.getString(2131366939));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.B();
  }
  
  public void a(boolean paramBoolean, Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    if (paramBoolean)
    {
      a(2130903531);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903418, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView, false));
      this.jdField_f_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903533, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView, false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_f_of_type_AndroidViewView.findViewById(2131298686));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView = ((NearbyTroopsExpandableListView)findViewById(2131298673));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_f_of_type_AndroidViewView.findViewById(2131298690));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131298692));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131298674);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298675));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298676));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_f_of_type_AndroidViewView.findViewById(2131298693));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131298685));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131298489);
      ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131299474)).setText(2131364144);
      this.jdField_f_of_type_AndroidViewView.findViewById(2131300436).setBackgroundColor(Color.parseColor("#f8f8f8"));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_f_of_type_AndroidViewView.findViewById(2131299473));
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      this.jdField_f_of_type_AndroidViewView.findViewById(2131299461).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setContentBackground(2130837687);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setOverScrollListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a_(this.jdField_f_of_type_AndroidViewView);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setContentDescription("");
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new kdn(this));
      if (this.jdField_g_of_type_Int == 10) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.b(this.jdField_a_of_type_AndroidContentContext.getString(2131366374));
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setFocusable(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setLongClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout = ((HorizontalScrollLayout)this.jdField_f_of_type_AndroidViewView.findViewById(2131298688));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131298689));
    }
    if (this.C == 1) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(this.r);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter = new NearbyTroopsExpandableListViewAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler, this, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.a(54, 54);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setGroupIndicator(null);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter);
      return;
      paramIntent = paramIntent.getStringExtra("config_res_plugin_item_name");
      if (!TextUtils.isEmpty(paramIntent)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(paramIntent);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(2131365804, -1);
      }
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a()) {
      a(true, this.E, this.D);
    }
    return true;
  }
  
  public boolean a(long paramLong)
  {
    return (0x100000 & paramLong) != 0L;
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext))
    {
      if (!this.h)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.d(2);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendEmptyMessageDelayed(2, 1000L);
      return false;
    }
    if (paramInt2 == 0) {
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.removeMessages(3);
      if (this.C == 1) {
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramBoolean, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, paramInt1, this.r, paramInt2);
      }
      for (;;)
      {
        return true;
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramBoolean, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, paramInt1, null, paramInt2);
      }
    }
  }
  
  public boolean a(boolean paramBoolean, Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a();
    if ((this.jdField_a_of_type_AndroidContentContext instanceof NearbyTroopsActivity)) {
      this.jdField_a_of_type_Int = ((NearbyTroopsActivity)this.jdField_a_of_type_AndroidContentContext).V;
    }
    this.i = false;
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler = new NearbyTroopsView.UIHandler(this, this);
    }
    if (paramIntent != null) {}
    for (;;)
    {
      this.C = paramIntent.getIntExtra("mode", 0);
      this.jdField_c_of_type_Int = paramIntent.getIntExtra("lat", 0);
      this.jdField_d_of_type_Int = paramIntent.getIntExtra("lon", 0);
      this.jdField_g_of_type_Int = paramIntent.getIntExtra("from", 0);
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("is_show_mapentry", true);
      if (this.C != 1) {
        break;
      }
      this.r = paramIntent.getStringExtra("location_name");
      if (!TextUtils.isEmpty(this.r)) {
        break;
      }
      j();
      return true;
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().getIntent();
    }
    a(paramBoolean, paramIntent);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.b();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendEmptyMessage(6);
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.g();
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_d_of_type_Boolean)) {
      n();
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
  }
  
  public void f() {}
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
  }
  
  /* Error */
  public void k()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aconst_null
    //   4: astore 14
    //   6: aconst_null
    //   7: astore 12
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 11
    //   15: aconst_null
    //   16: astore_2
    //   17: aconst_null
    //   18: astore 8
    //   20: aconst_null
    //   21: astore 9
    //   23: aconst_null
    //   24: astore 6
    //   26: new 1269	java/io/ObjectInputStream
    //   29: dup
    //   30: new 1271	java/io/BufferedInputStream
    //   33: dup
    //   34: aload_0
    //   35: getfield 161	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   38: ldc 49
    //   40: invokevirtual 1275	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   43: invokespecial 1278	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   46: invokespecial 1279	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore 5
    //   51: aload 5
    //   53: astore 4
    //   55: aload 5
    //   57: invokevirtual 1283	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   60: checkcast 874	java/util/ArrayList
    //   63: astore_1
    //   64: aload 5
    //   66: astore 4
    //   68: aload 5
    //   70: invokevirtual 1283	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   73: checkcast 874	java/util/ArrayList
    //   76: astore_3
    //   77: aload 5
    //   79: astore 4
    //   81: aload 5
    //   83: invokevirtual 1283	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   86: checkcast 874	java/util/ArrayList
    //   89: astore_2
    //   90: aload 5
    //   92: astore 4
    //   94: aload 5
    //   96: invokevirtual 1286	java/io/ObjectInputStream:readInt	()I
    //   99: pop
    //   100: aload 5
    //   102: astore 4
    //   104: aload 5
    //   106: invokevirtual 1286	java/io/ObjectInputStream:readInt	()I
    //   109: pop
    //   110: aload 5
    //   112: ifnull +738 -> 850
    //   115: aload 5
    //   117: invokevirtual 1287	java/io/ObjectInputStream:close	()V
    //   120: aload_1
    //   121: astore 4
    //   123: aload_2
    //   124: astore_1
    //   125: aload 4
    //   127: astore_2
    //   128: aload_2
    //   129: ifnonnull +706 -> 835
    //   132: new 874	java/util/ArrayList
    //   135: dup
    //   136: invokespecial 1288	java/util/ArrayList:<init>	()V
    //   139: astore_2
    //   140: aload_3
    //   141: ifnonnull +691 -> 832
    //   144: new 874	java/util/ArrayList
    //   147: dup
    //   148: invokespecial 1288	java/util/ArrayList:<init>	()V
    //   151: astore_3
    //   152: aload_1
    //   153: ifnonnull +676 -> 829
    //   156: new 874	java/util/ArrayList
    //   159: dup
    //   160: invokespecial 1288	java/util/ArrayList:<init>	()V
    //   163: astore_1
    //   164: aload_2
    //   165: invokevirtual 877	java/util/ArrayList:size	()I
    //   168: ifne +318 -> 486
    //   171: aload_3
    //   172: invokevirtual 877	java/util/ArrayList:size	()I
    //   175: ifne +311 -> 486
    //   178: aload_1
    //   179: invokevirtual 877	java/util/ArrayList:size	()I
    //   182: ifne +304 -> 486
    //   185: return
    //   186: astore 4
    //   188: aload 4
    //   190: invokevirtual 1058	java/io/IOException:printStackTrace	()V
    //   193: aload_1
    //   194: astore 4
    //   196: aload_2
    //   197: astore_1
    //   198: aload 4
    //   200: astore_2
    //   201: goto -73 -> 128
    //   204: astore 6
    //   206: aconst_null
    //   207: astore 5
    //   209: aconst_null
    //   210: astore_1
    //   211: aconst_null
    //   212: astore_2
    //   213: aconst_null
    //   214: astore_3
    //   215: aload 5
    //   217: astore 4
    //   219: aload 6
    //   221: invokevirtual 1289	java/io/StreamCorruptedException:printStackTrace	()V
    //   224: aload 5
    //   226: ifnull +621 -> 847
    //   229: aload 5
    //   231: invokevirtual 1287	java/io/ObjectInputStream:close	()V
    //   234: goto -106 -> 128
    //   237: astore 4
    //   239: aload 4
    //   241: invokevirtual 1058	java/io/IOException:printStackTrace	()V
    //   244: goto -116 -> 128
    //   247: astore_3
    //   248: aconst_null
    //   249: astore 7
    //   251: aload 12
    //   253: astore_1
    //   254: aload 7
    //   256: astore 4
    //   258: aload_3
    //   259: invokevirtual 1059	java/io/FileNotFoundException:printStackTrace	()V
    //   262: aload_1
    //   263: astore 4
    //   265: aload_2
    //   266: astore_3
    //   267: aload 6
    //   269: astore 5
    //   271: aload 7
    //   273: ifnull +565 -> 838
    //   276: aload 7
    //   278: invokevirtual 1287	java/io/ObjectInputStream:close	()V
    //   281: aload_1
    //   282: astore 4
    //   284: aload 6
    //   286: astore_1
    //   287: aload_2
    //   288: astore_3
    //   289: aload 4
    //   291: astore_2
    //   292: goto -164 -> 128
    //   295: astore_3
    //   296: aload_3
    //   297: invokevirtual 1058	java/io/IOException:printStackTrace	()V
    //   300: aload_1
    //   301: astore 4
    //   303: aload 6
    //   305: astore_1
    //   306: aload_2
    //   307: astore_3
    //   308: aload 4
    //   310: astore_2
    //   311: goto -183 -> 128
    //   314: astore_3
    //   315: aconst_null
    //   316: astore 7
    //   318: aload 8
    //   320: astore 6
    //   322: aload 10
    //   324: astore_2
    //   325: aload 13
    //   327: astore_1
    //   328: aload 7
    //   330: astore 4
    //   332: aload_3
    //   333: invokevirtual 1058	java/io/IOException:printStackTrace	()V
    //   336: aload_1
    //   337: astore 4
    //   339: aload_2
    //   340: astore_3
    //   341: aload 6
    //   343: astore 5
    //   345: aload 7
    //   347: ifnull +491 -> 838
    //   350: aload 7
    //   352: invokevirtual 1287	java/io/ObjectInputStream:close	()V
    //   355: aload_1
    //   356: astore 4
    //   358: aload 6
    //   360: astore_1
    //   361: aload_2
    //   362: astore_3
    //   363: aload 4
    //   365: astore_2
    //   366: goto -238 -> 128
    //   369: astore_3
    //   370: aload_3
    //   371: invokevirtual 1058	java/io/IOException:printStackTrace	()V
    //   374: aload_1
    //   375: astore 4
    //   377: aload 6
    //   379: astore_1
    //   380: aload_2
    //   381: astore_3
    //   382: aload 4
    //   384: astore_2
    //   385: goto -257 -> 128
    //   388: astore_3
    //   389: aconst_null
    //   390: astore 7
    //   392: aload 9
    //   394: astore 6
    //   396: aload 11
    //   398: astore_2
    //   399: aload 14
    //   401: astore_1
    //   402: aload 7
    //   404: astore 4
    //   406: aload_3
    //   407: invokevirtual 1290	java/lang/ClassNotFoundException:printStackTrace	()V
    //   410: aload_1
    //   411: astore 4
    //   413: aload_2
    //   414: astore_3
    //   415: aload 6
    //   417: astore 5
    //   419: aload 7
    //   421: ifnull +417 -> 838
    //   424: aload 7
    //   426: invokevirtual 1287	java/io/ObjectInputStream:close	()V
    //   429: aload_1
    //   430: astore 4
    //   432: aload 6
    //   434: astore_1
    //   435: aload_2
    //   436: astore_3
    //   437: aload 4
    //   439: astore_2
    //   440: goto -312 -> 128
    //   443: astore_3
    //   444: aload_3
    //   445: invokevirtual 1058	java/io/IOException:printStackTrace	()V
    //   448: aload_1
    //   449: astore 4
    //   451: aload 6
    //   453: astore_1
    //   454: aload_2
    //   455: astore_3
    //   456: aload 4
    //   458: astore_2
    //   459: goto -331 -> 128
    //   462: astore_1
    //   463: aconst_null
    //   464: astore 4
    //   466: aload 4
    //   468: ifnull +8 -> 476
    //   471: aload 4
    //   473: invokevirtual 1287	java/io/ObjectInputStream:close	()V
    //   476: aload_1
    //   477: athrow
    //   478: astore_2
    //   479: aload_2
    //   480: invokevirtual 1058	java/io/IOException:printStackTrace	()V
    //   483: goto -7 -> 476
    //   486: aload_0
    //   487: iconst_1
    //   488: putfield 183	com/tencent/mobileqq/troop/activity/NearbyTroopsView:h	Z
    //   491: aload_2
    //   492: invokevirtual 1294	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   495: astore 4
    //   497: aload 4
    //   499: invokeinterface 1299 1 0
    //   504: ifeq +64 -> 568
    //   507: aload 4
    //   509: invokeinterface 1302 1 0
    //   514: checkcast 1304	NearbyGroup/GroupInfo
    //   517: getfield 1308	NearbyGroup/GroupInfo:dwGroupFlagExt	J
    //   520: ldc2_w 1204
    //   523: land
    //   524: lconst_0
    //   525: lcmp
    //   526: ifeq -29 -> 497
    //   529: aload_0
    //   530: getfield 258	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsBaseView$INearbyTroopContext;
    //   533: invokeinterface 263 1 0
    //   538: ldc_w 1310
    //   541: ldc 171
    //   543: ldc 171
    //   545: ldc_w 1312
    //   548: ldc_w 1314
    //   551: bipush 45
    //   553: iconst_0
    //   554: ldc 171
    //   556: ldc 171
    //   558: ldc 171
    //   560: ldc 171
    //   562: invokestatic 276	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   565: goto -68 -> 497
    //   568: aload_0
    //   569: getfield 294	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter	Lcom/tencent/mobileqq/troop/data/NearbyTroopsExpandableListViewAdapter;
    //   572: aload_2
    //   573: aload_3
    //   574: aload_1
    //   575: invokevirtual 1317	com/tencent/mobileqq/troop/data/NearbyTroopsExpandableListViewAdapter:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    //   578: aload_0
    //   579: getfield 301	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView	Lcom/tencent/mobileqq/troop/widget/NearbyTroopsExpandableListView;
    //   582: iconst_1
    //   583: invokevirtual 1213	com/tencent/mobileqq/troop/widget/NearbyTroopsExpandableListView:a	(Z)V
    //   586: return
    //   587: astore_1
    //   588: goto -122 -> 466
    //   591: astore_3
    //   592: aload 14
    //   594: astore_1
    //   595: aload 11
    //   597: astore_2
    //   598: aload 9
    //   600: astore 6
    //   602: aload 5
    //   604: astore 7
    //   606: goto -204 -> 402
    //   609: astore_3
    //   610: aload 11
    //   612: astore_2
    //   613: aload 9
    //   615: astore 6
    //   617: aload 5
    //   619: astore 7
    //   621: goto -219 -> 402
    //   624: astore 4
    //   626: aload_3
    //   627: astore_2
    //   628: aload 4
    //   630: astore_3
    //   631: aload 9
    //   633: astore 6
    //   635: aload 5
    //   637: astore 7
    //   639: goto -237 -> 402
    //   642: astore 4
    //   644: aload_2
    //   645: astore 6
    //   647: aload_3
    //   648: astore_2
    //   649: aload 4
    //   651: astore_3
    //   652: aload 5
    //   654: astore 7
    //   656: goto -254 -> 402
    //   659: astore_3
    //   660: aload 13
    //   662: astore_1
    //   663: aload 10
    //   665: astore_2
    //   666: aload 8
    //   668: astore 6
    //   670: aload 5
    //   672: astore 7
    //   674: goto -346 -> 328
    //   677: astore_3
    //   678: aload 10
    //   680: astore_2
    //   681: aload 8
    //   683: astore 6
    //   685: aload 5
    //   687: astore 7
    //   689: goto -361 -> 328
    //   692: astore 4
    //   694: aload_3
    //   695: astore_2
    //   696: aload 4
    //   698: astore_3
    //   699: aload 8
    //   701: astore 6
    //   703: aload 5
    //   705: astore 7
    //   707: goto -379 -> 328
    //   710: astore 4
    //   712: aload_2
    //   713: astore 6
    //   715: aload_3
    //   716: astore_2
    //   717: aload 4
    //   719: astore_3
    //   720: aload 5
    //   722: astore 7
    //   724: goto -396 -> 328
    //   727: astore_3
    //   728: aload 12
    //   730: astore_1
    //   731: aload 5
    //   733: astore 7
    //   735: goto -481 -> 254
    //   738: astore_3
    //   739: aload 5
    //   741: astore 7
    //   743: goto -489 -> 254
    //   746: astore 4
    //   748: aload_3
    //   749: astore_2
    //   750: aload 4
    //   752: astore_3
    //   753: aload 5
    //   755: astore 7
    //   757: goto -503 -> 254
    //   760: astore 4
    //   762: aload_2
    //   763: astore 6
    //   765: aload_3
    //   766: astore_2
    //   767: aload 4
    //   769: astore_3
    //   770: aload 5
    //   772: astore 7
    //   774: goto -520 -> 254
    //   777: astore 6
    //   779: aconst_null
    //   780: astore_2
    //   781: aconst_null
    //   782: astore_3
    //   783: aconst_null
    //   784: astore_1
    //   785: goto -570 -> 215
    //   788: astore 6
    //   790: aconst_null
    //   791: astore_3
    //   792: aconst_null
    //   793: astore 4
    //   795: aload_1
    //   796: astore_2
    //   797: aload 4
    //   799: astore_1
    //   800: goto -585 -> 215
    //   803: astore 6
    //   805: aconst_null
    //   806: astore 4
    //   808: aload_1
    //   809: astore_2
    //   810: aload 4
    //   812: astore_1
    //   813: goto -598 -> 215
    //   816: astore 6
    //   818: aload_1
    //   819: astore 4
    //   821: aload_2
    //   822: astore_1
    //   823: aload 4
    //   825: astore_2
    //   826: goto -611 -> 215
    //   829: goto -665 -> 164
    //   832: goto -680 -> 152
    //   835: goto -695 -> 140
    //   838: aload 5
    //   840: astore_1
    //   841: aload 4
    //   843: astore_2
    //   844: goto -716 -> 128
    //   847: goto -719 -> 128
    //   850: aload_1
    //   851: astore 4
    //   853: aload_2
    //   854: astore_1
    //   855: aload 4
    //   857: astore_2
    //   858: goto -730 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	861	0	this	NearbyTroopsView
    //   63	391	1	localObject1	Object
    //   462	113	1	localArrayList1	ArrayList
    //   587	1	1	localObject2	Object
    //   594	261	1	localObject3	Object
    //   16	443	2	localObject4	Object
    //   478	95	2	localIOException1	java.io.IOException
    //   597	261	2	localObject5	Object
    //   76	139	3	localArrayList2	ArrayList
    //   247	12	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   266	23	3	localObject6	Object
    //   295	2	3	localIOException2	java.io.IOException
    //   307	1	3	localObject7	Object
    //   314	19	3	localIOException3	java.io.IOException
    //   340	23	3	localObject8	Object
    //   369	2	3	localIOException4	java.io.IOException
    //   381	1	3	localObject9	Object
    //   388	19	3	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   414	23	3	localObject10	Object
    //   443	2	3	localIOException5	java.io.IOException
    //   455	119	3	localObject11	Object
    //   591	1	3	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   609	18	3	localClassNotFoundException3	java.lang.ClassNotFoundException
    //   630	22	3	localClassNotFoundException4	java.lang.ClassNotFoundException
    //   659	1	3	localIOException6	java.io.IOException
    //   677	18	3	localIOException7	java.io.IOException
    //   698	22	3	localIOException8	java.io.IOException
    //   727	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   738	11	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   752	40	3	localFileNotFoundException4	java.io.FileNotFoundException
    //   53	73	4	localObject12	Object
    //   186	3	4	localIOException9	java.io.IOException
    //   194	24	4	localObject13	Object
    //   237	3	4	localIOException10	java.io.IOException
    //   256	252	4	localObject14	Object
    //   624	5	4	localClassNotFoundException5	java.lang.ClassNotFoundException
    //   642	8	4	localClassNotFoundException6	java.lang.ClassNotFoundException
    //   692	5	4	localIOException11	java.io.IOException
    //   710	8	4	localIOException12	java.io.IOException
    //   746	5	4	localFileNotFoundException5	java.io.FileNotFoundException
    //   760	8	4	localFileNotFoundException6	java.io.FileNotFoundException
    //   793	63	4	localObject15	Object
    //   49	790	5	localObject16	Object
    //   24	1	6	localObject17	Object
    //   204	100	6	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   320	444	6	localObject18	Object
    //   777	1	6	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   788	1	6	localStreamCorruptedException3	java.io.StreamCorruptedException
    //   803	1	6	localStreamCorruptedException4	java.io.StreamCorruptedException
    //   816	1	6	localStreamCorruptedException5	java.io.StreamCorruptedException
    //   249	524	7	localObject19	Object
    //   18	682	8	localObject20	Object
    //   21	611	9	localObject21	Object
    //   10	669	10	localObject22	Object
    //   13	598	11	localObject23	Object
    //   7	722	12	localObject24	Object
    //   1	660	13	localObject25	Object
    //   4	589	14	localObject26	Object
    // Exception table:
    //   from	to	target	type
    //   115	120	186	java/io/IOException
    //   26	51	204	java/io/StreamCorruptedException
    //   229	234	237	java/io/IOException
    //   26	51	247	java/io/FileNotFoundException
    //   276	281	295	java/io/IOException
    //   26	51	314	java/io/IOException
    //   350	355	369	java/io/IOException
    //   26	51	388	java/lang/ClassNotFoundException
    //   424	429	443	java/io/IOException
    //   26	51	462	finally
    //   471	476	478	java/io/IOException
    //   55	64	587	finally
    //   68	77	587	finally
    //   81	90	587	finally
    //   94	100	587	finally
    //   104	110	587	finally
    //   219	224	587	finally
    //   258	262	587	finally
    //   332	336	587	finally
    //   406	410	587	finally
    //   55	64	591	java/lang/ClassNotFoundException
    //   68	77	609	java/lang/ClassNotFoundException
    //   81	90	624	java/lang/ClassNotFoundException
    //   94	100	642	java/lang/ClassNotFoundException
    //   104	110	642	java/lang/ClassNotFoundException
    //   55	64	659	java/io/IOException
    //   68	77	677	java/io/IOException
    //   81	90	692	java/io/IOException
    //   94	100	710	java/io/IOException
    //   104	110	710	java/io/IOException
    //   55	64	727	java/io/FileNotFoundException
    //   68	77	738	java/io/FileNotFoundException
    //   81	90	746	java/io/FileNotFoundException
    //   94	100	760	java/io/FileNotFoundException
    //   104	110	760	java/io/FileNotFoundException
    //   55	64	777	java/io/StreamCorruptedException
    //   68	77	788	java/io/StreamCorruptedException
    //   81	90	803	java/io/StreamCorruptedException
    //   94	100	816	java/io/StreamCorruptedException
    //   104	110	816	java/io/StreamCorruptedException
  }
  
  public void l()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838125);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838123);
  }
  
  public void m()
  {
    if ((this.C == 1) && (this.jdField_g_of_type_Int != 23)) {
      a(true, 1, 0);
    }
    for (;;)
    {
      Object localObject = a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_e_of_type_Boolean = true;
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        a(this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout, (JSONObject)localObject);
        c("https://qun.qq.com/search/mobileqq/nearbyGroupClassify.json");
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(16, new Bundle(), new kdm(this));
        return;
        k();
        a(true, 1, 0);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NearbyTroopsActivity", 2, "initData==>JSONException");
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    Object localObject3;
    label756:
    do
    {
      do
      {
        return;
        if (this.jdField_d_of_type_AndroidViewView == paramView)
        {
          TroopNearByBigMapActivity.a(a(), this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "grp_tab", "Clk_map", 0, 0, "", "", "", "");
          return;
        }
        switch (paramView.getId())
        {
        }
        for (;;)
        {
          if (paramView.getId() != 2131298693) {
            break label756;
          }
          TroopCreateEnterActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), 2, 51);
          return;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "grp_tab", "Clk_banner", 0, 0, "", "", "", "");
          if (this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo == null) {
            break;
          }
          Object localObject1;
          switch (this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.uint32_jump_type.get())
          {
          default: 
            break;
          case 1: 
            if (this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_web_banner.has())
            {
              localObject1 = (nearbybanner.WebBanner)this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_web_banner.get();
              if (((nearbybanner.WebBanner)localObject1).bytes_jump_url.has())
              {
                localObject1 = ((nearbybanner.WebBanner)localObject1).bytes_jump_url.get().toStringUtf8();
                localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
                ((Intent)localObject3).putExtra("url", (String)localObject1);
                ((Intent)localObject3).putExtra("hide_left_button", true);
                ((Intent)localObject3).putExtra("show_right_close_button", true);
                ((Intent)localObject3).putExtra("finish_animation_up_down", true);
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
              }
            }
            break;
          case 5: 
            if (this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_search_banner.has())
            {
              localObject1 = (nearbybanner.SearchBanner)this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_search_banner.get();
              if (((nearbybanner.SearchBanner)localObject1).bytes_search_keyword.has())
              {
                localObject3 = ((nearbybanner.SearchBanner)localObject1).bytes_search_keyword.get().toStringUtf8();
                localObject1 = "https://qqweb.qq.com/m/relativegroup/index.html?source=qun_rec&keyword=" + URLEncoder.encode((String)localObject3) + "&_bid=165";
                if (QLog.isColorLevel()) {
                  QLog.d("NearbyTroopsActivity", 2, "lastKeywords = " + (String)localObject3 + " jump url is : " + (String)localObject1);
                }
                localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
                ((Intent)localObject3).putExtra("url", (String)localObject1);
                ((Intent)localObject3).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a());
                ((Intent)localObject3).putExtra("portraitOnly", true);
                ((Intent)localObject3).putExtra("hide_more_button", true);
                ((Intent)localObject3).putExtra("hide_operation_bar", true);
                ((Intent)localObject3).putExtra("isShowAd", false);
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
              }
            }
            break;
          case 2: 
            if (this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_create_banner.has())
            {
              localObject1 = (nearbybanner.CreateGroupBanner)this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_create_banner.get();
              if (((nearbybanner.CreateGroupBanner)localObject1).uint32_group_type.has())
              {
                ((nearbybanner.CreateGroupBanner)localObject1).uint32_group_type.get();
                TroopQQBrowserHelper.a(this.jdField_a_of_type_AndroidContentContext);
              }
            }
            break;
          case 3: 
            if (this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_recomm_banner.has())
            {
              localObject1 = (nearbybanner.RecommGroupBanner)this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_recomm_banner.get();
              if (((nearbybanner.RecommGroupBanner)localObject1).uint64_group_code.has())
              {
                localObject1 = TroopInfoActivity.a(String.valueOf(((nearbybanner.RecommGroupBanner)localObject1).uint64_group_code.get()), 2);
                ChatSettingForTroop.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, 2);
              }
            }
            break;
          case 4: 
            if (this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_set_banner.has())
            {
              localObject1 = (nearbybanner.SetGroupBanner)this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_set_banner.get();
              if (((nearbybanner.SetGroupBanner)localObject1).uint64_group_code.has())
              {
                long l1 = ((nearbybanner.SetGroupBanner)localObject1).uint64_group_code.get();
                try
                {
                  localObject1 = TroopInfoActivity.a(Long.toString(l1), 3, 0, 0, null);
                  TroopInfoActivity.a(a(), (Bundle)localObject1, 100);
                }
                catch (Exception localException) {}
              }
            }
            break;
          }
        }
      } while (!(paramView.getTag() instanceof kdu));
      localObject2 = (kdu)paramView.getTag();
      switch (((kdu)localObject2).jdField_a_of_type_Int)
      {
      default: 
        return;
      case 4: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "nearbygrp_map", "Clk_back", 0, 0, "", "", "", "");
        SosoInterface.a(new kdq(this, 3, true, 60000L, false, false, "NearbyTroopsView"));
        return;
      }
    } while (!(((kdu)localObject2).jdField_a_of_type_JavaLangObject instanceof kdr));
    Object localObject2 = (kdr)((kdu)localObject2).jdField_a_of_type_JavaLangObject;
    paramView = (TextView)paramView.findViewById(2131299368);
    if (paramView != null)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      }
      paramView.setBackgroundResource(2130839504);
      this.jdField_b_of_type_AndroidWidgetTextView = paramView;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout.getChildAt(((kdr)localObject2).jdField_b_of_type_Int + 2);
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout.a(((kdr)localObject2).jdField_b_of_type_Int, 2);
      label965:
      if (((kdr)localObject2).jdField_c_of_type_Int != 1) {
        break label1292;
      }
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localObject3 = new StringBuilder(((kdr)localObject2).jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject3).append("&lat=").append(this.jdField_e_of_type_Int).append("&lon=").append(this.jdField_f_of_type_Int).append("&city=").append(this.jdField_e_of_type_JavaLangString);
      localObject3 = ((StringBuilder)localObject3).toString();
      paramView.putExtra("url", (String)localObject3);
      paramView.putExtra("key_isReadModeEnabled", true);
      PublicAccountUtil.a(paramView, (String)localObject3);
      if (((kdr)localObject2).jdField_a_of_type_Int != 99) {
        break label1281;
      }
      paramView.putExtra("finish_animation_up_down", true);
      paramView.putExtra("hide_left_button", true);
      paramView.putExtra("show_right_close_button", true);
      paramView.putExtra("title", this.jdField_a_of_type_AndroidContentContext.getString(2131365805));
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().startActivityForResult(paramView, 1000);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().overridePendingTransition(2130968595, 2130968592);
    }
    for (;;)
    {
      this.D = ((kdr)localObject2).jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.c(this.D);
      }
      this.E = 4;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext == null) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "grp_tab", "Clk_grpcla", 0, 0, ((kdr)localObject2).jdField_a_of_type_Int + "", "", "", "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout.a(((kdr)localObject2).jdField_b_of_type_Int, 3);
      break label965;
      label1281:
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      continue;
      label1292:
      if (((kdr)localObject2).jdField_c_of_type_Int == 2) {
        a(true, 4, ((kdr)localObject2).jdField_a_of_type_Int);
      }
    }
  }
  
  public void setHasHotTroopRedDot(boolean paramBoolean)
  {
    this.jdField_k_of_type_Boolean = paramBoolean;
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.NearbyTroopsView
 * JD-Core Version:    0.7.0.1
 */