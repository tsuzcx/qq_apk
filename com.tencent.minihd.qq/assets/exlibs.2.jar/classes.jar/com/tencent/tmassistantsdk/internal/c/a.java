package com.tencent.tmassistantsdk.internal.c;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.a.b;
import com.tencent.tmassistantbase.a.f;
import com.tencent.tmassistantbase.a.k;
import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements c
{
  protected d a = null;
  protected int b = 0;
  protected final List c = new ArrayList();
  
  public void a()
  {
    this.a = null;
    this.c.clear();
  }
  
  public void a(JceStruct paramJceStruct)
  {
    try
    {
      k.c("BaseReportManager", "enter:" + paramJceStruct);
      if (paramJceStruct != null)
      {
        paramJceStruct = com.tencent.tmassistant.common.a.c(paramJceStruct);
        e().a(paramJceStruct);
      }
      k.c("BaseReportManager", "exit");
      return;
    }
    finally {}
  }
  
  public void a(d paramd, boolean paramBoolean)
  {
    k.c("BaseReportManager", "enter");
    k.c("BaseReportManager", "result:" + paramBoolean);
    if ((!paramBoolean) && (this.c != null) && (this.c.size() > 0))
    {
      k.c("BaseReportManager", "reback DB!");
      e().a(this.c);
    }
    this.a = null;
    this.c.clear();
    if ((paramBoolean) && (g()) && (this.b < 5))
    {
      k.c("BaseReportManager", "reportlog go on,result:" + paramBoolean + " count:" + this.b);
      c();
      this.b += 1;
    }
    k.c("BaseReportManager", "exit");
  }
  
  public void b()
  {
    if (this.a != null)
    {
      this.a.a();
      this.a = null;
    }
  }
  
  public void c()
  {
    try
    {
      k.c("BaseReportManager", "enter");
      if (!f.a().j())
      {
        k.c("BaseReportManager", "Not WiFi");
        k.c("BaseReportManager", "exit");
      }
      for (;;)
      {
        return;
        if (this.a == null) {
          break;
        }
        k.c("BaseReportManager", "reportRequst is sending out");
        k.c("BaseReportManager", "exit");
      }
      this.a = new d();
    }
    finally {}
    this.a.a(this);
    k.c("BaseReportManager", " request:" + this.a + " reportManager:" + getClass().getName());
    b localb = e().a(1000);
    k.c("BaseReportManager", "readLogDataAndSendToServer,wrappterCount:" + localb.b.size());
    if (localb != null) {
      if (localb.b.size() <= 0) {
        break label248;
      }
    }
    for (;;)
    {
      if (!bool) {
        this.a = null;
      }
      k.c("BaseReportManager", "exit");
      break;
      this.c.addAll(localb.b);
      boolean bool = this.a.a(f(), localb);
      e().b(localb.a);
      continue;
      label248:
      bool = false;
    }
  }
  
  public void d()
  {
    this.b = 0;
  }
  
  protected abstract com.tencent.tmassistant.common.a.a e();
  
  protected abstract byte f();
  
  protected abstract boolean g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.c.a
 * JD-Core Version:    0.7.0.1
 */