package com.tencent.mobileqq.startup.step;

import android.annotation.TargetApi;
import jwc;
import mqq.app.AppActivity;
import mqq.app.permission.PermissionManager;

@TargetApi(23)
public class SetPermission
  extends Step
{
  private static final String jdField_a_of_type_JavaLangString = "sp_permission";
  private static final String jdField_c_of_type_JavaLangString = "permission_first_show";
  private AppActivity jdField_a_of_type_MqqAppAppActivity;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean jdField_c_of_type_Boolean;
  
  private void a()
  {
    this.a.permissionManager.request(new jwc(this));
  }
  
  protected boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetPermission
 * JD-Core Version:    0.7.0.1
 */