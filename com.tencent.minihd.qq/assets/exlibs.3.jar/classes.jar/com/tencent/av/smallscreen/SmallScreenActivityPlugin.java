package com.tencent.av.smallscreen;

import byv;
import byw;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qav.app.QavAppInterface;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.session.QavSession;
import com.tencent.qphone.base.util.QLog;

public class SmallScreenActivityPlugin
{
  private static volatile SmallScreenActivityPlugin jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = null;
  static final String jdField_a_of_type_JavaLangString = "SmallScreenActivityPlugin";
  public QavAppInterface a;
  QavBussinessCtrl jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b = true;
  
  private SmallScreenActivityPlugin(QavAppInterface paramQavAppInterface)
  {
    this.jdField_a_of_type_ComTencentQavAppQavAppInterface = paramQavAppInterface;
    this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl = QavBussinessCtrl.a();
  }
  
  public static SmallScreenActivityPlugin a(QavAppInterface paramQavAppInterface)
  {
    if (jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin == null) {
        jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = new SmallScreenActivityPlugin(paramQavAppInterface);
      }
      return jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
    }
    finally {}
  }
  
  public void a()
  {
    if (SmallScreenUtils.f()) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = SmallScreenUtils.c(this.jdField_a_of_type_ComTencentQavAppQavAppInterface.a());
    if ((QLog.isColorLevel()) || (!bool2) || (paramBoolean)) {
      QLog.w("SmallScreenActivityPlugin", 1, "onPauseRender, isQuit[" + paramBoolean + "], isScreenOn[" + bool2 + "], seq[" + paramLong + "]");
    }
    if (!paramBoolean)
    {
      if (!SmallScreenUtils.f()) {
        break label135;
      }
      QavSession localQavSession = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a();
      if (localQavSession != null) {
        if (localQavSession.a != 2) {
          break label130;
        }
      }
    }
    label130:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      ThreadManager.b(new byw(this, bool2, paramBoolean));
      return;
    }
    label135:
    SmallScreenUtils.a(paramLong, this.jdField_a_of_type_ComTencentQavAppQavAppInterface, 2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (SmallScreenUtils.f())
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = false;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (!SmallScreenUtils.f());
  }
  
  public void b()
  {
    if (SmallScreenUtils.f())
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = true;
      ThreadManager.b(new byv(this));
    }
    SmallScreenUtils.a(0L, this.jdField_a_of_type_ComTencentQavAppQavAppInterface, 0);
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenActivityPlugin
 * JD-Core Version:    0.7.0.1
 */