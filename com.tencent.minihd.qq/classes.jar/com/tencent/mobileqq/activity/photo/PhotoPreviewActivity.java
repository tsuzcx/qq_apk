package com.tencent.mobileqq.activity.photo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QualityCheckBox;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import gsy;
import gsz;
import gta;
import gtb;
import gtd;
import gte;
import gtf;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class PhotoPreviewActivity
  extends PeakActivity
  implements CompoundButton.OnCheckedChangeListener
{
  public int a;
  public View a;
  public Button a;
  public CheckBox a;
  public TextView a;
  ProGallery jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery;
  public QualityCheckBox a;
  gtf jdField_a_of_type_Gtf;
  public String a;
  public ArrayList a;
  public boolean a;
  public int b;
  public View b;
  public TextView b;
  public String b;
  public ArrayList b;
  boolean b;
  private int jdField_c_of_type_Int = 0;
  View jdField_c_of_type_AndroidViewView;
  public String c;
  boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = false;
  private String jdField_e_of_type_JavaLangString = null;
  boolean jdField_e_of_type_Boolean = false;
  private String f;
  private String jdField_i_of_type_JavaLangString;
  private boolean jdField_i_of_type_Boolean = true;
  private String jdField_j_of_type_JavaLangString;
  private boolean jdField_j_of_type_Boolean = false;
  private String jdField_k_of_type_JavaLangString;
  private boolean jdField_k_of_type_Boolean = false;
  
  public PhotoPreviewActivity()
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    int m = 0;
    while (m < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      Integer localInteger = (Integer)this.jdField_b_of_type_JavaUtilArrayList.get(m);
      if ((localInteger != null) && (localInteger.intValue() >= 0) && (localInteger.intValue() < this.jdField_a_of_type_JavaUtilArrayList.size())) {
        localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(localInteger.intValue()));
      }
      m += 1;
    }
    return localArrayList;
  }
  
  private void a(String paramString)
  {
    if (new File(paramString).length() > 19922944L)
    {
      QQToast.a(this, getResources().getString(2131368366), 0).b(getResources().getDimensionPixelSize(2131492923));
      a(false, false, 2131368365);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setChecked(paramBoolean1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setEnabled(paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setText(paramInt);
  }
  
  private void c()
  {
    Intent localIntent = getIntent();
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("FROM_WHERE");
    localIntent.removeExtra("FROM_WHERE");
    this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      localObject = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!new File((String)((Iterator)localObject).next()).exists()) {
        ((Iterator)localObject).remove();
      }
    }
    this.jdField_d_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    int m = 0;
    while (m < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(m));
      m += 1;
    }
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.MY_UIN");
      this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.MY_NICK");
      this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.MY_HEAD_DIR");
    }
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (localObject = this.h;; localObject = this.jdField_a_of_type_JavaLangString)
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      this.jdField_a_of_type_Int = localIntent.getIntExtra("uintype", -1);
      this.jdField_j_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
      this.jdField_c_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
      this.jdField_d_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
      this.jdField_c_of_type_Int = localIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      this.jdField_e_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
      if (this.jdField_e_of_type_Boolean) {
        PhotoUtils.a(this, getIntent(), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_c_of_type_Int, true);
      }
      this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      this.jdField_k_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false);
      if (this.jdField_k_of_type_Boolean)
      {
        this.jdField_i_of_type_JavaLangString = localIntent.getStringExtra("uinname");
        this.f = localIntent.getStringExtra("uin");
      }
      if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_JavaLangString != null))
      {
        localObject = QZoneHelper.a(this.jdField_a_of_type_JavaLangString, this.f);
        if ((localObject == null) || (((BaseBusinessAlbumInfo)localObject).b() == null) || (((BaseBusinessAlbumInfo)localObject).b().equals(""))) {
          break;
        }
        this.jdField_j_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject).b();
        this.jdField_k_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject).c();
        localIntent.putExtra("key_album_id", this.jdField_j_of_type_JavaLangString);
        localIntent.putExtra("key_album_name", this.jdField_k_of_type_JavaLangString);
      }
      return;
    }
    localIntent.putExtra("key_album_id", "");
    localIntent.putExtra("key_album_name", "");
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131298124);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131297470);
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298136));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox = ((QualityCheckBox)findViewById(2131298137));
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298135));
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131298138));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297001));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnClickListener(new gsy(this));
      this.jdField_c_of_type_AndroidViewView = findViewById(2131298125);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new gsz(this));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new gta(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new gtb(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery = ((ProGallery)findViewById(2131297712));
      this.jdField_a_of_type_Gtf = new gtf(this, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setAdapter(this.jdField_a_of_type_Gtf);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setOnNoBlankListener(this.jdField_a_of_type_Gtf);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setOnItemSelectedListener(new gtd(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setSpacing(getResources().getDimensionPixelSize(2131492982));
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setSelection(this.jdField_b_of_type_Int);
      e();
      if ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setOnItemClickListener(new gte(this));
      if (QualityCheckBox.a(this.jdField_a_of_type_Int)) {
        break label422;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setEnabled(false);
    }
    label422:
    while ((this.jdField_c_of_type_Int != 2) || (a().size() <= 0))
    {
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setVisibility(8);
      break;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setChecked(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setText(a(), this.jdField_a_of_type_Int);
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_Boolean) {}
    for (String str = getString(2131368351);; str = getString(2131368352))
    {
      if (this.jdField_k_of_type_Boolean) {
        str = getString(2131368353);
      }
      if (this.jdField_e_of_type_JavaLangString != null) {
        str = this.jdField_e_of_type_JavaLangString;
      }
      if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
        break label201;
      }
      if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    if (QualityCheckBox.a(this.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setEnabled(true);
    }
    if ((this.jdField_b_of_type_JavaUtilArrayList.size() == 1) && (!this.jdField_k_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str + "(" + this.jdField_b_of_type_JavaUtilArrayList.size() + ")");
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    label201:
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    a(false, false, 2131368350);
  }
  
  private void f()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      localObject = PresendPicMgr.a(null);
      if (localObject != null) {
        ((PresendPicMgr)localObject).a();
      }
      localObject = a();
      if (localObject != null) {
        StatisticConstants.b(getIntent(), ((ArrayList)localObject).size());
      }
      AIOGalleryUtils.a(this, getIntent(), this.jdField_a_of_type_JavaLangString, this.f, this.jdField_i_of_type_JavaLangString, this.jdField_j_of_type_JavaLangString, this.jdField_k_of_type_JavaLangString, this.jdField_c_of_type_Int, a());
      return;
    }
    Object localObject = a();
    if (localObject != null)
    {
      StatisticConstants.a(((ArrayList)localObject).size(), this.jdField_d_of_type_Int);
      StatisticConstants.a(getIntent(), ((ArrayList)localObject).size(), this.jdField_c_of_type_Int);
    }
    localObject = getIntent();
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
    if (this.jdField_c_of_type_Int == 2) {
      if (localPresendPicMgr != null)
      {
        localPresendPicMgr.a();
        localPresendPicMgr.b();
      }
    }
    for (;;)
    {
      PhotoUtils.a(this, (Intent)localObject, a(), this.jdField_c_of_type_Int, this.jdField_a_of_type_Boolean);
      return;
      if (localPresendPicMgr != null) {
        localPresendPicMgr.a((Intent)localObject);
      }
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d(g, 4, "[PhotoPreviewActivity] [onActivityResult] requestCode = " + paramInt1 + "  resultCode:" + paramInt2 + "  ok:" + -1);
    }
    if ((paramInt2 == -1) && (paramInt1 == 100003))
    {
      if ((a() != null) && (a().size() != 0))
      {
        PhotoMagicStickUtils.a((String)a().get(0), this, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
        overridePendingTransition(2130968627, 2130968628);
      }
      return;
    }
    PhotoUtils.a(this, paramInt1, paramInt2, paramIntent, this.jdField_j_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.a(false)) {
      return;
    }
    if ("FROM_PHOTO_LIST".equals(this.jdField_d_of_type_JavaLangString))
    {
      Intent localIntent = getIntent();
      localIntent.setClass(this, PhotoListActivity.class);
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_c_of_type_Int);
      if (this.jdField_d_of_type_Boolean) {
        localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      }
      for (;;)
      {
        startActivity(localIntent);
        finish();
        AlbumUtil.a(this, true, false);
        return;
        localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", a());
      }
    }
    finish();
    AlbumUtil.a(this, true, false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int m = 0;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setText(a(), this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setChecked(this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.isEnabled());
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.isEnabled()) {
        m = 2;
      }
      this.jdField_c_of_type_Int = m;
      return;
    }
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setText(2131368350);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130903412);
    c();
    d();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    int m = 0;
    try
    {
      while (m < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if ((String)this.jdField_a_of_type_JavaUtilArrayList.get(m) != null)
        {
          File localFile = new File((String)this.jdField_a_of_type_JavaUtilArrayList.get(m));
          URLDrawable.removeMemoryCacheByUrl(localFile.toURL().toString());
          URLDrawable.removeMemoryCacheByUrl(localFile.toURL().toString() + "#NOSAMPLE");
        }
        m += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoPreviewActivity", 2, "remove file error");
      }
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    c();
    d();
  }
  
  @TargetApi(9)
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */