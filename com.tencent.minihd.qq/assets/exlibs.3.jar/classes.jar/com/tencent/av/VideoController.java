package com.tencent.av;

import android.app.KeyguardManager;
import android.content.Context;
import com.tencent.qav.app.QavAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class VideoController
{
  static volatile VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  Context jdField_a_of_type_AndroidContentContext;
  public QavAppInterface a;
  
  private VideoController()
  {
    this.jdField_a_of_type_ComTencentQavAppQavAppInterface = null;
  }
  
  public static VideoController a()
  {
    if (jdField_a_of_type_ComTencentAvVideoController == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvVideoController == null) {
        jdField_a_of_type_ComTencentAvVideoController = new VideoController();
      }
      return jdField_a_of_type_ComTencentAvVideoController;
    }
    finally {}
  }
  
  public static boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public int a()
  {
    return 255;
  }
  
  public int a(boolean paramBoolean)
  {
    return 255;
  }
  
  public void a(QavAppInterface paramQavAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentQavAppQavAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentQavAppQavAppInterface = paramQavAppInterface;
      return;
    }
    this.jdField_a_of_type_ComTencentQavAppQavAppInterface = paramQavAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramQavAppInterface.a().getApplicationContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.VideoController
 * JD-Core Version:    0.7.0.1
 */