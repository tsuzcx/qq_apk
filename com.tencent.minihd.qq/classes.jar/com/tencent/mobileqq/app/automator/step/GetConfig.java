package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.PluginConfigProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import cooperation.plugin.IPluginManager;
import hrg;
import protocol.KQQConfig.GetResourceReqInfo;

public class GetConfig
  extends AsyncStep
{
  private ResourcePluginListener a;
  
  protected int a()
  {
    Object localObject = new PluginConfigProxy();
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.a().a((PluginConfigProxy)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.a().a((PluginConfigProxy)localObject);
    ((PluginConfigProxy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a);
    ((IPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getManager(26)).a();
    ((EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getManager(73)).b();
    localObject = (ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.a(4);
    ((ConfigHandler)localObject).a(null, new GetResourceReqInfo[] { ((ConfigHandler)localObject).d(), ((ConfigHandler)localObject).e(), ((ConfigHandler)localObject).g(), ((ConfigHandler)localObject).b(), ((ConfigHandler)localObject).f(), ((ConfigHandler)localObject).c() });
    return 2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new hrg(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.a(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.b(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetConfig
 * JD-Core Version:    0.7.0.1
 */