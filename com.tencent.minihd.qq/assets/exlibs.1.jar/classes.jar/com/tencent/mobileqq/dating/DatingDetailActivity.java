package com.tencent.mobileqq.dating;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.dating.widget.CustomTabBarView;
import com.tencent.mobileqq.dating.widget.DatingInputPopupWindow.IDatingInputPopupWindowCallback;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import ias;
import iat;
import iav;
import java.util.List;

public class DatingDetailActivity
  extends DatingExtraActivity
  implements Handler.Callback, View.OnClickListener, ViewStub.OnInflateListener, DatingInputPopupWindow.IDatingInputPopupWindowCallback, OverScrollViewListener
{
  public static final int A = 1;
  public static final int B = 2;
  public static final int C = 3;
  public static final int D = 4;
  public static final int E = 5;
  public static final int F = 6;
  public static final int G = 7;
  public static final int H = 8;
  public static final int I = 9;
  public static final int J = 10;
  public static final int a = 1050;
  private static DatingInfo jdField_a_of_type_ComTencentMobileqqDataDatingInfo;
  public static final String a = "datingDetail";
  public static final int b = 1008;
  public static final String b = "appoint_id";
  public static final int c = 1007;
  public static final String c = "from_id";
  public static final int d = 1006;
  public static final String d = "detail_mode";
  public static final int e = 1005;
  public static final String e = "stranger_idx";
  public static final int f = 1004;
  public static final int g = 1003;
  public static final int h = 1002;
  public static final String h = "comment_id";
  public static final int i = 1001;
  public static final int j = 1009;
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 2;
  public static final int n = 1;
  public static final int o = 2;
  public static final int p = 0;
  static final int q = 1;
  static final int r = 4;
  static final int s = 2;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  public DatingObserver a;
  public DetailModel a;
  CustomTabBarView jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView;
  public PullRefreshHeader a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  View jdField_b_of_type_AndroidViewView;
  ViewStub jdField_b_of_type_AndroidViewViewStub;
  public volatile boolean b;
  View jdField_c_of_type_AndroidViewView;
  ViewStub jdField_c_of_type_AndroidViewViewStub;
  public volatile boolean c;
  View d;
  View e;
  public volatile boolean g = false;
  public String i;
  public String j;
  int t;
  public int w = 0;
  public int x = 0;
  public int y;
  public int z = 0;
  
  public DatingDetailActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver = new iav(this);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, DatingInfo paramDatingInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((jdField_a_of_type_ComTencentMobileqqDataDatingInfo != null) || (paramContext == null)) {
      return;
    }
    if ((paramInt2 != 1001) && (paramInt2 != 1009) && (paramInt2 != 1002)) {
      jdField_a_of_type_ComTencentMobileqqDataDatingInfo = paramDatingInfo;
    }
    paramDatingInfo = new Intent(paramContext, DatingDetailActivity.class);
    paramDatingInfo.putExtra("appoint_id", paramString);
    paramDatingInfo.putExtra("from_id", paramInt2);
    paramDatingInfo.putExtra("detail_mode", paramInt1);
    paramDatingInfo.putExtra("abp_flag", paramBoolean1);
    paramDatingInfo.putExtra("is_from_web", paramBoolean2);
    if (paramBoolean1) {
      paramDatingInfo.addFlags(268435456);
    }
    paramContext.startActivity(paramDatingInfo);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    int i1 = 2;
    if ((jdField_a_of_type_ComTencentMobileqqDataDatingInfo != null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || ((paramInt2 == 1) && (TextUtils.isEmpty(paramString2)))) {
      return;
    }
    paramInt1 = 1008;
    if ((paramInt2 == 1) || (paramInt2 == 2))
    {
      paramInt1 = 1007;
      if ((paramInt2 != 1) && (paramInt2 != 3) && (paramInt2 != 5)) {
        break label149;
      }
      i1 = 1;
    }
    for (;;)
    {
      Intent localIntent = new Intent(paramContext, DatingDetailActivity.class);
      localIntent.putExtra("appoint_id", paramString1);
      localIntent.putExtra("detail_mode", i1);
      localIntent.putExtra("from_id", paramInt1);
      localIntent.putExtra("comment_id", paramString2);
      localIntent.putExtra("stranger_idx", paramInt3);
      paramContext.startActivity(localIntent);
      return;
      if (paramInt2 != 3) {
        break;
      }
      paramInt1 = 1006;
      break;
      label149:
      if (paramInt2 != 4) {
        i1 = 0;
      }
    }
  }
  
  public void a()
  {
    if ((this.w != 0) || (this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId)))
    {
      this.rightViewImg.setVisibility(8);
      return;
    }
    this.rightViewImg.setVisibility(0);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView != this.jdField_a_of_type_ComTencentWidgetXListView) {
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public void a(DatingInfo paramDatingInfo, int paramInt)
  {
    if (((paramInt != 2) && (paramDatingInfo == null)) || ((paramDatingInfo != null) && (!this.i.equals(paramDatingInfo.datingId)))) {}
    for (;;)
    {
      return;
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(9);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      if ((this.w == 2) || ((this.w == 1) && ((this.x == 1001) || (this.x == 1009) || ((this.x == 1002) && (paramDatingInfo != null) && (paramDatingInfo.owner == 0)))))
      {
        a();
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel != null) || (paramDatingInfo != null)) {
        break;
      }
      a();
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      while (this.jdField_e_of_type_AndroidViewView == null)
      {
        this.jdField_e_of_type_AndroidViewView = new View(this);
        this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_e_of_type_AndroidViewView);
        paramDatingInfo = new XSimpleListAdapter(new View(this));
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(paramDatingInfo);
        return;
        this.jdField_b_of_type_AndroidViewViewStub.setVisibility(0);
      }
    }
    int i1;
    label252:
    Object localObject1;
    label273:
    label303:
    Object localObject2;
    boolean bool2;
    boolean bool1;
    label334:
    label365:
    Object localObject3;
    label453:
    int i2;
    label482:
    boolean bool3;
    int i4;
    List localList;
    label559:
    boolean bool4;
    int i3;
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel == null) {
      if (this.t == 2)
      {
        i1 = 0;
        if (i1 == 0) {
          break label841;
        }
        this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel = new DetailHost(this, paramDatingInfo, this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView);
        this.rightViewImg.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel);
        a();
        if (this.jdField_b_of_type_AndroidViewView == null) {
          break label861;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel;
        localObject2 = this.jdField_a_of_type_ComTencentWidgetXListView;
        bool2 = this.g;
        if (this.x != 1009) {
          break label872;
        }
        bool1 = true;
        ((DetailModel)localObject1).a((XListView)localObject2, bool2, bool1);
        if (this.x != 1006) {
          break label878;
        }
        this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a(2, false, false);
        if (this.jdField_e_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_e_of_type_AndroidViewView);
          this.jdField_e_of_type_AndroidViewView = null;
        }
        this.d.setVisibility(0);
        this.d.setBackgroundColor(getResources().getColor(2131427962));
        this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a((LinearLayout)this.d);
        getWindow().setBackgroundDrawable(null);
        if (this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.F == 0) {
          b("0X8004940");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel == null) || (paramDatingInfo == null)) {
          break label948;
        }
        localObject3 = null;
        if ((this.g) || (paramInt == 2)) {
          break label950;
        }
        i2 = 1;
        bool3 = paramDatingInfo.isReachOver(2, true);
        bool1 = paramDatingInfo.isReachOver(2, false);
        if ((this.jdField_b_of_type_Boolean) || (this.x != 1006)) {
          break label1087;
        }
        i4 = 3;
        localObject3 = Integer.valueOf(this.y);
        localList = paramDatingInfo.getStranger(false, this.y, 10, 10);
        if ((localList != null) && (!localList.isEmpty())) {
          break label956;
        }
        i1 = 1;
        if ((i1 == 0) || ((i2 == 0) && ((this.z & 0x4) == 0))) {
          break label961;
        }
        i1 = 0;
        localObject1 = localObject3;
        localObject2 = localList;
        bool4 = bool3;
        i3 = i4;
        label595:
        this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a(i1, 2, i3, bool4, bool1, (List)localObject2, null, localObject1);
        localObject2 = paramDatingInfo.getStranger(true, true, 20);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
          break label1245;
        }
        i1 = 1;
        label642:
        bool3 = paramDatingInfo.isReachOver(0, true);
        bool2 = paramDatingInfo.isReachOver(0, false);
        if ((i2 == 0) || (i1 == 0)) {
          break label1250;
        }
        i1 = 0;
        label669:
        this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a(i1, 0, 4, bool3, bool2, (List)localObject2, null, localObject1);
        bool4 = paramDatingInfo.isReachOver(1, true);
        bool1 = paramDatingInfo.isReachOver(1, false);
        if ((this.jdField_b_of_type_Boolean) || (this.x != 1007)) {
          break label1601;
        }
        i3 = 3;
        localObject1 = this.j;
        localObject3 = paramDatingInfo.getDatingComment(this.j, 10, 10);
        if ((localObject3 != null) && (!((List)localObject3).isEmpty())) {
          break label1311;
        }
        i1 = 1;
        label761:
        if ((i1 == 0) || ((i2 == 0) && ((this.z & 0x2) == 0))) {
          break label1316;
        }
        paramInt = 0;
        paramDatingInfo = (DatingInfo)localObject3;
        bool2 = bool4;
        i1 = i3;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a(paramInt, 1, i1, bool2, bool1, paramDatingInfo, null, localObject1);
      return;
      if (this.t == 1)
      {
        i1 = 1;
        break label252;
      }
      if (paramDatingInfo.owner == 1)
      {
        i1 = 1;
        break label252;
      }
      i1 = 0;
      break label252;
      label841:
      this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel = new DetailGuest(this, paramDatingInfo, this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView);
      break label273;
      label861:
      this.jdField_b_of_type_AndroidViewViewStub.setVisibility(0);
      break label303;
      label872:
      bool1 = false;
      break label334;
      label878:
      if (this.x == 1007)
      {
        this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a(1, false, false);
        break label365;
      }
      if (paramDatingInfo.datingCommentNum <= 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a(0, false, false);
        break label365;
      }
      this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a(1, false, false);
      break label365;
      this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a(paramDatingInfo, paramInt, this.g);
      break label453;
      label948:
      break;
      label950:
      i2 = 0;
      break label482;
      label956:
      i1 = 0;
      break label559;
      label961:
      bool2 = bool3;
      if (i1 == 0)
      {
        bool2 = bool3;
        if (bool3) {
          bool2 = paramDatingInfo.isReachCacheOver(2, localList.get(0), true);
        }
      }
      bool3 = bool1;
      if (i1 == 0)
      {
        bool3 = bool1;
        if (bool1) {
          bool3 = paramDatingInfo.isReachCacheOver(2, localList.get(localList.size() - 1), false);
        }
      }
      i1 = 1;
      i3 = i4;
      bool4 = bool2;
      bool1 = bool3;
      localObject2 = localList;
      localObject1 = localObject3;
      if (paramInt != 2) {
        break label595;
      }
      i1 = 2;
      i3 = i4;
      bool4 = bool2;
      bool1 = bool3;
      localObject2 = localList;
      localObject1 = localObject3;
      break label595;
      label1087:
      i4 = 4;
      localList = paramDatingInfo.getStranger(false, true, 20);
      if ((localList == null) || (localList.isEmpty())) {}
      for (i1 = 1;; i1 = 0)
      {
        if ((i2 == 0) || (i1 == 0)) {
          break label1152;
        }
        i1 = 0;
        i3 = i4;
        bool4 = bool3;
        localObject2 = localList;
        localObject1 = localObject3;
        break;
      }
      label1152:
      bool2 = bool1;
      if (i1 == 0)
      {
        bool2 = bool1;
        if (bool1) {
          bool2 = paramDatingInfo.isReachCacheOver(2, localList.get(localList.size() - 1), false);
        }
      }
      i1 = 1;
      i3 = i4;
      bool4 = bool3;
      bool1 = bool2;
      localObject2 = localList;
      localObject1 = localObject3;
      if (paramInt != 2) {
        break label595;
      }
      i1 = 2;
      i3 = i4;
      bool4 = bool3;
      bool1 = bool2;
      localObject2 = localList;
      localObject1 = localObject3;
      break label595;
      label1245:
      i1 = 0;
      break label642;
      label1250:
      bool1 = bool2;
      if (i1 == 0)
      {
        bool1 = bool2;
        if (bool2) {
          bool1 = paramDatingInfo.isReachCacheOver(0, ((List)localObject2).get(((List)localObject2).size() - 1), false);
        }
      }
      i1 = 1;
      bool2 = bool1;
      if (paramInt != 2) {
        break label669;
      }
      i1 = 2;
      bool2 = bool1;
      break label669;
      label1311:
      i1 = 0;
      break label761;
      label1316:
      if ((i1 != 0) && (i2 == 0) && ((this.z & 0x2) == 0))
      {
        i2 = 4;
        localObject3 = paramDatingInfo.getDatingComment(true, 20);
        if ((localObject3 == null) || (((List)localObject3).isEmpty())) {}
        for (bool4 = true;; bool4 = false)
        {
          bool3 = bool1;
          if (!bool4)
          {
            bool3 = bool1;
            if (bool1) {
              bool3 = paramDatingInfo.isReachCacheOver(1, ((List)localObject3).get(((List)localObject3).size() - 1), false);
            }
          }
          bool2 = true;
          boolean bool5 = true;
          paramInt = 1;
          bool1 = bool3;
          i1 = i2;
          paramDatingInfo = (DatingInfo)localObject3;
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            break label1742;
          }
          QLog.i("Q.dating.detail", 2, "initOrUpdateUI firstList is empty and secondList is empty: " + bool4);
          bool1 = bool3;
          i1 = i2;
          bool2 = bool5;
          paramDatingInfo = (DatingInfo)localObject3;
          break;
        }
      }
      bool3 = bool4;
      if (i1 == 0)
      {
        bool3 = bool4;
        if (bool4) {
          bool3 = paramDatingInfo.isReachCacheOver(1, ((List)localObject3).get(0), true);
        }
      }
      bool4 = bool1;
      if (i1 == 0)
      {
        bool4 = bool1;
        if (bool1) {
          bool4 = paramDatingInfo.isReachCacheOver(1, ((List)localObject3).get(((List)localObject3).size() - 1), false);
        }
      }
      bool1 = bool4;
      i1 = i3;
      bool2 = bool3;
      paramDatingInfo = (DatingInfo)localObject3;
      localObject2 = localObject1;
      if (paramInt == 2)
      {
        paramInt = 2;
        bool1 = bool4;
        i1 = i3;
        bool2 = bool3;
        paramDatingInfo = (DatingInfo)localObject3;
        continue;
        label1601:
        i3 = 4;
        localObject3 = paramDatingInfo.getDatingComment(true, 20);
        if ((localObject3 == null) || (((List)localObject3).isEmpty())) {}
        for (i1 = 1;; i1 = 0)
        {
          if ((i2 == 0) || (i1 == 0)) {
            break label1659;
          }
          paramInt = 0;
          i1 = i3;
          bool2 = bool4;
          paramDatingInfo = (DatingInfo)localObject3;
          break;
        }
        label1659:
        bool3 = bool1;
        if (i1 == 0)
        {
          bool3 = bool1;
          if (bool1) {
            bool3 = paramDatingInfo.isReachCacheOver(1, ((List)localObject3).get(((List)localObject3).size() - 1), false);
          }
        }
        bool1 = bool3;
        i1 = i3;
        bool2 = bool4;
        paramDatingInfo = (DatingInfo)localObject3;
        localObject2 = localObject1;
        if (paramInt == 2)
        {
          paramInt = 2;
          bool1 = bool3;
          i1 = i3;
          bool2 = bool4;
          paramDatingInfo = (DatingInfo)localObject3;
          continue;
        }
      }
      label1742:
      paramInt = 1;
      localObject1 = localObject2;
    }
  }
  
  public void a(String paramString, DatingComment paramDatingComment)
  {
    a(0, "评论中...", 0);
    DatingHandler localDatingHandler = (DatingHandler)this.app.a(40);
    if (localDatingHandler == null)
    {
      a(2, "评论失败", 0);
      return;
    }
    if ((paramDatingComment != null) && ((paramDatingComment.jdField_a_of_type_Int & 0x2) == 0))
    {
      paramString = DatingUtil.a(true, this.i, (int)(System.currentTimeMillis() / 1000L), paramString, paramDatingComment.jdField_a_of_type_JavaLangString, paramDatingComment.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger.a);
      b("0X8004F0E");
      if ((this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.jdField_a_of_type_ArrayOfJavaUtilList[1] == null) || (this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.jdField_a_of_type_ArrayOfJavaUtilList[1].size() <= 0)) {
        break label184;
      }
    }
    label184:
    for (paramDatingComment = ((DatingComment)this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.jdField_a_of_type_ArrayOfJavaUtilList[1].get(0)).jdField_a_of_type_JavaLangString;; paramDatingComment = "")
    {
      localDatingHandler.a(this.i, paramString, 20, paramDatingComment);
      b("0X8004F0D");
      return;
      paramString = DatingUtil.a(false, this.i, (int)(System.currentTimeMillis() / 1000L), paramString, "", 0L);
      break;
    }
  }
  
  public boolean a()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      DatingUtil.a("requestDetail", new Object[] { Boolean.valueOf(this.jdField_c_of_type_Boolean), Long.valueOf(System.currentTimeMillis()) });
      if (this.jdField_c_of_type_Boolean) {
        return true;
      }
      DatingHandler localDatingHandler = (DatingHandler)this.app.a(40);
      if (localDatingHandler != null)
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 60000L);
        localDatingHandler.a(this.i, this.x);
        return true;
      }
      return false;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    boolean bool = true;
    if (paramListView != this.jdField_a_of_type_ComTencentWidgetXListView) {
      bool = false;
    }
    while (this.jdField_b_of_type_Boolean) {
      return bool;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    if (NetworkUtil.e(getApplicationContext())) {
      ThreadManager.c(new ias(this));
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 60000L);
      return true;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 800L);
    return true;
  }
  
  public boolean a(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    return a(paramInt1, paramObject, paramInt2, paramInt3, true);
  }
  
  public boolean a(int paramInt1, Object paramObject, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i2 = -1;
    Object localObject2 = null;
    Object localObject1;
    int i1;
    if ((paramInt1 == 1) && ((paramObject instanceof String)))
    {
      localObject1 = (String)paramObject;
      i1 = i2;
    }
    while ((TextUtils.isEmpty((CharSequence)localObject1)) && (i1 == -1))
    {
      DatingUtil.b("fetchListData", new Object[] { Integer.valueOf(paramInt1), paramObject });
      return false;
      if (paramInt1 != 2)
      {
        i1 = i2;
        localObject1 = localObject2;
        if (paramInt1 != 0) {}
      }
      else
      {
        i1 = i2;
        localObject1 = localObject2;
        if ((paramObject instanceof Integer))
        {
          i1 = ((Integer)paramObject).intValue();
          localObject1 = localObject2;
        }
      }
    }
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel == null) || (this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.jdField_a_of_type_ComTencentMobileqqDataDatingInfo == null))
      {
        DatingUtil.b("fetchListData", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel });
        return false;
      }
      i2 = DatingUtil.a(paramInt2, paramInt3);
      if (a(this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.jdField_a_of_type_ComTencentMobileqqDataDatingInfo, 1, paramInt1, i1, (String)localObject1, i2)) {
        return false;
      }
    }
    if (!NetworkUtil.e(getApplicationContext()))
    {
      a(2, "网络未连接...", 0);
      return false;
    }
    i2 = 1 << paramInt1;
    if ((this.z & i2) != 0) {
      return false;
    }
    paramObject = (DatingHandler)this.app.a(40);
    if (paramObject == null) {
      return false;
    }
    switch (paramInt1)
    {
    }
    while ((i2 & this.z) != 0)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.e("Q.dating.detail", 2, "fetch stranger idx is: " + i1);
      }
      paramObject.a(false, this.i, i1, 1, paramInt3, paramInt2);
      this.z |= 0x4;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 30000L);
      continue;
      if (QLog.isColorLevel()) {
        QLog.e("Q.dating.detail", 2, "fetch comment idx is: " + (String)localObject1);
      }
      paramObject.a(this.i, (String)localObject1, paramInt3, paramInt2);
      this.z |= 0x2;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(8, 30000L);
      continue;
      if (QLog.isColorLevel()) {
        QLog.e("Q.dating.detail", 2, "fetch visiter idx is: " + i1);
      }
      paramObject.a(true, this.i, i1, 1, paramInt3, paramInt2);
      this.z |= 0x1;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 30000L);
    }
    return false;
  }
  
  public boolean a(DatingInfo paramDatingInfo, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4)
  {
    if ((paramDatingInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel == null)) {
      return false;
    }
    Object localObject = null;
    boolean bool4 = paramDatingInfo.isReachOver(paramInt2, true);
    boolean bool6 = paramDatingInfo.isReachOver(paramInt2, false);
    boolean bool1;
    if ((paramInt2 == 0) || (paramInt2 == 2)) {
      if (paramInt2 == 0)
      {
        bool1 = true;
        switch (paramInt4)
        {
        default: 
          paramInt4 = 4;
          paramString = paramDatingInfo.getStranger(bool1, true, 20);
          label90:
          localObject = Integer.valueOf(paramInt3);
          paramInt3 = paramInt4;
        }
      }
    }
    for (;;)
    {
      boolean bool5;
      label119:
      boolean bool2;
      if ((paramString != null) && (paramString.size() > 0))
      {
        bool5 = true;
        bool1 = bool4;
        bool2 = bool6;
        if (bool5) {
          switch (paramInt3)
          {
          default: 
            bool2 = bool6;
            bool1 = bool4;
          }
        }
      }
      for (;;)
      {
        if ((bool5) || (paramInt1 != 1)) {
          this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a(paramInt1, paramInt2, paramInt3, bool1, bool2, paramString, null, localObject);
        }
        return bool5;
        bool1 = false;
        break;
        paramString = paramDatingInfo.getStranger(bool1, paramInt3, 20, 0);
        break label90;
        paramString = paramDatingInfo.getStranger(bool1, paramInt3, 0, 20);
        break label90;
        paramString = paramDatingInfo.getStranger(bool1, paramInt3, 10, 10);
        break label90;
        if (paramInt2 != 1) {
          break label568;
        }
        switch (paramInt4)
        {
        default: 
          paramInt4 = 4;
          localObject = paramDatingInfo.getDatingComment(true, 20);
        }
        for (;;)
        {
          String str = paramString;
          paramString = (String)localObject;
          paramInt3 = paramInt4;
          localObject = str;
          break;
          localObject = paramDatingInfo.getDatingComment(paramString, 20, 0);
          continue;
          localObject = paramDatingInfo.getDatingComment(paramString, 0, 20);
          continue;
          localObject = paramDatingInfo.getDatingComment(paramString, 10, 10);
        }
        bool5 = false;
        break label119;
        bool1 = bool4;
        bool2 = bool6;
        if (bool4)
        {
          bool1 = paramDatingInfo.isReachCacheOver(paramInt2, paramString.get(0), true);
          bool2 = bool6;
          continue;
          bool1 = bool4;
          bool2 = bool6;
          if (bool6)
          {
            bool2 = paramDatingInfo.isReachCacheOver(paramInt2, paramString.get(paramString.size() - 1), false);
            bool1 = bool4;
            continue;
            boolean bool3 = bool4;
            if (bool4) {
              bool3 = paramDatingInfo.isReachCacheOver(paramInt2, paramString.get(0), true);
            }
            bool1 = bool3;
            bool2 = bool6;
            if (bool6)
            {
              bool2 = paramDatingInfo.isReachCacheOver(paramInt2, paramString.get(paramString.size() - 1), false);
              bool1 = bool3;
              continue;
              bool3 = true;
              bool1 = bool3;
              bool2 = bool6;
              if (bool6)
              {
                bool2 = paramDatingInfo.isReachCacheOver(paramInt2, paramString.get(paramString.size() - 1), false);
                bool1 = bool3;
              }
            }
          }
        }
      }
      label568:
      paramString = null;
      paramInt3 = paramInt4;
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView != this.jdField_a_of_type_ComTencentWidgetXListView) {}
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dating.detail", 2, "del comment comment id is empty");
      }
      return;
    }
    if (!NetworkUtil.e(getApplicationContext()))
    {
      a(2, "网络未连接...", 0);
      return;
    }
    DatingHandler localDatingHandler = (DatingHandler)this.app.a(40);
    if (localDatingHandler == null)
    {
      a(2, "删除失败", 0);
      return;
    }
    a(0, "删除评论中...", 0);
    localDatingHandler.a(this.i, paramString);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {}
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      super.doOnCreate(paramBundle);
      paramBundle = getIntent().getExtras();
      this.i = paramBundle.getString("appoint_id");
      this.t = paramBundle.getInt("detail_mode");
      this.x = paramBundle.getInt("from_id");
      if (this.x == 1007)
      {
        this.j = paramBundle.getString("comment_id");
        if ((this.app != null) && (!TextUtils.isEmpty(this.i))) {
          break label124;
        }
        jdField_a_of_type_ComTencentMobileqqDataDatingInfo = null;
        finish();
      }
      label124:
      do
      {
        return true;
        if (this.x != 1006) {
          break;
        }
        this.y = paramBundle.getInt("stranger_idx");
        break;
        if (this.jdField_e_of_type_Boolean) {
          setLeftViewName(2131369656);
        }
        setContentView(2130903887);
        getWindow().setBackgroundDrawable(getResources().getDrawable(2130837687));
        setTitle(2131369702);
        this.centerView.setOnClickListener(this);
        this.rightViewText.setVisibility(8);
        this.rightViewImg.setImageResource(2130838415);
        this.rightViewImg.setTag(-1, Integer.valueOf(1));
        this.rightViewImg.setContentDescription("更多");
        a();
        this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131299976));
        this.jdField_a_of_type_AndroidViewViewStub.setOnInflateListener(this);
        this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131299974));
        this.jdField_b_of_type_AndroidViewViewStub.setOnInflateListener(this);
        this.jdField_c_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131299973));
        this.jdField_c_of_type_AndroidViewViewStub.setOnInflateListener(this);
        this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView = ((CustomTabBarView)findViewById(2131299975));
        this.jdField_a_of_type_AndroidOsHandler = new CustomHandler(Looper.getMainLooper(), this);
        if ((jdField_a_of_type_ComTencentMobileqqDataDatingInfo != null) && (jdField_a_of_type_ComTencentMobileqqDataDatingInfo.nLimit == 2)) {
          this.w = 2;
        }
        a(jdField_a_of_type_ComTencentMobileqqDataDatingInfo, 0);
        jdField_a_of_type_ComTencentMobileqqDataDatingInfo = null;
      } while (!QLog.isDevelopLevel());
      QLog.i("Q.dating", 4, "doOnCreate, cost = " + (System.currentTimeMillis() - l1));
      return true;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a(null, 0, this.g);
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return true;
                } while (this.jdField_a_of_type_Boolean);
                this.jdField_a_of_type_Boolean = true;
                ThreadManager.a().post(new iat(this));
                return true;
              } while (this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel == null);
              this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a(paramMessage.arg1, paramMessage.obj);
              return true;
              this.jdField_b_of_type_Boolean = false;
              this.jdField_c_of_type_Boolean = false;
              this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
            } while (this.jdField_a_of_type_ComTencentWidgetXListView == null);
            this.jdField_a_of_type_ComTencentWidgetXListView.B();
            return true;
          } while (this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel == null);
          DatingUtil.a(this.app, this, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.detailPubUin), this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherNickname, this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.detailSigC2C, 3);
          return true;
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(9);
        } while (this.jdField_c_of_type_AndroidViewView == null);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        return true;
      } while (!this.jdField_c_of_type_Boolean);
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        return true;
      }
      this.jdField_c_of_type_AndroidViewViewStub.setVisibility(0);
      return true;
      this.z &= 0xFFFFFFFB;
      return true;
      this.z &= 0xFFFFFFFD;
      return true;
      this.z &= 0xFFFFFFFE;
      return true;
    } while (this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel == null);
    this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.b(paramMessage.arg1);
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 4097)
    {
      if (paramInt2 == -1)
      {
        finish();
        paramIntent = new Intent(this, DatingUserCenterActivity.class);
        paramIntent.addFlags(603979776);
        startActivity(paramIntent);
      }
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
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
    if (paramView.getId() == 2131299961)
    {
      paramView = new Intent(this, DatingFeedActivity.class);
      paramView.addFlags(67108864);
      startActivity(paramView);
      finish();
    }
    while ((paramView != this.centerView) || (this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.b(0, 0);
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    if (paramViewStub == this.jdField_a_of_type_AndroidViewViewStub)
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      ((Button)paramView.findViewById(2131299961)).setOnClickListener(this);
    }
    do
    {
      do
      {
        return;
        if (paramViewStub == this.jdField_b_of_type_AndroidViewViewStub)
        {
          this.jdField_b_of_type_AndroidViewView = paramView;
          this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramView.findViewById(2131299964));
          this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837687);
          this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2130903418, this.jdField_a_of_type_ComTencentWidgetXListView, false));
          this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
          this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
          this.d = ((LinearLayout)paramView.findViewById(2131299962));
          paramView.findViewById(2131299963).setBackgroundColor(getResources().getColor(2131427880));
          return;
        }
      } while (paramViewStub != this.jdField_c_of_type_AndroidViewViewStub);
      this.jdField_c_of_type_AndroidViewView = paramView;
      paramViewStub = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131296551)).getDrawable();
    } while (!(paramViewStub instanceof Animatable));
    ((Animatable)paramViewStub).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingDetailActivity
 * JD-Core Version:    0.7.0.1
 */