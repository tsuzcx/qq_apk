package com.tencent.mobileqq.PermissionsDialog;

import android.app.Activity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import dcl;
import dcm;
import dcn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PermissionsDialog
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private PermissionDialogCallback jdField_a_of_type_ComTencentMobileqqPermissionsDialogPermissionDialogCallback;
  
  private String a(String[] paramArrayOfString)
  {
    int j = 0;
    Object localObject1;
    if (paramArrayOfString != null)
    {
      Object localObject2 = new ArrayList();
      int k = paramArrayOfString.length;
      int i = 0;
      while (i < k)
      {
        localObject1 = paramArrayOfString[i];
        if (this.jdField_a_of_type_AndroidAppActivity.checkSelfPermission((String)localObject1) != 0) {
          ((List)localObject2).add(localObject1);
        }
        i += 1;
      }
      if ((((List)localObject2).size() == 1) && (localObject2.toString().equals("android.permission.WRITE_EXTERNAL_STORAGE"))) {
        return this.jdField_a_of_type_AndroidAppActivity.getString(2131370041);
      }
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131370039);
      localObject2 = ((List)localObject2).iterator();
      i = j;
      if (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        paramArrayOfString = (String[])localObject1;
        if (str.equals("android.permission.CAMERA")) {
          paramArrayOfString = (String)localObject1 + this.jdField_a_of_type_AndroidAppActivity.getString(2131370048);
        }
        localObject1 = paramArrayOfString;
        if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
          localObject1 = paramArrayOfString + this.jdField_a_of_type_AndroidAppActivity.getString(2131370042);
        }
        paramArrayOfString = (String[])localObject1;
        if (str.equals("android.permission.RECORD_AUDIO")) {
          paramArrayOfString = (String)localObject1 + this.jdField_a_of_type_AndroidAppActivity.getString(2131370047);
        }
        localObject1 = paramArrayOfString;
        if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
          localObject1 = paramArrayOfString + this.jdField_a_of_type_AndroidAppActivity.getString(2131370046);
        }
        paramArrayOfString = (String[])localObject1;
        if (str.equals("android.permission.WRITE_CALENDAR")) {
          paramArrayOfString = (String)localObject1 + this.jdField_a_of_type_AndroidAppActivity.getString(2131370050);
        }
        localObject1 = paramArrayOfString;
        if (str.equals("android.permission.WRITE_CONTACTS")) {
          localObject1 = paramArrayOfString + this.jdField_a_of_type_AndroidAppActivity.getString(2131370049);
        }
        paramArrayOfString = (String[])localObject1;
        if (str.equals("android.permission.READ_PHONE_STATE")) {
          paramArrayOfString = (String)localObject1 + this.jdField_a_of_type_AndroidAppActivity.getString(2131370043);
        }
        boolean bool1 = str.equals("android.permission.SEND_SMS");
        boolean bool2 = str.equals("android.permission.READ_SMS");
        if ((!(str.equals("android.permission.RECEIVE_SMS") | bool1 | bool2)) || (i != 0)) {
          break label532;
        }
        paramArrayOfString = this.jdField_a_of_type_AndroidAppActivity.getString(2131370045);
        i += 1;
      }
    }
    label532:
    for (;;)
    {
      localObject1 = paramArrayOfString + "，";
      break;
      return (String)localObject1 + this.jdField_a_of_type_AndroidAppActivity.getString(2131370040);
      return null;
    }
  }
  
  public void a(Activity paramActivity, int paramInt, String[] paramArrayOfString, PermissionDialogCallback paramPermissionDialogCallback)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqPermissionsDialogPermissionDialogCallback = paramPermissionDialogCallback;
    if (paramArrayOfString.length > 0)
    {
      paramPermissionDialogCallback = paramArrayOfString[0];
      paramPermissionDialogCallback = new dcl(this);
      paramActivity = DialogUtil.a(paramActivity, 230);
      paramActivity.setTitle(2131370030);
      paramActivity.setMessage(a(paramArrayOfString));
      paramActivity.setNegativeButton(2131370033, paramPermissionDialogCallback);
      paramActivity.setPositiveButton(2131370032, paramPermissionDialogCallback);
      paramActivity.setOnDismissListener(null);
      paramActivity.show();
    }
  }
  
  public void a(Activity paramActivity, PermissionDialogShowMessageCallback paramPermissionDialogShowMessageCallback)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    paramPermissionDialogShowMessageCallback = new dcm(this, paramPermissionDialogShowMessageCallback);
    paramActivity = DialogUtil.a(paramActivity, 230);
    paramActivity.setContentView(2130903217);
    paramActivity.setTitle(2131370037);
    paramActivity.setMessage(2131370038);
    paramActivity.setNegativeButton(2131370036, paramPermissionDialogShowMessageCallback);
    paramActivity.setOnDismissListener(null);
    paramActivity.setCanceledOnTouchOutside(false);
    paramActivity.setCancelable(true);
    paramActivity.show();
  }
  
  public void a(Activity paramActivity, String[] paramArrayOfString, PermissionDialogCallback paramPermissionDialogCallback)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqPermissionsDialogPermissionDialogCallback = paramPermissionDialogCallback;
    paramPermissionDialogCallback = new dcn(this);
    paramActivity = DialogUtil.a(paramActivity, 230);
    paramActivity.setTitle(2131370031);
    paramActivity.setMessage(a(paramArrayOfString));
    paramActivity.setNegativeButton(2131370033, paramPermissionDialogCallback);
    paramActivity.setPositiveButton(2131370032, paramPermissionDialogCallback);
    paramActivity.setOnDismissListener(null);
    paramActivity.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.PermissionsDialog.PermissionsDialog
 * JD-Core Version:    0.7.0.1
 */