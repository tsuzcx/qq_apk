package com.tencent.mobileqq.dating;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DateEventMsg;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheet.OnDismissListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import ibh;
import ibj;
import ibk;
import ibm;
import ibn;
import ibo;
import ibp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatingFeedActivity
  extends DatingBaseActivity
  implements Handler.Callback, View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, ActionSheet.OnButtonClickListener, ActionSheet.OnDismissListener, OverScrollViewListener
{
  public static final int a = 0;
  private static final long jdField_a_of_type_Long = 180000L;
  public static final String a = "FROM_WHERE";
  public static final int b = 0;
  private static final String jdField_b_of_type_JavaLangString = "DatingFeedActivity";
  static final int jdField_c_of_type_Int = 1;
  private static final String jdField_c_of_type_JavaLangString = "has_more";
  private static final String jdField_d_of_type_JavaLangString = "cookie";
  private static final String jdField_e_of_type_JavaLangString = "last_refresh_time";
  private static final String jdField_h_of_type_JavaLangString = "last_have_published_mark";
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DatingFeedAdapter jdField_a_of_type_ComTencentMobileqqDatingDatingFeedAdapter;
  private DatingFilters jdField_a_of_type_ComTencentMobileqqDatingDatingFilters;
  public DatingObserver a;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private ibo jdField_a_of_type_Ibo;
  private ibp jdField_a_of_type_Ibp;
  private volatile boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private DatingFilters jdField_b_of_type_ComTencentMobileqqDatingDatingFilters;
  private volatile boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private View jdField_e_of_type_AndroidViewView;
  private boolean g;
  private boolean jdField_h_of_type_Boolean;
  private boolean i = false;
  private boolean j = false;
  
  public DatingFeedActivity()
  {
    this.h = false;
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver = new ibh(this);
  }
  
  private List a(DatingManager paramDatingManager)
  {
    paramDatingManager = paramDatingManager.a().a(getClass().getName());
    if (paramDatingManager != null)
    {
      Map localMap = paramDatingManager.jdField_a_of_type_JavaUtilMap;
      this.jdField_c_of_type_Boolean = ((Boolean)localMap.get("has_more")).booleanValue();
      this.jdField_a_of_type_ArrayOfByte = ((byte[])localMap.get("cookie"));
      this.jdField_b_of_type_Long = ((Long)localMap.get("last_refresh_time")).longValue();
      this.g = ((Boolean)localMap.get("last_have_published_mark")).booleanValue();
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedAdapter.b(paramDatingManager.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentWidgetXListView.onRestoreInstanceState(paramDatingManager.jdField_a_of_type_AndroidOsParcelable);
      return paramDatingManager.jdField_a_of_type_JavaUtilList;
    }
    return null;
  }
  
  private void a(DatingFilters paramDatingFilters)
  {
    if ((paramDatingFilters != null) && (!paramDatingFilters.a()))
    {
      this.centerView.setVisibility(4);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.centerView.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(4);
  }
  
  private void a(List paramList)
  {
    if (this.jdField_b_of_type_Long > 0L)
    {
      b(paramList);
      if (this.jdField_a_of_type_Ibp != null)
      {
        if (this.jdField_c_of_type_Boolean) {
          break label49;
        }
        this.jdField_a_of_type_Ibp.c();
      }
    }
    while (!this.j)
    {
      a(true, false);
      return;
      label49:
      this.jdField_a_of_type_Ibp.b();
    }
    this.j = false;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (System.currentTimeMillis() - this.jdField_b_of_type_Long < 180000L)) {
      return;
    }
    if (!paramBoolean2)
    {
      startTitleProgress();
      a(null);
    }
    b(false, paramBoolean2);
  }
  
  private void b()
  {
    DatingManager localDatingManager = (DatingManager)this.app.getManager(67);
    List localList = a(localDatingManager);
    ThreadManager.a().post(new ibk(this, localList, localDatingManager));
  }
  
  private void b(List paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters != null) && (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedAdapter.a(this.jdField_a_of_type_AndroidViewView);
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label116;
      }
      this.jdField_a_of_type_Ibp.a(true);
    }
    for (;;)
    {
      if (!this.j)
      {
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedAdapter.b(paramList);
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      }
      c(paramList);
      if (!this.h)
      {
        this.h = true;
        findViewById(2131299984).setVisibility(8);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedAdapter.a(this.jdField_b_of_type_AndroidViewView);
      break;
      label116:
      this.jdField_a_of_type_Ibp.a(false);
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Ibo.a(paramBoolean1, paramBoolean2);
    this.jdField_a_of_type_Boolean = true;
    if (NetworkUtil.f(this))
    {
      ThreadManager.c(this.jdField_a_of_type_Ibo);
      return;
    }
    runOnUiThread(new ibn(this, paramBoolean1, paramBoolean2));
  }
  
  private void c()
  {
    setTitle(2131369656);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131297354);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297355));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297356));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131369656);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131369929);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130838415);
    this.rightViewImg.setOnClickListener(this);
    this.rightViewImg.setContentDescription(getString(2131369657));
    if ((getIntent().getIntExtra("FROM_WHERE", -1) == 0) || (this.jdField_e_of_type_Boolean)) {
      this.leftView.setText(2131367588);
    }
    for (;;)
    {
      this.jdField_d_of_type_Int = getResources().getDimensionPixelSize(2131492923);
      Object localObject1 = getLayoutInflater();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedAdapter = new DatingFeedAdapter(this, this.app, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
      Object localObject2 = ((LayoutInflater)localObject1).inflate(2130903894, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      ((View)localObject2).setOnClickListener(this);
      this.jdField_a_of_type_Ibp = new ibp((View)localObject2);
      View localView = ((LayoutInflater)localObject1).inflate(2130903893, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_d_of_type_AndroidViewView = localView.findViewById(2131299985);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(new ibm(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)((LayoutInflater)localObject1).inflate(2130903418, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131299983));
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getLayoutParams().height = getResources().getDimensionPixelSize(2131492896);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837687);
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838126);
      this.jdField_a_of_type_ComTencentWidgetXListView.b((View)localObject2, null, false);
      this.jdField_a_of_type_ComTencentWidgetXListView.a(localView, null, false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedAdapter);
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)localObject1).inflate(2130903896, null);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299997));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = ((LayoutInflater)localObject1).inflate(2130903895, null);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131299992).setOnClickListener(this);
      localObject1 = new ImageButton(this);
      ((ImageButton)localObject1).setImageResource(2130840266);
      ((ImageButton)localObject1).setBackgroundResource(17170445);
      localObject2 = new FrameLayout.LayoutParams(-2, -2, 85);
      float f = getResources().getDisplayMetrics().density;
      ((FrameLayout.LayoutParams)localObject2).bottomMargin = ((int)(32.0F * f));
      ((FrameLayout.LayoutParams)localObject2).rightMargin = ((int)(f * 32.0F));
      ((ImageButton)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((ImageButton)localObject1).setPadding(0, 0, 0, 0);
      ((ImageButton)localObject1).setOnClickListener(this);
      ((ImageButton)localObject1).setContentDescription("发布约会");
      this.jdField_c_of_type_AndroidViewView = ((View)localObject1);
      ((FrameLayout)findViewById(16908290)).addView(this.jdField_c_of_type_AndroidViewView);
      g();
      return;
      this.leftView.setText(2131365114);
    }
  }
  
  private void c(List paramList)
  {
    int m = 4;
    int k = 0;
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
      return;
    }
    if (this.g) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dating", 2, "updateHavePublishedState : " + m + " , " + k);
      }
      if (this.jdField_a_of_type_AndroidWidgetButton != null) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(m);
      }
      if (this.jdField_c_of_type_AndroidViewView == null) {
        break;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(k);
      return;
      m = 0;
      k = 4;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedAdapter != null)
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedAdapter.a();
      if ((localList != null) && (localList.size() > 0))
      {
        AnchorageManager localAnchorageManager = ((DatingManager)this.app.getManager(67)).a();
        HashMap localHashMap = new HashMap();
        localHashMap.put("cookie", this.jdField_a_of_type_ArrayOfByte);
        localHashMap.put("has_more", Boolean.valueOf(this.jdField_c_of_type_Boolean));
        localHashMap.put("last_have_published_mark", Boolean.valueOf(this.g));
        localHashMap.put("last_refresh_time", Long.valueOf(this.jdField_b_of_type_Long));
        localAnchorageManager.a(getClass().getName(), this.jdField_a_of_type_ComTencentWidgetXListView.onSaveInstanceState(), localList, localHashMap);
      }
    }
  }
  
  private void g()
  {
    if (this.jdField_d_of_type_AndroidViewView == null)
    {
      DatingUtil.a("updateDateEventEnty, mApplyNoticeHeader is null", new Object[0]);
      return;
    }
    Object localObject2 = (DatingManager)this.app.getManager(67);
    Object localObject1;
    int k;
    if (localObject2 == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label244;
      }
      k = ((DateEventManager)localObject1).a();
      if (k <= 0) {
        break label294;
      }
      localObject1 = ((DateEventManager)localObject1).a();
    }
    for (;;)
    {
      label55:
      DatingUtil.a("updateDateEventEnty", new Object[] { Integer.valueOf(k) });
      TextView localTextView1;
      if (k > 0)
      {
        if (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0) {
          b("0X8004F13");
        }
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        localTextView1 = (TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131299986);
        TextView localTextView2 = (TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131299987);
        if (k > 99)
        {
          localObject2 = "99+";
          label141:
          localTextView2.setText((CharSequence)localObject2);
          if (localObject1 == null) {
            break label289;
          }
        }
      }
      label289:
      for (localObject1 = ((DateEventMsg)localObject1).getDescStr(this, false);; localObject1 = null)
      {
        if (k > 1) {
          localObject1 = getString(2131369752);
        }
        localTextView1.setText((CharSequence)localObject1);
        localObject2 = new StringBuilder(100);
        ((StringBuilder)localObject2).append((String)localObject1);
        if (k > 1) {
          ((StringBuilder)localObject2).append(",等").append(k).append("条新消息");
        }
        ((StringBuilder)localObject2).append(",连按两次查看");
        this.jdField_d_of_type_AndroidViewView.setContentDescription(((StringBuilder)localObject2).toString());
        return;
        localObject1 = ((DatingManager)localObject2).a();
        break;
        label244:
        DatingUtil.b("updateDateEventEnty", new Object[] { "dem is null", localObject2 });
        localObject1 = null;
        k = 0;
        break label55;
        localObject2 = String.valueOf(k);
        break label141;
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      label294:
      localObject1 = null;
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131369686);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131369820);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131369669);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.e(2131365736);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
      a(this.app, this, 4097, "feed");
      continue;
      a();
      DatingBaseActivity.a(this.app, "0X800493B", "1");
      continue;
      paramView = new Intent(this, DatingUserCenterActivity.class);
      paramView.addFlags(335544320);
      startActivity(paramView);
      DatingBaseActivity.a(this.app, "0X800493A");
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      QQToast.a(this, 2131369777, 0).b(this.jdField_d_of_type_Int);
      return;
    }
    Intent localIntent = new Intent(this, DatingFilterActivity.class);
    if (this.i) {
      localIntent.putExtra("filter", this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters);
    }
    startActivityForResult(localIntent, 0);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      paramBitmap = new BitmapDrawable(getResources(), paramBitmap);
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      DatingItemBuilder localDatingItemBuilder = this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedAdapter.a();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
        if (localDatingItemBuilder.a(paramString, localView)) {
          localDatingItemBuilder.a(paramBitmap, localView);
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(this.jdField_b_of_type_Long);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(this.jdField_b_of_type_Long);
    a(false, true);
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(this.jdField_b_of_type_Long);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903892);
    getWindow().setBackgroundDrawableResource(2130837687);
    c();
    this.jdField_a_of_type_AndroidOsHandler = new CustomHandler(Looper.getMainLooper(), this);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    this.jdField_a_of_type_Ibo = new ibo(this, null);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters = ((DatingFilters)getIntent().getParcelableExtra("filter"));
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters != null)
    {
      this.i = true;
      this.jdField_b_of_type_Boolean = true;
      this.j = false;
      a(true, false);
    }
    for (;;)
    {
      b("0X8004939");
      ThreadManager.a().post(new ibj(this));
      return true;
      b();
    }
  }
  
  protected void doOnDestroy()
  {
    if (!this.i) {
      d();
    }
    super.doOnDestroy();
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    g();
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedAdapter.notifyDataSetChanged();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_ComTencentWidgetXListView.B();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 != -1) || (paramInt1 != 0) || (paramIntent == null)) {
      return;
    }
    this.i = false;
    this.jdField_b_of_type_Boolean = true;
    paramIntent = (DatingFilters)paramIntent.getParcelableExtra("key_filter_value");
    this.jdField_b_of_type_ComTencentMobileqqDatingDatingFilters = this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters;
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters = paramIntent;
    DatingUtil.a("doOnActivityResult : ", new Object[] { paramIntent });
    a(false, false);
    DatingFilters.a(this, this.app.a(), paramIntent);
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      Intent localIntent = new Intent(this, NearbyActivity.class);
      localIntent.putExtra("abp_flag", this.jdField_e_of_type_Boolean);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_c_of_type_AndroidViewView == paramView)
    {
      a(this.app, this, 4097, "feed");
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297361: 
      h();
      return;
    case 2131299988: 
      this.jdField_a_of_type_Ibp.a();
      b(true, false);
      return;
    case 2131299997: 
      a(this.app, this, 4097, "feed");
      return;
    case 2131299985: 
      a(this.app, this, 4097, "feed");
      return;
    }
    a();
    a(this.app, "0X800493B", "2");
  }
  
  public void onDismiss()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingFeedActivity
 * JD-Core Version:    0.7.0.1
 */