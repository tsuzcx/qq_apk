package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterViewPagerAdapter;
import com.tencent.widget.CirclePageIndicator;
import com.tencent.widget.XListView.MotionEventInterceptor;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.model.PhotoInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import jon;
import joo;

public class QzonePhotoView
  extends LinearLayout
  implements Handler.Callback, XListView.MotionEventInterceptor
{
  public static final int a = 100;
  public static final String a = "ProfileCard.QzonePhotoView";
  public static final int b = 2;
  public static final int c = 10;
  public static final int d = 5;
  private float jdField_a_of_type_Float;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new joo(this);
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ProfileCardInfo jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo;
  CoverCacheData jdField_a_of_type_CooperationQzoneModelCoverCacheData;
  public List a;
  private boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private float jdField_b_of_type_Float;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt = new int[2];
  private float jdField_c_of_type_Float;
  private boolean jdField_c_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public QzonePhotoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QzonePhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private List a(String paramString, Map paramMap, List paramList)
  {
    int m = 0;
    LinkedList localLinkedList = new LinkedList();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update").append("|type = ").append(paramString).append("|MulRelsotionUrl = ").append(paramMap).append("|vecUrls = ").append(paramList);
      QLog.i("ProfileCard.QzonePhotoView", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_CooperationQzoneModelCoverCacheData == null) {
      this.jdField_a_of_type_CooperationQzoneModelCoverCacheData = new CoverCacheData();
    }
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.type = paramString;
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.urls = ((HashMap)paramMap);
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.photoWall = ((ArrayList)paramList);
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.uin = Long.parseLong(this.jdField_b_of_type_JavaLangString);
    int k;
    if (paramList != null) {
      k = paramList.size();
    }
    while ((m < k) && (m < 20))
    {
      paramString = (Map)paramList.get(m);
      if (paramString != null)
      {
        paramString = new QzonePhotoView.PhotoInfo(m, 100, paramString);
        paramString.i = localLinkedList.size();
        localLinkedList.add(paramString);
      }
      m += 1;
      continue;
      k = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "updateCoverData photoInfo size=" + localLinkedList.size());
    }
    return localLinkedList;
  }
  
  public CoverCacheData a()
  {
    return this.jdField_a_of_type_CooperationQzoneModelCoverCacheData;
  }
  
  public void a()
  {
    CoverCacheData localCoverCacheData = a();
    if (localCoverCacheData != null)
    {
      localCoverCacheData.type = "PhotoWallCover";
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localUserInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      localUserInfo.c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
      QZoneHelper.b(this.jdField_a_of_type_AndroidAppActivity, localUserInfo, localCoverCacheData, 1008);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      QzonePhotoView.PhotoInfo localPhotoInfo = (QzonePhotoView.PhotoInfo)((Iterator)localObject2).next();
      if (localPhotoInfo.j != 101)
      {
        PhotoInfo localPhotoInfo1 = new PhotoInfo();
        localPhotoInfo1.c = localPhotoInfo.a();
        ((ArrayList)localObject1).add(localPhotoInfo1);
      }
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("mode", 6);
    ((Bundle)localObject2).putInt("curindex", paramInt);
    ((Bundle)localObject2).putParcelableArrayList("picturelist", (ArrayList)localObject1);
    localObject1 = QZoneHelper.UserInfo.a();
    ((QZoneHelper.UserInfo)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    ((QZoneHelper.UserInfo)localObject1).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    ((QZoneHelper.UserInfo)localObject1).c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
    QZoneHelper.b(this.jdField_a_of_type_AndroidAppActivity, (QZoneHelper.UserInfo)localObject1, (Bundle)localObject2, 1014);
  }
  
  public void a(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "initView");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.h = 0;
    this.jdField_b_of_type_JavaLangString = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()).inflate(2130904125, this, true);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = localDisplayMetrics.density;
    this.e = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    if (SizeMeasure.a(paramBaseActivity))
    {
      this.e = SizeMeasure.e(paramBaseActivity);
      int k = getResources().getDimensionPixelSize(2131493210);
      this.g = getResources().getDimensionPixelSize(2131493211);
      this.f = ((this.e - k * 2 - this.g * 4) / 5);
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label295;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      paramProfileCardInfo = (QZoneCover)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(QZoneCover.class, this.jdField_b_of_type_JavaLangString);
      if (paramProfileCardInfo != null)
      {
        new LinkedList();
        a(a(paramProfileCardInfo.type, paramProfileCardInfo.parseCoverInfo(), paramProfileCardInfo.parsePhotoInfo()));
      }
      paramProfileCardInfo = Message.obtain();
      paramProfileCardInfo.what = 100;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramProfileCardInfo);
      this.i = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(paramBaseActivity));
      return;
      this.e = SizeMeasure.h(paramBaseActivity);
      break;
      label295:
      bool = false;
    }
  }
  
  public void a(CoverCacheData paramCoverCacheData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "updateCoverCacheData data = " + paramCoverCacheData);
    }
    if (paramCoverCacheData != null) {
      a(a(paramCoverCacheData.type, paramCoverCacheData.urls, paramCoverCacheData.photoWall));
    }
    if ((this.jdField_a_of_type_CooperationQzoneModelCoverCacheData != null) && (Utils.a("PhotoWallCover", this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.type)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.QzonePhotoView", 2, "need get req cover info");
      }
      paramCoverCacheData = Message.obtain();
      paramCoverCacheData.what = 100;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramCoverCacheData);
    }
  }
  
  public void a(List paramList)
  {
    for (;;)
    {
      ViewPager localViewPager;
      CirclePageIndicator localCirclePageIndicator;
      try
      {
        if ((QLog.isColorLevel()) && (paramList != null)) {
          QLog.i("ProfileCard.QzonePhotoView", 2, "updatePhotoView photoInfo size=" + paramList.size());
        }
        this.jdField_a_of_type_JavaUtilList = paramList;
        if (paramList == null) {
          break label454;
        }
        k = paramList.size();
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300951));
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300950);
        this.jdField_b_of_type_AndroidViewView.setTag(new DataTag(25, null));
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ProfileCardTemplate.a(this.jdField_a_of_type_AndroidWidgetImageView, "src", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "photoAddTipsImage");
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(new DataTag(25, null));
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localViewPager = (ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131300954);
        localCirclePageIndicator = (CirclePageIndicator)this.jdField_a_of_type_AndroidViewView.findViewById(2131300955);
        if (k > 0)
        {
          QzonePhotoView.PhotoGridAdapter localPhotoGridAdapter = new QzonePhotoView.PhotoGridAdapter(this);
          localPhotoGridAdapter.a(paramList);
          localPhotoGridAdapter.a(this.f, this.f);
          paramList = new AdapterViewPagerAdapter(getContext(), localPhotoGridAdapter, 10);
          paramList.a(new jon(this));
          ViewGroup.LayoutParams localLayoutParams = localViewPager.getLayoutParams();
          localLayoutParams.width = this.e;
          if (localPhotoGridAdapter.getCount() > 5)
          {
            k = this.f * 2 + this.g;
            localLayoutParams.height = k;
            localViewPager.setLayoutParams(localLayoutParams);
            localViewPager.setAdapter(paramList);
            k = paramList.getCount();
            localCirclePageIndicator.setViewPager(localViewPager);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            localViewPager.setVisibility(0);
            if (k > 1)
            {
              localCirclePageIndicator.setVisibility(0);
              setVisibility(0);
            }
          }
          else
          {
            k = this.f + this.g;
            continue;
          }
          localCirclePageIndicator.setVisibility(8);
          continue;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label429;
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      localViewPager.setVisibility(8);
      localCirclePageIndicator.setVisibility(8);
      setVisibility(0);
      return;
      label429:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      setVisibility(8);
      return;
      label454:
      int k = 0;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "onGetQZoneCover|isSuc = " + paramBoolean + ",uin=" + paramString + ",mUin=" + this.jdField_b_of_type_JavaLangString);
    }
    if (!Utils.a(paramString, this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    List localList;
    int k;
    if ((paramBoolean) && (parammobile_sub_get_cover_rsp != null))
    {
      localList = a(parammobile_sub_get_cover_rsp.type, parammobile_sub_get_cover_rsp.MulRelsotionUrl, parammobile_sub_get_cover_rsp.vecUrls);
      k = 0;
      parammobile_sub_get_cover_rsp = null;
      paramString = null;
      label100:
      if (k >= 20) {
        break label293;
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > k))
      {
        paramString = (QzonePhotoView.PhotoInfo)this.jdField_a_of_type_JavaUtilList.get(k);
        label143:
        if ((localList == null) || (localList.size() <= k)) {
          break label242;
        }
        parammobile_sub_get_cover_rsp = (QzonePhotoView.PhotoInfo)localList.get(k);
        label173:
        if (Utils.a(paramString, parammobile_sub_get_cover_rsp)) {
          break label247;
        }
      }
    }
    label293:
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.QzonePhotoView", 2, "onGetQZoneCover  isNewPhoto=" + String.valueOf(paramBoolean));
      }
      if ((!paramBoolean) && ((paramString != null) || (parammobile_sub_get_cover_rsp != null))) {
        break;
      }
      a(localList);
      return;
      paramString = null;
      break label143;
      label242:
      parammobile_sub_get_cover_rsp = null;
      break label173;
      label247:
      k += 1;
      break label100;
      if ((!NetworkUtil.b(BaseApplication.getContext())) || (this.h >= 3)) {
        break;
      }
      paramString = Message.obtain();
      paramString.what = 100;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
    }
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    ViewPager localViewPager = (ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131300954);
    paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    localViewPager.getLocationInWindow(this.jdField_b_of_type_ArrayOfInt);
    float f1 = paramMotionEvent.getRawY();
    int k;
    if ((localViewPager.getVisibility() == 0) && (f1 >= this.jdField_b_of_type_ArrayOfInt[1]) && (f1 < this.jdField_b_of_type_ArrayOfInt[1] + localViewPager.getHeight())) {
      k = 1;
    }
    for (;;)
    {
      paramMotionEvent.offsetLocation(0.0F, this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_b_of_type_ArrayOfInt[1]);
      label136:
      boolean bool1;
      switch (paramMotionEvent.getAction())
      {
      default: 
        bool1 = false;
        label139:
        if (!bool1) {
          break;
        }
      }
      try
      {
        bool1 = localViewPager.dispatchTouchEvent(paramMotionEvent);
        if (paramMotionEvent.getAction() != 0)
        {
          bool2 = this.jdField_c_of_type_Boolean;
          if ((!bool2) || (!bool1)) {}
        }
        for (bool1 = bool3;; bool1 = false)
        {
          bool2 = bool1;
          return bool2;
          k = 0;
          break;
          if (k == 0) {
            break label136;
          }
          this.jdField_c_of_type_Boolean = true;
          this.j = 0;
          this.jdField_b_of_type_Float = paramMotionEvent.getX();
          this.jdField_c_of_type_Float = paramMotionEvent.getY();
          bool1 = true;
          break label139;
          if (k != 0)
          {
            if ((this.jdField_c_of_type_Boolean) && (this.j == 0))
            {
              f1 = Math.abs(paramMotionEvent.getX() - this.jdField_b_of_type_Float);
              f2 = Math.abs(paramMotionEvent.getY() - this.jdField_c_of_type_Float);
              if ((f1 > this.i) && (f1 * 0.5F > f2)) {
                this.j = 1;
              }
            }
            while (-1 != this.j) {
              for (;;)
              {
                float f2;
                bool1 = this.jdField_c_of_type_Boolean;
                break;
                if (f2 > this.i) {
                  this.jdField_c_of_type_Boolean = false;
                }
              }
            }
            return false;
          }
          if (1 != this.j) {
            break label136;
          }
          this.j = -1;
          bool1 = false;
          break label139;
          bool1 = this.jdField_c_of_type_Boolean;
          if (this.jdField_c_of_type_Boolean)
          {
            if (k == 0) {
              this.jdField_c_of_type_Boolean = false;
            }
            this.j = 0;
          }
          break label139;
        }
        return false;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.QzonePhotoView", 2, "handleMessage() MSG_REQ_ALBUM");
      }
      paramMessage = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      if (paramMessage != null)
      {
        paramMessage.a(this.jdField_b_of_type_JavaLangString, 2);
        this.h += 1;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (SizeMeasure.a(this.jdField_a_of_type_AndroidAppActivity)) {}
    for (this.e = SizeMeasure.e(this.jdField_a_of_type_AndroidAppActivity);; this.e = SizeMeasure.h(this.jdField_a_of_type_AndroidAppActivity))
    {
      int k = getResources().getDimensionPixelSize(2131493210);
      this.f = ((this.e - k * 2 - this.g * 4) / 5);
      a(this.jdField_a_of_type_JavaUtilList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.QzonePhotoView
 * JD-Core Version:    0.7.0.1
 */