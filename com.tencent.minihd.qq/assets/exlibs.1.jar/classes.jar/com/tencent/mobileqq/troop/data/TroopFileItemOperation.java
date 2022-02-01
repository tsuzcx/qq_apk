package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.util.UUID;
import kki;
import kkj;
import kkk;
import kkl;
import kkm;
import kkn;
import kko;
import kkp;
import kkq;
import kkr;

public class TroopFileItemOperation
{
  public long a;
  public Activity a;
  public QQAppInterface a;
  
  public TroopFileItemOperation(long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private int a()
  {
    return a(true);
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
    }
    return TroopFileUtils.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private String a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getString(paramInt);
  }
  
  private String a(int paramInt, Object... paramVarArgs)
  {
    return String.format(a(paramInt), paramVarArgs);
  }
  
  protected TroopFileInfo a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    paramView = paramView.getTag();
    if ((paramView == null) || (!(paramView instanceof TroopFileEntry))) {
      return null;
    }
    return ((TroopFileEntry)paramView).a();
  }
  
  public void a(TroopFileInfo paramTroopFileInfo)
  {
    paramTroopFileInfo = new kkn(this, paramTroopFileInfo);
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, a(2131363347), a(2131363358), 2131365736, 2131365737, paramTroopFileInfo, paramTroopFileInfo).show();
  }
  
  public void a(TroopFileStatusInfo paramTroopFileStatusInfo, String paramString, long paramLong)
  {
    FileInfo localFileInfo = new FileInfo();
    if (!FileUtil.a(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) {
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).b();
    }
    switch (paramTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    default: 
      String str = "";
      if (!TextUtils.isEmpty(paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString)) {
        str = paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString;
      }
      TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
      localFileInfo.d(str);
      localFileInfo.e(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
      localFileInfo.a(paramTroopFileStatusInfo.jdField_b_of_type_Long);
      TroopFileStatusInfo localTroopFileStatusInfo = new TroopFileStatusInfo();
      localTroopFileStatusInfo.jdField_e_of_type_JavaLangString = str;
      localTroopFileStatusInfo.jdField_a_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString;
      localTroopFileStatusInfo.jdField_b_of_type_Long = paramTroopFileStatusInfo.jdField_b_of_type_Long;
      localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID = paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID;
      localTroopFileStatusInfo.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localTroopFileStatusInfo.jdField_e_of_type_Int = paramTroopFileStatusInfo.jdField_e_of_type_Int;
      localTroopFileStatusInfo.d = paramTroopFileStatusInfo.d;
      localTroopFileStatusInfo.jdField_b_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_b_of_type_JavaLangString;
      localTroopFileStatusInfo.c = paramTroopFileStatusInfo.c;
      localTroopFileStatusInfo.jdField_b_of_type_Int = paramTroopFileStatusInfo.jdField_b_of_type_Int;
      paramTroopFileStatusInfo = FileManagerUtil.a(localTroopFileStatusInfo);
      paramTroopFileStatusInfo.selfUin = paramString;
      paramTroopFileStatusInfo.lastTime = paramLong;
      paramTroopFileStatusInfo.bSend = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(paramTroopFileStatusInfo.selfUin);
      paramString = new ForwardFileInfo();
      paramString.b(paramTroopFileStatusInfo.nSessionId);
      paramString.d(4);
      paramString.b(10006);
      paramString.a(localFileInfo.d());
      paramString.d(localFileInfo.e());
      paramString.d(localFileInfo.a());
      paramString.a(this.jdField_a_of_type_Long);
      paramTroopFileStatusInfo = this.jdField_a_of_type_AndroidAppActivity;
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof BasePluginActivity)) {
        paramTroopFileStatusInfo = ((BasePluginActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity();
      }
      paramTroopFileStatusInfo = new Intent(paramTroopFileStatusInfo, TroopFileDetailBrowserActivity.class);
      paramTroopFileStatusInfo.putExtra("fileinfo", paramString);
      paramTroopFileStatusInfo.putExtra("removemementity", true);
      paramTroopFileStatusInfo.putExtra("forward_from_troop_file", true);
      paramTroopFileStatusInfo.putExtra("not_forward", true);
      paramTroopFileStatusInfo.putExtra("last_time", paramLong);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramTroopFileStatusInfo, 102);
      return;
    }
    paramString = "";
    int i = paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString.lastIndexOf("/") + 1;
    if (i < paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString.length()) {
      paramString = paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString.substring(i, paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString.length() - 1);
    }
    paramTroopFileStatusInfo = a(2131363371, new Object[] { TroopFileUtils.a(paramString) });
    TroopFileError.a(this.jdField_a_of_type_AndroidAppActivity, paramTroopFileStatusInfo);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (i == 1)
    {
      paramString1 = new kkl(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt);
      paramString2 = a(2131363355, new Object[] { TroopFileUtils.a(paramString2), TroopFileUtils.a(paramLong) });
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, a(2131363346), paramString2, 2131365736, 2131363312, paramString1, paramString1).show();
      return;
    }
    localTroopFileTransferManager.a(paramString1, paramString2, paramLong, paramInt);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    Object localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (i == 1)
    {
      localObject = new kki(this, (TroopFileTransferManager)localObject, paramString, paramBoolean);
      File localFile = new File(paramString);
      paramString = a(2131363352, new Object[] { TroopFileUtils.a(FileManagerUtil.a(paramString)), TroopFileUtils.a(localFile.length()) });
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, a(2131363346), paramString, 2131365736, 2131363313, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject).show();
      return;
    }
    ((TroopFileTransferManager)localObject).a(paramString, paramBoolean);
  }
  
  public void a(UUID paramUUID)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (i == 1)
    {
      kkk localkkk = new kkk(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.a(paramUUID);
      if (paramUUID != null) {}
      for (paramUUID = a(2131363353, new Object[] { TroopFileUtils.a(paramUUID.jdField_e_of_type_JavaLangString), TroopFileUtils.a(paramUUID.jdField_b_of_type_Long) });; paramUUID = a(2131363354))
      {
        DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, a(2131363346), paramUUID, 2131365736, 2131363314, localkkk, localkkk).show();
        return;
      }
    }
    localTroopFileTransferManager.c(paramUUID);
  }
  
  public void b(TroopFileInfo paramTroopFileInfo)
  {
    paramTroopFileInfo = new kko(this, paramTroopFileInfo);
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, a(2131363348), a(2131363359), 2131365736, 2131365737, paramTroopFileInfo, paramTroopFileInfo).show();
  }
  
  public void b(UUID paramUUID)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (i == 1)
    {
      kkm localkkm = new kkm(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.a(paramUUID);
      if (paramUUID != null) {}
      for (paramUUID = a(2131363356, new Object[] { TroopFileUtils.a(paramUUID.jdField_e_of_type_JavaLangString), TroopFileUtils.a(paramUUID.jdField_b_of_type_Long) });; paramUUID = a(2131363357))
      {
        DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, a(2131363346), paramUUID, 2131365736, 2131363315, localkkm, localkkm).show();
        return;
      }
    }
    localTroopFileTransferManager.f(paramUUID);
  }
  
  public void c(TroopFileInfo paramTroopFileInfo)
  {
    int i = a(false);
    kkp localkkp = new kkp(this, paramTroopFileInfo);
    if (i == 1) {}
    for (paramTroopFileInfo = a(2131363353, new Object[] { TroopFileUtils.a(paramTroopFileInfo.c), paramTroopFileInfo.a() });; paramTroopFileInfo = a(2131363360, new Object[] { TroopFileUtils.a(paramTroopFileInfo.c) }))
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, a(2131363349), paramTroopFileInfo, 2131365736, 2131363314, localkkp, localkkp).show();
      return;
    }
  }
  
  public void d(TroopFileInfo paramTroopFileInfo)
  {
    int i = a(false);
    kkq localkkq = new kkq(this, paramTroopFileInfo);
    if (i == 1) {}
    for (paramTroopFileInfo = a(2131363356, new Object[] { TroopFileUtils.a(paramTroopFileInfo.c), paramTroopFileInfo.a() });; paramTroopFileInfo = a(2131363361, new Object[] { TroopFileUtils.a(paramTroopFileInfo.c) }))
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, a(2131363350), paramTroopFileInfo, 2131365736, 2131363315, localkkq, localkkq).show();
      return;
    }
  }
  
  public void e(TroopFileInfo paramTroopFileInfo)
  {
    boolean bool = false;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null);
    String[] arrayOfString = this.jdField_a_of_type_AndroidAppActivity.getResources().getStringArray(2131230799);
    if (paramTroopFileInfo.g == 11)
    {
      localActionSheet.a(arrayOfString[0], 1);
      bool = true;
    }
    if ((TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramTroopFileInfo.c()))) {
      localActionSheet.a(arrayOfString[1], 1);
    }
    localActionSheet.a(new kkr(this, bool, paramTroopFileInfo, localActionSheet));
    localActionSheet.e(2131365736);
    localActionSheet.show();
  }
  
  public void f(TroopFileInfo paramTroopFileInfo)
  {
    TroopFileStatusInfo localTroopFileStatusInfo2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(paramTroopFileInfo.jdField_b_of_type_JavaLangString);
    TroopFileStatusInfo localTroopFileStatusInfo1 = localTroopFileStatusInfo2;
    if (localTroopFileStatusInfo2 == null) {
      localTroopFileStatusInfo1 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID.toString(), paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo.c, paramTroopFileInfo.jdField_a_of_type_Long, paramTroopFileInfo.jdField_a_of_type_Int);
    }
    a(localTroopFileStatusInfo1, String.valueOf(paramTroopFileInfo.jdField_b_of_type_Int), paramTroopFileInfo.d);
  }
  
  public void g(TroopFileInfo paramTroopFileInfo)
  {
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131363367);
    String str2 = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131363383), new Object[] { TroopFileUtils.a(paramTroopFileInfo.c) });
    QQCustomDialog localQQCustomDialog = DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localQQCustomDialog.setTitle(str1).setMessage(str2);
    localQQCustomDialog.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131365737), new kkj(this, paramTroopFileInfo));
    localQQCustomDialog.show();
  }
  
  public void h(TroopFileInfo paramTroopFileInfo)
  {
    if (a() != 0)
    {
      TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(paramTroopFileInfo);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_trans_save", 0, 0, "", this.jdField_a_of_type_Long + "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation
 * JD-Core Version:    0.7.0.1
 */