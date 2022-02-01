package com.tencent.mobileqq.dating;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
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
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheet.OnDismissListener;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import ica;
import icb;
import icc;
import icd;
import ice;
import icf;
import icg;
import ici;
import icj;
import ick;
import icl;
import icm;
import icn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DatingUserCenterActivity
  extends DatingExtraActivity
  implements View.OnClickListener, ActionSheet.OnButtonClickListener, ActionSheet.OnDismissListener, icn
{
  public static final int a = 4097;
  private static final long jdField_a_of_type_Long = 500L;
  private static final String jdField_a_of_type_JavaLangString = "server_stamp_of_joined";
  public static final int b = 4100;
  private static final String jdField_b_of_type_JavaLangString = "server_stamp_of_published";
  public static final int c = 4098;
  public static final int d = 4099;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 0;
  public static final int h = 1;
  private static final int i = 0;
  private static final int l = 4097;
  private static final int m = 4098;
  private static final int n = 4099;
  private static final int o = 4100;
  private static final int p = 4101;
  private static final int q = 4102;
  private static final int r = 8193;
  private static final int s = 8195;
  private static final int t = 8196;
  private static final int w = 8197;
  private static final int x = 8198;
  private static final int y = 20;
  private int A = 0;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new ica(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private DatingHandler jdField_a_of_type_ComTencentMobileqqDatingDatingHandler;
  private DatingObserver jdField_a_of_type_ComTencentMobileqqDatingDatingObserver = new icg(this);
  private DatingUserCenterAdapter jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterAdapter;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = { -1, -1 };
  private long[] jdField_a_of_type_ArrayOfLong = { 0L, 0L };
  private boolean[] jdField_a_of_type_ArrayOfBoolean = { 1, 1 };
  private Handler.Callback jdField_b_of_type_AndroidOsHandler$Callback = new ice(this);
  private Handler jdField_b_of_type_AndroidOsHandler;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean[] jdField_b_of_type_ArrayOfBoolean = { 0, 0 };
  private boolean[] c = { 0, 0 };
  private boolean[] d = { 0, 0 };
  private boolean[] e;
  private int j = 0;
  private int k = 0;
  private int z;
  
  public DatingUserCenterActivity()
  {
    this.jdField_e_of_type_ArrayOfBoolean = new boolean[] { 0, 0 };
  }
  
  private int a(String paramString)
  {
    return getSharedPreferences(this.app.a(), 0).getInt(paramString, 0);
  }
  
  private View.OnClickListener a()
  {
    return new ici(this);
  }
  
  private FaceDecoder.DecodeTaskCompletionListener a()
  {
    return new icl(this);
  }
  
  private TabBarView.OnTabChangeListener a()
  {
    return new icf(this);
  }
  
  private AbsListView.OnScrollListener a()
  {
    return new icm(this);
  }
  
  private OverScrollViewListener a()
  {
    return new ick(this);
  }
  
  private void a()
  {
    setTitle(2131369669);
    if (getIntent() != null) {
      setLeftViewName(2131365114);
    }
    for (;;)
    {
      onCreateRightView();
      this.rightViewImg.setImageResource(2130838415);
      this.rightViewImg.setOnClickListener(this);
      this.rightViewImg.setContentDescription(getString(2131369659));
      this.leftView.setVisibility(0);
      this.rightViewImg.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131300078);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(a());
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131300076));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131369672));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131369673));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(a());
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).a(false);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131300077));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2130903418, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(a());
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(a());
      this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837687);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this).inflate(2130903377, null));
      this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_AndroidWidgetLinearLayout, null, false);
      a(false, false);
      this.z = ((int)(getResources().getDisplayMetrics().density * 60.0F));
      this.jdField_a_of_type_ComTencentWidgetXListView.setFooterDividersEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setHeaderDividersEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterAdapter = new DatingUserCenterAdapter(this, this.app, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this.z, this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
      return;
      setLeftViewName(2131369656);
    }
  }
  
  private void a(int paramInt)
  {
    this.k = this.j;
    this.j = paramInt;
    if (this.jdField_e_of_type_ArrayOfBoolean[this.j] != 0)
    {
      startTitleProgress();
      if (this.jdField_b_of_type_ArrayOfBoolean[this.k] != 0) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4098);
      }
      if (this.jdField_b_of_type_ArrayOfBoolean[this.j] != 0) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(this.jdField_a_of_type_ArrayOfLong[this.j]);
      }
      if (this.c[this.j] == 0) {
        break label263;
      }
      a(true, this.d[this.j]);
      label107:
      if (paramInt != 1) {
        break label323;
      }
      if ((this.jdField_a_of_type_ArrayOfBoolean[1] == 0) || (this.jdField_e_of_type_ArrayOfBoolean[1] != 0)) {
        break label280;
      }
      a(1, this.jdField_a_of_type_JavaUtilList, false, false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterAdapter);
      startTitleProgress();
      this.jdField_e_of_type_ArrayOfBoolean[1] = true;
      localObject = new Message();
      ((Message)localObject).arg1 = 1;
      ((Message)localObject).what = 8193;
      this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).setContentDescription(getString(2131369672));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("已选定 ");
      ((StringBuilder)localObject).append(getString(2131369673));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setContentDescription(((StringBuilder)localObject).toString());
    }
    label263:
    label280:
    label323:
    while (paramInt != 0)
    {
      return;
      stopTitleProgress();
      break;
      a(false, this.d[this.j]);
      break label107;
      localObject = this.jdField_a_of_type_JavaUtilList;
      if (this.jdField_e_of_type_ArrayOfBoolean[1] == 0) {}
      for (bool = true;; bool = false)
      {
        a(1, (List)localObject, false, bool);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterAdapter);
        break;
      }
    }
    if ((this.jdField_a_of_type_ArrayOfBoolean[0] != 0) && (getIntent() != null) && (!TextUtils.isEmpty(getIntent().getStringExtra("new_id"))))
    {
      a(0, this.jdField_b_of_type_JavaUtilList, false, false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterAdapter);
      startTitleProgress();
      this.jdField_e_of_type_ArrayOfBoolean[0] = true;
      paramInt = a("server_stamp_of_published");
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingHandler.a(paramInt, 0, 20, 0, 4097);
    }
    for (;;)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("已选定 ");
      ((StringBuilder)localObject).append(getString(2131369672));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).setContentDescription(((StringBuilder)localObject).toString());
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setContentDescription(getString(2131369673));
      return;
      if ((this.jdField_a_of_type_ArrayOfBoolean[0] == 0) || (this.jdField_e_of_type_ArrayOfBoolean[0] != 0)) {
        break;
      }
      a(0, this.jdField_b_of_type_JavaUtilList, false, false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterAdapter);
      startTitleProgress();
      this.jdField_e_of_type_ArrayOfBoolean[0] = true;
      localObject = new Message();
      ((Message)localObject).what = 8193;
      ((Message)localObject).arg1 = 0;
      this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    }
    Object localObject = this.jdField_b_of_type_JavaUtilList;
    if (this.jdField_e_of_type_ArrayOfBoolean[0] == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(0, (List)localObject, false, bool);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterAdapter);
      break;
    }
  }
  
  private void a(int paramInt, List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, -this.z, 0, 0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterAdapter.a(paramInt, paramList, paramBoolean1, paramBoolean2);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4102);
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 0, 0);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = getSharedPreferences(this.app.a(), 0).edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject = (DatingManager)this.app.getManager(67);
    if (localObject != null)
    {
      paramString1 = ((DatingManager)localObject).a().a(paramString1, true, false, true);
      paramString2 = ((DatingManager)localObject).a().a(paramString2, true, false, true);
      localObject = new ArrayList();
      if (paramString1 != null) {
        ((List)localObject).add(paramString1);
      }
      if (paramString2 != null) {
        ((List)localObject).add(paramString2);
      }
      a((List)localObject);
      if (this.j == 1) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
      }
    }
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (this.jdField_b_of_type_JavaUtilList == null)
    {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      this.jdField_b_of_type_JavaUtilList.addAll(paramList);
      return;
    }
    paramList = paramList.iterator();
    label51:
    label241:
    for (;;)
    {
      DatingInfo localDatingInfo1;
      if (paramList.hasNext())
      {
        localDatingInfo1 = (DatingInfo)paramList.next();
        if ((localDatingInfo1 != null) && (!TextUtils.isEmpty(localDatingInfo1.datingId)))
        {
          Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            DatingInfo localDatingInfo2 = (DatingInfo)localIterator.next();
            if ((localDatingInfo2 != null) && (localDatingInfo1.datingId.equals(localDatingInfo2.datingId)))
            {
              localDatingInfo2.datingStatus = localDatingInfo1.datingStatus;
              localDatingInfo2.datingApplyWording = localDatingInfo1.datingApplyWording;
              localDatingInfo2.datingVisitWording = localDatingInfo1.datingVisitWording;
            }
          }
        }
      }
      else
      {
        for (int i1 = 1;; i1 = 0)
        {
          if (i1 != 0) {
            break label241;
          }
          this.jdField_b_of_type_JavaUtilList.add(0, localDatingInfo1);
          i1 = this.jdField_b_of_type_JavaUtilList.size();
          if ((this.d[0] == 0) || (i1 <= 20) || (i1 % 20 != 1)) {
            break label51;
          }
          this.jdField_b_of_type_JavaUtilList.remove(this.jdField_b_of_type_JavaUtilList.size() - 1);
          break label51;
          break;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 8;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      return;
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297997);
    ProgressBar localProgressBar = (ProgressBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296735);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297996);
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        i1 = 2131366571;
        localTextView.setText(i1);
        if (!paramBoolean1) {
          break label119;
        }
        i1 = 0;
        label81:
        localProgressBar.setVisibility(i1);
        if (!paramBoolean1) {
          break label125;
        }
      }
      label119:
      label125:
      for (int i1 = i2;; i1 = 0)
      {
        localImageView.setVisibility(i1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(b());
        return;
        i1 = 2131366569;
        break;
        i1 = 8;
        break label81;
      }
    }
    localTextView.setText(2131369719);
    localProgressBar.setVisibility(8);
    localImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
  }
  
  private View.OnClickListener b()
  {
    return new icj(this);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler = new CustomHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_b_of_type_AndroidOsHandler = new CustomHandler(ThreadManager.b(), this.jdField_b_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingHandler = ((DatingHandler)this.app.a(40));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    this.jdField_a_of_type_ArrayOfLong[0] = (a("server_stamp_of_published") * 1000L);
    this.jdField_a_of_type_ArrayOfLong[1] = (a("server_stamp_of_joined") * 1000L);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(BaseApplication.getContext(), this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(a());
  }
  
  private void c()
  {
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(8196);
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void c(int paramInt)
  {
    boolean bool2 = false;
    if (paramInt == 1) {}
    for (List localList = this.jdField_a_of_type_JavaUtilList; localList.size() == 0; localList = this.jdField_b_of_type_JavaUtilList) {
      return;
    }
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < localList.size())
      {
        if (((DatingInfo)localList.get(i1)).datingStatus == 0) {
          bool1 = true;
        }
      }
      else
      {
        a(paramInt, null, true, bool1);
        return;
      }
      i1 += 1;
    }
  }
  
  private void d()
  {
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(8197);
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void d(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1) {}
    for (List localList = this.jdField_a_of_type_JavaUtilList; localList.size() == 0; localList = this.jdField_b_of_type_JavaUtilList) {
      return;
    }
    String str = ((DatingInfo)localList.get(0)).datingId;
    int i1 = this.j;
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(8195);
    localMessage.obj = new Object[] { str, Boolean.valueOf(true), Integer.valueOf(i1) };
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
    i1 = 0;
    while (i1 < localList.size())
    {
      localArrayList.add(((DatingInfo)localList.get(i1)).datingId);
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterAdapter.a(this.jdField_a_of_type_ComTencentWidgetXListView, localArrayList);
    if (paramInt == 0) {
      ((DatingManager)this.app.getManager(67)).a(null);
    }
    if (paramInt == 0)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004F1E", "0X8004F1E", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004F1D", "0X8004F1D", 0, 0, "", "", "", "");
  }
  
  private void d(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterAdapter.a(this.jdField_a_of_type_ComTencentWidgetXListView, paramString);
    int i1 = this.j;
    Object localObject = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(8195);
    ((Message)localObject).obj = new Object[] { paramString, Boolean.valueOf(false), Integer.valueOf(i1) };
    this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    if (paramInt == 0)
    {
      localObject = (DatingManager)this.app.getManager(67);
      String str = ((DatingManager)localObject).d();
      if ((!TextUtils.isEmpty(str)) && (str.equals(paramString))) {
        ((DatingManager)localObject).a(null);
      }
    }
    if (paramInt == 0)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004F20", "0X8004F20", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004F1F", "0X8004F1F", 0, 0, "", "", "", "");
  }
  
  private void e(int paramInt)
  {
    boolean bool2 = false;
    this.A = paramInt;
    if (paramInt == 0) {
      if ((getIntent() != null) && (this.jdField_e_of_type_Boolean))
      {
        setLeftViewName(2131365114);
        this.rightViewImg.setImageResource(2130838415);
        this.rightViewImg.setOnClickListener(this);
        this.rightViewImg.setContentDescription(getString(2131369659));
        this.leftView.setVisibility(0);
        this.rightViewImg.setVisibility(0);
        this.leftViewNotBack.setVisibility(8);
        this.rightViewText.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterAdapter.a(this.A);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        return;
        setLeftViewName(2131369656);
      }
    }
    setLeftButton(2131369660, this);
    setRightButton(2131369661, this);
    this.leftView.setVisibility(8);
    this.rightViewImg.setVisibility(8);
    this.leftViewNotBack.setVisibility(0);
    this.rightViewText.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterAdapter.a(this.A);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    boolean bool1;
    if ((this.j != 0) || (this.jdField_b_of_type_JavaUtilList.size() <= 0))
    {
      bool1 = bool2;
      if (this.j == 1)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {}
      }
    }
    else
    {
      bool1 = true;
    }
    enableLeftBtn(bool1);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131369658);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.e(2131365736);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this);
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
      ReportController.b(this.app, "CliOper", "", "", "0X8004F1C", "0X8004F1C", 0, 0, "", "", "", "");
      e(1);
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 0;
    int i1;
    if (paramInt == 0) {
      if (paramBoolean2) {
        if (paramBoolean1)
        {
          i1 = 2131369663;
          if (i1 != 0) {
            break label101;
          }
        }
      }
    }
    label101:
    do
    {
      return;
      i1 = 2131369662;
      break;
      i1 = i2;
      if (!paramBoolean1) {
        break;
      }
      i1 = 2131369664;
      break;
      i1 = i2;
      if (paramInt != 1) {
        break;
      }
      if (paramBoolean2)
      {
        if (paramBoolean1)
        {
          i1 = 2131369666;
          break;
        }
        i1 = 2131369665;
        break;
      }
      i1 = i2;
      if (!paramBoolean1) {
        break;
      }
      i1 = 2131369667;
      break;
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, i1, 2131365736, 2131369668, new icb(this), new icc(this, paramBoolean1, paramInt, paramString));
    } while (this.jdField_a_of_type_AndroidAppDialog == null);
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void a(int paramInt, Collection paramCollection)
  {
    ArrayList localArrayList;
    if (paramInt == 0) {
      if ((this.jdField_b_of_type_JavaUtilList != null) && (paramCollection != null))
      {
        localArrayList = new ArrayList();
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext())
        {
          paramInt = ((Integer)paramCollection.next()).intValue();
          if (paramInt < this.jdField_b_of_type_JavaUtilList.size()) {
            localArrayList.add(this.jdField_b_of_type_JavaUtilList.get(paramInt));
          }
        }
        if (this.jdField_b_of_type_JavaUtilList.removeAll(localArrayList)) {
          a(0, this.jdField_b_of_type_JavaUtilList, true, true);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while ((paramInt != 1) || (this.jdField_a_of_type_JavaUtilList == null) || (paramCollection == null));
      localArrayList = new ArrayList();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        paramInt = ((Integer)paramCollection.next()).intValue();
        if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
          localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(paramInt));
        }
      }
    } while (!this.jdField_a_of_type_JavaUtilList.removeAll(localArrayList));
    a(1, this.jdField_a_of_type_JavaUtilList, true, true);
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    ThreadManager.c(new icd(this, paramArrayOfObject));
  }
  
  public void b(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingHandler, paramString);
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    Object localObject;
    if (paramInt == 1)
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      if (((List)localObject).size() != 0) {
        break label31;
      }
    }
    label31:
    label118:
    for (;;)
    {
      return;
      localObject = this.jdField_b_of_type_JavaUtilList;
      break;
      int i1 = 0;
      if (i1 < ((List)localObject).size()) {
        if (!((DatingInfo)((List)localObject).get(i1)).datingId.equals(paramString)) {}
      }
      for (localObject = (DatingInfo)((List)localObject).get(i1);; localObject = null)
      {
        if (localObject == null) {
          break label118;
        }
        if (((DatingInfo)localObject).datingStatus == 0)
        {
          a(paramInt, paramString, false, true);
          return;
          i1 += 1;
          break;
        }
        d(paramInt, paramString);
        return;
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903913);
    getWindow().setBackgroundDrawable(null);
    b();
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
  
  @TargetApi(9)
  protected void doOnResume()
  {
    super.doOnResume();
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterAdapter.notifyDataSetChanged();
    }
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
    } while (this.j != 0);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterAdapter.a(true);
    a(0, this.jdField_b_of_type_JavaUtilList, true, true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4101, 500L);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 4097) && (paramInt2 == -1)) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      Intent localIntent = new Intent(this, DatingFeedActivity.class);
      localIntent.putExtra("abp_flag", this.jdField_e_of_type_Boolean);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131297358) {
      c(this.j);
    }
    do
    {
      return;
      if (paramView.getId() == 2131297360)
      {
        e(0);
        c();
        d();
        return;
      }
    } while (paramView.getId() != 2131297361);
    g();
  }
  
  public void onDismiss()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingUserCenterActivity
 * JD-Core Version:    0.7.0.1
 */