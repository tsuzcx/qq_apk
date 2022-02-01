package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.helper.QQHeadFace;
import com.tencent.mobileqq.adapter.WebBaseFacePreloadExpandableListAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.NearbyTroopsLocationActivity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.tencentmap.mapsdk.map.Projection;
import java.util.ArrayList;
import knt;
import knu;
import knv;
import knw;
import knx;
import kny;
import knz;
import koa;

public class NearbyTroopsMapView
  extends MapView
  implements View.OnClickListener, Animation.AnimationListener, NearbyTroopsMapViewItemOverlay.Callback
{
  static final int jdField_e_of_type_Int = 0;
  static final int f = 1;
  static final int g = 2;
  static final int h = 3;
  int jdField_a_of_type_Int = 0;
  public Context a;
  public Handler a;
  public View a;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  public ImageView a;
  public TextView a;
  private QQHeadFace jdField_a_of_type_ComTencentBizHelperQQHeadFace;
  private WebBaseFacePreloadExpandableListAdapter jdField_a_of_type_ComTencentMobileqqAdapterWebBaseFacePreloadExpandableListAdapter;
  public NearbyTroopsMapView.NearbyTroopsMapViewObserver a;
  public NearbyTroopsMapViewItemOverlay a;
  private NearbyTroopsMapViewOverlayItem jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewOverlayItem;
  public ValueAnimation a;
  public GeoPoint a;
  public Thread a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  public Handler b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public TextView b;
  private NearbyTroopsMapViewOverlayItem jdField_b_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewOverlayItem;
  public boolean b;
  int jdField_c_of_type_Int = 0;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  public TextView c;
  public boolean c;
  int d;
  public TextView d;
  public boolean d;
  boolean jdField_e_of_type_Boolean;
  public int i = 0;
  public int j = 0;
  
  public NearbyTroopsMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.e = false;
    this.jdField_b_of_type_AndroidOsHandler = new knt(this);
    this.jdField_a_of_type_JavaLangThread = new knu(this, "qqmapview_calculate_position");
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839148);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    addView(this.jdField_b_of_type_AndroidWidgetImageView);
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839149);
    paramAttributeSet = "";
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
    if ((localBaseActivity.getAppRuntime() instanceof QQAppInterface)) {
      paramAttributeSet = ((QQAppInterface)localBaseActivity.getAppRuntime()).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay = new NearbyTroopsMapViewItemOverlay(paramContext, localDrawable, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay.setShadowEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay.a(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay.setOnFocusChangeListener(new knv(this));
    addOverlay(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay);
    this.j = getZoomLevel();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903538, this, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298702));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298703));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298704));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298705));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298700));
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130968693);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298706));
    this.jdField_a_of_type_JavaLangThread.setPriority(10);
    this.jdField_a_of_type_JavaLangThread.start();
    this.jdField_a_of_type_ComTencentBizHelperQQHeadFace = new QQHeadFace(localBaseActivity);
    this.jdField_a_of_type_ComTencentBizHelperQQHeadFace.a(new knw(this));
  }
  
  private void a()
  {
    if (!this.e) {}
    NearbyTroopsMapViewOverlayItem localNearbyTroopsMapViewOverlayItem;
    do
    {
      return;
      localNearbyTroopsMapViewOverlayItem = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay.a(this);
    } while ((localNearbyTroopsMapViewOverlayItem == null) || ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewOverlayItem == localNearbyTroopsMapViewOverlayItem) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewOverlayItem = localNearbyTroopsMapViewOverlayItem;
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 200L);
  }
  
  private void b(NearbyTroopsMapViewOverlayItem paramNearbyTroopsMapViewOverlayItem)
  {
    if (!this.e)
    {
      b(false);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewOverlayItem = paramNearbyTroopsMapViewOverlayItem;
    int k;
    if (this.jdField_a_of_type_AndroidViewView.getWidth() == 0)
    {
      k = Util.a(this.jdField_a_of_type_AndroidContentContext, 250.0F);
      this.jdField_b_of_type_Int = k;
      this.jdField_c_of_type_Int = getWidth();
      if (this.jdField_c_of_type_AndroidWidgetImageView.getWidth() != 0) {
        break label404;
      }
      k = Util.a(this.jdField_a_of_type_AndroidContentContext, 44.0F);
      label73:
      this.jdField_d_of_type_Int = k;
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterWebBaseFacePreloadExpandableListAdapter == null) {
        break label535;
      }
    }
    label404:
    label535:
    for (Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAdapterWebBaseFacePreloadExpandableListAdapter.a(String.valueOf(paramNearbyTroopsMapViewOverlayItem.jdField_b_of_type_Long), true);; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentBizHelperQQHeadFace.a(String.valueOf(paramNearbyTroopsMapViewOverlayItem.jdField_b_of_type_Long), 4, true);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ImageUtil.a();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
      localObject1 = getProjection().toPixels(paramNearbyTroopsMapViewOverlayItem.getPoint().Copy(), null);
      if (((Point)localObject1).x < this.jdField_b_of_type_Int / 2) {
        if (((Point)localObject1).x - 60 > 0)
        {
          k = ((Point)localObject1).x - 60;
          label205:
          k += 30;
          label210:
          localObject1 = new MapView.LayoutParams(-2, -2, null, this.jdField_b_of_type_Int / 2 - k - this.jdField_d_of_type_Int / 2, -(this.jdField_a_of_type_Int * 43), 81);
          ((MapView.LayoutParams)localObject1).point = paramNearbyTroopsMapViewOverlayItem.getPoint().Copy();
          updateViewLayout(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject1);
          localObject1 = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject1).leftMargin = k;
          this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramNearbyTroopsMapViewOverlayItem.jdField_a_of_type_JavaLangString);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(paramNearbyTroopsMapViewOverlayItem.jdField_b_of_type_JavaLangString);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(paramNearbyTroopsMapViewOverlayItem.jdField_a_of_type_Long + "");
          if (paramNearbyTroopsMapViewOverlayItem.jdField_a_of_type_Long != 1L) {
            break label524;
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidViewView.setTag(paramNearbyTroopsMapViewOverlayItem);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay.setFocus(paramNearbyTroopsMapViewOverlayItem);
        refreshMap();
        b(true);
        return;
        k = this.jdField_a_of_type_AndroidViewView.getWidth();
        break;
        k = this.jdField_c_of_type_AndroidWidgetImageView.getWidth();
        break label73;
        k = 60;
        break label205;
        if (this.jdField_c_of_type_Int - ((Point)localObject1).x < this.jdField_b_of_type_Int / 2)
        {
          int m;
          if (this.jdField_c_of_type_Int - ((Point)localObject1).x > 60)
          {
            k = this.jdField_b_of_type_Int;
            m = this.jdField_c_of_type_Int;
          }
          for (k = ((Point)localObject1).x + (k - m) + 60 - this.jdField_d_of_type_Int;; k = this.jdField_b_of_type_Int - 60 - this.jdField_d_of_type_Int)
          {
            k -= 30;
            break;
          }
        }
        k = this.jdField_b_of_type_Int / 2 - this.jdField_d_of_type_Int / 2;
        break label210;
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public Message a(int paramInt, Point paramPoint)
  {
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
    localMessage.arg1 = paramInt;
    localMessage.obj = paramPoint;
    return localMessage;
  }
  
  public Message a(int paramInt, GeoPoint paramGeoPoint)
  {
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
    localMessage.arg1 = paramInt;
    localMessage.obj = paramGeoPoint;
    return localMessage;
  }
  
  public void a(NearbyTroopsMapViewOverlayItem paramNearbyTroopsMapViewOverlayItem)
  {
    Object localObject = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
    if ((((BaseActivity)localObject).getAppRuntime() instanceof QQAppInterface)) {
      ReportController.b((QQAppInterface)((BaseActivity)localObject).getAppRuntime(), "P_CliOper", "Grp_nearby", "", "nearbygrp_map", "Clk_label", 0, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
    {
      localObject = (NearbyTroopsMapViewOverlayItem)this.jdField_a_of_type_AndroidViewView.getTag();
      if (localObject == null) {}
      while ((((NearbyTroopsMapViewOverlayItem)localObject).getPoint().equals(paramNearbyTroopsMapViewOverlayItem.getPoint())) || (!((NearbyTroopsMapViewOverlayItem)localObject).jdField_a_of_type_Boolean)) {
        return;
      }
    }
    b(paramNearbyTroopsMapViewOverlayItem);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
        try
        {
          Object localObject = (NearbyTroopsMapViewOverlayItem)this.jdField_a_of_type_AndroidViewView.getTag();
          if ((localObject != null) && (String.valueOf(((NearbyTroopsMapViewOverlayItem)localObject).jdField_b_of_type_Long).equals(paramString)) && ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)))
          {
            localObject = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
            if ((((BaseActivity)localObject).getAppRuntime() instanceof QQAppInterface))
            {
              localObject = (QQAppInterface)((BaseActivity)localObject).getAppRuntime();
              this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(((QQAppInterface)localObject).a(paramString, (byte)3, false, false));
              return;
            }
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    if ((paramArrayList != null) && (paramArrayList.size() > 5))
    {
      ArrayList localArrayList = new ArrayList(5);
      int k = 0;
      while (k < 5)
      {
        localArrayList.add(paramArrayList.get(k));
        k += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay.a(localArrayList, Boolean.valueOf(true), true);
    }
    for (;;)
    {
      refreshMap();
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay.a(paramArrayList, Boolean.valueOf(true), true);
    }
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay.a(paramArrayList, Boolean.valueOf(false), paramBoolean);
    refreshMap();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
    View localView;
    do
    {
      return;
      this.e = paramBoolean;
      localView = ((NearbyTroopsActivity)this.jdField_a_of_type_AndroidContentContext).findViewById(2131298591);
    } while (localView == null);
    int k;
    if (paramBoolean)
    {
      k = localView.getHeight();
      int m = Utils.a(this.jdField_a_of_type_AndroidContentContext, 55.0F);
      this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation = new ValueAnimation(Integer.valueOf(getHeight()), Integer.valueOf(k - m), new knx(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation.setAnimationListener(new kny(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation.setDuration(250L);
      startAnimation(this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation);
      return;
      b(false);
      k = Utils.a(this.jdField_a_of_type_AndroidContentContext, 150.0F);
      this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation = new ValueAnimation(Integer.valueOf(getHeight()), Integer.valueOf(k), new knz(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation.setAnimationListener(new koa(this));
    }
  }
  
  public void changeToBigModeNoAnimation()
  {
    this.e = true;
    a();
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    this.i += 1;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView$NearbyTroopsMapViewObserver != null) && (this.jdField_a_of_type_JavaLangThread != null)) {
      synchronized (this.jdField_a_of_type_JavaLangThread)
      {
        this.jdField_a_of_type_JavaLangThread.notify();
        return;
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_c_of_type_Boolean = true;
      continue;
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.e)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {}
    while (!(localObject1 instanceof NearbyTroopsMapViewOverlayItem)) {
      return;
    }
    Object localObject2 = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
    paramView = null;
    if ((((BaseActivity)localObject2).getAppRuntime() instanceof QQAppInterface))
    {
      paramView = (QQAppInterface)((BaseActivity)localObject2).getAppRuntime();
      ReportController.b(paramView, "P_CliOper", "Grp_nearby", "", "nearbygrp_map", "Clk_bubble", 0, 0, "", "", "", "");
    }
    localObject1 = (NearbyTroopsMapViewOverlayItem)localObject1;
    localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyTroopsLocationActivity.class);
    ((Intent)localObject2).putExtra("lat", ((NearbyTroopsMapViewOverlayItem)localObject1).getPoint().getLatitudeE6());
    ((Intent)localObject2).putExtra("lon", ((NearbyTroopsMapViewOverlayItem)localObject1).getPoint().getLongitudeE6());
    ((Intent)localObject2).putExtra("location_name", ((NearbyTroopsMapViewOverlayItem)localObject1).jdField_a_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("from", 10);
    ((Intent)localObject2).putExtra("mode", 1);
    ((Intent)localObject2).putExtra("is_show_mapentry", false);
    ((Intent)localObject2).putExtra("leftViewText", this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131366374));
    NearbyTroopsLocationActivity.a(this.jdField_a_of_type_AndroidContentContext, paramView, (Intent)localObject2);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentBizHelperQQHeadFace.a();
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqAdapterWebBaseFacePreloadExpandableListAdapter = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewItemOverlay = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView$NearbyTroopsMapViewObserver = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      this.jdField_a_of_type_JavaLangThread.interrupt();
      this.jdField_a_of_type_JavaLangThread = null;
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler = null;
    super.onDestroy();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.e) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public void setFaceAdapter(WebBaseFacePreloadExpandableListAdapter paramWebBaseFacePreloadExpandableListAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqAdapterWebBaseFacePreloadExpandableListAdapter = paramWebBaseFacePreloadExpandableListAdapter;
  }
  
  public void setMyLocation(GeoPoint paramGeoPoint)
  {
    MapView.LayoutParams localLayoutParams = new MapView.LayoutParams(-2, -2, null, 81);
    localLayoutParams.point = paramGeoPoint.Copy();
    updateViewLayout(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void setObserver(NearbyTroopsMapView.NearbyTroopsMapViewObserver paramNearbyTroopsMapViewObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView$NearbyTroopsMapViewObserver = paramNearbyTroopsMapViewObserver;
  }
  
  public void setUIHandler(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.NearbyTroopsMapView
 * JD-Core Version:    0.7.0.1
 */