package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
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
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.GridView;
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
import jop;

public class VipPhotoViewForSimple
  extends LinearLayout
  implements Handler.Callback
{
  public static final int a = 100;
  public static final String a = "ProfileCard.VipPhotoViewForSimple";
  public static float b = 0.0F;
  public static final int b = 1;
  public static final int c = 16;
  public static final int k = 240;
  public float a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new jop(this);
  View jdField_a_of_type_AndroidViewView;
  public HorizontalScrollView a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ProfileCardInfo jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo;
  public GridView a;
  CoverCacheData jdField_a_of_type_CooperationQzoneModelCoverCacheData;
  public List a;
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  public int d;
  public int e;
  public int f = -1;
  public int g = -1;
  public int h = -1;
  public int i = -1;
  public int j = -1;
  public int l = -1;
  public int m = -1;
  private int n;
  
  static
  {
    jdField_b_of_type_Float = 1.43F;
  }
  
  public VipPhotoViewForSimple(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Float = 1.5F;
  }
  
  public VipPhotoViewForSimple(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = 1.5F;
  }
  
  private List a(String paramString, Map paramMap, List paramList)
  {
    int i2 = 0;
    LinkedList localLinkedList = new LinkedList();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update").append("|type = ").append(paramString).append("|MulRelsotionUrl = ").append(paramMap).append("|vecUrls = ").append(paramList);
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_CooperationQzoneModelCoverCacheData == null) {
      this.jdField_a_of_type_CooperationQzoneModelCoverCacheData = new CoverCacheData();
    }
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.type = paramString;
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.urls = ((HashMap)paramMap);
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.photoWall = ((ArrayList)paramList);
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.uin = Long.parseLong(this.jdField_b_of_type_JavaLangString);
    int i1;
    if (paramList != null) {
      i1 = paramList.size();
    }
    while ((i2 < i1) && (i2 < 16))
    {
      paramString = (Map)paramList.get(i2);
      if (paramString != null)
      {
        paramString = new QzonePhotoView.PhotoInfo(i2, 100, paramString);
        paramString.i = localLinkedList.size();
        paramString.h = i2;
        localLinkedList.add(paramString);
      }
      i2 += 1;
      continue;
      i1 = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "updateCoverData photoInfo size=" + localLinkedList.size());
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
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "initView");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_b_of_type_JavaLangString = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()).inflate(2130904124, this, true);
    this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300953));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300952));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300951));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300950);
    paramBaseActivity = getResources().getDisplayMetrics();
    this.d = paramBaseActivity.widthPixels;
    this.e = paramBaseActivity.heightPixels;
    int i1 = (int)(this.d / this.jdField_a_of_type_Float);
    this.f = i1;
    this.i = i1;
    this.l = getResources().getDimensionPixelSize(2131493216);
    this.m = getResources().getDimensionPixelSize(2131493217);
    this.j = ((int)(paramBaseActivity.density * 240.0F));
    this.g = this.j;
    this.f = this.j;
    this.h = getResources().getDimensionPixelSize(2131493212);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (VersionUtils.c()) {
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setOverScrollMode(2);
      }
      paramBaseActivity = (QZoneCover)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(QZoneCover.class, this.jdField_b_of_type_JavaLangString);
      if (paramBaseActivity != null)
      {
        new LinkedList();
        a(a(paramBaseActivity.type, paramBaseActivity.parseCoverInfo(), paramBaseActivity.parsePhotoInfo()));
      }
      paramBaseActivity = Message.obtain();
      paramBaseActivity.what = 100;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramBaseActivity);
      return;
    }
  }
  
  public void a(CoverCacheData paramCoverCacheData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "updateCoverCacheData data = " + paramCoverCacheData);
    }
    if (paramCoverCacheData != null) {
      a(a(paramCoverCacheData.type, paramCoverCacheData.urls, paramCoverCacheData.photoWall));
    }
    if ((this.jdField_a_of_type_CooperationQzoneModelCoverCacheData != null) && (Utils.a("PhotoWallCover", this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.type)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "need get req cover info");
      }
      paramCoverCacheData = Message.obtain();
      paramCoverCacheData.what = 100;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramCoverCacheData);
    }
  }
  
  public void a(List paramList)
  {
    if ((QLog.isColorLevel()) && (paramList != null)) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "updatePhotoView photoInfo size=" + paramList.size());
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (paramList != null) {}
    for (int i1 = paramList.size(); (i1 > 0) && (this.jdField_a_of_type_ComTencentWidgetGridView != null); i1 = 0)
    {
      this.jdField_a_of_type_ComTencentWidgetGridView.setPadding(0, this.l, 0, this.m);
      this.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.f);
      this.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(0);
      this.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.h);
      VipPhotoViewForSimple.PhotoAdapter localPhotoAdapter = new VipPhotoViewForSimple.PhotoAdapter(this, this.jdField_a_of_type_AndroidAppActivity);
      localPhotoAdapter.a(paramList);
      i1 = paramList.size();
      paramList = new LinearLayout.LayoutParams((this.f + this.h) * i1, this.j);
      this.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams(paramList);
      this.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(i1);
      this.jdField_a_of_type_ComTencentWidgetGridView.setAdapter(localPhotoAdapter);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(0);
      setVisibility(0);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      ProfileCardTemplate.a(this.jdField_a_of_type_AndroidWidgetImageView, "src", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddSrc");
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(new DataTag(25, null));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(8);
      setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    setVisibility(8);
  }
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "onGetQZoneCover|isSuc = " + paramBoolean + ",uin=" + paramString + ",mUin=" + this.jdField_b_of_type_JavaLangString);
    }
    if (!Utils.a(paramString, this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    List localList;
    int i1;
    if ((paramBoolean) && (parammobile_sub_get_cover_rsp != null))
    {
      localList = a(parammobile_sub_get_cover_rsp.type, parammobile_sub_get_cover_rsp.MulRelsotionUrl, parammobile_sub_get_cover_rsp.vecUrls);
      i1 = 0;
      parammobile_sub_get_cover_rsp = null;
      paramString = null;
      label100:
      if (i1 >= 16) {
        break label293;
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > i1))
      {
        paramString = (QzonePhotoView.PhotoInfo)this.jdField_a_of_type_JavaUtilList.get(i1);
        label143:
        if ((localList == null) || (localList.size() <= i1)) {
          break label242;
        }
        parammobile_sub_get_cover_rsp = (QzonePhotoView.PhotoInfo)localList.get(i1);
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
        QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "onGetQZoneCover  isNewPhoto=" + String.valueOf(paramBoolean));
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
      i1 += 1;
      break label100;
      if ((!NetworkUtil.b(BaseApplication.getContext())) || (this.n >= 3)) {
        break;
      }
      paramString = Message.obtain();
      paramString.what = 100;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
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
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "handleMessage() MSG_REQ_ALBUM");
      }
      paramMessage = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      if (paramMessage != null)
      {
        paramMessage.a(this.jdField_b_of_type_JavaLangString, 2);
        this.n += 1;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipPhotoViewForSimple
 * JD-Core Version:    0.7.0.1
 */