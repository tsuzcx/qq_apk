package com.tencent.mobileqq.richstatus;

import PersonalState.UserProfile;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import jsm;
import jsn;
import jso;
import jsp;

public class SameStatusActivity
  extends LbsBaseActivity
  implements Handler.Callback, View.OnClickListener, IIconListener, ISameStatusListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, OverScrollViewListener
{
  private static final long jdField_a_of_type_Long = 1000L;
  public static final String a = "k_action";
  private static final int jdField_b_of_type_Int = 0;
  public static final String b = "k_data";
  private static final int jdField_c_of_type_Int = 0;
  public static final String c = "k_friend";
  private static final int jdField_d_of_type_Int = 1;
  private static final String jdField_d_of_type_JavaLangString = "k_same_status_guide";
  private static final int jdField_e_of_type_Int = 2;
  private static final String jdField_e_of_type_JavaLangString = "k_same_status_filter";
  private static final int jdField_f_of_type_Int = 3;
  private static final int k = 1;
  private static final int l = 2;
  private static final int m = 3;
  private static final int n = 0;
  private static final int o = 1;
  private static final int p = 2;
  private static final int q = 3;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver;
  private FriendManager jdField_a_of_type_ComTencentMobileqqModelFriendManager;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private jsp jdField_a_of_type_Jsp;
  private long jdField_b_of_type_Long;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString;
  private int g = -1;
  private int h = 0;
  private int i;
  private int j;
  private int r = 0;
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.e.setText("正在寻找此时与你做相同事情的人。");
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(false, false);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841979);
    if (paramInt == 3)
    {
      this.e.setText("此时没有找到与你做相同事情的人");
      return;
    }
    this.e.setText("查找失败，下拉重新查找。");
  }
  
  public static void a(BaseActivity paramBaseActivity, boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = (QQAppInterface)paramBaseActivity.getAppRuntime();
    if (!paramBoolean)
    {
      ((QQAppInterface)localObject).a().getSharedPreferences("mobileQQ", 0).edit().putBoolean("k_same_status_guide", false).commit();
      localObject = new Intent(paramBaseActivity, SameStatusActivity.class);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("k_action", paramInt1);
      ((Intent)localObject).putExtra("k_data", paramInt2);
      ((Intent)localObject).putExtra("k_friend", paramString);
      paramBaseActivity.startActivity((Intent)localObject);
      return;
      if (((QQAppInterface)localObject).a().getSharedPreferences("mobileQQ", 0).getBoolean("k_same_status_guide", true)) {
        localObject = new Intent(paramBaseActivity, SameStatusGuideActivity.class);
      } else {
        localObject = new Intent(paramBaseActivity, SameStatusActivity.class);
      }
    }
  }
  
  private void a(List paramList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new jsn(this);
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      paramList = paramList.iterator();
    }
    for (;;)
    {
      UserProfile localUserProfile;
      if (paramList.hasNext())
      {
        localUserProfile = (UserProfile)paramList.next();
        if (localUserProfile.vSig == null) {}
      }
      else
      {
        return;
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.toString(localUserProfile.lEctID), localUserProfile);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    stopTitleProgress();
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1000L);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      return;
    }
    a(1, getString(2131366939));
    this.jdField_a_of_type_ComTencentWidgetXListView.B();
  }
  
  private void b(int paramInt)
  {
    this.g = paramInt;
    switch (this.g)
    {
    default: 
      this.centerView.setText("做相同事情的人");
      return;
    case 1: 
      this.centerView.setText("做相同事情的人(女)");
      return;
    }
    this.centerView.setText("做相同事情的人(男)");
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqModelFriendManager = ((FriendManager)this.app.getManager(8));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.g = this.app.getPreferences().getInt("k_same_status_filter", -1);
    this.i = getIntent().getIntExtra("k_action", 0);
    this.j = getIntent().getIntExtra("k_data", 0);
    this.f = getIntent().getStringExtra("k_friend");
  }
  
  private void f()
  {
    Drawable localDrawable = getResources().getDrawable(2130838487);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    this.centerView.setCompoundDrawables(null, null, localDrawable, null);
    this.centerView.setOnClickListener(this);
    b(this.g);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131302229));
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837687);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130904441, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297591));
    this.e.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297590));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838136);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2130903418, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_Jsp = new jsp(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Jsp);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null)
    {
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = null;
    }
  }
  
  private void h()
  {
    d(new jso(this));
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null) {
      j();
    }
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setSelected(false);
    this.c.setSelected(false);
    this.jdField_b_of_type_AndroidWidgetTextView.setSelected(false);
    switch (this.g)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetTextView.setSelected(true);
    }
    for (;;)
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      int i1 = b();
      int i2 = (int)(localDisplayMetrics.density * 4.0F);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.getContentView().setPadding(0, i1 - i2, 0, 0);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(getWindow().getDecorView(), 80, 0, 0);
      return;
      this.c.setSelected(true);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setSelected(true);
    }
  }
  
  private void j()
  {
    View localView = getLayoutInflater().inflate(2130903316, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297674));
    ((TextView)localView.findViewById(2131297675)).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297677));
    this.c = ((TextView)localView.findViewById(2131297676));
    this.d = ((TextView)localView.findViewById(2131297678));
    this.d.setText("清除信息并退出");
    localView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localView, -1, -1, true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131558938);
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramInt2 == 201)) {}
    for (;;)
    {
      return;
      int i1 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt2 = 0;
      while (paramInt2 < i1)
      {
        SameStatusActivity.ItemViewHolder localItemViewHolder = (SameStatusActivity.ItemViewHolder)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt2).getTag();
        if ((localItemViewHolder != null) && (localItemViewHolder.jdField_a_of_type_Int == paramInt1)) {
          localItemViewHolder.c.setImageDrawable(new StatableBitmapDrawable(getResources(), paramBitmap, false, false));
        }
        paramInt2 += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.r != 2))
    {
      long l1 = Long.parseLong(paramString);
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((paramString != null) && ((paramString instanceof SameStatusActivity.ItemViewHolder)))
        {
          paramString = (SameStatusActivity.ItemViewHolder)paramString;
          if ((paramString.jdField_a_of_type_PersonalStateUserProfile != null) && (paramString.jdField_a_of_type_PersonalStateUserProfile.lEctID == l1)) {
            paramString.b.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(this.jdField_b_of_type_Long);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.r != paramInt)
    {
      this.r = paramInt;
      if (this.r != 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
        this.jdField_a_of_type_Jsp.notifyDataSetChanged();
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch ((int)paramLong)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.h != 3);
      paramAdapterView = (SameStatusActivity.MoreViewHolder)paramView.getTag();
      paramAdapterView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramAdapterView.jdField_a_of_type_AndroidWidgetTextView.setText("加载更多中...");
      this.h = 2;
      a(false, false);
      return;
      paramView = (SameStatusActivity.ItemViewHolder)paramView.getTag();
    } while ((paramView == null) || (paramView.jdField_a_of_type_PersonalStateUserProfile == null));
    paramAdapterView = Long.toString(paramView.jdField_a_of_type_PersonalStateUserProfile.lEctID);
    Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.c(paramAdapterView);
    if ((localFriends == null) || (!localFriends.isFriend())) {}
    for (paramAdapterView = new ProfileActivity.AllInOne(paramAdapterView, 56);; paramAdapterView = new ProfileActivity.AllInOne(paramAdapterView, 55))
    {
      paramAdapterView.h = paramView.jdField_a_of_type_PersonalStateUserProfile.strNick;
      paramAdapterView.b = paramView.jdField_a_of_type_PersonalStateUserProfile.vSig;
      paramAdapterView.g = 68;
      paramAdapterView.j = paramView.jdField_a_of_type_Int;
      ProfileActivity.b(this, paramAdapterView);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (NetworkUtil.e(this))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramBoolean1, this.g, this.i, this.j, this.f);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        a(1);
      }
      if (!paramBoolean2) {
        break label83;
      }
      stopTitleProgress();
    }
    label83:
    while (!paramBoolean1)
    {
      return;
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, 1, 0);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
      break;
    }
    startTitleProgress();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, List paramList, boolean paramBoolean3)
  {
    if (paramInt != this.g) {
      return;
    }
    a(paramBoolean1);
    if (paramBoolean1)
    {
      this.app.c(true, true);
      if (paramBoolean2)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        if ((paramList.size() > 0) && (((UserProfile)paramList.get(0)).vSig == null)) {
          a(paramList);
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
        if (!paramBoolean3) {
          break label129;
        }
        paramInt = 1;
        label88:
        this.h = paramInt;
        label93:
        if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
          break label151;
        }
        if (!paramBoolean1) {
          break label146;
        }
        paramInt = 3;
        label109:
        a(paramInt);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Jsp.notifyDataSetChanged();
      return;
      g();
      break;
      label129:
      paramInt = 0;
      break label88;
      if (paramBoolean2) {
        break label93;
      }
      this.h = 3;
      break label93;
      label146:
      paramInt = 2;
      break label109;
      label151:
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(false, false);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(this.jdField_b_of_type_Long);
    a(true, true);
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(this.jdField_b_of_type_Long);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    a(true, false);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentViewNoBackground(2130904446);
    e();
    f();
    b(new jsm(this));
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(null);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(false, false);
    }
    g();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    this.app.getPreferences().edit().putInt("k_same_status_filter", this.g);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b();
    super.finish();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      stopTitleProgress();
      this.jdField_a_of_type_ComTencentWidgetXListView.B();
    } while (paramMessage.arg1 != 1);
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      a(2);
    }
    a(1, 2131366939);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      i();
      return;
      b(-1);
      a(true, false);
      continue;
      b(0);
      a(true, false);
      continue;
      b(1);
      a(true, false);
      continue;
      h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SameStatusActivity
 * JD-Core Version:    0.7.0.1
 */