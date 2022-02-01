package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.app.QQAppInterface;

public abstract class BaseProxy
{
  protected QQAppInterface a;
  public ProxyManager a;
  
  public BaseProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager = paramProxyManager;
  }
  
  public abstract void a();
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.BaseProxy
 * JD-Core Version:    0.7.0.1
 */