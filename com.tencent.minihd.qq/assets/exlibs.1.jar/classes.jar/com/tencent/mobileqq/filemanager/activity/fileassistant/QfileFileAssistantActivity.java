package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ForwardHandlerActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import cooperation.qlink.QQProxyForQlink;
import cooperation.weiyun.WeiyunHelper;
import cooperation.weiyun.WeiyunRemoteCommand;
import cooperation.weiyun.WeiyunRemoteCommand.OnStateChangeListener;
import imw;
import imx;
import imz;
import ina;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class QfileFileAssistantActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  public static final int b = 4;
  public static String c;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  public View.OnClickListener a;
  View jdField_a_of_type_AndroidViewView;
  FileCategoryAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = null;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  private WeiyunRemoteCommand.OnStateChangeListener jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand$OnStateChangeListener = new ina(this);
  private WeiyunRemoteCommand jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private FMObserver jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new imx(this);
  public boolean f = false;
  private volatile boolean g = false;
  
  static
  {
    jdField_c_of_type_JavaLangString = "FileAssistantActivity<FileAssistant>";
  }
  
  public QfileFileAssistantActivity()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new imw(this);
  }
  
  private void m()
  {
    Object localObject = getString(2131368531);
    getString(2131368532);
    getString(2131370053);
    String str1 = getString(2131362358);
    String str2 = getString(2131362356);
    String str3 = getString(2131362364);
    getString(2131364779);
    String str4 = getString(2131362355);
    a(2130903755, 2130840356, 2, "", 0, false, 0, "video", 1, false, false);
    a(2130903752, 2130839615, 0, (String)localObject, 0, false, 12, "offline", 2, true, false);
    a(2130903770, 2130840356, 1, str4, 0, true, 0, "other", 1, false, false);
    a(2130903753, 2130839651, 0, str3, 0, false, 13, "picture", 2, false, this.app.a().d());
    a(2130903753, 2130839653, 0, str2, 0, false, 15, "other", 3, false, false);
    localObject = (RegisterProxySvcPackHandler)this.app.a(9);
    a(2130903753, 2130839648, 0, str1, 0, false, 14, "music", 4, false, false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter.notifyDataSetChanged();
  }
  
  private void n()
  {
    this.app.a().a("0X800474E", 1);
    QQProxyForQlink.a(this, 2, null);
  }
  
  private void o()
  {
    this.g = false;
    if (this.app.a().c() == true)
    {
      this.app.a().e();
      return;
    }
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      localIntent.putExtra("tab_tab_type", 3);
      startActivityForResult(localIntent, 101);
      return;
    }
    FMToastUtil.a(BaseApplication.getContext().getString(2131365941));
  }
  
  private void p()
  {
    try
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putLong("category", 14L);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("tab_tab_type", 3);
      startActivityForResult(localIntent, 101);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void q()
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 3);
    startActivityForResult(localIntent, 101);
  }
  
  private void r()
  {
    this.jdField_b_of_type_AndroidWidgetTextView = this.centerView;
    setTitle(2131362352);
    d();
  }
  
  private void s()
  {
    RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(35);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a(String.valueOf("100160.100162"));
    JSONObject localJSONObject;
    if ((localAppInfo != null) && (localAppInfo.iNewFlag != null) && (localAppInfo.iNewFlag.get() != 0)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("service_type", 2);
      localJSONObject.put("act_id", 1001);
      localJSONObject.put("obj_id", "");
      localJSONObject.put("pay_amt", 0);
      localRedTouchManager.b(localAppInfo, localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand == null) {
      return;
    }
    int i = this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileCategoryEntity localFileCategoryEntity = (FileCategoryEntity)localIterator.next();
      if (localFileCategoryEntity.H == 16)
      {
        if (i == 4)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_c_of_type_JavaLangString, 2, "AlbumBackup:updateBackupInfo, upload state");
          }
          localFileCategoryEntity.jdField_b_of_type_JavaLangString = getResources().getString(2131370086);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_c_of_type_JavaLangString, 2, "AlbumBackup:updateBackupInfo, other state");
          }
          localFileCategoryEntity.jdField_b_of_type_JavaLangString = null;
        }
      }
      else if (localFileCategoryEntity.H == 13) {
        localFileCategoryEntity.jdField_c_of_type_Boolean = this.app.a().d();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter.notifyDataSetChanged();
  }
  
  private void u()
  {
    this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand = new WeiyunRemoteCommand();
    PluginCommunicationHandler.getInstance().register(this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand);
    WeiyunHelper.a(this.app.getApplication());
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, boolean paramBoolean1, int paramInt5, String paramString2, int paramInt6, boolean paramBoolean2, boolean paramBoolean3)
  {
    FileCategoryEntity localFileCategoryEntity = new FileCategoryEntity();
    localFileCategoryEntity.E = paramInt1;
    localFileCategoryEntity.F = paramInt2;
    localFileCategoryEntity.D = paramInt3;
    localFileCategoryEntity.jdField_a_of_type_JavaLangString = paramString1;
    localFileCategoryEntity.G = paramInt4;
    localFileCategoryEntity.jdField_a_of_type_Boolean = paramBoolean1;
    localFileCategoryEntity.H = paramInt5;
    localFileCategoryEntity.jdField_c_of_type_JavaLangString = paramString2;
    localFileCategoryEntity.I = paramInt6;
    localFileCategoryEntity.jdField_b_of_type_Boolean = paramBoolean2;
    localFileCategoryEntity.jdField_c_of_type_Boolean = paramBoolean3;
    this.jdField_a_of_type_JavaUtilList.add(localFileCategoryEntity);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true))) || (paramInt2 == 4))
    {
      Intent localIntent = new Intent(this, ForwardHandlerActivity.class);
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903757);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getActivity());
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131299521));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = new FileCategoryAdapter(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter);
    r();
    m();
    paramBundle = new FileManagerReporter.fileAssistantReportData();
    paramBundle.jdField_b_of_type_JavaLangString = "file_asst_in";
    paramBundle.a = 11;
    FileManagerReporter.a(this.app.a(), paramBundle);
    this.app.a().addObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    u();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.app.a().deleteObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    WeiyunHelper.b(this.app.getApplication());
    this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand.a(null);
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.g = true;
    this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand.a(null);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    t();
    s();
    this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand.a(this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand$OnStateChangeListener);
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void l()
  {
    this.f = true;
    new Handler().postDelayed(new imz(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */