package com.tencent.mobileqq.activity.photo;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pic.IPresendPicMgr.Stub;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileProvider7Helper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.GuideDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QualityCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;
import common.config.service.QzoneConfig;
import cooperation.photoplus.PhotoPlusBridgeActivity;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import cooperation.qzone.video.QzoneVideoPluginProxyActivity;
import cooperation.zebra.ZebraPluginProxyActivity;
import gso;
import gsp;
import gsq;
import gsr;
import gss;
import gst;
import gsu;
import gsv;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class PhotoListActivity
  extends PeakActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final String a;
  private static final HashMap jdField_a_of_type_JavaUtilHashMap;
  static final String jdField_b_of_type_JavaLangString = "FROM_WHERE";
  static final String jdField_c_of_type_JavaLangString = "FROM_PHOTO_LIST";
  private static final int g = 100;
  private static final int h = 101;
  private static final int jdField_i_of_type_Int = -1;
  private static final int jdField_j_of_type_Int = 4;
  private static final int jdField_k_of_type_Int = 6;
  private static int jdField_l_of_type_Int;
  private static int jdField_s_of_type_Int;
  private static final int jdField_t_of_type_Int = jdField_a_of_type_JavaUtilHashMap.size();
  public int a;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public AsyncTask a;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private PresendPicMgr jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
  public QualityCheckBox a;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new gsq(this);
  GestureSelectGridView.OnSelectListener jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener = new gso(this);
  public GestureSelectGridView a;
  public gsv a;
  public ArrayList a;
  public boolean a;
  public int b;
  private long jdField_b_of_type_Long;
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  private long jdField_c_of_type_Long;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean = false;
  public int d;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  public int e;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  String f;
  private String jdField_i_of_type_JavaLangString;
  private boolean jdField_i_of_type_Boolean = true;
  private String jdField_j_of_type_JavaLangString;
  private boolean jdField_j_of_type_Boolean = false;
  private String jdField_k_of_type_JavaLangString = null;
  private boolean jdField_k_of_type_Boolean = false;
  private String jdField_l_of_type_JavaLangString;
  private boolean jdField_l_of_type_Boolean = false;
  private int jdField_m_of_type_Int;
  private String jdField_m_of_type_JavaLangString;
  private boolean jdField_m_of_type_Boolean;
  private int jdField_n_of_type_Int;
  private String jdField_n_of_type_JavaLangString;
  private boolean jdField_n_of_type_Boolean = false;
  private int jdField_o_of_type_Int;
  private String jdField_o_of_type_JavaLangString;
  private boolean jdField_o_of_type_Boolean = false;
  private int jdField_p_of_type_Int;
  private String jdField_p_of_type_JavaLangString;
  private boolean jdField_p_of_type_Boolean;
  private int jdField_q_of_type_Int;
  private boolean jdField_q_of_type_Boolean;
  private int jdField_r_of_type_Int = 0;
  private boolean jdField_r_of_type_Boolean = false;
  private boolean jdField_s_of_type_Boolean = true;
  private boolean jdField_t_of_type_Boolean = false;
  private boolean u = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = PhotoListActivity.class.getSimpleName();
    jdField_l_of_type_Int = 4;
    jdField_s_of_type_Int = -1;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("image", Integer.valueOf(0));
    jdField_a_of_type_JavaUtilHashMap.put("video", Integer.valueOf(1));
    jdField_a_of_type_JavaUtilHashMap.put("mobileqq", Integer.valueOf(2));
  }
  
  public PhotoListActivity()
  {
    this.jdField_a_of_type_Gsv = null;
    this.jdField_d_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
  }
  
  @TargetApi(8)
  private File a()
  {
    Object localObject = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String str = "JPEG_" + (String)localObject + "_";
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      boolean bool = false;
      if (Build.VERSION.SDK_INT > 7)
      {
        localObject = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        bool = true;
      }
      while (bool)
      {
        localObject = File.createTempFile(str, ".jpg", (File)localObject);
        this.jdField_p_of_type_JavaLangString = ((File)localObject).getAbsolutePath();
        return localObject;
        File localFile = new File(Environment.getExternalStorageDirectory(), "DCIM");
        localObject = localFile;
        if (!localFile.exists())
        {
          bool = localFile.mkdirs();
          localObject = localFile;
        }
      }
    }
    return null;
  }
  
  private void a(Intent paramIntent)
  {
    paramIntent = (BinderWarpper)paramIntent.getParcelableExtra("binder_presendService");
    if (paramIntent != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = PresendPicMgr.a(IPresendPicMgr.Stub.a(paramIntent.a));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + "  initPresendMgr , mPresendMgr = " + this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + "  initPresendMgr , bw is null ! ");
      }
    }
  }
  
  private void a(Configuration paramConfiguration)
  {
    if (paramConfiguration == null)
    {
      i1 = getResources().getConfiguration().orientation;
      if (i1 != 1) {
        break label35;
      }
    }
    label35:
    for (int i1 = 4;; i1 = 6)
    {
      jdField_l_of_type_Int = i1;
      return;
      i1 = paramConfiguration.orientation;
      break;
    }
  }
  
  private void a(String paramString)
  {
    if (new File(paramString).length() > 19922944L)
    {
      QQToast.a(this, getResources().getString(2131368366), 0).b(this.jdField_e_of_type_Int);
      a(false, false, 2131368365);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i1 = 0;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setText(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_q_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setChecked(this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.isEnabled());
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.isEnabled()) {
        i1 = 2;
      }
      this.jdField_r_of_type_Int = i1;
      return;
    }
    this.jdField_r_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setText(2131368350);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.jdField_r_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setChecked(paramBoolean1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setEnabled(paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setText(paramInt);
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (!"image".equals(MimeHelper.a(paramLocalMediaInfo.jdField_b_of_type_JavaLangString)[0])) {}
    long l1;
    do
    {
      int i1;
      do
      {
        return false;
        i1 = paramLocalMediaInfo.jdField_b_of_type_Int;
      } while (((i1 == 1) && (paramBoolean)) || ((i1 == 2) && (!paramBoolean)));
      if ((i1 != 2) || (!paramBoolean) || (this.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_d_of_type_Int)) {
        break;
      }
      l1 = System.currentTimeMillis();
    } while (l1 - this.jdField_a_of_type_Long < 700L);
    QQToast.a(this, "最多只能选择" + this.jdField_d_of_type_Int + "张图片", 1000).b(this.jdField_e_of_type_Int);
    this.jdField_a_of_type_Long = l1;
    return false;
    String str = paramLocalMediaInfo.jdField_a_of_type_JavaLangString;
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(str);
      if (this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr != null) {
        this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr.a(str);
      }
      StatisticConstants.a(getIntent(), "param_totalSelNum");
      Object localObject = getIntent();
      if (!((Intent)localObject).hasExtra("param_initTime")) {
        ((Intent)localObject).putExtra("param_initTime", System.currentTimeMillis());
      }
      paramLocalMediaInfo.jdField_b_of_type_Int = 1;
      localObject = (LinkedHashMap)AlbumUtil.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_j_of_type_JavaLangString);
      paramLocalMediaInfo = (LocalMediaInfo)localObject;
      if (localObject == null)
      {
        paramLocalMediaInfo = new LinkedHashMap();
        AlbumUtil.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_j_of_type_JavaLangString, paramLocalMediaInfo);
      }
      paramLocalMediaInfo.put(str, Integer.valueOf(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s()));
      paramLocalMediaInfo = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.jdField_j_of_type_JavaLangString, this.jdField_i_of_type_JavaLangString));
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.isChecked()) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setText(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_q_of_type_Int);
      }
      return true;
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramLocalMediaInfo.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr != null) {
        this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr.b(paramLocalMediaInfo.jdField_a_of_type_JavaLangString);
      }
      paramLocalMediaInfo.jdField_b_of_type_Int = 2;
      StatisticConstants.a(getIntent(), "param_cancelSelNum");
      paramLocalMediaInfo = (HashMap)AlbumUtil.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_j_of_type_JavaLangString);
      if (paramLocalMediaInfo != null) {
        paramLocalMediaInfo.remove(str);
      }
      paramLocalMediaInfo = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
      if (paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.remove(str);
      }
    }
  }
  
  private void b(Intent paramIntent)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + " initData(),intent extras is:" + paramIntent.getExtras());
    }
    a(paramIntent);
    this.jdField_n_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    label388:
    Object localObject;
    if (paramIntent.getBooleanExtra("album_enter_directly", false))
    {
      long l1 = System.currentTimeMillis();
      long l2 = AlbumUtil.jdField_c_of_type_Long;
      if ((this.jdField_n_of_type_Boolean) && (l1 - l2 < 60000L))
      {
        this.jdField_i_of_type_JavaLangString = AlbumUtil.jdField_c_of_type_JavaLangString;
        this.jdField_j_of_type_JavaLangString = AlbumUtil.jdField_b_of_type_JavaLangString;
      }
      if (this.jdField_j_of_type_JavaLangString == null)
      {
        this.jdField_j_of_type_JavaLangString = "$RecentAlbumId";
        this.jdField_i_of_type_JavaLangString = null;
      }
      this.jdField_a_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_d_of_type_Int = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
      this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
      this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SET_BACKGROUND", false);
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.MY_UIN");
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.MY_NICK");
        this.f = paramIntent.getStringExtra("PhotoConst.MY_HEAD_DIR");
      }
      this.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
      this.jdField_j_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
      this.jdField_k_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_NEED_EDIT", false);
      this.jdField_l_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
      this.jdField_q_of_type_Int = paramIntent.getIntExtra("uintype", -1);
      this.jdField_r_of_type_Int = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      if (this.jdField_d_of_type_Int > 1) {
        this.jdField_a_of_type_Boolean = false;
      }
      this.jdField_m_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
      this.jdField_o_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
      if ((this.jdField_q_of_type_Int != 1) || (paramIntent.getBooleanExtra("is_anonymous", false)) || (this.jdField_c_of_type_Boolean)) {
        break label720;
      }
      bool1 = true;
      this.jdField_q_of_type_Boolean = bool1;
      this.jdField_l_of_type_JavaLangString = paramIntent.getStringExtra("uinname");
      this.jdField_m_of_type_JavaLangString = paramIntent.getStringExtra("uin");
      if (this.jdField_d_of_type_JavaLangString != null) {
        break label725;
      }
      localObject = this.h;
      label428:
      this.jdField_d_of_type_JavaLangString = ((String)localObject);
      this.jdField_p_of_type_Int = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE.ordinal());
      this.jdField_b_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 28835840L);
      this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
      this.jdField_c_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
      if (this.jdField_o_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "Photo+ send pic,cancel presend!");
          }
          this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr.a();
        }
        PhotoUtils.a(this, paramIntent, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_r_of_type_Int, true);
      }
      this.jdField_k_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      if ((this.jdField_q_of_type_Boolean) && (this.jdField_d_of_type_JavaLangString != null))
      {
        localObject = QZoneHelper.a(this.jdField_d_of_type_JavaLangString, this.jdField_m_of_type_JavaLangString);
        if ((localObject == null) || (((BaseBusinessAlbumInfo)localObject).b() == null) || (((BaseBusinessAlbumInfo)localObject).b().equals(""))) {
          break label734;
        }
        this.jdField_n_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject).b();
        this.jdField_o_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject).c();
        paramIntent.putExtra("key_album_id", this.jdField_n_of_type_JavaLangString);
        paramIntent.putExtra("key_album_name", this.jdField_o_of_type_JavaLangString);
      }
      label649:
      this.jdField_t_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false);
      this.u = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_BAR", false);
      if ((this.jdField_t_of_type_Boolean) || (this.u)) {
        break label759;
      }
    }
    label720:
    label725:
    label734:
    label759:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_r_of_type_Boolean = bool1;
      return;
      this.jdField_i_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_NAME");
      this.jdField_j_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_ID");
      break;
      bool1 = false;
      break label388;
      localObject = this.jdField_d_of_type_JavaLangString;
      break label428;
      paramIntent.putExtra("key_album_id", "");
      paramIntent.putExtra("key_album_name", "");
      break label649;
    }
  }
  
  private void b(String paramString)
  {
    if (this.jdField_n_of_type_Boolean)
    {
      AlbumUtil.jdField_c_of_type_Long = System.currentTimeMillis();
      AlbumUtil.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_j_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Gsv.getCount()));
      if (!TextUtils.isEmpty(paramString))
      {
        AlbumUtil.jdField_a_of_type_JavaLangString = paramString;
        HashMap localHashMap = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
        if (localHashMap.containsKey(paramString))
        {
          paramString = (Pair)localHashMap.get(paramString);
          AlbumUtil.jdField_b_of_type_JavaLangString = (String)paramString.first;
          AlbumUtil.jdField_c_of_type_JavaLangString = (String)paramString.second;
          AlbumUtil.a(this, AlbumUtil.jdField_b_of_type_JavaLangString, AlbumUtil.jdField_c_of_type_JavaLangString);
        }
      }
    }
    AlbumUtil.c();
  }
  
  private boolean b()
  {
    return QzoneConfig.a().a("PhotoUpload", "QunAioRememberUpload", 1) != 0;
  }
  
  private void c()
  {
    Resources localResources = getResources();
    int i1 = localResources.getDisplayMetrics().widthPixels;
    this.jdField_o_of_type_Int = localResources.getDimensionPixelSize(2131493054);
    this.jdField_m_of_type_Int = localResources.getDimensionPixelSize(2131493052);
    this.jdField_n_of_type_Int = localResources.getDimensionPixelSize(2131493053);
    this.jdField_a_of_type_Int = ((int)((i1 - this.jdField_o_of_type_Int * 2 - this.jdField_m_of_type_Int * (jdField_l_of_type_Int - 1)) / jdField_l_of_type_Int + 0.5D));
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  private void c(Intent paramIntent)
  {
    this.jdField_n_of_type_JavaLangString = paramIntent.getStringExtra("key_album_id");
    this.jdField_o_of_type_JavaLangString = paramIntent.getStringExtra("key_album_name");
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_t_of_type_Boolean);
    if ((this.jdField_r_of_type_Boolean) && (b()))
    {
      boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("qzone_will_upload_to_qun_album" + this.jdField_m_of_type_JavaLangString, false);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
    }
    String str2 = "";
    String str1 = "";
    int i1;
    if (TextUtils.isEmpty(this.jdField_n_of_type_JavaLangString))
    {
      paramIntent = getString(2131368361);
      i1 = 2131368360;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramIntent);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(i1);
      getIntent().putExtra("key_album_name", str2);
      getIntent().putExtra("key_album_id", str1);
      return;
      paramIntent = "《" + this.jdField_o_of_type_JavaLangString + "》";
      i1 = 2131368359;
      str2 = this.jdField_o_of_type_JavaLangString;
      str1 = this.jdField_n_of_type_JavaLangString;
    }
  }
  
  private void c(String paramString)
  {
    AlbumUtil.a();
    Intent localIntent = getIntent();
    localIntent.putExtra("ALBUM_NAME", this.jdField_i_of_type_JavaLangString);
    localIntent.putExtra("ALBUM_ID", this.jdField_j_of_type_JavaLangString);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    if (this.jdField_j_of_type_Boolean)
    {
      HashMap localHashMap = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
      if (!localHashMap.containsKey(paramString)) {
        localHashMap.put(paramString, new Pair(this.jdField_j_of_type_JavaLangString, this.jdField_i_of_type_JavaLangString));
      }
      b(paramString);
      PhotoUtils.a(this, localIntent, this.jdField_a_of_type_JavaUtilArrayList, 0, this.jdField_d_of_type_Boolean);
      return;
    }
    if (!this.jdField_k_of_type_Boolean)
    {
      localIntent.setClass(this, PhotoPreviewActivity.class);
      paramString = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if ((paramString == null) || (!paramString.endsWith("FriendProfileCardActivity"))) {
        break label260;
      }
      paramString = new Intent();
      paramString.setAction("fragment_on_recieve");
      paramString.putExtras(localIntent.getExtras());
      sendBroadcast(paramString);
      finish();
    }
    for (;;)
    {
      AlbumUtil.a(this, true, true);
      return;
      if (100 == localIntent.getIntExtra("Business_Origin", 0))
      {
        localIntent.setClass(this, PhotoCropForPortraitActivity.class);
        localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
      }
      for (;;)
      {
        AlbumUtil.a(localIntent, this.jdField_j_of_type_JavaLangString, paramString, this.jdField_n_of_type_Boolean);
        break;
        localIntent.setClass(this, PhotoCropActivity.class);
      }
      label260:
      localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      startActivity(localIntent);
      finish();
    }
  }
  
  private void d()
  {
    int i2 = getResources().getDisplayMetrics().widthPixels;
    int i3 = getResources().getDisplayMetrics().heightPixels;
    int i1 = Math.min(i2, i3);
    i2 = Math.max(i2, i3);
    this.jdField_c_of_type_Int = Math.max((int)((i1 - this.jdField_o_of_type_Int * 2 - this.jdField_m_of_type_Int * 3) / 4 + 0.5D), (int)((i2 - this.jdField_o_of_type_Int * 2 - this.jdField_m_of_type_Int * 5) / 6 + 0.5D));
  }
  
  @TargetApi(9)
  private void e()
  {
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297357));
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130838414);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297360));
    if (this.jdField_d_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText("发送");
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297348));
    if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
    Object localObject;
    label407:
    int i1;
    if (this.jdField_e_of_type_AndroidWidgetTextView != null)
    {
      if (this.jdField_i_of_type_JavaLangString != null)
      {
        localObject = this.jdField_i_of_type_JavaLangString;
        setTitle((CharSequence)localObject);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298136));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox = ((QualityCheckBox)findViewById(2131298137));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131300330));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131300329);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131300325);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300326));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)findViewById(2131300331));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(jdField_l_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(this.jdField_m_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(this.jdField_n_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setPadding(this.jdField_o_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingTop(), this.jdField_o_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setMaximumVelocity((int)(2500.0F * getResources().getDisplayMetrics().density));
      this.jdField_a_of_type_Gsv = new gsv(this);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.jdField_a_of_type_Gsv);
      String str = this.jdField_k_of_type_JavaLangString;
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        if (!this.jdField_t_of_type_Boolean) {
          break label681;
        }
        localObject = getString(2131368353);
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      localObject = this.jdField_a_of_type_AndroidViewView;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_p_of_type_Int != MediaFileFilter.MEDIA_FILTER_SHOW_VIDEO.ordinal())) {
        break label710;
      }
      i1 = 8;
      label443:
      ((View)localObject).setVisibility(i1);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setOnCheckedChangeListener(this);
      }
      i();
      if ((this.jdField_q_of_type_Boolean) && (this.jdField_d_of_type_JavaLangString != null))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131299785));
        this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_b_of_type_AndroidViewView.findViewById(2131300327));
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
        c(getIntent());
        GuideDialog.a(this, "PhotoListTroopAlbumGuide", 2130903980, false);
      }
      if (this.jdField_c_of_type_Boolean)
      {
        findViewById(2131300328).setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (QualityCheckBox.a(this.jdField_q_of_type_Int)) {
        break label715;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setEnabled(false);
    }
    label681:
    label710:
    label715:
    while ((this.jdField_r_of_type_Int != 2) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0))
    {
      return;
      if (this.jdField_p_of_type_Int == MediaFileFilter.MEDIA_FILTER_SHOW_VIDEO.ordinal())
      {
        localObject = "视频";
        break;
      }
      localObject = "最近照片";
      break;
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = getString(2131368351);
        break label407;
      }
      localObject = getString(2131368352);
      break label407;
      i1 = 0;
      break label443;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setChecked(true);
  }
  
  private void f()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("ALBUM_ID", this.jdField_j_of_type_JavaLangString);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
    localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_r_of_type_Int);
    localIntent.putExtra("peak.myUin", this.jdField_d_of_type_JavaLangString);
    localIntent.setClass(this, AlbumListActivity.class);
    localIntent.addFlags(603979776);
    startActivityForResult(localIntent, 101);
    AlbumUtil.a(this, true);
  }
  
  private void g()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        h();
      }
      while (!this.jdField_a_of_type_AndroidAppDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131558902);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppDialog.show();
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903413);
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoListActivity", 2, "dialog error");
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.cancel();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  private void i()
  {
    Object localObject1;
    if (this.jdField_k_of_type_JavaLangString != null)
    {
      localObject1 = this.jdField_k_of_type_JavaLangString;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
        break label219;
      }
      bool = true;
      label24:
      Object localObject2 = localObject1;
      if (bool) {
        localObject2 = (String)localObject1 + "(" + this.jdField_a_of_type_JavaUtilArrayList.size() + ")";
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      this.jdField_d_of_type_AndroidWidgetTextView.setEnabled(bool);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(bool);
      if (!bool)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        a(false, false, 2131368350);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label229;
      }
      if (bool)
      {
        if (QualityCheckBox.a(this.jdField_q_of_type_Int)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setEnabled(true);
        }
        localObject1 = this.jdField_a_of_type_AndroidWidgetButton;
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() != 1) || (this.jdField_t_of_type_Boolean)) {
          break label224;
        }
      }
    }
    label219:
    label224:
    for (boolean bool = true;; bool = false)
    {
      ((Button)localObject1).setEnabled(bool);
      return;
      if (this.jdField_t_of_type_Boolean)
      {
        localObject1 = getString(2131368353);
        break;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        localObject1 = getString(2131368351);
        break;
      }
      localObject1 = getString(2131368352);
      break;
      bool = false;
      break label24;
    }
    label229:
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setVisibility(8);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidWidgetCheckBox == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {}
    for (String str = "0X80047F8";; str = "0X80047F9")
    {
      ReportController.a(null, "CliOper", "", "", str, str, 0, 0, this.jdField_d_of_type_JavaLangString, "", "", "");
      return;
    }
  }
  
  private void k()
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    Object localObject;
    if (localIntent.resolveActivity(getPackageManager()) != null) {
      localObject = null;
    }
    try
    {
      File localFile = a();
      localObject = localFile;
    }
    catch (IOException localIOException)
    {
      label31:
      break label31;
    }
    if (localObject != null)
    {
      FileProvider7Helper.setSystemCapture(this, localObject, localIntent);
      startActivityForResult(localIntent, 16);
    }
  }
  
  private void l()
  {
    if (this.jdField_t_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr != null) {
        this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr.a();
      }
      StatisticConstants.b(getIntent(), this.jdField_a_of_type_JavaUtilArrayList.size());
      AIOGalleryUtils.a(this, getIntent(), this.jdField_d_of_type_JavaLangString, this.jdField_m_of_type_JavaLangString, this.jdField_l_of_type_JavaLangString, this.jdField_n_of_type_JavaLangString, this.jdField_o_of_type_JavaLangString, this.jdField_r_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      StatisticConstants.a(getIntent(), this.jdField_a_of_type_JavaUtilArrayList.size());
      StatisticConstants.a(getIntent(), this.jdField_a_of_type_JavaUtilArrayList.size(), this.jdField_r_of_type_Int);
    }
    Intent localIntent = getIntent();
    localIntent.putExtra("is_activity_to_fragment", false);
    if (this.jdField_r_of_type_Int == 2) {
      if (this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr.a();
        this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr.b();
      }
    }
    for (;;)
    {
      PhotoUtils.a(this, localIntent, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_r_of_type_Int, this.jdField_d_of_type_Boolean);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr != null) {
        this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr.a(localIntent);
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
    if (paramInt1 == 101) {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        b(paramIntent);
        if (this.jdField_e_of_type_AndroidWidgetTextView != null)
        {
          if (this.jdField_i_of_type_JavaLangString == null) {
            break label56;
          }
          paramIntent = this.jdField_i_of_type_JavaLangString;
          setTitle(paramIntent);
        }
        onStart();
      }
    }
    label56:
    do
    {
      return;
      if (this.jdField_p_of_type_Int == MediaFileFilter.MEDIA_FILTER_SHOW_VIDEO.ordinal())
      {
        paramIntent = "视频";
        break;
      }
      paramIntent = "最近照片";
      break;
      if ((QLog.isDevelopLevel()) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0)) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[PhotoListActivity] [onActivityResult] selectedPhotoList = " + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
      if ((this.jdField_q_of_type_Boolean) && (paramIntent != null) && (paramInt1 == 100) && (paramInt2 == -1) && (paramInt1 != 100003))
      {
        c(paramIntent);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        return;
      }
      if (paramInt2 == -1) {
        switch (paramInt1)
        {
        }
      }
      while (paramInt1 != 17)
      {
        PhotoUtils.a(this, paramInt1, paramInt2, paramIntent, this.jdField_l_of_type_Boolean, this.jdField_d_of_type_JavaLangString);
        return;
        if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
          break;
        }
        PhotoMagicStickUtils.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(0), this, this.jdField_d_of_type_Boolean, this.jdField_q_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.f);
        overridePendingTransition(2130968627, 2130968628);
        return;
      }
      AlbumUtil.jdField_c_of_type_Long = 0L;
    } while (paramInt2 != 888);
    setResult(888, paramIntent);
    finish();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    switch (paramCompoundButton.getId())
    {
    default: 
      return;
    case 2131298137: 
      a(paramBoolean);
      return;
    }
    if (LocalMultiProcConfig.a(this.jdField_d_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_m_of_type_JavaLangString, -1, this.jdField_d_of_type_JavaLangString) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_s_of_type_Boolean = bool;
      if (this.jdField_s_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      paramCompoundButton = new QQCustomDialog(this, 2131558902);
      paramCompoundButton.setContentView(2130903216);
      paramCompoundButton.setTitle(getString(2131363508));
      paramCompoundButton.setMessage(getString(2131363510));
      paramCompoundButton.setNegativeButton(getString(2131363511), new gsr(this));
      paramCompoundButton.setCanceledOnTouchOutside(false);
      paramCompoundButton.setCancelable(false);
      paramCompoundButton.show();
      QZoneClickReport.a(this.jdField_d_of_type_JavaLangString, "40", "1");
      return;
    }
    this.jdField_t_of_type_Boolean = paramBoolean;
    getIntent().putExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", this.jdField_t_of_type_Boolean);
    i();
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    int i1 = 1;
    int i2 = 0;
    int i3 = paramView.getId();
    boolean bool1;
    if (LocalMultiProcConfig.a(this.jdField_d_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_m_of_type_JavaLangString, -1, this.jdField_d_of_type_JavaLangString) != 0)
    {
      bool1 = true;
      this.jdField_s_of_type_Boolean = bool1;
    }
    switch (i3)
    {
    default: 
    case 2131297348: 
    case 2131297357: 
    case 2131298136: 
    case 2131300330: 
    case 2131297360: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              bool1 = false;
              break;
              f();
              return;
              AlbumUtil.c();
              AlbumUtil.a();
              if (!this.jdField_m_of_type_Boolean)
              {
                finish();
                if (this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr != null) {
                  this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr.a();
                }
                paramView = getIntent();
                i1 = i2;
                if (this.jdField_a_of_type_JavaUtilArrayList != null) {
                  i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
                }
                StatisticConstants.b(paramView, i1);
                return;
              }
              paramView = getIntent();
              String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
              String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
              if (str1 == null)
              {
                QQToast.a(this, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
                return;
              }
              paramView.setClassName(str2, str1);
              paramView.removeExtra("PhotoConst.PHOTO_PATHS");
              paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
              paramView.addFlags(603979776);
              if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
                startActivity(paramView);
              }
              for (;;)
              {
                finish();
                AlbumUtil.a(this, false, false);
                break;
                str2 = paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
                String str3 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
                String str4 = paramView.getStringExtra("PhotoConst.UIN");
                if ("WaterMarkCamera.apk".equals(str2)) {
                  paramView.putExtra("cleartop", true);
                }
                if ("qzone_plugin.apk".equals(str3))
                {
                  QzonePluginProxyActivity.a(paramView, str1);
                  finish();
                }
                else if ("QzoneVideoPlugin.apk".equals(str3))
                {
                  QzoneVideoPluginProxyActivity.a(paramView, str1);
                  paramView.putExtra("cleartop", true);
                  QzoneVideoPluginProxyActivity.a(this, str4, paramView, -1);
                }
                else if ("qqfav.apk".equals(str3))
                {
                  QfavHelper.a(this, str4, paramView, 2);
                }
                else
                {
                  IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
                  localPluginParams.jdField_b_of_type_JavaLangString = str3;
                  localPluginParams.jdField_d_of_type_JavaLangString = str2;
                  localPluginParams.jdField_a_of_type_JavaLangString = str4;
                  localPluginParams.jdField_e_of_type_JavaLangString = str1;
                  localPluginParams.jdField_a_of_type_JavaLangClass = ZebraPluginProxyActivity.class;
                  localPluginParams.jdField_a_of_type_AndroidContentIntent = paramView;
                  localPluginParams.jdField_b_of_type_Int = 2;
                  localPluginParams.jdField_a_of_type_AndroidAppDialog = null;
                  localPluginParams.jdField_c_of_type_Int = 10000;
                  localPluginParams.f = null;
                  IPluginManager.a(this, localPluginParams);
                }
              }
            } while (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0);
            getIntent().removeExtra("param_initTime");
            getIntent().putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
            ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
            paramView = new Intent(BaseApplication.getContext(), PhotoPlusBridgeActivity.class);
            paramView.putExtra("photo_path", (String)this.jdField_a_of_type_JavaUtilArrayList.get(0));
            paramView.putExtra("iswaitforsult", this.jdField_d_of_type_Boolean);
            paramView.putExtra("type", this.jdField_q_of_type_Int);
            paramView.putExtra("uin", this.jdField_d_of_type_JavaLangString);
            paramView.putExtra("nick", this.jdField_e_of_type_JavaLangString);
            paramView.putExtra("headDir", this.f);
            startActivityForResult(paramView, 100003);
            this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
            return;
            AlbumUtil.a();
            paramView = getIntent();
            paramView.putExtra("ALBUM_NAME", this.jdField_i_of_type_JavaLangString);
            paramView.putExtra("ALBUM_ID", this.jdField_j_of_type_JavaLangString);
            paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
            paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
            paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_r_of_type_Int);
            jdField_s_of_type_Int = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s();
            paramView.setClass(this, PhotoPreviewActivity.class);
            paramView.addFlags(603979776);
            startActivity(paramView);
            b((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1));
            finish();
            AlbumUtil.a(this, true, true);
          } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0));
          ReportController.b(null, "CliOper", "0X8004072", this.jdField_d_of_type_JavaLangString, "0X8004072", "0X8004072", 0, this.jdField_a_of_type_JavaUtilArrayList.size(), 0, "", "", "", "");
          return;
          if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
            b((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1));
          }
          AlbumUtil.a();
          if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
            break label960;
          }
        } while (!QLog.isColorLevel());
        QLog.e("PhotoList", 2, "size == 0");
        return;
        if (getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
        {
          paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          for (long l1 = 0L; paramView.hasNext(); l1 = FileUtils.a((String)paramView.next()) + l1) {}
          if (l1 > 5242880L) {}
          while ((FileManagerUtil.a()) && (i1 != 0))
          {
            FMDialogUtil.a(this, 2131362469, 2131362465, new gss(this));
            return;
            i1 = 0;
          }
        }
        l();
      } while ((!b()) || (!this.jdField_r_of_type_Boolean) || (this.jdField_a_of_type_AndroidWidgetCheckBox == null));
      bool1 = this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
      if ((Build.VERSION.SDK_INT >= 9) && (TextUtils.isEmpty(this.jdField_n_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("qzone_will_upload_to_qun_album" + this.jdField_m_of_type_JavaLangString, bool1).apply();
        return;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("qzone_will_upload_to_qun_album" + this.jdField_m_of_type_JavaLangString, bool1).commit();
      return;
    case 2131300326: 
      if (!this.jdField_s_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        paramView = new QQCustomDialog(this, 2131558902);
        paramView.setContentView(2130903216);
        paramView.setTitle(getString(2131363508));
        paramView.setMessage(getString(2131363510));
        paramView.setNegativeButton(getString(2131363511), new gst(this));
        paramView.setCanceledOnTouchOutside(false);
        paramView.setCancelable(false);
        paramView.show();
        QZoneClickReport.a(this.jdField_d_of_type_JavaLangString, "40", "1");
        return;
      }
      if (this.jdField_a_of_type_AndroidWidgetCheckBox != null)
      {
        paramView = this.jdField_a_of_type_AndroidWidgetCheckBox;
        if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label1343;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        paramView.setChecked(bool1);
        j();
        return;
      }
    case 2131299785: 
      label960:
      if (!this.jdField_s_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        paramView = new QQCustomDialog(this, 2131558902);
        paramView.setContentView(2130903216);
        paramView.setTitle(getString(2131363508));
        paramView.setMessage(getString(2131363510));
        paramView.setNegativeButton(getString(2131363511), new gsu(this));
        paramView.setCanceledOnTouchOutside(false);
        paramView.setCancelable(false);
        paramView.show();
        QZoneClickReport.a(this.jdField_d_of_type_JavaLangString, "40", "1");
        return;
      }
      label1343:
      paramView = QZoneHelper.UserInfo.a();
      paramView.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      paramView.jdField_b_of_type_JavaLangString = this.jdField_l_of_type_JavaLangString;
      QZoneHelper.c(this, paramView, this.jdField_m_of_type_JavaLangString, this.jdField_l_of_type_JavaLangString, 100);
      return;
    }
    j();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    a(paramConfiguration);
    c();
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(jdField_l_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Gsv.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (!this.bActivityToFragment) {
      requestWindowFeature(7);
    }
    super.onCreate(paramBundle);
    try
    {
      super.setContentView(2130903979);
      if (!this.bActivityToFragment) {
        getWindow().setFeatureInt(7, 2130903210);
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("share", 0);
      a(null);
      c();
      d();
      paramBundle = getIntent();
      b(paramBundle);
      e();
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + " onCreate(),extra is:" + paramBundle.getExtras());
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + ",hashCode is:" + System.identityHashCode(this));
      }
      return;
    }
    catch (Throwable paramBundle)
    {
      finish();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    AlbumThumbManager.a(this).a();
    if (this.jdField_a_of_type_Gsv != null)
    {
      int i1 = this.jdField_a_of_type_Gsv.getCount();
      AlbumUtil.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_j_of_type_JavaLangString, Integer.valueOf(i1));
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + " onNewIntent() is called,extra is:" + paramIntent.getExtras());
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + "hashCode is:" + System.identityHashCode(this));
    }
    setIntent(paramIntent);
    b(paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_AndroidOsAsyncTask = null;
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    }
    this.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams().width = -2;
    this.jdField_e_of_type_AndroidWidgetTextView.setClickable(true);
    this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(2130837673), null);
  }
  
  protected void onStart()
  {
    super.onStart();
    runOnUiThread(new gsp(this));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoListActivity
 * JD-Core Version:    0.7.0.1
 */