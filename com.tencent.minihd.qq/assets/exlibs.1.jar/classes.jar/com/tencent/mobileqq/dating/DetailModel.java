package com.tencent.mobileqq.dating;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.dating.widget.CustomTabBarView;
import com.tencent.mobileqq.dating.widget.DatingInputPopupWindow;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.XListView;
import ict;
import icu;
import icv;
import icw;
import icx;
import icy;
import icz;
import idb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class DetailModel
  implements View.OnClickListener, DatingDetailItemView.IDatingDetailItemViewCallback, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener, ActionSheet.OnButtonClickListener
{
  protected static final int A = 12;
  protected static final int B = 13;
  protected static final int C = 14;
  protected static final int D = 15;
  protected static final int E = 16;
  public static final int G = 61;
  public static final int H = 60;
  private static final int J = 1;
  private static final int K = 44;
  private static final int L = 25;
  public static final int a = 0;
  protected static final short a = 15;
  public static final int b = 1;
  protected static final short b = 1;
  public static final int c = 0;
  protected static final short c = 240;
  public static final int d = 1;
  protected static final short d = 16;
  public static final int e = 2;
  protected static final short e = 32;
  public static final int f = 3;
  public static final int g = 4;
  public static final int h = 0;
  public static final int i = 1;
  public static final int j = 2;
  public static final int k = 1;
  public static final int l = 2;
  public static final int m = 20;
  protected static final int n = -1;
  protected static final int o = 0;
  protected static final int p = 1;
  protected static final int q = 2;
  protected static final int r = 3;
  protected static final int s = 4;
  protected static final int t = 5;
  protected static final int u = 6;
  protected static final int v = 7;
  protected static final int w = 8;
  protected static final int x = 9;
  protected static final int y = 10;
  protected static final int z = 11;
  public final int F;
  public int I = 3;
  private int M;
  private int N;
  private int O;
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  public Dialog a;
  protected View a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  URLDrawable.URLDrawableOptions jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions;
  public DatingInfo a;
  public DatingDetailActivity a;
  protected DatingDetailAdapter a;
  DatingHandler jdField_a_of_type_ComTencentMobileqqDatingDatingHandler;
  DatingManager jdField_a_of_type_ComTencentMobileqqDatingDatingManager;
  protected DatingShareHelper a;
  public CustomTabBarView a;
  protected FaceDecoder a;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  protected CustomImgView a;
  public XListView a;
  private String jdField_a_of_type_JavaLangString = "0";
  protected StringBuilder a;
  private boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  protected List[] a;
  private boolean[] jdField_a_of_type_ArrayOfBoolean = { 0, 0, 0 };
  protected long b;
  protected View b;
  protected ImageView b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  protected TextView b;
  public CustomTabBarView b;
  protected CustomImgView b;
  private String jdField_b_of_type_JavaLangString = "0";
  private boolean jdField_b_of_type_Boolean = false;
  private int[] jdField_b_of_type_ArrayOfInt = new int[3];
  private boolean[] jdField_b_of_type_ArrayOfBoolean = { 0, 0, 0 };
  private View jdField_c_of_type_AndroidViewView;
  protected ImageView c;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  protected TextView c;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean[] jdField_c_of_type_ArrayOfBoolean = { 0, 0, 0 };
  private View jdField_d_of_type_AndroidViewView;
  protected ImageView d;
  protected TextView d;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean[] jdField_d_of_type_ArrayOfBoolean = { 0, 0, 0 };
  protected ImageView e;
  protected TextView e;
  private boolean e;
  protected ImageView f;
  protected TextView f;
  protected ImageView g;
  protected TextView g;
  protected ImageView h;
  protected TextView h;
  protected ImageView i;
  protected TextView i;
  protected TextView j;
  protected TextView k;
  protected TextView l;
  protected TextView m;
  private TextView n;
  
  protected DetailModel(DatingDetailActivity paramDatingDetailActivity, int paramInt, DatingInfo paramDatingInfo, CustomTabBarView paramCustomTabBarView)
  {
    this.jdField_a_of_type_ArrayOfJavaUtilList = new List[3];
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity = paramDatingDetailActivity;
    this.F = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingHandler = ((DatingHandler)this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.app.a(40));
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager = ((DatingManager)this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.app.getManager(67));
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo = paramDatingInfo;
    this.M = paramDatingInfo.datingCommentNum;
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView = paramCustomTabBarView;
  }
  
  private void a(View paramView1, View paramView2)
  {
    if ((paramView1 == null) || (paramView2 == null)) {
      return;
    }
    paramView2.setVisibility(paramView1.getVisibility());
  }
  
  private void a(DatingComment paramDatingComment)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, null);
    localActionSheet.a("要删除这条评论吗？");
    localActionSheet.c("确认");
    localActionSheet.e(2131365736);
    localActionSheet.a(new idb(this, localActionSheet, paramDatingComment));
    localActionSheet.show();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
      return;
    }
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131297997);
    ProgressBar localProgressBar = (ProgressBar)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131296735);
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131297996);
    if (localImageView.getVisibility() != 8) {
      localImageView.setVisibility(8);
    }
    int i1;
    if ((this.jdField_a_of_type_ArrayOfJavaUtilList[this.I] != null) && (!this.jdField_a_of_type_ArrayOfJavaUtilList[this.I].isEmpty()))
    {
      i1 = 1;
      if (i1 != 0) {
        break label197;
      }
      if (this.I != 1) {
        break label160;
      }
      localTextView.setText("还没有人评论");
    }
    for (;;)
    {
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources().getColor(2131427972));
      localProgressBar.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      return;
      i1 = 0;
      break;
      label160:
      if (this.I == 2) {
        localTextView.setText("还没有人报名");
      } else if (this.I == 0) {
        localTextView.setText("还没有人看过");
      }
    }
    label197:
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources().getColor(2131427972));
        localTextView.setText("正在加载");
        localProgressBar.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setTag(-1, Integer.valueOf(14));
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        return;
        localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources().getColor(2131428001));
        localTextView.setText("加载更多");
        localProgressBar.setVisibility(8);
      }
    }
    if (this.I == 1) {
      localTextView.setText("已是全部评论");
    }
    for (;;)
    {
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources().getColor(2131427972));
      localProgressBar.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      return;
      if (this.I == 2) {
        localTextView.setText("已是全部报名的人");
      } else if (this.I == 0) {
        localTextView.setText("已是全部看过的人");
      }
    }
  }
  
  private void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.setCurrentTab(paramInt);
      i1 = this.jdField_a_of_type_ComTencentWidgetXListView.s();
      this.jdField_a_of_type_ArrayOfInt[this.I] = i1;
      this.jdField_b_of_type_ArrayOfInt[this.I] = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(0).getTop();
      i1 = this.I;
      this.I = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailAdapter.a(this.I, this.jdField_a_of_type_ArrayOfJavaUtilList[this.I], true);
      if (this.jdField_a_of_type_Boolean) {
        break label324;
      }
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.a(this.n);
        this.jdField_c_of_type_Boolean = false;
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidWidgetLinearLayout);
        this.jdField_d_of_type_Boolean = false;
      }
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_c_of_type_AndroidWidgetLinearLayout);
        this.jdField_e_of_type_Boolean = false;
      }
      label163:
      a(this.jdField_b_of_type_ArrayOfBoolean[this.I], this.jdField_d_of_type_ArrayOfBoolean[this.I]);
      b(this.jdField_a_of_type_ArrayOfBoolean[this.I], this.jdField_c_of_type_ArrayOfBoolean[this.I]);
      if (this.jdField_d_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_d_of_type_AndroidViewView);
      }
      if (!paramBoolean2) {
        break label804;
      }
      if (this.jdField_a_of_type_ArrayOfInt[i1] < 1) {
        break label775;
      }
      this.jdField_a_of_type_ArrayOfInt[this.I] = 1;
      this.jdField_b_of_type_ArrayOfInt[this.I] = 0;
      label261:
      b(this.jdField_a_of_type_ArrayOfInt[this.I], this.jdField_b_of_type_ArrayOfInt[this.I]);
      if (this.I != 2) {
        break label903;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.owner == 1) {
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004F44");
      }
    }
    label324:
    do
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.setCurrentTab(paramInt);
      break;
      if (paramInt == 0)
      {
        if ((this.jdField_a_of_type_ArrayOfJavaUtilList[paramInt] != null) && (!this.jdField_a_of_type_ArrayOfJavaUtilList[paramInt].isEmpty()))
        {
          if (!this.jdField_c_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentWidgetXListView.a(this.n);
            this.jdField_c_of_type_Boolean = true;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.owner == 1) && (this.jdField_d_of_type_ArrayOfBoolean[this.I] != 0)) {
            if (!this.jdField_d_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidWidgetLinearLayout);
              this.jdField_d_of_type_Boolean = true;
            }
          }
        }
        for (;;)
        {
          if ((this.jdField_c_of_type_AndroidWidgetLinearLayout == null) || (!this.jdField_e_of_type_Boolean)) {
            break label529;
          }
          this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_c_of_type_AndroidWidgetLinearLayout);
          this.jdField_e_of_type_Boolean = false;
          break;
          if (this.jdField_d_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidWidgetLinearLayout);
            this.jdField_d_of_type_Boolean = false;
            continue;
            if (this.jdField_c_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentWidgetXListView.a(this.n);
              this.jdField_c_of_type_Boolean = false;
            }
            if (!this.jdField_d_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidWidgetLinearLayout);
              this.jdField_d_of_type_Boolean = true;
            }
          }
        }
        break label163;
      }
      if (this.jdField_c_of_type_AndroidWidgetLinearLayout != null)
      {
        if ((this.jdField_c_of_type_ArrayOfBoolean[this.I] == 0) || (this.jdField_e_of_type_Boolean)) {
          break label659;
        }
        this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_c_of_type_AndroidWidgetLinearLayout);
      }
      for (this.jdField_e_of_type_Boolean = true;; this.jdField_e_of_type_Boolean = false)
      {
        do
        {
          if ((this.n != null) && (this.jdField_c_of_type_Boolean))
          {
            this.jdField_a_of_type_ComTencentWidgetXListView.a(this.n);
            this.jdField_c_of_type_Boolean = false;
          }
          if ((this.jdField_a_of_type_ArrayOfJavaUtilList[this.I] != null) && (!this.jdField_a_of_type_ArrayOfJavaUtilList[this.I].isEmpty())) {
            break label698;
          }
          if (this.jdField_d_of_type_Boolean) {
            break;
          }
          this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidWidgetLinearLayout);
          this.jdField_d_of_type_Boolean = true;
          break;
        } while ((this.jdField_c_of_type_ArrayOfBoolean[this.I] != 0) || (!this.jdField_e_of_type_Boolean));
        this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_c_of_type_AndroidWidgetLinearLayout);
      }
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_d_of_type_ArrayOfBoolean[this.I] == 0))
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidWidgetLinearLayout);
        this.jdField_d_of_type_Boolean = false;
        break label163;
      }
      if ((this.jdField_d_of_type_Boolean) || (this.jdField_d_of_type_ArrayOfBoolean[this.I] == 0)) {
        break label163;
      }
      this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidWidgetLinearLayout);
      this.jdField_d_of_type_Boolean = true;
      break label163;
      this.jdField_a_of_type_ArrayOfInt[this.I] = 0;
      this.jdField_b_of_type_ArrayOfInt[this.I] = this.jdField_b_of_type_ArrayOfInt[i1];
      break label261;
      if ((this.jdField_a_of_type_ArrayOfInt[i1] >= 1) && (this.jdField_a_of_type_ArrayOfInt[this.I] >= 1)) {
        break label261;
      }
      if ((this.jdField_a_of_type_ArrayOfInt[i1] >= 1) && (this.jdField_a_of_type_ArrayOfInt[this.I] == 0))
      {
        this.jdField_a_of_type_ArrayOfInt[this.I] = 1;
        this.jdField_b_of_type_ArrayOfInt[this.I] = 0;
        break label261;
      }
      this.jdField_a_of_type_ArrayOfInt[this.I] = 0;
      this.jdField_b_of_type_ArrayOfInt[this.I] = this.jdField_b_of_type_ArrayOfInt[i1];
      break label261;
      if (this.I == 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.owner == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004986");
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004F41");
        return;
      }
    } while (this.I != 1);
    label529:
    label659:
    label698:
    if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.owner == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004F42");
      return;
    }
    label775:
    label804:
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004F43");
    label903:
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_c_of_type_AndroidWidgetLinearLayout == null) {
      return;
    }
    TextView localTextView = (TextView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131297997);
    ProgressBar localProgressBar = (ProgressBar)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131296735);
    ImageView localImageView = (ImageView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131297996);
    if (localImageView.getVisibility() != 8) {
      localImageView.setVisibility(8);
    }
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources().getColor(2131427972));
        localTextView.setText("正在加载");
        localProgressBar.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setTag(-1, Integer.valueOf(15));
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        return;
      }
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources().getColor(2131428001));
      if (this.I == 1) {
        localTextView.setText("展开更新评论");
      }
      for (;;)
      {
        localProgressBar.setVisibility(8);
        break;
        if (this.I == 2) {
          localTextView.setText("展开更多报名的人");
        } else if (this.I == 0) {
          localTextView.setText("展开更多看过的人");
        }
      }
    }
    localTextView.setText("暂无更多内容");
    localProgressBar.setVisibility(8);
    localImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0) {
      return;
    }
    int i3 = this.jdField_a_of_type_ComTencentWidgetXListView.m();
    if (this.N <= 0) {
      this.N = this.jdField_b_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.getBottom();
    }
    if (this.O <= 0) {
      this.O = this.jdField_a_of_type_ComTencentWidgetXListView.getBottom();
    }
    int i2 = this.N;
    int i1 = i2;
    if (this.jdField_e_of_type_Boolean) {
      i1 = (int)(i2 + 60.0F * this.jdField_a_of_type_Float);
    }
    i1 = (int)(i1 + (paramInt2 + 1) * 61 * this.jdField_a_of_type_Float);
    if (this.I == paramInt1)
    {
      if (this.O >= i1)
      {
        b(0, 0);
        return;
      }
      paramInt1 = (int)(this.jdField_a_of_type_Float * 44.0F);
      this.jdField_b_of_type_Boolean = true;
      b(i3 + paramInt2, paramInt1);
      return;
    }
    if (this.O >= i1)
    {
      this.jdField_a_of_type_ArrayOfInt[paramInt1] = 0;
      this.jdField_b_of_type_ArrayOfInt[paramInt1] = 0;
      return;
    }
    this.jdField_a_of_type_ArrayOfInt[paramInt1] = (i3 + paramInt2);
    this.jdField_b_of_type_ArrayOfInt[paramInt1] = ((int)(this.jdField_a_of_type_Float * 44.0F));
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    DatingUtil.a("DetailGuset.OnClick", new Object[] { Integer.valueOf(paramInt), this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo });
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId)) {}
    label37:
    long l1;
    do
    {
      do
      {
        break label37;
        break label37;
        do
        {
          return;
        } while (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) < 1000L);
        if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.hide();
        }
        if (paramInt == 0)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.owner == 1) {
            this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004C9A");
          }
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingShareHelper == null) {
              this.jdField_a_of_type_ComTencentMobileqqDatingDatingShareHelper = new DatingShareHelper(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity);
            }
            this.jdField_a_of_type_ComTencentMobileqqDatingDatingShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo);
            return;
            this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004C9B");
          }
        }
      } while (paramInt != 1);
      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.owner == 1) {
        break;
      }
      l1 = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherID;
    } while (l1 == 0L);
    ReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, 405, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId, "0", this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.app.a(), String.valueOf(l1), "0");
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X800494B");
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager != null) {}
    for (paramInt = this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.b();; paramInt = 0)
    {
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X800494C");
        return;
      }
      if (paramInt != 2) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X800494D");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingStatus != 0) {
        break;
      }
      b(5, null);
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXListView.s();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingShareHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingShareHelper.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.M = paramInt;
    f();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.a(1, "评论成功", 0);
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    int i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1);
      if (localView != null) {}
      for (Object localObject = localView.getTag(-1);; localObject = null)
      {
        if ((localObject != null) && (localObject.equals(Integer.valueOf(paramInt1)))) {
          a(localView, paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5, paramInt6);
        }
        i1 += 1;
        break;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, List paramList, String paramString, Object paramObject)
  {
    if ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 4))
    {
      if ((paramInt2 == 1) && (paramList != null))
      {
        if (paramInt3 != 1) {
          break label429;
        }
        if ((paramList.get(0) instanceof DatingComment)) {
          this.jdField_b_of_type_JavaLangString = ((DatingComment)paramList.get(0)).jdField_a_of_type_JavaLangString;
        }
      }
      if (paramInt3 == 1)
      {
        if (this.jdField_a_of_type_ArrayOfJavaUtilList[paramInt2] == null) {
          this.jdField_a_of_type_ArrayOfJavaUtilList[paramInt2] = new ArrayList();
        }
        if ((paramList != null) && (!paramList.isEmpty())) {
          this.jdField_a_of_type_ArrayOfJavaUtilList[paramInt2].addAll(0, paramList);
        }
        label119:
        paramString = this.jdField_d_of_type_ArrayOfBoolean;
        if (paramBoolean2) {
          break label677;
        }
        paramBoolean2 = true;
        label133:
        paramString[paramInt2] = paramBoolean2;
        paramString = this.jdField_c_of_type_ArrayOfBoolean;
        if (paramBoolean1) {
          break label683;
        }
        paramBoolean1 = true;
        label153:
        paramString[paramInt2] = paramBoolean1;
        if ((this.I == paramInt2) && (this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailAdapter != null)) {
          this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailAdapter.a(this.I, this.jdField_a_of_type_ArrayOfJavaUtilList[paramInt2], true);
        }
        label192:
        if (paramInt1 != 0) {
          break label697;
        }
        this.jdField_b_of_type_ArrayOfBoolean[paramInt2] = true;
        this.jdField_d_of_type_ArrayOfBoolean[paramInt2] = true;
        label210:
        if (this.I == paramInt2)
        {
          if ((this.jdField_d_of_type_AndroidViewView != null) && (paramInt1 != 4)) {
            this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_d_of_type_AndroidViewView);
          }
          if (this.I != 0) {
            break label949;
          }
          if (this.jdField_a_of_type_Boolean) {
            break label771;
          }
          if (this.jdField_c_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentWidgetXListView.a(this.n);
            this.jdField_c_of_type_Boolean = false;
          }
          if (this.jdField_d_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidWidgetLinearLayout);
            this.jdField_d_of_type_Boolean = false;
          }
          a(this.jdField_b_of_type_ArrayOfBoolean[paramInt2], this.jdField_d_of_type_ArrayOfBoolean[paramInt2]);
          b(this.jdField_a_of_type_ArrayOfBoolean[paramInt2], this.jdField_c_of_type_ArrayOfBoolean[paramInt2]);
        }
        label304:
        if (paramInt3 == 3)
        {
          if (paramInt2 != 2) {
            break label1275;
          }
          if (((paramObject instanceof Integer)) && (paramList != null))
          {
            paramInt3 = ((Integer)paramObject).intValue();
            paramInt1 = 0;
            label370:
            if (paramInt1 >= paramList.size()) {
              break label1377;
            }
            if ((paramList.get(paramInt1) == null) || (((DatingStranger)paramList.get(paramInt1)).f != paramInt3)) {
              break label1268;
            }
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.post(new icu(this, paramInt2, paramInt1));
      label429:
      label697:
      label1229:
      label1266:
      label1268:
      label1275:
      do
      {
        return;
        if (paramInt3 == 2)
        {
          if (!(paramList.get(paramList.size() - 1) instanceof DatingComment)) {
            break;
          }
          this.jdField_a_of_type_JavaLangString = ((DatingComment)paramList.get(paramList.size() - 1)).jdField_a_of_type_JavaLangString;
          break;
        }
        if ((paramInt3 != 3) && (paramInt3 != 0) && (paramInt3 != 4)) {
          break;
        }
        if ((paramList.get(0) instanceof DatingComment)) {
          this.jdField_b_of_type_JavaLangString = ((DatingComment)paramList.get(0)).jdField_a_of_type_JavaLangString;
        }
        if (!(paramList.get(paramList.size() - 1) instanceof DatingComment)) {
          break;
        }
        this.jdField_a_of_type_JavaLangString = ((DatingComment)paramList.get(paramList.size() - 1)).jdField_a_of_type_JavaLangString;
        break;
        if (paramInt3 == 2)
        {
          if (this.jdField_a_of_type_ArrayOfJavaUtilList[paramInt2] == null) {
            this.jdField_a_of_type_ArrayOfJavaUtilList[paramInt2] = new ArrayList();
          }
          if ((paramList == null) || (paramList.isEmpty())) {
            break label119;
          }
          this.jdField_a_of_type_ArrayOfJavaUtilList[paramInt2].addAll(paramList);
          break label119;
        }
        if (paramInt3 == 3)
        {
          this.jdField_a_of_type_ArrayOfJavaUtilList[paramInt2] = paramList;
          break label119;
        }
        if ((paramInt3 != 0) && (paramInt3 != 4)) {
          break label119;
        }
        this.jdField_a_of_type_ArrayOfJavaUtilList[paramInt2] = paramList;
        break label119;
        paramBoolean2 = false;
        break label133;
        paramBoolean1 = false;
        break label153;
        if (paramInt1 != 3) {
          break label192;
        }
        break label192;
        if (paramInt3 == 1)
        {
          this.jdField_a_of_type_ArrayOfBoolean[paramInt2] = false;
          break label210;
        }
        if (paramInt3 == 2)
        {
          this.jdField_b_of_type_ArrayOfBoolean[paramInt2] = false;
          break label210;
        }
        if (paramInt3 == 4)
        {
          this.jdField_b_of_type_ArrayOfBoolean[paramInt2] = false;
          this.jdField_a_of_type_ArrayOfBoolean[paramInt2] = false;
          break label210;
        }
        if (paramInt3 != 3) {
          break label210;
        }
        this.jdField_b_of_type_ArrayOfBoolean[paramInt2] = false;
        this.jdField_a_of_type_ArrayOfBoolean[paramInt2] = false;
        break label210;
        if ((this.jdField_a_of_type_ArrayOfJavaUtilList[this.I] != null) && (!this.jdField_a_of_type_ArrayOfJavaUtilList[this.I].isEmpty()))
        {
          if (!this.jdField_c_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentWidgetXListView.a(this.n);
            this.jdField_c_of_type_Boolean = true;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.owner == 1) && (this.jdField_d_of_type_ArrayOfBoolean[this.I] != 0))
          {
            if (this.jdField_d_of_type_Boolean) {
              break label304;
            }
            this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidWidgetLinearLayout);
            this.jdField_d_of_type_Boolean = true;
            break label304;
          }
          if (!this.jdField_d_of_type_Boolean) {
            break label304;
          }
          this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidWidgetLinearLayout);
          this.jdField_d_of_type_Boolean = false;
          break label304;
        }
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentWidgetXListView.a(this.n);
          this.jdField_c_of_type_Boolean = false;
        }
        if (this.jdField_d_of_type_Boolean) {
          break label304;
        }
        this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidWidgetLinearLayout);
        this.jdField_d_of_type_Boolean = true;
        break label304;
        if ((!this.jdField_a_of_type_Boolean) || (paramInt1 == 0))
        {
          if (this.jdField_c_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentWidgetXListView.a(this.n);
            this.jdField_c_of_type_Boolean = false;
          }
          if (this.jdField_d_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidWidgetLinearLayout);
            this.jdField_d_of_type_Boolean = false;
          }
        }
        for (;;)
        {
          if (!this.jdField_c_of_type_Boolean) {
            break label1266;
          }
          this.jdField_a_of_type_ComTencentWidgetXListView.a(this.n);
          this.jdField_c_of_type_Boolean = false;
          break;
          if ((this.jdField_a_of_type_ArrayOfJavaUtilList[this.I] == null) || (this.jdField_a_of_type_ArrayOfJavaUtilList[this.I].isEmpty()))
          {
            if (!this.jdField_d_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidWidgetLinearLayout);
              this.jdField_d_of_type_Boolean = true;
            }
          }
          else
          {
            if ((this.jdField_c_of_type_ArrayOfBoolean[paramInt2] != 0) && (!this.jdField_e_of_type_Boolean) && (paramInt3 == 3))
            {
              if (this.jdField_c_of_type_AndroidWidgetLinearLayout == null) {
                this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity).inflate(2130903377, null));
              }
              this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_c_of_type_AndroidWidgetLinearLayout);
            }
            for (this.jdField_e_of_type_Boolean = true;; this.jdField_e_of_type_Boolean = false)
            {
              do
              {
                if ((this.jdField_d_of_type_Boolean) || (this.jdField_d_of_type_ArrayOfBoolean[this.I] == 0)) {
                  break label1229;
                }
                this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidWidgetLinearLayout);
                this.jdField_d_of_type_Boolean = true;
                break;
              } while ((this.jdField_c_of_type_ArrayOfBoolean[paramInt2] != 0) || (!this.jdField_e_of_type_Boolean));
              this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_c_of_type_AndroidWidgetLinearLayout);
            }
            if ((this.jdField_d_of_type_Boolean) && (this.jdField_d_of_type_ArrayOfBoolean[this.I] == 0))
            {
              this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidWidgetLinearLayout);
              this.jdField_d_of_type_Boolean = false;
            }
          }
        }
        break label304;
        paramInt1 += 1;
        break label370;
      } while ((paramInt2 != 1) || (!(paramObject instanceof String)) || (paramList == null));
      label677:
      label683:
      label949:
      paramString = (String)paramObject;
      label771:
      paramInt1 = 0;
      if (paramInt1 < paramList.size()) {
        if ((paramList.get(paramInt1) == null) || (!((DatingComment)paramList.get(paramInt1)).jdField_a_of_type_JavaLangString.equals(paramString))) {}
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.post(new icv(this, paramInt2, paramInt1));
        return;
        paramInt1 += 1;
        break;
        paramInt1 = -1;
      }
      label1377:
      paramInt1 = -1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    DatingUtil.a("onDecodeTaskCompleted", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramBitmap });
    if ((paramBitmap == null) || (paramInt2 != 32) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    try
    {
      a(Long.parseLong(paramString), new BitmapDrawable(BaseApplication.getContext().getResources(), paramBitmap));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i3 = 0;
    int i4 = 0;
    int i2 = 0;
    int i1 = 0;
    if (((paramInt1 == 0) && (paramInt2 == 0)) || (paramBoolean)) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(paramInt1, paramInt2);
    }
    while (paramInt1 < 0) {
      return;
    }
    if (paramInt1 > 1) {
      if (this.jdField_a_of_type_ArrayOfJavaUtilList[this.I] == null)
      {
        i2 = i1;
        if (paramInt1 - this.jdField_a_of_type_ComTencentWidgetXListView.m() <= 0) {
          break label239;
        }
        i1 = (int)((i2 - (paramInt1 - this.jdField_a_of_type_ComTencentWidgetXListView.m())) * 61 * this.jdField_a_of_type_Float);
        label95:
        i2 = i1;
        if (this.jdField_d_of_type_Boolean) {
          i2 = (int)(i1 + this.jdField_a_of_type_Float * 60.0F);
        }
        i1 = this.O - i2 - paramInt2;
      }
    }
    label239:
    do
    {
      i2 = i1;
      if (paramBoolean) {
        i2 = (int)(i1 + 61.0F * this.jdField_a_of_type_Float);
      }
      if (i2 > 0)
      {
        if (this.jdField_d_of_type_AndroidViewView == null) {
          this.jdField_d_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity);
        }
        this.jdField_d_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, i2));
        this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_d_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(paramInt1, paramInt2);
      return;
      i2 = this.jdField_a_of_type_ArrayOfJavaUtilList[this.I].size();
      break;
      i1 = i2;
      if (paramInt1 - this.jdField_a_of_type_ComTencentWidgetXListView.m() != 0) {
        break label95;
      }
      i3 = i2;
      if (this.jdField_e_of_type_Boolean) {
        i3 = (int)(i2 + this.jdField_a_of_type_Float * 60.0F);
      }
      i1 = i3;
      if (!this.jdField_c_of_type_Boolean) {
        break label95;
      }
      i1 = (int)(i3 + this.jdField_a_of_type_Float * 60.0F);
      break label95;
      if (paramInt1 == 1)
      {
        if (this.jdField_a_of_type_ArrayOfJavaUtilList[this.I] == null) {}
        for (i1 = i4;; i1 = this.jdField_a_of_type_ArrayOfJavaUtilList[this.I].size())
        {
          i2 = (int)((int)(i1 * 61 * this.jdField_a_of_type_Float) + 44.0F * this.jdField_a_of_type_Float);
          i1 = i2;
          if (this.jdField_d_of_type_Boolean) {
            i1 = (int)(i2 + this.jdField_a_of_type_Float * 60.0F);
          }
          i2 = i1;
          if (this.jdField_e_of_type_Boolean) {
            i2 = (int)(i1 + this.jdField_a_of_type_Float * 60.0F);
          }
          i1 = i2;
          if (this.jdField_c_of_type_Boolean) {
            i1 = (int)(i2 + this.jdField_a_of_type_Float * 25.0F);
          }
          i1 = this.O - i1 - paramInt2;
          break;
        }
      }
      i1 = i3;
    } while (paramInt1 != 0);
    if (this.jdField_a_of_type_ArrayOfJavaUtilList[this.I] == null) {}
    for (i1 = i2;; i1 = this.jdField_a_of_type_ArrayOfJavaUtilList[this.I].size())
    {
      i2 = (int)(i1 * 61 * this.jdField_a_of_type_Float) + this.N;
      i1 = i2;
      if (this.jdField_d_of_type_Boolean) {
        i1 = (int)(i2 + this.jdField_a_of_type_Float * 60.0F);
      }
      i2 = i1;
      if (this.jdField_e_of_type_Boolean) {
        i2 = (int)(i1 + this.jdField_a_of_type_Float * 60.0F);
      }
      i1 = i2;
      if (this.jdField_c_of_type_Boolean) {
        i1 = (int)(i2 + this.jdField_a_of_type_Float * 25.0F);
      }
      i1 = this.O - i1 - paramInt2;
      break;
    }
  }
  
  public void a(int paramInt, DatingComment paramDatingComment)
  {
    new DatingInputPopupWindow(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, true, this.jdField_a_of_type_ComTencentWidgetXListView, paramInt, paramDatingComment, this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId).show();
  }
  
  public void a(int paramInt1, DatingStranger paramDatingStranger, int paramInt2, DatingComment paramDatingComment)
  {
    if ((this.I == 2) || (this.I == 0)) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.detailCanProfile != 1)
      {
        paramDatingComment = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.detailProfileTip;
        paramDatingStranger = paramDatingComment;
        if (TextUtils.isEmpty(paramDatingComment)) {
          paramDatingStranger = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(2131369807);
        }
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.a(2, paramDatingStranger, 0);
      }
    }
    label220:
    label231:
    while (this.I != 1) {
      for (;;)
      {
        return;
        boolean bool;
        if (paramDatingStranger != null)
        {
          paramDatingComment = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity;
          long l1 = paramDatingStranger.jdField_a_of_type_Long;
          String str1 = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId;
          String str2 = paramDatingStranger.jdField_a_of_type_JavaLangString;
          paramInt1 = paramDatingStranger.jdField_a_of_type_Int;
          paramInt2 = paramDatingStranger.b;
          int i1 = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject;
          if (paramDatingStranger.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherID)
          {
            bool = true;
            DatingUtil.a(paramDatingComment, l1, str1, null, 18, str2, paramInt1, paramInt2, i1, bool);
          }
        }
        else if (this.I == 0)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.owner == 1) {
            break label220;
          }
          this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004985");
        }
        for (;;)
        {
          if ((this.I != 2) || (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.owner != 1)) {
            break label231;
          }
          this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004988");
          return;
          bool = false;
          break;
          this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004987");
        }
      }
    }
    paramDatingStranger = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, null);
    paramDatingStranger.c("回复");
    if ((paramDatingComment != null) && ((paramDatingComment.jdField_a_of_type_Int & 0x2) == 0)) {
      paramDatingStranger.c("举报");
    }
    if ((paramDatingComment != null) && ((paramDatingComment.jdField_a_of_type_Int & 0x1) == 1)) {
      paramDatingStranger.a("删除", 3);
    }
    paramDatingStranger.e(2131365736);
    paramDatingStranger.a(new icz(this, paramDatingStranger, paramInt2, paramDatingComment));
    paramDatingStranger.show();
  }
  
  protected abstract void a(int paramInt, Object paramObject);
  
  public void a(int paramInt, Collection paramCollection)
  {
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.a(1, "删除评论成功", 0);
    b(1, paramCollection);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailAdapter.a(paramInt, paramBoolean);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView == null) || (this.jdField_b_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView == null)) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.owner == 1) {
          break;
        }
      } while ((paramInt < 0) || (paramInt > 1));
      if (!paramBoolean1)
      {
        this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.setCurrentTab(paramInt, paramBoolean2);
        this.jdField_b_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.setCurrentTab(paramInt, paramBoolean2);
        this.I = paramInt;
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.getVisibility() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.setCurrentTab(paramInt, paramBoolean2);
        return;
      }
      this.jdField_b_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.setCurrentTab(paramInt, paramBoolean2);
      return;
    } while ((paramInt < 0) || (paramInt > 2));
    if (!paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.setCurrentTab(paramInt, paramBoolean2);
      this.jdField_b_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.setCurrentTab(paramInt, paramBoolean2);
      this.I = paramInt;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.getVisibility() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.setCurrentTab(paramInt, paramBoolean2);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.setCurrentTab(paramInt, paramBoolean2);
  }
  
  protected void a(long paramLong, Drawable paramDrawable)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId)) {}
    label93:
    Object localObject;
    label129:
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
      {
        if ((paramLong != 9223372036854775807L) || (paramDrawable != null)) {
          continue;
        }
        paramDrawable = DatingUtil.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherID), this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.app, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, 3001);
        this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable(paramDrawable);
        i2 = this.jdField_a_of_type_ComTencentWidgetXListView.s();
        i3 = this.jdField_a_of_type_ComTencentWidgetXListView.t();
        i1 = 0;
        if (i1 <= i3 - i2)
        {
          paramDrawable = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i1);
          if ((paramDrawable instanceof DatingDetailItemView)) {
            break label129;
          }
        }
      }
      for (;;)
      {
        i1 += 1;
        break label93;
        break;
        break;
        paramDrawable = (DatingDetailItemView)paramDrawable;
        if (paramDrawable.a() >= 0L)
        {
          localObject = DatingUtil.a(Long.toString(paramDrawable.a()), this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.app, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, 3001);
          paramDrawable.a(paramDrawable.a(), (Drawable)localObject);
        }
      }
    } while ((paramLong == 9223372036854775807L) || (paramDrawable == null));
    if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherID == paramLong)
    {
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable(paramDrawable);
      return;
    }
    int i2 = this.jdField_a_of_type_ComTencentWidgetXListView.s();
    int i3 = this.jdField_a_of_type_ComTencentWidgetXListView.t();
    int i1 = 0;
    label236:
    if (i1 <= i3 - i2)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i1);
      if ((localObject instanceof DatingDetailItemView)) {
        break label274;
      }
    }
    for (;;)
    {
      i1 += 1;
      break label236;
      break;
      label274:
      localObject = (DatingDetailItemView)localObject;
      if (paramLong == ((DatingDetailItemView)localObject).a()) {
        ((DatingDetailItemView)localObject).a(paramLong, paramDrawable);
      }
    }
  }
  
  protected void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_b_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)this.jdField_b_of_type_AndroidViewView.findViewById(2131299950));
    paramView = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources().getDrawable(2130840157);
    this.jdField_b_of_type_ComTencentWidgetCustomImgView.setBackground(paramView);
    this.jdField_b_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentWidgetCustomImgView.setTag(-1, Integer.valueOf(9));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131299940));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131299942));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131299955));
    this.j = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131299952));
    this.k = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131299953));
    this.l = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131299946));
    this.m = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131299943));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131299941));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131299939));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131299945));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131299948));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131299951));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131299954));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131299956));
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131299949);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setTag(-1, Integer.valueOf(9));
    paramView = this.jdField_b_of_type_AndroidViewView.findViewById(2131298053);
    View localView = this.jdField_b_of_type_AndroidViewView.findViewById(2131299958);
    int i1 = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources().getColor(2131427880);
    paramView.setBackgroundColor(i1);
    localView.setBackgroundColor(i1);
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5)
  {
    TextView localTextView;
    if (paramView != null)
    {
      paramView.setVisibility(0);
      paramView.setTag(-1, Integer.valueOf(paramInt1));
      paramView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(paramInt2));
      localTextView = (TextView)paramView.findViewById(2131297022);
      localTextView.setTag(-1, Integer.valueOf(paramInt1));
      localTextView.setText(paramInt2);
      localTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(paramInt2));
      if (paramInt3 <= 0) {
        break label197;
      }
      localTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt3, 0, 0, 0);
      if (paramInt4 <= 0) {
        break label209;
      }
      paramInt2 = localTextView.getPaddingLeft();
      paramInt3 = localTextView.getPaddingRight();
      int i1 = localTextView.getPaddingTop();
      int i2 = localTextView.getPaddingBottom();
      localTextView.setBackgroundResource(paramInt4);
      localTextView.setPadding(paramInt2, i1, paramInt3, i2);
      localTextView.setTag(-1, Integer.valueOf(paramInt1));
      localTextView.setOnClickListener(this);
      label153:
      if (paramInt5 <= 0) {
        break label226;
      }
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources().getColor(paramInt5));
    }
    for (;;)
    {
      localTextView.setEnabled(paramBoolean);
      paramView.setContentDescription(localTextView.getText().toString());
      return;
      label197:
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label209:
      paramView.setTag(-1, Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
      break label153;
      label226:
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources().getColorStateList(2131427879));
    }
  }
  
  protected void a(LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    do
    {
      do
      {
        return;
        paramLinearLayout.removeAllViews();
        localObject = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity).inflate(2130903879, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -1);
        localLayoutParams.weight = 1.0F;
        paramLinearLayout.addView((View)localObject, localLayoutParams);
        a((View)localObject, 13, 2131369707, 2130840158, true, 0, 0);
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.owner == 1) || (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo == null));
      int i1 = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources().getColor(2131427889);
      float f1 = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources().getDisplayMetrics().density;
      localObject = new ImageView(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity);
      ((ImageView)localObject).setBackgroundColor(i1);
      localLayoutParams = new LinearLayout.LayoutParams((int)(0.75D * f1), (int)(f1 * 20.0F));
      localLayoutParams.gravity = 17;
      paramLinearLayout.addView((View)localObject, localLayoutParams);
      localObject = View.inflate(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, 2130903879, null);
      localLayoutParams = new LinearLayout.LayoutParams(0, -1);
      localLayoutParams.weight = 1.0F;
      paramLinearLayout.addView((View)localObject, localLayoutParams);
      a((View)localObject, 2, 2131369706, 2130840484, true, 0, 0);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingStatus == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingApply == 0))
      {
        localObject = View.inflate(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, 2130903879, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -1);
        localLayoutParams.weight = 1.0F;
        paramLinearLayout.addView((View)localObject, localLayoutParams);
        a((View)localObject, 3, 2131369708, 2130840159, true, 2130838085, 2131427966);
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingStatus != 0) || (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingApply != 1));
    Object localObject = View.inflate(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, 2130903879, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView((View)localObject, localLayoutParams);
    a((View)localObject, 4, 2131369709, 0, true, 2130838090, 2131427970);
  }
  
  public void a(TextView paramTextView, String paramString, boolean paramBoolean)
  {
    if (paramTextView == null) {}
    do
    {
      do
      {
        return;
        if (!TextUtils.isEmpty(paramString)) {
          break;
        }
        if (paramBoolean)
        {
          paramTextView.setVisibility(8);
          return;
        }
        paramTextView.setVisibility(0);
      } while ("".equals(paramTextView.getText().toString()));
      paramTextView.setText("");
      return;
      paramTextView.setVisibility(0);
    } while (paramString.equals(paramTextView.getText().toString()));
    paramTextView.setText(paramString);
  }
  
  protected void a(DatingInfo paramDatingInfo, int paramInt, boolean paramBoolean)
  {
    if (paramDatingInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo = paramDatingInfo;
      this.M = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingCommentNum;
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.a();
      e();
      d();
      c();
      f();
    } while (this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailAdapter == null);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailAdapter.a(this.I, this.jdField_a_of_type_ArrayOfJavaUtilList[this.I], true);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      }
      if (paramInt == 0) {
        a(9223372036854775807L, null);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= 1) {
      if ((this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.getVisibility() == 0) || (!this.jdField_b_of_type_Boolean)) {}
    }
    do
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.post(new icw(this));
      for (;;)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.getVisibility() != 4) {
          this.jdField_b_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.setVisibility(4);
        }
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.getVisibility() != 0) {
          this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.setVisibility(0);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.getVisibility() != 8) {
        this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.setVisibility(8);
      }
    } while (this.jdField_b_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.getVisibility() == 0);
    this.jdField_b_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.setVisibility(0);
  }
  
  protected void a(XListView paramXListView, boolean paramBoolean)
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, 2130903881, null);
    paramXListView.a(localView);
    h();
    paramXListView = localView.findViewById(2131299935);
    if (paramBoolean)
    {
      paramXListView.setVisibility(0);
      paramXListView.setTag(-1, Integer.valueOf(16));
      paramXListView.setOnClickListener(this);
      paramXListView.setContentDescription("查看其他约会，给生活更多可能");
    }
    for (;;)
    {
      b(localView.findViewById(2131299936));
      d();
      localView.findViewById(2131298053).setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources().getColor(2131427880));
      a(localView.findViewById(2131299937));
      c();
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailAdapter = new DatingDetailAdapter(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo, this.I, this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailAdapter);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity).inflate(2130903377, null));
      this.n = new TextView(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity);
      this.n.setText("最近看过的人");
      this.n.setGravity(16);
      this.n.setTextColor(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources().getColor(2131427972));
      this.n.setTextSize(2, 14.0F);
      this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources().getDisplayMetrics().density;
      this.n.setPadding((int)(this.jdField_a_of_type_Float * 15.0F), 0, 0, 0);
      this.n.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(25.0F * this.jdField_a_of_type_Float)));
      g();
      f();
      return;
      paramXListView.setVisibility(8);
    }
  }
  
  protected void a(XListView paramXListView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramXListView == null) {
      throw new IllegalArgumentException("detail mode initUI param listView is null.");
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    a(paramXListView, paramBoolean2);
    this.jdField_a_of_type_Boolean = paramBoolean1;
  }
  
  public void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ArrayOfJavaUtilList[1] == null) || (this.jdField_a_of_type_ArrayOfJavaUtilList[1].isEmpty())) {}
    Object localObject;
    DatingComment localDatingComment;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.jdField_a_of_type_ArrayOfJavaUtilList[1].iterator();
      }
      localObject = localIterator.next();
      localDatingComment = (DatingComment)localObject;
    } while ((localDatingComment == null) || (!paramString.equals(localDatingComment.jdField_a_of_type_JavaLangString)));
    this.jdField_a_of_type_ArrayOfJavaUtilList[1].remove(localObject);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailAdapter.notifyDataSetChanged();
    this.M -= 1;
    f();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingStatus == 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingApply == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.owner != 1))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSelFlag == 0)
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130840244);
          return;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130840247);
        return;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130840245);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailAdapter.a(paramInt, (int)(61.0F * this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources().getDisplayMetrics().density));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, false);
  }
  
  protected void b(int paramInt, Object paramObject)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId)) {}
    label167:
    do
    {
      do
      {
        return;
        switch (paramInt)
        {
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 10: 
        case 11: 
        case 12: 
        default: 
          return;
        case 1: 
          if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
          {
            this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity);
            this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131369676);
            if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.owner == 1) {
              break label167;
            }
            this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131367622);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentWidgetActionSheet.e(2131365736);
            this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this);
            this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingStatus == 0) {
              this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131369675);
            }
          }
        case 9: 
          if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject != 5)
          {
            paramObject = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.addressCompanyUrl;
            paramInt = 2131369812;
            this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004941");
          }
          while (TextUtils.isEmpty(paramObject))
          {
            this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b(paramInt);
            return;
            paramObject = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.placeUrl;
            paramInt = 2131369813;
            this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004F39");
          }
          Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, QQBrowserActivity.class);
          localIntent.putExtra("url", paramObject);
          localIntent.putExtra("hide_more_button", true);
          localIntent.putExtra("hide_operation_bar", true);
          this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.startActivity(localIntent);
          return;
        case 13: 
          new DatingInputPopupWindow(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, false, this.jdField_a_of_type_ComTencentWidgetXListView, 0, null, this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId).show();
          return;
        case 8: 
          DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherID, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.detailSigC2C, 18, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherNickname, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherAge, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherGender, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject, true);
          return;
        }
      } while (this.jdField_b_of_type_ArrayOfBoolean[this.I] != 0);
      this.jdField_b_of_type_ArrayOfBoolean[this.I] = true;
      a(this.jdField_b_of_type_ArrayOfBoolean[this.I], true);
      if (this.I == 1) {
        paramObject = this.jdField_a_of_type_JavaLangString;
      }
      for (;;)
      {
        this.jdField_b_of_type_ArrayOfBoolean[this.I] = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.a(this.I, paramObject, 0, 20);
        if (this.jdField_b_of_type_ArrayOfBoolean[this.I] != 0) {
          break;
        }
        a(this.jdField_b_of_type_ArrayOfBoolean[this.I], this.jdField_d_of_type_ArrayOfBoolean[this.I]);
        return;
        if ((this.jdField_a_of_type_ArrayOfJavaUtilList[this.I] != null) && (this.jdField_a_of_type_ArrayOfJavaUtilList[this.I].size() > 0)) {
          paramObject = Integer.valueOf(((DatingStranger)this.jdField_a_of_type_ArrayOfJavaUtilList[this.I].get(this.jdField_a_of_type_ArrayOfJavaUtilList[this.I].size() - 1)).f);
        } else if (this.I == 1) {
          paramObject = "0";
        } else {
          paramObject = Integer.valueOf(-1);
        }
      }
    } while (this.jdField_a_of_type_ArrayOfBoolean[this.I] != 0);
    b(true, true);
    if (this.I == 1) {
      paramObject = this.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfBoolean[this.I] = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.a(this.I, paramObject, 20, 0);
      if (this.jdField_a_of_type_ArrayOfBoolean[this.I] != 0) {
        break;
      }
      b(this.jdField_a_of_type_ArrayOfBoolean[this.I], this.jdField_c_of_type_ArrayOfBoolean[this.I]);
      return;
      if ((this.jdField_a_of_type_ArrayOfJavaUtilList[this.I] != null) && (this.jdField_a_of_type_ArrayOfJavaUtilList[this.I].size() > 0)) {
        paramObject = Integer.valueOf(((DatingStranger)this.jdField_a_of_type_ArrayOfJavaUtilList[this.I].get(0)).f);
      } else if (this.I == 1) {
        paramObject = "0";
      } else {
        paramObject = Integer.valueOf(-1);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.finish();
    paramObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, DatingFeedActivity.class);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.startActivity(paramObject);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.overridePendingTransition(2130968593, 2130968594);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004FAA");
  }
  
  public void b(int paramInt, Collection paramCollection)
  {
    if (paramCollection.size() <= 0) {}
    do
    {
      ArrayList localArrayList;
      do
      {
        return;
        localArrayList = new ArrayList();
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext())
        {
          int i1 = ((Integer)paramCollection.next()).intValue();
          localArrayList.add(this.jdField_a_of_type_ArrayOfJavaUtilList[paramInt].get(i1));
        }
      } while (!this.jdField_a_of_type_ArrayOfJavaUtilList[paramInt].removeAll(localArrayList));
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailAdapter.notifyDataSetChanged();
    } while (paramInt != 1);
    this.M -= 1;
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.a(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingVisitNum, this.M, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingApplyNum);
    this.jdField_b_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.a(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingVisitNum, this.M, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingApplyNum);
  }
  
  protected void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setTag(-1, Integer.valueOf(8));
    this.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296751));
    paramView = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources().getDrawable(2130840233);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setBackgroundDrawable(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299971));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299970));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299892));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299969));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298048));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299894));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299893));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299967));
  }
  
  public void b(DatingStranger paramDatingStranger)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.detailCanProfile != 1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.detailProfileTip;
      paramDatingStranger = (DatingStranger)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramDatingStranger = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(2131369807);
      }
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.a(2, paramDatingStranger, 0);
      return;
    }
    boolean bool;
    if (paramDatingStranger != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity;
      long l1 = paramDatingStranger.jdField_a_of_type_Long;
      String str1 = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId;
      String str2 = paramDatingStranger.jdField_a_of_type_JavaLangString;
      int i1 = paramDatingStranger.jdField_a_of_type_Int;
      int i2 = paramDatingStranger.b;
      int i3 = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject;
      if (paramDatingStranger.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherID)
      {
        bool = true;
        label121:
        DatingUtil.a((Context)localObject, l1, str1, null, 18, str2, i1, i2, i3, bool);
      }
    }
    else if (this.I == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.owner == 1) {
        break label234;
      }
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004985");
    }
    for (;;)
    {
      if ((this.I == 2) && (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.owner == 1)) {
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004988");
      }
      if (this.I != 1) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.owner == 1) {
        break label247;
      }
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004F46");
      return;
      bool = false;
      break label121;
      label234:
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004987");
    }
    label247:
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004F45");
  }
  
  public void b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ArrayOfJavaUtilList[1] == null) || (this.jdField_a_of_type_ArrayOfJavaUtilList[1].isEmpty()))
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.e();
      return;
    }
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_ArrayOfJavaUtilList[1].size())
    {
      DatingComment localDatingComment = (DatingComment)this.jdField_a_of_type_ArrayOfJavaUtilList[1].get(i1);
      if ((localDatingComment == null) || (!paramString.equals(localDatingComment.jdField_a_of_type_JavaLangString))) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailAdapter.a(this.jdField_a_of_type_ComTencentWidgetXListView, 1, i1);
      return;
      i1 += 1;
      break;
      i1 = -1;
    }
  }
  
  protected void c()
  {
    int i2 = 2130840196;
    if ((this.jdField_b_of_type_AndroidViewView == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId))) {
      return;
    }
    StringBuilder localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources();
    Object localObject1;
    int i1;
    switch (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject)
    {
    default: 
      localObject1 = localResources.getDrawable(2130840249);
      localObject2 = localResources.getString(2131369681);
      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingStatus == 0)
      {
        i1 = 2130840248;
        i2 = 2130840193;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1361;
        }
        if (this.jdField_g_of_type_AndroidWidgetTextView.getVisibility() != 8)
        {
          this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        label155:
        if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject != 5) {
          break label1438;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.placePicUrl;
        label175:
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1450;
        }
        this.jdField_b_of_type_ComTencentWidgetCustomImgView.setImageDrawable((Drawable)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.strDatingTime;
        a(this.jdField_i_of_type_AndroidWidgetTextView, (String)localObject1, true);
        a(this.jdField_i_of_type_AndroidWidgetTextView, this.jdField_i_of_type_AndroidWidgetImageView);
        localStringBuilder.setLength(0);
        if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject != 5) {
          break label1594;
        }
        localObject1 = DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.departPoi, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.departCity, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.departRegion, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.departProvince, -1) + "-" + DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.destPoi, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.destCity, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.destRegion, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.destProvince, -1);
        i1 = 2130840182;
        label329:
        this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(i1);
        a(this.j, (String)localObject1, false);
        a(this.j, this.jdField_g_of_type_AndroidWidgetImageView);
        if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject != 5) {
          break label1721;
        }
        localObject1 = localResources.getStringArray(2131230756);
        if ((localObject1 == null) || (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.vehicle < 0) || (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.vehicle >= localObject1.length)) {
          break label1712;
        }
        localObject1 = localObject1[this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.vehicle];
        switch (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.vehicle)
        {
        default: 
          i1 = 2130840180;
          label472:
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            this.k.setVisibility(8);
            label488:
            this.jdField_h_of_type_AndroidWidgetImageView.setImageResource(i1);
            a(this.k, (String)localObject1, false);
            a(this.k, this.jdField_h_of_type_AndroidWidgetImageView);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingIntroduce;
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              break label1747;
            }
            this.l.setVisibility(8);
            a(this.l, this.jdField_e_of_type_AndroidWidgetImageView);
            b();
            switch (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingGender)
            {
            default: 
              localObject1 = localResources.getString(2131369713);
              label601:
              localObject2 = localObject1;
              if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject == 5)
              {
                localObject2 = localObject1;
                if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.partnerCount >= 0)
                {
                  localObject2 = localObject1;
                  if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.partnerCount <= 4)
                  {
                    localObject3 = localResources.getStringArray(2131230754);
                    localObject2 = localObject1;
                    if (localObject3 != null)
                    {
                      localStringBuilder.setLength(0);
                      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.partnerCount != 0) {
                        break label1812;
                      }
                      localStringBuilder.append("人数不限");
                    }
                  }
                }
              }
              break;
            }
          }
          label542:
          break;
        }
      }
      break;
    }
    for (;;)
    {
      localStringBuilder.append(" ").append((String)localObject1);
      localObject2 = localStringBuilder.toString();
      a(this.m, (String)localObject2, true);
      a(this.m, this.jdField_d_of_type_AndroidWidgetImageView);
      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject != 5) {
        break label1831;
      }
      this.jdField_h_of_type_AndroidWidgetTextView.setText("");
      if ((this.N <= 0) || (this.O <= 0)) {
        this.jdField_a_of_type_ComTencentWidgetXListView.post(new ict(this));
      }
      localStringBuilder.setLength(0);
      localStringBuilder.append("约会内容");
      localObject1 = this.jdField_g_of_type_AndroidWidgetTextView.getText().toString();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localStringBuilder.append(",").append((String)localObject1);
      }
      localStringBuilder.append(",").append((String)localObject1);
      if (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0) {
        localStringBuilder.append(",").append("已过期");
      }
      localObject1 = this.jdField_h_of_type_AndroidWidgetTextView.getText().toString();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localStringBuilder.append(",").append((String)localObject1);
      }
      localObject1 = this.m.getText().toString();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localStringBuilder.append(",约会对象,").append((String)localObject1);
      }
      localObject1 = this.l.getText().toString();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localStringBuilder.append(",约会说明,").append((String)localObject1);
      }
      localObject1 = localStringBuilder.toString();
      this.jdField_b_of_type_AndroidViewView.findViewById(2131299960).setContentDescription((CharSequence)localObject1);
      localStringBuilder.setLength(0);
      localObject1 = this.j.getText().toString();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localStringBuilder.append("地点,").append((String)localObject1);
      }
      localObject1 = this.k.getText().toString();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localStringBuilder.append(",").append((String)localObject1);
      }
      localObject1 = DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingTime);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localStringBuilder.append(",时间,").append((String)localObject1);
      }
      localStringBuilder.append(",连按两次进入商家详情页.");
      localObject1 = localStringBuilder.toString();
      this.jdField_c_of_type_AndroidViewView.setContentDescription((CharSequence)localObject1);
      this.jdField_b_of_type_ComTencentWidgetCustomImgView.setContentDescription((CharSequence)localObject1);
      return;
      localObject1 = localResources.getDrawable(2130840249);
      localObject2 = localResources.getString(2131369681);
      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingStatus == 0)
      {
        i1 = 2130840248;
        i2 = 2130840193;
        break;
      }
      i1 = 2130840250;
      break;
      localObject1 = localResources.getDrawable(2130840255);
      localObject2 = localResources.getString(2131369684);
      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingStatus == 0)
      {
        i1 = 2130840254;
        i2 = 2130840195;
        break;
      }
      i1 = 2130840256;
      break;
      localObject1 = localResources.getDrawable(2130840252);
      localObject2 = localResources.getString(2131369682);
      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingStatus == 0)
      {
        i1 = 2130840251;
        i2 = 2130840194;
        break;
      }
      i1 = 2130840253;
      break;
      localObject1 = localResources.getDrawable(2130840258);
      localObject2 = localResources.getString(2131369683);
      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingStatus == 0)
      {
        i1 = 2130840257;
        i2 = 2130840197;
        break;
      }
      i1 = 2130840259;
      break;
      localObject1 = localResources.getDrawable(2130840261);
      localObject2 = localResources.getString(2131369685);
      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingStatus == 0)
      {
        i1 = 2130840260;
        i2 = 2130840198;
        break;
      }
      i1 = 2130840262;
      break;
      i1 = 2130840250;
      break;
      label1361:
      if (this.jdField_g_of_type_AndroidWidgetTextView.getVisibility() != 0)
      {
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_g_of_type_AndroidWidgetTextView.getText().equals(localObject2)) {
        break label155;
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      this.jdField_f_of_type_AndroidWidgetImageView.setBackgroundResource(i1);
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(i2);
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(i2);
      break label155;
      label1438:
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.addressCompanyPicUrl;
      break label175;
      for (;;)
      {
        try
        {
          label1450:
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources().getDimensionPixelSize(2131493363);
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestWidth;
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
          localObject2 = URLDrawable.getDrawable((String)localObject2, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions);
        }
        catch (Exception localException1)
        {
          try
          {
            this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mFailedDrawable = null;
            this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mLoadingDrawable = null;
            localObject3 = this.jdField_b_of_type_ComTencentWidgetCustomImgView;
            if (localObject2 != null) {
              break label1588;
            }
            ((CustomImgView)localObject3).setImageDrawable((Drawable)localObject1);
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localObject3 = localObject2;
            }
          }
          localException1 = localException1;
          localObject3 = null;
        }
        localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.dating", 2, localException1.toString());
          localObject2 = localObject3;
          continue;
          label1588:
          localObject1 = localObject2;
        }
      }
      label1594:
      i1 = 2130840184;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.addressCompanyName;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localStringBuilder.append((String)localObject1);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.addressCompanyZone;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localStringBuilder.append(" (").append((String)localObject1).append(")");
      }
      localObject1 = localStringBuilder.toString();
      break label329;
      i1 = 2130840181;
      break label472;
      i1 = 2130840186;
      break label472;
      i1 = 2130840172;
      break label472;
      i1 = 2130840171;
      break label472;
      i1 = 2130840183;
      break label472;
      i1 = 2130840173;
      break label472;
      i1 = 2130840180;
      break label472;
      label1712:
      localObject1 = "";
      i1 = 0;
      break label472;
      label1721:
      i1 = 2130840178;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.addressCompanyAddr;
      break label472;
      this.k.setVisibility(0);
      break label488;
      label1747:
      this.l.setVisibility(0);
      this.l.setText(new QQText((CharSequence)localObject1, 1, 16));
      break label542;
      localObject1 = localResources.getString(2131369711);
      break label601;
      localObject1 = localResources.getString(2131369712);
      break label601;
      localObject1 = localResources.getString(2131369713);
      break label601;
      label1812:
      localStringBuilder.append(localObject3[this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.partnerCount]);
    }
    label1831:
    switch (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingPayType)
    {
    default: 
      i2 = 2131369679;
      i1 = 2131427881;
    }
    for (;;)
    {
      localObject1 = localResources.getString(i2);
      localObject1 = (String)localObject1;
      if (((String)localObject1).equals(this.jdField_h_of_type_AndroidWidgetTextView.getText().toString())) {
        break;
      }
      this.jdField_h_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(localResources.getColorStateList(i1));
      break;
      i2 = 2131369680;
      i1 = 2131427883;
      continue;
      i2 = 2131369678;
      i1 = 2131427882;
      continue;
      i2 = 2131369679;
      i1 = 2131427881;
    }
  }
  
  protected void d()
  {
    String str = null;
    if ((this.jdField_a_of_type_AndroidViewView == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getResources();
    Object localObject = DatingUtil.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherID), this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.app, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, 3001);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable((Drawable)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherNickname;
    a(this.jdField_a_of_type_AndroidWidgetTextView, (String)localObject, false);
    localObject = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherVip;
    label141:
    label206:
    int i2;
    if ("svip".equalsIgnoreCase((String)localObject))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842003);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherNBflag != 1) {
        break label561;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherAge > 0) {
        break label573;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherDistance;
      a(this.jdField_e_of_type_AndroidWidgetTextView, (String)localObject, true);
      i1 = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherEmo - 1;
      if ((i1 <= 0) || (i1 >= NearbyProfileUtil.b.length)) {
        break label650;
      }
      localObject = NearbyProfileUtil.b[i1];
      a(this.jdField_f_of_type_AndroidWidgetTextView, (String)localObject, true);
      i1 = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherProfession;
      localObject = str;
      if (i1 >= 0)
      {
        localObject = str;
        if (i1 < NearbyProfileUtil.e.length) {
          localObject = NearbyProfileUtil.e[i1];
        }
      }
      if ((i1 < 0) || (i1 >= NearbyProfileUtil.jdField_a_of_type_ArrayOfInt.length)) {
        break label655;
      }
      i2 = NearbyProfileUtil.jdField_a_of_type_ArrayOfInt[i1];
      i1 = i2;
      if (i2 >= 0) {}
    }
    label650:
    label655:
    for (int i1 = 0;; i1 = 0)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(i1);
      a(this.jdField_d_of_type_AndroidWidgetTextView, (String)localObject, true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherConstellation;
      a(this.jdField_c_of_type_AndroidWidgetTextView, (String)localObject, true);
      localObject = this.jdField_a_of_type_JavaLangStringBuilder;
      ((StringBuilder)localObject).setLength(0);
      ((StringBuilder)localObject).append("约会发布人");
      str = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherNickname;
      if (!TextUtils.isEmpty(str)) {
        ((StringBuilder)localObject).append(",").append(str);
      }
      str = this.jdField_b_of_type_AndroidWidgetTextView.getText().toString();
      if (!TextUtils.isEmpty(str)) {
        ((StringBuilder)localObject).append(",").append(str);
      }
      str = this.jdField_c_of_type_AndroidWidgetTextView.getText().toString();
      if (!TextUtils.isEmpty(str)) {
        ((StringBuilder)localObject).append(",").append(str);
      }
      str = this.jdField_d_of_type_AndroidWidgetTextView.getText().toString();
      if (!TextUtils.isEmpty(str)) {
        ((StringBuilder)localObject).append(",").append(str);
      }
      str = this.jdField_e_of_type_AndroidWidgetTextView.getText().toString();
      if (!TextUtils.isEmpty(str)) {
        ((StringBuilder)localObject).append(",").append(str);
      }
      ((StringBuilder)localObject).append(",连按两次进入发布者个人资料.");
      this.jdField_a_of_type_AndroidViewView.setContentDescription(((StringBuilder)localObject).toString());
      return;
      if ("vip".equalsIgnoreCase((String)localObject))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842130);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label561:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label141;
      label573:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherAge));
      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherGender == 1) {
        i1 = 2130838479;
      }
      for (i2 = 2130840432;; i2 = 2130840433)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i1, 0, 0, 0);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(i2);
        break;
        i1 = 2130838484;
      }
      localObject = null;
      break label206;
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      return;
    }
    a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.a(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingVisitNum, this.M, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingApplyNum);
    this.jdField_b_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.a(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingVisitNum, this.M, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingApplyNum);
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.owner == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.a(true);
      this.jdField_b_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.a(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.owner != 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.a();
      this.jdField_b_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.a();
    }
  }
  
  protected void h()
  {
    this.jdField_b_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView = new CustomTabBarView(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_b_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView);
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.setOnTabChangeListener(new icx(this));
    this.jdField_b_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.setOnTabChangeListener(new icy(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      if (Math.abs(System.currentTimeMillis() - this.jdField_b_of_type_Long) >= 800L)
      {
        Object localObject = paramView.getTag(-1);
        paramView = paramView.getTag();
        if ((localObject instanceof Integer)) {}
        for (int i1 = ((Integer)localObject).intValue(); i1 != 0; i1 = 0)
        {
          b(i1, paramView);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DetailModel
 * JD-Core Version:    0.7.0.1
 */