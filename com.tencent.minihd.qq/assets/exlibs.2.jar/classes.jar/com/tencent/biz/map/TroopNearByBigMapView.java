package com.tencent.biz.map;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import chl;
import chm;
import chn;
import cho;
import chp;
import chq;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.troop.data.NearbyTroops;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView.NearbyTroopsMapViewObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.Projection;

public class TroopNearByBigMapView
  extends FrameLayout
{
  private static final boolean jdField_a_of_type_Boolean = true;
  private static final int jdField_c_of_type_Int = 1;
  private static final int d = 2;
  private static final int e = 3;
  private int jdField_a_of_type_Int = 0;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private chq jdField_a_of_type_Chq;
  private TroopNearByBigMapView.IMapLogicCallBack jdField_a_of_type_ComTencentBizMapTroopNearByBigMapView$IMapLogicCallBack;
  private TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  private LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new chl(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private NearbyTroopsMapView.NearbyTroopsMapViewObserver jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView$NearbyTroopsMapViewObserver = new chp(this);
  private NearbyTroopsMapView jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView;
  private MapController jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController;
  private int jdField_b_of_type_Int = 0;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean jdField_c_of_type_Boolean;
  
  public TroopNearByBigMapView(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.c = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    GeoPoint localGeoPoint = new GeoPoint(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.setMyLocation(localGeoPoint);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setZoom(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getMaxZoomLevel() - 1);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.animateTo(localGeoPoint);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (!NetworkUtil.e(getContext())) {
      return false;
    }
    GeoPoint localGeoPoint = new GeoPoint(paramInt1, paramInt2);
    if (NearbyTroops.a(new GeoPoint(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int), localGeoPoint) >= 10000.0D) {}
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getHeight() >= this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getWidth()) {}
      for (int i = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getHeight();; i = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getWidth())
      {
        Projection localProjection = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getProjection();
        Point localPoint = localProjection.toPixels(localGeoPoint, null);
        double d1 = NearbyTroops.a(localProjection.fromPixels(localPoint.x - i, localPoint.y - i), localGeoPoint);
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramInt1, paramInt2, (int)d1, bool);
        return true;
      }
      bool = true;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setZoom(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getMaxZoomLevel() - 1);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setCenter(new GeoPoint(paramInt1, paramInt2));
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Int == 0)) {
      return;
    }
    chm localchm = new chm(this);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.animateTo(new GeoPoint(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int), localchm);
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.changeToBigModeNoAnimation();
  }
  
  private void h()
  {
    if (!NetworkUtil.f(getContext())) {
      return;
    }
    b(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Chq.sendEmptyMessage(2);
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Int == 0))
    {
      SosoInterface.a(new chn(this, 0, true, 0L, true, false, "TroopNearByBigMapView"));
      return;
    }
    a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView = ((NearbyTroopsMapView)findViewById(2131298698));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.setUIHandler(this.jdField_a_of_type_Chq);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getController();
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setZoom(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getMinZoomLevel());
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.setBuiltInZoomControls(false);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.setClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.setObserver(null);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.setObserver(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView$NearbyTroopsMapViewObserver);
    setContentDescription("");
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298675));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131298676));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new cho(this));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getResources().getString(2131365811));
    this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getResources().getString(2131365811));
  }
  
  public void a()
  {
    LayoutInflater.from(getContext()).inflate(2130903537, this, true);
    this.jdField_a_of_type_Chq = new chq(this);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    i();
  }
  
  public void b()
  {
    this.c = true;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    this.jdField_a_of_type_Chq.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Chq = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.onDestroy();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.onStop();
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.onResume();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Chq.sendEmptyMessage(1);
  }
  
  public void setMapLogicCallBack(TroopNearByBigMapView.IMapLogicCallBack paramIMapLogicCallBack)
  {
    this.jdField_a_of_type_ComTencentBizMapTroopNearByBigMapView$IMapLogicCallBack = paramIMapLogicCallBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.map.TroopNearByBigMapView
 * JD-Core Version:    0.7.0.1
 */