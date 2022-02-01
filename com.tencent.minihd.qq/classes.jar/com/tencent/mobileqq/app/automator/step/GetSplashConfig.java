package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.RedPacketServlet;

public class GetSplashConfig
  extends AsyncStep
{
  protected int a()
  {
    this.a.a.b(this.a.a.a());
    ConfigServlet.c(this.a.a, this.a.a.a());
    ConfigServlet.d(this.a.a, this.a.a.a());
    ConfigServlet.a(this.a.a);
    ConfigServlet.g(this.a.a, this.a.a.a());
    ConfigServlet.e(this.a.a, this.a.a.a());
    ConfigServlet.b(this.a.a, this.a.a.a());
    ConfigServlet.a(this.a.a, this.a.a.a());
    ConfigServlet.f(this.a.a, this.a.a.a());
    ConfigServlet.h(this.a.a, this.a.a.a());
    PortalManager localPortalManager = (PortalManager)this.a.a.getManager(74);
    RedPacketServlet.a(this.a.a, localPortalManager.c());
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSplashConfig
 * JD-Core Version:    0.7.0.1
 */