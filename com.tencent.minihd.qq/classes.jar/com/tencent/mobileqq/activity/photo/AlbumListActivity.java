package com.tencent.mobileqq.activity.photo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.MaxHeightListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.video.QzoneVideoPluginProxyActivity;
import cooperation.zebra.ZebraPluginProxyActivity;
import gro;
import java.util.ArrayList;

public class AlbumListActivity
  extends PeakActivity
{
  public static final int a = 100;
  static final String jdField_a_of_type_JavaLangString = AlbumListActivity.class.getSimpleName();
  public static final String b = "_size>0) GROUP BY (_data";
  static final String jdField_c_of_type_JavaLangString = "peak.myUin";
  public AlbumListAdapter a;
  public XListView a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int;
  ArrayList jdField_b_of_type_JavaUtilArrayList;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  private String e = null;
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = ViewConfiguration.get(this).getScaledWindowTouchSlop();
    paramMotionEvent = getWindow().getDecorView();
    return (i < -k) || (j < -k) || (i > paramMotionEvent.getWidth() + k) || (j > paramMotionEvent.getHeight() + k);
  }
  
  private void c()
  {
    Intent localIntent = getIntent();
    this.e = localIntent.getStringExtra("ALBUM_ID");
    if (this.e == null) {
      this.e = "$RecentAlbumId";
    }
    this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.jdField_d_of_type_Int = localIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", MediaFileFilter.MEDIA_FILTER_DEFAULT.ordinal());
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("peak.myUin");
    if (this.jdField_d_of_type_JavaLangString == null)
    {
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.a();
      if (this.jdField_d_of_type_JavaLangString == null) {
        throw new RuntimeException("must set MY_UIN");
      }
    }
  }
  
  @TargetApi(9)
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListAdapter = new AlbumListAdapter(this, MediaFileFilter.filterOfOrdinal(this.jdField_d_of_type_Int), this.e);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131299783));
    this.jdField_a_of_type_ComTencentWidgetXListView.setChoiceMode(1);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new gro(this, null));
    if (Build.VERSION.SDK_INT > 8) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Window localWindow = getWindow();
    localWindow.setBackgroundDrawableResource(2130837667);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.y = getResources().getDimensionPixelSize(2131492917);
    localLayoutParams.width = getResources().getDimensionPixelSize(2131493496);
    if (getResources().getConfiguration().orientation == 2) {
      localLayoutParams.width = ((int)(SizeMeasure.h(this) / SizeMeasure.i(this) * localLayoutParams.width));
    }
    localLayoutParams.height = -2;
    localLayoutParams.dimAmount = 0.0F;
    localLayoutParams.flags = 25231616;
    localLayoutParams.gravity = 49;
    localWindow.setAttributes(localLayoutParams);
  }
  
  public void onBackPressed()
  {
    int i = 0;
    if (!this.jdField_b_of_type_Boolean)
    {
      finish();
      AlbumUtil.a();
      AlbumUtil.a(this, false);
      localObject = PresendPicMgr.a(null);
      if (localObject != null) {
        ((PresendPicMgr)localObject).a();
      }
      localObject = getIntent();
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
      }
      StatisticConstants.b((Intent)localObject, i);
      return;
    }
    Object localObject = getIntent();
    String str1 = ((Intent)localObject).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = ((Intent)localObject).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null)
    {
      QQToast.a(this, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
      return;
    }
    ((Intent)localObject).removeExtra("PhotoConst.PHOTO_PATHS");
    ((Intent)localObject).removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    ((Intent)localObject).addFlags(603979776);
    if (str1.startsWith("com.qzone"))
    {
      QzonePluginProxyActivity.a((Intent)localObject, str1);
      ((Intent)localObject).putExtra("cleartop", true);
      QZoneHelper.a(this, this.jdField_d_of_type_JavaLangString, (Intent)localObject, -1);
    }
    for (;;)
    {
      finish();
      AlbumUtil.a(this, false, false);
      break;
      ((Intent)localObject).setClassName(str2, str1);
      if (!((Intent)localObject).getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false))
      {
        startActivity((Intent)localObject);
      }
      else
      {
        str2 = ((Intent)localObject).getStringExtra("PhotoConst.PLUGIN_NAME");
        String str3 = ((Intent)localObject).getStringExtra("PhotoConst.PLUGIN_APK");
        String str4 = ((Intent)localObject).getStringExtra("PhotoConst.UIN");
        if ("WaterMarkCamera.apk".equals(str2)) {
          ((Intent)localObject).putExtra("cleartop", true);
        }
        if ("qzone_plugin.apk".equals(str3))
        {
          ((Intent)localObject).putExtra("qzone_plugin_activity_name", str1);
          QZoneHelper.a(this, str4, (Intent)localObject, 2);
        }
        else if ("QzoneVideoPlugin.apk".equals(str3))
        {
          QzoneVideoPluginProxyActivity.a((Intent)localObject, str1);
          ((Intent)localObject).putExtra("cleartop", true);
          QzoneVideoPluginProxyActivity.a(this, str4, (Intent)localObject, -1);
        }
        else if ("qqfav.apk".equals(str3))
        {
          QfavHelper.a(this, this.jdField_d_of_type_JavaLangString, (Intent)localObject, -1);
        }
        else
        {
          IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
          localPluginParams.jdField_b_of_type_JavaLangString = str3;
          localPluginParams.jdField_d_of_type_JavaLangString = str2;
          localPluginParams.jdField_a_of_type_JavaLangString = str4;
          localPluginParams.e = str1;
          localPluginParams.jdField_a_of_type_JavaLangClass = ZebraPluginProxyActivity.class;
          localPluginParams.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject);
          localPluginParams.jdField_b_of_type_Int = 2;
          localPluginParams.jdField_a_of_type_AndroidAppDialog = null;
          IPluginManager.a(this, localPluginParams);
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    int i = 4;
    int k = getResources().getDimensionPixelSize(2131493496);
    int j = k;
    if (paramConfiguration.orientation == 2)
    {
      i = 3;
      float f = SizeMeasure.h(this) / SizeMeasure.i(this);
      j = (int)(k * f);
    }
    localLayoutParams.width = j;
    localLayoutParams.height = -2;
    localLayoutParams.gravity = 49;
    localLayoutParams.flags = 25231616;
    localWindow.setAttributes(localLayoutParams);
    j = getResources().getDimensionPixelSize(2131493497);
    ((MaxHeightListView)this.jdField_a_of_type_ComTencentWidgetXListView).setMaxHeight(i * j);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130903835);
    this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131493048);
    this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    c();
    d();
  }
  
  protected void onDestroy()
  {
    AlbumThumbManager.a(this).a();
    if (!this.jdField_c_of_type_Boolean) {
      AlbumUtil.c();
    }
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    c();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (a(paramMotionEvent)))
    {
      onBackPressed();
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.AlbumListActivity
 * JD-Core Version:    0.7.0.1
 */