package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileCategoryBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.widget.XListView;
import ijp;
import ijq;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FMLocalFileActivity
  extends BaseFileAssistantActivity
{
  public static String c = "FileAssistantActivity<FileAssistant>";
  public View.OnClickListener a;
  public FileCategoryAdapter a;
  XListView a;
  public List a;
  
  public FMLocalFileActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ijq(this);
  }
  
  private void b(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
      if (paramInt == 7) {
        if (c()) {
          a().aj();
        }
      }
      break;
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label263;
      }
      return;
      localObject1 = new Intent(getApplicationContext(), QfileLocalFileCategoryBrowserActivity.class);
      break;
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        localObject1 = new Intent(getApplicationContext(), LocalFileBrowserActivity.class);
        break;
      }
      FMToastUtil.a(2131362437);
      localObject1 = localObject2;
      break;
      a().ah();
      finish();
      overridePendingTransition(2130968603, 2130968605);
      return;
      a().al();
      continue;
      if ((paramInt == 8) || (paramInt == 8)) {
        if (c()) {
          a().ak();
        } else {
          a().am();
        }
      }
    }
    try
    {
      label263:
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("category", paramInt);
      ((Intent)localObject1).putExtra("bundle", (Bundle)localObject2);
      localObject2 = getIntent();
      boolean bool = ((Intent)localObject2).getBooleanExtra("STRING_SingleSelect", false);
      ((Intent)localObject1).putExtra("localSdCardfile", ((Intent)localObject2).getIntExtra("localSdCardfile", -1));
      if (bool) {
        ((Intent)localObject1).putExtra("STRING_SingleSelect", bool);
      }
      localObject2 = ((Intent)localObject2).getStringArrayExtra("STRING_Show_Within_Suffixs");
      if (localObject2 != null) {
        ((Intent)localObject1).putExtra("STRING_Show_Within_Suffixs", (String[])localObject2);
      }
      startActivityForResult((Intent)localObject1, 100);
      overridePendingTransition(2130968603, 2130968605);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void m()
  {
    this.b = getString(2131362351);
    setTitle(this.b);
  }
  
  private void n()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    String str1 = getString(2131362380);
    String str2 = getString(2131362371);
    String str3 = getString(2131362372);
    String str4 = getString(2131362373);
    String str5 = getString(2131362364);
    String str6 = getString(2131362376);
    String str7 = getString(2131362377);
    String str8 = getString(2131362378);
    String str9 = getString(2131362355);
    Intent localIntent = getIntent();
    boolean bool8;
    boolean bool7;
    boolean bool6;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool1;
    boolean bool5;
    if (localIntent != null)
    {
      bool8 = localIntent.getBooleanExtra("STRING_Show_Music_Category", true);
      bool7 = localIntent.getBooleanExtra("STRING_Show_Video_Category", true);
      bool6 = localIntent.getBooleanExtra("STRING_Show_Apk_Category", true);
      bool2 = localIntent.getBooleanExtra("STRING_Show_Pic_Category", true);
      bool3 = localIntent.getBooleanExtra("STRING_Show_Download_Category", true);
      bool4 = localIntent.getBooleanExtra("STRING_Show_Driver_Category", true);
      bool1 = localIntent.getBooleanExtra("STRING_Show_MyFile_Category", false);
      boolean bool9 = localIntent.getBooleanExtra("STRING_Show_First_Space", true);
      bool5 = bool3;
      bool3 = bool1;
      bool1 = bool9;
    }
    for (;;)
    {
      if (bool4) {
        a(2130903755, 2130840356, 2, null, 0, false, 0, 1);
      }
      if (bool2) {
        a(2130903753, 2130839654, 0, str1, FileCategoryUtil.a(this), true, 10, 2);
      }
      if (bool8) {
        a(2130903753, 2130839652, 0, str2, FileCategoryUtil.b(this), true, 1, 3);
      }
      if (bool7) {
        a(2130903753, 2130839657, 0, str3, FileCategoryUtil.c(this), true, 2, 3);
      }
      if (bool6) {
        a(2130903753, 2130839647, 0, str4, 0, true, 4, 4);
      }
      if (bool3) {
        a(2130903753, 2130839650, 0, str9, 0, false, 20, 2);
      }
      if (bool1) {
        a(2130903747, 2130840356, 1, null, 0, false, 0, 1);
      }
      if (bool5) {
        a(2130903753, 2130839649, 0, str5, 0, false, 6, 2);
      }
      a(2130903753, 2130839655, 0, str6, 0, false, 7, 3);
      if (FileManagerUtil.a(this).containsKey("externalSdCard"))
      {
        a(2130903753, 2130839656, 0, str7, 0, false, 8, 3);
        a(2130903753, 2130839656, 0, str8, 0, false, 11, 4);
      }
      while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter == null)
      {
        return;
        a(2130903753, 2130839656, 0, str7, 0, false, 8, 4);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter.notifyDataSetChanged();
      l();
      return;
      bool1 = true;
      bool3 = false;
      bool5 = true;
      bool2 = true;
      bool6 = true;
      bool7 = true;
      bool8 = true;
      bool4 = true;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    FileCategoryEntity localFileCategoryEntity = new FileCategoryEntity();
    localFileCategoryEntity.E = paramInt1;
    localFileCategoryEntity.F = paramInt2;
    localFileCategoryEntity.D = paramInt3;
    localFileCategoryEntity.jdField_a_of_type_JavaLangString = paramString;
    localFileCategoryEntity.G = paramInt4;
    localFileCategoryEntity.jdField_a_of_type_Boolean = paramBoolean;
    localFileCategoryEntity.H = paramInt5;
    localFileCategoryEntity.I = paramInt6;
    this.jdField_a_of_type_JavaUtilList.add(localFileCategoryEntity);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == 4) || (paramInt2 == 5) || ((paramInt2 == -1) && (paramIntent == null)))
    {
      if (paramInt2 == 5) {
        a().ai();
      }
      return;
    }
    n();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903757);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131299521));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = new FileCategoryAdapter(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter);
    m();
    n();
    Intent localIntent;
    switch (getIntent().getIntExtra("localSdCardfile", -1))
    {
    default: 
      localIntent = getIntent();
      String str = localIntent.getStringExtra("targetUin");
      if ((paramBundle == null) || (!AppConstants.Y.equals(str))) {
        break;
      }
    }
    for (;;)
    {
      k();
      return true;
      d();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      setTitle(2131362351);
      return true;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      setTitle(2131362351);
      break;
      b(localIntent.getIntExtra("category", 0));
    }
  }
  
  public void l()
  {
    new ijp(this).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity
 * JD-Core Version:    0.7.0.1
 */